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
import com.ihg.brandstandards.db.service.UserSearchCriteriaLocalServiceUtil;

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
public class UserSearchCriteriaClp extends BaseModelImpl<UserSearchCriteria>
	implements UserSearchCriteria {
	public UserSearchCriteriaClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserSearchCriteria.class;
	}

	@Override
	public String getModelClassName() {
		return UserSearchCriteria.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userSearchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserSearchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userSearchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userSearchId", getUserSearchId());
		attributes.put("searchName", getSearchName());
		attributes.put("searchCriteria", getSearchCriteria());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("moduleName", getModuleName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userSearchId = (Long)attributes.get("userSearchId");

		if (userSearchId != null) {
			setUserSearchId(userSearchId);
		}

		String searchName = (String)attributes.get("searchName");

		if (searchName != null) {
			setSearchName(searchName);
		}

		String searchCriteria = (String)attributes.get("searchCriteria");

		if (searchCriteria != null) {
			setSearchCriteria(searchCriteria);
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

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}
	}

	@Override
	public long getUserSearchId() {
		return _userSearchId;
	}

	@Override
	public void setUserSearchId(long userSearchId) {
		_userSearchId = userSearchId;

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setUserSearchId", long.class);

				method.invoke(_userSearchCriteriaRemoteModel, userSearchId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSearchName() {
		return _searchName;
	}

	@Override
	public void setSearchName(String searchName) {
		_searchName = searchName;

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchName", String.class);

				method.invoke(_userSearchCriteriaRemoteModel, searchName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSearchCriteria() {
		return _searchCriteria;
	}

	@Override
	public void setSearchCriteria(String searchCriteria) {
		_searchCriteria = searchCriteria;

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setSearchCriteria",
						String.class);

				method.invoke(_userSearchCriteriaRemoteModel, searchCriteria);
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

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_userSearchCriteriaRemoteModel, creatorId);
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

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_userSearchCriteriaRemoteModel, createdDate);
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

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_userSearchCriteriaRemoteModel, updatedBy);
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

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_userSearchCriteriaRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleName() {
		return _moduleName;
	}

	@Override
	public void setModuleName(String moduleName) {
		_moduleName = moduleName;

		if (_userSearchCriteriaRemoteModel != null) {
			try {
				Class<?> clazz = _userSearchCriteriaRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleName", String.class);

				method.invoke(_userSearchCriteriaRemoteModel, moduleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserSearchCriteriaRemoteModel() {
		return _userSearchCriteriaRemoteModel;
	}

	public void setUserSearchCriteriaRemoteModel(
		BaseModel<?> userSearchCriteriaRemoteModel) {
		_userSearchCriteriaRemoteModel = userSearchCriteriaRemoteModel;
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

		Class<?> remoteModelClass = _userSearchCriteriaRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userSearchCriteriaRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserSearchCriteriaLocalServiceUtil.addUserSearchCriteria(this);
		}
		else {
			UserSearchCriteriaLocalServiceUtil.updateUserSearchCriteria(this);
		}
	}

	@Override
	public UserSearchCriteria toEscapedModel() {
		return (UserSearchCriteria)ProxyUtil.newProxyInstance(UserSearchCriteria.class.getClassLoader(),
			new Class[] { UserSearchCriteria.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserSearchCriteriaClp clone = new UserSearchCriteriaClp();

		clone.setUserSearchId(getUserSearchId());
		clone.setSearchName(getSearchName());
		clone.setSearchCriteria(getSearchCriteria());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setModuleName(getModuleName());

		return clone;
	}

	@Override
	public int compareTo(UserSearchCriteria userSearchCriteria) {
		long primaryKey = userSearchCriteria.getPrimaryKey();

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

		if (!(obj instanceof UserSearchCriteriaClp)) {
			return false;
		}

		UserSearchCriteriaClp userSearchCriteria = (UserSearchCriteriaClp)obj;

		long primaryKey = userSearchCriteria.getPrimaryKey();

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

		sb.append("{userSearchId=");
		sb.append(getUserSearchId());
		sb.append(", searchName=");
		sb.append(getSearchName());
		sb.append(", searchCriteria=");
		sb.append(getSearchCriteria());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", moduleName=");
		sb.append(getModuleName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.UserSearchCriteria");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userSearchId</column-name><column-value><![CDATA[");
		sb.append(getUserSearchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchName</column-name><column-value><![CDATA[");
		sb.append(getSearchName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchCriteria</column-name><column-value><![CDATA[");
		sb.append(getSearchCriteria());
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
			"<column><column-name>moduleName</column-name><column-value><![CDATA[");
		sb.append(getModuleName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userSearchId;
	private String _searchName;
	private String _searchCriteria;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private String _moduleName;
	private BaseModel<?> _userSearchCriteriaRemoteModel;
}