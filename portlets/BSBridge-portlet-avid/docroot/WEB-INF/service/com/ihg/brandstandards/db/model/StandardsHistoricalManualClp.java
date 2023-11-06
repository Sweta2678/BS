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
import com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalServiceUtil;

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
public class StandardsHistoricalManualClp extends BaseModelImpl<StandardsHistoricalManual>
	implements StandardsHistoricalManual {
	public StandardsHistoricalManualClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsHistoricalManual.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsHistoricalManual.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stdMnlId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdMnlId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdMnlId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdMnlId", getStdMnlId());
		attributes.put("stdId", getStdId());
		attributes.put("histManualId", getHistManualId());
		attributes.put("change", getChange());
		attributes.put("title", getTitle());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdMnlId = (Long)attributes.get("stdMnlId");

		if (stdMnlId != null) {
			setStdMnlId(stdMnlId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long histManualId = (Long)attributes.get("histManualId");

		if (histManualId != null) {
			setHistManualId(histManualId);
		}

		String change = (String)attributes.get("change");

		if (change != null) {
			setChange(change);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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
	public long getStdMnlId() {
		return _stdMnlId;
	}

	@Override
	public void setStdMnlId(long stdMnlId) {
		_stdMnlId = stdMnlId;

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setStdMnlId", long.class);

				method.invoke(_standardsHistoricalManualRemoteModel, stdMnlId);
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

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsHistoricalManualRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHistManualId() {
		return _histManualId;
	}

	@Override
	public void setHistManualId(long histManualId) {
		_histManualId = histManualId;

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setHistManualId", long.class);

				method.invoke(_standardsHistoricalManualRemoteModel,
					histManualId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChange() {
		return _change;
	}

	@Override
	public void setChange(String change) {
		_change = change;

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setChange", String.class);

				method.invoke(_standardsHistoricalManualRemoteModel, change);
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

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_standardsHistoricalManualRemoteModel, title);
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

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsHistoricalManualRemoteModel, creatorId);
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

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsHistoricalManualRemoteModel, createdDate);
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

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsHistoricalManualRemoteModel, updatedBy);
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

		if (_standardsHistoricalManualRemoteModel != null) {
			try {
				Class<?> clazz = _standardsHistoricalManualRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsHistoricalManualRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public java.lang.String getChain() {
		try {
			String methodName = "getChain";

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
	public java.lang.String getHistManualTitle() {
		try {
			String methodName = "getHistManualTitle";

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
	public void setChain(java.lang.String chain) {
		try {
			String methodName = "setChain";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { chain };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setHistManualTitle(java.lang.String histManualTitle) {
		try {
			String methodName = "setHistManualTitle";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { histManualTitle };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setRegion(java.lang.String region) {
		try {
			String methodName = "setRegion";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { region };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setHistManualType(java.lang.String histManualType) {
		try {
			String methodName = "setHistManualType";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { histManualType };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getHistManualType() {
		try {
			String methodName = "getHistManualType";

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
	public java.lang.String getRegion() {
		try {
			String methodName = "getRegion";

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

	public BaseModel<?> getStandardsHistoricalManualRemoteModel() {
		return _standardsHistoricalManualRemoteModel;
	}

	public void setStandardsHistoricalManualRemoteModel(
		BaseModel<?> standardsHistoricalManualRemoteModel) {
		_standardsHistoricalManualRemoteModel = standardsHistoricalManualRemoteModel;
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

		Class<?> remoteModelClass = _standardsHistoricalManualRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsHistoricalManualRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsHistoricalManualLocalServiceUtil.addStandardsHistoricalManual(this);
		}
		else {
			StandardsHistoricalManualLocalServiceUtil.updateStandardsHistoricalManual(this);
		}
	}

	@Override
	public StandardsHistoricalManual toEscapedModel() {
		return (StandardsHistoricalManual)ProxyUtil.newProxyInstance(StandardsHistoricalManual.class.getClassLoader(),
			new Class[] { StandardsHistoricalManual.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsHistoricalManualClp clone = new StandardsHistoricalManualClp();

		clone.setStdMnlId(getStdMnlId());
		clone.setStdId(getStdId());
		clone.setHistManualId(getHistManualId());
		clone.setChange(getChange());
		clone.setTitle(getTitle());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsHistoricalManual standardsHistoricalManual) {
		long primaryKey = standardsHistoricalManual.getPrimaryKey();

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

		if (!(obj instanceof StandardsHistoricalManualClp)) {
			return false;
		}

		StandardsHistoricalManualClp standardsHistoricalManual = (StandardsHistoricalManualClp)obj;

		long primaryKey = standardsHistoricalManual.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{stdMnlId=");
		sb.append(getStdMnlId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", histManualId=");
		sb.append(getHistManualId());
		sb.append(", change=");
		sb.append(getChange());
		sb.append(", title=");
		sb.append(getTitle());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsHistoricalManual");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdMnlId</column-name><column-value><![CDATA[");
		sb.append(getStdMnlId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>histManualId</column-name><column-value><![CDATA[");
		sb.append(getHistManualId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>change</column-name><column-value><![CDATA[");
		sb.append(getChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
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

	private long _stdMnlId;
	private long _stdId;
	private long _histManualId;
	private String _change;
	private String _title;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _standardsHistoricalManualRemoteModel;
}