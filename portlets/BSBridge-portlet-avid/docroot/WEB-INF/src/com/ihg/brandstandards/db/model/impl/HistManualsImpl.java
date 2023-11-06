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

import com.ihg.brandstandards.db.model.HistManuals;

/**
 * The model implementation for the HistManuals service. Represents a row in the &quot;HIST_MNL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.HistManuals} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class HistManualsImpl extends HistManualsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a hist manuals model instance should use the {@link HistManuals} interface instead.
	 */

    private String chain;
    private String region;
    
    public HistManualsImpl() {
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
}