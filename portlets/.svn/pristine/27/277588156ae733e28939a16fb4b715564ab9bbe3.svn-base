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
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;

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
public class ErrNotificationClp extends BaseModelImpl<ErrNotification>
	implements ErrNotification {
	public ErrNotificationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ErrNotification.class;
	}

	@Override
	public String getModelClassName() {
		return ErrNotification.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNotificationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _notificationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationId", getNotificationId());
		attributes.put("componentName", getComponentName());
		attributes.put("referenceId", getReferenceId());
		attributes.put("severity", getSeverity());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		String componentName = (String)attributes.get("componentName");

		if (componentName != null) {
			setComponentName(componentName);
		}

		Long referenceId = (Long)attributes.get("referenceId");

		if (referenceId != null) {
			setReferenceId(referenceId);
		}

		String severity = (String)attributes.get("severity");

		if (severity != null) {
			setSeverity(severity);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
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

	@Override
	public long getNotificationId() {
		return _notificationId;
	}

	@Override
	public void setNotificationId(long notificationId) {
		_notificationId = notificationId;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationId", long.class);

				method.invoke(_errNotificationRemoteModel, notificationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComponentName() {
		return _componentName;
	}

	@Override
	public void setComponentName(String componentName) {
		_componentName = componentName;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setComponentName", String.class);

				method.invoke(_errNotificationRemoteModel, componentName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReferenceId() {
		return _referenceId;
	}

	@Override
	public void setReferenceId(long referenceId) {
		_referenceId = referenceId;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setReferenceId", long.class);

				method.invoke(_errNotificationRemoteModel, referenceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeverity() {
		return _severity;
	}

	@Override
	public void setSeverity(String severity) {
		_severity = severity;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setSeverity", String.class);

				method.invoke(_errNotificationRemoteModel, severity);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_errNotificationRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_errNotificationRemoteModel, description);
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

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_errNotificationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_errNotificationRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_regionId = regionId;

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_errNotificationRemoteModel, regionId);
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

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_errNotificationRemoteModel, creatorId);
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

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_errNotificationRemoteModel, createdDate);
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

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_errNotificationRemoteModel, updatedBy);
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

		if (_errNotificationRemoteModel != null) {
			try {
				Class<?> clazz = _errNotificationRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_errNotificationRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getErrNotificationRemoteModel() {
		return _errNotificationRemoteModel;
	}

	public void setErrNotificationRemoteModel(
		BaseModel<?> errNotificationRemoteModel) {
		_errNotificationRemoteModel = errNotificationRemoteModel;
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

		Class<?> remoteModelClass = _errNotificationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_errNotificationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ErrNotificationLocalServiceUtil.addErrNotification(this);
		}
		else {
			ErrNotificationLocalServiceUtil.updateErrNotification(this);
		}
	}

	@Override
	public ErrNotification toEscapedModel() {
		return (ErrNotification)ProxyUtil.newProxyInstance(ErrNotification.class.getClassLoader(),
			new Class[] { ErrNotification.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ErrNotificationClp clone = new ErrNotificationClp();

		clone.setNotificationId(getNotificationId());
		clone.setComponentName(getComponentName());
		clone.setReferenceId(getReferenceId());
		clone.setSeverity(getSeverity());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());
		clone.setPublishId(getPublishId());
		clone.setRegionId(getRegionId());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(ErrNotification errNotification) {
		long primaryKey = errNotification.getPrimaryKey();

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

		if (!(obj instanceof ErrNotificationClp)) {
			return false;
		}

		ErrNotificationClp errNotification = (ErrNotificationClp)obj;

		long primaryKey = errNotification.getPrimaryKey();

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

		sb.append("{notificationId=");
		sb.append(getNotificationId());
		sb.append(", componentName=");
		sb.append(getComponentName());
		sb.append(", referenceId=");
		sb.append(getReferenceId());
		sb.append(", severity=");
		sb.append(getSeverity());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", regionId=");
		sb.append(getRegionId());
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
		sb.append("com.ihg.brandstandards.db.model.ErrNotification");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>notificationId</column-name><column-value><![CDATA[");
		sb.append(getNotificationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>componentName</column-name><column-value><![CDATA[");
		sb.append(getComponentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referenceId</column-name><column-value><![CDATA[");
		sb.append(getReferenceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>severity</column-name><column-value><![CDATA[");
		sb.append(getSeverity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
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

	private long _notificationId;
	private String _componentName;
	private long _referenceId;
	private String _severity;
	private String _title;
	private String _description;
	private String _status;
	private long _publishId;
	private long _regionId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _errNotificationRemoteModel;
}