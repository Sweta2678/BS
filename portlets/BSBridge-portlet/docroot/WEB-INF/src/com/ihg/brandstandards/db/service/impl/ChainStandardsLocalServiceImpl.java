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
import java.util.List;

import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.impl.ChainStandardsImpl;
import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsChainImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.ChainStandardsLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the chain standards local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.ChainStandardsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.ChainStandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil
 */
public class ChainStandardsLocalServiceImpl
	extends ChainStandardsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil} to access the chain standards local service.
	 */
    public ChainStandards getChainStandardsObject(){
        return new ChainStandardsImpl();
    }
    
    public void clearCache()
    {
        try
        {
            chainStandardsPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<ChainStandards> getChainStandardsByStdId(long stdId) throws SystemException
    {
        return chainStandardsPersistence.findByStdId(stdId, "Y");
    }
    public ChainStandards getChainStandardsByChainCode(long stdId,String chainCode) throws SystemException, NoSuchChainStandardsException
    {
        return chainStandardsPersistence.findByChainCode(stdId,chainCode, "Y");
    }
    public ChainStandards getChainStandardsByChainCodeAll(long stdId,String chainCode) throws SystemException, NoSuchChainStandardsException
    {
        return chainStandardsPersistence.findByChainCodeAll(stdId, chainCode);
    }
    public List<ChainStandards> getChainStandardsByStdIdAll(long stdId) throws SystemException
    {
        return chainStandardsPersistence.findByStdIdAll(stdId);
    }
    public ChainStandards deleteChainStandards(ChainStandards chainStd) throws SystemException
    {
        if(Validator.isNotNull(chainStd))
        {
            /* Delete External Chain Link */
            List<ExternalLinkStandards> extLinkStds = ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsByStandardId(chainStd.getStdId());
            for(ExternalLinkStandards extLinkStd : extLinkStds )
            {
               List<ChainExternalLinkStandards> chainExtStds =   ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsByLinkId(extLinkStd.getExtLinkId());
                for(ChainExternalLinkStandards chainExtStd : chainExtStds )
                {
                    if(chainStd.getChainCode().equals(chainExtStd.getChainCode()))
                    {
                        ChainExternalLinkStandardsLocalServiceUtil.deleteChainExternalLinkStandards(chainExtStd);
                    }
                }
            }
            
            /* Delete Attachment Chain */
            List<AttachmentsStandards> attachemntStandards = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByStandardId(chainStd.getStdId());
            for(AttachmentsStandards attachemntStandard : attachemntStandards )
            {
               List<ChainAttachmentsStandards> chainAttachmentStds =   ChainAttachmentsStandardsLocalServiceUtil.getChainAttachmentsStandardsByAttachmentId(attachemntStandard.getAttachmentId());
                for(ChainAttachmentsStandards chainAttachmentStd : chainAttachmentStds )
                {
                    if(chainStd.getChainCode().equals(chainAttachmentStd.getChainCode()))
                    {
                        ChainAttachmentsStandardsLocalServiceUtil.deleteChainAttachmentsStandards(chainAttachmentStd);
                    }
                }
            }
            
            /* Delete Image Chain */
            List<StandardsImages> stdsImages = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(chainStd.getStdId());
            for(StandardsImages stdsImage : stdsImages )
            {
                List<StandardsChainImages> stdChainImages = StandardsChainImagesLocalServiceUtil.getChainImagesByStdImageId(stdsImage.getStdImageId());
                for(StandardsChainImages stdChainImage : stdChainImages)
                {
                    if(chainStd.getChainCode().equals(stdChainImage.getChainCode()))
                    {
                        StandardsChainImagesLocalServiceUtil.deleteStandardsChainImages(stdChainImage);
                    }
                }
                
            }
            //chainStandardsPersistence.remove(chainStd);
            chainStd.setIsActive("N");
            chainStandardsPersistence.update(chainStd);
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public List<Long> getStandardsByChain(String chainCode) throws SystemException
    {
    	List<Long> arlStandardIds = new ArrayList<Long>();
    	List<ChainStandards> arlStandards = new ArrayList<ChainStandards>();
    	ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(ChainStandards.class, portletClassLoader);
    	Criterion stdCriterion = RestrictionsFactoryUtil.eq("chainCode", chainCode);	
    	dynamicQuery.add(stdCriterion);
        arlStandards = ChainStandardsLocalServiceUtil.dynamicQuery(dynamicQuery);
    	
        for(ChainStandards chainStds : arlStandards)
        {
        	arlStandardIds.add(chainStds.getStdId());
        }
    	return arlStandardIds;
    }
}