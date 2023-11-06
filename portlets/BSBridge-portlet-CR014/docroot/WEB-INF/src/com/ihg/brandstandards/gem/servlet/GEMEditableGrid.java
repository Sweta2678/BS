package com.ihg.brandstandards.gem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.GEMCode;
import com.ihg.brandstandards.db.model.GEMManagementBucket;
import com.ihg.brandstandards.db.model.GEMMeasurement;
import com.ihg.brandstandards.db.model.GEMSeverity;
import com.ihg.brandstandards.db.model.GEMTrigger;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMCodeLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMManagementBucketLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMMeasurementLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMSeverityLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTriggerLocalServiceUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * Servlet implementation class GEMEditableGrid
 */
public class GEMEditableGrid  extends HttpServlet 
{
    private static final Log LOG = LogFactoryUtil.getLog(GEMEditableGrid.class);

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GEMEditableGrid() {
    }
 
    /**
     * @param request This is an HttpServletRequest object
     * @param response This is an HttpServletResponse Object
     * @throws IOException throws IOException
     * @throws ServletException 
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        long seTemplateId = ParamUtil.get(request, "seTemplateId", 0L);
        long saTemplateId = ParamUtil.get(request, "saTemplateId", 0L);
        long publishId = ParamUtil.get(request, "publishId", 0L);
        long bridgePublishId = ParamUtil.get(request, "bridgePublishId", 0L);
        long gemDepartmentId = ParamUtil.get(request, "gemDepartmentId", 0L);
        long regionId = ParamUtil.get(request, "regionId", 1L);
        String regionCd = BrandStandardsUtil.getRegionCode(regionId);
        HttpSession httpSession = request.getSession();
        request.setAttribute("regionId", regionId);
        
        List<GEMMeasurement> measurements = getMeasurement(seTemplateId);
        List<GEMMeasurement> measurCatgy = getMeasurementCategoryType(measurements);
        request.setAttribute("measurCatgy", measurCatgy);
        request.setAttribute("rowspanSize", measurCatgy.size() + 1);

        request.setAttribute("severityCatgy", measurements);
        request.setAttribute("severitySpanSize", measurements.size());

        List<GEMManagementBucket> bucket = getManagementBucket(gemDepartmentId);
        request.setAttribute("manageBucket", bucket);
        String reportingCategory = managementBucketToJSONString(bucket);
        request.setAttribute("reportingCategory", reportingCategory);
        
        String defaultScoringHeader = getDefaultScoringHeader(bucket);
        request.setAttribute("defaultScoringHeader", defaultScoringHeader);

        List<GEMSeverity> severity = getSeverity();
        request.setAttribute("severityLst", severity);
        String criticality = severityToJSONString(severity);
        request.setAttribute("criticality", criticality);

        Map<Long, String> categories = getCategoryHeadings(seTemplateId, saTemplateId);
        String categoryHeading = categoryHeadingsToJSONString(categories);
        request.setAttribute("categoryHeading", categoryHeading);

        List<GEMTrigger> triggers = getQuestions(publishId);
        String questions = questionsToJSONString(triggers);
        request.setAttribute("questions", questions);
        
        List<GEMCode> codes = getCompliantDuration();
        String complDue = compliantDurationToJSONString(codes);
        request.setAttribute("complDue", complDue);
        
        List<String> stdOwners = getStdOwners(bridgePublishId, regionId, regionCd);
        String stdBusOwner = getStdOwnersToJSONString(stdOwners);
        request.setAttribute("stdBusOwner", stdBusOwner);
        
        Map<String,String> manualTypeConfig =  GEMQlReportLocalServiceUtil.getReportManualTypes(GemQueryUtils.getReportManualTypes(publishId));
        String seMnlTypeConfig = manualTypeConfig != null ? manualTypeConfig.get(GemConstants.SE_REPORT_TYPE) : GemConstants.MANUAL_TYPE_OPERATE;
        //List<FlagCategory> flagCategories = getManualTypeFlags(30);
        String manualTypes = manualTypeToJSONString(seMnlTypeConfig);
        request.setAttribute("manualTypes", manualTypes);
        
        Map<String, String> indexPathData = getGemPathFilterData(httpSession, publishId, regionId);
        String indexpathJsonData = indexpathToJSONString(indexPathData);
        request.setAttribute("indexpathJsonData", indexpathJsonData);
        
        int gridWidht = 940;
        request.setAttribute("gridWidht", gridWidht);

        boolean showMaximize = ParamUtil.getBoolean(request, "showMaximize", true);
        request.setAttribute("showMaximize", showMaximize);
        
        Map<String, String> bktSeverityCatgyCnts = GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyCounts(seTemplateId);
        request.setAttribute("bktSeverityCatgyCnts", bktSeverityCatgyCnts);
        Map<String, String> gemBktSeverityCatgyTotalCounts = GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyTotalCounts(seTemplateId);
        request.setAttribute("gemBktSeverityCatgyTotalCounts", gemBktSeverityCatgyTotalCounts);
        
        setNonCompliantQtyForHeader(request, bucket, severity, gemBktSeverityCatgyTotalCounts);
        
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/html/GEM/qualitylead/gemGrid.jsp");
        // rd.include(request, response);
        rd.forward(request, response);
    }

    private void setNonCompliantQtyForHeader(HttpServletRequest request, List<GEMManagementBucket> bucket,
            List<GEMSeverity> severity, Map<String, String> gemBktSeverityCatgyTotalCounts)
    {
    	StringBuilder strBuilder = new StringBuilder();
    
        if (gemBktSeverityCatgyTotalCounts != null && !gemBktSeverityCatgyTotalCounts.isEmpty())
        {
        	int indx = 1;
        	
            for (GEMManagementBucket bkt : bucket)
            {
            	strBuilder.append(HtmlUtil.escape(bkt.getBucketName()));
            	for (GEMSeverity sev : severity)
                {
                    String key = bkt.getBucketId() + "_" + sev.getSeverityId() + "_nonComplQty";
                    String val = gemBktSeverityCatgyTotalCounts.get(key);

                        if ("Important".equals(sev.getSeverityName()))
                        {
                        	strBuilder.append(": I:"+val);
                        	
                        }
                        else if ("Critical".equals(sev.getSeverityName()))
                        {
                        	strBuilder.append(": C:"+val);
                             
                        }
                        else if ("Auto Fail".equals(sev.getSeverityName()))
                        {
                        	strBuilder.append(": A:"+val);
                        	
                        }  
                }
            	if(indx != bucket.size()){
            		strBuilder.append(" | ");
                }
            	
            	indx++;
            }
            
            
        }
        else
        {
        	  int indx =1;
              for (GEMManagementBucket bkt : bucket)
              {
              	strBuilder.append(HtmlUtil.escape(bkt.getBucketName()));
              	strBuilder.append(": I: C: A: ");
                 if(indx != bucket.size()){
              	   strBuilder.append(" | ");
                 }
                 indx++;
              }
           
        }
        
        request.setAttribute("scoringHeader", strBuilder.toString());
    }
    
    /**
     * @param request This is an HttpServletRequest Object
     * @param response This is an HttpServletResponse Object
     * @throws IOException throws IOException
     * @throws ServletException 
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        doGet(request, response);
    }

    protected List<GEMMeasurement> getMeasurement(long templateId)
    {
        List<GEMMeasurement> measurCatgy;
        
        try
        {
            measurCatgy = GEMMeasurementLocalServiceUtil.getByTemplateId(templateId);
        }
        catch (SystemException e)
        {
            LOG.error("Failed to fetch Measurement Categories", e);
            measurCatgy = new ArrayList<GEMMeasurement>();
        }
        
        return measurCatgy;
    }
    
    protected List<GEMMeasurement> getSeverityCategoryType(List<GEMMeasurement> measurements)
    {
        String type = "SEVERITY";
        String type_other = "SEVERITY_OTHER";
        String type_trigger = "SEVERITY_TRIGGET";
        String type_cmply = "SEVERITY_CMPL_DT";
        List<GEMMeasurement> catgy = new ArrayList<GEMMeasurement>();

        for (GEMMeasurement item : measurements)
        {
            if (type_other.equals(item.getMeasurementType()))
            {
                catgy.add(item);
                break;
            }
        }

        for (GEMMeasurement item : measurements)
        {
            if (type.equals(item.getMeasurementType()))
            {
                catgy.add(item);
            }
        }

        for (GEMMeasurement item : measurements)
        {
            if (type_trigger.equals(item.getMeasurementType()))
            {
                catgy.add(item);
                break;
            }
        }

        for (GEMMeasurement item : measurements)
        {
            if (type_cmply.equals(item.getMeasurementType()))
            {
                catgy.add(item);
                break;
            }
        }
        return catgy;
    }

    protected List<GEMMeasurement> getMeasurementCategoryType(List<GEMMeasurement> measurements)
    {
        String type = "SEVERITY";
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

    protected List<GEMManagementBucket> getManagementBucket(long gemDepartmentId)
    {
        List<GEMManagementBucket> buckets = new ArrayList<GEMManagementBucket>();
        
        try
        {
            buckets = GEMManagementBucketLocalServiceUtil.getByDepartmentId(gemDepartmentId);
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
    protected String getDefaultScoringHeader(List<GEMManagementBucket> buckets)
    {
        StringBuilder strBuilder = new StringBuilder();
        int indx =1;
        strBuilder.append("To Fail Audit... ");
        for (GEMManagementBucket bkt : buckets)
        {
        	strBuilder.append(HtmlUtil.escape(bkt.getBucketName()));
        	strBuilder.append(": I: C: A: ");
           if(indx != buckets.size()){
        	   strBuilder.append(" | ");
           }
           indx++;
        }
        return strBuilder.toString();
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
            jsonObject.put("critNm", item.getSeverityId() > 0 ? item.getSeverityName() : "");
            array.put(jsonObject);
        }
       
        return array.toString();
    }
    
    /*private List<FlagCategory> getManualTypeFlags(long prntFlagCatgyId)
    {
    	List<FlagCategory> flagCategories = new ArrayList<FlagCategory>();
    	try {
    		flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(prntFlagCatgyId);
    	} catch(Exception e) {
    		LOG.error("Failed to get Manual Type Flag Categories", e);
    	}
        return flagCategories; 
    }*/
    
