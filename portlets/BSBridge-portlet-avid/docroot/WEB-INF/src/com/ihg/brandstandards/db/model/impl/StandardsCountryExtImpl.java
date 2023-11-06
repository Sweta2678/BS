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

/**
 * The model implementation for the StandardsCountryExt service. Represents a row in the &quot;BRNDSTND_CTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.model.StandardsCountryExt} interface.
 * </p>
 *
 * @author Mummanedi
 */
public class StandardsCountryExtImpl extends StandardsCountryExtBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a standards country ext model instance should use the {@link StandardsCountryExt} interface instead.
	 */
	public StandardsCountryExtImpl() {
	}

	private String regionCode;
	private long regionId;
	private String subRegionCode;
	
	public String getRegionCode()
	{
		return regionCode;
	}

	
	public void setRegionCode(String regionCode)
	{
		this.regionCode = regionCode;
	}

	
	public long getRegionId()
	{
		return regionId;
	}

	
	public void setRegionId(long regionId)
	{
		this.regionId = regionId;
	}


	
	public String getSubRegionCode()
	{
		return subRegionCode;
	}


	
	public void setSubRegionCode(String subRegionCode)
	{
		this.subRegionCode = subRegionCode;
	}

	
}