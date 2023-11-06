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
import com.ihg.brandstandards.db.service.GEMTemplateColumnLocalServiceUtil;

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
public class GEMTemplateColumnClp extends BaseModelImpl<GEMTemplateColumn>
	implements GEMTemplateColumn {
	public GEMTemplateColumnClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplateColumn.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplateColumn.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _columnId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setColumnId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _columnId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("columnId", getColumnId());
		attributes.put("templateId", getTemplateId());
		attributes.put("columnName", getColumnName());
		attributes.put("valueType", getValueType());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("isMandatory", getIsMandatory());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long columnId = (Long)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String columnName = (String)attributes.get("columnName");

		if (columnName != null) {
			setColumnName(columnName);
		}

		String valueType = (String)attributes.get("valueType");

		if (valueType != null) {
			setValueType(valueType);
		}

		String defaultValue = (String)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}

		String isMandatory = (String)attributes.get("isMandatory");

		if (isMandatory != null) {
			setIsMandatory(isMandatory);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
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
	public long getColumnId() {
		return _columnId;
	}

	@Override
	public void setColumnId(long columnId) {
		_columnId = columnId;

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnId", long.class);

				method.invoke(_gemTemplateColumnRemoteModel, columnId);
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

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_gemTemplateColumnRemoteModel, templateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumnName() {
		return _columnName;
	}

	@Override
	public void setColumnName(String columnName) {
		_columnName = columnName;

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnName", String.class);

				method.invoke(_gemTemplateColumnRemoteModel, columnName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValueType() {
		return _valueType;
	}

	@Override
	public void setValueType(String valueType) {
		_valueType = valueType;

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setValueType", String.class);

				method.invoke(_gemTemplateColumnRemoteModel, valueType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDefaultValue() {
		return _defaultValue;
	}

	@Override
	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultValue", String.class);

				method.invoke(_gemTemplateColumnRemoteModel, defaultValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsMandatory() {
		return _isMandatory;
	}

	@Override
	public void setIsMandatory(String isMandatory) {
		_isMandatory = isMandatory;

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setIsMandatory", String.class);

				method.invoke(_gemTemplateColumnRemoteModel, isMandatory);
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

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemTemplateColumnRemoteModel, displayOrderNumber);
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

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemTemplateColumnRemoteModel, creatorId);
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

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemTemplateColumnRemoteModel, createdDate);
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

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemTemplateColumnRemoteModel, updatedBy);
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

		if (_gemTemplateColumnRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateColumnRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemTemplateColumnRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMTemplateColumnRemoteModel() {
		return _gemTemplateColumnRemoteModel;
	}

	public void setGEMTemplateColumnRemoteModel(
		BaseModel<?> gemTemplateColumnRemoteModel) {
		_gemTemplateColumnRemoteModel = gemTemplateColumnRemoteModel;
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

		Class<?> remoteModelClass = _gemTemplateColumnRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemTemplateColumnRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMTemplateColumnLocalServiceUtil.addGEMTemplateColumn(this);
		}
		else {
			GEMTemplateColumnLocalServiceUtil.updateGEMTemplateColumn(this);
		}
	}

	@Override
	public GEMTemplateColumn toEscapedModel() {
		return (GEMTemplateColumn)ProxyUtil.newProxyInstance(GEMTemplateColumn.class.getClassLoader(),
			new Class[] { GEMTemplateColumn.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMTemplateColumnClp clone = new GEMTemplateColumnClp();

		clone.setColumnId(getColumnId());
		clone.setTemplateId(getTemplateId());
		clone.setColumnName(getColumnName());
		clone.setValueType(getValueType());
		clone.setDefaultValue(getDefaultValue());
		clone.setIsMandatory(getIsMandatory());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMTemplateColumn gemTemplateColumn) {
		long primaryKey = gemTemplateColumn.getPrimaryKey();

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

		if (!(obj instanceof GEMTemplateColumnClp)) {
			return false;
		}

		GEMTemplateColumnClp gemTemplateColumn = (GEMTemplateColumnClp)obj;

		long primaryKey = gemTemplateColumn.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{columnId=");
		sb.append(getColumnId());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", columnName=");
		sb.append(getColumnName());
		sb.append(", valueType=");
		sb.append(getValueType());
		sb.append(", defaultValue=");
		sb.append(getDefaultValue());
		sb.append(", isMandatory=");
		sb.append(getIsMandatory());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMTemplateColumn");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>columnId</column-name><column-value><![CDATA[");
		sb.append(getColumnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>columnName</column-name><column-value><![CDATA[");
		sb.append(getColumnName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valueType</column-name><column-value><![CDATA[");
		sb.append(getValueType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultValue</column-name><column-value><![CDATA[");
		sb.append(getDefaultValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isMandatory</column-name><column-value><![CDATA[");
		sb.append(getIsMandatory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
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

	private long _columnId;
	private long _templateId;
	private String _columnName;
	private String _valueType;
	private String _defaultValue;
	private String _isMandatory;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemTemplateColumnRemoteModel;
}