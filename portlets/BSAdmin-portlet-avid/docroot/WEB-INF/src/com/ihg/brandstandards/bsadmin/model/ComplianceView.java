package com.ihg.brandstandards.bsadmin.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsComplianceExt;
import com.ihg.brandstandards.util.ComplianceUtil;

/**
 * 
 * @author hitesh.methani
 *
 */
/**
 * @author krunalm.patel
 *
 */
public class ComplianceView implements Serializable
{
    
    private Map<String, String> allBrands;
    //Map<BrandCode, Map<RgnCd, brandRegionProperties> 
    private Map<String, Map<String, BrandRegionProperties>> brandRegionMapping;
    
    // Brand published date mapping
    private Map<String, String> brandPublishedDate;
    
    // Brand perspective selected
    private String selectedBrand;
    
    // To state if logged in user is global or not
    private boolean loggedInGlobal;
    
    // Map to show compliance rule months select dropdown
    private Map<Long, String> validMonths;
    
    // BrandRegion under edit
    private String[] brandRegionEdit;
    
    // Mapping between Brandcode and expire stds, this will help in display of table,will be set only for GLBL std
    private Map<String, Standards[]> expireStds;
    
    // Mapping between Brandcode and expire std string, this will help in display hover text, will be set only for GLBL std
    private Map<String, String> expireIds;
    
    private List<String> brands;
    private Map<String, String> associatedRegions;
    private List<String> associatedCountries;
    
    private boolean isAuthor;
    private boolean isGlobalAuthor;
    private boolean isSuperAdmin;
    private String authorsRegion;
    private boolean isBrandPublished;
    private long stdId;
    private List<StandardsComplianceExt> arlStdCompliance;
    private Map<String, String> complianceDate;
    
    public List<StandardsComplianceExt> getArlStdCompliance() {
		return arlStdCompliance;
	}


	public void setArlStdCompliance(List<StandardsComplianceExt> arlStdCompliance) {
		this.arlStdCompliance = arlStdCompliance;
	}


	public List<String> getBrands() {
		return brands;
	}


	public void setBrands(List<String> brands) {
		this.brands = brands;
	}


	public Map<String, String> getAssociatedRegions() {
		return associatedRegions;
	}


	public void setAssociatedRegions(Map<String, String> associatedRegions) {
		this.associatedRegions = associatedRegions;
	}


	public List<String> getAssociatedCountries() {
		return associatedCountries;
	}


	public void setAssociatedCountries(List<String> associatedCountries) {
		this.associatedCountries = associatedCountries;
	}


	public boolean isAuthor() {
		return isAuthor;
	}


	public void setAuthor(boolean isAuthor) {
		this.isAuthor = isAuthor;
	}


	public boolean isGlobalAuthor() {
		return isGlobalAuthor;
	}


