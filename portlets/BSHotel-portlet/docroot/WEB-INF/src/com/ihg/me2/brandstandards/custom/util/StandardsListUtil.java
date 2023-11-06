/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.db.model.SpecialWordDictionary;
import com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="StandardsListUtil.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Niranjan Khandekar
 */
public class StandardsListUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsListUtil.class);

    private static final String DELIMS = " ,+";

    //	private static final String COMPLIANCE_DEADLINE = "compDeadline";
    private static final Map<Long, String> hotelLifeCycleFlagMap;
    static
    {
        hotelLifeCycleFlagMap = new HashMap<Long, String>();
        hotelLifeCycleFlagMap.put(Long.valueOf(396), BrandStandardsConstant.HOTEL_LIFECYCLE_NEW_BUILD);
        hotelLifeCycleFlagMap.put(Long.valueOf(477), BrandStandardsConstant.HOTEL_LIFECYCLE_CONVERSION);
        hotelLifeCycleFlagMap.put(Long.valueOf(478), BrandStandardsConstant.HOTEL_LIFECYCLE_RENOVATION);
        hotelLifeCycleFlagMap.put(Long.valueOf(399), BrandStandardsConstant.HOTEL_LIFECYCLE_REPLACEMENT);
        hotelLifeCycleFlagMap.put(Long.valueOf(479), BrandStandardsConstant.HOTEL_LIFECYCLE_EXISTING);
    }

    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @param paramName parameter name.
     * @param renderParamName renderParamName name.
     * @return List of param values.
     */
    private static List<String> getParamFromRequest(HttpServletRequest request, boolean isRenderRequest, String paramName,
            String renderParamName)
    {
        List<String> paramValues = new ArrayList<String>();
        try
        {
            String[] values = request.getParameterValues(paramName);
            if (values != null && values.length > 0)
            {
                paramValues.addAll(Arrays.asList(values));
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return paramValues;
    }

    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @return List of department values.
     */
    public static List<String> getDeptApplicabilityFromRequest(HttpServletRequest request, boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "deptApplicability", "deptApp[]");
    }

    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @return List of guest journey values.
     */
    public static List<String> getGuestJourneyFromRequest(HttpServletRequest request, boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "guestJourney", "guestJourney[]");
    }

    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @return List of location hotel values.
     */
    public static List<String> getLocHotelFromRequest(HttpServletRequest request, boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "locHotel", "locHotel[]");
    }

    /*Add CR 50.2 Added hotel Lifecycle and specialism
    Get Maunal-> "Operate" categrory from Hotel Lifecycle parameter
    */
    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @return List of hotel lifecycle values.
     */

    public static List<String> getHotelLifeCycleFromRequest(HttpServletRequest request, boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "hotelLifecycle", "hotelLifecycle[]");
    }

    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @return List of specialism values.
     */

    public static List<String> getSpecialismFromRequest(HttpServletRequest request, boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "specialism", "specialism[]");
    }
    //End CR 50.2 

    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @return List of flag values.
     */
    public static List<String> getFlagsList(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> arlFlags = new ArrayList<String>();
        final List<String> arlHotelLifecycle = getHotelLifeCycleFromRequest(request, isRenderRequest);
        final List<String> arlSpecialism = getSpecialismFromRequest(request, isRenderRequest);
        final List<String> arlDeptApplicability = getDeptApplicabilityFromRequest(request, isRenderRequest);
        final List<String> arlGuestJourney = getGuestJourneyFromRequest(request, isRenderRequest);
        final List<String> arlLocHotel = getLocHotelFromRequest(request, isRenderRequest);

        if (!isNullOrBlank(arlHotelLifecycle))
        {
            arlFlags.addAll(arlHotelLifecycle);
        }
        if (!isNullOrBlank(arlSpecialism))
        {
            arlFlags.addAll(arlSpecialism);
        }
        if (!isNullOrBlank(arlDeptApplicability))
        {
            arlFlags.addAll(arlDeptApplicability);
        }
        if (!isNullOrBlank(arlGuestJourney))
        {
            arlFlags.addAll(arlGuestJourney);
        }
        if (!isNullOrBlank(arlLocHotel))
        {
            arlFlags.addAll(arlLocHotel);
        }
        return arlFlags;
    }

    /**
     * @param request HttpServletRequest object
     * @param isRenderRequest specifying is it render request.
     * @return return filters
     */
    public static Map<String, List<String>> getCriteriaFromRequest(final HttpServletRequest request, final boolean isRenderRequest, String replacedTextSearch)
    {
        Map<String, List<String>> hashMap = new HashMap<String, List<String>>();
        List<String> arlCriteria = new ArrayList<String>();
        List<String> arlReplaceCriteria = new ArrayList<String>();
        List<String> arlIdCriteria = new ArrayList<String>();
        try
        {
            final String criteria = ParamUtil.getString(request, "filterText");
            String textSearchType = ParamUtil.getString(request, "searchOptions");
            LOG.info("value of filter text is " + criteria);
            if (  criteria != null && criteria.trim().length() > 0)
            {
                if ("all".equals(textSearchType) || "any".equals(textSearchType))
                {
                    final StringTokenizer strTok = new StringTokenizer(criteria, DELIMS);
                    while (strTok.hasMoreTokens())
                    {
                        String value = strTok.nextToken();
                        if (value.trim().length() > 0)
                        {
                            if (isNumeric(value))
                            {
                                arlIdCriteria.add(value);
                            }
                            else
                            {
                                arlCriteria.add(value);
                            }
                        }
                    }
                    
                    /*if("exact".equals(textSearchType) && arlCriteria.size()>0){
                    		arlCriteria= new ArrayList<String>();
                    		arlIdCriteria= new ArrayList<String>();
                    		arlCriteria.add(criteria);
                    }*/
                }
                else
                {
                    arlCriteria.add(criteria);
                	/* if (isNumeric(criteria))
                     {
                         arlIdCriteria.add(criteria);
                     }
                     else
                     {
                         arlCriteria.add(criteria);
                     }*/
                }
            }
            
            if (replacedTextSearch != null && replacedTextSearch.trim().length() > 0)
            {
               if ("all".equals(textSearchType) || "any".equals(textSearchType))
                {
                    final StringTokenizer strTok = new StringTokenizer(replacedTextSearch, DELIMS);
                    while (strTok.hasMoreTokens())
                    {
                        String value = strTok.nextToken();
                        if (value.trim().length() > 0)
                        {
                            if (isNumeric(value))
                            {
                                arlIdCriteria.add(value);
                            }
                            else
                            {
                            	arlReplaceCriteria.add(value);
                            }
                        }
                    }
                    /*if("exact".equals(textSearchType) && arlReplaceCriteria.size()>0){
                    		arlReplaceCriteria.clear();
                    		arlIdCriteria.clear();
                    		arlReplaceCriteria.add(replacedTextSearch);
                    }
                    */
                }
                else
                {
                	arlReplaceCriteria.add(replacedTextSearch);
                	/*if (isNumeric(replacedTextSearch))
                    {
                        arlIdCriteria.add(replacedTextSearch);
                    }
                    else
                    {
                    	arlReplaceCriteria.add(replacedTextSearch);
                    }*/
                }
            }
            
            hashMap.put("arlReplaceCriteria", arlReplaceCriteria);
            hashMap.put("arlCriteria", arlCriteria);
            hashMap.put("arlIdCriteria", arlIdCriteria);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return hashMap;
    }

    /**
     * @param days The ComplianceDeadline
     * @return String returns compliance date
     */
    public static String getComplianceDeadline(String days)
    {
        String complianceDeadline = "";
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        try
        {
            if ("0d".equals(days))
            {
                date = new Date();
            }
            else if ("7d".equals(days))
            {
                calendar.add(Calendar.DATE, 7);
                date = calendar.getTime();
            }
            else if ("1m".equals(days))
            {
                calendar.add(Calendar.DATE, 30);
                date = calendar.getTime();
            }
            else if ("3m".equals(days))
            {
                calendar.add(Calendar.DATE, 90);
                date = calendar.getTime();
            }
            else if ("6m".equals(days))
            {
                calendar.add(Calendar.DATE, 182);
                date = calendar.getTime();
            }
            else if ("12m".equals(days))
            {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                if (year % 4 == 0)
                {
                    calendar.add(Calendar.DATE, 366);
                }
                else
                {
                    calendar.add(Calendar.DATE, 365);
                }
                date = calendar.getTime();
            }
            else if ("12m+".equals(days))
            {
                int year = Calendar.getInstance().get(Calendar.YEAR);
                if (year % 4 == 0)
                {
                    calendar.add(Calendar.DATE, 366);
                }
                else
                {
                    calendar.add(Calendar.DATE, 365);
                }

                date = calendar.getTime();
            }
            Format formatter = new SimpleDateFormat("dd-MMM-yy");
            complianceDeadline = formatter.format(date);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return complianceDeadline;
    }

    /**
     * @return formated todays dates as string.
     */
    public static String now()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
        return sdf.format(cal.getTime());
    }

    /**
     * Get Hotel LifeCycle flag from string
     * 
     * @param flags
     * @return
     */
    public static Map<Long, String> getHotleLifeCycelFlag(String flags)
    {
        //List<String> flagLists = new ArrayList<String>();
        Map<Long, String> flagLists = new LinkedHashMap<Long, String>();
        try
        {
            if (Validator.isNotNull(flags))
            {
                String[] flagvalues = flags.split(",");
                for (int i = 0; i < flagvalues.length; i++)
                {
                    if (hotelLifeCycleFlagMap.containsKey(Long.parseLong(flagvalues[i].trim())))
                    {
                        flagLists.put(Long.parseLong(flagvalues[i].trim()),
                                hotelLifeCycleFlagMap.get(Long.parseLong(flagvalues[i].trim())));
                    }
                }

            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return flagLists;
    }

    public static String getReplacedSearchText(String searchLocaleCode, String searchKeyWord){
    	boolean hasReplacedWords = false;
    	StringBuilder replacedSearchKeyWord = new StringBuilder();
    	//Special Word Search is restricted to en_GB & en_US 
    	if(BrandStandardsConstant.SPECIAL_WORD_SEARCH_LANGUAGES.contains(searchLocaleCode)){
	    	String searchWords[] = Validator.isNotNull(searchKeyWord) ? searchKeyWord.split(StringPool.SPACE) : null;
	    	List<SpecialWordDictionary> specialWordsList = SpecialWordDictionaryLocalServiceUtil.getByLocaleCode("en_GB");
	    	if(searchWords != null && searchWords.length > 0 && Validator.isNotNull(specialWordsList)) {
	    		for(String keyWord : searchWords){
	        		boolean wordReplaced = false;
	    			for(SpecialWordDictionary word : specialWordsList){
		        		if(word.getReplacedWordTxt().equalsIgnoreCase(keyWord.trim())){
		        			if(!replacedSearchKeyWord.toString().isEmpty()){
			        			replacedSearchKeyWord.append(StringPool.SPACE);
		        			}
		        			replacedSearchKeyWord.append(word.getReplacementWordTxt());
		        			wordReplaced = true;
		        			hasReplacedWords = true;
		        			break;
		        		}
		        	}
	    			if(!wordReplaced){
	    				if(!replacedSearchKeyWord.toString().isEmpty()){
		        			replacedSearchKeyWord.append(StringPool.SPACE);
	        			}
	        			replacedSearchKeyWord.append(keyWord);
	        		}
	        	}
	    	}
    	}
    	if(hasReplacedWords){
    		return replacedSearchKeyWord.toString();
    	} else {
    		return null;
    	}
    }
}
