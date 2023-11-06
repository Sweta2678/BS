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

import com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK;

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
public class AttachmentsStandardsCountryClp extends BaseModelImpl<AttachmentsStandardsCountry>
	implements AttachmentsStandardsCountry {
	public AttachmentsStandardsCountryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AttachmentsStandardsCountry.class;
	}

	@Override
	public String getModelClassName() {
		return AttachmentsStandardsCountry.class.getName();
	}

	@Override
	public AttachmentsStandardsCountryPK getPrimaryKey() {
		return new AttachmentsStandardsCountryPK(_attachmentId, _countryCode,
			_localeCode);
	}

	@Override
	public void setPrimaryKey(AttachmentsStandardsCountryPK primaryKey) {
		setAttachmentId(primaryKey.attachmentId);
		setCountryCode(primaryKey.countryCode);
		setLocaleCode(primaryKey.localeCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AttachmentsStandardsCountryPK(_attachmentId, _countryCode,
			_localeCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AttachmentsStandardsCountryPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("localeCode", getLocaleCode());
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

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
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

		if (_attachmentsStandardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentId", long.class);

				method.invoke(_attachmentsStandardsCountryRemoteModel,
					attachmentId);
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

		if (_attachmentsStandardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_attachmentsStandardsCountryRemoteModel,
					countryCode);
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

		if (_attachmentsStandardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_attachmentsStandardsCountryRemoteModel,
					localeCode);
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

		if (_attachmentsStandardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_attachmentsStandardsCountryRemoteModel, creatorId);
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

		if (_attachmentsStandardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_attachmentsStandardsCountryRemoteModel,
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

		if (_attachmentsStandardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_attachmentsStandardsCountryRemoteModel, updatedBy);
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

		if (_attachmentsStandardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _attachmentsStandardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_attachmentsStandardsCountryRemoteModel,
					updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAttachmentsStandardsCountryRemoteModel() {
		return _attachmentsStandardsCountryRemoteModel;
	}

	public void setAttachmentsStandardsCountryRemoteModel(
		BaseModel<?> attachmentsStandardsCountryRemoteModel) {
		_attachmentsStandardsCountryRemoteModel = attachmentsStandardsCountryRemoteModel;
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

		Class<?> remoteModelClass = _attachmentsStandardsCountryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_attachmentsStandardsCountryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AttachmentsStandardsCountryLocalServiceUtil.addAttachmentsStandardsCountry(this);
		}
		else {
			AttachmentsStandardsCountryLocalServiceUtil.updateAttachmentsStandardsCountry(this);
		}
	}

	@Override
	public AttachmentsStandardsCountry toEscapedModel() {
		return (AttachmentsStandardsCountry)ProxyUtil.newProxyInstance(AttachmentsStandardsCountry.class.getClassLoader(),
			new Class[] { AttachmentsStandardsCountry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AttachmentsStandardsCountryClp clone = new AttachmentsStandardsCountryClp();

		clone.setAttachmentId(getAttachmentId());
		clone.setCountryCode(getCountryCode());
		clone.setLocaleCode(getLocaleCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(
		AttachmentsStandardsCountry attachmentsStandardsCountry) {
		AttachmentsStandardsCountryPK primaryKey = attachmentsStandardsCountry.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentsStandardsCountryClp)) {
			return false;
		}

		AttachmentsStandardsCountryClp attachmentsStandardsCountry = (AttachmentsStandardsCountryClp)obj;

		AttachmentsStandardsCountryPK primaryKey = attachmentsStandardsCountry.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{attachmentId=");
		sb.append(getAttachmentId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
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
		sb.append("com.ihg.brandstandards.db.model.AttachmentsStandardsCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attachmentId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
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
	private String _countryCode;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _attachmentsStandardsCountryRemoteModel;
}