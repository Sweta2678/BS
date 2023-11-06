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

import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.model.Image;
import com.ihg.brandstandards.db.model.impl.ImageImpl;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.ImageLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.ImageLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
/**
 * The implementation of the image local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.ImageLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.ImageLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.ImageLocalServiceUtil
 */
public class ImageLocalServiceImpl extends ImageLocalServiceBaseImpl
{
    private static final Log LOG = LogFactoryUtil.getLog(ImageLocalServiceImpl.class);
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.ImageLocalServiceUtil} to access the image local service.
     */

    public Image addImage(DLFileEntry dlFileEntry, long userId) throws SystemException
    {
        LOG.debug("Inside imagelocalserviceimpl");
        Image image = null;
        String dimension = "";
        try
        {
            image = new ImageImpl();
            image.setImageId(dlFileEntry.getFileEntryId());
            image.setImageUuId(dlFileEntry.getUuid());
            image.setImageTitle(dlFileEntry.getTitle());
            image.setImageDesc(dlFileEntry.getDescription());
            image.setImageDimension(dimension);
            image.setImageSize(String.valueOf(dlFileEntry.getSize()));
            image.setImageType(dlFileEntry.getExtension());
            image.setSmallImageId(String.valueOf(dlFileEntry.getSmallImageId()));
            image.setCreatorId(String.valueOf(userId));
            image.setCreatedDate(new Date());
            image.setUpdatedBy(String.valueOf(userId));
            image.setUpdatedDate(new Date());

            ImageLocalServiceUtil.addImage(image);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return image;
    }

    public Image updateImage(DLFileEntry dlFileEntry, long userId, long imageId) throws SystemException
    {
        Image image = null;
        String dimension = "";
        try
        {
            image = new ImageImpl();
            image.setImageId(dlFileEntry.getFileEntryId());
            image.setImageUuId(dlFileEntry.getUuid());
            image.setImageTitle(dlFileEntry.getTitle());
            image.setImageDesc(dlFileEntry.getDescription());
            image.setImageDimension(dimension);
            image.setImageSize(String.valueOf(dlFileEntry.getSize()));
            image.setImageType(dlFileEntry.getExtension());
            image.setSmallImageId(String.valueOf(dlFileEntry.getSmallImageId()));
            image.setCreatorId(String.valueOf(userId));
            image.setCreatedDate(new Date());
            image.setUpdatedBy(String.valueOf(userId));
            image.setUpdatedDate(new Date());

            ImageLocalServiceUtil.updateImage(image);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return image;
    }
    
    /**
     * Get Images by specified list of Image Id.
     * 
     * @param imgId list of Image Id
     * @return list of Images
     */
    @SuppressWarnings("unchecked")
    public List<Image> getImages(List<Object> imgId)
    {
        List<Image> images;
        try
        {
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Image.class, portletClassLoader);
            Criterion criterion = RestrictionsFactoryUtil.in("imageId", imgId);
            dynamicQuery.add(criterion);
            images = ImageLocalServiceUtil.dynamicQuery(dynamicQuery);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            images = null;
        }
        return images;
    }

    public List<Image> findImageByDescAndTitle(String imageDesc, String imageTitle) throws SystemException
    {
        List<Image> images = null;
        /*try {
            images= ImageFinderUtil.findByimageDescAndTitle("%" + imageDesc + "%", "%" + imageTitle + "%");
        }
        catch (Exception e) {
            LOG.info(e);
        }*/
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Image.class, portletClassLoader);
        Criterion titleCriterion = RestrictionsFactoryUtil.ilike("imageTitle", "%" + imageTitle + "%");
        Criterion descCriterion = RestrictionsFactoryUtil.ilike("imageDesc", "%" + imageDesc + "%");
        Criterion orCondition = RestrictionsFactoryUtil.or(titleCriterion, descCriterion);
        dynamicQuery.add(orCondition);
        LOG.debug(" Query is " + dynamicQuery.toString());
        images = ImageLocalServiceUtil.dynamicQuery(dynamicQuery);

        return images;
    }
    
    public void clearCache()
    {
        try
        {
            imagePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
}