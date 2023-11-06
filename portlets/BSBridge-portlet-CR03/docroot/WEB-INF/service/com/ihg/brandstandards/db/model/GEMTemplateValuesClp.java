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
import com.ihg.brandstandards.db.service.GEMTemplateValuesLocalServiceUtil;

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
public class GEMTemplateValuesClp extends BaseModelImpl<GEMTemplateValues>
	implements GEMTemplateValues {
	public GEMTemplateValuesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplateValues.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplateValues.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _valueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setValueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _valueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("valueId", getValueId());
		attributes.put("columnId", getColumnId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("columnValue", getColumnValue());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long valueId = (Long)attributes.get("valueId");

		if (valueId != null) {
			setValueId(valueId);
		}

		Long columnId = (Long)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String columnValue = (String)attributes.get("columnValue");

		if (columnValue != null) {
			setColumnValue(columnValue);
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
	public long getValueId() {
		return _valueId;
	}

	@Override
	public void setValueId(long valueId) {
		_valueId = valueId;

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setValueId", long.class);

				method.invoke(_gemTemplateValuesRemoteModel, valueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getColumnId() {
		return _columnId;
	}

	@Override
	public void setColumnId(long columnId) {
		_columnId = columnId;

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnId", long.class);

				method.invoke(_gemTemplateValuesRemoteModel, columnId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_gemTemplateValuesRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getColumnValue() {
		return _columnValue;
	}

	@Override
	public void setColumnValue(String columnValue) {
		_columnValue = columnValue;

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnValue", String.class);

				method.invoke(_gemTemplateValuesRemoteModel, columnValue);
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

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemTemplateValuesRemoteModel, displayOrderNumber);
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

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemTemplateValuesRemoteModel, creatorId);
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

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemTemplateValuesRemoteModel, createdDate);
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

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemTemplateValuesRemoteModel, updatedBy);
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

		if (_gemTemplateValuesRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateValuesRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemTemplateValuesRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMTemplateValuesRemoteModel() {
		return _gemTemplateValuesRemoteModel;
	}

	public void setGEMTemplateValuesRemoteModel(
		BaseModel<?> gemTemplateValuesRemoteModel) {
		_gemTemplateValuesRemoteModel = gemTemplateValuesRemoteModel;
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

		Class<?> remoteModelClass = _gemTemplateValuesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemTemplateValuesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMTemplateValuesLocalServiceUtil.addGEMTemplateValues(this);
		}
		else {
			GEMTemplateValuesLocalServiceUtil.updateGEMTemplateValues(this);
		}
	}

	@Override
	public GEMTemplateValues toEscapedModel() {
		return (GEMTemplateValues)ProxyUtil.newProxyInstance(GEMTemplateValues.class.getClassLoader(),
			new Class[] { GEMTemplateValues.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMTemplateValuesClp clone = new GEMTemplateValuesClp();

		clone.setValueId(getValueId());
		clone.setColumnId(getColumnId());
		clone.setCategoryId(getCategoryId());
		clone.setColumnValue(getColumnValue());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMTemplateValues gemTemplateValues) {
		long primaryKey = gemTemplateValues.getPrimaryKey();

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

		if (!(obj instanceof GEMTemplateValuesClp)) {
			return false;
		}

		GEMTemplateValuesClp gemTemplateValues = (GEMTemplateValuesClp)obj;

		long primaryKey = gemTemplateValues.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{valueId=");
		sb.append(getValueId());
		sb.append(", columnId=");
		sb.append(getColumnId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", columnValue=");
		sb.append(getColumnValue());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMTemplateValues");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>valueId</column-name><column-value><![CDATA[");
		sb.append(getValueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>columnId</column-name><column-value><![CDATA[");
		sb.append(getColumnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>columnValue</column-name><column-value><![CDATA[");
		sb.append(getColumnValue());
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

	private long _valueId;
	private long _columnId;
	private long _categoryId;
	private String _columnValue;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemTemplateValuesRemoteModel;
}