    protected String manualTypeToJSONString(String seMnlTypeConfig)
    {
    	JSONArray array = JSONFactoryUtil.createJSONArray();
        if (GemConstants.MANUAL_TYPE_FULL_BUILD_OPERATE.equals(seMnlTypeConfig)) {
        	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("mnlTypeId", "257, 258");
            jsonObject.put("mnlTypeNm", "Build & Operate");
            array.put(jsonObject);
            
            jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("mnlTypeId", "257");
            jsonObject.put("mnlTypeNm", "Build");
            array.put(jsonObject);
            
            jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("mnlTypeId", "258");
            jsonObject.put("mnlTypeNm", "Operate");
            array.put(jsonObject);
        } else if (GemConstants.MANUAL_TYPE_BUILD.equals(seMnlTypeConfig)) {
        	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("mnlTypeId", "257");
            jsonObject.put("mnlTypeNm", "Build");
            array.put(jsonObject);
        } else if(GemConstants.MANUAL_TYPE_OPERATE.equals(seMnlTypeConfig)) {
        	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("mnlTypeId", "258");
            jsonObject.put("mnlTypeNm", "Operate");
            array.put(jsonObject);
        }
       
        return array.toString();
    }
    
    @SuppressWarnings("unchecked")
	private Map<String, String> getGemPathFilterData(HttpSession httpSession, long gemPublishId, long regionId){
    	Map<String, String> indexPathData = new LinkedHashMap<String, String>();
    	StringBuilder scopedVar = new StringBuilder("GEMPubId_");
    	scopedVar.append(gemPublishId).append("_rgnId_").append(regionId).append("_IndexPathData");
        if(httpSession.getAttribute(scopedVar.toString()) != null){
        	indexPathData = (Map<String, String>)httpSession.getAttribute(scopedVar.toString());
        } else {
        	indexPathData = GEMQlReportLocalServiceUtil.getGemPathFilterData(GemQueryUtils.getGemPathFilterData(gemPublishId, regionId));
        	httpSession.setAttribute(scopedVar.toString(), indexPathData);
        }
        return indexPathData;
    }
    
