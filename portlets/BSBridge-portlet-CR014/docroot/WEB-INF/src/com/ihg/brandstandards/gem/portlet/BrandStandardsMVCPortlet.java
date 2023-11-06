package com.ihg.brandstandards.gem.portlet;

import java.util.Map;

import com.ihg.brandstandards.bridge.util.BrandStandardsUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.ihg.brandstandards.gem.process.Processor;
import com.ihg.brandstandards.gem.process.ProcessorFactory;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BrandStandardsMVCPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(BrandStandardsMVCPortlet.class);
	
	/**
	 * 
	 * @param request
	 * @param envorinment
	 * @return Preferences
	 */
	public Preferences getPreferences (PortletRequest request, String environment) {
		
		Preferences preferences = null;
        try
        {
            HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(request);
            HttpSession session = httpRequest.getSession();
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            String regionCode = StringPool.BLANK;
            String chainCode = StringPool.BLANK;
            String sessionVariable = "Preferences";
            String sessionChainCode = "userBranch";
            if ("GEM".equals(environment)) {
            	sessionVariable = "gemPreferences";
            	sessionChainCode = "gemUserBranch";
            }
            
            if (session.getAttribute(sessionVariable) != null)
            {
                preferences = (Preferences)session.getAttribute(sessionVariable);
            }
            else
            {
                UserPreference userPreference = null;
                try
                {
                    userPreference = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(themeDisplay.getUserId(), environment);
                    regionCode = BrandStandardsUtil.getGemUserRegionFromUserRole(themeDisplay.getUser().getRoles());
                }
                catch (Exception e)
                {
                    LOG.error(StackTraceUtil.getStackTrace(e));
                }
                if (userPreference != null)
                {
                    preferences = new Preferences();
                    preferences.setBrand(userPreference.getChainCode());
                    if (userPreference.getCountryCode() != null && !userPreference.getCountryCode().isEmpty())
                    {
                        regionCode = BrandStandardsUtil.decodeRegionCode(userPreference.getCountryCode());
                    }
                    preferences.setRegion(userPreference.getCountryCode());
                    preferences.setRegionCode(regionCode);
                    preferences.setRegion(BrandStandardsUtil.decodeReverseRegionCode(regionCode));
                    preferences.setRegionName(BrandStandardsUtil.decodeRegionName(regionCode));
                    preferences.setDiscontinuedFilter(userPreference.getBuildType());
                    preferences.setItemsPerPage(BrandStandardsUtil.IsNullOrBlank(userPreference.getItemsPerPage()) ? 
                            BrandStandardsUtil.DEFAULT_ITEMS_PER_PAGE : Integer.valueOf(userPreference.getItemsPerPage()));
                    preferences.setUserId(themeDisplay.getUserId());
                    chainCode = userPreference.getChainCode();
                    preferences.setDepartmentId(GetterUtil.getLong(userPreference.getInfoDisplay()));
                }
            }
            session.setAttribute(sessionVariable, preferences);
            session.setAttribute(sessionChainCode, chainCode);
		
	} 
    catch (NumberFormatException e)
    {
        LOG.error("Failed to get GEM User Preferences", e);
    }

    return preferences;
	}
	
	/**
     * Get Active Bridge Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active Bridge Publish
     */
    protected Publication getBridgePublishForGem(long departmentId, String brandCode)
    {
    	Publication gemPublish = getActiveGEMPublication(departmentId, brandCode);
        //Get bridge publish by using parent id of GEM Publication. 
    	Publication bridgePublish = null;
        if(gemPublish != null) {
    		try {
				bridgePublish = PublicationLocalServiceUtil.getPublication(gemPublish.getParentPublishId());
			} catch (Exception e) {
				LOG.error("No Bridge Publish Exist with Publish Id:" + gemPublish.getParentPublishId());
			}
        }
        return bridgePublish;
    }
    
    /**
     * Get Active GEM Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active GEM Publish
     */
    protected Publication getActiveGEMPublication(long departmentId, String brandCode)
    {
    	Publication publication = null;
    	try {
			publication = PublishDeptLocalServiceUtil.getAcitveDepartmentPublication(departmentId, brandCode);
		} catch (Exception e) {
            LOG.error("No Active GEM Publish Exist for brand:" + brandCode);
        }
    	return publication;
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
