package com.ihg.brandstandards.bsadmin.model;

import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.BusImpactAssmt;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.FlagStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsAuthors;
import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.TaxonomyStandards;
import com.ihg.brandstandards.db.model.Workflow;
import com.liferay.portal.model.User;

/**
 * Data class for Standard.
 * 
 * @author Vipul_D
 * 
 */
public class StandardsView
{

    private Standards standard;

    private List<ChainStandards> chainStandards;

    private List<CountryStandards> countryStandards;

    private TaxonomyStandards taxonomyStandards;

    private String taxonomyTitle;

    private Map<AttachmentsStandards, List<List>> attachmentStandards;

    private Map<ExternalLinkStandards, List<List>> extLinkStandards;

    private Map<ExternalLinkStandards, List<List>> assocExtLinkStandards;

    private StandardsAuthors primaryAuthor;

    private List<StandardsAuthors> secondaryAuthor;

    private List<FlagCategory> flagCategory;

    private List<FlagStandards> flagStandards;

    private Workflow workflow;

    private boolean isApprover;

    private List<User> authors;

    private List<User> businessOwners;

    private Standards associatedStandard;

    private List<ChainStandards> assocChainStandards;

    private List<CountryStandards> assocCountryStandards;

    private List<StandardsHistoricalManual> standardsHistoricalManuals;

    private List<StandardsHistoricalManual> assocStandardsHistoricalManuals;

    private List<BusImpactAssmt> busImpactAssmts;

    private Map<StandardsImages, List<List>> assignImages;

    private List<FlagStandards> assocFlagStandards;
    
    private List<FlagStandards> childFlagStandards;
	
	private String defaultStatusCode;  

	/**
     * Get Standard.
     * 
     * @return Standard
     */
    public Standards getStandard()
    {
        return standard;
    }

    /**
     * Set Standard.
     * 
     * @param standard - Standard
     */
    public void setStandard(final Standards standard)
    {
        this.standard = standard;
    }

    /**
     * Get Chains associated with Standard.
     * 
     * @return List of ChainStandards
     */
    public List<ChainStandards> getChainStandards()
    {
        return chainStandards;
    }

    /**
     * Set ChainStandards.
     * 
     * @param chainStandards - List of ChainStandards
     */
    public void setChainStandards(final List<ChainStandards> chainStandards)
    {
        this.chainStandards = chainStandards;
    }

    /**
     * Get CountryStandards.
     * 
     * @return list of CountryStandards
     */
    public List<CountryStandards> getCountryStandards()
    {
        return countryStandards;
    }

    /**
     * Set CountryStandards.
     * 
     * @param countryStandards - list of CountryStandards
     */
    public void setCountryStandards(final List<CountryStandards> countryStandards)
    {
        this.countryStandards = countryStandards;
    }

    /**
     * Get TaxonomyStandards.
     * 
     * @return TaxonomyStandards
     */
    public TaxonomyStandards getTaxonomyStandards()
    {
        return taxonomyStandards;
    }

    /**
     * Set TaxonomyStandards.
     * 
     * @param taxonomyStandards - TaxonomyStandards
     */
    public void setTaxonomyStandards(final TaxonomyStandards taxonomyStandards)
    {
        this.taxonomyStandards = taxonomyStandards;
    }

    /**
     * Get AttachmentsStandards.
     * 
     * @return list of AttachmentsStandards
     */
    public Map<AttachmentsStandards, List<List>> getAttachmentStandards()
    {
        return attachmentStandards;
    }

    /**
     * set AttachmentsStandards.
     * 
     * @param attachmentStandards - list of AttachmentsStandards
     */
    public void setAttachmentStandards(final Map<AttachmentsStandards, List<List>> attachmentStandards)
    {
        this.attachmentStandards = attachmentStandards;
    }

    /**
     * Get ExternalLinkStandards.
     * 
     * @return List of ExternalLinkStandards
     */
    public Map<ExternalLinkStandards, List<List>> getExtLinkStandards()
    {
        return extLinkStandards;
    }

    /**
     * Set ExternalLinkStandards.
     * 
     * @param extLinkStandards - ExternalLinkStandards
     */
    public void setExtLinkStandards(final Map<ExternalLinkStandards, List<List>> extLinkStandards)
    {
        this.extLinkStandards = extLinkStandards;
    }

