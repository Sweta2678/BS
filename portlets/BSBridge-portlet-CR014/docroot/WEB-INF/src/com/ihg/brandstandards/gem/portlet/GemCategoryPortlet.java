/**
 * ©2015 IHG. All rights reserved.
 */
package com.ihg.brandstandards.gem.portlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.GEMCategory;
import com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.gem.util.GemCategoryPortletUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="GemCategoryPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class GemCategoryPortlet extends BrandStandardsGemPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(GemCategoryPortlet.class);
    
	@Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        HttpServletRequest httpRequest = getHttpServletRequest(renderRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final PortletURL portletURL = renderResponse.createRenderURL();
        boolean isGemCategoryAdmin = false;
        boolean isGemAdmin = false;
        int prefRecPerPage = BridgeConstants.DEFAULT_ITEMS_PER_PAGE;
        Preferences preferences = getGEMUserPreferences(renderRequest);
        if (preferences != null) {
            prefRecPerPage = preferences.getItemsPerPage();
        }
        try {
            isGemCategoryAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PortletProps.get("gem.category.admin.role"), false);
            isGemAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PortletProps.get("gem.admin.role"), false);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        
        try {
            if (isGemCategoryAdmin || isGemAdmin) {
                List<GEMCategory> gemCategoryList = new ArrayList<GEMCategory>();
                try {
                	gemCategoryList = GEMCategoryLocalServiceUtil.getGEMCategories(-1, -1);
                } catch (Exception e) {
                    LOG.error("Failed while getting GEM Categories:", e);
                }
                setResultsToSearchContainer(renderRequest, httpRequest, gemCategoryList, portletURL, prefRecPerPage);
                String categoryId = (String) renderRequest.getParameter("categoryId");
                if (Validator.isNotNull(categoryId)) {
                    GEMCategory gemCategory = GEMCategoryLocalServiceUtil.getGEMCategory(Long.parseLong(categoryId));
                    renderRequest.setAttribute("gemCategory", gemCategory);
                    renderRequest.setAttribute("showEditCategoryDialog", true);
                }
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        
        renderRequest.setAttribute("isGemCategoryAdmin", isGemCategoryAdmin);
        renderRequest.setAttribute("isGemAdmin", isGemAdmin);
        include(viewTemplate, renderRequest, renderResponse);
    }
    
    /**
     * Method to set results into search container.
     * @param renderRequest
     * @param httpRequest
     * @param resultList
     * @param portletURL
     * @param prefRecPerPage
     */
    protected void setResultsToSearchContainer(RenderRequest renderRequest, HttpServletRequest httpRequest, 
    		List<GEMCategory> resultList, PortletURL portletURL, int prefRecPerPage) {
        int pageNumber = ParamUtil.getInteger(httpRequest, BridgeConstants.REQUEST_PARAM_PAGE_NUM);
        int recPerPage = ParamUtil.getInteger(httpRequest, BridgeConstants.REQUEST_PARAM_REC_PER_PAGE);
        
        if (recPerPage == 0 && renderRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM) != null) {
            recPerPage = Integer.parseInt(renderRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM));
        } else if (recPerPage == 0) {
            recPerPage = prefRecPerPage;
        }
        SearchContainer<GEMCategory> searchContainer = new SearchContainer<GEMCategory>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, pageNumber, recPerPage, portletURL, null, null);
        final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());
        searchContainer.setTotal(resultList.size());
        
        List<GEMCategory> categoryDisplayList = ListUtil.subList(resultList, searchContainer.getStart(), searchContainer.getEnd());
        searchContainer.setResults(categoryDisplayList);
        searchContainer.setEmptyResultsMessage("No Categories Exist.");
        renderRequest.setAttribute("searchContainer", searchContainer);
        
        renderRequest.setAttribute("curPageNum",
        		renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? String.valueOf(pageNumber) : 
        			renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
        renderRequest.setAttribute("delta",recPerPage);
        renderRequest.setAttribute("cur", renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? String.valueOf(pageNumber) : 
			renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
        
    }

    /**
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    @ProcessAction(name = "processSave")
    public void processSave(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String gemCategoryCode = ParamUtil.getString(actionRequest, "gemCategoryCode");
        String gemPrntCategoryId = ParamUtil.getString(actionRequest, "gemPrntCategoryId");
        String categoryName = ParamUtil.getString(actionRequest, "categoryName");
        String categoryViewType = ParamUtil.getString(actionRequest, "categoryViewType");
        String categoryAnsAll = ParamUtil.getString(actionRequest, "categoryAnsAll");
        String duplicatable = ParamUtil.getString(actionRequest, "duplicatable");
        long displayOrderNumber = ParamUtil.getLong(actionRequest, "displayOrderNumber");
        int recPerPage = ParamUtil.getInteger(actionRequest, "recPerPage");
        int pageNum = ParamUtil.getInteger(actionRequest, "pageNum");
        actionRequest.setAttribute("recPerPage", recPerPage);
        actionRequest.setAttribute("pageNum", pageNum);
        actionRequest.setAttribute("delta", recPerPage);
        actionRequest.setAttribute("cur", pageNum);
        actionResponse.setRenderParameter("delta", String.valueOf(recPerPage));
        actionResponse.setRenderParameter("cur", String.valueOf(pageNum));
        
        try {
        	GEMCategory gemCategory = GEMCategoryLocalServiceUtil.createGEMCategory(
        			GEMTemplateLocalServiceUtil.getSequenceNumber("GEM_CATGY_ID_SEQ"));
        	gemCategory.setGemCategoryCode(gemCategoryCode);
        	gemCategory.setCmsCategoryId(GEMCategoryLocalServiceUtil.getGEMMappingCMSCategoryId(GemConstants.CMS_LOOKUP_CATEGORY_IDS, categoryName));
        	gemCategory.setGemPrntCategoryId(gemPrntCategoryId);
        	gemCategory.setCategoryName(categoryName);
        	gemCategory.setCategoryViewType(categoryViewType);
        	gemCategory.setCategoryAnsAll(categoryAnsAll);
        	gemCategory.setDuplicatable(duplicatable);
        	gemCategory.setDisplayOrderNumber(displayOrderNumber);
        	
        	gemCategory.setCreatorId(String.valueOf(themeDisplay.getUserId()));
        	gemCategory.setCreatedDate(new Date());
        	gemCategory.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
        	gemCategory.setUpdatedDate(new Date());
            GEMCategoryLocalServiceUtil.updateGEMCategory(gemCategory);
        	if (LOG.isDebugEnabled()) {
                LOG.debug("Created Category: categoryId=" + gemCategory.getCategoryId() + " gemCategoryCode=" + gemCategory.getGemCategoryCode() 
                		+ " gemPrntCategoryId="+gemCategory.getGemPrntCategoryId() + " categoryName=" + gemCategory.getCategoryName() );
            }
        } catch (Exception e) {
            LOG.error("Failed while Saving Category:", e);
            throw new PortletException("Failed to add Category");
        }
    }

    /**
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    @ProcessAction(name = "processEdit")
    public void processEdit(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String categoryId = ParamUtil.getString(actionRequest, "categoryId");
        String gemCategoryCode = ParamUtil.getString(actionRequest, "gemCategoryCode");
        String gemPrntCategoryId = ParamUtil.getString(actionRequest, "gemPrntCategoryId");
        String categoryName = ParamUtil.getString(actionRequest, "categoryName");
        String categoryViewType = ParamUtil.getString(actionRequest, "categoryViewType");
        String categoryAnsAll = ParamUtil.getString(actionRequest, "categoryAnsAll");
        String duplicatable = ParamUtil.getString(actionRequest, "duplicatable");
        long displayOrderNumber = ParamUtil.getLong(actionRequest, "displayOrderNumber");
        int recPerPage = ParamUtil.getInteger(actionRequest, "recPerPage");
        int pageNum = ParamUtil.getInteger(actionRequest, "pageNum");
        actionRequest.setAttribute("recPerPage", recPerPage);
        actionRequest.setAttribute("pageNum", pageNum);
        actionRequest.setAttribute("delta", recPerPage);
        actionRequest.setAttribute("cur", pageNum);
        actionResponse.setRenderParameter("delta", String.valueOf(recPerPage));
        actionResponse.setRenderParameter("cur", String.valueOf(pageNum));
        
        try {
        	GEMCategory gemCategory = GEMCategoryLocalServiceUtil.getGEMCategory(Long.parseLong(categoryId));
        	if(gemCategory != null){
	        	gemCategory.setGemCategoryCode(gemCategoryCode);
	        	gemCategory.setCmsCategoryId(GEMCategoryLocalServiceUtil.getGEMMappingCMSCategoryId(GemConstants.CMS_LOOKUP_CATEGORY_IDS, categoryName));
	        	gemCategory.setGemPrntCategoryId(gemPrntCategoryId);
	        	gemCategory.setCategoryName(categoryName);
	        	gemCategory.setCategoryViewType(categoryViewType);
	        	gemCategory.setCategoryAnsAll(categoryAnsAll);
	        	gemCategory.setDuplicatable(duplicatable);
	        	gemCategory.setDisplayOrderNumber(displayOrderNumber);
	        	
	            gemCategory.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
	            gemCategory.setUpdatedDate(new Date());
	            GEMCategoryLocalServiceUtil.updateGEMCategory(gemCategory);
	            if (LOG.isDebugEnabled()) {
	            	LOG.debug("Updated Category: categoryId=" + gemCategory.getCategoryId() + " gemCategoryCode=" + gemCategory.getGemCategoryCode() 
	                		+ " gemPrntCategoryId="+gemCategory.getGemPrntCategoryId() + " categoryName=" + gemCategory.getCategoryName() );
	            }
        	}
        } catch (Exception e) {
            LOG.error("Failed while Editing Category with Category Id:" + categoryId, e);
            throw new PortletException("Failed to save Category while editing.");
        }
    }
  
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String modalType = (String) resourceRequest.getParameter("modalType");
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        resourceRequest.setAttribute("recPerPage", Validator.isNull(resourceRequest.getParameter("delta")) ? BridgeConstants.DEFAULT_ITEMS_PER_PAGE : resourceRequest.getParameter("delta"));
        resourceRequest.setAttribute("pageNum", Validator.isNull(resourceRequest.getParameter("cur")) ? 0 : resourceRequest.getParameter("cur"));
        resourceRequest.setAttribute("delta", Validator.isNull(resourceRequest.getParameter("delta")) ? BridgeConstants.DEFAULT_ITEMS_PER_PAGE : resourceRequest.getParameter("delta"));
        resourceRequest.setAttribute("cur", Validator.isNull(resourceRequest.getParameter("cur")) ? 0 : resourceRequest.getParameter("cur"));
        
        boolean isGemCategoryAdmin = false;
        boolean isGemAdmin = false;
        try {
        	isGemCategoryAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PortletProps.get("gem.category.admin.role"), false);
            isGemAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PortletProps.get("gem.admin.role"), false);
        } catch (Exception e) {
            LOG.error(e);
        }
        resourceRequest.setAttribute("isGemCategoryAdmin", isGemCategoryAdmin);
        resourceRequest.setAttribute("isGemAdmin", isGemAdmin);
        
        try {
            if ("addCategory".equalsIgnoreCase(modalType)) {
            	resourceRequest.setAttribute("categoryViewTypes", PortletProps.get("gem.category.view.types").split(StringPool.COMMA));
            	setCategoriesInRequestScope(resourceRequest);
                include("/html/GEM/category/addCategory.jsp", resourceRequest, resourceResponse);
            } else if ("editCategory".equalsIgnoreCase(modalType)) {
            	String categoryId = ParamUtil.getString(resourceRequest, "categoryId");
                GEMCategory gemCategory = null;
				try {
					gemCategory = GEMCategoryLocalServiceUtil.getGEMCategory(Long.parseLong(categoryId));
				} catch (Exception e) {
					LOG.error("Failed to get category with Category Id:"+categoryId);
				}
				if(gemCategory != null){
					resourceRequest.setAttribute("categoryViewTypes", PortletProps.get("gem.category.view.types").split(StringPool.COMMA));
	                resourceRequest.setAttribute("editCategory", gemCategory);
	                httpRequest.setAttribute("editCategory", gemCategory);
	                setCategoriesInRequestScope(resourceRequest);
	                include("/html/GEM/category/editCategory.jsp", resourceRequest, resourceResponse);
				}
            } else if ("showImportCategoryPopup".equalsIgnoreCase(modalType)) {
                include("/html/GEM/category/importCategories.jsp", resourceRequest, resourceResponse);
            } else if ("validateGEMCategoryId".equalsIgnoreCase(modalType)) {
            	String gemCategoryCode = ParamUtil.getString(resourceRequest, "gemCategoryCode");
                boolean categoryExist = false;
                String returnMsg = "Category Exist";
                if (Validator.isNotNull(gemCategoryCode)) {
                    try {
                    	GEMCategory gemCategory = GEMCategoryLocalServiceUtil.getByGEMCategoryId(gemCategoryCode);
                        if (gemCategory != null) {
                            categoryExist = true;
                        }
                    } catch (Exception e) {
                        categoryExist = false;
                    }
                } else {
                    categoryExist = true;
                    returnMsg = "Invalid Key";
                }

                if (categoryExist) {
                    resourceResponse.getWriter().write(returnMsg);
                }
            } else if ("deleteCategory".equalsIgnoreCase(modalType)) {
            	long categoryId = ParamUtil.getLong(resourceRequest, "categoryId");
            	String gemCategoryCode = ParamUtil.getString(resourceRequest, "gemCategoryCode");
                boolean catgyExistWithPrnt = false;
                String returnMsg = "Success";
                if (Validator.isNotNull(gemCategoryCode)) {
                    try {
                    	List<GEMCategory> gemPrntCategories = GEMCategoryLocalServiceUtil.getByGemPrntCategoryId(gemCategoryCode);
                        if (gemPrntCategories != null && gemPrntCategories.size() > 0) {
                        	catgyExistWithPrnt = true;
                            returnMsg = "Child Categories exist for this category.";
                        }
                    } catch (Exception e) {
                    	catgyExistWithPrnt = true;
                        returnMsg = "Failed";
                    }
                } else {
                	catgyExistWithPrnt = true;
                    returnMsg = "Failed";
                }
                resourceResponse.getWriter().write(returnMsg);
                if (!catgyExistWithPrnt && categoryId > 0) {
               		GEMCategoryLocalServiceUtil.deleteGEMCategory(categoryId);
                }
            } else if ("importCategoriesFromXLS".equalsIgnoreCase(modalType)) {
                String json = "";
                PrintWriter out = resourceResponse.getWriter();
                JSONObject recordsjsonObject = JSONFactoryUtil.createJSONObject();
                final boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(httpRequest));
                UploadPortletRequest uploadRequest = null;
                try {
                    if (isMultipart) {
                        uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
                        String fileName = uploadRequest.getFileName("file");
                        String importType = ParamUtil.getString(uploadRequest, "importType");
                        File file = uploadRequest.getFile("file");
                        if (file == null || fileName == null || fileName.trim().isEmpty()) {
                            throw new Exception("No file is selected. Please browse file again!");
                        }
                        recordsjsonObject = new GemCategoryPortletUtil().processGEMCategoryExcelSheet(-1, null, file, fileName, String.valueOf(themeDisplay.getUserId()), importType);
                    }
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                    json = "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception - :" + e.getMessage() + "\"}";
                    out.print(json);
                    out.flush();
                    out.close();
                    e.printStackTrace();
                }
                
                if ((recordsjsonObject != null) && (recordsjsonObject.length() > 0)) {
                    resourceResponse.getWriter().print(recordsjsonObject.toString());
                } else {
                    json = "{" + "\"response\": \"Success\", " + "\"message\": \"Categories updated successfully.\"}";
                    out.print(json);
                    out.flush();
                    out.close();
                }
            }
        } catch (Exception e) {
            LOG.error(e);
        }
    }

    public void setCategoriesInRequestScope(ResourceRequest resourceRequest){
    	List<GEMCategory> gemCategoryList = new ArrayList<GEMCategory>();
        try {
        	gemCategoryList = GEMCategoryLocalServiceUtil.getGEMCategories(-1, -1);
        } catch (Exception e) {
            LOG.error("Failed while getting GEM Categories:", e);
        }
        resourceRequest.setAttribute("gemCategoryList", gemCategoryList);
    }
    
}
