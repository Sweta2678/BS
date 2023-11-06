/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
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
import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.service.BridgePublishCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * <a href="UnpublishPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards Bridge.
 * @author KODIS
 */
public class UnpublishPortlet extends BrandStandardsBridgePortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(UnpublishPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
    	BridgeApplicationImpl bridgeApplicationImpl = new BridgeApplicationImpl();
        PortletURL portletURL = renderResponse.createRenderURL();
        int prefRecPerPage = BridgeConstants.DEFAULT_ITEMS_PER_PAGE;
        Preferences preferences = getBridgeUserPreferences(renderRequest);
        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        HttpSession session = getHttpSession(httpRequest);
        PortletSession portletSession = renderRequest.getPortletSession();
        String brandCode = null;
        String regionCode = null;
        if (preferences != null)
        {
        	brandCode = preferences.getBrand();
        	regionCode = preferences.getRegionCode();
            prefRecPerPage = preferences.getItemsPerPage();
        }
        final int pageNum = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM) == null ? 0 : 
            Integer.parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM));
        SearchContainer<Standard> searchContainer = BridgeCommonUtil.getPageSearchContainer(renderRequest, portletURL, prefRecPerPage, httpRequest, pageNum);
        final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        Publication publish = getActiveBridgePublication(brandCode);
        if(publish  != null){
	        long publishId = publish.getPublishId();
	        long defaultRgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
	        String stdIds = ParamUtil.getString(renderRequest, "findByStdId");
	        List<Standard> viewDetailsStandards = bridgeApplicationImpl.getUnpublishedStandardsViewDetails(publishId, defaultRgnId, brandCode, regionCode, stdIds);
	        if (viewDetailsStandards == null || viewDetailsStandards.size() <= 0) {
	        	renderRequest.setAttribute("showExportButton", "NO");
	        } else {
	        	renderRequest.setAttribute("showExportButton", "YES");
	        }
	        if(Validator.isNotNull(stdIds)){
	        	addStdIdToSession(session, viewDetailsStandards, true);
	        }
	        else{
	        	session.setAttribute("stdIdLst", "All");
	        }
	        setActionDetails(renderRequest, portletSession, viewDetailsStandards, searchContainer, pageNum);
	        renderRequest.setAttribute("findId", stdIds);
	        renderRequest.setAttribute("regionCode", regionCode);
        } else {
        	renderRequest.setAttribute("displayNoPublishMessage", true);
        }
        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = "moveToPublish")
    public void moveToPublish(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long publishId = -1;
		long regionId = -1;
		String standardId = ParamUtil.getString(actionRequest, "stdId");
		User user = themeDisplay.getUser();
		Preferences preferences = getBridgeUserPreferences(actionRequest);
		if (preferences != null) {
			Publication publish = getActiveBridgePublication(preferences.getBrand());
			publishId = publish.getPublishId();
			regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(preferences.getRegionCode());
		} else {
			LOG.error("User must have preferences! User name = "+ themeDisplay.getUser().getScreenName());
		}

		try 
		{
			if(Validator.isNotNull(standardId)){
    			BridgePublishLocalServiceUtil.updateUnpublishedToPublishedRecords(publishId, preferences.getBrand(), regionId, 
					themeDisplay.getUser().getScreenName(), standardId);
    			//GEM Unique groups
                //addRequestInQueue(publishId, regionId, BridgeConstants.SA_REPORT_TYPE, preferences, user);
                //Bridge Unique groups
                addRequestInQueue(publishId, regionId, BridgeConstants.BRIDGE_GROUPS_TYPE, preferences, user);
                
    	        BridgePublishLocalServiceUtil.clearCache();
    	        BridgePublishCountryLocalServiceUtil.clearCache();
			}
		} catch (Exception e) {
			LOG.error("Exception: ", e);
		}

	}
    
    protected void setActionDetails(final RenderRequest renderRequest, final PortletSession portletSession,
            final List<Standard> viewDetailsStandards, SearchContainer<Standard> searchContainer, final int pageNum)
    {
        searchContainer.setTotal(viewDetailsStandards.size());
        List<Standard> viewDetailDisplayList = ListUtil.subList(viewDetailsStandards, searchContainer.getStart(), searchContainer.getEnd());
        searchContainer.setResults(viewDetailDisplayList);
        renderRequest.setAttribute("searchContainer", searchContainer);
        renderRequest.setAttribute("curPageNum",
                renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? String.valueOf(pageNum) : renderRequest
                        .getParameter(SearchContainer.DEFAULT_CUR_PARAM));
    }

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
        final String resourceID = resourceRequest.getResourceID();
        Preferences userPref = getBridgeUserPreferences(resourceRequest);
        String chainCode = "";
        String regionCode = "";
        if (userPref != null)
        {
            chainCode = userPref.getBrand();
            regionCode = userPref.getRegionCode();
        }

        if ("createReport".equals(resourceID))
        {
            try
            {
                submitReportRequest(resourceRequest, resourceResponse, true);
            }
            catch (IOException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        else if ("regionCountryList".equals(resourceID))
        {
            long stdId = ParamUtil.getLong(resourceRequest, "stdId");
            long regionId = BrandStandardsUtil.getRegionId(regionCode);
            try 
            {
                Map<String, List<String>> subRegionCountryMap = BrandStandardsUtil.getSubRegionCountriesForRegion(regionCode);
                Map<String, String> countryNameMap = BrandStandardsUtil.getCountryNamesForRegion(regionCode);
                Map<String, StandardsCountryExt> countryDetailMap = new LinkedHashMap<String, StandardsCountryExt>();
                List<StandardsCountryExt> countryList = StandardsCountryExtLocalServiceUtil.getRegionBasedCountryStatus(stdId, chainCode, regionId);
                for (StandardsCountryExt cntry : countryList)
                {
                    countryDetailMap.put(cntry.getCountryCode(), cntry);
                }
                HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
                HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
                httpRequest.setAttribute("regionCode",regionCode);
                httpRequest.setAttribute("subRegionCountryMap", subRegionCountryMap);
                httpRequest.setAttribute("countryDetailMap", countryDetailMap);
                httpRequest.setAttribute("countryNameList", countryNameMap);
                include("/html/unpublish/ctryPopup.jsp", resourceRequest, resourceResponse);
            }
            catch (IOException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            catch (PortletException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            } catch (SystemException e) 
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
    }
    
    @Override
    protected String submitReportRequest(String reportId, String title, String brandCode, String regionCode, long regionId,
            String stdIdLst, long publishId, String userFullName, String screenName, String email)
    {
        String returnMsg = "Success";
        
        StringBuilder metadata = new StringBuilder();
        metadata.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><metadata>");
        metadata.append("<type>").append(BridgeConstants.REPORT_TYPE_UNPUBLISH_XLS_REPORT).append("</type>");
        metadata.append("<params>");
        metadata.append("<param name=\"ENVIRONMENT\">").append(BridgeConstants.BRIDGE_ENVIRONMENT).append("</param>");
        metadata.append("<param name=\"REPORT_ID\">").append(reportId).append("</param>");
        metadata.append("<param name=\"REPORT_TITLE\">").append(title).append("</param>");
        metadata.append("<param name=\"REPORT_TYPE\">").append(BridgeConstants.REPORT_TYPE_UNPUBLISH_XLS_REPORT).append("</param>");
        metadata.append("<param name=\"USER_PREF_LOCALE_CD\">").append(BridgeConstants.METADATA_PARAM_DEF_LANG).append("</param>");
        metadata.append("<param name=\"USER_NAME\">").append(userFullName).append("</param>");
        metadata.append("<search name=\"SEARCH_CRITERIA\">" );
        metadata.append("<field name=\"publishId\">").append(publishId).append("</field>");
        if (stdIdLst != null && !stdIdLst.isEmpty())
        {
            metadata.append("<field name=\"standardsIds\">").append(stdIdLst).append("</field>");
        }
        metadata.append("<field name=\"regionCd\">").append(regionCode).append("</field>");
        metadata.append("<field name=\"regionId\">").append(regionId).append("</field>");
        metadata.append("<field name=\"reportId\">").append(reportId).append("</field>");
        metadata.append("<field name=\"defaultLangLocaleCd\">").append(BridgeConstants.METADATA_PARAM_DEF_LANG).append("</field>");
        metadata.append("<field name=\"preferedBrand\">").append(brandCode).append("</field>");
        metadata.append("</search>");
        metadata.append("</params>");
        metadata.append("</metadata>");

        try 
        {
            //PublishQueueLocalServiceUtil.createReport(metadata.toString(), screenName, email);
        	JobQueueLocalServiceUtil.addNewJobRequest(BridgeConstants.REPORT_TYPE_UNPUBLISH_XLS_REPORT, metadata.toString(), screenName, email);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            returnMsg = "ERROR";
        }
        return returnMsg;
    }
}
