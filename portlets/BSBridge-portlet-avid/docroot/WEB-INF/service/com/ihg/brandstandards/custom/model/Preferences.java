package com.ihg.brandstandards.custom.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Preferences implements Serializable
{
    private long userId;
	private String brand;
	private String region;
	private String regionCode;
	private String discontinuedFilter;
	private int itemsPerPage;
    private String regionName;
    private long departmentId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getDiscontinuedFilter() {
		return discontinuedFilter;
	}
	public void setDiscontinuedFilter(String discontinuedFilter) {
		this.discontinuedFilter = discontinuedFilter;
	}
	public String getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}
    /**
     * @return the itemsPerPage
     */
    public int getItemsPerPage()
    {
        return itemsPerPage;
    }
    /**
     * @param itemsPerPage the itemsPerPage to set
     */
    public void setItemsPerPage(int itemsPerPage)
    {
        this.itemsPerPage = itemsPerPage;
    }
    /**
     * @return the regionName
     */
    public String getRegionName()
    {
        return regionName;
    }
    /**
     * @param regionName the regionName to set
     */
    public void setRegionName(String regionName)
    {
        this.regionName = regionName;
    }
    /**
     * @return departmentId
     */
	public long getDepartmentId() {
		return departmentId;
	}
	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
}
