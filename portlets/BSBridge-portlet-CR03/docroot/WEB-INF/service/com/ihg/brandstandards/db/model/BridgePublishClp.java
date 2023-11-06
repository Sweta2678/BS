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

import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
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
public class BridgePublishClp extends BaseModelImpl<BridgePublish>
	implements BridgePublish {
	public BridgePublishClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublish.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublish.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _bridgePublishId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBridgePublishId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bridgePublishId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bridgePublishId", getBridgePublishId());
		attributes.put("publishId", getPublishId());
		attributes.put("standardId", getStandardId());
		attributes.put("regionId", getRegionId());
		attributes.put("unpublishInd", getUnpublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bridgePublishId = (Long)attributes.get("bridgePublishId");

		if (bridgePublishId != null) {
			setBridgePublishId(bridgePublishId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long standardId = (Long)attributes.get("standardId");

		if (standardId != null) {
			setStandardId(standardId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String unpublishInd = (String)attributes.get("unpublishInd");

		if (unpublishInd != null) {
			setUnpublishInd(unpublishInd);
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
	public long getBridgePublishId() {
		return _bridgePublishId;
	}

	@Override
	public void setBridgePublishId(long bridgePublishId) {
		_bridgePublishId = bridgePublishId;

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setBridgePublishId", long.class);

				method.invoke(_bridgePublishRemoteModel, bridgePublishId);
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

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_bridgePublishRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStandardId() {
		return _standardId;
	}

	@Override
	public void setStandardId(long standardId) {
		_standardId = standardId;

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setStandardId", long.class);

				method.invoke(_bridgePublishRemoteModel, standardId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_regionId = regionId;

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_bridgePublishRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnpublishInd() {
		return _unpublishInd;
	}

	@Override
	public void setUnpublishInd(String unpublishInd) {
		_unpublishInd = unpublishInd;

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setUnpublishInd", String.class);

				method.invoke(_bridgePublishRemoteModel, unpublishInd);
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

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgePublishRemoteModel, creatorId);
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

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgePublishRemoteModel, createdDate);
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

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgePublishRemoteModel, updatedBy);
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

		if (_bridgePublishRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgePublishRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgePublishRemoteModel() {
		return _bridgePublishRemoteModel;
	}

	public void setBridgePublishRemoteModel(
		BaseModel<?> bridgePublishRemoteModel) {
		_bridgePublishRemoteModel = bridgePublishRemoteModel;
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

		Class<?> remoteModelClass = _bridgePublishRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgePublishRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgePublishLocalServiceUtil.addBridgePublish(this);
		}
		else {
			BridgePublishLocalServiceUtil.updateBridgePublish(this);
		}
	}

	@Override
	public BridgePublish toEscapedModel() {
		return (BridgePublish)ProxyUtil.newProxyInstance(BridgePublish.class.getClassLoader(),
			new Class[] { BridgePublish.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgePublishClp clone = new BridgePublishClp();

		clone.setBridgePublishId(getBridgePublishId());
		clone.setPublishId(getPublishId());
		clone.setStandardId(getStandardId());
		clone.setRegionId(getRegionId());
		clone.setUnpublishInd(getUnpublishInd());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgePublish bridgePublish) {
		int value = 0;

		if (getBridgePublishId() < bridgePublish.getBridgePublishId()) {
			value = -1;
		}
		else if (getBridgePublishId() > bridgePublish.getBridgePublishId()) {
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

		if (!(obj instanceof BridgePublishClp)) {
			return false;
		}

		BridgePublishClp bridgePublish = (BridgePublishClp)obj;

		long primaryKey = bridgePublish.getPrimaryKey();

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

		sb.append("{bridgePublishId=");
		sb.append(getBridgePublishId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", standardId=");
		sb.append(getStandardId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", unpublishInd=");
		sb.append(getUnpublishInd());
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
		sb.append("com.ihg.brandstandards.db.model.BridgePublish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bridgePublishId</column-name><column-value><![CDATA[");
		sb.append(getBridgePublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>standardId</column-name><column-value><![CDATA[");
		sb.append(getStandardId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unpublishInd</column-name><column-value><![CDATA[");
		sb.append(getUnpublishInd());
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

	private long _bridgePublishId;
	private long _publishId;
	private long _standardId;
	private long _regionId;
	private String _unpublishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgePublishRemoteModel;
}