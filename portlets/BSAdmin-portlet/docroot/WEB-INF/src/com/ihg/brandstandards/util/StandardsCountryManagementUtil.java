package com.ihg.brandstandards.util;

import com.ihg.brandstandards.db.model.StandardsCountry;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsComplianceLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ClassNameLocalServiceUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class StandardsCountryManagementUtil
{

	private static final Log LOG = LogFactoryUtil.getLog(StandardsCountryManagementUtil.class);
	
    public static Map<String, String> getCtryMap(){    
        BSLanguageUtil adminLanguageUtil = new BSLanguageUtil("en_GB", BSCommonConstants.ELEMENT_MODULE_BRIDGE);
        List<StandardsCountry> ctryList = null;
        Map<String, String> ctryUIElem = new LinkedHashMap<String, String>();
		try
		{
			ctryList = StandardsCountryLocalServiceUtil.getStandardsCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (SystemException e)
		{
			LOG.error("Country Code and Name Error", e);
		}
        
        for(StandardsCountry country : ctryList){
        	
        	ctryUIElem.put(country.getCountryNameCode(), adminLanguageUtil.get("bs.country.name.cd." + country.getCountryNameCode().toLowerCase()));
        }
        
        return ctryUIElem;
    }
    
    public static  List<String> getSubRegionsByRegioncode(long parentRegionId)
    {
    	
    	List<StandardsRegion> standardsSubRegionsList = StandardsRegionLocalServiceUtil.getSubRegionsListByParentId(parentRegionId);
    	
        List<String> subRegionList = new ArrayList<String>();
        
        for(StandardsRegion standardsRegion : standardsSubRegionsList){

        	if(parentRegionId == standardsRegion.getParentRegionId()){
        		String subRegion = new String();
        		subRegion = standardsRegion.getRegionCode();
        		subRegionList.add(subRegion);
        	}
        	
        }
       
        return subRegionList;
    }
    
    public static String assignCountryAttributes(String fromCountry, String toCountry, boolean standardsOption, boolean complianceDateOption, 
    	boolean expDate, boolean attachemtnsOption, boolean imagesOption, boolean linksOption ){
    	
    	String status = "success";
    	
    	if(Validator.isNotNull(standardsOption) && standardsOption)
    	{
    		status = CountryStandardsLocalServiceUtil.assignStandardsAttributToCountry(fromCountry, toCountry);
    	}
    	
    	if(CountryStandardsLocalServiceUtil.getCommonStdCount(fromCountry, toCountry) > 0)
    	{
    		
	    	if(Validator.isNotNull(attachemtnsOption) && attachemtnsOption )
	    	{
	    		status = AttachmentsStandardsCountryLocalServiceUtil.assignAttachementAttributeToCountry(fromCountry, toCountry);
	    	}
	    	
	    	if(Validator.isNotNull(linksOption) && linksOption)
	    	{
	    		status = ExternalLinkStandardsCountryLocalServiceUtil.assignLinkAttributeToCountry(fromCountry, toCountry);
	    	}
	    	
	    	if(Validator.isNotNull(imagesOption) && imagesOption)
	    	{
	    		status = StandardsCountryImagesLocalServiceUtil.assignImageAttributeToCountry(fromCountry, toCountry);
	    	}
	    	
	    	if(Validator.isNotNull(complianceDateOption) && complianceDateOption)
	    	{
	    		
	    		status = StandardsComplianceLocalServiceUtil.assignComplianceDateToCountry(fromCountry, toCountry);
	    		StandardsComplianceLocalServiceUtil.clearCache();
	    		EntityCacheUtil.clearCache(BSAdminConstants.STANDARDS_CMPL);
	    		FinderCacheUtil.clearCache(BSAdminConstants.STANDARDS_CMPL);
	    	}
	    	
	    	if(Validator.isNotNull(expDate) && expDate)
	    	{
	    		status = StandardsComplianceLocalServiceUtil.assignExpiryDateToCountry(fromCountry, toCountry);
	    		StandardsComplianceLocalServiceUtil.clearCache();
	    		EntityCacheUtil.clearCache(BSAdminConstants.STANDARDS_CMPL);
	    		FinderCacheUtil.clearCache(BSAdminConstants.STANDARDS_CMPL);
	    	}
	    	
    	}
    	
		else
		{
			status = "Origin and destination country have no common standards.";
		}
    	
    	return status;
    }
    
    public static String removeCountryAttributes(String ctryNameCode, boolean standardsOption, boolean complianceDateOption, 
    	boolean expDate, boolean attachemtnsOption, boolean imagesOption, boolean linksOption ){
    	
    	String status = "success";
    	if(Validator.isNotNull(standardsOption) && standardsOption){

    		status = CountryStandardsLocalServiceUtil.deleteCountryStandardAttribute(ctryNameCode);
    	}
    	
    	if(Validator.isNotNull(attachemtnsOption) && attachemtnsOption ){
    		
    		status = AttachmentsStandardsCountryLocalServiceUtil.deleteCountryAttachementAttribute(ctryNameCode);
    	}
    	
    	if(Validator.isNotNull(linksOption) && linksOption){
    		
    		status = ExternalLinkStandardsCountryLocalServiceUtil.deleteCountryExtLinkAttribute(ctryNameCode);
    	}
    	
    	if(Validator.isNotNull(imagesOption) && imagesOption){
    		
    		status = StandardsCountryImagesLocalServiceUtil.deleteCountryImagesAttribute(ctryNameCode);
    	}
    	
    	if(Validator.isNotNull(complianceDateOption) && complianceDateOption){
    		
    		status = StandardsComplianceLocalServiceUtil.deleteComplianceExpiryDateAttribute(ctryNameCode, "C");
    	}
    	
    	if(Validator.isNotNull(expDate) && expDate){
    		
    		status = StandardsComplianceLocalServiceUtil.deleteComplianceExpiryDateAttribute(ctryNameCode, "E");
    	}
    	
    	return status;
    }
   
}
