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

import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class JobQueueClp extends BaseModelImpl<JobQueue> implements JobQueue {
	public JobQueueClp() {
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
	public long getPrimaryKey() {
		return _jobId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJobId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(long jobId) {
		_jobId = jobId;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setJobId", long.class);

				method.invoke(_jobQueueRemoteModel, jobId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobOwner() {
		return _jobOwner;
	}

	@Override
	public void setJobOwner(String jobOwner) {
		_jobOwner = jobOwner;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setJobOwner", String.class);

				method.invoke(_jobQueueRemoteModel, jobOwner);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobType() {
		return _jobType;
	}

	@Override
	public void setJobType(String jobType) {
		_jobType = jobType;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setJobType", String.class);

				method.invoke(_jobQueueRemoteModel, jobType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMetadata() {
		return _metadata;
	}

	@Override
	public void setMetadata(String metadata) {
		_metadata = metadata;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setMetadata", String.class);

				method.invoke(_jobQueueRemoteModel, metadata);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLink() {
		return _link;
	}

	@Override
	public void setLink(String link) {
		_link = link;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setLink", String.class);

				method.invoke(_jobQueueRemoteModel, link);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotificationEmail() {
		return _notificationEmail;
	}

	@Override
	public void setNotificationEmail(String notificationEmail) {
		_notificationEmail = notificationEmail;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationEmail",
						String.class);

				method.invoke(_jobQueueRemoteModel, notificationEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", Date.class);

				method.invoke(_jobQueueRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", Date.class);

				method.invoke(_jobQueueRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_jobQueueRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_jobQueueRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_jobQueueRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdatedBy() {
		return _updatedBy;
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_jobQueueRemoteModel, updatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;

		if (_jobQueueRemoteModel != null) {
			try {
				Class<?> clazz = _jobQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_jobQueueRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJobQueueRemoteModel() {
		return _jobQueueRemoteModel;
	}

	public void setJobQueueRemoteModel(BaseModel<?> jobQueueRemoteModel) {
		_jobQueueRemoteModel = jobQueueRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _jobQueueRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_jobQueueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JobQueueLocalServiceUtil.addJobQueue(this);
		}
		else {
			JobQueueLocalServiceUtil.updateJobQueue(this);
		}
	}

	@Override
	public JobQueue toEscapedModel() {
		return (JobQueue)ProxyUtil.newProxyInstance(JobQueue.class.getClassLoader(),
			new Class[] { JobQueue.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JobQueueClp clone = new JobQueueClp();

		clone.setJobId(getJobId());
		clone.setJobOwner(getJobOwner());
		clone.setJobType(getJobType());
		clone.setMetadata(getMetadata());
		clone.setLink(getLink());
		clone.setNotificationEmail(getNotificationEmail());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setStatus(getStatus());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(JobQueue jobQueue) {
		long primaryKey = jobQueue.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobQueueClp)) {
			return false;
		}

		JobQueueClp jobQueue = (JobQueueClp)obj;

		long primaryKey = jobQueue.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{jobId=");
		sb.append(getJobId());
		sb.append(", jobOwner=");
		sb.append(getJobOwner());
		sb.append(", jobType=");
		sb.append(getJobType());
		sb.append(", metadata=");
		sb.append(getMetadata());
		sb.append(", link=");
		sb.append(getLink());
		sb.append(", notificationEmail=");
		sb.append(getNotificationEmail());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.JobQueue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobOwner</column-name><column-value><![CDATA[");
		sb.append(getJobOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobType</column-name><column-value><![CDATA[");
		sb.append(getJobType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>metadata</column-name><column-value><![CDATA[");
		sb.append(getMetadata());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>link</column-name><column-value><![CDATA[");
		sb.append(getLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationEmail</column-name><column-value><![CDATA[");
		sb.append(getNotificationEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedDate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _jobQueueRemoteModel;
}