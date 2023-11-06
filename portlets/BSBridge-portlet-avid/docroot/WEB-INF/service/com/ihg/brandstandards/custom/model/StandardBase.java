package com.ihg.brandstandards.custom.model;

import java.io.Serializable;
import java.util.Date;

import com.liferay.portal.kernel.util.StringPool;


public class StandardBase implements Serializable
{
    private long stdId;
    private long parentStdId;
    private long publishStdId;
    private String stdType;
    private long displayOrder;
    private String title;
    private String stdTitleXlat;
    private String currentTitle;
    private String description;
    private String waiver;
    
    private long taxonomyId;
    private long parentTaxonomyId;
    private long indexOrder;
    private long indexSortOrder;
    private String taxonomyText;
    private String indexTitleXlat;
	private String taxonomyDesc;
    private String indexDescXlat;
    private String taxonomyPath;
    private String currentPath;
    private long level;
    
    private String status;
    private String regionCode;
    private String framework;
    private String isGlobal;
    
    private boolean textTranslated;
    private boolean imagesTranslated;
    private boolean attchmentsTranslated;
    private boolean linksTranslated;
    
    private boolean isTextUpdated;
    private boolean isComplianceUpdated;
    private boolean isLifecycleUpdated;
    private String changedStatus;
    
    
    private long publishId;
    private Date publishDate;
    
    private String amer;
    private String amea;
    private String euro;
    private String gc;
    private String chieldIds = StringPool.BLANK;

    private Date complDate;
    private String complDateStr;
    private String expiredStdId;
    private String category;
    private String manual;
    private String imageList;
    private String imageListXlat;
    private String linkList;
    private String linkListXlat;
    private String attachmentList;
    private String attachmentListXlat;
    
    public StandardBase()
    {
    }
    
    /**
     * @return the stdId
     */
    public long getStdId()
    {
        return stdId;
    }
    /**
     * @param standardId the stdId to set
     */
    public void setStdId(long stdId)
    {
        this.stdId = stdId;
    }
    /**
     * @return the parentStdId
     */
    public long getParentStdId()
    {
        return parentStdId;
    }
    /**
     * @param parentStdId the parentStdId to set
     */
    public void setParentStdId(long parentStdId)
    {
        this.parentStdId = parentStdId;
    }
    
    /**
     * @return the publishStdId
     */
    public long getPublishStdId()
    {
        return publishStdId;
    }

    /**
     * @param publishStdId the publishStdId to set
     */
    public void setPublishStdId(long publishStdId)
    {
        this.publishStdId = publishStdId;
    }

