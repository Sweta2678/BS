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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.JobQueue;
import com.ihg.brandstandards.db.model.JobQueueModel;
import com.ihg.brandstandards.db.model.JobQueueSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the JobQueue service. Represents a row in the &quot;JOB_QUEUE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.JobQueueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JobQueueImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see JobQueueImpl
 * @see com.ihg.brandstandards.db.model.JobQueue
 * @see com.ihg.brandstandards.db.model.JobQueueModel
 * @generated
 */
@JSON(strict = true)
public class JobQueueModelImpl extends BaseModelImpl<JobQueue>
	implements JobQueueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a job queue model instance should use the {@link com.ihg.brandstandards.db.model.JobQueue} interface instead.
	 */
	public static final String TABLE_NAME = "JOB_QUEUE";
	public static final Object[][] TABLE_COLUMNS = {
			{ "JOB_ID", Types.BIGINT },
			{ "JOB_OWNER", Types.VARCHAR },
			{ "JOB_TYP", Types.VARCHAR },
			{ "METADATA_TXT", Types.VARCHAR },
			{ "LINK_TXT", Types.VARCHAR },
			{ "NOTIFICAtiON_EMAIL_ID", Types.VARCHAR },
			{ "STRT_TS", Types.TIMESTAMP },
			{ "END_TS", Types.TIMESTAMP },
			{ "STAT_CD", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table JOB_QUEUE (JOB_ID LONG not null primary key,JOB_OWNER VARCHAR(75) null,JOB_TYP VARCHAR(75) null,METADATA_TXT VARCHAR(75) null,LINK_TXT VARCHAR(75) null,NOTIFICAtiON_EMAIL_ID VARCHAR(75) null,STRT_TS DATE null,END_TS DATE null,STAT_CD VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table JOB_QUEUE";
	public static final String ORDER_BY_JPQL = " ORDER BY jobQueue.jobId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY JOB_QUEUE.JOB_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.JobQueue"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.JobQueue"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.JobQueue"),
			true);
	public static long JOBID_COLUMN_BITMASK = 1L;
	public static long JOBOWNER_COLUMN_BITMASK = 2L;
	public static long JOBTYPE_COLUMN_BITMASK = 4L;
	public static long STATUS_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static JobQueue toModel(JobQueueSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		JobQueue model = new JobQueueImpl();

		model.setJobId(soapModel.getJobId());
		model.setJobOwner(soapModel.getJobOwner());
		model.setJobType(soapModel.getJobType());
		model.setMetadata(soapModel.getMetadata());
		model.setLink(soapModel.getLink());
		model.setNotificationEmail(soapModel.getNotificationEmail());
		model.setStartTime(soapModel.getStartTime());
		model.setEndTime(soapModel.getEndTime());
		model.setStatus(soapModel.getStatus());
		model.setCreatorId(soapModel.getCreatorId());
		model.setCreatedDate(soapModel.getCreatedDate());
		model.setUpdatedBy(soapModel.getUpdatedBy());
		model.setUpdatedDate(soapModel.getUpdatedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<JobQueue> toModels(JobQueueSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<JobQueue> models = new ArrayList<JobQueue>(soapModels.length);

		for (JobQueueSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.JobQueue"));

	public JobQueueModelImpl() {
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

	@JSON
	@Override
	public long getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(long jobId) {
		_columnBitmask |= JOBID_COLUMN_BITMASK;

		if (!_setOriginalJobId) {
			_setOriginalJobId = true;

			_originalJobId = _jobId;
		}

		_jobId = jobId;
	}

	public long getOriginalJobId() {
		return _originalJobId;
	}

	@JSON
	@Override
	public String getJobOwner() {
		if (_jobOwner == null) {
			return StringPool.BLANK;
		}
		else {
			return _jobOwner;
		}
	}

	@Override
	public void setJobOwner(String jobOwner) {
		_columnBitmask |= JOBOWNER_COLUMN_BITMASK;

		if (_originalJobOwner == null) {
			_originalJobOwner = _jobOwner;
		}

		_jobOwner = jobOwner;
	}

	public String getOriginalJobOwner() {
		return GetterUtil.getString(_originalJobOwner);
	}

	@JSON
	@Override
	public String getJobType() {
		if (_jobType == null) {
			return StringPool.BLANK;
		}
		else {
			return _jobType;
		}
	}

	@Override
	public void setJobType(String jobType) {
		_columnBitmask |= JOBTYPE_COLUMN_BITMASK;

		if (_originalJobType == null) {
			_originalJobType = _jobType;
		}

		_jobType = jobType;
	}

	public String getOriginalJobType() {
		return GetterUtil.getString(_originalJobType);
	}

	@JSON
	@Override
	public String getMetadata() {
		if (_metadata == null) {
			return StringPool.BLANK;
		}
		else {
			return _metadata;
		}
	}

	@Override
	public void setMetadata(String metadata) {
		_metadata = metadata;
	}

	@JSON
	@Override
	public String getLink() {
		if (_link == null) {
			return StringPool.BLANK;
		}
		else {
			return _link;
		}
	}

	@Override
	public void setLink(String link) {
		_link = link;
	}

	@JSON
	@Override
	public String getNotificationEmail() {
		if (_notificationEmail == null) {
			return StringPool.BLANK;
		}
		else {
			return _notificationEmail;
		}
	}

	@Override
	public void setNotificationEmail(String notificationEmail) {
		_notificationEmail = notificationEmail;
	}

	@JSON
	@Override
	public Date getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	@JSON
	@Override
	public Date getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (_originalStatus == null) {
			_originalStatus = _status;
		}

		_status = status;
	}

	public String getOriginalStatus() {
		return GetterUtil.getString(_originalStatus);
	}

	@JSON
	@Override
	public String getCreatorId() {
		if (_creatorId == null) {
			return StringPool.BLANK;
		}
		else {
			return _creatorId;
		}
	}

	@Override
	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;
	}

	@JSON
	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@JSON
	@Override
	public String getUpdatedBy() {
		if (_updatedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _updatedBy;
		}
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	@JSON
	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			JobQueue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JobQueue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (JobQueue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		JobQueueImpl jobQueueImpl = new JobQueueImpl();

		jobQueueImpl.setJobId(getJobId());
		jobQueueImpl.setJobOwner(getJobOwner());
		jobQueueImpl.setJobType(getJobType());
		jobQueueImpl.setMetadata(getMetadata());
		jobQueueImpl.setLink(getLink());
		jobQueueImpl.setNotificationEmail(getNotificationEmail());
		jobQueueImpl.setStartTime(getStartTime());
		jobQueueImpl.setEndTime(getEndTime());
		jobQueueImpl.setStatus(getStatus());
		jobQueueImpl.setCreatorId(getCreatorId());
		jobQueueImpl.setCreatedDate(getCreatedDate());
		jobQueueImpl.setUpdatedBy(getUpdatedBy());
		jobQueueImpl.setUpdatedDate(getUpdatedDate());

		jobQueueImpl.resetOriginalValues();

		return jobQueueImpl;
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

		if (!(obj instanceof JobQueue)) {
			return false;
		}

		JobQueue jobQueue = (JobQueue)obj;

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
	public void resetOriginalValues() {
		JobQueueModelImpl jobQueueModelImpl = this;

		jobQueueModelImpl._originalJobId = jobQueueModelImpl._jobId;

		jobQueueModelImpl._setOriginalJobId = false;

		jobQueueModelImpl._originalJobOwner = jobQueueModelImpl._jobOwner;

		jobQueueModelImpl._originalJobType = jobQueueModelImpl._jobType;

		jobQueueModelImpl._originalStatus = jobQueueModelImpl._status;

		jobQueueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JobQueue> toCacheModel() {
		JobQueueCacheModel jobQueueCacheModel = new JobQueueCacheModel();

		jobQueueCacheModel.jobId = getJobId();

		jobQueueCacheModel.jobOwner = getJobOwner();

		String jobOwner = jobQueueCacheModel.jobOwner;

		if ((jobOwner != null) && (jobOwner.length() == 0)) {
			jobQueueCacheModel.jobOwner = null;
		}

		jobQueueCacheModel.jobType = getJobType();

		String jobType = jobQueueCacheModel.jobType;

		if ((jobType != null) && (jobType.length() == 0)) {
			jobQueueCacheModel.jobType = null;
		}

		jobQueueCacheModel.metadata = getMetadata();

		String metadata = jobQueueCacheModel.metadata;

		if ((metadata != null) && (metadata.length() == 0)) {
			jobQueueCacheModel.metadata = null;
		}

		jobQueueCacheModel.link = getLink();

		String link = jobQueueCacheModel.link;

		if ((link != null) && (link.length() == 0)) {
			jobQueueCacheModel.link = null;
		}

		jobQueueCacheModel.notificationEmail = getNotificationEmail();

		String notificationEmail = jobQueueCacheModel.notificationEmail;

		if ((notificationEmail != null) && (notificationEmail.length() == 0)) {
			jobQueueCacheModel.notificationEmail = null;
		}

		Date startTime = getStartTime();

		if (startTime != null) {
			jobQueueCacheModel.startTime = startTime.getTime();
		}
		else {
			jobQueueCacheModel.startTime = Long.MIN_VALUE;
		}

		Date endTime = getEndTime();

		if (endTime != null) {
			jobQueueCacheModel.endTime = endTime.getTime();
		}
		else {
			jobQueueCacheModel.endTime = Long.MIN_VALUE;
		}

		jobQueueCacheModel.status = getStatus();

		String status = jobQueueCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			jobQueueCacheModel.status = null;
		}

		jobQueueCacheModel.creatorId = getCreatorId();

		String creatorId = jobQueueCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			jobQueueCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			jobQueueCacheModel.createdDate = createdDate.getTime();
		}
		else {
			jobQueueCacheModel.createdDate = Long.MIN_VALUE;
		}

		jobQueueCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = jobQueueCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			jobQueueCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			jobQueueCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			jobQueueCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return jobQueueCacheModel;
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

	private static ClassLoader _classLoader = JobQueue.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			JobQueue.class
		};
	private long _jobId;
	private long _originalJobId;
	private boolean _setOriginalJobId;
	private String _jobOwner;
	private String _originalJobOwner;
	private String _jobType;
	private String _originalJobType;
	private String _metadata;
	private String _link;
	private String _notificationEmail;
	private Date _startTime;
	private Date _endTime;
	private String _status;
	private String _originalStatus;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private JobQueue _escapedModel;
}