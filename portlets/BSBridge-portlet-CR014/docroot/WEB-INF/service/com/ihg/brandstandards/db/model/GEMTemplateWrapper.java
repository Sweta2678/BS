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
 * This class is a wrapper for {@link GEMTemplate}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplate
 * @generated
 */
public class GEMTemplateWrapper implements GEMTemplate,
	ModelWrapper<GEMTemplate> {
	public GEMTemplateWrapper(GEMTemplate gemTemplate) {
		_gemTemplate = gemTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateId", getTemplateId());
		attributes.put("templateName", getTemplateName());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("templateType", getTemplateType());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String templateType = (String)attributes.get("templateType");

		if (templateType != null) {
			setTemplateType(templateType);
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
	* Returns the primary key of this g e m template.
	*
	* @return the primary key of this g e m template
	*/
	@Override
	public long getPrimaryKey() {
		return _gemTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m template.
	*
	* @param primaryKey the primary key of this g e m template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the template ID of this g e m template.
	*
	* @return the template ID of this g e m template
	*/
	@Override
	public long getTemplateId() {
		return _gemTemplate.getTemplateId();
	}

	/**
	* Sets the template ID of this g e m template.
	*
	* @param templateId the template ID of this g e m template
	*/
	@Override
	public void setTemplateId(long templateId) {
		_gemTemplate.setTemplateId(templateId);
	}

	/**
	* Returns the template name of this g e m template.
	*
	* @return the template name of this g e m template
	*/
	@Override
	public java.lang.String getTemplateName() {
		return _gemTemplate.getTemplateName();
	}

	/**
	* Sets the template name of this g e m template.
	*
	* @param templateName the template name of this g e m template
	*/
	@Override
	public void setTemplateName(java.lang.String templateName) {
		_gemTemplate.setTemplateName(templateName);
	}

	/**
	* Returns the publish ID of this g e m template.
	*
	* @return the publish ID of this g e m template
	*/
	@Override
	public long getPublishId() {
		return _gemTemplate.getPublishId();
	}

	/**
	* Sets the publish ID of this g e m template.
	*
	* @param publishId the publish ID of this g e m template
	*/
	@Override
	public void setPublishId(long publishId) {
		_gemTemplate.setPublishId(publishId);
	}

	/**
	* Returns the region ID of this g e m template.
	*
	* @return the region ID of this g e m template
	*/
	@Override
	public long getRegionId() {
		return _gemTemplate.getRegionId();
	}

	/**
	* Sets the region ID of this g e m template.
	*
	* @param regionId the region ID of this g e m template
	*/
	@Override
	public void setRegionId(long regionId) {
		_gemTemplate.setRegionId(regionId);
	}

	/**
	* Returns the template type of this g e m template.
	*
	* @return the template type of this g e m template
	*/
	@Override
	public java.lang.String getTemplateType() {
		return _gemTemplate.getTemplateType();
	}

	/**
	* Sets the template type of this g e m template.
	*
	* @param templateType the template type of this g e m template
	*/
	@Override
	public void setTemplateType(java.lang.String templateType) {
		_gemTemplate.setTemplateType(templateType);
	}

	/**
	* Returns the creator ID of this g e m template.
	*
	* @return the creator ID of this g e m template
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemTemplate.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m template.
	*
	* @param creatorId the creator ID of this g e m template
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemTemplate.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m template.
	*
	* @return the created date of this g e m template
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemTemplate.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m template.
	*
	* @param createdDate the created date of this g e m template
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemTemplate.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m template.
	*
	* @return the updated by of this g e m template
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemTemplate.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m template.
	*
	* @param updatedBy the updated by of this g e m template
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemTemplate.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m template.
	*
	* @return the updated date of this g e m template
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemTemplate.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m template.
	*
	* @param updatedDate the updated date of this g e m template
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemTemplate.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMTemplateWrapper((GEMTemplate)_gemTemplate.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMTemplate gemTemplate) {
		return _gemTemplate.compareTo(gemTemplate);
	}

	@Override
	public int hashCode() {
		return _gemTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMTemplate> toCacheModel() {
		return _gemTemplate.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplate toEscapedModel() {
		return new GEMTemplateWrapper(_gemTemplate.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplate toUnescapedModel() {
		return new GEMTemplateWrapper(_gemTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMTemplateWrapper)) {
			return false;
		}

		GEMTemplateWrapper gemTemplateWrapper = (GEMTemplateWrapper)obj;

		if (Validator.equals(_gemTemplate, gemTemplateWrapper._gemTemplate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMTemplate getWrappedGEMTemplate() {
		return _gemTemplate;
	}

	@Override
	public GEMTemplate getWrappedModel() {
		return _gemTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_gemTemplate.resetOriginalValues();
	}

	private GEMTemplate _gemTemplate;
}