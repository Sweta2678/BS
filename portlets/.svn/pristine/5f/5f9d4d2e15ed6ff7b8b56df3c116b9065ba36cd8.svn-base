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
import com.ihg.brandstandards.db.service.GEMMeasurementLocalServiceUtil;

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
public class GEMMeasurementClp extends BaseModelImpl<GEMMeasurement>
	implements GEMMeasurement {
	public GEMMeasurementClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurement.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurement.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _measurementId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMeasurementId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _measurementId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("measurementId", getMeasurementId());
		attributes.put("measurementName", getMeasurementName());
		attributes.put("measurementType", getMeasurementType());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("templateId", getTemplateId());
		attributes.put("multiplierQty", getMultiplierQty());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long measurementId = (Long)attributes.get("measurementId");

		if (measurementId != null) {
			setMeasurementId(measurementId);
		}

		String measurementName = (String)attributes.get("measurementName");

		if (measurementName != null) {
			setMeasurementName(measurementName);
		}

		String measurementType = (String)attributes.get("measurementType");

		if (measurementType != null) {
			setMeasurementType(measurementType);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long multiplierQty = (Long)attributes.get("multiplierQty");

		if (multiplierQty != null) {
			setMultiplierQty(multiplierQty);
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
	public long getMeasurementId() {
		return _measurementId;
	}

	@Override
	public void setMeasurementId(long measurementId) {
		_measurementId = measurementId;

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementId", long.class);

				method.invoke(_gemMeasurementRemoteModel, measurementId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasurementName() {
		return _measurementName;
	}

	@Override
	public void setMeasurementName(String measurementName) {
		_measurementName = measurementName;

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementName",
						String.class);

				method.invoke(_gemMeasurementRemoteModel, measurementName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasurementType() {
		return _measurementType;
	}

	@Override
	public void setMeasurementType(String measurementType) {
		_measurementType = measurementType;

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementType",
						String.class);

				method.invoke(_gemMeasurementRemoteModel, measurementType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemMeasurementRemoteModel, displayOrderNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_templateId = templateId;

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_gemMeasurementRemoteModel, templateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMultiplierQty() {
		return _multiplierQty;
	}

	@Override
	public void setMultiplierQty(long multiplierQty) {
		_multiplierQty = multiplierQty;

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setMultiplierQty", long.class);

				method.invoke(_gemMeasurementRemoteModel, multiplierQty);
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

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemMeasurementRemoteModel, creatorId);
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

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemMeasurementRemoteModel, createdDate);
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

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemMeasurementRemoteModel, updatedBy);
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

		if (_gemMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemMeasurementRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMMeasurementRemoteModel() {
		return _gemMeasurementRemoteModel;
	}

	public void setGEMMeasurementRemoteModel(
		BaseModel<?> gemMeasurementRemoteModel) {
		_gemMeasurementRemoteModel = gemMeasurementRemoteModel;
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

		Class<?> remoteModelClass = _gemMeasurementRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemMeasurementRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMMeasurementLocalServiceUtil.addGEMMeasurement(this);
		}
		else {
			GEMMeasurementLocalServiceUtil.updateGEMMeasurement(this);
		}
	}

	@Override
	public GEMMeasurement toEscapedModel() {
		return (GEMMeasurement)ProxyUtil.newProxyInstance(GEMMeasurement.class.getClassLoader(),
			new Class[] { GEMMeasurement.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMMeasurementClp clone = new GEMMeasurementClp();

		clone.setMeasurementId(getMeasurementId());
		clone.setMeasurementName(getMeasurementName());
		clone.setMeasurementType(getMeasurementType());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setTemplateId(getTemplateId());
		clone.setMultiplierQty(getMultiplierQty());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMMeasurement gemMeasurement) {
		int value = 0;

		if (getDisplayOrderNumber() < gemMeasurement.getDisplayOrderNumber()) {
			value = -1;
		}
		else if (getDisplayOrderNumber() > gemMeasurement.getDisplayOrderNumber()) {
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

		if (!(obj instanceof GEMMeasurementClp)) {
			return false;
		}

		GEMMeasurementClp gemMeasurement = (GEMMeasurementClp)obj;

		long primaryKey = gemMeasurement.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{measurementId=");
		sb.append(getMeasurementId());
		sb.append(", measurementName=");
		sb.append(getMeasurementName());
		sb.append(", measurementType=");
		sb.append(getMeasurementType());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", multiplierQty=");
		sb.append(getMultiplierQty());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMMeasurement");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>measurementId</column-name><column-value><![CDATA[");
		sb.append(getMeasurementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementName</column-name><column-value><![CDATA[");
		sb.append(getMeasurementName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementType</column-name><column-value><![CDATA[");
		sb.append(getMeasurementType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>multiplierQty</column-name><column-value><![CDATA[");
		sb.append(getMultiplierQty());
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

	private long _measurementId;
	private String _measurementName;
	private String _measurementType;
	private long _displayOrderNumber;
	private long _templateId;
	private long _multiplierQty;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemMeasurementRemoteModel;
}