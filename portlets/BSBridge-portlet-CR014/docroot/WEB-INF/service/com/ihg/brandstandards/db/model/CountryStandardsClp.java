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
import com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.CountryStandardsPK;

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
public class CountryStandardsClp extends BaseModelImpl<CountryStandards>
	implements CountryStandards {
	public CountryStandardsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CountryStandards.class;
	}

	@Override
	public String getModelClassName() {
		return CountryStandards.class.getName();
	}

	@Override
	public CountryStandardsPK getPrimaryKey() {
		return new CountryStandardsPK(_country, _stdId);
	}

	@Override
	public void setPrimaryKey(CountryStandardsPK primaryKey) {
		setCountry(primaryKey.country);
		setStdId(primaryKey.stdId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CountryStandardsPK(_country, _stdId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CountryStandardsPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("country", getCountry());
		attributes.put("stdId", getStdId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
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
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_countryStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_countryStandardsRemoteModel, country);
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

		if (_countryStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_countryStandardsRemoteModel, stdId);
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

		if (_countryStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_countryStandardsRemoteModel, creatorId);
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

		if (_countryStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_countryStandardsRemoteModel, createdDate);
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

		if (_countryStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_countryStandardsRemoteModel, updatedBy);
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

		if (_countryStandardsRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_countryStandardsRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCountryStandardsRemoteModel() {
		return _countryStandardsRemoteModel;
	}

	public void setCountryStandardsRemoteModel(
		BaseModel<?> countryStandardsRemoteModel) {
		_countryStandardsRemoteModel = countryStandardsRemoteModel;
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

		Class<?> remoteModelClass = _countryStandardsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_countryStandardsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CountryStandardsLocalServiceUtil.addCountryStandards(this);
		}
		else {
			CountryStandardsLocalServiceUtil.updateCountryStandards(this);
		}
	}

	@Override
	public CountryStandards toEscapedModel() {
		return (CountryStandards)ProxyUtil.newProxyInstance(CountryStandards.class.getClassLoader(),
			new Class[] { CountryStandards.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CountryStandardsClp clone = new CountryStandardsClp();

		clone.setCountry(getCountry());
		clone.setStdId(getStdId());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(CountryStandards countryStandards) {
		CountryStandardsPK primaryKey = countryStandards.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CountryStandardsClp)) {
			return false;
		}

		CountryStandardsClp countryStandards = (CountryStandardsClp)obj;

		CountryStandardsPK primaryKey = countryStandards.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{country=");
		sb.append(getCountry());
		sb.append(", stdId=");
		sb.append(getStdId());
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
		sb.append("com.ihg.brandstandards.db.model.CountryStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
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

	private String _country;
	private long _stdId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _countryStandardsRemoteModel;
}