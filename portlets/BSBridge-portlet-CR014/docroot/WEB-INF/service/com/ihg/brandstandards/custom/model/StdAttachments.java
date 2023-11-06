/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.custom.model;

/**
 * 
 * @author chintan.akhani
 * 
 */
public class StdAttachments
{
    private String attachmentName;
    private String attachmentLink;
    private String attachmentStatus;
    private long attachmentId;
    private String attachmentType;
    private String attachmentExt;
    private long standardId;
    private long dlFileEntryId;
    private long fileSize;
    private long attachmentParentId;
    private String locale;

    /**
     * 
     * @return String
     */
    public String getLocale()
    {
        return locale;
    }

    /**
     * 
     * @param locale This is a String object
     */
    public void setLocale(String locale)
    {
        this.locale = locale;
    }

    /**
     * 
     * @return long
     */
    public long getAttachmentParentId()
    {
        return attachmentParentId;
    }

    /**
     * 
     * @param attachmentParentId This is a long object
     */
    public void setAttachmentParentId(long attachmentParentId)
    {
        this.attachmentParentId = attachmentParentId;
    }

    /**
     * 
     * @return long
     */
    public long getFileSize()
    {
        return fileSize;
    }

    /**
     * 
     * @param fileSize This is a long object
     */
    public void setFileSize(long fileSize)
    {
        this.fileSize = fileSize;
    }

    /**
     * 
     * @return long
     */
    public long getDlFileEntryId()
    {
        return dlFileEntryId;
    }

    /**
     * 
     * @param dlFileEntryId This is a long object
     */
    public void setDlFileEntryId(long dlFileEntryId)
    {
        this.dlFileEntryId = dlFileEntryId;
    }

    /**
     * 
     * @return long
     */
    public long getStandardId()
    {
        return standardId;
    }

    /**
     * 
     * @param standardId This is a long object
     */
    public void setStandardId(long standardId)
    {
        this.standardId = standardId;
    }

    /**
     * 
     * @return String
     */
    public String getAttachmentType()
    {
        return attachmentType;
    }

    /**
     * 
     * @param attachmentType This is a String object
     */
    public void setAttachmentType(String attachmentType)
    {
        this.attachmentType = attachmentType;
    }

    /**
     * 
     * @return String
     */
    public String getAttachmentExt()
    {
        return attachmentExt;
    }

    /**
     * 
     * @param attachmentExt This is a String object
     */
    public void setAttachmentExt(String attachmentExt)
    {
        this.attachmentExt = attachmentExt;
    }

    /**
     * 
     * @return String
     */
    public String getAttachmentName()
    {
        return attachmentName;
    }

    /**
     * 
     * @param attachmentName This is a String object
     */
    public void setAttachmentName(String attachmentName)
    {
        this.attachmentName = attachmentName;
    }

    /**
     * 
     * @return String
     */
    public String getAttachmentLink()
    {
        return attachmentLink;
    }

    /**
     * 
     * @param attachmentLink This is a String object
     */
    public void setAttachmentLink(String attachmentLink)
    {
        this.attachmentLink = attachmentLink;
    }

    /**
     * 
     * @return String
     */
    public String getAttachmentStatus()
    {
        return attachmentStatus;
    }

    /**
     * 
     * @param attachmentStatus This is a String object
     */
    public void setAttachmentStatus(String attachmentStatus)
    {
        this.attachmentStatus = attachmentStatus;
    }

    /**
     * 
     * @return long
     */
    public long getAttachmentId()
    {
        return attachmentId;
    }

    /**
     * 
     * @param attachmentId This is a long object
     */
    public void setAttachmentId(long attachmentId)
    {
        this.attachmentId = attachmentId;
    }
}