	public void setGlobalAuthor(boolean isGlobalAuthor) {
		this.isGlobalAuthor = isGlobalAuthor;
	}


	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}


	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}


	public String getAuthorsRegion() {
		return authorsRegion;
	}


	public void setAuthorsRegion(String authorsRegion) {
		this.authorsRegion = authorsRegion;
	}


	public boolean isBrandPublished() {
		return isBrandPublished;
	}


	public void setBrandPublished(boolean isBrandPublished) {
		this.isBrandPublished = isBrandPublished;
	}


	public long getStdId() {
		return stdId;
	}


	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	
	/**
	 * @return the complianceDate
	 */
	public Map<String, String> getComplianceDate() {
		return complianceDate;
	}


	/**
	 * @param complianceDate the complianceDate to set to by checking into std_ctry_chain table for verifying standards is in pubilcation
	 */
	public void setComplianceDate(Map<String, String> complianceDate) {
		this.complianceDate = complianceDate;
	}


	/**
     * @return the allBrands
     */
    public Map<String, String> getAllBrands()
    {
        return allBrands;
    }
    
    
    public ComplianceView()
    {
        validMonths = new LinkedHashMap<Long, String>();
        validMonths.put(0L, "0 "+ ComplianceUtil.MONTHS);
        validMonths.put(1L, "1 month");
        validMonths.put(3L, "3 "+ ComplianceUtil.MONTHS);
        validMonths.put(6L, "6 "+ ComplianceUtil.MONTHS);
        validMonths.put(9L, "9 "+ ComplianceUtil.MONTHS);
        validMonths.put(12L, "12 "+ ComplianceUtil.MONTHS);
        validMonths.put(18L, "18 "+ ComplianceUtil.MONTHS);
        validMonths.put(24L, "24 "+ ComplianceUtil.MONTHS);
        validMonths.put(36L, "36 "+ ComplianceUtil.MONTHS);
        validMonths.put(60L, "60 "+ ComplianceUtil.MONTHS);
        validMonths.put(120L, "120 "+ ComplianceUtil.MONTHS);
    }
    /**
     * @param allBrands the allBrands to set
     */
    public void setAllBrands(Map<String, String> allBrands)
    {
        this.allBrands = allBrands;
    }

    /**
     * @return the brandRegionMapping
     */
    public Map<String, Map<String, BrandRegionProperties>> getBrandRegionMapping()
    {
        return brandRegionMapping;
    }

    /**
     * @param brandRegionMapping the brandRegionMapping to set
     */
    public void setBrandRegionMapping(Map<String, Map<String, BrandRegionProperties>> brandRegionMapping)
    {
        this.brandRegionMapping = brandRegionMapping;
    }

    /**
     * @return the brandPublishedDate
     */
    public Map<String, String> getBrandPublishedDate()
    {
        return brandPublishedDate;
    }

    /**
     * @param brandPublishedDate the brandPublishedDate to set
     */
    public void setBrandPublishedDate(Map<String, String> brandPublishedDate)
    {
        this.brandPublishedDate = brandPublishedDate;
    }

    /**
     * @return the selectedBrand
     */
    public String getSelectedBrand()
    {
        return selectedBrand;
    }

    /**
     * @param selectedBrand the selectedBrand to set
     */
    public void setSelectedBrand(String selectedBrand)
    {
        this.selectedBrand = selectedBrand;
    }

    /**
     * @return the loggedInGlobal
     */
    public boolean isLoggedInGlobal()
    {
        return loggedInGlobal;
    }

    /**
     * @param loggedInGlobal the loggedInGlobal to set
     */
    public void setLoggedInGlobal(boolean loggedInGlobal)
    {
        this.loggedInGlobal = loggedInGlobal;
    }

    /**
     * @return the validMonths
     */
    public Map<Long, String> getValidMonths()
    {
        return validMonths;
    }

    /**
     * @param validMonths the validMonths to set
     */
    public void setValidMonths(Map<Long, String> validMonths)
    {
        this.validMonths = validMonths;
    }


    /**
     * @return the brandRegionEdit
     */
    public String[] getBrandRegionEdit()
    {
        return brandRegionEdit;
    }


    /**
     * @param brandRegionEdit the brandRegionEdit to set
     */
    public void setBrandRegionEdit(String[] brandRegionEdit)
    {
        this.brandRegionEdit = brandRegionEdit;
    }


    /**
     * @return the expireStds
     */
    public Map<String, Standards[]> getExpireStds()
    {
        return expireStds;
    }


    /**
     * @param expireStds the expireStds to set
     */
    public void setExpireStds(Map<String, Standards[]> expireStds)
    {
        this.expireStds = expireStds;
    }


    /**
     * @return the expireIds
     */
    public Map<String, String> getExpireIds()
    {
        return expireIds;
    }


    /**
     * @param expireIds the expireIds to set
     */
    public void setExpireIds(Map<String, String> expireIds)
    {
        this.expireIds = expireIds;
    }
    
}
