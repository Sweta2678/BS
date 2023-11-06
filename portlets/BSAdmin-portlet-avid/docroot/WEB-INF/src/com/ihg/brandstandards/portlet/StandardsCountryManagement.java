package com.ihg.brandstandards.portlet;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.StandardsCountry;
import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryExtPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryExtUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryPersistence;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsCountryManagementUtil;
import com.ihg.brandstandards.util.UserPreferencesUtil;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * Portlet implementation class StandardsCountryRegionPortlet
 */
public class StandardsCountryManagement extends MVCPortlet {
 
	private static final Log LOG = LogFactoryUtil.getLog(StandardsCountryManagement.class);
	protected String standardsCountryRegionJSP;
	protected String countryAttributeContent ;
	protected String unAttributeContent;
	
    @Override
    public void init() throws PortletException {
        super.init();
        standardsCountryRegionJSP = getInitParameter("country-region-jsp");
        countryAttributeContent = getInitParameter("attribute-content-jsp");
        unAttributeContent = getInitParameter("unAttribute-content-jsp");
    }

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		List<StandardsCountryExt> standardsCountryRegionList = StandardsCountryExtLocalServiceUtil.getCountryRegionList();
		renderRequest.setAttribute("standardsCountryRegionList", standardsCountryRegionList);

