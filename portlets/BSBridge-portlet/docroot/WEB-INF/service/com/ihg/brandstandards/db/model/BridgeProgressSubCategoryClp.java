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

import com.ihg.brandstandards.db.service.BridgeProgressSubCategoryLocalServiceUtil;
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
public class BridgeProgressSubCategoryClp extends BaseModelImpl<BridgeProgressSubCategory>
	implements BridgeProgressSubCategory {
	public BridgeProgressSubCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeProgressSubCategory.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeProgressSubCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _progressSubCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProgressSubCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _progressSubCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("progressSubCategoryId", getProgressSubCategoryId());
		attributes.put("progressCategoryId", getProgressCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long progressSubCategoryId = (Long)attributes.get(
				"progressSubCategoryId");

		if (progressSubCategoryId != null) {
			setProgressSubCategoryId(progressSubCategoryId);
		}

		Long progressCategoryId = (Long)attributes.get("progressCategoryId");

		if (progressCategoryId != null) {
			setProgressCategoryId(progressCategoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
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
	public long getProgressSubCategoryId() {
		return _progressSubCategoryId;
	}

	@Override
	public void setProgressSubCategoryId(long progressSubCategoryId) {
		_progressSubCategoryId = progressSubCategoryId;

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressSubCategoryId",
						long.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel,
					progressSubCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProgressCategoryId() {
		return _progressCategoryId;
	}

	@Override
	public void setProgressCategoryId(long progressCategoryId) {
		_progressCategoryId = progressCategoryId;

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressCategoryId",
						long.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel,
					progressCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategoryName() {
		return _categoryName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryName", String.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel,
					categoryName);
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

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel,
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

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel, creatorId);
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

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel, createdDate);
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

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel, updatedBy);
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

		if (_bridgeProgressSubCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressSubCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgeProgressSubCategoryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgeProgressSubCategoryRemoteModel() {
		return _bridgeProgressSubCategoryRemoteModel;
	}

	public void setBridgeProgressSubCategoryRemoteModel(
		BaseModel<?> bridgeProgressSubCategoryRemoteModel) {
		_bridgeProgressSubCategoryRemoteModel = bridgeProgressSubCategoryRemoteModel;
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

		Class<?> remoteModelClass = _bridgeProgressSubCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgeProgressSubCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgeProgressSubCategoryLocalServiceUtil.addBridgeProgressSubCategory(this);
		}
		else {
			BridgeProgressSubCategoryLocalServiceUtil.updateBridgeProgressSubCategory(this);
		}
	}

	@Override
	public BridgeProgressSubCategory toEscapedModel() {
		return (BridgeProgressSubCategory)ProxyUtil.newProxyInstance(BridgeProgressSubCategory.class.getClassLoader(),
			new Class[] { BridgeProgressSubCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgeProgressSubCategoryClp clone = new BridgeProgressSubCategoryClp();

		clone.setProgressSubCategoryId(getProgressSubCategoryId());
		clone.setProgressCategoryId(getProgressCategoryId());
		clone.setCategoryName(getCategoryName());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgeProgressSubCategory bridgeProgressSubCategory) {
		long primaryKey = bridgeProgressSubCategory.getPrimaryKey();

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

		if (!(obj instanceof BridgeProgressSubCategoryClp)) {
			return false;
		}

		BridgeProgressSubCategoryClp bridgeProgressSubCategory = (BridgeProgressSubCategoryClp)obj;

		long primaryKey = bridgeProgressSubCategory.getPrimaryKey();

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

		sb.append("{progressSubCategoryId=");
		sb.append(getProgressSubCategoryId());
		sb.append(", progressCategoryId=");
		sb.append(getProgressCategoryId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgeProgressSubCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>progressSubCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProgressSubCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProgressCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
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

	private long _progressSubCategoryId;
	private long _progressCategoryId;
	private String _categoryName;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgeProgressSubCategoryRemoteModel;
}