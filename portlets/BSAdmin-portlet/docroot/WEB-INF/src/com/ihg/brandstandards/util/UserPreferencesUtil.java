package com.ihg.brandstandards.util;

import java.util.Date;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;

/**
 * Utility class for User Preferences.
 *
 */
public final class UserPreferencesUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(UserPreferencesUtil.class);
    
    /**
     * Get Brand Code from User Preferences.
     * @param request
     * @return
     */
    public static String getUserpreferences(PortletRequest request)
    {
        ThemeDisplay theme = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String brandCode = StringPool.BLANK;
        if (theme.isSignedIn())
        {
            HttpSession session = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getSession();
            Map<String, String> chnCdMap = StandardsUtil.chainCodeMap();
            if (Validator.isNotNull(session.getAttribute("userBranch")))
            {
                return (String) session.getAttribute("userBranch");
            }
            else
            {
                try
                {
                    PortletPreferences preferences = PortletPreferencesLocalServiceUtil.getPreferences(theme.getCompanyId(), theme.getUserId(),
                            PortletKeys.PREFS_OWNER_TYPE_USER, 0, "UserPreferences_WAR_BSAdminportlet");
                    brandCode = preferences.getValue("checkedBranch", "Global");

                    if (Validator.isNull(brandCode) || !chnCdMap.containsKey(brandCode))
                    {
                        brandCode = "Global";
                        session.setAttribute("userBranch", brandCode);
                    }

                    if (Validator.isNull(session.getAttribute("userBranch")))
                    {
                        session.setAttribute("userBranch", brandCode);
                    }
                }
                catch (SystemException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }
        return brandCode;
    }

    /**
     * Get Discontinued value.
     * @param request request
     * @return true or empty string
     */
    public static String getDiscontinuedFilter(PortletRequest request)
    {
        String dFilter = StringPool.BLANK;
        ThemeDisplay theme = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        if (theme.isSignedIn())
        {
            HttpSession session = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getSession();
            if (Validator.isNotNull(session.getAttribute("statusFilter")))
            {
                return (String) session.getAttribute("statusFilter");
            }
            else
            {
                try
                {
                    PortletPreferences preferences = PortletPreferencesLocalServiceUtil.getPreferences(theme.getCompanyId(), theme.getUserId(),
                            PortletKeys.PREFS_OWNER_TYPE_USER, 0, "UserPreferences_WAR_BSAdminportlet");
                    dFilter = preferences.getValue("discontinuedFilter", "true");
                    if (Validator.isNull(session.getAttribute("statusFilter")))
                    {
                        session.setAttribute("statusFilter", dFilter);
                    }
                }
                catch (SystemException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }
        return dFilter;
    }
    
    /**
     * Update Records per page on User Preferences.
     * @param request request
     */
    public static void updateItemsPerPage(final PortletRequest request, final int itemsPerPage)
    {
        ThemeDisplay theme = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        if (theme.isSignedIn())
        {
            if (itemsPerPage > 0)
            {
                try
                {
                    UserPreference userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(theme.getUserId(), "CMS");
                    if (userPreferences != null && userPreferences.getPreferenceId() != 0)
                    {
                        userPreferences.setItemsPerPage(String.valueOf(itemsPerPage));
                        userPreferences.setUpdatedBy(String.valueOf(userPreferences.getUserId()));
                        userPreferences.setUpdatedDate(new Date());
                        UserPreferenceLocalServiceUtil.updateUserPreference(userPreferences);
                    }
                    else
                    {
                        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
                        User user = themeDisplay.getUser();
                        long userId = user.getUserId();
                        //userPreferences = new UserPreferenceImpl();
                        long preferenceId = UserPreferenceLocalServiceUtil.getUserPreferencePK();
                        userPreferences = UserPreferenceLocalServiceUtil.createUserPreference(preferenceId);
                        if (LOG.isDebugEnabled())
                        {
                            LOG.debug("value of preferenceId = " + preferenceId);
                        }
                        userPreferences.setPreferenceId(preferenceId);
                        userPreferences.setChainCode("GL");
                        userPreferences.setUserId(userId);
                        userPreferences.setCountryCode("NA");
                        userPreferences.setLangCode("en_GB");
                        userPreferences.setItemsPerPage(String.valueOf(itemsPerPage));
                        userPreferences.setBuildType("N");
                        userPreferences.setModuleName("CMS");
                        userPreferences.setCreatorId(String.valueOf(userId));
                        userPreferences.setCreatedDate(new Date());
                        userPreferences.setUpdatedBy(String.valueOf(userId));
                        userPreferences.setUpdatedDate(new Date());
                        UserPreferenceLocalServiceUtil.addUserPreference(userPreferences);
                    }

                }
                catch (SystemException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
            }
        }
    }
}
