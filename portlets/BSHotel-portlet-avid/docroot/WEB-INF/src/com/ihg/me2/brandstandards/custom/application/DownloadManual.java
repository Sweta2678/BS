/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishedPdfList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="DownloadManual.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 * 
 */
public interface DownloadManual extends ContentApplication
{
	/**
	 * @param publishId This is a long object
	 * @param countryCode This is a String object
	 * @param langCode This is a String object
	 * @param buildType This is a String object
	 * @param pageSize This is a String object
	 * @return PublishedPdfList
	 */
    public PublishedPdfList getPublishedPDF(long publishId, String countryCode, String langCode, String buildType, String pageSize);

    /**
     * @param brandCode This is a String object
     * @param environment This is a String object
     * @param status This is a String object
     * @return Publish
     */
    public Publication getCurrentBrandPublishedObject(String brandCode, String environment, String status);
    
    /**
     * @param publishId This is a long object
     * @param countryCode This is a String object
     * @param buildType This is a String object
     * @param pageSize This is a String object
     * @return Map<String,String>
     */
    public Map<String, LinkedHashMap<String,String>> getStaticManuals(long publishId, String countryCode, List<String> buildTypes, String pageSize);
}