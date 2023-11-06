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
 * This class is a wrapper for {@link Workflow}.
 * </p>
 *
 * @author Mummanedi
 * @see Workflow
 * @generated
 */
public class WorkflowWrapper implements Workflow, ModelWrapper<Workflow> {
	public WorkflowWrapper(Workflow workflow) {
		_workflow = workflow;
	}

	@Override
	public Class<?> getModelClass() {
		return Workflow.class;
	}

	@Override
	public String getModelClassName() {
		return Workflow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowActvtId", getWorkflowActvtId());
		attributes.put("objectId", getObjectId());
		attributes.put("objectType", getObjectType());
		attributes.put("status", getStatus());
		attributes.put("prevStatus", getPrevStatus());
		attributes.put("title", getTitle());
		attributes.put("comment", getComment());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowActvtId = (Long)attributes.get("workflowActvtId");

		if (workflowActvtId != null) {
			setWorkflowActvtId(workflowActvtId);
		}

		Long objectId = (Long)attributes.get("objectId");

		if (objectId != null) {
			setObjectId(objectId);
		}

		String objectType = (String)attributes.get("objectType");

		if (objectType != null) {
			setObjectType(objectType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String prevStatus = (String)attributes.get("prevStatus");

		if (prevStatus != null) {
			setPrevStatus(prevStatus);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
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
	* Returns the primary key of this workflow.
	*
	* @return the primary key of this workflow
	*/
	@Override
	public long getPrimaryKey() {
		return _workflow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this workflow.
	*
	* @param primaryKey the primary key of this workflow
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workflow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the workflow actvt ID of this workflow.
	*
	* @return the workflow actvt ID of this workflow
	*/
	@Override
	public long getWorkflowActvtId() {
		return _workflow.getWorkflowActvtId();
	}

	/**
	* Sets the workflow actvt ID of this workflow.
	*
	* @param workflowActvtId the workflow actvt ID of this workflow
	*/
	@Override
	public void setWorkflowActvtId(long workflowActvtId) {
		_workflow.setWorkflowActvtId(workflowActvtId);
	}

	/**
	* Returns the object ID of this workflow.
	*
	* @return the object ID of this workflow
	*/
	@Override
	public long getObjectId() {
		return _workflow.getObjectId();
	}

	/**
	* Sets the object ID of this workflow.
	*
	* @param objectId the object ID of this workflow
	*/
	@Override
	public void setObjectId(long objectId) {
		_workflow.setObjectId(objectId);
	}

	/**
	* Returns the object type of this workflow.
	*
	* @return the object type of this workflow
	*/
	@Override
	public java.lang.String getObjectType() {
		return _workflow.getObjectType();
	}

	/**
	* Sets the object type of this workflow.
	*
	* @param objectType the object type of this workflow
	*/
	@Override
	public void setObjectType(java.lang.String objectType) {
		_workflow.setObjectType(objectType);
	}

	/**
	* Returns the status of this workflow.
	*
	* @return the status of this workflow
	*/
	@Override
	public java.lang.String getStatus() {
		return _workflow.getStatus();
	}

	/**
	* Sets the status of this workflow.
	*
	* @param status the status of this workflow
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_workflow.setStatus(status);
	}

	/**
	* Returns the prev status of this workflow.
	*
	* @return the prev status of this workflow
	*/
	@Override
	public java.lang.String getPrevStatus() {
		return _workflow.getPrevStatus();
	}

	/**
	* Sets the prev status of this workflow.
	*
	* @param prevStatus the prev status of this workflow
	*/
	@Override
	public void setPrevStatus(java.lang.String prevStatus) {
		_workflow.setPrevStatus(prevStatus);
	}

	/**
	* Returns the title of this workflow.
	*
	* @return the title of this workflow
	*/
	@Override
	public java.lang.String getTitle() {
		return _workflow.getTitle();
	}

	/**
	* Sets the title of this workflow.
	*
	* @param title the title of this workflow
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_workflow.setTitle(title);
	}

	/**
	* Returns the comment of this workflow.
	*
	* @return the comment of this workflow
	*/
	@Override
	public java.lang.String getComment() {
		return _workflow.getComment();
	}

	/**
	* Sets the comment of this workflow.
	*
	* @param comment the comment of this workflow
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_workflow.setComment(comment);
	}

	/**
	* Returns the created by of this workflow.
	*
	* @return the created by of this workflow
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _workflow.getCreatedBy();
	}

	/**
	* Sets the created by of this workflow.
	*
	* @param createdBy the created by of this workflow
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_workflow.setCreatedBy(createdBy);
	}

	/**
	* Returns the chain code of this workflow.
	*
	* @return the chain code of this workflow
	*/
	@Override
	public java.lang.String getChainCode() {
		return _workflow.getChainCode();
	}

	/**
	* Sets the chain code of this workflow.
	*
	* @param chainCode the chain code of this workflow
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_workflow.setChainCode(chainCode);
	}

	/**
	* Returns the creator ID of this workflow.
	*
	* @return the creator ID of this workflow
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _workflow.getCreatorId();
	}

	/**
	* Sets the creator ID of this workflow.
	*
	* @param creatorId the creator ID of this workflow
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_workflow.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this workflow.
	*
	* @return the created date of this workflow
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _workflow.getCreatedDate();
	}

	/**
	* Sets the created date of this workflow.
	*
	* @param createdDate the created date of this workflow
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_workflow.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this workflow.
	*
	* @return the updated by of this workflow
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _workflow.getUpdatedBy();
	}

	/**
	* Sets the updated by of this workflow.
	*
	* @param updatedBy the updated by of this workflow
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_workflow.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this workflow.
	*
	* @return the updated date of this workflow
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _workflow.getUpdatedDate();
	}

	/**
	* Sets the updated date of this workflow.
	*
	* @param updatedDate the updated date of this workflow
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_workflow.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _workflow.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workflow.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workflow.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workflow.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workflow.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workflow.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workflow.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workflow.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workflow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workflow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workflow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkflowWrapper((Workflow)_workflow.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.Workflow workflow) {
		return _workflow.compareTo(workflow);
	}

	@Override
	public int hashCode() {
		return _workflow.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.Workflow> toCacheModel() {
		return _workflow.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.Workflow toEscapedModel() {
		return new WorkflowWrapper(_workflow.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.Workflow toUnescapedModel() {
		return new WorkflowWrapper(_workflow.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workflow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workflow.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflow.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkflowWrapper)) {
			return false;
		}

		WorkflowWrapper workflowWrapper = (WorkflowWrapper)obj;

		if (Validator.equals(_workflow, workflowWrapper._workflow)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Workflow getWrappedWorkflow() {
		return _workflow;
	}

	@Override
	public Workflow getWrappedModel() {
		return _workflow;
	}

	@Override
	public void resetOriginalValues() {
		_workflow.resetOriginalValues();
	}

	private Workflow _workflow;
}