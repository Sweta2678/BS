/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.custom.model.StdImage;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.me2.brandstandards.custom.application.AttachmentsApplication;
import com.ihg.me2.brandstandards.custom.application.StandardsListApplication;
import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.pojo.StandardsDisplayOptions;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.brandstandards.custom.util.ApplicationUtil;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.ihg.me2.brandstandards.custom.util.QueryUtils;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
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
 * @author Niranjan Khandekar
 */
public class StandardsListPortlet extends SearchMVCPortlet
{
	protected static final String ARL_STANDARDS = "arlStandards";
    private static final Log LOG = LogFactoryUtil.getLog(StandardsListPortlet.class);
    private UserPreferencesApplication userPrefApp = new UserPreferencesApplication();

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        String environment = renderRequest.getPreferences().getValue(ENVIRONMENT, BrandStandardsConstant.ENVIRONMENT_PROD);
        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        HttpSession session = getHttpSession(httpRequest);
        StandardsSearchCriteria criteria = null;
        StandardsDisplayOptions displayOptions = null;
        String chainCode = "";
        String countryCode = "";
        String langCode = "";
        int noOfPages = 1;
        int noOfRecords = 1;
        int pageNumber = 1;
        int recordsPerPage = 25;
        boolean isSearch = false;
        String displayMessage = "";
        List<Standard> arlDisplayList = new ArrayList<Standard>();
        List<Long> standardIdsOfSearch = new ArrayList<Long>();
        List<Standard> arlStandards = new ArrayList<Standard>();
        List<Long> allReferencedIds = new ArrayList<Long>();
        StandardsListApplication standApp = new StandardsListApplication();
        //Auto Open Search options if User is coming from Home page and if no search criteria is available
        showSearchOptionsPopup(renderRequest, user, httpRequest, standApp);
        boolean isNew = false;
        String contentType = StringPool.BLANK;
        try
        {
            AccessAndPreferences userprefs = (AccessAndPreferences) session.getAttribute(USER_PREFERENCES);
            UserPreference userPreferences = userPrefApp.getUserPreferences(user.getUserId());
            arlStandards = (ArrayList<Standard>) session.getAttribute(ARL_STANDARDS);
            LOG.info("the value of environment in portlet is " + environment);
            if (arlStandards == null)
            {
                arlStandards = new ArrayList<Standard>();

            }

            if (session.getAttribute(SEARCH_CRITERIA) != null)
            {
                criteria = (StandardsSearchCriteria) session.getAttribute(SEARCH_CRITERIA);
                isSearch = true;
            }
            else
            {
                criteria = standApp.getUserSearchCriteria(user.getUserId());
                if (criteria != null)
                {
                    session.setAttribute(SEARCH_CRITERIA, criteria);
                    isSearch = true;
                }
                else
                {
                    criteria = new StandardsSearchCriteria(httpRequest, userPreferences.getLangCode());
                    isSearch = false;
                }
                if(criteria != null){
                	criteria.setScope(SEARCH_STANDARDS);
                }
            }
            if (session.getAttribute(DISPLAY_OPTIONS) == null)
            {
                displayOptions = standApp.getUserDisplayOptions(user.getUserId());
                if (displayOptions == null)
                {
                    displayOptions = new StandardsDisplayOptions(httpRequest);
                }
                session.setAttribute(DISPLAY_OPTIONS, displayOptions);
            }

            if (userprefs != null)
            {
                chainCode = userprefs.getChain();
                countryCode = userprefs.getCountry();
                langCode = userprefs.getLangCode();
            }
            else
            {
                //buildTye = userPreferences.getBuildType();
                chainCode = userPreferences.getChainCode();
                countryCode = userPreferences.getCountryCode();
                langCode = userPreferences.getLangCode();
            }

            if (httpRequest.getParameter("pageNumber") != null && httpRequest.getParameter("itemsPerPage") != null)
            {
                pageNumber = Integer.parseInt(httpRequest.getParameter("pageNumber"));
                recordsPerPage = Integer.parseInt(httpRequest.getParameter("itemsPerPage"));
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("records :" + recordsPerPage);
                }
                //  userprefs.setRecordsPerPage(recordsPerPage);
                //userprefs.setPageNumber(pageNumber);
            }
            else if (Validator.isNotNull(userprefs) && userprefs.getRecordsPerPage() != 0)
            {
                pageNumber = 1;
                recordsPerPage = userprefs.getRecordsPerPage();
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("records from accesspref object:" + recordsPerPage);
                }
            }
            else if (Validator.isNotNull(userPreferences) && Validator.isNotNull(userPreferences.getItemsPerPage())
                    && !String.valueOf(0).equalsIgnoreCase(userPreferences.getItemsPerPage()))
            {
                pageNumber = 1;
                recordsPerPage = Integer.parseInt(userPreferences.getItemsPerPage());
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("records from userprefs object:" + recordsPerPage);
                }
            }
            else
            {
                pageNumber = 1;
                recordsPerPage = 25;
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("default recordsperpage count:" + recordsPerPage);
                }
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("recordsPerPage :" + recordsPerPage);
            }
            if (Validator.isNotNull(userprefs) && recordsPerPage != userprefs.getRecordsPerPage())
            {
                userprefs.setRecordsPerPage(recordsPerPage);
                session.setAttribute(USER_PREFERENCES, userprefs);
            }
            if (!String.valueOf(recordsPerPage).equalsIgnoreCase(userPreferences.getItemsPerPage()))
            {
                userPreferences.setItemsPerPage(String.valueOf(recordsPerPage));
                userPrefApp.addOrUpdateUserPreferences(userPreferences, isNew);
            }
            
            long publishId = 0L;
            //set publish content type 
            Publication publish = PublicationLocalServiceUtil.getPublishObjectByBrand(chainCode, environment, BrandStandardsConstant.PUBLISHED_RECORD_STATUS);
            if(publish != null)
            {
                 contentType = publish.getPublishContentType();
                 publishId = publish.getPublishId();
            }
            else
            {
                LOG.error("Null pointer thrown by Publish object");
            }
            
            if (arlStandards.isEmpty() || pageNumber == 1 || isSearch)
            {
                Map<String, List<?>> standardsMap = standApp.getStandardsByBrandAndCountry(publishId, langCode, chainCode, countryCode,
                        criteria, user.getUserId(), environment);
                arlStandards = (List<Standard>) standardsMap.get("displayStandards");
                standardIdsOfSearch = (List<Long>) standardsMap.get(STANDARD_IDS_OF_SEARCH);
                allReferencedIds = (List<Long>) standardsMap.get("allReferencedIds");
                if (LOG.isDebugEnabled()) {
                    LOG.debug("refrence ids :"+allReferencedIds);
                }
                /*if (isSearch)
                {
                    matchedStandardIds = (List<Long>) standardsMap.get("matchedStandards");
                }*/
            }

            noOfRecords = arlStandards.size();
            criteria.setResultCount(noOfRecords);
            session.setAttribute("resultCount", noOfRecords);
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
        catch (SystemException se)
        {
            LOG.error(se.getMessage(), se);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
        BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(renderRequest, langCode, "OBSM");
        renderRequest.setAttribute("displayList", arlDisplayList);
        // remove attribute from session first
        removeAttribute(renderRequest, "BS_stdIds");
        renderRequest.setAttribute("supportingMaterialTitle", obsmLanguageUtil.get("bs.supprting.material"));
        renderRequest.setAttribute("allSupportingMaterialTitle", obsmLanguageUtil.get("bs.all.supprting.material"));
        renderRequest.setAttribute("viewDetailsLink", obsmLanguageUtil.get("bs.view.details"));
        renderRequest.setAttribute("createPDFLabel", obsmLanguageUtil.get("bs.createpdf"));
        renderRequest.setAttribute("viewDetails", obsmLanguageUtil.get("bs.details"));
        renderRequest.setAttribute("noOfPages", noOfPages);
        renderRequest.setAttribute("pageNumber", pageNumber);
        renderRequest.setAttribute("recordsPerPage", recordsPerPage);
        renderRequest.setAttribute("hotelCode", chainCode);
        renderRequest.setAttribute("languageCode", langCode);
        renderRequest.setAttribute("countryCode", countryCode);
        renderRequest.setAttribute("referencedIds", obsmLanguageUtil.get("bs.pdf.xref.label"));
        renderRequest.setAttribute("referenceTitle", obsmLanguageUtil.get("bs.std.reference.label"));
        renderRequest.setAttribute("expiresTxt", obsmLanguageUtil.get("bs.pdf.expires"));
        renderRequest.setAttribute("contentType", contentType);
        if (isSearch)
        {
            renderRequest.setAttribute(SHOW_SEARCH_RESULTS_MSG, true);
            displayMessage = BrandStandardsUtil.getSearchResultMessage(criteria, langCode, noOfRecords, obsmLanguageUtil);
        }
        else
        {
            renderRequest.setAttribute(SHOW_NO_SEARCH_ACTIVE_MSG, true);
            renderRequest.setAttribute(SHOW_SEARCH_RESULTS_MSG, false);
            displayMessage = obsmLanguageUtil.get("bs.search.result.nosearchactive.msg");
        }
        setSearchScreenLabels(renderRequest, obsmLanguageUtil, langCode, "SS");
        renderRequest.setAttribute(SEARCH_RESULTS_MSG, displayMessage);
        renderRequest.setAttribute("isSearchActive", isSearch);
        session.setAttribute(ARL_STANDARDS, arlStandards);
        if(standardIdsOfSearch != null && !standardIdsOfSearch.isEmpty())
        {
            //merge reference ids here
            standardIdsOfSearch.addAll(allReferencedIds);
            session.setAttribute(STANDARD_IDS_OF_SEARCH, standardIdsOfSearch.toString().replaceAll("([\\[\\]])", ""));
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Search Standard Ids:" + standardIdsOfSearch.toString().replaceAll("([\\[\\]])", ""));
            }
        }

        renderRequest.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
        session.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
        
        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/browse/view.jsp");
        dispatcher.include(renderRequest, renderResponse);
    }

    /**
     * @param resourceRequest This is a RenderRequest object
     * @param resourceResponse This is a RenderResponse object
     */
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        String environment = resourceRequest.getPreferences().getValue(ENVIRONMENT, BrandStandardsConstant.ENVIRONMENT_PROD);
        AccessAndPreferences userPreferences = getUserPreferences(resourceRequest);
        HttpSession session = getHttpSession(getHttpRequest(resourceRequest));
        final String resourceID = resourceRequest.getResourceID();
        BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(resourceRequest, userPreferences.getLangCode(), "OBSM");
        
        resourceRequest.setAttribute("brandCode", userPreferences.getChain());
        resourceRequest.setAttribute("langCode", userPreferences.getLangCode());
        resourceRequest.setAttribute("countryCode", userPreferences.getCountry());
        resourceRequest.setAttribute("differentDateFormat", BrandStandardsConstant.CHINESE_LOCALE_CD);
        if ("saveDisplayOptions".equalsIgnoreCase(resourceID))
        {
            saveDisplayOptions(resourceRequest, user, session);
            return;
        }
        String modalType = resourceRequest.getParameter("modalType");
        int resultCount = 0;
        if (session.getAttribute("resultCount") != null)
        {
            resultCount = (Integer) session.getAttribute("resultCount");
        }
        
        if ("supportingMaterial".equalsIgnoreCase(modalType) && Validator.isNotNull(resourceRequest.getParameter("stdId")))
        {
            getSupportingMaterial(resourceRequest, resourceResponse, environment, userPreferences, obsmLanguageUtil);
        }
        else if ("download".equalsIgnoreCase(modalType))
        {
            downloadSupportingMaterial(resourceRequest, resourceResponse, themeDisplay, environment, userPreferences, obsmLanguageUtil);
        }
        else if ("allSupportingMaterial".equalsIgnoreCase(modalType))
        {
            getAllSupportingMaterials(resourceRequest, resourceResponse, environment, userPreferences, session, obsmLanguageUtil, resultCount);
        }
        else if ("images".equalsIgnoreCase(modalType))
        {
            getImages(resourceRequest, resourceResponse, environment, userPreferences, obsmLanguageUtil);
        }
        else if ("referenceStandards".equalsIgnoreCase(modalType) && Validator.isNotNull(resourceRequest.getParameter("stdId")))
        {
            getReferenceStandards(resourceRequest, resourceResponse, environment, userPreferences, obsmLanguageUtil);
        }
        /*else if ("createPDF".equalsIgnoreCase(modalType))
        {
            createPDF(resourceRequest, resourceResponse, environment, userPreferences, session, obsmLanguageUtil, resultCount);
        }*/
        /*else if ("generatePDF".equalsIgnoreCase(modalType))
        {
            generatePDF(resourceRequest, resourceResponse, environment, obsmLanguageUtil);
        }*/
        /*else if ("viewSearch".equalsIgnoreCase(modalType))
        {
        	getViewSearch(resourceRequest, resourceResponse, environment, userPreferences, obsmLanguageUtil);
        }*/
        /*else if ("viewHelp".equalsIgnoreCase(modalType))
        {
            getViewHelp(resourceRequest, resourceResponse, themeDisplay, userPreferences, obsmLanguageUtil);
        }*/
        processResourceRendering(resourceRequest, resourceResponse, userPreferences, SEARCH_STANDARDS, modalType);
        
    }

    private void saveDisplayOptions(ResourceRequest resourceRequest, User user, HttpSession session)
    {
        String whatsNew = (String) resourceRequest.getParameter("whatsNew");
        String compDate = (String) resourceRequest.getParameter("compDate");
        String highlight = (String) resourceRequest.getParameter("highlight");
        String hotelLifeCycle =(String) resourceRequest.getParameter("hotelLifeCycle");
        if(LOG.isDebugEnabled()){
            LOG.info("Serve Resource :: hotelLifeCycle"+ hotelLifeCycle);
        }
        
        // Add save Display Options Method.
        StandardsListApplication standApp = new StandardsListApplication();
        StandardsDisplayOptions displayOptions = standApp.getUserDisplayOptions(user.getUserId());
        if (displayOptions != null)
        {
            session.setAttribute(DISPLAY_OPTIONS, displayOptions);
            if(LOG.isDebugEnabled()){
                LOG.info("Serve resource Session value set for hotle Life cycle :: "+ displayOptions.isHotelLifeCycle());
            }
        }
        else
        {
            displayOptions = new StandardsDisplayOptions();
        }
        displayOptions.setWhatsNew(CONSTANT_Y.equals(whatsNew));
        displayOptions.setCompDate(CONSTANT_Y.equals(compDate));
        displayOptions.setHighlight(CONSTANT_Y.equals(highlight));
        displayOptions.setHotelLifeCycle(CONSTANT_Y.equals(hotelLifeCycle));
        standApp.saveUserDisplayOptions(user.getUserId(), displayOptions);
        session.setAttribute(DISPLAY_OPTIONS, displayOptions);
    }

    private void getSupportingMaterial(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String environment,
            AccessAndPreferences userPreferences, BSLanguageUtil obsmLanguageUtil)
    {
        try
        {
            long stdId = Long.parseLong(resourceRequest.getParameter("stdId"));
            if (LOG.isDebugEnabled())
            {
                LOG.debug("stdId :::" + stdId);
            }

            long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(userPreferences.getChain(), environment);
            
            AttachmentsApplication attachment = ApplicationUtil.getAtatchmentsApplicationObject();
            Standard standard = attachment.getAllsupportingMaterial(publishId, stdId, userPreferences.getLangCode(),
                    userPreferences.getChain(), userPreferences.getCountry(), environment, null);
            resourceRequest.setAttribute("stdDetails", standard);
            resourceRequest.setAttribute("attachmentTypes", BrandStandardsUtil.fileTypes());
            resourceRequest.setAttribute("supportedFormats", BrandStandardsConstant.VIDEO_FORMATS);
            resourceRequest.setAttribute("displayFormat", BrandStandardsConstant.VIDEO_LABEL);
            resourceRequest.setAttribute("brandCode", userPreferences.getChain());
            resourceRequest.setAttribute("langCode", userPreferences.getLangCode());
            setSupportingMaterialLabels(resourceRequest, obsmLanguageUtil);
            include("/html/browse/supportingMaterial.jsp", resourceRequest, resourceResponse);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortletException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

    private void downloadSupportingMaterial(ResourceRequest resourceRequest, ResourceResponse resourceResponse,
            ThemeDisplay themeDisplay, String environment, AccessAndPreferences userPreferences, BSLanguageUtil obsmLanguageUtil)
    {
        Map<String, String> metadataParams = new HashMap<String, String>();
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_ENVIRONMENT, environment);
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_DOWNLOAD_IDS, resourceRequest.getParameter("attachmentIds"));
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_DOWNLOAD_FILE_SOURCE, "Liferay");
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_SECOND_LOCALE_CD, userPreferences.getLangCode());
        metadataParams.put(BrandStandardsConstant.METADATA_PARAM_USER_NAME, themeDisplay.getUser().getFirstName());
        String metaData = BrandStandardsUtil.buildJobQueueMetadataXML(BrandStandardsConstant.JOB_TYPE_MYDOWNLOADS, metadataParams, null, null);
        boolean isExist = false;

        if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(metaData, themeDisplay.getUser().getScreenName(),
                BrandStandardsConstant.JOB_TYPE_MYDOWNLOADS))
        {
            BrandStandardsUtil.addToJobQueue(BrandStandardsConstant.JOB_TYPE_MYDOWNLOADS, metaData, 
                    themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress());
        }
        else
        {
            isExist = true;
        }
        resourceResponse.setCharacterEncoding("UTF-8");
        resourceResponse.setContentType("application/text");
        try
        {
            if (isExist)
            {
                resourceResponse.getWriter().write(obsmLanguageUtil.get("bs.all.supporting.material.download.exist.msg"));
            }
            else
            {
                resourceResponse.getWriter().write(obsmLanguageUtil.get("bs.all.supporting.material.download.success.msg"));
            }
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

    private void getAllSupportingMaterials(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String environment,
            AccessAndPreferences userPreferences, HttpSession session, BSLanguageUtil obsmLanguageUtil, int resultCount)
    {
        try
        {

            StandardsSearchCriteria criteria = null;
            Standard standard = null;
            if (session.getAttribute(SEARCH_CRITERIA) != null)
            {
                criteria = (StandardsSearchCriteria) session.getAttribute(SEARCH_CRITERIA);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Search criteria from database:::");
                }
            }
            if (Validator.isNotNull(criteria))
            {
                resourceRequest.setAttribute(SHOW_SEARCH_RESULTS_MSG, true);
                resourceRequest.setAttribute(SEARCH_RESULTS_MSG,
                        BrandStandardsUtil.getSearchResultMessage(criteria, userPreferences.getLangCode(), resultCount, obsmLanguageUtil));
                resourceRequest.setAttribute("allSupportingMaterial", obsmLanguageUtil.format("bs.all.supporting.material.msg",
                        new Object[] { criteria.getResultCount() }));
            }
            else
            {
                resourceRequest.setAttribute(SHOW_NO_SEARCH_ACTIVE_MSG, true);
                resourceRequest.setAttribute(NO_SEARCH_ACTIVE_MSG, obsmLanguageUtil.get("bs.search.result.nosearchactive.msg"));
                resourceRequest.setAttribute("allSupportingMaterial", obsmLanguageUtil.format("bs.all.supporting.material.msg",
                        new Object[] { obsmLanguageUtil.get("bs.all") }));
                criteria = new StandardsSearchCriteria();
                if(criteria != null){
                	criteria.setScope(SEARCH_STANDARDS);
                }
            }
            
            long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(userPreferences.getChain(), environment);
            
            AttachmentsApplication attachment = ApplicationUtil.getAtatchmentsApplicationObject();
            standard = attachment.getAllsupportingMaterial(publishId, 0l, userPreferences.getLangCode(), userPreferences.getChain(),
                    userPreferences.getCountry(), environment, criteria);
            resourceRequest.setAttribute("stdDetails", standard);
            resourceRequest.setAttribute("attachmentTypes", BrandStandardsUtil.fileTypes());
            resourceRequest.setAttribute("supportedFormats", BrandStandardsConstant.VIDEO_FORMATS);
            resourceRequest.setAttribute("displayFormat", BrandStandardsConstant.VIDEO_LABEL);
            resourceRequest.setAttribute("brandCode", userPreferences.getChain());
            resourceRequest.setAttribute("langCode", userPreferences.getLangCode());
            setAllSupportingMaterialLabels(resourceRequest, obsmLanguageUtil);
            include("/html/browse/allSupportingMaterials.jsp", resourceRequest, resourceResponse);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortletException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

    private void getImages(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String environment,
            AccessAndPreferences userPreferences, BSLanguageUtil obsmLanguageUtil)
    {
        try
        {
            long stdId = 0l;
            if (Validator.isNotNull(resourceRequest.getParameter("standardID")))
            {
                stdId = Long.parseLong(resourceRequest.getParameter("standardID"));
                List<StdImage> images = StandardsListApplication.getAssociatedImages(stdId, userPreferences.getLangCode(),
                        userPreferences.getChain(), userPreferences.getCountry(), environment, null);
                resourceRequest.setAttribute("stdDetails", images);
                resourceRequest.setAttribute("closeMsg", obsmLanguageUtil.get("bs.close"));
            }
            include("/html/browse/mandatoryImages.jsp", resourceRequest, resourceResponse);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortletException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

    private void getReferenceStandards(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String environment,
            AccessAndPreferences userPreferences, BSLanguageUtil obsmLanguageUtil)
    {
        try
        {
            long stdId = Long.parseLong(StringUtil.trim(resourceRequest.getParameter("stdId")));
            if (LOG.isDebugEnabled())
            {
                LOG.debug("stdId :::" + stdId);
            }
            
            long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(userPreferences.getChain(), environment);

            String query = null;
            if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment))
            {
                query = QueryUtils.getAllAssociatedStandards(publishId, stdId, userPreferences.getCountry(), userPreferences.getLangCode());
            } 
            else 
            {
                query = QueryUtils.getAllAssociatedStandardsForStaging(publishId, stdId, userPreferences.getCountry(), userPreferences.getLangCode());
            }
            List standardDetails = PublishStdLocalServiceUtil.getAssociatedStds(query);
            StandardsListApplication standApp = new StandardsListApplication();

            if (LOG.isDebugEnabled()) 
            {
            	LOG.debug("Refrenced standards :");
            }
            resourceRequest.setAttribute("referenceRecords", standApp.sortRefStandardSpecsAndGdln(standardDetails));
            resourceRequest.setAttribute("brandCode", userPreferences.getChain());
            resourceRequest.setAttribute("langCode", userPreferences.getLangCode());
            setStandardReferenceLabel(resourceRequest, obsmLanguageUtil);
            include("/html/browse/stdReference.jsp", resourceRequest, resourceResponse);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortletException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * This method will verify whether the Search options Popup should open automatically or not.
     * 
     * @param renderRequest This is a RenderRequest object
     * @param user This is a User object
     * @param httpRequest This is an HttpRequest object
     * @param standApp This is a StandardsListApplication object
     * 
     */
    private void showSearchOptionsPopup(RenderRequest renderRequest, User user, HttpServletRequest httpRequest,
            StandardsListApplication standApp)
    {
        String homeRef = httpRequest.getParameter("ref");
        if ("home".equalsIgnoreCase(homeRef))
        {
            if (standApp.getUserSearchCriteria(user.getUserId()) == null)
            {
                renderRequest.setAttribute(SHOW_SEARCH_OPTIONS, true);
            }
            else
            {
                renderRequest.setAttribute(SHOW_SEARCH_OPTIONS, false);
            }
        }
        else
        {
            renderRequest.setAttribute(SHOW_SEARCH_OPTIONS, false);
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Show Search options:" + renderRequest.getAttribute(SHOW_SEARCH_OPTIONS));
        }
    }

    /**
     * @param request This is a PortletRequest object
     * @param langCode This is a String object
     */
    private void setSupportingMaterialLabels(PortletRequest request, BSLanguageUtil obsmLanguageUtil)
    {
        request.setAttribute("supportingMaterial", obsmLanguageUtil.get("bs.supprting.material"));
        request.setAttribute("downloadMsg", obsmLanguageUtil.get("bs.download"));
        request.setAttribute("closeMsg", obsmLanguageUtil.get("bs.close"));
        request.setAttribute("help", obsmLanguageUtil.get("bs.help"));
        request.setAttribute("helpMsg", obsmLanguageUtil.get("bs.supprting.material.help.msg"));
        request.setAttribute("links", obsmLanguageUtil.get("bs.links"));
        request.setAttribute("newRecord", obsmLanguageUtil.get("bs.new"));
        request.setAttribute("updatedRecord", obsmLanguageUtil.get("bs.updated"));
    }
    
    /**
     * @param request This is a PortletRequest object
     * @param langCode This is a String object
     */
    private void setStandardReferenceLabel(PortletRequest request, BSLanguageUtil obsmLanguageUtil)
    {
        request.setAttribute("referenceTitle", obsmLanguageUtil.get("bs.std.reference.label"));
        request.setAttribute("closeMsg", obsmLanguageUtil.get("bs.close"));
        request.setAttribute("newRecord", obsmLanguageUtil.get("bs.new"));
        request.setAttribute("updatedRecord", obsmLanguageUtil.get("bs.updated"));
        request.setAttribute("guidelines", obsmLanguageUtil.get("bs.search.guidelines"));
    }

    /**
     * 
     * @param request This is a PortletRequest object
     * @param langCode This is a String object
     */
    private void setAllSupportingMaterialLabels(PortletRequest request, BSLanguageUtil obsmLanguageUtil)
    {
        request.setAttribute("downloadAll", obsmLanguageUtil.get("bs.download.all"));
        request.setAttribute("download", obsmLanguageUtil.get("bs.download"));
        request.setAttribute("closeMsg", obsmLanguageUtil.get("bs.close"));
        request.setAttribute("help", obsmLanguageUtil.get("bs.help"));
        request.setAttribute("helpMsg", obsmLanguageUtil.get("bs.all.supporting.material.help.msg"));
        request.setAttribute("searchMessage", obsmLanguageUtil.get("bs.all.supporting.material.search.msg"));
        request.setAttribute("type", obsmLanguageUtil.get("bs.type"));
        request.setAttribute("title", obsmLanguageUtil.get("bs.title"));
        request.setAttribute("standard", obsmLanguageUtil.get("bs.standard.id"));
        request.setAttribute("links", obsmLanguageUtil.get("bs.links"));
        request.setAttribute("link", obsmLanguageUtil.get("bs.link"));
        request.setAttribute("items", StringPool.SPACE + obsmLanguageUtil.get("bs.items"));
        request.setAttribute("allSupportingMaterialTitle", obsmLanguageUtil.get("bs.all.supprting.material"));
        request.setAttribute("downloadMsg", obsmLanguageUtil.get("bs.download"));
        request.setAttribute("newRecord", obsmLanguageUtil.get("bs.new"));
        request.setAttribute("updatedRecord", obsmLanguageUtil.get("bs.updated"));

    }

    /**
     * 
     * @param request This is a PortletRequest object
     * @param param This is a String object
     * @return
     */
    private void removeAttribute(PortletRequest request, String param)
    {
        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
        HttpSession session = httpReq.getSession();
        session.removeAttribute(param);
    }

    /**
     * @param actionRequest The ActionRequest object
     * @param actionResponse The ActionResponse object
     * @throws IOException throws IOException
     * @throws PortletException throws PortletException
     */
    @ProcessAction(name = "searchStandards")
    public void searchStandards(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession session = getHttpSession(request);
        AccessAndPreferences userPreferences = getUserPreferences(actionRequest);
        StandardsSearchCriteria criteria = null;
        session.removeAttribute(ARL_STANDARDS);
        session.removeAttribute(SEARCH_CRITERIA);
        criteria = new StandardsSearchCriteria(request, userPreferences.getLangCode());
        if(criteria != null){
        	criteria.setScope(SEARCH_STANDARDS);
        }
        session.setAttribute(SEARCH_CRITERIA, criteria);
        String publicUrl = themeDisplay.getPathFriendlyURLPublic();
        String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
        String url = publicUrl + "/brand-standards" + friendlyUrl;
        actionResponse.sendRedirect(url);
    }

    /**
     * @param actionRequest The ActionRequest object
     * @param actionResponse The ActionResponse object
     * @throws IOException throws IOException
     * @throws PortletException throws PortletException
     */
    @ProcessAction(name = "clearSearchAction")
    public void clearSearchAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
            PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        StandardsListApplication standApp = new StandardsListApplication();
        User user = themeDisplay.getUser();
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession session = getHttpSession(request);
        session.removeAttribute(SEARCH_CRITERIA);
        session.removeAttribute(ARL_STANDARDS);
        StandardsSearchCriteria criteria = new StandardsSearchCriteria();
        if(criteria != null){
        	criteria.setScope(SEARCH_STANDARDS);
        }
        boolean flag = standApp.saveSearchCriteria(user.getUserId(), criteria, null);
        /** Setting ShowPDF(Create PDF) button to False */
        actionRequest.setAttribute("showPDF", false);
        LOG.info("the value of flag is " + flag);
        String publicUrl = themeDisplay.getPathFriendlyURLPublic();
        String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
        String url = publicUrl + "/brand-standards" + friendlyUrl;
        actionResponse.sendRedirect(url);
    }

    /**
     * @param renderRequest This is a RenderRequest object
     * @param renderResponse This is a RenderResponse object
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
     * @param actionResponse This is an ActionRequest object
     * @param actionRequest This is an ActionResponse object
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
