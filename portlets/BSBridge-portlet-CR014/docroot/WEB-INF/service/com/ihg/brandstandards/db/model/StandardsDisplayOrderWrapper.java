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
 * This class is a wrapper for {@link StandardsDisplayOrder}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrder
 * @generated
 */
public class StandardsDisplayOrderWrapper implements StandardsDisplayOrder,
	ModelWrapper<StandardsDisplayOrder> {
	public StandardsDisplayOrderWrapper(
		StandardsDisplayOrder standardsDisplayOrder) {
		_standardsDisplayOrder = standardsDisplayOrder;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsDisplayOrder.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsDisplayOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("regionCode", getRegionCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
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
	* Returns the primary key of this standards display order.
	*
	* @return the primary key of this standards display order
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK getPrimaryKey() {
		return _standardsDisplayOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards display order.
	*
	* @param primaryKey the primary key of this standards display order
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK primaryKey) {
		_standardsDisplayOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this standards display order.
	*
	* @return the std ID of this standards display order
	*/
	@Override
	public long getStdId() {
		return _standardsDisplayOrder.getStdId();
	}

	/**
	* Sets the std ID of this standards display order.
	*
	* @param stdId the std ID of this standards display order
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsDisplayOrder.setStdId(stdId);
	}

	/**
	* Returns the region code of this standards display order.
	*
	* @return the region code of this standards display order
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _standardsDisplayOrder.getRegionCode();
	}

	/**
	* Sets the region code of this standards display order.
	*
	* @param regionCode the region code of this standards display order
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_standardsDisplayOrder.setRegionCode(regionCode);
	}

	/**
	* Returns the chain code of this standards display order.
	*
	* @return the chain code of this standards display order
	*/
	@Override
	public java.lang.String getChainCode() {
		return _standardsDisplayOrder.getChainCode();
	}

	/**
	* Sets the chain code of this standards display order.
	*
	* @param chainCode the chain code of this standards display order
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_standardsDisplayOrder.setChainCode(chainCode);
	}

	/**
	* Returns the display order of this standards display order.
	*
	* @return the display order of this standards display order
	*/
	@Override
	public long getDisplayOrder() {
		return _standardsDisplayOrder.getDisplayOrder();
	}

	/**
	* Sets the display order of this standards display order.
	*
	* @param displayOrder the display order of this standards display order
	*/
	@Override
	public void setDisplayOrder(long displayOrder) {
		_standardsDisplayOrder.setDisplayOrder(displayOrder);
	}

	/**
	* Returns the creator ID of this standards display order.
	*
	* @return the creator ID of this standards display order
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsDisplayOrder.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards display order.
	*
	* @param creatorId the creator ID of this standards display order
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsDisplayOrder.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards display order.
	*
	* @return the created date of this standards display order
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsDisplayOrder.getCreatedDate();
	}

	/**
	* Sets the created date of this standards display order.
	*
	* @param createdDate the created date of this standards display order
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsDisplayOrder.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards display order.
	*
	* @return the updated by of this standards display order
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsDisplayOrder.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards display order.
	*
	* @param updatedBy the updated by of this standards display order
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsDisplayOrder.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards display order.
	*
	* @return the updated date of this standards display order
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsDisplayOrder.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards display order.
	*
	* @param updatedDate the updated date of this standards display order
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsDisplayOrder.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsDisplayOrder.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsDisplayOrder.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsDisplayOrder.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsDisplayOrder.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsDisplayOrder.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsDisplayOrder.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsDisplayOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsDisplayOrder.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsDisplayOrder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsDisplayOrder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsDisplayOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsDisplayOrderWrapper((StandardsDisplayOrder)_standardsDisplayOrder.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsDisplayOrder standardsDisplayOrder) {
		return _standardsDisplayOrder.compareTo(standardsDisplayOrder);
	}

	@Override
	public int hashCode() {
		return _standardsDisplayOrder.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsDisplayOrder> toCacheModel() {
		return _standardsDisplayOrder.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder toEscapedModel() {
		return new StandardsDisplayOrderWrapper(_standardsDisplayOrder.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrder toUnescapedModel() {
		return new StandardsDisplayOrderWrapper(_standardsDisplayOrder.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsDisplayOrder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsDisplayOrder.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsDisplayOrder.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsDisplayOrderWrapper)) {
			return false;
		}

		StandardsDisplayOrderWrapper standardsDisplayOrderWrapper = (StandardsDisplayOrderWrapper)obj;

		if (Validator.equals(_standardsDisplayOrder,
					standardsDisplayOrderWrapper._standardsDisplayOrder)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsDisplayOrder getWrappedStandardsDisplayOrder() {
		return _standardsDisplayOrder;
	}

	@Override
	public StandardsDisplayOrder getWrappedModel() {
		return _standardsDisplayOrder;
	}

	@Override
	public void resetOriginalValues() {
		_standardsDisplayOrder.resetOriginalValues();
	}

	private StandardsDisplayOrder _standardsDisplayOrder;
}