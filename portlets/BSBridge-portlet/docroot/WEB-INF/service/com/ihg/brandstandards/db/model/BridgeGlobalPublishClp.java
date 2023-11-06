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

import com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil;
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
public class BridgeGlobalPublishClp extends BaseModelImpl<BridgeGlobalPublish>
	implements BridgeGlobalPublish {
	public BridgeGlobalPublishClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeGlobalPublish.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeGlobalPublish.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _globalPublishId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlobalPublishId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _globalPublishId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("globalPublishId", getGlobalPublishId());
		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("mustPublishInd", getMustPublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long globalPublishId = (Long)attributes.get("globalPublishId");

		if (globalPublishId != null) {
			setGlobalPublishId(globalPublishId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String mustPublishInd = (String)attributes.get("mustPublishInd");

		if (mustPublishInd != null) {
			setMustPublishInd(mustPublishInd);
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
	public long getGlobalPublishId() {
		return _globalPublishId;
	}

	@Override
	public void setGlobalPublishId(long globalPublishId) {
		_globalPublishId = globalPublishId;

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setGlobalPublishId", long.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, globalPublishId);
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

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, publishId);
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

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMustPublishInd() {
		return _mustPublishInd;
	}

	@Override
	public void setMustPublishInd(String mustPublishInd) {
		_mustPublishInd = mustPublishInd;

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setMustPublishInd",
						String.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, mustPublishInd);
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

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, creatorId);
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

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, createdDate);
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

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, updatedBy);
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

		if (_bridgeGlobalPublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgeGlobalPublishRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgeGlobalPublishRemoteModel() {
		return _bridgeGlobalPublishRemoteModel;
	}

	public void setBridgeGlobalPublishRemoteModel(
		BaseModel<?> bridgeGlobalPublishRemoteModel) {
		_bridgeGlobalPublishRemoteModel = bridgeGlobalPublishRemoteModel;
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

		Class<?> remoteModelClass = _bridgeGlobalPublishRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgeGlobalPublishRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgeGlobalPublishLocalServiceUtil.addBridgeGlobalPublish(this);
		}
		else {
			BridgeGlobalPublishLocalServiceUtil.updateBridgeGlobalPublish(this);
		}
	}

	@Override
	public BridgeGlobalPublish toEscapedModel() {
		return (BridgeGlobalPublish)ProxyUtil.newProxyInstance(BridgeGlobalPublish.class.getClassLoader(),
			new Class[] { BridgeGlobalPublish.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgeGlobalPublishClp clone = new BridgeGlobalPublishClp();

		clone.setGlobalPublishId(getGlobalPublishId());
		clone.setPublishId(getPublishId());
		clone.setStdId(getStdId());
		clone.setMustPublishInd(getMustPublishInd());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgeGlobalPublish bridgeGlobalPublish) {
		int value = 0;

		if (getGlobalPublishId() < bridgeGlobalPublish.getGlobalPublishId()) {
			value = -1;
		}
		else if (getGlobalPublishId() > bridgeGlobalPublish.getGlobalPublishId()) {
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

		if (!(obj instanceof BridgeGlobalPublishClp)) {
			return false;
		}

		BridgeGlobalPublishClp bridgeGlobalPublish = (BridgeGlobalPublishClp)obj;

		long primaryKey = bridgeGlobalPublish.getPrimaryKey();

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

		sb.append("{globalPublishId=");
		sb.append(getGlobalPublishId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", mustPublishInd=");
		sb.append(getMustPublishInd());
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
		sb.append("com.ihg.brandstandards.db.model.BridgeGlobalPublish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>globalPublishId</column-name><column-value><![CDATA[");
		sb.append(getGlobalPublishId());
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
			"<column><column-name>mustPublishInd</column-name><column-value><![CDATA[");
		sb.append(getMustPublishInd());
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

	private long _globalPublishId;
	private long _publishId;
	private long _stdId;
	private String _mustPublishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgeGlobalPublishRemoteModel;
}