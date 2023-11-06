package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.ihg.brandstandards.bridge.model.BridgePublishAppModel;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.MustPublishUtilities;
import com.ihg.brandstandards.custom.model.CountryList;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.UniqueGroup;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.gem.process.Processor;
import com.ihg.brandstandards.gem.process.ProcessorFactory;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * 
 * @author AkhaniC
 * This is a base class for Bridge Update Preview and GEM 
 * Update Preview portlet class
 */
public abstract class AbstractPreviewPortlet extends BrandStandardsBridgePortlet {

	
	private Log LOG = LogFactoryUtil.getLog(AbstractPreviewPortlet.class);
	 /**
     * 
     * @param publishPreviews
     * @param notFoundList
     */
    public List<BridgePublishAppModel> sortPreviewResults (List<BridgePublishPreview> publishPreviews, List<String> notFoundList) {
		
    	List<BridgePublishAppModel> previewPojos = new ArrayList<BridgePublishAppModel>();
    	if(publishPreviews != null && !publishPreviews.isEmpty())
		{
    		BridgePublishAppModel statePojo = null;
			for(BridgePublishPreview preview: publishPreviews)
			{
				if(BridgeConstants.TYPE_STD.equals(preview.getType()))
				{
					notFoundList.remove(preview.getStdId() + "");
					
					statePojo = new BridgePublishAppModel();
					statePojo.setStdId(preview.getStdId());
					statePojo.setTitle(preview.getTitle());
					statePojo.setCurrentTitle(preview.getCurrentTitle());
					statePojo.setTaxonomyText(preview.getTaxonomyTitle());
					statePojo.setTaxonomyPath(preview.getPath().replace(preview.getTaxonomyTitle(), ""));
					statePojo.setStdType(preview.getType());
                    statePojo.setDisplayOrder(preview.getDisplayOrder());
                    statePojo.setIndexOrder(preview.getIndexOrder());
                    statePojo.setParentTaxonomyId(preview.getParentTaxonomyId());
                    statePojo.setTaxonomyId(preview.getTaxonomyId());
                    statePojo.setLevel(preview.getLevel());
                    statePojo.setIndexSortOrder(preview.getLevelSortOrder());
                    statePojo.setStatus(preview.getStatus());
                    statePojo.setHotelLifecycleAttr(preview.getHotelAttributes());
                    statePojo.setComplDateStr(preview.getComplianceDate());
                    if (Validator.isNotNull(preview.getImageCount()) && preview.getImageCount() > 0l) {
                    	statePojo.setImageAttached(true);
                    }
                    if (Validator.isNotNull(preview.getAttachmentCount()) && preview.getAttachmentCount() > 0l) {
                    	statePojo.setAttachmentExists(true);
                    }
                    if (Validator.isNotNull(preview.getStdReference())) {
                    	statePojo.setStdReference(preview.getStdReference());
                    	statePojo.setReferenceExists(true);
                    }
					previewPojos.add(statePojo);
				}
			}
			//Update index order
            MustPublishUtilities.updateIndexOrder(previewPojos);
            //sort standards
            previewPojos = MustPublishUtilities.sortRecords(previewPojos);
            //Specifications and guidelines
            List<BridgePublishAppModel> specPojos = null;
            List<BridgePublishAppModel> gdlnPojos = null;
            BridgePublishAppModel childPojo = null;
			for(BridgePublishAppModel stdPojo : previewPojos)
			{
				specPojos = new ArrayList<BridgePublishAppModel>();
				gdlnPojos = new ArrayList<BridgePublishAppModel>();
				for(BridgePublishPreview preview: publishPreviews)
				{
					if(stdPojo.getStdId() == preview.getParentStdId() && !BridgeConstants.TYPE_STD.equals(preview.getType()))
					{
						childPojo = new BridgePublishAppModel();
						notFoundList.remove(preview.getStdId() + "");
						childPojo.setStdId(preview.getStdId());
						childPojo.setTitle(preview.getTitle());
						childPojo.setCurrentTitle(preview.getCurrentTitle());
						childPojo.setTaxonomyText(preview.getTaxonomyTitle());
						childPojo.setTaxonomyPath(preview.getPath().replace(preview.getTaxonomyTitle(), ""));
						childPojo.setStdType(preview.getType());
						childPojo.setStatus(preview.getStatus());
						childPojo.setHotelLifecycleAttr(preview.getHotelAttributes());
						childPojo.setComplDateStr(preview.getComplianceDate());
						childPojo.setDisplayOrder(preview.getDisplayOrder());
						if (Validator.isNotNull(preview.getImageCount()) && preview.getImageCount() > 0l) {
							childPojo.setImageAttached(true);
                        }
						if (Validator.isNotNull(preview.getAttachmentCount()) && preview.getAttachmentCount() > 0l) {
							childPojo.setAttachmentExists(true);
                        }
						if (Validator.isNotNull(preview.getStdReference())) {
							childPojo.setStdReference(preview.getStdReference());
							childPojo.setReferenceExists(true);
                        }
						if(BridgeConstants.TYPE_SPEC.equals(preview.getType()))
						{
							specPojos.add(childPojo);
						}
						else
						{
							gdlnPojos.add(childPojo);
						}
					}
				}
				Collections.sort(specPojos, new SpecsGuidelinesSortBySTDId());
                Collections.sort(gdlnPojos, new SpecsGuidelinesSortBySTDId());
				stdPojo.setSpecifications(specPojos);
				stdPojo.setGuidelines(gdlnPojos);
			}
		}
    	return previewPojos;
    }
    