    /**
     * Get FlagCategory.
     * 
     * @return list of FlagCategory
     */
    public List<FlagCategory> getFlagCategory()
    {
        return flagCategory;
    }

    /**
     * Set FlagCategory.
     * 
     * @param flagCategory FlagCategory
     */
    public void setFlagCategory(final List<FlagCategory> flagCategory)
    {
        this.flagCategory = flagCategory;
    }

    /**
     * Get Workflow.
     * 
     * @return Workflow
     */
    public Workflow getWorkflow()
    {
        return workflow;
    }

    /**
     * Set Workflow.
     * 
     * @param workflow Workflow
     */
    public void setWorkflow(final Workflow workflow)
    {
        this.workflow = workflow;
    }

    /**
     * Get approver flag.
     * 
     * @return true/false
     */
    public boolean isApprover()
    {
        return isApprover;
    }

    /**
     * Set Approver flag.
     * 
     * @param isApprover true/false
     */
    public void setApprover(final boolean isApprover)
    {
        this.isApprover = isApprover;
    }

    /**
     * Get Authors.
     * 
     * @return list of Author users.
     */
    public List<User> getAuthors()
    {
        return authors;
    }

    /**
     * Set Authors.
     * 
     * @param authors list of Author users.
     */
    public void setAuthors(final List<User> authors)
    {
        this.authors = authors;
    }

    /**
     * Get Standard for Specification or Guideline.
     * 
     * @return Standard
     */
    public Standards getAssociatedStandard()
    {
        return associatedStandard;
    }

    /**
     * Set Standard for Specification or Guideline.
     * 
     * @param associatedStandard Standard
     */
    public void setAssociatedStandard(final Standards associatedStandard)
    {
        this.associatedStandard = associatedStandard;
    }

    /**
     * Get Business Owner.
     * 
     * @return list of users
     */
    public List<User> getBusinessOwners()
    {
        return businessOwners;
    }

    /**
     * Set Business Owner.
     * 
     * @param businessOwners list of Business Owner users.
     */
    public void setBusinessOwners(final List<User> businessOwners)
    {
        this.businessOwners = businessOwners;
    }

    /**
     * Get associated with Standard Chains.
     * 
     * @return list of ChainStandards
     */
    public List<ChainStandards> getAssocChainStandards()
    {
        return assocChainStandards;
    }

    /**
     * Set associated with Standard Chains.
     * 
     * @param assocChainStandards list of ChainStandards
     */
    public void setAssocChainStandards(final List<ChainStandards> assocChainStandards)
    {
        this.assocChainStandards = assocChainStandards;
    }

    /**
     * Get Flags associated with a Standard.
     * 
     * @return list of FlagStandards
     */
    public List<FlagStandards> getFlagStandards()
    {
        return flagStandards;
    }

    /**
     * Set Flags associated with a Standard.
     * 
     * @param flagStandards list of FlagStandards
     */
    public void setFlagStandards(final List<FlagStandards> flagStandards)
    {
        this.flagStandards = flagStandards;
    }

    /**
     * Get Index title.
     * 
     * @return title.
     */
    public String getTaxonomyTitle()
    {
        return taxonomyTitle;
    }

    /**
     * Set Index Title.
     * 
     * @param taxonomyTitle title
     */
    public void setTaxonomyTitle(final String taxonomyTitle)
    {
        this.taxonomyTitle = taxonomyTitle;
    }

    /**
     * Get countries associated with a Standard.
     * 
     * @return list of CountryStandards
     */
    public List<CountryStandards> getAssocCountryStandards()
    {
        return assocCountryStandards;
    }

    /**
     * Set countries associated with a Standard.
     * 
     * @param assocCountryStandards - list of CountryStandards
     */
    public void setAssocCountryStandards(final List<CountryStandards> assocCountryStandards)
    {
        this.assocCountryStandards = assocCountryStandards;
    }

    /**
     * Get ExternalLinks for a Standard.
     * 
     * @return list of ExternalLinkStandards
     */
    public Map<ExternalLinkStandards, List<List>> getAssocExtLinkStandards()
    {
        return assocExtLinkStandards;
    }

    /**
     * Set ExternalLinks for a Standard.
     * 
     * @param assocExtLinkStandards - list of ExternalLinkStandards
     */
    public void setAssocExtLinkStandards(final Map<ExternalLinkStandards, List<List>> assocExtLinkStandards)
    {
        this.assocExtLinkStandards = assocExtLinkStandards;
    }

