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
import com.ihg.brandstandards.db.service.GEMChainMeasurementLocalServiceUtil;

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
public class GEMChainMeasurementClp extends BaseModelImpl<GEMChainMeasurement>
	implements GEMChainMeasurement {
	public GEMChainMeasurementClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMChainMeasurement.class;
	}

	@Override
	public String getModelClassName() {
		return GEMChainMeasurement.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _chainMeasurementId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setChainMeasurementId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _chainMeasurementId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chainMeasurementId", getChainMeasurementId());
		attributes.put("measurementId", getMeasurementId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("measurementItemCount", getMeasurementItemCount());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long chainMeasurementId = (Long)attributes.get("chainMeasurementId");

		if (chainMeasurementId != null) {
			setChainMeasurementId(chainMeasurementId);
		}

		Long measurementId = (Long)attributes.get("measurementId");

		if (measurementId != null) {
			setMeasurementId(measurementId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long uniqueGroupId = (Long)attributes.get("uniqueGroupId");

		if (uniqueGroupId != null) {
			setUniqueGroupId(uniqueGroupId);
		}

		Long measurementItemCount = (Long)attributes.get("measurementItemCount");

		if (measurementItemCount != null) {
			setMeasurementItemCount(measurementItemCount);
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
	public long getChainMeasurementId() {
		return _chainMeasurementId;
	}

	@Override
	public void setChainMeasurementId(long chainMeasurementId) {
		_chainMeasurementId = chainMeasurementId;

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setChainMeasurementId",
						long.class);

				method.invoke(_gemChainMeasurementRemoteModel,
					chainMeasurementId);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementId", long.class);

				method.invoke(_gemChainMeasurementRemoteModel, measurementId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishDeptId() {
		return _publishDeptId;
	}

	@Override
	public void setPublishDeptId(long publishDeptId) {
		_publishDeptId = publishDeptId;

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDeptId", long.class);

				method.invoke(_gemChainMeasurementRemoteModel, publishDeptId);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_gemChainMeasurementRemoteModel, publishId);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemChainMeasurementRemoteModel, regionId);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setUniqueGroupId", long.class);

				method.invoke(_gemChainMeasurementRemoteModel, uniqueGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMeasurementItemCount() {
		return _measurementItemCount;
	}

	@Override
	public void setMeasurementItemCount(long measurementItemCount) {
		_measurementItemCount = measurementItemCount;

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementItemCount",
						long.class);

				method.invoke(_gemChainMeasurementRemoteModel,
					measurementItemCount);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemChainMeasurementRemoteModel, creatorId);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemChainMeasurementRemoteModel, createdDate);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemChainMeasurementRemoteModel, updatedBy);
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

		if (_gemChainMeasurementRemoteModel != null) {
			try {
				Class<?> clazz = _gemChainMeasurementRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemChainMeasurementRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMChainMeasurementRemoteModel() {
		return _gemChainMeasurementRemoteModel;
	}

	public void setGEMChainMeasurementRemoteModel(
		BaseModel<?> gemChainMeasurementRemoteModel) {
		_gemChainMeasurementRemoteModel = gemChainMeasurementRemoteModel;
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

		Class<?> remoteModelClass = _gemChainMeasurementRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemChainMeasurementRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMChainMeasurementLocalServiceUtil.addGEMChainMeasurement(this);
		}
		else {
			GEMChainMeasurementLocalServiceUtil.updateGEMChainMeasurement(this);
		}
	}

	@Override
	public GEMChainMeasurement toEscapedModel() {
		return (GEMChainMeasurement)ProxyUtil.newProxyInstance(GEMChainMeasurement.class.getClassLoader(),
			new Class[] { GEMChainMeasurement.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMChainMeasurementClp clone = new GEMChainMeasurementClp();

		clone.setChainMeasurementId(getChainMeasurementId());
		clone.setMeasurementId(getMeasurementId());
		clone.setPublishDeptId(getPublishDeptId());
		clone.setPublishId(getPublishId());
		clone.setRegionId(getRegionId());
		clone.setUniqueGroupId(getUniqueGroupId());
		clone.setMeasurementItemCount(getMeasurementItemCount());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMChainMeasurement gemChainMeasurement) {
		long primaryKey = gemChainMeasurement.getPrimaryKey();

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

		if (!(obj instanceof GEMChainMeasurementClp)) {
			return false;
		}

		GEMChainMeasurementClp gemChainMeasurement = (GEMChainMeasurementClp)obj;

		long primaryKey = gemChainMeasurement.getPrimaryKey();

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

		sb.append("{chainMeasurementId=");
		sb.append(getChainMeasurementId());
		sb.append(", measurementId=");
		sb.append(getMeasurementId());
		sb.append(", publishDeptId=");
		sb.append(getPublishDeptId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", uniqueGroupId=");
		sb.append(getUniqueGroupId());
		sb.append(", measurementItemCount=");
		sb.append(getMeasurementItemCount());
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
		sb.append("com.ihg.brandstandards.db.model.GEMChainMeasurement");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>chainMeasurementId</column-name><column-value><![CDATA[");
		sb.append(getChainMeasurementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementId</column-name><column-value><![CDATA[");
		sb.append(getMeasurementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDeptId</column-name><column-value><![CDATA[");
		sb.append(getPublishDeptId());
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
			"<column><column-name>uniqueGroupId</column-name><column-value><![CDATA[");
		sb.append(getUniqueGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementItemCount</column-name><column-value><![CDATA[");
		sb.append(getMeasurementItemCount());
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

	private long _chainMeasurementId;
	private long _measurementId;
	private long _publishDeptId;
	private long _publishId;
	private long _regionId;
	private long _uniqueGroupId;
	private long _measurementItemCount;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemChainMeasurementRemoteModel;
}