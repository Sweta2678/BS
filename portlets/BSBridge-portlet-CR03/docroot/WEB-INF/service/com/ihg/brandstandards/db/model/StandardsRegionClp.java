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
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;

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
public class StandardsRegionClp extends BaseModelImpl<StandardsRegion>
	implements StandardsRegion {
	public StandardsRegionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsRegion.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsRegion.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _regionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _regionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("regionId", getRegionId());
		attributes.put("regionCode", getRegionCode());
		attributes.put("regionType", getRegionType());
		attributes.put("regionName", getRegionName());
		attributes.put("isActive", getIsActive());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("parentRegionId", getParentRegionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String regionType = (String)attributes.get("regionType");

		if (regionType != null) {
			setRegionType(regionType);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}

		String isActive = (String)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
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

		Long parentRegionId = (Long)attributes.get("parentRegionId");

		if (parentRegionId != null) {
			setParentRegionId(parentRegionId);
		}
	}

	@Override
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_regionId = regionId;

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_standardsRegionRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_standardsRegionRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionType() {
		return _regionType;
	}

	@Override
	public void setRegionType(String regionType) {
		_regionType = regionType;

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionType", String.class);

				method.invoke(_standardsRegionRemoteModel, regionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionName() {
		return _regionName;
	}

	@Override
	public void setRegionName(String regionName) {
		_regionName = regionName;

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionName", String.class);

				method.invoke(_standardsRegionRemoteModel, regionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(String isActive) {
		_isActive = isActive;

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", String.class);

				method.invoke(_standardsRegionRemoteModel, isActive);
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

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsRegionRemoteModel, creatorId);
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

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsRegionRemoteModel, createdDate);
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

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsRegionRemoteModel, updatedBy);
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

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsRegionRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentRegionId() {
		return _parentRegionId;
	}

	@Override
	public void setParentRegionId(long parentRegionId) {
		_parentRegionId = parentRegionId;

		if (_standardsRegionRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionRemoteModel.getClass();

				Method method = clazz.getMethod("setParentRegionId", long.class);

				method.invoke(_standardsRegionRemoteModel, parentRegionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsRegionRemoteModel() {
		return _standardsRegionRemoteModel;
	}

	public void setStandardsRegionRemoteModel(
		BaseModel<?> standardsRegionRemoteModel) {
		_standardsRegionRemoteModel = standardsRegionRemoteModel;
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

		Class<?> remoteModelClass = _standardsRegionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsRegionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsRegionLocalServiceUtil.addStandardsRegion(this);
		}
		else {
			StandardsRegionLocalServiceUtil.updateStandardsRegion(this);
		}
	}

	@Override
	public StandardsRegion toEscapedModel() {
		return (StandardsRegion)ProxyUtil.newProxyInstance(StandardsRegion.class.getClassLoader(),
			new Class[] { StandardsRegion.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsRegionClp clone = new StandardsRegionClp();

		clone.setRegionId(getRegionId());
		clone.setRegionCode(getRegionCode());
		clone.setRegionType(getRegionType());
		clone.setRegionName(getRegionName());
		clone.setIsActive(getIsActive());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setParentRegionId(getParentRegionId());

		return clone;
	}

	@Override
	public int compareTo(StandardsRegion standardsRegion) {
		long primaryKey = standardsRegion.getPrimaryKey();

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

		if (!(obj instanceof StandardsRegionClp)) {
			return false;
		}

		StandardsRegionClp standardsRegion = (StandardsRegionClp)obj;

		long primaryKey = standardsRegion.getPrimaryKey();

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

		sb.append("{regionId=");
		sb.append(getRegionId());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", regionType=");
		sb.append(getRegionType());
		sb.append(", regionName=");
		sb.append(getRegionName());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", parentRegionId=");
		sb.append(getParentRegionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsRegion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionType</column-name><column-value><![CDATA[");
		sb.append(getRegionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionName</column-name><column-value><![CDATA[");
		sb.append(getRegionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
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
		sb.append(
			"<column><column-name>parentRegionId</column-name><column-value><![CDATA[");
		sb.append(getParentRegionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _regionId;
	private String _regionCode;
	private String _regionType;
	private String _regionName;
	private String _isActive;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _parentRegionId;
	private BaseModel<?> _standardsRegionRemoteModel;
}