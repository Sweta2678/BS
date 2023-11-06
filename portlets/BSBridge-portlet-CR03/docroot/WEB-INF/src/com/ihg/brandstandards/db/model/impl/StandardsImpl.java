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

import com.ihg.brandstandards.db.model.Standards;

/**
 * The model implementation for the Standards service. Represents a row in the &quot;STD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.Standards} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class StandardsImpl extends StandardsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a standards model instance should use the {@link Standards} interface instead.
	 */
    public StandardsImpl() {
    }
    
    private boolean isTextTransExist;
    private boolean isContextTransExist;
    /**
     * @return the isTextTransExist
     */
    public boolean isTextTransExist()
    {
        return isTextTransExist;
    }
    /**
     * @param isTextTransExist the isTextTransExist to set
     */
    public void setTextTransExist(boolean isTextTransExist)
    {
        this.isTextTransExist = isTextTransExist;
    }
    /**
     * @return the isContextTransExist
     */
    public boolean isContextTransExist()
    {
        return isContextTransExist;
    }
    /**
     * @param isContextTransExist the isContextTransExist to set
     */
    public void setContextTransExist(boolean isContextTransExist)
    {
        this.isContextTransExist = isContextTransExist;
    }
}