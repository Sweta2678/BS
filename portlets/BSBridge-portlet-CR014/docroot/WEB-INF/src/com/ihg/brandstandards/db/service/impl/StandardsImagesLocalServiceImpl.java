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

import com.ihg.brandstandards.db.NoSuchStandardsImagesException;
import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.service.base.StandardsImagesLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.StandardsImagesFinderUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the standards images local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsImagesLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsImagesLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil
 */
public class StandardsImagesLocalServiceImpl extends StandardsImagesLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil} to access the standards images local service.
     */

    private static final Log LOG = LogFactoryUtil.getLog(StandardsImagesLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            standardsImagesPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<StandardsImages> getStdImages(long imageId) throws SystemException
    {
        List<StandardsImages> arlStandardsImages = new ArrayList();
        try
        {
            /* DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(StandardsImages.class);
             Criterion criterion = RestrictionsFactoryUtil.eq("IMAGE_ID", imageId);
             dynamicQuery.add(criterion);
             arlStandardsImages = StandardsImagesLocalServiceUtil.dynamicQuery(dynamicQuery);*/
            arlStandardsImages = standardsImagesPersistence.findByimageId(imageId);

            //arlStandardsImages = StandardsImagesLocalServiceUtil.dynamicQuery(dynamicQuery);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        return arlStandardsImages;
    }

    public List<String> StandardsImagesCount(long imageId) throws SystemException
    {
        List<String> arlStandardsImages = new ArrayList();
        try
        {
            arlStandardsImages = StandardsImagesFinderUtil.getStandardsImagesCount(imageId);
        }
        catch (Exception e)
        {
            LOG.info(e);
        }
        return arlStandardsImages;
    }

    /**
     * Find Images by Std Id.
     * 
     * @return list of Images.
     */
    public List<StandardsImages> getStandardsImagesByStdId(long stdId) throws SystemException
    {
        return standardsImagesPersistence.findByStdId(stdId);
    }

    /**
     * Find all parent stdImages by StdId
     * 
     * @throws SystemException
     */
    public List<StandardsImages> getParentStdImages(long stdId) throws SystemException
    {
        return standardsImagesPersistence.findByparentsStdId(stdId);
    }

    public List<StandardsImages> getParentStdImagesByLocaleCode(long stdId, String localeCode) throws SystemException
    {
        return standardsImagesPersistence.findByparentsStdIdLocaleCode(stdId, localeCode);
    }

    /**
     * find all images by parentId and stdId
     */
    public List<StandardsImages> getStdImagesByParentImageIdStdId(long parentImageId, long stdId) throws SystemException
    {
        return standardsImagesPersistence.findByParentImageIdStdId(parentImageId, stdId);
    }

    /**
     * Find images of particular stdId, parentImageId and localeCode
     * 
     * @throws SystemException
     */
    public List<StandardsImages> getStdImagesByParentImageIdStdIdLocaleCd(long parentImageId, long stdId, String localeCode)
            throws SystemException
    {
        return standardsImagesPersistence.findByParentImageIdStdIdLocaleCd(parentImageId, stdId, localeCode);
    }

    /**
     * This method deletes images deep down, that is, cascade delete along with children stdImages
     * 
     * @param stdImage
     * @throws SystemException
     * @throws NoSuchStandardsImagesException
     */
    public void deleteStdImagesDeep(long stdImageId) throws SystemException, NoSuchStandardsImagesException
    {
        StandardsImages stdImage = standardsImagesPersistence.findByPrimaryKey(stdImageId);
        if (Validator.isNotNull(stdImage))
        {
            boolean isParent = (stdImage.getStdImageId() == stdImage.getParentImageId());
            if (isParent)
            {
                // Here removeByParentId method from persistence will not work as we need to remove child records first
                List<StandardsImages> children = standardsImagesPersistence.findByParentId(stdImage.getStdImageId());
                if (Validator.isNotNull(children) && children.size() > 0)
                {
                    for (StandardsImages child : children)
                    {
                        // check if its not parent itself
                        if (child.getStdImageId() != child.getParentImageId())
                        {
                            standardsImagesPersistence.remove(child.getStdImageId());
                        }
                    }
                }
            }
            standardsImagesPersistence.remove(stdImage.getStdImageId());
        }
    }

    /**
     * 
     * @param imageId
     * @param stdId
     * @param localeCd
     * @return
     * @throws SystemException
     */
    public List<StandardsImages> getStandardsImagesByImageIdStdIdLocaleCd(long imageId, long stdId, String localeCd)
            throws SystemException
    {
        return standardsImagesPersistence.findByImageIdStdIdLocaleCd(imageId, stdId, localeCd);
    }

    public StandardsImages deleteStandardsImages(long stdImageId) throws SystemException
    {
        StandardsImages img = null;
        List<StandardsChainImages> stdChainImages = standardsChainImagesPersistence.findBystdImageId(stdImageId);
        for (StandardsChainImages stdChainImage : stdChainImages)
        {
            standardsChainImagesPersistence.remove(stdChainImage);
        }
        try
        {
            standardsImagesPersistence.remove(stdImageId);
        }
        catch (NoSuchStandardsImagesException e)
        {
            LOG.error("No StdImage found with pk" + stdImageId);
        }
        return img;
    }
    
    /**
     * Get Standards Images translation by passing  stdId, regionId and locales.
     * 
     * @param stdId
     * @param regionId
     * @param locales
     * @return
     */
    public List<StandardsImages> getStandardImagesByStdIdAndRgnIdAndLocale(long stdId, String regionId, List<String> locales)
    {
    	return standardsImagesFinder.getStandardImagesByStdIdAndRgnIdAndLocale(stdId, regionId, locales);
    }
}