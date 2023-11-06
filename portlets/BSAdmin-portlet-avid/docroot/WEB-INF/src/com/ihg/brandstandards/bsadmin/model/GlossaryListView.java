/**
 * 
 */
package com.ihg.brandstandards.bsadmin.model;

/**
 * Class used to create POJO for Glossary Listing View Layer.
 * 
 *
 */
public class GlossaryListView 
{

	private String glossaryTermTxt;
	private String glossaryTermDef;
	private String glossaryId;
	private String region;
	private String chainCode;
	
	/**
	 * @return the glossaryTermTxt
	 */
	public String getGlossaryTermTxt() 
	{
		return glossaryTermTxt;
	}
	/**
	 * @param glossaryTermTxt the glossaryTermTxt to set
	 */
	public void setGlossaryTermTxt(String glossaryTermTxt) 
	{
		this.glossaryTermTxt = glossaryTermTxt;
	}
	/**
	 * @return the glossaryTermDef
	 */
	public String getGlossaryTermDef() 
	{
		return glossaryTermDef;
	}
	/**
	 * @param glossaryTermDef the glossaryTermDef to set
	 */
	public void setGlossaryTermDef(String glossaryTermDef) 
	{
		this.glossaryTermDef = glossaryTermDef;
	}
	/**
	 * @return the glossaryId
	 */
	public String getGlossaryId() 
	{
		return glossaryId;
	}
	/**
	 * @param glossaryId the glossaryId to set
	 */
	public void setGlossaryId(String glossaryId) 
	{
		this.glossaryId = glossaryId;
	}
	/**
	 * @return the region
	 */
	public String getRegion() 
	{
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) 
	{
		this.region = region;
	}
	/**
	 * @return the chainCode
	 */
	public String getChainCode() 
	{
		return chainCode;
	}
	/**
	 * @param chainCode the chainCode to set
	 */
	public void setChainCode(String chainCode) 
	{
		this.chainCode = chainCode;
	}
}
