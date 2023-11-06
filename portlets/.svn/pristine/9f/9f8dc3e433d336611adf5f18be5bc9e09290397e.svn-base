/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import java.util.zip.ZipOutputStream;

import com.ihg.brandstandards.db.model.PublishStd;

/**
 * <a href="Application.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author KhandeN
 */
public interface Application
{
    /**
     * @return ZipOutputStream
     */
    public abstract ZipOutputStream createZipBundle();

    /**
     * @param standard This is PublishStandards object.
     * @return boolean.
     */
    public boolean isStandardAvailable(PublishStd standard);

    /**
     * @param locale This is a String object.
     * @return boolean.
     */
    public boolean isDefaultLocale(String locale);

}
