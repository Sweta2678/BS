package com.ihg.brandstandards.bsadmin.model;

//To store mapping properties for brand and region
public class BrandRegionProperties
{
    private boolean editable;
    private String validity;
    private String expireIds;
    /**
     * @return the isEditable
     */
    public boolean isEditable()
    {
        return editable;
    }
    /**
     * @param isEditable the isEditable to set
     */
    public void setEditable(boolean isEditable)
    {
        this.editable = isEditable;
    }
    /**
     * @return the validity
     */
    public String getValidity()
    {
        return validity;
    }
    /**
     * @param validity the validity to set
     */
    public void setValidity(String validity)
    {
        this.validity = validity;
    }
    /**
     * @return the expireIds
     */
    public String getExpireIds()
    {
        return expireIds;
    }
    /**
     * @param expireIds the expireIds to set
     */
    public void setExpireIds(String expireIds)
    {
        this.expireIds = expireIds;
    }
    
}
