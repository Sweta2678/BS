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
import com.ihg.brandstandards.db.service.CountryStandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class CountryStandardsExtClp extends BaseModelImpl<CountryStandardsExt>
	implements CountryStandardsExt {
	public CountryStandardsExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CountryStandardsExt.class;
	}

	@Override
	public String getModelClassName() {
		return CountryStandardsExt.class.getName();
	}

	@Override
	public CountryStandardsExtPK getPrimaryKey() {
		return new CountryStandardsExtPK(_countryCode, _stdId);
	}

	@Override
	public void setPrimaryKey(CountryStandardsExtPK primaryKey) {
		setCountryCode(primaryKey.countryCode);
		setStdId(primaryKey.stdId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new CountryStandardsExtPK(_countryCode, _stdId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((CountryStandardsExtPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryCode", getCountryCode());
		attributes.put("stdId", getStdId());
		attributes.put("regionId", getRegionId());
		attributes.put("regionCode", getRegionCode());
		attributes.put("regionName", getRegionName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}
	}

	@Override
	public String getCountryCode() {
		return _countryCode;
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;

		if (_countryStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_countryStandardsExtRemoteModel, countryCode);
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

		if (_countryStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_countryStandardsExtRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_regionId = regionId;

		if (_countryStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_countryStandardsExtRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;

		if (_countryStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_countryStandardsExtRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionName() {
		return _regionName;
	}

	@Override
	public void setRegionName(String regionName) {
		_regionName = regionName;

		if (_countryStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _countryStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionName", String.class);

				method.invoke(_countryStandardsExtRemoteModel, regionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCountryStandardsExtRemoteModel() {
		return _countryStandardsExtRemoteModel;
	}

	public void setCountryStandardsExtRemoteModel(
		BaseModel<?> countryStandardsExtRemoteModel) {
		_countryStandardsExtRemoteModel = countryStandardsExtRemoteModel;
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

		Class<?> remoteModelClass = _countryStandardsExtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_countryStandardsExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CountryStandardsExtLocalServiceUtil.addCountryStandardsExt(this);
		}
		else {
			CountryStandardsExtLocalServiceUtil.updateCountryStandardsExt(this);
		}
	}

	@Override
	public CountryStandardsExt toEscapedModel() {
		return (CountryStandardsExt)ProxyUtil.newProxyInstance(CountryStandardsExt.class.getClassLoader(),
			new Class[] { CountryStandardsExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CountryStandardsExtClp clone = new CountryStandardsExtClp();

		clone.setCountryCode(getCountryCode());
		clone.setStdId(getStdId());
		clone.setRegionId(getRegionId());
		clone.setRegionCode(getRegionCode());
		clone.setRegionName(getRegionName());

		return clone;
	}

	@Override
	public int compareTo(CountryStandardsExt countryStandardsExt) {
		CountryStandardsExtPK primaryKey = countryStandardsExt.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CountryStandardsExtClp)) {
			return false;
		}

		CountryStandardsExtClp countryStandardsExt = (CountryStandardsExtClp)obj;

		CountryStandardsExtPK primaryKey = countryStandardsExt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{countryCode=");
		sb.append(getCountryCode());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", regionName=");
		sb.append(getRegionName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.CountryStandardsExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionName</column-name><column-value><![CDATA[");
		sb.append(getRegionName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _countryCode;
	private long _stdId;
	private long _regionId;
	private String _regionCode;
	private String _regionName;
	private BaseModel<?> _countryStandardsExtRemoteModel;
}