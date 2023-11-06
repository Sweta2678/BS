/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;

/**
 * <a href="UserPreferencesApplication.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author KhandeN
 */
public class UserPreferencesApplication extends ApplicationImpl
{
    private static final Log LOG = LogFactoryUtil.getLog(UserPreferencesApplication.class);

    /**
     * @param userid userId of the user
     * @return UserPreferences object
     */
    public UserPreference getUserPreferences(long userid)
    {
        UserPreference userpreferences = null;
        try
        {
            userpreferences = UserPreferenceLocalServiceUtil.getUserPreferencesByUserId(userid, "OBSM");
        }
        catch (SystemException e)
        {
            LOG.error("SystemException: ", e);
        }
        return userpreferences;
    }

    /**
     * @param userPreferences The UserPreferences object
     * @param isNew boolean specifying is the insert new/update entry 
     * @return UserPreferences object
     */
    public UserPreference addOrUpdateUserPreferences(UserPreference userPreferences, boolean isNew)
    {
        try
        {
            if (isNew)
            {
                //long userPrefsId = CounterLocalServiceUtil.increment(UserPreferences.class.getName());
            	long userPrefsId = UserPreferenceLocalServiceUtil.getUserPreferencePK();
            	userPreferences.setPreferenceId(userPrefsId);
                UserPreferenceLocalServiceUtil.addUserPreference(userPreferences);
            }
            else
            {
                UserPreferenceLocalServiceUtil.updateUserPreference(userPreferences);
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException: ", e);
        }
        return userPreferences;
    }

    /**
     * @param brand The hotel brand code 
     * @param country Country code
     * @return List of StandardsLocale objects
     * @throws Exception Throws exception
     */
    public List<StandardsLocale> getLanguagesPerBrandCountry(String brand, String country, String environment) throws Exception
    {
        List<StandardsLocale> arlLanguages = null;
        List<StandardsLocale> arlLang = new ArrayList<StandardsLocale>();
        Map<String, Map<String, String>> rgnCountryMap = BrandStandardsUtil.getCountryByRegionsMap();
        Set<String> regionNames = rgnCountryMap.keySet();
        String regionName = "";
        try
        {
        for (String key : regionNames)
        {
            Map<String, String> countryMap = rgnCountryMap.get(key);
            Set<String> countryCodes = countryMap.keySet();
            for (String ctryKey : countryCodes)
            {
                if (ctryKey.equals(country))
                {
                    regionName = key;
                    break;
                }
            }
        }

        arlLanguages = StandardsLocaleLocalServiceUtil.getLanguagesByRegion(regionName);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("size of arlLanguages is " + arlLanguages.size());
        }

        List<String> arlPublishLang = getPublishedLanguages(brand, environment);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("size of arraylist of published languages by brand is " + arlPublishLang.size());
        }
        for (StandardsLocale locale : arlLanguages)
        {
            for (String lang : arlPublishLang)
            {
                if (locale.getLocaleCode().equals(lang))
                {
                	
                    arlLang.add(locale);
                }
            }
        }
        Publication publication = PublicationLocalServiceUtil.getLatestPublication(brand, environment, BrandStandardsConstant.PUBLISH_ACTIVE_STATUS_CODE);
        Date latestPublicationDate = publication.getPublishDate();
        
        String dateString = "31-JUN-17";
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");

	    Date date = new Date();
		try
		{
			date = sdf.parse(dateString);
		}
		catch (ParseException e)
		{
			LOG.error(e.getMessage());
		}
        
		String regionCode = StandardsCountryExtLocalServiceUtil.getRegionCodeByCountryCode(country);
		
		if( latestPublicationDate.before(date) && regionCode.equalsIgnoreCase(BrandStandardsConstant.REGION_AMER))
		{
			StandardsLocale frenchLanguage = StandardsLocaleLocalServiceUtil.createStandardsLocale("fr_FR");
			frenchLanguage.setLocaleName(BrandStandardsConstant.FRENCH_LANGUAGE_EUROPE.trim());
			
			StandardsLocale spanishLanguage = StandardsLocaleLocalServiceUtil.createStandardsLocale("es_ES");
			spanishLanguage.setLocaleName(BrandStandardsConstant.SPANISH_LANGUAGE_EURO.trim());
			
			arlLang.add(frenchLanguage);
			arlLang.add(spanishLanguage);
		}
		else if( latestPublicationDate.before(date) && regionCode.equalsIgnoreCase(BrandStandardsConstant.REGION_EUROPE)){
			
			List<StandardsLocale> remLocales = new ArrayList<StandardsLocale>();
			for(StandardsLocale locale : arlLang){
				if(locale.getLocaleName().equalsIgnoreCase(BrandStandardsConstant.FRENCH_LANGUAGE_EUROPE)){
					remLocales.add(locale);
				}
			}
			for(StandardsLocale locale : arlLang){
				if(locale.getLocaleName().equalsIgnoreCase(BrandStandardsConstant.SPANISH_LANGUAGE_EURO)){
					remLocales.add(locale);
				}
			}
			
			arlLang.removeAll(remLocales);
		}
        arlLang = removeDuplicates(arlLang);
        // populate default language
        if (arlLang.size() == 0)
        {
            StandardsLocale defaultLocale = StandardsLocaleLocalServiceUtil.createStandardsLocale("en_GB");
            defaultLocale.setLocaleName("English (UK)");
            arlLang.add(defaultLocale);
            if (LOG.isDebugEnabled())
            {
                LOG.debug("default locale added ----");
            }
        }
        }
        catch(Exception e)
        {
        	LOG.error(e);
        }
        
