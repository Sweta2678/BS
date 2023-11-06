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

import com.ihg.brandstandards.db.service.BridgePublishCountryLocalServiceUtil;
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
public class BridgePublishCountryClp extends BaseModelImpl<BridgePublishCountry>
	implements BridgePublishCountry {
	public BridgePublishCountryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishCountry.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishCountry.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publishCtryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishCtryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishCtryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishCtryId", getPublishCtryId());
		attributes.put("bridgePublishId", getBridgePublishId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("statusCode", getStatusCode());
		attributes.put("publishInd", getPublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishCtryId = (Long)attributes.get("publishCtryId");

		if (publishCtryId != null) {
			setPublishCtryId(publishCtryId);
		}

		Long bridgePublishId = (Long)attributes.get("bridgePublishId");

		if (bridgePublishId != null) {
			setBridgePublishId(bridgePublishId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String statusCode = (String)attributes.get("statusCode");

		if (statusCode != null) {
			setStatusCode(statusCode);
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
	public long getPublishCtryId() {
		return _publishCtryId;
	}

	@Override
	public void setPublishCtryId(long publishCtryId) {
		_publishCtryId = publishCtryId;

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishCtryId", long.class);

				method.invoke(_bridgePublishCountryRemoteModel, publishCtryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBridgePublishId() {
		return _bridgePublishId;
	}

	@Override
	public void setBridgePublishId(long bridgePublishId) {
		_bridgePublishId = bridgePublishId;

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setBridgePublishId", long.class);

				method.invoke(_bridgePublishCountryRemoteModel, bridgePublishId);
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

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_bridgePublishCountryRemoteModel, countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusCode() {
		return _statusCode;
	}

	@Override
	public void setStatusCode(String statusCode) {
		_statusCode = statusCode;

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusCode", String.class);

				method.invoke(_bridgePublishCountryRemoteModel, statusCode);
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

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishInd", String.class);

				method.invoke(_bridgePublishCountryRemoteModel, publishInd);
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

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgePublishCountryRemoteModel, creatorId);
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

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgePublishCountryRemoteModel, createdDate);
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

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgePublishCountryRemoteModel, updatedBy);
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

		if (_bridgePublishCountryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgePublishCountryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgePublishCountryRemoteModel() {
		return _bridgePublishCountryRemoteModel;
	}

	public void setBridgePublishCountryRemoteModel(
		BaseModel<?> bridgePublishCountryRemoteModel) {
		_bridgePublishCountryRemoteModel = bridgePublishCountryRemoteModel;
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

		Class<?> remoteModelClass = _bridgePublishCountryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgePublishCountryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgePublishCountryLocalServiceUtil.addBridgePublishCountry(this);
		}
		else {
			BridgePublishCountryLocalServiceUtil.updateBridgePublishCountry(this);
		}
	}

	@Override
	public BridgePublishCountry toEscapedModel() {
		return (BridgePublishCountry)ProxyUtil.newProxyInstance(BridgePublishCountry.class.getClassLoader(),
			new Class[] { BridgePublishCountry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgePublishCountryClp clone = new BridgePublishCountryClp();

		clone.setPublishCtryId(getPublishCtryId());
		clone.setBridgePublishId(getBridgePublishId());
		clone.setCountryCode(getCountryCode());
		clone.setStatusCode(getStatusCode());
		clone.setPublishInd(getPublishInd());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgePublishCountry bridgePublishCountry) {
		int value = 0;

		if (getPublishCtryId() < bridgePublishCountry.getPublishCtryId()) {
			value = -1;
		}
		else if (getPublishCtryId() > bridgePublishCountry.getPublishCtryId()) {
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

		if (!(obj instanceof BridgePublishCountryClp)) {
			return false;
		}

		BridgePublishCountryClp bridgePublishCountry = (BridgePublishCountryClp)obj;

		long primaryKey = bridgePublishCountry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{publishCtryId=");
		sb.append(getPublishCtryId());
		sb.append(", bridgePublishId=");
		sb.append(getBridgePublishId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", statusCode=");
		sb.append(getStatusCode());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgePublishCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishCtryId</column-name><column-value><![CDATA[");
		sb.append(getPublishCtryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bridgePublishId</column-name><column-value><![CDATA[");
		sb.append(getBridgePublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusCode</column-name><column-value><![CDATA[");
		sb.append(getStatusCode());
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

	private long _publishCtryId;
	private long _bridgePublishId;
	private String _countryCode;
	private String _statusCode;
	private String _publishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgePublishCountryRemoteModel;
}