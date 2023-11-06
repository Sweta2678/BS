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

import com.ihg.brandstandards.db.model.StandardsHistoricalManual;

/**
 * The model implementation for the StandardsHistoricalManual service. Represents a row in the &quot;STD_MNL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.StandardsHistoricalManual} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class StandardsHistoricalManualImpl
	extends StandardsHistoricalManualBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a standards historical manual model instance should use the {@link StandardsHistoricalManual} interface instead.
	 */
    private String chain;
    private String region;
    private String histManualType;
    private String histManualTitle;

    public StandardsHistoricalManualImpl()
    {
    }

    public String getChain()
    {
        return chain;
    }

    public void setChain(String chain)
    {
        this.chain = chain;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public String getHistManualType()
    {
        return histManualType;
    }

    public void setHistManualType(String histManualType)
    {
        this.histManualType = histManualType;
    }

    public String getHistManualTitle()
    {
        return histManualTitle;
    }

    public void setHistManualTitle(String histManualTitle)
    {
        this.histManualTitle = histManualTitle;
    }
}