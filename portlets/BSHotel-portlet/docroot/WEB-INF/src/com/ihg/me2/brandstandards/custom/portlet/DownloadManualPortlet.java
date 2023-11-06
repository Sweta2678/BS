/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishedPdfList;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.me2.brandstandards.custom.application.DownloadManual;
import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.util.ApplicationUtil;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

/**
 * <a href="DownloadManualPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 */
public class DownloadManualPortlet extends BrandStandardsPortlet
{

    private static final String ARTICLE_TYPE = "articleType";
    private static final Log LOG = LogFactoryUtil.getLog(DownloadManualPortlet.class);
    private static final String ENVIRONMENT = "environmentVal";

    /**
     * @param renderRequest This is a RenderRequest object
     * @param renderResponse This is a RenderResponse object
     * @throws IOException It throws IOException
     * @throws PortletException It throws PortletException
     */
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        AccessAndPreferences userPreferences = getUserPreferences(renderRequest);
        
        if (userPreferences != null)
        {
            BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(renderRequest, userPreferences.getLangCode(), "OBSM");
            String brandCode = userPreferences.getChain();
            String countryCode = userPreferences.getCountry();
            String languageCode = userPreferences.getLangCode();
            List<String> buildTypes = new ArrayList<String>(); 
            String paperSize = BrandStandardsConstant.MANUAL_A4_PORTRAIT;
            boolean hasEditPermission = false;
            if (BrandStandardsConstant.USER_COUNTRY_CODE.equalsIgnoreCase(countryCode))
            {
                paperSize = BrandStandardsConstant.MANUAL_LETTER_PORTRAIT;
            }
            DownloadManual manual = ApplicationUtil.getDownloadManualObject();
            long categoryId = manual.getAssetCategoryId(themeDisplay.getScopeGroupId(), languageCode, false);
            //long categoryId = 43203 ;
            String environment = renderRequest.getPreferences().getValue(ENVIRONMENT, BrandStandardsConstant.ENVIRONMENT_PROD);
            
            if (LOG.isDebugEnabled())
            {
                LOG.debug("category ID :" + categoryId + " Brand Code :" + brandCode + " Environment :" + environment);
            }
            Publication publishObj = manual.getCurrentBrandPublishedObject(brandCode, environment,
                    BrandStandardsConstant.PUBLISHED_RECORD_STATUS);
            
            long resourcePrimkey = manual.getArticleResourcePrimaryKey(renderRequest.getPreferences(), categoryId, 0l); 
            //long resourcePrimkey = 43303;
            renderRequest.setAttribute("resourcePrimkey", resourcePrimkey);
            renderRequest.setAttribute("brand", brandCode);
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

            if (Validator.isNotNull(publishObj))
            {
                long publishId = publishObj.getPublishId();
                Date publishDate = publishObj.getPublishDate();
                String publishContentType = publishObj.getPublishContentType();

                //Get Build Type from publish contentType
                if (Validator.isNotNull(publishContentType))
                {
	                if (publishContentType.indexOf("_") > 0)
	                {
	                    buildTypes = new LinkedList<String>(Arrays.asList(publishContentType.split("_")));
	                } 
	                else 
	                {
	                	buildTypes.add(publishContentType);
	                }

                }
                buildTypes.add("FULL_MANUAL");
                Collections.reverse(buildTypes);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("publish Id:" + publishObj.getPublishId());
                    LOG.debug("bs_last_published :" + obsmLanguageUtil.get("bs.last.publish"));
                    LOG.debug("language :" + languageCode);
                    LOG.debug("country code :" + countryCode);
                    LOG.debug("build Type :" + buildTypes);
                    LOG.debug("paper size :" + paperSize);
                }
                renderRequest.setAttribute("publishMsg", obsmLanguageUtil.get("bs.last.publish"));
                renderRequest.setAttribute("downloadMsg", obsmLanguageUtil.get("bs.download"));
                renderRequest.setAttribute("languageMsg", obsmLanguageUtil.get("bs.language"));
                renderRequest.setAttribute("fullManualMsg", obsmLanguageUtil.get("bs.fullManual"));
                if (Validator.isNotNull(languageCode))
                {
                    renderRequest.setAttribute("langCode", languageCode);
                    renderRequest.setAttribute("langName", LocaleUtil.fromLanguageId(languageCode).getDisplayName());
                }
                if (publishDate != null)
                {
                    String dateValue = BrandStandardsUtil.getFormatedDate(publishDate, languageCode, obsmLanguageUtil);
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("published date :::" + dateValue);
                    }
                    renderRequest.setAttribute("publishDate", dateValue);
                }

