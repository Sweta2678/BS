package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.bridge.application.impl.BridgeApplicationImpl;
import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

public class ViewCompliancePortlet extends BrandStandardsBridgePortlet 
{
    private static final Log LOG = LogFactoryUtil.getLog(ViewCompliancePortlet.class);
    
    private static final String REQUEST_VIEW_COMPLIANCE = "ViewCompliance";

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        String brandCode = null;
        String regionCode = null;
        Preferences preferences = getBridgeUserPreferences(renderRequest);
        if (preferences != null)
        {
            brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
        }

        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        String requestType = httpRequest.getParameter("requestType");
        if (REQUEST_VIEW_COMPLIANCE.equals(requestType))
        {
            processViewComplianceCountriesRequest(renderRequest, renderResponse, brandCode, regionCode, httpRequest);
        }
        else 
        {
            processViewRequest(renderRequest, renderResponse, brandCode, regionCode, httpRequest);
        }
    }

    /**
     * Process view Compliance Deadline request and load listing page.
     * @param renderRequest request
     * @param renderResponse response
     * @param brandCode Brand
     * @param regionCode Region
     * @param httpRequest HTTP request
     * @throws IOException exception
     * @throws PortletException exception
     */
    private void processViewRequest(RenderRequest renderRequest, RenderResponse renderResponse, String brandCode, String regionCode,
            HttpServletRequest httpRequest) throws PortletException, IOException
    {
        Publication publish = getActiveBridgePublication(brandCode);
        if (publish != null && publish.getPublishDate() != null)
        {
            renderRequest.setAttribute("activePublish", true);
        }
        List<Standard> standards = getStandards(renderRequest, renderResponse, brandCode, regionCode);
        SearchContainer<Standard> searchContainer = BridgeCommonUtil.getStandardsSearchContainer(renderRequest, renderResponse);
        final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
        searchContainer.setTotal(standards.size());
        standards = ListUtil.subList(standards, searchContainer.getStart(), searchContainer.getEnd());
        searchContainer.setResults(standards);
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());
        searchContainer.setEmptyResultsMessage("No Standards Available");
        renderRequest.setAttribute("searchContainerObj", searchContainer);
        
        int reportId = 119;
        if( "AMEA".equals(regionCode))
        {
            reportId = 136;
        }
        else if( "AMER".equals(regionCode))
        {
            reportId = 137;
        }
        else if( "EURO".equals(regionCode))
        {
            reportId = 138;
        }
        else if( "GC".equals(regionCode))
        {
            reportId = 139;
        }
        renderRequest.setAttribute("reportId", reportId);
            
        super.doView(renderRequest, renderResponse);
    }

    /**
     * Process View Compliance Deadline request and load edit page.
     * @param renderRequest request
     * @param renderResponse response
     * @param brandCode Brand
     * @param regionCode Region
     * @param httpRequest HTTP request
     * @throws IOException exception
     * @throws PortletException exception
     */
    private void processViewComplianceCountriesRequest(RenderRequest renderRequest, RenderResponse renderResponse, String brandCode, String regionCode,
            HttpServletRequest httpRequest) throws IOException, PortletException
    {
    	Long stdId = httpRequest.getParameter("stdId") != null ? Long.parseLong(httpRequest.getParameter("stdId")) : 0L;
        //Bellow parameters are for Filter & Search
        String pageNum = httpRequest.getParameter("pageNum");
        String  selectDate = httpRequest.getParameter("selectDate");
        String  searchById = httpRequest.getParameter("searchById");
        String  dateInputFrom = httpRequest.getParameter("dateInputFrom");
        String  dateInputTo = httpRequest.getParameter("dateInputTo");
        
        try
        {
            com.ihg.brandstandards.db.model.Standards std = StandardsLocalServiceUtil.getStandards(stdId);
            Map<String, List<String>> subRegionCountryMap = BrandStandardsUtil.getSubRegionCountriesForRegion(regionCode);
            Map<String, String> countryNameMap = BrandStandardsUtil.getCountryNamesForRegion(regionCode);
            Map<String, String> ctryDateMap = BridgePublishLocalServiceUtil.getBridgeStandardComplianceDetails(stdId, brandCode, regionCode);
            String stdType = BrandStandardsUtil.STD_TYPE_STANDARD.equals(std.getStdTyp()) ? "Standard" : "Specification";
            renderRequest.setAttribute("ctryDateMap", ctryDateMap);
            renderRequest.setAttribute("stdId", stdId);
            renderRequest.setAttribute("stdTitle", std.getTitle());
            renderRequest.setAttribute("stdType", stdType);
            renderRequest.setAttribute("pageNum", pageNum);
            renderRequest.setAttribute("selectDate", selectDate);
            renderRequest.setAttribute("searchById", searchById);
            renderRequest.setAttribute("dateInputFrom", dateInputFrom);
            renderRequest.setAttribute("dateInputTo", dateInputTo);
            String regionName = getRegionName(regionCode);
            renderRequest.setAttribute("region", regionName);
            renderRequest.setAttribute("subRegionCountryMap", subRegionCountryMap);
            renderRequest.setAttribute("countryNameMap", countryNameMap);
            super.doEdit(renderRequest, renderResponse);
        }
        catch (SystemException e)
        {
            LOG.error("Exception on get compliance deadline for countries for StdId: " + stdId, e);
            throw new PortletException(e);
        }
        catch (PortalException e)
        {
            LOG.error("Exception on get Standard for StdId: " + stdId, e);
            throw new PortletException(e);
        }
    }
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
        String requestType = resourceRequest.getParameter("requestType");
        
        if ("exportComplianceReport".equals(requestType))
        {
            submitReportRequest(resourceRequest, resourceResponse, true);
        }
    }

    /**
     * Convert string date to Date.
     * @param dateStr date string
     * @return Date
     * @throws PortletException exception
     */
    private Date getComplianceDate(String dateStr) throws PortletException
    {
        Date date = null;
        if (dateStr != null && !dateStr.isEmpty())
        {
            try
            {
                date = BridgeConstants.DEFAULT_DATE_FORMATTER.parse(dateStr);
            }
            catch (ParseException e)
            {
                try
                {
                    date = BridgeConstants.USA_DATE_FORMATTER.parse(dateStr);
                }
                catch (ParseException e1)
                {
                    throw new PortletException("Invalid Date Format", e1);
                }

            }
        }
        return date;
    }
    
    /**
     * This method handles search.
     * @param actionRequest request
     * @param actionResponse response
     * @throws IOException exception
     * @throws PortletException exception
     */
    public void FilterData(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        PortalUtil.copyRequestParameters(actionRequest, actionResponse);
    }

   /**
     * Get Standards from database.
     * @param request request request
     * @param response response response
     * @param brandCode brand brand code
     * @param regionCode region region code
     * @throws PortletException exception
     */
    private List<Standard> getStandards(RenderRequest request, RenderResponse response, String brandCode, String regionCode) throws PortletException
    {       
        List<Standard> standards = new ArrayList<Standard>();
        try
        {
            String stdType = null;
            String ids = request.getParameter("searchById");
            List<Long> stdIds = getStdIds(ids);
            
            String fromDate = null;
            String toDate = null;
            String selectDate = request.getParameter("selectDate");
            if ("between".equals(selectDate))
            {
                fromDate = getDate(request.getParameter("dateInputFrom"));
                toDate = getDate(request.getParameter("dateInputTo"));
                request.setAttribute("filterBy", selectDate);
                request.setAttribute("fromDate", request.getParameter("dateInputFrom"));
                request.setAttribute("toDate", request.getParameter("dateInputTo"));
            } 
            else if ("week".equals(selectDate) || "month".equals(selectDate) || "quarter".equals(selectDate))
            {
                fromDate = getCurrentDate();
                toDate = getDateFromNow(selectDate);
                request.setAttribute("filterBy", selectDate);
            }
            
            List<PublishStandardsExt> stdLst = BridgePublishLocalServiceUtil.getBridgeStandardsCompliance(stdIds, stdType, brandCode, regionCode, fromDate, toDate);
            BridgeApplicationImpl application = new BridgeApplicationImpl();
            standards = application.getSortedStandards(stdLst);
            
            if (stdIds != null && !stdIds.isEmpty())
            {
                request.setAttribute("searchPerformed", true);
                request.setAttribute("findById", ids);
                StringBuffer searchIdsHighlight = new StringBuffer();
                for (String id : ids.split(" "))
                {
                    if (Validator.isNull(searchIdsHighlight.toString())) {
                    	searchIdsHighlight.append("'");
                    	searchIdsHighlight.append(id.trim());
                    	searchIdsHighlight.append("'");
                    } else {
                    	searchIdsHighlight.append(",'");
                    	searchIdsHighlight.append(id.trim());
                    	searchIdsHighlight.append("'");
                    }
                }
                request.setAttribute("highlightSearchIds", searchIdsHighlight.toString());
            }
            
            // List of std_id for reporting should be set on session before filter apply
            if(ids == null && selectDate == null)
            {
                HttpServletRequest httpRequest = getHttpRequest(request);
                HttpSession session = getHttpSession(httpRequest);
                addStdIdToSession(session, standards, false);
            }

        }
        catch (SystemException e)
        {
            LOG.error("Error while fetching standards: " + e.getMessage());
        }
        return standards;
    }

    private List<Long> getStdIds(String ids)
    {
        List<Long> stdIds = null;
        if (ids != null && !ids.isEmpty())
        {
            String[] idArr = ids.trim().split("\\s+");
            stdIds = new ArrayList<Long>();
            for (String id : idArr)
            {
                stdIds.add(Long.parseLong(id));
            }
        }
        return stdIds;
    }
    
    private String getDate(String dateStr)
    {
        Date date;
        try
        {
            date = getComplianceDate(dateStr);
        }
        catch (PortletException e)
        {
            date = null;
        }
            
        return date == null ? null : BridgeConstants.DEFAULT_DATE_FORMATTER.format(date);
    }

    private String getDateToString(Date date)
    {
        if (date != null)
        {
            return BridgeConstants.DEFAULT_DATE_FORMATTER.format(date);
        }
        return null;
    }

    private String getCurrentDate()
    {
        return BridgeConstants.DEFAULT_DATE_FORMATTER.format(new Date()); 
    }

    private String getDateFromNow(String condition)
    {
        String newDate = null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        
        if ("week".equals(condition))
        {
            cal.add(Calendar.DATE, 7);
            newDate = BridgeConstants.DEFAULT_DATE_FORMATTER.format(cal.getTime());
        }
        else if ("month".equals(condition))
        {
            cal.add(Calendar.MONTH, 1);
            newDate = BridgeConstants.DEFAULT_DATE_FORMATTER.format(cal.getTime());
        }
        else if ("quarter".equals(condition))
        {
            cal.add(Calendar.MONTH, 3);
            newDate = BridgeConstants.DEFAULT_DATE_FORMATTER.format(cal.getTime());
        }
        
        return newDate;
    }
    
}
