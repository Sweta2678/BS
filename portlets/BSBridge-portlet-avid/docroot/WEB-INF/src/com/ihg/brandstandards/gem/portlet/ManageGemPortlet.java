package com.ihg.brandstandards.gem.portlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.bridge.util.BrandStandardsUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchPublishDeptException;
import com.ihg.brandstandards.db.model.BridgePublishLang;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishDept;
import com.ihg.brandstandards.db.model.PublishParm;
import com.ihg.brandstandards.db.service.BridgePublishLangLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishParmLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.gem.process.Processor;
import com.ihg.brandstandards.gem.process.ProcessorFactory;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BSCommonUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

/**
 * Portlet implementation class ManageGemPortlet
 */
public class ManageGemPortlet extends BrandStandardsGemPortlet
{
	private static final Log LOG = LogFactoryUtil.getLog(ManageGemPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String brandCode = null;
        String regionCode = null;
        String gemPublicationLocaleList = null;
        Preferences preferences = getGEMUserPreferences(renderRequest);
        if (preferences != null) {
            brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
        }
        Publication gemPublish = getActiveGEMPublication(preferences.getDepartmentId(), brandCode);
        if(gemPublish != null){
        	renderRequest.setAttribute("activeGemPublish", true);
        } else {
        	renderRequest.setAttribute("activeGemPublish", false);
        }
        
        Publication publish = getBridgePublishForGem(preferences.getDepartmentId(), brandCode);
        timeBeforePublication(renderRequest, publish);
        //GEM Templates should rely on GEM Publish Id and not Bridge Publish Id
		if(gemPublish != null) {
			List<GEMTemplate> gemTemplates = new ArrayList<GEMTemplate>();
			List<GEMTemplate> gemSATemplates = new ArrayList<GEMTemplate>();
			List<GEMTemplate> gemSETemplates = new ArrayList<GEMTemplate>();
			List<GEMTemplate> gemWaiverTemplates = new ArrayList<GEMTemplate>();
			Map<String, PublishParm> manualTypes = new LinkedHashMap<String, PublishParm>();
			boolean isGlobalMustNotSelectedForMeasurement = false;
			
			try {
				if(Validator.isNotNull(regionCode) && !"GLBL".equals(regionCode)){
		            long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
					gemTemplates = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnId(gemPublish.getPublishId(), regionId);
					gemSATemplates = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnIdAndType(gemPublish.getPublishId(), regionId, GemConstants.TEMPLATE_TYPE_SA);
					gemSETemplates = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnIdAndType(gemPublish.getPublishId(), regionId, GemConstants.TEMPLATE_TYPE_SE);
					gemWaiverTemplates = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnIdAndType(gemPublish.getPublishId(), regionId, GemConstants.TEMPLATE_TYPE_WAIVER);
                    isGlobalMustNotSelectedForMeasurement = GEMQlReportLocalServiceUtil.isGlobalMustNotSelectedForMeasurement(gemPublish.getPublishId(), regionId);
                    //Get Active publication's manual types
                	manualTypes = PublishParmLocalServiceUtil.getPublishParmsByPublishId(gemPublish.getPublishId());
                    LOG.debug("Is Global Must Not Selected for Measurement: " + isGlobalMustNotSelectedForMeasurement);
                  //Get Active Languages patelhiren_CR19
                    setActiveLanguages(renderRequest, gemPublish);
				}
				
			} catch(Exception e){
				LOG.error("Failed to fetch templates ", e);
			}
			
            renderRequest.setAttribute("isGlobalMustNotSelectedForMeasurement", isGlobalMustNotSelectedForMeasurement);
			renderRequest.setAttribute("gemTemplates", gemTemplates);
			renderRequest.setAttribute("gemSATemplates", gemSATemplates);
			renderRequest.setAttribute("gemSETemplates", gemSETemplates);
			renderRequest.setAttribute("gemWaiverTemplates", gemWaiverTemplates);
			renderRequest.setAttribute("manualTypes", manualTypes);
			renderRequest.setAttribute("gemPublishId", gemPublish.getPublishId());
			renderRequest.setAttribute("bridgePublishId", gemPublish.getParentPublishId());
			renderRequest.setAttribute("gemDeptId", preferences.getDepartmentId());
			
			//renderRequest.setAttribute("gemPublicationLocaleList", gemPublicationLocaleList);
		}
		renderRequest.setAttribute("gemWaiverTemplateLabel", GemConstants.WAIVER_TEMPLATE_LABEL);
		
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * @param ResourceRequest resourceRequest
	 * @param ResourceResponse resourceResponse
	 */
    @Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
    	
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
    	String brandCode = null;
        String regionCode = null;
        Preferences preferences = getGEMUserPreferences(resourceRequest);
        Map<String, Object> subBrandDetails = GemConstants.SUB_BRAND_DETAILS;
        if (preferences != null) {
            brandCode = preferences.getBrand();
            regionCode = preferences.getRegionCode();
        }
        if (LOG.isDebugEnabled()) {
        	LOG.debug("SubBrand Map :"+subBrandDetails);
        	LOG.debug("brandCode :"+brandCode);
        }
        String requestType = ParamUtil.getString(resourceRequest, "requestType");
        if ("createPublication".equals(requestType))
        {
        	String returnMsg = processGemPublication(resourceRequest, brandCode);
    		resourceResponse.getWriter().write(returnMsg);
        }
        else if("updateManualType".equals(requestType) || "openCreatePublication".equals(requestType)){
        	long gemPublishId = ParamUtil.getLong(resourceRequest, "gemPublishId");
        	String bridgePublishId = ParamUtil.getString(resourceRequest, "bridgePublishId");
        	String cmd = ParamUtil.getString(resourceRequest, "cmd");
        	try {
        		List<Publication> bridgePublishList = PublicationLocalServiceUtil.
                		getPublicationByQuery(BridgeQueryUtils.getBridgePublications(brandCode, BridgeConstants.PRE_STAGING_ENVIRONMENT));
        		resourceRequest.setAttribute("bridgePublishList", bridgePublishList);
        		if(BridgeConstants.CMD_UPDATE.equalsIgnoreCase(cmd)){
        			Map<String, PublishParm> manualTypes = PublishParmLocalServiceUtil.getPublishParmsByPublishId(gemPublishId);
    				if(Validator.isNotNull(manualTypes) && manualTypes.size() > 0){
    					resourceRequest.setAttribute("gemSAManualType", manualTypes.get(BridgeConstants.SA_REPORT_TYPE).getParmValue().toLowerCase());
    					resourceRequest.setAttribute("gemSEManualType", manualTypes.get(BridgeConstants.SE_REPORT_TYPE).getParmValue().toLowerCase());
    					resourceRequest.setAttribute("gemWaiverManualType", manualTypes.get(BridgeConstants.WR_REPORT_TYPE).getParmValue().toLowerCase());
    				}
    				resourceRequest.setAttribute("bridgePublishId", bridgePublishId);
    				resourceRequest.setAttribute("cmd", cmd);
        		}
        		Map<String, String> chainCodeMap = BrandStandardsUtil.chainCodeMap();
            	if(chainCodeMap != null && Validator.isNotNull(chainCodeMap.get(brandCode))){
            		resourceRequest.setAttribute("currentBrand", chainCodeMap.get(brandCode));
            	}
				
			} catch (SystemException e) {
				LOG.error("Failed to fetch manual types"+e);
			}
        	include("/html/GEM/manage/createPublication.jsp", resourceRequest, resourceResponse);
        }
        long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        //Store GEM publish id into gem template table. 
        Publication publish = getActiveGEMPublication(preferences.getDepartmentId(), brandCode);
		if(publish != null) 
		{
	        if ("uploadTemplate".equals(requestType))
	        {
	    		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
	    		String templateType = ParamUtil.getString(uploadRequest, "template_type");
	    		if (Validator.isNotNull(templateType)) 
	    		{
	    			uploadTemplateRequest(uploadRequest, resourceRequest, resourceResponse);
	    		}
	        } 
	    	else if ("generateGEMReport".equals(requestType))
	        {
	    		String returnMsg = "Success";
	    		String reportType = resourceRequest.getParameter("reportType");
		        String templateId = ParamUtil.getString(resourceRequest, "templateId");
		        String reportTitle = ParamUtil.getString(resourceRequest, "reportTitle");
		        String reportLanguages = ParamUtil.getString(resourceRequest, "reportLanguages");
		        String subBrands = null;
		        if (subBrandDetails != null) {
		        	if( subBrandDetails.containsKey(brandCode)) {
			        	subBrands = (String)subBrandDetails.get(brandCode);
			        }
		        	if (LOG.isDebugEnabled()) {
			        	for (Map.Entry<String, Object> entry : subBrandDetails.entrySet()) {
			        		LOG.debug("Brand Name :"+entry.getKey());
			        		LOG.debug("SubBrand name :"+(String)entry.getValue());
			        	}
		        		LOG.debug("Sub brand :::"+subBrands);
			        }
		        }  
		        
		      //Get manual types from configuration
	        	Map<String,String> manualTypes =  GEMQlReportLocalServiceUtil.getReportManualTypes
	        			(GemQueryUtils.getReportManualTypes(publish.getPublishId()));
	        	
	    		Map<String, String> metadataParams = new LinkedHashMap<String, String>();
	            Map<String, String> compareMetadataParams = new LinkedHashMap<String, String>();
	            addMetadataFields(publish, GemConstants.GEM_ENVIRONMENT, themeDisplay.getUser().getFirstName(), templateId, reportType, reportTitle, 
	            		regionCode, subBrands, metadataParams, compareMetadataParams, manualTypes, reportLanguages);
	    		String metaData = BSCommonUtil.buildJobQueueMetadataXML(BridgeConstants.JOB_TYPE_GEM_REPORT, metadataParams, null, null);
	            String compareMetaData = BSCommonUtil.buildJobQueueMetadataXML(BridgeConstants.JOB_TYPE_GEM_REPORT, compareMetadataParams, null, null);
	            String groupCompareMetaData = addUniqueGroupMetadataFields(brandCode, regionCode, regionId, publish.getPublishId(), reportType, manualTypes.get(reportType));
	            
	            if (JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(groupCompareMetaData, StringPool.PERCENT, BridgeConstants.JOB_TYPE_COUNTRY_GROUP, "NEW,IN_PROGRESS"))
	            {
	            	returnMsg = "Groups_Inprogress";
	            }  
	            else if (JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetaData, themeDisplay.getUser().getScreenName(), BridgeConstants.JOB_TYPE_GEM_REPORT))
	            {
	            	returnMsg = "Exist";
	            }
	            else
	            {	
	    			try 
	    			{
		    			JobQueueLocalServiceUtil.insertJobQueueUsingOraSequence(themeDisplay.getUser().getScreenName(), BridgeConstants.JOB_TYPE_GEM_REPORT, metaData, 
		    					null, themeDisplay.getUser().getEmailAddress(), themeDisplay.getUser().getScreenName());
	    			} 
	    			catch(Exception e)
	    			{
	    				returnMsg = "Failure";
	    				LOG.error("Failed to insert JOB Queue Entry"+e.getMessage());
	    			}
	            }
	            
	    		
	    		resourceResponse.getWriter().write(returnMsg);
	        }else if ("LanguageRefreshURL".equals(requestType))  //CR19 by patelHiren
	         {
	            String updateLanguage = resourceRequest.getParameter("updateLanguage");
	            setActiveLanguages(resourceRequest, publish);
	            
	               if(Validator.isNotNull(updateLanguage)){
	                if(updatePublicationLanguage(resourceRequest, themeDisplay, publish))
	                {
	                 setActiveLanguages(resourceRequest, publish);
	                }
	               }
	                  include("/html/GEM/manage/language.jsp", resourceRequest, resourceResponse);
	              }
		}
	}

    /**
     * 
     * @param resourceRequest
     * @throws FileNotFoundException 
     */
	private void uploadTemplateRequest (UploadPortletRequest uploadRequest, ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
			throws FileNotFoundException {
		
		Processor uploadTemplate = null;
		File file = uploadRequest.getFile("uploadFile");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		//User object
		User user = themeDisplay.getUser();
		String templateType = ParamUtil.getString(uploadRequest, "template_type");
		Preferences preferences = getGEMUserPreferences(resourceRequest);
		try {
			if (preferences != null && Validator.isNotNull(preferences.getBrand())) {
				
				Publication publication = getActiveGEMPublication(preferences.getDepartmentId(), preferences.getBrand());
				//Get Department publication reference 
				PublishDept publishDept = PublishDeptLocalServiceUtil.getActivePublicationByDept(publication.getPublishId(), preferences.getDepartmentId());
				long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(preferences.getRegionCode());
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), resourceRequest);
				long templateId =  0;
				//Waiver template or selfaudit template.
				boolean processValues = true;
				String fileName = uploadRequest.getFileName("uploadFile");
				
				if (GemConstants.TEMPLATE_TYPE_WAIVER.equals(templateType) || GemConstants.TEMPLATE_TYPE_SA.equals(templateType) || GemConstants.TEMPLATE_TYPE_SE.equals(templateType)) {
					uploadTemplate = ProcessorFactory.getProcessorObject(templateType);
					//Get File name 
					if(GemConstants.TEMPLATE_TYPE_WAIVER.equals(templateType))
					{
						processValues = false;
					}
					
					templateId = uploadTemplate.processTemplate(file, templateType, 
		    				fileName, publication.getPublishId(), publishDept.getPublishDeptId(), regionId, user.getUserId(), processValues, 0);
		    	}
				
					if (templateId != 0) {
						addTemplateInDLRepository(file, themeDisplay, preferences, serviceContext, templateId, fileName);
						resourceResponse.getWriter().write("success");
					} else {
						resourceResponse.getWriter().write("error");
					}
				} 
			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
			} catch (NoSuchPublishDeptException e) {
				LOG.error(e.getMessage(), e);
			} catch (SystemException e) {
				LOG.error(e.getMessage(), e);
			} catch (PortalException e) {
				LOG.error(e.getMessage(), e);
			}
		}

	/**
	 * This method inserts templates in document library
	 * @param file
	 * @param themeDisplay
	 * @param preferences
	 * @param serviceContext
	 * @param templateId
	 * @param fileName
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void addTemplateInDLRepository(File file, ThemeDisplay themeDisplay, Preferences preferences, ServiceContext serviceContext, long templateId, String fileName) throws PortalException, SystemException {
		String mimeType = MimeTypesUtil.getContentType(fileName);
		DateFormat formatter = new SimpleDateFormat("MMM_dd_yy_HH-mmaaa_");
		long folderId = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0L, GemConstants.GEM_DL_FOLDER).getFolderId();
		StringBuilder title = new StringBuilder(formatter.format(new Date())).append(preferences.getRegionCode()).append("_").append(preferences.getBrand()).append("_").append(templateId);
		DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folderId, fileName, mimeType, title.toString(), title.toString(), "", file, serviceContext);
	}

	/**
     * This method will generate a map with metadata fields based on the search criteria selection.
     */
    public void addMetadataFields(Publication publish, String environment, String userName, String templateId, String reportType, String reportTitle, 
    		String regionCode, String subBrandCode, Map<String, String> metadataParams, Map<String, String> compareMetadataParams, Map<String, String> manualTypes,String localeList)
    {
    	long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        metadataParams.put(BridgeConstants.METADATA_PARAM_ENVIRONMENT, environment);
        metadataParams.put(BridgeConstants.METADATA_PARAM_GEM_PUBLISH_ID, String.valueOf(publish.getPublishId()));
        metadataParams.put(BridgeConstants.METADATA_PARAM_BRIDGE_PUBLISH_ID, String.valueOf(publish.getParentPublishId()));
        metadataParams.put(BridgeConstants.METADATA_PARAM_LOCALE_LIST, localeList);  // Added selected languages CR19
        metadataParams.put(BridgeConstants.METADATA_PARAM_CHAIN_CD, publish.getChainCode());
        metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_CD, regionCode);
        metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_ID, String.valueOf(regionId));
        metadataParams.put(BridgeConstants.METADATA_PARAM_TEMPLATE_ID, templateId);
        metadataParams.put(BridgeConstants.METADATA_PARAM_REPORT_TYPE, reportType);
        metadataParams.put(BridgeConstants.METADATA_PARAM_REPORT_TITLE, reportTitle);
        metadataParams.put(BridgeConstants.SA_MANUAL_TYPE, manualTypes.get(BridgeConstants.SA_REPORT_TYPE));
        metadataParams.put(BridgeConstants.SE_MANUAL_TYPE, manualTypes.get(BridgeConstants.SE_REPORT_TYPE));
        metadataParams.put(BridgeConstants.WR_MANUAL_TYPE, manualTypes.get(BridgeConstants.WR_REPORT_TYPE));
        metadataParams.put(BridgeConstants.METADATA_PARAM_USER_NAME, userName);
        //Put subBrands into metadata
        metadataParams.put(BridgeConstants.METADATA_PARAM_SUB_BRANDS, subBrandCode);
        
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_ENVIRONMENT, environment);
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_GEM_PUBLISH_ID, String.valueOf(publish.getPublishId()));
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_BRIDGE_PUBLISH_ID, String.valueOf(publish.getParentPublishId()));
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_LOCALE_LIST, localeList);  // Added selected languages CR19
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_CHAIN_CD, publish.getChainCode());
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_REGION_CD, regionCode);
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_REGION_ID, String.valueOf(regionId));
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_TEMPLATE_ID, templateId);
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_REPORT_TYPE, reportType);
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_REPORT_TITLE, StringPool.PERCENT);
        compareMetadataParams.put(BridgeConstants.SA_MANUAL_TYPE, manualTypes.get(BridgeConstants.SA_REPORT_TYPE));
        compareMetadataParams.put(BridgeConstants.SE_MANUAL_TYPE, manualTypes.get(BridgeConstants.SE_REPORT_TYPE));
        compareMetadataParams.put(BridgeConstants.WR_MANUAL_TYPE, manualTypes.get(BridgeConstants.WR_REPORT_TYPE));
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_USER_NAME, userName);
        //Put subBrands into metadata
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_SUB_BRANDS, subBrandCode);
        

        //compareMetaData.put(BrandStandardsConstant.METADATA_PARAM_COUNTRY_DESC, StringPool.PERCENT);
    }
    
    public String addUniqueGroupMetadataFields(String brandCode, String regionCode, long regionId, long publishId, String groupType, String manualType) {
		Map<String, String> compareMetadataParams = new LinkedHashMap<String, String>();
		compareMetadataParams.put(BridgeConstants.METADATA_PARAM_ENVIRONMENT, GemConstants.GEM_ENVIRONMENT);
		compareMetadataParams.put(BridgeConstants.METADATA_PARAM_GEM_PUBLISH_ID, String.valueOf(publishId));
		compareMetadataParams.put(BridgeConstants.METADATA_PARAM_CHAIN_CD, brandCode);
		compareMetadataParams.put(BridgeConstants.METADATA_PARAM_PUBLISH_CONTENT_TYPE, manualType);
		compareMetadataParams.put(BridgeConstants.METADATA_PARAM_REGION_CD, regionCode);
		compareMetadataParams.put(BridgeConstants.METADATA_PARAM_REGION_ID, String.valueOf(regionId));
        if(BridgeConstants.SE_REPORT_TYPE.equals(groupType)){
        	compareMetadataParams.put(BridgeConstants.METADATA_PARAM_GROUP_TYPE, BridgeConstants.SE_REPORT_TYPE);
        } else if(BridgeConstants.SA_REPORT_TYPE.equals(groupType)){
        	compareMetadataParams.put(BridgeConstants.METADATA_PARAM_GROUP_TYPE, BridgeConstants.SA_REPORT_TYPE);
        } else if (BridgeConstants.WR_REPORT_TYPE.equals(groupType)) {
        	compareMetadataParams.put(BridgeConstants.METADATA_PARAM_GROUP_TYPE, BridgeConstants.WR_REPORT_TYPE);
        }
        compareMetadataParams.put(BridgeConstants.METADATA_PARAM_USER_NAME, StringPool.PERCENT);
        return BSCommonUtil.buildJobQueueMetadataXML(GemConstants.JOB_TYPE_COUNTRY_GROUP, compareMetadataParams, null, null);
    }
    
    public String processGemPublication(ResourceRequest resourceRequest, String brandCode) 
    {
    	String returnMsg = "SUCCESS";
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	String gemPublicationEnv  = resourceRequest.getParameter("gemPublicationEnv");
    	String gemBridgePublicationId  = resourceRequest.getParameter("gemBridgePublicationId");
    	String gemOBSMPublicationId  = resourceRequest.getParameter("gemOBSMPublicationId");
    	String gemSEManualType  = resourceRequest.getParameter("gemSEManualType");
    	String gemSAManualType  = resourceRequest.getParameter("gemSAManualType");
    	String gemWaiverManualType  = resourceRequest.getParameter("gemWaiverManualType");
    	String oldGemSEManualType  = resourceRequest.getParameter("oldGemSEManualType");
    	String oldGemSAManualType  = resourceRequest.getParameter("oldGemSAManualType");
    	String oldGemWaiverManualType  = resourceRequest.getParameter("oldGemWaiverManualType");
    	String gemPublicationLocaleList = "";
    	Map<String, String> manualTypeMap = getManualTypeMap(gemSEManualType, gemSAManualType, gemWaiverManualType);
    	boolean createNewGemPublication = false;
    	Publication activeGemPublication = null;
    	Preferences preferences = getGEMUserPreferences(resourceRequest);
    	long regionId = -1;
    	if (preferences != null) {
			regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(preferences.getRegionCode());
		}
    	try {
    		//Setting current active gem publication to archive if exist
	        activeGemPublication = getActiveGEMPublication(preferences.getDepartmentId(), brandCode);
	        if(activeGemPublication != null && activeGemPublication.getParentPublishId() != Long.parseLong(gemBridgePublicationId)){
	        	createNewGemPublication = true;
	        	activeGemPublication.setPublishStatCd(BridgeConstants.PUBLISH_ARCHIVE_STATUS_CODE);

	        	//Change by:  Dilip
	        	gemPublicationLocaleList = getBridgePublicationLocaleListByGlobalRegion(gemBridgePublicationId);
	        	activeGemPublication.setPublishLocaleList(gemPublicationLocaleList);
	            //Changes end : Dilip

	        	PublicationLocalServiceUtil.updatePublication(activeGemPublication);
	        }
    	} catch (Exception e) {
            //Do Nothing
        }
    	
	    try {
	    	Publication gemPublication = null;
	    	
	    	//Change by:  Dilip
        	gemPublicationLocaleList = getBridgePublicationLocaleListByGlobalRegion(gemBridgePublicationId);
        	//Changes end : Dilip
	    	if(activeGemPublication == null || createNewGemPublication){
	    		
	    		
		        //Creating new Gem Publication
	            gemPublication = PublicationLocalServiceUtil.createPublication();
	            gemPublication.setPublishVerId(0);
	            gemPublication.setChainCode(brandCode);
	            gemPublication.setPublishEnvName(gemPublicationEnv);
	            gemPublication.setPublishStatCd(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE);
	            if(gemPublicationEnv.equals("GEM_CMS") && Validator.isNotNull(gemBridgePublicationId)) {
	            	gemPublication.setParentPublishId(Long.parseLong(gemBridgePublicationId));
	        	} else if(gemPublicationEnv.equals("GEM_OBSM") && Validator.isNotNull(gemOBSMPublicationId)) {
	        		gemPublication.setParentPublishId(Long.parseLong(gemOBSMPublicationId));
	        	} else {
	        		gemPublication.setParentPublishId(gemPublication.getPublishId());
	        	}
	
	            gemPublication.setCreatorId(String.valueOf(themeDisplay.getUser().getUserId()));
	            gemPublication.setUpdatedBy(String.valueOf(themeDisplay.getUser().getUserId()));
	            //Added by Dilip
				gemPublication.setPublishLocaleList(gemPublicationLocaleList);  
	          
	            gemPublication = PublicationLocalServiceUtil.addPublication(gemPublication);
	            
	                
	            if (LOG.isDebugEnabled()) {
	                LOG.debug("Gem publication created :" + gemPublication.getPublishId());
	            }
	            updateManualTypes(themeDisplay, manualTypeMap, gemPublication);
	            
	            //Store department publication reference into DEPT_PUBLISH table
	            PublishDept publishDept = PublishDeptLocalServiceUtil.createDeptPublication();
	            publishDept.setPublishDeptId(publishDept.getPublishDeptId());
	            publishDept.setPublishId(gemPublication.getPublishId());
	            publishDept.setDeptId(preferences.getDepartmentId());
	            if (LOG.isDebugEnabled()) {
	            	LOG.debug("Publish dept Id :"+publishDept.getPublishDeptId());
	            	LOG.debug("Publish Id :"+publishDept.getPublishId());
	            	LOG.debug("dept Id :"+publishDept.getDeptId());
	            }
	            publishDept.setCreatedDate(new Date());
	            publishDept.setUpdatedDate(new Date());
	            publishDept.setCreatorId(String.valueOf(themeDisplay.getUser().getUserId()));
	            publishDept.setUpdatedBy(String.valueOf(themeDisplay.getUser().getUserId()));
	            //Add this record
	            PublishDeptLocalServiceUtil.addPublishDept(publishDept);
	            if(LOG.isDebugEnabled()) {
	            	LOG.debug("GEM Department Publication :"+publishDept.getPublishDeptId());
	            }
	    	}
	    	else
	    	{
	    		Map<String, PublishParm> manualTypes = PublishParmLocalServiceUtil.getPublishParmsByPublishId(activeGemPublication.getPublishId());
	    		if(Validator.isNotNull(manualTypes) && manualTypes.size() > 0){
	    			for(Map.Entry<String, PublishParm> mnlType : manualTypes.entrySet()){
	    				PublishParm manualType = mnlType.getValue();
	    				manualType.setParmValue(manualTypeMap.get(manualType.getParmName()).toUpperCase());
	    				manualType.setCreatorId(String.valueOf(themeDisplay.getUser().getUserId()));
	    				manualType.setCreatedDate(new Date());
	    				manualType.setUpdatedBy(String.valueOf(themeDisplay.getUser().getUserId()));
	    				manualType.setUpdatedDate(new Date());
	    				PublishParmLocalServiceUtil.updatePublishParm(manualType);
	    			}
	    		}
	    		else
	    		{
	    			updateManualTypes(themeDisplay, manualTypeMap, activeGemPublication);
	    		}
	    	}
	    	if(!gemSEManualType.equalsIgnoreCase(oldGemSEManualType) || !gemSAManualType.equalsIgnoreCase(oldGemSAManualType) || !gemWaiverManualType.equalsIgnoreCase(oldGemWaiverManualType)){
	    		for(int rgnId=2; rgnId <= 5; rgnId++){
	    			if(!gemSEManualType.equalsIgnoreCase(oldGemSEManualType)){
	    	    		addRequestInQueue(Validator.isNotNull(gemPublication) ? gemPublication.getPublishId() : activeGemPublication.getPublishId(), rgnId, BridgeConstants.SE_MANUAL_TYPE, preferences, themeDisplay.getUser());
	    	    	}
	    			if(!gemSAManualType.equalsIgnoreCase(oldGemSAManualType)){
	    	    		addRequestInQueue(Validator.isNotNull(gemPublication) ? gemPublication.getPublishId() : activeGemPublication.getPublishId(), rgnId, BridgeConstants.SA_MANUAL_TYPE, preferences, themeDisplay.getUser());
	    	    	}
	    	    	if(!gemWaiverManualType.equalsIgnoreCase(oldGemWaiverManualType)){
	    	    		addRequestInQueue(Validator.isNotNull(gemPublication) ? gemPublication.getPublishId() : activeGemPublication.getPublishId(), rgnId, BridgeConstants.WR_MANUAL_TYPE, preferences, themeDisplay.getUser());
	    	    	}
	    		}
	    	}
        } catch (Exception e) {
            LOG.error(e);
            returnMsg = "Failed to create Measurement Publication.";
        }
    	return returnMsg;
    }

	/* Added method for get Bridge Publication Languages in string */
    private String getBridgePublicationLocaleListByGlobalRegion(String gemBridgePublicationId) {
    	StringBuffer languageListString = new StringBuffer("en_GB");
    	try {
			//Publication bridgePublication = PublicationLocalServiceUtil.getPublication(Long.parseLong(gemBridgePublicationId));
			List<BridgePublishLang> bridgelanguageList = BridgePublishLangLocalServiceUtil.getByRegion(Long.parseLong(gemBridgePublicationId), GemConstants.GLBL_RGN_ID);
			
			for(BridgePublishLang bridgePublishedlocale :bridgelanguageList ){
				if(languageListString.length()>1){
					languageListString = languageListString.append(StringPool.COMMA);
				}
				languageListString = languageListString.append(bridgePublishedlocale.getLocaleCode());
			}
			//return bridgePublication.getPublishLocaleList();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return languageListString.toString();
	}

	/**
     * Update Manual Types in Database
     * @param themeDisplay
     * @param manualTypeMap
     * @param gemPublication
     * @throws SystemException
     */
	private void updateManualTypes(ThemeDisplay themeDisplay, Map<String, String> manualTypeMap, Publication gemPublication) throws SystemException {
		for (Map.Entry<String, String> manualType : manualTypeMap.entrySet()) {
		    String key = manualType.getKey();
		    String value = manualType.getValue().toUpperCase();
		    PublishParm publishParm = PublishParmLocalServiceUtil.createPublishParam();
		    publishParm.setPublishId(gemPublication.getPublishId());
		    publishParm.setParmName(key);
		    publishParm.setParmValue(value);
		    publishParm.setCreatorId(String.valueOf(themeDisplay.getUser().getUserId()));
		    publishParm.setCreatedDate(new Date());
		    publishParm.setUpdatedBy(String.valueOf(themeDisplay.getUser().getUserId()));
		    publishParm.setUpdatedDate(new Date());
		    PublishParmLocalServiceUtil.addPublishParm(publishParm);
		}
	}

	/**
	 * Creating Map for SA, SE and Waiver Manual Type
	 * @param gemSEManualType
	 * @param gemSAManualType
	 * @param gemWaiverManualType
	 * @return
	 */
	private Map<String, String> getManualTypeMap(String gemSEManualType, String gemSAManualType, String gemWaiverManualType) {
		Map<String, String> manualTypeMap = new LinkedHashMap<String, String>();
		manualTypeMap.put(BridgeConstants.SA_REPORT_TYPE, gemSAManualType);
		manualTypeMap.put(BridgeConstants.SE_REPORT_TYPE, gemSEManualType);
		manualTypeMap.put(BridgeConstants.WR_REPORT_TYPE, gemWaiverManualType);
		return manualTypeMap;
	}
	
	//PatelHiren CR_19_Start
	  /**
	     * Fetch Active languages for a Region from database.
	     * 
	     * @param portletRequest request
	     * @param publish Publication
	     * @param regionCd region code
	     * @param rgnId region id
	     */
	    protected void setActiveLanguages(PortletRequest portletRequest, Publication publish) 
	    {
	        Map<String, String> activeSecondLanguages = getRegionActiveSecondLanguages(GemConstants.GLBL_RGN_CD);
	        portletRequest.setAttribute("activeSecondLanguages", activeSecondLanguages.entrySet());
	        Map<String, String> selectedBrdgRgnLangs = new LinkedHashMap<String, String>();
	        Map<String, String> selectedGemLangs = new LinkedHashMap<String, String>();
	        try
	        {
	            if (publish != null)
	            {
	             String publishLangCode = publish.getPublishLocaleList();
	                List<String> publishLangCodeList = new ArrayList<String>(Arrays.asList(publishLangCode.split(StringPool.COMMA)));
	                if (publishLangCodeList != null && !publishLangCodeList.isEmpty())
	                {
	                    for (String langCode : publishLangCodeList)
	                    {
	                     selectedGemLangs.put(langCode, langCode);
	                    }
	                }
	                
	                List<BridgePublishLang> bridgePublishLangList = BridgePublishLangLocalServiceUtil.getByRegion(publish.getParentPublishId(), GemConstants.GLBL_RGN_ID);
	                if (bridgePublishLangList != null && !bridgePublishLangList.isEmpty())
	                {
	                    for (BridgePublishLang lang : bridgePublishLangList)
	                    {
	                     selectedBrdgRgnLangs.put(lang.getLocaleCode(), lang.getLocaleCode());
	                    }
	                }
	            }
	        }
	        catch (Exception e)
	        {
	            LOG.error(e);
	        }
	        portletRequest.setAttribute("selectedBrdgRgnLangs", selectedBrdgRgnLangs);
	        portletRequest.setAttribute("selectedGemLangs", selectedGemLangs);
	    }
	    
	    /**
	     * Add/Remove language selection for Publication.
	     * 
	     * @param resourceRequest request
	     * @param themeDisplay themeDisplay
	     * @param publish Publication
	     * @param regionCd region code
	     * @param rgnId region ID
	     */
	    private boolean updatePublicationLanguage(ResourceRequest resourceRequest, ThemeDisplay themeDisplay, Publication publish)
	    {
	        String localeCode = getHttpServletRequest(resourceRequest).getParameter("localeCode");
	        String elementChecked = getHttpServletRequest(resourceRequest).getParameter("elementChecked");
	        boolean isPublicationUpdated = false;
	        if(LOG.isDebugEnabled()){
	         LOG.debug(" localeCode=" + localeCode + " --elementChecked=" + elementChecked);
	        }

	        StringBuilder publishLocaleCode = new StringBuilder();
	        try
	        {
	         String publishLangCode = publish.getPublishLocaleList();
	            if (publishLangCode != null && "true".equals(elementChecked))
	            {
	             publishLocaleCode.append(publishLangCode);
	             if (!publishLocaleCode.toString().contains(localeCode)) {
	              publishLocaleCode.append(StringPool.COMMA);
	              publishLocaleCode.append(localeCode);
	          }
	             isPublicationUpdated = updatePublication(publish,themeDisplay.getUserId(),publishLocaleCode.toString());
	             
	            }
	            else if (publishLangCode != null && "false".equals(elementChecked)){
	             publishLocaleCode.append(publishLangCode);
	             int start = publishLocaleCode.indexOf(localeCode);
	             if(start < 0){
	                 return false;
	             }    
	             publishLocaleCode.delete(start-1, start + localeCode.length());
	             isPublicationUpdated = updatePublication(publish,themeDisplay.getUserId(), publishLocaleCode.toString());
	            }
	        }
	        catch (Exception e)
	        {
	            LOG.error(e);
	        }
	        return isPublicationUpdated;
	    }
	    
	    /**
	     * 
	     * @param publish
	     * @param publishLocaleList
	     * @param userId
	     */
	    private boolean updatePublication(Publication publish, long userId,String publishLocaleList) 
	    {
	     boolean isPublicationUpdated = false;
	     try {
	             publish.setUpdatedDate(new Date());
	             publish.setUpdatedBy(StringPool.BLANK+userId);
	             publish.setPublishLocaleList(publishLocaleList);
	             PublicationLocalServiceUtil.updatePublication(publish);
	             isPublicationUpdated = true;
	             if (LOG.isDebugEnabled())
	                {
	                    LOG.debug("update publication :" + publish.getPublishId());
	                }
	   } catch (Exception e) {
	    LOG.error(StackTraceUtil.getStackTrace(e));
	   }
	        return isPublicationUpdated; 
	    } 
	 //PatelHiren CR_19_End
}
