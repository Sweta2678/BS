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
 * This class is a wrapper for {@link GEMTemplateReference}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateReference
 * @generated
 */
public class GEMTemplateReferenceWrapper implements GEMTemplateReference,
	ModelWrapper<GEMTemplateReference> {
	public GEMTemplateReferenceWrapper(
		GEMTemplateReference gemTemplateReference) {
		_gemTemplateReference = gemTemplateReference;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplateReference.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplateReference.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateRefId", getTemplateRefId());
		attributes.put("templateId", getTemplateId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("regionId", getRegionId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateRefId = (Long)attributes.get("templateRefId");

		if (templateRefId != null) {
			setTemplateRefId(templateRefId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
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
	* Returns the primary key of this g e m template reference.
	*
	* @return the primary key of this g e m template reference
	*/
	@Override
	public long getPrimaryKey() {
		return _gemTemplateReference.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m template reference.
	*
	* @param primaryKey the primary key of this g e m template reference
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemTemplateReference.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the template ref ID of this g e m template reference.
	*
	* @return the template ref ID of this g e m template reference
	*/
	@Override
	public long getTemplateRefId() {
		return _gemTemplateReference.getTemplateRefId();
	}

	/**
	* Sets the template ref ID of this g e m template reference.
	*
	* @param templateRefId the template ref ID of this g e m template reference
	*/
	@Override
	public void setTemplateRefId(long templateRefId) {
		_gemTemplateReference.setTemplateRefId(templateRefId);
	}

	/**
	* Returns the template ID of this g e m template reference.
	*
	* @return the template ID of this g e m template reference
	*/
	@Override
	public long getTemplateId() {
		return _gemTemplateReference.getTemplateId();
	}

	/**
	* Sets the template ID of this g e m template reference.
	*
	* @param templateId the template ID of this g e m template reference
	*/
	@Override
	public void setTemplateId(long templateId) {
		_gemTemplateReference.setTemplateId(templateId);
	}

	/**
	* Returns the publish dept ID of this g e m template reference.
	*
	* @return the publish dept ID of this g e m template reference
	*/
	@Override
	public long getPublishDeptId() {
		return _gemTemplateReference.getPublishDeptId();
	}

	/**
	* Sets the publish dept ID of this g e m template reference.
	*
	* @param publishDeptId the publish dept ID of this g e m template reference
	*/
	@Override
	public void setPublishDeptId(long publishDeptId) {
		_gemTemplateReference.setPublishDeptId(publishDeptId);
	}

	/**
	* Returns the region ID of this g e m template reference.
	*
	* @return the region ID of this g e m template reference
	*/
	@Override
	public long getRegionId() {
		return _gemTemplateReference.getRegionId();
	}

	/**
	* Sets the region ID of this g e m template reference.
	*
	* @param regionId the region ID of this g e m template reference
	*/
	@Override
	public void setRegionId(long regionId) {
		_gemTemplateReference.setRegionId(regionId);
	}

	/**
	* Returns the creator ID of this g e m template reference.
	*
	* @return the creator ID of this g e m template reference
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemTemplateReference.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m template reference.
	*
	* @param creatorId the creator ID of this g e m template reference
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemTemplateReference.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m template reference.
	*
	* @return the created date of this g e m template reference
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemTemplateReference.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m template reference.
	*
	* @param createdDate the created date of this g e m template reference
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemTemplateReference.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m template reference.
	*
	* @return the updated by of this g e m template reference
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemTemplateReference.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m template reference.
	*
	* @param updatedBy the updated by of this g e m template reference
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemTemplateReference.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m template reference.
	*
	* @return the updated date of this g e m template reference
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemTemplateReference.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m template reference.
	*
	* @param updatedDate the updated date of this g e m template reference
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemTemplateReference.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemTemplateReference.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemTemplateReference.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemTemplateReference.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemTemplateReference.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemTemplateReference.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemTemplateReference.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemTemplateReference.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemTemplateReference.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemTemplateReference.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemTemplateReference.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemTemplateReference.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMTemplateReferenceWrapper((GEMTemplateReference)_gemTemplateReference.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMTemplateReference gemTemplateReference) {
		return _gemTemplateReference.compareTo(gemTemplateReference);
	}

	@Override
	public int hashCode() {
		return _gemTemplateReference.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMTemplateReference> toCacheModel() {
		return _gemTemplateReference.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateReference toEscapedModel() {
		return new GEMTemplateReferenceWrapper(_gemTemplateReference.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateReference toUnescapedModel() {
		return new GEMTemplateReferenceWrapper(_gemTemplateReference.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemTemplateReference.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemTemplateReference.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemTemplateReference.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMTemplateReferenceWrapper)) {
			return false;
		}

		GEMTemplateReferenceWrapper gemTemplateReferenceWrapper = (GEMTemplateReferenceWrapper)obj;

		if (Validator.equals(_gemTemplateReference,
					gemTemplateReferenceWrapper._gemTemplateReference)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMTemplateReference getWrappedGEMTemplateReference() {
		return _gemTemplateReference;
	}

	@Override
	public GEMTemplateReference getWrappedModel() {
		return _gemTemplateReference;
	}

	@Override
	public void resetOriginalValues() {
		_gemTemplateReference.resetOriginalValues();
	}

	private GEMTemplateReference _gemTemplateReference;
}