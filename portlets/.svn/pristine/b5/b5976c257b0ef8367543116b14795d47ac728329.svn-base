/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.util;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.JobQueue;
import com.ihg.brandstandards.db.model.StandardsCountry;
import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.brandstandards.xml.metadata.FieldType;
import com.ihg.brandstandards.xml.metadata.Metadata;
import com.ihg.brandstandards.xml.metadata.MetadataValidationEventHandler;
import com.ihg.brandstandards.xml.metadata.ObjectFactory;
import com.ihg.brandstandards.xml.metadata.ParamList;
import com.ihg.brandstandards.xml.metadata.ParamType;
import com.ihg.brandstandards.xml.metadata.Search;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.utils.session.MerlinCache;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="BrandStandardsUtil.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Niranjan Khandekar
 */
public class BrandStandardsUtil
{
    private static final String BS_SEARCH_RESULT_COMPLIANCEDEADLINE_MSG = "bs.search.result.compliancedeadline.msg";

    private static final Log LOG = LogFactoryUtil.getLog(BrandStandardsUtil.class);
    

    private static Map<String, String> REGIONS;
    private static Map<String, Map<String, String>> COUNTRIES;
    public static final String REGION_GLBL = "GLBL";
    public static final String REGION_AMER = "AMER";
    public static final String REGION_AMEA = "AMEA";
    public static final String REGION_EUROPE = "EURO";
    public static final String REGION_GC = "GC";

    public static final String MAP_ATTR_NAME_HOLIDEX = "HLDX_CD";
    public static final String MAP_ATTR_NAME_REGION = "REGION";
    public static final String MAP_ATTR_NAME_COUNTRY = "COUNTRY";
    public static final String MAP_ATTR_NAME_BRAND = "BRAND";
    public static final String MAP_ATTR_NAME_CHAIN = "CHAIN";
    public static final String MAP_ATTR_NAME_HOTELNAME = "HOTELNM";
    
    
    private static final Map<String, String> ctryMap;
    static
    {
        ctryMap = new LinkedHashMap<String, String>();
        ctryMap.put("AMER", "---AMER---");
        ctryMap.put("ARG", "Argentina");
        ctryMap.put("ABW", "Aruba");
        ctryMap.put("BHS", "Bahamas");
        ctryMap.put("BMU", "Bermuda");
        ctryMap.put("BRA", "Brazil");
        ctryMap.put("CAN", "Canada");
        ctryMap.put("CYM", "Cayman Islands");
        ctryMap.put("CHL", "Chile");
        ctryMap.put("COL", "Colombia");
        ctryMap.put("CRI", "Costa Rica");
        ctryMap.put("DOM", "Dominican Republic");
        ctryMap.put("ECU", "Ecuador");
        ctryMap.put("SLV", "El Salvador");
        ctryMap.put("GTM", "Guatemala");
        ctryMap.put("HND", "Honduras");
        ctryMap.put("JAM", "Jamaica");
        ctryMap.put("MEX", "Mexico");
        ctryMap.put("NIC", "Nicaragua");
        ctryMap.put("PAN", "Panama");
        ctryMap.put("PRY", "Paraguay");
        ctryMap.put("PER", "Peru");
        ctryMap.put("PRI", "Puerto Rico");
        ctryMap.put("TTO", "Trinidad And Tobago");
        ctryMap.put("USA", "United States");
        ctryMap.put("URY", "Uruguay");
        ctryMap.put("VIR", "US Virgin Islands");
        ctryMap.put("VEN", "Venezuela");
        ctryMap.put("EURO", "---EURO---");
        ctryMap.put("AND", "Andorra");
        ctryMap.put("AUT", "Austria");
        ctryMap.put("AZE", "Azerbaijan");
        ctryMap.put("BLR", "Belarus");
        ctryMap.put("BEL", "Belgium");
        ctryMap.put("BGR", "Bulgaria");
        ctryMap.put("CYP", "Cyprus");
        ctryMap.put("CZE", "Czech Republic");
        ctryMap.put("DNK", "Denmark");
        ctryMap.put("FIN", "Finland");
        ctryMap.put("FRA", "France");
        ctryMap.put("GEO", "Georgia");
        ctryMap.put("DEU", "Germany");
        ctryMap.put("GRC", "Greece");
        ctryMap.put("HUN", "Hungary");
        ctryMap.put("IRL", "Ireland");
        ctryMap.put("ISR", "Israel");
        ctryMap.put("ITA", "Italy");
        ctryMap.put("KAZ", "Kazakhstan");
        ctryMap.put("LTU", "Lithuania");
        ctryMap.put("MKD", "Macedonia, Republic Of");
        ctryMap.put("MLT", "Malta");
        ctryMap.put("NLD", "Netherlands (Holland)");
        ctryMap.put("NIR", "Northern Ireland");
        ctryMap.put("POL", "Poland");
        ctryMap.put("PRT", "Portugal");
        ctryMap.put("ROU", "Romania");
        ctryMap.put("RUS", "Russia");
        ctryMap.put("SCG", "Serbia");
        //We do have two country codes for Serbia in our system.
        ctryMap.put("SRB", "Serbia");
        ctryMap.put("SVK", "Slovakia");
        ctryMap.put("ESP", "Spain");
        ctryMap.put("CHE", "Switzerland");
        ctryMap.put("TUR", "Turkey");
        ctryMap.put("UKR", "Ukraine");
        ctryMap.put("GBR", "United Kingdom");
        ctryMap.put("UZB", "Uzbekistan");
        ctryMap.put("AMEA", "---AMEA---");
        ctryMap.put("DZA", "Algeria");
        ctryMap.put("AUS", "Australia");
        ctryMap.put("BHR", "Bahrain");
        ctryMap.put("BGD", "Bangladesh");
        ctryMap.put("KHM", "Cambodia");
        ctryMap.put("EGY", "Egypt");
        ctryMap.put("FJI", "Fiji Islands");
        ctryMap.put("PYF", "French Polynesia/Tahiti");
        ctryMap.put("GHA", "Ghana");
        ctryMap.put("IND", "India");
        ctryMap.put("IDN", "Indonesia");
        ctryMap.put("JPN", "Japan");
        ctryMap.put("JOR", "Jordan");
        ctryMap.put("KEN", "Kenya");
        ctryMap.put("KOR", "Korea, Republic Of");
        ctryMap.put("KWT", "Kuwait");
        ctryMap.put("LAO", "Laos");
        ctryMap.put("LBN", "Lebanon");
        ctryMap.put("LBY", "Libyan Arab Jamahiriya");
        ctryMap.put("MYS", "Malaysia");
        ctryMap.put("MDV", "Maldives");
        ctryMap.put("MUS", "Mauritius");
        ctryMap.put("MAR", "Morocco");
        ctryMap.put("NPL", "Nepal");
        ctryMap.put("NZL", "New Zealand");
        ctryMap.put("NGA", "Nigeria");
        ctryMap.put("OMN", "Oman");
        ctryMap.put("PAK", "Pakistan");
        ctryMap.put("PSE", "Palestine Authority");
        ctryMap.put("PNG", "Papua New Guinea");
        ctryMap.put("PHL", "Philippines");
        ctryMap.put("QAT", "Qatar");
        ctryMap.put("SAU", "Saudi Arabia");
        ctryMap.put("SEN", "Senegal");
        ctryMap.put("SGP", "Singapore");
        ctryMap.put("ZAF", "South Africa");
        ctryMap.put("LKA", "Sri Lanka");
        ctryMap.put("SYR", "Syria");
        ctryMap.put("TZA", "Tanzania");
        ctryMap.put("THA", "Thailand");
        ctryMap.put("TUN", "Tunisia");
        ctryMap.put("UGA", "Uganda");
        ctryMap.put("ARE", "United Arab Emirates");
        ctryMap.put("VUT", "Vanuatu");
        ctryMap.put("VNM", "Vietnam");
        ctryMap.put("ZMB", "Zambia");
        ctryMap.put("ZWE", "Zimbabwe");
        ctryMap.put("GC", "---GC---");
        ctryMap.put("CHN", "China Mainland");
        ctryMap.put("HKG", "Hong Kong");
        ctryMap.put("MAC", "Macau");
        ctryMap.put("TUN", "Tunisia");
        ctryMap.put("TWN", "Taiwan");
    }
    
