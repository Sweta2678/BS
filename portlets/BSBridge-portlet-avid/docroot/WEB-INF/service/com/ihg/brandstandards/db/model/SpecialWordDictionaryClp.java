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
import com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalServiceUtil;

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
public class SpecialWordDictionaryClp extends BaseModelImpl<SpecialWordDictionary>
	implements SpecialWordDictionary {
	public SpecialWordDictionaryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SpecialWordDictionary.class;
	}

	@Override
	public String getModelClassName() {
		return SpecialWordDictionary.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _specialWordId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpecialWordId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _specialWordId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("specialWordId", getSpecialWordId());
		attributes.put("replacedWordTxt", getReplacedWordTxt());
		attributes.put("replacementWordTxt", getReplacementWordTxt());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long specialWordId = (Long)attributes.get("specialWordId");

		if (specialWordId != null) {
			setSpecialWordId(specialWordId);
		}

		String replacedWordTxt = (String)attributes.get("replacedWordTxt");

		if (replacedWordTxt != null) {
			setReplacedWordTxt(replacedWordTxt);
		}

		String replacementWordTxt = (String)attributes.get("replacementWordTxt");

		if (replacementWordTxt != null) {
			setReplacementWordTxt(replacementWordTxt);
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
	public long getSpecialWordId() {
		return _specialWordId;
	}

	@Override
	public void setSpecialWordId(long specialWordId) {
		_specialWordId = specialWordId;

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setSpecialWordId", long.class);

				method.invoke(_specialWordDictionaryRemoteModel, specialWordId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReplacedWordTxt() {
		return _replacedWordTxt;
	}

	@Override
	public void setReplacedWordTxt(String replacedWordTxt) {
		_replacedWordTxt = replacedWordTxt;

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setReplacedWordTxt",
						String.class);

				method.invoke(_specialWordDictionaryRemoteModel, replacedWordTxt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReplacementWordTxt() {
		return _replacementWordTxt;
	}

	@Override
	public void setReplacementWordTxt(String replacementWordTxt) {
		_replacementWordTxt = replacementWordTxt;

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setReplacementWordTxt",
						String.class);

				method.invoke(_specialWordDictionaryRemoteModel,
					replacementWordTxt);
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

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_specialWordDictionaryRemoteModel, localeCode);
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

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_specialWordDictionaryRemoteModel, creatorId);
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

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_specialWordDictionaryRemoteModel, createdDate);
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

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_specialWordDictionaryRemoteModel, updatedBy);
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

		if (_specialWordDictionaryRemoteModel != null) {
			try {
				Class<?> clazz = _specialWordDictionaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_specialWordDictionaryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSpecialWordDictionaryRemoteModel() {
		return _specialWordDictionaryRemoteModel;
	}

	public void setSpecialWordDictionaryRemoteModel(
		BaseModel<?> specialWordDictionaryRemoteModel) {
		_specialWordDictionaryRemoteModel = specialWordDictionaryRemoteModel;
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

		Class<?> remoteModelClass = _specialWordDictionaryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_specialWordDictionaryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SpecialWordDictionaryLocalServiceUtil.addSpecialWordDictionary(this);
		}
		else {
			SpecialWordDictionaryLocalServiceUtil.updateSpecialWordDictionary(this);
		}
	}

	@Override
	public SpecialWordDictionary toEscapedModel() {
		return (SpecialWordDictionary)ProxyUtil.newProxyInstance(SpecialWordDictionary.class.getClassLoader(),
			new Class[] { SpecialWordDictionary.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SpecialWordDictionaryClp clone = new SpecialWordDictionaryClp();

		clone.setSpecialWordId(getSpecialWordId());
		clone.setReplacedWordTxt(getReplacedWordTxt());
		clone.setReplacementWordTxt(getReplacementWordTxt());
		clone.setLocaleCode(getLocaleCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(SpecialWordDictionary specialWordDictionary) {
		int value = 0;

		value = getReplacedWordTxt()
					.compareTo(specialWordDictionary.getReplacedWordTxt());

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

		if (!(obj instanceof SpecialWordDictionaryClp)) {
			return false;
		}

		SpecialWordDictionaryClp specialWordDictionary = (SpecialWordDictionaryClp)obj;

		long primaryKey = specialWordDictionary.getPrimaryKey();

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

		sb.append("{specialWordId=");
		sb.append(getSpecialWordId());
		sb.append(", replacedWordTxt=");
		sb.append(getReplacedWordTxt());
		sb.append(", replacementWordTxt=");
		sb.append(getReplacementWordTxt());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.SpecialWordDictionary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>specialWordId</column-name><column-value><![CDATA[");
		sb.append(getSpecialWordId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replacedWordTxt</column-name><column-value><![CDATA[");
		sb.append(getReplacedWordTxt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>replacementWordTxt</column-name><column-value><![CDATA[");
		sb.append(getReplacementWordTxt());
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

	private long _specialWordId;
	private String _replacedWordTxt;
	private String _replacementWordTxt;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _specialWordDictionaryRemoteModel;
}