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

import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class SpreadSheetAttributeUpdateClp extends BaseModelImpl<SpreadSheetAttributeUpdate>
	implements SpreadSheetAttributeUpdate {
	public SpreadSheetAttributeUpdateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SpreadSheetAttributeUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return SpreadSheetAttributeUpdate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _speardSheetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpeardSheetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _speardSheetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("speardSheetId", getSpeardSheetId());
		attributes.put("requestTitle", getRequestTitle());
		attributes.put("status", getStatus());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("spreadSheet", getSpreadSheet());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long speardSheetId = (Long)attributes.get("speardSheetId");

		if (speardSheetId != null) {
			setSpeardSheetId(speardSheetId);
		}

		String requestTitle = (String)attributes.get("requestTitle");

		if (requestTitle != null) {
			setRequestTitle(requestTitle);
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

		String spreadSheet = (String)attributes.get("spreadSheet");

		if (spreadSheet != null) {
			setSpreadSheet(spreadSheet);
		}
	}

	@Override
	public long getSpeardSheetId() {
		return _speardSheetId;
	}

	@Override
	public void setSpeardSheetId(long speardSheetId) {
		_speardSheetId = speardSheetId;

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpeardSheetId", long.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel,
					speardSheetId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequestTitle() {
		return _requestTitle;
	}

	@Override
	public void setRequestTitle(String requestTitle) {
		_requestTitle = requestTitle;

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestTitle", String.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel,
					requestTitle);
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

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel, status);
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

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel, creatorId);
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

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel,
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

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel, updatedBy);
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

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel,
					updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpreadSheet() {
		return _spreadSheet;
	}

	@Override
	public void setSpreadSheet(String spreadSheet) {
		_spreadSheet = spreadSheet;

		if (_spreadSheetAttributeUpdateRemoteModel != null) {
			try {
				Class<?> clazz = _spreadSheetAttributeUpdateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpreadSheet", String.class);

				method.invoke(_spreadSheetAttributeUpdateRemoteModel,
					spreadSheet);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSpreadSheetAttributeUpdateRemoteModel() {
		return _spreadSheetAttributeUpdateRemoteModel;
	}

	public void setSpreadSheetAttributeUpdateRemoteModel(
		BaseModel<?> spreadSheetAttributeUpdateRemoteModel) {
		_spreadSheetAttributeUpdateRemoteModel = spreadSheetAttributeUpdateRemoteModel;
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

		Class<?> remoteModelClass = _spreadSheetAttributeUpdateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spreadSheetAttributeUpdateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SpreadSheetAttributeUpdateLocalServiceUtil.addSpreadSheetAttributeUpdate(this);
		}
		else {
			SpreadSheetAttributeUpdateLocalServiceUtil.updateSpreadSheetAttributeUpdate(this);
		}
	}

	@Override
	public SpreadSheetAttributeUpdate toEscapedModel() {
		return (SpreadSheetAttributeUpdate)ProxyUtil.newProxyInstance(SpreadSheetAttributeUpdate.class.getClassLoader(),
			new Class[] { SpreadSheetAttributeUpdate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SpreadSheetAttributeUpdateClp clone = new SpreadSheetAttributeUpdateClp();

		clone.setSpeardSheetId(getSpeardSheetId());
		clone.setRequestTitle(getRequestTitle());
		clone.setStatus(getStatus());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setSpreadSheet(getSpreadSheet());

		return clone;
	}

	@Override
	public int compareTo(SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		int value = 0;

		value = DateUtil.compareTo(getUpdatedDate(),
				spreadSheetAttributeUpdate.getUpdatedDate());

		value = value * -1;

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

		if (!(obj instanceof SpreadSheetAttributeUpdateClp)) {
			return false;
		}

		SpreadSheetAttributeUpdateClp spreadSheetAttributeUpdate = (SpreadSheetAttributeUpdateClp)obj;

		long primaryKey = spreadSheetAttributeUpdate.getPrimaryKey();

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

		sb.append("{speardSheetId=");
		sb.append(getSpeardSheetId());
		sb.append(", requestTitle=");
		sb.append(getRequestTitle());
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
		sb.append(", spreadSheet=");
		sb.append(getSpreadSheet());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>speardSheetId</column-name><column-value><![CDATA[");
		sb.append(getSpeardSheetId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestTitle</column-name><column-value><![CDATA[");
		sb.append(getRequestTitle());
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
		sb.append(
			"<column><column-name>spreadSheet</column-name><column-value><![CDATA[");
		sb.append(getSpreadSheet());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _speardSheetId;
	private String _requestTitle;
	private String _status;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private String _spreadSheet;
	private BaseModel<?> _spreadSheetAttributeUpdateRemoteModel;
}