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
import com.ihg.brandstandards.db.service.GEMScoringValueLocalServiceUtil;

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
public class GEMScoringValueClp extends BaseModelImpl<GEMScoringValue>
	implements GEMScoringValue {
	public GEMScoringValueClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMScoringValue.class;
	}

	@Override
	public String getModelClassName() {
		return GEMScoringValue.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _scoringId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setScoringId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _scoringId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("scoringId", getScoringId());
		attributes.put("measurementBucketChainId", getMeasurementBucketChainId());
		attributes.put("totalMeasurement", getTotalMeasurement());
		attributes.put("netMeasurement", getNetMeasurement());
		attributes.put("nonCompliantMeasurement", getNonCompliantMeasurement());
		attributes.put("nonCompliantMeasurementPercent",
			getNonCompliantMeasurementPercent());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long scoringId = (Long)attributes.get("scoringId");

		if (scoringId != null) {
			setScoringId(scoringId);
		}

		Long measurementBucketChainId = (Long)attributes.get(
				"measurementBucketChainId");

		if (measurementBucketChainId != null) {
			setMeasurementBucketChainId(measurementBucketChainId);
		}

		Long totalMeasurement = (Long)attributes.get("totalMeasurement");

		if (totalMeasurement != null) {
			setTotalMeasurement(totalMeasurement);
		}

		Long netMeasurement = (Long)attributes.get("netMeasurement");

		if (netMeasurement != null) {
			setNetMeasurement(netMeasurement);
		}

		Long nonCompliantMeasurement = (Long)attributes.get(
				"nonCompliantMeasurement");

		if (nonCompliantMeasurement != null) {
			setNonCompliantMeasurement(nonCompliantMeasurement);
		}

		Long nonCompliantMeasurementPercent = (Long)attributes.get(
				"nonCompliantMeasurementPercent");

		if (nonCompliantMeasurementPercent != null) {
			setNonCompliantMeasurementPercent(nonCompliantMeasurementPercent);
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
	public long getScoringId() {
		return _scoringId;
	}

	@Override
	public void setScoringId(long scoringId) {
		_scoringId = scoringId;

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setScoringId", long.class);

				method.invoke(_gemScoringValueRemoteModel, scoringId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMeasurementBucketChainId() {
		return _measurementBucketChainId;
	}

	@Override
	public void setMeasurementBucketChainId(long measurementBucketChainId) {
		_measurementBucketChainId = measurementBucketChainId;

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementBucketChainId",
						long.class);

				method.invoke(_gemScoringValueRemoteModel,
					measurementBucketChainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTotalMeasurement() {
		return _totalMeasurement;
	}

	@Override
	public void setTotalMeasurement(long totalMeasurement) {
		_totalMeasurement = totalMeasurement;

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalMeasurement",
						long.class);

				method.invoke(_gemScoringValueRemoteModel, totalMeasurement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNetMeasurement() {
		return _netMeasurement;
	}

	@Override
	public void setNetMeasurement(long netMeasurement) {
		_netMeasurement = netMeasurement;

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setNetMeasurement", long.class);

				method.invoke(_gemScoringValueRemoteModel, netMeasurement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNonCompliantMeasurement() {
		return _nonCompliantMeasurement;
	}

	@Override
	public void setNonCompliantMeasurement(long nonCompliantMeasurement) {
		_nonCompliantMeasurement = nonCompliantMeasurement;

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setNonCompliantMeasurement",
						long.class);

				method.invoke(_gemScoringValueRemoteModel,
					nonCompliantMeasurement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNonCompliantMeasurementPercent() {
		return _nonCompliantMeasurementPercent;
	}

	@Override
	public void setNonCompliantMeasurementPercent(
		long nonCompliantMeasurementPercent) {
		_nonCompliantMeasurementPercent = nonCompliantMeasurementPercent;

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setNonCompliantMeasurementPercent",
						long.class);

				method.invoke(_gemScoringValueRemoteModel,
					nonCompliantMeasurementPercent);
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

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemScoringValueRemoteModel, creatorId);
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

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemScoringValueRemoteModel, createdDate);
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

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemScoringValueRemoteModel, updatedBy);
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

		if (_gemScoringValueRemoteModel != null) {
			try {
				Class<?> clazz = _gemScoringValueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemScoringValueRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMScoringValueRemoteModel() {
		return _gemScoringValueRemoteModel;
	}

	public void setGEMScoringValueRemoteModel(
		BaseModel<?> gemScoringValueRemoteModel) {
		_gemScoringValueRemoteModel = gemScoringValueRemoteModel;
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

		Class<?> remoteModelClass = _gemScoringValueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemScoringValueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMScoringValueLocalServiceUtil.addGEMScoringValue(this);
		}
		else {
			GEMScoringValueLocalServiceUtil.updateGEMScoringValue(this);
		}
	}

	@Override
	public GEMScoringValue toEscapedModel() {
		return (GEMScoringValue)ProxyUtil.newProxyInstance(GEMScoringValue.class.getClassLoader(),
			new Class[] { GEMScoringValue.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMScoringValueClp clone = new GEMScoringValueClp();

		clone.setScoringId(getScoringId());
		clone.setMeasurementBucketChainId(getMeasurementBucketChainId());
		clone.setTotalMeasurement(getTotalMeasurement());
		clone.setNetMeasurement(getNetMeasurement());
		clone.setNonCompliantMeasurement(getNonCompliantMeasurement());
		clone.setNonCompliantMeasurementPercent(getNonCompliantMeasurementPercent());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMScoringValue gemScoringValue) {
		long primaryKey = gemScoringValue.getPrimaryKey();

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

		if (!(obj instanceof GEMScoringValueClp)) {
			return false;
		}

		GEMScoringValueClp gemScoringValue = (GEMScoringValueClp)obj;

		long primaryKey = gemScoringValue.getPrimaryKey();

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

		sb.append("{scoringId=");
		sb.append(getScoringId());
		sb.append(", measurementBucketChainId=");
		sb.append(getMeasurementBucketChainId());
		sb.append(", totalMeasurement=");
		sb.append(getTotalMeasurement());
		sb.append(", netMeasurement=");
		sb.append(getNetMeasurement());
		sb.append(", nonCompliantMeasurement=");
		sb.append(getNonCompliantMeasurement());
		sb.append(", nonCompliantMeasurementPercent=");
		sb.append(getNonCompliantMeasurementPercent());
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
		sb.append("com.ihg.brandstandards.db.model.GEMScoringValue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>scoringId</column-name><column-value><![CDATA[");
		sb.append(getScoringId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementBucketChainId</column-name><column-value><![CDATA[");
		sb.append(getMeasurementBucketChainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalMeasurement</column-name><column-value><![CDATA[");
		sb.append(getTotalMeasurement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>netMeasurement</column-name><column-value><![CDATA[");
		sb.append(getNetMeasurement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nonCompliantMeasurement</column-name><column-value><![CDATA[");
		sb.append(getNonCompliantMeasurement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nonCompliantMeasurementPercent</column-name><column-value><![CDATA[");
		sb.append(getNonCompliantMeasurementPercent());
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

	private long _scoringId;
	private long _measurementBucketChainId;
	private long _totalMeasurement;
	private long _netMeasurement;
	private long _nonCompliantMeasurement;
	private long _nonCompliantMeasurementPercent;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemScoringValueRemoteModel;
}