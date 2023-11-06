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
import com.ihg.brandstandards.db.service.StandardsAuthorsLocalServiceUtil;

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
public class StandardsAuthorsClp extends BaseModelImpl<StandardsAuthors>
	implements StandardsAuthors {
	public StandardsAuthorsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsAuthors.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsAuthors.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stdAuthorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdAuthorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdAuthorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdAuthorId", getStdAuthorId());
		attributes.put("stdId", getStdId());
		attributes.put("authorName", getAuthorName());
		attributes.put("isPrimary", getIsPrimary());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdAuthorId = (Long)attributes.get("stdAuthorId");

		if (stdAuthorId != null) {
			setStdAuthorId(stdAuthorId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String authorName = (String)attributes.get("authorName");

		if (authorName != null) {
			setAuthorName(authorName);
		}

		String isPrimary = (String)attributes.get("isPrimary");

		if (isPrimary != null) {
			setIsPrimary(isPrimary);
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
	public long getStdAuthorId() {
		return _stdAuthorId;
	}

	@Override
	public void setStdAuthorId(long stdAuthorId) {
		_stdAuthorId = stdAuthorId;

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdAuthorId", long.class);

				method.invoke(_standardsAuthorsRemoteModel, stdAuthorId);
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

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsAuthorsRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthorName() {
		return _authorName;
	}

	@Override
	public void setAuthorName(String authorName) {
		_authorName = authorName;

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorName", String.class);

				method.invoke(_standardsAuthorsRemoteModel, authorName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsPrimary() {
		return _isPrimary;
	}

	@Override
	public void setIsPrimary(String isPrimary) {
		_isPrimary = isPrimary;

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setIsPrimary", String.class);

				method.invoke(_standardsAuthorsRemoteModel, isPrimary);
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

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsAuthorsRemoteModel, creatorId);
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

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsAuthorsRemoteModel, createdDate);
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

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsAuthorsRemoteModel, updatedBy);
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

		if (_standardsAuthorsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsAuthorsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsAuthorsRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsAuthorsRemoteModel() {
		return _standardsAuthorsRemoteModel;
	}

	public void setStandardsAuthorsRemoteModel(
		BaseModel<?> standardsAuthorsRemoteModel) {
		_standardsAuthorsRemoteModel = standardsAuthorsRemoteModel;
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

		Class<?> remoteModelClass = _standardsAuthorsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsAuthorsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsAuthorsLocalServiceUtil.addStandardsAuthors(this);
		}
		else {
			StandardsAuthorsLocalServiceUtil.updateStandardsAuthors(this);
		}
	}

	@Override
	public StandardsAuthors toEscapedModel() {
		return (StandardsAuthors)ProxyUtil.newProxyInstance(StandardsAuthors.class.getClassLoader(),
			new Class[] { StandardsAuthors.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsAuthorsClp clone = new StandardsAuthorsClp();

		clone.setStdAuthorId(getStdAuthorId());
		clone.setStdId(getStdId());
		clone.setAuthorName(getAuthorName());
		clone.setIsPrimary(getIsPrimary());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsAuthors standardsAuthors) {
		long primaryKey = standardsAuthors.getPrimaryKey();

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

		if (!(obj instanceof StandardsAuthorsClp)) {
			return false;
		}

		StandardsAuthorsClp standardsAuthors = (StandardsAuthorsClp)obj;

		long primaryKey = standardsAuthors.getPrimaryKey();

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

		sb.append("{stdAuthorId=");
		sb.append(getStdAuthorId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", authorName=");
		sb.append(getAuthorName());
		sb.append(", isPrimary=");
		sb.append(getIsPrimary());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsAuthors");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdAuthorId</column-name><column-value><![CDATA[");
		sb.append(getStdAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorName</column-name><column-value><![CDATA[");
		sb.append(getAuthorName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isPrimary</column-name><column-value><![CDATA[");
		sb.append(getIsPrimary());
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

	private long _stdAuthorId;
	private long _stdId;
	private String _authorName;
	private String _isPrimary;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _standardsAuthorsRemoteModel;
}