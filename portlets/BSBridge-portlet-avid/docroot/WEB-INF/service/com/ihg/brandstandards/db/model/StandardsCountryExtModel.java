/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.brandstandards.db.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the StandardsCountryExt service. Represents a row in the &quot;BRNDSTND_CTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.StandardsCountryExtImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryExt
 * @see com.ihg.brandstandards.db.model.impl.StandardsCountryExtImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsCountryExtModelImpl
 * @generated
 */
public interface StandardsCountryExtModel extends BaseModel<StandardsCountryExt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a standards country ext model instance should use the {@link StandardsCountryExt} interface instead.
	 */

	/**
	 * Returns the primary key of this standards country ext.
	 *
	 * @return the primary key of this standards country ext
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this standards country ext.
	 *
	 * @param primaryKey the primary key of this standards country ext
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the row num of this standards country ext.
	 *
	 * @return the row num of this standards country ext
	 */
	public long getRowNum();

	/**
	 * Sets the row num of this standards country ext.
	 *
	 * @param rowNum the row num of this standards country ext
	 */
	public void setRowNum(long rowNum);

	/**
	 * Returns the country code of this standards country ext.
	 *
	 * @return the country code of this standards country ext
	 */
	@AutoEscape
	public String getCountryCode();

	/**
	 * Sets the country code of this standards country ext.
	 *
	 * @param countryCode the country code of this standards country ext
	 */
	public void setCountryCode(String countryCode);

	/**
	 * Returns the flag of this standards country ext.
	 *
	 * @return the flag of this standards country ext
	 */
	@AutoEscape
	public String getFlag();

	/**
	 * Sets the flag of this standards country ext.
	 *
	 * @param flag the flag of this standards country ext
	 */
	public void setFlag(String flag);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(StandardsCountryExt standardsCountryExt);

	@Override
	public int hashCode();

	@Override
	public CacheModel<StandardsCountryExt> toCacheModel();

	@Override
	public StandardsCountryExt toEscapedModel();

	@Override
	public StandardsCountryExt toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}