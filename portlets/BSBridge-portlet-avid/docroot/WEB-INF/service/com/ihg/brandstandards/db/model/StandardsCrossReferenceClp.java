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
import com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK;

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
public class StandardsCrossReferenceClp extends BaseModelImpl<StandardsCrossReference>
	implements StandardsCrossReference {
	public StandardsCrossReferenceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCrossReference.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCrossReference.class.getName();
	}

	@Override
	public StandardsCrossReferencePK getPrimaryKey() {
		return new StandardsCrossReferencePK(_stdId, _xrefStdId);
	}

	@Override
	public void setPrimaryKey(StandardsCrossReferencePK primaryKey) {
		setStdId(primaryKey.stdId);
		setXrefStdId(primaryKey.xrefStdId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardsCrossReferencePK(_stdId, _xrefStdId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardsCrossReferencePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("xrefStdId", getXrefStdId());
		attributes.put("dispOrderNumber", getDispOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long xrefStdId = (Long)attributes.get("xrefStdId");

		if (xrefStdId != null) {
			setXrefStdId(xrefStdId);
		}

		Long dispOrderNumber = (Long)attributes.get("dispOrderNumber");

		if (dispOrderNumber != null) {
			setDispOrderNumber(dispOrderNumber);
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
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_standardsCrossReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCrossReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsCrossReferenceRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXrefStdId() {
		return _xrefStdId;
	}

	@Override
	public void setXrefStdId(long xrefStdId) {
		_xrefStdId = xrefStdId;

		if (_standardsCrossReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCrossReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setXrefStdId", long.class);

				method.invoke(_standardsCrossReferenceRemoteModel, xrefStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDispOrderNumber() {
		return _dispOrderNumber;
	}

	@Override
	public void setDispOrderNumber(long dispOrderNumber) {
		_dispOrderNumber = dispOrderNumber;

		if (_standardsCrossReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCrossReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setDispOrderNumber", long.class);

				method.invoke(_standardsCrossReferenceRemoteModel,
					dispOrderNumber);
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

		if (_standardsCrossReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCrossReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsCrossReferenceRemoteModel, creatorId);
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

		if (_standardsCrossReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCrossReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsCrossReferenceRemoteModel, createdDate);
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

		if (_standardsCrossReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCrossReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsCrossReferenceRemoteModel, updatedBy);
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

		if (_standardsCrossReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCrossReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsCrossReferenceRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsCrossReferenceRemoteModel() {
		return _standardsCrossReferenceRemoteModel;
	}

	public void setStandardsCrossReferenceRemoteModel(
		BaseModel<?> standardsCrossReferenceRemoteModel) {
		_standardsCrossReferenceRemoteModel = standardsCrossReferenceRemoteModel;
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

		Class<?> remoteModelClass = _standardsCrossReferenceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsCrossReferenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsCrossReferenceLocalServiceUtil.addStandardsCrossReference(this);
		}
		else {
			StandardsCrossReferenceLocalServiceUtil.updateStandardsCrossReference(this);
		}
	}

	@Override
	public StandardsCrossReference toEscapedModel() {
		return (StandardsCrossReference)ProxyUtil.newProxyInstance(StandardsCrossReference.class.getClassLoader(),
			new Class[] { StandardsCrossReference.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsCrossReferenceClp clone = new StandardsCrossReferenceClp();

		clone.setStdId(getStdId());
		clone.setXrefStdId(getXrefStdId());
		clone.setDispOrderNumber(getDispOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsCrossReference standardsCrossReference) {
		StandardsCrossReferencePK primaryKey = standardsCrossReference.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsCrossReferenceClp)) {
			return false;
		}

		StandardsCrossReferenceClp standardsCrossReference = (StandardsCrossReferenceClp)obj;

		StandardsCrossReferencePK primaryKey = standardsCrossReference.getPrimaryKey();

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

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", xrefStdId=");
		sb.append(getXrefStdId());
		sb.append(", dispOrderNumber=");
		sb.append(getDispOrderNumber());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsCrossReference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xrefStdId</column-name><column-value><![CDATA[");
		sb.append(getXrefStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dispOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDispOrderNumber());
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

	private long _stdId;
	private long _xrefStdId;
	private long _dispOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _standardsCrossReferenceRemoteModel;
}