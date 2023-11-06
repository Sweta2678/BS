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
import com.ihg.brandstandards.db.service.StandardsCountryLocalServiceUtil;

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
public class StandardsCountryClp extends BaseModelImpl<StandardsCountry>
	implements StandardsCountry {
	public StandardsCountryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCountry.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCountry.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _countryNameCode;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCountryNameCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _countryNameCode;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryNameCode", getCountryNameCode());
		attributes.put("regionId", getRegionId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("subRegionId", getSubRegionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String countryNameCode = (String)attributes.get("countryNameCode");

		if (countryNameCode != null) {
			setCountryNameCode(countryNameCode);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
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

		Long subRegionId = (Long)attributes.get("subRegionId");

		if (subRegionId != null) {
			setSubRegionId(subRegionId);
		}
	}

	@Override
	public String getCountryNameCode() {
		return _countryNameCode;
	}

	@Override
	public void setCountryNameCode(String countryNameCode) {
		_countryNameCode = countryNameCode;

		if (_standardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryNameCode",
						String.class);

				method.invoke(_standardsCountryRemoteModel, countryNameCode);
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

		if (_standardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_standardsCountryRemoteModel, regionId);
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

		if (_standardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsCountryRemoteModel, creatorId);
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

		if (_standardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsCountryRemoteModel, createdDate);
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

		if (_standardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsCountryRemoteModel, updatedBy);
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

		if (_standardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsCountryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubRegionId() {
		return _subRegionId;
	}

	@Override
	public void setSubRegionId(long subRegionId) {
		_subRegionId = subRegionId;

		if (_standardsCountryRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryRemoteModel.getClass();

				Method method = clazz.getMethod("setSubRegionId", long.class);

				method.invoke(_standardsCountryRemoteModel, subRegionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsCountryRemoteModel() {
		return _standardsCountryRemoteModel;
	}

	public void setStandardsCountryRemoteModel(
		BaseModel<?> standardsCountryRemoteModel) {
		_standardsCountryRemoteModel = standardsCountryRemoteModel;
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

		Class<?> remoteModelClass = _standardsCountryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsCountryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsCountryLocalServiceUtil.addStandardsCountry(this);
		}
		else {
			StandardsCountryLocalServiceUtil.updateStandardsCountry(this);
		}
	}

	@Override
	public StandardsCountry toEscapedModel() {
		return (StandardsCountry)ProxyUtil.newProxyInstance(StandardsCountry.class.getClassLoader(),
			new Class[] { StandardsCountry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsCountryClp clone = new StandardsCountryClp();

		clone.setCountryNameCode(getCountryNameCode());
		clone.setRegionId(getRegionId());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setSubRegionId(getSubRegionId());

		return clone;
	}

	@Override
	public int compareTo(StandardsCountry standardsCountry) {
		int value = 0;

		if (getRegionId() < standardsCountry.getRegionId()) {
			value = -1;
		}
		else if (getRegionId() > standardsCountry.getRegionId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getCountryNameCode()
					.compareTo(standardsCountry.getCountryNameCode());

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

		if (!(obj instanceof StandardsCountryClp)) {
			return false;
		}

		StandardsCountryClp standardsCountry = (StandardsCountryClp)obj;

		String primaryKey = standardsCountry.getPrimaryKey();

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

		sb.append("{countryNameCode=");
		sb.append(getCountryNameCode());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", subRegionId=");
		sb.append(getSubRegionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>countryNameCode</column-name><column-value><![CDATA[");
		sb.append(getCountryNameCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
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
			"<column><column-name>subRegionId</column-name><column-value><![CDATA[");
		sb.append(getSubRegionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _countryNameCode;
	private long _regionId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _subRegionId;
	private BaseModel<?> _standardsCountryRemoteModel;
}