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
 * This class is a wrapper for {@link FlagStandards}.
 * </p>
 *
 * @author Mummanedi
 * @see FlagStandards
 * @generated
 */
public class FlagStandardsWrapper implements FlagStandards,
	ModelWrapper<FlagStandards> {
	public FlagStandardsWrapper(FlagStandards flagStandards) {
		_flagStandards = flagStandards;
	}

	@Override
	public Class<?> getModelClass() {
		return FlagStandards.class;
	}

	@Override
	public String getModelClassName() {
		return FlagStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("flagCatId", getFlagCatId());
		attributes.put("stdId", getStdId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long flagCatId = (Long)attributes.get("flagCatId");

		if (flagCatId != null) {
			setFlagCatId(flagCatId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
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
	* Returns the primary key of this flag standards.
	*
	* @return the primary key of this flag standards
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.FlagStandardsPK getPrimaryKey() {
		return _flagStandards.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flag standards.
	*
	* @param primaryKey the primary key of this flag standards
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagStandardsPK primaryKey) {
		_flagStandards.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the flag cat ID of this flag standards.
	*
	* @return the flag cat ID of this flag standards
	*/
	@Override
	public long getFlagCatId() {
		return _flagStandards.getFlagCatId();
	}

	/**
	* Sets the flag cat ID of this flag standards.
	*
	* @param flagCatId the flag cat ID of this flag standards
	*/
	@Override
	public void setFlagCatId(long flagCatId) {
		_flagStandards.setFlagCatId(flagCatId);
	}

	/**
	* Returns the std ID of this flag standards.
	*
	* @return the std ID of this flag standards
	*/
	@Override
	public long getStdId() {
		return _flagStandards.getStdId();
	}

	/**
	* Sets the std ID of this flag standards.
	*
	* @param stdId the std ID of this flag standards
	*/
	@Override
	public void setStdId(long stdId) {
		_flagStandards.setStdId(stdId);
	}

	/**
	* Returns the creator ID of this flag standards.
	*
	* @return the creator ID of this flag standards
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _flagStandards.getCreatorId();
	}

	/**
	* Sets the creator ID of this flag standards.
	*
	* @param creatorId the creator ID of this flag standards
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_flagStandards.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this flag standards.
	*
	* @return the created date of this flag standards
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _flagStandards.getCreatedDate();
	}

	/**
	* Sets the created date of this flag standards.
	*
	* @param createdDate the created date of this flag standards
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_flagStandards.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this flag standards.
	*
	* @return the updated by of this flag standards
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _flagStandards.getUpdatedBy();
	}

	/**
	* Sets the updated by of this flag standards.
	*
	* @param updatedBy the updated by of this flag standards
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_flagStandards.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this flag standards.
	*
	* @return the updated date of this flag standards
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _flagStandards.getUpdatedDate();
	}

	/**
	* Sets the updated date of this flag standards.
	*
	* @param updatedDate the updated date of this flag standards
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_flagStandards.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _flagStandards.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flagStandards.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flagStandards.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flagStandards.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flagStandards.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flagStandards.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flagStandards.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flagStandards.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flagStandards.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flagStandards.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flagStandards.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlagStandardsWrapper((FlagStandards)_flagStandards.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.FlagStandards flagStandards) {
		return _flagStandards.compareTo(flagStandards);
	}

	@Override
	public int hashCode() {
		return _flagStandards.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.FlagStandards> toCacheModel() {
		return _flagStandards.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.FlagStandards toEscapedModel() {
		return new FlagStandardsWrapper(_flagStandards.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.FlagStandards toUnescapedModel() {
		return new FlagStandardsWrapper(_flagStandards.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flagStandards.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flagStandards.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flagStandards.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlagStandardsWrapper)) {
			return false;
		}

		FlagStandardsWrapper flagStandardsWrapper = (FlagStandardsWrapper)obj;

		if (Validator.equals(_flagStandards, flagStandardsWrapper._flagStandards)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlagStandards getWrappedFlagStandards() {
		return _flagStandards;
	}

	@Override
	public FlagStandards getWrappedModel() {
		return _flagStandards;
	}

	@Override
	public void resetOriginalValues() {
		_flagStandards.resetOriginalValues();
	}

	private FlagStandards _flagStandards;
}