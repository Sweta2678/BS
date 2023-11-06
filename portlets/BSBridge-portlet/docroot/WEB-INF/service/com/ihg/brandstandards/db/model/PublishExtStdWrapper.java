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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PublishExtStd}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishExtStd
 * @generated
 */
public class PublishExtStdWrapper implements PublishExtStd,
	ModelWrapper<PublishExtStd> {
	public PublishExtStdWrapper(PublishExtStd publishExtStd) {
		_publishExtStd = publishExtStd;
	}

	@Override
	public Class<?> getModelClass() {
		return PublishExtStd.class;
	}

	@Override
	public String getModelClassName() {
		return PublishExtStd.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("compDate", getCompDate());
		attributes.put("stdId", getStdId());
		attributes.put("parentId", getParentId());
		attributes.put("title", getTitle());
		attributes.put("expiredIds", getExpiredIds());
		attributes.put("regionCode", getRegionCode());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("framework", getFramework());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Date compDate = (Date)attributes.get("compDate");

		if (compDate != null) {
			setCompDate(compDate);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String expiredIds = (String)attributes.get("expiredIds");

		if (expiredIds != null) {
			setExpiredIds(expiredIds);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}
	}

	/**
	* Returns the primary key of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the primary key of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public long getPrimaryKey() {
		return _publishExtStd.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param primaryKey the primary key of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publishExtStd.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the comp date of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the comp date of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public java.util.Date getCompDate() {
		return _publishExtStd.getCompDate();
	}

	/**
	* Sets the comp date of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param compDate the comp date of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setCompDate(java.util.Date compDate) {
		_publishExtStd.setCompDate(compDate);
	}

	/**
	* Returns the std ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the std ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public long getStdId() {
		return _publishExtStd.getStdId();
	}

	/**
	* Sets the std ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param stdId the std ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setStdId(long stdId) {
		_publishExtStd.setStdId(stdId);
	}

	/**
	* Returns the parent ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the parent ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public long getParentId() {
		return _publishExtStd.getParentId();
	}

	/**
	* Sets the parent ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param parentId the parent ID of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setParentId(long parentId) {
		_publishExtStd.setParentId(parentId);
	}

	/**
	* Returns the title of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the title of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public java.lang.String getTitle() {
		return _publishExtStd.getTitle();
	}

	/**
	* Sets the title of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param title the title of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_publishExtStd.setTitle(title);
	}

	/**
	* Returns the expired IDs of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the expired IDs of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public java.lang.String getExpiredIds() {
		return _publishExtStd.getExpiredIds();
	}

	/**
	* Sets the expired IDs of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param expiredIds the expired IDs of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setExpiredIds(java.lang.String expiredIds) {
		_publishExtStd.setExpiredIds(expiredIds);
	}

	/**
	* Returns the region code of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the region code of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _publishExtStd.getRegionCode();
	}

	/**
	* Sets the region code of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param regionCode the region code of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_publishExtStd.setRegionCode(regionCode);
	}

	/**
	* Returns the is global of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the is global of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public java.lang.String getIsGlobal() {
		return _publishExtStd.getIsGlobal();
	}

	/**
	* Sets the is global of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param isGlobal the is global of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setIsGlobal(java.lang.String isGlobal) {
		_publishExtStd.setIsGlobal(isGlobal);
	}

	/**
	* Returns the framework of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @return the framework of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public java.lang.String getFramework() {
		return _publishExtStd.getFramework();
	}

	/**
	* Sets the framework of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables..
	*
	* @param framework the framework of this Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables.
	*/
	@Override
	public void setFramework(java.lang.String framework) {
		_publishExtStd.setFramework(framework);
	}

	@Override
	public boolean isNew() {
		return _publishExtStd.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publishExtStd.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publishExtStd.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publishExtStd.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publishExtStd.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publishExtStd.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publishExtStd.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publishExtStd.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publishExtStd.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publishExtStd.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publishExtStd.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublishExtStdWrapper((PublishExtStd)_publishExtStd.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.PublishExtStd publishExtStd) {
		return _publishExtStd.compareTo(publishExtStd);
	}

	@Override
	public int hashCode() {
		return _publishExtStd.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.PublishExtStd> toCacheModel() {
		return _publishExtStd.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd toEscapedModel() {
		return new PublishExtStdWrapper(_publishExtStd.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishExtStd toUnescapedModel() {
		return new PublishExtStdWrapper(_publishExtStd.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publishExtStd.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publishExtStd.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishExtStd.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishExtStdWrapper)) {
			return false;
		}

		PublishExtStdWrapper publishExtStdWrapper = (PublishExtStdWrapper)obj;

		if (Validator.equals(_publishExtStd, publishExtStdWrapper._publishExtStd)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PublishExtStd getWrappedPublishExtStd() {
		return _publishExtStd;
	}

	@Override
	public PublishExtStd getWrappedModel() {
		return _publishExtStd;
	}

	@Override
	public void resetOriginalValues() {
		_publishExtStd.resetOriginalValues();
	}

	private PublishExtStd _publishExtStd;
}