package com.ihg.brandstandards.bridge.portlet;


import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.bridge.application.BridgeApplication;
import com.ihg.brandstandards.bridge.application.impl.BridgeApplicationImpl;
import com.ihg.brandstandards.bridge.model.BridgePublishAppModel;
import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.bridge.util.StandardsUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.custom.model.StdImage;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.UniqueGroup;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishPreviewLocalServiceUtil;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.UniqueGroupCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.UniqueGroupLocalServiceUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * 
 * @author AkhaniC
 *
 */
public class UpdatePreviewPortlet extends AbstractPreviewPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(UpdatePreviewPortlet.class);
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        try 
        {

        	long userId = PortalUtil.getUserId(renderRequest);
        	ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            if (userId > 1)
            {
                renderRequest.setAttribute("loggedIn", true);
                String regionCd = null;
                String chainCd = null;
                Preferences preferences = getBridgeUserPreferences(renderRequest);
                if (preferences != null)
                {
                    chainCd = preferences.getBrand();
                    regionCd = preferences.getRegionCode();
                }
                //Get Active OBSM Production publication
                Publication activeOBSMPublish = getActiveProductionPublication(chainCd);
                long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
                //Get Active Bridge publication
                Publication publish = getActiveBridgePublication(chainCd);
                List<UniqueGroup> groups  = null;
                UniqueGroup selectedGroup = null;
                List<BridgePublishPreview> publishPreviews =  null;
                List<BridgePublishAppModel> previewPojos = null;
                if(activeOBSMPublish == null){
                	renderRequest.setAttribute("activeOBSMPublish", false);
                } else {
                	renderRequest.setAttribute("activeOBSMPublish", true);
                }
                
                if(publish != null && publish.getPublishDate() != null)
                { 
	                HttpServletRequest httpServletRequest = getHttpRequest(renderRequest);
	                String groupName = ParamUtil.getString(renderRequest, "groupName");
	                //Search functionality
	                String selectedGrp = ParamUtil.getString(httpServletRequest, "selectedGrp");
	                if (Validator.isNull(groupName)) {
	                	groupName = ParamUtil.getString(httpServletRequest, "groupName"); 
	                }
	                if (Validator.isNotNull(selectedGrp)) {
	                	groupName = selectedGrp;
	                }
	                if (Validator.isNull(groupName)) {
	                	groupName = BridgeConstants.DEFAULT_GROUP;
	                }
	                if (LOG.isDebugEnabled()) {
	                	LOG.debug("Selected group name :"+groupName);
	                }
	                renderRequest.setAttribute("groupName", groupName);
	                groups = UniqueGroupLocalServiceUtil.getUniqueGroupsByRegionAndPublication
	                		(publish.getPublishId(), regionId);
	                String selById = renderRequest.getParameter("byId");
                    String notFound = selById!=null && !selById.equals("")? selById: "";
                    List<String> notFoundList = new LinkedList<String>( Arrays.asList(notFound.split(StringPool.SPACE)));
                    String selByState = renderRequest.getParameter("byState");
                    //Check if any request pending into Error Message table
        			List<ErrNotification> notifications = ErrNotificationLocalServiceUtil.getMessagesByComponentTypeAndPublication
        					(GemConstants.JOB_TYPE_COUNTRY_GROUP, publish.getPublishId(), regionId);
        			
        			if (Validator.isNotNull(notifications) && notifications.size() > 0) {
        				for (ErrNotification notification : notifications) {
        					if (BridgeConstants.PRE_STAGING_ENVIRONMENT.equals(notification.getTitle())) {
        						renderRequest.setAttribute("message", notification.getDescription());
        						break;
        					}
        				}
        			}
	                if (Validator.isNotNull(groups) && groups.size() > 0) {
	    				//Get selected group
	    				selectedGroup = getSelectedUniqueGroup(groups, groupName);
	    				//Get All standards for selected group. Pass group type to differentiate between SA and SE. 
	    				publishPreviews = BridgePublishPreviewLocalServiceUtil.getBridgePublishPreview(selectedGroup.getGroupName(), 
	    						preferences.getBrand(), regionId, null, selById, selByState, BridgeConstants.DEFAULT_LANG, 
	    						publish.getPublishId(), BridgeConstants.BRIDGE_GROUPS_TYPE);
	    				//sort standards
	    				previewPojos = sortPreviewResults(publishPreviews, notFoundList);
	    				//Country list, get country 
	    				String countryList = UniqueGroupCountryLocalServiceUtil.getCountryListOfUniqueGroup(selectedGroup.getGroupName(), 
	    						publish.getPublishId(), BrandStandardsUtil.getRegionId(preferences.getRegionCode()));
	    				if (Validator.isNotNull(countryList)) {
	    					renderRequest.setAttribute("countryCode", BrandStandardsUtil.getCountryList(countryList, preferences.getRegionCode()));
	    				}
	    				renderRequest.setAttribute("selectedGroupName", selectedGroup.getGroupName());
	    				renderRequest.setAttribute("groupName", selectedGroup.getGroupName());
	    			}
                
					SearchContainer<BridgePublishAppModel> searchContainer = BridgeCommonUtil.getBridgePublishAppSearchContainer(renderRequest, renderResponse);
					searchContainer.setEmptyResultsMessage("No Standards Available");
					if (Validator.isNotNull(previewPojos)) {
						searchContainer.setTotal(previewPojos.size());
						previewPojos = ListUtil.subList(previewPojos, searchContainer.getStart(), searchContainer.getEnd());
						if (LOG.isDebugEnabled()) {
							LOG.debug("Standard list size :"+previewPojos.size());
						}
						searchContainer.setResults(previewPojos);
						renderRequest.setAttribute("previewPojos", previewPojos);
					} else {
						searchContainer.setTotal(0);
					}
					//Select by state
					if(!BrandStandardsUtil.IsNullOrBlank(selByState))
					{
						renderRequest.setAttribute("byState", selByState);
					}
					
					notFound = Arrays.toString(notFoundList.toArray());
                    notFound = notFound.replace("[", StringPool.BLANK).replace("]", StringPool.BLANK);
                    renderRequest.setAttribute("notFound", notFound.trim());
					
                    if(!BrandStandardsUtil.IsNullOrBlank(selByState) && (Validator.isNull(previewPojos) || previewPojos.size() == 0))
	                {
						renderRequest.setAttribute("notFound", selByState);
	                }
                    
					renderRequest.setAttribute("searchContainerObj", searchContainer);
					renderRequest.setAttribute("countryGroups", groups);
					renderRequest.setAttribute("byId", selById);
					renderRequest.setAttribute("activePublish", true);
					renderRequest.setAttribute("hotelCode", chainCd);
					renderRequest.setAttribute("publishId", publish.getPublishId());
					renderRequest.setAttribute("regionId", regionId);
					checkAdminRole (BrandStandardsUtil.BRND_STND_SUPER_ADMIN, renderRequest, themeDisplay);
					//Get Hotel Lifecycle attributes
			        renderRequest.setAttribute("htlLifeCycleFlags", FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(91));
				}
                else
                {
                    renderRequest.setAttribute("activePublish", false);
                }
            }
            else
            {
                renderRequest.setAttribute("loggedIn", false);
            }
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            renderRequest.setAttribute("errorMessage", e.getMessage());
        } catch (Exception e) {
        	renderRequest.setAttribute("errorMessage", e.getMessage());
        }
        super.doView(renderRequest, renderResponse);
    }
    
    @ProcessAction(name = "FilterData")
    public void FilterData(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        String byId = ParamUtil.get(actionRequest, "byId", StringPool.BLANK);
        if(byId != null)
        {
            actionResponse.setRenderParameter("byId", byId);
        }
        String byState = ParamUtil.get(actionRequest, "byState", StringPool.BLANK);
        LOG.info("Process Action"+ byState);
        if(byState != null)
        {
            actionResponse.setRenderParameter("byState", byState);
        }
        
    }

    @ProcessAction(name = "ClearFilter")
    public void ClearFilter(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        if (LOG.isDebugEnabled()) {
        	LOG.debug(" Cleared Filter.");
        }
        actionResponse.setRenderParameter("byId", "");
    }
    
    @ProcessAction(name="changeGroup")
    public void changeGroup (ActionRequest actionRequest, ActionResponse actionResponse) {
    	String currentGroup = ParamUtil.get(actionRequest, "currentGroup", StringPool.BLANK);
    	if (currentGroup != null) {
    		
    		if(LOG.isDebugEnabled()) {
    			LOG.debug("Selected Group :"+currentGroup);
    		}
    		actionResponse.setRenderParameter("groupName", currentGroup);
    	}
    }
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
        Preferences preferences = getBridgeUserPreferences(resourceRequest);
        BridgeApplication bridgeApplication = new BridgeApplicationImpl();
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user =  themeDisplay.getUser();
		String groupName = ParamUtil.getString(resourceRequest, "groupName");
		Publication publication = null;
		String countryList = null;
		if (preferences != null)
        {
			//Get active bridge publication
			publication =  getActiveBridgePublication(preferences.getBrand());
			countryList = UniqueGroupCountryLocalServiceUtil.getCountryListOfUniqueGroup(groupName,
					publication.getPublishId(), BrandStandardsUtil.getRegionId(preferences.getRegionCode()));
        }
		resourceResponse.setContentType("text/html; charset=UTF-8");
		
		if ("exportReport".equalsIgnoreCase(resourceRequest.getResourceID())) 
        {
            if (publication != null)
            {
				if(addRequestToJobQueue(groupName, user, preferences, countryList, publication)) {
					resourceResponse.getWriter().write("An email with a link to your Report will be sent to you once the Report has been generated.");
				}
            }
                
        } 
        else if ("exportAllReport".equalsIgnoreCase(resourceRequest.getResourceID())) 
        {
            if (publication != null)
            {
				long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(preferences.getRegionCode());
				List<UniqueGroup> groups = null;
				try {
					groups = UniqueGroupLocalServiceUtil.getUniqueGroupsByRegionAndPublication
	                		(publication.getPublishId(), regionId);
					for (UniqueGroup group : groups) {
						
						countryList = UniqueGroupCountryLocalServiceUtil.getCountryListOfUniqueGroup(group.getGroupName(),
								publication.getPublishId(), regionId);
						addRequestToJobQueue(group.getGroupName(), user, preferences,	
								countryList , publication);
					}
					resourceResponse.getWriter().write("An email with a link to your Report will be sent to you once the Report has been generated.");
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
				}
            }
                
        }
        else if ("referenceStandards".equalsIgnoreCase(resourceRequest.getResourceID()) && 
        		Validator.isNotNull(resourceRequest.getParameter("stdId")))
        {
            try
            {
                long stdId = Long.parseLong(StringUtil.trim(resourceRequest.getParameter("stdId")));
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("stdId :::" + stdId);
                }
                
                List<Standard> finalList = BridgePublishLocalServiceUtil.
                		getStandardDetails(BridgeQueryUtils.getStandardsById(stdId, preferences.getBrand(), preferences.getRegionCode()));
                //Sort standards
                if (LOG.isDebugEnabled()) {
                	LOG.debug("Refrenced standards :");
                }
                resourceRequest.setAttribute("referenceRecords", StandardsUtil.sortRecords(finalList));
                resourceRequest.setAttribute("brandCode", preferences.getBrand());
                resourceRequest.setAttribute("referenceTitle", "Reference");
                resourceRequest.setAttribute("closeMsg", "Close");
                resourceRequest.setAttribute("newRecord", "New");
                resourceRequest.setAttribute("updatedRecord", "Updated");
                resourceRequest.setAttribute("guidelines", "Guidelines");
                include("/html/updatePreview/stdReference.jsp", resourceRequest, resourceResponse);
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
        //getAssociatedImages
        else if ("viewDetails".equalsIgnoreCase(resourceRequest.getResourceID()))
        {
            try
            {
                long stdId = 0l;
                if (Validator.isNotNull(resourceRequest.getParameter("standardID")) && preferences != null)
                {
                	stdId = Long.parseLong(resourceRequest.getParameter("standardID"));
                    if (LOG.isDebugEnabled()) {
                    	LOG.debug("Country list :"+countryList);
                    	LOG.debug("GroupName :"+groupName);
                    }
                    List<StdImage> images = bridgeApplication.getAssociatedImages(stdId, BridgeConstants.DEFAULT_LANG, 
                    		preferences.getBrand(), countryList);
                    
                    resourceRequest.setAttribute("stdDetails", images);
                    resourceRequest.setAttribute("closeMsg", "close");
                    include("/html/updatePreview/mandatoryImages.jsp", resourceRequest, resourceResponse);
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
        else if ("supportingMaterial".equalsIgnoreCase(resourceRequest.getResourceID()) && Validator.isNotNull(resourceRequest.getParameter("stdId")))
        {
            try
            {
                long stdId = Long.parseLong(resourceRequest.getParameter("stdId"));
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("stdId :::" + stdId);
                }
                Standard standard = bridgeApplication.getAllsupportingMaterial(stdId, BridgeConstants.DEFAULT_LANG, preferences.getBrand(), 
                		countryList);
                resourceRequest.setAttribute("stdDetails", standard);
                resourceRequest.setAttribute("attachmentTypes", com.ihg.brandstandards.bridge.util.BrandStandardsUtil.fileTypes());
                resourceRequest.setAttribute("supportedFormats", BridgeConstants.VIDEO_FORMATS);
                resourceRequest.setAttribute("displayFormat", BridgeConstants.VIDEO_LABEL);
                resourceRequest.setAttribute("brandCode", preferences.getBrand());
                resourceRequest.setAttribute("langCode", BridgeConstants.DEFAULT_LANG);
                setSupportingMaterialLabels(resourceRequest);
                include("/html/updatePreview/supportingMaterial.jsp", resourceRequest, resourceResponse);
            }
            catch (IOException e)
            {
                LOG.error(e);
            }
            catch (PortletException e)
            {
                LOG.error(e);
            }
        } else if ("groupCountryDetails".equalsIgnoreCase(resourceRequest.getResourceID())) {
        	
        	long regionId = Long.parseLong(resourceRequest.getParameter("regionId"));
	        resourceRequest.setAttribute("selectedGrpName", groupName);
        	// Group type is OTEHR 
        	resourceRequest.setAttribute("groupData", UniqueGroupLocalServiceUtil.
        			getGroupAndCountryDetails(publication.getPublishId(), regionId, BridgeConstants.BRIDGE_GROUPS_TYPE));
        	include("/html/updatePreview/groupCountryDetails.jsp", resourceRequest, resourceResponse);
        } else if ("generateUniqueGroups".equalsIgnoreCase(resourceRequest.getResourceID())) {
        	//Generate Bridge groups
        	reGenerateGroups(resourceRequest, resourceResponse, BridgeConstants.BRIDGE_GROUPS_TYPE, 
        			publication.getPublishId(), preferences, themeDisplay.getUser(), null);
        }
       
    }
    
        
   
    
    /**
     * 
     * @param user
     * @param regionCode
     * @param regionId
     * @param brandCode
     * @param environment
     * @return boolean
     */
    public boolean addRequestToJobQueue (String groupName, User user, Preferences preferences, String countryList, Publication publication) {
    	
    	boolean isRequestAdded = false;
    	if (publication != null) {
	    	StringBuilder metadata = new StringBuilder();
	    	long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(preferences.getRegionCode());
	        metadata.append("<metadata>");
	        metadata.append("<type>").append("UPDATE_PREVIEW_PDF").append("</type>");
	        metadata.append("<params>");
	        metadata.append("<param name=\"PUBLISH_ID\">").append(publication.getPublishId()).append("</param>");
	        metadata.append("<param name=\"REGION\">").append(preferences.getRegionCode()).append("</param>");
	        metadata.append("<param name=\"GROUP_NAME\">").append(groupName).append("</param>");
	        metadata.append("<param name=\"PAGE_ORIENTATION\">LANDSCAPE</param>");
	        metadata.append("<param name=\"PAGE_SIZE\">A4</param>");
	        metadata.append("<param name=\"MANUAL_TYPE\">FULL_BUILD_OPERATE</param>");
	        metadata.append("<param name=\"PUBLISH_DATE\">").append(publication.getPublishDate()).append("</param>");
	        metadata.append("<param name=\"EXPIRATION_DATE\"></param>");
	        metadata.append("<param name=\"REGIONID\">").append(regionId).append("</param>");
	        metadata.append("<param name=\"CHAIN_CD\">").append(preferences.getBrand()).append("</param>");
	        metadata.append("<param name=\"ENVIRONMENT\">").append(publication.getPublishEnvName()).append("</param>");
	        metadata.append("<param name=\"COUNTRY_LST\">").append(getCountryList(countryList, preferences.getRegionCode())).append("</param>");
	        metadata.append("<param name=\"COUNTRY_CODE_LIST\">").append(countryList).append("</param>");
	        metadata.append("<param name=\"USER_NAME\">").append(user.getFullName()).append("</param>");
	        metadata.append("</params>");
	        metadata.append("</metadata>");
	        isRequestAdded = SpreadSheetAttributeUpdateLocalServiceUtil.addToJobQueue(user, metadata.toString(), "UPDATE_PREVIEW_PDF");
    	}
        return isRequestAdded;
    }
    
    
}