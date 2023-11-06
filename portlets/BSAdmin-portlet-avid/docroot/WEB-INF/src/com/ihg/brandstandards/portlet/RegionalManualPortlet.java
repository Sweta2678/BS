package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.bsadmin.model.RegionalView;
import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.util.CMSStandardsListUtil;
import com.ihg.brandstandards.util.RegionalUtil;
import com.ihg.brandstandards.util.StandardsHistoricalManualReferenceUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is the controller for standards and specification creation and edit operations.
 * 
 * @author Vipul_D
 * 
 */
public class RegionalManualPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(RegionalManualPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException
    {
        LOG.info("THIS IS RegionalManualCONTROLLER");
        try
        {
            final long userId = PortalUtil.getUserId(renderRequest);
            String page = viewTemplate;
            if (userId < 1)
            {
                renderRequest.setAttribute("NotLoggedIn", true);
            }
            else
            {
                HttpServletRequest httpReq = PortalUtil
                        .getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
                final RegionalView stdView = prepareRequest(httpReq);
                renderRequest.setAttribute("RegManStdView", stdView);
            }

            final String browser = PortalUtil.getHttpServletRequest(renderRequest).getHeader("User-Agent");
            if (browser.indexOf("MSIE 9") > 0)
            {
                PortalUtil.getHttpServletResponse(renderResponse).setHeader("X-UA-Compatible", "IE=8");
            }
            final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(page);
            reqDisp.include(renderRequest, renderResponse);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    /**
     * Fetch data for Standards view.
     * 
     * @param httpReq - HttpServletRequest
     * @return - StandardsView object
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public RegionalView prepareRequest(final HttpServletRequest httpReq) throws PortalException, SystemException
    {
        final RegionalView stdView = new RegionalView();
        final String objId = httpReq.getParameter(RegionalUtil.REQUEST_PARAM_ID);
        final String prntStdId = httpReq.getParameter(RegionalUtil.REQUEST_PARAM_STD_ID);
        final String objTyp = httpReq.getParameter(RegionalUtil.REQUEST_PARAM_OBJ_TYP);
        final long userId = PortalUtil.getUserId(httpReq);
        final User user = UserLocalServiceUtil.getUserById(userId);

        final long stdId = Long.valueOf(objId);
        stdView.setStandard(StandardsLocalServiceUtil.getStandards(stdId));
        if (!RegionalUtil.IsNullOrBlank(prntStdId))
        {
            final Standards assocStd = StandardsLocalServiceUtil.getStandards(Long.valueOf(prntStdId));
            stdView.setAssociatedStandard(assocStd);
            stdView.setAssocChainStandards(ChainStandardsLocalServiceUtil.getChainStandardsByStdId(assocStd.getStdId()));
            stdView.setAssocCountryStandards(CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(assocStd.getStdId()));
        }
        stdView.setChainStandards(ChainStandardsLocalServiceUtil.getChainStandardsByStdId(stdId));
        stdView.setCountryStandards(CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(stdId));
        /*if (!"NEW".equals(stdView.getStandard().getChange()))
        {*/
        stdView.setStandardsHistoricalManuals(StandardsHistoricalManualLocalServiceUtil.findStdHistoricalManualsByStdId(stdId));
        //}

        return stdView;
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {
        final String resourceID = request.getResourceID();
        String message = StandardsUtil.SUCCESS_MESSAGE;
        if ("SaveStandard".equals(resourceID))
        {
            LOG.debug("--- Test Submit ---:  " + request.getParameter("standard_name"));
            try
            {
                processRequest(request);
            }
            catch (Exception e)
            {
                message = e.getLocalizedMessage() + " : " + e.getMessage();
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            final PrintWriter writer = response.getWriter();
            writer.print(message);
        }
        else if ("getHistoricalManual".equals(resourceID))
        {
            getHistoricalManual(request, response);
        }
        else
        {
            LOG.error("Unknown Resource ID: " + resourceID);
        }
    }

    /**
     * Fetch Historical Manual from database.
     * 
     * @param resourceRequest - request
     * @param resourceResponse - response
     */
    private void getHistoricalManual(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse)
    {
        final HttpServletRequest request = PortalUtil
                .getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        final String manualTypes = request.getParameter("manualTypeArray");
        final List<String> manualTypeList = getFilterList(manualTypes);
        final String brands = request.getParameter("brandArray");
        final List<String> brandList = getFilterList(brands);
        final String regions = request.getParameter("regionsArray");
        final List<String> regionList = getFilterList(regions);

        String errorMsg = "Success";
        List<HistManuals> manuals = null;
        try
        {
            manuals = HistManualsLocalServiceUtil.findHistoricalManualsByFilter(brandList, regionList, manualTypeList);
            //manuals = HistManualsLocalServiceUtil.findHistoricalManualsByFilter(brandList, null, manualTypeList);
            if (StandardsUtil.isNullOrBlank(manuals))
            {
                errorMsg = "No data found";
            }
        }
        catch (SystemException e)
        {
            errorMsg = "Search failed";
        }

        try
        {
            final JSONObject jsonMain = getHistoricalManualsJson(errorMsg, manuals);
            final PrintWriter writer = resourceResponse.getWriter();
            writer.write(jsonMain.toString());
            writer.flush();
        }
        catch (IOException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    /**
     * Populate JSON object with Historical Manuals.
     * 
     * @param errorMsg - specified error message
     * @param manuals - list of manuals.
     * @return - JSON onject.
     */
    private JSONObject getHistoricalManualsJson(final String errorMsg, final List<HistManuals> manuals)
    {
        final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        jsonMain.put("message", errorMsg);

        if (!StandardsUtil.isNullOrBlank(manuals))
        {
            jsonMain.put("recordCnt", manuals.size());

            for (HistManuals m : manuals)
            {
                final JSONObject jsonOSM = JSONFactoryUtil.createJSONObject();
                jsonOSM.put("title", m.getTitle().length() < 63 ? m.getTitle() : m.getTitle().substring(0, 60) + "...");
                jsonOSM.put("type", m.getType());
                jsonOSM.put("region", RegionalUtil.decodeRegionCode(m.getRegion()));
                final String chain = RegionalUtil.decodeChainCode(m.getChain());
                jsonOSM.put("brand", chain);
                jsonMain.put(String.valueOf(m.getHistManualId()), jsonOSM);
            }
        }
        return jsonMain;
    }

    /**
     * Convert filter from string to list.
     * 
     * @param filter - comma separated filter
     * @return - list
     */
    private List<String> getFilterList(final String filter)
    {
        List<String> filterList = null;
        if (!StandardsUtil.IsNullOrBlank(filter))
        {
            filterList = Arrays.asList(filter.split(","));
        }
        return filterList;
    }

    /**
     * Persist data into database.
     * 
     * @param resourceRequest - request
     * @return - updated data from database.
     * @throws Exception - exception
     */
    public RegionalView processRequest(final ResourceRequest resourceRequest) throws Exception
    {
        final RegionalView regStdView = new RegionalView();

        HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

        final long userId = PortalUtil.getUserId(request);

        Standards standards = null;
        long stdId = -100;
        String comments = "";

        if (!StandardsUtil.IsNullOrBlank(request.getParameter(RegionalUtil.REQUEST_PARAM_ID)))
        {
            stdId = Long.valueOf(request.getParameter(RegionalUtil.REQUEST_PARAM_ID));
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter(RegionalUtil.REQUEST_PARAM_HIDDEN_COMMENT)))
        {
            comments = (String) request.getParameter(RegionalUtil.REQUEST_PARAM_HIDDEN_COMMENT);
        }

        standards = StandardsLocalServiceUtil.getStandards(stdId);

        // Processing and persisting STD MANUAL Links.

        StandardsHistoricalManualReferenceUtil.proseccHistoricalManualReferences(request, standards.getStdId(), userId);
        final Workflow workflow = CMSStandardsListUtil.setStandardsWorkflow(resourceRequest, standards, standards.getStatus(),
                comments);
        LOG.debug("Value of current and previous status from workflow is " + workflow.getPrevStatus() + " "
                + workflow.getStatus());
        WorkflowLocalServiceUtil.addWorkflow(workflow);
        return regStdView;
    }

}