    /**
     * 
     * @param ctry
     * @param region
     * @return
     */
    public String getCountryList (String ctry, String region) {
    	StringBuffer countryStr = null;
    	Map<String,String> countryName = BrandStandardsUtil.getCountries().get(region);
    	for (String value :ctry.split(StringPool.SEMICOLON)) {
    		if (countryStr == null) {
    			countryStr = new StringBuffer();
    			countryStr.append(countryName.get(value));
    		} else {
    			countryStr.append(StringPool.COMMA);
    			countryStr.append(countryName.get(value));
    		}
    	}
    	return countryStr.toString();
    }
    
    /**
	 * 
	 * @param groups
	 * @param groupName
	 * @return UniqueGroup
	 */
	public UniqueGroup getSelectedUniqueGroup (List<UniqueGroup> groups, String groupName) {
		UniqueGroup group = null;
		if (Validator.isNotNull(groupName)) {
			for (UniqueGroup grp : groups) {
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
	
	/**
     * 
     * @param request
     */
    protected void setSupportingMaterialLabels(PortletRequest request)
    {
    	request.setAttribute("supportingMaterial", GemConstants.SUPPORTING_MATERIAL);
        request.setAttribute("downloadMsg", GemConstants.DOWNLOAD_DOCUMENT);
        request.setAttribute("closeMsg", GemConstants.CLOSE_MODAL_WINDOW);
        request.setAttribute("help", GemConstants.HELP_BUTTON);
        request.setAttribute("helpMsg", GemConstants.HELP_MESSAGE);
        request.setAttribute("links", GemConstants.LINK_SECTION);
        request.setAttribute("newRecord", GemConstants.NEW_STATUS);
        request.setAttribute("updatedRecord", GemConstants.UPDATE_STATUS);
    }
    
    /**
	 * @param resourceRequest
	 * @param resourceResponse
	 * @param groupType
	 * @param publishId
	 * @param userPreferences
	 * @param user
	 * Regenerate SA / SE / BRIDGE unique groups. We will create a job queue request to re-generate unique groups for 
	 * SA / SE / BRIDGE.
	 */
	protected void reGenerateGroups (ResourceRequest resourceRequest, ResourceResponse resourceResponse, 
			 String groupType, long publishId, Preferences userPreferences, User user, Map<String,String> manualTypes) {
		
		Processor processor = null;
		String countryGroupType = groupType;
		String manualType = null;
        if (manualTypes != null) {
        	manualType = manualTypes.get(groupType);
        }
		if (BridgeConstants.BRIDGE_GROUPS_TYPE.equals(groupType)) {
        	processor = ProcessorFactory.getProcessorObject("SA");
        	countryGroupType = BridgeConstants.PRE_STAGING_ENVIRONMENT;
        } else {
        	processor = ProcessorFactory.getProcessorObject(groupType);
        }
		//Pass manual type
        String compareMetadata = processor.generateMetadata(userPreferences.getBrand(), userPreferences.getRegionCode(), 
        		BrandStandardsUtil.getRegionId(userPreferences.getRegionCode()), publishId, groupType, manualType, StringPool.PERCENT);
        //If job queue request is in queue then do not create new request
        try {
	        if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetadata, StringPool.PERCENT, 
	        		BridgeConstants.JOB_TYPE_COUNTRY_GROUP, BridgeConstants.QUEUE_NEW_STATUS)) {
	        	processor.addMessageInQueue(BridgeConstants.JOB_TYPE_COUNTRY_GROUP, publishId, groupType, manualType, userPreferences, user);
				resourceResponse.getWriter().write("Request to re-generate unique groups for "+countryGroupType+" is submitted");
	        } else {
	        	resourceResponse.getWriter().write("Request to re-generate unique groups for "+countryGroupType+" already exists");
	        }
        } catch (IOException e) {
			LOG.error(e.getMessage(), e);
		}
	}
    
    /**
     * @param role 
     * @param portletRequest
     * @param themeDisplay
     */
    protected void checkAdminRole (String role, PortletRequest portletRequest, ThemeDisplay themeDisplay) {
    	//Get User role 
        long adminRole = com.ihg.brandstandards.bridge.util.BrandStandardsUtil.getRoleId(themeDisplay.getCompanyId(), role); 
        if (LOG.isDebugEnabled()) {
       	 LOG.debug("Admin role id is :"+adminRole);
        }
        try {
	         //Check for user role
			 if (UserLocalServiceUtil.hasRoleUser(adminRole, themeDisplay.getUserId())) {
				 portletRequest.setAttribute("adminUser", true);
			 } else{
				 portletRequest.setAttribute("adminUser", false);
			 }
        } catch (SystemException e) {
       	 LOG.error(e.getMessage(), e);
        }
       if (LOG.isDebugEnabled()) {
       	LOG.debug("User has admin access :"+portletRequest.getAttribute("adminUser"));
       }
    }
    
    /**
     * @author Ketan.savaliya
     */
    class SpecsGuidelinesSortBySTDId implements Comparator<BridgePublishAppModel>
    {
        /**
         * @param o1 - Standards objects.
         * @param o2 - Standards objects.
         * @return integer.
         */
        public int compare(BridgePublishAppModel o1, BridgePublishAppModel o2)
        {
            int res = 0;
            if (o1.getDisplayOrder() > 0L || o2.getDisplayOrder() > 0L)
            {
                res = compareLong(o1.getDisplayOrder(), o2.getDisplayOrder());
            }
            else
            {
            	res = compareLong(o1.getStdId(), o2.getStdId());
            }

            return res;
        }
        
        /**
         * Compare long values.
         *
         * @param v1
         *            - value 1
         * @param v2
         *            - value 2
         * @return 1, 0, -1
         */
        private int compareLong(long v1, long v2)
        {
            if (v1 > v2)
            {
                return 1;
            }
            else if (v1 < v2)
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }
    
    /**
     * @author Ketan.savaliya
     */
    class CountryListSortByCountry implements Comparator<CountryList>
    {
        /**
         * @param o1 - Standards objects.
         * @param o2 - Standards objects.
         * @return integer.
         */
        public int compare(CountryList o1, CountryList o2)
        {
            int res = 0;
            res = o1.getCountryList().compareTo(o2.getCountryList());

            return res;
        }
    }
}
