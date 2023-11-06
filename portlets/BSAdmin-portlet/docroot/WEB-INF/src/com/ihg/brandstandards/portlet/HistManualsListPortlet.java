package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.UserPreferencesUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * @author SengarA
 * 
 */
public class HistManualsListPortlet extends GenericPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(HistManualsListPortlet.class);

    /**
     * Overwrite view method.
     */
    public void doView(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException
    {
        SearchContainer<HistManuals> searchContainer = null;
        try
        {
            final PortletURL portletURL = renderResponse.createRenderURL();
            final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
            final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
            final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
            searchContainer = getSearchContainer(request, portletURL, httpRequest);
            searchContext.setStart(searchContainer.getStart());
            searchContext.setEnd(searchContainer.getEnd());
            List<HistManuals> arlManuals = HistManualsLocalServiceUtil.getManuals();
            searchContainer.setTotal(arlManuals.size());

            arlManuals = ListUtil.subList(arlManuals, searchContainer.getStart(), searchContainer.getEnd());
            searchContainer.setResults(arlManuals);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        request.setAttribute("searchContainer", searchContainer);
        final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher("/html/manuals/view.jsp");
        reqDisp.include(request, renderResponse);
    }

    /**
     * Get Search Container for pagination grid.
     * @param request request
     * @param portletURL portlet URL
     * @param httpRequest  http request
     * @return SearchContainer
     */
    private SearchContainer<HistManuals> getSearchContainer(RenderRequest request, final PortletURL portletURL,
            final HttpServletRequest httpRequest)
    {
        SearchContainer<HistManuals> searchContainer;
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
        searchContainer = new SearchContainer<HistManuals>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
                recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        return searchContainer;
    }

    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        resourceResponse.setContentType("text/html");
        String json;
        final PrintWriter out = resourceResponse.getWriter();
        try
        {
            final String manualId = (String) resourceRequest.getParameter("manualId");
            LOG.debug("histanualId=====>>>>>" + manualId);
            final HistManuals histManualObj = HistManualsLocalServiceUtil.getHistManuals(Long.parseLong(manualId));
            final String prevStatus = histManualObj.getStatus();
            histManualObj.setStatus("DELETED");
            HistManualsLocalServiceUtil.updateHistManuals(histManualObj);

            final String currStatus = histManualObj.getStatus();
            final long objId = histManualObj.getPrimaryKey();

            final long userId = PortalUtil.getUserId(resourceRequest);
            final User user = UserLocalServiceUtil.getUserById(userId);

            // Workflow
            final long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
            LOG.debug("wrkflowId=====>>>>>" + wrkflowId);
            final Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(wrkflowId);
            workflow.setStatus(currStatus);
            workflow.setPrevStatus(prevStatus);
            workflow.setObjectId(objId);
            //workflow.setObjectType(type);
            workflow.setObjectType("MNL");
            workflow.setCreatedBy(user.getScreenName());
            workflow.setUpdatedBy(String.valueOf(userId));
            workflow.setUpdatedDate(new Date());
            workflow.setCreatedDate(new Date());
            workflow.setCreatorId(String.valueOf(user.getUserId()));
            WorkflowLocalServiceUtil.addWorkflow(workflow);

            json = "{" + "\"response\": \"Success\"," + "\"message\": \"Manual deleted successfully.\"}";//"+e.getMessage()+"\"}";
            out.print(json);
            out.flush();
            out.close();
        }
        catch (Exception e)
        {
            json = "{" + "\"response\": \"Failure\"," + "\"message\": \"Failure - Exception.\"}";//"+e.getMessage()+"\"}";
            out.print(json);
            out.flush();
            out.close();
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }
}
