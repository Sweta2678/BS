package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;



/**
 * Utility class to access MultiVMPoolUtil cache
 * @author hitesh.methani
 *
 */
public class BrandStandardsCacheUtil
{
    public static final String LANGUAGE_MAP = "languageMap";
    
    public static final String REGION_MAP = "regionMap";
    
    public static final String BRAND_STANDARDS_CACHE = "BrandStandardsCache";
    
    public static List<StandardsLocale> getAllLocales() throws SystemException
    {
        List<StandardsLocale> standardsLocale;
        if(Validator.isNotNull(MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).get(LANGUAGE_MAP))){
            standardsLocale = new ArrayList<StandardsLocale>(((Map<String, StandardsLocale>)MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).get(LANGUAGE_MAP)).values());
        } else {
            LinkedHashMap<String, StandardsLocale> languageMap = new LinkedHashMap<String, StandardsLocale>();
            standardsLocale = StandardsLocaleLocalServiceUtil.getStandardsLocales(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            for(StandardsLocale locale : standardsLocale)
            {
                languageMap.put(locale.getLocaleCode(), locale);
            }
            MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).put(LANGUAGE_MAP, languageMap);
        }
        return standardsLocale;
    }
    
    public static Map<String, StandardsRegion> getAllRegion() throws SystemException
    {
        LinkedHashMap<String, StandardsRegion> standardsRegion = new LinkedHashMap<String, StandardsRegion>();
        if(Validator.isNotNull(MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).get(REGION_MAP))) {
            standardsRegion = (LinkedHashMap<String, StandardsRegion>)MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).get(REGION_MAP);
        } else {
            List<StandardsRegion> standardsRgions = StandardsRegionLocalServiceUtil.getStandardsRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            for(StandardsRegion region : standardsRgions)
            {
                standardsRegion.put(region.getRegionName(), region);
            }
            MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).put(REGION_MAP, standardsRegion);
        }
        return standardsRegion;
    }
    
    
    public static StandardsLocale getStandardsLocaleByLocaleCd(String localeCd) throws SystemException
    {
        StandardsLocale standardsLocale;
        if(Validator.isNotNull(MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).get(LANGUAGE_MAP))) {
            standardsLocale = ((Map<String, StandardsLocale>)MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).get(LANGUAGE_MAP)).get(localeCd);
        } else {
            LinkedHashMap<String, StandardsLocale> languageMap = new LinkedHashMap<String, StandardsLocale>();
            List<StandardsLocale> standardsLocales = StandardsLocaleLocalServiceUtil.getStandardsLocales(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            for(StandardsLocale locale : standardsLocales)
            {
                languageMap.put(locale.getLocaleCode(), locale);
            }
            MultiVMPoolUtil.getCache(BRAND_STANDARDS_CACHE).put(LANGUAGE_MAP, languageMap);
            standardsLocale = languageMap.get(localeCd);
        }
        return standardsLocale;
    }
}