    /**
     * @return the stdType
     */
    public String getStdType()
    {
        return stdType;
    }
    /**
     * @param stdType the stdType to set
     */
    public void setStdType(String stdType)
    {
        this.stdType = stdType;
    }
    /**
     * @return the displayOrder
     */
    public long getDisplayOrder()
    {
        return displayOrder;
    }
    /**
     * @param displayOrder the displayOrder to set
     */
    public void setDisplayOrder(long displayOrder)
    {
        this.displayOrder = displayOrder;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the currentTitle
     */
    public String getCurrentTitle()
    {
        return currentTitle;
    }

    /**
     * @param currentTitle the currentTitle to set
     */
    public void setCurrentTitle(String currentTitle)
    {
        this.currentTitle = currentTitle;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    /**
     * @return the waiver
     */
    public String getWaiver()
    {
        return waiver;
    }

    /**
     * @param waiver the waiver to set
     */
    public void setWaiver(String waiver)
    {
        this.waiver = waiver;
    }

    /**
     * @return long
     */
    public long getTaxonomyId()
    {
        return taxonomyId;
    }

    /**
     * @param taxonomyId This is a long object
     */
    public void setTaxonomyId(long taxonomyId)
    {
        this.taxonomyId = taxonomyId;
    }

    /**
     * @return long
     */
    public long getIndexOrder()
    {
        return indexOrder;
    }

    /**
     * @param indexOrder This is a long object
     */
    public void setIndexOrder(long indexOrder)
    {
        this.indexOrder = indexOrder;
    }

    /**
     * @return long
     */
    public long getParentTaxonomyId()
    {
        return parentTaxonomyId;
    }

    /**
     * @param parentTaxonomyId This is a long object
     */
    public void setParentTaxonomyId(long parentTaxonomyId)
    {
        this.parentTaxonomyId = parentTaxonomyId;
    }

    /**
     * @return long
     */
    public long getIndexSortOrder()
    {
        return indexSortOrder;
    }

    /**
     * @param indexSortOrder This is a long object type
     */
    public void setIndexSortOrder(long indexSortOrder)
    {
        this.indexSortOrder = indexSortOrder;
    }

    /**
     * @return String
     */
    public String getTaxonomyText()
    {
        return taxonomyText;
    }

    /**
     * @param taxonomyText This is a String object
     */
    public void setTaxonomyText(String taxonomyText)
    {
        this.taxonomyText = taxonomyText;
    }

    public String getTaxonomyDesc() {
		return taxonomyDesc;
	}

	public void setTaxonomyDesc(String taxonomyDesc) {
		this.taxonomyDesc = taxonomyDesc;
	}

    /**
     * @return String
     */
    public String getTaxonomyPath()
    {
        return taxonomyPath;
    }

    /**
     * 
     * @param taxonomyPath This is a String object
     */
    public void setTaxonomyPath(String taxonomyPath)
    {
        this.taxonomyPath = taxonomyPath;
    }

    /**
     * @return the currentPath
     */
    public String getCurrentPath()
    {
        return currentPath;
    }

    /**
     * @param currentPath the currentPath to set
     */
    public void setCurrentPath(String currentPath)
    {
        this.currentPath = currentPath;
    }

    /**
     * @return String
     */
    public long getLevel()
    {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(long level)
    {
        this.level = level;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the regionCode
     */
    public String getRegionCode()
    {
        return regionCode;
    }

    /**
     * @param regionCode the regionCode to set
     */
    public void setRegionCode(String regionCode)
    {
        this.regionCode = regionCode;
    }

    /**
     * @return the framework
     */
    public String getFramework()
    {
        return framework;
    }

    /**
     * @param framework the framework to set
     */
    public void setFramework(String framework)
    {
        this.framework = framework;
    }

    /**
     * @return the isGlobal
     */
    public String getIsGlobal()
    {
        return isGlobal;
    }

    /**
     * @param isGlobal the isGlobal to set
     */
    public void setIsGlobal(String isGlobal)
    {
        this.isGlobal = isGlobal;
    }

    /**
     * @return the textTranslated
     */
    public boolean isTextTranslated()
    {
        return textTranslated;
    }

    /**
     * @param textTranslated the textTranslated to set
     */
    public void setTextTranslated(boolean textTranslated)
    {
        this.textTranslated = textTranslated;
    }

    /**
     * @return the imagesTranslated
     */
    public boolean isImagesTranslated()
    {
        return imagesTranslated;
    }

    /**
     * @param imagesTranslated the imagesTranslated to set
     */
    public void setImagesTranslated(boolean imagesTranslated)
    {
        this.imagesTranslated = imagesTranslated;
    }

    /**
     * @return the attchmentsTranslated
     */
    public boolean isAttchmentsTranslated()
    {
        return attchmentsTranslated;
    }

    /**
     * @param attchmentsTranslated the attchmentsTranslated to set
     */
    public void setAttchmentsTranslated(boolean attchmentsTranslated)
    {
        this.attchmentsTranslated = attchmentsTranslated;
    }

    /**
     * @return the linksTranslated
     */
    public boolean isLinksTranslated()
    {
        return linksTranslated;
    }

    /**
     * @param linksTranslated the linksTranslated to set
     */
    public void setLinksTranslated(boolean linksTranslated)
    {
        this.linksTranslated = linksTranslated;
    }

    /**
     * @return the amer
     */
    public String getAmer()
    {
        return amer;
    }

    /**
     * @param amer the amer to set
     */
    public void setAmer(String amer)
    {
        this.amer = amer;
    }

    /**
     * @return the amea
     */
    public String getAmea()
    {
        return amea;
    }

    /**
     * @param amea the amea to set
     */
    public void setAmea(String amea)
    {
        this.amea = amea;
    }

    /**
     * @return the euro
     */
    public String getEuro()
    {
        return euro;
    }

    /**
     * @param euro the euro to set
     */
    public void setEuro(String euro)
    {
        this.euro = euro;
    }

    /**
     * @return the gc
     */
    public String getGc()
    {
        return gc;
    }

    /**
     * @param gc the gc to set
     */
    public void setGc(String gc)
    {
        this.gc = gc;
    }

    /**
     * @return the chieldIds
     */
    public String getChieldIds()
    {
        return chieldIds;
    }

    /**
     * @param chieldIds the chieldIds to set
     */
    public void setChieldIds(String chieldIds)
    {
        this.chieldIds = chieldIds;
    }

    /**
     * @return the publishId
     */
    public long getPublishId()
    {
        return publishId;
    }

    /**
     * @param publishId the publishId to set
     */
    public void setPublishId(long publishId)
    {
        this.publishId = publishId;
    }

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

    /**
     * @return the complDate
     */
    public Date getComplDate()
    {
        return complDate;
    }

    /**
     * @param complDate the complDate to set
     */
    public void setComplDate(Date complDate)
    {
        this.complDate = complDate;
    }

    /**
     * @return the complDateStr
     */
    public String getComplDateStr()
    {
        return complDateStr;
    }

    /**
     * @param complDateStr the complDateStr to set
     */
    public void setComplDateStr(String complDateStr)
    {
        this.complDateStr = complDateStr;
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

	public String getIndexTitleXlat() {
		return indexTitleXlat;
	}

	public void setIndexTitleXlat(String indexTitleXlat) {
		this.indexTitleXlat = indexTitleXlat;
	}

	public String getStdTitleXlat() {
		return stdTitleXlat;
	}

	public void setStdTitleXlat(String stdTitleXlat) {
		this.stdTitleXlat = stdTitleXlat;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}

	public String getIndexDescXlat() {
		return indexDescXlat;
	}

	public void setIndexDescXlat(String indexDescXlat) {
		this.indexDescXlat = indexDescXlat;
	}

	public String getImageList() {
		return imageList;
	}

	public void setImageList(String imageList) {
		this.imageList = imageList;
	}

	public String getImageListXlat() {
		return imageListXlat;
	}

	public void setImageListXlat(String imageListXlat) {
		this.imageListXlat = imageListXlat;
	}

	public String getLinkList() {
		return linkList;
	}

	public void setLinkList(String linkList) {
		this.linkList = linkList;
	}

	public String getLinkListXlat() {
		return linkListXlat;
	}

	public void setLinkListXlat(String linkListXlat) {
		this.linkListXlat = linkListXlat;
	}

	public String getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(String attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getAttachmentListXlat() {
		return attachmentListXlat;
	}

	public void setAttachmentListXlat(String attachmentListXlat) {
		this.attachmentListXlat = attachmentListXlat;
	}

	
	public boolean isTextUpdated() {
		return isTextUpdated;
	}

	
	public void setTextUpdated(boolean isTextUpdated) {
		this.isTextUpdated = isTextUpdated;
	}

	
	public boolean isComplianceUpdated() {
		return isComplianceUpdated;
	}

	
	public void setComplianceUpdated(boolean isComplianceUpdated) {
		this.isComplianceUpdated = isComplianceUpdated;
	}

	
	public boolean isLifecycleUpdated() {
		return isLifecycleUpdated;
	}

	
	public void setLifecycleUpdated(boolean isLifecycleUpdated) {
		this.isLifecycleUpdated = isLifecycleUpdated;
	}

	public String getChangedStatus() {
		return changedStatus;
	}

	public void setChangedStatus(String changedStatus) {
		this.changedStatus = changedStatus;
	}

}
