package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.ihg.brandstandards.bridge.application.impl.BridgePublishApplicationImpl;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.SpreadsheetUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.model.BridgePublishImport;
import com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.portlet.PortletProps;

public class AddByImportPortlet extends BrandStandardsBridgePortlet
{
	private static final Log LOG = LogFactoryUtil.getLog(AddByImportPortlet.class);
	private static final String ISSUE_COUNT_EXCLUDE_STATUSES = "GLBLMST,UNPUBLISH";
    private static final long MAX_STD_ADD_REAL_TIME = 1000;
	
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
    	BridgePublishApplicationImpl bridgePublishApp = new BridgePublishApplicationImpl();
        
    	LOG.debug("inside doView");
        String brandCode = "";
        String regionCode = "";
        HttpServletRequest httpRequest = getHttpRequest(renderRequest);
        HttpSession session = getHttpSession(httpRequest);
        Preferences preferences = getBridgeUserPreferences(renderRequest);
        if (preferences != null)
        {
            brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
        }

        long bridgePublishId = getBridgePublishId(brandCode);

        if (bridgePublishId == 0L)
        {
            renderRequest.setAttribute("displayNoPublishMessage", true);
            super.doView(renderRequest, renderResponse);
        }
        else 
        {
            List<Standard> myPublicationsList = new ArrayList<Standard>();
            List<Standard> arlDisplayList = new ArrayList<Standard>();
            int noOfPages = 1;
            int noOfRecords = 1;
            int pageNumber = 1;
            int recordsPerPage = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE) == null ? 
                    BridgeConstants.DEFAULT_ITEMS_PER_PAGE : Integer.parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE));
            int importedRecordsCount = 0;
            String sessionChainCD = (String)session.getAttribute("sessionChainCD");
            String sessionRgnCD = (String)session.getAttribute("sessionRgnCD");
            long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
            LOG.debug("Region Code is " + regionCode + " chain Code is " + brandCode);
            
            importedRecordsCount = bridgePublishApp.getBridgeImportedRecordsCount(bridgePublishId, regionId);
             
            if (httpRequest.getParameter("pageNumber") != null && httpRequest.getParameter("itemsPerPage") != null)
            {
                pageNumber = Integer.parseInt(httpRequest.getParameter("pageNumber"));
                recordsPerPage = Integer.parseInt(httpRequest.getParameter("itemsPerPage"));
            }
            else
            {
                pageNumber = 1;
                recordsPerPage = BridgeConstants.CUSTOM_PAGINATION_ITEM_PER_PAGE;//preferences.getItemsPerPage();
            }
            if (myPublicationsList.isEmpty() || pageNumber == 1)
            {
                if (importedRecordsCount > 0)
                {
                    myPublicationsList = bridgePublishApp.getMyPublishImportStandards(brandCode, String.valueOf(regionId), regionCode);
                    addStdIdToSession(session, myPublicationsList, true);
                    renderRequest.setAttribute("reportId", 118);
                }
            }
            noOfRecords = myPublicationsList.size();
            noOfPages = noOfRecords / recordsPerPage;
            noOfPages = noOfPages + 1;
            int startIndex = (pageNumber - 1) * recordsPerPage;
            int toIndex = 0;
            toIndex = startIndex + recordsPerPage;
            if (noOfRecords < toIndex)
            {
                toIndex = noOfRecords;
            }
    
            // Remove session attribute of add by id
            session.removeAttribute("stdItems");
    
            arlDisplayList = myPublicationsList.subList(startIndex, toIndex);
            renderRequest.setAttribute("displayList", arlDisplayList);
            renderRequest.setAttribute("noOfPages", noOfPages);
            renderRequest.setAttribute("pageNumber", pageNumber);
            renderRequest.setAttribute("recordsPerPage", recordsPerPage);
            renderRequest.setAttribute("hotelCode", brandCode);
            renderRequest.setAttribute("importCount", importedRecordsCount);
            renderRequest.setAttribute("bridgePublishId", bridgePublishId);
            session.setAttribute("bridgePublishId", bridgePublishId);
            renderRequest.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
            session.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
            
            //Check preferences brand and region is exist in session or not
            if (!brandCode.equals(sessionChainCD) || !regionCode.equals(sessionRgnCD)) {
            	session.removeAttribute("myPublicationSession");
		    	session.removeAttribute("sessionChainCD");
		    	session.removeAttribute("sessionRgnCD");
            }
            
            @SuppressWarnings("unchecked")
            Map<Long, String> myPublicationSession = (Map<Long, String>) session.getAttribute("myPublicationSession");
            if (importedRecordsCount > 0 && (myPublicationSession == null || myPublicationSession.isEmpty()) )
            {
                myPublicationSession = new HashMap<Long, String>();
                try
                {
                    List<BridgePublishImport> publishStds = BridgePublishImportLocalServiceUtil.findByPublishIdAndRegionId(
                            bridgePublishId, regionId);
                    for (BridgePublishImport std : publishStds)
                    {
                        myPublicationSession.put(std.getStdId(), std.getSelectInd());
                    }
                    session.setAttribute("myPublicationSession", myPublicationSession);
                    session.setAttribute("sessionChainCD", brandCode);
					session.setAttribute("sessionRgnCD", regionCode);
                }
                catch (SystemException e)
                {
                    LOG.error(e.getMessage(), e);
                }
            }
            renderRequest.setAttribute("myPublicationSession", myPublicationSession);

            StringBuilder metadataParams = getAddToMyPublicationMetadataParams(brandCode, regionCode, regionId, bridgePublishId);
            String compareMetadata = StringPool.PERCENT + metadataParams.toString() + StringPool.PERCENT;

            //If job queue request is in queue then do not create new request
            if (JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetadata, StringPool.PERCENT, 
                    BridgeConstants.JOB_TYPE_ADD_TO_MY_PUBLICATION, BridgeConstants.QUEUE_NEW_STATUS + "," + BridgeConstants.QUEUE_STATUS_INPROGRESS))
            {
                renderRequest.setAttribute("disableAddToMyPub", true);
            }
            else
            {
                renderRequest.setAttribute("disableAddToMyPub", false);
            }

            renderRequest.setAttribute("importIssueCount", 
        			BridgePublishImportLocalServiceUtil.getMyPublicationIssuesCount(bridgePublishId, regionId, ISSUE_COUNT_EXCLUDE_STATUSES));
            PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/addByImport/view.jsp");
            dispatcher.include(renderRequest, renderResponse);
        }
    }

    /**
     * This processAction is importing data from xls file.
     * 
     * @param actionRequest
     * @param actionResponse
     * @throws PortletException
     */
    @ProcessAction(name = "importStandards")
    public void importStandards(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException
    {
        String error = StringPool.BLANK;
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        String brand = null;
        String regionCd = null;
        try
        {
            Preferences userPref = getBridgeUserPreferences(actionRequest);
            if (userPref != null)
            {
                brand = userPref.getBrand();
                regionCd = userPref.getRegionCode();
            }
            // Publication publish = getActiveBridgePublication(brand);
            long startTime = new Date().getTime();
            long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(brand, "BRIDGE");
            long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
            if (LOG.isDebugEnabled())
                LOG.debug("value of regionCode is " + regionCd + " fetch publishId = " + publishId + " and rgnId = " + rgnId + 
                    " took = " + (new Date().getTime() - startTime) + " ms");
            
            List<Long> stdIds = SpreadsheetUtil.getStandardsIdList(actionRequest);
            if (stdIds.size() > 0)
            {
                importStandards(stdIds, publishId, brand, rgnId, String.valueOf(userId), regionCd);
                getHttpSession(actionRequest).removeAttribute("myPublicationSession");
            }
        }
        catch (SystemException se)
        {
            LOG.error(StackTraceUtil.getStackTrace(se));
            error = se.getMessage();
        }
        catch (InvalidFormatException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            error = e.getMessage();
        }
        catch (IOException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            error = e.getMessage();
        }
        actionRequest.setAttribute("error", error);
    }

    private void importStandards(List<Long> stdIds, long publishId, String brand, long rgnId, String userId, String regionCode) throws PortletException,
            SystemException
    {
        if (stdIds != null && !stdIds.isEmpty())
        {
            List<Long> importedIds = new ArrayList<Long>();

            try
            {
                List<BridgePublishImport> list = BridgePublishImportLocalServiceUtil.findByPublishIdAndRegionId(publishId, rgnId);
                if (LOG.isDebugEnabled())
                    LOG.debug("findByPublishIdAndRegionId: return " + list.size() + " items for publishId = " + publishId + " rgnId = " + rgnId);
                
                for (BridgePublishImport item : list)
                {
                    importedIds.add(item.getStdId());
                }
            }
            catch (SystemException e1)
            {
                LOG.error(StackTraceUtil.getStackTrace(e1));
            }

            List<Long> stdIdList = new ArrayList<Long>();

            for (Long stdId : stdIds)
            {
                if (!importedIds.contains(stdId))
                {
                    stdIdList.add(stdId);
                }
            }

            if (!stdIdList.isEmpty())
            {
                BridgePublishImportLocalServiceUtil.addBridgePublishImport(stdIdList, publishId, brand, rgnId, userId);
            }
        }

    }

    public void addStandards(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException 
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        String screenName = user.getScreenName();
        String brand = null;
        String regionCd = null;
        Preferences userPref = getBridgeUserPreferences(resourceRequest);
        if (userPref != null)
        {
            brand = userPref.getBrand();
            regionCd = userPref.getRegionCode();
        }
        long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
        long bridgePublishId = getBridgePublishId(brand);
        //Update bridge publish import table
        updateBridgePublishImport(bridgePublishId, regionId, resourceRequest);
        long count = BridgePublishImportLocalServiceUtil.getSTDToBeAddedCount(bridgePublishId, regionId);
        String result = "SUCCESS";
        
        if (count > MAX_STD_ADD_REAL_TIME)
        {
            result = submitAddToMyPublicationRequest(brand, regionCd, regionId, bridgePublishId, user);
        }
        else
        {
            try
            {
                BridgePublishApplicationImpl bridgeApp = new BridgePublishApplicationImpl();
                bridgeApp.addStandardsToPublishAfterImport(brand, regionId, bridgePublishId, screenName);
                generateUniqueGroups(themeDisplay.getUser(), userPref, regionId, bridgePublishId);
            }
            catch (SystemException se)
            {
                LOG.error(StackTraceUtil.getStackTrace(se));
                result = "ERROR";
            }
        }
        getHttpSession(resourceRequest).removeAttribute("myPublicationSession");
        
        try
        {
            resourceResponse.getWriter().write(result);
        }
        catch (IOException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            throw new IOException(e);
        }
    }

	/**
	 * Create request to generate unique groups for Bridge and GEM.
	 * @param user user
	 * @param userPref user preferences
	 * @param rgnId region id
	 * @param bridgePublishId publish id
	 */
    private void generateUniqueGroups(User user, Preferences userPref, long rgnId, long bridgePublishId)
    {
        //Bridge Unique groups
        addRequestInQueue(bridgePublishId, rgnId, BridgeConstants.BRIDGE_GROUPS_TYPE, userPref, user);
    }

    /**
     * 
     * @param actionRequest
     * @param actionResponse
     */
    public void saveStandardImport(ActionRequest actionRequest, ActionResponse actionResponse)
    {

        Preferences userPref = getBridgeUserPreferences(actionRequest);
        String regionCd = "";
        String brand = "";
        if (userPref != null)
        {
            brand = userPref.getBrand();
            regionCd = userPref.getRegionCode();
        }
        long bridgePublishId = getBridgePublishId(brand);
        long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
        updateBridgePublishImport(bridgePublishId, rgnId, actionRequest);
        getHttpSession(actionRequest).removeAttribute("myPublicationSession");
    }

    
    public void deleteStandardsImport (ActionRequest actionRequest, ActionResponse actionResponse)
    {
    	 Preferences userPref = getBridgeUserPreferences(actionRequest);
         String regionCd = "";
         String brand = "";
         if (userPref != null)
         {
             brand = userPref.getBrand();
             regionCd = userPref.getRegionCode();
         }
    	long bridgePublishId = getBridgePublishId(brand);
    	long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
    	try {
			BridgePublishImportLocalServiceUtil.deleteBridgeImportByPublishIdAndRegionId(bridgePublishId, rgnId);
		} catch (SystemException e) {
			LOG.error("Error while delete imports standards", e );
		}
    }
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException
    {
        String modalType = resourceRequest.getParameter("modalType");
       
        if ("updateSelection".equals(modalType))
        {
            updateStandardSelection(resourceRequest, resourceResponse);

        }
        else if ("exportSelection".equals(modalType))
        {
            submitReportRequest(resourceRequest, resourceResponse, true);
        }
        else if ("addStandards".equals(modalType))
        {
            addStandards(resourceRequest, resourceResponse);
        }
        
    }

    /**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 */
    private void updateStandardSelection(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
        HttpSession session = getHttpSession(getHttpRequest(resourceRequest));
        long stdId = ParamUtil.getLong(resourceRequest, "standardId");
        String selected = ParamUtil.getString(resourceRequest, "isSelected");
        @SuppressWarnings("unchecked")
        Map<Long, String> myPublicationSession = (Map<Long, String>) getHttpSession(resourceRequest).getAttribute("myPublicationSession");
        if (myPublicationSession != null && !myPublicationSession.isEmpty() && Validator.isNotNull(selected)
                && myPublicationSession.containsKey(stdId))
        {
            myPublicationSession.put(stdId, selected);
            session.setAttribute("myPublicationSession", myPublicationSession);
            try
            {
                resourceResponse.getWriter().write("success");
            }
            catch (IOException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
    }
    
    /**
     * 
     * @param publishId
     * @param rgnId
     * @param actionRequest
     */
    private void updateBridgePublishImport(long publishId, long rgnId, PortletRequest actionRequest) 
    {
    	try
        {
            @SuppressWarnings("unchecked")
            Map<Long, String> importSelection = (Map<Long, String>) getHttpSession(actionRequest).getAttribute("myPublicationSession");
            if (importSelection != null && !importSelection.isEmpty())
            {
                BridgePublishImportLocalServiceUtil.setBridgePublishForImport(publishId, rgnId, importSelection);
            }
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }
}
