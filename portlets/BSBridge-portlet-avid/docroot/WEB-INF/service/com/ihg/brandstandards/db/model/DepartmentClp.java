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
import com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil;

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
public class DepartmentClp extends BaseModelImpl<Department>
	implements Department {
	public DepartmentClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Department.class;
	}

	@Override
	public String getModelClassName() {
		return Department.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _departmentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDepartmentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _departmentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("description", getDescription());
		attributes.put("activeInd", getActiveInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
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
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_departmentRemoteModel, departmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartmentName() {
		return _departmentName;
	}

	@Override
	public void setDepartmentName(String departmentName) {
		_departmentName = departmentName;

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentName",
						String.class);

				method.invoke(_departmentRemoteModel, departmentName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_departmentRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActiveInd() {
		return _activeInd;
	}

	@Override
	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveInd", String.class);

				method.invoke(_departmentRemoteModel, activeInd);
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

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_departmentRemoteModel, creatorId);
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

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_departmentRemoteModel, createdDate);
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

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_departmentRemoteModel, updatedBy);
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

		if (_departmentRemoteModel != null) {
			try {
				Class<?> clazz = _departmentRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_departmentRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDepartmentRemoteModel() {
		return _departmentRemoteModel;
	}

	public void setDepartmentRemoteModel(BaseModel<?> departmentRemoteModel) {
		_departmentRemoteModel = departmentRemoteModel;
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

		Class<?> remoteModelClass = _departmentRemoteModel.getClass();

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

		Object returnValue = method.invoke(_departmentRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DepartmentLocalServiceUtil.addDepartment(this);
		}
		else {
			DepartmentLocalServiceUtil.updateDepartment(this);
		}
	}

	@Override
	public Department toEscapedModel() {
		return (Department)ProxyUtil.newProxyInstance(Department.class.getClassLoader(),
			new Class[] { Department.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DepartmentClp clone = new DepartmentClp();

		clone.setDepartmentId(getDepartmentId());
		clone.setDepartmentName(getDepartmentName());
		clone.setDescription(getDescription());
		clone.setActiveInd(getActiveInd());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(Department department) {
		int value = 0;

		if (getDepartmentId() < department.getDepartmentId()) {
			value = -1;
		}
		else if (getDepartmentId() > department.getDepartmentId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof DepartmentClp)) {
			return false;
		}

		DepartmentClp department = (DepartmentClp)obj;

		long primaryKey = department.getPrimaryKey();

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

		sb.append("{departmentId=");
		sb.append(getDepartmentId());
		sb.append(", departmentName=");
		sb.append(getDepartmentName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", activeInd=");
		sb.append(getActiveInd());
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
		sb.append("com.ihg.brandstandards.db.model.Department");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentName</column-name><column-value><![CDATA[");
		sb.append(getDepartmentName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeInd</column-name><column-value><![CDATA[");
		sb.append(getActiveInd());
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

	private long _departmentId;
	private String _departmentName;
	private String _description;
	private String _activeInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _departmentRemoteModel;
}