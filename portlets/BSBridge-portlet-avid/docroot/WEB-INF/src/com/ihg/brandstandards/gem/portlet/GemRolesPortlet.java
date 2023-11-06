/**
 * ©2015 IHG. All rights reserved.
 */
package com.ihg.brandstandards.gem.portlet;

import java.io.IOException;
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

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.GEMRole;
import com.ihg.brandstandards.db.service.GEMRoleLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="GemRolesPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class GemRolesPortlet extends BrandStandardsGemPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(GemRolesPortlet.class);
    
	@Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        HttpServletRequest httpRequest = getHttpServletRequest(renderRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final PortletURL portletURL = renderResponse.createRenderURL();
        boolean isGemAdmin = false;
        int prefRecPerPage = BridgeConstants.DEFAULT_ITEMS_PER_PAGE;
        Preferences preferences = getGEMUserPreferences(renderRequest);
        if (preferences != null) {
            prefRecPerPage = preferences.getItemsPerPage();
        }
        try {
            isGemAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), PortletProps.get("gem.admin.role"), false);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        
        try {
            if (isGemAdmin) {
                List<GEMRole> gemRolesList = new ArrayList<GEMRole>();
                try {
                	GEMRoleLocalServiceUtil.clearCache();
                	gemRolesList = GEMRoleLocalServiceUtil.getGEMRoles(-1, -1);
                } catch (Exception e) {
                    LOG.error("Failed while getting GEM Categories:", e);
                }
                setResultsToSearchContainer(renderRequest, httpRequest, gemRolesList, portletURL, prefRecPerPage);
                String gemRoleId = (String) renderRequest.getParameter("gemRoleId");
                if (Validator.isNotNull(gemRoleId)) {
                    GEMRole gemRole = GEMRoleLocalServiceUtil.getGEMRole(Long.parseLong(gemRoleId));
                    renderRequest.setAttribute("gemRole", gemRole);
                    renderRequest.setAttribute("showEditRoleDialog", true);
                }
            }
        } catch (Exception e) {
            LOG.error(e);
        }
        
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
    		List<GEMRole> resultList, PortletURL portletURL, int prefRecPerPage) {
        int pageNumber = ParamUtil.getInteger(httpRequest, BridgeConstants.REQUEST_PARAM_PAGE_NUM);
        int recPerPage = ParamUtil.getInteger(httpRequest, BridgeConstants.REQUEST_PARAM_REC_PER_PAGE);
        
        if (recPerPage == 0 && renderRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM) != null) {
            recPerPage = Integer.parseInt(renderRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM));
        } else if (recPerPage == 0) {
            recPerPage = prefRecPerPage;
        }
        SearchContainer<GEMRole> searchContainer = new SearchContainer<GEMRole>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, pageNumber, recPerPage, portletURL, null, null);
        final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());
        searchContainer.setTotal(resultList.size());
        
        List<GEMRole> roleDisplayList = ListUtil.subList(resultList, searchContainer.getStart(), searchContainer.getEnd());
        searchContainer.setResults(roleDisplayList);
        searchContainer.setEmptyResultsMessage("No Roles Exist.");
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
        String brandCode = null;
        String regionCode = null;
    	Preferences preferences = getGEMUserPreferences(actionRequest);
        if (preferences != null) {
        	brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
        }
        long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        	
        String gemRoleCode = ParamUtil.getString(actionRequest, "gemRoleCode");
        String ownerGrpId = ParamUtil.getString(actionRequest, "ownerGrpId");
        String ownerGrpName = ParamUtil.getString(actionRequest, "ownerGrpName");
        String busOwnerName = ParamUtil.getString(actionRequest, "busOwnerName");
        String deligate1Name = ParamUtil.getString(actionRequest, "deligate1Name");
        String deligate2Name = ParamUtil.getString(actionRequest, "deligate2Name");
        int recPerPage = ParamUtil.getInteger(actionRequest, "recPerPage");
        int pageNum = ParamUtil.getInteger(actionRequest, "pageNum");
        actionRequest.setAttribute("recPerPage", recPerPage);
        actionRequest.setAttribute("pageNum", pageNum);
        actionRequest.setAttribute("delta", recPerPage);
        actionRequest.setAttribute("cur", pageNum);
        actionResponse.setRenderParameter("delta", String.valueOf(recPerPage));
        actionResponse.setRenderParameter("cur", String.valueOf(pageNum));
        
        try {
        	GEMRole gemRole = GEMRoleLocalServiceUtil.createGEMRole(GEMTemplateLocalServiceUtil.getSequenceNumber("GEM_ROLE_ID_SEQ"));
        	gemRole.setRegionId(regionId);
        	gemRole.setChainCode(brandCode);
        	gemRole.setGemGrpCode(gemRoleCode);
        	gemRole.setOwnerGrpId(ownerGrpId);
        	gemRole.setOwnerGrpName(ownerGrpName);
        	gemRole.setBusOwnerName(busOwnerName);
        	gemRole.setDeligate1Name(deligate1Name != null ? deligate1Name : "");
        	gemRole.setDeligate2Name(deligate2Name != null ? deligate2Name : "");
        	
        	gemRole.setCreatorId(themeDisplay.getUser().getScreenName());
        	gemRole.setCreatedDate(new Date());
        	gemRole.setUpdatedBy(themeDisplay.getUser().getScreenName());
        	gemRole.setUpdatedDate(new Date());
        	GEMRoleLocalServiceUtil.updateGEMRole(gemRole);
        	if (LOG.isDebugEnabled()) {
                LOG.debug("Created Gem Role: GemGrpId=" + gemRole.getGemGrpId() + " gemGrpCode=" + gemRole.getGemGrpCode());
            }
        } catch (Exception e) {
            LOG.error("Failed while Saving Gem Role:", e);
            throw new PortletException("Failed to add Gem Role");
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
        String brandCode = null;
        String regionCode = null;
    	Preferences preferences = getGEMUserPreferences(actionRequest);
        if (preferences != null) {
        	brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
        }
        long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        
        long gemRoleId = ParamUtil.getLong(actionRequest, "gemRoleId");
        String ownerGrpId = ParamUtil.getString(actionRequest, "ownerGrpId");
        String ownerGrpName = ParamUtil.getString(actionRequest, "ownerGrpName");
        String busOwnerName = ParamUtil.getString(actionRequest, "busOwnerName");
        String deligate1Name = ParamUtil.getString(actionRequest, "deligate1Name");
        String deligate2Name = ParamUtil.getString(actionRequest, "deligate2Name");
        int recPerPage = ParamUtil.getInteger(actionRequest, "recPerPage");
        int pageNum = ParamUtil.getInteger(actionRequest, "pageNum");
        actionRequest.setAttribute("recPerPage", recPerPage);
        actionRequest.setAttribute("pageNum", pageNum);
        actionRequest.setAttribute("delta", recPerPage);
        actionRequest.setAttribute("cur", pageNum);
        actionResponse.setRenderParameter("delta", String.valueOf(recPerPage));
        actionResponse.setRenderParameter("cur", String.valueOf(pageNum));
        
        try {
        	GEMRole gemRole = GEMRoleLocalServiceUtil.getGEMRole(gemRoleId);
        	if(gemRole != null){
        		gemRole.setRegionId(regionId);
        		gemRole.setChainCode(brandCode);
            	gemRole.setOwnerGrpId(ownerGrpId);
            	gemRole.setOwnerGrpName(ownerGrpName);
            	gemRole.setBusOwnerName(busOwnerName);
            	gemRole.setDeligate1Name(deligate1Name != null ? deligate1Name : "");
            	gemRole.setDeligate2Name(deligate2Name != null ? deligate2Name : "");
	        	
	            gemRole.setUpdatedBy(themeDisplay.getUser().getScreenName());
	            gemRole.setUpdatedDate(new Date());
	            GEMRoleLocalServiceUtil.updateGEMRole(gemRole);
	            if (LOG.isDebugEnabled()) {
	            	LOG.debug("Created Gem Role: GemGrpId=" + gemRole.getGemGrpId() + " gemGrpCode=" + gemRole.getGemGrpCode());
	            }
        	}
        } catch (Exception e) {
            LOG.error("Failed while Editing Gem Role with GemRoleId=" + gemRoleId, e);
            throw new PortletException("Failed to save Gem Role while editing.");
        }
    }
  
    @ProcessAction(name="refreshGemRoles")
    public void refreshGemRoles(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        GEMRoleLocalServiceUtil.refreshGemRoles(themeDisplay.getUser().getScreenName());
    	LOG.info("Gem Roles Refreshed");
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
        
        boolean isGemAdmin = false;
        try {
        	isGemAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("gem.admin.role"), false);
        } catch (Exception e) {
            LOG.error(e);
        }
        resourceRequest.setAttribute("isGemAdmin", isGemAdmin);
        try {
            if ("addGemRole".equalsIgnoreCase(modalType)) {
            	setBusinessOwner(resourceRequest);
                include("/html/GEM/roles/addGemRole.jsp", resourceRequest, resourceResponse);
            } else if ("editGemRole".equalsIgnoreCase(modalType)) {
            	long gemRoleId = ParamUtil.getLong(resourceRequest, "gemRoleId");
            	GEMRole gemRole = null;
				try {
					gemRole = GEMRoleLocalServiceUtil.getGEMRole(gemRoleId);
				} catch (Exception e) {
					LOG.error("Failed to get role with GemRoleId:"+gemRoleId);
				}
				if(gemRole != null){
					setBusinessOwner(resourceRequest);
	                resourceRequest.setAttribute("editGemRole", gemRole);
	                httpRequest.setAttribute("editGemRole", gemRole);
	                include("/html/GEM/roles/editGemRole.jsp", resourceRequest, resourceResponse);
				}
            } else if ("validateGEMRoleCode".equalsIgnoreCase(modalType)) {
            	String gemRoleCode = ParamUtil.getString(resourceRequest, "gemRoleCode");
                boolean gemRoleExist = false;
                String returnMsg = "Role Exist";
                if (Validator.isNotNull(gemRoleCode)) {
                    try {
                    	GEMRole gemRole = GEMRoleLocalServiceUtil.getByGemRoleCode(gemRoleCode);
                        if (gemRole != null) {
                            gemRoleExist = true;
                        }
                    } catch (Exception e) {
                        gemRoleExist = false;
                    }
                } else {
                    gemRoleExist = true;
                    returnMsg = "Invalid Key";
                }

                if (gemRoleExist) {
                    resourceResponse.getWriter().write(returnMsg);
                }
            } else if ("deleteGemRole".equalsIgnoreCase(modalType)) {
            	long gemRoleId = ParamUtil.getLong(resourceRequest, "gemRoleId");
                String returnMsg = "Success";
                if (gemRoleId <= 0) {
                    returnMsg = "Failed";
                }
                resourceResponse.getWriter().write(returnMsg);
                if (gemRoleId > 0) {
                	GEMRoleLocalServiceUtil.deleteGEMRole(gemRoleId);
                }
            }
        } catch (Exception e) {
            LOG.error(e);
        }
    }
    
    private void setBusinessOwner(ResourceRequest resourceRequest){
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        try {
        	List<User> cmsBusinessOwners = UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "BRND_STND_GLBL_BUS_OWNERS").getRoleId());
        	cmsBusinessOwners.addAll(UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "BRND_STND_AMEA_BUS_OWNERS").getRoleId()));
        	cmsBusinessOwners.addAll(UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "BRND_STND_AMER_BUS_OWNERS").getRoleId()));
    		cmsBusinessOwners.addAll(UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "BRND_STND_EURO_BUS_OWNERS").getRoleId()));
    		cmsBusinessOwners.addAll(UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "BRND_STND_GC_BUS_OWNERS").getRoleId()));
        	resourceRequest.setAttribute("businessOwnerList", cmsBusinessOwners);
		} catch (Exception e) {
			LOG.error("Failed to get Business Owner Name");
		}
    }

}
