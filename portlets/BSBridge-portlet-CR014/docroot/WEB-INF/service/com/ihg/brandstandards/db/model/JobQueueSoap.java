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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ihg.brandstandards.db.service.http.JobQueueServiceSoap}.
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.http.JobQueueServiceSoap
 * @generated
 */
public class JobQueueSoap implements Serializable {
	public static JobQueueSoap toSoapModel(JobQueue model) {
		JobQueueSoap soapModel = new JobQueueSoap();

		soapModel.setJobId(model.getJobId());
		soapModel.setJobOwner(model.getJobOwner());
		soapModel.setJobType(model.getJobType());
		soapModel.setMetadata(model.getMetadata());
		soapModel.setLink(model.getLink());
		soapModel.setNotificationEmail(model.getNotificationEmail());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static JobQueueSoap[] toSoapModels(JobQueue[] models) {
		JobQueueSoap[] soapModels = new JobQueueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobQueueSoap[][] toSoapModels(JobQueue[][] models) {
		JobQueueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobQueueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobQueueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobQueueSoap[] toSoapModels(List<JobQueue> models) {
		List<JobQueueSoap> soapModels = new ArrayList<JobQueueSoap>(models.size());

		for (JobQueue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobQueueSoap[soapModels.size()]);
	}

	public JobQueueSoap() {
	}

	public long getPrimaryKey() {
		return _jobId;
	}

	public void setPrimaryKey(long pk) {
		setJobId(pk);
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
	}

	public String getJobOwner() {
		return _jobOwner;
	}

	public void setJobOwner(String jobOwner) {
		_jobOwner = jobOwner;
	}

	public String getJobType() {
		return _jobType;
	}

	public void setJobType(String jobType) {
		_jobType = jobType;
	}

	public String getMetadata() {
		return _metadata;
	}

	public void setMetadata(String metadata) {
		_metadata = metadata;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getNotificationEmail() {
		return _notificationEmail;
	}

	public void setNotificationEmail(String notificationEmail) {
		_notificationEmail = notificationEmail;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return _updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	private long _jobId;
	private String _jobOwner;
	private String _jobType;
	private String _metadata;
	private String _link;
	private String _notificationEmail;
	private Date _startTime;
	private Date _endTime;
	private String _status;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}