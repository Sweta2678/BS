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

import com.ihg.brandstandards.db.service.BridgeProgressCategoryLocalServiceUtil;
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
public class BridgeProgressCategoryClp extends BaseModelImpl<BridgeProgressCategory>
	implements BridgeProgressCategory {
	public BridgeProgressCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeProgressCategory.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeProgressCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _progressCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProgressCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _progressCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("progressCategoryId", getProgressCategoryId());
		attributes.put("progressCategoryName", getProgressCategoryName());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long progressCategoryId = (Long)attributes.get("progressCategoryId");

		if (progressCategoryId != null) {
			setProgressCategoryId(progressCategoryId);
		}

		String progressCategoryName = (String)attributes.get(
				"progressCategoryName");

		if (progressCategoryName != null) {
			setProgressCategoryName(progressCategoryName);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
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
	public long getProgressCategoryId() {
		return _progressCategoryId;
	}

	@Override
	public void setProgressCategoryId(long progressCategoryId) {
		_progressCategoryId = progressCategoryId;

		if (_bridgeProgressCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressCategoryId",
						long.class);

				method.invoke(_bridgeProgressCategoryRemoteModel,
					progressCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProgressCategoryName() {
		return _progressCategoryName;
	}

	@Override
	public void setProgressCategoryName(String progressCategoryName) {
		_progressCategoryName = progressCategoryName;

		if (_bridgeProgressCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressCategoryName",
						String.class);

				method.invoke(_bridgeProgressCategoryRemoteModel,
					progressCategoryName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;

		if (_bridgeProgressCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_bridgeProgressCategoryRemoteModel,
					displayOrderNumber);
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

		if (_bridgeProgressCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgeProgressCategoryRemoteModel, creatorId);
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

		if (_bridgeProgressCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgeProgressCategoryRemoteModel, createdDate);
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

		if (_bridgeProgressCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgeProgressCategoryRemoteModel, updatedBy);
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

		if (_bridgeProgressCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgeProgressCategoryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgeProgressCategoryRemoteModel() {
		return _bridgeProgressCategoryRemoteModel;
	}

	public void setBridgeProgressCategoryRemoteModel(
		BaseModel<?> bridgeProgressCategoryRemoteModel) {
		_bridgeProgressCategoryRemoteModel = bridgeProgressCategoryRemoteModel;
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

		Class<?> remoteModelClass = _bridgeProgressCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgeProgressCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgeProgressCategoryLocalServiceUtil.addBridgeProgressCategory(this);
		}
		else {
			BridgeProgressCategoryLocalServiceUtil.updateBridgeProgressCategory(this);
		}
	}

	@Override
	public BridgeProgressCategory toEscapedModel() {
		return (BridgeProgressCategory)ProxyUtil.newProxyInstance(BridgeProgressCategory.class.getClassLoader(),
			new Class[] { BridgeProgressCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgeProgressCategoryClp clone = new BridgeProgressCategoryClp();

		clone.setProgressCategoryId(getProgressCategoryId());
		clone.setProgressCategoryName(getProgressCategoryName());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgeProgressCategory bridgeProgressCategory) {
		long primaryKey = bridgeProgressCategory.getPrimaryKey();

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

		if (!(obj instanceof BridgeProgressCategoryClp)) {
			return false;
		}

		BridgeProgressCategoryClp bridgeProgressCategory = (BridgeProgressCategoryClp)obj;

		long primaryKey = bridgeProgressCategory.getPrimaryKey();

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

		sb.append("{progressCategoryId=");
		sb.append(getProgressCategoryId());
		sb.append(", progressCategoryName=");
		sb.append(getProgressCategoryName());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
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
		sb.append("com.ihg.brandstandards.db.model.BridgeProgressCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>progressCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProgressCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressCategoryName</column-name><column-value><![CDATA[");
		sb.append(getProgressCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
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

	private long _progressCategoryId;
	private String _progressCategoryName;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgeProgressCategoryRemoteModel;
}