		final PortletURL portletURL = renderResponse.createRenderURL();
		HttpServletRequest request = getHttpServletRequest(renderRequest);
		final SearchContext searchContext = SearchContextFactory.getInstance(request);
		SearchContainer<StandardsCountryExt> searchContainer = getSearchContainer(renderRequest, portletURL, request);
		
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());
        searchContainer.setTotal(standardsCountryRegionList.size());
        standardsCountryRegionList = ListUtil.subList(standardsCountryRegionList, searchContainer.getStart(), searchContainer.getEnd());
        searchContainer.setResults(standardsCountryRegionList);
        renderRequest.setAttribute("searchContainer", searchContainer);
		
		super.doView(renderRequest, renderResponse);
	}
	
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException{
		
		String resourceId = resourceRequest.getResourceID();

		List<StandardsRegion> standardsRegions = null;
		Map<Long, String> regionMap = new LinkedHashMap<Long, String>();
		try {
			standardsRegions = StandardsRegionLocalServiceUtil.getStandardsParentRegionsList();
		} catch (Exception e) {
			LOG.error(e);
		}
		
		for(StandardsRegion region : standardsRegions)
		{
			if(!region.getRegionCode().equals(BSCommonConstants.REGION_GLBL))
			{
				regionMap.put(region.getRegionId(), region.getRegionCode());
			}
			
		}
		
		if (Validator.isNotNull(resourceId) && "createCountryRegionPopupURL".equalsIgnoreCase(resourceId)) {
			
			resourceRequest.setAttribute("stdRegionMap", regionMap);
            include(standardsCountryRegionJSP, resourceRequest, resourceResponse);
        }
		
		if (Validator.isNotNull(resourceId) && "editCountryRegionPopupURL".equalsIgnoreCase(resourceId)){
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			String countryCode = httpReq.getParameter("stdCountryCode");
			StandardsCountry country = null;
			try {
				country = StandardsCountryLocalServiceUtil.getStandardsCountry(countryCode);
			} catch (Exception e) {
				LOG.error(e);
			}
			
			long regionId = country.getRegionId();
			long subRegionId = country.getSubRegionId();
			List<StandardsRegion> subRegionList = StandardsRegionLocalServiceUtil.getSubRegionsListByParentId(regionId);
			resourceRequest.setAttribute("countryCode", countryCode);
			resourceRequest.setAttribute("regionId", regionId);
			resourceRequest.setAttribute("subRegionId", subRegionId);
			resourceRequest.setAttribute("subRegionList", subRegionList);
			resourceRequest.setAttribute("stdRegionMap", regionMap);
			include(standardsCountryRegionJSP, resourceRequest, resourceResponse);
		}
		
		if (Validator.isNotNull(resourceId) && "createAttributeContentPopupURL".equalsIgnoreCase(resourceId)){
			
			List<StandardsCountry> standardsCountryList = new ArrayList<StandardsCountry>();
			List<String> countryList = new ArrayList<String>();
			try
			{
				standardsCountryList = StandardsCountryLocalServiceUtil.getStandardsCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
			catch (SystemException e)
			{
				LOG.error(e);
			}
			
			for(StandardsCountry countries : standardsCountryList){
				countryList.add(countries.getCountryNameCode());
			}
			Collections.sort(countryList);
			resourceRequest.setAttribute("countryList", countryList);
			include(countryAttributeContent, resourceRequest, resourceResponse);
		}
		
		if (Validator.isNotNull(resourceId) && "unAttributeContentPopupURL".equalsIgnoreCase(resourceId)){
			
			List<StandardsCountry> standardsCountryList = new ArrayList<StandardsCountry>();
			List<String> countryList = new ArrayList<String>();
			try
			{
				standardsCountryList = StandardsCountryLocalServiceUtil.getStandardsCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			}
			catch (SystemException e)
			{
				LOG.error(e);
			}
			
			for(StandardsCountry countries : standardsCountryList){
				countryList.add(countries.getCountryNameCode());
			}
			Collections.sort(countryList);
			resourceRequest.setAttribute("countryList", countryList);
			include(unAttributeContent, resourceRequest, resourceResponse);
		}
		
		if(Validator.isNotNull(resourceId) && "getSuberRegionByRegionId".equalsIgnoreCase(resourceId)){
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			long regionId = Long.parseLong( httpReq.getParameter("stdRegionId"));
			
			List<StandardsRegion> subRegionList = StandardsRegionLocalServiceUtil.getSubRegionsListByParentId(regionId);
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			for(StandardsRegion region : subRegionList ){
				jsonObject.put(String.valueOf(region.getRegionId()), region.getRegionCode());
			}
			resourceResponse.getWriter().write(jsonObject.toString());
			resourceRequest.setAttribute("subRegionList", subRegionList);
			
		}
		
		if(Validator.isNotNull(resourceId) && "attributeContentAction".equalsIgnoreCase(resourceId))
		{
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			
			boolean standardsOption = false;
			boolean complianceDateOption = false;
			boolean expDateOption = false;
			boolean attachmentOption = false;
			boolean imageOption = false;
			boolean linkOption = false;
			if(httpReq.getParameterValues("stdAttributesList") != null)
			{
				String opts = httpReq.getParameter("stdAttributesList");
				String countryCodeFrom = httpReq.getParameter("attributeFromCountry");
				String countryCodeTo = httpReq.getParameter("attributeToCountry");

				String[] attOptins = opts.split(",");
				List<String> optionList = Arrays.asList(attOptins);
				for(String option : optionList)
				{
					if(option.equalsIgnoreCase("standards")){
						standardsOption = true;
					}
					else if(option.equalsIgnoreCase("complianceDates")){
						complianceDateOption = true;
					}
					else if(option.equalsIgnoreCase("expiryDates")){
						expDateOption = true;
					}
					else if(option.equalsIgnoreCase("attachments")){
						attachmentOption = true;
					}
					else if(option.equalsIgnoreCase("images")){
						imageOption = true;
					}
					else if(option.equalsIgnoreCase("links")){
						linkOption = true;
					}
				}
			String status = StandardsCountryManagementUtil.assignCountryAttributes(countryCodeFrom, countryCodeTo, standardsOption, complianceDateOption, expDateOption, attachmentOption, imageOption, linkOption);
			resourceResponse.getWriter().write(status);
			}
			
			super.serveResource(resourceRequest, resourceResponse);
		}
		
		if(Validator.isNotNull(resourceId) && resourceId.equalsIgnoreCase("unAttributeContentAction"))
		{
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			boolean standardsOption = false;
			boolean complianceDateOption = false;
			boolean expDateOption = false;
			boolean attachmentOption = false;
			boolean imageOption = false;
			boolean linkOption = false;
			
			if(httpReq.getParameterValues("stdAttributesList") != null)
			{
				String opts = httpReq.getParameter("stdAttributesList");
				String countryCode = httpReq.getParameter("unAttributeCountry");

				String[] attOptins = opts.split(",");
				List<String> optionList = Arrays.asList(attOptins);
				for(String option : optionList)
				{
					if(option.equalsIgnoreCase("standards")){
						standardsOption = true;
					}
					else if(option.equalsIgnoreCase("complianceDates")){
						complianceDateOption = true;
					}
					else if(option.equalsIgnoreCase("expiryDates")){
						expDateOption = true;
					}
					else if(option.equalsIgnoreCase("attachments")){
						attachmentOption = true;
					}
					else if(option.equalsIgnoreCase("images")){
						imageOption = true;
					}
					else if(option.equalsIgnoreCase("links")){
						linkOption = true;
					}
				}
			
			String status = StandardsCountryManagementUtil.removeCountryAttributes(countryCode, standardsOption, complianceDateOption, expDateOption, attachmentOption, imageOption, linkOption);
			resourceResponse.getWriter().write(status);
			
			super.serveResource(resourceRequest, resourceResponse);
			}
		}
		
		if(Validator.isNotNull(resourceId) && "stdCtryValidationAction".equalsIgnoreCase(resourceId))
		{
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			HttpServletRequest httpServletRequest =  PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			String countryCode = httpServletRequest.getParameter("stdCountryCode").toUpperCase();
			long regionId = Long.parseLong(httpServletRequest.getParameter("stdRegionCode"));
			long subRegionId = Long.parseLong(httpServletRequest.getParameter("stdSubRegionCode"));
			Date date = new Date();
			String hiddenCountryCode = httpServletRequest.getParameter("hiddenCountryCode");
			String status = "";
			if(Validator.isNotNull(hiddenCountryCode))
			{
				try
				{
					StandardsCountry country = StandardsCountryLocalServiceUtil.getStandardsCountry(countryCode);
					country.setRegionId(regionId);
					country.setUpdatedBy(themeDisplay.getUser().getScreenName().toUpperCase());
					country.setUpdatedDate(date);
					country.setSubRegionId(subRegionId);
					StandardsCountryLocalServiceUtil.updateStandardsCountry(country);
					status = "success";
				}
				catch (PortalException e)
				{
					LOG.error(e);
				}
				catch (SystemException e)
				{
					LOG.error(e);
				}
				
			} 
			else 
			{
				try
				{
					List<String> ctryList = StandardsCountryExtLocalServiceUtil.getAllStdCountryList();
					if(ctryList.contains(countryCode)){
						status = "Country already exists";
					}
					else
					{
						StandardsCountry country = StandardsCountryLocalServiceUtil.createStandardsCountry(countryCode.toUpperCase()); ;
						country.setRegionId(regionId);
						country.setCreatorId(themeDisplay.getUser().getScreenName().toUpperCase());
						country.setCreatedDate(date);
						country.setUpdatedDate(date);
						country.setUpdatedBy(themeDisplay.getUser().getScreenName().toUpperCase());
						country.setSubRegionId(subRegionId);
						
						StandardsCountryLocalServiceUtil.addStandardsCountry(country);
						status = "success";
					}
				}
				
				catch (SystemException e1)
				{
					LOG.error(e1);
				}
			}
			StandardsCountryLocalServiceUtil.clearCache();
			BrandStandardsUtil.newCountryListObject();
			resourceResponse.getWriter().write(status);
			super.serveResource(resourceRequest, resourceResponse);
	}
}
	
	
	
	private HttpServletRequest getHttpServletRequest(PortletRequest portletRequest)
    {
        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);
        return PortalUtil.getOriginalServletRequest(httpServletRequest);
    }
	
	 private SearchContainer<StandardsCountryExt> getSearchContainer(RenderRequest request, final PortletURL portletURL,
         final HttpServletRequest httpRequest){
		 
	        SearchContainer<StandardsCountryExt> searchContainer;
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

	        int pageNum = request.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? 0 : 
	            Integer.parseInt(request.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
	        if (pageNum == 0)
	        {
	            pageNum = request.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? 1 : 
	                Integer.parseInt(request.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
	        }

	        if (prefRecPerPage != recPerPage)
	        {
	            UserPreferencesUtil.updateItemsPerPage(request, recPerPage);
	            recPerPage = prefRecPerPage;
	        }
	        searchContainer = new SearchContainer<StandardsCountryExt>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
	                recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
	        
	        return searchContainer;
	    }
 
}
