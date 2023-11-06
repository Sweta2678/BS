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
import com.ihg.grs.common.service.FeedbackLocalServiceUtil;

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
public class FeedbackClp extends BaseModelImpl<Feedback> implements Feedback {
	public FeedbackClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public int getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("title", getTitle());
		attributes.put("email", getEmail());
		attributes.put("onBehalfOf", getOnBehalfOf());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createdate", getCreatedate());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("updatedate", getUpdatedate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer feedbackId = (Integer)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String onBehalfOf = (String)attributes.get("onBehalfOf");

		if (onBehalfOf != null) {
			setOnBehalfOf(onBehalfOf);
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
	public int getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(int feedbackId) {
		_feedbackId = feedbackId;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFeedbackId", int.class);

				method.invoke(_feedbackRemoteModel, feedbackId);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_feedbackRemoteModel, firstName);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_feedbackRemoteModel, lastName);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_feedbackRemoteModel, title);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_feedbackRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOnBehalfOf() {
		return _onBehalfOf;
	}

	@Override
	public void setOnBehalfOf(String onBehalfOf) {
		_onBehalfOf = onBehalfOf;

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setOnBehalfOf", String.class);

				method.invoke(_feedbackRemoteModel, onBehalfOf);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", String.class);

				method.invoke(_feedbackRemoteModel, createUserId);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedate", Date.class);

				method.invoke(_feedbackRemoteModel, createdate);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateUserId",
						String.class);

				method.invoke(_feedbackRemoteModel, lastUpdateUserId);
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

		if (_feedbackRemoteModel != null) {
			try {
				Class<?> clazz = _feedbackRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedate", Date.class);

				method.invoke(_feedbackRemoteModel, updatedate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFeedbackRemoteModel() {
		return _feedbackRemoteModel;
	}

	public void setFeedbackRemoteModel(BaseModel<?> feedbackRemoteModel) {
		_feedbackRemoteModel = feedbackRemoteModel;
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

		Class<?> remoteModelClass = _feedbackRemoteModel.getClass();

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

		Object returnValue = method.invoke(_feedbackRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FeedbackLocalServiceUtil.addFeedback(this);
		}
		else {
			FeedbackLocalServiceUtil.updateFeedback(this);
		}
	}

	@Override
	public Feedback toEscapedModel() {
		return (Feedback)ProxyUtil.newProxyInstance(Feedback.class.getClassLoader(),
			new Class[] { Feedback.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FeedbackClp clone = new FeedbackClp();

		clone.setFeedbackId(getFeedbackId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setTitle(getTitle());
		clone.setEmail(getEmail());
		clone.setOnBehalfOf(getOnBehalfOf());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreatedate(getCreatedate());
		clone.setLastUpdateUserId(getLastUpdateUserId());
		clone.setUpdatedate(getUpdatedate());

		return clone;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int primaryKey = feedback.getPrimaryKey();

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

		if (!(obj instanceof FeedbackClp)) {
			return false;
		}

		FeedbackClp feedback = (FeedbackClp)obj;

		int primaryKey = feedback.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{feedbackId=");
		sb.append(getFeedbackId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", onBehalfOf=");
		sb.append(getOnBehalfOf());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.grs.common.model.Feedback");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>onBehalfOf</column-name><column-value><![CDATA[");
		sb.append(getOnBehalfOf());
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

	private int _feedbackId;
	private String _firstName;
	private String _lastName;
	private String _title;
	private String _email;
	private String _onBehalfOf;
	private String _createUserId;
	private Date _createdate;
	private String _lastUpdateUserId;
	private Date _updatedate;
	private BaseModel<?> _feedbackRemoteModel;
	private Class<?> _clpSerializerClass = com.ihg.grs.common.service.ClpSerializer.class;
}