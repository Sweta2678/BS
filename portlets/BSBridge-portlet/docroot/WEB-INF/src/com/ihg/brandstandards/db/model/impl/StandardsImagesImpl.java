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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.Image;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The model implementation for the StandardsImages service. Represents a row in the &quot;STD_IMAGE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.StandardsImages} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class StandardsImagesImpl extends StandardsImagesBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a standards images model instance should use the {@link StandardsImages} interface instead.
	 */
    private static final Log LOG = LogFactoryUtil.getLog(StandardsImagesImpl.class);
    private Image image;
    private boolean isTranslationExist;

    /**
     * Constructor.
     */
    public StandardsImagesImpl()
    {
    }

    /**
     * Getter for Image.
     * 
     * @return the Image
     */
    public Image getImage()
    {
        return image;
    }

    /**
     * Setter for Image.
     * 
     * @param image the Image to set
     */
    public void setImage(Image image)
    {
        this.image = image;
    }

    public Image getDBImage()
    {
        if (image != null)
        {
            return image;
        }
        else
        {
            long imageId = getImageId();
            Image dbImage = null;
            try
            {
                dbImage = ImageLocalServiceUtil.getImage(imageId);
            }
            catch (PortalException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            catch (SystemException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            setImage(dbImage);
            return dbImage;
        }
    }

    /**
     * @return the isTranslationExist
     */
    public boolean getIsTranslationExist()
    {
        return isTranslationExist;
    }

    /**
     * @param isTranslationExist the isTranslationExist to set
     */
    public void setIsTranslationExist(boolean isTranslationExist)
    {
        this.isTranslationExist = isTranslationExist;
    }
}