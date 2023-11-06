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
import com.ihg.brandstandards.db.service.GEMCodeLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class GEMCodeClp extends BaseModelImpl<GEMCode> implements GEMCode {
	public GEMCodeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMCode.class;
	}

	@Override
	public String getModelClassName() {
		return GEMCode.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _code;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setCode(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _code;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("code", getCode());
		attributes.put("codeDesc", getCodeDesc());
		attributes.put("codeVal", getCodeVal());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String codeDesc = (String)attributes.get("codeDesc");

		if (codeDesc != null) {
			setCodeDesc(codeDesc);
		}

		String codeVal = (String)attributes.get("codeVal");

		if (codeVal != null) {
			setCodeVal(codeVal);
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
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_gemCodeRemoteModel != null) {
			try {
				Class<?> clazz = _gemCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_gemCodeRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodeDesc() {
		return _codeDesc;
	}

	@Override
	public void setCodeDesc(String codeDesc) {
		_codeDesc = codeDesc;

		if (_gemCodeRemoteModel != null) {
			try {
				Class<?> clazz = _gemCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeDesc", String.class);

				method.invoke(_gemCodeRemoteModel, codeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCodeVal() {
		return _codeVal;
	}

	@Override
	public void setCodeVal(String codeVal) {
		_codeVal = codeVal;

		if (_gemCodeRemoteModel != null) {
			try {
				Class<?> clazz = _gemCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCodeVal", String.class);

				method.invoke(_gemCodeRemoteModel, codeVal);
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

		if (_gemCodeRemoteModel != null) {
			try {
				Class<?> clazz = _gemCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemCodeRemoteModel, creatorId);
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

		if (_gemCodeRemoteModel != null) {
			try {
				Class<?> clazz = _gemCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemCodeRemoteModel, createdDate);
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

		if (_gemCodeRemoteModel != null) {
			try {
				Class<?> clazz = _gemCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemCodeRemoteModel, updatedBy);
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

		if (_gemCodeRemoteModel != null) {
			try {
				Class<?> clazz = _gemCodeRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemCodeRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMCodeRemoteModel() {
		return _gemCodeRemoteModel;
	}

	public void setGEMCodeRemoteModel(BaseModel<?> gemCodeRemoteModel) {
		_gemCodeRemoteModel = gemCodeRemoteModel;
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

		Class<?> remoteModelClass = _gemCodeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemCodeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMCodeLocalServiceUtil.addGEMCode(this);
		}
		else {
			GEMCodeLocalServiceUtil.updateGEMCode(this);
		}
	}

	@Override
	public GEMCode toEscapedModel() {
		return (GEMCode)ProxyUtil.newProxyInstance(GEMCode.class.getClassLoader(),
			new Class[] { GEMCode.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMCodeClp clone = new GEMCodeClp();

		clone.setCode(getCode());
		clone.setCodeDesc(getCodeDesc());
		clone.setCodeVal(getCodeVal());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMCode gemCode) {
		int value = 0;

		value = DateUtil.compareTo(getCreatedDate(), gemCode.getCreatedDate());

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

		if (!(obj instanceof GEMCodeClp)) {
			return false;
		}

		GEMCodeClp gemCode = (GEMCodeClp)obj;

		String primaryKey = gemCode.getPrimaryKey();

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

		sb.append("{code=");
		sb.append(getCode());
		sb.append(", codeDesc=");
		sb.append(getCodeDesc());
		sb.append(", codeVal=");
		sb.append(getCodeVal());
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
		sb.append("com.ihg.brandstandards.db.model.GEMCode");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeDesc</column-name><column-value><![CDATA[");
		sb.append(getCodeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codeVal</column-name><column-value><![CDATA[");
		sb.append(getCodeVal());
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

	private String _code;
	private String _codeDesc;
	private String _codeVal;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemCodeRemoteModel;
}