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
import com.ihg.brandstandards.db.service.HistManualAttachmentLocalServiceUtil;

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
public class HistManualAttachmentClp extends BaseModelImpl<HistManualAttachment>
	implements HistManualAttachment {
	public HistManualAttachmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return HistManualAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return HistManualAttachment.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _histManualId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHistManualId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _histManualId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("histManualId", getHistManualId());
		attributes.put("attachmentPath", getAttachmentPath());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long histManualId = (Long)attributes.get("histManualId");

		if (histManualId != null) {
			setHistManualId(histManualId);
		}

		String attachmentPath = (String)attributes.get("attachmentPath");

		if (attachmentPath != null) {
			setAttachmentPath(attachmentPath);
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
	public long getHistManualId() {
		return _histManualId;
	}

	@Override
	public void setHistManualId(long histManualId) {
		_histManualId = histManualId;

		if (_histManualAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _histManualAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setHistManualId", long.class);

				method.invoke(_histManualAttachmentRemoteModel, histManualId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttachmentPath() {
		return _attachmentPath;
	}

	@Override
	public void setAttachmentPath(String attachmentPath) {
		_attachmentPath = attachmentPath;

		if (_histManualAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _histManualAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentPath",
						String.class);

				method.invoke(_histManualAttachmentRemoteModel, attachmentPath);
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

		if (_histManualAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _histManualAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_histManualAttachmentRemoteModel, creatorId);
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

		if (_histManualAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _histManualAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_histManualAttachmentRemoteModel, createdDate);
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

		if (_histManualAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _histManualAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_histManualAttachmentRemoteModel, updatedBy);
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

		if (_histManualAttachmentRemoteModel != null) {
			try {
				Class<?> clazz = _histManualAttachmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_histManualAttachmentRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHistManualAttachmentRemoteModel() {
		return _histManualAttachmentRemoteModel;
	}

	public void setHistManualAttachmentRemoteModel(
		BaseModel<?> histManualAttachmentRemoteModel) {
		_histManualAttachmentRemoteModel = histManualAttachmentRemoteModel;
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

		Class<?> remoteModelClass = _histManualAttachmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_histManualAttachmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HistManualAttachmentLocalServiceUtil.addHistManualAttachment(this);
		}
		else {
			HistManualAttachmentLocalServiceUtil.updateHistManualAttachment(this);
		}
	}

	@Override
	public HistManualAttachment toEscapedModel() {
		return (HistManualAttachment)ProxyUtil.newProxyInstance(HistManualAttachment.class.getClassLoader(),
			new Class[] { HistManualAttachment.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HistManualAttachmentClp clone = new HistManualAttachmentClp();

		clone.setHistManualId(getHistManualId());
		clone.setAttachmentPath(getAttachmentPath());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(HistManualAttachment histManualAttachment) {
		long primaryKey = histManualAttachment.getPrimaryKey();

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

		if (!(obj instanceof HistManualAttachmentClp)) {
			return false;
		}

		HistManualAttachmentClp histManualAttachment = (HistManualAttachmentClp)obj;

		long primaryKey = histManualAttachment.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{histManualId=");
		sb.append(getHistManualId());
		sb.append(", attachmentPath=");
		sb.append(getAttachmentPath());
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
		sb.append("com.ihg.brandstandards.db.model.HistManualAttachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>histManualId</column-name><column-value><![CDATA[");
		sb.append(getHistManualId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentPath</column-name><column-value><![CDATA[");
		sb.append(getAttachmentPath());
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

	private long _histManualId;
	private String _attachmentPath;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _histManualAttachmentRemoteModel;
}