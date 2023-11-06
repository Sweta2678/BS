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
 * This class is a wrapper for {@link PublishCountryStandard}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishCountryStandard
 * @generated
 */
public class PublishCountryStandardWrapper implements PublishCountryStandard,
	ModelWrapper<PublishCountryStandard> {
	public PublishCountryStandardWrapper(
		PublishCountryStandard publishCountryStandard) {
		_publishCountryStandard = publishCountryStandard;
	}

	@Override
	public Class<?> getModelClass() {
		return PublishCountryStandard.class;
	}

	@Override
	public String getModelClassName() {
		return PublishCountryStandard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishCountryStdId", getPublishCountryStdId());
		attributes.put("publishVerId", getPublishVerId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("expiredRefTxt", getExpiredRefTxt());
		attributes.put("publishStatCode", getPublishStatCode());
		attributes.put("stdComplyDeadlineDate", getStdComplyDeadlineDate());
		attributes.put("orderNumber", getOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publishCountryStdId = (String)attributes.get(
				"publishCountryStdId");

		if (publishCountryStdId != null) {
			setPublishCountryStdId(publishCountryStdId);
		}

		Long publishVerId = (Long)attributes.get("publishVerId");

		if (publishVerId != null) {
			setPublishVerId(publishVerId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String expiredRefTxt = (String)attributes.get("expiredRefTxt");

		if (expiredRefTxt != null) {
			setExpiredRefTxt(expiredRefTxt);
		}

		String publishStatCode = (String)attributes.get("publishStatCode");

		if (publishStatCode != null) {
			setPublishStatCode(publishStatCode);
		}

		Date stdComplyDeadlineDate = (Date)attributes.get(
				"stdComplyDeadlineDate");

		if (stdComplyDeadlineDate != null) {
			setStdComplyDeadlineDate(stdComplyDeadlineDate);
		}

		Long orderNumber = (Long)attributes.get("orderNumber");

		if (orderNumber != null) {
			setOrderNumber(orderNumber);
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
	* Returns the primary key of this publish country standard.
	*
	* @return the primary key of this publish country standard
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _publishCountryStandard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this publish country standard.
	*
	* @param primaryKey the primary key of this publish country standard
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_publishCountryStandard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish country std ID of this publish country standard.
	*
	* @return the publish country std ID of this publish country standard
	*/
	@Override
	public java.lang.String getPublishCountryStdId() {
		return _publishCountryStandard.getPublishCountryStdId();
	}

	/**
	* Sets the publish country std ID of this publish country standard.
	*
	* @param publishCountryStdId the publish country std ID of this publish country standard
	*/
	@Override
	public void setPublishCountryStdId(java.lang.String publishCountryStdId) {
		_publishCountryStandard.setPublishCountryStdId(publishCountryStdId);
	}

	/**
	* Returns the publish ver ID of this publish country standard.
	*
	* @return the publish ver ID of this publish country standard
	*/
	@Override
	public long getPublishVerId() {
		return _publishCountryStandard.getPublishVerId();
	}

	/**
	* Sets the publish ver ID of this publish country standard.
	*
	* @param publishVerId the publish ver ID of this publish country standard
	*/
	@Override
	public void setPublishVerId(long publishVerId) {
		_publishCountryStandard.setPublishVerId(publishVerId);
	}

	/**
	* Returns the country code of this publish country standard.
	*
	* @return the country code of this publish country standard
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _publishCountryStandard.getCountryCode();
	}

	/**
	* Sets the country code of this publish country standard.
	*
	* @param countryCode the country code of this publish country standard
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_publishCountryStandard.setCountryCode(countryCode);
	}

	/**
	* Returns the expired ref txt of this publish country standard.
	*
	* @return the expired ref txt of this publish country standard
	*/
	@Override
	public java.lang.String getExpiredRefTxt() {
		return _publishCountryStandard.getExpiredRefTxt();
	}

	/**
	* Sets the expired ref txt of this publish country standard.
	*
	* @param expiredRefTxt the expired ref txt of this publish country standard
	*/
	@Override
	public void setExpiredRefTxt(java.lang.String expiredRefTxt) {
		_publishCountryStandard.setExpiredRefTxt(expiredRefTxt);
	}

	/**
	* Returns the publish stat code of this publish country standard.
	*
	* @return the publish stat code of this publish country standard
	*/
	@Override
	public java.lang.String getPublishStatCode() {
		return _publishCountryStandard.getPublishStatCode();
	}

	/**
	* Sets the publish stat code of this publish country standard.
	*
	* @param publishStatCode the publish stat code of this publish country standard
	*/
	@Override
	public void setPublishStatCode(java.lang.String publishStatCode) {
		_publishCountryStandard.setPublishStatCode(publishStatCode);
	}

	/**
	* Returns the std comply deadline date of this publish country standard.
	*
	* @return the std comply deadline date of this publish country standard
	*/
	@Override
	public java.util.Date getStdComplyDeadlineDate() {
		return _publishCountryStandard.getStdComplyDeadlineDate();
	}

	/**
	* Sets the std comply deadline date of this publish country standard.
	*
	* @param stdComplyDeadlineDate the std comply deadline date of this publish country standard
	*/
	@Override
	public void setStdComplyDeadlineDate(java.util.Date stdComplyDeadlineDate) {
		_publishCountryStandard.setStdComplyDeadlineDate(stdComplyDeadlineDate);
	}

	/**
	* Returns the order number of this publish country standard.
	*
	* @return the order number of this publish country standard
	*/
	@Override
	public long getOrderNumber() {
		return _publishCountryStandard.getOrderNumber();
	}

	/**
	* Sets the order number of this publish country standard.
	*
	* @param orderNumber the order number of this publish country standard
	*/
	@Override
	public void setOrderNumber(long orderNumber) {
		_publishCountryStandard.setOrderNumber(orderNumber);
	}

	/**
	* Returns the creator ID of this publish country standard.
	*
	* @return the creator ID of this publish country standard
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _publishCountryStandard.getCreatorId();
	}

	/**
	* Sets the creator ID of this publish country standard.
	*
	* @param creatorId the creator ID of this publish country standard
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_publishCountryStandard.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this publish country standard.
	*
	* @return the created date of this publish country standard
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _publishCountryStandard.getCreatedDate();
	}

	/**
	* Sets the created date of this publish country standard.
	*
	* @param createdDate the created date of this publish country standard
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_publishCountryStandard.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this publish country standard.
	*
	* @return the updated by of this publish country standard
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _publishCountryStandard.getUpdatedBy();
	}

	/**
	* Sets the updated by of this publish country standard.
	*
	* @param updatedBy the updated by of this publish country standard
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_publishCountryStandard.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this publish country standard.
	*
	* @return the updated date of this publish country standard
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _publishCountryStandard.getUpdatedDate();
	}

	/**
	* Sets the updated date of this publish country standard.
	*
	* @param updatedDate the updated date of this publish country standard
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_publishCountryStandard.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _publishCountryStandard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publishCountryStandard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publishCountryStandard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publishCountryStandard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publishCountryStandard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publishCountryStandard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publishCountryStandard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publishCountryStandard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publishCountryStandard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publishCountryStandard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publishCountryStandard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublishCountryStandardWrapper((PublishCountryStandard)_publishCountryStandard.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.PublishCountryStandard publishCountryStandard) {
		return _publishCountryStandard.compareTo(publishCountryStandard);
	}

	@Override
	public int hashCode() {
		return _publishCountryStandard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.PublishCountryStandard> toCacheModel() {
		return _publishCountryStandard.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishCountryStandard toEscapedModel() {
		return new PublishCountryStandardWrapper(_publishCountryStandard.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishCountryStandard toUnescapedModel() {
		return new PublishCountryStandardWrapper(_publishCountryStandard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publishCountryStandard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publishCountryStandard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishCountryStandard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishCountryStandardWrapper)) {
			return false;
		}

		PublishCountryStandardWrapper publishCountryStandardWrapper = (PublishCountryStandardWrapper)obj;

		if (Validator.equals(_publishCountryStandard,
					publishCountryStandardWrapper._publishCountryStandard)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PublishCountryStandard getWrappedPublishCountryStandard() {
		return _publishCountryStandard;
	}

	@Override
	public PublishCountryStandard getWrappedModel() {
		return _publishCountryStandard;
	}

	@Override
	public void resetOriginalValues() {
		_publishCountryStandard.resetOriginalValues();
	}

	private PublishCountryStandard _publishCountryStandard;
}