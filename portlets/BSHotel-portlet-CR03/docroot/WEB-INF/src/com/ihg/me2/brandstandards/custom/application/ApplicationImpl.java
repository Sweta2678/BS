/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import java.util.zip.ZipOutputStream;

import com.ihg.brandstandards.db.model.PublishStd;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.liferay.portal.kernel.util.Validator;

/**
 * <a href="ApplicationImpl.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author KhandeN
 */
public class ApplicationImpl implements Application
{
    //private static final Log LOG = LogFactoryUtil.getLog(ApplicationImpl.class);
    static final String STD_TYP_STD = "STD";
    static final String STD_TYP_SPEC = "SPEC";
    static final String STD_TYP_GDLN = "GDLN";

    /**
     * @param standard This is a PublishStandards object
     * @return boolean
     */
    public boolean isStandardAvailable(PublishStd standard)
    {
        String status = standard.getStatus();
        boolean isAvailable = true;
        if (Validator.isNotNull(status)
                && (BrandStandardsConstant.STANDARD_STATUS_DELETED.equalsIgnoreCase(status) || BrandStandardsConstant.STANDARD_STATUS_EXPIRED
                        .equalsIgnoreCase(status)))
        {
            isAvailable = false;
        }
        return isAvailable;
    }

    /**
     * @param locale This is a locale object
     * @return boolean
     */
    public boolean isDefaultLocale(String locale)
    {
        return BrandStandardsConstant.DEFAULT_LOCALE.equalsIgnoreCase(locale);
    }

    /**
     * @return ZipOutputStream
     */
    public ZipOutputStream createZipBundle()
    {
        return null;
    }

}
