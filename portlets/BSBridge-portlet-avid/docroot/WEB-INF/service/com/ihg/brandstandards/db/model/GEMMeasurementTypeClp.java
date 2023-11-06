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
import com.ihg.brandstandards.db.service.GEMMeasurementTypeLocalServiceUtil;

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
public class GEMMeasurementTypeClp extends BaseModelImpl<GEMMeasurementType>
	implements GEMMeasurementType {
	public GEMMeasurementTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementType.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementType.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _measurementType;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setMeasurementType(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _measurementType;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("measurementType", getMeasurementType());
		attributes.put("measurementTypeDesc", getMeasurementTypeDesc());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String measurementType = (String)attributes.get("measurementType");

		if (measurementType != null) {
			setMeasurementType(measurementType);
		}

		String measurementTypeDesc = (String)attributes.get(
				"measurementTypeDesc");

		if (measurementTypeDesc != null) {
			setMeasurementTypeDesc(measurementTypeDesc);
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
	public String getMeasurementType() {
		return _measurementType;
	}

	@Override
	public void setMeasurementType(String measurementType) {
		_measurementType = measurementType;

		if (_gemMeasurementTypeRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementType",
						String.class);

				method.invoke(_gemMeasurementTypeRemoteModel, measurementType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMeasurementTypeDesc() {
		return _measurementTypeDesc;
	}

	@Override
	public void setMeasurementTypeDesc(String measurementTypeDesc) {
		_measurementTypeDesc = measurementTypeDesc;

		if (_gemMeasurementTypeRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementTypeDesc",
						String.class);

				method.invoke(_gemMeasurementTypeRemoteModel,
					measurementTypeDesc);
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

		if (_gemMeasurementTypeRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemMeasurementTypeRemoteModel, creatorId);
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

		if (_gemMeasurementTypeRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemMeasurementTypeRemoteModel, createdDate);
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

		if (_gemMeasurementTypeRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemMeasurementTypeRemoteModel, updatedBy);
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

		if (_gemMeasurementTypeRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemMeasurementTypeRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMMeasurementTypeRemoteModel() {
		return _gemMeasurementTypeRemoteModel;
	}

	public void setGEMMeasurementTypeRemoteModel(
		BaseModel<?> gemMeasurementTypeRemoteModel) {
		_gemMeasurementTypeRemoteModel = gemMeasurementTypeRemoteModel;
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

		Class<?> remoteModelClass = _gemMeasurementTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemMeasurementTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMMeasurementTypeLocalServiceUtil.addGEMMeasurementType(this);
		}
		else {
			GEMMeasurementTypeLocalServiceUtil.updateGEMMeasurementType(this);
		}
	}

	@Override
	public GEMMeasurementType toEscapedModel() {
		return (GEMMeasurementType)ProxyUtil.newProxyInstance(GEMMeasurementType.class.getClassLoader(),
			new Class[] { GEMMeasurementType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMMeasurementTypeClp clone = new GEMMeasurementTypeClp();

		clone.setMeasurementType(getMeasurementType());
		clone.setMeasurementTypeDesc(getMeasurementTypeDesc());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMMeasurementType gemMeasurementType) {
		String primaryKey = gemMeasurementType.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMMeasurementTypeClp)) {
			return false;
		}

		GEMMeasurementTypeClp gemMeasurementType = (GEMMeasurementTypeClp)obj;

		String primaryKey = gemMeasurementType.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{measurementType=");
		sb.append(getMeasurementType());
		sb.append(", measurementTypeDesc=");
		sb.append(getMeasurementTypeDesc());
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
		sb.append("com.ihg.brandstandards.db.model.GEMMeasurementType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>measurementType</column-name><column-value><![CDATA[");
		sb.append(getMeasurementType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementTypeDesc</column-name><column-value><![CDATA[");
		sb.append(getMeasurementTypeDesc());
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

	private String _measurementType;
	private String _measurementTypeDesc;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemMeasurementTypeRemoteModel;
}