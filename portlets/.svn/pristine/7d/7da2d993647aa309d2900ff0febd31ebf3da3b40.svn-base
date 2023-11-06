package com.ihg.brandstandards.bridge.portlet;

import com.ihg.brandstandards.bridge.application.impl.BridgePublishApplicationImpl;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.bridge.util.StandardsUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.NoSuchBridgePublishException;
import com.ihg.brandstandards.db.model.BridgeGlobalPublish;
import com.ihg.brandstandards.db.model.BridgePublish;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

public class MyPublicationPortlet extends BrandStandardsBridgePortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(MyPublicationPortlet.class);

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
    	BridgePublishApplicationImpl bridgePublishApp = new BridgePublishApplicationImpl();
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
        if (LOG.isDebugEnabled()) {
        	LOG.debug("inside doView");
        	LOG.debug("Region Code is " + regionCode + " chain Code is " + brandCode);
        }
        
        long bridgePublishId = getBridgePublishId(brandCode);

        if (bridgePublishId == 0L)
        {
            renderRequest.setAttribute("displayNoPublishMessage", true);
            super.doView(renderRequest, renderResponse);
        }
        else 
        {
            String pageType = ParamUtil.getString(renderRequest, "pageType");
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            List<Standard> myPublicationsList = new ArrayList<Standard>();
            List<Standard> arlDisplayList = new ArrayList<Standard>();
            int noOfPages = 1;
            int noOfRecords = 1;
            int pageNumber = 1;
            int recordsPerPage = httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE) == null ? 
                    BridgeConstants.DEFAULT_ITEMS_PER_PAGE : Integer.parseInt(httpRequest.getParameter(BridgeConstants.REQUEST_PARAM_REC_PER_PAGE));
            long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
            
            String stdIds = ParamUtil.getString(renderRequest, "findByStdId");
            /********************************* Check for find by id value  *****************************/
            if (Validator.isNull(stdIds)) {
            	myPublicationsList = (ArrayList<Standard>) session.getAttribute("standardsList");
            }
            
            if (myPublicationsList == null)
            {
                myPublicationsList = new ArrayList<Standard>();
            }
            if (httpRequest.getParameter("pageNumber") != null && httpRequest.getParameter("itemsPerPage") != null)
            {
                pageNumber = Integer.parseInt(httpRequest.getParameter("pageNumber"));
                recordsPerPage = Integer.parseInt(httpRequest.getParameter("itemsPerPage"));
            }
            else
            {
                pageNumber = 1;
                recordsPerPage = BridgeConstants.CUSTOM_PAGINATION_ITEM_PER_PAGE;
            }
            if ((myPublicationsList.isEmpty() || pageNumber == 1) && !"addStdById".equals(pageType))
            {
            	myPublicationsList = bridgePublishApp.getMyPublishStandards(brandCode, String.valueOf(regionId), regionCode, stdIds);
                addStdIdToSession(session, myPublicationsList, true);
            }

            if (Validator.isNotNull(pageType) && "addById".equals(pageType))
            {
            	PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/myPublication/addByIds.jsp");
                dispatcher.include(renderRequest, renderResponse);
            }
            else if ("addStdById".equals(pageType) || "modifyStd".equals(pageType))
            {
                addStandardsByIds(renderRequest, themeDisplay.getUser(), brandCode, regionId, bridgePublishId);
                //Remove my publication list from session and get it from database
                session.removeAttribute("standardsList");
                //Get My publication list
                myPublicationsList = bridgePublishApp.getMyPublishStandards(brandCode, String.valueOf(regionId), regionCode, stdIds);
                addStdIdToSession(session, myPublicationsList, true);
                //Remove update preview country group list from session
                removeUpdatePreviewSessionAttributes(session, themeDisplay.getUserId());
            }
            //Get all missing references
            try {
            	renderRequest.setAttribute("missingReference", BridgePublishLocalServiceUtil.getMissingReferences(bridgePublishId, regionId));
            } catch (SystemException e) {
            	LOG.error(e.getMessage(), e);
            }
            noOfRecords = myPublicationsList.size();
            if (Validator.isNull(stdIds)) {
            	session.setAttribute("resultCount", noOfRecords);
            }
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
            if (Validator.isNull(pageType) || "addStdById".equals(pageType) || "modifyStd".equals(pageType))
            {
                arlDisplayList = myPublicationsList.subList(startIndex, toIndex);
                renderRequest.setAttribute("displayList", arlDisplayList);
                if (Validator.isNull(stdIds)) {
                	session.setAttribute("standardsList", myPublicationsList);
                } else {
                	//set search Id into request
                	renderRequest.setAttribute("findId", stdIds);
                }
//                renderRequest.setAttribute("issuesCount", issuesCount);
                renderRequest.setAttribute("issuesCount", 0);
                renderRequest.setAttribute("noOfPages", noOfPages);
                renderRequest.setAttribute("pageNumber", pageNumber);
                renderRequest.setAttribute("recordsPerPage", recordsPerPage);
                renderRequest.setAttribute("hotelCode", brandCode);
                renderRequest.setAttribute("bridgePublishId", bridgePublishId);
                session.setAttribute("bridgePublishId", bridgePublishId);
                renderRequest.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
                session.setAttribute("itemsPerPageOptions", PortletProps.get("pagination.itemsperpage.options").split(","));
                httpRequest.setAttribute("regionCode", regionCode);
                httpRequest.setAttribute("regionId", regionId);
                renderRequest.setAttribute("referencedIds", "See also ID number");
                PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/myPublication/view.jsp");
                dispatcher.include(renderRequest, renderResponse);
            }
        }
    }

    @ProcessAction(name = "deleteStandards")
    public void deleteStandards(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession session = getHttpSession(request);
        String stdIdStr = request.getParameter("hidStdId");
        Preferences preferences = getBridgeUserPreferences(actionRequest);
        
        if (LOG.isDebugEnabled()) {
        	LOG.debug("value of stdId is " + stdIdStr);
        }

        if (stdIdStr != null && preferences != null)
        {
            long stdId = Long.valueOf(stdIdStr);
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
            		BridgeConstants.JOB_TYPE_COUNTRY_GROUP, BridgeConstants.QUEUE_NEW_STATUS)) {
            	processor.addMessageInQueue(BridgeConstants.JOB_TYPE_COUNTRY_GROUP, bridgePublishId, BridgeConstants.SA_REPORT_TYPE, preferences, user);
            }