                renderRequest.setAttribute("countryCode", countryCode);
                renderRequest.setAttribute("hasEditPermission", hasEditPermission);
                Map<String, LinkedHashMap<String,String>> staticManuals = manual.getStaticManuals(publishId, countryCode, buildTypes, paperSize);
                List<String> buildTypesList = new ArrayList<String>();
                for(Map.Entry<String,LinkedHashMap<String,String>> entry : staticManuals.entrySet())
                {
                    for(String key :  entry.getValue().keySet())
                    {
                        buildTypesList.add(key);
                    }
                    
                }
                Map<String, LinkedHashMap<String,String>> filteredManuals = null;
                UserPreferencesApplication userPreferenceApp = new UserPreferencesApplication();
                List<StandardsLocale> supportedLanguages = null;
                try
                {
                    supportedLanguages = userPreferenceApp.getLanguagesPerBrandCountry(brandCode, countryCode, environment);
                }
                catch (Exception e)
                {
                    LOG.error(e.getMessage(), e);
                }
                if (Validator.isNotNull(staticManuals) && supportedLanguages != null)
                {

                    filteredManuals = getFilteredManuals(supportedLanguages, staticManuals);
                }
                if (Validator.isNotNull(filteredManuals) && filteredManuals.size() > 0)
                {

                    renderRequest.setAttribute("staticManuals", filteredManuals);
                    renderRequest.setAttribute("jsonStaticManuals",JSONFactoryUtil.serialize(filteredManuals));
                    renderRequest.setAttribute("buildTypesList", buildTypesList);
                }
                else
                {
                    renderRequest.setAttribute("noManuals", obsmLanguageUtil.get("bs.no.manuals.msg"));
                }
            }
            else
            {
                renderRequest.setAttribute("noManuals", obsmLanguageUtil.get("bs.no.manuals.msg"));
            }
        }
        super.doView(renderRequest, renderResponse);
    }

    /**
     * @param languages List of BsLocale
     * @param fullManuals Map of String
     * @return Map<String, String>
     */
    private Map<String, LinkedHashMap<String,String>> getFilteredManuals(List<StandardsLocale> languages, Map<String, LinkedHashMap<String,String>> fullManuals)
    {
    	Map<String, LinkedHashMap<String,String>> filteredManuals = new LinkedHashMap<String, LinkedHashMap<String,String>>();
        for (StandardsLocale language : languages)
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("supported locales :::" + language.getLocaleCode());	
            }
            if (fullManuals.containsKey(language.getLocaleCode()))
            {
                filteredManuals.put(language.getLocaleCode(), fullManuals.get(language.getLocaleCode()));
            }
        }

        return filteredManuals;
    }

    /**
     * @param resourceRequest This is a RenderRequest object
     * @param resourceResponse This is a RenderResponse object
     */
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
    	AccessAndPreferences userPreferences = getUserPreferences(resourceRequest);
        if (userPreferences != null)
        {
            String brandCode = userPreferences.getChain();
            String countryCode = userPreferences.getCountry();
            String langCode = StringPool.BLANK + resourceRequest.getAttribute("langCode");
            String buildType = userPreferences.getBuildType();
            String paperSize = userPreferences.getPaperSize();
            DownloadManual manual = ApplicationUtil.getDownloadManualObject();
            Publication publishObj = manual.getCurrentBrandPublishedObject(brandCode, BrandStandardsConstant.ENVIRONMENT_PROD,
                    BrandStandardsConstant.PUBLISHED_RECORD_STATUS);
            if (publishObj != null)
            {
                PublishedPdfList pdfList = manual.getPublishedPDF(publishObj.getPublishId(), countryCode, langCode, buildType,
                        paperSize);
                resourceResponse.setCharacterEncoding("UTF-8");
                resourceResponse.setContentType("application/text");
                try
                {
                    if (pdfList != null)
                    {
                        resourceResponse.getWriter().write(pdfList.getPdfFileURLText());
                    }
                }
                catch (IOException e)
                {
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * @param renderRequest This is a RenderRequest object
     * @param renderResponse This is a RenderResponse object
     * @throws IOException It throws IOException
     * @throws PortletException It throws PortletException
     */
    @Override
    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        DownloadManual manual = ApplicationUtil.getDownloadManualObject();
        PortletPreferences preferences = renderRequest.getPreferences();
        renderRequest.setAttribute(ARTICLE_TYPE, preferences.getValue(ARTICLE_TYPE, ""));
        renderRequest.setAttribute("structureList", manual.getStructureList(themeDisplay.getScopeGroupId()));
        renderRequest.setAttribute(ENVIRONMENT, preferences.getValue(ENVIRONMENT, StringPool.BLANK));
        super.doEdit(renderRequest, renderResponse);
    }

    /**
     * @param actionRequest This is a ActionRequest object
     * @param actionResponse This is a ActionResponse object
     */
    public void setCustomPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        String structureId = actionRequest.getParameter(ARTICLE_TYPE);
        String environment = actionRequest.getParameter("environment");
        PortletPreferences preferences = actionRequest.getPreferences();
        try
        {
            preferences.setValue(ARTICLE_TYPE, structureId);
            preferences.setValue(ENVIRONMENT, environment);
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

}
