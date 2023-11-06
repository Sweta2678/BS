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
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;

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
public class ExternalLinkStandardsClp extends BaseModelImpl<ExternalLinkStandards>
	implements ExternalLinkStandards {
	public ExternalLinkStandardsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ExternalLinkStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ExternalLinkStandards.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _extLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExtLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _extLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("extLinkId", getExtLinkId());
		attributes.put("parentExtLinkId", getParentExtLinkId());
		attributes.put("stdId", getStdId());
		attributes.put("url", getUrl());
		attributes.put("title", getTitle());
		attributes.put("translationIndicator", getTranslationIndicator());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long extLinkId = (Long)attributes.get("extLinkId");

		if (extLinkId != null) {
			setExtLinkId(extLinkId);
		}

		Long parentExtLinkId = (Long)attributes.get("parentExtLinkId");

		if (parentExtLinkId != null) {
			setParentExtLinkId(parentExtLinkId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
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
	public long getExtLinkId() {
		return _extLinkId;
	}

	@Override
	public void setExtLinkId(long extLinkId) {
		_extLinkId = extLinkId;

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setExtLinkId", long.class);

				method.invoke(_externalLinkStandardsRemoteModel, extLinkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentExtLinkId() {
		return _parentExtLinkId;
	}

	@Override
	public void setParentExtLinkId(long parentExtLinkId) {
		_parentExtLinkId = parentExtLinkId;

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setParentExtLinkId", long.class);

				method.invoke(_externalLinkStandardsRemoteModel, parentExtLinkId);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_externalLinkStandardsRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_externalLinkStandardsRemoteModel, url);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_externalLinkStandardsRemoteModel, title);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setTranslationIndicator",
						String.class);

				method.invoke(_externalLinkStandardsRemoteModel,
					translationIndicator);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_externalLinkStandardsRemoteModel, localeCode);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_externalLinkStandardsRemoteModel, creatorId);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_externalLinkStandardsRemoteModel, createdDate);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_externalLinkStandardsRemoteModel, updatedBy);
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

		if (_externalLinkStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _externalLinkStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_externalLinkStandardsRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean isLinkTranslationExist() {
		try {
			String methodName = "isLinkTranslationExist";

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

	@Override
	public void setLinkTranslationExist(boolean isLinkTranslationExist) {
		try {
			String methodName = "setLinkTranslationExist";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { isLinkTranslationExist };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getRealTitle() {
		try {
			String methodName = "getRealTitle";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getRealUrl() {
		try {
			String methodName = "getRealUrl";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getExternalLinkStandardsRemoteModel() {
		return _externalLinkStandardsRemoteModel;
	}

	public void setExternalLinkStandardsRemoteModel(
		BaseModel<?> externalLinkStandardsRemoteModel) {
		_externalLinkStandardsRemoteModel = externalLinkStandardsRemoteModel;
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

		Class<?> remoteModelClass = _externalLinkStandardsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_externalLinkStandardsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExternalLinkStandardsLocalServiceUtil.addExternalLinkStandards(this);
		}
		else {
			ExternalLinkStandardsLocalServiceUtil.updateExternalLinkStandards(this);
		}
	}

	@Override
	public ExternalLinkStandards toEscapedModel() {
		return (ExternalLinkStandards)ProxyUtil.newProxyInstance(ExternalLinkStandards.class.getClassLoader(),
			new Class[] { ExternalLinkStandards.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExternalLinkStandardsClp clone = new ExternalLinkStandardsClp();

		clone.setExtLinkId(getExtLinkId());
		clone.setParentExtLinkId(getParentExtLinkId());
		clone.setStdId(getStdId());
		clone.setUrl(getUrl());
		clone.setTitle(getTitle());
		clone.setTranslationIndicator(getTranslationIndicator());
		clone.setLocaleCode(getLocaleCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(ExternalLinkStandards externalLinkStandards) {
		long primaryKey = externalLinkStandards.getPrimaryKey();

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

		if (!(obj instanceof ExternalLinkStandardsClp)) {
			return false;
		}

		ExternalLinkStandardsClp externalLinkStandards = (ExternalLinkStandardsClp)obj;

		long primaryKey = externalLinkStandards.getPrimaryKey();

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

		sb.append("{extLinkId=");
		sb.append(getExtLinkId());
		sb.append(", parentExtLinkId=");
		sb.append(getParentExtLinkId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", translationIndicator=");
		sb.append(getTranslationIndicator());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.ExternalLinkStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>extLinkId</column-name><column-value><![CDATA[");
		sb.append(getExtLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentExtLinkId</column-name><column-value><![CDATA[");
		sb.append(getParentExtLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
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

	private long _extLinkId;
	private long _parentExtLinkId;
	private long _stdId;
	private String _url;
	private String _title;
	private String _translationIndicator;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _externalLinkStandardsRemoteModel;
}