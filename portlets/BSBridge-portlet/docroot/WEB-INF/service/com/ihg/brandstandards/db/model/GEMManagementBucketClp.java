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
import com.ihg.brandstandards.db.service.GEMManagementBucketLocalServiceUtil;

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
public class GEMManagementBucketClp extends BaseModelImpl<GEMManagementBucket>
	implements GEMManagementBucket {
	public GEMManagementBucketClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMManagementBucket.class;
	}

	@Override
	public String getModelClassName() {
		return GEMManagementBucket.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _bucketId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBucketId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bucketId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bucketId", getBucketId());
		attributes.put("bucketName", getBucketName());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("activeInd", getActiveInd());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("bucketCode", getBucketCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bucketId = (Long)attributes.get("bucketId");

		if (bucketId != null) {
			setBucketId(bucketId);
		}

		String bucketName = (String)attributes.get("bucketName");

		if (bucketName != null) {
			setBucketName(bucketName);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
		}

		String bucketCode = (String)attributes.get("bucketCode");

		if (bucketCode != null) {
			setBucketCode(bucketCode);
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
	public long getBucketId() {
		return _bucketId;
	}

	@Override
	public void setBucketId(long bucketId) {
		_bucketId = bucketId;

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setBucketId", long.class);

				method.invoke(_gemManagementBucketRemoteModel, bucketId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBucketName() {
		return _bucketName;
	}

	@Override
	public void setBucketName(String bucketName) {
		_bucketName = bucketName;

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setBucketName", String.class);

				method.invoke(_gemManagementBucketRemoteModel, bucketName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_gemManagementBucketRemoteModel, departmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActiveInd() {
		return _activeInd;
	}

	@Override
	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveInd", String.class);

				method.invoke(_gemManagementBucketRemoteModel, activeInd);
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

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemManagementBucketRemoteModel,
					displayOrderNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBucketCode() {
		return _bucketCode;
	}

	@Override
	public void setBucketCode(String bucketCode) {
		_bucketCode = bucketCode;

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setBucketCode", String.class);

				method.invoke(_gemManagementBucketRemoteModel, bucketCode);
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

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemManagementBucketRemoteModel, creatorId);
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

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemManagementBucketRemoteModel, createdDate);
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

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemManagementBucketRemoteModel, updatedBy);
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

		if (_gemManagementBucketRemoteModel != null) {
			try {
				Class<?> clazz = _gemManagementBucketRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemManagementBucketRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMManagementBucketRemoteModel() {
		return _gemManagementBucketRemoteModel;
	}

	public void setGEMManagementBucketRemoteModel(
		BaseModel<?> gemManagementBucketRemoteModel) {
		_gemManagementBucketRemoteModel = gemManagementBucketRemoteModel;
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

		Class<?> remoteModelClass = _gemManagementBucketRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemManagementBucketRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMManagementBucketLocalServiceUtil.addGEMManagementBucket(this);
		}
		else {
			GEMManagementBucketLocalServiceUtil.updateGEMManagementBucket(this);
		}
	}

	@Override
	public GEMManagementBucket toEscapedModel() {
		return (GEMManagementBucket)ProxyUtil.newProxyInstance(GEMManagementBucket.class.getClassLoader(),
			new Class[] { GEMManagementBucket.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMManagementBucketClp clone = new GEMManagementBucketClp();

		clone.setBucketId(getBucketId());
		clone.setBucketName(getBucketName());
		clone.setDepartmentId(getDepartmentId());
		clone.setActiveInd(getActiveInd());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setBucketCode(getBucketCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMManagementBucket gemManagementBucket) {
		int value = 0;

		if (getDisplayOrderNumber() < gemManagementBucket.getDisplayOrderNumber()) {
			value = -1;
		}
		else if (getDisplayOrderNumber() > gemManagementBucket.getDisplayOrderNumber()) {
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

		if (!(obj instanceof GEMManagementBucketClp)) {
			return false;
		}

		GEMManagementBucketClp gemManagementBucket = (GEMManagementBucketClp)obj;

		long primaryKey = gemManagementBucket.getPrimaryKey();

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

		sb.append("{bucketId=");
		sb.append(getBucketId());
		sb.append(", bucketName=");
		sb.append(getBucketName());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", activeInd=");
		sb.append(getActiveInd());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
		sb.append(", bucketCode=");
		sb.append(getBucketCode());
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
		sb.append("com.ihg.brandstandards.db.model.GEMManagementBucket");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bucketId</column-name><column-value><![CDATA[");
		sb.append(getBucketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bucketName</column-name><column-value><![CDATA[");
		sb.append(getBucketName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeInd</column-name><column-value><![CDATA[");
		sb.append(getActiveInd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bucketCode</column-name><column-value><![CDATA[");
		sb.append(getBucketCode());
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

	private long _bucketId;
	private String _bucketName;
	private long _departmentId;
	private String _activeInd;
	private long _displayOrderNumber;
	private String _bucketCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemManagementBucketRemoteModel;
}