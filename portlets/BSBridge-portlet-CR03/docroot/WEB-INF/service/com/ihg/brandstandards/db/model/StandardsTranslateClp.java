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
import com.ihg.brandstandards.db.service.StandardsTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK;

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
public class StandardsTranslateClp extends BaseModelImpl<StandardsTranslate>
	implements StandardsTranslate {
	public StandardsTranslateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsTranslate.class.getName();
	}

	@Override
	public StandardsTranslatePK getPrimaryKey() {
		return new StandardsTranslatePK(_stdId, _localeCode);
	}

	@Override
	public void setPrimaryKey(StandardsTranslatePK primaryKey) {
		setStdId(primaryKey.stdId);
		setLocaleCode(primaryKey.localeCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardsTranslatePK(_stdId, _localeCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardsTranslatePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("note", getNote());
		attributes.put("comment", getComment());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("isValidTxt", getIsValidTxt());
		attributes.put("isValidCntxt", getIsValidCntxt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
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

		String isValidTxt = (String)attributes.get("isValidTxt");

		if (isValidTxt != null) {
			setIsValidTxt(isValidTxt);
		}

		String isValidCntxt = (String)attributes.get("isValidCntxt");

		if (isValidCntxt != null) {
			setIsValidCntxt(isValidCntxt);
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsTranslateRemoteModel, stdId);
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

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_standardsTranslateRemoteModel, localeCode);
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

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_standardsTranslateRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_standardsTranslateRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_standardsTranslateRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_standardsTranslateRemoteModel, comment);
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

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsTranslateRemoteModel, creatorId);
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

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsTranslateRemoteModel, createdDate);
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

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsTranslateRemoteModel, updatedBy);
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

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsTranslateRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsValidTxt() {
		return _isValidTxt;
	}

	@Override
	public void setIsValidTxt(String isValidTxt) {
		_isValidTxt = isValidTxt;

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setIsValidTxt", String.class);

				method.invoke(_standardsTranslateRemoteModel, isValidTxt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsValidCntxt() {
		return _isValidCntxt;
	}

	@Override
	public void setIsValidCntxt(String isValidCntxt) {
		_isValidCntxt = isValidCntxt;

		if (_standardsTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _standardsTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setIsValidCntxt", String.class);

				method.invoke(_standardsTranslateRemoteModel, isValidCntxt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsTranslateRemoteModel() {
		return _standardsTranslateRemoteModel;
	}

	public void setStandardsTranslateRemoteModel(
		BaseModel<?> standardsTranslateRemoteModel) {
		_standardsTranslateRemoteModel = standardsTranslateRemoteModel;
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

		Class<?> remoteModelClass = _standardsTranslateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsTranslateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsTranslateLocalServiceUtil.addStandardsTranslate(this);
		}
		else {
			StandardsTranslateLocalServiceUtil.updateStandardsTranslate(this);
		}
	}

	@Override
	public StandardsTranslate toEscapedModel() {
		return (StandardsTranslate)ProxyUtil.newProxyInstance(StandardsTranslate.class.getClassLoader(),
			new Class[] { StandardsTranslate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsTranslateClp clone = new StandardsTranslateClp();

		clone.setStdId(getStdId());
		clone.setLocaleCode(getLocaleCode());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setNote(getNote());
		clone.setComment(getComment());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setIsValidTxt(getIsValidTxt());
		clone.setIsValidCntxt(getIsValidCntxt());

		return clone;
	}

	@Override
	public int compareTo(StandardsTranslate standardsTranslate) {
		StandardsTranslatePK primaryKey = standardsTranslate.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsTranslateClp)) {
			return false;
		}

		StandardsTranslateClp standardsTranslate = (StandardsTranslateClp)obj;

		StandardsTranslatePK primaryKey = standardsTranslate.getPrimaryKey();

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

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", isValidTxt=");
		sb.append(getIsValidTxt());
		sb.append(", isValidCntxt=");
		sb.append(getIsValidCntxt());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsTranslate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
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
			"<column><column-name>isValidTxt</column-name><column-value><![CDATA[");
		sb.append(getIsValidTxt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isValidCntxt</column-name><column-value><![CDATA[");
		sb.append(getIsValidCntxt());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stdId;
	private String _localeCode;
	private String _title;
	private String _description;
	private String _note;
	private String _comment;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private String _isValidTxt;
	private String _isValidCntxt;
	private BaseModel<?> _standardsTranslateRemoteModel;
}