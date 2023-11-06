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
import com.ihg.brandstandards.db.service.UniqueGroupCountryLocalServiceUtil;

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
public class UniqueGroupCountryClp extends BaseModelImpl<UniqueGroupCountry>
	implements UniqueGroupCountry {
	public UniqueGroupCountryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UniqueGroupCountry.class;
	}

	@Override
	public String getModelClassName() {
		return UniqueGroupCountry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _groupCountryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGroupCountryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _groupCountryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupCountryId", getGroupCountryId());
		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupCountryId = (Long)attributes.get("groupCountryId");

		if (groupCountryId != null) {
			setGroupCountryId(groupCountryId);
		}

		Long uniqueGroupId = (Long)attributes.get("uniqueGroupId");

		if (uniqueGroupId != null) {
			setUniqueGroupId(uniqueGroupId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
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
	public long getGroupCountryId() {
		return _groupCountryId;
	}

	@Override
	public void setGroupCountryId(long groupCountryId) {
		_groupCountryId = groupCountryId;

		if (_uniqueGroupCountryRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupCountryId", long.class);

				method.invoke(_uniqueGroupCountryRemoteModel, groupCountryId);
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

		if (_uniqueGroupCountryRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUniqueGroupId", long.class);

				method.invoke(_uniqueGroupCountryRemoteModel, uniqueGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _countryCode;
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;

		if (_uniqueGroupCountryRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_uniqueGroupCountryRemoteModel, countryCode);
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

		if (_uniqueGroupCountryRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_uniqueGroupCountryRemoteModel, creatorId);
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

		if (_uniqueGroupCountryRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_uniqueGroupCountryRemoteModel, createdDate);
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

		if (_uniqueGroupCountryRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_uniqueGroupCountryRemoteModel, updatedBy);
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

		if (_uniqueGroupCountryRemoteModel != null) {
			try {
				Class<?> clazz = _uniqueGroupCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_uniqueGroupCountryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUniqueGroupCountryRemoteModel() {
		return _uniqueGroupCountryRemoteModel;
	}

	public void setUniqueGroupCountryRemoteModel(
		BaseModel<?> uniqueGroupCountryRemoteModel) {
		_uniqueGroupCountryRemoteModel = uniqueGroupCountryRemoteModel;
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

		Class<?> remoteModelClass = _uniqueGroupCountryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_uniqueGroupCountryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UniqueGroupCountryLocalServiceUtil.addUniqueGroupCountry(this);
		}
		else {
			UniqueGroupCountryLocalServiceUtil.updateUniqueGroupCountry(this);
		}
	}

	@Override
	public UniqueGroupCountry toEscapedModel() {
		return (UniqueGroupCountry)ProxyUtil.newProxyInstance(UniqueGroupCountry.class.getClassLoader(),
			new Class[] { UniqueGroupCountry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UniqueGroupCountryClp clone = new UniqueGroupCountryClp();

		clone.setGroupCountryId(getGroupCountryId());
		clone.setUniqueGroupId(getUniqueGroupId());
		clone.setCountryCode(getCountryCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(UniqueGroupCountry uniqueGroupCountry) {
		long primaryKey = uniqueGroupCountry.getPrimaryKey();

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

		if (!(obj instanceof UniqueGroupCountryClp)) {
			return false;
		}

		UniqueGroupCountryClp uniqueGroupCountry = (UniqueGroupCountryClp)obj;

		long primaryKey = uniqueGroupCountry.getPrimaryKey();

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

		sb.append("{groupCountryId=");
		sb.append(getGroupCountryId());
		sb.append(", uniqueGroupId=");
		sb.append(getUniqueGroupId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
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
		sb.append("com.ihg.brandstandards.db.model.UniqueGroupCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>groupCountryId</column-name><column-value><![CDATA[");
		sb.append(getGroupCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uniqueGroupId</column-name><column-value><![CDATA[");
		sb.append(getUniqueGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
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

	private long _groupCountryId;
	private long _uniqueGroupId;
	private String _countryCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _uniqueGroupCountryRemoteModel;
}