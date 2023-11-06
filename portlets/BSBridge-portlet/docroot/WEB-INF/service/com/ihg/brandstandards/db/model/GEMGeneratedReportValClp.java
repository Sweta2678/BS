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
import com.ihg.brandstandards.db.service.GEMGeneratedReportValLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK;

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
public class GEMGeneratedReportValClp extends BaseModelImpl<GEMGeneratedReportVal>
	implements GEMGeneratedReportVal {
	public GEMGeneratedReportValClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMGeneratedReportVal.class;
	}

	@Override
	public String getModelClassName() {
		return GEMGeneratedReportVal.class.getName();
	}

	@Override
	public GEMGeneratedReportValPK getPrimaryKey() {
		return new GEMGeneratedReportValPK(_reportValId, _reportId);
	}

	@Override
	public void setPrimaryKey(GEMGeneratedReportValPK primaryKey) {
		setReportValId(primaryKey.reportValId);
		setReportId(primaryKey.reportId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new GEMGeneratedReportValPK(_reportValId, _reportId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((GEMGeneratedReportValPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportValId", getReportValId());
		attributes.put("reportId", getReportId());
		attributes.put("columnId", getColumnId());
		attributes.put("generatedValue", getGeneratedValue());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportValId = (Long)attributes.get("reportValId");

		if (reportValId != null) {
			setReportValId(reportValId);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long columnId = (Long)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}

		String generatedValue = (String)attributes.get("generatedValue");

		if (generatedValue != null) {
			setGeneratedValue(generatedValue);
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
	public long getReportValId() {
		return _reportValId;
	}

	@Override
	public void setReportValId(long reportValId) {
		_reportValId = reportValId;

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setReportValId", long.class);

				method.invoke(_gemGeneratedReportValRemoteModel, reportValId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		_reportId = reportId;

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setReportId", long.class);

				method.invoke(_gemGeneratedReportValRemoteModel, reportId);
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

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setColumnId", long.class);

				method.invoke(_gemGeneratedReportValRemoteModel, columnId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeneratedValue() {
		return _generatedValue;
	}

	@Override
	public void setGeneratedValue(String generatedValue) {
		_generatedValue = generatedValue;

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneratedValue",
						String.class);

				method.invoke(_gemGeneratedReportValRemoteModel, generatedValue);
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

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemGeneratedReportValRemoteModel,
					displayOrderNumber);
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

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemGeneratedReportValRemoteModel, creatorId);
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

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemGeneratedReportValRemoteModel, createdDate);
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

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemGeneratedReportValRemoteModel, updatedBy);
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

		if (_gemGeneratedReportValRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportValRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemGeneratedReportValRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMGeneratedReportValRemoteModel() {
		return _gemGeneratedReportValRemoteModel;
	}

	public void setGEMGeneratedReportValRemoteModel(
		BaseModel<?> gemGeneratedReportValRemoteModel) {
		_gemGeneratedReportValRemoteModel = gemGeneratedReportValRemoteModel;
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

		Class<?> remoteModelClass = _gemGeneratedReportValRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemGeneratedReportValRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMGeneratedReportValLocalServiceUtil.addGEMGeneratedReportVal(this);
		}
		else {
			GEMGeneratedReportValLocalServiceUtil.updateGEMGeneratedReportVal(this);
		}
	}

	@Override
	public GEMGeneratedReportVal toEscapedModel() {
		return (GEMGeneratedReportVal)ProxyUtil.newProxyInstance(GEMGeneratedReportVal.class.getClassLoader(),
			new Class[] { GEMGeneratedReportVal.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMGeneratedReportValClp clone = new GEMGeneratedReportValClp();

		clone.setReportValId(getReportValId());
		clone.setReportId(getReportId());
		clone.setColumnId(getColumnId());
		clone.setGeneratedValue(getGeneratedValue());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMGeneratedReportVal gemGeneratedReportVal) {
		int value = 0;

		if (getReportId() < gemGeneratedReportVal.getReportId()) {
			value = -1;
		}
		else if (getReportId() > gemGeneratedReportVal.getReportId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getDisplayOrderNumber() < gemGeneratedReportVal.getDisplayOrderNumber()) {
			value = -1;
		}
		else if (getDisplayOrderNumber() > gemGeneratedReportVal.getDisplayOrderNumber()) {
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

		if (!(obj instanceof GEMGeneratedReportValClp)) {
			return false;
		}

		GEMGeneratedReportValClp gemGeneratedReportVal = (GEMGeneratedReportValClp)obj;

		GEMGeneratedReportValPK primaryKey = gemGeneratedReportVal.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{reportValId=");
		sb.append(getReportValId());
		sb.append(", reportId=");
		sb.append(getReportId());
		sb.append(", columnId=");
		sb.append(getColumnId());
		sb.append(", generatedValue=");
		sb.append(getGeneratedValue());
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
		sb.append("com.ihg.brandstandards.db.model.GEMGeneratedReportVal");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportValId</column-name><column-value><![CDATA[");
		sb.append(getReportValId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>columnId</column-name><column-value><![CDATA[");
		sb.append(getColumnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>generatedValue</column-name><column-value><![CDATA[");
		sb.append(getGeneratedValue());
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

	private long _reportValId;
	private long _reportId;
	private long _columnId;
	private String _generatedValue;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemGeneratedReportValRemoteModel;
}