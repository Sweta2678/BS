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
 * This class is a wrapper for {@link JobQueue}.
 * </p>
 *
 * @author Mummanedi
 * @see JobQueue
 * @generated
 */
public class JobQueueWrapper implements JobQueue, ModelWrapper<JobQueue> {
	public JobQueueWrapper(JobQueue jobQueue) {
		_jobQueue = jobQueue;
	}

	@Override
	public Class<?> getModelClass() {
		return JobQueue.class;
	}

	@Override
	public String getModelClassName() {
		return JobQueue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobId", getJobId());
		attributes.put("jobOwner", getJobOwner());
		attributes.put("jobType", getJobType());
		attributes.put("metadata", getMetadata());
		attributes.put("link", getLink());
		attributes.put("notificationEmail", getNotificationEmail());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("status", getStatus());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		String jobOwner = (String)attributes.get("jobOwner");

		if (jobOwner != null) {
			setJobOwner(jobOwner);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}

		String metadata = (String)attributes.get("metadata");

		if (metadata != null) {
			setMetadata(metadata);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String notificationEmail = (String)attributes.get("notificationEmail");

		if (notificationEmail != null) {
			setNotificationEmail(notificationEmail);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	* Returns the primary key of this job queue.
	*
	* @return the primary key of this job queue
	*/
	@Override
	public long getPrimaryKey() {
		return _jobQueue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job queue.
	*
	* @param primaryKey the primary key of this job queue
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobQueue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job ID of this job queue.
	*
	* @return the job ID of this job queue
	*/
	@Override
	public long getJobId() {
		return _jobQueue.getJobId();
	}

	/**
	* Sets the job ID of this job queue.
	*
	* @param jobId the job ID of this job queue
	*/
	@Override
	public void setJobId(long jobId) {
		_jobQueue.setJobId(jobId);
	}

	/**
	* Returns the job owner of this job queue.
	*
	* @return the job owner of this job queue
	*/
	@Override
	public java.lang.String getJobOwner() {
		return _jobQueue.getJobOwner();
	}

	/**
	* Sets the job owner of this job queue.
	*
	* @param jobOwner the job owner of this job queue
	*/
	@Override
	public void setJobOwner(java.lang.String jobOwner) {
		_jobQueue.setJobOwner(jobOwner);
	}

	/**
	* Returns the job type of this job queue.
	*
	* @return the job type of this job queue
	*/
	@Override
	public java.lang.String getJobType() {
		return _jobQueue.getJobType();
	}

	/**
	* Sets the job type of this job queue.
	*
	* @param jobType the job type of this job queue
	*/
	@Override
	public void setJobType(java.lang.String jobType) {
		_jobQueue.setJobType(jobType);
	}

	/**
	* Returns the metadata of this job queue.
	*
	* @return the metadata of this job queue
	*/
	@Override
	public java.lang.String getMetadata() {
		return _jobQueue.getMetadata();
	}

	/**
	* Sets the metadata of this job queue.
	*
	* @param metadata the metadata of this job queue
	*/
	@Override
	public void setMetadata(java.lang.String metadata) {
		_jobQueue.setMetadata(metadata);
	}

	/**
	* Returns the link of this job queue.
	*
	* @return the link of this job queue
	*/
	@Override
	public java.lang.String getLink() {
		return _jobQueue.getLink();
	}

	/**
	* Sets the link of this job queue.
	*
	* @param link the link of this job queue
	*/
	@Override
	public void setLink(java.lang.String link) {
		_jobQueue.setLink(link);
	}

	/**
	* Returns the notification email of this job queue.
	*
	* @return the notification email of this job queue
	*/
	@Override
	public java.lang.String getNotificationEmail() {
		return _jobQueue.getNotificationEmail();
	}

	/**
	* Sets the notification email of this job queue.
	*
	* @param notificationEmail the notification email of this job queue
	*/
	@Override
	public void setNotificationEmail(java.lang.String notificationEmail) {
		_jobQueue.setNotificationEmail(notificationEmail);
	}

	/**
	* Returns the start time of this job queue.
	*
	* @return the start time of this job queue
	*/
	@Override
	public java.util.Date getStartTime() {
		return _jobQueue.getStartTime();
	}

	/**
	* Sets the start time of this job queue.
	*
	* @param startTime the start time of this job queue
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_jobQueue.setStartTime(startTime);
	}

	/**
	* Returns the end time of this job queue.
	*
	* @return the end time of this job queue
	*/
	@Override
	public java.util.Date getEndTime() {
		return _jobQueue.getEndTime();
	}

	/**
	* Sets the end time of this job queue.
	*
	* @param endTime the end time of this job queue
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_jobQueue.setEndTime(endTime);
	}

	/**
	* Returns the status of this job queue.
	*
	* @return the status of this job queue
	*/
	@Override
	public java.lang.String getStatus() {
		return _jobQueue.getStatus();
	}

	/**
	* Sets the status of this job queue.
	*
	* @param status the status of this job queue
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_jobQueue.setStatus(status);
	}

	/**
	* Returns the creator ID of this job queue.
	*
	* @return the creator ID of this job queue
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _jobQueue.getCreatorId();
	}

	/**
	* Sets the creator ID of this job queue.
	*
	* @param creatorId the creator ID of this job queue
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_jobQueue.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this job queue.
	*
	* @return the created date of this job queue
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _jobQueue.getCreatedDate();
	}

	/**
	* Sets the created date of this job queue.
	*
	* @param createdDate the created date of this job queue
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_jobQueue.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this job queue.
	*
	* @return the updated by of this job queue
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _jobQueue.getUpdatedBy();
	}

	/**
	* Sets the updated by of this job queue.
	*
	* @param updatedBy the updated by of this job queue
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_jobQueue.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this job queue.
	*
	* @return the updated date of this job queue
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _jobQueue.getUpdatedDate();
	}

	/**
	* Sets the updated date of this job queue.
	*
	* @param updatedDate the updated date of this job queue
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_jobQueue.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _jobQueue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jobQueue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jobQueue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobQueue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jobQueue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jobQueue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jobQueue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jobQueue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jobQueue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jobQueue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jobQueue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobQueueWrapper((JobQueue)_jobQueue.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.JobQueue jobQueue) {
		return _jobQueue.compareTo(jobQueue);
	}

	@Override
	public int hashCode() {
		return _jobQueue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.JobQueue> toCacheModel() {
		return _jobQueue.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.JobQueue toEscapedModel() {
		return new JobQueueWrapper(_jobQueue.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.JobQueue toUnescapedModel() {
		return new JobQueueWrapper(_jobQueue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jobQueue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jobQueue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobQueue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobQueueWrapper)) {
			return false;
		}

		JobQueueWrapper jobQueueWrapper = (JobQueueWrapper)obj;

		if (Validator.equals(_jobQueue, jobQueueWrapper._jobQueue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JobQueue getWrappedJobQueue() {
		return _jobQueue;
	}

	@Override
	public JobQueue getWrappedModel() {
		return _jobQueue;
	}

	@Override
	public void resetOriginalValues() {
		_jobQueue.resetOriginalValues();
	}

	private JobQueue _jobQueue;
}