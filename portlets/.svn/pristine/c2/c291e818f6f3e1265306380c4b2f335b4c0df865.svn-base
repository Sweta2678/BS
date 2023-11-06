package com.ihg.brandstandards.gem.portlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.gem.model.QualityLeadModel;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchPublishDeptException;
import com.ihg.brandstandards.db.model.Department;
import com.ihg.brandstandards.db.model.GEMCategory;
import com.ihg.brandstandards.db.model.GEMCode;
import com.ihg.brandstandards.db.model.GEMManagementBucket;
import com.ihg.brandstandards.db.model.GEMMeasurement;
import com.ihg.brandstandards.db.model.GEMSeverity;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.GEMTrigger;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishDept;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMCodeLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMManagementBucketLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMMeasurementLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMSeverityLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTriggerLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMUniqueGroupLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil;
import com.ihg.brandstandards.gem.process.Processor;
import com.ihg.brandstandards.gem.process.ProcessorFactory;
import com.ihg.brandstandards.gem.score.AbstractScoreCalculator;
import com.ihg.brandstandards.gem.score.GEMScore;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Portlet implementation class QualityLeadPortlet
 */
public class QualityLeadPortlet extends BrandStandardsGemPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(QualityLeadPortlet.class);

    public QualityLeadPortlet()
    {
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Preferences userPreferences = getGEMUserPreferences(renderRequest);
        String brandCode = userPreferences.getBrand();
        //USe GEM Publish Id
        Publication publish = getActiveGEMPublication(userPreferences.getDepartmentId(), brandCode);
        if(publish != null) {
	        long gemPublishId = publish.getPublishId();
	        long bridgePublishId = publish.getParentPublishId();
	        long regionId = BrandStandardsUtil.getRegionId(userPreferences.getRegionCode());
	        String regionCode = userPreferences.getRegionCode();
	        long seTemplateId = getTemplateId(gemPublishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
	        long saTemplateId = getTemplateId(gemPublishId, regionId, GemConstants.TEMPLATE_TYPE_SA);
	        boolean isGEMGlobalUser = false;
			try {
			    isGEMGlobalUser = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), "BRND_STND_GEM_GLBL_ADMIN", false);
			} catch (Exception e) {
			}
			LOG.debug("Is Global GEM user: " + isGEMGlobalUser);
	
	        if(themeDisplay.getURLCurrent().contains("/gem/ql-scoring-maximize"))
	        {
	        	renderRequest.setAttribute("showMaximize", false);
	        }
	        else 
	        {
	        	renderRequest.setAttribute("showMaximize", true);
	        }
	        
	        renderRequest.setAttribute("isGEMGlobalUser", isGEMGlobalUser);
	        renderRequest.setAttribute("regionId", regionId);
	        renderRequest.setAttribute("regionCode", regionCode);
	        renderRequest.setAttribute("publishId", gemPublishId);
	        renderRequest.setAttribute("bridgePublishId", bridgePublishId);
	        renderRequest.setAttribute("gemDepartmentId", userPreferences.getDepartmentId());
	        renderRequest.setAttribute("seTemplateId", seTemplateId);
	        renderRequest.setAttribute("saTemplateId", saTemplateId);
	        renderRequest.setAttribute("activeGemPublish", true);

	        Map<String,String> manualTypes =  GEMQlReportLocalServiceUtil.getReportManualTypes(GemQueryUtils.getReportManualTypes(gemPublishId));
	        String seMnlTypeConfig = null;
	    	if(Validator.isNotNull(manualTypes) && Validator.isNotNull(manualTypes.get(GemConstants.SE_REPORT_TYPE))) {
	    		seMnlTypeConfig = manualTypes.get(GemConstants.SE_REPORT_TYPE);
	    	} else {
	    		LOG.error("No SE Manual Config PARM found for the publication:"+gemPublishId+". Defaulting to Operate");
	    		seMnlTypeConfig = GemConstants.MANUAL_TYPE_OPERATE;
	    	}
	    	
	        if (GemConstants.MANUAL_TYPE_OPERATE.equals(seMnlTypeConfig) || GemConstants.MANUAL_TYPE_FULL_BUILD_OPERATE.equals(seMnlTypeConfig)) {
				renderRequest.setAttribute("selManualFilterId", GemConstants.MANUAL_TYPE_ID_OPERATE);
	        } else if (GemConstants.MANUAL_TYPE_BUILD.equals(seMnlTypeConfig)) {
				renderRequest.setAttribute("selManualFilterId", GemConstants.MANUAL_TYPE_ID_BUILD);
	        }
        } 
        else 
        {
        	renderRequest.setAttribute("activeGemPublish", false);
        }
        super.doView(renderRequest, renderResponse);
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

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	HttpSession httpSession = getHttpSession(resourceRequest);
        final String resourceID = resourceRequest.getResourceID();
        Preferences userPreferences = getGEMUserPreferences(resourceRequest);
        String brandCode = userPreferences.getBrand();
        String regionCode = userPreferences.getRegionCode();
        long regionId = BrandStandardsUtil.getRegionId(regionCode);
        //Use GEM Publish Id
    	Publication gemPublish = getActiveGEMPublication(userPreferences.getDepartmentId(), brandCode);
        long gemPublishId = gemPublish.getPublishId();
        
        LOG.debug("resourceID = " + resourceID);
        if ("getStdRecords".equals(resourceID))
        {
            try {
            	String std = getStdRecords(resourceRequest, userPreferences, gemPublish);
            	PrintWriter writer = resourceResponse.getWriter();
            	writer.write(std);
            } catch (NoSuchPublishDeptException e) {
            	LOG.error(e.getMessage(), e);
            } catch (SystemException e) {
            	LOG.error(e.getMessage(), e);
            }
        }
        else if("getFilterMessage".equals(resourceID)){
        	String filterMessage = getFilterMessage(httpSession, resourceRequest, gemPublishId, regionId);
        	PrintWriter writer = resourceResponse.getWriter();
        	writer.write(filterMessage);
        }
        else if ("saveGrid".equals(resourceID))
        {
            String status = saveGridChanges(resourceRequest, userPreferences);            
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(status);
        }
        else if ("calculateScore".equals(resourceID))
        {
            String scoreData = calculateScore(resourceRequest, userPreferences);            
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(scoreData);
        }
        else if ("calculateScorePercent".equals(resourceID))
        {
            String scorePercentData = calculateScorePercent(resourceRequest, userPreferences);            
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(scorePercentData);
        }
        else if ("loadScore".equals(resourceID))
        {
            String status = loadScore(resourceRequest, userPreferences);            
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(status);
        }

        /* do we need it here? */
        else if ("getSEReportingCategory".equals(resourceID))
        {
            List<GEMManagementBucket> bucket = getManagementBucket(userPreferences.getDepartmentId());
            String seCatgy = managementBucketToJSONString(bucket);
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(seCatgy);
        }
        else if ("getCriticality".equals(resourceID))
        {
            List<GEMSeverity> severity = getSeverity();
            String criticality = severityToJSONString(severity);
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(criticality);
        }
        else if ("getCategoryHeading".equals(resourceID))
        {
            List<GEMCategory> categories = getCategoryHeadings();
            String catgy = categoryHeadingsToJSONString(categories);
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(catgy);
        }
        else if ("getQuestions".equals(resourceID))
        {
            String questions = getQuestions();
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(questions);
        }
        else if ("updateMultiplierQty".equals(resourceID))
        {
        	try {
				String measurementId = getHttpServletRequest(resourceRequest).getParameter("measurementId");
				String multiplierQty = getHttpServletRequest(resourceRequest).getParameter("multiplierQty");
				if(Validator.isNotNull(measurementId) && Validator.isNotNull(multiplierQty)){
					updateMeasurementMultiplier(measurementId, multiplierQty, themeDisplay.getUser().getScreenName());
				}
			} catch (NumberFormatException e) {
				LOG.error("", e);
			}
        }
        else if ("loadStdGrpCtryDetail".equals(resourceID))
        {
        	String stdId = getHttpServletRequest(resourceRequest).getParameter("stdId");
			Map<String, String> stdGrpCtryDetails = GEMUniqueGroupLocalServiceUtil.getStdUniqueGrpAndCtrys(gemPublishId, regionId, GemConstants.TEMPLATE_TYPE_SA, stdId);
			resourceRequest.setAttribute("groupData", stdGrpCtryDetails.entrySet());
			resourceRequest.setAttribute("hasGroupDetails", (stdGrpCtryDetails.size() > 0 ? true : false));
			if(LOG.isDebugEnabled()){
				LOG.debug("No of Unique Groups available for the Standard:"+stdId+" Groups Size:"+stdGrpCtryDetails.size());
			}
			
			include("/html/GEM/qualitylead/stdGrpCtryDetail.jsp", resourceRequest, resourceResponse);
        }
        else if("exportStdRecords".equalsIgnoreCase(resourceID))
        {        	
        	List<QualityLeadModel> stdRecords = (List<QualityLeadModel>) resourceRequest.getPortletSession().getAttribute(GemConstants.SESN_ATR_STD_LIST); 
        	
        	if(stdRecords != null && stdRecords.size() > 0){        	
        		String columnToExportStr = ParamUtil.getString(resourceRequest, "columnsToExport", null);
        		try {
					JSONArray exportColumns = JSONFactoryUtil.createJSONArray(columnToExportStr);
					if(exportColumns != null && exportColumns.length() > 0){
						Workbook workbook = getStdRecordsInWorkbook(exportColumns, stdRecords);        		
		        		resourceResponse.setContentType("application/vnd.ms-excel");
		        		
		        		Department dept = DepartmentLocalServiceUtil.getDepartment(userPreferences.getDepartmentId());
		        		
		        		StringBuilder fileName = new StringBuilder();
		        		fileName.append(userPreferences.getBrand()).append("_")
		        				.append(dept.getDepartmentName()).append("_")
		        				.append(userPreferences.getRegionCode())
		        				.append("_Measurement_")
		        				.append(DateUtil.getCurrentDate("MMMddyyyy", Locale.US))
		        				.append(".xls");        		
		        		
		        		resourceResponse.addProperty("Content-Disposition", "attachment; filename="+fileName.toString());
		        		final OutputStream outputStream = resourceResponse.getPortletOutputStream();
		        		workbook.write(outputStream);
		        		outputStream.flush();
		        		outputStream.close();
					}
				} catch (JSONException e) {
					LOG.error(e);
				} catch (PortalException e) {
					LOG.error(e);
				} catch (SystemException e) {
					LOG.error(e);
				}        			
        	}        	
        }
        else if("getBrandsForStd".equals(resourceID))
        {	
        	String brandsForStandard = getBrandsForStandard(resourceRequest, userPreferences);        	 
        	resourceResponse.getWriter().write(brandsForStandard);
        }
    }

    private String loadScore(ResourceRequest resourceRequest, Preferences userPreferences)
    {
        return calculateScore(resourceRequest, userPreferences);
    }
    
    private String calculateScorePercent(ResourceRequest resourceRequest, Preferences userPreferences)
    {
    	String brandCode = userPreferences.getBrand();
        Publication publish = getActiveGEMPublication(userPreferences.getDepartmentId(), brandCode);
        long publishId = publish.getPublishId();
        long regionId = BrandStandardsUtil.getRegionId(userPreferences.getRegionCode());
        
        String scorePctQtyId = resourceRequest.getParameter("scorePctQtyId");
        String bucketId = resourceRequest.getParameter("bucketId");
        String importantQty = resourceRequest.getParameter("importantQty");
        String criticalQty = resourceRequest.getParameter("criticalQty");
        String autoFailQty = resourceRequest.getParameter("autoFailQty");
        if(LOG.isDebugEnabled()) {
        	LOG.debug("=======>scorePctQtyId="+scorePctQtyId+"->importantQty="+importantQty+"->criticalQty="+criticalQty+"->autoFailQty="+autoFailQty);
        }
    	final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        JSONArray array = JSONFactoryUtil.createJSONArray();
        jsonMain.put("status", "SUCCESS");
        jsonMain.put("scores", array);
        
        AbstractScoreCalculator calc = new GEMScore();
        String scorePercent = calc.calculateScorePercent(publishId, regionId, brandCode, bucketId,importantQty, criticalQty, autoFailQty);
        
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("id", scorePctQtyId);
        jsonObject.put("val", scorePercent);
        array.put(jsonObject);
        
        return jsonMain.toString();
    }

    private String calculateScore(ResourceRequest request, Preferences userPreferences)
    {
        String brandCode = userPreferences.getBrand();
        Publication publish = getActiveGEMPublication(userPreferences.getDepartmentId(), brandCode);
        long publishId = publish.getPublishId();
        long regionId = BrandStandardsUtil.getRegionId(userPreferences.getRegionCode());
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String screenName = themeDisplay.getUser().getScreenName();
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

        return populateDataToJSON(seTemplateId,userPreferences.getDepartmentId());
    }
    
    private String populateDataToJSON(long seTemplateId,long gemDepartmentId)
    {
    	final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        JSONArray array = JSONFactoryUtil.createJSONArray();
        jsonMain.put("status", "SUCCESS");
        jsonMain.put("scores", array);
        
    	Map<String, String> bktSeverityCatgyCnts = GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyCounts(seTemplateId);
        Map<String, String> gemBktSeverityCatgyTotalCounts = GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyTotalCounts(seTemplateId);
        if(bktSeverityCatgyCnts != null && !bktSeverityCatgyCnts.isEmpty()){
	        for(Entry<String, String> entry : bktSeverityCatgyCnts.entrySet()){
	        	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	            jsonObject.put("id", entry.getKey());
	            jsonObject.put("val", entry.getValue());
	            array.put(jsonObject);
	        }
        }
        
        if(gemBktSeverityCatgyTotalCounts != null && !gemBktSeverityCatgyTotalCounts.isEmpty()){
	        for(Entry<String, String> entry : gemBktSeverityCatgyTotalCounts.entrySet()){
	        	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
	            jsonObject.put("id", entry.getKey());
	            jsonObject.put("val", entry.getValue());
	            array.put(jsonObject);
	        }
        }
        
        String headerCounts  = GEMQlReportLocalServiceUtil.getScoringHeaderCounts(seTemplateId, gemDepartmentId);
        jsonMain.put("headerCounts", headerCounts);
        
        return jsonMain.toString();
    }

    private String saveGridChanges(ResourceRequest request, Preferences preferences)
    {
        String regionCode = preferences.getRegionCode();
        long regionId = BrandStandardsUtil.getRegionId(regionCode);
        String brandCode = preferences.getBrand();
        Publication publish = getActiveGEMPublication(preferences.getDepartmentId(), brandCode);
        long publishId = publish.getPublishId();
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String screenName = themeDisplay.getUser().getScreenName();
        String changedRec = request.getParameter("changes");
        boolean isReSequence = ParamUtil.getBoolean(request, "isReSequence", false);
        PublishDept publishDept = null;
		
        if(LOG.isDebugEnabled()){
        	LOG.debug("isReSequence--->"+isReSequence);
        }
        boolean isGEMGlobalUser = false;
        try {
        	publishDept = PublishDeptLocalServiceUtil.getActivePublicationByDept(publishId, 
        			preferences.getDepartmentId());
            isGEMGlobalUser = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), "BRND_STND_GEM_GLBL_ADMIN", false);
        } catch (Exception e) {
        }
        //LOG.debug("changed records = " + changedRec);
        List<QualityLeadModel> list = new ArrayList<QualityLeadModel>();
        String status = "FAILED";
        
        try
        {
            JSONArray array = JSONFactoryUtil.createJSONArray(changedRec);
            for (int i = 0; i< array.length(); i++)
            {
                JSONObject jsonObject = array.getJSONObject(i);
                LOG.debug("jsonObject = " + jsonObject.toString());
                list.add(new QualityLeadModel(jsonObject));
            }
            
            boolean success = GEMQlReportLocalServiceUtil.saveGEMQlReport(list, publishDept.getPublishDeptId(), 
            		publish.getParentPublishId(), publishId, regionId, screenName, isGEMGlobalUser, isReSequence);
            if (success)
            {
                status = "SUCCESS";
                //Get manual type of SE, SA and Waiver
                String seMnlTypeConfig = null;
                Map<String,String> manualTypes =  GEMQlReportLocalServiceUtil.getReportManualTypes(GemQueryUtils.getReportManualTypes(publishId));
                if(Validator.isNotNull(manualTypes) && Validator.isNotNull(manualTypes.get(GemConstants.SE_REPORT_TYPE))) {
            		seMnlTypeConfig = manualTypes.get(GemConstants.SE_REPORT_TYPE);
            	} else {
            		LOG.error("No SE Manual Config PARM found for the publication:"+publishId+". Defaulting to Operate");
            		seMnlTypeConfig = GemConstants.MANUAL_TYPE_OPERATE;
            	}
                //Create gem unique groups
    	        Processor processor = ProcessorFactory.getProcessorObject(BridgeConstants.SE_REPORT_TYPE);
    	        String compareMetadata = processor.generateMetadata(preferences.getBrand(), preferences.getRegionCode(), 
    	        		regionId, publishId, BridgeConstants.SE_REPORT_TYPE, seMnlTypeConfig,
    	        		StringPool.PERCENT);
    	        //If job que request is in queue then do not create new request
    	        if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetadata, 
    	        		StringPool.PERCENT, BridgeConstants.JOB_TYPE_COUNTRY_GROUP, BridgeConstants.QUEUE_NEW_STATUS)) {
    	        	processor.addMessageInQueue(BridgeConstants.JOB_TYPE_COUNTRY_GROUP, publishId, 
    	        			BridgeConstants.SE_REPORT_TYPE, seMnlTypeConfig, preferences, themeDisplay.getUser());
    	        }
            }
        }
        catch (JSONException e)
        {
            LOG.error("Invalid JASON: " + changedRec);
            LOG.error("Invalid JASON", e);
        }
        return status;
    }

    private String getStdRecords(ResourceRequest resourceRequest, Preferences preferences, Publication gemPublish) throws NoSuchPublishDeptException, SystemException
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String regionCode = preferences.getRegionCode();
        long regionId = BrandStandardsUtil.getRegionId(regionCode);
        String brandCode = preferences.getBrand();
        Publication bridgePublication = getBridgePublishForGem(preferences.getDepartmentId(), brandCode);
        String screenName = themeDisplay.getUser().getScreenName();
        long gemPublishId = gemPublish.getPublishId();
        PublishDept publishDept = PublishDeptLocalServiceUtil.getActivePublicationByDept(gemPublishId, preferences.getDepartmentId());
        int pageNo = ParamUtil.get(resourceRequest, "page", 1);
        int itemsPerPage = ParamUtil.get(resourceRequest, "rows", 20);
        
        String filterRules = ParamUtil.get(resourceRequest, "filterRules", "");
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Measurement FilterRules: " + filterRules);
        }
        
        boolean isGEMGlobalUser = false;
        try {
            List<Role> userRoleList = themeDisplay.getUser().getRoles();
            String regionCodeFromUserRole = BrandStandardsUtil.getUserRegionFromUserRole(userRoleList);
            if ("GLBL".equals(regionCodeFromUserRole)) {
                isGEMGlobalUser = true;
            }
        } catch (SystemException e) {
        }
        //Get manual type of SE, SA and Waiver
        Map<String,String> manualTypes =  GEMQlReportLocalServiceUtil.getReportManualTypes(GemQueryUtils.getReportManualTypes(gemPublishId));
        String seMnlTypeConfig = null;
        String saMnlTypeConfig = null;
        String wrMnlTypeConfig = null;
    	if(Validator.isNotNull(manualTypes) && Validator.isNotNull(manualTypes.get(GemConstants.SE_REPORT_TYPE))) {
    		seMnlTypeConfig = manualTypes.get(GemConstants.SE_REPORT_TYPE);
    	} else {
    		LOG.error("No SE Manual Config PARM found for the publication:"+gemPublishId+". Defaulting to Operate");
    		seMnlTypeConfig = GemConstants.MANUAL_TYPE_OPERATE;
    	}
    	if(Validator.isNotNull(manualTypes) && Validator.isNotNull(manualTypes.get(GemConstants.SA_REPORT_TYPE))){
    		saMnlTypeConfig = manualTypes.get(GemConstants.SA_REPORT_TYPE);
    	} else {
    		LOG.error("No SA Manual Config PARM found for the publication:"+gemPublishId+". Defaulting to Operate");
    		saMnlTypeConfig = GemConstants.MANUAL_TYPE_OPERATE;
    	}
    	if(Validator.isNotNull(manualTypes) && Validator.isNotNull(manualTypes.get(GemConstants.WAIVER_REPORT_TYPE))){
    		wrMnlTypeConfig = manualTypes.get(GemConstants.WAIVER_REPORT_TYPE);
    	} else {
    		LOG.error("No Waiver Manual Config PARM found for the publication:"+gemPublishId+". Defaulting to Operate");
    		wrMnlTypeConfig = GemConstants.MANUAL_TYPE_OPERATE;
    	}
        
        GEMQlReportLocalServiceUtil.syncBridgeGEMQlReport(preferences.getDepartmentId(), publishDept.getPublishDeptId(), 
        		bridgePublication.getPublishId(), gemPublishId, regionId, regionCode, brandCode, screenName, themeDisplay.getUser().getFullName(), 
        		seMnlTypeConfig, saMnlTypeConfig, wrMnlTypeConfig, isGEMGlobalUser);
        
        String query = GemQueryUtils.getGemQLFormRecordsQuery(gemPublish.getParentPublishId(), gemPublishId, regionId, regionCode, brandCode, seMnlTypeConfig, filterRules);
        List<QualityLeadModel> recs = GEMQlReportLocalServiceUtil.getGEMQlReport(query);
        List<QualityLeadModel> list = getSortedStandards(recs);
        
        resourceRequest.getPortletSession().setAttribute(GemConstants.SESN_ATR_STD_LIST, list);
        
        JSONArray array = JSONFactoryUtil.createJSONArray();
        final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        if(list != null && !list.isEmpty()) {
            int size = list.size();
            jsonMain.put("total", size);  
            
            List<QualityLeadModel> finalList = new ArrayList<QualityLeadModel>();
            for (int i=((pageNo - 1) * itemsPerPage); (i<(itemsPerPage * pageNo) && i<size); i++) {
                QualityLeadModel std = list.get(i);
                finalList.add(std);
                for (QualityLeadModel item : std.getSpecifications())
                {
                    finalList.add(item);
                }
                for (QualityLeadModel item : std.getGuidelines())
                {
                    finalList.add(item);
                }
            }

            for (QualityLeadModel std : finalList)
            {
                array.put(std.toJSON());
            }
        }
        else
        {
            jsonMain.put("total", 0);  
        }
        jsonMain.put("rows", array);

        return jsonMain.toString();
    }
    
    private String getFilterMessage(HttpSession httpSession, ResourceRequest resourceRequest, long gemPublishId, long regionId)
    {
    	String glblMust = null, stdRegion = null, stdIdLst = null, mnlType = "258", path = null, stdStatus = null, stdTitle = null, stdCatgy = null, stdOwner = null, stdCmply = null, complDue = null;
        long catgyHead = 0, seRptCatgy = 0, criticality = 0, seSeqNo = 0, question = 0;
        long seTemplateId = getTemplateId(gemPublishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
        long saTemplateId = getTemplateId(gemPublishId, regionId, GemConstants.TEMPLATE_TYPE_SA);
        
    	StringBuilder filterMessage = new StringBuilder("Current Filter Selection: ");
        String filterRules = ParamUtil.get(resourceRequest, "filterRules", "");
        filterRules = getHttpServletRequest(resourceRequest).getParameter("filterRules");
        if (filterRules != null && !filterRules.isEmpty()) {
        	try {
                JSONArray array = JSONFactoryUtil.createJSONArray(filterRules);
                LOG.debug("JSON array: " + array.toString());
                for (int i = 0; i < array.length(); i++) {
                	JSONObject filterObj = array.getJSONObject(i);
                	if(filterObj.getString("field").equals("glblMust")){
                		glblMust = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("glblRgn")){
                		stdRegion = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("stdId")){
                		stdIdLst = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("mnlType")){
                		mnlType = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("path")){
                		path = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("stdStatus")){
                		stdStatus = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("title")){
                		stdTitle = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("catgy")){
                		stdCatgy = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("stdOwner")){
                		stdOwner = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("cmply")){
                		stdCmply = filterObj.getString("value");
                	} else if(filterObj.getString("field").equals("catgyHead")){
                		catgyHead = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("seRptCatgy")){
                		seRptCatgy = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("crit")){
                		criticality = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("seSeqNo")){
                		seSeqNo = Math.round(filterObj.getDouble("value"));
                	} else if(filterObj.getString("field").equals("question")){
                		question = filterObj.getLong("value");
                	} else if(filterObj.getString("field").equals("complDue")){
                		complDue = filterObj.getString("value");
                	}
                }
                
                boolean addComma = false;
                if(Validator.isNotNull(glblMust)) {
                	filterMessage.append(" Global Must:");
            		if("Y".equals(glblMust)){
            			filterMessage.append("Yes");
            		} else {
            			filterMessage.append("No");
            		}
            		addComma = true;
                }
                if(Validator.isNotNull(stdRegion)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Region: ");
                	if("GLBL".equals(stdRegion)){
                		filterMessage.append("Global");
                	} else {
                		filterMessage.append(stdRegion);
                	}
            		addComma = true;
                }

                if(Validator.isNotNull(stdIdLst)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" STD ID: ").append(stdIdLst);
            		addComma = true;
                }
                if(Validator.isNotNull(mnlType)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Manual Type: ");
                	if("258".equals(mnlType)){
                		filterMessage.append("Operate");
                	} else if("257".equals(mnlType)){
                		filterMessage.append("Build");
                	} else if ("257, 258".equals(mnlType) || "258, 257".equals(mnlType)){
                		filterMessage.append("Build & Operate");
                	}
            		addComma = true;
                }
                if(Validator.isNotNull(path)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Path: ");
                	filterMessage.append(path.substring(path.indexOf("_")+1, path.length()));
            		addComma = true;
                }
                if(Validator.isNotNull(stdStatus)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Status: ");
                	if("MEASURED".equals(stdStatus)){
                		filterMessage.append("Measured");
                	} else if("NOT_MEASURED".equals(stdStatus)){
                		filterMessage.append("Not Measured");
                	} else if("GLBL_MUST_MEASURE".equals(stdStatus)){
                		filterMessage.append("Global Must");
                	}
            		addComma = true;
                }
                if(Validator.isNotNull(stdTitle)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Text: ").append(stdTitle);
            		addComma = true;
                }
                if(Validator.isNotNull(stdCatgy)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Category: ").append(stdCatgy);
            		addComma = true;
                }
                if(Validator.isNotNull(stdOwner)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Standard Owner: ").append(stdOwner);
            		addComma = true;
                }
                if(Validator.isNotNull(stdCmply)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Compliance Date: ");
                	if("EXIST".equals(stdCmply)){
                		filterMessage.append("Exist");
                	} else if("NOT_EXIST".equals(stdCmply)){
                		filterMessage.append("Not Exist");
                	}
            		addComma = true;
                }
                if(Validator.isNotNull(catgyHead)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Category Heading: ").append(decodeCategoryHeadings(httpSession, gemPublishId, regionId, seTemplateId, saTemplateId, catgyHead));
            		addComma = true;
                }
                if(Validator.isNotNull(seRptCatgy)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" SE Reporting Category: ").append(decodeReportingCatgy(httpSession, seRptCatgy));
            		addComma = true;
                }
                if(Validator.isNotNull(criticality)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Q Criticality: ").append(decodeSeverity(httpSession, criticality));
            		addComma = true;
                }
                if(Validator.isNotNull(seSeqNo)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" SE Sequence No: ").append(seSeqNo);
            		addComma = true;
                }
                if(Validator.isNotNull(question)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Trigger Question: ").append(decodeQuestion(httpSession, gemPublishId, question));
            		addComma = true;
                }
                if(Validator.isNotNull(complDue)) {
                	if(addComma) {
            			filterMessage.append(StringPool.COMMA);
            		}
                	filterMessage.append(" Due Date: ").append(getCompliantDuration(httpSession, complDue));
            		addComma = true;
                }
            } catch (JSONException e) {
                LOG.error("Failed to extract JSON", e);
            }
        } else if(Validator.isNull(filterRules) || Validator.isNull(mnlType)){
        	filterMessage.append("Manual Type: Operate");
        }
        //resourceRequest.setAttribute("filterMessage", filterMessage);
        return filterMessage.toString();
    }
    
    protected List<GEMMeasurement> getMeasurement()
    {
        List<GEMMeasurement> measurCatgy;
        
        try
        {
            measurCatgy = GEMMeasurementLocalServiceUtil.getGEMMeasurements(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        }
        catch (SystemException e)
        {
            LOG.error("Failed to fetch Measurement Categories", e);
            measurCatgy = new ArrayList<GEMMeasurement>();
        }
        
        return measurCatgy;
    }
    
    protected List<GEMMeasurement> getMeasurementCategoryType(List<GEMMeasurement> measurements, String type)
    {
        List<GEMMeasurement> catgy = new ArrayList<GEMMeasurement>();
        
        for (GEMMeasurement item : measurements)
        {
            if (type.equals(item.getMeasurementType()))
            {
                catgy.add(item);
            }
        }
        return catgy;
    }

    protected List<GEMManagementBucket> getManagementBucket(long departmentId)
    {
        List<GEMManagementBucket> buckets = new ArrayList<GEMManagementBucket>();
        
        try
        {
             buckets = GEMManagementBucketLocalServiceUtil.getByDepartmentId(departmentId);
         
        }
        catch (SystemException e)
        {
            LOG.error("Failed to fetch SE Categories", e);
        }
        
        return buckets;
    }

    protected String managementBucketToJSONString(List<GEMManagementBucket> buckets)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        
        for (GEMManagementBucket bkt : buckets)
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("seRptCatgy", bkt.getBucketId());
            jsonObject.put("seRptCatgyNm", HtmlUtil.escape(bkt.getBucketName()));
            array.put(jsonObject);
        }
        return array.toString();
    }

    protected List<GEMSeverity> getSeverity()
    {
        List<GEMSeverity> severity;
        try
        {
            severity = GEMSeverityLocalServiceUtil.getGEMSeverities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        }
        catch (SystemException e)
        {
            LOG.error("Failed to fetch severity", e);
            severity = new ArrayList<GEMSeverity>();
        }
        return severity;
    }

    protected String severityToJSONString(List<GEMSeverity> severity)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        
        for (GEMSeverity item : severity)
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("crit", item.getSeverityId());
            jsonObject.put("critNm", item.getSeverityName());
            array.put(jsonObject);
        }
       
        return array.toString();
    }

    protected List<GEMCategory> getCategoryHeadings()
    {
        List<GEMCategory> categories;
        
        try
        {
            categories = GEMCategoryLocalServiceUtil.getGEMCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        }
        catch (SystemException e)
        {
            LOG.error("Failed to fetch SE Categories", e);
            categories = new ArrayList<GEMCategory>();
        }
        
        return categories;
    }

    protected String categoryHeadingsToJSONString(List<GEMCategory> categories)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        
        for (GEMCategory catgy : categories)
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("catgyHead", catgy.getCategoryId());
            jsonObject.put("catgyHeadNm", HtmlUtil.escape(catgy.getCategoryName()));
            array.put(jsonObject);
        }
        return array.toString();
    }
    
    
    protected String severityCategoryToJSONString(List<GEMMeasurement> severityCatgy)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        
        for (GEMMeasurement catgy : severityCatgy)
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("catgyHead", catgy.getMeasurementId());
            jsonObject.put("catgyHeadNm", HtmlUtil.escape(catgy.getMeasurementName()));
            array.put(jsonObject);
        }
        return array.toString();
    }

    protected String getQuestions()
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("question", 1);
        jsonObject.put("questionNm", "Does this property have a Breakroom/Canteen?");
        array.put(jsonObject);

        jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("question", 2);
        jsonObject.put("questionNm", "Q2 Does this property have a Breakroom/Canteen?");
        array.put(jsonObject);
        
        jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("question", 3);
        jsonObject.put("questionNm", "Question 777 Question777 Question ??");
        array.put(jsonObject);
        
        return array.toString();
    }    
    
    /**
     * @param publishId The bridge publish id
     * @param regionId The region id
     * @param statIndText The status indicator text
     */
    public List<QualityLeadModel> getSortedStandards(List<QualityLeadModel> arlDisplayResults)
    {
        if (arlDisplayResults.isEmpty())
        {
            return new ArrayList<QualityLeadModel>();
        }
        
        List<QualityLeadModel> standardsLst = new ArrayList<QualityLeadModel>();
        List<QualityLeadModel> stdSpecGdln = new ArrayList<QualityLeadModel>();
        List<Long> stdIdLst = new ArrayList<Long>();

        for (QualityLeadModel qlModel : arlDisplayResults)
        {
            if (!stdIdLst.contains(qlModel.getStdId()))
            {
                stdIdLst.add(qlModel.getStdId());
                if (BSCommonConstants.STD_TYPE_STANDARD.equals(qlModel.getStdType()))
                {
                    standardsLst.add(qlModel);
                }
                else //if (BrandStandardsUtil.STD_TYPE_SPEC.equals(stdExt.getStdTyp()))
                {
                    stdSpecGdln.add(qlModel);
                }
            }
        }

        //updateIndexOrder(standardsLst);
        //List<QualityLeadModel> sortedStandards = sortRecords(standardsLst);
        //for (QualityLeadModel std : sortedStandards)
        for (QualityLeadModel std : standardsLst)
        {
            List<QualityLeadModel> specLst = std.getSpecifications();//return an empty ArrayList if no specifications available
            List<QualityLeadModel> gdlnLst = std.getGuidelines();//return an empty ArrayList if no guidelines available
            boolean recAdded = false;
            
            for (QualityLeadModel item : stdSpecGdln)
            {
                if (std.getStdId() == item.getParentStdId())
                {
                    if (BSCommonConstants.STD_TYPE_SPEC.equals(item.getStdType()))
                    {
                        specLst.add(item);
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(item.getStdType()))
                    {
                        gdlnLst.add(item);
                    }
                    recAdded = true;
                }
            }
            
            if (recAdded)
            {
                cleanup(stdSpecGdln, specLst);
                cleanup(stdSpecGdln, gdlnLst);
            }
            Collections.sort(specLst, new SpecsGuidelinesSortBySTDId());
            Collections.sort(gdlnLst, new SpecsGuidelinesSortBySTDId());
        }
        //return sortedStandards;
        return standardsLst;
    }

    /**
     * Remove unwanted items from collection.
     * @param stdLst original list
     * @param rmStdLst unwanted items list
     */
    private void cleanup(List<QualityLeadModel> stdLst, List<QualityLeadModel> rmStdLst)
    {
        for (QualityLeadModel item : rmStdLst)
        {
            stdLst.remove(item);
        }
    }

    /**
     * @param standards -Standards List
     * @param chainCd -Brand Code
     * @param environment - Environment information
     * @throws SystemException throws System Exception
     */
    public void updateIndexOrder(List<QualityLeadModel> standards)
    {
        final List<PublishStandardsExt> indexes = PublishStandardsExtLocalServiceUtil.getCMSAllIndexes();
        final Map<Long, PublishStandardsExt> indexMap = new HashMap<Long, PublishStandardsExt>();
        for (PublishStandardsExt indx : indexes)
        {
            if (indx.getPublishTaxonomyId() > 1L)
            {
                indexMap.put(indx.getPublishTaxonomyId(), indx);
            }
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("indexMap contains : " + indexMap.size());
        }

        for (QualityLeadModel std : standards)
        {
            PublishStandardsExt rec = indexMap.get(std.getIndexId());
            if (rec != null)
            {
                std.setIndexOrder(rec.getIndexOrder());
            }
        }
    }

    /**
     * Sort records.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    public List<QualityLeadModel> sortRecords(List<QualityLeadModel> standards)
    {
        sortRecordsByIndex(standards);
        return sortStdRecordsUnderIndex(standards);
    }

    /**
     * Sort records.
     * 
     * @param standards -Standard List
     */
    public void sortRecordsByIndex(List<QualityLeadModel> standards)
    {
        Collections.sort(standards, new Comparator<QualityLeadModel>()
        {
            public int compare(QualityLeadModel s1, QualityLeadModel s2)
            {
                int res = compareLong(s1.getIndexOrder(), s2.getIndexOrder());
                if (res == 0)
                {
                    if (s1.getStdId() == 0 && s2.getStdId() == 0)
                    {
                        return 0;
                    }
                    res = compareLong(s1.getParentStdId(), s2.getParentStdId());
                    if (res == 0)
                    {
                        res = compareRecordType(s2.getStdType(), s1.getStdType());
                        if (res == 0)
                        {
                            if (s1.getDisplayOrder() > 0L || s2.getDisplayOrder() > 0L)
                            {
                                res = compareLong(s1.getDisplayOrder(), s2.getDisplayOrder());
                            }
                            else
                            {
                                res = compareLong(s1.getStdId(), s2.getStdId());
                            }
                        }
                    }
                }
                return res;
            }

            /**
             * Compare long values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
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

            /**
             * Compare long values.
             * 
             * @param t1 - record type 1
             * @param t2 - record type 2
             * @return 1, 0, -1
             */
            private int compareRecordType(String t1, String t2)
            {
                if (t1 != null && t2 != null)
                {
                    if (BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && !BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_SPEC.equals(t1) && !BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_SPEC.equals(t1) && BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSCommonConstants.STD_TYPE_SPEC.equals(t1) && BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(t1) && BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(t1) && !BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_GDLN.equals(t1) && BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return -1;
                    }
                }
                else if (t1 != null && t2 == null)
                {
                    return 1;
                }
                else if (t1 == null && t2 != null)
                {
                    return -1;
                }
                return 0;
            }
        });
    }

    /**
     * Sort Standards Under each Index by specified sort order.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    public List<QualityLeadModel> sortStdRecordsUnderIndex(List<QualityLeadModel> standards)
    {
        Map<Long, Map<Long, List<QualityLeadModel>>> indexRecords = new LinkedHashMap<Long, Map<Long, List<QualityLeadModel>>>();

        for (QualityLeadModel std : standards)
        {
            Map<Long, List<QualityLeadModel>> indexItem = indexRecords.get(std.getIndexId());
            // no Index found
            if (indexItem == null)
            {
                // create map to store Standard
                indexItem = new LinkedHashMap<Long, List<QualityLeadModel>>();
                List<QualityLeadModel> stdItem = new ArrayList<QualityLeadModel>();
                stdItem.add(std);
                indexItem.put(std.getStdId(), stdItem);
                // create Index item with Standard
                indexRecords.put(std.getIndexId(), indexItem);
            }
            // found Index; add Standard, Specification or Guideline
            else
            {
                List<QualityLeadModel> stdItem = indexItem.get(std.getParentStdId());
                // this is should be Standard. For Specification and Guideline stdItem should NOT be null
                if (stdItem == null)
                {
                    stdItem = new ArrayList<QualityLeadModel>();
                    indexItem.put(std.getStdId(), stdItem);
                }
                stdItem.add(std);
            }
        }

        List<QualityLeadModel> sortedList = new ArrayList<QualityLeadModel>();
        List<QualityLeadModel> tmpList = new ArrayList<QualityLeadModel>();
        for (Map.Entry<Long, Map<Long, List<QualityLeadModel>>> indexEntry : indexRecords.entrySet())
        {
            tmpList.clear();
            // Standards for Index  === <prnt_std_id, list of Records> first records is a Standard
            Map<Long, List<QualityLeadModel>> stdRecords = indexEntry.getValue();
            for (Map.Entry<Long, List<QualityLeadModel>> stdEntry : stdRecords.entrySet())
            {
                List<QualityLeadModel> recordsList = stdEntry.getValue();
                if (recordsList != null && !recordsList.isEmpty())
                {
                    for (QualityLeadModel rec : recordsList)
                    {
                        //Standards rec = recordsList.get(0);
                        if (BSCommonConstants.STD_TYPE_STANDARD.equals(rec.getStdType()))
                        {
                            tmpList.add(rec);
                        }
                        else
                        {
                            LOG.error("Found ==" + rec.getStdType() + " in index 0, publish std id=" + rec.getStdId());
                        }
                    }
                }
            }

            sortStdBySortOrder(tmpList);
            for (QualityLeadModel std : tmpList)
            {
                List<QualityLeadModel> stdItems = stdRecords.get(std.getStdId());
                sortedList.addAll(stdItems);
            }
        }
        return sortedList;
    }

    /**
     * Sort records by Display order.
     * 
     * @param standards -Standard List
     */
    private void sortStdBySortOrder(List<QualityLeadModel> standards)
    {
        Collections.sort(standards, new Comparator<QualityLeadModel>()
        {
            public int compare(QualityLeadModel s1, QualityLeadModel s2)
            {
                return compareLong(s1.getDisplayOrder(), s2.getDisplayOrder());
            }

            /**
             * Compare long values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
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

        });
    }

    /**
     * @author Lakshminarayana
     */
    class SpecsGuidelinesSortBySTDId implements Comparator<QualityLeadModel>
    {
        /**
         * @param o1 - Standards objects.
         * @param o2 - Standards objects.
         * @return integer.
         */
        public int compare(QualityLeadModel o1, QualityLeadModel o2)
        {
            int res = 0;
            if (o1.getDisplayOrder() > 0L || o2.getDisplayOrder() > 0L)
            {
                Long object1 = o1.getDisplayOrder();
                Long object2 = o2.getDisplayOrder();
                res = object1.compareTo(object2);
            }
            else
            {
                Long object1 = o1.getStdId();
                Long object2 = o2.getStdId();
                res = object1.compareTo(object2);
            }

            return res;
        }
    }

    public void updateMeasurementMultiplier(String measurementId, String multiplierQty, String creatorId){
    	try {
			GEMMeasurement gemMeasurement = GEMMeasurementLocalServiceUtil.getGEMMeasurement(Long.parseLong(measurementId));
			if(gemMeasurement != null){
				gemMeasurement.setMultiplierQty(Long.parseLong(multiplierQty));
				gemMeasurement.setUpdatedBy(creatorId);
				gemMeasurement.setUpdatedDate(new Date());
				GEMMeasurementLocalServiceUtil.updateGEMMeasurement(gemMeasurement);
			}
		} catch (Exception e) {
			LOG.error("Failed to update GEM Measurement Multiplier Quantity", e);
		}
    }

    @SuppressWarnings("unchecked")
	protected String decodeCategoryHeadings(HttpSession httpSession, long gemPublishId, long regionId, long seTemplateId, long saTemplateId, long catgyId) {
    	String catgyHeading = StringPool.BLANK;
    	StringBuilder scopedVar = new StringBuilder("GEMPubId_");
    	scopedVar.append(gemPublishId).append("_rgnId_").append(regionId).append("_CategoryHeadings");
    	Map<Long, String> categoryHeadings = new LinkedHashMap<Long, String>();
        if(httpSession.getAttribute(scopedVar.toString()) != null){
        	categoryHeadings = (Map<Long, String>)httpSession.getAttribute(scopedVar.toString());
        	catgyHeading = categoryHeadings.get(catgyId);
        } else {
	        try {
	        	categoryHeadings = GEMCategoryLocalServiceUtil.getQLFormSAAndSECategories(seTemplateId+StringPool.COMMA+saTemplateId);
	            httpSession.setAttribute(scopedVar.toString(), categoryHeadings);
	            catgyHeading = categoryHeadings.get(catgyId);
	        } catch (Exception e) {
	            LOG.error("Failed to fetch Category Heading Categories", e);
	        }
        }
        
        return catgyHeading;
    }

    @SuppressWarnings("unchecked")
	protected String decodeReportingCatgy(HttpSession httpSession, long bucketId) {
        String reportingCatgy = StringPool.BLANK;
    	Map<Long, String> mgmtBuckets = new LinkedHashMap<Long, String>();
        if(httpSession.getAttribute("GEMMgmtBuckets") != null){
        	mgmtBuckets = (Map<Long, String>)httpSession.getAttribute("GEMMgmtBuckets");
        	reportingCatgy = mgmtBuckets.get(bucketId);
        } else {
	        try {
	            List<GEMManagementBucket> list = GEMManagementBucketLocalServiceUtil.getGEMManagementBuckets(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	            for (GEMManagementBucket item : list) {
	                if (item.getBucketId() > 0L) {
	                	mgmtBuckets.put(item.getBucketId(), item.getBucketName());
	                }
	            }
	            httpSession.setAttribute("GEMMgmtBuckets", mgmtBuckets);
	            reportingCatgy = mgmtBuckets.get(bucketId);
	        } catch (SystemException e) {
	            LOG.error("Failed to fetch SE Categories", e);
	        }
        }
        
        return reportingCatgy;
    }
    
    @SuppressWarnings("unchecked")
	protected String decodeSeverity(HttpSession httpSession, long criticId)
    {
        String criticality = StringPool.BLANK;
    	Map<Long, String> gemSeverities = new LinkedHashMap<Long, String>();
        if(httpSession.getAttribute("GEMSeverities") != null){
        	gemSeverities = (Map<Long, String>)httpSession.getAttribute("GEMSeverities");
        	criticality = gemSeverities.get(criticId);
        } else {
	        try {
	        	List<GEMSeverity> severity = GEMSeverityLocalServiceUtil.getGEMSeverities(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	            for (GEMSeverity item : severity) {
	                if (item.getSeverityId() > 0L) {
	                	gemSeverities.put(item.getSeverityId(), item.getSeverityName());
	                }
	            }
	            httpSession.setAttribute("GEMSeverities", gemSeverities);
	            criticality = gemSeverities.get(criticId);
	        } catch (SystemException e) {
	            LOG.error("Failed to fetch severity", e);
	        }
        }
        return criticality;
    }
    
    @SuppressWarnings("unchecked")
	protected String decodeQuestion(HttpSession httpSession, long gemPublishId, long triggerId) {
    	String question = StringPool.BLANK;
    	StringBuilder scopedVar = new StringBuilder("GEMPubId_").append(gemPublishId).append("_TriggerQuestions");
        Map<Long, String> triggerQuestions = new LinkedHashMap<Long, String>();
        if(httpSession.getAttribute(scopedVar.toString()) != null){
        	triggerQuestions = (Map<Long, String>)httpSession.getAttribute(scopedVar.toString());
        	question = triggerQuestions.get(triggerId);
        } else {
	        try {
	        	List<GEMTrigger> questions = GEMTriggerLocalServiceUtil.getByPublishId(gemPublishId);
	            for(GEMTrigger trigger : questions){
	            	triggerQuestions.put(trigger.getTriggerId(), trigger.getQuestion());
	            }
	            httpSession.setAttribute(scopedVar.toString(), triggerQuestions);
	            question = triggerQuestions.get(triggerId);
	        } catch (Exception e) {
	            LOG.error("Failed to fetch Due Date Code", e);
	        }
        }
        
        return question;
    }
    
    @SuppressWarnings("unchecked")
	protected String getCompliantDuration(HttpSession httpSession, String dueDateCode) {
        String dueDateDesc = StringPool.BLANK;
    	Map<String, String> dueDateCodes = new LinkedHashMap<String, String>();
        if(httpSession.getAttribute("GEMDueDateCodes") != null){
        	dueDateCodes = (Map<String, String>)httpSession.getAttribute("GEMDueDateCodes");
        	dueDateDesc = dueDateCodes.get(dueDateCode);
        } else {
	        try {
	        	List<GEMCode> codes = GEMCodeLocalServiceUtil.getGEMCodes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	            for(GEMCode code : codes){
	            	dueDateCodes.put(code.getCode(), code.getCodeDesc());
	            }
	            httpSession.setAttribute("GEMDueDateCodes", dueDateCodes);
	            dueDateDesc = dueDateCodes.get(dueDateCode);
	        } catch (Exception e) {
	            LOG.error("Failed to fetch Due Date Code", e);
	        }
        }
        
        return dueDateDesc;
    }
    
    protected Workbook getStdRecordsInWorkbook(JSONArray exportColumns, List<QualityLeadModel> stdRecords){
    	final Workbook workbook = new HSSFWorkbook();
    	CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("Standards Measurement");
        
        CellStyle textStyle = workbook.createCellStyle();
        textStyle.setWrapText(true);
        textStyle.setBorderTop((short)1);
        textStyle.setBorderRight((short)1);
        textStyle.setBorderBottom((short)1);
        textStyle.setBorderLeft((short)1);
        
        /** Header Row Style */
        final HSSFFont headerRowFont = (HSSFFont) workbook.createFont();
        headerRowFont.setFontName(HSSFFont.FONT_ARIAL);
        headerRowFont.setColor(HSSFColor.BLACK.index);
        headerRowFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        HSSFCellStyle headerRowStyle = (HSSFCellStyle) workbook.createCellStyle();
        headerRowStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerRowFont.setColor(HSSFColor.WHITE.index);
        headerRowStyle.setFont(headerRowFont);
        headerRowStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerRowStyle.setBorderTop((short)1);
        headerRowStyle.setBorderRight((short)1);
        headerRowStyle.setBorderBottom((short)1);
        headerRowStyle.setBorderLeft((short)1);
        
        /** Std Row Style */
        Font stdRowFont = workbook.createFont();
        stdRowFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        CellStyle stdRowStyle = workbook.createCellStyle();
        stdRowStyle.setFont(stdRowFont);
        stdRowStyle.setWrapText(true);
        stdRowStyle.setBorderTop((short)1);
        stdRowStyle.setBorderRight((short)1);
        stdRowStyle.setBorderBottom((short)1);
        stdRowStyle.setBorderLeft((short)1);        
        
        /** Guideline Row Style */
        CellStyle gdlnRowStyle = workbook.createCellStyle();
        Font gdlnFont = workbook.createFont();
        gdlnFont.setColor(HSSFColor.GREY_40_PERCENT.index);
        gdlnRowStyle.setFont(gdlnFont);
        gdlnRowStyle.setWrapText(true);
        gdlnRowStyle.setBorderTop((short)1);
        gdlnRowStyle.setBorderRight((short)1);
        gdlnRowStyle.setBorderBottom((short)1);
        gdlnRowStyle.setBorderLeft((short)1);
        
        Map<String, Integer> columnIndexMap = new HashMap<String, Integer>();
        JSONObject jsonObject = null;
        String columnHeader = null;
        
        Row headerRow = sheet.createRow(0);
             
        for(int i=0; i < exportColumns.length() ; i++){
        	jsonObject = exportColumns.getJSONObject(i);
        	columnHeader = jsonObject.getString("title");
        	columnIndexMap.put(columnHeader, jsonObject.getInt("index"));
        	
        	sheet.setColumnWidth(i, 2000 * jsonObject.getInt("width")/50);
        	sheet.setDefaultColumnStyle(i, textStyle);
        	
        	Cell cell = headerRow.createCell(i);
            cell.setCellStyle(headerRowStyle);
            cell.setCellValue(creationHelper.createRichTextString(columnHeader));
        }
        
        int rowCounter = 0;        
        Row dataRow = null;     
        
        for(QualityLeadModel qlModel : stdRecords){
        	 dataRow = sheet.createRow(++rowCounter);
        	        	 
        	 populateRowValues(qlModel, columnIndexMap, dataRow, stdRowStyle);
        	 
        	 for (QualityLeadModel spec : qlModel.getSpecifications()){
        		 dataRow = sheet.createRow(++rowCounter);
        		 populateRowValues(spec, columnIndexMap, dataRow, null);
             }
        	 
             for (QualityLeadModel gdln : qlModel.getGuidelines()){
            	 dataRow = sheet.createRow(++rowCounter);
            	 populateRowValues(gdln, columnIndexMap, dataRow, gdlnRowStyle);
             }
        }        
    	return workbook;
    }
    
    private void populateRowValues(QualityLeadModel qlModel, Map<String, Integer> columnIndexMap,  Row dataRow, CellStyle style){    	 
    	 String cellValue = StringPool.BLANK;
    	 
    	 if(columnIndexMap.containsKey("Must") && 
    		("Global".equalsIgnoreCase(qlModel.getGlobalOrRegional()) && ("STD".equalsIgnoreCase(qlModel.getStdType()) || "SPEC".equalsIgnoreCase(qlModel.getStdType())))){
    		
			 if("Y".equalsIgnoreCase(qlModel.getGlobalMust())){
				 cellValue = "Yes";
			 }else if("N".equalsIgnoreCase(qlModel.getGlobalMust())){
				 cellValue = "No";
			 }			 
			 createCell(dataRow, columnIndexMap.get("Must"), cellValue, style);
    	 } 
    	 if(columnIndexMap.containsKey("Region")){    		    
    		 createCell(dataRow, columnIndexMap.get("Region"), StringUtils.isNotBlank(qlModel.getGlobalOrRegional()) ? qlModel.getGlobalOrRegional() : StringPool.BLANK, style);
    	 }        	 
    	 if(columnIndexMap.containsKey("STD ID")){    		     		  
    		 createCell(dataRow, columnIndexMap.get("STD ID"), String.valueOf(qlModel.getStdId()), style);
    	 }     
    	 if(columnIndexMap.containsKey("PARENT STD ID")){    		 	
    		 createCell(dataRow, columnIndexMap.get("PARENT STD ID"), String.valueOf(qlModel.getParentStdId()), style);
    	 }  
    	 if(columnIndexMap.containsKey("Manual Type")){
    		 cellValue = StringPool.BLANK;
    		 if("258".equals(qlModel.getStdManualType())){
    			 cellValue = "Operate";
    		 }else if("257".equals(qlModel.getStdManualType())){
    			 cellValue = "Build";        			 
    		 }else if ("257, 258".equals(qlModel.getStdManualType()) || "258, 257".equals(qlModel.getStdManualType())){
    			 cellValue = "Build & Operate";
    		 }   		 
    		 createCell(dataRow, columnIndexMap.get("Manual Type"), cellValue, style);
    	 }
    	 if(columnIndexMap.containsKey("Path")){
    		 createCell(dataRow, columnIndexMap.get("Path"), StringUtils.isNotBlank(qlModel.getIndexPath()) ? qlModel.getIndexPath() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("Status")){
    		 cellValue = StringPool.BLANK;
    		 if("D_FOR_REF".equals(qlModel.getStdStatus()) || "D_NOT_RQ".equals(qlModel.getStdStatus()) || "D_RPLCD".equals(qlModel.getStdStatus()) || "INST_RQ".equals(qlModel.getStdStatus())){
    			 cellValue = "Discontinued";
    		 }else if(qlModel.getInPublication() == 0){
    			 cellValue = "NOT Published";        			 
    		 }else if(qlModel.getCategoryId() > 0 && qlModel.getSeverityId() > 0 && qlModel.getBucketId() > 0){
    			 cellValue = "Measured Global Must";
    			 if("N".equalsIgnoreCase(qlModel.getGlobalMust())){
    				 cellValue = "Measured";
    			 }
    		 }else if("Y".equalsIgnoreCase(qlModel.getGlobalMust()) && qlModel.getCategoryId() > 0 && (qlModel.getSeverityId() == 0 || qlModel.getBucketId() == 0)){
    			 cellValue = "Global Must";
    		 }    		 	  
    		 createCell(dataRow, columnIndexMap.get("Status"), cellValue, style);
    	 }
    	 if(columnIndexMap.containsKey("Type")){
    		 cellValue = StringPool.BLANK;
    		 if("STD".equals(qlModel.getStdType())){
    			 cellValue = "Standard";
    		 }else if("SPEC".equals(qlModel.getStdType())){
    			 cellValue = "Specification";        			 
    		 }else if ("GDLN".equals(qlModel.getStdType())){
    			 cellValue = "Guideline";
    		 }    		 
    		 createCell(dataRow, columnIndexMap.get("Type"), cellValue, style);
    	 }
    	 if(columnIndexMap.containsKey("Text")){    		 
    		 createCell(dataRow, columnIndexMap.get("Text"), StringUtils.isNotBlank(qlModel.getStdTitle()) ? qlModel.getStdTitle() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("Category")){    		 
    		 createCell(dataRow, columnIndexMap.get("Category"), StringUtils.isNotBlank(qlModel.getStdCategory()) ? qlModel.getStdCategory() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("Standard Owner")){    		 	 
    		 createCell(dataRow, columnIndexMap.get("Standard Owner"), StringUtils.isNotBlank(qlModel.getStdOwner()) ? qlModel.getStdOwner() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("Compliance Date")){    		 		 
    		 createCell(dataRow, columnIndexMap.get("Compliance Date"), StringUtils.isNotBlank(qlModel.getCmplyRuleDate()) ? qlModel.getCmplyRuleDate() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("Category Heading")){    		 
    		 createCell(dataRow, columnIndexMap.get("Category Heading"), StringUtils.isNotBlank(qlModel.getCategoryDesc()) ? qlModel.getCategoryDesc() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("SE Reporting Category")){    		 
    		 createCell(dataRow, columnIndexMap.get("SE Reporting Category"), StringUtils.isNotBlank(qlModel.getBucketDesc()) ? qlModel.getBucketDesc() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("Q Criticality")){
    		 createCell(dataRow, columnIndexMap.get("Q Criticality"), StringUtils.isNotBlank(qlModel.getSeverityDesc()) ? qlModel.getSeverityDesc() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("SE Sequence No")){
    		 createCell(dataRow, columnIndexMap.get("SE Sequence No"), StringUtils.isNotBlank(qlModel.getSeSquence()) ? qlModel.getSeSquence() : StringPool.BLANK, style);
    	 }
    	 if(columnIndexMap.containsKey("Trigger Question")){
    		 createCell(dataRow, columnIndexMap.get("Trigger Question"), StringUtils.isNotBlank(qlModel.getTriggerDesc()) ? qlModel.getTriggerDesc() : StringPool.BLANK, style);    		     		 
    	 }
    	 if(columnIndexMap.containsKey("Due Date")){
    		 createCell(dataRow, columnIndexMap.get("Due Date"), StringUtils.isNotBlank(qlModel.getComplDueDesc()) ? qlModel.getComplDueDesc() : StringPool.BLANK, style);    		     		 
    	 }      	
    }
    
    private void createCell(Row dataRow, int cellIndex, String cellValue, CellStyle style){
    	 Cell cell = dataRow.createCell(cellIndex);
    	 cell.setCellValue(cellValue);
    	 
    	 if(style != null){
    		 cell.setCellStyle(style);
    	 }
    }
    
    protected String getBrandsForStandard(PortletRequest portletRequest, Preferences userPreferences){   	
    	long deptId = userPreferences.getDepartmentId();
    	long standardId = ParamUtil.get(portletRequest, "stdId", -1);
    	long regionId = BrandStandardsUtil.getRegionId(userPreferences.getRegionCode());
    	
    	JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
    	JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
    	int total = 0;
    	
    	if(standardId > 0){
    		List<QualityLeadModel> brandsList = GEMQlReportLocalServiceUtil.getApplicableBrandsByStdId(deptId, standardId, regionId);
    		total = brandsList.size();
	    	
	    	for(QualityLeadModel qlModel : brandsList){	    		
	            jsonArray.put(qlModel.copyToBrandJSON());
	        }
	    }
    	jsonMain.put("total", total);
    	jsonMain.put("rows", jsonArray);
    	
    	return jsonMain.toString();
    }
}
