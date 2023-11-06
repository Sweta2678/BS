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
import com.ihg.brandstandards.db.service.PublishParmLocalServiceUtil;

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
public class PublishParmClp extends BaseModelImpl<PublishParm>
	implements PublishParm {
	public PublishParmClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PublishParm.class;
	}

	@Override
	public String getModelClassName() {
		return PublishParm.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publishParmId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishParmId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishParmId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishParmId", getPublishParmId());
		attributes.put("publishId", getPublishId());
		attributes.put("parmName", getParmName());
		attributes.put("parmValue", getParmValue());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishParmId = (Long)attributes.get("publishParmId");

		if (publishParmId != null) {
			setPublishParmId(publishParmId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String parmName = (String)attributes.get("parmName");

		if (parmName != null) {
			setParmName(parmName);
		}

		String parmValue = (String)attributes.get("parmValue");

		if (parmValue != null) {
			setParmValue(parmValue);
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
	public long getPublishParmId() {
		return _publishParmId;
	}

	@Override
	public void setPublishParmId(long publishParmId) {
		_publishParmId = publishParmId;

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishParmId", long.class);

				method.invoke(_publishParmRemoteModel, publishParmId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_publishParmRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParmName() {
		return _parmName;
	}

	@Override
	public void setParmName(String parmName) {
		_parmName = parmName;

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setParmName", String.class);

				method.invoke(_publishParmRemoteModel, parmName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParmValue() {
		return _parmValue;
	}

	@Override
	public void setParmValue(String parmValue) {
		_parmValue = parmValue;

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setParmValue", String.class);

				method.invoke(_publishParmRemoteModel, parmValue);
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

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_publishParmRemoteModel, creatorId);
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

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_publishParmRemoteModel, createdDate);
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

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_publishParmRemoteModel, updatedBy);
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

		if (_publishParmRemoteModel != null) {
			try {
				Class<?> clazz = _publishParmRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_publishParmRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublishParmRemoteModel() {
		return _publishParmRemoteModel;
	}

	public void setPublishParmRemoteModel(BaseModel<?> publishParmRemoteModel) {
		_publishParmRemoteModel = publishParmRemoteModel;
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

		Class<?> remoteModelClass = _publishParmRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publishParmRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishParmLocalServiceUtil.addPublishParm(this);
		}
		else {
			PublishParmLocalServiceUtil.updatePublishParm(this);
		}
	}

	@Override
	public PublishParm toEscapedModel() {
		return (PublishParm)ProxyUtil.newProxyInstance(PublishParm.class.getClassLoader(),
			new Class[] { PublishParm.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishParmClp clone = new PublishParmClp();

		clone.setPublishParmId(getPublishParmId());
		clone.setPublishId(getPublishId());
		clone.setParmName(getParmName());
		clone.setParmValue(getParmValue());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(PublishParm publishParm) {
		int value = 0;

		value = getParmName().compareTo(publishParm.getParmName());

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

		if (!(obj instanceof PublishParmClp)) {
			return false;
		}

		PublishParmClp publishParm = (PublishParmClp)obj;

		long primaryKey = publishParm.getPrimaryKey();

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

		sb.append("{publishParmId=");
		sb.append(getPublishParmId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", parmName=");
		sb.append(getParmName());
		sb.append(", parmValue=");
		sb.append(getParmValue());
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
		sb.append("com.ihg.brandstandards.db.model.PublishParm");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishParmId</column-name><column-value><![CDATA[");
		sb.append(getPublishParmId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parmName</column-name><column-value><![CDATA[");
		sb.append(getParmName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parmValue</column-name><column-value><![CDATA[");
		sb.append(getParmValue());
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

	private long _publishParmId;
	private long _publishId;
	private String _parmName;
	private String _parmValue;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _publishParmRemoteModel;
}