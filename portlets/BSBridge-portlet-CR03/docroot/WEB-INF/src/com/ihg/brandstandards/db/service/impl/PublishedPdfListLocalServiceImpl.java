/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.PublishedPdfList;
import com.ihg.brandstandards.db.service.PublishedPdfListLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.PublishedPdfListLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the published pdf list local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.PublishedPdfListLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishedPdfListLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishedPdfListLocalServiceUtil
 */
public class PublishedPdfListLocalServiceImpl
	extends PublishedPdfListLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishedPdfListLocalServiceUtil} to access the published pdf list local service.
	 */
    private static final Log LOG = LogFactoryUtil.getLog(PublishedPdfListLocalServiceImpl.class);
    
    public void clearCache()
    {
        try
        {
            publishedPdfListPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public PublishedPdfList addPublishedPdfList(String pdfChainCode, String pdfCtryCode, String pdfBuildType, int pdfYearNumber,
            String pdfLocaleCode, long pdfVersionNumber, String pdfFileName, String pdfFileURLText, long publishId,
            String pageSizeOrientationType, String createdBy, Date createDate, String updatedBy, Date updateDate)
            throws PortalException, SystemException
    {

        PublishedPdfList publishedPdfList = PublishedPdfListLocalServiceUtil.createPublishedPdfList(CounterLocalServiceUtil
                .increment(PublishedPdfList.class.getName()));

        publishedPdfList.setPdfChainCode(pdfChainCode);
        publishedPdfList.setPdfCtryCode(pdfCtryCode);
        publishedPdfList.setPdfBuildType(pdfBuildType);
        publishedPdfList.setPdfYearNumber(pdfYearNumber);
        publishedPdfList.setPdfLocaleCode(pdfLocaleCode);
        publishedPdfList.setPdfVersionNumber(pdfVersionNumber);
        publishedPdfList.setPdfFileName(pdfFileName);
        publishedPdfList.setPdfFileURLText(pdfFileURLText);
        publishedPdfList.setPublishId(publishId);
        publishedPdfList.setPageSizeOrientationType(pageSizeOrientationType);

        publishedPdfList.setCreatedBy(createdBy);
        publishedPdfList.setCreatedDate(createDate);
        publishedPdfList.setUpdatedBy(updatedBy);
        publishedPdfList.setUpdatedDate(updateDate);
        publishedPdfListPersistence.update(publishedPdfList);
        return publishedPdfList;
    }

    public PublishedPdfList updatePublishedPdfList(long pdfId, String pdfChainCode, String pdfCtryCode, String pdfBuildType,
            int pdfYearNumber, String pdfLocaleCode, long pdfVersionNumber, String pdfFileName, String pdfFileURLText,
            long publishId, String pageSizeOrientationType, String createdBy, Date createDate, String updatedBy, Date updateDate)
            throws PortalException, SystemException
    {

        PublishedPdfList publishedPdfList = publishedPdfListPersistence.findByPrimaryKey(pdfId);

        publishedPdfList.setPdfChainCode(pdfChainCode);
        publishedPdfList.setPdfCtryCode(pdfCtryCode);
        publishedPdfList.setPdfBuildType(pdfBuildType);
        publishedPdfList.setPdfYearNumber(pdfYearNumber);
        publishedPdfList.setPdfLocaleCode(pdfLocaleCode);
        publishedPdfList.setPdfVersionNumber(pdfVersionNumber);
        publishedPdfList.setPdfFileName(pdfFileName);
        publishedPdfList.setPdfFileURLText(pdfFileURLText);
        publishedPdfList.setPublishId(publishId);
        publishedPdfList.setPageSizeOrientationType(pageSizeOrientationType);

        publishedPdfList.setUpdatedBy(updatedBy);
        publishedPdfList.setUpdatedDate(updateDate);
        publishedPdfListPersistence.update(publishedPdfList);
        return publishedPdfList;
    }

    public List<PublishedPdfList> getByPdfChainCode(String pdfChainCode) throws PortalException, SystemException
    {
        List<PublishedPdfList> publishedPdfLists = publishedPdfListPersistence.findByPdfChainCode(pdfChainCode);
        return publishedPdfLists;
    }

    public List<PublishedPdfList> getByPdfCtryCode(String pdfCtryCode) throws PortalException, SystemException
    {
        List<PublishedPdfList> publishedPdfLists = publishedPdfListPersistence.findByPdfCtryCode(pdfCtryCode);
        return publishedPdfLists;
    }

    public List<PublishedPdfList> getByPdfFileName(String pdfFileName) throws PortalException, SystemException
    {
        List<PublishedPdfList> publishedPdfLists = publishedPdfListPersistence.findByPdfFileName(pdfFileName);
        return publishedPdfLists;
    }

    public List<PublishedPdfList> getByPdfFileURLText(String pdfFileURLText) throws PortalException, SystemException
    {
        List<PublishedPdfList> publishedPdfLists = publishedPdfListPersistence.findByPdfFileURLText(pdfFileURLText);
        return publishedPdfLists;
    }

    public List<PublishedPdfList> getByPdfFileNameAndURL(String pdfFileName, String pdfFileURLText) throws PortalException,
            SystemException
    {
        List<PublishedPdfList> publishedPdfLists = publishedPdfListPersistence.findByPdfFileNameAndURL(pdfFileName,
                pdfFileURLText);
        return publishedPdfLists;
    }

    public PublishedPdfList getByPdfManualParams(long publishId, String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
            String pageSizeOrientationType) throws PortalException, SystemException
    {
        List<PublishedPdfList> publishedPdfLists = publishedPdfListPersistence.findByPdfManualParams(publishId, pdfCtryCode,
                pdfLocaleCode, pdfBuildType, pageSizeOrientationType);

        PublishedPdfList publishedPdf = null;
        if (publishedPdfLists.size() > 0)
        {
            publishedPdf = publishedPdfLists.get(0);
        }
        return publishedPdf;
    }

    public String getPublishedPDFFullManualURL(long publishId, String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
            String pageSizeOrientationType)
    {
        String publishedManualURL = "#";
        List<PublishedPdfList> publishedPdfLists = null;
        try
        {
            publishedPdfLists = publishedPdfListPersistence.findByPdfManualParams(publishId, pdfCtryCode,
                    pdfLocaleCode, pdfBuildType, pageSizeOrientationType);
            PublishedPdfList publishedPdf = null;
            if (publishedPdfLists.size() > 0)
            {
                publishedPdf = publishedPdfLists.get(0);
                if (publishedPdf != null && publishedPdf.getPdfFileURLText() != null
                        && !(publishedPdf.getPdfFileURLText().trim().isEmpty()))
                {
                    publishedManualURL = publishedPdf.getPdfFileURLText();
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        return publishedManualURL;
    }

    public Map<String, LinkedHashMap<String,String>> getPublishedPDFListByParams(long publishId, String pdfCtryCode, List<String> pdfBuildTypes,
            String pageSizeOrientationType)
    {
        List<PublishedPdfList> publishedPdfLists = null;
        List<PublishedPdfList> pdfListByManuals = new ArrayList<PublishedPdfList>();
        
        Map<String, LinkedHashMap<String,String>> staticManuals = new LinkedHashMap<String, LinkedHashMap<String, String>>();
        try
        {
            if(pdfBuildTypes != null && pdfBuildTypes.size() > 0){
                for (String pdfBuildType : pdfBuildTypes) {
                    if (Validator.isNotNull(pageSizeOrientationType)) {
                        publishedPdfLists = publishedPdfListPersistence.findByPublishPdfManualParams(publishId, pdfCtryCode, pdfBuildType,
                            pageSizeOrientationType);
                    } else {
                        publishedPdfLists = publishedPdfListPersistence.findByPublishedPDFParams(publishId, pdfCtryCode, pdfBuildType);
                    }
                    pdfListByManuals.addAll(publishedPdfLists);
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        if (Validator.isNotNull(pdfListByManuals))
        {
            for (PublishedPdfList manual : pdfListByManuals)
            {
                LinkedHashMap<String, String> buildTypePdfUrlMap = null;
                if(!staticManuals.containsKey(manual.getPdfLocaleCode())){
                    buildTypePdfUrlMap = new LinkedHashMap<String, String>();
                    
                }else {
                    buildTypePdfUrlMap = staticManuals.get(manual.getPdfLocaleCode());
                }
                buildTypePdfUrlMap.put(manual.getPdfBuildType() , manual.getPdfFileURLText());
                
                staticManuals.put(manual.getPdfLocaleCode(), buildTypePdfUrlMap);
            }
        }
        return staticManuals;
    }
}