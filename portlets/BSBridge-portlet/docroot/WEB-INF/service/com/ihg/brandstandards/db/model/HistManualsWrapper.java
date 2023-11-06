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
 * This class is a wrapper for {@link HistManuals}.
 * </p>
 *
 * @author Mummanedi
 * @see HistManuals
 * @generated
 */
public class HistManualsWrapper implements HistManuals,
	ModelWrapper<HistManuals> {
	public HistManualsWrapper(HistManuals histManuals) {
		_histManuals = histManuals;
	}

	@Override
	public Class<?> getModelClass() {
		return HistManuals.class;
	}

	@Override
	public String getModelClassName() {
		return HistManuals.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("histManualId", getHistManualId());
		attributes.put("title", getTitle());
		attributes.put("type", getType());
		attributes.put("pubDate", getPubDate());
		attributes.put("status", getStatus());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long histManualId = (Long)attributes.get("histManualId");

		if (histManualId != null) {
			setHistManualId(histManualId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Date pubDate = (Date)attributes.get("pubDate");

		if (pubDate != null) {
			setPubDate(pubDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String creatorId = (String)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}
	}

	/**
	* Returns the primary key of this hist manuals.
	*
	* @return the primary key of this hist manuals
	*/
	@Override
	public long getPrimaryKey() {
		return _histManuals.getPrimaryKey();
	}

	/**
	* Sets the primary key of this hist manuals.
	*
	* @param primaryKey the primary key of this hist manuals
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_histManuals.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the hist manual ID of this hist manuals.
	*
	* @return the hist manual ID of this hist manuals
	*/
	@Override
	public long getHistManualId() {
		return _histManuals.getHistManualId();
	}

	/**
	* Sets the hist manual ID of this hist manuals.
	*
	* @param histManualId the hist manual ID of this hist manuals
	*/
	@Override
	public void setHistManualId(long histManualId) {
		_histManuals.setHistManualId(histManualId);
	}

	/**
	* Returns the title of this hist manuals.
	*
	* @return the title of this hist manuals
	*/
	@Override
	public java.lang.String getTitle() {
		return _histManuals.getTitle();
	}

	/**
	* Sets the title of this hist manuals.
	*
	* @param title the title of this hist manuals
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_histManuals.setTitle(title);
	}

	/**
	* Returns the type of this hist manuals.
	*
	* @return the type of this hist manuals
	*/
	@Override
	public java.lang.String getType() {
		return _histManuals.getType();
	}

	/**
	* Sets the type of this hist manuals.
	*
	* @param type the type of this hist manuals
	*/
	@Override
	public void setType(java.lang.String type) {
		_histManuals.setType(type);
	}

	/**
	* Returns the pub date of this hist manuals.
	*
	* @return the pub date of this hist manuals
	*/
	@Override
	public java.util.Date getPubDate() {
		return _histManuals.getPubDate();
	}

	/**
	* Sets the pub date of this hist manuals.
	*
	* @param pubDate the pub date of this hist manuals
	*/
	@Override
	public void setPubDate(java.util.Date pubDate) {
		_histManuals.setPubDate(pubDate);
	}

	/**
	* Returns the status of this hist manuals.
	*
	* @return the status of this hist manuals
	*/
	@Override
	public java.lang.String getStatus() {
		return _histManuals.getStatus();
	}

	/**
	* Sets the status of this hist manuals.
	*
	* @param status the status of this hist manuals
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_histManuals.setStatus(status);
	}

	/**
	* Returns the creator ID of this hist manuals.
	*
	* @return the creator ID of this hist manuals
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _histManuals.getCreatorId();
	}

	/**
	* Sets the creator ID of this hist manuals.
	*
	* @param creatorId the creator ID of this hist manuals
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_histManuals.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this hist manuals.
	*
	* @return the created date of this hist manuals
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _histManuals.getCreatedDate();
	}

	/**
	* Sets the created date of this hist manuals.
	*
	* @param createdDate the created date of this hist manuals
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_histManuals.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this hist manuals.
	*
	* @return the updated by of this hist manuals
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _histManuals.getUpdatedBy();
	}

	/**
	* Sets the updated by of this hist manuals.
	*
	* @param updatedBy the updated by of this hist manuals
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_histManuals.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this hist manuals.
	*
	* @return the updated date of this hist manuals
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _histManuals.getUpdatedDate();
	}

	/**
	* Sets the updated date of this hist manuals.
	*
	* @param updatedDate the updated date of this hist manuals
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_histManuals.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _histManuals.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_histManuals.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _histManuals.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_histManuals.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _histManuals.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _histManuals.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_histManuals.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _histManuals.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_histManuals.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_histManuals.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_histManuals.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HistManualsWrapper((HistManuals)_histManuals.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.HistManuals histManuals) {
		return _histManuals.compareTo(histManuals);
	}

	@Override
	public int hashCode() {
		return _histManuals.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.HistManuals> toCacheModel() {
		return _histManuals.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.HistManuals toEscapedModel() {
		return new HistManualsWrapper(_histManuals.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.HistManuals toUnescapedModel() {
		return new HistManualsWrapper(_histManuals.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _histManuals.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _histManuals.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_histManuals.persist();
	}

	@Override
	public java.lang.String getChain() {
		return _histManuals.getChain();
	}

	@Override
	public void setChain(java.lang.String chain) {
		_histManuals.setChain(chain);
	}

	@Override
	public java.lang.String getRegion() {
		return _histManuals.getRegion();
	}

	@Override
	public void setRegion(java.lang.String region) {
		_histManuals.setRegion(region);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistManualsWrapper)) {
			return false;
		}

		HistManualsWrapper histManualsWrapper = (HistManualsWrapper)obj;

		if (Validator.equals(_histManuals, histManualsWrapper._histManuals)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HistManuals getWrappedHistManuals() {
		return _histManuals;
	}

	@Override
	public HistManuals getWrappedModel() {
		return _histManuals;
	}

	@Override
	public void resetOriginalValues() {
		_histManuals.resetOriginalValues();
	}

	private HistManuals _histManuals;
}