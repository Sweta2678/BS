package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.bridge.application.BridgeApplication;
import com.ihg.brandstandards.bridge.application.impl.BridgeApplicationImpl;
import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.ProgressPortletUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Portlet implementation class MyPublicationErrorDetailsPortlet
 */
public class MyPublicationErrorDetailsPortlet extends ProgressMVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(MyPublicationErrorDetailsPortlet.class);
    
    private static final String ERR_DETAILS_CACHE = "ERR_DETAILS_CACHE";
    
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        String brandCode = "";
        String regionCode = "";
        Preferences preferences = getBridgeUserPreferences(renderRequest);

        if (preferences != null)
        {
            brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
            renderRequest.setAttribute("regionCode", regionCode);
            setProgressUIElements(renderRequest, brandCode);
        }

        Publication publish = getActiveBridgePublication(brandCode);
        if (publish != null)
        {
            long bridgePublishId = publish.getPublishId();
            renderRequest.setAttribute("activePublishId", bridgePublishId);
            long arhivePublishId = getLatestArchivePublishId(brandCode, BSCommonConstants.PUBLISH_ENV_BRIDGE);
            renderRequest.setAttribute("arhivePublishId", arhivePublishId);

            HttpServletRequest httpRequest = getHttpRequest(renderRequest);
            final int pageNum = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM) == null ? 0 : 
                Integer.parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM));
            final PortletURL portletURL = renderResponse.createRenderURL();
            SearchContainer<Standard> searchContainer = BridgeCommonUtil.getPageSearchContainer(renderRequest, portletURL, BridgeConstants.DEFAULT_ITEMS_PER_PAGE, httpRequest, pageNum);
            final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
            searchContext.setStart(searchContainer.getStart());
            searchContext.setEnd(searchContainer.getEnd());

            long regionId = BrandStandardsUtil.getRegionId(regionCode);
            setViewDetails(renderRequest, searchContainer, publish, null, null, regionCode, regionId, pageNum);
        }
        else
        {
            renderRequest.setAttribute("displayNoPublishMessage", true);
        }

        super.doView(renderRequest, renderResponse);
    }
    
    protected void setViewDetails(PortletRequest portletRequest, SearchContainer<Standard> searchContainer, Publication publish, 
            String viewType, String localeCode, String regionCode, long regionId, int pageNumber) {
        PortletSession portletSession = portletRequest.getPortletSession();
        List<Standard> viewDetailsStandards = null;

        int curPage = portletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? pageNumber : Integer.parseInt(portletRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
        if (curPage <= 1)
        {
            BridgeApplication bridgeApp = new BridgeApplicationImpl();
            viewDetailsStandards = bridgeApp.getStandardsForProgressViewDetails(publish, regionId, viewType, localeCode, BridgeConstants.STAT_IND_ALL);
            portletSession.setAttribute(ERR_DETAILS_CACHE, viewDetailsStandards);
        }
        else if(portletSession.getAttribute(ERR_DETAILS_CACHE) != null)
        {
            viewDetailsStandards = (List<Standard>) portletSession.getAttribute(ERR_DETAILS_CACHE);
        }
        
        if (viewDetailsStandards == null)
        {
            viewDetailsStandards = new ArrayList<Standard>();
            portletRequest.setAttribute("showExportButton", "NO");
        } 
        
        if (viewDetailsStandards == null || viewDetailsStandards.size() <= 0)
        {
            portletRequest.setAttribute("showExportButton", "NO");
        } 
        else 
        {
            portletRequest.setAttribute("showExportButton", "YES");
        }
        
        portletRequest.setAttribute("indicatorStyle", "label-important");
        setResultsToSearchContainer(portletRequest, viewDetailsStandards, searchContainer, regionCode, pageNumber);
    }

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException 
	{
		if ("exportErrorReport".equals(resourceRequest.getResourceID()))
		{
			handleExportErrorDetailReport(resourceRequest, resourceResponse);
		} 
		else if ("deleteStd".equals(resourceRequest.getResourceID()))
        {
            deleteStd(resourceRequest, resourceResponse);
        } 
		else 
		{
			super.serveResource(resourceRequest, resourceResponse);
		}
	}

	private void deleteStd(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException
    {
	    ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
//        User user = themeDisplay.getUser();
        HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
        HttpSession session = getHttpSession(request);
	    long stdId = ParamUtil.get(resourceRequest, "stdId", 0L);
        Preferences preferences = getBridgeUserPreferences(resourceRequest);
	    
	    if (LOG.isDebugEnabled()) 
	    {
	        LOG.debug("DELETE STD: " + stdId);
	    }
        
        if (preferences != null && stdId > 0L) 
        {
	        String brandCode = preferences.getBrand();
	        String regionCode = preferences.getRegionCode();
            deleteStandardFromMyPublication(themeDisplay, session, preferences, stdId, brandCode, regionCode);
/*
	        BridgePublishApplicationImpl bridgePublishApp = new BridgePublishApplicationImpl();
	        bridgePublishApp.deleteStandards(stdId, regionCode, brandCode);
	      //Remove update preview country group list from session
	        removeUpdatePreviewSessionAttributes(session, themeDisplay.getUserId());
	      //Create gem unique groups
	        long regionId = BrandStandardsUtil.getRegionId(regionCode);
	        long bridgePublishId = getBridgePublishId(brandCode);
	        Processor processor = ProcessorFactory.getProcessorObject("SA");
	        String compareMetadata = processor.generateMetadata(brandCode, preferences.getRegionCode(), 
	                regionId, bridgePublishId, BridgeConstants.SA_REPORT_TYPE, StringPool.PERCENT);
	        //If job que request is in queue then do not create new request
	        if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetadata, StringPool.PERCENT, 
	                BridgeConstants.JOB_TYPE_COUNTRY_GROUP, BridgeConstants.QUEUE_NEW_STATUS)) 
	        {
	            processor.addMessageInQueue(BridgeConstants.JOB_TYPE_COUNTRY_GROUP, bridgePublishId, BridgeConstants.SA_REPORT_TYPE, preferences, user);
	        }
*/
        }
        else
        {
            LOG.error("Failed to find publication on deleteStd. DB error?");
            throw new PortletException("Faield to delete record with std id = " + stdId);
        }
    }

    /**
	 * Handle request for export error report.
	 * @param resourceRequest request
	 * @param resourceResponse response
	 */
    private void handleExportErrorDetailReport(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException
    {
        if (LOG.isDebugEnabled()) {
        	LOG.debug("export detail error report");
        }

        String brandCode = "";
        String regionCode = "";
        Publication publish = null;
        
        Preferences preferences = getBridgeUserPreferences(resourceRequest);
        if (preferences != null)
        {
            brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
            publish = getActiveBridgePublication(brandCode);
        }
        
        if (publish != null) 
        {
            OutputStream outputStream = null;
        	try {
                HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
                HttpServletRequest request = PortalUtil.getOriginalServletRequest(httpServletRequest);
                //My publication error detail report title
                String reportTitle = ParamUtil.get(request, "reportTitle", BridgeConstants.EXPORT_REPORT_TITLE);
                long regionId = BrandStandardsUtil.getRegionId(regionCode);

                Workbook workbook =	exportDetailReport(reportTitle, regionId, publish);
        		resourceResponse.setContentType("application/vnd.ms-excel");
        		resourceResponse.addProperty("Content-Disposition", "attachment; filename=" + reportTitle + ".xls");
        		outputStream = resourceResponse.getPortletOutputStream();
                workbook.write(outputStream);
                outputStream.flush();
                outputStream.close();
        	} catch (Exception e) {
        		LOG.error(e.getMessage(), e);
        		throw new PortletException("Faield to generate report");
        	} finally {
        		try {
        			if (outputStream != null) {
        				outputStream.close();
        			}
        		} catch (IOException e) {
        			LOG.error(e.getMessage(), e);
        		}
        	}
        }
        else
        {
            LOG.error("Failed to find publication on handleExportErrorDetailReport. DB error?");
            throw new PortletException("Faield to generate report");
        }
    }
	
	/**
	 * 
	 * @param reportTitle
	 * @param resourceResponse
	 */
	private Workbook exportDetailReport (String reportTitle, long regionId, Publication publish) 
	{
		List<Standard> viewDetailsStandards = null;
		BridgeApplication bridgeApp = new BridgeApplicationImpl();
        viewDetailsStandards = bridgeApp.getStandardsForProgressViewDetails(publish, regionId, null, null, BridgeConstants.STAT_IND_ALL);
		Workbook workbook = ProgressPortletUtil.exportStandardsErrorReport(reportTitle, viewDetailsStandards);
		return workbook;
	}
    
}
