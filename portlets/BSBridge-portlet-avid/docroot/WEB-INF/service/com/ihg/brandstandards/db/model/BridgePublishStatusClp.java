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

import com.ihg.brandstandards.db.service.BridgePublishStatusLocalServiceUtil;
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
public class BridgePublishStatusClp extends BaseModelImpl<BridgePublishStatus>
	implements BridgePublishStatus {
	public BridgePublishStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishStatus.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishStatus.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _publishStatusCode;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setPublishStatusCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishStatusCode;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishStatusCode", getPublishStatusCode());
		attributes.put("publishStatusName", getPublishStatusName());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publishStatusCode = (String)attributes.get("publishStatusCode");

		if (publishStatusCode != null) {
			setPublishStatusCode(publishStatusCode);
		}

		String publishStatusName = (String)attributes.get("publishStatusName");

		if (publishStatusName != null) {
			setPublishStatusName(publishStatusName);
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
	public String getPublishStatusCode() {
		return _publishStatusCode;
	}

	@Override
	public void setPublishStatusCode(String publishStatusCode) {
		_publishStatusCode = publishStatusCode;

		if (_bridgePublishStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishStatusCode",
						String.class);

				method.invoke(_bridgePublishStatusRemoteModel, publishStatusCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishStatusName() {
		return _publishStatusName;
	}

	@Override
	public void setPublishStatusName(String publishStatusName) {
		_publishStatusName = publishStatusName;

		if (_bridgePublishStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishStatusName",
						String.class);

				method.invoke(_bridgePublishStatusRemoteModel, publishStatusName);
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

		if (_bridgePublishStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgePublishStatusRemoteModel, creatorId);
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

		if (_bridgePublishStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgePublishStatusRemoteModel, createdDate);
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

		if (_bridgePublishStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgePublishStatusRemoteModel, updatedBy);
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

		if (_bridgePublishStatusRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgePublishStatusRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgePublishStatusRemoteModel() {
		return _bridgePublishStatusRemoteModel;
	}

	public void setBridgePublishStatusRemoteModel(
		BaseModel<?> bridgePublishStatusRemoteModel) {
		_bridgePublishStatusRemoteModel = bridgePublishStatusRemoteModel;
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

		Class<?> remoteModelClass = _bridgePublishStatusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgePublishStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgePublishStatusLocalServiceUtil.addBridgePublishStatus(this);
		}
		else {
			BridgePublishStatusLocalServiceUtil.updateBridgePublishStatus(this);
		}
	}

	@Override
	public BridgePublishStatus toEscapedModel() {
		return (BridgePublishStatus)ProxyUtil.newProxyInstance(BridgePublishStatus.class.getClassLoader(),
			new Class[] { BridgePublishStatus.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgePublishStatusClp clone = new BridgePublishStatusClp();

		clone.setPublishStatusCode(getPublishStatusCode());
		clone.setPublishStatusName(getPublishStatusName());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgePublishStatus bridgePublishStatus) {
		int value = 0;

		value = getPublishStatusCode()
					.compareTo(bridgePublishStatus.getPublishStatusCode());

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

		if (!(obj instanceof BridgePublishStatusClp)) {
			return false;
		}

		BridgePublishStatusClp bridgePublishStatus = (BridgePublishStatusClp)obj;

		String primaryKey = bridgePublishStatus.getPrimaryKey();

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

		sb.append("{publishStatusCode=");
		sb.append(getPublishStatusCode());
		sb.append(", publishStatusName=");
		sb.append(getPublishStatusName());
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
		sb.append("com.ihg.brandstandards.db.model.BridgePublishStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishStatusCode</column-name><column-value><![CDATA[");
		sb.append(getPublishStatusCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishStatusName</column-name><column-value><![CDATA[");
		sb.append(getPublishStatusName());
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

	private String _publishStatusCode;
	private String _publishStatusName;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgePublishStatusRemoteModel;
}