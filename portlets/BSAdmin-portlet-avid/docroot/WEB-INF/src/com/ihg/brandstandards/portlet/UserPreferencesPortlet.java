/**
 * 
 */
package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * UserPreferencesPortlet.
 * @author jatin.panchal
 * 
 */
public class UserPreferencesPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(UserPreferencesPortlet.class);
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        Preferences preferences = new Preferences();
        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(renderRequest);
        HttpSession session = httpReq.getSession();
        Map<String, String> chnCdMap = StandardsUtil.chainCodeMap();
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        long userId = user.getUserId();
        String chainCode = "";
        try
        {
            UserPreference userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userId, "CMS");

            if (userPreferences != null)
            {
                preferences.setBrand(userPreferences.getChainCode());
                preferences.setRegion(userPreferences.getCountryCode());
                preferences.setRegionCode(decodeRegionCode(userPreferences.getCountryCode()));
                preferences.setDiscontinuedFilter(userPreferences.getBuildType());
                preferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(userPreferences.getItemsPerPage()) ? 
                        BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE : Integer.valueOf(userPreferences.getItemsPerPage()));
                preferences.setUserId(userId);
                chainCode = userPreferences.getChainCode();
            }
            else
            {
                preferences.setBrand("GL");
                preferences.setDiscontinuedFilter("N");
                preferences.setRegionCode("NA");
                preferences.setRegion("NA");
                preferences.setItemsPerPage(BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE);
                preferences.setUserId(userId);
            }
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        session.setAttribute("Preferences", preferences);
        session.setAttribute("userBranch", chainCode);
        renderRequest.setAttribute("chainCdMap", chnCdMap);
        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = "setPreference")
    public void setPreference(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        HttpSession session = null;
        Preferences preferences = new Preferences();
        boolean isSuperAdmin = false;
        String currentURL = "";
        String chainCode ="";
        try
        {
            session = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest)).getSession();
            String checkedBrand = ParamUtil.getString(actionRequest, "chnCd");
            String region = ParamUtil.getString(actionRequest, "rgnCd");
            String itemsPerPage = ParamUtil.getString(actionRequest, BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE);
            currentURL = ParamUtil.getString(actionRequest, "redirect");
            String discontinuedFilter = ParamUtil.getString(actionRequest, "autofilter");
           
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            User user = themeDisplay.getUser();
            long userId = user.getUserId();
            List<Role> roles = user.getRoles();
            for (Role role : roles)
            {
            	if (StandardsUtil.BRND_STND_SUPER_ADMIN.equalsIgnoreCase(role.getName()))
                {
                	isSuperAdmin = true;
                    break;
                }
            }
            if (isSuperAdmin && (BrandStandardsUtil.IsNullOrBlank(region) || region.length() > 3))
            {
                region = "GLB";
            }
            else if(!isSuperAdmin)
            {
            	region = "NA";
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("the value of region code is " + region+" and is SuperAdmin "+isSuperAdmin);
            }
			UserPreference userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userId, "CMS");
            if (userPreferences != null && userPreferences.getPreferenceId() != 0)
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("in if userpreferences not null value of preference id is " + userPreferences.getPreferenceId());
                }
                userPreferences.setUserId(userId);
                userPreferences.setChainCode(checkedBrand);
                userPreferences.setCountryCode(region);
                userPreferences.setLangCode("en_GB");
                userPreferences.setBuildType(discontinuedFilter);
                userPreferences.setModuleName("CMS");
//                userPreferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(itemsPerPage) ? String.valueOf(DEFAULT_ITEMS_PER_PAGE) : itemsPerPage);
                userPreferences.setUpdatedBy(String.valueOf(userPreferences.getUserId()));
                userPreferences.setUpdatedDate(new Date());
                UserPreferenceLocalServiceUtil.updateUserPreference(userPreferences);
            }
            else
            {
                //userPreferences = new UserPreferenceImpl();
                long preferenceId = UserPreferenceLocalServiceUtil.getUserPreferencePK();
                userPreferences = UserPreferenceLocalServiceUtil.createUserPreference(preferenceId);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("value of preferenceId = " + preferenceId);
                }
                //userPreferences.setPreferenceId(preferenceId);
                userPreferences.setChainCode(checkedBrand);
                userPreferences.setUserId(userId);
                userPreferences.setCountryCode(region);
                userPreferences.setLangCode("en_GB");
                userPreferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(itemsPerPage) ? String.valueOf(BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE) : itemsPerPage);
                userPreferences.setBuildType(discontinuedFilter);
                userPreferences.setModuleName("CMS");
                userPreferences.setCreatorId(String.valueOf(userId));
                userPreferences.setCreatedDate(new Date());
                userPreferences.setUpdatedBy(String.valueOf(userId));
                userPreferences.setUpdatedDate(new Date());
                UserPreferenceLocalServiceUtil.addUserPreference(userPreferences);
            }

            preferences.setBrand(userPreferences.getChainCode());
			preferences.setRegion(userPreferences.getCountryCode());
			preferences.setRegionCode(decodeRegionCode(userPreferences.getCountryCode()));
			preferences.setDiscontinuedFilter(userPreferences.getBuildType());
            preferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(userPreferences.getItemsPerPage()) ? BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE : Integer.valueOf(userPreferences.getItemsPerPage()));
			preferences.setUserId(userId);
			chainCode = userPreferences.getChainCode();
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        session.setAttribute("Preferences", preferences);
        session.setAttribute("userBranch", chainCode);
        actionResponse.sendRedirect(currentURL);
    }
    
    /**
     * Decode region code.
     * @param region region code
     * @return decoded region
     */
    public String decodeRegionCode(String region)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("inside region code");
        }
        String regionCode = "";
        final Map<String, String> rgnCdMap = new LinkedHashMap<String, String>();
        rgnCdMap.put("AMR", "AMER");
        rgnCdMap.put("EUR", "EURO");
        rgnCdMap.put("AME", "AMEA");
        rgnCdMap.put("GC", "GC");
        rgnCdMap.put("GLB", "GLBL");

        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : rgnCdMap.entrySet())
        {
            if (region.contains(entry.getKey()))
            {
                if (builder.length() > 0)
                {
                    builder.append(", ");
                }
                builder.append(entry.getValue());
            }
        }
        regionCode = builder.toString();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("the value of region code is " + regionCode);
        }
        return regionCode;
    }
}
