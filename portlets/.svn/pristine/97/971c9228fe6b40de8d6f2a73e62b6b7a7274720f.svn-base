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

import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.util.StringPool;

/**
 * The model implementation for the ExternalLinkStandards service. Represents a row in the &quot;STD_EXTL_LINK&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.ExternalLinkStandards} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class ExternalLinkStandardsImpl extends ExternalLinkStandardsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a external link standards model instance should use the {@link ExternalLinkStandards} interface instead.
	 */
	public ExternalLinkStandardsImpl() {
	}
    
    public String getRealUrl()
    {
        if (getUrl().equals(BSCommonConstants.NOT_APPLICABLE))
        {
            return StringPool.BLANK;
        }
        else
        {
            return getUrl();
        }
    }
    
    
    
    public String getRealTitle()
    {
        if (getTitle().equals(BSCommonConstants.NOT_APPLICABLE))
        {
            return StringPool.BLANK;
        }
        else
        {
            return getTitle();
        }
    }
    
    private boolean isLinkTranslationExist;

    /**
     * @return the isLinkTranslationExist
     */
    public boolean isLinkTranslationExist()
    {
        return isLinkTranslationExist;
    }

    /**
     * @param isLinkTranslationExist the isLinkTranslationExist to set
     */
    public void setLinkTranslationExist(boolean isLinkTranslationExist)
    {
        this.isLinkTranslationExist = isLinkTranslationExist;
    }
}