        return arlLang;
    }
	
    /**
     * @param duplicatesList StandardsLocale list object
     * @return List of StandardsLocale objects
     */
    public static final List<StandardsLocale> removeDuplicates(List<StandardsLocale> duplicatesList)
    {
        List<StandardsLocale> uniqueList = new ArrayList<StandardsLocale>();
        HashSet<StandardsLocale> hs = new HashSet<StandardsLocale>();
        hs.addAll(duplicatesList);
        uniqueList.addAll(hs);

        return uniqueList;
    }

    /**
     * @param chainCode The Hotel Brand Code
     * @return returns boolean
     */
    public boolean isPublishedActiveBrand(String chainCode)
    {
        boolean isActiveBrand = false;
        try
        {
            isActiveBrand = PublicationLocalServiceUtil.isPublishedBrand(chainCode);
        }
        catch (Exception e)
        {
            LOG.error("Exception: ", e);
        }

        return isActiveBrand;
    }

    /**
     * @param localeCode The Locale code
     * @return returns Language Name
     */
    public String getLanguageName(String localeCode)
    {
        String languageName = "";
        try
        {
            StandardsLocale bsLocale = StandardsLocaleLocalServiceUtil.getStandardsLocale(localeCode);
            languageName = bsLocale.getLocaleName();
        }
        catch (Exception e)
        {
            LOG.error("Exception: ", e);
        }
        return languageName;
    }

    /**
     * @param chainCode The Locale code
     * @return returns list of languages
     */
    public List<String> getPublishedLanguages(String chainCode, String environment)
    {
        List<String> arllanguages = new ArrayList<String>();

        try
        {
            arllanguages = PublicationLocalServiceUtil.getPublishLanguagesPerBrand(chainCode, environment);
        }
        catch (SystemException e)
        {
            LOG.error("SystemException: ", e);
        }
        return arllanguages;
    }

    /**
     * @param userId The userId of the user.
     * @return Returns AccessAndPreferences object with user information.
     */
    public AccessAndPreferences loadUserPreferences(long userId)
    {
        AccessAndPreferences accessPrefs = new AccessAndPreferences();
        try
        {
            UserPreference userPrefs = getUserPreferences(userId);
            accessPrefs.setBuildType("258");
            accessPrefs.setChain(userPrefs.getChainCode());
            accessPrefs.setCountry(userPrefs.getCountryCode());
            accessPrefs.setLangCode(userPrefs.getLangCode());
            accessPrefs.setPdfLangCode(userPrefs.getPdfLangCode());
        }
        catch (Exception e)
        {
            LOG.error("Exception: ", e);
        }

        return accessPrefs;
    }

    /**
     * @param chainCode The hotel code
     * @return returns active publishId
     * @throws SystemException throws SystemException
     */
    public long getPublishIdByChain(String chainCode, String environment) throws SystemException
    {
        return PublicationLocalServiceUtil.getPublishIdByBrand(chainCode, environment);
    }
	
    /**
     * @param prefs The AccessAndPreferences object
     * @param selectedChain The Selected Hotel Code
     * @return returns boolean saying user has access to that brand or not.
     */
	public boolean isSelectedBrandUsersBrand(AccessAndPreferences prefs, String selectedChain) 
	{
		boolean isSelectedBrand = false;
		String userType = prefs.getUserType();
		List<String> arlChains = prefs.getChains();
		 if ("H".equals(userType) || "M".equals(userType) || "O".equals(userType)) 
		 {
			 for(String chain: arlChains)
			 {
				 if(chain.equals(selectedChain))
				 {
					 isSelectedBrand = true;
				 }
			 }
		 }
		 else
		 {
			 isSelectedBrand = true;
		 }
		 
		return isSelectedBrand;
	}
}
