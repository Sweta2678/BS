package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.ihg.brandstandards.bsadmin.model.FileAttachment;
import com.ihg.brandstandards.bsadmin.model.NewUserBean;
import com.ihg.brandstandards.util.MailUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class SupportPortlet extends MVCPortlet
{
    private static final String RECEIVER_EMAILS = "receiverEmails";
    private String to = ""; //GTBrandStandards@ihg.com
    private static final Log LOG = LogFactoryUtil.getLog(SupportPortlet.class);

    public void doView(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException
    {
        String pageName = "/html/support/supportForm.jsp";
        PortletPreferences portletPreferences = request.getPreferences();
        ConfigBean config = configValues(portletPreferences);
        to = config.getReceiverEmails();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        request.setAttribute(MailUtil.FULL_NAME, themeDisplay.getUser().getFullName());
        request.setAttribute(MailUtil.SCREEN_NAME, themeDisplay.getUser().getScreenName());
        request.setAttribute(MailUtil.EMAIL, themeDisplay.getUser().getEmailAddress());
        request.setAttribute(MailUtil.ROLES_MAP, MailUtil.getRoles());
        final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(pageName);
        reqDisp.include(request, renderResponse);
    }

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
        String json = "";
        boolean error = false;
        resourceResponse.setContentType("text/html");
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PrintWriter out = null;
        FileAttachment fileAttachment = null;
        try
        {
            out = resourceResponse.getWriter();
            String requestType = "";
            String message = "";
            String fileName = "";
            File file = null;
            NewUserBean newUserBean = null;
            String UserName = themeDisplay.getUser().getFullName();
            String ScreenName = themeDisplay.getUser().getScreenName();
            String EmailAdd = themeDisplay.getUser().getEmailAddress();

            if (!Validator.isNotNull(to))
            {
                to = "GTBrandStandards@ihg.com";
            }

            HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
            final boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(request));
            UploadPortletRequest uploadRequest = null;
            if (isMultipart)
            {
                uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
            }

            requestType = ParamUtil.getString(uploadRequest, "request_type");
            //new user add request
            if (requestType.equals("user_request"))
            {
                newUserBean = new NewUserBean();
                if (Validator.isNotNull(ParamUtil.getString(uploadRequest, "user_domain_id")))
                    newUserBean.setUserMerlinId(ParamUtil.getString(uploadRequest, "user_domain_id"));

                if (Validator.isNotNull(ParamUtil.getString(uploadRequest, "user_full_name")))
                    newUserBean.setUserFullName(ParamUtil.getString(uploadRequest, "user_full_name"));

                if (Validator.isNotNull(ParamUtil.getString(uploadRequest, "user_region")))
                    newUserBean.setUserRegion(ParamUtil.getString(uploadRequest, "user_region"));

                if (Validator.isNotNull(ParamUtil.getString(uploadRequest, "email")))
                    newUserBean.setEmailAddress(ParamUtil.getString(uploadRequest, "email"));

                if (Validator.isNotNull(uploadRequest.getParameterValues("select_roles")))
                    newUserBean.setUserRoles(uploadRequest.getParameterValues("select_roles"));
            }
            else
            //change request
            {
                message = ParamUtil.getString(uploadRequest, "mail_textarea");

                file = uploadRequest.getFile("file");
                fileName = uploadRequest.getFileName("file");
                if (Validator.isNotNull(fileName))
                {
                    fileAttachment = new FileAttachment(file.getPath());
                    fileAttachment.setRealName(fileName);
                }
            }
            MailUtil.sendEmailToSupportTeam(UserName, ScreenName, to, EmailAdd, message, fileAttachment, newUserBean, requestType);

        }
        catch (Exception e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception -:" + e.getMessage() + "\"}";
            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        if (!error)
        {
            json = "{" + "\"response\": \"Success\"," + "\"message\": \"Mail sent successfully.\"}";
            out.print(json);
            out.flush();
            out.close();
        }

    }

    /**
     * This method handles the doEdit.
     * 
     * @param renderRequest the render request.
     * @param renderResponse the render response.
     */
    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
    {
        try
        {
            PortletPreferences portletPreferences = renderRequest.getPreferences();
            PortletContext pageContext = getPortletContext();

            pageContext.setAttribute(RECEIVER_EMAILS, portletPreferences.getValue(RECEIVER_EMAILS, ""));
            PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(editTemplate);
            rd.include(renderRequest, renderResponse);
        }
        catch (Exception e)
        {
            LOG.debug(e.getMessage());
        }
    }

    /**
     * This method handles the feedBackConfig.
     * 
     * @param actionRequest the action request.
     * @param actionResponse the action response.
     */
    @ProcessAction(name = "submitSupportConfig")
    public void submitTeamspaceConfig(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        try
        {
            PortletPreferences portletPreferences = actionRequest.getPreferences();

            if (actionRequest.getParameter(RECEIVER_EMAILS) != null)
            {
                portletPreferences.setValue(RECEIVER_EMAILS, actionRequest.getParameter(RECEIVER_EMAILS));
            }
            portletPreferences.store();

            actionResponse.setPortletMode(PortletMode.VIEW);
        }
        catch (Exception e)
        {
            LOG.debug(e.getMessage());
        }
    }

    @ProcessAction(name = "Cancel")
    public void Cancel(final ActionRequest actionRequest, final ActionResponse actionResponse) throws IOException,
            PortletException
    {
        actionResponse.setPortletMode(PortletMode.VIEW);
    }

    /**
     * This method retrieves the value from preferences and set the values to config bean.
     * 
     * @param portletPreferences : the portlet preferences.
     * @return config bean.
     */

    public static ConfigBean configValues(PortletPreferences portletPreferences)
    {
        ConfigBean configBean = new ConfigBean();

        LOG.debug("preference map " + portletPreferences.getMap());

        String receiverEmails = portletPreferences.getValue(RECEIVER_EMAILS, "");
        configBean.setReceiverEmails(receiverEmails);
        return configBean;
    }

}

class ConfigBean
{
    private String receiverEmails;

    public String getReceiverEmails()
    {
        return receiverEmails;
    }

    public void setReceiverEmails(String receiverEmails)
    {
        this.receiverEmails = receiverEmails;
    }
}