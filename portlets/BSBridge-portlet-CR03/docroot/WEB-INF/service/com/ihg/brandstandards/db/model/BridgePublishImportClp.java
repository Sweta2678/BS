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

import com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil;
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
public class BridgePublishImportClp extends BaseModelImpl<BridgePublishImport>
	implements BridgePublishImport {
	public BridgePublishImportClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishImport.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishImport.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publishImportId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishImportId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishImportId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishImportId", getPublishImportId());
		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("selectInd", getSelectInd());
		attributes.put("regionId", getRegionId());
		attributes.put("status", getStatus());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishImportId = (Long)attributes.get("publishImportId");

		if (publishImportId != null) {
			setPublishImportId(publishImportId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String selectInd = (String)attributes.get("selectInd");

		if (selectInd != null) {
			setSelectInd(selectInd);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public long getPublishImportId() {
		return _publishImportId;
	}

	@Override
	public void setPublishImportId(long publishImportId) {
		_publishImportId = publishImportId;

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishImportId", long.class);

				method.invoke(_bridgePublishImportRemoteModel, publishImportId);
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

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_bridgePublishImportRemoteModel, publishId);
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

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_bridgePublishImportRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSelectInd() {
		return _selectInd;
	}

	@Override
	public void setSelectInd(String selectInd) {
		_selectInd = selectInd;

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setSelectInd", String.class);

				method.invoke(_bridgePublishImportRemoteModel, selectInd);
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

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_bridgePublishImportRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_bridgePublishImportRemoteModel, status);
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

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgePublishImportRemoteModel, creatorId);
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

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgePublishImportRemoteModel, createdDate);
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

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgePublishImportRemoteModel, updatedBy);
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

		if (_bridgePublishImportRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishImportRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgePublishImportRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgePublishImportRemoteModel() {
		return _bridgePublishImportRemoteModel;
	}

	public void setBridgePublishImportRemoteModel(
		BaseModel<?> bridgePublishImportRemoteModel) {
		_bridgePublishImportRemoteModel = bridgePublishImportRemoteModel;
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

		Class<?> remoteModelClass = _bridgePublishImportRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgePublishImportRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgePublishImportLocalServiceUtil.addBridgePublishImport(this);
		}
		else {
			BridgePublishImportLocalServiceUtil.updateBridgePublishImport(this);
		}
	}

	@Override
	public BridgePublishImport toEscapedModel() {
		return (BridgePublishImport)ProxyUtil.newProxyInstance(BridgePublishImport.class.getClassLoader(),
			new Class[] { BridgePublishImport.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgePublishImportClp clone = new BridgePublishImportClp();

		clone.setPublishImportId(getPublishImportId());
		clone.setPublishId(getPublishId());
		clone.setStdId(getStdId());
		clone.setSelectInd(getSelectInd());
		clone.setRegionId(getRegionId());
		clone.setStatus(getStatus());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgePublishImport bridgePublishImport) {
		long primaryKey = bridgePublishImport.getPrimaryKey();

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

		if (!(obj instanceof BridgePublishImportClp)) {
			return false;
		}

		BridgePublishImportClp bridgePublishImport = (BridgePublishImportClp)obj;

		long primaryKey = bridgePublishImport.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{publishImportId=");
		sb.append(getPublishImportId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", selectInd=");
		sb.append(getSelectInd());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", status=");
		sb.append(getStatus());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgePublishImport");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishImportId</column-name><column-value><![CDATA[");
		sb.append(getPublishImportId());
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
			"<column><column-name>selectInd</column-name><column-value><![CDATA[");
		sb.append(getSelectInd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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

	private long _publishImportId;
	private long _publishId;
	private long _stdId;
	private String _selectInd;
	private long _regionId;
	private String _status;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgePublishImportRemoteModel;
}