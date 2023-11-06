package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;
import com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil;
import com.ihg.brandstandards.service.AttributeRequestService;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class AttributeUpdateRequestPortlet extends MVCPortlet
{

    private static final Log LOG = LogFactoryUtil.getLog(AttributeUpdateRequestPortlet.class);
    private AttributeRequestService attributeRequestService = null;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        long requestId = ParamUtil.get(renderRequest, "requestId", 0l);
        AttributeRequestService attrRequest = getAttributeRequestObject();
        HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        HttpSession session = request.getSession();
        
        if (Validator.isNotNull(renderRequest.getParameter("deleteRequest")))
        {
            if (requestId != 0l)
            {
            	attrRequest.deleteAttributeRequest(renderRequest, requestId);
            }
        }
        else if (Validator.isNotNull(renderRequest.getParameter("rejectRequest")))
        {
            if (requestId != 0l)
            {
            	attrRequest.rejectAttributeRequest(renderRequest, requestId);
            }
        }
        else if (Validator.isNotNull(renderRequest.getParameter("approveRequest")))
        {
            if (requestId != 0l)
            {
            	attrRequest.approveAttributeRequest(renderRequest, requestId);
            }
        }
        else if (Validator.isNotNull(renderRequest.getParameter("executeUpdateAttributeRequest")))
        {
            if (requestId != 0l)
            {
            	attrRequest.executeUpdateAttributeRequest(renderRequest, requestId);
            }
        }

        List<SpreadSheetAttributeUpdate> updateRequests = new ArrayList<SpreadSheetAttributeUpdate>();
        try
        {
            //check for super attribute admin role
        	renderRequest.setAttribute("attributeAdmin",attrRequest.hasUserSuperRole(renderRequest));
        	updateRequests = SpreadSheetAttributeUpdateLocalServiceUtil.getSpreadSheetAttributeUpdates(
                    BSAdminConstants.START_POS, BSAdminConstants.END_POS);
            attrRequest.setUpdateAttributeRequests(renderRequest, renderResponse, updateRequests);
            String region = BrandStandardsUtil.getUserRegionFromUserRole(user.getRoles());
            
            if (Validator.isNotNull(region))
            {
                renderRequest.setAttribute("region", region);
            }
            if (UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), BSAdminConstants.SUPER_ADMIN_ROLE,
                    themeDisplay.getUserId(), false))
            {
                renderRequest.setAttribute("region", BSAdminConstants.ACCESS_TO_ALL);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("User's region :"+renderRequest.getAttribute("region"));
            }
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        renderRequest.setAttribute("updateRequests", updateRequests);
        renderRequest.setAttribute("reportInProgress", BSAdminConstants.REPORT_IN_PROGRESS);
        if (Validator.isNotNull(renderRequest.getParameter("stdNotExist")))
        {
            renderRequest.setAttribute("standardNotExistMsg", renderRequest.getParameter("stdNotExist"));
        } else if (Validator.isNotNull(renderRequest.getParameter("requestProcessed")))
        {
            renderRequest.setAttribute("requestProcessed", renderRequest.getParameter("requestProcessed"));
        } else if (Validator.isNotNull(renderRequest.getParameter("wrongExcelsheet")))
        {
            renderRequest.setAttribute("wrongExcelsheet", renderRequest.getParameter("wrongExcelsheet"));
        } else if (Validator.isNotNull(renderRequest.getParameter("noAccess"))) {
        	renderRequest.setAttribute("noAccess", renderRequest.getParameter("noAccess"));
        } else if (Validator.isNotNull(session.getAttribute("diffReport"))) {
        	renderRequest.setAttribute("largeRequest", StringPool.BLANK+session.getAttribute("diffReport"));
        	session.removeAttribute("diffReport");
        }
        
        super.doView(renderRequest, renderResponse);
    }

    /**
     * 
     * @param actionRequest ActionRequest object
     * @param actionResponse ActionResponse object
     */
    public void importSpreadsheet(ActionRequest actionRequest, ActionResponse actionResponse)
    {

        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        Date date = new Date();
        boolean recordProcessed = false;
        String title = ParamUtil.getString(uploadRequest, "requestTitle");
        if (LOG.isDebugEnabled()) {
        	LOG.debug("title :" + title);
        }
        File file = uploadRequest.getFile("uploadFile");
        boolean isValidFile = false;
        AttributeRequestService attrRequest = getAttributeRequestObject();
        if (Validator.isNotNull(file))
        {
            isValidFile = attrRequest.validateAttributeRequest(actionRequest, file);
        }
        if (isValidFile)
        {
            recordProcessed = attrRequest.createOrUpdateAttributeRequest(file, userId, title, date, true, 0l);
            if (recordProcessed)
            {
                actionResponse.setRenderParameter("requestProcessed", "true");
            }
            else
            {
                actionResponse.setRenderParameter("requestProcessed", "false");
            }
        } else if (!isValidFile) {
        	if (Validator.isNotNull(""+actionRequest.getAttribute("stdNotExist"))) {
        	    actionResponse.setRenderParameter("stdNotExist", StringPool.BLANK+actionRequest.getAttribute("stdNotExist"));
        	} else if (Validator.isNotNull(""+actionRequest.getAttribute("templateValue"))) {
        	    actionResponse.setRenderParameter("wrongExcelsheet", "true");
        	} else if (Validator.isNotNull(""+actionRequest.getAttribute("noRegion"))) {
        	    actionResponse.setRenderParameter("noAccess", ""+actionRequest.getAttribute("noRegion"));
        	} 
        } else
        {
            actionResponse.setRenderParameter("requestProcessed", "false");
        }
        
    }

    /**
     * 
     * @param resourceRequest ResourceRequest object
     * @param resourceResponse ResourceResponse object
     */
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {

        String passStdIds = ParamUtil.getString(resourceRequest, "passStdIds");
        String diffReport = ParamUtil.getString(resourceRequest, "diffReport");
        long attrId = ParamUtil.getLong(resourceRequest, "attrId");
        HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        HttpSession session = request.getSession();
        String stdIds = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        AttributeRequestService attrRequest = getAttributeRequestObject();
        String environment = null;
        try
        {
        	PortletPreferences portletPreferences = resourceRequest.getPreferences();
            environment = portletPreferences.getValue("environment", BSAdminConstants.ENVIRONMENT_CMS);
            List<Long> standardIds = new ArrayList<Long>();
        	if (Validator.isNotNull(passStdIds))
            {
        		 resourceResponse.setContentType(ContentTypes.APPLICATION_TEXT);
                 resourceResponse.setCharacterEncoding("UTF-8");
        		stdIds = ParamUtil.getString(resourceRequest, "stdIds");
                if (Validator.isNotNull(stdIds))
                {
                	attrRequest.getStandardIds(stdIds.trim().split("\\s+"), standardIds);
                }
                if (standardIds.size() > BSAdminConstants.SMALL_REQUEST_RECORDS)
                {
                	String message = null;
                	if (attrRequest.addRequestToJobQueue(standardIds, user, null, "ExportReport", 
                			user.getEmailAddress(), ParamUtil.getString(resourceRequest, "standard_region"), environment, 
                			ParamUtil.getString(resourceRequest, "standard_brand"))){
                		message = BSAdminConstants.REPORT_IN_PROGRESS;
                	} else {
                		resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "404");
                		message = BSAdminConstants.ERROR_OCCURED;
                	}
                	
                	 try
                     {
                         resourceResponse.getWriter().write(message);
                     }
                     catch (IOException e)
                     {
                         LOG.error(e.getMessage(), e);
                     }
                } else {
                	session.setAttribute(themeDisplay.getUserId() + "_stdId", stdIds);
                    session.setAttribute(themeDisplay.getUserId() + "_template",
                            ParamUtil.getString(resourceRequest, "standard_brand"));
                    session.setAttribute(themeDisplay.getUserId()+"_regionVal", ParamUtil.getString(resourceRequest, "standard_region"));
                }
            }
            else if (Validator.isNotNull(diffReport) && attrId != 0l)
            {

                SpreadSheetAttributeUpdate attributeUpdate = SpreadSheetAttributeUpdateLocalServiceUtil
                        .getSpreadSheetAttributeUpdate(attrId);
                if (Validator.isNotNull(attributeUpdate)
                /*&& 
                (BSAdminConstants.READY_FOR_REVIEW.equalsIgnoreCase(attributeUpdate.getStatus()) || 
                		BSAdminConstants.UPDATED_FOR_REVIEW.equalsIgnoreCase(attributeUpdate.getStatus()) ) */)
                {
                	attrRequest.updateAttributeRequestObject(attributeUpdate, resourceRequest, resourceResponse, user, environment);
                	if (Validator.isNotNull(""+resourceRequest.getAttribute("largeRequest"))) {
                            session.setAttribute("diffReport", ""+resourceRequest.getAttribute("largeRequest"));
                            PortalUtil.getHttpServletResponse(resourceResponse).sendRedirect("/web/brand-standards/attribute-update");
                	}
                }
                else
                {
                    
                    resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "404");
                    try
                    {
                        resourceResponse.getWriter().write(BSAdminConstants.ERROR_OCCURED);
                    }
                    catch (IOException e)
                    {
                        LOG.error(e.getMessage(), e);
                    }
                }

            }
            else
            {

                stdIds = StringPool.BLANK + session.getAttribute(themeDisplay.getUserId() + "_stdId");
                session.removeAttribute(themeDisplay.getUserId() + "_stdId");
                String template = StringPool.BLANK + session.getAttribute(themeDisplay.getUserId() + "_template");
                String region = StringPool.BLANK + session.getAttribute(themeDisplay.getUserId() + "_regionVal");
                session.removeAttribute(themeDisplay.getUserId() + "_template");
                session.removeAttribute(themeDisplay.getUserId() + "_regionVal");
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Template :" + template);
                    LOG.debug("region :" + region);
                }
                if (Validator.isNotNull(stdIds))
                {
                	attrRequest.getStandardIds(stdIds.trim().split("\\s+"), standardIds);
                }
                if (standardIds.size() <= BSAdminConstants.SMALL_REQUEST_RECORDS && Validator.isNotNull(template))
                {
                	attrRequest.exportStandardAttributeDetails(standardIds, template, resourceResponse, region);
                } 
            }
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        } catch (IOException e)
		{
        	LOG.error(e.getMessage(), e);
		}
    }

    /**
     * 
     * @param actionRequest ActionRequest object
     * @param actionResponse ActionResponse object
     */
    public void updateAttribute(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        Date date = new Date();
        String title = ParamUtil.getString(uploadRequest, "standard_name");
        long requestId = ParamUtil.getLong(uploadRequest, "attr_id");
        File file = uploadRequest.getFile("standard_file");
        boolean isValidFile = true;
        if (Validator.isNotNull(file) && file.exists())
        {
            isValidFile = getAttributeRequestObject().validateAttributeRequest(actionRequest, file);
        }
        else
        {
            file = null;
        }
        if (Validator.isNotNull(requestId) && isValidFile)
        {

            getAttributeRequestObject().createOrUpdateAttributeRequest(file, userId, title, date, false, requestId);
        } else if (!isValidFile) {
            if (Validator.isNotNull(StringPool.BLANK+actionRequest.getAttribute("stdNotExist"))) {
                actionResponse.setRenderParameter("stdNotExist", StringPool.BLANK+actionRequest.getAttribute("stdNotExist"));
            } else if (Validator.isNotNull(StringPool.BLANK+actionRequest.getAttribute("noRegion"))) {
                actionResponse.setRenderParameter("noAccess", StringPool.BLANK+actionRequest.getAttribute("noRegion"));
            } 
            
        }
    }

    /**
     * 
     * @return AttributeRequestService This method will return an object of AttributeRequestService
     */
    private AttributeRequestService getAttributeRequestObject()
    {
        if (this.attributeRequestService == null)
        {
            this.attributeRequestService = new AttributeRequestService();
        }
        return attributeRequestService;
    }

    @Override
    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        PortletPreferences preferences = renderRequest.getPreferences();
        renderRequest.setAttribute("contentEnvironmentVal", preferences.getValue("environment", StringPool.BLANK));
        super.doEdit(renderRequest, renderResponse);
    }

    /**
     * @param actionRequest This is for actionRequest
     * @param actionResponse This is for actionResponse
     */
    public void setCustomPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        String environment = actionRequest.getParameter("contentEnvironment");

        PortletPreferences preferences = actionRequest.getPreferences();
        try
        {
            preferences.setValue("environment", environment);
            preferences.store();
        }
        catch (ReadOnlyException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (ValidatorException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }
}
