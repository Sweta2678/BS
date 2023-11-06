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
import com.ihg.brandstandards.db.service.UniqueGroupStandardLocalServiceUtil;

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
public class UniqueGroupStandardClp extends BaseModelImpl<UniqueGroupStandard>
	implements UniqueGroupStandard {
	public UniqueGroupStandardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UniqueGroupStandard.class;
	}

	@Override
	public String getModelClassName() {
		return UniqueGroupStandard.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _groupStandardId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupStandardId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupStandardId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupStandardId", getGroupStandardId());
		attributes.put("groupId", getGroupId());
		attributes.put("stdId", getStdId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupStandardId = (Long)attributes.get("groupStandardId");

		if (groupStandardId != null) {
			setGroupStandardId(groupStandardId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
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
	public long getGroupStandardId() {
		return _groupStandardId;
	}

	@Override
	public void setGroupStandardId(long groupStandardId) {
		_groupStandardId = groupStandardId;

		if (_uniqueGroupStandardRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupStandardId", long.class);

				method.invoke(_uniqueGroupStandardRemoteModel, groupStandardId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_uniqueGroupStandardRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_uniqueGroupStandardRemoteModel, groupId);
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

		if (_uniqueGroupStandardRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_uniqueGroupStandardRemoteModel, stdId);
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

		if (_uniqueGroupStandardRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_uniqueGroupStandardRemoteModel, creatorId);
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

		if (_uniqueGroupStandardRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_uniqueGroupStandardRemoteModel, createdDate);
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

		if (_uniqueGroupStandardRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_uniqueGroupStandardRemoteModel, updatedBy);
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

		if (_uniqueGroupStandardRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_uniqueGroupStandardRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUniqueGroupStandardRemoteModel() {
		return _uniqueGroupStandardRemoteModel;
	}

	public void setUniqueGroupStandardRemoteModel(
		BaseModel<?> uniqueGroupStandardRemoteModel) {
		_uniqueGroupStandardRemoteModel = uniqueGroupStandardRemoteModel;
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

		Class<?> remoteModelClass = _uniqueGroupStandardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_uniqueGroupStandardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UniqueGroupStandardLocalServiceUtil.addUniqueGroupStandard(this);
		}
		else {
			UniqueGroupStandardLocalServiceUtil.updateUniqueGroupStandard(this);
		}
	}

	@Override
	public UniqueGroupStandard toEscapedModel() {
		return (UniqueGroupStandard)ProxyUtil.newProxyInstance(UniqueGroupStandard.class.getClassLoader(),
			new Class[] { UniqueGroupStandard.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UniqueGroupStandardClp clone = new UniqueGroupStandardClp();

		clone.setGroupStandardId(getGroupStandardId());
		clone.setGroupId(getGroupId());
		clone.setStdId(getStdId());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(UniqueGroupStandard uniqueGroupStandard) {
		long primaryKey = uniqueGroupStandard.getPrimaryKey();

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

		if (!(obj instanceof UniqueGroupStandardClp)) {
			return false;
		}

		UniqueGroupStandardClp uniqueGroupStandard = (UniqueGroupStandardClp)obj;

		long primaryKey = uniqueGroupStandard.getPrimaryKey();

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

		sb.append("{groupStandardId=");
		sb.append(getGroupStandardId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", stdId=");
		sb.append(getStdId());
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
		sb.append("com.ihg.brandstandards.db.model.UniqueGroupStandard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupStandardId</column-name><column-value><![CDATA[");
		sb.append(getGroupStandardId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
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

	private long _groupStandardId;
	private long _groupId;
	private long _stdId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _uniqueGroupStandardRemoteModel;
}