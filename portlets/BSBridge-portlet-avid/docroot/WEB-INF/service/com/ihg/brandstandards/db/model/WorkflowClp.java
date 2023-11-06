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
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;

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
public class WorkflowClp extends BaseModelImpl<Workflow> implements Workflow {
	public WorkflowClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Workflow.class;
	}

	@Override
	public String getModelClassName() {
		return Workflow.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _workflowActvtId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowActvtId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowActvtId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowActvtId", getWorkflowActvtId());
		attributes.put("objectId", getObjectId());
		attributes.put("objectType", getObjectType());
		attributes.put("status", getStatus());
		attributes.put("prevStatus", getPrevStatus());
		attributes.put("title", getTitle());
		attributes.put("comment", getComment());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowActvtId = (Long)attributes.get("workflowActvtId");

		if (workflowActvtId != null) {
			setWorkflowActvtId(workflowActvtId);
		}

		Long objectId = (Long)attributes.get("objectId");

		if (objectId != null) {
			setObjectId(objectId);
		}

		String objectType = (String)attributes.get("objectType");

		if (objectType != null) {
			setObjectType(objectType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String prevStatus = (String)attributes.get("prevStatus");

		if (prevStatus != null) {
			setPrevStatus(prevStatus);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
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
	public long getWorkflowActvtId() {
		return _workflowActvtId;
	}

	@Override
	public void setWorkflowActvtId(long workflowActvtId) {
		_workflowActvtId = workflowActvtId;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowActvtId", long.class);

				method.invoke(_workflowRemoteModel, workflowActvtId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getObjectId() {
		return _objectId;
	}

	@Override
	public void setObjectId(long objectId) {
		_objectId = objectId;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectId", long.class);

				method.invoke(_workflowRemoteModel, objectId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getObjectType() {
		return _objectType;
	}

	@Override
	public void setObjectType(String objectType) {
		_objectType = objectType;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setObjectType", String.class);

				method.invoke(_workflowRemoteModel, objectType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_workflowRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrevStatus() {
		return _prevStatus;
	}

	@Override
	public void setPrevStatus(String prevStatus) {
		_prevStatus = prevStatus;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setPrevStatus", String.class);

				method.invoke(_workflowRemoteModel, prevStatus);
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

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_workflowRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_workflowRemoteModel, comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_workflowRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChainCode() {
		return _chainCode;
	}

	@Override
	public void setChainCode(String chainCode) {
		_chainCode = chainCode;

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_workflowRemoteModel, chainCode);
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

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_workflowRemoteModel, creatorId);
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

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_workflowRemoteModel, createdDate);
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

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_workflowRemoteModel, updatedBy);
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

		if (_workflowRemoteModel != null) {
			try {
				Class<?> clazz = _workflowRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_workflowRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkflowRemoteModel() {
		return _workflowRemoteModel;
	}

	public void setWorkflowRemoteModel(BaseModel<?> workflowRemoteModel) {
		_workflowRemoteModel = workflowRemoteModel;
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

		Class<?> remoteModelClass = _workflowRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workflowRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkflowLocalServiceUtil.addWorkflow(this);
		}
		else {
			WorkflowLocalServiceUtil.updateWorkflow(this);
		}
	}

	@Override
	public Workflow toEscapedModel() {
		return (Workflow)ProxyUtil.newProxyInstance(Workflow.class.getClassLoader(),
			new Class[] { Workflow.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkflowClp clone = new WorkflowClp();

		clone.setWorkflowActvtId(getWorkflowActvtId());
		clone.setObjectId(getObjectId());
		clone.setObjectType(getObjectType());
		clone.setStatus(getStatus());
		clone.setPrevStatus(getPrevStatus());
		clone.setTitle(getTitle());
		clone.setComment(getComment());
		clone.setCreatedBy(getCreatedBy());
		clone.setChainCode(getChainCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(Workflow workflow) {
		long primaryKey = workflow.getPrimaryKey();

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

		if (!(obj instanceof WorkflowClp)) {
			return false;
		}

		WorkflowClp workflow = (WorkflowClp)obj;

		long primaryKey = workflow.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{workflowActvtId=");
		sb.append(getWorkflowActvtId());
		sb.append(", objectId=");
		sb.append(getObjectId());
		sb.append(", objectType=");
		sb.append(getObjectType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", prevStatus=");
		sb.append(getPrevStatus());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", chainCode=");
		sb.append(getChainCode());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.Workflow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workflowActvtId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowActvtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objectId</column-name><column-value><![CDATA[");
		sb.append(getObjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>objectType</column-name><column-value><![CDATA[");
		sb.append(getObjectType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prevStatus</column-name><column-value><![CDATA[");
		sb.append(getPrevStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
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

	private long _workflowActvtId;
	private long _objectId;
	private String _objectType;
	private String _status;
	private String _prevStatus;
	private String _title;
	private String _comment;
	private String _createdBy;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _workflowRemoteModel;
}