    private static final Map<String, String> amerOptions;
    static 
    {
        amerOptions = new LinkedHashMap<String, String>();
        amerOptions.put("ARG", "Argentina");
        amerOptions.put("ABW", "Aruba");
        amerOptions.put("BHS", "Bahamas");
        amerOptions.put("BMU", "Bermuda");
        amerOptions.put("BRA", "Brazil");
        amerOptions.put("CAN", "Canada");
        amerOptions.put("CYM", "Cayman Islands");
        amerOptions.put("CHL", "Chile");
        amerOptions.put("COL", "Colombia");
        amerOptions.put("CRI", "Costa Rica");
        amerOptions.put("DOM", "Dominican Republic");
        amerOptions.put("ECU", "Ecuador");
        amerOptions.put("SLV", "El Salvador");
        amerOptions.put("GTM", "Guatemala");
        amerOptions.put("HND", "Honduras");
        amerOptions.put("JAM", "Jamaica");
        amerOptions.put("MEX", "Mexico");
        amerOptions.put("NIC", "Nicaragua");
        amerOptions.put("PAN", "Panama");
        amerOptions.put("PRY", "Paraguay");
        amerOptions.put("PER", "Peru");
        amerOptions.put("PRI", "Puerto Rico");
        amerOptions.put("TTO", "Trinidad And Tobago");
        amerOptions.put("USA", "United States");
        amerOptions.put("URY", "Uruguay");
        amerOptions.put("VIR", "US Virgin Islands");
        amerOptions.put("VEN", "Venezuela");
    }

    private static final Map<String, String> euOptions;
    static
    {
        euOptions = new LinkedHashMap<String, String>();
        euOptions.put("AND", "Andorra");
        euOptions.put("AUT", "Austria");
        euOptions.put("AZE", "Azerbaijan");
        euOptions.put("BLR", "Belarus");
        euOptions.put("BEL", "Belgium");
        euOptions.put("BGR", "Bulgaria");
        euOptions.put("CYP", "Cyprus");
        euOptions.put("CZE", "Czech Republic");
        euOptions.put("DNK", "Denmark");
        euOptions.put("FIN", "Finland");
        euOptions.put("FRA", "France");
        euOptions.put("GEO", "Georgia");
        euOptions.put("DEU", "Germany");
        euOptions.put("GRC", "Greece");
        euOptions.put("HUN", "Hungary");
        euOptions.put("IRL", "Ireland");
        euOptions.put("ISR", "Israel");
        euOptions.put("ITA", "Italy");
        euOptions.put("KAZ", "Kazakhstan");
        euOptions.put("LTU", "Lithuania");
        euOptions.put("MKD", "Macedonia, Republic Of");
        euOptions.put("MLT", "Malta");
        euOptions.put("NLD", "Netherlands (Holland)");
        euOptions.put("NIR", "Northern Ireland");
        euOptions.put("POL", "Poland");
        euOptions.put("PRT", "Portugal");
        euOptions.put("ROU", "Romania");
        euOptions.put("RUS", "Russia");
        euOptions.put("SCG", "Serbia");
        euOptions.put("SVK", "Slovakia");
        euOptions.put("ESP", "Spain");
        euOptions.put("CHE", "Switzerland");
        euOptions.put("TUR", "Turkey");
        euOptions.put("UKR", "Ukraine");
        euOptions.put("GBR", "United Kingdom");
        euOptions.put("UZB", "Uzbekistan");
    }
    
    private static final Map<String, String> ameaOptions;
    static
    {
        ameaOptions = new LinkedHashMap<String, String>();
        ameaOptions.put("DZA", "Algeria");
        ameaOptions.put("AUS", "Australia");
        ameaOptions.put("BHR", "Bahrain");
        ameaOptions.put("BGD", "Bangladesh");
        ameaOptions.put("KHM", "Cambodia");
        ameaOptions.put("EGY", "Egypt");
        ameaOptions.put("FJI", "Fiji Islands");
        ameaOptions.put("PYF", "French Polynesia/Tahiti");
        ameaOptions.put("GHA", "Ghana");
        ameaOptions.put("IND", "India");
        ameaOptions.put("IDN", "Indonesia");
        ameaOptions.put("JPN", "Japan");
        ameaOptions.put("JOR", "Jordan");
        ameaOptions.put("KEN", "Kenya");
        ameaOptions.put("KOR", "Korea, Republic Of");
        ameaOptions.put("KWT", "Kuwait");
        ameaOptions.put("LAO", "Laos");
        ameaOptions.put("LBN", "Lebanon");
        ameaOptions.put("LBY", "Libyan Arab Jamahiriya");
        ameaOptions.put("MYS", "Malaysia");
        ameaOptions.put("MDV", "Maldives");
        ameaOptions.put("MUS", "Mauritius");
        ameaOptions.put("MAR", "Morocco");
        ameaOptions.put("NPL", "Nepal");
        ameaOptions.put("NZL", "New Zealand");
        ameaOptions.put("NGA", "Nigeria");
        ameaOptions.put("OMN", "Oman");
        ameaOptions.put("PAK", "Pakistan");
        ameaOptions.put("PSE", "Palestine Authority");
        ameaOptions.put("PNG", "Papua New Guinea");
        ameaOptions.put("PHL", "Philippines");
        ameaOptions.put("QAT", "Qatar");
        ameaOptions.put("SAU", "Saudi Arabia");
        ameaOptions.put("SEN", "Senegal");
        ameaOptions.put("SGP", "Singapore");
        ameaOptions.put("ZAF", "South Africa");
        ameaOptions.put("LKA", "Sri Lanka");
        ameaOptions.put("SYR", "Syria");
        ameaOptions.put("TZA", "Tanzania");
        ameaOptions.put("THA", "Thailand");
        ameaOptions.put("TUN", "Tunisia");
        ameaOptions.put("UGA", "Uganda");
        ameaOptions.put("ARE", "United Arab Emirates");
        ameaOptions.put("VUT", "Vanuatu");
        ameaOptions.put("VNM", "Vietnam");
        ameaOptions.put("ZMB", "Zambia");
        ameaOptions.put("ZWE", "Zimbabwe");
    }
    
