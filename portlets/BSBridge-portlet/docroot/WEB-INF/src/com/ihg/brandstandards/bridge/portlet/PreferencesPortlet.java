package com.ihg.brandstandards.bridge.portlet;

import com.ihg.brandstandards.bridge.util.BrandStandardsUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.Department;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.model.impl.UserPreferenceImpl;
import com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PreferencesPortlet extends BrandStandardsBridgePortlet
{
	private static final Log LOG = LogFactoryUtil.getLog(PreferencesPortlet.class);
	
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        HttpSession session = getHttpSession(httpRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Layout parentLayout = null;
       
        String chainCode = "";
        String glblRegionCode = "";
        boolean isProdPublish = false;
        boolean isStagePublish = false;
        boolean isStagePublicationActive = false;
        boolean isUserOnGEMScope = false;
        List<Department> departments = new ArrayList<Department>();
        Preferences preferences = new Preferences();
        Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
        
        try 
        {
        	long userId = themeDisplay.getUserId();
            List<Role> userRoleList = themeDisplay.getUser().getRoles();
            parentLayout = LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
            String regionCodeFromUserRole = null;
            UserPreference userPreferences = null;
            if (themeDisplay.getURLCurrent().contains(BridgeConstants.GEM_PREFIX_URL))
            {
            	//Gem user
            	isUserOnGEMScope = true;
            	userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userId, BridgeConstants.APP_GEM);
            	regionCodeFromUserRole =  BrandStandardsUtil.getGemUserRegionFromUserRole(userRoleList);
            }
            else 
            {
            	//Bridge user
            	isUserOnGEMScope = false;
            	userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userId, BridgeConstants.APP_BRIDGE);
            	regionCodeFromUserRole = BrandStandardsUtil.getUserRegionFromUserRole(userRoleList);
            	if (regionCodeFromUserRole.equals("GLBL") )
            	{
            		glblRegionCode = httpRequest.getParameter("rgnCd");
            		if (glblRegionCode != null && !glblRegionCode.isEmpty())
            		{
            			regionCodeFromUserRole = glblRegionCode;
            			if (userPreferences != null)
            			{
            				userPreferences.setCountryCode(BrandStandardsUtil.decodeReverseRegionCode(regionCodeFromUserRole));
            				UserPreferenceLocalServiceUtil.updateUserPreference(userPreferences);
            			}
            		}
            	}
            }
            
            if (userPreferences != null)
            {
                preferences.setBrand(userPreferences.getChainCode());
                if (userPreferences.getCountryCode() != null && !userPreferences.getCountryCode().isEmpty())
                {
                    regionCodeFromUserRole = BrandStandardsUtil.decodeRegionCode(userPreferences.getCountryCode());
                }
                preferences.setRegion(userPreferences.getCountryCode());
                preferences.setRegionCode(regionCodeFromUserRole);
                preferences.setRegion(BrandStandardsUtil.decodeReverseRegionCode(regionCodeFromUserRole));
                preferences.setRegionName(BrandStandardsUtil.decodeRegionName(regionCodeFromUserRole));
                preferences.setDiscontinuedFilter(userPreferences.getBuildType());
                preferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(userPreferences.getItemsPerPage()) ? 
                        BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE : Integer.valueOf(userPreferences.getItemsPerPage()));
                preferences.setUserId(userId);
                chainCode = userPreferences.getChainCode();
                
              //Check whether staging publication is active or not, and whether it is created from current bridge publication or not?
                isStagePublicationActive = isStagePublicationExist(preferences, renderRequest);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("is staging active publication :"+isStagePublicationActive);
                }
                //Check whether any publication to stage or prod is in progress
                if (Validator.isNotNull(chainCode)) {
                    isProdPublish = isQueueEmpty(chainCode, BridgeConstants.PRODUCTION_ENVIRONMENT, statusList.toString());
                    isStagePublish = isQueueEmpty(chainCode, BridgeConstants.STAGING_ENVIRONMENT, statusList.toString());
                }
                // Set department into preferences
                if (Validator.isNotNull(userPreferences.getInfoDisplay())) {
                	Department dept = DepartmentLocalServiceUtil.getDepartment(GetterUtil.getLong(userPreferences.getInfoDisplay()));
                	renderRequest.setAttribute("deptName", dept.getDepartmentName());
                	if (BrandStandardsUtil.isGemGlobalAdmin(userRoleList)) {
                		preferences.setDepartmentId(GetterUtil.getLong(userPreferences.getInfoDisplay()));
                	} else {
                		//First of all verify whether user has access to this department or not
                    	departments.add(DepartmentLocalServiceUtil.getDepartment(
                    			GetterUtil.getLong(userPreferences.getInfoDisplay())));
                    	if (BrandStandardsUtil.getRoleBasedDeptList(departments, userRoleList).size() > 0) {
                    		preferences.setDepartmentId(GetterUtil.getLong(userPreferences.getInfoDisplay()));
                    	} else {
                        	httpRequest.setAttribute("showAccessDialog", true);
                        	departments = DepartmentLocalServiceUtil.getActiveDepartments("Y");
        	                if (LOG.isDebugEnabled()) {
        	                	LOG.debug("departments ::"+ departments);
        	                }
        	                //Check for role based permission
        	    			renderRequest.setAttribute("departments", 
        	    						BrandStandardsUtil.getRoleBasedDeptList(departments, userRoleList));
                    	}
                	}
                	
                } else if (isUserOnGEMScope && Validator.isNull(userPreferences.getInfoDisplay())) {
                	departments = DepartmentLocalServiceUtil.getActiveDepartments("Y");
                	renderRequest.setAttribute("departments", 
    						BrandStandardsUtil.getRoleBasedDeptList(departments, userRoleList));
                	httpRequest.setAttribute("showAccessDialog", true);
                }
            } else {
                preferences = null;
                httpRequest.setAttribute("showAccessDialog", true);
            } 
        } 
        catch (Exception e) 
        {
            LOG.error(e);
        }
        //Bellow code for bridge only
        if(preferences != null && !isUserOnGEMScope) {
        	try {
        			if("GLBL".equals(preferences.getRegionCode()) && "Region".equals(parentLayout.getName(Locale.US))) {
						renderRequest.setAttribute("redirectToBridgeScope", true);
						renderRequest.setAttribute("redirectBridgePageURL", "/web/brand-standards/bridge/progress");
					} else if(!"GLBL".equals(preferences.getRegionCode()) && "Global".equals(parentLayout.getName(Locale.US))) {
						renderRequest.setAttribute("redirectToBridgeScope", true);
						renderRequest.setAttribute("redirectBridgePageURL", "/web/brand-standards/bridge/summary");
					}
			} catch (Exception e) {
				LOG.error("Failed to set redirect info in request", e);
			}
        }
        
        if (isUserOnGEMScope)
        {
        	session.setAttribute("gemPreferences", preferences);
            session.setAttribute("gemUserBranch", chainCode);
        } 
        else 
        {
	        session.setAttribute("Preferences", preferences);
	        session.setAttribute("userBranch", chainCode);
        }
        renderRequest.setAttribute("chainCdMap", chnCdMap);
        renderRequest.setAttribute("glblRgnCd", glblRegionCode);
        session.setAttribute("isStagePublicationExist", isStagePublicationActive);
        if (isProdPublish && isStagePublish) {
            session.setAttribute("publicationLocked", false);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Publication is not locked");
            }
        } else {
            session.setAttribute("publicationLocked", true);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Publication is  locked");
            }
        }
        renderRequest.setAttribute("isUserOnGEMScope", isUserOnGEMScope);
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/preferences/view.jsp");
        dispatcher.include(renderRequest, renderResponse);
    }
	
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
        String modalType = resourceRequest.getParameter("modalType");
        boolean isUserOnGEMScope = false;
        resourceRequest.setAttribute("selectBrandErrorMsg", "Please choose a Brand");
        resourceRequest.setAttribute("selectRegionErrorMsg", "Please choose a Region");
        resourceRequest.setAttribute("selectDeptErrorMsg", "Please choose a Department");
        if ("editPreferences".equals(modalType))
        {
            try
            {
            	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
            	if (themeDisplay.getURLCurrent().contains(BridgeConstants.GEM_PREFIX_URL))
            	{
            		isUserOnGEMScope = true;
            		boolean isGEMGlobalAdmin = false;
            		boolean isGEMGlobalDepartmentAdmin = false;
	                List<Role> userRoleList = themeDisplay.getUser().getRoles();
	                isGEMGlobalAdmin = BrandStandardsUtil.isGemGlobalAdmin(userRoleList);
	                isGEMGlobalDepartmentAdmin = BrandStandardsUtil.isGemGlobalDepartmentAdmin(userRoleList);
	                resourceRequest.setAttribute("isGemGlobalAdmin", isGEMGlobalAdmin);
	                resourceRequest.setAttribute("isGemAdmin", isGEMGlobalDepartmentAdmin);
	                // Get list of active department
	                List<Department> departments = DepartmentLocalServiceUtil.getActiveDepartments("Y");
	                if (LOG.isDebugEnabled()) {
	                	LOG.debug("departments ::"+ departments);
	                	LOG.debug("Is Global GEM user: " + isGEMGlobalAdmin);
	                }
	    			
	    			if (isGEMGlobalAdmin) {
	    				resourceRequest.setAttribute("departments", departments);
	    			} else {
	    				//Check for role based permission
	    				resourceRequest.setAttribute("departments", 
	    						BrandStandardsUtil.getRoleBasedDeptList(departments, userRoleList));
	    			}
	    			resourceRequest.setAttribute("regCodeFrmUsrRole", BrandStandardsUtil.getGemUserRegionFromUserRole(userRoleList));
            	}
            	resourceRequest.setAttribute("isUserOnGEMScope", isUserOnGEMScope);
            	
                include("/html/preferences/editPreferences.jsp", resourceRequest, resourceResponse);
            }
            catch (Exception e)
            {
                LOG.error(e);
            }
        }
    }
    
    @ProcessAction(name = "setPreference")
    public void setPreference(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        HttpSession session = null;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Preferences preferences = new Preferences();
        String chainCode ="";
        boolean isUserOnGEMScope = false;
        try
        {
            session = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest)).getSession();
            String checkedBrand = ParamUtil.getString(actionRequest, "chnCd");
            String itemsPerPage = ParamUtil.getString(actionRequest, BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE);
            String discontinuedFilter = ParamUtil.getString(actionRequest, "autofilter");
            User user = themeDisplay.getUser();
            long userId = user.getUserId();
            List<Role> roles = user.getRoles();
        	isUserOnGEMScope = false;
            boolean isGemAdmin = false;
            String department = ParamUtil.getString(actionRequest, "access_corp_choose_dept");
            //parentLayout = LayoutLocalServiceUtil.getLayout(themeDisplay.getLayout().getParentPlid());
            UserPreference userPreferences = null;
            String regionCode = null;
            if (themeDisplay.getURLCurrent().contains(BridgeConstants.GEM_PREFIX_URL))
        	{
        		//Gem user
        		userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userId, BridgeConstants.APP_GEM);
        		isUserOnGEMScope = true;
        		isGemAdmin = BrandStandardsUtil.isGemGlobalDepartmentAdmin(roles);
        		if (isGemAdmin)
        		{
        			regionCode = ParamUtil.getString(actionRequest, "rgnCd");
        		}
        		else
        		{
        			regionCode = BrandStandardsUtil.getGemUserRegionFromUserRole (roles); 
        		}
        	}
        	else
        	{
        		//Bridge user
        		userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userId, BridgeConstants.APP_BRIDGE);
        		regionCode = BrandStandardsUtil.getUserRegionFromUserRole (roles); 
        	}
            
            if(Validator.isNotNull(checkedBrand))
            {
	            if (userPreferences != null && userPreferences.getPreferenceId() != 0)
	            {
	                if (LOG.isDebugEnabled())
	                {
	                    LOG.debug("in if userpreferences not null value of preference id is " + userPreferences.getPreferenceId());
	                }
	                userPreferences.setUserId(userId);
	                userPreferences.setChainCode(checkedBrand);
	                userPreferences.setCountryCode(BrandStandardsUtil.decodeReverseRegionCode(regionCode));
	                userPreferences.setLangCode("en_GB");
	                userPreferences.setBuildType(discontinuedFilter);
	                userPreferences.setModuleName(isUserOnGEMScope ? BridgeConstants.APP_GEM : BridgeConstants.APP_BRIDGE);
	                userPreferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(itemsPerPage) ? String.valueOf(BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE) : itemsPerPage);
	                userPreferences.setUpdatedBy(String.valueOf(userPreferences.getUserId()));
	                userPreferences.setUpdatedDate(new Date());
	                //Set department
	                if (Validator.isNotNull(department) && BridgeConstants.APP_GEM.equals(userPreferences.getModuleName())) {
	                	userPreferences.setInfoDisplay(department);
	                }
	                UserPreferenceLocalServiceUtil.updateUserPreference(userPreferences);
	            }
	            else
	            {
	                userPreferences = new UserPreferenceImpl();
	                long preferenceId = UserPreferenceLocalServiceUtil.getUserPreferencePK();
	                if (LOG.isDebugEnabled())
	                {
	                    LOG.debug("value of preferenceId = " + preferenceId);
	                }
	                userPreferences.setPreferenceId(preferenceId);
	                userPreferences.setChainCode(checkedBrand);
	                userPreferences.setUserId(userId);
	                userPreferences.setCountryCode(BrandStandardsUtil.decodeReverseRegionCode(regionCode));
	                userPreferences.setLangCode("en_GB");
	                userPreferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(itemsPerPage) ? String.valueOf(BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE) : itemsPerPage);
	                userPreferences.setBuildType(discontinuedFilter);
	                userPreferences.setModuleName(isUserOnGEMScope ? BridgeConstants.APP_GEM : BridgeConstants.APP_BRIDGE);
	                userPreferences.setCreatorId(String.valueOf(userId));
	                userPreferences.setCreatedDate(new Date());
	                userPreferences.setUpdatedBy(String.valueOf(userId));
	                userPreferences.setUpdatedDate(new Date());
	              //Set department
	                if (Validator.isNotNull(department) && BridgeConstants.APP_GEM.equals(userPreferences.getModuleName())) {
	                	userPreferences.setInfoDisplay(department);
	                }
	                UserPreferenceLocalServiceUtil.addUserPreference(userPreferences);
	            }
        	}
            preferences.setBrand(userPreferences.getChainCode());
            preferences.setRegion(userPreferences.getCountryCode());
            preferences.setRegionCode(BrandStandardsUtil.decodeRegionCode(userPreferences.getCountryCode()));
            preferences.setDiscontinuedFilter(userPreferences.getBuildType());
            preferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(userPreferences.getItemsPerPage()) ? BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE : Integer.valueOf(userPreferences.getItemsPerPage()));
            preferences.setUserId(userId);
          //Set department
            if (Validator.isNotNull(department) && BridgeConstants.APP_GEM.equals(userPreferences.getModuleName())) {
            	preferences.setDepartmentId(GetterUtil.getLong(userPreferences.getInfoDisplay()));
            }
            chainCode = userPreferences.getChainCode();
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        
        if (themeDisplay.getURLCurrent().contains(BridgeConstants.GEM_PREFIX_URL))
        {
        	session.setAttribute("gemPreferences", preferences);
            session.setAttribute("gemUserBranch", chainCode);
        } 
        else 
        {
	        session.setAttribute("Preferences", preferences);
	        session.setAttribute("userBranch", chainCode);
        }
        
        if (preferences != null && !isUserOnGEMScope && ("GLB".equals(preferences.getRegion()) || "GLBL".equals(preferences.getRegion())))
        {
            actionResponse.sendRedirect("/web/brand-standards/bridge/progress");
        }
    }
}
