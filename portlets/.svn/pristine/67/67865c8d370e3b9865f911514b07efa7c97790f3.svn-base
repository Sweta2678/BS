package com.ihg.brandstandards.gem.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.bridge.application.BridgeApplication;
import com.ihg.brandstandards.bridge.application.impl.BridgeApplicationImpl;
import com.ihg.brandstandards.bridge.model.BridgePublishAppModel;
import com.ihg.brandstandards.bridge.portlet.AbstractPreviewPortlet;
import com.ihg.brandstandards.bridge.util.BridgeCommonUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.bridge.util.StandardsUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.custom.model.StdImage;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.model.GEMUniqueGroup;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMUniqueGroupLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * 
 * @author akhanic
 *
 */
public class GEMUpdatePreviewPortlet extends AbstractPreviewPortlet {

	private final Log LOG = LogFactoryUtil.getLog(GEMUpdatePreviewPortlet.class);
	private static final String DEFAULT_LANGUAGE = "en_GB";
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		//HttpServletRequest object
		HttpServletRequest httpServletRequest = getHttpRequest(renderRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
		List<BridgePublishPreview> publishPreviews =  null;
		List<BridgePublishAppModel> previewPojos = null;
		GEMUniqueGroup selectedGroup = null;
		PortletPreferences portletPreferences = renderRequest.getPreferences();
		//Form parameter
		String groupName = ParamUtil.getString(renderRequest, "groupName");
		if (Validator.isNull(groupName)) {
        	groupName = ParamUtil.getString(httpServletRequest, "groupName"); 
        }
		//Search functionality
        String selectedGrp = ParamUtil.getString(httpServletRequest, "selectedGrp");
        
        if (Validator.isNotNull(selectedGrp)) {
        	groupName = selectedGrp;
        }
		long userId = PortalUtil.getUserId(renderRequest);
        
        if (userId > 1)
        {
        	renderRequest.setAttribute("loggedIn", true);
        }
         
		 String selById = renderRequest.getParameter("byId");
         String notFound = selById!=null && !selById.equals("")? selById: "";
         List<String> notFoundList = new LinkedList<String>( Arrays.asList(notFound.split(StringPool.SPACE)));
         String selByState = renderRequest.getParameter("byState");
         
		//Get GEM Preferences
		Preferences preferences = getPreferences(renderRequest, "GEM");
		//Get Current GEM publication
		Publication publication = getActiveGEMPublication(preferences.getDepartmentId(), preferences.getBrand());
		//Get List of groups
		List<GEMUniqueGroup> groups  = null;
		long regionId = 0l;
		String groupType = portletPreferences.getValue("groupType", GemConstants.SA_REPORT_TYPE);
		if (publication != null) {
			try {
				regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(preferences.getRegionCode());
				// Get groups based on group type. Here we have two types of groups, 1. SA and 2. SE.
				groups = GEMUniqueGroupLocalServiceUtil.
					getUniqueGroupsByRegionAndPublicationAndType(publication.getPublishId(), regionId, 
							groupType);
				//Get Hotel Lifecycle attributes
		        renderRequest.setAttribute("htlLifeCycleFlags", FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(91));
			} catch (SystemException e) {
				LOG.error(e.getMessage(), e);
			}
			
			if (Validator.isNotNull(groups) && groups.size() > 0) {
				//Get selected group
				selectedGroup = getGEMSelectedUniqueGroup(groups, groupName);
				//Get All standards for selected group. Pass group type to differentiate between SA and SE. 
				publishPreviews = GEMUniqueGroupLocalServiceUtil.getBridgePublishPreview(selectedGroup.getGroupName(), 
						preferences.getBrand(), regionId, null, selById, selByState, DEFAULT_LANGUAGE, 
						publication.getPublishId(), groupType);
				//sort standards
				previewPojos = sortPreviewResults(publishPreviews, notFoundList);
				//Country list, get country 
				String countryList = GEMUniqueGroupCountryLocalServiceUtil.getCountryListOfUniqueGroup(selectedGroup.getGroupName(), groupType,
						publication.getPublishId(), BrandStandardsUtil.getRegionId(preferences.getRegionCode()));
				if (Validator.isNotNull(countryList)) {
					renderRequest.setAttribute("countryCode", BrandStandardsUtil.getCountryList(countryList, preferences.getRegionCode()));
				}
				renderRequest.setAttribute("selectedGroupName", selectedGroup.getGroupName());
				renderRequest.setAttribute("groupName", selectedGroup.getGroupName());
			}
			//Check if any request pending into Error Message table
			List<ErrNotification> notifications = ErrNotificationLocalServiceUtil.getMessagesByComponentTypeAndPublication
					(GemConstants.JOB_TYPE_COUNTRY_GROUP, publication.getPublishId(), regionId);
			
			if (Validator.isNotNull(notifications) && notifications.size() > 0) {
				for (ErrNotification notification : notifications) {
					if (notification.getTitle().contains(groupType)) {
						renderRequest.setAttribute("message", notification.getTitle());
						break;
					}
				}
			}
			//SearchContainer
			SearchContainer<BridgePublishAppModel> searchContainer = BridgeCommonUtil.getBridgePublishAppSearchContainer(renderRequest, renderResponse);
			if (previewPojos == null) {
				previewPojos = new ArrayList<BridgePublishAppModel>();
			}
			
			searchContainer.setTotal(previewPojos.size());
			searchContainer.setEmptyResultsMessage("No Standards Available");
			notFound = Arrays.toString(notFoundList.toArray());
		    notFound = notFound.replace("[", StringPool.BLANK).replace("]", StringPool.BLANK);
		    renderRequest.setAttribute("notFound", notFound.trim());
		    if(!BrandStandardsUtil.IsNullOrBlank(selByState) && previewPojos.size() < 1) {
				renderRequest.setAttribute("notFound", selByState);
		    }
		    if (LOG.isDebugEnabled()) {
				LOG.debug("SelBySTATE : " + selByState);
			}
			// Set SelByState.
			if(!BrandStandardsUtil.IsNullOrBlank(selByState))
			{
				renderRequest.setAttribute("byState", selByState);
			}
			previewPojos = ListUtil.subList(previewPojos, searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setResults(previewPojos);
			renderRequest.setAttribute("searchContainerObj", searchContainer);
			renderRequest.setAttribute("previewPojos", previewPojos);
			renderRequest.setAttribute("byId", selById);
			renderRequest.setAttribute("activePublish", true);
			renderRequest.setAttribute("hotelCode", preferences.getBrand());
			renderRequest.setAttribute("countryGroups", groups);
			renderRequest.setAttribute("publishId", publication.getPublishId());
			renderRequest.setAttribute("regionId", regionId);
			renderRequest.setAttribute("groupType", groupType);
			//Get Gem Admin User role 
        	checkAdminRole (GemConstants.GEM_ADMIN_ROLE, renderRequest, themeDisplay);
		} else {
			renderRequest.setAttribute("activePublish", false);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
        resourceResponse.setContentType("text/html; charset=UTF-8");
        Preferences preferences = getPreferences(resourceRequest, "GEM");
        BridgeApplication bridgeApplication = new BridgeApplicationImpl();
		String groupName = ParamUtil.getString(resourceRequest, "groupName");
		Publication publication = getActiveGEMPublication(preferences.getDepartmentId(), preferences.getBrand());
		//Preferences
		PortletPreferences portletPreferences = resourceRequest.getPreferences();
		String groupType = portletPreferences.getValue("groupType", GemConstants.SA_REPORT_TYPE);
		String countryList = GEMUniqueGroupCountryLocalServiceUtil.getCountryListOfUniqueGroup(groupName, groupType, 
				publication.getPublishId(), BrandStandardsUtil.getRegionId(preferences.getRegionCode()));
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
		if ("referenceStandards".equalsIgnoreCase(resourceRequest.getResourceID()) && 
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
                include("/html/GEM/updatePreview/stdReference.jsp", resourceRequest, resourceResponse);
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
        else if ("viewDetails".equalsIgnoreCase(resourceRequest.getResourceID()) && Validator.isNotNull(groupName))
        {
            try
            {
                long stdId = 0l;
                if (Validator.isNotNull(resourceRequest.getParameter("standardID")))
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
                }
                include("/html/GEM/updatePreview/mandatoryImages.jsp", resourceRequest, resourceResponse);
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
        else if ("supportingMaterial".equalsIgnoreCase(resourceRequest.getResourceID()) && 
        		Validator.isNotNull(resourceRequest.getParameter("stdId")) && Validator.isNotNull(groupName))
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
                include("/html/GEM/updatePreview/supportingMaterial.jsp", resourceRequest, resourceResponse);
            }
            catch (IOException e)
            {
                LOG.error(e);
            }
            catch (PortletException e)
            {
                LOG.error(e);
            }
        } else if ("setLevelId".equalsIgnoreCase(resourceRequest.getResourceID())) {
        	long regionId = Long.parseLong(resourceRequest.getParameter("regionId"));
        	
        	//Get Gem Admin User role 
        	checkAdminRole (GemConstants.GEM_ADMIN_ROLE, resourceRequest, themeDisplay);
	        // Group type SA or SE or Waiver
	        resourceRequest.setAttribute("groupType", groupType);
        	resourceRequest.setAttribute("groupData", GEMUniqueGroupLocalServiceUtil.
        			getGroupAndCountryDetails(publication.getPublishId(), regionId, groupType));
        	include("/html/GEM/updatePreview/groupLevelId.jsp", resourceRequest, resourceResponse);
        } else if ("generateUniqueGroups".equalsIgnoreCase(resourceRequest.getResourceID())) {
        	//Get manual types from configuration
        	Map<String,String> manualTypes =  GEMQlReportLocalServiceUtil.getReportManualTypes
        			(GemQueryUtils.getReportManualTypes(publication.getPublishId()));
        	//Generate SA / SE / Waiver groups
        	reGenerateGroups(resourceRequest, resourceResponse, groupType, publication.getPublishId(), 
        			preferences, themeDisplay.getUser(), manualTypes);
        }
       
    }
		
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
    public void filterData(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        String byId = ParamUtil.get(actionRequest, "byId", StringPool.BLANK);
        if(byId != null)
        {
            actionResponse.setRenderParameter("byId", byId);
        }
        String byState = ParamUtil.get(actionRequest, "byState", StringPool.BLANK);
        System.out.println("Process Action"+ byState);
        if(byState != null)
        {
            actionResponse.setRenderParameter("byState", byState);
        }
        
    }
    
    /**
     * 
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    public void clearFilter(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        LOG.info("Edit State : Cleared Filter.");
        actionResponse.setRenderParameter("byId", "");
    }
    
    /**
     * 
     * @param actionRequest
     * @param actionResponse
     */
    public void updateLevelId (ActionRequest actionRequest, ActionResponse actionResponse) {
    	//Get All groups for current region and publication
    	Preferences preferences = getPreferences(actionRequest, "GEM");
		Publication publication = getActiveGEMPublication(preferences.getDepartmentId(), preferences.getBrand());
		long regionId = BrandStandardsUtil.getRegionId(preferences.getRegionCode());
		List<GEMUniqueGroup> gemUniqueGroups = new ArrayList<GEMUniqueGroup>();
		try {
			gemUniqueGroups = GEMUniqueGroupLocalServiceUtil.getUniqueGroupsByRegionAndPublication
					(publication.getPublishId(), regionId);
			String levelId = null;
			for (GEMUniqueGroup uniqueGroup : gemUniqueGroups) {
				levelId = ParamUtil.getString(actionRequest, StringPool.BLANK+uniqueGroup.getUniqueGroupId()); 
				if (Validator.isNull(levelId)) {
					uniqueGroup.setLevelId(StringPool.SPACE);
				} else {
					uniqueGroup.setLevelId(levelId);	
				}
				GEMUniqueGroupLocalServiceUtil.updateGEMUniqueGroup(uniqueGroup);
			}
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
		
    }

	
	/**
	 * 
	 * @param groups
	 * @param groupName
	 * @return GEMUniqueGroup
	 */
	private GEMUniqueGroup getGEMSelectedUniqueGroup (List<GEMUniqueGroup> groups, String groupName) {
		GEMUniqueGroup group = null;
		if (Validator.isNotNull(groupName)) {
			for (GEMUniqueGroup grp : groups) {
				if (grp.getGroupName().equals(groupName)) {
					group = grp;
				}
			}
		} else {
			//Default group
			group = groups.get(0);
		}
		return group;
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		renderRequest.setAttribute("groupType", preferences.getValue("groupType", null));
		super.doEdit(renderRequest, renderResponse);
	}
	
	/**
	 * @param actionRequest
	 * @param actionResponse
	 * Save groupType into preferences
	 */
	public void savePreferences (ActionRequest actionRequest, ActionResponse actionResponse) {
		String groupType = ParamUtil.get(actionRequest, "groupType", GemConstants.SA_REPORT_TYPE);
		PortletPreferences preferences = actionRequest.getPreferences();
		try {
			preferences.setValue("groupType", groupType);
			preferences.store();
		} catch (ReadOnlyException e) {
			LOG.error(e.getMessage(), e);
		} catch (ValidatorException e) {
			LOG.error(e.getMessage(), e);
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
		} 
	}
   
}
