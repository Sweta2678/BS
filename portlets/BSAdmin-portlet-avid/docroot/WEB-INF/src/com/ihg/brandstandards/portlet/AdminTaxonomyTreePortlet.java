package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.db.model.BrandTaxonomy;
import com.ihg.brandstandards.db.model.BrandTaxonomyTranslate;
import com.ihg.brandstandards.db.model.Taxonomy;
import com.ihg.brandstandards.db.model.TaxonomyTranslate;
import com.ihg.brandstandards.db.model.TreeXML;
import com.ihg.brandstandards.db.service.BrandTaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.util.ActionUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

public class AdminTaxonomyTreePortlet extends GenericPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(AdminTaxonomyTreePortlet.class);

    public void doView(final RenderRequest request, final RenderResponse response) throws PortletException, IOException
    {
        response.setContentType("text/html");
        final String url = "/html/admin/view.jsp";
        getPortletContext().getRequestDispatcher(response.encodeURL(url)).include(request, response);
    }

    public void renameTaxonomy(final ResourceRequest request, final ResourceResponse response) throws IOException,
            NumberFormatException, SystemException, PortalException
    {
        final Taxonomy taxonomy = ActionUtil.renameTaxonomyFromRequest(request);
        TaxonomyLocalServiceUtil.updateTaxonomy(taxonomy);
        // TreeXMLLocalServiceUtil.insertAdminTaxonomy(1L);
        ActionUtil.insertAdminXML(1l);
    }

    public void moveTaxonomy(final ResourceRequest request, final ResourceResponse response) throws PortalException, IOException,
            SystemException, NumberFormatException
    {
        Taxonomy taxonomyObj = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(request.getParameter("taxonomyId")));
        Taxonomy taxonomyRef = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(request.getParameter("referenceId")));
        Long pos = Long.parseLong(request.getParameter("position"));
        if (taxonomyObj.getParentId() == taxonomyRef.getTaxId()) // only ordering 
        {
            TaxonomyLocalServiceUtil.updateTaxonomyPosition(taxonomyObj, taxonomyRef, pos);

        }
        else
        {
            TaxonomyLocalServiceUtil.updateTaxonomyPosition(taxonomyObj, taxonomyRef, pos);
            final Taxonomy taxonomy = ActionUtil.moveTaxonomyFromRequest(request);
            TaxonomyLocalServiceUtil.updateTaxonomy(taxonomy);
        }

        ActionUtil.insertAdminXML(1l);
    }

    public void removeTaxonomy(final ResourceRequest request, final ResourceResponse response) throws IOException,
            NumberFormatException, PortalException, SystemException
    {

        Taxonomy taxonomyObj = null;
        TaxonomyTranslate taxonomyTranslate = null;
        BrandTaxonomy brandTaxonomy = null;
        BrandTaxonomyTranslate brandTaxonomyTranslate = null;

        final PortletPreferences prefs = request.getPreferences();
        final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        final long groupId = themeDisplay.getLayout().getGroupId();
        final ServiceContext serviceContext = new ServiceContext();
        serviceContext.setScopeGroupId(groupId);

        // DLFolder dlFolder =
        // DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
        // "BrandStandard");
        final long folderId = Long.parseLong((String) prefs.getValue("Image_Folder", "0"));
        String oldFileName = "";
        Map<String, String> brandList = BrandStandardsUtil.chainCodeMap();

        /*
         * List<String> brandList = new ArrayList<String>() { private static
         * final long serialVersionUID = 1L; { add("IC"); add("IR"); add("HI");
         * add("EX"); add("RS"); add("CV"); add("CP"); add("CR"); add("UL");
         * add("IN"); add("VN"); add("SB"); add("CW"); } };
         */

        Map<String, String> activeLanguages = StandardsLocaleLocalServiceUtil
                .getActiveLanguages(BSAdminConstants.ACTIVE_LANG_QUERY);
        request.setAttribute("activeLanguages", activeLanguages.entrySet());
        if(LOG.isDebugEnabled()){
            LOG.debug("Remove taxonomy - Active Languages: " + activeLanguages.entrySet());
        }
        /*
         * List<String> localeList = new ArrayList<String>() { private static
         * final long serialVersionUID = 1L; { add("en_US"); add("es_ES");
         * add("fr_FR"); add("de_DE"); add("it_IT"); add("pt_BR"); add("ru_RU");
         * add("zh_CN"); add("ja_JP"); add("ar_SA"); add("tr_TR"); } };
         */

        String taxonomyId = request.getParameter("taxonomyId");

        for (String brand : brandList.keySet())
        {
            try
            {
                brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);

            }
            catch (Exception e)
            {
                LOG.error("Exception occured " + e);
            }

            for (String locale : activeLanguages.keySet())
            {
                if (brandTaxonomy != null)
                {
                    try
                    {
                        brandTaxonomyTranslate = BrandTaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(
                                brandTaxonomy.getId(), locale);

                    }
                    catch (Exception e)
                    {
                        LOG.error("Exception occured " + e);
                    }

                }

                if (brandTaxonomyTranslate != null)
                {
                    if (brandTaxonomyTranslate.getImageLoc() != null && !(brandTaxonomyTranslate.getImageLoc()).isEmpty())
                    {
                        final String[] strArr = brandTaxonomyTranslate.getImageLoc().split("/");
                        oldFileName = strArr[strArr.length - 1];

                        if (!(oldFileName.isEmpty()))
                        {
                            ActionUtil.deleteFileFromBrandTaxonomyTranslate(groupId, folderId, brandTaxonomyTranslate);
                        }
                    }

                    BrandTaxonomyTranslateLocalServiceUtil.updateBrandTaxonomyTranslate(brandTaxonomyTranslate);
                }

            }
        }

        for (String brand : brandList.keySet())
        {
            try
            {
                brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(taxonomyId), brand);
            }
            catch (Exception e)
            {
                LOG.error("Exception occured " + e);
            }

            if (brandTaxonomy != null)
            {
                if (brandTaxonomy.getImageLoc() != null && !(brandTaxonomy.getImageLoc()).isEmpty())
                {
                    final String[] strArr = brandTaxonomy.getImageLoc().split("/");
                    oldFileName = strArr[strArr.length - 1];

                    if (!(oldFileName.isEmpty()))
                    {
                        ActionUtil.deleteFileFromBrandTaxonomy(groupId, folderId, brandTaxonomy);
                    }
                }

                BrandTaxonomyLocalServiceUtil.updateBrandTaxonomy(brandTaxonomy);
            }
        }

        for (String locale : activeLanguages.keySet())
        {
            try
            {
                taxonomyTranslate = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(Long.parseLong(taxonomyId), locale);
            }
            catch (Exception e)
            {
                LOG.error("Exception occured: " + e);
            }

            if (taxonomyTranslate != null)
            {
                if (taxonomyTranslate.getImageLoc() != null && !(taxonomyTranslate.getImageLoc()).isEmpty())
                {
                    final String[] strArr = taxonomyTranslate.getImageLoc().split("/");
                    oldFileName = strArr[strArr.length - 1];
                }

                if (!(oldFileName.isEmpty()))
                {
                    ActionUtil.deleteFileFromTaxonomyTranslate(groupId, folderId, taxonomyTranslate);
                }

                TaxonomyTranslateLocalServiceUtil.updateTaxonomyTranslate(taxonomyTranslate);
            }
        }

        try
        {
            taxonomyObj = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(taxonomyId));
        }
        catch (Exception e)
        {
            LOG.error("Exception occured " + e);
        }

        if (taxonomyObj.getImageLoc() != null && !(taxonomyObj.getImageLoc()).isEmpty())
        {
            final String[] strArr = taxonomyObj.getImageLoc().split("/");
            oldFileName = strArr[strArr.length - 1];
        }

        if (!(oldFileName.isEmpty()))
        {
            ActionUtil.deleteFile(groupId, folderId, taxonomyObj);
        }

        TaxonomyLocalServiceUtil.updateTaxonomyPosition(taxonomyObj, taxonomyObj, taxonomyObj.getPosition());

        ActionUtil.removeTaxonomyFromRequest(request);

        ActionUtil.insertAdminXML(1l);
    }

    public void editDescTaxonomy(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse)
            throws NumberFormatException, PortalException, SystemException
    {

        ActionUtil.editTaxonomy(resourceRequest, resourceResponse);

        ActionUtil.insertAdminXML(1l);
    }

    @SuppressWarnings("unchecked")
    private String fetchDescData(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws NumberFormatException, PortalException, SystemException, IOException
    {

        List<String> brandDescs = ActionUtil.getBrandDescriptionData(resourceRequest);

        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("msg0", brandDescs.get(0));
        jsonObject.put("msg1", brandDescs.get(1));
        jsonObject.put("msg2", brandDescs.get(2));
        jsonObject.put("msg3", brandDescs.get(3));
        jsonObject.put("msg4", brandDescs.get(4));
        jsonObject.put("msg5", brandDescs.get(5));
        jsonObject.put("msg6", brandDescs.get(6));
        jsonObject.put("msg7", brandDescs.get(7));
        jsonObject.put("msg8", brandDescs.get(8));
        jsonObject.put("msg9", brandDescs.get(9));
        jsonObject.put("msg10", brandDescs.get(10));
        jsonObject.put("msg11", brandDescs.get(11));
        jsonObject.put("msg12", brandDescs.get(12));
        jsonObject.put("msg13", brandDescs.get(13));

        if(LOG.isDebugEnabled()){
            LOG.debug("jsonObject: " + jsonObject.toString());
        }
        return jsonObject.toString();
    }

    private String fetchSingleBrandData(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws NumberFormatException, PortalException, SystemException, IOException
    {

        String brandDesc = ActionUtil.getSingleBrandDescriptionData(resourceRequest);
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("singleBrandDesc", brandDesc);

        if(LOG.isDebugEnabled()){
            LOG.debug("jsonObject: " + jsonObject.toString());
        }
        return jsonObject.toString();
    }

    public String uploadFileTaxonomy(final ResourceRequest request, final ResourceResponse response) throws IOException,
            NumberFormatException, PortalException, SystemException, FileUploadException
    {
        final PortletPreferences prefs = request.getPreferences();
        final HttpServletRequest request1 = PortalUtil.getHttpServletRequest(request);

        // Create a factory for disk-based file items
        final FileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        final ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        List items = upload.parseRequest(request1);

        String imageUrl = "";

        // Process the uploaded items
        Iterator iterator = items.iterator();

        String taxId = "";
        String fileUrl = "";
        FileItem fileObj = null;
        String fileName = null;
        while (iterator.hasNext())
        {
            final FileItem item = (FileItem) iterator.next();
            if (item == null)
            {
                throw new RuntimeException("File payload not found");
            }
            if (item.isFormField())
            {
                if (item.getFieldName().equals("taxonomyId"))
                {
                    taxId = item.getString();
                }
                if (item.getFieldName().equals("action"))
                {
                    String action = item.getString();
                }
            }
            else
            {
                if (item.getFieldName().equals("document"))
                {
                    fileObj = item;
                    fileName = item.getName();
                }
            }

        }

        if (taxId != null && fileObj != null && fileName != null)
        {
            final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            final long realUserId = themeDisplay.getRealUserId();
            final long groupId = themeDisplay.getLayout().getGroupId();
            final ServiceContext serviceContext = new ServiceContext();
            serviceContext.setScopeGroupId(groupId);
            // DLFolder dlFolder =
            // DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
            // "BrandStandard");
            final long folderId = Long.parseLong((String) prefs.getValue("Image_Folder", "0"));
            final Taxonomy taxonomyObj = TaxonomyLocalServiceUtil.getTaxonomy(Long.parseLong(taxId));
            final DLFileEntry fileEntry = ActionUtil.addOrOverwriteFile(realUserId, groupId, folderId, fileName,
                    fileObj.getInputStream(), fileObj.getSize(), taxonomyObj);
            if (fileEntry != null)
            {
                final String title = fileEntry.getTitle();

                fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/"
                        + themeDisplay.getScopeGroupId() + "/" + folderId + "/" + HttpUtil.encodeURL(HtmlUtil.unescape(title));
            }
        }
        if(LOG.isDebugEnabled()){
            LOG.debug("======================>>>>>>" + fileUrl);
        }
        if (fileUrl != null)
        {
            final long userId = PortalUtil.getUserId(request);
            final Taxonomy taxonomy = ActionUtil.editFileUrlTaxonomy(taxId, fileUrl, userId);
            TaxonomyLocalServiceUtil.updateTaxonomy(taxonomy);
            ActionUtil.insertAdminXML(1l);
            imageUrl = fileUrl;
        }
        return imageUrl;
    }

    @ProcessAction(name = "SavePrefs")
    public void SavePrefs(final ActionRequest actionRequest, final ActionResponse actionResponse) throws IOException,
            PortletException
    {
        PortletPreferences portletPreferences = actionRequest.getPreferences();
        if (Validator.isNotNull(actionRequest.getParameter("Image_Folder")))
        {
            portletPreferences.setValue("Image_Folder", actionRequest.getParameter("Image_Folder"));
        }
        portletPreferences.store();
    }

    protected void doEdit(final RenderRequest rRequest, final RenderResponse rResponse) throws PortletException, IOException,
            UnavailableException
    {
        rResponse.setContentType("text/html");
        final PortletRequestDispatcher prd = getPortletContext().getRequestDispatcher("/html/admin/edit.jsp");
        prd.include(rRequest, rResponse);
    }

    @ProcessAction(name = "Cancel")
    public void Cancel(final ActionRequest actionRequest, final ActionResponse actionResponse) throws IOException,
            PortletException
    {
        actionResponse.setPortletMode(PortletMode.VIEW);
    }

    public long createTaxonomy(final ResourceRequest request, final ResourceResponse response) throws IOException,
            SystemException, PortalException
    {
        //final Taxonomy taxonomy = ActionUtil.createTaxonomyFromRequest(request);
        final long userId = PortalUtil.getUserId(request);
        final User user = UserLocalServiceUtil.getUserById(userId);
        final Taxonomy taxonomy = TaxonomyLocalServiceUtil.createTaxonomy(CounterLocalServiceUtil.increment(Taxonomy.class.getName()));
        taxonomy.setParentId(Long.parseLong(request.getParameter("parentId")));
        taxonomy.setTitle(request.getParameter("title"));
        taxonomy.setPosition(Long.parseLong(request.getParameter("position")));
        taxonomy.setCreatedBy(user.getScreenName());
        taxonomy.setCreatorId(String.valueOf(userId));
        taxonomy.setCreatedDate(new Date());
        taxonomy.setUpdatedBy(String.valueOf(userId));
        taxonomy.setUpdatedDate(new Date());
        final Taxonomy insertedTaxonomy = TaxonomyLocalServiceUtil.updateTaxonomy(taxonomy);
        ActionUtil.insertAdminXML(1l);
        return insertedTaxonomy.getTaxId();
    }

    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException
    {
        long taxonomyId = 0;
        String action = "";
        boolean error = false;
        String imageUrl = "";

        if (!ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(request)))
        {
            action = request.getParameter("action");
        }
        if(LOG.isDebugEnabled()){
            LOG.debug("the action is : " + action);
        }
        if (("xmlExcelExportTaxonomy").equalsIgnoreCase(action))
        {
            exportTaxonomyToExcel(response);
        }
        else
        {
            noExport(request, response, taxonomyId, action, error, imageUrl);
        }
    }

    private void noExport(ResourceRequest resourceRequest, ResourceResponse resourceResponse, long taxonomyId, String action,
            boolean error, String imageUrl) throws IOException
    {
        String json;
        resourceResponse.setContentType("text/html");
        final PrintWriter out = resourceResponse.getWriter();
        try
        {
            if (ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest)))
            {
                error = multiFileUpload(resourceRequest, resourceResponse, error, imageUrl, out);
            }
            if (("moveTaxonomy").equalsIgnoreCase(action))
            {
                error = moveTheTaxonomy(resourceRequest, resourceResponse, error, out);
            }
            if (("createTaxonomy").equalsIgnoreCase(action))
            {
                try
                {
                    taxonomyId = createTaxonomy(resourceRequest, resourceResponse);
                }
                catch (NoSuchUserException e)
                {
                    error = true;
                    json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - NoSuchUserException\"}";// "+e.getMessage()+"\"}";

                    out.print(json);
                    out.flush();
                    out.close();
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
                catch (NumberFormatException e)
                {
                    error = true;
                    json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - NumberFormatException\"}";// "+e.getMessage()+"\"}";

                    out.print(json);
                    out.flush();
                    out.close();
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
                catch (SystemException e)
                {
                    error = true;
                    json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - SystemException\"}";// "+e.getMessage()+"\"}";

                    out.print(json);
                    out.flush();
                    out.close();
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
                if (!error)
                {
                    json = "{" + "\"response\": \"Success\"," + "\"message\": \"Node successfully created.\"," + "\"id\" : \""
                            + taxonomyId + "\"}";
                    out.print(json);
                    out.flush();
                    out.close();
                }
            }
            if (("renameTaxonomy").equalsIgnoreCase(action))
            {
                error = renameTheTaxonomy(resourceRequest, resourceResponse, error, out);
            }
            if (("removeTaxonomy").equalsIgnoreCase(action))
            {

                error = removeTheTaxonomy(resourceRequest, resourceResponse, taxonomyId, error, out);
            }
            if (("editDescTaxonomy").equalsIgnoreCase(action))
            {

                editTaxDesc(resourceRequest, resourceResponse, taxonomyId, error, out);
            }
            if (("xmlTaxonomy").equalsIgnoreCase(action))
            {

                taxonomyXml(resourceRequest, resourceResponse, out);
            }
            if (("getBrandDescData").equalsIgnoreCase(action))
            {

                brandDescData(resourceRequest, resourceResponse, taxonomyId, error, out);
            }
            if (("getDescData").equalsIgnoreCase(action))
            {

                descData(resourceRequest, resourceResponse, taxonomyId, error, out);
            }
        }
        catch (Exception e)
        {
            out.print("Failure - Exception - " + e.getMessage());
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    private void brandDescData(ResourceRequest resourceRequest, ResourceResponse resourceResponse, long taxonomyId,
            boolean error, PrintWriter out) throws PortalException, IOException
    {

        String json;
        try
        {
            json = fetchDescData(resourceRequest, resourceResponse);
        }
        catch (Exception e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (!error)
        {
            out.print(json);
            out.flush();
            out.close();
        }

    }

    private void descData(ResourceRequest resourceRequest, ResourceResponse resourceResponse, long taxonomyId, boolean error,
            PrintWriter out) throws PortalException, IOException
    {

        String json;
        try
        {
            json = fetchSingleBrandData(resourceRequest, resourceResponse);
        }
        catch (Exception e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (!error)
        {
            out.print(json);
            out.flush();
            out.close();
        }

    }

    private boolean multiFileUpload(ResourceRequest request, ResourceResponse response, boolean error, String imageUrl,
            final PrintWriter out)
    {
        String json;
        try
        {
            imageUrl = uploadFileTaxonomy(request, response);
        }
        catch (Exception e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - Exception\"}";// "+e.getMessage()+"\"}";
            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (!error)
        {
            // json = "{" + "\"response\": \"Success\"," +
            // "\"message\": \"File uploaded successfully.\"}";
            json = "{" + "\"response\": \"Success\"," + "\"message\": \"File uploaded successfully.\"," + "\"imageUrl\" : \""
                    + imageUrl + "\"}";
            out.print(json);
            out.flush();
            out.close();
        }
        return error;
    }

    private void taxonomyXml(ResourceRequest request, ResourceResponse response, final PrintWriter out)
    {
        String json;
        try
        {
            response.setContentType("text/xml");
            xmlTaxonomy(request, response);
        }
        catch (NumberFormatException e)
        {
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - NumberFormatException\"}";// "+e.getMessage()+"\"}";
            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    private void editTaxDesc(ResourceRequest request, ResourceResponse response, long taxonomyId, boolean error,
            final PrintWriter out) throws PortalException
    {
        String json;
        try
        {
            editDescTaxonomy(request, response);
        }
        catch (NumberFormatException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Number Format Exception\"}";// +e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - SystemException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (!error)
        {
            json = "{" + "\"response\": \"Success\"," + "\"message\": \"Description successfully saved.\"," + "\"id\" : \""
                    + taxonomyId + "\"}";
            out.print(json);
            out.flush();
            out.close();
        }
    }

    private boolean removeTheTaxonomy(ResourceRequest request, ResourceResponse response, long taxonomyId, boolean error,
            final PrintWriter out) throws IOException, PortalException
    {
        String json;
        try
        {
            removeTaxonomy(request, response);

        }
        catch (NumberFormatException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - NumberFormatException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - SystemException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (!error)
        {
            json = "{" + "\"response\": \"Success\"," + "\"message\": \"Node successfully removed.\"," + "\"id\" : \""
                    + taxonomyId + "\"}";
            out.print(json);
            out.flush();
            out.close();
        }
        return error;
    }

    private boolean renameTheTaxonomy(ResourceRequest request, ResourceResponse response, boolean error, final PrintWriter out)
            throws IOException, PortalException
    {
        String json;
        try
        {
            renameTaxonomy(request, response);
        }
        catch (NumberFormatException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - NumberFormatException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - SystemException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (!error)
        {
            json = "{" + "\"response\": \"Success\"," + "\"message\": \"Node successfully renamed.\"}";
            out.print(json);
            out.flush();
            out.close();
        }
        return error;
    }

    private boolean moveTheTaxonomy(ResourceRequest request, ResourceResponse response, boolean error, final PrintWriter out)
            throws IOException
    {
        String json;
        try
        {
            moveTaxonomy(request, response);
        }
        catch (NumberFormatException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - NumberFormatException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (PortalException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - PortalException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            error = true;
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception - SystemException\"}";// "+e.getMessage()+"\"}";

            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        if (!error)
        {
            json = "{" + "\"response\": \"Success\"," + "\"message\": \"Node successfully moved.\"}";
            out.print(json);
            out.flush();
            out.close();
        }
        return error;
    }

    private void exportTaxonomyToExcel(ResourceResponse response)
    {
        try
        {
            final Workbook workbook = ActionUtil.xmElxcelExport();

            response.setContentType("application/vnd.ms-excel");
            // response.addProperty(HttpHeaders.CACHE_CONTROL,
            // "max-age=3600, must-revalidate");
            response.addProperty("Content-Disposition", "attachment; filename=IndexTree.xls");

            final OutputStream out = response.getPortletOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            LOG.error("Exception occurred ...", e);
        }
    }

    public void xmlTaxonomy(final ResourceRequest request, final ResourceResponse response)
    {
        try
        {
            PrintWriter out = response.getWriter();
            StringBuffer sb = new StringBuffer();
            final TreeXML treeXmlTbl = ActionUtil.getXMLTreeTaxonomy(1L);
            if (treeXmlTbl != null)
            {
                sb.append(treeXmlTbl.getXMLLOB());
                out.write(sb.toString());
            }
            out.flush();
            out.close();
        }
        catch (Exception pe)
        {
            LOG.error(StackTraceUtil.getStackTrace(pe));
        }
    }

}
