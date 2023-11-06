/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.bridge.portlet;

import com.ihg.brandstandards.bridge.application.BridgeApplication;
import com.ihg.brandstandards.bridge.application.impl.BridgeApplicationImpl;
import com.ihg.brandstandards.bridge.application.impl.BridgePublishApplicationImpl;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.NoSuchStandardsRegionException;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.gem.portlet.BrandStandardsMVCPortlet;
import com.ihg.brandstandards.gem.process.Processor;
import com.ihg.brandstandards.gem.process.ProcessorFactory;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.QueryUtils;
import com.liferay.portal.kernel.exception.NestableException;
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
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;


/**
 * <a href="BrandStandardsBridgePortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards Bridge.
 * @author MUMMANL
 */
public class BrandStandardsBridgePortlet extends BrandStandardsMVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(BrandStandardsBridgePortlet.class);
    protected static StringBuffer statusList = null;
    
    static {
    	if (statusList == null) {
    		statusList = new StringBuffer(BridgeConstants.PUBLISH_NEW_STATUS_CODE);
            statusList.append(StringPool.COMMA);
            statusList.append(BridgeConstants.QUEUE_STATUS_INPROGRESS);
    	}
    }
    
    /**
     * @param renderRequest The Portlet Request Object
     * @return HttpServletRequest return HttpServletRequest Object
     */
    public HttpServletRequest getHttpRequest(PortletRequest renderRequest)
    {
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(renderRequest);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);

        return httpRequest;
    }

    /**
     * 
     * @param httpRequest The HttpServletRequest Object
     * @return HttpSession return HttpSession Object
     */
    public HttpSession getHttpSession(HttpServletRequest httpRequest)
    {
        return httpRequest.getSession();
    }

    /**
     * 
     * @param portletRequest The PortletRequest Object
     * @return HttpSession return HttpSession Object
     */
    public HttpSession getHttpSession(PortletRequest portletRequest)
    {
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));

        return httpRequest.getSession();
    }

    /**
     * 
     * @param portletRequest The PortletRequest Object
     * @return HttpSession return HttpSession Object
     */
    public HttpSession getHttpSession(ResourceRequest resourceRequest)
    {
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));

        return httpRequest.getSession();
    }

    /**
     * get user preferences from session.
     * 
     * @param request The PortletRequest Object
     * @return AccessAndPreferences return AccessAndPreferences Object
     */
    public Preferences getBridgeUserPreferences(PortletRequest request)
    {
        return getPreferences(request, "BRIDGE");
    }

    /**
     * UI Element Access Util method.
     * 
     * @param request
     * @param localeCode
     * @param moduleUsedIn
     * @return
     */
    public BSLanguageUtil getOBSMLanguageUtil(PortletRequest request, String localeCode, String moduleUsedIn)
    {
        BSLanguageUtil obsmLanguageUtil = null;
        HttpSession session = getHttpSession(request);
        if (session.getAttribute("bridgeLanguageUtil") != null)
        {
            obsmLanguageUtil = (BSLanguageUtil) session.getAttribute("bridgeLanguageUtil");
        }
        if (obsmLanguageUtil == null)
        {
            if(moduleUsedIn != null){
                obsmLanguageUtil = new BSLanguageUtil(localeCode, moduleUsedIn);
            } else {
                obsmLanguageUtil = new BSLanguageUtil(localeCode);
            }
            session.setAttribute("bridgeLanguageUtil", obsmLanguageUtil);
        }
        return obsmLanguageUtil;
    }
    
    /**
     * Get Active Bridge Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active Publish
     */
    protected Publication getActiveBridgePublication(String brandCode)
    {
    	Publication publish = null;
        try
        {
            publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE,
                    BridgeConstants.BRIDGE_ENVIRONMENT, brandCode);
        }
        catch (NestableException e)
        {
            LOG.error("No Active Bridge Publish Exist for brand:" + brandCode);
        }
        return publish;
    }
    
    /**
     * Get Active OBSM Production Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active Publish
     */
    protected Publication getActiveProductionPublication(String brandCode)
    {
    	Publication publish = null;
        try
        {
            publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE, 
            		BridgeConstants.PRODUCTION_ENVIRONMENT, brandCode);
        }
        catch (Exception e)
        {
            LOG.error("No Active Production Publish Exist for brand:" + brandCode);
        }
        return publish;
    }
    
    /**
     * Get Active OBSM Staging Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active Publish
     */
    protected Publication getActiveStagingPublication(String brandCode)
    {
    	Publication publish = null;
        try
        {
            publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE,
                    BridgeConstants.STAGING_ENVIRONMENT, brandCode);
        }
        catch (NestableException e)
        {
            LOG.error("No Active Bridge Publish Exist for brand:" + brandCode);
        }
        return publish;
    }

    public boolean isMultipart(ResourceRequest resourceRequest)
    {
        HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(request));
        return isMultipart;
    }
    
    /**
     * This method will get the active languages.
     * 
     * @return Map<String, String>
     */
    protected Map<String, String> getActiveLanguages()
    {
        Map<String, String> activeLanguages = new LinkedHashMap<String, String>();
        try
        {
            activeLanguages = StandardsLocaleLocalServiceUtil.getActiveLanguages(QueryUtils.ACTIVE_ALL_LANG_QUERY);
        }
        catch (Exception e)
        {
        	 LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return activeLanguages;
    }
    
    /**
     * 
     * @param brand String object
     * @return boolean isQueueEmpty
     */
    protected boolean isQueueEmpty (String brand, String env, String status) {
    	boolean isQueueEmpty = false; 
    	List<PublishQueue> queueList = getPublishQueueByBrandAndEnv(brand, env, status);
         if (queueList == null || queueList.isEmpty())
         { 
        	 isQueueEmpty = true;
         }
       return isQueueEmpty;  
    }
    
    /**
     * @param publishId
     * @return PublishQueue
     */
    private List<PublishQueue> getPublishQueueByBrandAndEnv (String brandCode, String environment, String status) 
    {
        List<PublishQueue> publishQueueList = null;
        try
        {
            publishQueueList = BridgePublishLocalServiceUtil.getPublishQueueRecords(brandCode, environment, status);
        } 
        catch (Exception e) 
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return publishQueueList;
    }
    
    /**
     * @param preferences
     * @param request
     * @return boolean isStaginPublicationExist
     * @author Chintan
     */
    protected boolean isStagePublicationExist(Preferences preferences, PortletRequest request) {
    	BridgeApplication application = new BridgeApplicationImpl(); 
    	
    	boolean isStaginPublicationExist = false;
    	if (Validator.isNotNull(preferences) && Validator.isNotNull(preferences.getBrand())) {
	    	try {
	    		Map<String,List<Publication>> allPublications = application.getAllPublicationRecords(preferences.getBrand(), request);
	        	Publication draftPublication = null;
	    		if (allPublications.get("bridge") != null && !allPublications.get("bridge").isEmpty()) 
		        {
		        	draftPublication = allPublications.get("bridge").get(0);
		        }
		    	if (allPublications.get("staging") != null && !allPublications.get("staging").isEmpty()) 
		        {
		        		Publication stagePublication = allPublications.get("staging").get(0);
		        		if (Validator.isNotNull(draftPublication) && Validator.isNotNull(stagePublication) && 
		        				stagePublication.getCreatedDate().compareTo(draftPublication.getCreatedDate()) > 0 ) {
		        			isStaginPublicationExist = true;
		        		}
		        }
	    	} catch (Exception e) {
	    	    //TODO DO NOT print stacktrace on missing Staging/Bridge publication 
//	    		LOG.error(StackTraceUtil.getStackTrace(e));
	    	}
    	}
    	return isStaginPublicationExist;
    }
    
    protected String getRegionName(String regionCode)
    {
        String regionName = null;
        try
        {
            regionName = StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(regionCode).getRegionName();
        }
        catch (NoSuchStandardsRegionException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return regionName;
    }

    protected long getBridgePublishId(String brandCode)
    {
        long bridgePublishId = 0;
        try
        {
            bridgePublishId = PublicationLocalServiceUtil.getPublishIdByBrand(brandCode, BSCommonConstants.PUBLISH_ENV_BRIDGE);
        }
        catch (SystemException e)
        {
            LOG.debug("No Publication exists for " + brandCode + " Brand");
        }
        return bridgePublishId;
    }
    
    protected long getLatestArchivePublishId(String brandCode, String environment)
    {
        Publication lastPublish = PublicationLocalServiceUtil.getLatestPublication(brandCode, environment, BridgeConstants.PUBLISH_ARCHIVE_STATUS_CODE);
        return lastPublish.getPublishId();
    }

    protected void submitReportRequest(ResourceRequest resourceRequest, ResourceResponse resourceResponse, boolean requireStdIdLst)
            throws IOException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Preferences preferences = getBridgeUserPreferences(resourceRequest);
        if (preferences != null)
        {
            HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
            HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
            String brandCode = preferences.getBrand();
            String regionCd = preferences.getRegionCode();
            
            String title = ParamUtil.getString(resourceRequest, "reportTitle");
            String reportId = ParamUtil.getString(resourceRequest, "reportId");
            String reportPublishId = ParamUtil.getString(resourceRequest, "reportPublishId");
            String stdIdLst = null;
            if (requireStdIdLst)
            {
                HttpSession session = getHttpSession(httpRequest);
                stdIdLst = (String)session.getAttribute("stdIdLst");
            }
            String userFullName = themeDisplay.getUser().getFullName();
            String screenName = themeDisplay.getUser().getScreenName();
            String email = themeDisplay.getUser().getEmailAddress();

            String returnMsg;
            if (stdIdLst != null && !stdIdLst.isEmpty() || !requireStdIdLst)
            {
                long bridgePublishId;
                if (reportPublishId != null &&!reportPublishId.isEmpty())
                {
                    bridgePublishId = Long.valueOf(reportPublishId);
                }
                else
                {
                    bridgePublishId = getBridgePublishId(brandCode);
                }
                long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
                returnMsg = submitReportRequest(reportId, title, brandCode, regionCd, regionId, stdIdLst, bridgePublishId,
                        userFullName, screenName, email);
            }
            else
            {
                LOG.error("stdIdLst is null for report = " + reportId);
                returnMsg = "Error: stdIdLst is null";
            }
            resourceResponse.getWriter().write(returnMsg);
            resourceResponse.getWriter().flush();
        }
        else
        {
            LOG.error("User must have preferences! User name = " + themeDisplay.getUser().getScreenName());
            resourceResponse.getWriter().write("No User Preferences Found!");
            resourceResponse.getWriter().flush();
        }
    }
    
    protected String submitReportRequest(String reportId, String title, String brandCode, String regionCode, long regionId,
            String stdIdLst, long publishId, String userFullName, String screenName, String email)
    {
        String returnMsg = "Success";
        
        StringBuilder metadata = new StringBuilder();
        metadata.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><metadata>");
        metadata.append("<type>").append(BridgeConstants.REPORT_TYPE_XLS_RERORT).append("</type>");
        metadata.append("<params>");
        metadata.append("<param name=\"ENVIRONMENT\">").append(BridgeConstants.BRIDGE_ENVIRONMENT).append("</param>");
        metadata.append("<param name=\"REPORT_ID\">").append(reportId).append("</param>");
        metadata.append("<param name=\"REPORT_TITLE\">").append(title).append("</param>");
        metadata.append("<param name=\"REPORT_TYPE\">").append(BridgeConstants.REPORT_TYPE_XLS_RERORT).append("</param>");
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
            PublishQueueLocalServiceUtil.createReport(metadata.toString(), screenName, email);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            returnMsg = "ERROR";
        }
        return returnMsg;
    }
    
    protected String submitAddToMyPublicationRequest(String brandCode, String regionCode, long regionId, long publishId, User user)
    {
        String returnMsg = "SCHEDULE_SUCCESS";
        
        StringBuilder metadata = new StringBuilder();
        metadata.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><metadata>");
        metadata.append("<type>").append(BridgeConstants.JOB_TYPE_ADD_TO_MY_PUBLICATION).append("</type>");
        metadata.append("<params>");
        StringBuilder metadataParams = getAddToMyPublicationMetadataParams(brandCode, regionCode, regionId, publishId);
        metadata.append(metadataParams);
        metadata.append("<param name=\"USER_NAME\">").append(user.getFullName()).append("</param>");
        metadata.append("</params>");
        metadata.append("</metadata>");

        // TODO verify whether new request exists
        try 
        {
            PublishQueueLocalServiceUtil.createReport(metadata.toString(), user.getScreenName(), user.getEmailAddress(), 
                    null, BridgeConstants.JOB_TYPE_ADD_TO_MY_PUBLICATION);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            returnMsg = "ERROR";
        }
        return returnMsg;
    }

    protected StringBuilder getAddToMyPublicationMetadataParams(String brandCode, String regionCode, long regionId, long publishId)
    {
        StringBuilder metadataParams = new StringBuilder();
        metadataParams.append("<param name=\"ENVIRONMENT\">").append(BridgeConstants.BRIDGE_ENVIRONMENT).append("</param>");
        metadataParams.append("<param name=\"PUBLISH_ID\">").append(publishId).append("</param>");
        metadataParams.append("<param name=\"REGION_CD\">").append(regionCode).append("</param>");
        metadataParams.append("<param name=\"REGION_ID\">").append(regionId).append("</param>");
        metadataParams.append("<param name=\"CHAIN_CD\">").append(brandCode).append("</param>");
        return metadataParams;
    }
        
    protected List<ReportConfig> getReport(String feature)
    {
        List<ReportConfig> config = ReportConfigLoader.getSortedReportConfig();
        
        return config;
    }
    
    protected void deleteStandardFromMyPublication(ThemeDisplay themeDisplay, HttpSession session,  
            Preferences preferences, long stdId, String brandCode, String regionCode)
    {
        User user = themeDisplay.getUser();
        BridgePublishApplicationImpl bridgePublishApp = new BridgePublishApplicationImpl();
        bridgePublishApp.deleteStandards(stdId, regionCode, brandCode);
      //Remove update preview country group list from session
        removeUpdatePreviewSessionAttributes(session, user.getUserId());
      //Create gem unique groups
        long regionId = BrandStandardsUtil.getRegionId(regionCode);
        long bridgePublishId = getBridgePublishId(brandCode);
        //GEM Unique Groups
        //commenting below line as sync on Q&L page load will handle country group generation - Jatin Panchal
        //addRequestInQueue(bridgePublishId, regionId, BridgeConstants.SA_REPORT_TYPE, preferences, user);
        //Bridge Unique Groups
        addRequestInQueue(bridgePublishId, regionId, BridgeConstants.BRIDGE_GROUPS_TYPE, preferences, user);
    }

    /**
     * 
     * @param session
     * @param userId
     */
    protected void removeUpdatePreviewSessionAttributes (HttpSession session, long userId) {
    	//Remove update preview country group list from session
        session.removeAttribute("countryGroup_"+userId);
        session.removeAttribute("sessionGrpName");
        session.removeAttribute("sessionChainCD");
        session.removeAttribute("sessionRgnCD");
    }

    protected void addStdIdToSession(HttpSession session, List<Standard> myPublicationsList, boolean includeGuideline)
    {
        StringBuilder stdIdLst = new StringBuilder();
        for (Standard std : myPublicationsList)
        {
            addStdId(stdIdLst, std);
            
            for (Standard rec : std.getSpecifications())
            {
                addStdId(stdIdLst, rec);
            }

            if (includeGuideline)
            {
                for (Standard rec : std.getGuidelines())
                {
                    addStdId(stdIdLst, rec);
                }
            }
        }
        session.setAttribute("stdIdLst", stdIdLst.toString());
    }
    
    protected void addStdId(StringBuilder stdIdLst, Standard std)
    {
        if (stdIdLst.length() > 0)
        {
            stdIdLst.append(":::");
        }
        stdIdLst.append(std.getStdId());
    }

    /**
     * This method will get the active languages for a region except en_GB.
     * 
     * @param regionCd the region code
     * @return Map<String, String>
     */
    protected Map<String, String> getRegionActiveSecondLanguages(String regionCd)
    {
        Map<String, String> activeSecondLanguages = new LinkedHashMap<String, String>();
        try
        {
            activeSecondLanguages = StandardsLocaleLocalServiceUtil.getActiveLanguages(QueryUtils.getActiveSecondLangsByRegion(regionCd));
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return activeSecondLanguages;
    }
    
    /**
     * 
     * @param publishId
     * @param regionId
     * @param groupType
     * @param preferences
     * @param user
     */
    protected void addRequestInQueue (long publishId, long regionId, String groupType, Preferences preferences, User user) {
    	Processor processor = ProcessorFactory.getProcessorObject("SA");
    	//Get manual type of SE, SA and Waiver
        Map<String,String> manualTypes =  GEMQlReportLocalServiceUtil.getReportManualTypes(GemQueryUtils.getReportManualTypes(publishId));
    	String compareMetadata = processor.generateMetadata(preferences.getBrand(), preferences.getRegionCode(), 
                regionId, publishId, groupType, manualTypes.get(groupType), StringPool.PERCENT);
        
        //If job que request is in queue then do not create new request
        if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetadata, StringPool.PERCENT, 
                BridgeConstants.JOB_TYPE_COUNTRY_GROUP, BridgeConstants.QUEUE_NEW_STATUS)) {
            processor.addMessageInQueue(BridgeConstants.JOB_TYPE_COUNTRY_GROUP, publishId, groupType, manualTypes.get(groupType), preferences, user);
        }
    }
}
