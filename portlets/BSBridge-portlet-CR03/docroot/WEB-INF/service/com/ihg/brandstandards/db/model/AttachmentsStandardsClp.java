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

import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK;

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
public class AttachmentsStandardsClp extends BaseModelImpl<AttachmentsStandards>
	implements AttachmentsStandards {
	public AttachmentsStandardsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AttachmentsStandards.class;
	}

	@Override
	public String getModelClassName() {
		return AttachmentsStandards.class.getName();
	}

	@Override
	public AttachmentsStandardsPK getPrimaryKey() {
		return new AttachmentsStandardsPK(_attachmentId, _localeCode);
	}

	@Override
	public void setPrimaryKey(AttachmentsStandardsPK primaryKey) {
		setAttachmentId(primaryKey.attachmentId);
		setLocaleCode(primaryKey.localeCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AttachmentsStandardsPK(_attachmentId, _localeCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AttachmentsStandardsPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("parentAttachmentId", getParentAttachmentId());
		attributes.put("stdId", getStdId());
		attributes.put("type", getType());
		attributes.put("title", getTitle());
		attributes.put("translationIndicator", getTranslationIndicator());
		attributes.put("attachmentPath", getAttachmentPath());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		Long parentAttachmentId = (Long)attributes.get("parentAttachmentId");

		if (parentAttachmentId != null) {
			setParentAttachmentId(parentAttachmentId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String translationIndicator = (String)attributes.get(
				"translationIndicator");

		if (translationIndicator != null) {
			setTranslationIndicator(translationIndicator);
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
	public long getAttachmentId() {
		return _attachmentId;
	}

	@Override
	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentId", long.class);

				method.invoke(_attachmentsStandardsRemoteModel, attachmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocaleCode() {
		return _localeCode;
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_attachmentsStandardsRemoteModel, localeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentAttachmentId() {
		return _parentAttachmentId;
	}

	@Override
	public void setParentAttachmentId(long parentAttachmentId) {
		_parentAttachmentId = parentAttachmentId;

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setParentAttachmentId",
						long.class);

				method.invoke(_attachmentsStandardsRemoteModel,
					parentAttachmentId);
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

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_attachmentsStandardsRemoteModel, stdId);
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

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_attachmentsStandardsRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_attachmentsStandardsRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTranslationIndicator() {
		return _translationIndicator;
	}

	@Override
	public void setTranslationIndicator(String translationIndicator) {
		_translationIndicator = translationIndicator;

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setTranslationIndicator",
						String.class);

				method.invoke(_attachmentsStandardsRemoteModel,
					translationIndicator);
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

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentPath",
						String.class);

				method.invoke(_attachmentsStandardsRemoteModel, attachmentPath);
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

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_attachmentsStandardsRemoteModel, creatorId);
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

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_attachmentsStandardsRemoteModel, createdDate);
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

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_attachmentsStandardsRemoteModel, updatedBy);
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

		if (_attachmentsStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_attachmentsStandardsRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setTranslationExist(boolean isTranslationExist) {
		try {
			String methodName = "setTranslationExist";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { isTranslationExist };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTranslationExist() {
		try {
			String methodName = "isTranslationExist";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getAttachmentsStandardsRemoteModel() {
		return _attachmentsStandardsRemoteModel;
	}

	public void setAttachmentsStandardsRemoteModel(
		BaseModel<?> attachmentsStandardsRemoteModel) {
		_attachmentsStandardsRemoteModel = attachmentsStandardsRemoteModel;
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

		Class<?> remoteModelClass = _attachmentsStandardsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_attachmentsStandardsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AttachmentsStandardsLocalServiceUtil.addAttachmentsStandards(this);
		}
		else {
			AttachmentsStandardsLocalServiceUtil.updateAttachmentsStandards(this);
		}
	}

	@Override
	public AttachmentsStandards toEscapedModel() {
		return (AttachmentsStandards)ProxyUtil.newProxyInstance(AttachmentsStandards.class.getClassLoader(),
			new Class[] { AttachmentsStandards.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AttachmentsStandardsClp clone = new AttachmentsStandardsClp();

		clone.setAttachmentId(getAttachmentId());
		clone.setLocaleCode(getLocaleCode());
		clone.setParentAttachmentId(getParentAttachmentId());
		clone.setStdId(getStdId());
		clone.setType(getType());
		clone.setTitle(getTitle());
		clone.setTranslationIndicator(getTranslationIndicator());
		clone.setAttachmentPath(getAttachmentPath());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(AttachmentsStandards attachmentsStandards) {
		AttachmentsStandardsPK primaryKey = attachmentsStandards.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentsStandardsClp)) {
			return false;
		}

		AttachmentsStandardsClp attachmentsStandards = (AttachmentsStandardsClp)obj;

		AttachmentsStandardsPK primaryKey = attachmentsStandards.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{attachmentId=");
		sb.append(getAttachmentId());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
		sb.append(", parentAttachmentId=");
		sb.append(getParentAttachmentId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", translationIndicator=");
		sb.append(getTranslationIndicator());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.AttachmentsStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attachmentId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentAttachmentId</column-name><column-value><![CDATA[");
		sb.append(getParentAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>translationIndicator</column-name><column-value><![CDATA[");
		sb.append(getTranslationIndicator());
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

	private long _attachmentId;
	private String _localeCode;
	private long _parentAttachmentId;
	private long _stdId;
	private String _type;
	private String _title;
	private String _translationIndicator;
	private String _attachmentPath;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _attachmentsStandardsRemoteModel;
}