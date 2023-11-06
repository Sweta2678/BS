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
 * This class is a wrapper for {@link HistManualChain}.
 * </p>
 *
 * @author Mummanedi
 * @see HistManualChain
 * @generated
 */
public class HistManualChainWrapper implements HistManualChain,
	ModelWrapper<HistManualChain> {
	public HistManualChainWrapper(HistManualChain histManualChain) {
		_histManualChain = histManualChain;
	}

	@Override
	public Class<?> getModelClass() {
		return HistManualChain.class;
	}

	@Override
	public String getModelClassName() {
		return HistManualChain.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chainCode", getChainCode());
		attributes.put("histManualId", getHistManualId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		Long histManualId = (Long)attributes.get("histManualId");

		if (histManualId != null) {
			setHistManualId(histManualId);
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
	* Returns the primary key of this hist manual chain.
	*
	* @return the primary key of this hist manual chain
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.HistManualChainPK getPrimaryKey() {
		return _histManualChain.getPrimaryKey();
	}

	/**
	* Sets the primary key of this hist manual chain.
	*
	* @param primaryKey the primary key of this hist manual chain
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.HistManualChainPK primaryKey) {
		_histManualChain.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the chain code of this hist manual chain.
	*
	* @return the chain code of this hist manual chain
	*/
	@Override
	public java.lang.String getChainCode() {
		return _histManualChain.getChainCode();
	}

	/**
	* Sets the chain code of this hist manual chain.
	*
	* @param chainCode the chain code of this hist manual chain
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_histManualChain.setChainCode(chainCode);
	}

	/**
	* Returns the hist manual ID of this hist manual chain.
	*
	* @return the hist manual ID of this hist manual chain
	*/
	@Override
	public long getHistManualId() {
		return _histManualChain.getHistManualId();
	}

	/**
	* Sets the hist manual ID of this hist manual chain.
	*
	* @param histManualId the hist manual ID of this hist manual chain
	*/
	@Override
	public void setHistManualId(long histManualId) {
		_histManualChain.setHistManualId(histManualId);
	}

	/**
	* Returns the creator ID of this hist manual chain.
	*
	* @return the creator ID of this hist manual chain
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _histManualChain.getCreatorId();
	}

	/**
	* Sets the creator ID of this hist manual chain.
	*
	* @param creatorId the creator ID of this hist manual chain
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_histManualChain.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this hist manual chain.
	*
	* @return the created date of this hist manual chain
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _histManualChain.getCreatedDate();
	}

	/**
	* Sets the created date of this hist manual chain.
	*
	* @param createdDate the created date of this hist manual chain
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_histManualChain.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this hist manual chain.
	*
	* @return the updated by of this hist manual chain
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _histManualChain.getUpdatedBy();
	}

	/**
	* Sets the updated by of this hist manual chain.
	*
	* @param updatedBy the updated by of this hist manual chain
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_histManualChain.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this hist manual chain.
	*
	* @return the updated date of this hist manual chain
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _histManualChain.getUpdatedDate();
	}

	/**
	* Sets the updated date of this hist manual chain.
	*
	* @param updatedDate the updated date of this hist manual chain
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_histManualChain.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _histManualChain.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_histManualChain.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _histManualChain.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_histManualChain.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _histManualChain.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _histManualChain.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_histManualChain.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _histManualChain.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_histManualChain.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_histManualChain.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_histManualChain.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HistManualChainWrapper((HistManualChain)_histManualChain.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.HistManualChain histManualChain) {
		return _histManualChain.compareTo(histManualChain);
	}

	@Override
	public int hashCode() {
		return _histManualChain.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.HistManualChain> toCacheModel() {
		return _histManualChain.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.HistManualChain toEscapedModel() {
		return new HistManualChainWrapper(_histManualChain.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.HistManualChain toUnescapedModel() {
		return new HistManualChainWrapper(_histManualChain.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _histManualChain.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _histManualChain.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_histManualChain.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HistManualChainWrapper)) {
			return false;
		}

		HistManualChainWrapper histManualChainWrapper = (HistManualChainWrapper)obj;

		if (Validator.equals(_histManualChain,
					histManualChainWrapper._histManualChain)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public HistManualChain getWrappedHistManualChain() {
		return _histManualChain;
	}

	@Override
	public HistManualChain getWrappedModel() {
		return _histManualChain;
	}

	@Override
	public void resetOriginalValues() {
		_histManualChain.resetOriginalValues();
	}

	private HistManualChain _histManualChain;
}