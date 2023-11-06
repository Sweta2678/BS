/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.custom.model;

/**
 * <a href="ExternalLinks.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author chintan.akhani
 */
public class ExternalLinks
{
    private String externalLink;
    private String externalURL;
    private String externalLinkStatus;
    private long standardId;
    private long externalLinkParentId;
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
    public long getExternalLinkParentId()
    {
        return externalLinkParentId;
    }

    /**
     * 
     * @param externalLinkParentId This is a long object
     */
    public void setExternalLinkParentId(long externalLinkParentId)
    {
        this.externalLinkParentId = externalLinkParentId;
    }

    /**
     * 
     * @return This is a long object
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
    public String getExternalLinkStatus()
    {
        return externalLinkStatus;
    }

    /**
     * 
     * @param externalLinkStatus This is a String object
     */
    public void setExternalLinkStatus(String externalLinkStatus)
    {
        this.externalLinkStatus = externalLinkStatus;
    }

    private long externalLinkId;

    /**
     * 
     * @return long
     */
    public long getExternalLinkId()
    {
        return externalLinkId;
    }

    /**
     * 
     * @param externalLinkId This is a long object
     */
    public void setExternalLinkId(long externalLinkId)
    {
        this.externalLinkId = externalLinkId;
    }

    /**
     * 
     * @return String
     */
    public String getExternalLink()
    {
        return externalLink;
    }

    /**
     * 
     * @param externalLink This is a String object
     */
    public void setExternalLink(String externalLink)
    {
        this.externalLink = externalLink;
    }

    /**
     * 
     * @return String
     */
    public String getExternalURL()
    {
        return externalURL;
    }

    /**
     * 
     * @param externalURL This is a String object
     */
    public void setExternalURL(String externalURL)
    {
        this.externalURL = externalURL;
    }

}
