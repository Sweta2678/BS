package com.ihg.brandstandards.custom.gem.model;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class QualityLeadModel extends BaseGemModel
{
    private long id;
    private long stdId;
    private long parentStdId;
    private long publishId;
    private String chainCode;
    
    // Reporting Category is Bucket - seReportingCatgyDesc;
    private long bucketId;
    private String bucketDesc; 
    // Criticality
    private long severityId;
    private String severityDesc;
    private long measurementId;
    private String measurementDesc;
    // Trigger Question
    private long triggerId;
    private String triggerDesc;
    // Category Heading
    private long categoryId;
    private String categoryDesc;
    
    private long complDueId;
    private String complDueDesc;

    private long displayOrder;
    
    private String globalOrRegional;
    private String regionCd;
    private long indexId;
    private long indexPrntId;
    private long indexLevel;
    private long indexHerarchyLevel;
    private String indexPath;
    private String indexTitle;
    
    private String stdStatus;
    private String stdStatusDesc;
    
    private String stdType;
    private String stdTitle;
    private String stdCategory;
    private String stdOwner;
    private String cmplyRuleDate;
    
    private String existingFixedCd;
    private String seSquence;
    private long catgyDisplayOrder;
    private String userId;
    
    private int inPublication;
    private long indexOrder;
    private String globalMust = "N";
    private String stdManualType;
    
    private List<QualityLeadModel> specifications;
    private List<QualityLeadModel> guidelines;
    
    public QualityLeadModel()
    {
    }

    public QualityLeadModel(JSONObject jsonObject)
    {
        fromJSON(jsonObject);
    }
    
    public JSONObject toJSON()
    {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        
        jsonObject.put("id", id);
        jsonObject.put("publishId", publishId);
        jsonObject.put("isChanged", 0);
        jsonObject.put("glblRgn", globalOrRegional);
        jsonObject.put("glblMust", globalMust);
        jsonObject.put("path", indexPath);
        jsonObject.put("stdId", stdId);
        jsonObject.put("prntStdId", parentStdId);
        jsonObject.put("stdType", stdType);
        jsonObject.put("title", stdTitle);
        jsonObject.put("catgy", stdCategory);
        jsonObject.put("stdOwner", stdOwner);
        jsonObject.put("cmply", cmplyRuleDate);
        jsonObject.put("existFixed", existingFixedCd);
        jsonObject.put("seRptCatgy", bucketId);
        jsonObject.put("seRptCatgyNm", bucketDesc);
        jsonObject.put("crit", severityId);
        jsonObject.put("critNm", severityDesc);
        jsonObject.put("catgyHead", categoryId);
        jsonObject.put("catgyHeadNm", categoryDesc);
        jsonObject.put("seSeqNo", seSquence);
        jsonObject.put("question", triggerId);
        jsonObject.put("questionNm", triggerDesc);
        jsonObject.put("complDue", complDueId);
        jsonObject.put("complDueNm", complDueDesc);
        jsonObject.put("inPublication", inPublication);
        jsonObject.put("stdStatus", stdStatus);
        jsonObject.put("mnlType", stdManualType);        
        
        return jsonObject;
    }
    
    public JSONObject copyToBrandJSON(){
    	JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
    	
    	jsonObject.put("id", id);
    	jsonObject.put("chainCd", chainCode);
    	jsonObject.put("stdId", stdId);
    	jsonObject.put("catgyHead", categoryId);
    	jsonObject.put("catgyHeadNm", categoryDesc);
    	jsonObject.put("seRptCatgy", bucketId);
    	jsonObject.put("seRptCatgyNm", bucketDesc);
    	jsonObject.put("crit", severityId);
        jsonObject.put("critNm", severityDesc);
        
    	return jsonObject;
    }
    
    public static QualityLeadModel fromCopyToBrandJSON(JSONObject jsonObject){
    	QualityLeadModel qualityLeadModel = new QualityLeadModel();
    	
    	qualityLeadModel.setId(jsonObject.getLong("id"));
    	qualityLeadModel.setCategoryId(jsonObject.getLong("catgyHead"));
    	qualityLeadModel.setCategoryDesc(jsonObject.getString("categoryDesc"));
    	qualityLeadModel.setBucketId(jsonObject.getLong("seRptCatgy"));
    	qualityLeadModel.setBucketDesc(jsonObject.getString("seRptCatgyNm"));
    	qualityLeadModel.setSeverityId(jsonObject.getLong("crit"));
    	qualityLeadModel.setSeverityDesc(jsonObject.getString("critNm"));
    	
    	return qualityLeadModel;
    }

    public void fromJSON(JSONObject jsonObject)
    {
        id = jsonObject.getLong("id", 0L);
        publishId = jsonObject.getLong("publishId", 0L);
        globalOrRegional = jsonObject.getString("glblRgn");
        globalMust = jsonObject.getString("glblMust");
        indexPath = jsonObject.getString("path");
        stdId = jsonObject.getLong("stdId", 0L);
        parentStdId = jsonObject.getLong("prntStdId", 0L);
        stdType = jsonObject.getString("stdType");
        stdTitle = jsonObject.getString("title");
        stdCategory = jsonObject.getString("catgy");
        stdOwner = jsonObject.getString("stdOwner");
        cmplyRuleDate = jsonObject.getString("cmply");
        existingFixedCd = jsonObject.getString("existFixed");
        bucketId = jsonObject.getLong("seRptCatgy", 0L);
        bucketDesc = jsonObject.getString("seRptCatgyNm");
        severityId = jsonObject.getLong("crit", 0L);
        severityDesc = jsonObject.getString("critNm");
        categoryId = jsonObject.getLong("catgyHead", 0L);
        categoryDesc = jsonObject.getString("catgyHeadNm");
        seSquence = jsonObject.getString("seSeqNo");
        triggerId = jsonObject.getLong("question", 0L);
        triggerDesc = jsonObject.getString("questionNm");
        complDueId = jsonObject.getLong("complDue", 0L);
        complDueDesc = jsonObject.getString("complDueNm");
        inPublication = jsonObject.getInt("inPublication", 0);
        measurementDesc = jsonObject.getString("measurementDesc");
        stdStatus = jsonObject.getString("stdStatus");
        stdManualType = jsonObject.getString("mnlType");
    }

    public long getId()
    {
        return id;
    }
    
    public void setId(long id)
    {
        this.id = id;
    }
    
    public long getStdId()
    {
        return stdId;
    }
    
    public void setStdId(long stdId)
    {
        this.stdId = stdId;
    }
    
    public long getBucketId()
    {
        return bucketId;
    }
    
    public void setBucketId(long bucketId)
    {
        this.bucketId = bucketId;
    }
    
    public String getBucketDesc()
    {
        return bucketDesc;
    }
    
    public void setBucketDesc(String bucketDesc)
    {
        this.bucketDesc = bucketDesc;
    }
    
    public long getSeverityId()
    {
        return severityId;
    }
    
    public void setSeverityId(long severityId)
    {
        this.severityId = severityId;
    }
    
    public String getSeverityDesc()
    {
        return severityDesc;
    }
    
    public void setSeverityDesc(String severityDesc)
    {
        this.severityDesc = severityDesc;
    }
    
    public long getMeasurementId()
    {
        return measurementId;
    }
    
    public void setMeasurementId(long measurementId)
    {
        this.measurementId = measurementId;
    }
    
    public long getTriggerId()
    {
        return triggerId;
    }
    
    public void setTriggerId(long triggerId)
    {
        this.triggerId = triggerId;
    }
    
    public String getTriggerDesc()
    {
        return triggerDesc;
    }
    
    public void setTriggerDesc(String triggerDesc)
    {
        this.triggerDesc = triggerDesc;
    }
    
    public long getCategoryId()
    {
        return categoryId;
    }
    
    public void setCategoryId(long categoryId)
    {
        this.categoryId = categoryId;
    }
    
    public String getCategoryDesc()
    {
        return categoryDesc;
    }
    
    public void setCategoryDesc(String categoryDesc)
    {
        this.categoryDesc = categoryDesc;
    }
    
    public long getDisplayOrder()
    {
        return displayOrder;
    }
    
    public void setDisplayOrder(long displayOrder)
    {
        this.displayOrder = displayOrder;
    }

    public boolean isGlobal()
    {
        return globalOrRegional.equals("Global") || globalOrRegional.equals("Multi Regional") ;
    }
    
    public String getGlobalOrRegional()
    {
        return globalOrRegional;
    }
    
    public void setGlobalOrRegional(String globalOrRegional)
    {
        this.globalOrRegional = globalOrRegional;
    }
    
    public String getRegionCd()
    {
        return regionCd;
    }
    
    public void setRegionCd(String regionCd)
    {
        this.regionCd = regionCd;
    }
    
    public String getIndexPath()
    {
        return indexPath;
    }
    
    public void setIndexPath(String indexPath)
    {
        this.indexPath = indexPath;
    }
    
    public String getStdType()
    {
        return stdType;
    }
    
    public void setStdType(String stdType)
    {
        this.stdType = stdType;
    }
    
    public String getStdTitle()
    {
        return stdTitle;
    }
    
    public void setStdTitle(String stdTitle)
    {
        this.stdTitle = stdTitle;
    }
    
    public String getStdCategory()
    {
        return stdCategory;
    }
    
    public void setStdCategory(String stdCategory)
    {
        this.stdCategory = stdCategory;
    }
    
    public String getStdOwner()
    {
        return stdOwner;
    }
    
    public void setStdOwner(String stdOwner)
    {
        this.stdOwner = stdOwner;
    }
    
    public String getCmplyRuleDate()
    {
        return cmplyRuleDate;
    }
    
    public void setCmplyRuleDate(String cmplyRuleDate)
    {
        this.cmplyRuleDate = cmplyRuleDate;
    }
    
    public String getExistingFixedCd()
    {
        return existingFixedCd;
    }
    
    public void setExistingFixedCd(String existingFixedCd)
    {
        this.existingFixedCd = existingFixedCd;
    }
    
    public String getSeSquence()
    {
        return seSquence;
    }
    
    public void setSeSquence(String seSquence)
    {
        this.seSquence = seSquence;
    }

    public long getComplDueId()
    {
        return complDueId;
    }

    public void setComplDueId(long complDueId)
    {
        this.complDueId = complDueId;
    }

    public String getComplDueDesc()
    {
        return complDueDesc;
    }

    public void setComplDueDesc(String complDueDesc)
    {
        this.complDueDesc = complDueDesc;
    }

    public boolean isInPublication()
    {
        return inPublication > 0;
    }

    public int getInPublication()
    {
        return inPublication;
    }

    public void setInPublication(int inPublication)
    {
        this.inPublication = inPublication;
    }

    public long getPublishId()
    {
        return publishId;
    }

    public void setPublishId(long publishId)
    {
        this.publishId = publishId;
    }

    public String getMeasurementDesc()
    {
        return measurementDesc;
    }

    public void setMeasurementDesc(String measurementDesc)
    {
        this.measurementDesc = measurementDesc;
    }

    public long getIndexId()
    {
        return indexId;
    }

    public void setIndexId(long indexId)
    {
        this.indexId = indexId;
    }

    public long getIndexPrntId()
    {
        return indexPrntId;
    }

    public void setIndexPrntId(long indexPrntId)
    {
        this.indexPrntId = indexPrntId;
    }

    public long getIndexLevel()
    {
        return indexLevel;
    }

    public void setIndexLevel(long indexLevel)
    {
        this.indexLevel = indexLevel;
    }

    public long getIndexHerarchyLevel()
    {
        return indexHerarchyLevel;
    }

    public void setIndexHerarchyLevel(long indexHerarchyLevel)
    {
        this.indexHerarchyLevel = indexHerarchyLevel;
    }

    public String getIndexTitle()
    {
        return indexTitle;
    }

    public void setIndexTitle(String indexTitle)
    {
        this.indexTitle = indexTitle;
    }

    public String getStdStatus()
    {
        return stdStatus;
    }

    public void setStdStatus(String stdStatus)
    {
        this.stdStatus = stdStatus;
    }

    public String getStdStatusDesc()
    {
        return stdStatusDesc;
    }

    public void setStdStatusDesc(String stdStatusDesc)
    {
        this.stdStatusDesc = stdStatusDesc;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public long getIndexOrder()
    {
        return indexOrder;
    }

    public void setIndexOrder(long indexOrder)
    {
        this.indexOrder = indexOrder;
    }

    public List<QualityLeadModel> getSpecifications()
    {
        if (specifications == null)
        {
            specifications = new ArrayList<QualityLeadModel>();
        }
        return specifications;
    }

    public void setSpecifications(List<QualityLeadModel> specifications)
    {
        this.specifications = specifications;
    }

    public List<QualityLeadModel> getGuidelines()
    {
        if (guidelines == null)
        {
            guidelines = new ArrayList<QualityLeadModel>();
        }
        return guidelines;
    }

    public void setGuidelines(List<QualityLeadModel> guidelines)
    {
        this.guidelines = guidelines;
    }

    public long getParentStdId()
    {
        return parentStdId;
    }

    public void setParentStdId(long parentStdId)
    {
        this.parentStdId = parentStdId;
    }

	public long getCatgyDisplayOrder() {
		return catgyDisplayOrder;
	}

	public void setCatgyDisplayOrder(long catgyDisplayOrder) {
		this.catgyDisplayOrder = catgyDisplayOrder;
	}

    public String getGlobalMust()
    {
        return globalMust;
    }

    public void setGlobalMust(String globalMust)
    {
        this.globalMust = globalMust;
    }

	public String getStdManualType() {
		return stdManualType;
	}

	public void setStdManualType(String stdManualType) {
		this.stdManualType = stdManualType;
	}

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}	
}