*/
        }
    }
    
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
        final String resourceID = resourceRequest.getResourceID();
        String modalType = resourceRequest.getParameter("modalType");
        BridgePublishApplicationImpl bridgeApp = new BridgePublishApplicationImpl();
        Preferences userPref = getBridgeUserPreferences(resourceRequest);
        String chainCode = "";
        String regionCode = "";
        String regionName = "";
        Standard standards = new Standard();
        if (userPref != null)
        {
            chainCode = userPref.getBrand();
            regionCode = userPref.getRegionCode();
            regionName = userPref.getRegionName();
        }
        if ("viewEdit".equalsIgnoreCase(modalType) && Validator.isNotNull(resourceRequest.getParameter("stdId")))
        {
            long stdId = Long.parseLong(resourceRequest.getParameter("stdId"));
            long regionId = BrandStandardsUtil.getRegionId(regionCode);
            try
            {
                standards = bridgeApp.getStandardByStandardid(chainCode, regionId, stdId);
                resourceRequest.setAttribute("StandardsObj", standards);
                include("/html/myPublication/editStandards.jsp", resourceRequest, resourceResponse);
            }
            catch (SystemException e)
            {
                LOG.error(e.getMessage(), e);
            }
            catch (Exception e)
            {
                LOG.error(e.getMessage(), e);
            }
        }
        else if ("updateSelection".equalsIgnoreCase(modalType))
        {
            updateStandardSelection(resourceRequest, resourceResponse);

        }
        else if ("addById".equals(modalType))
        {
            redirectToPage(resourceRequest, resourceResponse, "/html/myPublication/addByIds.jsp");
        }
        else if ("searchById".equals(modalType))
        {
            resourceRequest.setAttribute("countryName", regionName);
            searchStandardById(resourceRequest, resourceResponse, chainCode, regionCode);
        }
        else if ("updateStdList".equals(modalType))
        {
            updateStandardsList(resourceRequest, resourceResponse);

        }
        else if ("deleteStandard".equals(modalType))
        {
            removeStandardFromList(resourceRequest, resourceResponse);
        } 
        else if ("referenceStandards".equalsIgnoreCase(modalType) && Validator.isNotNull(resourceRequest.getParameter("stdId")))
        {
            try
            {
                long stdId = Long.parseLong(StringUtil.trim(resourceRequest.getParameter("stdId")));
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("stdId :::" + stdId);
                }
                
                List<Standard> finalList = BridgePublishLocalServiceUtil.getStandardDetails(BridgeQueryUtils.getStandardsById(stdId, chainCode, regionCode));
                //Sort standards
                if (LOG.isDebugEnabled()) {
                	LOG.debug("Refrenced standards :");
                }
                resourceRequest.setAttribute("referenceRecords", StandardsUtil.sortRecords(finalList));
                resourceRequest.setAttribute("brandCode", chainCode);
                resourceRequest.setAttribute("referenceTitle", "Reference");
                resourceRequest.setAttribute("closeMsg", "Close");
                resourceRequest.setAttribute("newRecord", "New");
                resourceRequest.setAttribute("updatedRecord", "Updated");
                resourceRequest.setAttribute("guidelines", "Guidelines");
                include("/html/myPublication/stdReference.jsp", resourceRequest, resourceResponse);
            }
            catch (IOException e)
            {
                LOG.error(e);
            }
            catch (PortletException e)
            {
                LOG.error(e);
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
                long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(chainCode, "BRIDGE");
                Map<String, StandardsCountryExt> countryDetailMap = new LinkedHashMap<String, StandardsCountryExt>();
                List<StandardsCountryExt> countryList = StandardsCountryExtLocalServiceUtil.getCountryListByStdIdAndRegionIdForMyPublication(stdId, regionId, publishId);
                for (StandardsCountryExt cntry : countryList)
                {
                    countryDetailMap.put(cntry.getCountryCode(), cntry);
                }
                HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
                HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
                httpRequest.setAttribute("regionCode",regionCode);
                httpRequest.setAttribute("bridgePubId", BridgePublishLocalServiceUtil.getByPublishIdRegionIdAndStdId(publishId, regionId, stdId).getBridgePublishId());
                httpRequest.setAttribute("subRegionCountryMap", subRegionCountryMap);
                httpRequest.setAttribute("countryDetailMap", countryDetailMap);
                httpRequest.setAttribute("countryNameList", countryNameMap);
                include("/html/myPublication/ctryPopup.jsp", resourceRequest, resourceResponse);
            }
            catch (NoSuchBridgePublishException e) 
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
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
        else if ("createReport".equals(resourceID))
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
        else if ("getIssuesCount".equals(resourceID))
        {
            long regionId = BrandStandardsUtil.getRegionId(regionCode);
            Publication publish = getActiveBridgePublication(chainCode);
            
            long issuesCount = setOverallProgressCounts(publish, regionId, regionCode);
            try
            {
                resourceResponse.getWriter().write(String.valueOf(issuesCount));
                resourceResponse.getWriter().flush();
            }
            catch (IOException e)
            {
                LOG.error("failed to write: ", e);
            }
        }
    }

	@ProcessAction(name = "editedStandards")
    public void editedStandards(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession httpSession = getHttpSession(request);
        String stdId = request.getParameter("editStdId");
        String prntStdId = request.getParameter("prntStdId");
        List<Long> arlStdIds = new ArrayList<Long>();
        BridgePublishApplicationImpl bridgePubApp = new BridgePublishApplicationImpl();
        Map<String, Standard> addedItems = new HashMap<String, Standard>();
        
        try
        {
            if (stdId != null && stdId.length() > 0)
            {
                for (String str : stdId.split(","))
                {
                    arlStdIds.add(Long.parseLong(str));
                    if (LOG.isDebugEnabled())
                    {
                       LOG.debug("value of std id in editedStandards is "+str);
                    }
                }
            }
            Preferences preferences = getBridgeUserPreferences(actionRequest);
            String brandCode = "";
            String regionCode = "";
            if (preferences != null)
            {
                brandCode = preferences.getBrand();
                regionCode = preferences.getRegionCode();
            }
            
            if (httpSession.getAttribute("stdItems") != null)
            {
                addedItems = (Map<String, Standard>) httpSession.getAttribute("stdItems");
            }
            if (Validator.isNotNull(stdId))
            {
                for (String id : stdId.split(","))
                {
                    addEditedStdDetails(addedItems, id, prntStdId);
                }
            }
            Publication publication = getActiveBridgePublication(brandCode);
            long publishId = publication.getPublishId();
            		
            bridgePubApp.editStandards(publishId, regionCode, brandCode, arlStdIds, Long.parseLong(prntStdId), user.getScreenName());
            httpSession.setAttribute("stdItems", addedItems);
            actionResponse.setRenderParameter("pageType", "modifyStd");
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @return boolean isValidStd
	 */
    private String validateStandard(PortletRequest resourceRequest, String brand, String region)
    {
        String validationMessage = null;
        long stdId = ParamUtil.getLong(PortalUtil.getHttpServletRequest(resourceRequest), "standardId", 0l);
        if (Validator.isNotNull(stdId))
        {
            try
            {
                // First validation, whether std is exist in CMS or not?
            	if (StandardsLocalServiceUtil.getStandards(stdId)!=null)
            	{
	            	long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(brand, "BRIDGE");
	            	long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(region);
	            	BridgePublish bridgePublish = BridgePublishLocalServiceUtil.getByPublishIdRegionIdAndStdId(publishId, regionId, stdId);
	            	if (bridgePublish != null && "N".equals(bridgePublish.getUnpublishInd()))
	            	{
	            		validationMessage = "<div class='alert alert-warnin'>Standard ID [" + stdId + "] already added in its entirety.</div>";
	            	}
            	} else {
            		validationMessage = "<div class='alert alert-warnin'>Standard ID [" + stdId + "] not found in CMS</div>";
            	}
            }
            catch (Exception e)
            {
                LOG.error(e.getMessage(), e);
            } 
        }
        else
        {
            validationMessage = "<div class='alert alert-warnin'>Please provide standard Id</div>";
        }
        return validationMessage;
    }

	/**
	 * 
	 * @param request
	 * @param chainCode
	 * @param regionCode
	 * @param std
	 */
    private void setSearchResult(ResourceRequest request, String chainCode, String regionCode, List<Standard> standardList)
    {
        /**
         * Validation rules : 
         * 1. If Std is in global must not publish list then spec / gdln should be disabled 
         * 2. If Std is not in current region then spec/ gdln should be disabled 
         * 3. If Std is not applicable to current brand then spec / gdln should be disabled
         */
    	List<Long> arlStdsByChain = new ArrayList<Long>();
    	Map<Long, Long> globalMustStd = new HashMap<Long, Long>();
        try
        {
            
            long publishId = PublicationLocalServiceUtil.getPublishIdByBrand(chainCode, "BRIDGE");
            long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
            arlStdsByChain = StandardsExtLocalServiceUtil.getStandardsByChain(chainCode);
            List<Long> stdIds = new ArrayList<Long>();
            for (Standard std : standardList)
            {
                stdIds.add(std.getStdId());
            }
            
            List<Long> unpublishLst = getBridgePublishStdList(stdIds, chainCode, regionId, publishId, "Y");
            List<Long> alreadyAdded = getBridgePublishStdList(stdIds, chainCode, regionId, publishId, "N");
            String stdStatus = null;
            
            for (Standard std : standardList)
            {
                BridgeGlobalPublish globalStd = BridgeGlobalPublishLocalServiceUtil.getByPublishIdAndStdId(publishId, std.getStdId());

                if (!validStdStatus(stdStatus))
                {
                    std.setStatus(stdStatus);
                }
                else if (!arlStdsByChain.contains(std.getStdId()))
                {
                    std.setStatus("NOTBRND");
                }
                else if ("NOTRGN".equals(std.getCurRegion()))
                {
                    std.setStatus("NOTRGN");
                }
                else if ("DISCONT".equals(std.getStatus()))
                {
                    std.setStatus("DISCONT");
                }
                else if (globalStd != null && "Y".equals(globalStd.getMustPublishInd()))
                {
                    std.setStatus("GLBLMST");
                    globalMustStd.put(globalStd.getStdId(), globalStd.getStdId()); // DO we need it?
                }
                else if (globalStd != null && "N".equals(globalStd.getMustPublishInd()))
                {
                    std.setStatus("GLBLMSTNOT");
                }
                else if (unpublishLst != null && unpublishLst.contains(std.getStdId()))
                {
                    std.setStatus("UNPUBLISH");
                }
                else if (alreadyAdded != null && alreadyAdded.contains(std.getStdId()))
                {
                    std.setStatus("EXISTS");
                }
                //Global std which is not include in mustpublish as a Global Not In Must
                else if ("GLBL".equals(std.getRegionCode()) && (globalStd == null || (globalStd != null && !"Y".equals(globalStd.getMustPublishInd())) ) )	
                {
                	std.setStatus("GNOTINMUST");
                }
                
                if ("STD".equals(std.getStdType()))
                {
                    request.setAttribute("taxonomyPath", std.getTaxonomyPath());
                    request.setAttribute("taxonomyText", std.getTaxonomyText());
                    stdStatus = std.getStatus();
                }
            }
            request.setAttribute("globalMustStd", globalMustStd); // DO we need it?
            request.setAttribute("chainCode", chainCode);
            request.setAttribute("regionCode", regionCode);
            request.setAttribute("standardList", standardList);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

    private boolean validStdStatus(String status)
    {
        boolean isValid = true;
        if ("GLBLMSTNOT".equals(status) || "NOTBRND".equals(status) || "GNOTINMUST".equals(status) || "NOTRGN".equals(status) || "DISCONT".equals(status))
        {
            isValid = false;
        }
        return isValid;
    }

	/**
	 * 
	 * @param portletRequest
	 * @param user
	 * @param brandCode
	 * @param regionId
	 * @param publishId
	 */
    private void addStandardsByIds(PortletRequest portletRequest, User user, String brandCode, long regionId, long bridgePublishId)
    {
        HttpSession session = getHttpSession(getHttpRequest(portletRequest));
        Map<String, Standard> addedItems = new HashMap<String, Standard>();
        if (session.getAttribute("stdItems") != null)
        {
            addedItems = (Map<String, Standard>) session.getAttribute("stdItems");
            
            List<Long> stdIds = new ArrayList<Long>();
            for (Map.Entry<String, Standard> entry : addedItems.entrySet())
            {
                stdIds.add(GetterUtil.getLong(entry.getKey()));
            }
            
            long prodPublishId;
            try
            {
                prodPublishId = PublicationLocalServiceUtil.getPublishIdByBrand(brandCode, "PRODUCTION");
            }
            catch (SystemException e)
            {
                prodPublishId = 0;
            }
            BridgePublishLocalServiceUtil.addStdToBridgeForAddById(bridgePublishId, prodPublishId, brandCode, regionId, stdIds, user.getScreenName());
            //Create bridge unique groups
            Preferences userPref = getBridgeUserPreferences(portletRequest);
            //GEM Unique groups
            //addRequestInQueue(bridgePublishId, regionId, BridgeConstants.SA_REPORT_TYPE, userPref, user);
            //Bridge Unique groups
            addRequestInQueue(bridgePublishId, regionId, BridgeConstants.BRIDGE_GROUPS_TYPE, userPref, user);
            
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
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param path
	 */
    private void redirectToPage(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String path)
    {
        try
        {
            include(path, resourceRequest, resourceResponse);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortletException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }

	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param chainCode
	 * @param regionCode
	 */
    private void searchStandardById(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String chainCode, String regionCode)
    {
        long stdId = ParamUtil.getLong(resourceRequest, "standardId");
        if (stdId != 0l)
        {
            String validationMsg = validateStandard(resourceRequest, chainCode, regionCode);
            try
            {
                if (validationMsg == null)
                {
                    List<Standard> finalList = BridgePublishLocalServiceUtil.getStandardDetails(BridgeQueryUtils.searchStandardsById(stdId, chainCode, regionCode));
                    // set validation flags
                    setSearchResult(resourceRequest, chainCode, regionCode, finalList);
                    include("/html/myPublication/search.jsp", resourceRequest, resourceResponse);
                }
                else
                {
                    resourceResponse.getWriter().write(validationMsg);
                }
            }
            catch (IOException e)
            {
                LOG.error(e.getMessage(), e);
            }
            catch (PortletException e)
            {
                LOG.error(e.getMessage(), e);
            }
        }
    }

	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 */
    private void updateStandardsList(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
        HttpSession httpSession = PortalUtil.getHttpServletRequest(resourceRequest).getSession();
        String[] stdIds = resourceRequest.getParameterValues("stdCheckBox");
        LOG.debug("hidden stds :" + resourceRequest.getParameter("globalMustStd"));
        Map<String, Standard> addedItems = new LinkedHashMap<String, Standard>();
        
        Standard stdTemp = null;
        if (httpSession.getAttribute("stdItems") != null)
        {
            addedItems = (Map<String, Standard>) httpSession.getAttribute("stdItems");
        }
        if (ArrayUtil.isNotEmpty(stdIds))
        {
            for (String id : stdIds)
            {
                addStdDetails(resourceRequest, addedItems, id);
            }
        }
        // Add global must stdIds
        if (Validator.isNotNull(resourceRequest.getParameter("globalMustStd")))
        {
            for (String id : resourceRequest.getParameter("globalMustStd").split(","))
            {
                addStdDetails(resourceRequest, addedItems, id);
            }
        }
        
        addedItems = sortStandardsList(addedItems);
        try
        {
            resourceRequest.setAttribute("addedItems", addedItems);
            httpSession.setAttribute("stdItems", addedItems);
            include("/html/myPublication/addItems.jsp", resourceRequest, resourceResponse);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortletException e)
        {
            LOG.error(e.getMessage(), e);
        }
    }
    
    private Map<String, Standard> sortStandardsList(Map<String, Standard> addedItems){
    	Map<String, Standard> sortByType = new LinkedHashMap<String, Standard>();
    	Map<String, Standard> stdType = new HashMap<String, Standard>();
    	Map<String, Standard> specType = new HashMap<String, Standard>();
    	Map<String, Standard> gndlType = new HashMap<String, Standard>();
    	Standard stdTemp = null;
	    for (String str :  addedItems.keySet())
	    {
	    	stdTemp = addedItems.get(str);
	    	if (stdTemp!=null && BSCommonConstants.STD_TYPE_STANDARD.equals(stdTemp.getStdType()))
	    	{
	    		stdType.put(str, stdTemp);
	    	} 
	    	else if (stdTemp!=null && BSCommonConstants.STD_TYPE_SPEC.equals(stdTemp.getStdType()))
	    	{
	    		specType.put(str, stdTemp);
	    	}
	    	else if (stdTemp!=null && BSCommonConstants.STD_TYPE_GDLN.equals(stdTemp.getStdType()))
	    	{
	    		gndlType.put(str, stdTemp);
	    	}
	    }
	    if (!stdType.isEmpty())
	    {
	    	sortByType.putAll(stdType);
	    }
	    if (!specType.isEmpty())
	    {
	    	sortByType.putAll(specType);
	    }
	    if (!gndlType.isEmpty())
	    {
	    	sortByType.putAll(gndlType);
	    }
	    
	    return sortByType;
    }

	/**
	 * 
	 * @param resourceRequest
	 * @param resourceResponse
	 */
    private void removeStandardFromList(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    {
        HttpSession httpSession = PortalUtil.getHttpServletRequest(resourceRequest).getSession();
        Map<String, Standard> addedItems = new HashMap<String, Standard>();
        if (httpSession.getAttribute("stdItems") != null)
        {
            addedItems = (Map<String, Standard>) httpSession.getAttribute("stdItems");
        }
        String stdId = ParamUtil.getString(resourceRequest, "stdIdVal");
        String stdType = ParamUtil.getString(resourceRequest, "stdTypeVal");
        LOG.debug("Delete standard :" + stdId);
        try {
	        if (addedItems.containsKey(stdId))
	        {
	        	addedItems.remove(stdId);
	        	if ("STD".equals(stdType)) {
	        		List<Standards> stdList =  StandardsLocalServiceUtil.getStandardsByParent(GetterUtil.getLong(stdId));
	        		for (Standards std : stdList) {
	        			if (addedItems.containsKey(String.valueOf(std.getStdId()))) {
	        				addedItems.remove(String.valueOf(std.getStdId()));
	        			}
	        		}
	        		if (LOG.isDebugEnabled()) {
	        			LOG.debug("Removing specs and guideline for std :" + stdId);
	        		}
	        	}
	        	
	            httpSession.setAttribute("stdItems", addedItems);
	        }
	        resourceRequest.setAttribute("addedItems", addedItems);
	        include("/html/myPublication/addItems.jsp", resourceRequest, resourceResponse);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortletException e)
        {
            LOG.error(e.getMessage(), e);
        } catch (SystemException e) {
        	LOG.error(e.getMessage(), e);
        }
    }

	/**
	 * 
	 * @param stdIds
	 * @param brandCode
	 * @param regionCode
	 * @param publishId
	 * @return List<Long>
	 */
    private List<Long> getBridgePublishStdList(List<Long> stdIds, String brandCode, long regionId, long publishId, String publishStatus)
    {
        List<Long> unPublishList = null;
        try
        {
            unPublishList = BridgePublishLocalServiceUtil.getBridgePublishStandardsByParent(BridgeQueryUtils
                    .getBridgePublishStandardsByStdIds(brandCode, stdIds, regionId, publishId, publishStatus));
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        return unPublishList;
    }

	/**
	 * 
	 * @param resourceRequest
	 * @param addedItems
	 * @param id
	 */
    private void addStdDetails(ResourceRequest resourceRequest, Map<String, Standard> addedItems, String id)
    {
        Standard std = new Standard();
        String title = resourceRequest.getParameter("title_" + id);
        String parentId = resourceRequest.getParameter("parentStdId_" + id);
        String stdId = resourceRequest.getParameter("stdId_" + id);
        String type = resourceRequest.getParameter("type_" + id);
        std.setTitle(title);
        std.setParentStdId(GetterUtil.getLong(parentId));
        std.setStdId(GetterUtil.getLong(stdId));
        std.setStdType(type);
        addedItems.put(stdId, std);
    }
    
    private void addEditedStdDetails(Map<String, Standard> addedItems, String stdId, String prntStdId)
    {
    	Standard std = new Standard();
        std.setStdId(GetterUtil.getLong(stdId));
        std.setParentStdId(GetterUtil.getLong(prntStdId));
        addedItems.put(stdId, std);
    }
   
    protected long setOverallProgressCounts(Publication publish, long rgnId, String regionCd)
    {
        long overallCount = 0;
        if (publish != null)
        {
//            Map<String, String> activeLanguages = getRegionActiveSecondLanguages(regionCd);
            Map<String, String> activeLanguages = null;
            
            overallCount += getCount(publish, rgnId, activeLanguages, BridgeConstants.PROGRESS_TYPE_OVERALL);
            overallCount += getCount(publish, rgnId, activeLanguages, BridgeConstants.PROGRESS_TYPE_COMPLIANCE);
//            if (activeLanguages != null && !activeLanguages.isEmpty())
//            {
//                overallCount += getCount(publish, rgnId, activeLanguages, BridgeConstants.PROGRESS_TYPE_INDEX_TRANS);
//                overallCount += getCount(publish, rgnId, activeLanguages, BridgeConstants.PROGRESS_TYPE_CONTENT_TRANS);
//                overallCount += getCount(publish, rgnId, activeLanguages, BridgeConstants.PROGRESS_TYPE_ATTACH_TRANS);
//                overallCount += getCount(publish, rgnId, activeLanguages, BridgeConstants.PROGRESS_TYPE_LINKS_TRANS);
//                overallCount += getCount(publish, rgnId, activeLanguages, BridgeConstants.PROGRESS_TYPE_IMAGE_TRANS);
//            }
        }

        return overallCount;
    }
    
    private long getCount(Publication publish, long rgnId, Map<String, String> activeLanguages, String progressType)
    {
        long cnt = 0;
        boolean validateLang = BridgeConstants.PROGRESS_TYPE_INDEX_TRANS.equals(progressType) || 
                               BridgeConstants.PROGRESS_TYPE_CONTENT_TRANS.equals(progressType) || 
                               BridgeConstants.PROGRESS_TYPE_ATTACH_TRANS.equals(progressType) || 
                               BridgeConstants.PROGRESS_TYPE_LINKS_TRANS.equals(progressType) || 
                               BridgeConstants.PROGRESS_TYPE_IMAGE_TRANS.equals(progressType);
        
        try
        {
            Map<String, Long> progress = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
                    publish.getPublishDate(), rgnId, rgnId == 1 ? true : false, progressType);
            if (progress != null && !progress.isEmpty())
            {
                for (Map.Entry<String, Long> entry : progress.entrySet())
                {
                    if (BridgeConstants.COUNT_OVERRIDDEN.equals(entry.getKey()) || BridgeConstants.COUNT_MISS_XREF.equals(entry.getKey()))
                    {
                        continue;
                    }
                    else
                    {
                        if (validateLang)
                        {
                            if (activeLanguages.get(entry.getKey()) != null)
                            {
                                cnt += entry.getValue();
                            }
                        }
                        else
                        {
                            cnt += entry.getValue();
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error("Overall Progress count exception", e);
        }
        return cnt;
    }
}
