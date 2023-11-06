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
import com.ihg.brandstandards.db.service.GEMGeneratedReportLocalServiceUtil;

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
public class GEMGeneratedReportClp extends BaseModelImpl<GEMGeneratedReport>
	implements GEMGeneratedReport {
	public GEMGeneratedReportClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMGeneratedReport.class;
	}

	@Override
	public String getModelClassName() {
		return GEMGeneratedReport.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _reportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _reportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("reportId", getReportId());
		attributes.put("templateId", getTemplateId());
		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long uniqueGroupId = (Long)attributes.get("uniqueGroupId");

		if (uniqueGroupId != null) {
			setUniqueGroupId(uniqueGroupId);
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
	public long getReportId() {
		return _reportId;
	}

	@Override
	public void setReportId(long reportId) {
		_reportId = reportId;

		if (_gemGeneratedReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportRemoteModel.getClass();

				Method method = clazz.getMethod("setReportId", long.class);

				method.invoke(_gemGeneratedReportRemoteModel, reportId);
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

		if (_gemGeneratedReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_gemGeneratedReportRemoteModel, templateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUniqueGroupId() {
		return _uniqueGroupId;
	}

	@Override
	public void setUniqueGroupId(long uniqueGroupId) {
		_uniqueGroupId = uniqueGroupId;

		if (_gemGeneratedReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportRemoteModel.getClass();

				Method method = clazz.getMethod("setUniqueGroupId", long.class);

				method.invoke(_gemGeneratedReportRemoteModel, uniqueGroupId);
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

		if (_gemGeneratedReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemGeneratedReportRemoteModel, creatorId);
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

		if (_gemGeneratedReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemGeneratedReportRemoteModel, createdDate);
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

		if (_gemGeneratedReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemGeneratedReportRemoteModel, updatedBy);
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

		if (_gemGeneratedReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemGeneratedReportRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemGeneratedReportRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMGeneratedReportRemoteModel() {
		return _gemGeneratedReportRemoteModel;
	}

	public void setGEMGeneratedReportRemoteModel(
		BaseModel<?> gemGeneratedReportRemoteModel) {
		_gemGeneratedReportRemoteModel = gemGeneratedReportRemoteModel;
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

		Class<?> remoteModelClass = _gemGeneratedReportRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemGeneratedReportRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMGeneratedReportLocalServiceUtil.addGEMGeneratedReport(this);
		}
		else {
			GEMGeneratedReportLocalServiceUtil.updateGEMGeneratedReport(this);
		}
	}

	@Override
	public GEMGeneratedReport toEscapedModel() {
		return (GEMGeneratedReport)ProxyUtil.newProxyInstance(GEMGeneratedReport.class.getClassLoader(),
			new Class[] { GEMGeneratedReport.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMGeneratedReportClp clone = new GEMGeneratedReportClp();

		clone.setReportId(getReportId());
		clone.setTemplateId(getTemplateId());
		clone.setUniqueGroupId(getUniqueGroupId());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMGeneratedReport gemGeneratedReport) {
		int value = 0;

		if (getReportId() < gemGeneratedReport.getReportId()) {
			value = -1;
		}
		else if (getReportId() > gemGeneratedReport.getReportId()) {
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

		if (!(obj instanceof GEMGeneratedReportClp)) {
			return false;
		}

		GEMGeneratedReportClp gemGeneratedReport = (GEMGeneratedReportClp)obj;

		long primaryKey = gemGeneratedReport.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{reportId=");
		sb.append(getReportId());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", uniqueGroupId=");
		sb.append(getUniqueGroupId());
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
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMGeneratedReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>reportId</column-name><column-value><![CDATA[");
		sb.append(getReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uniqueGroupId</column-name><column-value><![CDATA[");
		sb.append(getUniqueGroupId());
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

	private long _reportId;
	private long _templateId;
	private long _uniqueGroupId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemGeneratedReportRemoteModel;
}