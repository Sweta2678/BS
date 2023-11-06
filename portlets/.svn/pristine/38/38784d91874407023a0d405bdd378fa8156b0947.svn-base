/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * <a href="BrandStandardsPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author KhandeN
 */
public class BrandStandardsPortlet extends MVCPortlet
{
    protected static final String USER_PREFERENCES = "UserPreferences";
    //private static final Logger LOG = BrandStandardsLogger.getLogger(BrandStandardsPortlet.class);
    static final String CURR_LOCATION = "CURRLOCATIONNAME";

    /**
     * @param renderRequest The Portlet Request Object
     * @return HttpServletRequest return HttpServletRequest Object
     */
    public HttpServletRequest getHttpRequest(PortletRequest renderRequest)
    {
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(renderRequest);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);

        return httpRequest;
    }

    /**
     * 
     * @param httpRequest The HttpServletRequest Object
     * @return HttpSession return HttpSession Object
     */
    public HttpSession getHttpSession(HttpServletRequest httpRequest)
    {
        return httpRequest.getSession();
    }

    /**
     * 
     * @param portletRequest The PortletRequest Object
     * @return HttpSession return HttpSession Object
     */
    public HttpSession getHttpSession(PortletRequest portletRequest)
    {
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));

        return httpRequest.getSession();
    }

    /**
     * @param request The HttpServletRequest Object
     */
    public void terminateSession(HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        session.invalidate();
    }

    /**
     * get user preferences from session.
     * 
     * @param request The PortletRequest Object
     * @return AccessAndPreferences return AccessAndPreferences Object
     */
    public AccessAndPreferences getUserPreferences(PortletRequest request)
    {
        AccessAndPreferences userPreferences = null;
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
        HttpSession session = httpRequest.getSession();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        if (session.getAttribute(USER_PREFERENCES) != null)
        {
            userPreferences = (AccessAndPreferences) session.getAttribute(USER_PREFERENCES);
        }
        else
        {
            UserPreferencesApplication userPrefsApp = new UserPreferencesApplication();
            UserPreference userPrefs = userPrefsApp.getUserPreferences(themeDisplay.getUserId());
            if (userPrefs != null)
            {
                userPreferences = userPrefsApp.loadUserPreferences(themeDisplay.getUserId());
            }
            else
            {
                userPreferences = new AccessAndPreferences();
            }
        }

        return userPreferences;
    }
    
    public BSLanguageUtil getOBSMLanguageUtil(PortletRequest request, String localeCode, String moduleUsedIn)
    {
        BSLanguageUtil obsmLanguageUtil = null;
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
        HttpSession session = httpRequest.getSession();
        if(session.getAttribute("obsmLanguageUtil") != null)
        {
            obsmLanguageUtil = (BSLanguageUtil)session.getAttribute("obsmLanguageUtil");
        }
        
        if(obsmLanguageUtil == null)
        {
            obsmLanguageUtil = new BSLanguageUtil(localeCode, "OBSM");
            session.setAttribute("obsmLanguageUtil", obsmLanguageUtil);
        }
        
        return obsmLanguageUtil;
    }

}
