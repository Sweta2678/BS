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
import com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil;

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
public class StandardsCountryExtClp extends BaseModelImpl<StandardsCountryExt>
	implements StandardsCountryExt {
	public StandardsCountryExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCountryExt.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCountryExt.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _rowNum;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRowNum(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rowNum;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rowNum", getRowNum());
		attributes.put("countryCode", getCountryCode());
		attributes.put("flag", getFlag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rowNum = (Long)attributes.get("rowNum");

		if (rowNum != null) {
			setRowNum(rowNum);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String flag = (String)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}
	}

	@Override
	public long getRowNum() {
		return _rowNum;
	}

	@Override
	public void setRowNum(long rowNum) {
		_rowNum = rowNum;

		if (_standardsCountryExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRowNum", long.class);

				method.invoke(_standardsCountryExtRemoteModel, rowNum);
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

		if (_standardsCountryExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_standardsCountryExtRemoteModel, countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlag() {
		return _flag;
	}

	@Override
	public void setFlag(String flag) {
		_flag = flag;

		if (_standardsCountryExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setFlag", String.class);

				method.invoke(_standardsCountryExtRemoteModel, flag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setRegionId(long regionId) {
		try {
			String methodName = "setRegionId";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { regionId };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getSubRegionCode() {
		try {
			String methodName = "getSubRegionCode";

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
	public long getRegionId() {
		try {
			String methodName = "getRegionId";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSubRegionCode(java.lang.String subRegionCode) {
		try {
			String methodName = "setSubRegionCode";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { subRegionCode };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getRegionCode() {
		try {
			String methodName = "getRegionCode";

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
	public void setRegionCode(java.lang.String regionCode) {
		try {
			String methodName = "setRegionCode";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { regionCode };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getStandardsCountryExtRemoteModel() {
		return _standardsCountryExtRemoteModel;
	}

	public void setStandardsCountryExtRemoteModel(
		BaseModel<?> standardsCountryExtRemoteModel) {
		_standardsCountryExtRemoteModel = standardsCountryExtRemoteModel;
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

		Class<?> remoteModelClass = _standardsCountryExtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsCountryExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsCountryExtLocalServiceUtil.addStandardsCountryExt(this);
		}
		else {
			StandardsCountryExtLocalServiceUtil.updateStandardsCountryExt(this);
		}
	}

	@Override
	public StandardsCountryExt toEscapedModel() {
		return (StandardsCountryExt)ProxyUtil.newProxyInstance(StandardsCountryExt.class.getClassLoader(),
			new Class[] { StandardsCountryExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsCountryExtClp clone = new StandardsCountryExtClp();

		clone.setRowNum(getRowNum());
		clone.setCountryCode(getCountryCode());
		clone.setFlag(getFlag());

		return clone;
	}

	@Override
	public int compareTo(StandardsCountryExt standardsCountryExt) {
		long primaryKey = standardsCountryExt.getPrimaryKey();

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

		if (!(obj instanceof StandardsCountryExtClp)) {
			return false;
		}

		StandardsCountryExtClp standardsCountryExt = (StandardsCountryExtClp)obj;

		long primaryKey = standardsCountryExt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{rowNum=");
		sb.append(getRowNum());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", flag=");
		sb.append(getFlag());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsCountryExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>rowNum</column-name><column-value><![CDATA[");
		sb.append(getRowNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flag</column-name><column-value><![CDATA[");
		sb.append(getFlag());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _rowNum;
	private String _countryCode;
	private String _flag;
	private BaseModel<?> _standardsCountryExtRemoteModel;
}