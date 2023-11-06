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
import com.ihg.brandstandards.db.service.UIElementTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK;

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
public class UIElementTranslateClp extends BaseModelImpl<UIElementTranslate>
	implements UIElementTranslate {
	public UIElementTranslateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UIElementTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return UIElementTranslate.class.getName();
	}

	@Override
	public UIElementTranslatePK getPrimaryKey() {
		return new UIElementTranslatePK(_elementId, _localeCode);
	}

	@Override
	public void setPrimaryKey(UIElementTranslatePK primaryKey) {
		setElementId(primaryKey.elementId);
		setLocaleCode(primaryKey.localeCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new UIElementTranslatePK(_elementId, _localeCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((UIElementTranslatePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("elementId", getElementId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("elementValue", getElementValue());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long elementId = (Long)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String elementValue = (String)attributes.get("elementValue");

		if (elementValue != null) {
			setElementValue(elementValue);
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
	public long getElementId() {
		return _elementId;
	}

	@Override
	public void setElementId(long elementId) {
		_elementId = elementId;

		if (_uiElementTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _uiElementTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setElementId", long.class);

				method.invoke(_uiElementTranslateRemoteModel, elementId);
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

		if (_uiElementTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _uiElementTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_uiElementTranslateRemoteModel, localeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getElementValue() {
		return _elementValue;
	}

	@Override
	public void setElementValue(String elementValue) {
		_elementValue = elementValue;

		if (_uiElementTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _uiElementTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setElementValue", String.class);

				method.invoke(_uiElementTranslateRemoteModel, elementValue);
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

		if (_uiElementTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _uiElementTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_uiElementTranslateRemoteModel, creatorId);
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

		if (_uiElementTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _uiElementTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_uiElementTranslateRemoteModel, createdDate);
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

		if (_uiElementTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _uiElementTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_uiElementTranslateRemoteModel, updatedBy);
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

		if (_uiElementTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _uiElementTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_uiElementTranslateRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUIElementTranslateRemoteModel() {
		return _uiElementTranslateRemoteModel;
	}

	public void setUIElementTranslateRemoteModel(
		BaseModel<?> uiElementTranslateRemoteModel) {
		_uiElementTranslateRemoteModel = uiElementTranslateRemoteModel;
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

		Class<?> remoteModelClass = _uiElementTranslateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_uiElementTranslateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UIElementTranslateLocalServiceUtil.addUIElementTranslate(this);
		}
		else {
			UIElementTranslateLocalServiceUtil.updateUIElementTranslate(this);
		}
	}

	@Override
	public UIElementTranslate toEscapedModel() {
		return (UIElementTranslate)ProxyUtil.newProxyInstance(UIElementTranslate.class.getClassLoader(),
			new Class[] { UIElementTranslate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UIElementTranslateClp clone = new UIElementTranslateClp();

		clone.setElementId(getElementId());
		clone.setLocaleCode(getLocaleCode());
		clone.setElementValue(getElementValue());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(UIElementTranslate uiElementTranslate) {
		int value = 0;

		if (getElementId() < uiElementTranslate.getElementId()) {
			value = -1;
		}
		else if (getElementId() > uiElementTranslate.getElementId()) {
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

		if (!(obj instanceof UIElementTranslateClp)) {
			return false;
		}

		UIElementTranslateClp uiElementTranslate = (UIElementTranslateClp)obj;

		UIElementTranslatePK primaryKey = uiElementTranslate.getPrimaryKey();

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

		sb.append("{elementId=");
		sb.append(getElementId());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
		sb.append(", elementValue=");
		sb.append(getElementValue());
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
		sb.append("com.ihg.brandstandards.db.model.UIElementTranslate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>elementId</column-name><column-value><![CDATA[");
		sb.append(getElementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>elementValue</column-name><column-value><![CDATA[");
		sb.append(getElementValue());
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

	private long _elementId;
	private String _localeCode;
	private String _elementValue;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _uiElementTranslateRemoteModel;
}