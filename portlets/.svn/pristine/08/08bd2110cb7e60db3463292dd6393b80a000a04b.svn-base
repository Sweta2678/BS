/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
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

import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.me2.utils.session.MerlinCache;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * <a href="SummaryPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards Bridge.
 * @author MUMMANL
 */
public class SummaryPortlet extends ProgressMVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(SummaryPortlet.class);
    private static final String VIEW_DETAILS_JSP = "/html/progress/view_details.jsp";
    private static final String VIEW_JSP = "/html/summary/view.jsp";

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        if (MerlinCache.getCacheMap("IHG_TICKER_DATA") != null) 
        {
            Map<String, Object> tickerMap = MerlinCache.getCacheMap("IHG_TICKER_DATA");
            Map<String, String> valueMap = (Map<String, String>) tickerMap.get("SECURITY_VALUES");
            LOG.info("\n\n IHG Ticker:");
            for (Map.Entry<String, String> entry : valueMap.entrySet())
            {
                LOG.info(entry.getKey() + " = " + entry.getValue());
            }
            LOG.info("\n\n");
        }
        
        
        String includeJSP = VIEW_JSP;
        final PortletURL portletURL = renderResponse.createRenderURL();
        SearchContainer<Standard> searchContainer;
        String brandCode = null;
        String regionCode = null;
        int prefRecPerPage = BridgeConstants.DEFAULT_ITEMS_PER_PAGE;
        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        Preferences preferences = getBridgeUserPreferences(renderRequest);
        if (preferences != null)
        {
            brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
            prefRecPerPage = preferences.getItemsPerPage();
        }
        if(LOG.isDebugEnabled())
        {
        	LOG.debug("doview selectedRegion-->" + regionCode);
        }
        
        String glblRegionCode = httpRequest.getParameter("rgnCd");
        
        if (glblRegionCode != null && "GLBL".equals(regionCode) && !"GLBL".equals(glblRegionCode))
        {
            renderRequest.setAttribute("regionCode", glblRegionCode);
        }
        else 
        {
            renderRequest.setAttribute("regionCode", regionCode);
        }
        setProgressUIElements(renderRequest, brandCode);
        
        String requestType = renderRequest.getParameter("requestType");
        String viewType = renderRequest.getParameter("viewType");
        String localeCode = httpRequest.getParameter("localeCode");
        if (requestType == null)
        {
            requestType = httpRequest.getParameter("requestType");
        }
        if (viewType == null)
        {
        	viewType = httpRequest.getParameter("viewType");
        }
        if (localeCode == null)
        {
            localeCode = renderRequest.getParameter("localeCode");
        }
        
        if (requestType != null)
        {
            portletURL.setParameter("requestType", requestType);
        }
        if (viewType != null)
        {
            portletURL.setParameter("viewType", viewType);
        }
        if (localeCode != null)
        {
            portletURL.setParameter("localeCode", localeCode);
        }
        renderRequest.setAttribute("reportLocaleCode", localeCode);
        renderRequest.setAttribute("reportType", viewType);
        renderRequest.setAttribute("currentPage", "Summary");
        
        final int pageNum = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM) == null ? 0 : Integer
                .parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM));
        searchContainer = BridgeCommonUtil.getPageSearchContainer(renderRequest, portletURL, prefRecPerPage, httpRequest, pageNum);
        final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        long defaultRgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        Publication publish = getActiveBridgePublication(brandCode);
        if (publish != null && publish.getPublishId() > 0)
        {
            renderRequest.setAttribute("activePublishId", publish.getPublishId());
            long arhivePublishId = getLatestArchivePublishId(brandCode, BSCommonConstants.PUBLISH_ENV_BRIDGE);
            renderRequest.setAttribute("arhivePublishId", arhivePublishId);
        }
        PortletSession portletSession = renderRequest.getPortletSession();

        if ("ViewDetails".equals(requestType))
        {
            includeJSP = VIEW_DETAILS_JSP;
            setViewDetails(renderRequest, searchContainer, publish, viewType, localeCode, regionCode, defaultRgnId, pageNum);
        }
        else
        {
            includeJSP = VIEW_JSP;
            portletSession.removeAttribute("summaryViewStandards");
            timeBeforePublication(renderRequest, publish);
        }
        include(includeJSP, renderRequest, renderResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        resourceRequest.setAttribute("tabIndx", -1);
        resourceRequest.setAttribute("currentPage", "Summary");
        String requestType = ParamUtil.getString(resourceRequest, "requestType");
        
        if ("createReport".equals(requestType))
        {
            submitReportRequest(resourceRequest, resourceResponse, false);
        }
        else
        {
            Preferences preferences = getBridgeUserPreferences(resourceRequest);
            if (preferences != null)
            {
                String selectedBrand = preferences.getBrand();
                String regionCd = preferences.getRegionCode();
    
                Publication publish = getActiveBridgePublication(selectedBrand);
                if(publish != null && publish.getValidateTranslation() != null && publish.getValidateTranslation().equals("Y")){
                	resourceRequest.setAttribute("translationExecOverrideChecked", "checked=\"checked\"");
                }
                long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
                processResourceRendering(resourceRequest, resourceResponse, publish, regionCd, rgnId);
            }
            else
            {
                LOG.error("User must have preferences! User name = " + themeDisplay.getUser().getScreenName());
            }
        }
    }

    @ProcessAction(name = "resetPublication")
    public void resetPublication(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Preferences preferences = getBridgeUserPreferences(actionRequest);
        if (preferences != null)
        {
        	Publication publish = getActiveBridgePublication(preferences.getBrand());
            long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(preferences.getRegionCode());
    
            if (publish != null)
            {
                try
                {
                    BridgePublishLocalServiceUtil.resetBridgePublication(publish.getPublishId(), rgnId, publish.getChainCode(), themeDisplay.getUser().getScreenName());
                }
                catch (SystemException e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                    throw new PortletException(e);
                }
            }
        }
        else
        {
            LOG.error("User must have preferences! User name = " + themeDisplay.getUser().getScreenName());
        }
    }

}
