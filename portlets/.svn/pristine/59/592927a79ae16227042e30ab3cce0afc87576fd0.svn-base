package com.ihg.brandstandards.gem.message.listener;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.gem.model.QualityLeadModel;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchPublishDeptException;
import com.ihg.brandstandards.db.model.GEMQlReport;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishDept;
import com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.gem.process.Processor;
import com.ihg.brandstandards.gem.process.ProcessorFactory;
import com.ihg.brandstandards.gem.score.AbstractScoreCalculator;
import com.ihg.brandstandards.gem.score.GEMScore;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * 
 * @author DilipChauhan
 *
 */
public class GEMCopyToBrandMessageListener implements MessageListener 
{
    private static Log LOG = LogFactoryUtil.getLog(GEMCopyToBrandMessageListener.class);

    public void receive(Message message)
    {
        try {
            //Check message type first.
            String requestType = GetterUtil.getString(message.get("requestType"));
            if (Validator.isNotNull(requestType) && GemConstants.JOB_TYPE_GEM_COPY_TO_BRAND.equals(requestType))
            {
                gemCopyToBrandRequest(message);
            }
            LOG.debug("inside message listner...");
        } catch (Exception e) {
            LOG.error("Unable to process message " + message, e);
        }
    }
    
    /**
     * 
     * @param message
     */
    private void gemCopyToBrandRequest(Message message)
    {
        // Get preferences, user object and publication id from message
        LOG.debug("------- Get attributes -----");
        
        long baseQLReportId = message.getLong("baseQLReportId");
        Preferences preferences = (Preferences) message.get("preferences");
       
        
        User user = (User) message.get("user");
        long regionId = BrandStandardsUtil.getRegionId(preferences.getRegionCode());         
        String userScreenName = message.getString("userScreenName");
        String copyToBrand = message.getString("copyToBrand");
        boolean isGEMGlobalUser = message.getBoolean("isGEMGlobalUser");
      
        try {
        		//List<GEMQlReport> baseReportList = new ArrayList<GEMQlReport>();
        		GEMQlReport baseReport = GEMQlReportLocalServiceUtil.getGEMQlReport(baseQLReportId);
        		
        		GEMQlReport qlReport;
        		if(Validator.isNotNull(baseReport) && Validator.isNotNull(copyToBrand)){
        			for(String qlReportString : copyToBrand.split(StringPool.COMMA)){
        				String[] reportValues = qlReportString.split(StringPool.DASH);
        				long qlReportId = Long.valueOf(reportValues[0]);
        				qlReport =  GEMQlReportLocalServiceUtil.getGEMQlReport(qlReportId);
        				boolean targetHaveCategory = Boolean.FALSE;
        				
        				 long seTemplateId = getTemplateId(qlReport.getPublishId(), regionId, GemConstants.TEMPLATE_TYPE_SE);
        			     long saTemplateId = getTemplateId(qlReport.getPublishId(), regionId, GemConstants.TEMPLATE_TYPE_SA);
        			     Map<Long, String> categoryHeadings = new LinkedHashMap<Long, String>();
        			     try {
        			        	categoryHeadings = GEMCategoryLocalServiceUtil.getQLFormSAAndSECategories(seTemplateId+StringPool.COMMA+saTemplateId);
        			        	   targetHaveCategory = categoryHeadings.containsKey(baseReport.getCategoryId());
        			        	   LOG.debug("===========Target report have Category :"+targetHaveCategory);
        			        } catch (Exception e) {
        			            LOG.error("Failed to fetch Category Heading Categories", e);
        			        }
        			     
        			    // targetBrand  isFromCopyToBrand
        			    //preferences.setBrand(reportValues[1]);//PublicationLocalServiceUtil.getPublication(qlReport.getPublishId()).getChainCode());
      	        		Preferences targetedPreferences = new Preferences();
      	        		targetedPreferences.setBrand(reportValues[1]);
      	        		targetedPreferences.setRegionCode(preferences.getRegionCode());
      	        		targetedPreferences.setDepartmentId(preferences.getDepartmentId());
      	        		targetedPreferences.setRegionName(preferences.getRegionName());
      	        		targetedPreferences.setRegion(preferences.getRegion());
      	        		targetedPreferences.setUserId(preferences.getUserId());
      	        		
      	        		
      	        		if(Validator.isNotNull(qlReport) && qlReport!=baseReport && targetHaveCategory){
      	        			LOG.debug("===========> fETCHING RECORD WITH Target id "+baseQLReportId);
        					
        					
        					List<QualityLeadModel> list = new ArrayList<QualityLeadModel>();
        					QualityLeadModel objModel = new QualityLeadModel();
        					objModel.setCategoryId(baseReport.getCategoryId());
        					objModel.setSeverityId(baseReport.getSeverityId( ));
        					objModel.setBucketId(baseReport.getBucketId());
        					
        					objModel.setSeSquence(String.valueOf(Long.valueOf(qlReport.getDisplayOrderNumber())));
        					objModel.setId(qlReport.getQlReportId());
        					objModel.setGlobalMust(qlReport.getGlblMustMeasure());
        					objModel.setGlobalOrRegional(StandardsLocalServiceUtil.getStandards(qlReport.getStdId()).getRegionCode());
        					objModel.setStdId(qlReport.getStdId()); 
        					objModel.setTriggerId(qlReport.getTriggerId());
        					objModel.setComplDueId(qlReport.getComplianceDueDays());
        					list.add(objModel);
        					
        					LOG.debug("baseQLReportId : "+ baseQLReportId +"____regionId : "+regionId+"____userScreenName :"+userScreenName+"_____copyToBrand :"+copyToBrand+"____BrandCode:"+targetedPreferences.getBrand()+"_____RegionCode:"+targetedPreferences.getRegionCode());
        					LOG.info("List : "+list+"____________publishDept.getPublishDeptId()"+qlReport.getPublishDeptId()+"____________________publish.getParentPublishId()"+0+"_______publishId"+qlReport.getPublishId()+"______isGEMGlobalUser"+isGEMGlobalUser);
        					boolean success = GEMQlReportLocalServiceUtil.saveGEMQlReport(list, qlReport.getPublishDeptId(), 
        							   0,qlReport.getPublishId(), regionId, userScreenName, isGEMGlobalUser, true);
        					
        					if (success)
        		            {
        		               // status = "SUCCESS";
        		                //Get manual type of SE, SA and Waiver
        		                String seMnlTypeConfig = null;
        		               
        		                LOG.info("=========================PublishId====:"+qlReport.getPublishId());
        		                Map<String,String> manualTypes =  GEMQlReportLocalServiceUtil.getReportManualTypes(GemQueryUtils.getReportManualTypes(qlReport.getPublishId()));
        		                if(Validator.isNotNull(manualTypes) && Validator.isNotNull(manualTypes.get(GemConstants.SE_REPORT_TYPE))) {
        		            		seMnlTypeConfig = manualTypes.get(GemConstants.SE_REPORT_TYPE);
        		            	} else {
        		            		LOG.error("No SE Manual Config PARM found for the publication:"+qlReport.getPublishId()+". Defaulting to Operate");
        		            		seMnlTypeConfig = GemConstants.MANUAL_TYPE_OPERATE;
        		            	}
        		                //Create gem unique groups
        		    	        Processor processor = ProcessorFactory.getProcessorObject(BridgeConstants.SE_REPORT_TYPE);
        		    	        String compareMetadata = processor.generateMetadata(targetedPreferences.getBrand(), targetedPreferences.getRegionCode(), 
        		    	        		regionId, qlReport.getPublishId(), BridgeConstants.SE_REPORT_TYPE, seMnlTypeConfig,
        		    	        		StringPool.PERCENT);
        		    	        //If job que request is in queue then do not create new request
        		    	        if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetadata, 
        		    	        		StringPool.PERCENT, BridgeConstants.JOB_TYPE_COUNTRY_GROUP, BridgeConstants.QUEUE_NEW_STATUS)) {
        		    	        	processor.addMessageInQueue(BridgeConstants.JOB_TYPE_COUNTRY_GROUP, qlReport.getPublishId(), 
        		    	        			BridgeConstants.SE_REPORT_TYPE, seMnlTypeConfig, targetedPreferences, user);
        		    	        }
        		            }
        					
        					calculateScore(qlReport.getPublishId(), regionId, user.getScreenName(), targetedPreferences);
        					
        				}
        			}      				
        			
        		}
        	
			} catch (PortalException e) {
				LOG.error("Failed to Copy to Brand  message execution for QLREport :" + baseQLReportId + " Errors :" + e.getMessage());
			} catch (SystemException e) {
				LOG.error("Failed to Copy to Brand  message execution for QLREport :" + baseQLReportId + " Errors :" + e.getMessage());
			}        	
		
   }
    private long getTemplateId(long publishId, long regionId, String templType)
    {
        long templateId = 0;
        try
        {
            List<GEMTemplate> list = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnIdAndType(publishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
            if(list != null && !list.isEmpty())
            {
                templateId = list.get(0).getTemplateId();
            }
        }
        catch (SystemException e)
        {
            LOG.error("Failed to get " + templType + " temlates:" + e);
        }
        return templateId;
    }

    
    private void calculateScore(long publishId,long regionId,String screenName, Preferences userPreferences)
    {
        String brandCode = userPreferences.getBrand();
        Publication publish = getActiveGEMPublication(userPreferences.getDepartmentId(), brandCode);
        PublishDept publishDept = null;
		try {
			publishDept = PublishDeptLocalServiceUtil.getActivePublicationByDept(publishId, 
					userPreferences.getDepartmentId());
		} catch (NoSuchPublishDeptException e) {
			LOG.error(e.getMessage(), e);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
        
        long seTemplateId = getTemplateId(publishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
        GEMQlReportLocalServiceUtil.populateScoringCounts(publishDept.getPublishDeptId(), publish.getParentPublishId(), publishId, seTemplateId, regionId, screenName);
        
        AbstractScoreCalculator calc = new GEMScore();
        calc.calculate(publishId, regionId, brandCode);

    }
    private Publication getActiveGEMPublication(long departmentId, String brandCode)
    {
    	Publication publication = null;
    	try {
			publication = PublishDeptLocalServiceUtil.getAcitveDepartmentPublication(departmentId, brandCode);
		} catch (Exception e) {
            LOG.error("No Active GEM Publish Exist for brand:" + brandCode);
        }
    	return publication;
    }
}