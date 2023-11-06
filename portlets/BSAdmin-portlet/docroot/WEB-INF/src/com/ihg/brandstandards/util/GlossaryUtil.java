package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;

public class GlossaryUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(GlossaryUtil.class); 
    
    public static String GLOSSARY_TRANSLATION_VIEW = "TranslationsView";
    
    public static String TRANSLATION_SUCCESS_MESSAGE = "Translation data successfully submitted";

    public static final String DEFAULT_YES  =  "Y"; 
    public static final String DEFAULT_NO  =  "N"; 
    
    public static final String REGION_BARND_SPLIT  =  StringPool.COMMA_AND_SPACE; 
    public static final String CONFIGURE_FIELD_ID =  "glossaryId"; 
    public static final String CONFIGURE_FIELD_TITLE  =  "glossaryTitle"; 
    public static final String CONFIGURE_FIELD_DESC  =  "glossaryDescription"; 
    public static final String CONFIGURE_FIELD_TITLE_TERM  =  "glossaryTermText"; 
    public static final String CONFIGURE_FIELD_DESC_TERM  =  "glossaryTermDesc"; 
    public static final String CONFIGURE_FIELD_OWNER  =  "glossaryOwner"; 
    public static final String CONFIGURE_FIELD_PUBLISHED  =  "glossaryPublished"; 
    public static final String CONFIGURE_FIELD_AMER  =  "glossaryAMER"; 
    public static final String CONFIGURE_FIELD_AMEA =  "glossaryAMEA"; 
    public static final String CONFIGURE_FIELD_EUROPE  =  "glossaryEUROPE"; 
    public static final String CONFIGURE_FIELD_GC  =  "glossaryGreaterChina"; 
    
    public static final String XLS_FIELD_ID =  "Entry Id"; 
    public static final String XLS_FIELD_TITLE  =  "Term"; 
    public static final String XLS_FIELD_DESC  =  "Definition"; 
    public static final String XLS_FIELD_TITLE_TERM  =  "Term Translation"; 
    public static final String XLS_FIELD_DESC_TERM  =  "Definition Translation"; 
    public static final String XLS_FIELD_OWNER  =  "Owner"; 
    public static final String XLS_FIELD_PUBLISHED  =  "Published"; 
    public static final String XLS_FIELD_AMER  =  "Americas"; 
    public static final String XLS_FIELD_AMEA =  "AMEA"; 
    public static final String XLS_FIELD_EUROPE  =  "Europe"; 
    public static final String XLS_FIELD_GC  =  "Greater China"; 
    
    public static final String REPORT_TYPE_GLOSSARY_BASE =  "GlossaryBase"; 
    public static final String REPORT_TYPE_GLOSSARY_TRANSLATION =  "GlossaryTranslation"; 
    
    public static final int MAGIC_TEN  =  10;
    public static final int MAGIC_FIFTY  =  50;
    public static final int MAGIC_HUNDRED  =  100;
    
    public static final String SUCCESS_MESSAGE = "The form submitted successfully.";
    
    public static final String REQUEST_PARAM_GLOSSARY_ID = "glossaryId";
    
    public static final String REQUEST_PARAM_GLOSSARY_VISIBLE_CHAR = "visibleChar";
    
    public static final String REQUEST_PARAM_GLOSSARY_TERM_TEXT = "term_name";
    
    public static final String REQUEST_PARAM_GLOSSARY_DEFINATION_TEXT = "term_definition";
    
    public static final String REQUEST_PARAM_GLOSSARY_OWNER = "owner";
    
    public static final String REQUEST_PARAM_GLOSSARY_PUBLISHED = "glossary_published";
    
    public static final String TERM_EXISTS_ERROR_MSG = "Term text already exists !!";
    
    public static final long INITIAL_GLOSSARY_ID = -100;
    
    public static final String MSG_NO_GLOSSARY_FOUND_VALIDATION = "Invalid GlossaryId";
    
    public static final String MSG_BARND_VALIDATION = "Must have atleast One Brand to atleast One Region for this Glossary";
    
    public static final String XLS_FIELD_KEY = "c_";
    
    
    /**
     * Request parameters.
     */
    public static final String PARAM_IMPORT_ID_EXCEL  =  "IMPORT_ID_EXCEL";
    public static final String PARAM_EXPORT_ID_EXCEL  =  "EXPORT_ID_EXCEL";
    
    /**
     * Retun Brand Stands Locale list.
     * @return List<StandardsLocale>.
     */
    public static List<StandardsLocale> getStandardsLocaleList() 
    {
        List<StandardsLocale> localeList =  new ArrayList<StandardsLocale>(); 
        try 
        {
            localeList  =  StandardsLocaleLocalServiceUtil.getBrandStandardsLocale(); 
        } 
        catch (SystemException e) 
        {
            LOG.error("Exception : while get locale list"); 
            LOG.error(StackTraceUtil.getStackTrace(e)); 
        }
        return localeList; 
    }
     
    /**
     * Return String comma separate of brand based on glossaryid and regionid.
     * 
     * @param glossaryId glossaryId.
     * @param regionId regionId.
     * @return String  i.e. HI,  EX.
     */
    public static String getBrandsByGlossary(long glossaryId, long regionId) 
    {
       try 
       {
            return GlossaryRegionNavLocalServiceUtil.getRegionCodesByglossaryIdAndRegionId(glossaryId,  regionId); 
       } 
       catch (SystemException e) 
       {
            LOG.error(e.getMessage(),  e); 
       }
       return null; 
   }
   
    /**
     * Get Region name by region id.
     * 
     * @param regionId Region id.
     * @return String of region name
     */
    public static String getRegionById(long regionId)
    {
        try
        {
            return StandardsRegionLocalServiceUtil.getStandardsRegion( regionId).getRegionName();
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(),  e); 
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(),  e); 
        }
        return null;
    }
    
    /**
     * Remove duplicate string from passed string.
    
     * @param regionId Region id.
     * @return String of region name.
     */
    public static String deleteDuplicate(String s) 
    {
        return new LinkedHashSet<String>(Arrays.asList(s.split(", "))).toString().replaceAll("(^\\[|\\]$)", "");
    }
}
