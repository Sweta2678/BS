/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ihg.brandstandards.db.service.UIElementLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="BSLanguageUtil.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class BSLanguageUtil implements Serializable
{
    private static final Log LOG = LogFactoryUtil.getLog(BSLanguageUtil.class);
    private static final long serialVersionUID = 1L;
    private Map<String, String> bsUIElements = new LinkedHashMap<String, String>();

    /**
     * Constructor with locale code argument.
     * 
     * @param localeCode the locale code
     */
    public BSLanguageUtil(String localeCode)
    {
        String localeCD = localeCode;
        try
        {
            if (Validator.isNull(localeCD))
            {
                localeCD = "en_GB";
            }
            //LOG.debug("====> BSLanguageUtil Bean created with ("+localeCD+")  ================");
            bsUIElements = (Map<String, String>) UIElementLocalServiceUtil.loadUIElements(localeCD);
        }
        catch (Exception e)
        {
            LOG.error("Failed load UI Elements", e);
        }
    }

    /**
     * Constructor with locale code & module used In argument.
     * 
     * @param localeCode the locale code
     * @param moduleUsedIn The used in module
     */
    public BSLanguageUtil(String localeCode, String moduleUsedIn)
    {
        String localeCD = localeCode;
        String usedIn = moduleUsedIn;
        try
        {
            if (Validator.isNull(localeCD))
            {
                localeCD = "en_GB";
            }
            if (Validator.isNull(usedIn))
            {
                usedIn = "OBSM";
            }
            //LOG.debug("====> BSLanguageUtil Bean created with ("+localeCD+")  ================");
            bsUIElements = (Map<String, String>) UIElementLocalServiceUtil.loadUIElements(localeCD, usedIn);
        }
        catch (Exception e)
        {
            LOG.error("Failed load UI Elements", e);
        }
    }

    /**
     * Get method will return value of the key value.
     * 
     * @param key The UI Element key
     * @return
     */
    public String get(String key)
    {
        if (bsUIElements.get(key) != null && !(bsUIElements.get(key).trim().isEmpty()))
        {
            return bsUIElements.get(key);
        }
        else
        {
            LOG.warn("Element Key not found. Returning Key. Key:" + key);
            return key;
        }
    }

    /**
     * Get method will return value of the key value.
     * 
     * @param key The UI Element key
     * @param defaultValue The default value
     * @return
     */
    public String get(String key, String defaultValue)
    {

        if (bsUIElements.get(key) != null && !(bsUIElements.get(key).trim().isEmpty()))
        {
            return bsUIElements.get(key);
        }
        else if (defaultValue != null && !(defaultValue.trim().isEmpty()))
        {
            LOG.warn("Element Key not found. Returning default value. Key:" + key);
            return defaultValue;
        }
        else
        {
            LOG.warn("Element Key not found. Default value is null or emprty. Returning Key. Key:" + key);
            return key;
        }
    }

    /**
     * @param key The UI Element key
     * @param arguments The arguments
     * @return
     */
    public String format(String key, Object[] arguments)
    {
        return format(key, arguments, "", false);
    }
    
    /**
     * @param key The UI Element key 
     * @param arguments The arguments
     * @param defaultValue The default value
     * @return
     */
    public String format(String key, Object[] arguments, String defaultValue)
    {
        return format(key, arguments, defaultValue, false);
    }

    /**
     * @param key The UI Element key
     * @param arguments The arguments
     * @param defaultValue The default value
     * @param translateArguments The translateArguments boolean
     * @return
     */
    public String format(String key, Object[] arguments, String defaultValue, boolean translateArguments)
    {
        if (bsUIElements.get(key) == null || bsUIElements.get(key).trim().isEmpty())
        {
            if (defaultValue != null && !(defaultValue.trim().isEmpty()))
            {
                LOG.warn("Element Key not found. Returning default value. Key:" + key);
                return defaultValue;
            }
            else
            {
                LOG.warn("Element Key not found. Default value is null or emprty. Returning Key. Key:" + key);
                return key;
            }
        }

        String value = null;

        try
        {
            String pattern = bsUIElements.get(key);

            if (arguments != null)
            {
                pattern = _escapePattern(pattern);

                Object[] formattedArguments = new Object[arguments.length];

                for (int i = 0; i < arguments.length; i++)
                {
                    if (translateArguments)
                    {
                        formattedArguments[i] = bsUIElements.get(arguments[i].toString());
                    }
                    else
                    {
                        formattedArguments[i] = arguments[i];
                    }
                }

                value = MessageFormat.format(pattern, formattedArguments);
            }
            else
            {
                value = pattern;
            }
        }
        catch (Exception e)
        {
            LOG.warn(e, e);
        }

        if (value == null)
        {
            return defaultValue;
        }

        return value;
    }

    /**
     * @param pattern The pattern
     * @return
     */
    private String _escapePattern(String pattern)
    {
        return StringUtil.replace(pattern, StringPool.APOSTROPHE, StringPool.DOUBLE_APOSTROPHE);
    }
}
