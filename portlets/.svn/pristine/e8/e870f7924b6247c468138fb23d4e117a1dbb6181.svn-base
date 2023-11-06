/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
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
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="ProgressPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards Bridge.
 * @author MUMMANL
 */
public class ProgressPortlet extends ProgressMVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ProgressPortlet.class);

    private static final String VIEW_DETAILS_JSP = "/html/progress/view_details.jsp";
    private static final String VIEW_JSP = "/html/progress/view.jsp";
    private static final String RGN_CD_LIST[] = {"GLBL", "AMEA", "AMER", "EURO", "GC"};

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        String includeJSP = VIEW_JSP;
        PortletURL portletURL = renderResponse.createRenderURL();
        int prefRecPerPage = BridgeConstants.DEFAULT_ITEMS_PER_PAGE;
        Preferences preferences = getBridgeUserPreferences(renderRequest);
        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        PortletSession portletSession = renderRequest.getPortletSession();
        String selectedBrand = "";
        if (preferences != null)
        {
            selectedBrand = preferences.getBrand();
            prefRecPerPage = preferences.getItemsPerPage();
        }
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
            renderRequest.setAttribute("reportType", viewType);
        }
        if (localeCode != null)
        {
            portletURL.setParameter("localeCode", localeCode);
            renderRequest.setAttribute("reportLocaleCode", localeCode);
        }
        
        int tabIndx = httpRequest.getParameter("tabIndx") != null ? Integer.parseInt(httpRequest.getParameter("tabIndx")) : 0;
        if (httpRequest.getParameter("tabIndx") == null && portletSession.getAttribute("selectTabIndex") != null)
        {
            tabIndx = (Integer) portletSession.getAttribute("selectTabIndex");
        }
        portletSession.setAttribute("selectTabIndex", tabIndx);
        renderRequest.setAttribute("selectedTab", tabIndx);
        renderRequest.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
        setProgressUIElements(renderRequest, selectedBrand);

        final int pageNum = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM) == null ? 0 : Integer
                .parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM));
        SearchContainer<Standard> searchContainer = BridgeCommonUtil.getPageSearchContainer(renderRequest, portletURL, prefRecPerPage, httpRequest, pageNum);
        final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        Publication publish = getActiveBridgePublication(selectedBrand);
        String regionCode = RGN_CD_LIST[tabIndx];
        long defaultRgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        renderRequest.setAttribute("selectedRegion", regionCode);
        renderRequest.setAttribute("currentPage", "Progress");
        if(LOG.isDebugEnabled()){
        	LOG.debug("doview tabIndx-->" + tabIndx);
        }

        if ("ViewDetails".equals(requestType))
        {
            includeJSP = VIEW_DETAILS_JSP;
            setViewDetails(renderRequest, searchContainer, publish, viewType, localeCode, regionCode, defaultRgnId, pageNum);
        }
        else
        {
            includeJSP = VIEW_JSP;
            portletSession.removeAttribute("progressViewStandards");
            timeBeforePublication(renderRequest, publish);
        }
        include(includeJSP, renderRequest, renderResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        PortletSession portletSession = resourceRequest.getPortletSession();
        Preferences preferences = getBridgeUserPreferences(resourceRequest);	
        String selectedBrand = "";
        if (preferences != null)
        {
            selectedBrand = preferences.getBrand();
        }
        int tabIndx = resourceRequest.getParameter("tabIndx") != null ? Integer.parseInt(resourceRequest.getParameter("tabIndx")) : 0;
        resourceRequest.setAttribute("tabIndx", tabIndx);
        portletSession.setAttribute("selectTabIndex", tabIndx);
        resourceRequest.setAttribute("currentPage", "Progress");
        if(LOG.isDebugEnabled()){
        	LOG.debug("serveResource===tabIndx====>" + tabIndx);
        }
        Publication publish = getActiveBridgePublication(selectedBrand);
        if(publish != null && publish.getValidateTranslation() != null && publish.getValidateTranslation().equals("Y")){
        	resourceRequest.setAttribute("translationExecOverrideChecked", "checked=\"checked\"");
        }
        String regionCd = RGN_CD_LIST[tabIndx];
        long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
        
        processResourceRendering(resourceRequest, resourceResponse, publish, regionCd, rgnId);
    }

}
