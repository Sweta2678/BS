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

import com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK;

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
public class ChainExternalLinkStandardsClp extends BaseModelImpl<ChainExternalLinkStandards>
	implements ChainExternalLinkStandards {
	public ChainExternalLinkStandardsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChainExternalLinkStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ChainExternalLinkStandards.class.getName();
	}

	@Override
	public ChainExternalLinkStandardsPK getPrimaryKey() {
		return new ChainExternalLinkStandardsPK(_extLinkId, _chainCode);
	}

	@Override
	public void setPrimaryKey(ChainExternalLinkStandardsPK primaryKey) {
		setExtLinkId(primaryKey.extLinkId);
		setChainCode(primaryKey.chainCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ChainExternalLinkStandardsPK(_extLinkId, _chainCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ChainExternalLinkStandardsPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("extLinkId", getExtLinkId());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long extLinkId = (Long)attributes.get("extLinkId");

		if (extLinkId != null) {
			setExtLinkId(extLinkId);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
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
	public long getExtLinkId() {
		return _extLinkId;
	}

	@Override
	public void setExtLinkId(long extLinkId) {
		_extLinkId = extLinkId;

		if (_chainExternalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainExternalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtLinkId", long.class);

				method.invoke(_chainExternalLinkStandardsRemoteModel, extLinkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChainCode() {
		return _chainCode;
	}

	@Override
	public void setChainCode(String chainCode) {
		_chainCode = chainCode;

		if (_chainExternalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainExternalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_chainExternalLinkStandardsRemoteModel, chainCode);
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

		if (_chainExternalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainExternalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_chainExternalLinkStandardsRemoteModel, creatorId);
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

		if (_chainExternalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainExternalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_chainExternalLinkStandardsRemoteModel,
					createdDate);
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

		if (_chainExternalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainExternalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_chainExternalLinkStandardsRemoteModel, updatedBy);
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

		if (_chainExternalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainExternalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_chainExternalLinkStandardsRemoteModel,
					updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getChainExternalLinkStandardsRemoteModel() {
		return _chainExternalLinkStandardsRemoteModel;
	}

	public void setChainExternalLinkStandardsRemoteModel(
		BaseModel<?> chainExternalLinkStandardsRemoteModel) {
		_chainExternalLinkStandardsRemoteModel = chainExternalLinkStandardsRemoteModel;
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

		Class<?> remoteModelClass = _chainExternalLinkStandardsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_chainExternalLinkStandardsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChainExternalLinkStandardsLocalServiceUtil.addChainExternalLinkStandards(this);
		}
		else {
			ChainExternalLinkStandardsLocalServiceUtil.updateChainExternalLinkStandards(this);
		}
	}

	@Override
	public ChainExternalLinkStandards toEscapedModel() {
		return (ChainExternalLinkStandards)ProxyUtil.newProxyInstance(ChainExternalLinkStandards.class.getClassLoader(),
			new Class[] { ChainExternalLinkStandards.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChainExternalLinkStandardsClp clone = new ChainExternalLinkStandardsClp();

		clone.setExtLinkId(getExtLinkId());
		clone.setChainCode(getChainCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(ChainExternalLinkStandards chainExternalLinkStandards) {
		ChainExternalLinkStandardsPK primaryKey = chainExternalLinkStandards.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChainExternalLinkStandardsClp)) {
			return false;
		}

		ChainExternalLinkStandardsClp chainExternalLinkStandards = (ChainExternalLinkStandardsClp)obj;

		ChainExternalLinkStandardsPK primaryKey = chainExternalLinkStandards.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{extLinkId=");
		sb.append(getExtLinkId());
		sb.append(", chainCode=");
		sb.append(getChainCode());
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
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.ChainExternalLinkStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>extLinkId</column-name><column-value><![CDATA[");
		sb.append(getExtLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
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

	private long _extLinkId;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _chainExternalLinkStandardsRemoteModel;
}