    protected String indexpathToJSONString(Map<String, String> indexPathEntries)
    {
    	JSONArray array = JSONFactoryUtil.createJSONArray();
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("indexId", "");
        jsonObject.put("indexPath", "All");
        array.put(jsonObject);
        for (Map.Entry<String, String> item : indexPathEntries.entrySet())
        {
            jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("indexId", item.getKey());
            jsonObject.put("indexPath", item.getValue());
            array.put(jsonObject);
        }
       
        return array.toString();
    }

    protected Map<Long, String> getScoringCategoryHeadings(long templateId)
    {
        return GEMCategoryLocalServiceUtil.getScoringSECategories(templateId);
    }

    protected String scoringCategoryHeadingsToJSONString(Map<Long, String> categories)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        
        for (Map.Entry<Long, String> catgy : categories.entrySet())
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("catgyHead", catgy.getKey());
            jsonObject.put("catgyHeadNm", HtmlUtil.escape(catgy.getValue()));
            array.put(jsonObject);
        }
        return array.toString();
    }
    
    protected Map<Long, String> getCategoryHeadings(long seTemplateId, long saTemplateId)
    {
        return GEMCategoryLocalServiceUtil.getQLFormSAAndSECategories(seTemplateId+StringPool.COMMA+saTemplateId);
    }

    protected String categoryHeadingsToJSONString(Map<Long, String> categories)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        
        for (Map.Entry<Long, String> catgy : categories.entrySet())
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("catgyHead", catgy.getKey());
            jsonObject.put("catgyHeadNm", HtmlUtil.escape(catgy.getValue()));
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

    protected List<GEMTrigger> getQuestions(long publishId)
    {
        List<GEMTrigger> questions;
        try
        {
            questions = GEMTriggerLocalServiceUtil.getByPublishId(publishId);
        }
        catch (SystemException e)
        {
            questions = new ArrayList<GEMTrigger>();
        }
        
        return questions; 
    }    

    protected String questionsToJSONString(List<GEMTrigger> questions)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put("question", 0);
        jsonObject.put("questionNm", "Not Required");
        array.put(jsonObject);

        for (GEMTrigger item : questions)
        {
            jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("question", item.getTriggerId());
            jsonObject.put("questionNm", item.getQuestion());
            array.put(jsonObject);
        }
        return array.toString();
    }    

    protected List<GEMCode> getCompliantDuration()
    {
        List<GEMCode> codes;
        try
        {
            codes = GEMCodeLocalServiceUtil.getGEMCodes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        }
        catch (SystemException e)
        {
            LOG.error("Failed to fetch GEM Due Date Codes", e);
            codes = new ArrayList<GEMCode>();
        }
        
        return codes;
    }

    protected String compliantDurationToJSONString(List<GEMCode> codes)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        for (GEMCode cd : codes)
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("complDue", cd.getCode());
            jsonObject.put("complDueNm", cd.getCodeDesc());
            array.put(jsonObject);
        }        
        return array.toString();
    }

    private List<String> getStdOwners(long publishId, long regionId, String regionCd)
    {
        return GEMQlReportLocalServiceUtil.getStdOwners(publishId, regionId, regionCd);
    }
    
    private String getStdOwnersToJSONString(List<String> stdOwners)
    {
        JSONArray array = JSONFactoryUtil.createJSONArray();
        for (String owner : stdOwners)
        {
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            jsonObject.put("stdBusOwner", HtmlUtil.escape(owner));
            jsonObject.put("stdBusOwnerNm", HtmlUtil.escape(owner));
            array.put(jsonObject);
        }        
        return array.toString(); 
    }
}
