/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.custom.model;

/**
 * 
 * @author chintan.akhani
 *
 */
public class StdImage
{
    private String imageTitle;
    private String imageURL;
    private String imageDescription;
    private String imageSize;
    private String imageStatus;
    private long imageId;
    private String uuid;
    private long groupId;
    private long imageParentId;
    private String locale;
    private long stdImageId;
    
    /**
     * 
     * @return long
     */
    public long getStdImageId()
    {
        return stdImageId;
    }
    /**
     * 
     * @param stdImageId This is a long object
     */
    public void setStdImageId(long stdImageId)
    {
        this.stdImageId = stdImageId;
    }
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
    public long getImageParentId()
    {
        return imageParentId;
    }
    /**
     * 
     * @param imageParentId This is a long object
     */
    public void setImageParentId(long imageParentId)
    {
        this.imageParentId = imageParentId;
    }
    /**
     * 
     * @return String
     */
    public String getImageStatus()
    {
        return imageStatus;
    }
    /**
     * 
     * @param imageStatus This is a String object
     */
    public void setImageStatus(String imageStatus)
    {
        this.imageStatus = imageStatus;
    }
    /**
     * 
     * @return String
     */
    public String getUuid()
    {
        return uuid;
    }
    /**
     * 
     * @param uuid This is a String object
     */
    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }
    /**
     * 
     * @return long
     */
    public long getGroupId()
    {
        return groupId;
    }
    /**
     * 
     * @param groupId This is a long object
     */
    public void setGroupId(long groupId)
    {
        this.groupId = groupId;
    }
    /**
     * 
     * @return long
     */
    public long getImageId()
    {
        return imageId;
    }
    /**
     * 
     * @param imageId This is a long object
     */
    public void setImageId(long imageId)
    {
        this.imageId = imageId;
    }
    /**
     * 
     * @return String
     */
    public String getImageTitle()
    {
        return imageTitle;
    }
    /**
     * 
     * @param imageTitle This is a String object
     */
    public void setImageTitle(String imageTitle)
    {
        this.imageTitle = imageTitle;
    }
    /**
     * 
     * @return String
     */
    public String getImageURL()
    {
        return imageURL;
    }
    /**
     * 
     * @param imageURL This is a String object
     */
    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }
    /**
     * 
     * @return String
     */
    public String getImageDescription()
    {
        return imageDescription;
    }
    /**
     * 
     * @param imageDescription This is a String object
     */
    public void setImageDescription(String imageDescription)
    {
        this.imageDescription = imageDescription;
    }
    /**
     * 
     * @return String
     */
    public String getImageSize()
    {
        return imageSize;
    }
    /**
     * 
     * @param imageSize This is a String object
     */
    public void setImageSize(String imageSize)
    {
        this.imageSize = imageSize;
    }

}
