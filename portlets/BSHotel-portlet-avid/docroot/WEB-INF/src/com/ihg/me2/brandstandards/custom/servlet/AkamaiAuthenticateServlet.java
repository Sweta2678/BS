/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.me2.brandstandards.custom.application.UserPreferencesApplication;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.ihg.me2.utils.session.MerlinSession;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoTableConstants;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

/**
 * <a href="AkamaiAuthenticateServlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 */
public class AkamaiAuthenticateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    //private static String BS_QA = "/qa/";
    private static final String BS_STAGING = "/stage/";
    private static final String FULL_MANUAL = "/downloads/manuals/";
    private static final String USER_CLASSNAME = "com.liferay.portal.model.User";
    private static final String USER_TYPE = "User Type";
    private static final String USER_BRANDS = "Brands";
    private static final Log LOG = LogFactoryUtil.getLog(AkamaiAuthenticateServlet.class);

    /**
     * @param request This is an HttpServletRequest object
     * @param response This is an HttpServletResponse Object
     * @throws IOException throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("AKAMAI: -------------------------------------- STARTING AKAMAIAUTH SERVICE ------------------------------------------");
            LOG.debug("AKAMAI: request.getQueryString(): " + request.getQueryString());
        }

        try
        {
            StringBuffer requestURL = request.getRequestURL();
            String completeURL = StringPool.BLANK;
            String akamaiHeader = request.getHeader("X-Akamai-Processing-Agent");

            if (LOG.isDebugEnabled())
            {
                LOG.debug("AKAMAI: completeURL 1: " + completeURL);
                LOG.debug("akamaiHeader: " + akamaiHeader);
            }

            if (request.getQueryString() != null)
            {
                requestURL.append(StringPool.QUESTION).append(request.getQueryString());
            }
            completeURL = requestURL.toString();
            if (LOG.isDebugEnabled())
            {
                LOG.debug("AKAMAI: completeURL 2: " + completeURL);
                LOG.debug("AKAMAI: akamaiHeader: " + akamaiHeader);
            }

            if (akamaiHeader == null)
            {

                completeURL = completeURL.replace("BSHotel-portlet/AkamaiAuthService/?URL=/", "");
                completeURL = completeURL.replace("BSHotel-portlet/AkamaiAuthService?URL=/", "");
                completeURL = completeURL.replace("http:", "https:");
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("AKAMAI: AKAMAI HEADER IS NULL");
                    LOG.debug("Akamai header is not present. Will redirect to original file url: " + completeURL);
                    LOG.debug("AKAMAI: SETTING 200 OK RESPONSE (1)");
                    LOG.debug("AKAMAI: REDIRECTING USER TO: " + completeURL);
                    LOG.debug("AKAMAI: -------------------------------------- ENDING AKAMAIAUTH SERVICE 1 ------------------------------------------");
                }

                response.setStatus(HttpServletResponse.SC_OK);
                response.sendRedirect(completeURL);
            }
            else
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("AKAMAI: Akamai header is  present. Will redirect to original file url: " + completeURL);
                }
                checkForUserAccess(request, response);
            }

            if (LOG.isDebugEnabled())
            {
                LOG.debug("AKAMAI: -------------------------------------- ENDING AKAMAIAUTH SERVICE 2 ------------------------------------------");
            }
        }
        catch (Exception e)
        {
            LOG.error("Exception in doGet: ", e);
        }
    }

    /**
     * @param request This is an HttpServletRequest Object
     * @param response This is an HttpServletResponse Object
     * @throws IOException throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        doGet(request, response);
    }

    /**
     * @param hexString string to get convert ASCII
     * @return returns string value
     */
    @Deprecated
    public String hexStringToStringByAscii(String hexString)
    {
        byte[] bytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length() / 2; i++)
        {
            String oneHexa = hexString.substring(i * 2, i * 2 + 2);
            bytes[i] = Byte.parseByte(oneHexa, 16);
        }
        try
        {
            return new String(bytes, "ASCII");
        }
        catch (UnsupportedEncodingException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param request This is an HttpServletResponse Object
     * @return long returns long value
     */
    private long getCompanyId(HttpServletRequest request)
    {
        long companyId = 0l;
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies)
        {
            if ("COMPANY_ID".equals(c.getName()) && Validator.isNotNull(c.getValue()))
            {
                companyId = GetterUtil.getLong(c.getValue());
                break;
            }
        }
        if (companyId == 0l)
        {
            companyId = PortalUtil.getDefaultCompanyId();
        }
        return companyId;
    }

    /**
     * @param user This is a User object
     * @param request This is an HttpServletResponse Object
     * @return boolean returns boolean value
     */
    private boolean isCorporateUser(User user, HttpServletRequest request)
    {

        boolean isCorporateUser = false;
        String userType = getExpandoValue(user, USER_TYPE, getCompanyId(request));
        if (LOG.isDebugEnabled())
        {
            LOG.debug("user type is :" + userType);
        }
        if (Validator.isNotNull(userType) && (userType.contains("[C]") || userType.contains("[T]") || userType.contains("[V]")))
        {
            isCorporateUser = true;
        }
        return isCorporateUser;
    }

    /**
     * @param user This is a User object
     * @param request This is an HttpServletResponse Object
     * @param destinationPath This is a String object
     * @return boolean returns boolean value
     */
    private boolean hasUserCurrentBrandAndCountry(User user, HttpServletRequest request, String destinationPath)
    {
        boolean hasBrandAndCountry = false;
        boolean hasBrand = false;
        String brands = getExpandoValue(user, USER_BRANDS, getCompanyId(request));
        String currentBrand = destinationPath.substring(destinationPath.indexOf("manuals/") + 8);
        String currentCountry = destinationPath.substring(destinationPath.lastIndexOf('/') + 1);
        currentBrand = currentBrand.substring(0, currentBrand.indexOf('/'));
        UserPreferencesApplication userPrefsApp = new UserPreferencesApplication();
        UserPreference userPrefs = userPrefsApp.getUserPreferences(user.getUserId());
        //String country = userPrefs.getCountryCode();
        String brand = userPrefs.getChainCode();
        if (LOG.isDebugEnabled())
        {
            LOG.debug("user brands :" + brands);
            LOG.debug("User Pref brand :" + brand);
            LOG.debug(" current country :" + currentCountry);
            LOG.debug("download manual "+currentBrand);
        }
        //Fix for Intercontinental Resorts and Crown Plaza Resorts
        if (Validator.isNotNull(brand) && brand.contains(currentBrand))
        {
            hasBrand = true;
        }
        if (hasBrand)
        {
            Map<String, String> sessMap = MerlinSession.get(user.getScreenName());
            if (Validator.isNotNull(sessMap) && Validator.isNotNull(sessMap.get("LOCATIONS")))
            {
                String locations = sessMap.get("LOCATIONS");
                String[] arrLocations = locations.split(";");
                for (int i = 0; i < arrLocations.length; i++)
                {
                    Map<String, String> hotelOfficeMap = BrandStandardsUtil.getHotelOfficeMap(arrLocations[i]);
                    if (hotelOfficeMap.get("country") != null && currentCountry.contains(hotelOfficeMap.get("country")))
                    {
                        hasBrandAndCountry = true;
                        break;
                    }
                }
            }
        }

        return hasBrandAndCountry;
    }

    /**
     * @param user This is a User object
     * @param attributeName This is a String object
     * @param companyId This is a long object
     * @return String returns string value
     */
    private String getExpandoValue(User user, String attributeName, long companyId)
    {
        String attributeValue = StringPool.BLANK;
        try
        {
            attributeValue = ExpandoValueLocalServiceUtil.getData(companyId, USER_CLASSNAME,
                    ExpandoTableConstants.DEFAULT_TABLE_NAME, attributeName, user.getUserId(), StringPool.BLANK);
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        return attributeValue;
    }

    /**
     * @param request This is an HttpServletRequest Object
     * @param response This is an HttpServletResponse Object
     */
    private void checkForUserAccess(HttpServletRequest request, HttpServletResponse response)
    {
        String destinationPath = request.getQueryString();
        String loggedInUser = request.getHeader("SAMACCOUNTNAME");
        if (LOG.isDebugEnabled())
        {
            LOG.debug("loggedInUser :" + loggedInUser);
            LOG.debug("destinationPath :" + destinationPath);
        }
        /*if (Validator.isNotNull(destinationPath)
        		&& destinationPath.contains(BS_QA)) {
            response.setStatus(HttpServletResponse.SC_OK);
            if (_log.isDebugEnabled()) {
                _log.debug("It is qa server :");
            }
        } else*/if (Validator.isNotNull(destinationPath) && destinationPath.contains(BS_STAGING))
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("AKAMAI: It is a staging server :");
            }
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else if (Validator.isNotNull(loggedInUser))
        {
            if (Validator.isNotNull(destinationPath) && destinationPath.contains(FULL_MANUAL))
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("AKAMAI: Request for full manual :");
                }
                long companyId = getCompanyId(request);
                try
                {
                    User user = UserLocalServiceUtil.getUserByScreenName(companyId, loggedInUser);
                    if (isCorporateUser(user, request))
                    {
                        response.setStatus(HttpServletResponse.SC_OK);
                    }
                    else if (hasUserCurrentBrandAndCountry(user, request, destinationPath))
                    {
                        if (LOG.isDebugEnabled())
                        {
                            LOG.debug("AKAMAI: User has access to full manual :");
                        }
                        response.setStatus(HttpServletResponse.SC_OK);
                    }
                    else
                    {
                        if (LOG.isDebugEnabled())
                        {
                            LOG.debug("AKAMAI: User does not have access to full manual :");
                        }
                        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    }
                }
                catch (PortalException e)
                {
                    LOG.error(e.getMessage(), e);
                }
                catch (SystemException e)
                {
                    LOG.error(e.getMessage(), e);
                }
            }
            else if (Validator.isNotNull(destinationPath) && Validator.isNotNull(loggedInUser)
                    && destinationPath.toLowerCase().contains(loggedInUser.toLowerCase()))
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("AKAMAI: user has access to manual:");
                }
                response.setStatus(HttpServletResponse.SC_OK);
            }
            else
            {
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("AKAMAI: no access ::");
                }
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }
        }
        else
        {
            if (LOG.isDebugEnabled())
            {
                LOG.debug("AKAMAI: no access ::");
            }
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }

    }
}