    /**
     * Get HistoricalManual for a Standard.
     * 
     * @return list of HistoricalManual
     */
    public List<StandardsHistoricalManual> getStandardsHistoricalManuals()
    {
        return standardsHistoricalManuals;
    }

    /**
     * Set HistoricalManual for a Standard.
     * 
     * @param standardsHistoricalManuals list of HistoricalManual
     */
    public void setStandardsHistoricalManuals(final List<StandardsHistoricalManual> standardsHistoricalManuals)
    {
        this.standardsHistoricalManuals = standardsHistoricalManuals;
    }

    /**
     * Get HistoricalManual for a parent Standard.
     * 
     * @return list of HistoricalManual
     */
    public List<StandardsHistoricalManual> getAssocStandardsHistoricalManuals()
    {
        return assocStandardsHistoricalManuals;
    }

    /**
     * Set HistoricalManual for a parent Standard.
     * 
     * @param assocStandardsHistoricalManuals list of HistoricalManual
     */
    public void setAssocStandardsHistoricalManuals(final List<StandardsHistoricalManual> assocStandardsHistoricalManuals)
    {
        this.assocStandardsHistoricalManuals = assocStandardsHistoricalManuals;
    }

    /**
     * Getter for Business Impact Assessment.
     * 
     * @return list of Business Impact Assessments
     */
    public List<BusImpactAssmt> getBusImpactAssmts()
    {
        return busImpactAssmts;
    }

    /**
     * Setter for Business Impact Assessment.
     * 
     * @param busImpactAssmts
     */
    public void setBusImpactAssmts(List<BusImpactAssmt> busImpactAssmts)
    {
        this.busImpactAssmts = busImpactAssmts;
    }

    /**
     * getter for primary author.
     * 
     * @return StandardsAuthors
     */
    public StandardsAuthors getPrimaryAuthor()
    {
        return primaryAuthor;
    }

    /**
     * Setter for primary author.
     * 
     * @param primaryAuthor author
     */
    public void setPrimaryAuthor(StandardsAuthors primaryAuthor)
    {
        this.primaryAuthor = primaryAuthor;
    }

    /**
     * Getter for secondary author.
     * 
     * @return list of Standards Authors
     */
    public List<StandardsAuthors> getSecondaryAuthor()
    {
        return secondaryAuthor;
    }

    /**
     * Setter for secondary author.
     * 
     * @param secondaryAuthor author
     */
    public void setSecondaryAuthor(List<StandardsAuthors> secondaryAuthor)
    {
        this.secondaryAuthor = secondaryAuthor;
    }

    /**
     * Getter for Assigned Images.
     * 
     * @return the assignImages
     */
    public Map<StandardsImages, List<List>> getAssignImages()
    {
        return assignImages;
    }

    /**
     * Setter for Assigned Images.
     * 
     * @param assignImages the assignImages to set
     */
    public void setAssignImages(Map<StandardsImages, List<List>> assignImages)
    {
        this.assignImages = assignImages;
    }
    

	/**
	 * Getter for Flag
	 * @return the assocFlagStandards
	 */
	public List<FlagStandards> getAssocFlagStandards() {
		return assocFlagStandards;
	}

	/**
	 * @param assocFlagStandards the assocFlagStandards to set
	 */
	public void setAssocFlagStandards(List<FlagStandards> assocFlagStandards) {
		this.assocFlagStandards = assocFlagStandards;
	}
	
	/**
     * Getter for child Flag Stds.
     * 
     * @return the childFlagStandards
     */    
    public List<FlagStandards> getChildFlagStandards()
    {
        return childFlagStandards;
    }

    /**
     * Setter for child Flag Stds.
     * 
     * @param childFlagStandards the childFlagStandards to set
     */
    public void setChildFlagStandards(List<FlagStandards> childFlagStandards)
    {
        this.childFlagStandards = childFlagStandards;
    }
	
	/**
     * Get default status.
     * @return status value
     */
    public String getDefaultStatusCode()
    {
        return defaultStatusCode;
    }
    
    /**
     * set default status code.
     * @param defaultStatusCode
     */
    public void setDefaultStatusCode(String defaultStatusCode)
    {
        this.defaultStatusCode = defaultStatusCode;
    }
}
