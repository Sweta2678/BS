/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.custom.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="Standard.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author chintan.akhani
 */
/**
 * @author cignex
 *
 */
public class Standard extends StandardBase
{
    private long origTaxonomyId;
    private long pubParentStdId;
    
    private String prevTitleText;
    private String prevDescription;
    private String prevFlagStdId;
    private String titleChange;
    private String cmplyChange;
    private String exprChange;
    private String hlcChange;
    private String changedStatus;
    private String effectiveDate;
    private String complianceDate;
    private Date compDate;
    private Date prevCmplyDate;
    private String prevCmplDateStr;
    private Date prevExpiryDate;
    private String prevExpiryDateStr;
    
    private String attachmentStatus;
    private String linkStatus;
    private String imageStatus;
    
    private boolean attachmentExists;
    private boolean linkExists;
    private boolean imageExists;
    private boolean searchMatches;
    
    private String matchedId;
    private String expiryDate;
    private String stdRefId;
    
    private List<Standard> specifications;
    private List<Standard> guidelines;
    private Map<Long, String> hotelLifeCycleFlags;
    private Map<Long, String> prevHotelLifeCycleFlags;
    private Map<String, List<StdAttachments>> attachments;
    private List<ExternalLinks> externalLinks;
    private List<StdImage> images;
    private String expiredStdId;
    /** This will hold the additional metadata of a standard like Std title, Std desc, link, image, attachment translations */
    private Map<String, String> metadata;
    private boolean isMustPublish;
    private String curRegion;
    private boolean isRemovable;
    private String errorType;
    
    public Standard()
    {
    }

    /**
     * 
     * @return long
     */
    public String getStdRefId()
    {
        return stdRefId;
    }

    /**
     * 
     * @param stdRefId This is a String object
     */
    public void setStdRefId(String stdRefId)
    {
        this.stdRefId = stdRefId;
    }

    /**
     * @return String
     */
    public String getPrevTitleText()
    {
        return prevTitleText;
    }

    /**
     * @param prevTitleText This is a String object
     */
    public void setPrevTitleText(String prevTitleText)
    {
        this.prevTitleText = prevTitleText;
    }

    /**
     * @return String
     */
    public String getPrevDescription()
    {
        return prevDescription;
    }

    /**
     * @param prevDescription This is a String object
     */
    public void setPrevDescription(String prevDescription)
    {
        this.prevDescription = prevDescription;
    }

    /**
     * @return String
     */
    public String getEffectiveDate()
    {
        return effectiveDate;
    }

