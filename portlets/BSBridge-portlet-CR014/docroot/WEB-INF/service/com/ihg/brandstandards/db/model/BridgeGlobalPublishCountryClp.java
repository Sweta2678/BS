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

import com.ihg.brandstandards.db.service.BridgeGlobalPublishCountryLocalServiceUtil;
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
public class BridgeGlobalPublishCountryClp extends BaseModelImpl<BridgeGlobalPublishCountry>
	implements BridgeGlobalPublishCountry {
	public BridgeGlobalPublishCountryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeGlobalPublishCountry.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeGlobalPublishCountry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _globalPublishCtryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlobalPublishCtryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _globalPublishCtryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("globalPublishCtryId", getGlobalPublishCtryId());
		attributes.put("globalPublishId", getGlobalPublishId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("publishInd", getPublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long globalPublishCtryId = (Long)attributes.get("globalPublishCtryId");

		if (globalPublishCtryId != null) {
			setGlobalPublishCtryId(globalPublishCtryId);
		}

		Long globalPublishId = (Long)attributes.get("globalPublishId");

		if (globalPublishId != null) {
			setGlobalPublishId(globalPublishId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String publishInd = (String)attributes.get("publishInd");

		if (publishInd != null) {
			setPublishInd(publishInd);
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
	public long getGlobalPublishCtryId() {
		return _globalPublishCtryId;
	}

	@Override
	public void setGlobalPublishCtryId(long globalPublishCtryId) {
		_globalPublishCtryId = globalPublishCtryId;

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setGlobalPublishCtryId",
						long.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel,
					globalPublishCtryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGlobalPublishId() {
		return _globalPublishId;
	}

	@Override
	public void setGlobalPublishId(long globalPublishId) {
		_globalPublishId = globalPublishId;

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setGlobalPublishId", long.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel,
					globalPublishId);
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

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel,
					countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishInd() {
		return _publishInd;
	}

	@Override
	public void setPublishInd(String publishInd) {
		_publishInd = publishInd;

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishInd", String.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel, publishInd);
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

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel, creatorId);
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

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel,
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

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel, updatedBy);
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

		if (_bridgeGlobalPublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeGlobalPublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgeGlobalPublishCountryRemoteModel,
					updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgeGlobalPublishCountryRemoteModel() {
		return _bridgeGlobalPublishCountryRemoteModel;
	}

	public void setBridgeGlobalPublishCountryRemoteModel(
		BaseModel<?> bridgeGlobalPublishCountryRemoteModel) {
		_bridgeGlobalPublishCountryRemoteModel = bridgeGlobalPublishCountryRemoteModel;
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

		Class<?> remoteModelClass = _bridgeGlobalPublishCountryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgeGlobalPublishCountryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgeGlobalPublishCountryLocalServiceUtil.addBridgeGlobalPublishCountry(this);
		}
		else {
			BridgeGlobalPublishCountryLocalServiceUtil.updateBridgeGlobalPublishCountry(this);
		}
	}

	@Override
	public BridgeGlobalPublishCountry toEscapedModel() {
		return (BridgeGlobalPublishCountry)ProxyUtil.newProxyInstance(BridgeGlobalPublishCountry.class.getClassLoader(),
			new Class[] { BridgeGlobalPublishCountry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgeGlobalPublishCountryClp clone = new BridgeGlobalPublishCountryClp();

		clone.setGlobalPublishCtryId(getGlobalPublishCtryId());
		clone.setGlobalPublishId(getGlobalPublishId());
		clone.setCountryCode(getCountryCode());
		clone.setPublishInd(getPublishInd());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		int value = 0;

		if (getGlobalPublishCtryId() < bridgeGlobalPublishCountry.getGlobalPublishCtryId()) {
			value = -1;
		}
		else if (getGlobalPublishCtryId() > bridgeGlobalPublishCountry.getGlobalPublishCtryId()) {
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

		if (!(obj instanceof BridgeGlobalPublishCountryClp)) {
			return false;
		}

		BridgeGlobalPublishCountryClp bridgeGlobalPublishCountry = (BridgeGlobalPublishCountryClp)obj;

		long primaryKey = bridgeGlobalPublishCountry.getPrimaryKey();

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

		sb.append("{globalPublishCtryId=");
		sb.append(getGlobalPublishCtryId());
		sb.append(", globalPublishId=");
		sb.append(getGlobalPublishId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", publishInd=");
		sb.append(getPublishInd());
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
		sb.append("com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>globalPublishCtryId</column-name><column-value><![CDATA[");
		sb.append(getGlobalPublishCtryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>globalPublishId</column-name><column-value><![CDATA[");
		sb.append(getGlobalPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishInd</column-name><column-value><![CDATA[");
		sb.append(getPublishInd());
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

	private long _globalPublishCtryId;
	private long _globalPublishId;
	private String _countryCode;
	private String _publishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgeGlobalPublishCountryRemoteModel;
}