package com.ihg.brandstandards.bsadmin.model;

import java.util.List;

import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.ihg.brandstandards.db.model.Workflow;
import com.liferay.portal.model.User;

/**
 * Data class for Standard.
 * 
 * @author Vipul_D
 * 
 */
public class RegionalView
{

    private Standards standard;

    private List<ChainStandards> chainStandards;

    private List<CountryStandards> countryStandards;

    private Workflow workflow;

    private boolean isApprover;

    private List<User> authors;

    private Standards associatedStandard;

    private List<ChainStandards> assocChainStandards;

    private List<CountryStandards> assocCountryStandards;

    private List<StandardsHistoricalManual> standardsHistoricalManuals;

    private List<StandardsHistoricalManual> assocStandardsHistoricalManuals;

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
     * Get Chains associated with Standard.
     * 
     * @return List of ChainStandards
     */
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

}