    /**
     * @param effectiveDate This is a String object
     */
    public void setEffectiveDate(String effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    /**
     * @return String
     */
    public String getComplianceDate()
    {
        return complianceDate;
    }

    /**
     * @param complianceDate This is a String object
     */
    public void setComplianceDate(String complianceDate)
    {
        this.complianceDate = complianceDate;
    }

    /**
     * @return long
     */
    public long getOrigTaxonomyId()
    {
        return origTaxonomyId;
    }

    /**
     * @param origTaxonomyId This is a long object
     */
    public void setOrigTaxonomyId(long origTaxonomyId)
    {
        this.origTaxonomyId = origTaxonomyId;
    }

    /**
     * @return long
     */
    public long getPubParentStdId()
    {
        return pubParentStdId;
    }

    /**
     * @param pubParentStdId This is a long object
     */
    public void setPubParentStdId(long pubParentStdId)
    {
        this.pubParentStdId = pubParentStdId;
    }

    /**
     * @return String
     */
    public String getAttachmentStatus()
    {
        return attachmentStatus;
    }

    /**
     * @param attachmentStatus This is a String object
     */
    public void setAttachmentStatus(String attachmentStatus)
    {
        this.attachmentStatus = attachmentStatus;
    }

    /**
     * @return String
     */
    public String getLinkStatus()
    {
        return linkStatus;
    }

    /**
     * @param linkStatus This is a String object
     */
    public void setLinkStatus(String linkStatus)
    {
        this.linkStatus = linkStatus;
    }

    /**
     * @return String
     */
    public String getImageStatus()
    {
        return imageStatus;
    }

    /**
     * @param imageStatus This is a String object
     */
    public void setImageStatus(String imageStatus)
    {
        this.imageStatus = imageStatus;
    }

    /**
     * @return boolean
     */
    public boolean isAttachmentExists()
    {
        return attachmentExists;
    }

    /**
     * @param attachmentExists This is a boolean object
     */
    public void setAttachmentExists(boolean attachmentExists)
    {
        this.attachmentExists = attachmentExists;
    }

    /**
     * @return boolean
     */
    public boolean isLinkExists()
    {
        return linkExists;
    }

    /**
     * @param linkExists This is a boolean object
     */
    public void setLinkExists(boolean linkExists)
    {
        this.linkExists = linkExists;
    }

    /**
     * @return boolean
     */
    public boolean isImageExists()
    {
        return imageExists;
    }

    /**
     * @param imageExists This is a boolean object
     */
    public void setImageExists(boolean imageExists)
    {
        this.imageExists = imageExists;
    }

    /**
     * @return String
     */
    public String getMatchedId()
    {
        return matchedId;
    }

    /**
     * @param matchedId This is a String object
     */
    public void setMatchedId(String matchedId)
    {
        this.matchedId = matchedId;
    }

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

    /**
     * @return the specifications
     */
    public List<Standard> getSpecifications()
    {
    	if(specifications == null){
    		specifications = new ArrayList<Standard>();
    	}
        return specifications;
    }

    /**
     * @param specifications the specifications to set
     */
    public void setSpecifications(List<Standard> specifications)
    {
        this.specifications = specifications;
    }

    /**
     * @return the guidelines
     */
    public List<Standard> getGuidelines()
    {
    	if(guidelines == null){
    		guidelines = new ArrayList<Standard>();
		}
        return guidelines;
    }

    /**
     * @param guidelines the guidelines to set
     */
    public void setGuidelines(List<Standard> guidelines)
    {
        this.guidelines = guidelines;
    }

	public Map<String, List<StdAttachments>> getAttachments() {
		return attachments;
	}

	public void setAttachments(Map<String, List<StdAttachments>> attachments) {
		this.attachments = attachments;
	}

	public List<ExternalLinks> getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(List<ExternalLinks> externalLinks) {
		this.externalLinks = externalLinks;
	}

	public List<StdImage> getImages() {
		return images;
	}

	public void setImages(List<StdImage> images) {
		this.images = images;
	}
	/**
     * @return the hotelLifeCycleFlags
     */
    public Map<Long, String> getHotelLifeCycleFlags() {
        if(hotelLifeCycleFlags == null){
            hotelLifeCycleFlags = new HashMap<Long, String>();
        }
        return hotelLifeCycleFlags;
    }

    /**
     * @param hotelLifeCycleFlags the hotelLifeCycleFlags to set
     */
    public void setHotelLifeCycleFlags(Map<Long, String> hotelLifeCycleFlags) {
        this.hotelLifeCycleFlags = hotelLifeCycleFlags;
    }

    /**
     * @return the expiredStdId
     */
    public String getExpiredStdId()
    {
        return expiredStdId;
    }

    /**
     * @param expiredStdId the expiredStdId to set
     */
    public void setExpiredStdId(String expiredStdId)
    {
        this.expiredStdId = expiredStdId;
    }

    /**
     * @return the complDate
     */
    public Date getCompDate()
    {
        return compDate;
    }

    /**
     * @param complDate the complDate to set
     */
    public void setCompDate(Date compDate)
    {
        this.compDate = compDate;
    }

	public Map<String, String> getMetadata() {
		if(metadata == null){
			metadata = new HashMap<String, String>();
        }
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	public boolean isMustPublish() {
		return isMustPublish;
	}

	public void setMustPublish(boolean isMustPublish) {
		this.isMustPublish = isMustPublish;
	}

    public String getCurRegion()
    {
        return curRegion;
    }

    public void setCurRegion(String curRegion)
    {
        this.curRegion = curRegion;
    }

	public boolean isSearchMatches() {
		return searchMatches;
	}
	
	public void setSearchMatches(boolean searchMatches) {
		this.searchMatches = searchMatches;
	}

	public boolean isRemovable() {
		return isRemovable;
	}

	public void setRemovable(boolean isRemovable) {
		this.isRemovable = isRemovable;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	public String getPrevFlagStdId() {
		return prevFlagStdId;
	}

	public void setPrevFlagStdId(String prevFlagStdId) {
		this.prevFlagStdId = prevFlagStdId;
	}

	public String getTitleChange() {
		return titleChange;
	}

	public void setTitleChange(String titleChange) {
		this.titleChange = titleChange;
	}

	public String getCmplyChange() {
		return cmplyChange;
	}

	public void setCmplyChange(String cmplyChange) {
		this.cmplyChange = cmplyChange;
	}

	public String getExprChange() {
		return exprChange;
	}

	public void setExprChange(String exprChange) {
		this.exprChange = exprChange;
	}

	public String getHlcChange() {
		return hlcChange;
	}

	public void setHlcChange(String hlcChange) {
		this.hlcChange = hlcChange;
	}

	public String getChangedStatus() {
		return changedStatus;
	}

	public void setChangedStatus(String changedStatus) {
		this.changedStatus = changedStatus;
	}

	public Date getPrevCmplyDate() {
		return prevCmplyDate;
	}

	public void setPrevCmplyDate(Date prevCmplyDate) {
		this.prevCmplyDate = prevCmplyDate;
	}

	public String getPrevCmplDateStr() {
		return prevCmplDateStr;
	}

	public void setPrevCmplDateStr(String prevCmplDateStr) {
		this.prevCmplDateStr = prevCmplDateStr;
	}

	public Date getPrevExpiryDate() {
		return prevExpiryDate;
	}

	public void setPrevExpiryDate(Date prevExpiryDate) {
		this.prevExpiryDate = prevExpiryDate;
	}

	public String getPrevExpiryDateStr() {
		return prevExpiryDateStr;
	}

	public void setPrevExpiryDateStr(String prevExpiryDateStr) {
		this.prevExpiryDateStr = prevExpiryDateStr;
	}

	public Map<Long, String> getPrevHotelLifeCycleFlags() {
		return prevHotelLifeCycleFlags;
	}

	public void setPrevHotelLifeCycleFlags(Map<Long, String> prevHotelLifeCycleFlags) {
		this.prevHotelLifeCycleFlags = prevHotelLifeCycleFlags;
	}
}
