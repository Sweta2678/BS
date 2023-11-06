package com.ihg.brandstandards.bridge.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ihg.brandstandards.custom.model.StandardBase;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.StandardsSortableUtil;
import com.ihg.brandstandards.util.StandardsSortableUtil.StandardSortBySTDId;

public class StandardsUtil {
	
	/**
	 *  
	 * @param arlDisplayStandards
	 * @return List<Standards>
	 */
	public static List<Standard> sortRecords(List<Standard> arlDisplayStandards)
	    {
	     List<Standard> stdList = new ArrayList<Standard>();  
		 for (Standard std : arlDisplayStandards)
	        {
	            Standard standards = new Standard();
	            if (BSCommonConstants.STD_TYPE_STANDARD.equals(std.getStdType()))
	            {
	                populateStdData(std, standards);
	                stdList.add(standards);
	            }
	        }

	        List<Standard> sortedStandards = StandardsSortableUtil.sort(stdList);
	        for (Standard standards : sortedStandards)
	        {
	            List<Standard> arlSpecs = new ArrayList<Standard>();
	            List<Standard> arlGdlns = new ArrayList<Standard>();
	            for (Standard std : arlDisplayStandards)
	            {
	                populateSpecGdlnDdata(standards, arlSpecs, arlGdlns, std);
	            }
	            Collections.sort(arlSpecs, new StandardSortBySTDId());
	            Collections.sort(arlGdlns, new StandardSortBySTDId());
	            standards.setSpecifications(arlSpecs);
	            standards.setGuidelines(arlGdlns);
	        }
	        return sortedStandards;
	    }
	 
		/**
		 * @param std
		 * @param standards
		 */
	 	private static void populateStdData(Standard std, StandardBase standards)
	    {
	        standards.setTaxonomyId(std.getTaxonomyId());
	        standards.setTaxonomyPath(std.getTaxonomyPath());
	        standards.setIndexOrder(std.getIndexOrder());
	        standards.setParentTaxonomyId(std.getParentTaxonomyId());
	        standards.setStdId(std.getStdId());
	        standards.setParentStdId(std.getParentStdId());
	        standards.setTitle(std.getTitle());
	        standards.setDescription(std.getDescription());
	        standards.setStdType(std.getStdType());
	        standards.setStatus(std.getStatus());
	        standards.setDisplayOrder(std.getDisplayOrder());
	        standards.setFramework(std.getFramework());
	        standards.setIsGlobal(std.getIsGlobal());
	        standards.setRegionCode(std.getRegionCode());
	    }

	 	/**
	 	 * @param standards
	 	 * @param arlSpecs
	 	 * @param arlGdlns
	 	 * @param specGdln
	 	 */
	    private static void populateSpecGdlnDdata(Standard standards, List<Standard> arlSpecs, List<Standard> arlGdlns,
	            Standard specGdln)
	    {
	        if (standards.getStdId() == specGdln.getParentStdId())
	        {
	            Standard specs = new Standard();
	            specs.setPublishStdId(specGdln.getStdId());
	            specs.setStdId(specGdln.getStdId());
	            specs.setParentStdId(specGdln.getParentStdId());
	            specs.setTitle(specGdln.getTitle());
	            specs.setDescription(specGdln.getDescription());
	            specs.setStdType(specGdln.getStdType());
	            specs.setStatus(specGdln.getStatus());
	            specs.setDisplayOrder(specGdln.getDisplayOrder());
	            specs.setFramework(specGdln.getFramework());
	            specs.setIsGlobal(specGdln.getIsGlobal());
	            specs.setRegionCode(specGdln.getRegionCode());
	            if (BSCommonConstants.STD_TYPE_SPEC.equals(specGdln.getStdType()))
	            {
	                arlSpecs.add(specs);
	            }
	            else if (BSCommonConstants.STD_TYPE_GDLN.equals(specGdln.getStdType()))
	            {
	                arlGdlns.add(specs);
	            }
	        }
	    }

}
