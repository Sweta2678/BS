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
import com.ihg.brandstandards.db.service.GEMMeasurementBucketChainLocalServiceUtil;

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
public class GEMMeasurementBucketChainClp extends BaseModelImpl<GEMMeasurementBucketChain>
	implements GEMMeasurementBucketChain {
	public GEMMeasurementBucketChainClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementBucketChain.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementBucketChain.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _measurementBucketChainId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMeasurementBucketChainId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _measurementBucketChainId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("measurementBucketChainId", getMeasurementBucketChainId());
		attributes.put("bucketId", getBucketId());
		attributes.put("severityId", getSeverityId());
		attributes.put("measurementId", getMeasurementId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("subRegionCd", getSubRegionCd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long measurementBucketChainId = (Long)attributes.get(
				"measurementBucketChainId");

		if (measurementBucketChainId != null) {
			setMeasurementBucketChainId(measurementBucketChainId);
		}

		Long bucketId = (Long)attributes.get("bucketId");

		if (bucketId != null) {
			setBucketId(bucketId);
		}

		Long severityId = (Long)attributes.get("severityId");

		if (severityId != null) {
			setSeverityId(severityId);
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

		String subRegionCd = (String)attributes.get("subRegionCd");

		if (subRegionCd != null) {
			setSubRegionCd(subRegionCd);
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
	public long getMeasurementBucketChainId() {
		return _measurementBucketChainId;
	}

	@Override
	public void setMeasurementBucketChainId(long measurementBucketChainId) {
		_measurementBucketChainId = measurementBucketChainId;

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementBucketChainId",
						long.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel,
					measurementBucketChainId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBucketId() {
		return _bucketId;
	}

	@Override
	public void setBucketId(long bucketId) {
		_bucketId = bucketId;

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setBucketId", long.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, bucketId);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setSeverityId", long.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, severityId);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementId", long.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel,
					measurementId);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDeptId", long.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel,
					publishDeptId);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, publishId);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubRegionCd() {
		return _subRegionCd;
	}

	@Override
	public void setSubRegionCd(String subRegionCd) {
		_subRegionCd = subRegionCd;

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setSubRegionCd", String.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, subRegionCd);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, creatorId);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, createdDate);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, updatedBy);
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

		if (_gemMeasurementBucketChainRemoteModel != null) {
			try {
				Class<?> clazz = _gemMeasurementBucketChainRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemMeasurementBucketChainRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMMeasurementBucketChainRemoteModel() {
		return _gemMeasurementBucketChainRemoteModel;
	}

	public void setGEMMeasurementBucketChainRemoteModel(
		BaseModel<?> gemMeasurementBucketChainRemoteModel) {
		_gemMeasurementBucketChainRemoteModel = gemMeasurementBucketChainRemoteModel;
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

		Class<?> remoteModelClass = _gemMeasurementBucketChainRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemMeasurementBucketChainRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMMeasurementBucketChainLocalServiceUtil.addGEMMeasurementBucketChain(this);
		}
		else {
			GEMMeasurementBucketChainLocalServiceUtil.updateGEMMeasurementBucketChain(this);
		}
	}

	@Override
	public GEMMeasurementBucketChain toEscapedModel() {
		return (GEMMeasurementBucketChain)ProxyUtil.newProxyInstance(GEMMeasurementBucketChain.class.getClassLoader(),
			new Class[] { GEMMeasurementBucketChain.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMMeasurementBucketChainClp clone = new GEMMeasurementBucketChainClp();

		clone.setMeasurementBucketChainId(getMeasurementBucketChainId());
		clone.setBucketId(getBucketId());
		clone.setSeverityId(getSeverityId());
		clone.setMeasurementId(getMeasurementId());
		clone.setPublishDeptId(getPublishDeptId());
		clone.setPublishId(getPublishId());
		clone.setRegionId(getRegionId());
		clone.setSubRegionCd(getSubRegionCd());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMMeasurementBucketChain gemMeasurementBucketChain) {
		long primaryKey = gemMeasurementBucketChain.getPrimaryKey();

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

		if (!(obj instanceof GEMMeasurementBucketChainClp)) {
			return false;
		}

		GEMMeasurementBucketChainClp gemMeasurementBucketChain = (GEMMeasurementBucketChainClp)obj;

		long primaryKey = gemMeasurementBucketChain.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{measurementBucketChainId=");
		sb.append(getMeasurementBucketChainId());
		sb.append(", bucketId=");
		sb.append(getBucketId());
		sb.append(", severityId=");
		sb.append(getSeverityId());
		sb.append(", measurementId=");
		sb.append(getMeasurementId());
		sb.append(", publishDeptId=");
		sb.append(getPublishDeptId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", subRegionCd=");
		sb.append(getSubRegionCd());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMMeasurementBucketChain");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>measurementBucketChainId</column-name><column-value><![CDATA[");
		sb.append(getMeasurementBucketChainId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bucketId</column-name><column-value><![CDATA[");
		sb.append(getBucketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>severityId</column-name><column-value><![CDATA[");
		sb.append(getSeverityId());
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
			"<column><column-name>subRegionCd</column-name><column-value><![CDATA[");
		sb.append(getSubRegionCd());
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

	private long _measurementBucketChainId;
	private long _bucketId;
	private long _severityId;
	private long _measurementId;
	private long _publishDeptId;
	private long _publishId;
	private long _regionId;
	private String _subRegionCd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemMeasurementBucketChainRemoteModel;
}