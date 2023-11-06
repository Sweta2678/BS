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
 * This class is a wrapper for {@link GEMTrigger}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTrigger
 * @generated
 */
public class GEMTriggerWrapper implements GEMTrigger, ModelWrapper<GEMTrigger> {
	public GEMTriggerWrapper(GEMTrigger gemTrigger) {
		_gemTrigger = gemTrigger;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTrigger.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTrigger.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("triggerId", getTriggerId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("question", getQuestion());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long triggerId = (Long)attributes.get("triggerId");

		if (triggerId != null) {
			setTriggerId(triggerId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
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
	* Returns the primary key of this g e m trigger.
	*
	* @return the primary key of this g e m trigger
	*/
	@Override
	public long getPrimaryKey() {
		return _gemTrigger.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m trigger.
	*
	* @param primaryKey the primary key of this g e m trigger
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemTrigger.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the trigger ID of this g e m trigger.
	*
	* @return the trigger ID of this g e m trigger
	*/
	@Override
	public long getTriggerId() {
		return _gemTrigger.getTriggerId();
	}

	/**
	* Sets the trigger ID of this g e m trigger.
	*
	* @param triggerId the trigger ID of this g e m trigger
	*/
	@Override
	public void setTriggerId(long triggerId) {
		_gemTrigger.setTriggerId(triggerId);
	}

	/**
	* Returns the publish dept ID of this g e m trigger.
	*
	* @return the publish dept ID of this g e m trigger
	*/
	@Override
	public long getPublishDeptId() {
		return _gemTrigger.getPublishDeptId();
	}

	/**
	* Sets the publish dept ID of this g e m trigger.
	*
	* @param publishDeptId the publish dept ID of this g e m trigger
	*/
	@Override
	public void setPublishDeptId(long publishDeptId) {
		_gemTrigger.setPublishDeptId(publishDeptId);
	}

	/**
	* Returns the publish ID of this g e m trigger.
	*
	* @return the publish ID of this g e m trigger
	*/
	@Override
	public long getPublishId() {
		return _gemTrigger.getPublishId();
	}

	/**
	* Sets the publish ID of this g e m trigger.
	*
	* @param publishId the publish ID of this g e m trigger
	*/
	@Override
	public void setPublishId(long publishId) {
		_gemTrigger.setPublishId(publishId);
	}

	/**
	* Returns the question of this g e m trigger.
	*
	* @return the question of this g e m trigger
	*/
	@Override
	public java.lang.String getQuestion() {
		return _gemTrigger.getQuestion();
	}

	/**
	* Sets the question of this g e m trigger.
	*
	* @param question the question of this g e m trigger
	*/
	@Override
	public void setQuestion(java.lang.String question) {
		_gemTrigger.setQuestion(question);
	}

	/**
	* Returns the creator ID of this g e m trigger.
	*
	* @return the creator ID of this g e m trigger
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemTrigger.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m trigger.
	*
	* @param creatorId the creator ID of this g e m trigger
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemTrigger.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m trigger.
	*
	* @return the created date of this g e m trigger
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemTrigger.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m trigger.
	*
	* @param createdDate the created date of this g e m trigger
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemTrigger.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m trigger.
	*
	* @return the updated by of this g e m trigger
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemTrigger.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m trigger.
	*
	* @param updatedBy the updated by of this g e m trigger
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemTrigger.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m trigger.
	*
	* @return the updated date of this g e m trigger
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemTrigger.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m trigger.
	*
	* @param updatedDate the updated date of this g e m trigger
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemTrigger.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemTrigger.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemTrigger.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemTrigger.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemTrigger.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemTrigger.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemTrigger.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemTrigger.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemTrigger.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemTrigger.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemTrigger.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemTrigger.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMTriggerWrapper((GEMTrigger)_gemTrigger.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.GEMTrigger gemTrigger) {
		return _gemTrigger.compareTo(gemTrigger);
	}

	@Override
	public int hashCode() {
		return _gemTrigger.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMTrigger> toCacheModel() {
		return _gemTrigger.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTrigger toEscapedModel() {
		return new GEMTriggerWrapper(_gemTrigger.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTrigger toUnescapedModel() {
		return new GEMTriggerWrapper(_gemTrigger.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemTrigger.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemTrigger.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemTrigger.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMTriggerWrapper)) {
			return false;
		}

		GEMTriggerWrapper gemTriggerWrapper = (GEMTriggerWrapper)obj;

		if (Validator.equals(_gemTrigger, gemTriggerWrapper._gemTrigger)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMTrigger getWrappedGEMTrigger() {
		return _gemTrigger;
	}

	@Override
	public GEMTrigger getWrappedModel() {
		return _gemTrigger;
	}

	@Override
	public void resetOriginalValues() {
		_gemTrigger.resetOriginalValues();
	}

	private GEMTrigger _gemTrigger;
}