package com.ihg.brandstandards.util;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsCountry;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.xml.metadata.FieldType;
import com.ihg.brandstandards.xml.metadata.Metadata;
import com.ihg.brandstandards.xml.metadata.MetadataValidationEventHandler;
import com.ihg.brandstandards.xml.metadata.ObjectFactory;
import com.ihg.brandstandards.xml.metadata.ParamList;
import com.ihg.brandstandards.xml.metadata.ParamType;
import com.ihg.brandstandards.xml.metadata.Search;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class BSCommonUtil
{
	private static final Log LOG = LogFactoryUtil.getLog(BSCommonUtil.class);
	
    private static Map<String, Map<String, String>> COUNTRIES;
    private static Map<String, Map<String, List<String>>> SUB_REGION_COUNTRIES;

    /**
     * Get Countries.
     * 
     * @return map of countries
     */
    public static synchronized Map<String, Map<String, String>> getCountries()
    {
        if (COUNTRIES == null || COUNTRIES.isEmpty())
        {
            final Map<String, String> amerOptions = new LinkedHashMap<String, String>();
            final Map<String, String> euOptions = new LinkedHashMap<String, String>();
            final Map<String, String> ameaOptions = new LinkedHashMap<String, String>();
            final Map<String, String> gcOptions = new LinkedHashMap<String, String>();
            
            try
            {
                BSLanguageUtil obsmLanguageUtil = new BSLanguageUtil("en_GB", BSCommonConstants.ELEMENT_MODULE_BRIDGE);
                List<StandardsCountry> ctryList = StandardsCountryLocalServiceUtil.getStandardsCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
                for (StandardsCountry ctry : ctryList) 
                {
                    if (ctry.getRegionId() == 2)
                    {
                        amerOptions.put(ctry.getCountryNameCode(), obsmLanguageUtil.get("bs.country.name.cd." + ctry.getCountryNameCode().toLowerCase()));   
                    }
                    else if (ctry.getRegionId() == 3)
                    {
                        ameaOptions.put(ctry.getCountryNameCode(), obsmLanguageUtil.get("bs.country.name.cd." + ctry.getCountryNameCode().toLowerCase()));
                    } 
                    else if (ctry.getRegionId() == 4)
                    {
                        euOptions.put(ctry.getCountryNameCode(), obsmLanguageUtil.get("bs.country.name.cd." + ctry.getCountryNameCode().toLowerCase()));
                    } 
                    else if (ctry.getRegionId() == 5)
                    {
                        gcOptions.put(ctry.getCountryNameCode(), obsmLanguageUtil.get("bs.country.name.cd." + ctry.getCountryNameCode().toLowerCase()));
                    } 
                }
                COUNTRIES = new LinkedHashMap<String, Map<String, String>>();
                COUNTRIES.put(BSCommonConstants.REGION_AMER, amerOptions);
                COUNTRIES.put(BSCommonConstants.REGION_EUROPE, euOptions);
                COUNTRIES.put(BSCommonConstants.REGION_AMEA, ameaOptions);
                COUNTRIES.put(BSCommonConstants.REGION_GC, gcOptions);
            }
            catch (SystemException e)
            {
                //LOG.error(StackTraceUtil.getStackTrace(e));
            }
        }
        return COUNTRIES;
    }
    
    public static  Map<String, List<String>> getSubRegionCountriesForRegion(String regionCode)
    {
        Map<String, List<String>> subRegionCountryMap;
        if (BSCommonConstants.REGION_GLBL.equals(regionCode))
        {
            subRegionCountryMap = new LinkedHashMap<String, List<String>>();
            Map<String, Map<String, List<String>>> allCountries = BrandStandardsUtil.getSubRegionAndCountries();
            subRegionCountryMap.putAll(allCountries.get(BSCommonConstants.REGION_AMEA));
            subRegionCountryMap.putAll(allCountries.get(BSCommonConstants.REGION_AMER));
            subRegionCountryMap.putAll(allCountries.get(BSCommonConstants.REGION_EUROPE));
            subRegionCountryMap.putAll(allCountries.get(BSCommonConstants.REGION_GC));
        }
        else
        {
            subRegionCountryMap = BrandStandardsUtil.getSubRegionAndCountries().get(regionCode);
        }
        return subRegionCountryMap;
    }
    
    public static Map<String, String> getCountryNamesForRegion(String regionCode)
    {
        Map<String, String> countryNameMap;
        Map<String, Map<String, String>> regionCountryMap = getCountries();
        if (BSCommonConstants.REGION_GLBL.equals(regionCode))
        {
            countryNameMap = new HashMap<String, String>();
            countryNameMap.putAll(regionCountryMap.get(BSCommonConstants.REGION_AMEA));
            countryNameMap.putAll(regionCountryMap.get(BSCommonConstants.REGION_AMER));
            countryNameMap.putAll(regionCountryMap.get(BSCommonConstants.REGION_EUROPE));
            countryNameMap.putAll(regionCountryMap.get(BSCommonConstants.REGION_GC));
        }
        else
        {
            countryNameMap = regionCountryMap.get(regionCode);
        }
        return countryNameMap;
    }
    
    /**
     * Get Countries.
     * 
     * @return map of countries
     */
    public static synchronized Map<String, Map<String, List<String>>> getSubRegionAndCountries()
    {
    	if (SUB_REGION_COUNTRIES == null || SUB_REGION_COUNTRIES.isEmpty())
        {
    		SUB_REGION_COUNTRIES = new LinkedHashMap<String, Map<String,List<String>>>();
    		
    		final Map<String, List<String>> ameaRegions = new LinkedHashMap<String, List<String>>();
    		final Map<String, List<String>> amerRegions = new LinkedHashMap<String, List<String>>();
    		final Map<String, List<String>> euRegions = new LinkedHashMap<String, List<String>>();    		
    		final Map<String, List<String>> gcRegions = new  LinkedHashMap<String, List<String>>();
    		
            final List<String> aaCountries = new ArrayList<String>();
            final  List<String> meaCountries = new ArrayList<String>();
            
            final  List<String> lacMexCountries = new ArrayList<String>();
            final  List<String> usCanadaCountries = new ArrayList<String>();
            
            final  List<String> beneScanCountries = new ArrayList<String>();
            final  List<String> iberiaCountries = new ArrayList<String>();
            final  List<String> dachCountries = new ArrayList<String>();
            final  List<String> russiaCisCountries = new ArrayList<String>();
            final  List<String> otherCountries = new ArrayList<String>();
            
            final  List<String> gcCountries = new ArrayList<String>();
            
            	aaCountries.add("AUS");
            	aaCountries.add("BGD");
            	aaCountries.add("KHM");
            	aaCountries.add("FJI");
            	aaCountries.add("PYF");
            	aaCountries.add("IND");
            	aaCountries.add("IDN");
            	aaCountries.add("JPN");
            	aaCountries.add("KOR");
            	aaCountries.add("LAO");
            	aaCountries.add("MYS");
            	aaCountries.add("MDV");
            	aaCountries.add("NPL");
            	aaCountries.add("NZL");
            	aaCountries.add("PNG");
            	aaCountries.add("PHL");
            	aaCountries.add("SGP");
            	aaCountries.add("LKA");
            	aaCountries.add("THA");
            	aaCountries.add("VUT");
            	aaCountries.add("VNM");
            	ameaRegions.put("AA", aaCountries);
            	
            	meaCountries.add("DZA");
            	meaCountries.add("BHR");
            	meaCountries.add("EGY");
            	meaCountries.add("GHA");
            	meaCountries.add("JOR");
            	meaCountries.add("KEN");
            	meaCountries.add("KWT");
            	meaCountries.add("LBN");
            	meaCountries.add("LBY");
            	meaCountries.add("MAR");
            	meaCountries.add("MUS");
            	meaCountries.add("NGA");
            	meaCountries.add("OMN");
            	meaCountries.add("PAK");
            	meaCountries.add("PSE");
            	meaCountries.add("QAT");
            	meaCountries.add("SAU");
            	meaCountries.add("SEN");
            	meaCountries.add("ZAF");
            	meaCountries.add("SYR");
            	meaCountries.add("TUN");
            	meaCountries.add("TZA");
            	meaCountries.add("UGA");
            	meaCountries.add("ARE");
            	meaCountries.add("ZMB");
            	meaCountries.add("ZWE");
            	ameaRegions.put("MEA", meaCountries);
            	SUB_REGION_COUNTRIES.put(BSCommonConstants.REGION_AMEA, ameaRegions );
            	
            	lacMexCountries.add("ARG");
            	lacMexCountries.add("ABW");
            	lacMexCountries.add("BHS");
            	lacMexCountries.add("BMU");
            	lacMexCountries.add("BRA");
            	lacMexCountries.add("CYM");
            	lacMexCountries.add("CHL");
            	lacMexCountries.add("COL");
            	lacMexCountries.add("CRI");
            	lacMexCountries.add("DOM");
            	lacMexCountries.add("ECU");
            	lacMexCountries.add("SLV");
            	lacMexCountries.add("GTM");
            	lacMexCountries.add("HND");
            	lacMexCountries.add("JAM");
            	lacMexCountries.add("MEX");
            	lacMexCountries.add("NIC");
            	lacMexCountries.add("PAN");
            	lacMexCountries.add("PRY");
            	lacMexCountries.add("PER");
            	lacMexCountries.add("PRI");
            	lacMexCountries.add("TTO");
            	lacMexCountries.add("URY");
            	lacMexCountries.add("VIR");
            	lacMexCountries.add("VEN");
            	amerRegions.put("LAC and MEX", lacMexCountries);
            	
            	usCanadaCountries.add("CAN");
            	usCanadaCountries.add("USA");
            	amerRegions.put("US/Canada", usCanadaCountries);
            	SUB_REGION_COUNTRIES.put(BSCommonConstants.REGION_AMER, amerRegions);
            	
            	beneScanCountries.add("BEL");
            	beneScanCountries.add("DNK");
            	beneScanCountries.add("FIN");
            	beneScanCountries.add("NLD");
            	euRegions.put("BeneScan", beneScanCountries);
            	
            	iberiaCountries.add("AND");
            	iberiaCountries.add("PRT");
            	iberiaCountries.add("ESP");
            	euRegions.put("Iberia", iberiaCountries);
            	
            	dachCountries.add("AUT");
            	dachCountries.add("DEU");
            	dachCountries.add("CHE");
            	euRegions.put("DACH", dachCountries);
            	
            	russiaCisCountries.add("AZE");
            	russiaCisCountries.add("BLR");
            	russiaCisCountries.add("GEO");
            	russiaCisCountries.add("KAZ");
            	russiaCisCountries.add("RUS");
            	russiaCisCountries.add("UKR");
            	russiaCisCountries.add("UZB");
            	euRegions.put("Russia & CIS", russiaCisCountries);
            	
            	otherCountries.add("BGR");
            	otherCountries.add("CYP");
            	otherCountries.add("CZE");
            	otherCountries.add("FRA");
            	otherCountries.add("GRC");
            	otherCountries.add("HUN");
            	otherCountries.add("IRL");
            	otherCountries.add("ISR");
            	otherCountries.add("ITA");
            	otherCountries.add("LTU");
            	otherCountries.add("MKD");
            	otherCountries.add("MLT");
            	otherCountries.add("NIR");
            	otherCountries.add("POL");
            	otherCountries.add("ROU");
            	otherCountries.add("SCG");
            	otherCountries.add("SVK");
            	otherCountries.add("TUR");
            	otherCountries.add("GBR");
            	euRegions.put("Other", otherCountries);
            	SUB_REGION_COUNTRIES.put(BSCommonConstants.REGION_EUROPE, euRegions);
            	
            	gcCountries.add("CHN");
            	gcCountries.add("HKG");
            	gcCountries.add("MAC");
            	gcCountries.add("TWN");
            	gcRegions.put("GC", gcCountries);
            	SUB_REGION_COUNTRIES.put(BSCommonConstants.REGION_GC, gcRegions);
        }
    	return SUB_REGION_COUNTRIES;
    }

    public static int getAllCountriesCount()
    {
        Map<String, Map<String, String>> regions = getCountries();
        int totalCountries = 0;
        for (String rgnCode : regions.keySet())
        {
            Map<String, String> countries = regions.get(rgnCode);
            totalCountries = totalCountries + countries.size();
        }
        return totalCountries;
    }
    
    public static boolean isStandardPublished(long stdId, String brandCode) throws SystemException
    {
        try
        {
            ChainStandards chainStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(stdId, brandCode);
            if (Validator.isNotNull(chainStd) && Validator.isNotNull(chainStd.getLastPublishedDate()))
            {
                return true;
            }
        }
        catch (NoSuchChainStandardsException e)
        {
            return false;
        }
        return false;
    }

    public static boolean isBrandAssigned(Standards std, String chainCode) throws SystemException
    {
        try
        {
            ChainStandards chainStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(std.getStdId(), chainCode);
            if (Validator.isNotNull(chainStd))
            {
                return true;
            }
        }
        catch (NoSuchChainStandardsException e)
        {
            return false;
        }
        return false;
    }
    
    public static Map<TimeUnit, Long> computeTimeDiff(Date date1, Date date2)
    {
        long diffInMillies = date2.getTime() - date1.getTime();
        List<TimeUnit> units = new ArrayList<TimeUnit>(EnumSet.allOf(TimeUnit.class));
        Collections.reverse(units);
        Map<TimeUnit, Long> result = new LinkedHashMap<TimeUnit, Long>();
        long milliesRest = diffInMillies;
        for (TimeUnit unit : units)
        {
            long diff = unit.convert(milliesRest, TimeUnit.MILLISECONDS);
            long diffInMilliesForUnit = unit.toMillis(diff);
            milliesRest = milliesRest - diffInMilliesForUnit;
            result.put(unit, diff);
        }
        return result;
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
        catch (JAXBException e)
        {
            LOG.error(e);
        }
        return stringWriter.toString();
    }
	
	public static String getRegionByCountryCode(Map<String, Map<String, String>> regionCountryMap,String  countryCode){
    	for(String region :regionCountryMap.keySet()){
        	Map<String, String> country = regionCountryMap.get(region);
        	if (country.get(countryCode)!=null)
        	{
        		return region;
        	}
        }
    	return StringPool.BLANK;
    }
}
