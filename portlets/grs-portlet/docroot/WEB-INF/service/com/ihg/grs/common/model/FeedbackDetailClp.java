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
import com.ihg.grs.common.service.FeedbackDetailLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gulam.vora
 */
public class FeedbackDetailClp extends BaseModelImpl<FeedbackDetail>
	implements FeedbackDetail {
	public FeedbackDetailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FeedbackDetail.class;
	}

	@Override
	public String getModelClassName() {
		return FeedbackDetail.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _PORTAL_FEEDBACK_DTL_ID;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setPORTAL_FEEDBACK_DTL_ID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _PORTAL_FEEDBACK_DTL_ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("PORTAL_FEEDBACK_DTL_ID", getPORTAL_FEEDBACK_DTL_ID());
		attributes.put("feedbackId", getFeedbackId());
		attributes.put("feedbackType", getFeedbackType());
		attributes.put("subject", getSubject());
		attributes.put("message", getMessage());
		attributes.put("fileName", getFileName());
		attributes.put("fileContent", getFileContent());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createdate", getCreatedate());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("updatedate", getUpdatedate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer PORTAL_FEEDBACK_DTL_ID = (Integer)attributes.get(
				"PORTAL_FEEDBACK_DTL_ID");

		if (PORTAL_FEEDBACK_DTL_ID != null) {
			setPORTAL_FEEDBACK_DTL_ID(PORTAL_FEEDBACK_DTL_ID);
		}

		Integer feedbackId = (Integer)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		String feedbackType = (String)attributes.get("feedbackType");

		if (feedbackType != null) {
			setFeedbackType(feedbackType);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Blob fileContent = (Blob)attributes.get("fileContent");

		if (fileContent != null) {
			setFileContent(fileContent);
		}

		String createUserId = (String)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Date createdate = (Date)attributes.get("createdate");

		if (createdate != null) {
			setCreatedate(createdate);
		}

		String lastUpdateUserId = (String)attributes.get("lastUpdateUserId");

		if (lastUpdateUserId != null) {
			setLastUpdateUserId(lastUpdateUserId);
		}

		Date updatedate = (Date)attributes.get("updatedate");

		if (updatedate != null) {
			setUpdatedate(updatedate);
		}
	}

	@Override
	public int getPORTAL_FEEDBACK_DTL_ID() {
		return _PORTAL_FEEDBACK_DTL_ID;
	}

	@Override
	public void setPORTAL_FEEDBACK_DTL_ID(int PORTAL_FEEDBACK_DTL_ID) {
		_PORTAL_FEEDBACK_DTL_ID = PORTAL_FEEDBACK_DTL_ID;

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setPORTAL_FEEDBACK_DTL_ID",
						int.class);

				method.invoke(_feedbackDetailRemoteModel, PORTAL_FEEDBACK_DTL_ID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(int feedbackId) {
		_feedbackId = feedbackId;

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setFeedbackId", int.class);

				method.invoke(_feedbackDetailRemoteModel, feedbackId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFeedbackType() {
		return _feedbackType;
	}

	@Override
	public void setFeedbackType(String feedbackType) {
		_feedbackType = feedbackType;

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setFeedbackType", String.class);

				method.invoke(_feedbackDetailRemoteModel, feedbackType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubject() {
		return _subject;
	}

	@Override
	public void setSubject(String subject) {
		_subject = subject;

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSubject", String.class);

				method.invoke(_feedbackDetailRemoteModel, subject);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessage() {
		return _message;
	}

	@Override
	public void setMessage(String message) {
		_message = message;

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setMessage", String.class);

				method.invoke(_feedbackDetailRemoteModel, message);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileName() {
		return _fileName;
	}

	@Override
	public void setFileName(String fileName) {
		_fileName = fileName;

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setFileName", String.class);

				method.invoke(_feedbackDetailRemoteModel, fileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Blob getFileContent() {
		return _fileContent;
	}

	@Override
	public void setFileContent(Blob fileContent) {
		_fileContent = fileContent;

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setFileContent", Blob.class);

				method.invoke(_feedbackDetailRemoteModel, fileContent);
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

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", String.class);

				method.invoke(_feedbackDetailRemoteModel, createUserId);
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

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedate", Date.class);

				method.invoke(_feedbackDetailRemoteModel, createdate);
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

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateUserId",
						String.class);

				method.invoke(_feedbackDetailRemoteModel, lastUpdateUserId);
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

		if (_feedbackDetailRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedate", Date.class);

				method.invoke(_feedbackDetailRemoteModel, updatedate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setFeedbackFile(java.io.File feedbackFile) {
		try {
			String methodName = "setFeedbackFile";

			Class<?>[] parameterTypes = new Class<?>[] { java.io.File.class };

			Object[] parameterValues = new Object[] { feedbackFile };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.io.File getFeedbackFile() {
		try {
			String methodName = "getFeedbackFile";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.io.File returnObj = (java.io.File)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getFeedbackDetailRemoteModel() {
		return _feedbackDetailRemoteModel;
	}

	public void setFeedbackDetailRemoteModel(
		BaseModel<?> feedbackDetailRemoteModel) {
		_feedbackDetailRemoteModel = feedbackDetailRemoteModel;
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

		Class<?> remoteModelClass = _feedbackDetailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_feedbackDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FeedbackDetailLocalServiceUtil.addFeedbackDetail(this);
		}
		else {
			FeedbackDetailLocalServiceUtil.updateFeedbackDetail(this);
		}
	}

	@Override
	public FeedbackDetail toEscapedModel() {
		return (FeedbackDetail)ProxyUtil.newProxyInstance(FeedbackDetail.class.getClassLoader(),
			new Class[] { FeedbackDetail.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FeedbackDetailClp clone = new FeedbackDetailClp();

		clone.setPORTAL_FEEDBACK_DTL_ID(getPORTAL_FEEDBACK_DTL_ID());
		clone.setFeedbackId(getFeedbackId());
		clone.setFeedbackType(getFeedbackType());
		clone.setSubject(getSubject());
		clone.setMessage(getMessage());
		clone.setFileName(getFileName());
		clone.setFileContent(getFileContent());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreatedate(getCreatedate());
		clone.setLastUpdateUserId(getLastUpdateUserId());
		clone.setUpdatedate(getUpdatedate());

		return clone;
	}

	@Override
	public int compareTo(FeedbackDetail feedbackDetail) {
		int primaryKey = feedbackDetail.getPrimaryKey();

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

		if (!(obj instanceof FeedbackDetailClp)) {
			return false;
		}

		FeedbackDetailClp feedbackDetail = (FeedbackDetailClp)obj;

		int primaryKey = feedbackDetail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{PORTAL_FEEDBACK_DTL_ID=");
		sb.append(getPORTAL_FEEDBACK_DTL_ID());
		sb.append(", feedbackId=");
		sb.append(getFeedbackId());
		sb.append(", feedbackType=");
		sb.append(getFeedbackType());
		sb.append(", subject=");
		sb.append(getSubject());
		sb.append(", message=");
		sb.append(getMessage());
		sb.append(", fileName=");
		sb.append(getFileName());
		sb.append(", fileContent=");
		sb.append(getFileContent());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", createdate=");
		sb.append(getCreatedate());
		sb.append(", lastUpdateUserId=");
		sb.append(getLastUpdateUserId());
		sb.append(", updatedate=");
		sb.append(getUpdatedate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.grs.common.model.FeedbackDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>PORTAL_FEEDBACK_DTL_ID</column-name><column-value><![CDATA[");
		sb.append(getPORTAL_FEEDBACK_DTL_ID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackType</column-name><column-value><![CDATA[");
		sb.append(getFeedbackType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subject</column-name><column-value><![CDATA[");
		sb.append(getSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>message</column-name><column-value><![CDATA[");
		sb.append(getMessage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileName</column-name><column-value><![CDATA[");
		sb.append(getFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileContent</column-name><column-value><![CDATA[");
		sb.append(getFileContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdate</column-name><column-value><![CDATA[");
		sb.append(getCreatedate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastUpdateUserId</column-name><column-value><![CDATA[");
		sb.append(getLastUpdateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _PORTAL_FEEDBACK_DTL_ID;
	private int _feedbackId;
	private String _feedbackType;
	private String _subject;
	private String _message;
	private String _fileName;
	private Blob _fileContent;
	private String _createUserId;
	private Date _createdate;
	private String _lastUpdateUserId;
	private Date _updatedate;
	private BaseModel<?> _feedbackDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.ihg.grs.common.service.ClpSerializer.class;
}