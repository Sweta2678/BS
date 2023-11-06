package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.ihg.brandstandards.bridge.application.BridgeApplication;
import com.ihg.brandstandards.bridge.application.impl.BridgeApplicationImpl;
import com.ihg.brandstandards.bridge.util.BrandStandardsUtil;
import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchPublicationException;
import com.ihg.brandstandards.db.NoSuchPublishQueueException;
import com.ihg.brandstandards.db.model.BridgePublishLang;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.service.BridgePublishLangLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.util.QueryUtils;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * 
 * @author AkhaniC
 * Global Manage functionality
 *
 */
public class ManagePublicationPortlet extends ProgressMVCPortlet 
{
    private static final Log LOG = LogFactoryUtil.getLog(ManagePublicationPortlet.class);
    private static final String DEFAULT_TIME = "00:00";
    
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        BridgeApplication application = new BridgeApplicationImpl();
        Map<String,String> chnMap = BrandStandardsUtil.chainCodeMap();
        Preferences preferences = getBridgeUserPreferences(renderRequest);
        boolean removeDraftPublication = true;
        boolean updatePublicationDate = true;
        boolean publishToStaging = true;
        boolean publishToProd = true;
        if (Validator.isNotNull(preferences) && Validator.isNotNull(preferences.getBrand())) {
        	
	        Map<String,List<Publication>> allPublications = application.getAllPublicationRecords(preferences.getBrand(), renderRequest);
	        Publication  draftPublication = null;
	        //check for draft publication
	        if (allPublications.get("bridge") != null && !allPublications.get("bridge").isEmpty()) 
	        {
	        	draftPublication = allPublications.get("bridge").get(0);
	        	renderRequest.setAttribute("checkProgress", getOverAllProgress(renderRequest, draftPublication, true));
	        	long count = BridgePublishLocalServiceUtil.getStandardCountForPublication(draftPublication.getPublishId());
	        	if (!isQueueEmpty(draftPublication.getChainCode(), BridgeConstants.STAGING_ENVIRONMENT, statusList.toString())) {
	        		publishToStaging = false;
	        		removeDraftPublication = false;
	        	}
	        	renderRequest.setAttribute("stdCount", count);
	        }
	        renderRequest.setAttribute("currentBrand", chnMap.get(preferences.getBrand()));
	        renderRequest.setAttribute("createPublication", isPublicationExist(preferences.getBrand(), BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE, 
	        		BridgeConstants.PRE_STAGING_ENVIRONMENT));
	        
	        renderRequest.setAttribute("publication", allPublications);
	        //set all languages into request
	        renderRequest.setAttribute("languages", getActiveLanguages());
	        
	        if (allPublications.get("staging") != null && !allPublications.get("staging").isEmpty()) 
	        {
	        	try 
	        	{
	        		for (Publication stagePublication : allPublications.get("staging")) {
	        			if ("ACTIVE".equals(stagePublication.getPublishStatCd())) {
		        			if (Validator.isNotNull(draftPublication) && Validator.isNotNull(stagePublication) && 
		        				draftPublication.getPublishId() == stagePublication.getParentPublishId()) {
		        				removeDraftPublication = false;
		        				if (LOG.isDebugEnabled()) {
		        					LOG.debug(" Bridge publication has staging publication available :");
		        				}
		        			} else {
		        				if (LOG.isDebugEnabled()) {
		        					LOG.debug(" Bridge publication does not have staging publication available :");
		        				}
		        			}
		        			PublishQueue queue = PublishQueueLocalServiceUtil.findPublishQueueByPublishId(stagePublication.getPublishId());
		        			renderRequest.setAttribute("stageToProdDate", queue.getExpectedProdPublishDt());
	        			}
	        		}
				} 
	        	catch (NoSuchPublishQueueException e) 
	        	{
					LOG.error(StackTraceUtil.getStackTrace(e));
				} 
	        	catch (SystemException e) 
	        	{
					LOG.error(StackTraceUtil.getStackTrace(e));
				}
	        }
	        //Check production publication
	        publishToProd = isQueueEmpty(preferences.getBrand(), BridgeConstants.PRODUCTION_ENVIRONMENT, statusList.toString());
	        
	        //check if publication in staging or production is in progress 
	        if (!publishToProd || !publishToStaging) {
	        	removeDraftPublication = false;
	        	updatePublicationDate = false;
	        }
        }  
        renderRequest.setAttribute("removeDraftPublication",removeDraftPublication);
        renderRequest.setAttribute("publishToStaging", publishToStaging);
        renderRequest.setAttribute("publishToProd", publishToProd);
        renderRequest.setAttribute("updatePublicationDate", updatePublicationDate);
        super.doView(renderRequest, renderResponse);
    }
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        String requestType = ParamUtil.getString(resourceRequest, "requestType");
        resourceResponse.setContentType(ContentTypes.APPLICATION_TEXT);
        resourceResponse.setCharacterEncoding(StringPool.UTF8);
        Preferences preferences = getBridgeUserPreferences(resourceRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String respMsg = BridgeConstants.SUCCESS_MSG;
                
        if ("createPublication".equals(requestType))
        {
            respMsg = createPublication(resourceRequest, resourceResponse, preferences);
        }
        else if ("publishToStaging".equals(requestType))
        {
            respMsg = publishedToStaging(resourceRequest, resourceResponse);
        }
        else if ("publishToProduction".equals(requestType))
        {
            respMsg = publishedToProduction(resourceRequest, resourceResponse, themeDisplay.getUserId());
        }
        else if ("deletePublication".equals(requestType)) 
        {
            if (ParamUtil.getLong(resourceRequest, "publishId") != 0l) {
            	respMsg = deleteBridgePublication(resourceRequest, preferences);
            } else if (ParamUtil.getLong(resourceRequest, "publishQueueId") != 0l) {
            	respMsg = deleteStagePublication(resourceRequest, preferences);
            }
        } 
        else if ("updatePublication".equals(requestType))
        {
            respMsg = updatePublication(resourceRequest, themeDisplay);
        } 
        else if ("createManuals".equalsIgnoreCase(requestType)) 
        {
            respMsg = createManuals(resourceRequest, resourceResponse);
        }
        else if ("createReport".equals(requestType))
        {
            submitReportRequest(resourceRequest, resourceResponse, false);
        }
        
        try
        {
            resourceResponse.getWriter().write(respMsg);
        }
        catch (IOException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        super.serveResource(resourceRequest, resourceResponse);
    }

    /**
     * Create new draft publication.
     * @param resourceRequest
     * @param resourceResponse
     * @param preferences
     * @return
     */
    private String createPublication(ResourceRequest resourceRequest, ResourceResponse resourceResponse, Preferences preferences)
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	String respMsg = BridgeConstants.SUCCESS_MSG;
        if (isPublicationExist(preferences.getBrand(), BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE, BridgeConstants.PRE_STAGING_ENVIRONMENT))
        {
            respMsg = BridgeConstants.CREATE_PUBLICATION_ERROR_MSG;
        }
        else 
        {
        	Publication publish = createPublication(resourceRequest, resourceResponse, preferences.getBrand(), BridgeConstants.PRE_STAGING_ENVIRONMENT, BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE);
        	if (publish != null){
	        	populateBridgePublishLangauges(publish, themeDisplay);
	            respMsg = BridgeConstants.SUCCESS_MSG;
        	}
        }
        return respMsg;
    }

    /**
     * Update existing Publication.
     * @param resourceRequest request
     * @param themeDisplay response
     * @return error code
     */
    private String updatePublication(ResourceRequest resourceRequest, ThemeDisplay themeDisplay)
    {
        String respMsg = BridgeConstants.PUBLISH_PROD_ERROR_MSG;
        long publishId = ParamUtil.getLong(resourceRequest, "publishId");
        SimpleDateFormat formatter = new SimpleDateFormat(BridgeConstants.DATE_FORMAT_NEW);
        Date publishDate = GetterUtil.getDate(resourceRequest.getParameter("publishDate"), formatter);
        String environment = ParamUtil.getString(resourceRequest, "environment");
        String contentType = getContentType(resourceRequest);
        
        if (publishId > 0L && Validator.isNotNull(resourceRequest.getParameter("publishDate"))) {
        	if (LOG.isDebugEnabled())
            {
                LOG.debug("update publication date :" + formatter.format(publishDate));
            }
        	if (updatePublication(publishId, publishDate, null, themeDisplay.getUserId(), environment))
            {
                respMsg = BridgeConstants.SUCCESS_MSG;
            }
        } else if (publishId > 0l &&  contentType != null && !contentType.isEmpty()) {
        	
        	if (LOG.isDebugEnabled()) {
        		LOG.debug("Manual type change :"+contentType);
        	}
        		
        	if (updatePublication(publishId, null, contentType, themeDisplay.getUserId(), environment))
            {
                respMsg = BridgeConstants.SUCCESS_MSG;
            }
        }
       
        return respMsg;
    }

    /**
     * Delete Publication.
     * @param resourceRequest request
     * @param themeDisplay response
     * @return error code
     */
    private String deleteBridgePublication(ResourceRequest resourceRequest, Preferences preferences)
    {
        String respMsg = BridgeConstants.PUBLISH_PROD_ERROR_MSG;
        long publishId = ParamUtil.getLong(resourceRequest, "publishId");
        if (publishId > 0L)
        {
            try
            {
                if (isQueueEmpty(preferences.getBrand(),BridgeConstants.STAGING_ENVIRONMENT, statusList.toString()))
                {
                    //Soft delete. Change publication status to delete
                	Publication publication = PublicationLocalServiceUtil.getPublication(publishId);
                    publication.setPublishStatCd(BridgeConstants.PUBLISH_DELETE_STATUS_CODE);
                    PublicationLocalServiceUtil.updatePublication(publication);
                    respMsg = BridgeConstants.SUCCESS_MSG;
                    LOG.info("Publication deleted :" + publishId);
                }
                else
                {
                    respMsg = BridgeConstants.PUBLISH_STAGING_IN_PROGRESS;
                    LOG.info("Publication not deleted :" + publishId);
                }
            }
            catch (PortalException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            catch (SystemException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        return respMsg;
    }
    
    /**
     * Create new Publication.
     * @param request RenderRequest object
     * @param response RenderResponse object
     * @param brand String object
     * @param env String object
     * @param status String object
     * @return Publish
     */
    private Publication createPublication (PortletRequest request, PortletResponse response, String brand, String env, String status) 
    {
        //get current brand from preferences
    	SimpleDateFormat formatter = new SimpleDateFormat(BridgeConstants.DATE_FORMAT_NEW);
        Date publicationDate = GetterUtil.getDate(request.getParameter("dateInput"), formatter);
        String contentType = getContentType(request);

        Publication publish = null;
        if (LOG.isDebugEnabled())
        {
        	LOG.debug("Date formatter type :" + BridgeConstants.DATE_FORMAT_NEW);
    		LOG.debug("publishDate :" + formatter.format(publicationDate));
    	}
        if (Validator.isNotNull(publicationDate)) 
        {
            try
            {
                ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
                User user = themeDisplay.getUser();
                publish = PublicationLocalServiceUtil.createPublication();
                publish.setCreatorId(String.valueOf(user.getUserId()));
                publish.setUpdatedBy(String.valueOf(user.getUserId()));
                publish.setPublishDate(publicationDate);
                publish.setChainCode(brand);
                publish.setPublishEnvName(env);
                publish.setPublishStatCd(status);
                publish.setPublishContentType(contentType);
                //set parent publish id
                publish.setParentPublishId(publish.getPublishId());
                publish = PublicationLocalServiceUtil.addPublication(publish);
                //create standard entries into bridge publish table
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Draft publication created :" + publish.getPublishId());
                }
                if (!BridgeConstants.PRODUCTION_ENVIRONMENT.equals(status))
                {
                    BridgePublishLocalServiceUtil.createDraftPublication(publish.getPublishId(), brand, user.getScreenName());
                    //Delete staging publication if it is exist.
                    try {
						Publication stagePublish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE,
						        BridgeConstants.STAGING_ENVIRONMENT, brand);
						stagePublish.setPublishStatCd(BridgeConstants.PUBLISH_DELETE_STATUS_CODE);
						PublicationLocalServiceUtil.updatePublication(stagePublish);
					} catch (NoSuchPublicationException e) {
						 LOG.error(StackTraceUtil.getStackTrace(e));
					}
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("Standard entiries added into bridge publish table for brand :" + brand);
                    }
                }

            }
            catch (SystemException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
       return publish; 
    }

    private String getContentType(PortletRequest request)
    {
        String contentType;
        String operateType = request.getParameter("operateType");
        String buildType = request.getParameter("buildType");
        if ("true".equals(operateType) && "true".equals(buildType))
        {
            contentType = BridgeConstants.MANUAL_TYPE_FULL_BUILD_OPERATE;
        }
        else if ("true".equals(operateType))
        {
            contentType = BridgeConstants.MANUAL_TYPE_OPERATE;
        }
        else if ("true".equals(buildType))
        {
            contentType = BridgeConstants.MANUAL_TYPE_BUILD;
        }
        else
        {
            contentType = BridgeConstants.MANUAL_TYPE_FULL;
        }
        return contentType;
    }
    
    /**
     * Is Publication exist.
     * @param brand
     * @param status
     * @param environment
     * @return boolean
     */
    private boolean isPublicationExist (String brand, String status, String environment)  
    {
        boolean isRecordExist = false;
        try
        {
        	Publication publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(status, environment, brand);
            if (publish != null)
            {
                isRecordExist = true;
            }
        }
        catch (NoSuchPublicationException e)
        {
//            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return isRecordExist;
    }
    
    /**
     * Publish to Staging.
     * @param resourceRequest request
     * @param themeDisplay response
     * @return error code
     */
    private String publishedToStaging (ResourceRequest request, ResourceResponse response) 
    {
        //get current brand from preferences
        Preferences preferences =  getBridgeUserPreferences(request);
        String currentBrand = preferences.getBrand();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Publication publish = null;
        User user = themeDisplay.getUser();
        String respMsg = BridgeConstants.SUCCESS_MSG;
        try
        {
            publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE,
                    BridgeConstants.PRE_STAGING_ENVIRONMENT, currentBrand);
            if (isQueueEmpty(currentBrand, BridgeConstants.STAGING_ENVIRONMENT, statusList.toString()))
            {
                if (publish != null)
                {
                    if (!addToPublishQueue(request, BridgeConstants.STAGING_ENVIRONMENT, user, currentBrand, publish))
                    {
                        respMsg = BridgeConstants.PUBLISH_PROD_ERROR_MSG;
                    } 
                }
            }
            else
            {
                respMsg = BridgeConstants.PUBLISH_STAGING_IN_PROGRESS;
            }
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (NoSuchPublicationException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return respMsg;
    }
    
    /**
     * Publish to Production.
     * @param resourceRequest request
     * @param themeDisplay response
     * @return error code
     */
    private String publishedToProduction (PortletRequest request, ResourceResponse response, long userId) 
    {
        //get current brand from preferences
        Preferences preferences = getBridgeUserPreferences(request);
        final String currentBrand = preferences.getBrand();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        String respMsg = BridgeConstants.SUCCESS_MSG;
        if (!addToPublishQueueProduction(request, BridgeConstants.PRODUCTION_ENVIRONMENT, currentBrand, user))
        {
            respMsg = BridgeConstants.PUBLISH_PROD_ERROR_MSG;
        }
        return respMsg;
    }
    
    /**
     * Add request to publish to Staging / Production Environment.
     * @param resourceRequest
     * @param pubEnv
     * @param user
     * @param pubBrand
     * @param publish
     * @throws SystemException
     */
    private boolean addToPublishQueue(final PortletRequest resourceRequest, String pubEnv, final User user, final String pubBrand, 
    		Publication publish) throws SystemException
    {
        boolean pubSchedule = ParamUtil.getBoolean(resourceRequest,"publishSchedule", false);
        String pubDate = resourceRequest.getParameter("publishDate");
        String pubTime = resourceRequest.getParameter("publishTime");
        String pubEmail = resourceRequest.getParameter("publishEmail");
        boolean isAddedToQueue = false;
        //Use BridgeLang service to find locales
        Map<String,String> languages = BridgePublishLangLocalServiceUtil.getAllLanguagesForPublication (publish.getPublishId());
        if (Validator.isNotNull(pubEmail)) 
        {
        	pubEmail = user.getEmailAddress() + StringPool.COMMA + pubEmail;
        } 
        else 
        {
        	pubEmail = user.getEmailAddress();
        }
        
        String locales = BridgeCommonUtil.getPublicationLanguages(languages);
        
        if (LOG.isDebugEnabled()) 
        {
        	LOG.debug("locales :" + locales);
        	LOG.debug("It is a scheduled publication :"+resourceRequest.getParameter("publishSchedule"));
        }

        //add stdIds into PUBLISH_FILE_TXT column
        PublishQueue queue = PublishQueueLocalServiceUtil.createPublishQueueOraSecuence();
        queue.setPublishId(publish.getPublishId());
        queue.setPublishEnvironment(pubEnv);
        queue.setNotificationEmailId(pubEmail);
        queue.setPublishFileText(BridgeConstants.BRIDGE_PUB_ID_TAG + publish.getPublishId() + StringPool.SEMICOLON + 
                                 BridgeConstants.BRIDGE_PUB_USER_NAME_TAG + user.getFullName());
        queue.setQueueStatCd(BridgeConstants.QUEUE_NEW_STATUS);
        
        //schedule publication
        try
        {
            if (Validator.isNotNull(pubDate) && pubSchedule) 
            {
                SimpleDateFormat formatter = new SimpleDateFormat(BridgeConstants.DATE_FORMAT);
                pubDate = pubDate.replaceAll(StringPool.DASH, StringPool.SPACE);
                Date schedulePublishDate = formatter.parse(pubDate + StringPool.SPACE + pubTime);
                queue.setSchedulePublish(schedulePublishDate);
            }
        } 
        catch (ParseException e) {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        
        queue.setExpectedProdPublishDt(publish.getPublishDate());
        queue.setChainCd(pubBrand);
        queue.setPublishLocaleList(locales);
        String crUser = String.valueOf(user.getUserId());
        queue.setCreatorId(crUser);
        queue.setUpdatedBy(crUser);
        PublishQueueLocalServiceUtil.addPublishQueue(queue);
        isAddedToQueue = true;

        return isAddedToQueue;
    }
    
    /**
     * Add request to publish to a specified Environment.
     * @param resourceRequest request
     * @param pubEnv environment
     * @param brand brandCode
     * @param user User object
     * @throws SystemException exception
     */
    private boolean addToPublishQueueProduction(final PortletRequest resourceRequest, String pubEnv, String brand, User user)
    {
        boolean isRecordAdded = false;
        boolean pubSchedule = ParamUtil.getBoolean(resourceRequest,"publishSchedule");
        String pubDate = resourceRequest.getParameter("publishDate");
        String pubTime = resourceRequest.getParameter("publishTime");
        String pubEmail = resourceRequest.getParameter("publishEmail");
    	long publishQueueId = 0l;
    	if (Validator.isNotNull(pubEmail)) 
    	{
        	pubEmail = user.getEmailAddress()+StringPool.COMMA+pubEmail;
        } 
    	else
    	{
        	pubEmail = user.getEmailAddress();
        }
    	
        try 
        {
        	Publication publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE,
                BridgeConstants.STAGING_ENVIRONMENT, brand);
            PublishQueue stagingQueue = PublishQueueLocalServiceUtil.findPublishQueueByPublishId(publish.getPublishId());
            publishQueueId = stagingQueue.getPublishQueueId();
        }
        catch (NoSuchPublicationException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (NoSuchPublishQueueException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        
        try {
	        if (Validator.isNotNull(publishQueueId)) 
	        {
	        	Date schedulePublishDate = new Date();
	            if (Validator.isNotNull(pubDate) && pubSchedule) 
	            {
	            	SimpleDateFormat formatter = new SimpleDateFormat(BridgeConstants.DATE_FORMAT);
	            	pubDate = pubDate.replaceAll(StringPool.DASH, StringPool.SPACE);
	            	if (Validator.isNull(pubTime)) {
	            		pubTime = DEFAULT_TIME;
	            	}
	                schedulePublishDate = formatter.parse(pubDate + StringPool.SPACE + pubTime);
	            }
	            PublishQueue queue = PublishQueueLocalServiceUtil.clonePublishQueue(publishQueueId);
	            if (Validator.isNotNull(queue)) {
		            queue.setNotificationEmailId(pubEmail);
		            queue.setQueueStatCd(BridgeConstants.QUEUE_NEW_STATUS);
			        //schedule push
			        queue.setSchedulePublish(schedulePublishDate);
			        queue.setPublishEnvironment(pubEnv);
			        queue.setCreatorId(StringPool.BLANK+user.getUserId());
			        queue.setUpdatedBy(StringPool.BLANK+user.getUserId());
		            PublishQueueLocalServiceUtil.addPublishQueue(queue);
		            PublishQueueLocalServiceUtil.updatePublishQueueStatus(publishQueueId, BridgeConstants.QUEUE_PROD_STATUS);
		            isRecordAdded = true;
	            }
	        }
        } 
        catch (SystemException e) 
        {
        	LOG.error(StackTraceUtil.getStackTrace(e));
        } 
        catch (ParseException e) 
        {
        	LOG.error(StackTraceUtil.getStackTrace(e));
		}
        return isRecordAdded;
    }
    
    /**
     * 
     * @param publishId
     * @param publishDate
     * @param userId
     * @return boolean
     */
    private boolean updatePublication (long publishId, Date publishDate, String contentType, long userId, String environment) 
    {
        boolean isPublicationUpdated = false;
        if (BridgeConstants.BRIDGE_ENVIRONMENT.equals(environment)) 
        {
			try {
				Publication publish = PublicationLocalServiceUtil.getPublication(publishId);
				if (publishDate != null)
				{
				    publish.setPublishDate(publishDate);
				}
				if (contentType != null && !contentType.isEmpty())
				{
				    publish.setPublishContentType(contentType);
				}
            	publish.setUpdatedDate(new Date());
            	publish.setUpdatedBy(StringPool.BLANK+userId);
            	PublicationLocalServiceUtil.updatePublication(publish);
            	isPublicationUpdated = true;
			} catch (PortalException e) {
				LOG.error(StackTraceUtil.getStackTrace(e));
			} catch (SystemException e) {
				LOG.error(StackTraceUtil.getStackTrace(e));
			}
        	
            if (publishDate != null)
            {
				try {
					PublishQueue publishQueue = PublishQueueLocalServiceUtil.findPublishQueueByPublishId(publishId);
					publishQueue.setExpectedProdPublishDt(publishDate);
	            	PublishQueueLocalServiceUtil.updatePublishQueue(publishQueue);
				} catch (NoSuchPublishQueueException e) {
					LOG.error(StackTraceUtil.getStackTrace(e));
				} catch (SystemException e) {
					LOG.error(StackTraceUtil.getStackTrace(e));
					isPublicationUpdated = false;
				}
            }
        } 
        return isPublicationUpdated;
    }
    
    /**
     * 
     * @param publishId
     * @param allRgn
     * @return boolean
     */
    private Map<Long,Boolean> getOverAllProgress (PortletRequest portletRequest,  Publication publication, boolean allRgn) 
    {
    	boolean isVerified = true;
    	Map<Long,Boolean> allProgress = new HashMap<Long, Boolean>();
    	// check progress for all activities, pass global id in case you are looking for all regions verification
    	Map<String, Long> overAllProgress = setOverallProgressCounts(portletRequest, publication, 1l);
    	//Check for compliance
    	overAllProgress.putAll(setComplianceProgressCounts(portletRequest, publication, 1l));
    	Iterator<Map.Entry<String, Long>> itr = overAllProgress.entrySet().iterator();
    	while(itr.hasNext()) 
    	{
    		Map.Entry<String, Long> entry = itr.next();
    		if (!BridgeConstants.COUNT_MISS_XREF.equals(entry.getKey()) && 
    				!BridgeConstants.COUNT_SELECT_STATE.equals(entry.getKey()) && !BridgeConstants.COUNT_OVERRIDDEN.equals(entry.getKey()) && entry.getValue() != 0) 
    		{
    			isVerified = false;
    			break;
    		}
    	}
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("overAllProgress :"+overAllProgress);
    	}
    	//Check for override executive and check for languages
    	if (isVerified && !"Y".equals(publication.getValidateTranslation())) {
    		isVerified = checkTranslationStatus(portletRequest, publication, 1l);
    	} else {
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("Is verified :::"+isVerified);
    			LOG.debug("Override executive order :::"+publication.getValidateTranslation());
    		}
    	}
    	LOG.info("Is verified :::"+isVerified);
    	//If any of selected language and / or overall progress task (except noOfMissingXrefIds)  has count > 0 then publish to staging button will be disabled. 
    	allProgress.put(publication.getPublishId(), isVerified);
    	return allProgress;
    }
    
    /**
     * Create Manuals.
     * @param resourceRequest request
     * @param resourceResponse response
     * @return String error code
     */
    private String createManuals(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse)
    {
        //String pubEnv = ParamUtil.getString(resourceRequest, "pubEnv");
        long publishId = ParamUtil.getLong(resourceRequest, "publishId");
        String status = BridgeConstants.PUBLISH_PROD_ERROR_MSG;
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
        LOG.info("Publish Id :"+publishId);
        try
        {
            if (publishId != 0l) {
            	PublishQueue publishQueue = PublishQueueLocalServiceUtil.findPublishQueueByPublishId(publishId);
            	//Create manuals
            	User user = themeDisplay.getUser();
            	BridgePublishLocalServiceUtil.createManuals(publishQueue.getPublishQueueId(), publishId, user.getEmailAddress(), user.getFullName());
            	status = BridgeConstants.SUCCESS_MSG;
            } 
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        } catch (NoSuchPublishQueueException e) {
            LOG.error(e.getMessage(), e);
		}
        return status;
    }
    
    /**
     * Delete Publication.
     * @param resourceRequest request
     * @param themeDisplay response
     * @return error code
     */
    private String deleteStagePublication(ResourceRequest resourceRequest, Preferences preferences)
    {
        String respMsg = BridgeConstants.SUCCESS_MSG;
        long publishQueueId = ParamUtil.getLong(resourceRequest, "publishQueueId");
        	
        if (publishQueueId > 0L)
        {
            try
            {
            	BridgeApplication application = new BridgeApplicationImpl();
            	//Clear cache
            	try {
            		PublishQueueLocalServiceUtil.clearCache();
            	} catch (Exception e) {
            		LOG.error(StackTraceUtil.getStackTrace(e));
            	}
            	//Get publishQueue record
            	PublishQueue publishQueue = application.getPublishQueueObject(0l, publishQueueId);
            	
            	if ("NEW".equals(publishQueue.getQueueStatCd()))
                {
                    //Remove publication queue record
                    PublishQueueLocalServiceUtil.deletePublishQueue(publishQueueId);
                    LOG.info("PublishQueue deleted :" + publishQueueId);
                }
                else
                {
                    respMsg = BridgeConstants.PUBLISH_STAGING_IN_PROGRESS;
                    LOG.info("PublishQueue not deleted :" + publishQueueId);
                }
            }
            catch (PortalException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            catch (SystemException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        return respMsg;
    }
    
    /**
     * 
     * @param publishId
     * @return boolean
     */
    private boolean checkTranslationStatus (PortletRequest portletRequest, Publication publication, long rgnId) {
    	boolean isVerified = true;
    	try {
    		Map<String,String> languages = BridgePublishLangLocalServiceUtil.getAllLanguagesForPublication(publication.getPublishId());
    		Map<String, Long> translationsCount = null;
				if (isVerified) {
					//Index translation
	    			setIndexTranslationCounts(portletRequest, publication, rgnId);
	    			translationsCount = (Map<String, Long>) portletRequest.getAttribute("indexTranslationCounts");
	    			
					if (Validator.isNotNull(translationsCount) && translationsCount.size() > 0) 
					{
						isVerified =  isTranslationAvailable(languages, translationsCount);
				    	if (LOG.isDebugEnabled()) {
			    			LOG.debug("index translation for publication verified :"+isVerified);
			    			LOG.debug("languages for publication :"+languages);
			    			LOG.debug("Index translationsCount :"+translationsCount);
			    		}
					}
					//Content translation
					if (isVerified) {
						setContentTranslationCounts(portletRequest, publication, rgnId);
						translationsCount = null;
						translationsCount = (Map<String, Long>) portletRequest.getAttribute("contentTranslationCount");
						if (Validator.isNotNull(translationsCount) && translationsCount.size() > 0) 
						{
							isVerified =  isTranslationAvailable(languages, translationsCount);
					    	if (LOG.isDebugEnabled()) {
				    			LOG.debug("content translation for publication verified :"+isVerified);
				    			LOG.debug("languages for publication :"+languages);
				    			LOG.debug("translationsCount :"+translationsCount);
				    		}
						}
					}
					
					//Supported documents translation
					if (isVerified) {
						setSupportDocsTranslationCounts(portletRequest, publication, rgnId);
						translationsCount = null;
						translationsCount = (Map<String, Long>) portletRequest.getAttribute("supportDocsTranslationCounts");
						if (Validator.isNotNull(translationsCount) && translationsCount.size() > 0) 
						{
							isVerified =  isTranslationAvailable(languages, translationsCount);
					    	if (LOG.isDebugEnabled()) {
				    			LOG.debug("Supported documents translation for publication verified :"+isVerified);
				    			LOG.debug("languages for publication :"+languages);
				    			LOG.debug("translationsCount :"+translationsCount);
				    		}
						}
					}
					
					//Links translation
					if (isVerified) {
						setLinkTranslationCounts(portletRequest, publication, rgnId);
						translationsCount = null;
						translationsCount = (Map<String, Long>) portletRequest.getAttribute("linkTranslationCounts");
						if (Validator.isNotNull(translationsCount) && translationsCount.size() > 0) 
						{
							isVerified =  isTranslationAvailable(languages, translationsCount);
					    	if (LOG.isDebugEnabled()) {
				    			LOG.debug("link translation for publication verified :"+isVerified);
				    			LOG.debug("languages for publication :"+languages);
				    			LOG.debug("translationsCount :"+translationsCount);
				    		}
						}
					}
					
					//Images translation
					if (isVerified) {
						setImageTranslationCounts(portletRequest, publication, rgnId);
						translationsCount = null;
						translationsCount = (Map<String, Long>) portletRequest.getAttribute("imageTranslationCounts");
						if (Validator.isNotNull(translationsCount) && translationsCount.size() > 0) 
						{
							isVerified =  isTranslationAvailable(languages, translationsCount);
					    	if (LOG.isDebugEnabled()) {
				    			LOG.debug("Images translation for publication verified :"+isVerified);
				    			LOG.debug("languages for publication :"+languages);
				    			LOG.debug("translationsCount :"+translationsCount);
				    		}
						}
					}
				}
    		
		} catch (PortletException e) {
			LOG.error(e.getMessage(), e);
		}
    	
    	return isVerified;
    }

    private void populateBridgePublishLangauges(Publication publish, ThemeDisplay themeDisplay){
    	final String RGN_CD_LIST[] = {"GLBL", "AMEA", "AMER", "EURO", "GC"};
    	for(String regionCd : RGN_CD_LIST) {
	    	Map<String, String> activeSecondLanguages = getRegionActiveSecondLanguages(regionCd);
	    	long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
	        for(Map.Entry<String, String> langOpt : activeSecondLanguages.entrySet()) {
		        try {
		            BridgePublishLang bridgePublishLang = getBridgePublishLanguage(publish, rgnId, langOpt.getKey());
		            if (bridgePublishLang == null) {
		                bridgePublishLang = BridgePublishLangLocalServiceUtil.createBridgePublishLang(CounterLocalServiceUtil
		                        .increment(BridgePublishLang.class.getName()));
		                bridgePublishLang.setPublishId(publish.getPublishId());
		                bridgePublishLang.setRegionId(rgnId);
		                bridgePublishLang.setLocaleCode(langOpt.getKey());
		                bridgePublishLang.setCreatorId(String.valueOf(themeDisplay.getUserId()));
		                bridgePublishLang.setCreatedDate(new Date());
		                bridgePublishLang.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
		                bridgePublishLang.setUpdatedDate(new Date());
		                BridgePublishLangLocalServiceUtil.updateBridgePublishLang(bridgePublishLang);
		            }
		        }
		        catch (Exception e)
		        {
		            LOG.error(e);
		        }
	        }
    	}
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
     * Get Publish language for a Region.
     * 
     * @param publish Publish
     * @param rgnId Region Id
     * @param localeCode locale
     * @return BridgePublishLang or null
     */
    protected BridgePublishLang getBridgePublishLanguage(Publication publish, long rgnId, String localeCode)
    {
        BridgePublishLang bridgePublishLang = null;
        try
        {
            bridgePublishLang = BridgePublishLangLocalServiceUtil.getByRegionAndLocale(publish.getPublishId(), rgnId, localeCode);
        }
        catch (Exception e)
        {
        }
        return bridgePublishLang;
    }
    
    /**
     * 
     * @param languages
     * @param translationCount
     * @return boolean
     */
    protected boolean isTranslationAvailable (Map<String, String> languages,  Map<String, Long> translationCount) {
    	boolean isAvailable = true;
    	Iterator<Map.Entry<String, String>> langItr = languages.entrySet().iterator();
    	Map.Entry<String, String> langEntry = null;
    	Iterator<Map.Entry<String, Long>> translation = null;
    	Map.Entry<String, Long> countEntry = null;
    	while(langItr.hasNext()) 
    	{
    		langEntry = langItr.next();
    		translation = translationCount.entrySet().iterator();
    		while (translation.hasNext()) {
    			countEntry = translation.next();
    			if (langEntry.getValue().contains(countEntry.getKey()) && countEntry.getValue() > 0) {
    				isAvailable = false;
    				break;
    			}
    		}
    		if (!isAvailable) {
    			break;
    		}
    	}
    	return isAvailable;
    }
}