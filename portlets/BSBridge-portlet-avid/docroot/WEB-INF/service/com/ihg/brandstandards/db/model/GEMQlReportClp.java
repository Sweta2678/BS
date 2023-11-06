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
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;

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
public class GEMQlReportClp extends BaseModelImpl<GEMQlReport>
	implements GEMQlReport {
	public GEMQlReportClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMQlReport.class;
	}

	@Override
	public String getModelClassName() {
		return GEMQlReport.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _qlReportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setQlReportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _qlReportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("qlReportId", getQlReportId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("bucketId", getBucketId());
		attributes.put("severityId", getSeverityId());
		attributes.put("measurementId", getMeasurementId());
		attributes.put("triggerId", getTriggerId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("regionId", getRegionId());
		attributes.put("complianceDueDays", getComplianceDueDays());
		attributes.put("glblMustMeasure", getGlblMustMeasure());
		attributes.put("parentQlReportId", getParentQlReportId());
		attributes.put("duplicate", getDuplicate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long qlReportId = (Long)attributes.get("qlReportId");

		if (qlReportId != null) {
			setQlReportId(qlReportId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
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

		Long triggerId = (Long)attributes.get("triggerId");

		if (triggerId != null) {
			setTriggerId(triggerId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long complianceDueDays = (Long)attributes.get("complianceDueDays");

		if (complianceDueDays != null) {
			setComplianceDueDays(complianceDueDays);
		}

		String glblMustMeasure = (String)attributes.get("glblMustMeasure");

		if (glblMustMeasure != null) {
			setGlblMustMeasure(glblMustMeasure);
		}

		Long parentQlReportId = (Long)attributes.get("parentQlReportId");

		if (parentQlReportId != null) {
			setParentQlReportId(parentQlReportId);
		}

		String duplicate = (String)attributes.get("duplicate");

		if (duplicate != null) {
			setDuplicate(duplicate);
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
	public long getQlReportId() {
		return _qlReportId;
	}

	@Override
	public void setQlReportId(long qlReportId) {
		_qlReportId = qlReportId;

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setQlReportId", long.class);

				method.invoke(_gemQlReportRemoteModel, qlReportId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDeptId", long.class);

				method.invoke(_gemQlReportRemoteModel, publishDeptId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_gemQlReportRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_gemQlReportRemoteModel, stdId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setBucketId", long.class);

				method.invoke(_gemQlReportRemoteModel, bucketId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setSeverityId", long.class);

				method.invoke(_gemQlReportRemoteModel, severityId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setMeasurementId", long.class);

				method.invoke(_gemQlReportRemoteModel, measurementId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTriggerId() {
		return _triggerId;
	}

	@Override
	public void setTriggerId(long triggerId) {
		_triggerId = triggerId;

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setTriggerId", long.class);

				method.invoke(_gemQlReportRemoteModel, triggerId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_gemQlReportRemoteModel, categoryId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemQlReportRemoteModel, displayOrderNumber);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemQlReportRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getComplianceDueDays() {
		return _complianceDueDays;
	}

	@Override
	public void setComplianceDueDays(long complianceDueDays) {
		_complianceDueDays = complianceDueDays;

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceDueDays",
						long.class);

				method.invoke(_gemQlReportRemoteModel, complianceDueDays);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlblMustMeasure() {
		return _glblMustMeasure;
	}

	@Override
	public void setGlblMustMeasure(String glblMustMeasure) {
		_glblMustMeasure = glblMustMeasure;

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setGlblMustMeasure",
						String.class);

				method.invoke(_gemQlReportRemoteModel, glblMustMeasure);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentQlReportId() {
		return _parentQlReportId;
	}

	@Override
	public void setParentQlReportId(long parentQlReportId) {
		_parentQlReportId = parentQlReportId;

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setParentQlReportId",
						long.class);

				method.invoke(_gemQlReportRemoteModel, parentQlReportId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuplicate() {
		return _duplicate;
	}

	@Override
	public void setDuplicate(String duplicate) {
		_duplicate = duplicate;

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setDuplicate", String.class);

				method.invoke(_gemQlReportRemoteModel, duplicate);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemQlReportRemoteModel, creatorId);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemQlReportRemoteModel, createdDate);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemQlReportRemoteModel, updatedBy);
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

		if (_gemQlReportRemoteModel != null) {
			try {
				Class<?> clazz = _gemQlReportRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemQlReportRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMQlReportRemoteModel() {
		return _gemQlReportRemoteModel;
	}

	public void setGEMQlReportRemoteModel(BaseModel<?> gemQlReportRemoteModel) {
		_gemQlReportRemoteModel = gemQlReportRemoteModel;
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

		Class<?> remoteModelClass = _gemQlReportRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemQlReportRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMQlReportLocalServiceUtil.addGEMQlReport(this);
		}
		else {
			GEMQlReportLocalServiceUtil.updateGEMQlReport(this);
		}
	}

	@Override
	public GEMQlReport toEscapedModel() {
		return (GEMQlReport)ProxyUtil.newProxyInstance(GEMQlReport.class.getClassLoader(),
			new Class[] { GEMQlReport.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMQlReportClp clone = new GEMQlReportClp();

		clone.setQlReportId(getQlReportId());
		clone.setPublishDeptId(getPublishDeptId());
		clone.setPublishId(getPublishId());
		clone.setStdId(getStdId());
		clone.setBucketId(getBucketId());
		clone.setSeverityId(getSeverityId());
		clone.setMeasurementId(getMeasurementId());
		clone.setTriggerId(getTriggerId());
		clone.setCategoryId(getCategoryId());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setRegionId(getRegionId());
		clone.setComplianceDueDays(getComplianceDueDays());
		clone.setGlblMustMeasure(getGlblMustMeasure());
		clone.setParentQlReportId(getParentQlReportId());
		clone.setDuplicate(getDuplicate());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMQlReport gemQlReport) {
		long primaryKey = gemQlReport.getPrimaryKey();

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

		if (!(obj instanceof GEMQlReportClp)) {
			return false;
		}

		GEMQlReportClp gemQlReport = (GEMQlReportClp)obj;

		long primaryKey = gemQlReport.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{qlReportId=");
		sb.append(getQlReportId());
		sb.append(", publishDeptId=");
		sb.append(getPublishDeptId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", bucketId=");
		sb.append(getBucketId());
		sb.append(", severityId=");
		sb.append(getSeverityId());
		sb.append(", measurementId=");
		sb.append(getMeasurementId());
		sb.append(", triggerId=");
		sb.append(getTriggerId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", complianceDueDays=");
		sb.append(getComplianceDueDays());
		sb.append(", glblMustMeasure=");
		sb.append(getGlblMustMeasure());
		sb.append(", parentQlReportId=");
		sb.append(getParentQlReportId());
		sb.append(", duplicate=");
		sb.append(getDuplicate());
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
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMQlReport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>qlReportId</column-name><column-value><![CDATA[");
		sb.append(getQlReportId());
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
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
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
			"<column><column-name>triggerId</column-name><column-value><![CDATA[");
		sb.append(getTriggerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceDueDays</column-name><column-value><![CDATA[");
		sb.append(getComplianceDueDays());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glblMustMeasure</column-name><column-value><![CDATA[");
		sb.append(getGlblMustMeasure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentQlReportId</column-name><column-value><![CDATA[");
		sb.append(getParentQlReportId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duplicate</column-name><column-value><![CDATA[");
		sb.append(getDuplicate());
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

	private long _qlReportId;
	private long _publishDeptId;
	private long _publishId;
	private long _stdId;
	private long _bucketId;
	private long _severityId;
	private long _measurementId;
	private long _triggerId;
	private long _categoryId;
	private long _displayOrderNumber;
	private long _regionId;
	private long _complianceDueDays;
	private String _glblMustMeasure;
	private long _parentQlReportId;
	private String _duplicate;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemQlReportRemoteModel;
}