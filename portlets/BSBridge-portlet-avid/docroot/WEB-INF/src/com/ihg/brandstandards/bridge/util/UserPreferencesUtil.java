package com.ihg.brandstandards.bridge.util;

import java.util.Date;

import javax.portlet.PortletRequest;

import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.model.impl.UserPreferenceImpl;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

public class UserPreferencesUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(UserPreferencesUtil.class);
    
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
                    UserPreference userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(theme.getUserId(), BSCommonConstants.PUBLISH_ENV_BRIDGE);
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
                        userPreferences = new UserPreferenceImpl();
                        long preferenceId = UserPreferenceLocalServiceUtil.getUserPreferencePK();
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
                        userPreferences.setModuleName(BSCommonConstants.PUBLISH_ENV_BRIDGE);
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
    
    public static String getBrand(long userId)
    {
        UserPreference userPreferences;
        try {
            userPreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userId, BridgeConstants.APP_BRIDGE);
            return userPreferences.getChainCode();
        } catch (SystemException e) {
            LOG.error(e.getMessage(),e);
        }
        return null;
    }
}
