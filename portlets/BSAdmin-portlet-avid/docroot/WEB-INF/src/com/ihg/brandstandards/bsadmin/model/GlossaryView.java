package com.ihg.brandstandards.bsadmin.model;

import java.util.List;

import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.GlossaryRegionNav;

/**
 * Gloosaryview is Bean class that is used to show object value is view layer.
 * 
 */
public class GlossaryView 
{

	private  Glossary glossary;
	private  List<GlossaryRegionNav> glossaryRegionNav;

	/**
	 * Get Glossary Object.
	 * @return @Glossary
	 */
	public Glossary getGlossary() 
	{
		return glossary;
	}

	/**
	 * Set Glossary Object. 
	 * @param glossary Glossary Object.
	 */
	public void setGlossary(Glossary glossary) 
	{
		this.glossary = glossary;
	}

	/**
	 * Get list of @GlossaryRegionNav object.
	 * 
	 * @return list of @GlossaryRegionNav
	 */
	public List<GlossaryRegionNav> getGlossaryRegionNav() 
	{
		return glossaryRegionNav;
	}

	/**
	 * Set List of @GlossaryReionNav object.
	 * 
	 * @param glossaryRegionNav GlossaryRegionNav object.
	 */
	public void setGlossaryRegionNav(List<GlossaryRegionNav> glossaryRegionNav) 
	{
		this.glossaryRegionNav = glossaryRegionNav;
	}
}