    private static final Map<String, String> gcOptions;
    static
    {
        gcOptions = new LinkedHashMap<String, String>();
        gcOptions.put("CHN", "China Mainland");
        gcOptions.put("HKG", "Hong Kong");
        gcOptions.put("MAC", "Macau");
        gcOptions.put("TWN", "Taiwan");
    }
    
    private static final Map<String, String> fileTypes;
    static 
    {
        fileTypes = new LinkedHashMap<String, String>();
        // key length must be up to 20 characters - limited by database 
        fileTypes.put("", "Select a Type");
        fileTypes.put("SOP", "Standard Operating Procedure (SOP)");
        fileTypes.put("MSOP", "Measurement SOP");
        fileTypes.put("GUIDELINE", "Guideline");
        fileTypes.put("NOTES", "Briefing Notes");
        fileTypes.put("DE_GUIDELINE", "Design & Engineering Guideline");
        fileTypes.put("CC_GUIDELINE", "Communications Guideline");
        fileTypes.put("CC_TEMPLATE", "Communications Template");
        fileTypes.put("HTL_RDY_PLN", "Hotel Ready Plan");
        fileTypes.put("INTNL_TRAINING", "Internal Training");
        fileTypes.put("HTL_TRAINING", "Hotel Training");
        fileTypes.put("IMPL_PLAN", "Implementation Plan");
        fileTypes.put("AMD_CHNG_IMPACT", "Amendment Change Impact");
        fileTypes.put("STD_FORM", "Standards Form");
        fileTypes.put("PILOT_RESULTS", "Pilot Results");
        fileTypes.put("REVIEW_SUMMARY", "Review Summary");
        fileTypes.put("TABLE", "Table");
    }


