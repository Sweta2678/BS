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
import com.ihg.brandstandards.db.service.GEMMeasurementFormulaLocalServiceUtil;

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
public class GEMMeasurementFormulaClp extends BaseModelImpl<GEMMeasurementFormula>
	implements GEMMeasurementFormula {
	public GEMMeasurementFormulaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementFormula.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementFormula.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _formulaId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormulaId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formulaId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formulaId", getFormulaId());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("measurementId", getMeasurementId());
		attributes.put("severityId", getSeverityId());
		attributes.put("subRegionLevelCd", getSubRegionLevelCd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formulaId = (Long)attributes.get("formulaId");

		if (formulaId != null) {
			setFormulaId(formulaId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long measurementId = (Long)attributes.get("measurementId");

		if (measurementId != null) {
			setMeasurementId(measurementId);
		}

		Long severityId = (Long)attributes.get("severityId");

		if (severityId != null) {
			setSeverityId(severityId);
		}

		String subRegionLevelCd = (String)attributes.get("subRegionLevelCd");

		if (subRegionLevelCd != null) {
			setSubRegionLevelCd(subRegionLevelCd);
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
	public long getFormulaId() {
		return _formulaId;
	}

	@Override
	public void setFormulaId(long formulaId) {
		_formulaId = formulaId;

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setFormulaId", long.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, formulaId);
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

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, publishId);
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

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMeasurementId() {
		return _measurementId;
	}

	@Override
	public void setMeasurementId(long measurementId) {
		_measurementId = measurementId;

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementId", long.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, measurementId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSeverityId() {
		return _severityId;
	}

	@Override
	public void setSeverityId(long severityId) {
		_severityId = severityId;

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setSeverityId", long.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, severityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubRegionLevelCd() {
		return _subRegionLevelCd;
	}

	@Override
	public void setSubRegionLevelCd(String subRegionLevelCd) {
		_subRegionLevelCd = subRegionLevelCd;

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setSubRegionLevelCd",
						String.class);

				method.invoke(_gemMeasurementFormulaRemoteModel,
					subRegionLevelCd);
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

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, creatorId);
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

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, createdDate);
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

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, updatedBy);
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

		if (_gemMeasurementFormulaRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementFormulaRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemMeasurementFormulaRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMMeasurementFormulaRemoteModel() {
		return _gemMeasurementFormulaRemoteModel;
	}

	public void setGEMMeasurementFormulaRemoteModel(
		BaseModel<?> gemMeasurementFormulaRemoteModel) {
		_gemMeasurementFormulaRemoteModel = gemMeasurementFormulaRemoteModel;
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

		Class<?> remoteModelClass = _gemMeasurementFormulaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemMeasurementFormulaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMMeasurementFormulaLocalServiceUtil.addGEMMeasurementFormula(this);
		}
		else {
			GEMMeasurementFormulaLocalServiceUtil.updateGEMMeasurementFormula(this);
		}
	}

	@Override
	public GEMMeasurementFormula toEscapedModel() {
		return (GEMMeasurementFormula)ProxyUtil.newProxyInstance(GEMMeasurementFormula.class.getClassLoader(),
			new Class[] { GEMMeasurementFormula.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMMeasurementFormulaClp clone = new GEMMeasurementFormulaClp();

		clone.setFormulaId(getFormulaId());
		clone.setPublishId(getPublishId());
		clone.setRegionId(getRegionId());
		clone.setMeasurementId(getMeasurementId());
		clone.setSeverityId(getSeverityId());
		clone.setSubRegionLevelCd(getSubRegionLevelCd());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMMeasurementFormula gemMeasurementFormula) {
		long primaryKey = gemMeasurementFormula.getPrimaryKey();

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

		if (!(obj instanceof GEMMeasurementFormulaClp)) {
			return false;
		}

		GEMMeasurementFormulaClp gemMeasurementFormula = (GEMMeasurementFormulaClp)obj;

		long primaryKey = gemMeasurementFormula.getPrimaryKey();

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

		sb.append("{formulaId=");
		sb.append(getFormulaId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", measurementId=");
		sb.append(getMeasurementId());
		sb.append(", severityId=");
		sb.append(getSeverityId());
		sb.append(", subRegionLevelCd=");
		sb.append(getSubRegionLevelCd());
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
		sb.append("com.ihg.brandstandards.db.model.GEMMeasurementFormula");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formulaId</column-name><column-value><![CDATA[");
		sb.append(getFormulaId());
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
			"<column><column-name>measurementId</column-name><column-value><![CDATA[");
		sb.append(getMeasurementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>severityId</column-name><column-value><![CDATA[");
		sb.append(getSeverityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subRegionLevelCd</column-name><column-value><![CDATA[");
		sb.append(getSubRegionLevelCd());
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

	private long _formulaId;
	private long _publishId;
	private long _regionId;
	private long _measurementId;
	private long _severityId;
	private String _subRegionLevelCd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemMeasurementFormulaRemoteModel;
}