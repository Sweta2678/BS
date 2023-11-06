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
import com.ihg.brandstandards.db.service.GEMUniqueGroupLocalServiceUtil;

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
public class GEMUniqueGroupClp extends BaseModelImpl<GEMUniqueGroup>
	implements GEMUniqueGroup {
	public GEMUniqueGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMUniqueGroup.class;
	}

	@Override
	public String getModelClassName() {
		return GEMUniqueGroup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _uniqueGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUniqueGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _uniqueGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("groupName", getGroupName());
		attributes.put("regionId", getRegionId());
		attributes.put("policyId", getPolicyId());
		attributes.put("levelId", getLevelId());
		attributes.put("groupType", getGroupType());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uniqueGroupId = (Long)attributes.get("uniqueGroupId");

		if (uniqueGroupId != null) {
			setUniqueGroupId(uniqueGroupId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String policyId = (String)attributes.get("policyId");

		if (policyId != null) {
			setPolicyId(policyId);
		}

		String levelId = (String)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		String groupType = (String)attributes.get("groupType");

		if (groupType != null) {
			setGroupType(groupType);
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
	public long getUniqueGroupId() {
		return _uniqueGroupId;
	}

	@Override
	public void setUniqueGroupId(long uniqueGroupId) {
		_uniqueGroupId = uniqueGroupId;

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUniqueGroupId", long.class);

				method.invoke(_gemUniqueGroupRemoteModel, uniqueGroupId);
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

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDeptId", long.class);

				method.invoke(_gemUniqueGroupRemoteModel, publishDeptId);
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

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_gemUniqueGroupRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupName() {
		return _groupName;
	}

	@Override
	public void setGroupName(String groupName) {
		_groupName = groupName;

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupName", String.class);

				method.invoke(_gemUniqueGroupRemoteModel, groupName);
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

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemUniqueGroupRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPolicyId() {
		return _policyId;
	}

	@Override
	public void setPolicyId(String policyId) {
		_policyId = policyId;

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setPolicyId", String.class);

				method.invoke(_gemUniqueGroupRemoteModel, policyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLevelId() {
		return _levelId;
	}

	@Override
	public void setLevelId(String levelId) {
		_levelId = levelId;

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelId", String.class);

				method.invoke(_gemUniqueGroupRemoteModel, levelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupType() {
		return _groupType;
	}

	@Override
	public void setGroupType(String groupType) {
		_groupType = groupType;

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupType", String.class);

				method.invoke(_gemUniqueGroupRemoteModel, groupType);
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

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemUniqueGroupRemoteModel, creatorId);
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

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemUniqueGroupRemoteModel, createdDate);
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

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemUniqueGroupRemoteModel, updatedBy);
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

		if (_gemUniqueGroupRemoteModel != null) {
			try {
				Class<?> clazz = _gemUniqueGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemUniqueGroupRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMUniqueGroupRemoteModel() {
		return _gemUniqueGroupRemoteModel;
	}

	public void setGEMUniqueGroupRemoteModel(
		BaseModel<?> gemUniqueGroupRemoteModel) {
		_gemUniqueGroupRemoteModel = gemUniqueGroupRemoteModel;
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

		Class<?> remoteModelClass = _gemUniqueGroupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemUniqueGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMUniqueGroupLocalServiceUtil.addGEMUniqueGroup(this);
		}
		else {
			GEMUniqueGroupLocalServiceUtil.updateGEMUniqueGroup(this);
		}
	}

	@Override
	public GEMUniqueGroup toEscapedModel() {
		return (GEMUniqueGroup)ProxyUtil.newProxyInstance(GEMUniqueGroup.class.getClassLoader(),
			new Class[] { GEMUniqueGroup.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMUniqueGroupClp clone = new GEMUniqueGroupClp();

		clone.setUniqueGroupId(getUniqueGroupId());
		clone.setPublishDeptId(getPublishDeptId());
		clone.setPublishId(getPublishId());
		clone.setGroupName(getGroupName());
		clone.setRegionId(getRegionId());
		clone.setPolicyId(getPolicyId());
		clone.setLevelId(getLevelId());
		clone.setGroupType(getGroupType());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMUniqueGroup gemUniqueGroup) {
		long primaryKey = gemUniqueGroup.getPrimaryKey();

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

		if (!(obj instanceof GEMUniqueGroupClp)) {
			return false;
		}

		GEMUniqueGroupClp gemUniqueGroup = (GEMUniqueGroupClp)obj;

		long primaryKey = gemUniqueGroup.getPrimaryKey();

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

		sb.append("{uniqueGroupId=");
		sb.append(getUniqueGroupId());
		sb.append(", publishDeptId=");
		sb.append(getPublishDeptId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", groupName=");
		sb.append(getGroupName());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", policyId=");
		sb.append(getPolicyId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", groupType=");
		sb.append(getGroupType());
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
		sb.append("com.ihg.brandstandards.db.model.GEMUniqueGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uniqueGroupId</column-name><column-value><![CDATA[");
		sb.append(getUniqueGroupId());
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
			"<column><column-name>groupName</column-name><column-value><![CDATA[");
		sb.append(getGroupName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>policyId</column-name><column-value><![CDATA[");
		sb.append(getPolicyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupType</column-name><column-value><![CDATA[");
		sb.append(getGroupType());
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

	private long _uniqueGroupId;
	private long _publishDeptId;
	private long _publishId;
	private String _groupName;
	private long _regionId;
	private String _policyId;
	private String _levelId;
	private String _groupType;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemUniqueGroupRemoteModel;
}