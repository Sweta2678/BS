/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.me2.brandstandards.custom.application.ContentApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.util.ApplicationUtil;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

/**
 * <a href="ContentConfigurationPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 */
public class ContentConfigurationPortlet extends BrandStandardsPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ContentConfigurationPortlet.class);
    private static final String IS_BRAND_SPECIFIC = "isBrandSpecific";
    private static final String IS_LANG_SPECIFIC = "isLangSpecific";
    private static final String ARTICLE_TYPE = "articleType";

    @Override
    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        ContentApplication contentApplication = ApplicationUtil.getContentApplicationObject();
        PortletPreferences preferences = renderRequest.getPreferences();
        if (Validator.isNotNull(preferences.getValue(IS_BRAND_SPECIFIC, StringPool.BLANK)))
        {
            renderRequest.setAttribute(IS_BRAND_SPECIFIC,
                    Boolean.parseBoolean(preferences.getValue(IS_BRAND_SPECIFIC, StringPool.BLANK)));
        }
        if (Validator.isNotNull(preferences.getValue(IS_LANG_SPECIFIC, StringPool.BLANK)))
        {
            renderRequest.setAttribute(IS_LANG_SPECIFIC,
                    Boolean.parseBoolean(preferences.getValue(IS_LANG_SPECIFIC, StringPool.BLANK)));
        }
        renderRequest.setAttribute(ARTICLE_TYPE, preferences.getValue(ARTICLE_TYPE, StringPool.BLANK));
        renderRequest.setAttribute("structureList", contentApplication.getStructureList(themeDisplay.getScopeGroupId()));
        renderRequest.setAttribute("contentEnvironmentVal", preferences.getValue("environment", StringPool.BLANK));
        super.doEdit(renderRequest, renderResponse);
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        ContentApplication contentApplication = ApplicationUtil.getContentApplicationObject();
        AccessAndPreferences userPreferences = getUserPreferences(renderRequest);
        if (userPreferences != null)
        {
            BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(renderRequest, userPreferences.getLangCode(), "OBSM");
            if (LOG.isDebugEnabled())
            {
                LOG.debug("userPreference :" + userPreferences.getChain());
            }
            String brandCode = userPreferences.getChain();
            String languageCode = userPreferences.getLangCode();
            PortletPreferences portletPreferences = renderRequest.getPreferences();
            boolean isLangEnabled = false;
            boolean isBrandEnabled = false;
            boolean hasEditPermission = false;

            if (Validator.isNotNull(portletPreferences.getValue(IS_BRAND_SPECIFIC, StringPool.BLANK)))
            {
                isBrandEnabled = Boolean.parseBoolean(portletPreferences.getValue(IS_BRAND_SPECIFIC, "true"));
                renderRequest.setAttribute(IS_BRAND_SPECIFIC, isBrandEnabled);
            }
            if (Validator.isNotNull(portletPreferences.getValue(IS_LANG_SPECIFIC, "")))
            {
                isLangEnabled = Boolean.parseBoolean(portletPreferences.getValue(IS_LANG_SPECIFIC, "true"));
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("isLangEnabled :" + isLangEnabled);
            }
            long categoryId = contentApplication.getAssetCategoryId(themeDisplay.getScopeGroupId(), languageCode, false);
            long brandCategoryId = 0l;
            if (isBrandEnabled)
            {
                brandCategoryId = contentApplication.getAssetCategoryId(themeDisplay.getScopeGroupId(), brandCode, true);
            }
            long resourcePrimkey = contentApplication.getArticleResourcePrimaryKey(portletPreferences, categoryId,
                    brandCategoryId);
            renderRequest.setAttribute("resourcePrimkey",
                    contentApplication.getArticleResourcePrimaryKey(portletPreferences, categoryId, brandCategoryId));
            try
            {
                renderRequest.setAttribute("article", JournalArticleLocalServiceUtil.getLatestArticle(resourcePrimkey));
                hasEditPermission = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(),
                        themeDisplay.getScopeGroupId(), BrandStandardsConstant.ROLE_EDIT_ARTICLE);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("hasEditPermission :" + hasEditPermission);
                }
            }
            catch (PortalException e)
            {
                LOG.error(e.getMessage(), e);
            }
            catch (SystemException e)
            {
                LOG.error(e.getMessage(), e);
            }
            String environment = portletPreferences.getValue("environment", BrandStandardsConstant.ENVIRONMENT_PROD);

            renderRequest.setAttribute("contentEnvironmentVal", environment);
            renderRequest.setAttribute("hasEditPermission", hasEditPermission);
            renderRequest.setAttribute("brand", brandCode);
            renderRequest.setAttribute("countryCode", userPreferences.getCountry());
            renderRequest.setAttribute("langCode", languageCode);
            setUIElementLabels(renderRequest, obsmLanguageUtil);
            if (LOG.isDebugEnabled())
            {
                LOG.debug("resourcePrimkey ::" + resourcePrimkey);
            }
        }
        super.doView(renderRequest, renderResponse);
    }

    @Override
    public void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        setCustomPreferences(actionRequest, actionResponse);
    }

    /**
     * @param actionRequest This is for actionRequest
     * @param actionResponse This is for actionResponse
     */
    public void setCustomPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        String isBrandSpecific = actionRequest.getParameter(IS_BRAND_SPECIFIC);
        String isLangSpecific = actionRequest.getParameter("isLanguageSpecific");
        String structureId = actionRequest.getParameter(ARTICLE_TYPE);
        String environment = actionRequest.getParameter("contentEnvironment");

        PortletPreferences preferences = actionRequest.getPreferences();
        try
        {
            preferences.setValue(IS_BRAND_SPECIFIC, isBrandSpecific);
            preferences.setValue(IS_LANG_SPECIFIC, isLangSpecific);
            preferences.setValue(ARTICLE_TYPE, structureId);
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

    public void setUIElementLabels(PortletRequest portletRequest, BSLanguageUtil obsmLanguageUtil)
    {
        portletRequest.setAttribute("playLabel", obsmLanguageUtil.get("bs.play"));
        portletRequest.setAttribute("downloadLabel", obsmLanguageUtil.get("bs.download"));
        portletRequest.setAttribute("downloadVideoLabel", obsmLanguageUtil.get("bs.download.video"));
        portletRequest.setAttribute("videoLabel", obsmLanguageUtil.get("bs.video"));
        portletRequest.setAttribute("documentLabel", obsmLanguageUtil.get("bs.document"));
        portletRequest.setAttribute("closeLabel", obsmLanguageUtil.get("bs.close"));
        portletRequest.setAttribute("searchStandardLabel", obsmLanguageUtil.get("bs.search.standard"));
        portletRequest.setAttribute("transcriptLabel", obsmLanguageUtil.get("bs.transcript"));
    }
}
