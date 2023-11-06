package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishExtStd;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishExtStdLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.service.AkamaiFTPDataSource;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.CMSStandardsListUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.ihg.brandstandards.util.UserPreferencesUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ComplianceAdminPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ComplianceAdminPortlet.class);
    private static final String HOLIDAY_INN_EXPRESS = "EX";

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        String defaultTab = StringPool.BLANK;
        final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(renderRequest);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        HttpSession session = httpRequest.getSession();
        ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String currentURL = themeDisplay.getURLCurrent();
       
        if(currentURL.indexOf(StringPool.QUESTION) < 0)
        {
            session.setAttribute("isNonMatch", StringPool.BLANK);
            //LOG.info("Session value :: "+session.getAttribute("isNonMatch"));
        }
        
        List<String> allUniqueRecords = PublicationLocalServiceUtil.fetchUniquePublishedBrandCodes(); //fetchUniqueBrands();
        
        String tabNames = generateTabNames(allUniqueRecords);
        String tabValues = generateTabValues(allUniqueRecords);

        if (tabValues.contains(StringPool.COMMA))
        {
            defaultTab = tabValues.substring(0, tabValues.indexOf(StringPool.COMMA));
        }
        else
        {
            defaultTab = tabValues;
        }
        String tabs1 = ParamUtil.get(renderRequest, "tabs1", defaultTab);
        String filterOn = ParamUtil.get(renderRequest, "caloption", StringPool.BLANK);
        String isNonMatch = (String) session.getAttribute("isNonMatch");
        if (Validator.isNull(isNonMatch))
        {
            isNonMatch = ParamUtil.get(renderRequest, "isNonMatch", StringPool.BLANK);
        }
        String fromDate = ParamUtil.get(renderRequest, "between", StringPool.BLANK);
        String toDate = ParamUtil.get(renderRequest, "and", StringPool.BLANK);
        String stdString = ParamUtil.get(renderRequest, "Search", StringPool.BLANK);
    	fetchStandards(renderRequest, renderResponse, tabs1, filterOn, fromDate, toDate, stdString, isNonMatch);
        renderRequest.setAttribute("tabNames", tabNames);
        renderRequest.setAttribute("tabValues", tabValues);
        renderRequest.setAttribute("tabs1", tabs1);
        renderRequest.setAttribute("filterOn", filterOn);
        renderRequest.setAttribute("isNonMatch", isNonMatch);
        renderRequest.setAttribute("fromDate", fromDate);
        renderRequest.setAttribute("toDate", toDate);
        renderRequest.setAttribute("stdString", stdString);
        
        try
        {
            boolean allowCmplyImport = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), StandardsUtil.BRND_STND_COMPLIANCE_IMPORT, false);
            renderRequest.setAttribute("allowCmplyImport", allowCmplyImport);
        }
        catch (Exception e)
        {
            renderRequest.setAttribute("allowCmplyImport", false);
        }
            
        super.doView(renderRequest, renderResponse);
        
        LOG.debug("In Do VIEW : tabs1: "+tabs1+", caloption: "+filterOn+", between: "+fromDate+", and: "+toDate+", stdString: "+stdString +", isNonMatch: "+isNonMatch );
    }

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        resourceResponse.setContentType("text/html");
        final String resourceID = resourceRequest.getResourceID();
        if ("getSpecifications".equalsIgnoreCase(resourceID))
        {
            processGetSpecifications(resourceRequest, resourceResponse);
        }
        else if ("removeNonMatchValue".equalsIgnoreCase(resourceID))
        {
            //code for session add
            final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
            final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
            String isNonMatch = ParamUtil.get(resourceRequest, "nonMatch", StringPool.BLANK);
            HttpSession session = httpRequest.getSession();
            session.setAttribute("isNonMatch", isNonMatch);
        }
        else if ("excelComplianceImport".equalsIgnoreCase(resourceID))
        {
            try {
                excelComplianceImport(resourceRequest, resourceResponse);
            } catch (SystemException e) {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        else
        {
            LOG.error("Unknown Resource ID: " + resourceRequest.getResourceID());
        }
    }

    public void excelComplianceImport(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException, SystemException 
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UploadPortletRequest uploadRequest   =  PortalUtil.getUploadPortletRequest(resourceRequest);
        final String whereToUpdate = uploadRequest.getParameter("whereToUpdate");
        final String whatToUpdate = uploadRequest.getParameter("whatToUpdate");
        final String cmplyImportType = uploadRequest.getParameter("cmplyImportType");
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

        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        metadataParams.put(BSAdminConstants.METADATA_PARAM_REPORT_TYPE, BSAdminConstants.JOB_TYPE_XLS_UPDATE_COMPLIANCE );
        metadataParams.put("WHERE_TO_UPDATE", whereToUpdate);
        metadataParams.put("WHAT_TO_UPDATE", whatToUpdate);
        metadataParams.put("CMPLY_IMPORT_TYPE", cmplyImportType);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_PREF_LOCALE_CD, BSAdminConstants.METADATA_PARAM_DEF_LANG);
        metadataParams.put(BSAdminConstants.METADATA_PARAM_USER_NAME, themeDisplay.getUser().getFirstName());
        
        String metaData = CMSStandardsListUtil.buildJobQueueMetadataXML(BSAdminConstants.JOB_TYPE_XLS_UPDATE_COMPLIANCE, metadataParams, null, null); 
        try 
        {
            AkamaiFTPDataSource akamaiClient = new AkamaiFTPDataSource();
            akamaiClient.initProps();
            String akamaiFileLink = akamaiClient.addFileToAkamaiGetPath(System.currentTimeMillis()+"_"+fileName, "user_files", file);
            PublishQueueLocalServiceUtil.createReport(metaData, themeDisplay.getUser().getScreenName(), themeDisplay.getUser().getEmailAddress(), akamaiFileLink, BSAdminConstants.JOB_TYPE_XLS_UPDATE_COMPLIANCE);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }

    }
    
    public void fetchFilterResults(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException,
            PortletException
    {
        PortalUtil.copyRequestParameters(actionRequest, actionResponse);
    }

    private PortletRequestDispatcher processGetSpecifications(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException, IOException
    {
    	final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        HttpSession session = httpRequest.getSession();
        
    	List<PublishExtStd> specs = Collections.emptyList();
        List<PublishExtStd> totalSpecsList = new ArrayList<PublishExtStd>();
        List<PublishExtStd> allSpecs = new ArrayList<PublishExtStd>();
        ArrayList<Long> selectedStandards = new ArrayList<Long>();
        String[] dates = null;
        Long stdId = 0L;
        final String tabs1 = ParamUtil.get(resourceRequest, "tabs1", StringPool.BLANK);
        final long standardId = ParamUtil.getLong(resourceRequest, "standardsId", 0L);
        final long parentStdId = ParamUtil.getLong(resourceRequest, "parentId", 0L);
        final String caloption = ParamUtil.get(resourceRequest, "caloption", StringPool.BLANK);
        final String stdString = ParamUtil.get(resourceRequest, "Search", StringPool.BLANK);
        String isNonMatch = ParamUtil.get(resourceRequest, "nonMatch", StringPool.BLANK);
        String and = ParamUtil.get(resourceRequest, "and", StringPool.BLANK);
        String between = ParamUtil.get(resourceRequest, "between", StringPool.BLANK);
        session.setAttribute("isNonMatch", isNonMatch);
        Boolean hasFilter = true;

        if (Validator.isNotNull(caloption) && !"true".equals(isNonMatch))
        {
            dates = formatDates(caloption, between, and);
            between = dates[0];
            and = dates[1];
        }
        
        if(stdString != null && !(stdString.isEmpty()))
        {
        	for(String substring : stdString.split(" "))
            {
        		substring = substring.trim();
            	selectedStandards.add(Long.parseLong(substring));
            }
        }
        
        if((caloption == null || caloption.isEmpty()) && (stdString == null || stdString.isEmpty()) && (and == null || and.isEmpty()) && (between == null || between.isEmpty()) && (isNonMatch == null || isNonMatch.isEmpty()))
        {
        	hasFilter = false;
        	
        }
        
        try
        {
			 specs = PublishExtStdLocalServiceUtil.getPublishedStandards(parentStdId, BrandStandardsUtil.STD_TYPE_SPEC, tabs1, caloption, isNonMatch, between, and);
        }
        catch (SystemException e)
        {
             LOG.error("Error while fetching specs" + e.getMessage());
        }
        
        if(("true".equals(isNonMatch)) || hasFilter == false)
        {
        	totalSpecsList.addAll(specs);
        }else
        {
        	allSpecs.addAll(specs);
        	
        	for(int i =0; i < allSpecs.size(); i++)
      		{
       			stdId = allSpecs.get(i).getStdId();
       			
       		  if(selectedStandards.contains(stdId))
      		  {
   				totalSpecsList.add(allSpecs.get(i));
      		  }
      		}
        }
        
        Collections.sort(totalSpecsList);
        resourceRequest.setAttribute("arlSpecifications", totalSpecsList);
        resourceRequest.setAttribute("standardsId", standardId);
        resourceRequest.setAttribute("tabs1", tabs1);
        //For defect 5678
        String editUrlParam = "&caloption="+caloption+"&between="+between+"&and="+and+"&Search="+stdString+"&isNotMatch="+isNonMatch;
        resourceRequest.setAttribute("editUrlParam", editUrlParam);
        /*resourceRequest.setAttribute("between", between);
        resourceRequest.setAttribute("and", and);
        resourceRequest.setAttribute("isNotMatch", isNonMatch);
        resourceRequest.setAttribute("Search", stdString);*/
        
        LOG.debug("arlSpecifications: "+totalSpecsList);
        
        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/complianceAdmin/viewSpecifications.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
        return dispatcher;
    }

    /**
     * Fetch Standards.
     * @param request request
     * @param renderResponse response
     * @param tabs1 tab number
     * @param filterOn filter
     * @param fromDate from date
     * @param toDate to date
     */
    @SuppressWarnings("unchecked")
	private void fetchStandards(RenderRequest request, RenderResponse renderResponse, String tabs1, String filterOn,
            String fromDate, String toDate, String stdString, String isNonMatch)
    {
        List<PublishExtStd> standards = new ArrayList<PublishExtStd>();
        ArrayList<Long> selectedStandards = new ArrayList<Long>();
       
        String[] dates = null;
        String fDate = fromDate;
        String tDate = toDate;

        final PortletURL portletURL = renderResponse.createRenderURL();
        portletURL.setParameter("tabs1", tabs1);
        portletURL.setParameter("caloption", filterOn);
        portletURL.setParameter("between", fDate);
        portletURL.setParameter("and", tDate);
        portletURL.setParameter("stdString", stdString);
        
        if(filterOn.equalsIgnoreCase("between"))
        {
        	if((fDate == null || fDate.isEmpty()) ||(tDate == null || tDate.isEmpty()))
            {
            	filterOn = null;
            }
        }
        
        
        if (Validator.isNotNull(filterOn))
        {
            dates = formatDates(filterOn, fromDate, toDate);
            fDate = dates[0];
            tDate = dates[1];
        }
        
        try
        {
           	if(stdString == null || stdString.isEmpty())
           	{        	 
           		standards = PublishExtStdLocalServiceUtil.getPublishedStandards(0L, BrandStandardsUtil.STD_TYPE_STANDARD, tabs1, filterOn, StringPool.BLANK, fDate, tDate);
          	}
           	else
          	{
           		standards = PublishExtStdLocalServiceUtil.getPublishedStandards(tabs1, filterOn, StringPool.BLANK, fDate, tDate, stdString);
          	}
        }
        catch (SystemException e)
        {
            LOG.error("Error while fetching standards: " + e.getMessage());
        }

        SearchContainer<PublishExtStd> searchContainer = getSearchContainer(request, portletURL);
        searchContainer.setTotal(standards.size());
        standards = ListUtil.subList(standards, searchContainer.getStart(), searchContainer.getEnd());
        searchContainer.setResults(standards);
        request.setAttribute("searchContainerObj", searchContainer);
    }

    /**
     * Get Search Container for pagination grid.
     * @param request request
     * @param portletURL portlet URL
     * @return SearchContainer
     */
    private SearchContainer<PublishExtStd> getSearchContainer(RenderRequest request, final PortletURL portletURL)
    {
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        final HttpSession session = httpRequest.getSession();
        int prefRecPerPage = 0;
        Preferences preferences = (Preferences) session.getAttribute("Preferences");
        if (preferences != null)
        {
            prefRecPerPage = preferences.getItemsPerPage();
        }
        int recPerPage = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE) == null ? 0 : 
            Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE));
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
        SearchContainer<PublishExtStd> searchContainer = new SearchContainer<PublishExtStd>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
                recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        return searchContainer;
    }

    /**
     * Format Date.
     * @param filterOn
     * @param dq1
     */
    private String[] formatDates(String filterOn, String fromDate, String toDate)
    {
        String[] dates = new String[2];
        Date fDate = new Date();
        Date tDate = null;
        Calendar c = Calendar.getInstance();
        c.setTime(fDate);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 0, 0, 0);
        fDate = c.getTime();

        if (filterOn.equalsIgnoreCase("week"))
        {
            c.add(Calendar.DATE, 7);
            tDate = c.getTime();
        }
        else if (filterOn.equalsIgnoreCase("month"))
        {
            c.add(Calendar.DATE, 30);
            tDate = c.getTime();
        }
        else if (filterOn.equalsIgnoreCase("quarter"))
        {
            c.add(Calendar.DATE, 90);
            tDate = c.getTime();
        }
        else
        {
            // filter based on from and to date
            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            try
            {
                fDate = df.parse(fromDate);
                tDate = df.parse(toDate);
                c.setTime(tDate);
                c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), 23, 59, 59);
                //c.add(Calendar.DATE, 1);
                tDate = c.getTime();
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
        dates[0] = fDate.toString();
        dates[1] = tDate.toString();
        return dates;
    }

    /**
     * Method for generating tabnames
     * 
     * @param allUniqueRecords
     * @return
     */
    private String generateTabNames(List<String> allUniqueRecords)
    {
        StringBuilder tabNames = new StringBuilder();
        
        Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();

        if (allUniqueRecords.size() > 0)
        {
            if (allUniqueRecords.contains(HOLIDAY_INN_EXPRESS))
            {
                tabNames.append(chnCdMap.get(HOLIDAY_INN_EXPRESS));
                tabNames.append(StringPool.COMMA);
            }
            for (String brandCode : allUniqueRecords)
            {
                if (!brandCode.equalsIgnoreCase(HOLIDAY_INN_EXPRESS))
                {
                    tabNames.append(chnCdMap.get(brandCode));
                    tabNames.append(StringPool.COMMA);
                }
            }
            tabNames.deleteCharAt(tabNames.lastIndexOf(StringPool.COMMA));
        }
        return tabNames.toString();
    }

    /**
     * Method for generating tabvalues
     * 
     * @param allUniqueRecords
     * @return
     */
    private String generateTabValues(List<String> allUniqueRecords)
    {
        StringBuilder tabValues = new StringBuilder();
        if (allUniqueRecords.size() > 0)
        {
            if (allUniqueRecords.contains(HOLIDAY_INN_EXPRESS))
            {
                tabValues.append(HOLIDAY_INN_EXPRESS);
                tabValues.append(StringPool.COMMA);
            }
            for (String brandCode : allUniqueRecords)
            {
                if (!brandCode.equalsIgnoreCase(HOLIDAY_INN_EXPRESS))
                {
                    tabValues.append(brandCode);
                    tabValues.append(StringPool.COMMA);
                }
            }
            tabValues.deleteCharAt(tabValues.lastIndexOf(StringPool.COMMA));
        }
        return tabValues.toString();
    }

    /**
     * Method to fetch all published unique brands
     */
    @SuppressWarnings("unchecked")
	private List<String> fetchUniqueBrands()
    {
        List<String> allUniqueRecords = Collections.emptyList();
        
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dq0 = DynamicQueryFactoryUtil.forClass(Publication.class, portletClassLoader).setProjection(
                ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("chainCode")));
        try
        {
            allUniqueRecords = PublicationLocalServiceUtil.dynamicQuery(dq0);
        }
        catch (SystemException e)
        {
            LOG.error("Error while fetching unique records : " + e);
        }
        return allUniqueRecords;
    }
}
