/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.brandstandards.custom.model.StdImage;

import java.util.List;

/**
 * <a href="AttachmentsApplication.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 * 
 */
public interface AttachmentsApplication extends Application
{
    /**
     * 
     * @param stdId StandardId String object
     * @param locale Locale String object
     * @param brand brand String object
     * @param countryCode countryCode String object
     * @param environment environment String object
     * @param criteria criteria String object
     * @return List<StdImage>
     */
    public List<StdImage> getAssociatedImages(long stdId, String locale, String brand, String countryCode, String environment,
            StandardsSearchCriteria criteria);

    /**
     * 
     * @param stdId StandardId String object
     * @param locale Locale String object
     * @param brand brand String object
     * @param countryCode countryCode String object
     * @param environment environment String object
     * @param criteria criteria String object
     * @return Standard
     */
    public Standard getAllsupportingMaterial(long publishId, long stdId, String locale, String brand, String countryCode, String environment,
            StandardsSearchCriteria criteria);
}
