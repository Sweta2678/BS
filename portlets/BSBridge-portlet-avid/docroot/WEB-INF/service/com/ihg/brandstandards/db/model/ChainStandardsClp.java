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

import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.persistence.ChainStandardsPK;

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
public class ChainStandardsClp extends BaseModelImpl<ChainStandards>
	implements ChainStandards {
	public ChainStandardsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChainStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ChainStandards.class.getName();
	}

	@Override
	public ChainStandardsPK getPrimaryKey() {
		return new ChainStandardsPK(_chainCode, _stdId);
	}

	@Override
	public void setPrimaryKey(ChainStandardsPK primaryKey) {
		setChainCode(primaryKey.chainCode);
		setStdId(primaryKey.stdId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ChainStandardsPK(_chainCode, _stdId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ChainStandardsPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chainCode", getChainCode());
		attributes.put("stdId", getStdId());
		attributes.put("statusId", getStatusId());
		attributes.put("isActive", getIsActive());
		attributes.put("lastPublishedDate", getLastPublishedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long statusId = (Long)attributes.get("statusId");

		if (statusId != null) {
			setStatusId(statusId);
		}

		String isActive = (String)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Date lastPublishedDate = (Date)attributes.get("lastPublishedDate");

		if (lastPublishedDate != null) {
			setLastPublishedDate(lastPublishedDate);
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
	public String getChainCode() {
		return _chainCode;
	}

	@Override
	public void setChainCode(String chainCode) {
		_chainCode = chainCode;

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_chainStandardsRemoteModel, chainCode);
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

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_chainStandardsRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusId() {
		return _statusId;
	}

	@Override
	public void setStatusId(long statusId) {
		_statusId = statusId;

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusId", long.class);

				method.invoke(_chainStandardsRemoteModel, statusId);
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

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", String.class);

				method.invoke(_chainStandardsRemoteModel, isActive);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastPublishedDate() {
		return _lastPublishedDate;
	}

	@Override
	public void setLastPublishedDate(Date lastPublishedDate) {
		_lastPublishedDate = lastPublishedDate;

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastPublishedDate",
						Date.class);

				method.invoke(_chainStandardsRemoteModel, lastPublishedDate);
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

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_chainStandardsRemoteModel, creatorId);
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

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_chainStandardsRemoteModel, createdDate);
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

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_chainStandardsRemoteModel, updatedBy);
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

		if (_chainStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_chainStandardsRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getChainStandardsRemoteModel() {
		return _chainStandardsRemoteModel;
	}

	public void setChainStandardsRemoteModel(
		BaseModel<?> chainStandardsRemoteModel) {
		_chainStandardsRemoteModel = chainStandardsRemoteModel;
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

		Class<?> remoteModelClass = _chainStandardsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_chainStandardsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChainStandardsLocalServiceUtil.addChainStandards(this);
		}
		else {
			ChainStandardsLocalServiceUtil.updateChainStandards(this);
		}
	}

	@Override
	public ChainStandards toEscapedModel() {
		return (ChainStandards)ProxyUtil.newProxyInstance(ChainStandards.class.getClassLoader(),
			new Class[] { ChainStandards.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChainStandardsClp clone = new ChainStandardsClp();

		clone.setChainCode(getChainCode());
		clone.setStdId(getStdId());
		clone.setStatusId(getStatusId());
		clone.setIsActive(getIsActive());
		clone.setLastPublishedDate(getLastPublishedDate());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(ChainStandards chainStandards) {
		ChainStandardsPK primaryKey = chainStandards.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChainStandardsClp)) {
			return false;
		}

		ChainStandardsClp chainStandards = (ChainStandardsClp)obj;

		ChainStandardsPK primaryKey = chainStandards.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{chainCode=");
		sb.append(getChainCode());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", statusId=");
		sb.append(getStatusId());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", lastPublishedDate=");
		sb.append(getLastPublishedDate());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.ChainStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishedDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishedDate());
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

	private String _chainCode;
	private long _stdId;
	private long _statusId;
	private String _isActive;
	private Date _lastPublishedDate;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _chainStandardsRemoteModel;
}