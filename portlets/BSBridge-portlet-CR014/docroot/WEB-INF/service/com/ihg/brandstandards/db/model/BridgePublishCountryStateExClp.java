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

import com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class BridgePublishCountryStateExClp extends BaseModelImpl<BridgePublishCountryStateEx>
	implements BridgePublishCountryStateEx {
	public BridgePublishCountryStateExClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishCountryStateEx.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishCountryStateEx.class.getName();
	}

	@Override
	public BridgePublishCountryStateExPK getPrimaryKey() {
		return new BridgePublishCountryStateExPK(_stdId, _CountryCode);
	}

	@Override
	public void setPrimaryKey(BridgePublishCountryStateExPK primaryKey) {
		setStdId(primaryKey.stdId);
		setCountryCode(primaryKey.CountryCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new BridgePublishCountryStateExPK(_stdId, _CountryCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BridgePublishCountryStateExPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("CountryCode", getCountryCode());
		attributes.put("parentStdId", getParentStdId());
		attributes.put("type", getType());
		attributes.put("publishId", getPublishId());
		attributes.put("stateCd", getStateCd());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String CountryCode = (String)attributes.get("CountryCode");

		if (CountryCode != null) {
			setCountryCode(CountryCode);
		}

		Long parentStdId = (Long)attributes.get("parentStdId");

		if (parentStdId != null) {
			setParentStdId(parentStdId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String stateCd = (String)attributes.get("stateCd");

		if (stateCd != null) {
			setStateCd(stateCd);
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_bridgePublishCountryStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_bridgePublishCountryStateExRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _CountryCode;
	}

	@Override
	public void setCountryCode(String CountryCode) {
		_CountryCode = CountryCode;

		if (_bridgePublishCountryStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_bridgePublishCountryStateExRemoteModel,
					CountryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentStdId() {
		return _parentStdId;
	}

	@Override
	public void setParentStdId(long parentStdId) {
		_parentStdId = parentStdId;

		if (_bridgePublishCountryStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setParentStdId", long.class);

				method.invoke(_bridgePublishCountryStateExRemoteModel,
					parentStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_bridgePublishCountryStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_bridgePublishCountryStateExRemoteModel, type);
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

		if (_bridgePublishCountryStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_bridgePublishCountryStateExRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStateCd() {
		return _stateCd;
	}

	@Override
	public void setStateCd(String stateCd) {
		_stateCd = stateCd;

		if (_bridgePublishCountryStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setStateCd", String.class);

				method.invoke(_bridgePublishCountryStateExRemoteModel, stateCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgePublishCountryStateExRemoteModel() {
		return _bridgePublishCountryStateExRemoteModel;
	}

	public void setBridgePublishCountryStateExRemoteModel(
		BaseModel<?> bridgePublishCountryStateExRemoteModel) {
		_bridgePublishCountryStateExRemoteModel = bridgePublishCountryStateExRemoteModel;
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

		Class<?> remoteModelClass = _bridgePublishCountryStateExRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgePublishCountryStateExRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgePublishCountryStateExLocalServiceUtil.addBridgePublishCountryStateEx(this);
		}
		else {
			BridgePublishCountryStateExLocalServiceUtil.updateBridgePublishCountryStateEx(this);
		}
	}

	@Override
	public BridgePublishCountryStateEx toEscapedModel() {
		return (BridgePublishCountryStateEx)ProxyUtil.newProxyInstance(BridgePublishCountryStateEx.class.getClassLoader(),
			new Class[] { BridgePublishCountryStateEx.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgePublishCountryStateExClp clone = new BridgePublishCountryStateExClp();

		clone.setStdId(getStdId());
		clone.setCountryCode(getCountryCode());
		clone.setParentStdId(getParentStdId());
		clone.setType(getType());
		clone.setPublishId(getPublishId());
		clone.setStateCd(getStateCd());

		return clone;
	}

	@Override
	public int compareTo(
		BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		BridgePublishCountryStateExPK primaryKey = bridgePublishCountryStateEx.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishCountryStateExClp)) {
			return false;
		}

		BridgePublishCountryStateExClp bridgePublishCountryStateEx = (BridgePublishCountryStateExClp)obj;

		BridgePublishCountryStateExPK primaryKey = bridgePublishCountryStateEx.getPrimaryKey();

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

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", CountryCode=");
		sb.append(getCountryCode());
		sb.append(", parentStdId=");
		sb.append(getParentStdId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", stateCd=");
		sb.append(getStateCd());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgePublishCountryStateEx");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CountryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentStdId</column-name><column-value><![CDATA[");
		sb.append(getParentStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateCd</column-name><column-value><![CDATA[");
		sb.append(getStateCd());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stdId;
	private String _CountryCode;
	private long _parentStdId;
	private String _type;
	private long _publishId;
	private String _stateCd;
	private BaseModel<?> _bridgePublishCountryStateExRemoteModel;
}