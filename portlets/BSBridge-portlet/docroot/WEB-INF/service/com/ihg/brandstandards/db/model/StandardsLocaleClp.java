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
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;

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
public class StandardsLocaleClp extends BaseModelImpl<StandardsLocale>
	implements StandardsLocale {
	public StandardsLocaleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsLocale.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsLocale.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _localeCode;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setLocaleCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _localeCode;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("localeCode", getLocaleCode());
		attributes.put("countryCode", getCountryCode());
		attributes.put("localeName", getLocaleName());
		attributes.put("languageCode", getLanguageCode());
		attributes.put("orderNumber", getOrderNumber());
		attributes.put("isActive", getIsActive());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String localeName = (String)attributes.get("localeName");

		if (localeName != null) {
			setLocaleName(localeName);
		}

		String languageCode = (String)attributes.get("languageCode");

		if (languageCode != null) {
			setLanguageCode(languageCode);
		}

		Long orderNumber = (Long)attributes.get("orderNumber");

		if (orderNumber != null) {
			setOrderNumber(orderNumber);
		}

		String isActive = (String)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
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
	public String getLocaleCode() {
		return _localeCode;
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_standardsLocaleRemoteModel, localeCode);
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

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_standardsLocaleRemoteModel, countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocaleName() {
		return _localeName;
	}

	@Override
	public void setLocaleName(String localeName) {
		_localeName = localeName;

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleName", String.class);

				method.invoke(_standardsLocaleRemoteModel, localeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLanguageCode() {
		return _languageCode;
	}

	@Override
	public void setLanguageCode(String languageCode) {
		_languageCode = languageCode;

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setLanguageCode", String.class);

				method.invoke(_standardsLocaleRemoteModel, languageCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrderNumber() {
		return _orderNumber;
	}

	@Override
	public void setOrderNumber(long orderNumber) {
		_orderNumber = orderNumber;

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderNumber", long.class);

				method.invoke(_standardsLocaleRemoteModel, orderNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsActive() {
		return _isActive;
	}

	@Override
	public void setIsActive(String isActive) {
		_isActive = isActive;

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setIsActive", String.class);

				method.invoke(_standardsLocaleRemoteModel, isActive);
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

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsLocaleRemoteModel, creatorId);
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

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsLocaleRemoteModel, createdDate);
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

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsLocaleRemoteModel, updatedBy);
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

		if (_standardsLocaleRemoteModel != null) {
			try {
				Class<?> clazz = _standardsLocaleRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsLocaleRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsLocaleRemoteModel() {
		return _standardsLocaleRemoteModel;
	}

	public void setStandardsLocaleRemoteModel(
		BaseModel<?> standardsLocaleRemoteModel) {
		_standardsLocaleRemoteModel = standardsLocaleRemoteModel;
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

		Class<?> remoteModelClass = _standardsLocaleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsLocaleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsLocaleLocalServiceUtil.addStandardsLocale(this);
		}
		else {
			StandardsLocaleLocalServiceUtil.updateStandardsLocale(this);
		}
	}

	@Override
	public StandardsLocale toEscapedModel() {
		return (StandardsLocale)ProxyUtil.newProxyInstance(StandardsLocale.class.getClassLoader(),
			new Class[] { StandardsLocale.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsLocaleClp clone = new StandardsLocaleClp();

		clone.setLocaleCode(getLocaleCode());
		clone.setCountryCode(getCountryCode());
		clone.setLocaleName(getLocaleName());
		clone.setLanguageCode(getLanguageCode());
		clone.setOrderNumber(getOrderNumber());
		clone.setIsActive(getIsActive());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsLocale standardsLocale) {
		int value = 0;

		if (getOrderNumber() < standardsLocale.getOrderNumber()) {
			value = -1;
		}
		else if (getOrderNumber() > standardsLocale.getOrderNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof StandardsLocaleClp)) {
			return false;
		}

		StandardsLocaleClp standardsLocale = (StandardsLocaleClp)obj;

		String primaryKey = standardsLocale.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{localeCode=");
		sb.append(getLocaleCode());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", localeName=");
		sb.append(getLocaleName());
		sb.append(", languageCode=");
		sb.append(getLanguageCode());
		sb.append(", orderNumber=");
		sb.append(getOrderNumber());
		sb.append(", isActive=");
		sb.append(getIsActive());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsLocale");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeName</column-name><column-value><![CDATA[");
		sb.append(getLocaleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageCode</column-name><column-value><![CDATA[");
		sb.append(getLanguageCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderNumber</column-name><column-value><![CDATA[");
		sb.append(getOrderNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
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

	private String _localeCode;
	private String _countryCode;
	private String _localeName;
	private String _languageCode;
	private long _orderNumber;
	private String _isActive;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _standardsLocaleRemoteModel;
}