/**
 * �2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;
import com.ihg.brandstandards.util.BSLanguageUtil;
import com.ihg.me2.brandstandards.custom.application.FlagCategoryApplication;
import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <a href="UserPreferencePortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author KhandeN
 */
public class UserPreferencePortlet extends BrandStandardsPortlet
{
    private static final String BUILD_TYPE = "258";
    private static final String USRTYP = "USRTYP";
    private static final String CURRCTRY = "CURRCTRY";
    private static final String SESSION_LOCATIONS = "LOCATIONS";
    private static final String CHAIN = "chain";
    private static final String COUNTRY = "country";
    private static final String EN_GB = "en_GB";
    private static final String LANGUAGES = "languages";
    private static final String USERPREFS_VIEW_JSP = "/html/userprefs/view.jsp";
    private static final String SHOW_NO_ACCESS_DIALOG = "showNoAccessDialog";
    private static final String SHOW_ACCESS_DIALOG = "showAccessDialog";
    private static final String USER_PREFERENCES = "UserPreferences";
    private static final Log LOG = LogFactoryUtil.getLog(UserPreferencePortlet.class);
    private static final long CATEGORY_ID = 30;

    /**
     * @param request This is a RenderRequest object
     * @param renderResponse This is a RenderResponse object
     * @throws IOException It throws IOException
     * @throws PortletException It throws PortletException
     */
    public void doView(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException
    {
        String jsp = "";
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
        HttpSession session = httpReq.getSession();
        UserPreferencesApplication userPrefsApp = new UserPreferencesApplication();
        User user = themeDisplay.getUser();
        String langCode = "";
        List<StandardsLocale> arlLang = new ArrayList<StandardsLocale>();
        List<FlagCategory> arlFlagCategories = new ArrayList<FlagCategory>();
        AccessAndPreferences userPreferences = new AccessAndPreferences();
        String url = themeDisplay.getLayout().getFriendlyURL();
        String environment = "";
        if(url.contains("staging"))
        {
        	environment = "STAGING";
        }
        else
        {
        	environment = "PRODUCTION";
        }
        if (session.getAttribute(USER_PREFERENCES) != null)
        {
            userPreferences = (AccessAndPreferences) session.getAttribute(USER_PREFERENCES);
        }
        userPreferences = getUserCredentialsFromRequest(request, userPreferences);

        long userId = user.getUserId();
        UserPreference userPrefs = userPrefsApp.getUserPreferences(userId);
        boolean isBrandActive = false;
        boolean isSelectedUserBrand = false;
        long publishId = 0;
        if (userPrefs != null)
        {
            String brand = userPrefs.getChainCode();
           isBrandActive = userPrefsApp.isPublishedActiveBrand(brand);
            isSelectedUserBrand = userPrefsApp.isSelectedBrandUsersBrand(userPreferences, brand);
            if (!isBrandActive ) {
            	
            	httpReq.setAttribute("isBrandNotActive", true);
				httpReq.setAttribute(SHOW_ACCESS_DIALOG, false);
			    httpReq.setAttribute(SHOW_NO_ACCESS_DIALOG, true);
			    jsp = USERPREFS_VIEW_JSP;
               
            }else  if (!isSelectedUserBrand){
            	httpReq.setAttribute("isBrandNotActive", false);
					if(userPreferences.getChains().size()==1){
					    
						 httpReq.setAttribute("isUpdatedBrand", true);
						 httpReq.setAttribute(SHOW_ACCESS_DIALOG, true);
					     httpReq.setAttribute(SHOW_NO_ACCESS_DIALOG, false);
					     jsp = USERPREFS_VIEW_JSP;
						
						
					}else{
						httpReq.setAttribute("isUpdatedBrand", false);
						httpReq.setAttribute(SHOW_ACCESS_DIALOG, false);
					    httpReq.setAttribute(SHOW_NO_ACCESS_DIALOG, true);
					    jsp = USERPREFS_VIEW_JSP;
					}
            } else{
                langCode = userPrefs.getLangCode();
                userPreferences.setChain(brand);
                userPreferences.setCountry(userPrefs.getCountryCode());
                userPreferences.setLangCode(userPrefs.getLangCode());
                userPreferences.setPdfLangCode(userPrefs.getPdfLangCode());
                userPreferences.setLangName(userPrefsApp.getLanguageName(userPrefs.getLangCode()));
                userPreferences.setBuildType(userPrefs.getBuildType());
                userPreferences.setPaperSize(userPrefs.getPaperSize());
                userPreferences.setCountryName(BrandStandardsUtil.getCountryNameFromCode(userPrefs.getCountryCode()));
                userPreferences.setChainName(BrandStandardsUtil.decodeChainCode(brand));
                try
                {
                    arlLang = userPrefsApp.getLanguagesPerBrandCountry(brand, userPrefs.getCountryCode(), environment);
                }
                catch (Exception e)
                {
                    LOG.error("Caught Exception: ", e);
                }
                userPreferences.setPublishId(publishId);
                List<StandardsLocale> arlLanguages = new ArrayList<StandardsLocale>(arlLang);
                httpReq.setAttribute(LANGUAGES, arlLanguages);
                userPreferences.setLanguages(arlLanguages);
                session.setAttribute("USER_brand", userPreferences.getChain());
                session.setAttribute("USER_locale", userPreferences.getLangCode());

                httpReq.setAttribute(SHOW_ACCESS_DIALOG, false);
                httpReq.setAttribute(SHOW_NO_ACCESS_DIALOG, false);
                jsp = USERPREFS_VIEW_JSP;
            }

        }
        else
        {
            if ("X".equalsIgnoreCase(userPreferences.getUserType()) || "U".equalsIgnoreCase(userPreferences.getUserType())
                    || "A".equalsIgnoreCase(userPreferences.getUserType()))
            {
                httpReq.setAttribute(SHOW_ACCESS_DIALOG, false);
                httpReq.setAttribute(SHOW_NO_ACCESS_DIALOG, true);
                jsp = USERPREFS_VIEW_JSP;
            }
            else
            {
                userPreferences.setCountry("");
                httpReq.setAttribute(SHOW_NO_ACCESS_DIALOG, false);
                httpReq.setAttribute(SHOW_ACCESS_DIALOG, true);
                jsp = USERPREFS_VIEW_JSP;
            }
        }
        if (userPreferences.getLangCode() == null)
        {
            userPreferences.setLangCode(EN_GB);
            langCode = EN_GB;
        }
        try
        {
            arlFlagCategories = new FlagCategoryApplication().getCategoryByParentId(CATEGORY_ID);
            publishId = userPrefsApp.getPublishIdByChain(userPreferences.getChain(), environment);
            userPreferences.setPublishId(publishId);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
        
        BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(request, langCode, "OBSM");
        
        setAccessScreenLabels(request, obsmLanguageUtil);
        userPreferences.setManuals(arlFlagCategories);
        httpReq.setAttribute("userPreferences", userPreferences);
        session.setAttribute(USER_PREFERENCES, userPreferences);
        
        
       

        PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(jsp);
        dispatcher.include(request, renderResponse);
    }

    /**
     * @param resourceRequest This is a ResourceRequest object
     * @param resourceResponse This is a ResourceResponse object
     * @throws IOException It throws IOException
     * @throws PortletException It throws PortletException
     */
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        UserPreferencesApplication userPrefsApplication = new UserPreferencesApplication();
        List<StandardsLocale> arlLanguages = null;
        List<StandardsLocale> arlLang = null;
        resourceResponse.setContentType("text/html");
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(resourceRequest);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        String resource = resourceRequest.getResourceID();
        String modalType = resourceRequest.getParameter("modalType");
        AccessAndPreferences userprefs = null;
        String langCode = EN_GB;
        String url = httpRequest.getRequestURI();
        String environment = "";
        if(url.contains("staging"))
        {
        	environment = "STAGING";
        }
        else
        {
        	environment = "PRODUCTION";
        }
        userprefs = getUserPreferences(resourceRequest);
        if (Validator.isNotNull(userprefs))
        {
            langCode = userprefs.getLangCode();
        }
        BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(resourceRequest, langCode, "OBSM");
        setAccessScreenLabels(resourceRequest, obsmLanguageUtil);
        
        if ("showCorpLanguages".equalsIgnoreCase(resource))
        {
            String jsPage = "/html/userprefs/viewCorporateLang.jsp";
            String selectedBrand = (String) resourceRequest.getParameter("chnCd");
            String selectedCountry = (String) resourceRequest.getParameter("ctryCd");
            try
            {
                arlLang = userPrefsApplication.getLanguagesPerBrandCountry(selectedBrand, selectedCountry, environment);
                arlLanguages = new ArrayList<StandardsLocale>(arlLang);
                httpRequest.setAttribute(LANGUAGES, arlLanguages);
            }
            catch (Exception e)
            {
                LOG.error(e);
            }
            include(jsPage, resourceRequest, resourceResponse);
        }
        else if ("viewAccess".equalsIgnoreCase(modalType))
        {
            try
            {
                include("/html/userprefs/viewCorporate.jsp", resourceRequest, resourceResponse);
            }
            catch (IOException e)
            {
                LOG.error(e.getMessage(), e);
            }
            catch (PortletException e)
            {
                LOG.error(e.getMessage(), e);
            }
        }
        else if ("viewNoAccess".equalsIgnoreCase(modalType))
        {
        	httpRequest.setAttribute("isBrandNotActive", ParamUtil.getBoolean(resourceRequest, "isBrandNotActive"));
            try
            {
                include("/html/userprefs/error.jsp", resourceRequest, resourceResponse);
            }
            catch (IOException e)
            {
                LOG.error(e.getMessage(), e);
            }
            catch (PortletException e)
            {
                LOG.error(e.getMessage(), e);
            }
        }

    }

    /**
     * 
     * @param actionRequest This is an ActionRequest object
     * @param actionResponse This is an ActionResponse object
     * @throws IOException It throws IOException
     * @throws PortletException It throws PortletException
     */
    @ProcessAction(name = "setAccess")
    public void setAccess(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        UserPreferencesApplication userPrefsApp = new UserPreferencesApplication();
        boolean isBrandActive = false;
        boolean isSelectedUserBrand = false;
        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession session = httpReq.getSession();
        AccessAndPreferences userPreferences = (AccessAndPreferences) session.getAttribute(USER_PREFERENCES);
        if (userPreferences == null)
        {
            userPreferences = new AccessAndPreferences();
        }
        userPreferences = getUserCredentialsFromRequest(actionRequest, userPreferences);
        long userId = userPreferences.getUserId();
        UserPreference userPrefs = userPrefsApp.getUserPreferences(userId);
        String brand = ParamUtil.getString(actionRequest, "chnCd");
        String country = ParamUtil.getString(actionRequest, "ctryCd");
        String language = ParamUtil.getString(actionRequest, "lclCd");
        isBrandActive = userPrefsApp.isPublishedActiveBrand(brand);
        isSelectedUserBrand = userPrefsApp.isSelectedBrandUsersBrand(userPreferences, brand);
        String url = httpReq.getRequestURI();
        String environment = "";
        if(url.contains("staging"))
        {
        	environment = "STAGING";
        }
        else
        {
        	environment = "PRODUCTION";
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("The value of language is " + language + " country" + country + " brand" + brand);
            LOG.debug("isBrandActive :" + isBrandActive + ", isSelectedUserBrand :" + isSelectedUserBrand);
        }
        if (isBrandActive && isSelectedUserBrand)
        {
            userPreferences.setChain(brand);
            userPreferences.setCountry(country);
            userPreferences.setLangCode(language);
            if (userPrefs != null)
            {
                try
                {
                    
                    userPrefs.setChainCode(brand);
                    userPrefs.setCountryCode(country);
                    userPrefs.setLangCode(language);
                    userPrefs.setBuildType(BUILD_TYPE);
                    userPrefs.setUpdatedBy(String.valueOf(userPreferences.getUserId()));
                    userPrefs.setUpdatedDate(new Date());
                    userPrefs = UserPreferenceLocalServiceUtil.updateUserPreference(userPrefs);
                }
                catch (SystemException e)
                {
                    LOG.error("Failed to update OBSM User Preference Settings");
                }
            }
            else
            {
                try
                {
                   
                    userPrefs = UserPreferenceLocalServiceUtil.createUserPreference(CounterLocalServiceUtil.increment(UserPreference.class.getName()));
                    userPrefs.setUserId(userId);
                    userPrefs.setChainCode(brand);
                    userPrefs.setCountryCode(country);
                    userPrefs.setLangCode(language);
                    userPrefs.setBuildType(BUILD_TYPE);
                    userPrefs.setCreatorId(String.valueOf(userPreferences.getUserId()));
                    userPrefs.setCreatedDate(new Date());
                    userPrefs.setUpdatedBy(String.valueOf(userPreferences.getUserId()));
                    userPrefs.setUpdatedDate(new Date());
                    userPrefs.setModuleName("OBSM");
                    userPrefs = UserPreferenceLocalServiceUtil.addUserPreference(userPrefs);
                }
                catch (SystemException e)
                {
                    LOG.error("Failed to add OBSM User Preference Settings");
                }
            }
            session.setAttribute(USER_PREFERENCES, userPreferences);
            session.setAttribute("USER_brand", brand);
            session.setAttribute("USER_locale", language);
            actionRequest.getPortletSession().setAttribute("USER_brand", brand, PortletSession.APPLICATION_SCOPE);
            actionRequest.getPortletSession().setAttribute("USER_locale", language, PortletSession.APPLICATION_SCOPE);
            
            httpReq.setAttribute("userPreferences", userPreferences);
            if(themeDisplay.getLayout().getFriendlyURL().contains("/staging/")){
                actionResponse.sendRedirect("/web/brand-standards/staging/home");
            }else{
                actionResponse.sendRedirect("/web/brand-standards/hotel/home");
            }
        }
        else
        {
            if(userPreferences.getLanguages() != null && 
                    userPreferences.getLanguages().isEmpty()
                    )
            {
                try
                {   
                    userPreferences.setLanguages(userPrefsApp.getLanguagesPerBrandCountry(userPrefs.getChainCode(), userPrefs.getCountryCode(), environment));
                    session.setAttribute(USER_PREFERENCES, userPreferences);
                    httpReq.setAttribute("userPreferences", userPreferences);
                }
                catch (Exception e)
                {
                    LOG.error("Caught Exception: ", e);
                }
            }
            httpReq.setAttribute(SHOW_ACCESS_DIALOG, false);
            httpReq.setAttribute(SHOW_NO_ACCESS_DIALOG, true);
            if (Validator.isNotNull(userPreferences))
            {
                language = userPreferences.getLangCode();
            }
            
            BSLanguageUtil obsmLanguageUtil = getOBSMLanguageUtil(actionRequest, language, "OBSM");
            httpReq.setAttribute("change", obsmLanguageUtil.get("bs.change"));
            httpReq.setAttribute("noAccess", obsmLanguageUtil.get("bs.no.access"));
            httpReq.setAttribute("youAreViewing", obsmLanguageUtil.get("bs.you.are.viewing"));
            httpReq.setAttribute("yourViewFor", obsmLanguageUtil.get("bs.for"));
            httpReq.setAttribute("yourViewIn", obsmLanguageUtil.get("bs.in"));
            httpReq.setAttribute("yourView", obsmLanguageUtil.get("bs.your.view"));
            actionResponse.setRenderParameter("jspPage", USERPREFS_VIEW_JSP);
        }
        BSLanguageUtil obsmLanguageUtil = new BSLanguageUtil(userPreferences.getLangCode(), "OBSM");
        session.setAttribute("obsmLanguageUtil", obsmLanguageUtil);
    }

    /**
     * 
     * @param request This is a PortletRequest object
     * @param userPreferences This is an AccessAndPreferences object
     * @return AccessAndPreferences
     */
    public AccessAndPreferences getUserCredentialsFromRequest(PortletRequest request, AccessAndPreferences userPreferences)
    {
        UserPreferencesApplication userPrefsApplication = new UserPreferencesApplication();
        List<StandardsLocale> arlLanguages = new ArrayList<StandardsLocale>();
        List<String> arlChains = new ArrayList<String>();
        List<String> arlCountries = new ArrayList<String>();
        List<String> arlLocations = new ArrayList<String>();
        if (userPreferences == null)
        {
            userPreferences = new AccessAndPreferences();
        }
        try
        {
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(request);
            String url = httpReq.getRequestURI();
            String environment = "";
            if(url.contains("staging"))
            {
            	environment = "STAGING";
            }
            else
            {
            	environment = "PRODUCTION";
            }
            User user = themeDisplay.getUser();
            long userId = user.getUserId();
            userPreferences.setUser(user);
            userPreferences.setUserId(userId);
            Map<String, String> sessMap = MerlinSession.get(user.getScreenName());
            String locations = "";
            if (LOG.isDebugEnabled())
            {
                LOG.debug("session map :::" + sessMap);
            }
            if (sessMap != null)
            { 
                
                if (sessMap.get(USRTYP) != null)
                {
                    userPreferences.setUserType(sessMap.get(USRTYP));
                }
                if (!BrandStandardsUtil.IsNullOrBlank(sessMap.get(CURR_LOCATION)))
                {
                    String currchn = sessMap.get("CURRCHN");
                    String currBrand = sessMap.get("CURRBRND");
                    
                    if (!BrandStandardsUtil.IsNullOrBlank(currchn) && Validator.isNull(userPreferences.getChain()))
                    {
                    	String brandname;
                    	if(currBrand.equals("HCPR"))
                    	{
                    		brandname = "CR";
                    	}
                    	else if(currBrand.equals("HIRT"))
                    	{
                    		brandname = "RS";
                    	}else if(currBrand.equals("HICV")){
                    		brandname = "CV";
                    	}
                    	else
                        {
                    		brandname = currchn.toUpperCase();
                        }
                    	userPreferences.setChain(brandname);
                        userPreferences.setDefaultChain(brandname);
                    }
                }
                if (!BrandStandardsUtil.IsNullOrBlank(sessMap.get(SESSION_LOCATIONS)))
                {
                    locations = sessMap.get(SESSION_LOCATIONS);
                    String[] arrLocations = locations.split(";");
                    for (String location : arrLocations)
                    {
                        Map<String, String> hotelOfficeMap = BrandStandardsUtil.getHotelOfficeMap(location);
                        if (hotelOfficeMap.get(COUNTRY) != null && hotelOfficeMap.get(CHAIN) != null)
                        {
                            arlCountries.add(hotelOfficeMap.get(COUNTRY));
                            
                            if(hotelOfficeMap.get("brand").equals("HCPR"))
                            {
                            	arlChains.add("CR");
                            }
                            else if(hotelOfficeMap.get("brand").equals("HIRT"))
                            {
                            	arlChains.add("RS");
                            }
	                        else if(hotelOfficeMap.get("brand").equals("HICV")){
	                        	arlChains.add("CV");
	                    	}
                            else
                            {
                            	arlChains.add(hotelOfficeMap.get(CHAIN));
                            	if(hotelOfficeMap.get(CHAIN).equals("IC"))
                            	{
                            		arlChains.add("IR");
                            	}
                            }
                            arlLocations.add(location);
                            List<StandardsLocale> arlLang = userPrefsApplication.getLanguagesPerBrandCountry(hotelOfficeMap.get(CHAIN),
                                    hotelOfficeMap.get(COUNTRY), environment);
                            arlLanguages = new ArrayList<StandardsLocale>(arlLang);

                        }
                    }
                }

               
                if (sessMap.get(CURRCTRY) != null && Validator.isNull(userPreferences.getCountry()))
                {
                    userPreferences.setCountry(sessMap.get(CURRCTRY));
                }
                String defaultLocation = sessMap.get("CURRLOCATIONNAME");
                if (defaultLocation != null)
                {
                    userPreferences.setDefaultLocation(defaultLocation);
                }
                String locationName = sessMap.get("LOCATIONNAME");
                if (locationName != null)
                {
                    userPreferences.setLocationName(locationName);
                }
            }

        }
        catch (Exception e)
        {
            LOG.info("Exception: ", e);
        }
        userPreferences.setLanguages(arlLanguages);
        userPreferences.setChains(BrandStandardsUtil.removeDuplicates(arlChains));
        userPreferences.setCountries(BrandStandardsUtil.removeDuplicates(arlCountries));
        if (LOG.isDebugEnabled())
        {
            LOG.debug("userPreferences ::::" + userPreferences.getCountries());
            LOG.debug("current country ::::" + userPreferences.getCountry());
        }
        userPreferences.setLocations(arlLocations);
        return userPreferences;
    }

    /**
     * @param request This is a PortletRequest object
     * @param langCode This is a String object
     */
    private void setAccessScreenLabels(PortletRequest request, BSLanguageUtil obsmLanguageUtil)
    {
        request.setAttribute("yourView", obsmLanguageUtil.get("bs.your.view"));
        request.setAttribute("change", obsmLanguageUtil.get("bs.change"));
        request.setAttribute("youAreViewing", obsmLanguageUtil.get("bs.you.are.viewing"));
        request.setAttribute("yourViewFor", obsmLanguageUtil.get("bs.for"));
        request.setAttribute("yourViewIn", obsmLanguageUtil.get("bs.in"));
        request.setAttribute("yourViewNote", obsmLanguageUtil.get("bs.your.view.note"));
        request.setAttribute("employeeNote", obsmLanguageUtil.get("bs.your.view.employee.note"));
        request.setAttribute("brand", obsmLanguageUtil.get("bs.brand"));
        request.setAttribute(COUNTRY, obsmLanguageUtil.get("bs.country"));
        request.setAttribute("language", obsmLanguageUtil.get("bs.language"));
        request.setAttribute("changeSettings", obsmLanguageUtil.get("bs.change.settings"));
        request.setAttribute("cancel", obsmLanguageUtil.get("bs.cancel"));
        request.setAttribute("noAccess", obsmLanguageUtil.get("bs.no.access"));
        request.setAttribute("selectBrandVal", obsmLanguageUtil.get("bs.select.brand.msg"));
        request.setAttribute("selectCountryVal", obsmLanguageUtil.get("bs.select.country.msg"));
        request.setAttribute("selectLanguageVal", obsmLanguageUtil.get("bs.select.language.msg"));
        request.setAttribute("returnToMerlin", obsmLanguageUtil.get("bs.return.to.merlin"));
        request.setAttribute("returnToMerlinMsg", obsmLanguageUtil.get("bs.your.view.not.available.msg"));
        request.setAttribute("hasNoBrandMerlinMsg", obsmLanguageUtil.get("bs.has.not.any.brand.msg"));
        request.setAttribute("notActiveBrandMsg", obsmLanguageUtil.get("bs.is.not.active.brand.msg"));

    }
}
