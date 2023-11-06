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

package com.ihg.grs.common.model;

import com.ihg.grs.common.service.ClpSerializer;
import com.ihg.grs.common.service.DirectoryLocalServiceUtil;

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
 * @author gulam.vora
 */
public class DirectoryClp extends BaseModelImpl<Directory> implements Directory {
	public DirectoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Directory.class;
	}

	@Override
	public String getModelClassName() {
		return Directory.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _directoryId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setDirectoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _directoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("directoryId", getDirectoryId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("businessTitle", getBusinessTitle());
		attributes.put("geoRegion", getGeoRegion());
		attributes.put("role", getRole());
		attributes.put("regionType", getRegionType());
		attributes.put("organizationName", getOrganizationName());
		attributes.put("portraitURL", getPortraitURL());
		attributes.put("createdate", getCreatedate());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("updatedate", getUpdatedate());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer directoryId = (Integer)attributes.get("directoryId");

		if (directoryId != null) {
			setDirectoryId(directoryId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String businessTitle = (String)attributes.get("businessTitle");

		if (businessTitle != null) {
			setBusinessTitle(businessTitle);
		}

		String geoRegion = (String)attributes.get("geoRegion");

		if (geoRegion != null) {
			setGeoRegion(geoRegion);
		}

		String role = (String)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		String regionType = (String)attributes.get("regionType");

		if (regionType != null) {
			setRegionType(regionType);
		}

		String organizationName = (String)attributes.get("organizationName");

		if (organizationName != null) {
			setOrganizationName(organizationName);
		}

		String portraitURL = (String)attributes.get("portraitURL");

		if (portraitURL != null) {
			setPortraitURL(portraitURL);
		}

		Date createdate = (Date)attributes.get("createdate");

		if (createdate != null) {
			setCreatedate(createdate);
		}

		String createUserId = (String)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		String lastUpdateUserId = (String)attributes.get("lastUpdateUserId");

		if (lastUpdateUserId != null) {
			setLastUpdateUserId(lastUpdateUserId);
		}

		Date updatedate = (Date)attributes.get("updatedate");

		if (updatedate != null) {
			setUpdatedate(updatedate);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public int getDirectoryId() {
		return _directoryId;
	}

	@Override
	public void setDirectoryId(int directoryId) {
		_directoryId = directoryId;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDirectoryId", int.class);

				method.invoke(_directoryRemoteModel, directoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_directoryRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_directoryRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusinessTitle() {
		return _businessTitle;
	}

	@Override
	public void setBusinessTitle(String businessTitle) {
		_businessTitle = businessTitle;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessTitle", String.class);

				method.invoke(_directoryRemoteModel, businessTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeoRegion() {
		return _geoRegion;
	}

	@Override
	public void setGeoRegion(String geoRegion) {
		_geoRegion = geoRegion;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGeoRegion", String.class);

				method.invoke(_directoryRemoteModel, geoRegion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRole() {
		return _role;
	}

	@Override
	public void setRole(String role) {
		_role = role;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setRole", String.class);

				method.invoke(_directoryRemoteModel, role);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionType() {
		return _regionType;
	}

	@Override
	public void setRegionType(String regionType) {
		_regionType = regionType;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionType", String.class);

				method.invoke(_directoryRemoteModel, regionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrganizationName() {
		return _organizationName;
	}

	@Override
	public void setOrganizationName(String organizationName) {
		_organizationName = organizationName;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationName",
						String.class);

				method.invoke(_directoryRemoteModel, organizationName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPortraitURL() {
		return _portraitURL;
	}

	@Override
	public void setPortraitURL(String portraitURL) {
		_portraitURL = portraitURL;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPortraitURL", String.class);

				method.invoke(_directoryRemoteModel, portraitURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedate() {
		return _createdate;
	}

	@Override
	public void setCreatedate(Date createdate) {
		_createdate = createdate;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedate", Date.class);

				method.invoke(_directoryRemoteModel, createdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", String.class);

				method.invoke(_directoryRemoteModel, createUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastUpdateUserId() {
		return _lastUpdateUserId;
	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		_lastUpdateUserId = lastUpdateUserId;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateUserId",
						String.class);

				method.invoke(_directoryRemoteModel, lastUpdateUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdatedate() {
		return _updatedate;
	}

	@Override
	public void setUpdatedate(Date updatedate) {
		_updatedate = updatedate;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedate", Date.class);

				method.invoke(_directoryRemoteModel, updatedate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_directoryRemoteModel != null) {
			try {
				Class<?> clazz = _directoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_directoryRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDirectoryRemoteModel() {
		return _directoryRemoteModel;
	}

	public void setDirectoryRemoteModel(BaseModel<?> directoryRemoteModel) {
		_directoryRemoteModel = directoryRemoteModel;
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

		Class<?> remoteModelClass = _directoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_directoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DirectoryLocalServiceUtil.addDirectory(this);
		}
		else {
			DirectoryLocalServiceUtil.updateDirectory(this);
		}
	}

	@Override
	public Directory toEscapedModel() {
		return (Directory)ProxyUtil.newProxyInstance(Directory.class.getClassLoader(),
			new Class[] { Directory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DirectoryClp clone = new DirectoryClp();

		clone.setDirectoryId(getDirectoryId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setBusinessTitle(getBusinessTitle());
		clone.setGeoRegion(getGeoRegion());
		clone.setRole(getRole());
		clone.setRegionType(getRegionType());
		clone.setOrganizationName(getOrganizationName());
		clone.setPortraitURL(getPortraitURL());
		clone.setCreatedate(getCreatedate());
		clone.setCreateUserId(getCreateUserId());
		clone.setLastUpdateUserId(getLastUpdateUserId());
		clone.setUpdatedate(getUpdatedate());
		clone.setEmail(getEmail());

		return clone;
	}

	@Override
	public int compareTo(Directory directory) {
		int primaryKey = directory.getPrimaryKey();

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

		if (!(obj instanceof DirectoryClp)) {
			return false;
		}

		DirectoryClp directory = (DirectoryClp)obj;

		int primaryKey = directory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{directoryId=");
		sb.append(getDirectoryId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", businessTitle=");
		sb.append(getBusinessTitle());
		sb.append(", geoRegion=");
		sb.append(getGeoRegion());
		sb.append(", role=");
		sb.append(getRole());
		sb.append(", regionType=");
		sb.append(getRegionType());
		sb.append(", organizationName=");
		sb.append(getOrganizationName());
		sb.append(", portraitURL=");
		sb.append(getPortraitURL());
		sb.append(", createdate=");
		sb.append(getCreatedate());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", lastUpdateUserId=");
		sb.append(getLastUpdateUserId());
		sb.append(", updatedate=");
		sb.append(getUpdatedate());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.ihg.grs.common.model.Directory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>directoryId</column-name><column-value><![CDATA[");
		sb.append(getDirectoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessTitle</column-name><column-value><![CDATA[");
		sb.append(getBusinessTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>geoRegion</column-name><column-value><![CDATA[");
		sb.append(getGeoRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>role</column-name><column-value><![CDATA[");
		sb.append(getRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionType</column-name><column-value><![CDATA[");
		sb.append(getRegionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationName</column-name><column-value><![CDATA[");
		sb.append(getOrganizationName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>portraitURL</column-name><column-value><![CDATA[");
		sb.append(getPortraitURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdate</column-name><column-value><![CDATA[");
		sb.append(getCreatedate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastUpdateUserId</column-name><column-value><![CDATA[");
		sb.append(getLastUpdateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _directoryId;
	private String _firstName;
	private String _lastName;
	private String _businessTitle;
	private String _geoRegion;
	private String _role;
	private String _regionType;
	private String _organizationName;
	private String _portraitURL;
	private Date _createdate;
	private String _createUserId;
	private String _lastUpdateUserId;
	private Date _updatedate;
	private String _email;
	private BaseModel<?> _directoryRemoteModel;
	private Class<?> _clpSerializerClass = com.ihg.grs.common.service.ClpSerializer.class;
}