package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.CMSSearchCriteria;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.TreeXML;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.service.AkamaiFTPDataSource;
import com.ihg.brandstandards.util.ActionUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.CMSStandardsListUtil;
import com.ihg.brandstandards.util.StandardsStatusUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.ihg.brandstandards.util.UserPreferencesUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Fetch records based on search criteria. Keep track of search criteria until user clear criteria or end of session.
 * 
 * @author KhandeN
 * 
 */
public class StandardsListPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsListPortlet.class);

    private static final String SEARCH_CRITERIA = "searchCriteria";

    /**
     * Populate data on page load.
     * 
     * @param request - RenderRequest
     * @param renderResponse - RenderResponse
     * 
     * @throws IOException - IOException
     * @throws PortletException - PortletException
     */
    public void doView(final RenderRequest request, final RenderResponse renderResponse) throws IOException, PortletException
    {
//        LOG.info("THIS IS StandardsListPortlet");
        final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        final User user = themeDisplay.getUser();
        long companyId = 0;
        final PortletURL portletURL = renderResponse.createRenderURL();
        SearchContainer<Standards> searchContainer;
        List<Standards> arlStandards;
        List<Role> arlUserRoles = new ArrayList<Role>();
        List<String> arlUsers = new ArrayList<String>();
        String brandCode = "";
        String discontFilter = "";
        String regionCode = "";
        int prefRecPerPage = 0;
        int standardsCount = 0;
        try
        {
            companyId = themeDisplay.getCompanyId();
            arlUserRoles = user.getRoles();
            
            final boolean approverFlag = true; // isApprover(user.getUserId());
            final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
            final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
            final HttpSession session = httpRequest.getSession();
            Preferences preferences = (Preferences) session.getAttribute("Preferences");
            if (preferences != null)
            {
            	brandCode = preferences.getBrand();
            	regionCode = preferences.getRegionCode();
            	discontFilter = preferences.getDiscontinuedFilter();
            	prefRecPerPage = preferences.getItemsPerPage();
            }
            final int pageNum = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM) == null ? 0 : 
                Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM));
            searchContainer = getPageSearchContainer(request, portletURL, prefRecPerPage, httpRequest, pageNum);
            final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
            searchContext.setStart(searchContainer.getStart());
            searchContext.setEnd(searchContainer.getEnd());

            final CMSSearchCriteria criteria = updateSearchCriteria(request, session, approverFlag);
            arlStandards = getStandardsForCriteria(approverFlag, session, criteria, brandCode, discontFilter);
            standardsCount = arlStandards.size();
            searchContainer.setTotal(arlStandards.size());
            arlStandards = ListUtil.subList(arlStandards, searchContainer.getStart(), searchContainer.getEnd());
            searchContainer.setResults(arlStandards);

            arlUsers = CMSStandardsListUtil.getAuthorListByUserRole(companyId, arlUserRoles, regionCode);
            LOG.debug("Size of arl Users before setting to request is " + arlUsers.size());
            request.setAttribute("searchContainer", searchContainer);
            List<ReportConfig> config = ReportConfigLoader.getSortedReportConfig();
            request.setAttribute("reportConfigs", config);
            request.setAttribute("preferBrand", brandCode);
            request.setAttribute(
                    "curPageNum",
                    request.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? String.valueOf(pageNum) : request
                            .getParameter(SearchContainer.DEFAULT_CUR_PARAM));
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStandards = new ArrayList<Standards>();
            request.setAttribute("searchContainer", null);
        }
        request.setAttribute("arlStandards", arlStandards);
        request.setAttribute("standardsCount", standardsCount);
        request.setAttribute("arlUsers", arlUsers);

        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/standlist/view.jsp");
        dispatcher.include(request, renderResponse);
    }

    /**
     * Get Search Container for specified items per page and page number.
     * @param request request
     * @param portletURL portlet URL
     * @param prefRecPerPage items per page from user profile
     * @param httpRequest request
     * @param pageNum current page number
     * @return SearchContainer
     */
    private SearchContainer<Standards> getPageSearchContainer(final RenderRequest request, final PortletURL portletURL,
            int prefRecPerPage, final HttpServletRequest httpRequest, final int pageNum)
    {
        int recPerPage = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE) == null ? 0 : Integer
                .parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE));
        if (recPerPage == 0 && request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM) != null)
        {
            recPerPage = Integer.parseInt(request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM));
        }
        // first time loading page
        else if (recPerPage == 0)
        {
            recPerPage = prefRecPerPage;
        }

        if (prefRecPerPage != recPerPage)
        {
            UserPreferencesUtil.updateItemsPerPage(request, recPerPage);
            recPerPage = prefRecPerPage;
        }
        SearchContainer<Standards>  searchContainer = new SearchContainer<Standards>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, pageNum,
                recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        return searchContainer;
    }

    /**
     * Fetch Standards based on search criteria.
     * 
     * @param approverFlag - is approver
     * @param session - HTTP session
     * @param criteria - search criteria
     * @return List of Standards
     * @throws SystemException - exception
     */
    private List<Standards> getStandardsForCriteria(final boolean approverFlag, final HttpSession session,
            final CMSSearchCriteria criteria, String brandCode, String discontFilter) throws SystemException
    {
        List<Standards> arlStandards;
        if (criteria == null || criteria.isEmpty())
        {
            arlStandards = StandardsLocalServiceUtil.getStandards(approverFlag, brandCode, discontFilter);
            LOG.debug("The size of array list in else is " + arlStandards.size());
        }
        else
        {
            arlStandards = getStandardsFilterResults(criteria, approverFlag, brandCode, discontFilter);
            LOG.debug("size of arlstandards after fetching data " + arlStandards.size());
            session.setAttribute("approverFlag", approverFlag);
            LOG.debug("after setting lists to session");
        }
        return arlStandards;
    }

    /**
     * Fetch search criteria from request into CMSSearchCriteria.
     * 
     * @param request - RenderRequest
     * @param session - HTTP session
     * @param isApprover - Approver role flag
     * @return CMSSearchCriteria
     */
    private CMSSearchCriteria updateSearchCriteria(final RenderRequest request, final HttpSession session,
            final boolean isApprover)
    {
        CMSSearchCriteria criteria = null;
        final String clearFilter = request.getParameter("clearFilter");
        final String applyButton = request.getParameter("applyButton");

        if (clearFilter != null && "true".equals(clearFilter))
        {
            session.removeAttribute(SEARCH_CRITERIA);
        }
        else if (applyButton != null && "true".equals(applyButton))
        {
            criteria = new CMSSearchCriteria(request);
            criteria.setApprover(isApprover);
            session.setAttribute(SEARCH_CRITERIA, criteria);
        }
        else
        {
            criteria = getSearchCriteria(session, isApprover, false);
        }
        return criteria;
    }

    /**
     * Get search criteria from session.
     * 
     * @param session - HTTP session
     * @param isApprover - approver flag
     * @param create - if criteria is null then create one
     * @return search criteria
     */
    private CMSSearchCriteria getSearchCriteria(final HttpSession session, final boolean isApprover, final boolean create)
    {
        CMSSearchCriteria criteria = (CMSSearchCriteria) session.getAttribute(SEARCH_CRITERIA);
        if (criteria == null && create)
        {
            criteria = new CMSSearchCriteria();
        }
        if (criteria != null)
        {
            criteria.setApprover(isApprover);
        }
        return criteria;
    }

    /**
     * Serve AJAX calls.
     * 
     * @param resourceRequest - ResourceRequest
     * @param resourceResponse - ResourceResponse
     * @throws IOException - exception
     * @throws PortletException - exception
     */
    public void serveResource(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        resourceResponse.setContentType("text/html");
        final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        HttpSession session = httpRequest.getSession();
        
        String brandCode = "";
        String regionCode = "";
        String discontFilter = "";
        final ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final User user = themeDisplay.getUser();
        final String resourceID = resourceRequest.getResourceID();
        Preferences preferences = (Preferences) session.getAttribute("Preferences");
        if (preferences != null)
        {
            brandCode = preferences.getBrand();
        	regionCode = preferences.getRegionCode();
        	discontFilter = preferences.getDiscontinuedFilter();
        }
        if ("getSpecifications".equalsIgnoreCase(resourceID))
        {
            processGetSpecifications(resourceRequest, resourceResponse, true, httpRequest.getSession());
        }
        else if ("updateStatus".equalsIgnoreCase(resourceID))
        {
            processUpdateStatus(resourceRequest, resourceResponse, user);
        }
        else if ("showAdvancedFilter".equalsIgnoreCase(resourceID))
        {
            LOG.debug("In show advanced filter");
            final PortletRequestDispatcher dispatcher = getPortletContext()
                    .getRequestDispatcher("/html/standlist/viewSearch.jsp");
            dispatcher.include(resourceRequest, resourceResponse);
        }
        else if ("getStandardsCount".equalsIgnoreCase(resourceID))
        {
            processGetStandardsCount(resourceRequest, resourceResponse, true, brandCode);
        }
        else if ("dispAllSpecGuideline".equalsIgnoreCase(resourceID))
        {
            final CMSSearchCriteria searchCriteria = (CMSSearchCriteria) httpRequest.getSession().getAttribute(
                    SEARCH_CRITERIA);
            if (searchCriteria != null)
            {
                searchCriteria.setFetchAllSpecGuideline(resourceRequest);
            }
        }
        else if ("getTreeData".equals(resourceID))
        {
            try
            {
                resourceResponse.setContentType("text/xml");
                xmlTaxonomy(resourceRequest, resourceResponse);
            }
            catch (Exception e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        else if ("exportRecordsOnlyReport".equals(resourceID))
        {
            processExportReport(resourceRequest, resourceResponse, httpRequest.getSession(), true, true, regionCode);
        }
        else if ("exportFullReport".equals(resourceID))
        {
            processExportReport(resourceRequest, resourceResponse, httpRequest.getSession(), true, false, regionCode);
        }
        else if ("exportTranslationReport".equals(resourceID))
        {
        	try {
				processExportTranslationReport(resourceRequest, resourceResponse, httpRequest.getSession(), true);
			} catch (SystemException e) {
				LOG.error(StackTraceUtil.getStackTrace(e));
			}
        }
        else if ("importTranslationReport".equals(resourceID))
        {
        	try {
				processImportTranslationReport(resourceRequest, resourceResponse, httpRequest.getSession(), true);
			} catch (SystemException e) {
				LOG.error(StackTraceUtil.getStackTrace(e));
			}
        }else if ("attachmentsLinksReport".equals(resourceID))
        {
        		processAttachementLinksReport(resourceRequest, resourceResponse, httpRequest.getSession());
        }
        else
        {
            LOG.error("Unknown Resource ID: " + resourceRequest.getResourceID());
        }
    }

    /**
     * Process request for XLS report.
     * 
     * @param resourceRequest - ResourceRequest
     * @param resourceResponse - ResourceResponse
     * @param session - HTTP session
     * @param isApprover - approver flag
     * @param isRecordsOnlyReport - run records only report flag
     */
    private void processExportReport(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse,
            final HttpSession session, final boolean isApprover, final boolean isRecordsOnlyReport, final String regionCd)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final String reportId = resourceRequest.getParameter("reportId");
        final String reportTitle = resourceRequest.getParameter("reportTitle");
        final String secLangCd = resourceRequest.getParameter("secLangCd");
        final String secLangDesc = resourceRequest.getParameter("secLangDesc");
        final CMSSearchCriteria criteria = getSearchCriteria(session, isApprover, true);
        criteria.setReportId(reportId);
        criteria.setSecondLangLocaleCd(secLangCd);
        criteria.setPreferedBrand(UserPreferencesUtil.getUserpreferences(resourceRequest));
        criteria.setDiscontFilter(UserPreferencesUtil.getDiscontinuedFilter(resourceRequest));
        ReportConfig config = ReportConfigLoader.getReportConfigMap().get(reportId);
        config.setSecLanguage(secLangCd);
        
        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        metadataParams.put(BSAdminConstants.METADATA_PARAM_ENVIRONMENT, BSAdminConstants.ENVIRONMENT_PRODUCTION);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_ID, reportId);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TITLE, reportTitle);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TYPE, isRecordsOnlyReport ? 
                BSAdminConstants.REPORT_TYPE_XLS_RERORT : BSAdminConstants.REPORT_TYPE_FULL_XLS_REPORT);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_PREF_LOCALE_CD, BSAdminConstants.METADATA_PARAM_DEF_LANG);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_NAME, themeDisplay.getUser().getFirstName());
        //Pass region code into metadata
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REGION_CODE, regionCd);
        Map<String, String> searchFields = criteria.getSearchCriteriaFields();
        String metaData = CMSStandardsListUtil.buildJobQueueMetadataXML(BSAdminConstants.JOB_TYPE_XLS_REPORT,
                metadataParams, BSAdminConstants.METADATA_PARAM_SEARCH_CRITERIA, searchFields);
        
        LOG.debug("Requester Report Export. is Records Only Report = " + isRecordsOnlyReport + " Report Id = " + reportId +
                  " reportTitle= " + reportTitle + " Second Language = " + secLangDesc);

        try 
        {
            PublishQueueLocalServiceUtil.createReport(metaData, themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress());
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    /**
     * Fetch Specifications and Guidelines from database.
     * 
     * @param resourceRequest - ResourceRequest
     * @param resourceResponse - ResourceResponse
     * @param approverFlag - is approver
     * @param session - HTTP session
     * @return PortletRequestDispatcher
     * @throws PortletException - exception
     * @throws IOException - exception
     */
    private PortletRequestDispatcher processGetSpecifications(final ResourceRequest resourceRequest,
            final ResourceResponse resourceResponse, final boolean approverFlag, final HttpSession session)
            throws PortletException, IOException
    {
        List<Standards> tempResults;
        List<Standards> arlGuidelines;
        String brandCode = "";
        String regionCode = "";
        String discontFilter ="";
        try
        {
            final CMSSearchCriteria searchCriteria = (CMSSearchCriteria) session.getAttribute(SEARCH_CRITERIA);
            final String standardId = (String) resourceRequest.getParameter("standardsId");
            // Verify if system should ignore search criteria and fetch all Specifications and Guidelines? 
            boolean fetchAllSpecGuideline = false;
            //String brandCode = UserPreferencesUtil.getUserpreferences(resourceRequest);
            //String discontFilter = UserPreferencesUtil.getDiscontinuedFilter(resourceRequest);
            Preferences preferences = (Preferences)session.getAttribute("Preferences");
            if(preferences!=null)
            {
            	brandCode = preferences.getBrand();
            	regionCode = preferences.getRegionCode();
            	discontFilter = preferences.getDiscontinuedFilter();
            }
            if (searchCriteria != null && !searchCriteria.isEmpty())
            {
                fetchAllSpecGuideline = searchCriteria.isFetchAllSpecGuideline();
            }

            if (searchCriteria == null || searchCriteria.isEmpty() || fetchAllSpecGuideline)
            {
                tempResults = StandardsLocalServiceUtil.getSpecifications(Long.parseLong(standardId), approverFlag, brandCode, fetchAllSpecGuideline, discontFilter);
                arlGuidelines = StandardsLocalServiceUtil.getGuidelines(Long.parseLong(standardId), approverFlag, brandCode, fetchAllSpecGuideline, discontFilter);
            }
            else
            {
                final CMSSearchCriteria newCriteria = searchCriteria.clone();
                // Index will not be searched on for guidelines and specifications
                newCriteria.setIndex("");
                newCriteria.setApprover(approverFlag);
                final Map<String, CMSSearchCriteria> criteriaMap = new HashMap<String, CMSSearchCriteria>();
                criteriaMap.put("StandardsSearchCriteria", newCriteria);
                tempResults = StandardsLocalServiceUtil.getSearchSpecificationsFilterResults(criteriaMap, approverFlag,
                        standardId, "SPEC", brandCode, discontFilter);
                arlGuidelines = StandardsLocalServiceUtil.getSearchGuidelinesFilterResults(criteriaMap, approverFlag, standardId,
                        "GDLN", brandCode, discontFilter);
            }
            // logger.debug("Size of arraylist in portlet is "+arlGuidelines.size());
            resourceRequest.setAttribute("arlSpecifications", tempResults);
            resourceRequest.setAttribute("arlGuidelines", arlGuidelines);
            resourceRequest.setAttribute("standardsId", standardId);
            final String pageNum = (String) resourceRequest.getParameter("pageNum");
            LOG.debug("Value of Standards ID in controller is " + standardId + " pageNum = " + pageNum);
            resourceRequest.setAttribute("pageNum", pageNum);
            resourceRequest.setAttribute("preferBrand", brandCode);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(
                "/html/standlist/viewSpecifications.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
        return dispatcher;
    }

    /**
     * Count Standards.
     * 
     * @param resourceRequest - ResourceRequest
     * @param resourceResponse - ResourceResponse
     * @param approverFlag - is approver
     * @return PortletRequestDispatcher
     * @throws PortletException - exception
     * @throws IOException - exception
     */
    private PortletRequestDispatcher processGetStandardsCount(final ResourceRequest resourceRequest,
            final ResourceResponse resourceResponse, final boolean approverFlag, final String brandCode) throws PortletException,
            IOException
    {
        LOG.debug("Inside getStandardsCount");
        String discontFilter = UserPreferencesUtil.getDiscontinuedFilter(resourceRequest);
        try
        {
            final CMSSearchCriteria criteria = new CMSSearchCriteria(resourceRequest);
            criteria.setApprover(approverFlag);
            //logger.debug("The value of brand from request is "+resourceRequest.getAttribute("brands")+" "+ParamUtil.getString(resourceRequest, "brands"));
            final int count = getStandardsCount(criteria, approverFlag, brandCode, discontFilter);
            resourceRequest.setAttribute("standardsCount", count);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/standlist/viewCounter.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
        return dispatcher;
    }

    /**
     * Update Status.
     * 
     * @param resourceRequest - ResourceRequest
     * @param resourceResponse - ResourceResponse
     * @param user - user object
     * @return PortletRequestDispatcher
     * @throws PortletException - exception
     * @throws IOException - exception
     */
    private PortletRequestDispatcher processUpdateStatus(final ResourceRequest resourceRequest,
            final ResourceResponse resourceResponse, final User user) throws PortletException, IOException
    {
    	HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
        HttpSession session = httpRequest.getSession();
        String brandCode = "";
        String regionCode = "";
        String discontFilter ="";
        try
        {
        	 Preferences preferences = (Preferences)session.getAttribute("Preferences");
             if(preferences!=null)
             {
             	brandCode = preferences.getBrand();
             	regionCode = preferences.getRegionCode();
             	discontFilter = preferences.getDiscontinuedFilter();
             }
           
            final String standardId = (String) resourceRequest.getParameter("standardsId");
            final long status = ParamUtil.getLong(resourceRequest, "status");
            final String comments = (String) resourceRequest.getParameter("comments");
            Standards standards = StandardsLocalServiceUtil.getStandards(Long.parseLong(standardId));
            ChainStandards chainStandards = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(
                    standards.getStdId(), brandCode);
            final String previousStatus =  StandardsStatusUtil.getStatusById(chainStandards.getStatusId()).getStatusCode();
            final String currStatus =  StandardsStatusUtil.getStatusById(status).getStatusCode();
            chainStandards.setStatusId(status);
            chainStandards.setUpdatedBy(Long.toString(user.getUserId()));
            chainStandards.setUpdatedDate(new Date());
            ChainStandardsLocalServiceUtil.updateChainStandards(chainStandards);
            if(LOG.isDebugEnabled()){
                LOG.debug("The values passed to workflow are: currStatus "+currStatus+" previousStatus "+previousStatus+" brandCode "+brandCode);
            }
            final Workflow workflow = CMSStandardsListUtil.setStandardsWorkflow(resourceRequest, standards, currStatus, previousStatus, comments, brandCode);
            if(LOG.isDebugEnabled()){
                LOG.debug("Value of current and previous status from workflow is " + workflow.getPrevStatus() + " "
                    + workflow.getStatus());
            }
            WorkflowLocalServiceUtil.addWorkflow(workflow);
            if (standards.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_STANDARD))
    		{
		    	StandardsUtil.updateChildStatus(standards, brandCode, status, user);
    		}
            ActionUtil.insertAdminXML(1l);
            standards = StandardsLocalServiceUtil.getStandards(Long.parseLong(standardId));
            resourceRequest.setAttribute("standards", standards);
            resourceRequest.setAttribute("chainStandards", chainStandards);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/standlist/viewStatus.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
        return dispatcher;
    }

    /**
     * Populate Index Tree on page.
     * 
     * @param request - ResourceRequest
     * @param response - ResourceResponse
     */
    public void xmlTaxonomy(final ResourceRequest request, final ResourceResponse response)
    {
        try
        {
            final PrintWriter out = response.getWriter();
            final TreeXML treeXmlTbl = ActionUtil.getXMLTreeTaxonomy(1L);
            if (treeXmlTbl != null)
            {
                final StringBuffer buffer = new StringBuffer();
                buffer.append(treeXmlTbl.getXMLLOB());
                out.write(buffer.toString());
            }
            out.flush();
            out.close();
        }
        catch (Exception pe)
        {
            LOG.error(StackTraceUtil.getStackTrace(pe));
        }
    }

    /**
     * Search Standards.
     * 
     * @param searchCriteria - search criteria
     * @param approverFlag - is approver
     * @return List of Standards.
     */
    public List<Standards> getStandardsFilterResults(final CMSSearchCriteria searchCriteria, final boolean approverFlag,
            final String preferBrand, final String discontFilter)
    {
        List<Standards> arlStandards = new ArrayList<Standards>();
        LOG.debug("inside getStandardsfilter results");
        try
        {
            final String standardId = "";
            final Map<String, CMSSearchCriteria> criteriaMap = new HashMap<String, CMSSearchCriteria>();
            criteriaMap.put("StandardsSearchCriteria", searchCriteria);
            arlStandards = StandardsLocalServiceUtil.getStandardsAdvancedFilterResults(criteriaMap, approverFlag, standardId,
                    "STD", preferBrand, discontFilter);
            LOG.debug("size of standards list is " + arlStandards.size());
            
            List<Long> prntStdIds = new ArrayList<Long>();
            for (Standards std : arlStandards)
            {
                prntStdIds.add(std.getStdId());
            }
            
            final List<Standards> arlStdSpecs = StandardsLocalServiceUtil.getSpecificationsFilterResults(criteriaMap, approverFlag, 
                    standardId, "SPEC", preferBrand, discontFilter, prntStdIds);
            
            final List<Standards> arlStdGdlns = StandardsLocalServiceUtil.getGuidelinesFilterResults(criteriaMap, approverFlag,
                    standardId, "GDLN", preferBrand, discontFilter, prntStdIds);
            
            final List<Standards> arlStandard = new ArrayList<Standards>(arlStandards);
            arlStandard.addAll(arlStdSpecs);
            arlStandard.addAll(arlStdGdlns);

            arlStandards = new ArrayList<Standards>();
            for (Standards element : arlStandard)
            {
                if (!arlStandards.contains(element))
                {
                    arlStandards.add(element);
                }
            }
            Collections.sort(arlStandards, new Comparator<Standards>()
            {
                public int compare(final Standards s1, final Standards s2)
                {
                    long v1 = s1.getCreatedDate().getTime();
                    long v2 = s2.getCreatedDate().getTime();

                    if (v2 > v1)
                    {
                        return 1;
                    }
                    else if (v2 < v1)
                    {
                        return -1;
                    }
                    else
                    {
                        return 0;
                    }

                }
            });
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        return arlStandards;
    }

    /**
     * Count Standards.
     * 
     * @param searchCriteria - search criteria
     * @param approverFlag - is approver
     * @return count
     */
    public int getStandardsCount(final CMSSearchCriteria searchCriteria, final boolean approverFlag,
            final String preferBrand, final String discontFilter)
    {
        int standardsCount = 0;

        try
        {
            standardsCount = getStandardsFilterResults(searchCriteria, approverFlag, preferBrand, discontFilter).size();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return standardsCount;
    }
    
    private void processExportTranslationReport(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse,
            final HttpSession session, final boolean isApprover) throws SystemException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final User user = themeDisplay.getUser();
        List<Role> userRoles = user.getRoles();
        boolean isSuperAdmin = StandardsUtil.isSuperAdmin(userRoles);

        final String reportId = resourceRequest.getParameter("reportId");
        final String secLangCd = resourceRequest.getParameter("langCd");
		final String exportReportTitle = resourceRequest.getParameter("reportTitle");
        final CMSSearchCriteria criteria = getSearchCriteria(session, isApprover, true);
        criteria.setReportId(reportId);
        criteria.setSecondLangLocaleCd(secLangCd);
        criteria.setPreferedBrand(UserPreferencesUtil.getUserpreferences(resourceRequest));
        criteria.setDiscontFilter(UserPreferencesUtil.getDiscontinuedFilter(resourceRequest));
        if (isSuperAdmin)
        {
            Preferences preferences = (Preferences)session.getAttribute("Preferences");
            if (preferences != null) 
            {
                String rgnCd = preferences.getRegionCode();
                //criteria.setEnteredBy(rgnCd);
                //Defect 5661 :: Super user can not get global as well as regional content  
                LOG.info("Super User Region Code "+rgnCd);
                if(!BrandStandardsUtil.REGION_GLBL.equals(rgnCd))
                {
                    criteria.setEnteredBy(rgnCd +  CMSSearchCriteria.DIVIDER_VAL + BrandStandardsUtil.REGION_GLBL);  
                }
                else
                {
                    criteria.setEnteredBy(rgnCd);
                }
                criteria.setPreferedBrand(rgnCd);
            }
        }
        else 
        {
            String rgnCd = StandardsController.getRegionCodeFromUserRole(userRoles);
            LOG.info("Normal User Region Code "+rgnCd);
            if(!BrandStandardsUtil.REGION_GLBL.equals(rgnCd))
            {
                criteria.setEnteredBy(rgnCd +  CMSSearchCriteria.DIVIDER_VAL + BrandStandardsUtil.REGION_GLBL);  
            }
            else
            {
                criteria.setEnteredBy(rgnCd);
            }
        }
        
        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        metadataParams.put(BSAdminConstants.METADATA_PARAM_ENVIRONMENT, BSAdminConstants.ENVIRONMENT_PRODUCTION);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_ID, reportId);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TYPE, 
                BSAdminConstants.REPORT_TYPE_TRANSLATE_EXPORT_RERORT );
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_PREF_LOCALE_CD, BSAdminConstants.METADATA_PARAM_DEF_LANG);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_NAME, user.getFirstName());
		metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TITLE, exportReportTitle);

        Map<String, String> searchFields = criteria.getSearchCriteriaFields();
        String metaData = CMSStandardsListUtil.buildJobQueueMetadataXML(BSAdminConstants.REPORT_TYPE_TRANSLATE_EXPORT_RERORT,
                metadataParams, BSAdminConstants.METADATA_PARAM_SEARCH_CRITERIA, searchFields);

        try 
        {
            //PublishQueueLocalServiceUtil.createReport(metaData, String.valueOf(themeDisplay.getUser().getUserId()), themeDisplay.getUser().getEmailAddress(), null ,BSAdminConstants.REPORT_TYPE_TRANSLATE_EXPORT_RERORT);
        	//Add for Defect #9655 Forbidden Issue for
        	PublishQueueLocalServiceUtil.createReport(metaData, themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress(), null ,BSAdminConstants.REPORT_TYPE_TRANSLATE_EXPORT_RERORT);
        	
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        criteria.setEnteredBy("");
    }
    
    private void processImportTranslationReport(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse,
            final HttpSession session, final boolean isApprover) throws SystemException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UploadPortletRequest uploadRequest   =  PortalUtil.getUploadPortletRequest(resourceRequest);
        final String reportId = uploadRequest.getParameter("reportId");
        final String secLangCd = uploadRequest.getParameter("langCd");
        final String inputfileName = uploadRequest.getParameter("fileName");
        String fileName = StringPool.BLANK;
        File file = uploadRequest.getFile("file"); 
        if(inputfileName.contains(StringPool.BACK_SLASH))
        {
        	fileName = inputfileName.substring(inputfileName.lastIndexOf(StringPool.BACK_SLASH)+1,inputfileName.length());
        }
        else
        {
        	fileName = inputfileName;
        }
        
        final CMSSearchCriteria criteria = getSearchCriteria(session, isApprover, true);
        criteria.setReportId(reportId);
        criteria.setSecondLangLocaleCd(secLangCd);
        criteria.setPreferedBrand(UserPreferencesUtil.getUserpreferences(resourceRequest));
        criteria.setDiscontFilter(UserPreferencesUtil.getDiscontinuedFilter(resourceRequest));	
        
        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        metadataParams.put(BSAdminConstants.METADATA_PARAM_ENVIRONMENT, BSAdminConstants.ENVIRONMENT_PRODUCTION);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_ID, reportId);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TYPE, BSAdminConstants.REPORT_TYPE_TRANSLATE_IMPORT_RERORT );
        
        final User user = themeDisplay.getUser();
        List<Role> userRoles = user.getRoles();
        boolean isSuperAdmin = StandardsUtil.isSuperAdmin(userRoles);
        if (isSuperAdmin)
        {
            String rgnCd = StringPool.BLANK;
            Preferences preferences = (Preferences)session.getAttribute("Preferences");
            if (preferences != null) 
            {
                rgnCd = preferences.getRegionCode();
//                criteria.setEnteredBy(rgnCd);
                criteria.setPreferedBrand(rgnCd);
            }
            metadataParams.put(BSAdminConstants.METADATA_PARAM_REGION_CODE, rgnCd);
        }
        else 
        {
            metadataParams.put(BSAdminConstants.METADATA_PARAM_REGION_CODE, StandardsController.getRegionCodeFromUserRole(userRoles));
        }
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_PREF_LOCALE_CD, BSAdminConstants.METADATA_PARAM_DEF_LANG);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_NAME, user.getFirstName());

        Map<String, String> searchFields = criteria.getSearchCriteriaFields();
        String metaData = CMSStandardsListUtil.buildJobQueueMetadataXML(BSAdminConstants.REPORT_TYPE_TRANSLATE_IMPORT_RERORT,
                metadataParams, BSAdminConstants.METADATA_PARAM_SEARCH_CRITERIA, searchFields);

        try 
        {
	    	AkamaiFTPDataSource akamaiClient = new AkamaiFTPDataSource();
	        akamaiClient.initProps();
	        String akamaiFileLink = akamaiClient.addFileToAkamaiGetPath(fileName, "user_files", file);
             
            //PublishQueueLocalServiceUtil.createReport(metaData, String.valueOf(themeDisplay.getUser().getUserId()), themeDisplay.getUser().getEmailAddress(), akamaiFileLink, BSAdminConstants.REPORT_TYPE_TRANSLATE_IMPORT_RERORT);
            //Add for Defect #9655 Forbidden Issue for
            PublishQueueLocalServiceUtil.createReport(metaData, themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress(), akamaiFileLink, BSAdminConstants.REPORT_TYPE_TRANSLATE_IMPORT_RERORT);
        }
        catch (IOException e)
        {
        	LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }
    
    private void processAttachementLinksReport(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse,final HttpSession session)
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final String reportId = resourceRequest.getParameter("reportId");
        final String reportTitle = resourceRequest.getParameter("reportTitle");
        final String secLangCd = resourceRequest.getParameter("secLangCd");
        final CMSSearchCriteria criteria = getSearchCriteria(session, true, true);
        criteria.setSecondLangLocaleCd(secLangCd);
        criteria.setPreferedBrand(UserPreferencesUtil.getUserpreferences(resourceRequest));
        criteria.setDiscontFilter(UserPreferencesUtil.getDiscontinuedFilter(resourceRequest));
        ReportConfig config = ReportConfigLoader.getReportConfigMap().get(reportId);
        config.setSecLanguage(secLangCd);
        
        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        metadataParams.put(BSAdminConstants.METADATA_PARAM_ENVIRONMENT, BSAdminConstants.ENVIRONMENT_PRODUCTION);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TITLE, reportTitle);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_PREF_LOCALE_CD, BSAdminConstants.METADATA_PARAM_DEF_LANG);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_NAME, themeDisplay.getUser().getFirstName());
        final String brands = resourceRequest.getParameter("reportBrands");
        final String reportType = resourceRequest.getParameter("reportType");
        if(reportType.equalsIgnoreCase("links")){
        	criteria.setReportId(BSAdminConstants.LINKS_REPORT_ID);
            
        	metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_ID, BSAdminConstants.LINKS_REPORT_ID);
            
        }else if(reportType.equalsIgnoreCase("attachments")){
        	criteria.setReportId(BSAdminConstants.ATTACHMENTS_REPORT_ID);
        	metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_ID, BSAdminConstants.ATTACHMENTS_REPORT_ID);
            
        }else{
        	criteria.setReportId(BSAdminConstants.LINKS_ATTACHMENTS_REPORT_ID);
        	metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_ID, BSAdminConstants.LINKS_ATTACHMENTS_REPORT_ID);        	
        }
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TYPE,BSAdminConstants.JOB_TYPE_XLS_ATTACHMENT_LINKS_REPORT );
        metadataParams.put("SUB_REPORT_TYPE", reportType);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_CHAIN_CD, brands);
        
        LOG.debug("Requester Report for Attachment and links Export Report.  Report Type = " + reportType +" reportTitle= " + reportTitle );
        Map<String, String> searchFields = criteria.getSearchCriteriaFields();
        String metaData = CMSStandardsListUtil.buildJobQueueMetadataXML(BSAdminConstants.JOB_TYPE_XLS_ATTACHMENT_LINKS_REPORT,
                metadataParams, BSAdminConstants.METADATA_PARAM_SEARCH_CRITERIA, searchFields);
       
        try 
        {
            PublishQueueLocalServiceUtil.createReport(metaData, themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress(),null,BSAdminConstants.JOB_TYPE_XLS_ATTACHMENT_LINKS_REPORT);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }   
    }

}
