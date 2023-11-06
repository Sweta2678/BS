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
 * This class is a wrapper for {@link GEMGeneratedReport}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMGeneratedReport
 * @generated
 */
public class GEMGeneratedReportWrapper implements GEMGeneratedReport,
	ModelWrapper<GEMGeneratedReport> {
	public GEMGeneratedReportWrapper(GEMGeneratedReport gemGeneratedReport) {
		_gemGeneratedReport = gemGeneratedReport;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMGeneratedReport.class;
	}

	@Override
	public String getModelClassName() {
		return GEMGeneratedReport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportId", getReportId());
		attributes.put("templateId", getTemplateId());
		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long uniqueGroupId = (Long)attributes.get("uniqueGroupId");

		if (uniqueGroupId != null) {
			setUniqueGroupId(uniqueGroupId);
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
	* Returns the primary key of this g e m generated report.
	*
	* @return the primary key of this g e m generated report
	*/
	@Override
	public long getPrimaryKey() {
		return _gemGeneratedReport.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m generated report.
	*
	* @param primaryKey the primary key of this g e m generated report
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemGeneratedReport.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the report ID of this g e m generated report.
	*
	* @return the report ID of this g e m generated report
	*/
	@Override
	public long getReportId() {
		return _gemGeneratedReport.getReportId();
	}

	/**
	* Sets the report ID of this g e m generated report.
	*
	* @param reportId the report ID of this g e m generated report
	*/
	@Override
	public void setReportId(long reportId) {
		_gemGeneratedReport.setReportId(reportId);
	}

	/**
	* Returns the template ID of this g e m generated report.
	*
	* @return the template ID of this g e m generated report
	*/
	@Override
	public long getTemplateId() {
		return _gemGeneratedReport.getTemplateId();
	}

	/**
	* Sets the template ID of this g e m generated report.
	*
	* @param templateId the template ID of this g e m generated report
	*/
	@Override
	public void setTemplateId(long templateId) {
		_gemGeneratedReport.setTemplateId(templateId);
	}

	/**
	* Returns the unique group ID of this g e m generated report.
	*
	* @return the unique group ID of this g e m generated report
	*/
	@Override
	public long getUniqueGroupId() {
		return _gemGeneratedReport.getUniqueGroupId();
	}

	/**
	* Sets the unique group ID of this g e m generated report.
	*
	* @param uniqueGroupId the unique group ID of this g e m generated report
	*/
	@Override
	public void setUniqueGroupId(long uniqueGroupId) {
		_gemGeneratedReport.setUniqueGroupId(uniqueGroupId);
	}

	/**
	* Returns the creator ID of this g e m generated report.
	*
	* @return the creator ID of this g e m generated report
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemGeneratedReport.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m generated report.
	*
	* @param creatorId the creator ID of this g e m generated report
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemGeneratedReport.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m generated report.
	*
	* @return the created date of this g e m generated report
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemGeneratedReport.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m generated report.
	*
	* @param createdDate the created date of this g e m generated report
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemGeneratedReport.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m generated report.
	*
	* @return the updated by of this g e m generated report
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemGeneratedReport.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m generated report.
	*
	* @param updatedBy the updated by of this g e m generated report
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemGeneratedReport.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m generated report.
	*
	* @return the updated date of this g e m generated report
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemGeneratedReport.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m generated report.
	*
	* @param updatedDate the updated date of this g e m generated report
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemGeneratedReport.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemGeneratedReport.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemGeneratedReport.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemGeneratedReport.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemGeneratedReport.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemGeneratedReport.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemGeneratedReport.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemGeneratedReport.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemGeneratedReport.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemGeneratedReport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemGeneratedReport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemGeneratedReport.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMGeneratedReportWrapper((GEMGeneratedReport)_gemGeneratedReport.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMGeneratedReport gemGeneratedReport) {
		return _gemGeneratedReport.compareTo(gemGeneratedReport);
	}

	@Override
	public int hashCode() {
		return _gemGeneratedReport.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMGeneratedReport> toCacheModel() {
		return _gemGeneratedReport.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReport toEscapedModel() {
		return new GEMGeneratedReportWrapper(_gemGeneratedReport.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMGeneratedReport toUnescapedModel() {
		return new GEMGeneratedReportWrapper(_gemGeneratedReport.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemGeneratedReport.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemGeneratedReport.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemGeneratedReport.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMGeneratedReportWrapper)) {
			return false;
		}

		GEMGeneratedReportWrapper gemGeneratedReportWrapper = (GEMGeneratedReportWrapper)obj;

		if (Validator.equals(_gemGeneratedReport,
					gemGeneratedReportWrapper._gemGeneratedReport)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMGeneratedReport getWrappedGEMGeneratedReport() {
		return _gemGeneratedReport;
	}

	@Override
	public GEMGeneratedReport getWrappedModel() {
		return _gemGeneratedReport;
	}

	@Override
	public void resetOriginalValues() {
		_gemGeneratedReport.resetOriginalValues();
	}

	private GEMGeneratedReport _gemGeneratedReport;
}