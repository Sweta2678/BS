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
 * This class is a wrapper for {@link ChainExternalLinkStandards}.
 * </p>
 *
 * @author Mummanedi
 * @see ChainExternalLinkStandards
 * @generated
 */
public class ChainExternalLinkStandardsWrapper
	implements ChainExternalLinkStandards,
		ModelWrapper<ChainExternalLinkStandards> {
	public ChainExternalLinkStandardsWrapper(
		ChainExternalLinkStandards chainExternalLinkStandards) {
		_chainExternalLinkStandards = chainExternalLinkStandards;
	}

	@Override
	public Class<?> getModelClass() {
		return ChainExternalLinkStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ChainExternalLinkStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("extLinkId", getExtLinkId());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long extLinkId = (Long)attributes.get("extLinkId");

		if (extLinkId != null) {
			setExtLinkId(extLinkId);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
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
	* Returns the primary key of this chain external link standards.
	*
	* @return the primary key of this chain external link standards
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK getPrimaryKey() {
		return _chainExternalLinkStandards.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chain external link standards.
	*
	* @param primaryKey the primary key of this chain external link standards
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK primaryKey) {
		_chainExternalLinkStandards.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ext link ID of this chain external link standards.
	*
	* @return the ext link ID of this chain external link standards
	*/
	@Override
	public long getExtLinkId() {
		return _chainExternalLinkStandards.getExtLinkId();
	}

	/**
	* Sets the ext link ID of this chain external link standards.
	*
	* @param extLinkId the ext link ID of this chain external link standards
	*/
	@Override
	public void setExtLinkId(long extLinkId) {
		_chainExternalLinkStandards.setExtLinkId(extLinkId);
	}

	/**
	* Returns the chain code of this chain external link standards.
	*
	* @return the chain code of this chain external link standards
	*/
	@Override
	public java.lang.String getChainCode() {
		return _chainExternalLinkStandards.getChainCode();
	}

	/**
	* Sets the chain code of this chain external link standards.
	*
	* @param chainCode the chain code of this chain external link standards
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_chainExternalLinkStandards.setChainCode(chainCode);
	}

	/**
	* Returns the creator ID of this chain external link standards.
	*
	* @return the creator ID of this chain external link standards
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _chainExternalLinkStandards.getCreatorId();
	}

	/**
	* Sets the creator ID of this chain external link standards.
	*
	* @param creatorId the creator ID of this chain external link standards
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_chainExternalLinkStandards.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this chain external link standards.
	*
	* @return the created date of this chain external link standards
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _chainExternalLinkStandards.getCreatedDate();
	}

	/**
	* Sets the created date of this chain external link standards.
	*
	* @param createdDate the created date of this chain external link standards
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_chainExternalLinkStandards.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this chain external link standards.
	*
	* @return the updated by of this chain external link standards
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _chainExternalLinkStandards.getUpdatedBy();
	}

	/**
	* Sets the updated by of this chain external link standards.
	*
	* @param updatedBy the updated by of this chain external link standards
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_chainExternalLinkStandards.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this chain external link standards.
	*
	* @return the updated date of this chain external link standards
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _chainExternalLinkStandards.getUpdatedDate();
	}

	/**
	* Sets the updated date of this chain external link standards.
	*
	* @param updatedDate the updated date of this chain external link standards
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_chainExternalLinkStandards.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _chainExternalLinkStandards.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_chainExternalLinkStandards.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _chainExternalLinkStandards.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_chainExternalLinkStandards.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _chainExternalLinkStandards.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _chainExternalLinkStandards.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chainExternalLinkStandards.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chainExternalLinkStandards.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_chainExternalLinkStandards.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_chainExternalLinkStandards.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chainExternalLinkStandards.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChainExternalLinkStandardsWrapper((ChainExternalLinkStandards)_chainExternalLinkStandards.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.ChainExternalLinkStandards chainExternalLinkStandards) {
		return _chainExternalLinkStandards.compareTo(chainExternalLinkStandards);
	}

	@Override
	public int hashCode() {
		return _chainExternalLinkStandards.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.ChainExternalLinkStandards> toCacheModel() {
		return _chainExternalLinkStandards.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards toEscapedModel() {
		return new ChainExternalLinkStandardsWrapper(_chainExternalLinkStandards.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainExternalLinkStandards toUnescapedModel() {
		return new ChainExternalLinkStandardsWrapper(_chainExternalLinkStandards.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chainExternalLinkStandards.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _chainExternalLinkStandards.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chainExternalLinkStandards.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChainExternalLinkStandardsWrapper)) {
			return false;
		}

		ChainExternalLinkStandardsWrapper chainExternalLinkStandardsWrapper = (ChainExternalLinkStandardsWrapper)obj;

		if (Validator.equals(_chainExternalLinkStandards,
					chainExternalLinkStandardsWrapper._chainExternalLinkStandards)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ChainExternalLinkStandards getWrappedChainExternalLinkStandards() {
		return _chainExternalLinkStandards;
	}

	@Override
	public ChainExternalLinkStandards getWrappedModel() {
		return _chainExternalLinkStandards;
	}

	@Override
	public void resetOriginalValues() {
		_chainExternalLinkStandards.resetOriginalValues();
	}

	private ChainExternalLinkStandards _chainExternalLinkStandards;
}