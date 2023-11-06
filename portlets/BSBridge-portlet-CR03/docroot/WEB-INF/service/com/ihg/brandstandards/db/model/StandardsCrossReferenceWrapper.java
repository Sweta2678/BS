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
 * This class is a wrapper for {@link StandardsCrossReference}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCrossReference
 * @generated
 */
public class StandardsCrossReferenceWrapper implements StandardsCrossReference,
	ModelWrapper<StandardsCrossReference> {
	public StandardsCrossReferenceWrapper(
		StandardsCrossReference standardsCrossReference) {
		_standardsCrossReference = standardsCrossReference;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCrossReference.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCrossReference.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("xrefStdId", getXrefStdId());
		attributes.put("dispOrderNumber", getDispOrderNumber());
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

		Long xrefStdId = (Long)attributes.get("xrefStdId");

		if (xrefStdId != null) {
			setXrefStdId(xrefStdId);
		}

		Long dispOrderNumber = (Long)attributes.get("dispOrderNumber");

		if (dispOrderNumber != null) {
			setDispOrderNumber(dispOrderNumber);
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
	* Returns the primary key of this standards cross reference.
	*
	* @return the primary key of this standards cross reference
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK getPrimaryKey() {
		return _standardsCrossReference.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards cross reference.
	*
	* @param primaryKey the primary key of this standards cross reference
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK primaryKey) {
		_standardsCrossReference.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this standards cross reference.
	*
	* @return the std ID of this standards cross reference
	*/
	@Override
	public long getStdId() {
		return _standardsCrossReference.getStdId();
	}

	/**
	* Sets the std ID of this standards cross reference.
	*
	* @param stdId the std ID of this standards cross reference
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsCrossReference.setStdId(stdId);
	}

	/**
	* Returns the xref std ID of this standards cross reference.
	*
	* @return the xref std ID of this standards cross reference
	*/
	@Override
	public long getXrefStdId() {
		return _standardsCrossReference.getXrefStdId();
	}

	/**
	* Sets the xref std ID of this standards cross reference.
	*
	* @param xrefStdId the xref std ID of this standards cross reference
	*/
	@Override
	public void setXrefStdId(long xrefStdId) {
		_standardsCrossReference.setXrefStdId(xrefStdId);
	}

	/**
	* Returns the disp order number of this standards cross reference.
	*
	* @return the disp order number of this standards cross reference
	*/
	@Override
	public long getDispOrderNumber() {
		return _standardsCrossReference.getDispOrderNumber();
	}

	/**
	* Sets the disp order number of this standards cross reference.
	*
	* @param dispOrderNumber the disp order number of this standards cross reference
	*/
	@Override
	public void setDispOrderNumber(long dispOrderNumber) {
		_standardsCrossReference.setDispOrderNumber(dispOrderNumber);
	}

	/**
	* Returns the creator ID of this standards cross reference.
	*
	* @return the creator ID of this standards cross reference
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsCrossReference.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards cross reference.
	*
	* @param creatorId the creator ID of this standards cross reference
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsCrossReference.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards cross reference.
	*
	* @return the created date of this standards cross reference
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsCrossReference.getCreatedDate();
	}

	/**
	* Sets the created date of this standards cross reference.
	*
	* @param createdDate the created date of this standards cross reference
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsCrossReference.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards cross reference.
	*
	* @return the updated by of this standards cross reference
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsCrossReference.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards cross reference.
	*
	* @param updatedBy the updated by of this standards cross reference
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsCrossReference.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards cross reference.
	*
	* @return the updated date of this standards cross reference
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsCrossReference.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards cross reference.
	*
	* @param updatedDate the updated date of this standards cross reference
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsCrossReference.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsCrossReference.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsCrossReference.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsCrossReference.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsCrossReference.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsCrossReference.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsCrossReference.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsCrossReference.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsCrossReference.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsCrossReference.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsCrossReference.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsCrossReference.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsCrossReferenceWrapper((StandardsCrossReference)_standardsCrossReference.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsCrossReference standardsCrossReference) {
		return _standardsCrossReference.compareTo(standardsCrossReference);
	}

	@Override
	public int hashCode() {
		return _standardsCrossReference.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsCrossReference> toCacheModel() {
		return _standardsCrossReference.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference toEscapedModel() {
		return new StandardsCrossReferenceWrapper(_standardsCrossReference.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCrossReference toUnescapedModel() {
		return new StandardsCrossReferenceWrapper(_standardsCrossReference.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsCrossReference.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsCrossReference.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsCrossReference.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsCrossReferenceWrapper)) {
			return false;
		}

		StandardsCrossReferenceWrapper standardsCrossReferenceWrapper = (StandardsCrossReferenceWrapper)obj;

		if (Validator.equals(_standardsCrossReference,
					standardsCrossReferenceWrapper._standardsCrossReference)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsCrossReference getWrappedStandardsCrossReference() {
		return _standardsCrossReference;
	}

	@Override
	public StandardsCrossReference getWrappedModel() {
		return _standardsCrossReference;
	}

	@Override
	public void resetOriginalValues() {
		_standardsCrossReference.resetOriginalValues();
	}

	private StandardsCrossReference _standardsCrossReference;
}