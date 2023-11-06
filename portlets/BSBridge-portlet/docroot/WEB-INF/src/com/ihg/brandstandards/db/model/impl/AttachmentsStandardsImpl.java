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

import com.ihg.brandstandards.db.model.AttachmentsStandards;

/**
 * The model implementation for the AttachmentsStandards service. Represents a row in the &quot;STD_ATTACHMENT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.AttachmentsStandards} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class AttachmentsStandardsImpl extends AttachmentsStandardsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a attachments standards model instance should use the {@link AttachmentsStandards} interface instead.
	 */
     
	public AttachmentsStandardsImpl() {
	}
	
	private boolean isTranslationExist;
	   
    /**
     * @return the isTranslationExist
     */
    public boolean isTranslationExist()
    {
        return isTranslationExist;
    }

    /**
     * @param isTranslationExist the isTranslationExist to set
     */
    public void setTranslationExist(boolean isTranslationExist)
    {
        this.isTranslationExist = isTranslationExist;
    }
}