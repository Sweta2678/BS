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
 * This class is a wrapper for {@link GEMGeneratedReportVal}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMGeneratedReportVal
 * @generated
 */
public class GEMGeneratedReportValWrapper implements GEMGeneratedReportVal,
	ModelWrapper<GEMGeneratedReportVal> {
	public GEMGeneratedReportValWrapper(
		GEMGeneratedReportVal gemGeneratedReportVal) {
		_gemGeneratedReportVal = gemGeneratedReportVal;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMGeneratedReportVal.class;
	}

	@Override
	public String getModelClassName() {
		return GEMGeneratedReportVal.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportValId", getReportValId());
		attributes.put("reportId", getReportId());
		attributes.put("columnId", getColumnId());
		attributes.put("generatedValue", getGeneratedValue());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportValId = (Long)attributes.get("reportValId");

		if (reportValId != null) {
			setReportValId(reportValId);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long columnId = (Long)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}

		String generatedValue = (String)attributes.get("generatedValue");

		if (generatedValue != null) {
			setGeneratedValue(generatedValue);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
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
	* Returns the primary key of this g e m generated report val.
	*
	* @return the primary key of this g e m generated report val
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK getPrimaryKey() {
		return _gemGeneratedReportVal.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m generated report val.
	*
	* @param primaryKey the primary key of this g e m generated report val
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK primaryKey) {
		_gemGeneratedReportVal.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the report val ID of this g e m generated report val.
	*
	* @return the report val ID of this g e m generated report val
	*/
	@Override
	public long getReportValId() {
		return _gemGeneratedReportVal.getReportValId();
	}

	/**
	* Sets the report val ID of this g e m generated report val.
	*
	* @param reportValId the report val ID of this g e m generated report val
	*/
	@Override
	public void setReportValId(long reportValId) {
		_gemGeneratedReportVal.setReportValId(reportValId);
	}

	/**
	* Returns the report ID of this g e m generated report val.
	*
	* @return the report ID of this g e m generated report val
	*/
	@Override
	public long getReportId() {
		return _gemGeneratedReportVal.getReportId();
	}

	/**
	* Sets the report ID of this g e m generated report val.
	*
	* @param reportId the report ID of this g e m generated report val
	*/
	@Override
	public void setReportId(long reportId) {
		_gemGeneratedReportVal.setReportId(reportId);
	}

	/**
	* Returns the column ID of this g e m generated report val.
	*
	* @return the column ID of this g e m generated report val
	*/
	@Override
	public long getColumnId() {
		return _gemGeneratedReportVal.getColumnId();
	}

	/**
	* Sets the column ID of this g e m generated report val.
	*
	* @param columnId the column ID of this g e m generated report val
	*/
	@Override
	public void setColumnId(long columnId) {
		_gemGeneratedReportVal.setColumnId(columnId);
	}

	/**
	* Returns the generated value of this g e m generated report val.
	*
	* @return the generated value of this g e m generated report val
	*/
	@Override
	public java.lang.String getGeneratedValue() {
		return _gemGeneratedReportVal.getGeneratedValue();
	}

	/**
	* Sets the generated value of this g e m generated report val.
	*
	* @param generatedValue the generated value of this g e m generated report val
	*/
	@Override
	public void setGeneratedValue(java.lang.String generatedValue) {
		_gemGeneratedReportVal.setGeneratedValue(generatedValue);
	}

	/**
	* Returns the display order number of this g e m generated report val.
	*
	* @return the display order number of this g e m generated report val
	*/
	@Override
	public long getDisplayOrderNumber() {
		return _gemGeneratedReportVal.getDisplayOrderNumber();
	}

	/**
	* Sets the display order number of this g e m generated report val.
	*
	* @param displayOrderNumber the display order number of this g e m generated report val
	*/
	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_gemGeneratedReportVal.setDisplayOrderNumber(displayOrderNumber);
	}

	/**
	* Returns the creator ID of this g e m generated report val.
	*
	* @return the creator ID of this g e m generated report val
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemGeneratedReportVal.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m generated report val.
	*
	* @param creatorId the creator ID of this g e m generated report val
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemGeneratedReportVal.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m generated report val.
	*
	* @return the created date of this g e m generated report val
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemGeneratedReportVal.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m generated report val.
	*
	* @param createdDate the created date of this g e m generated report val
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemGeneratedReportVal.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m generated report val.
	*
	* @return the updated by of this g e m generated report val
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemGeneratedReportVal.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m generated report val.
	*
	* @param updatedBy the updated by of this g e m generated report val
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemGeneratedReportVal.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m generated report val.
	*
	* @return the updated date of this g e m generated report val
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemGeneratedReportVal.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m generated report val.
	*
	* @param updatedDate the updated date of this g e m generated report val
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemGeneratedReportVal.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemGeneratedReportVal.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemGeneratedReportVal.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemGeneratedReportVal.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemGeneratedReportVal.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemGeneratedReportVal.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemGeneratedReportVal.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemGeneratedReportVal.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemGeneratedReportVal.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemGeneratedReportVal.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemGeneratedReportVal.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemGeneratedReportVal.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMGeneratedReportValWrapper((GEMGeneratedReportVal)_gemGeneratedReportVal.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal) {
		return _gemGeneratedReportVal.compareTo(gemGeneratedReportVal);
	}

	@Override
	public int hashCode() {
		return _gemGeneratedReportVal.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMGeneratedReportVal> toCacheModel() {
		return _gemGeneratedReportVal.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal toEscapedModel() {
		return new GEMGeneratedReportValWrapper(_gemGeneratedReportVal.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReportVal toUnescapedModel() {
		return new GEMGeneratedReportValWrapper(_gemGeneratedReportVal.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemGeneratedReportVal.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemGeneratedReportVal.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemGeneratedReportVal.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMGeneratedReportValWrapper)) {
			return false;
		}

		GEMGeneratedReportValWrapper gemGeneratedReportValWrapper = (GEMGeneratedReportValWrapper)obj;

		if (Validator.equals(_gemGeneratedReportVal,
					gemGeneratedReportValWrapper._gemGeneratedReportVal)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMGeneratedReportVal getWrappedGEMGeneratedReportVal() {
		return _gemGeneratedReportVal;
	}

	@Override
	public GEMGeneratedReportVal getWrappedModel() {
		return _gemGeneratedReportVal;
	}

	@Override
	public void resetOriginalValues() {
		_gemGeneratedReportVal.resetOriginalValues();
	}

	private GEMGeneratedReportVal _gemGeneratedReportVal;
}