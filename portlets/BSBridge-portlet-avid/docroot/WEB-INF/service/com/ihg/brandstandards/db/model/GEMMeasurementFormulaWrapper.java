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
 * This class is a wrapper for {@link GEMMeasurementFormula}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementFormula
 * @generated
 */
public class GEMMeasurementFormulaWrapper implements GEMMeasurementFormula,
	ModelWrapper<GEMMeasurementFormula> {
	public GEMMeasurementFormulaWrapper(
		GEMMeasurementFormula gemMeasurementFormula) {
		_gemMeasurementFormula = gemMeasurementFormula;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementFormula.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementFormula.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formulaId", getFormulaId());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("measurementId", getMeasurementId());
		attributes.put("severityId", getSeverityId());
		attributes.put("subRegionLevelCd", getSubRegionLevelCd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formulaId = (Long)attributes.get("formulaId");

		if (formulaId != null) {
			setFormulaId(formulaId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long measurementId = (Long)attributes.get("measurementId");

		if (measurementId != null) {
			setMeasurementId(measurementId);
		}

		Long severityId = (Long)attributes.get("severityId");

		if (severityId != null) {
			setSeverityId(severityId);
		}

		String subRegionLevelCd = (String)attributes.get("subRegionLevelCd");

		if (subRegionLevelCd != null) {
			setSubRegionLevelCd(subRegionLevelCd);
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
	* Returns the primary key of this g e m measurement formula.
	*
	* @return the primary key of this g e m measurement formula
	*/
	@Override
	public long getPrimaryKey() {
		return _gemMeasurementFormula.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m measurement formula.
	*
	* @param primaryKey the primary key of this g e m measurement formula
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemMeasurementFormula.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the formula ID of this g e m measurement formula.
	*
	* @return the formula ID of this g e m measurement formula
	*/
	@Override
	public long getFormulaId() {
		return _gemMeasurementFormula.getFormulaId();
	}

	/**
	* Sets the formula ID of this g e m measurement formula.
	*
	* @param formulaId the formula ID of this g e m measurement formula
	*/
	@Override
	public void setFormulaId(long formulaId) {
		_gemMeasurementFormula.setFormulaId(formulaId);
	}

	/**
	* Returns the publish ID of this g e m measurement formula.
	*
	* @return the publish ID of this g e m measurement formula
	*/
	@Override
	public long getPublishId() {
		return _gemMeasurementFormula.getPublishId();
	}

	/**
	* Sets the publish ID of this g e m measurement formula.
	*
	* @param publishId the publish ID of this g e m measurement formula
	*/
	@Override
	public void setPublishId(long publishId) {
		_gemMeasurementFormula.setPublishId(publishId);
	}

	/**
	* Returns the region ID of this g e m measurement formula.
	*
	* @return the region ID of this g e m measurement formula
	*/
	@Override
	public long getRegionId() {
		return _gemMeasurementFormula.getRegionId();
	}

	/**
	* Sets the region ID of this g e m measurement formula.
	*
	* @param regionId the region ID of this g e m measurement formula
	*/
	@Override
	public void setRegionId(long regionId) {
		_gemMeasurementFormula.setRegionId(regionId);
	}

	/**
	* Returns the measurement ID of this g e m measurement formula.
	*
	* @return the measurement ID of this g e m measurement formula
	*/
	@Override
	public long getMeasurementId() {
		return _gemMeasurementFormula.getMeasurementId();
	}

	/**
	* Sets the measurement ID of this g e m measurement formula.
	*
	* @param measurementId the measurement ID of this g e m measurement formula
	*/
	@Override
	public void setMeasurementId(long measurementId) {
		_gemMeasurementFormula.setMeasurementId(measurementId);
	}

	/**
	* Returns the severity ID of this g e m measurement formula.
	*
	* @return the severity ID of this g e m measurement formula
	*/
	@Override
	public long getSeverityId() {
		return _gemMeasurementFormula.getSeverityId();
	}

	/**
	* Sets the severity ID of this g e m measurement formula.
	*
	* @param severityId the severity ID of this g e m measurement formula
	*/
	@Override
	public void setSeverityId(long severityId) {
		_gemMeasurementFormula.setSeverityId(severityId);
	}

	/**
	* Returns the sub region level cd of this g e m measurement formula.
	*
	* @return the sub region level cd of this g e m measurement formula
	*/
	@Override
	public java.lang.String getSubRegionLevelCd() {
		return _gemMeasurementFormula.getSubRegionLevelCd();
	}

	/**
	* Sets the sub region level cd of this g e m measurement formula.
	*
	* @param subRegionLevelCd the sub region level cd of this g e m measurement formula
	*/
	@Override
	public void setSubRegionLevelCd(java.lang.String subRegionLevelCd) {
		_gemMeasurementFormula.setSubRegionLevelCd(subRegionLevelCd);
	}

	/**
	* Returns the creator ID of this g e m measurement formula.
	*
	* @return the creator ID of this g e m measurement formula
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemMeasurementFormula.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m measurement formula.
	*
	* @param creatorId the creator ID of this g e m measurement formula
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemMeasurementFormula.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m measurement formula.
	*
	* @return the created date of this g e m measurement formula
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemMeasurementFormula.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m measurement formula.
	*
	* @param createdDate the created date of this g e m measurement formula
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemMeasurementFormula.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m measurement formula.
	*
	* @return the updated by of this g e m measurement formula
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemMeasurementFormula.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m measurement formula.
	*
	* @param updatedBy the updated by of this g e m measurement formula
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemMeasurementFormula.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m measurement formula.
	*
	* @return the updated date of this g e m measurement formula
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemMeasurementFormula.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m measurement formula.
	*
	* @param updatedDate the updated date of this g e m measurement formula
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemMeasurementFormula.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemMeasurementFormula.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemMeasurementFormula.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemMeasurementFormula.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemMeasurementFormula.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemMeasurementFormula.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemMeasurementFormula.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemMeasurementFormula.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemMeasurementFormula.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemMeasurementFormula.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemMeasurementFormula.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemMeasurementFormula.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMMeasurementFormulaWrapper((GEMMeasurementFormula)_gemMeasurementFormula.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMMeasurementFormula gemMeasurementFormula) {
		return _gemMeasurementFormula.compareTo(gemMeasurementFormula);
	}

	@Override
	public int hashCode() {
		return _gemMeasurementFormula.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMMeasurementFormula> toCacheModel() {
		return _gemMeasurementFormula.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementFormula toEscapedModel() {
		return new GEMMeasurementFormulaWrapper(_gemMeasurementFormula.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementFormula toUnescapedModel() {
		return new GEMMeasurementFormulaWrapper(_gemMeasurementFormula.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemMeasurementFormula.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemMeasurementFormula.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemMeasurementFormula.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMMeasurementFormulaWrapper)) {
			return false;
		}

		GEMMeasurementFormulaWrapper gemMeasurementFormulaWrapper = (GEMMeasurementFormulaWrapper)obj;

		if (Validator.equals(_gemMeasurementFormula,
					gemMeasurementFormulaWrapper._gemMeasurementFormula)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMMeasurementFormula getWrappedGEMMeasurementFormula() {
		return _gemMeasurementFormula;
	}

	@Override
	public GEMMeasurementFormula getWrappedModel() {
		return _gemMeasurementFormula;
	}

	@Override
	public void resetOriginalValues() {
		_gemMeasurementFormula.resetOriginalValues();
	}

	private GEMMeasurementFormula _gemMeasurementFormula;
}