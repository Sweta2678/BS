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
import com.ihg.brandstandards.db.service.TreeXMLLocalServiceUtil;

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
public class TreeXMLClp extends BaseModelImpl<TreeXML> implements TreeXML {
	public TreeXMLClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TreeXML.class;
	}

	@Override
	public String getModelClassName() {
		return TreeXML.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("XMLLOB", getXMLLOB());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID = (Long)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String XMLLOB = (String)attributes.get("XMLLOB");

		if (XMLLOB != null) {
			setXMLLOB(XMLLOB);
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
	public long getID() {
		return _ID;
	}

	@Override
	public void setID(long ID) {
		_ID = ID;

		if (_treeXMLRemoteModel != null) {
			try {
				Class<?> clazz = _treeXMLRemoteModel.getClass();

				Method method = clazz.getMethod("setID", long.class);

				method.invoke(_treeXMLRemoteModel, ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXMLLOB() {
		return _XMLLOB;
	}

	@Override
	public void setXMLLOB(String XMLLOB) {
		_XMLLOB = XMLLOB;

		if (_treeXMLRemoteModel != null) {
			try {
				Class<?> clazz = _treeXMLRemoteModel.getClass();

				Method method = clazz.getMethod("setXMLLOB", String.class);

				method.invoke(_treeXMLRemoteModel, XMLLOB);
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

		if (_treeXMLRemoteModel != null) {
			try {
				Class<?> clazz = _treeXMLRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_treeXMLRemoteModel, creatorId);
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

		if (_treeXMLRemoteModel != null) {
			try {
				Class<?> clazz = _treeXMLRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_treeXMLRemoteModel, createdDate);
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

		if (_treeXMLRemoteModel != null) {
			try {
				Class<?> clazz = _treeXMLRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_treeXMLRemoteModel, updatedBy);
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

		if (_treeXMLRemoteModel != null) {
			try {
				Class<?> clazz = _treeXMLRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_treeXMLRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTreeXMLRemoteModel() {
		return _treeXMLRemoteModel;
	}

	public void setTreeXMLRemoteModel(BaseModel<?> treeXMLRemoteModel) {
		_treeXMLRemoteModel = treeXMLRemoteModel;
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

		Class<?> remoteModelClass = _treeXMLRemoteModel.getClass();

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

		Object returnValue = method.invoke(_treeXMLRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TreeXMLLocalServiceUtil.addTreeXML(this);
		}
		else {
			TreeXMLLocalServiceUtil.updateTreeXML(this);
		}
	}

	@Override
	public TreeXML toEscapedModel() {
		return (TreeXML)ProxyUtil.newProxyInstance(TreeXML.class.getClassLoader(),
			new Class[] { TreeXML.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TreeXMLClp clone = new TreeXMLClp();

		clone.setID(getID());
		clone.setXMLLOB(getXMLLOB());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(TreeXML treeXML) {
		long primaryKey = treeXML.getPrimaryKey();

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

		if (!(obj instanceof TreeXMLClp)) {
			return false;
		}

		TreeXMLClp treeXML = (TreeXMLClp)obj;

		long primaryKey = treeXML.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", XMLLOB=");
		sb.append(getXMLLOB());
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
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.TreeXML");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>XMLLOB</column-name><column-value><![CDATA[");
		sb.append(getXMLLOB());
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

	private long _ID;
	private String _XMLLOB;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _treeXMLRemoteModel;
}