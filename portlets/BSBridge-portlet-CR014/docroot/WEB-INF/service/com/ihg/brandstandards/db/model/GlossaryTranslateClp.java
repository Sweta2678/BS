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
import com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil;

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
public class GlossaryTranslateClp extends BaseModelImpl<GlossaryTranslate>
	implements GlossaryTranslate {
	public GlossaryTranslateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GlossaryTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return GlossaryTranslate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _glossaryXlatId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlossaryXlatId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _glossaryXlatId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryXlatId", getGlossaryXlatId());
		attributes.put("glossaryId", getGlossaryId());
		attributes.put("langCode", getLangCode());
		attributes.put("glossaryTermText", getGlossaryTermText());
		attributes.put("glossaryTermDesc", getGlossaryTermDesc());
		attributes.put("isValidTermTxt", getIsValidTermTxt());
		attributes.put("isValidDescTxt", getIsValidDescTxt());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryXlatId = (Long)attributes.get("glossaryXlatId");

		if (glossaryXlatId != null) {
			setGlossaryXlatId(glossaryXlatId);
		}

		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String langCode = (String)attributes.get("langCode");

		if (langCode != null) {
			setLangCode(langCode);
		}

		String glossaryTermText = (String)attributes.get("glossaryTermText");

		if (glossaryTermText != null) {
			setGlossaryTermText(glossaryTermText);
		}

		String glossaryTermDesc = (String)attributes.get("glossaryTermDesc");

		if (glossaryTermDesc != null) {
			setGlossaryTermDesc(glossaryTermDesc);
		}

		String isValidTermTxt = (String)attributes.get("isValidTermTxt");

		if (isValidTermTxt != null) {
			setIsValidTermTxt(isValidTermTxt);
		}

		String isValidDescTxt = (String)attributes.get("isValidDescTxt");

		if (isValidDescTxt != null) {
			setIsValidDescTxt(isValidDescTxt);
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
	public long getGlossaryXlatId() {
		return _glossaryXlatId;
	}

	@Override
	public void setGlossaryXlatId(long glossaryXlatId) {
		_glossaryXlatId = glossaryXlatId;

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryXlatId", long.class);

				method.invoke(_glossaryTranslateRemoteModel, glossaryXlatId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGlossaryId() {
		return _glossaryId;
	}

	@Override
	public void setGlossaryId(long glossaryId) {
		_glossaryId = glossaryId;

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryId", long.class);

				method.invoke(_glossaryTranslateRemoteModel, glossaryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLangCode() {
		return _langCode;
	}

	@Override
	public void setLangCode(String langCode) {
		_langCode = langCode;

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setLangCode", String.class);

				method.invoke(_glossaryTranslateRemoteModel, langCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlossaryTermText() {
		return _glossaryTermText;
	}

	@Override
	public void setGlossaryTermText(String glossaryTermText) {
		_glossaryTermText = glossaryTermText;

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryTermText",
						String.class);

				method.invoke(_glossaryTranslateRemoteModel, glossaryTermText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlossaryTermDesc() {
		return _glossaryTermDesc;
	}

	@Override
	public void setGlossaryTermDesc(String glossaryTermDesc) {
		_glossaryTermDesc = glossaryTermDesc;

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryTermDesc",
						String.class);

				method.invoke(_glossaryTranslateRemoteModel, glossaryTermDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsValidTermTxt() {
		return _isValidTermTxt;
	}

	@Override
	public void setIsValidTermTxt(String isValidTermTxt) {
		_isValidTermTxt = isValidTermTxt;

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setIsValidTermTxt",
						String.class);

				method.invoke(_glossaryTranslateRemoteModel, isValidTermTxt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsValidDescTxt() {
		return _isValidDescTxt;
	}

	@Override
	public void setIsValidDescTxt(String isValidDescTxt) {
		_isValidDescTxt = isValidDescTxt;

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setIsValidDescTxt",
						String.class);

				method.invoke(_glossaryTranslateRemoteModel, isValidDescTxt);
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

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_glossaryTranslateRemoteModel, creatorId);
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

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_glossaryTranslateRemoteModel, createdDate);
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

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_glossaryTranslateRemoteModel, updatedBy);
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

		if (_glossaryTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_glossaryTranslateRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGlossaryTranslateRemoteModel() {
		return _glossaryTranslateRemoteModel;
	}

	public void setGlossaryTranslateRemoteModel(
		BaseModel<?> glossaryTranslateRemoteModel) {
		_glossaryTranslateRemoteModel = glossaryTranslateRemoteModel;
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

		Class<?> remoteModelClass = _glossaryTranslateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_glossaryTranslateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GlossaryTranslateLocalServiceUtil.addGlossaryTranslate(this);
		}
		else {
			GlossaryTranslateLocalServiceUtil.updateGlossaryTranslate(this);
		}
	}

	@Override
	public GlossaryTranslate toEscapedModel() {
		return (GlossaryTranslate)ProxyUtil.newProxyInstance(GlossaryTranslate.class.getClassLoader(),
			new Class[] { GlossaryTranslate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GlossaryTranslateClp clone = new GlossaryTranslateClp();

		clone.setGlossaryXlatId(getGlossaryXlatId());
		clone.setGlossaryId(getGlossaryId());
		clone.setLangCode(getLangCode());
		clone.setGlossaryTermText(getGlossaryTermText());
		clone.setGlossaryTermDesc(getGlossaryTermDesc());
		clone.setIsValidTermTxt(getIsValidTermTxt());
		clone.setIsValidDescTxt(getIsValidDescTxt());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GlossaryTranslate glossaryTranslate) {
		long primaryKey = glossaryTranslate.getPrimaryKey();

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

		if (!(obj instanceof GlossaryTranslateClp)) {
			return false;
		}

		GlossaryTranslateClp glossaryTranslate = (GlossaryTranslateClp)obj;

		long primaryKey = glossaryTranslate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{glossaryXlatId=");
		sb.append(getGlossaryXlatId());
		sb.append(", glossaryId=");
		sb.append(getGlossaryId());
		sb.append(", langCode=");
		sb.append(getLangCode());
		sb.append(", glossaryTermText=");
		sb.append(getGlossaryTermText());
		sb.append(", glossaryTermDesc=");
		sb.append(getGlossaryTermDesc());
		sb.append(", isValidTermTxt=");
		sb.append(getIsValidTermTxt());
		sb.append(", isValidDescTxt=");
		sb.append(getIsValidDescTxt());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GlossaryTranslate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>glossaryXlatId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryXlatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>langCode</column-name><column-value><![CDATA[");
		sb.append(getLangCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryTermText</column-name><column-value><![CDATA[");
		sb.append(getGlossaryTermText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryTermDesc</column-name><column-value><![CDATA[");
		sb.append(getGlossaryTermDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isValidTermTxt</column-name><column-value><![CDATA[");
		sb.append(getIsValidTermTxt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isValidDescTxt</column-name><column-value><![CDATA[");
		sb.append(getIsValidDescTxt());
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

	private long _glossaryXlatId;
	private long _glossaryId;
	private String _langCode;
	private String _glossaryTermText;
	private String _glossaryTermDesc;
	private String _isValidTermTxt;
	private String _isValidDescTxt;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _glossaryTranslateRemoteModel;
}