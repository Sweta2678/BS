/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.NoSuchPublicationException;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.me2.brandstandards.custom.application.StandardsListApplication;
import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="StandardsListPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class WhatChangedOnPortlet extends SearchMVCPortlet
{
    private static final String PREV_PUBLISH_ID = "prevPublishId";
    private static final String SEL_PUBLISH_ID = "selPublishId";
    private static final String ARL_WCO_STANDARDS = "arlWCOStandards";
    private static final String ENVIRONMENT = "environmentVal";
    private static final Log LOG = LogFactoryUtil.getLog(WhatChangedOnPortlet.class);

    /**
     * @param renderRequest Portlet RenderRequest object
     * @param renderResponse Portlet RenderResponse object
     * @throws IOException throws Input Output Exception
     * @throws PortletException throws Portlet Exception
     */
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        String environment = renderRequest.getPreferences().getValue(ENVIRONMENT, BrandStandardsConstant.ENVIRONMENT_PROD);
        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        HttpSession session = getHttpSession(httpRequest);
        StandardsSearchCriteria criteria = null;
        String chainCode = "";
        String countryCode = "";
        String langCode = "";
        String previousTextParam = "N";
        String highlightParam = "Y";
        String showCmplyParam = "Y";
    	String showLifecycleParam = "Y";
        int noOfPages = 1;
        int noOfRecords = 1;
        int pageNumber = 1;
        int recordsPerPage = 25;
        boolean isSearch = false;
        String displayMessage = "";
        List<Standard> arlDisplayList = new ArrayList<Standard>();
        List<Standard> arlStandards = new ArrayList<Standard>();
        StandardsListApplication standApp = new StandardsListApplication();
        String selPublishId = httpRequest.getParameter(SEL_PUBLISH_ID);
        String prevPublishId = httpRequest.getParameter(PREV_PUBLISH_ID);
        Publication selectedPublish = null;
        Publication previousPublish = null;
        UserPreferencesApplication userPrefApp = new UserPreferencesApplication();

        try
        {
            if (selPublishId != null && !selPublishId.isEmpty() && prevPublishId != null && !prevPublishId.isEmpty())
            {
                session.setAttribute(SEL_PUBLISH_ID, selPublishId);
                session.setAttribute(PREV_PUBLISH_ID, prevPublishId);
            }
            else
            {
                if (session.getAttribute(SEL_PUBLISH_ID) != null)
                {
                    selPublishId = (String) session.getAttribute(SEL_PUBLISH_ID);
                }
                else
                {
                    selPublishId = "0";
                }

                if (session.getAttribute(PREV_PUBLISH_ID) != null)
                {
                    prevPublishId = (String) session.getAttribute(PREV_PUBLISH_ID);
                }
                else
                {
                    prevPublishId = "0";
                }
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("publish data from request/session::: selPublishId:" + selPublishId + ":::prevPublishId:"
                        + prevPublishId);
            }

            AccessAndPreferences accessAndPref = (AccessAndPreferences) session.getAttribute(USER_PREFERENCES);
            if (session.getAttribute(ARL_WCO_STANDARDS) != null)
            {
                arlStandards = (ArrayList<Standard>) session.getAttribute(ARL_WCO_STANDARDS);
            }

            if (arlStandards == null)
            {
                arlStandards = new ArrayList<Standard>();
            }

            if (session.getAttribute(WHAT_CHANGED_CRITERIA) != null)
            {
                criteria = (StandardsSearchCriteria) session.getAttribute(WHAT_CHANGED_CRITERIA);
                isSearch = true;
            }
            else
            {
                criteria = new StandardsSearchCriteria(httpRequest, accessAndPref != null ? accessAndPref.getLangCode() : null);
                criteria.setFilterByNew(true);
                criteria.setFilterByTextUpdate(true);
                criteria.setFilterByComplianceUpdate(true);
                criteria.setFilterByLifecycleUpdate(true);
                criteria.setFilterByRemoved(true);
                criteria.setScope(WCO);
                session.setAttribute(WHAT_CHANGED_CRITERIA, criteria);
                isSearch = false;
            }

            if (Validator.isNotNull(httpRequest.getParameter("previousText")))
            {
            	previousTextParam = httpRequest.getParameter("previousText");
            	LOG.info("Selected previous text val ::: "+previousTextParam);
            }
            if (Validator.isNotNull(httpRequest.getParameter("highlight")))
            {
                highlightParam = httpRequest.getParameter("highlight");
            }
            if (Validator.isNotNull(httpRequest.getParameter("showCmplyParam")))
            {
            	showCmplyParam = httpRequest.getParameter("showCmplyParam");
            }
            if (Validator.isNotNull(httpRequest.getParameter("showLifecycleParam")))
            {
            	showLifecycleParam = httpRequest.getParameter("showLifecycleParam");
            }

            if (httpRequest.getParameter("pageNumber") != null && httpRequest.getParameter("itemsPerPage") != null)
            {
                pageNumber = Integer.parseInt(httpRequest.getParameter("pageNumber"));
                recordsPerPage = Integer.parseInt(httpRequest.getParameter("itemsPerPage"));
            }
            else if (accessAndPref != null && accessAndPref.getRecordsPerWCOPage() != 0)
            {
                pageNumber = 1;
                recordsPerPage = accessAndPref.getRecordsPerWCOPage();
            }
            else
            {
                pageNumber = 1;
                recordsPerPage = 25;
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Page Number:" + pageNumber + " RecordsPerPage:" + recordsPerPage);
            }
            /** Saving the Pagination information in session & in User Preferences */
            if (Validator.isNotNull(accessAndPref) && recordsPerPage != accessAndPref.getRecordsPerWCOPage())
            {
                accessAndPref.setRecordsPerWCOPage(recordsPerPage);
                session.setAttribute(USER_PREFERENCES, accessAndPref);
            }

            if (accessAndPref != null)
            {
                chainCode = accessAndPref.getChain();
                countryCode = accessAndPref.getCountry();
                langCode = accessAndPref.getLangCode();
            }
            else
            {
                UserPreference userPreferences = userPrefApp.getUserPreferences(user.getUserId());
                if (userPreferences != null)
                {
                    chainCode = userPreferences.getChainCode();
                    countryCode = userPreferences.getCountryCode();
                    langCode = userPreferences.getLangCode();
                }
            }
            /** Setting the Publication to the recent publication if publication parameters are not found */
            try
            {
                if ("0".equals(selPublishId))
                {
                    List<Publication> publications = PublicationLocalServiceUtil.getWhatChangedOnNavigation(chainCode, environment);
                    if (publications != null && publications.size() > 0)
                    {
                        selPublishId = publications.get(0).getPublishId() + "";
                        if (publications.size() > 1)
                        {
                            prevPublishId = publications.get(1).getPublishId() + "";
                        }
                        else
                        {
                            prevPublishId = "-1";
                        }
                    }
                    else
                    {
                        selPublishId = "-1";
                        prevPublishId = "-1";
                    }
                } else if("0".equals(prevPublishId))
                {
                    prevPublishId = "-1";
                }
                selectedPublish = PublicationLocalServiceUtil.getPublication(Long.parseLong(selPublishId));
                previousPublish = PublicationLocalServiceUtil.getPublication(Long.parseLong(prevPublishId));
            }
            catch (NoSuchPublicationException e)
            {
                LOG.error(e.getMessage());
            }
            catch (Exception e)
            {
                LOG.error(e);
            }

            if (arlStandards.isEmpty() || pageNumber == 1 || isSearch)
            {
                if (criteria.isFilterByNew() || criteria.isFilterByUpdated() || criteria.isFilterByTextUpdate() 
                		|| criteria.isFilterByComplianceUpdate() || criteria.isFilterByLifecycleUpdate() || criteria.isFilterByRemoved())
                {
                    Map<String, List> standardsMap = standApp.getStandardsForWhatChangedOn(langCode, chainCode, countryCode,
                            criteria, user.getUserId(), selPublishId, prevPublishId, environment);
                    session.setAttribute(SEL_PUBLISH_ID, selPublishId);
                    session.setAttribute(PREV_PUBLISH_ID, prevPublishId);
                    arlStandards = (List<Standard>) standardsMap.get("displayStandards");
                }
            }

            noOfRecords = arlStandards.size();
            criteria.setResultCount(noOfRecords);
            noOfPages = noOfRecords / recordsPerPage;
            noOfPages = noOfPages + 1;
            int startIndex = (pageNumber - 1) * recordsPerPage;
            int toIndex = 0;
            toIndex = startIndex + recordsPerPage;
            if (noOfRecords < toIndex)
            {
                toIndex = noOfRecords;
            }

            arlDisplayList = arlStandards.subList(startIndex, toIndex);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }

        renderRequest.setAttribute("displayList", arlDisplayList);
        renderRequest.setAttribute("noOfPages", noOfPages);
        renderRequest.setAttribute("pageNumber", pageNumber);
        renderRequest.setAttribute("recordsPerPage", recordsPerPage);
        renderRequest.setAttribute("previousTextParam", previousTextParam);
        renderRequest.setAttribute("highlightParam", highlightParam);
        renderRequest.setAttribute("showCmplyParam", showCmplyParam);
        renderRequest.setAttribute("showLifecycleParam", showLifecycleParam);
        
        BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(renderRequest, langCode, "OBSM");
        
        if (isSearch)
        {
            displayMessage = BrandStandardsUtil.getSearchResultMessage(criteria, langCode, noOfRecords, obsmLanguageUtil);
        }
        else
        {
            displayMessage = obsmLanguageUtil.get("bs.search.result.nosearchactive.msg");
        }
        setSearchScreenLabels(renderRequest, obsmLanguageUtil, langCode, "WCO");
        renderRequest.setAttribute(SEARCH_RESULTS_MSG, displayMessage);
        renderRequest.setAttribute("isSearchActive", isSearch);
        session.setAttribute(ARL_WCO_STANDARDS, arlStandards);

        if (selectedPublish != null)
        {
            renderRequest.setAttribute("currPublicationDate",
                    BrandStandardsUtil.getFormatedDate(selectedPublish.getPublishDate(), langCode, obsmLanguageUtil));
            if(BrandStandardsConstant.PUBLISHED_RECORD_STATUS.equals(selectedPublish.getPublishStatCd()) 
            		&& arlDisplayList != null && arlDisplayList.size() > 0) {
            	renderRequest.setAttribute("isActivePublish", true);
            } else {
            	renderRequest.setAttribute("isActivePublish", false);
            }
        }

        if (previousPublish != null)
        {
            renderRequest.setAttribute("prevPublicationDate",
                    BrandStandardsUtil.getFormatedDate(previousPublish.getUpdatedDate(), langCode, obsmLanguageUtil));
        }

        /** Setting search text or search standard id to highlight */
        setSearchHighlight(renderRequest, criteria);

        renderRequest.setAttribute("hotelCode", chainCode);
        renderRequest.setAttribute("languageCode", langCode);
        renderRequest.setAttribute("countryCode", countryCode);
        renderRequest.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
        session.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
        
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/whatChangedOn/view.jsp");
        dispatcher.include(renderRequest, renderResponse);
    }

    /**
     * This method will set the search terms or standards id to be highlighted.
     * 
     * @param renderRequest Portlet RenderRequest object
     * @param criteria The StandardsSearchCriteria object
     */
    public void setSearchHighlight(RenderRequest renderRequest, StandardsSearchCriteria criteria)
    {
        StringBuilder searchTextsHighlight = new StringBuilder();
        StringBuilder searchIdsHighlight = new StringBuilder();
        if (criteria != null)
        {
            List<String> searchCriteriaTexts = criteria.getSearchCriteria();
            List<String> searchCriteriaIds = criteria.getIdSearchCriteria();

            if (searchCriteriaTexts != null)
            {
                for (int i = 0; i < searchCriteriaTexts.size(); i++)
                {
                    String criterias = searchCriteriaTexts.get(i);
                    if (i == 0)
                    {
                        searchTextsHighlight.append("'");
                        searchTextsHighlight.append(criterias);
                        searchTextsHighlight.append("'");
                        //searchTextsHighlight = "'" + criterias + "'";
                    }
                    else
                    {
                        searchTextsHighlight.append(",'");
                        searchTextsHighlight.append(criterias);
                        searchTextsHighlight.append("'");
                        //searchTextsHighlight = searchTextsHighlight + ",'" + criterias + "'";
                    }
                }
            }
            if (searchCriteriaIds != null)
            {
                for (int i = 0; i < searchCriteriaIds.size(); i++)
                {
                    String criterias = searchCriteriaIds.get(i);
                    if (i == 0)
                    {
                        searchTextsHighlight.append("'");
                        searchTextsHighlight.append(criterias);
                        searchTextsHighlight.append("'");
                        //searchIdsHighlight = "'" + criterias + "'";
                    }
                    else
                    {
                        searchTextsHighlight.append(",'");
                        searchTextsHighlight.append(criterias);
                        searchTextsHighlight.append("'");
                        //searchIdsHighlight = searchIdsHighlight + ",'" + criterias + "'";
                    }
                }
            }
        }
        renderRequest.setAttribute("highlightSearchTexts", searchTextsHighlight.toString());
        renderRequest.setAttribute("searchCriteriaType", criteria.getTextSearchType());
        renderRequest.setAttribute("highlightSearchIds", searchIdsHighlight.toString());
    }

    /**
     * @param resourceRequest Portlet ResourceRequest Object
     * @param resourceResponse Portlet ResourceResponse Object
     */
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
    	AccessAndPreferences accessPrefs = getUserPreferences(resourceRequest);
        String modalType = resourceRequest.getParameter("modalType");
        resourceRequest.setAttribute("hotelCode", accessPrefs.getChain());
        resourceRequest.setAttribute("languageCode", accessPrefs.getLangCode());
        resourceRequest.setAttribute("countryCode", accessPrefs.getCountry());
        
        processResourceRendering(resourceRequest, resourceResponse, accessPrefs, "WCO", modalType);
    }

    /**
     * @param actionRequest Portlet ActionRequest Object
     * @param actionResponse Portlet ActionResponse Object
     * @throws IOException throws IOException
     * @throws PortletException throws Portlet Exception
     */
    @ProcessAction(name = "searchStandards")
    public void searchStandards(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession session = getHttpSession(request);
        AccessAndPreferences userPreferences = getUserPreferences(actionRequest);
        StandardsSearchCriteria criteria = null;
        session.removeAttribute(WHAT_CHANGED_CRITERIA);
        session.removeAttribute(ARL_WCO_STANDARDS);

        criteria = new StandardsSearchCriteria(request, userPreferences.getLangCode());
        criteria.setScope(WCO);
        session.setAttribute(WHAT_CHANGED_CRITERIA, criteria);
        String publicUrl = themeDisplay.getPathFriendlyURLPublic();
        String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
        String url = publicUrl + "/brand-standards" + friendlyUrl;
        actionResponse.sendRedirect(url);
    }

    /**
     * @param actionRequest Portlet ActionRequest Object
     * @param actionResponse Portlet ActionResponse Object
     * @throws IOException throws IOException
     * @throws PortletException throws PortletException
     */
    @ProcessAction(name = "clearSearchAction")
    public void clearSearchAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
            PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession session = getHttpSession(request);

        session.removeAttribute(WHAT_CHANGED_CRITERIA);
        session.removeAttribute(ARL_WCO_STANDARDS);
        String publicUrl = themeDisplay.getPathFriendlyURLPublic();
        String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
        String url = publicUrl + "/brand-standards" + friendlyUrl;
        actionResponse.sendRedirect(url);
    }

    /**
     * @param renderRequest Portlet RenderRequest Object
     * @param renderResponse Portlet RenderResponse Object
     * @throws IOException throws IOException
     * @throws PortletException throws PortletException
     */
    @Override
    public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        PortletPreferences preferences = renderRequest.getPreferences();
        renderRequest.setAttribute(ENVIRONMENT, preferences.getValue(ENVIRONMENT, StringPool.BLANK));
        super.doEdit(renderRequest, renderResponse);
    }

    /**
     * @param actionRequest Portlet ActionRequest Object
     * @param actionResponse Portlet ActionResponse Object
     */
    public void setCustomPreferences(ActionRequest actionRequest, ActionResponse actionResponse)
    {
        String environment = actionRequest.getParameter("environment");
        PortletPreferences preferences = actionRequest.getPreferences();
        try
        {
            preferences.setValue(ENVIRONMENT, environment);
            preferences.store();
            actionResponse.setPortletMode(PortletMode.VIEW);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

}
