/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * <a href="AnalyticsPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @description: This is a Brand Standard specific analytics portlet.
 * @author Chintan Akhani
 */
public class AnalyticsPortlet extends BrandStandardsPortlet
{
    private static final String JSP_PAGE = "jspPage";
    private static final String ANALYTICSID = "analyticsId";
    private static final Log LOG = LogFactoryUtil.getLog(AnalyticsPortlet.class);
    private static final String ANALYTICS_ID = "ihg.merlin.brandstandard.google.analytics.id";
    private static final String USER_TYPE = "USRTYP";
    private static final String HOTELCODE = "CURRLOCATIONNAME";

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String screenName = themeDisplay.getUser().getScreenName();
        UserPreferencesApplication userPrefsApp = new UserPreferencesApplication();
        renderRequest.setAttribute("userType", getMerlinSessionAttributeValue(screenName, USER_TYPE));

        String hotelCode = getMerlinSessionAttributeValue(screenName, HOTELCODE);
        if (Validator.isNotNull(hotelCode))
        {
            renderRequest.setAttribute("hotelCode", StringUtil.extractFirst(hotelCode, StringPool.COLON));
        }
        else
        {
            renderRequest.setAttribute("hotelCode", StringPool.BLANK);
        }

        //get brand code, country code and language code from brand standard session
        AccessAndPreferences preferences = getUserPreferences(renderRequest);

        renderRequest.setAttribute("brand", preferences.getChain());
        if (Validator.isNotNull(preferences.getCountry()))
        {
            renderRequest.setAttribute("countryName", BrandStandardsUtil.getCountryNameFromCode(preferences.getCountry()));
        }
        if (Validator.isNotNull(preferences.getLangCode()))
        {
            renderRequest.setAttribute("languageName", userPrefsApp.getLanguageName(preferences.getLangCode()));
        }
        //set google analytics id.
        renderRequest
                .setAttribute(ANALYTICSID, renderRequest.getPreferences().getValue(ANALYTICSID, PropsUtil.get(ANALYTICS_ID)));

        if (LOG.isDebugEnabled())
        {
            LOG.debug("countryName :" + renderRequest.getAttribute("countryName"));
            LOG.debug("languageName :" + renderRequest.getAttribute("languageName"));
        }

        super.doView(renderRequest, renderResponse);
    }

    @Override
    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {

        String analyticsId = renderRequest.getPreferences().getValue(ANALYTICSID, PropsUtil.get(ANALYTICS_ID));
        renderRequest.setAttribute(ANALYTICSID, analyticsId);
        if (Validator.isNotNull(renderRequest.getParameter(JSP_PAGE)))
        {
            include(renderRequest.getParameter(JSP_PAGE), renderRequest, renderResponse);
        }
        else
        {
            super.doEdit(renderRequest, renderResponse);
        }
    }

    /**
     * Set analytics Id into preferences.
     * 
     * @param actionRequest This is a ActionRequest object
     * @param actionResponse This is a ActionResponse object
     */
    public void setAnalyticsId(ActionRequest actionRequest, ActionResponse actionResponse)
    {

        PortletPreferences portletPreferences = actionRequest.getPreferences();
        try
        {
            portletPreferences.setValue(ANALYTICSID, actionRequest.getParameter(ANALYTICSID));
            portletPreferences.store();
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Analytics ID is ::" + actionRequest.getParameter(ANALYTICSID));
            }
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

    /**
     * @param activeDirectoryId This is a String object
     * @param parameterName This is a String object
     * @return String
     */
    private String getMerlinSessionAttributeValue(String activeDirectoryId, String parameterName)
    {

        String paramValue = "";

        try
        {
            paramValue = MerlinSession.get(activeDirectoryId, parameterName);
        }
        catch (Exception e)
        {
            LOG.warn(parameterName + " is NULL for user:" + activeDirectoryId);
        }

        if (null == paramValue)
        {
            paramValue = "";
        }
        return paramValue;
    }
}
