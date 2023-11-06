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

import com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;

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
public class ChainAttachmentsStandardsClp extends BaseModelImpl<ChainAttachmentsStandards>
	implements ChainAttachmentsStandards {
	public ChainAttachmentsStandardsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ChainAttachmentsStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ChainAttachmentsStandards.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _chainAttachmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setChainAttachmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _chainAttachmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chainAttachmentId", getChainAttachmentId());
		attributes.put("attachmentId", getAttachmentId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long chainAttachmentId = (Long)attributes.get("chainAttachmentId");

		if (chainAttachmentId != null) {
			setChainAttachmentId(chainAttachmentId);
		}

		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
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
	public long getChainAttachmentId() {
		return _chainAttachmentId;
	}

	@Override
	public void setChainAttachmentId(long chainAttachmentId) {
		_chainAttachmentId = chainAttachmentId;

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setChainAttachmentId",
						long.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel,
					chainAttachmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAttachmentId() {
		return _attachmentId;
	}

	@Override
	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentId", long.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel,
					attachmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocaleCode() {
		return _localeCode;
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel, localeCode);
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

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel, chainCode);
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

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel, creatorId);
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

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel, createdDate);
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

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel, updatedBy);
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

		if (_chainAttachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _chainAttachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_chainAttachmentsStandardsRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getChainAttachmentsStandardsRemoteModel() {
		return _chainAttachmentsStandardsRemoteModel;
	}

	public void setChainAttachmentsStandardsRemoteModel(
		BaseModel<?> chainAttachmentsStandardsRemoteModel) {
		_chainAttachmentsStandardsRemoteModel = chainAttachmentsStandardsRemoteModel;
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

		Class<?> remoteModelClass = _chainAttachmentsStandardsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_chainAttachmentsStandardsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ChainAttachmentsStandardsLocalServiceUtil.addChainAttachmentsStandards(this);
		}
		else {
			ChainAttachmentsStandardsLocalServiceUtil.updateChainAttachmentsStandards(this);
		}
	}

	@Override
	public ChainAttachmentsStandards toEscapedModel() {
		return (ChainAttachmentsStandards)ProxyUtil.newProxyInstance(ChainAttachmentsStandards.class.getClassLoader(),
			new Class[] { ChainAttachmentsStandards.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ChainAttachmentsStandardsClp clone = new ChainAttachmentsStandardsClp();

		clone.setChainAttachmentId(getChainAttachmentId());
		clone.setAttachmentId(getAttachmentId());
		clone.setLocaleCode(getLocaleCode());
		clone.setChainCode(getChainCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(ChainAttachmentsStandards chainAttachmentsStandards) {
		long primaryKey = chainAttachmentsStandards.getPrimaryKey();

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

		if (!(obj instanceof ChainAttachmentsStandardsClp)) {
			return false;
		}

		ChainAttachmentsStandardsClp chainAttachmentsStandards = (ChainAttachmentsStandardsClp)obj;

		long primaryKey = chainAttachmentsStandards.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{chainAttachmentId=");
		sb.append(getChainAttachmentId());
		sb.append(", attachmentId=");
		sb.append(getAttachmentId());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.ChainAttachmentsStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>chainAttachmentId</column-name><column-value><![CDATA[");
		sb.append(getChainAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
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

	private long _chainAttachmentId;
	private long _attachmentId;
	private String _localeCode;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _chainAttachmentsStandardsRemoteModel;
}