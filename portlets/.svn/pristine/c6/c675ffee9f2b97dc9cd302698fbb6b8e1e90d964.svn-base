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
import com.ihg.brandstandards.db.service.GEMMeasurementFormulaValueLocalServiceUtil;

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
public class GEMMeasurementFormulaValueClp extends BaseModelImpl<GEMMeasurementFormulaValue>
	implements GEMMeasurementFormulaValue {
	public GEMMeasurementFormulaValueClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementFormulaValue.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementFormulaValue.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _formulaValueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormulaValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formulaValueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formulaValueId", getFormulaValueId());
		attributes.put("formulaId", getFormulaId());
		attributes.put("formulaType", getFormulaType());
		attributes.put("formulaValue", getFormulaValue());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formulaValueId = (Long)attributes.get("formulaValueId");

		if (formulaValueId != null) {
			setFormulaValueId(formulaValueId);
		}

		Long formulaId = (Long)attributes.get("formulaId");

		if (formulaId != null) {
			setFormulaId(formulaId);
		}

		String formulaType = (String)attributes.get("formulaType");

		if (formulaType != null) {
			setFormulaType(formulaType);
		}

		String formulaValue = (String)attributes.get("formulaValue");

		if (formulaValue != null) {
			setFormulaValue(formulaValue);
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
	public long getFormulaValueId() {
		return _formulaValueId;
	}

	@Override
	public void setFormulaValueId(long formulaValueId) {
		_formulaValueId = formulaValueId;

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setFormulaValueId", long.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel,
					formulaValueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFormulaId() {
		return _formulaId;
	}

	@Override
	public void setFormulaId(long formulaId) {
		_formulaId = formulaId;

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setFormulaId", long.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel, formulaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormulaType() {
		return _formulaType;
	}

	@Override
	public void setFormulaType(String formulaType) {
		_formulaType = formulaType;

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setFormulaType", String.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel,
					formulaType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormulaValue() {
		return _formulaValue;
	}

	@Override
	public void setFormulaValue(String formulaValue) {
		_formulaValue = formulaValue;

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setFormulaValue", String.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel,
					formulaValue);
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

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel, creatorId);
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

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel,
					createdDate);
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

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel, updatedBy);
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

		if (_gemMeasurementFormulaValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaValueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemMeasurementFormulaValueRemoteModel,
					updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMMeasurementFormulaValueRemoteModel() {
		return _gemMeasurementFormulaValueRemoteModel;
	}

	public void setGEMMeasurementFormulaValueRemoteModel(
		BaseModel<?> gemMeasurementFormulaValueRemoteModel) {
		_gemMeasurementFormulaValueRemoteModel = gemMeasurementFormulaValueRemoteModel;
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

		Class<?> remoteModelClass = _gemMeasurementFormulaValueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemMeasurementFormulaValueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMMeasurementFormulaValueLocalServiceUtil.addGEMMeasurementFormulaValue(this);
		}
		else {
			GEMMeasurementFormulaValueLocalServiceUtil.updateGEMMeasurementFormulaValue(this);
		}
	}

	@Override
	public GEMMeasurementFormulaValue toEscapedModel() {
		return (GEMMeasurementFormulaValue)ProxyUtil.newProxyInstance(GEMMeasurementFormulaValue.class.getClassLoader(),
			new Class[] { GEMMeasurementFormulaValue.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMMeasurementFormulaValueClp clone = new GEMMeasurementFormulaValueClp();

		clone.setFormulaValueId(getFormulaValueId());
		clone.setFormulaId(getFormulaId());
		clone.setFormulaType(getFormulaType());
		clone.setFormulaValue(getFormulaValue());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		long primaryKey = gemMeasurementFormulaValue.getPrimaryKey();

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

		if (!(obj instanceof GEMMeasurementFormulaValueClp)) {
			return false;
		}

		GEMMeasurementFormulaValueClp gemMeasurementFormulaValue = (GEMMeasurementFormulaValueClp)obj;

		long primaryKey = gemMeasurementFormulaValue.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{formulaValueId=");
		sb.append(getFormulaValueId());
		sb.append(", formulaId=");
		sb.append(getFormulaId());
		sb.append(", formulaType=");
		sb.append(getFormulaType());
		sb.append(", formulaValue=");
		sb.append(getFormulaValue());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formulaValueId</column-name><column-value><![CDATA[");
		sb.append(getFormulaValueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formulaId</column-name><column-value><![CDATA[");
		sb.append(getFormulaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formulaType</column-name><column-value><![CDATA[");
		sb.append(getFormulaType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formulaValue</column-name><column-value><![CDATA[");
		sb.append(getFormulaValue());
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

	private long _formulaValueId;
	private long _formulaId;
	private String _formulaType;
	private String _formulaValue;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemMeasurementFormulaValueRemoteModel;
}