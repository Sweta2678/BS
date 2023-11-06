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

import java.util.List;

import com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException;
import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.AttachmentsStandardsCountry;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.base.AttachmentsStandardsLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the attachments standards local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.AttachmentsStandardsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.AttachmentsStandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil
 */
public class AttachmentsStandardsLocalServiceImpl extends AttachmentsStandardsLocalServiceBaseImpl 
{
    
    private static final Log LOG = LogFactoryUtil.getLog(AttachmentsStandardsLocalServiceImpl.class);

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil} to access the attachments standards local service.
	 */
    public void clearCache()
    {
        try
        {
            attachmentsStandardsPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<AttachmentsStandards> getAttachmentsStandardsByStandardId(long stdId) throws SystemException
    {
        return attachmentsStandardsPersistence.findByStdId(stdId);
    }

    public List<AttachmentsStandards> getAttachmentsStandardsByParentId(long parentId) throws SystemException
    {
        return attachmentsStandardsPersistence.findByparentAttachmentId(parentId);
    }

    public List<AttachmentsStandards> getAttachmentsStandardsByParentIdStdIdLangId(long parentId, long stdId, String langCd)
            throws SystemException
    {
        return attachmentsStandardsPersistence.findByparentIdStdIdLocaleCd(parentId, stdId, langCd);
    }

    public List<AttachmentsStandards> getAttachmentsStandardsByLocaleCdStdId(String localeCd, long stdId)
            throws SystemException
    {
        return attachmentsStandardsPersistence.findByStdIdLocaleCd(stdId, localeCd);
    }

    public List<AttachmentsStandards> getAttachmentsStandardsByParentIdStdId(long parentId, long stdId) throws SystemException
    {
        return attachmentsStandardsPersistence.findByParentIdStdId(parentId, stdId);
    }

    @SuppressWarnings("unchecked")
    public List<AttachmentsStandards> getAttachmentsStandardsParentsByStdId(long standardId) throws SystemException
    {
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AttachmentsStandards.class, portletClassLoader);
        dynamicQuery.add(RestrictionsFactoryUtil.eq("stdId", standardId));
        //dynamicQuery.add(RestrictionsFactoryUtil.eq("primaryKey.localeCode", BrandStandardsUtil.DEFAULT_LOCALE));
        dynamicQuery.add(RestrictionsFactoryUtil.eqProperty("parentAttachmentId", "primaryKey.attachmentId"));
        return AttachmentsStandardsLocalServiceUtil.dynamicQuery(dynamicQuery);
    }

    public AttachmentsStandards getAttachmentsStandardsByParentIdAttachId(long parentAttachId, long attachId) throws NoSuchAttachmentsStandardsException, SystemException
    {
        return attachmentsStandardsPersistence.findByParentIdAttachId(attachId, parentAttachId);
    }
    
    public AttachmentsStandards deleteAttachmentsStandards(AttachmentsStandards attachment) throws SystemException
    {
    	//Remove  Chaind reference
        List<ChainAttachmentsStandards> chainAttachments = ChainAttachmentsStandardsLocalServiceUtil.getChainAttachmentsStandardsByAttachmentId(attachment.getAttachmentId());
        for(ChainAttachmentsStandards chainAttachment : chainAttachments)
        {
            ChainAttachmentsStandardsLocalServiceUtil.deleteChainAttachmentsStandards(chainAttachment);
        }
        
        //Remove  country reference
        List< AttachmentsStandardsCountry> countryList =  AttachmentsStandardsCountryLocalServiceUtil.getAttachmentsStandardsCountryByAttachmentId(attachment.getAttachmentId());
    	for ( AttachmentsStandardsCountry countryAttachment : countryList)
    	{
    		AttachmentsStandardsCountryLocalServiceUtil.deleteAttachmentsStandardsCountry(countryAttachment);
    	}
        return attachmentsStandardsPersistence.remove(attachment);
                
    }
    
    public AttachmentsStandards getAttchmentByAttachmendId(long attachmentId){
        try {
            return attachmentsStandardsPersistence.findByattachmentId(attachmentId);
        } catch (NoSuchAttachmentsStandardsException e) {
            LOG.error(StackTraceUtil.getStackTrace(e));
        } catch (SystemException e) {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return null;
    }
    
    /**
     * Get Standards attachment translation by passing  stdId, regionId and locales.
     * 
     * @param stdId
     * @param regionId
     * @param locales
     * @return
     */
    public List<AttachmentsStandards> getStandardAttachmentsByStdIdAndRgnIdAndLocale(long stdId, String regionId, List<String> locales)
    {
    	return attachmentsStandardsFinder.getStandardAttachmentsByStdIdAndRgnIdAndLocale(stdId, regionId, locales);
    }
}