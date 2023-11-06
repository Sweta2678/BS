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

import com.ihg.brandstandards.db.model.BusImpactAssmt;

/**
 * The model implementation for the BusImpactAssmt service. Represents a row in the &quot;BUS_IMPACT_ASSMT_MNL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.BusImpactAssmt} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class BusImpactAssmtImpl extends BusImpactAssmtBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a bus impact assmt model instance should use the {@link BusImpactAssmt} interface instead.
	 */
	public BusImpactAssmtImpl() {
	}
    
    String chainName;

    public String getChainName()
    {
        return chainName;
    }

    public void setChainName(String chainName)
    {
        this.chainName = chainName;
    }
}