    /**
     * @param chain This is a String object
     * @return String
     */
    @SuppressWarnings("unchecked")
    public static String decodeChainCode(final String chain)
    {
        Map<String, String> chnCdMap = null;
        if (MerlinCache.getCacheMap("BRNDSTD_CHN") != null) {
            final Map<String, Object> chnFullMap = (Map<String, Object>) MerlinCache.getCacheMap("BRNDSTD_CHN");
            chnCdMap = (Map<String, String>) chnFullMap.get("SECURITY_VALUES");
        } else {
            LOG.warn("MerlinCache.getCacheMap(\"BRNDSTD_CHN\") is null. Chain code not available in merlin session and loading static chain codes.");
            chnCdMap = new LinkedHashMap<String, String>();
            chnCdMap.put("IC", "InterContinental Hotels");
            chnCdMap.put("IR", "InterContinental Resorts");
            chnCdMap.put("HI", "Holiday Inn");
            chnCdMap.put("EX", "Holiday Inn Express");
            chnCdMap.put("RS", "Holiday Inn Resort");
            chnCdMap.put("CV", "Holiday Inn Club Vacations");
            chnCdMap.put("CP", "Crowne Plaza Hotels");
            chnCdMap.put("CR", "Crowne Plaza Resorts");
            chnCdMap.put("UL", "HUALUXE Hotels & Resorts");
            chnCdMap.put("IN", "Hotel Indigo");
            chnCdMap.put("VN", "EVEN Hotels");
            chnCdMap.put("SB", "Staybridge Suites");
            chnCdMap.put("CW", "Candlewood Suites");
            chnCdMap.put("VA", "avid hotels");
        }

        final StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : chnCdMap.entrySet())
        {
            if (chain.contains(entry.getKey()))
            {
                if (builder.length() > 0)
                {
                    builder.append(", ");
                }
                builder.append(entry.getValue());
            }
        }
        return builder.toString();
    }

    /**
     * Verify if Map is null or empty.
     * 
     * @param obj This is a Map object
     * @return boolean
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNullOrBlank(final Map obj)
    {
        return obj == null || obj.isEmpty();
    }

    /**
     * Verify if List is null or empty.
     * 
     * @param obj This is a List object
     * @return boolean
     */
    @SuppressWarnings("rawtypes")
    public static boolean isNullOrBlank(final List obj)
    {
        return obj == null || obj.isEmpty();
    }

    /**
     * Verify of value of object is null or empty string.
     * 
     * @param obj This is a Object type object
     * @return boolean
     */
    public static boolean IsNullOrBlank(final Object obj)
    {
        return obj == null || obj.toString().isEmpty();
    }

    /**
     * Get string value or empty string.
     * 
     * @param obj This is of type Object
     * @return String
     */
    public static String getValueOrBlank(final Object obj)
    {
        return obj == null ? "" : obj.toString();
    }

    /**
     * get year from date.
     * 
     * @param date This is a Date object
     * @return int
     */
    public static int getYearFromDate(Date date)
    {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * @return Map<String, String>
     */
    public static Map<String, String> countryMap()
    {
    	BSLanguageUtil adminLanguageUtil = new BSLanguageUtil("en_GB", BSCommonConstants.ELEMENT_MODULE_BRIDGE);
        List<String> ctryList = null;
        Map<String, String> ctryMap = new LinkedHashMap<String, String>();
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        Map<String, String> sortedCtryMap = new LinkedHashMap<String, String>();
        Map<String, String> euroCtryMap = new LinkedHashMap<String, String>();
        Map<String, String> ameaCtryMap = new LinkedHashMap<String, String>();
        Map<String, String> restCtryMap = new LinkedHashMap<String, String>();
        
        List<StandardsRegion> parentRegionsList = new ArrayList<StandardsRegion>();
		parentRegionsList = StandardsRegionLocalServiceUtil.getStandardsParentRegionsList();
			
		for(StandardsRegion stdRegion : parentRegionsList )
		{
			if(!stdRegion.getRegionCode().equals(BrandStandardsConstant.REGION_GLOBAL)){
				ctryMap.put(stdRegion.getRegionCode(), "---"+stdRegion.getRegionCode()+"---");
				ctryList = StandardsCountryExtLocalServiceUtil.getCountryListByRegionCode(stdRegion.getRegionCode());
				for(String ctryCode : ctryList)
				{
					ctryMap.put(ctryCode, adminLanguageUtil.get("bs.country.name.cd." + ctryCode.toLowerCase() ));
				}
				if(stdRegion.getRegionCode().equals(BrandStandardsConstant.REGION_EUROPE)){
					euroCtryMap = sortByComparator(ctryMap);
					sortedMap.putAll(euroCtryMap);
					sortedMap.putAll(ameaCtryMap);
				}
				else if(stdRegion.getRegionCode().equals(BrandStandardsConstant.REGION_AMEA)){
					ameaCtryMap = sortByComparator(ctryMap);
				}
				else
				{
					restCtryMap = sortByComparator(ctryMap);
					sortedMap.putAll(restCtryMap);
					restCtryMap.clear();
				}
				sortedCtryMap.putAll(sortedMap);
				ctryList.clear();
				ctryMap.clear();
			}
		}

		
        return sortedCtryMap;
    }
    
    /**
     * @return Map<String, String>
     * Returns map sorted by value.
     */
    private static Map<String, String> sortByComparator(Map<String, String> unsortMap)
    {

        List<Entry<String, String>> list = new LinkedList<Entry<String, String>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, String>>()
        {
            public int compare(Entry<String, String> o1,
                    Entry<String, String> o2)
            {
            	return o1.getValue().compareTo(o2.getValue());
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, String> sortedMap = new LinkedHashMap<String, String>();
        for (Entry<String, String> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
    

    /**
     * @return Map<String, Map<String, String>>
     */
    public static Map<String, Map<String, String>> getCountryByRegionsMap()
    {
        if (COUNTRIES == null)
        {
            COUNTRIES = new LinkedHashMap<String, Map<String, String>>();
            BSLanguageUtil adminLanguageUtil = new BSLanguageUtil("en_GB", BSCommonConstants.ELEMENT_MODULE_BRIDGE);
            List<StandardsRegion> prntRegionList = StandardsRegionLocalServiceUtil.getStandardsParentRegionsList();
            for(StandardsRegion region : prntRegionList){
            	
            	if(region.getRegionCode().equals(REGION_AMER))
            	{
            		List<String> ctryList = StandardsCountryExtLocalServiceUtil.getCountryListByRegionCode(region.getRegionCode());
            		
            		for(String ctryCode : ctryList)
    				{
    					amerOptions.put(ctryCode, adminLanguageUtil.get("bs.country.name.cd." + ctryCode.toLowerCase() ));
    				}
	            	COUNTRIES.put(REGION_AMER, amerOptions);
            	}
            	else if(region.getRegionCode().equals(REGION_AMEA))
            	{
            		List<String> ctryList = StandardsCountryExtLocalServiceUtil.getCountryListByRegionCode(region.getRegionCode());
            		
            		for(String ctryCode : ctryList)
    				{
    					ameaOptions.put(ctryCode, adminLanguageUtil.get("bs.country.name.cd." + ctryCode.toLowerCase() ));
    				}
	            	COUNTRIES.put(REGION_AMEA, ameaOptions);
            	}
            	else if(region.getRegionCode().equals(REGION_EUROPE))
            	{
            		List<String> ctryList = StandardsCountryExtLocalServiceUtil.getCountryListByRegionCode(region.getRegionCode());
            		
            		for(String ctryCode : ctryList)
    				{
    					euOptions.put(ctryCode, adminLanguageUtil.get("bs.country.name.cd." + ctryCode.toLowerCase() ));
    				}
	            	COUNTRIES.put(REGION_EUROPE, euOptions);
            	}
            	else if(region.getRegionCode().equals(REGION_GC))
            	{
            		List<String> ctryList = StandardsCountryExtLocalServiceUtil.getCountryListByRegionCode(region.getRegionCode());
            		
            		for(String ctryCode : ctryList)
    				{
    					gcOptions.put(ctryCode, adminLanguageUtil.get("bs.country.name.cd." + ctryCode.toLowerCase() ));
    				}
	            	COUNTRIES.put(REGION_GC, gcOptions);
            	}
            }
            
        }
        return COUNTRIES;
    }

    /**
     * @return Map<String, String>
     */
    public static synchronized Map<String, String> getRegions()
    {
        if (REGIONS == null)
        {
            REGIONS = new LinkedHashMap<String, String>();
            REGIONS.put(REGION_AMEA, "AMEA");
            REGIONS.put(REGION_AMER, "Americas");
            REGIONS.put(REGION_EUROPE, "Europe");
            REGIONS.put(REGION_GC, "Greater China");
        }
        return REGIONS;
    }

    /**
     * @param publishedDate This is aDate object
     * @param localeCD This is a String object
     * @return String
     */
    public static String getFormatedDate(Date publishedDate, String localeCD, BSLanguageUtil obsmLanguageUtil)
    {
        DateFormat formatter = new SimpleDateFormat(BrandStandardsConstant.DOWNLOAD_MANUAL_DATE_FORMAT);
        String formatedDate = formatter.format(publishedDate);
        StringBuilder newDate = new StringBuilder();
        String[] dateArr = formatedDate.split(" ");
        String year = dateArr[2];
        String month = dateArr[1];
        String day = dateArr[0];
        String monthValue = null;
        String dateConstant = null;
        String yearConstant = null;
        if (obsmLanguageUtil != null && Validator.isNotNull(obsmLanguageUtil.get("bs.month." + month.toLowerCase())))
        {
            monthValue = obsmLanguageUtil.get("bs.month." + month.toLowerCase());
            dateConstant = obsmLanguageUtil.get("bs.constant.day");
            yearConstant = obsmLanguageUtil.get("bs.constant.year");
        }

        if (BrandStandardsConstant.CHINESE_LOCALE_CD.equalsIgnoreCase(localeCD))
        {
            newDate.append(year);
            if (Validator.isNotNull(yearConstant))
            {
                newDate.append(yearConstant);
            }
            if (Validator.isNotNull(monthValue))
            {
                newDate.append(monthValue);
            }
            else if (Validator.isNotNull(month))
            {
                newDate.append(month);
            }

            newDate.append(day);
            if (Validator.isNotNull(dateConstant))
            {
                newDate.append(dateConstant);
            }
        }
        else
        {
            newDate.append(day);
            newDate.append(StringPool.SPACE);
            if (Validator.isNotNull(monthValue))
            {
                newDate.append(monthValue);
            }
            else if (Validator.isNotNull(month))
            {
                newDate.append(month);
            }
            newDate.append(StringPool.SPACE);
            newDate.append(year);
        }

        if (LOG.isDebugEnabled())
        {
            LOG.debug("Language code :" + localeCD);
            LOG.debug("published date :" + newDate.toString());
        }

        return newDate.toString();
    }
    
    /**
     * This method will return the translated date based language & date params passed to it. 
     * This just a utility method. We have written this method here because this method is called form Navigation.vm.
     * @author Lakshminarayana Mummanedi
     * @param publishedDate
     * @param localeCD
     * @return String
     */
    public static String getFormatedDate(Date publishedDate, String localeCD, Map<String, String> obsmLanguageUtil)
    {
        DateFormat formatter = new SimpleDateFormat(BrandStandardsConstant.DOWNLOAD_MANUAL_DATE_FORMAT);
        String formatedDate = formatter.format(publishedDate);
        StringBuilder newDate = new StringBuilder();
        String[] dateArr = formatedDate.split(" ");
        String year = dateArr[2];
        String month = dateArr[1];
        String day = dateArr[0];
        String monthValue = null;
        if (Validator.isNotNull(obsmLanguageUtil.get("bs.month." + month.toLowerCase())))
        {
            monthValue = obsmLanguageUtil.get("bs.month." + month.toLowerCase());
        }

        if (BrandStandardsConstant.CHINESE_LOCALE_CD.equalsIgnoreCase(localeCD))
        {
            newDate.append(year);
            String dateConstant = obsmLanguageUtil.get("bs.constant.day");
            String yearConstant = obsmLanguageUtil.get("bs.constant.year");
            if (Validator.isNotNull(yearConstant))
            {
                newDate.append(yearConstant);
            }
            if (Validator.isNotNull(monthValue))
            {
                newDate.append(monthValue);
            }
            else if (Validator.isNotNull(month))
            {
                newDate.append(month);
            }

            newDate.append(day);
            if (Validator.isNotNull(dateConstant))
            {
                newDate.append(dateConstant);
            }
        }
        else
        {
            newDate.append(day);
            newDate.append(StringPool.SPACE);
            if (Validator.isNotNull(monthValue))
            {
                newDate.append(monthValue);
            }
            else if (Validator.isNotNull(month))
            {
                newDate.append(month);
            }
            newDate.append(StringPool.SPACE);
            newDate.append(year);
        }

        if (LOG.isDebugEnabled())
        {
            LOG.debug("Language code :" + localeCD);
            LOG.debug("published date :" + newDate.toString());
        }

        return newDate.toString();
    }

    /**
     * @return Map<String, String>
     */
    public static Map<String, String> fileTypes()
    {
        return fileTypes;
    }

    /**
     * @param attributeValue This is a String object
     * @return String
     */
    public static String formatPeopleDBAttributeValue(String attributeValue)
    {
        return attributeValue.replaceAll(StringPool.COMMA, StringPool.DASH);
    }

    /**
     * @param locationId This is a String object
     * @return Map<String, String>
     */
    public static Map<String, String> getHotelOfficeMap(String locationId)
    {
        Map<String, String> htlOffMap = new HashMap<String, String>();
        Map<String, String> attributeMap = null;
        Map<String, Map<String, String>> hotelOfficeMap = (Map<String, Map<String, String>>) MerlinCache.getCacheMap("HTL").get(
                "SECURITY_VALUES");

        if (!hotelOfficeMap.containsKey(locationId))
        {
            hotelOfficeMap = (Map<String, Map<String, String>>) MerlinCache.getCacheMap("OFC").get("SECURITY_VALUES");

            if (LOG.isDebugEnabled())
            {
                LOG.debug("Hotel Map does not contain  Location Id: " + locationId);
            }
        }

        if (hotelOfficeMap.containsKey(locationId))
        {
            attributeMap = (Map<String, String>) hotelOfficeMap.get(locationId);

            if (attributeMap.containsKey(MAP_ATTR_NAME_HOLIDEX))
            {
                String holidexCode = BrandStandardsUtil.formatPeopleDBAttributeValue(attributeMap.get(MAP_ATTR_NAME_HOLIDEX));
                htlOffMap.put("holidexCode", holidexCode);
            }
            if (attributeMap.containsKey(MAP_ATTR_NAME_REGION))
            {
                String region = BrandStandardsUtil.formatPeopleDBAttributeValue(attributeMap.get(MAP_ATTR_NAME_REGION));
                htlOffMap.put("region", region);
            }
            if (attributeMap.containsKey(MAP_ATTR_NAME_COUNTRY))
            {
                String country = BrandStandardsUtil.formatPeopleDBAttributeValue(attributeMap.get(MAP_ATTR_NAME_COUNTRY));
                String ctry = country.substring(country.indexOf("[") + 1, country.lastIndexOf("]"));
                htlOffMap.put("country", ctry);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("country for user:" + country);
                }
            }
            if (attributeMap.containsKey(MAP_ATTR_NAME_BRAND))
            {
                String brand = BrandStandardsUtil.formatPeopleDBAttributeValue(attributeMap.get(MAP_ATTR_NAME_BRAND));
                String brnd = brand.substring(brand.indexOf("[") + 1, brand.lastIndexOf("]"));
                htlOffMap.put("brand", brnd);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("brand substr for user:" + brnd);
                }
            }
            if (attributeMap.containsKey(MAP_ATTR_NAME_CHAIN))
            {
                String chain = BrandStandardsUtil.formatPeopleDBAttributeValue(attributeMap.get(MAP_ATTR_NAME_CHAIN));
                String chn = chain.substring(chain.indexOf("[") + 1, chain.lastIndexOf("]"));
                htlOffMap.put("chain", chn);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("value retrieved from chain is " + chn);
                    LOG.debug("chain for user:" + chain);
                }
            }
            if (attributeMap.containsKey(MAP_ATTR_NAME_HOTELNAME))
            {
                String hotelName = BrandStandardsUtil.formatPeopleDBAttributeValue(attributeMap.get(MAP_ATTR_NAME_HOTELNAME));
                htlOffMap.put("hotelName", hotelName);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("hotelName for user:" + hotelName);
                }
            }
        }

        return htlOffMap;
    }

    /**
     * @param attributeName This is a String object
     * @param attributeValue This is a String object
     * @return String
     */
    public static String formatPeopleDBAttributeValue(String attributeName, String attributeValue)
    {
        String formattedValue = attributeValue;

        if (Validator.isNotNull(attributeValue) && attributeValue.contains(StringPool.OPEN_BRACKET)
                && attributeValue.contains(StringPool.CLOSE_BRACKET))
        {
            int startWithIndex = attributeValue.indexOf(StringPool.OPEN_BRACKET);
            formattedValue = attributeValue.substring(0, startWithIndex);

            if (formattedValue.contains(StringPool.COMMA))
            {
                StringBuilder sb = new StringBuilder(StringPool.BLANK);

                String[] arrStr = formattedValue.split(StringPool.COMMA);

                for (int i = 0; i < arrStr.length; i++)
                {
                    sb.append(arrStr[i].trim());

                    if (i != arrStr.length - 1)
                    {
                        sb.append(StringPool.COMMA);
                        sb.append(StringPool.SPACE);
                    }
                }

                formattedValue = sb.toString().trim().toUpperCase();

                if (formattedValue.startsWith(StringPool.COMMA) || formattedValue.startsWith(StringPool.DASH))
                {
                    formattedValue = formattedValue.substring(1, formattedValue.length());
                }
            }

            if (LOG.isDebugEnabled())
            {
                LOG.debug("formattedValue is:" + formattedValue);
            }
        }

        return formattedValue;
    }

    /**
     * @param duplicatesList This is a List<String> object
     * @return List<String>
     */
    public static final List<String> removeDuplicates(List<String> duplicatesList)
    {
        List<String> uniqueList = new ArrayList<String>();
        HashSet<String> hs = new HashSet<String>();
        hs.addAll(duplicatesList);
        uniqueList.addAll(hs);

        return uniqueList;
    }

    /**
     * @param stdId This is a long object
     * @param stdIds This is of type Object
     * @return String
     */
    public static String getStdnardIds(long stdId, Object stdIds)
    {
        List<Long> publishStdIds = null;
        StringBuilder sb = new StringBuilder();
        if (stdId == 0l && stdIds instanceof List<?>)
        {
            publishStdIds = (List<Long>) stdIds;
        }
        else if (stdId == 0l && stdIds instanceof String)
        {
            sb.append(stdId);
        }
        else if (stdId != 0l)
        {
            sb.append(stdId);
        }
        if (publishStdIds != null && publishStdIds.size() > 0)
        {

            for (long id : publishStdIds)
            {
                if (sb.length() > 0)
                    sb.append(',');
                sb.append(id);
            }
        }
        return sb.toString();
    }

    /**
     * @param countryCode This is a String object
     * @return String
     */
    public static String getCountryNameFromCode(String countryCode)
    {
        Map<String, String> countryMap = countryMap();
        String countryName = countryMap.get(countryCode).toString();

        return countryName;
    }

    /**
     * @param countryCode This is a String object
     * @return String
     */
    public static String getRegionByConuntryCode(String countryCode)
    {
        String regionName = null;
        Map<String, Map<String, String>> regionMap = getCountryByRegionsMap();
        for (Map.Entry<String, Map<String, String>> regionEntry : regionMap.entrySet())
        {
            Map<String, String> regionCountyMap = regionMap.get(regionEntry.getKey());
            if (regionCountyMap.containsKey(countryCode))
            {
                regionName = regionEntry.getKey();
                break;
            }
        }
        return regionName;
    }

    /**
     * @param str This is a String object
     * @return boolean
     */
    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?"); //match a number with optional '-' and decimal.
    }

    /**
     * @param criteria This is a StandardsSearchCriteria object
     * @param bsLocale This is a Locale object
     * @param resultCount This is a Integer object
     * @return String
     */
    public static String getSearchResultMessage(StandardsSearchCriteria criteria, String localeCD, int resultCount, BSLanguageUtil obsmLanguageUtil)
    {
        StringBuilder searchResumtMsg = new StringBuilder();
        boolean hasSearchText = false;
        boolean hasDepartments = false;
        boolean hasLocations = false;
        boolean hasGuestJourneyStage = false;
        boolean hasSupportingMaterial = false;
        boolean hasComplianceDeadline = false;
        boolean hasContentTypeFilters = false;
        boolean hasHotelLifecycle = false;
        boolean hasSpecialism = false;
        try
        {
            /** Building Search Test Message */
            if (criteria.getTextSearch() != null && !(criteria.getTextSearch().trim().isEmpty()))
            {
                hasSearchText = true;
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.yoursearchforacross.msg",
                        new Object[] { criteria.getTextSearch() }));
                searchResumtMsg.append(" ");
            }
            else
            {
                hasSearchText = false;
                searchResumtMsg.append(obsmLanguageUtil.get("bs.search.result.yoursearchacross.msg"));
                searchResumtMsg.append(" ");
            }

            /** CR 50.2 Building Hotel Lifecycle Message */
            List<String> lifecycle = criteria.getHotelLifecycleForDisplay();
            if (lifecycle != null && !lifecycle.isEmpty())
            {	
                hasHotelLifecycle = true;
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.hotel.lifecycle.msg", new Object[] { lifecycle.size() }));
                
            }
            
            /** Building Specialism Message */
            if (criteria.getSpecialism() != null && !criteria.getSpecialism().isEmpty())
            {
            	
                hasSpecialism = true;
                if (hasHotelLifecycle)
                {
                    searchResumtMsg.append(", ");
                }
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.specialism.msg", new Object[] { criteria.getSpecialism().size() }));
            }
            
            
            /** Building Departments Message */
            if (criteria.getDeptApplicability() != null && !criteria.getDeptApplicability().isEmpty())
            {
                hasDepartments = true;
                if (hasHotelLifecycle || hasSpecialism)
                {
                    searchResumtMsg.append(", ");
                }
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.departments.msg", new Object[] { criteria.getDeptApplicability().size() }));
            }
            
            /** Building Locations Hotel Message */
            if (criteria.getLocHotel() != null && !criteria.getLocHotel().isEmpty())
            {
                hasLocations = true;
                if (hasHotelLifecycle || hasSpecialism || hasDepartments)
                {
                    searchResumtMsg.append(", ");
                }
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.locations.msg", new Object[] { criteria.getLocHotel()
                                .size() }));
            }

            /** Building Guest Journey Stage Message */
            if (criteria.getGuestJourney() != null && !criteria.getGuestJourney().isEmpty())
            {
                hasGuestJourneyStage = true;
                if (hasHotelLifecycle || hasSpecialism || hasDepartments || hasLocations)
                {
                    searchResumtMsg.append(", ");
                }
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.guestjourneystage.msg", new Object[] { criteria.getGuestJourney().size() }));
            }

            /** Building SupportingMaterial Message */
            int noOfAttachments = 0;
            if (criteria.isHasAttachments())
            {
                hasSupportingMaterial = true;
                noOfAttachments++;
            }
            if (criteria.isHasImages())
            {
                hasSupportingMaterial = true;
                noOfAttachments++;
            }
            if (criteria.isHasLinks())
            {
                hasSupportingMaterial = true;
                noOfAttachments++;
            }
            if (criteria.isHasSOP())
            {
                hasSupportingMaterial = true;
                noOfAttachments++;
            }
            if (criteria.isHasTrainingMaterial())
            {
                hasSupportingMaterial = true;
                noOfAttachments++;
            }
            if (noOfAttachments > 0)
            {
                hasSupportingMaterial = true;
                if (hasHotelLifecycle || hasSpecialism || hasDepartments || hasLocations || hasGuestJourneyStage)
                {
                    searchResumtMsg.append(", ");
                }
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.supportingmaterial.msg", new Object[] { noOfAttachments }));
            }

            /** Building ComplianceDeadline Message */
            //String localeCD = bsLocale.getLanguage() + StringPool.UNDERLINE + bsLocale.getCountry();
            if (criteria.getComplianceDeadline() != null && !(criteria.getComplianceDeadline().trim().isEmpty()))
            {
                Calendar curr = Calendar.getInstance();
                //SimpleDateFormat dFormat = new SimpleDateFormat("dd MMM yyyy");
                hasComplianceDeadline = true;
                if (hasHotelLifecycle || hasSpecialism || hasDepartments || hasLocations || hasGuestJourneyStage || hasSupportingMaterial)
                {
                    searchResumtMsg.append(" ");
                    searchResumtMsg.append(obsmLanguageUtil.get("bs.and"));
                    searchResumtMsg.append(" ");
                }
                if ("0d".equalsIgnoreCase(criteria.getComplianceDeadline()))
                {

                    searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.compliancedeadline.setto.msg",
                            new Object[] { BrandStandardsUtil.getFormatedDate(curr.getTime(), localeCD, obsmLanguageUtil) }));
                    //dFormat.format(curr.getTime()) 
                }
                else if ("12m+".equalsIgnoreCase(criteria.getComplianceDeadline()))
                {
                    Calendar featureDate = Calendar.getInstance();
                    featureDate.add(Calendar.MONTH, +12);
                    searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.compliancedeadline.setbeyond.msg",
                            new Object[] { BrandStandardsUtil.getFormatedDate(featureDate.getTime(), localeCD, obsmLanguageUtil) }));
                }
                else if ("7d".equalsIgnoreCase(criteria.getComplianceDeadline()))
                {
                    Calendar featureCal = Calendar.getInstance();
                    featureCal.add(Calendar.DATE, +7);
                    searchResumtMsg.append(obsmLanguageUtil.format(BS_SEARCH_RESULT_COMPLIANCEDEADLINE_MSG,
                            new Object[] { BrandStandardsUtil.getFormatedDate(curr.getTime(), localeCD, obsmLanguageUtil),
                                    BrandStandardsUtil.getFormatedDate(featureCal.getTime(), localeCD, obsmLanguageUtil) }));
                }
                else if ("1m".equalsIgnoreCase(criteria.getComplianceDeadline()))
                {
                    Calendar featureCal = Calendar.getInstance();
                    featureCal.add(Calendar.MONTH, +1);
                    searchResumtMsg.append(obsmLanguageUtil.format(BS_SEARCH_RESULT_COMPLIANCEDEADLINE_MSG,
                            new Object[] { BrandStandardsUtil.getFormatedDate(curr.getTime(), localeCD, obsmLanguageUtil),
                                    BrandStandardsUtil.getFormatedDate(featureCal.getTime(), localeCD, obsmLanguageUtil) }));
                }
                else if ("3m".equalsIgnoreCase(criteria.getComplianceDeadline()))
                {
                    Calendar featureCal = Calendar.getInstance();
                    featureCal.add(Calendar.MONTH, +3);
                    searchResumtMsg.append(obsmLanguageUtil.format(BS_SEARCH_RESULT_COMPLIANCEDEADLINE_MSG,
                            new Object[] { BrandStandardsUtil.getFormatedDate(curr.getTime(), localeCD, obsmLanguageUtil),
                                    BrandStandardsUtil.getFormatedDate(featureCal.getTime(), localeCD, obsmLanguageUtil) }));
                }
                else if ("6m".equalsIgnoreCase(criteria.getComplianceDeadline()))
                {
                    Calendar featureCal = Calendar.getInstance();
                    featureCal.add(Calendar.MONTH, +6);
                    searchResumtMsg.append(obsmLanguageUtil.format(BS_SEARCH_RESULT_COMPLIANCEDEADLINE_MSG,
                            new Object[] { BrandStandardsUtil.getFormatedDate(curr.getTime(), localeCD, obsmLanguageUtil),
                                    BrandStandardsUtil.getFormatedDate(featureCal.getTime(), localeCD, obsmLanguageUtil) }));
                }
                else if ("12m".equalsIgnoreCase(criteria.getComplianceDeadline()))
                {
                    Calendar featureCal = Calendar.getInstance();
                    featureCal.add(Calendar.MONTH, +12);
                    searchResumtMsg.append(obsmLanguageUtil.format(BS_SEARCH_RESULT_COMPLIANCEDEADLINE_MSG,
                            new Object[] { BrandStandardsUtil.getFormatedDate(curr.getTime(), localeCD, obsmLanguageUtil),
                                    BrandStandardsUtil.getFormatedDate(featureCal.getTime(), localeCD, obsmLanguageUtil) }));
                }
            }

            if("WCO".equals(criteria.getScope())) {
	            /** Building Content Type Filters Message */
	            int noOfContentTypeFilters = 0;
	            if (criteria.isFilterByNew())
	            {
	                hasContentTypeFilters = true;
	                noOfContentTypeFilters++;
	            }
	            if (criteria.isFilterByTextUpdate())
	            {
	                hasContentTypeFilters = true;
	                noOfContentTypeFilters++;
	            }
	            if (criteria.isFilterByComplianceUpdate())
	            {
	                hasContentTypeFilters = true;
	                noOfContentTypeFilters++;
	            }
	            if (criteria.isFilterByLifecycleUpdate())
	            {
	                hasContentTypeFilters = true;
	                noOfContentTypeFilters++;
	            }
	            if (criteria.isFilterByRemoved())
	            {
	                hasContentTypeFilters = true;
	                noOfContentTypeFilters++;
	            }
	            if (noOfContentTypeFilters > 0)
	            {
	                hasContentTypeFilters = true;
	                if (hasHotelLifecycle || hasSpecialism || hasDepartments || hasLocations || hasGuestJourneyStage)
	                {
	                    searchResumtMsg.append(", ");
	                }
	                if (noOfContentTypeFilters > 1)
	                {
	                    searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.change.type.filters.msg",
	                            new Object[] { noOfContentTypeFilters }));
	                }
	                else
	                {
	                    searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.change.type.filter.msg",
	                            new Object[] { noOfContentTypeFilters }));
	                }
	            }
        	}

            /** Building Search Result Count Message */
            if (hasSearchText && !hasHotelLifecycle && !hasSpecialism  && !hasDepartments && !hasLocations && !hasGuestJourneyStage && !hasSupportingMaterial
                    && !hasComplianceDeadline && !hasContentTypeFilters)
            {
                /** Sending new Message */
                searchResumtMsg = new StringBuilder();
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.yoursearchfor.msg",
                        new Object[] { criteria.getTextSearch() }));
                searchResumtMsg.append(" ");
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.returned.matchingitems.msg", new Object[] { resultCount }));
            }
            else if (hasSearchText || hasHotelLifecycle || hasSpecialism || hasDepartments || hasLocations || hasGuestJourneyStage || hasSupportingMaterial
                    || hasComplianceDeadline || hasContentTypeFilters)
            {
                searchResumtMsg.append(" ");
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.returned.matchingitems.msg", new Object[] { resultCount }));
            }
            else
            {
                /** Sending new Message */
                searchResumtMsg = new StringBuilder();
                searchResumtMsg.append(obsmLanguageUtil.get("bs.search.result.yoursearch.msg"));
                searchResumtMsg.append(" ");
                searchResumtMsg.append(obsmLanguageUtil.format("bs.search.result.returned.matchingitems.msg", new Object[] { resultCount }));
            }
        }
        catch (Exception e)
        {
            LOG.error("Failed to generate Search Result Message", e);
        }

        return searchResumtMsg.toString();
    }

    /**
     * @param flagCategories This is a List<FlagCategory> object
     * @return List<FlagCategory>
     */
    public static List<FlagCategory> sortFlagCategories(List<FlagCategory> flagCategories)
    {
        List<FlagCategory> arlFlagCategory = new ArrayList<FlagCategory>(flagCategories);
        Collections.sort(arlFlagCategory, new CategoryComparator());
        return arlFlagCategory;
    }

    /**
     * This method will build metadata xml based on type and params and return the xml.
     * 
     * @param type (metadata type. Ex: "MYDOWNLOADS", "FULL_MANUAL_PDF", "MANUAL_PDF")
     * @param metadataParams ({["Download_IDS", "12327,12328"],...)
     * @param searchParamName ("Search_Criteria")
     * @param searchFields ({["Download_IDS", "12327,12328"],...)
     * @return String (XML String)
     */
    public static String buildJobQueueMetadataXML(String type, Map<String, String> metadataParams, String searchParamName,
            Map<String, String> searchFields)
    {
        StringWriter stringWriter = new StringWriter();
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Metadata.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setEventHandler(new MetadataValidationEventHandler());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);

            stringWriter = new StringWriter();
            ObjectFactory factory = new ObjectFactory();
            Metadata metadata = factory.createMetadata();
            ParamList paramList = factory.createParamList();

            if (metadataParams != null && !(metadataParams.isEmpty()))
            {
                List<ParamType> paramTypes = paramList.getParam();
                for (Map.Entry<String, String> paramEntry : metadataParams.entrySet())
                {
                    ParamType param = new ParamType();
                    param.setName(paramEntry.getKey());
                    param.setValue(paramEntry.getValue());
                    paramTypes.add(param);
                }
            }

            if (searchFields != null && !(searchFields.isEmpty()))
            {
                Search searchCriteria = factory.createSearch();
                searchCriteria.setName(searchParamName);
                List<FieldType> searchFileds = searchCriteria.getField();

                for (Map.Entry<String, String> paramEntry : searchFields.entrySet())
                {
                    FieldType fieldType = new FieldType();
                    fieldType.setName(paramEntry.getKey());
                    fieldType.setValue(paramEntry.getValue());
                    searchFileds.add(fieldType);
                }
                paramList.setSearch(searchCriteria);
            }

            metadata.setType(type);
            metadata.setParams(paramList);

            marshaller.marshal(metadata, stringWriter);
            if (LOG.isDebugEnabled())
            {
                LOG.debug(type + "--" + stringWriter.toString());
            }
        }
        catch (PropertyException e)
        {
            LOG.error(e);
        }
        catch (JAXBException e)
        {
            LOG.error(e);
        }
        return stringWriter.toString();
    }

    /**
     * This method will add an entry to JOB_QUEUE table.
     * 
     * @param jobType This is a String object
     * @param metaData This is a String object
     * @param screenName This is a String object
     * @param notificationEmail This is a String object
     */
    public static void addToJobQueue(String jobType, String metaData, String screenName, String notificationEmail)
    {
        try
        {
            JobQueue jobQueue = JobQueueLocalServiceUtil.createJobQueue(CounterLocalServiceUtil.increment(JobQueue.class
                    .getName()));
            jobQueue.setNew(true);
            jobQueue.setJobOwner(screenName);
            jobQueue.setJobType(jobType);
            jobQueue.setMetadata(metaData);
            jobQueue.setLink("");
            jobQueue.setNotificationEmail(notificationEmail);
            jobQueue.setStatus(BrandStandardsConstant.JOB_STATUS_NEW);
            jobQueue.setCreatorId(screenName);
            jobQueue.setCreatedDate(DateUtil.newDate(System.currentTimeMillis()));
            jobQueue.setUpdatedBy(screenName);
            jobQueue.setUpdatedDate(DateUtil.newDate(System.currentTimeMillis()));
            JobQueueLocalServiceUtil.addJobQueue(jobQueue);
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Entry added to JobQueue table successfully. JobQueu Entry Id:::" + jobQueue.getJobId());
            }
        }
        catch (NumberFormatException e)
        {
            LOG.error(e);
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
    }

    /**
     * 
     * @param locale This is a Locale object
     * @return JSONObject
     */
    public static JSONObject getMonthList(BSLanguageUtil obsmLanguageUtil)
    {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        jsonObject.put(BrandStandardsConstant.MONTH_JANUARY, obsmLanguageUtil.get("bs.month.jan"));
        jsonObject.put(BrandStandardsConstant.MONTH_FEBRUARY, obsmLanguageUtil.get("bs.month.feb"));
        jsonObject.put(BrandStandardsConstant.MONTH_MARCH, obsmLanguageUtil.get("bs.month.mar"));
        jsonObject.put(BrandStandardsConstant.MONTH_APRIL, obsmLanguageUtil.get("bs.month.apr"));
        jsonObject.put(BrandStandardsConstant.MONTH_MAY, obsmLanguageUtil.get("bs.month.may"));
        jsonObject.put(BrandStandardsConstant.MONTH_JUNE, obsmLanguageUtil.get("bs.month.jun"));
        jsonObject.put(BrandStandardsConstant.MONTH_JULY, obsmLanguageUtil.get("bs.month.jul"));
        jsonObject.put(BrandStandardsConstant.MONTH_AUGUST, obsmLanguageUtil.get("bs.month.aug"));
        jsonObject.put(BrandStandardsConstant.MONTH_SEPTEMBER, obsmLanguageUtil.get("bs.month.sep"));
        jsonObject.put(BrandStandardsConstant.MONTH_OCTOBER, obsmLanguageUtil.get("bs.month.oct"));
        jsonObject.put(BrandStandardsConstant.MONTH_NOVEMBER, obsmLanguageUtil.get("bs.month.nov"));
        jsonObject.put(BrandStandardsConstant.MONTH_DECEMBER, obsmLanguageUtil.get("bs.month.dec"));
        return jsonObject;
    }
    
  
}

/**
 * CategoryComparator class.
 * 
 * @author Niranjan Khandekar
 */
class CategoryComparator implements Comparator<FlagCategory>
{
    /**
     * FlagCategory compare method.
     * 
     * @param o1 This is a FlagCategory object
     * @param o2 This is a FlagCategory object
     * @return integer.
     */
    public int compare(FlagCategory o1, FlagCategory o2)
    {
        return o1.getTxtValue().compareTo(o2.getTxtValue());
    }
}
