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
import com.ihg.brandstandards.db.service.GEMSeverityLocalServiceUtil;

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
public class GEMSeverityClp extends BaseModelImpl<GEMSeverity>
	implements GEMSeverity {
	public GEMSeverityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMSeverity.class;
	}

	@Override
	public String getModelClassName() {
		return GEMSeverity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _severityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSeverityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _severityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("severityId", getSeverityId());
		attributes.put("severityName", getSeverityName());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long severityId = (Long)attributes.get("severityId");

		if (severityId != null) {
			setSeverityId(severityId);
		}

		String severityName = (String)attributes.get("severityName");

		if (severityName != null) {
			setSeverityName(severityName);
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
	public long getSeverityId() {
		return _severityId;
	}

	@Override
	public void setSeverityId(long severityId) {
		_severityId = severityId;

		if (_gemSeverityRemoteModel != null) {
			try {
				Class<?> clazz = _gemSeverityRemoteModel.getClass();

				Method method = clazz.getMethod("setSeverityId", long.class);

				method.invoke(_gemSeverityRemoteModel, severityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSeverityName() {
		return _severityName;
	}

	@Override
	public void setSeverityName(String severityName) {
		_severityName = severityName;

		if (_gemSeverityRemoteModel != null) {
			try {
				Class<?> clazz = _gemSeverityRemoteModel.getClass();

				Method method = clazz.getMethod("setSeverityName", String.class);

				method.invoke(_gemSeverityRemoteModel, severityName);
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

		if (_gemSeverityRemoteModel != null) {
			try {
				Class<?> clazz = _gemSeverityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemSeverityRemoteModel, creatorId);
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

		if (_gemSeverityRemoteModel != null) {
			try {
				Class<?> clazz = _gemSeverityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemSeverityRemoteModel, createdDate);
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

		if (_gemSeverityRemoteModel != null) {
			try {
				Class<?> clazz = _gemSeverityRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemSeverityRemoteModel, updatedBy);
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

		if (_gemSeverityRemoteModel != null) {
			try {
				Class<?> clazz = _gemSeverityRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemSeverityRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMSeverityRemoteModel() {
		return _gemSeverityRemoteModel;
	}

	public void setGEMSeverityRemoteModel(BaseModel<?> gemSeverityRemoteModel) {
		_gemSeverityRemoteModel = gemSeverityRemoteModel;
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

		Class<?> remoteModelClass = _gemSeverityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemSeverityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMSeverityLocalServiceUtil.addGEMSeverity(this);
		}
		else {
			GEMSeverityLocalServiceUtil.updateGEMSeverity(this);
		}
	}

	@Override
	public GEMSeverity toEscapedModel() {
		return (GEMSeverity)ProxyUtil.newProxyInstance(GEMSeverity.class.getClassLoader(),
			new Class[] { GEMSeverity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMSeverityClp clone = new GEMSeverityClp();

		clone.setSeverityId(getSeverityId());
		clone.setSeverityName(getSeverityName());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMSeverity gemSeverity) {
		int value = 0;

		if (getSeverityId() < gemSeverity.getSeverityId()) {
			value = -1;
		}
		else if (getSeverityId() > gemSeverity.getSeverityId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMSeverityClp)) {
			return false;
		}

		GEMSeverityClp gemSeverity = (GEMSeverityClp)obj;

		long primaryKey = gemSeverity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{severityId=");
		sb.append(getSeverityId());
		sb.append(", severityName=");
		sb.append(getSeverityName());
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
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMSeverity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>severityId</column-name><column-value><![CDATA[");
		sb.append(getSeverityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>severityName</column-name><column-value><![CDATA[");
		sb.append(getSeverityName());
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

	private long _severityId;
	private String _severityName;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemSeverityRemoteModel;
}