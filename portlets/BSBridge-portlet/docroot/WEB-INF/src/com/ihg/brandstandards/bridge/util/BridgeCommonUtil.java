package com.ihg.brandstandards.bridge.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.bridge.model.BridgePublishAppModel;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.PublishExtStd;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

public class BridgeCommonUtil
{
    
    public static Map<TimeUnit, Long> computeTimeDiff(Date date1, Date date2)
    {
        long diffInMillies = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);
        Map<TimeUnit, Long> result = new LinkedHashMap<TimeUnit, Long>();
        long milliesRest = diffInMillies;
        for (TimeUnit unit : units)
        {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }
        return result;
    }
    
    /**
     * 
     * @param ids
     * @param seperator
     * @return String
     */
    public static String generateStringFromList (List<Long> ids, String seperator) {
        StringBuffer idString = null;
        for (long id : ids) {
            if (Validator.isNotNull(idString)) {
                idString.append(seperator);
            } else {
                idString = new StringBuffer();
            }
            idString.append(id);
        }
        return idString.toString();
    }
    
    /**
     * Get Search Container for pagination grid.
     * @param request request
     * @param portletURL portlet URL
     * @return SearchContainer
     */
    @SuppressWarnings("unchecked")
    public static SearchContainer<BridgePublishAppModel> getBridgePublishAppSearchContainer(final RenderRequest request, final RenderResponse response)
    {
        return (SearchContainer<BridgePublishAppModel>) getPageSearchContainer(request, response, "BridgePublishAppModel");
    }
    

    /**
     * Get Search Container for pagination grid.
     * @param request request
     * @param portletURL portlet URL
     * @return SearchContainer
     */
    @SuppressWarnings("unchecked")
    public static SearchContainer<Standard> getStandardsSearchContainer(final RenderRequest request, final RenderResponse response)
    {
        return (SearchContainer<Standard>) getPageSearchContainer(request, response, "Standards");
    }

    /**
     * Get Search Container for pagination grid.
     * @param request request
     * @param response response
     * @param modelName includes: BridgePublishAppModel, Standards, PublishExtStd
     * @return SearchContainer
     */
    public static SearchContainer<?> getPageSearchContainer(final RenderRequest request, final RenderResponse response, String modelName)
    {
        final PortletURL portletURL = response.createRenderURL();
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        final HttpSession session = httpRequest.getSession();
        int prefRecPerPage = 0;
        Preferences preferences = (Preferences) session.getAttribute("Preferences");
        if (preferences != null)
        {
            prefRecPerPage = preferences.getItemsPerPage();
        }
        int pageNum = 0;
        int recPerPage = 0;
        if(!ParamUtil.get(request, "crntPg", StringPool.BLANK).isEmpty() && !ParamUtil.get(request, "rcPrPg", StringPool.BLANK).isEmpty())
        {
            pageNum = ParamUtil.get(request, "crntPg", "0") == null ? 0 : Integer.parseInt(ParamUtil.get(request, "crntPg", "0"));
            recPerPage = ParamUtil.get(request, "rcPrPg", "0") == null ? 0 : Integer.parseInt(ParamUtil.get(request, "rcPrPg", "0"));
        }
        else
        {
            pageNum = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM) == null ? 0 : Integer
                    .parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_PAGE_NUM));
            recPerPage = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE) == null ? 0 : Integer
                .parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE));
        }
        
        if (recPerPage == 0 && request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM) != null)
        {
            recPerPage = ParamUtil.get(request, SearchContainer.DEFAULT_DELTA_PARAM, 0);
        }
        // first time loading page
        else if (recPerPage == 0)
        {
            recPerPage = prefRecPerPage;
        }
        
        if (pageNum == 0 && request.getParameter(SearchContainer.DEFAULT_CUR_PARAM) != null)
        {
            pageNum = ParamUtil.get(request, SearchContainer.DEFAULT_CUR_PARAM, 0);
        }
        request.setAttribute("crntPg", pageNum);

        if (prefRecPerPage != recPerPage)
        {
            UserPreferencesUtil.updateItemsPerPage(request, recPerPage);
            recPerPage = prefRecPerPage;
        }
        return getSearchContainer(request, portletURL, pageNum, recPerPage, modelName);
    }

    private static SearchContainer<?> getSearchContainer(RenderRequest request, final PortletURL portletURL,
            final int pageNum, int recPerPage, String modelName)
    {
        SearchContainer<?> searchContainer;
        
        if ("BridgePublishAppModel".equals(modelName))
        {
            //set selected group into url
        	if (Validator.isNotNull(request.getAttribute("groupName"))) {
        		portletURL.setParameter("groupName", StringPool.BLANK+request.getAttribute("groupName"));
        	}
        	//set filterby into url
        	if (Validator.isNotNull(request.getParameter("byState"))) {
        		portletURL.setParameter("byState", StringPool.BLANK+request.getParameter("byState"));
        	}
        	
        	//set filterbyID into url
        	if (Validator.isNotNull(ParamUtil.getString(request, "findId")))
        	{
        		portletURL.setParameter("findId", ParamUtil.getString(request, "findId"));
        	}
        	searchContainer = new SearchContainer<BridgePublishAppModel>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
                pageNum, recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        }
        else if ("PublishExtStd".equals(modelName))
        {
            searchContainer = new SearchContainer<PublishExtStd>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
               pageNum, recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        }
        else if ("Standards".equals(modelName))
        {
            searchContainer = new SearchContainer<Standard>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
               pageNum, recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        }
        else 
        {
            searchContainer = new SearchContainer<Object>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
                    pageNum, recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        }
        
        return searchContainer;
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
    public static SearchContainer<Standard> getPageSearchContainer(final RenderRequest request, final PortletURL portletURL,
            int prefRecPerPage, final HttpServletRequest httpRequest, final int pageNum)
    {
        int recPerPage = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE) == null ? 0 : Integer
                .parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE));
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
        SearchContainer<Standard> searchContainer = new SearchContainer<Standard>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, 
                pageNum, recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        return searchContainer;
    }

    /**
     * 
     * @param languages
     * @return String
     */
    public static String getPublicationLanguages (Map<String,String> languages) {
    	StringBuffer locales = new StringBuffer("en_GB");
    	if (languages != null && !languages.isEmpty()) {
    		Iterator<Map.Entry<String, String>> itr = languages.entrySet().iterator();
    		while(itr.hasNext()) {
    			Map.Entry<String, String> entry = itr.next();
    			if (Validator.isNotNull(entry.getValue())) {
    				for (String lang : entry.getValue().split(StringPool.COMMA)) {
    					if (!locales.toString().contains(lang)) {
    						locales.append(StringPool.COMMA);
    						locales.append(lang);
    					}
    				}
    			}
    		}
    	}
    	return locales.toString();
    }
    
}
