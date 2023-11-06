/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishedPdfList;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishedPdfListLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="DownloadManualImpl.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 * 
 */
public class DownloadManualImpl extends ContentApplicationImpl implements DownloadManual
{
    private static final Log LOG = LogFactoryUtil.getLog(DownloadManualImpl.class);

    /**
     * @param publishId This is a long object
     * @param countryCode This is a String object
     * @param langCode This is a String object
     * @param buildType This is a String object
     * @param pageSize This is a String object
     * @return PublishedPdfList
     */
    public PublishedPdfList getPublishedPDF(long publishId, String countryCode, String langCode, String buildType, String pageSize)
    {
        PublishedPdfList pdfList = null;
        try
        {
            pdfList = PublishedPdfListLocalServiceUtil.getByPdfManualParams(publishId, countryCode, langCode, buildType, pageSize);
        }
        catch (PortalException e)
        {
        	LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
        	LOG.error(e.getMessage(), e);
        }
        return pdfList;
    }

    /**
     * @param brandCode This is a String object
     * @param environment This is a String object
     * @param status This is a String object
     * @return Publish
     */
    public Publication getCurrentBrandPublishedObject(String brandCode, String environment, String status)
    {
    	Publication publish = PublicationLocalServiceUtil.getPublishObjectByBrand(brandCode, environment, status);
        return publish;
    }

    /**
     * @param publishId This is a long object
     * @param countryCode This is a String object
     * @param buildType This is a String object
     * @param pageSize This is a String object
     * @return Map<String, String>
     */
    public Map<String, LinkedHashMap<String,String>> getStaticManuals(long publishId, String countryCode, List<String> buildTypes, String pageSize)
    {
        return PublishedPdfListLocalServiceUtil.getPublishedPDFListByParams(publishId, countryCode, buildTypes, pageSize);
    }
}
