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
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;

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
public class PublishQueueClp extends BaseModelImpl<PublishQueue>
	implements PublishQueue {
	public PublishQueueClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PublishQueue.class;
	}

	@Override
	public String getModelClassName() {
		return PublishQueue.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publishQueueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishQueueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishQueueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishQueueId", getPublishQueueId());
		attributes.put("publishFileText", getPublishFileText());
		attributes.put("publishEnvironment", getPublishEnvironment());
		attributes.put("schedulePublish", getSchedulePublish());
		attributes.put("queueStatCd", getQueueStatCd());
		attributes.put("chainCd", getChainCd());
		attributes.put("notificationEmailId", getNotificationEmailId());
		attributes.put("scheduleStart", getScheduleStart());
		attributes.put("scheduleEnd", getScheduleEnd());
		attributes.put("expectedProdPublishDt", getExpectedProdPublishDt());
		attributes.put("publishId", getPublishId());
		attributes.put("publishLocaleList", getPublishLocaleList());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishQueueId = (Long)attributes.get("publishQueueId");

		if (publishQueueId != null) {
			setPublishQueueId(publishQueueId);
		}

		String publishFileText = (String)attributes.get("publishFileText");

		if (publishFileText != null) {
			setPublishFileText(publishFileText);
		}

		String publishEnvironment = (String)attributes.get("publishEnvironment");

		if (publishEnvironment != null) {
			setPublishEnvironment(publishEnvironment);
		}

		Date schedulePublish = (Date)attributes.get("schedulePublish");

		if (schedulePublish != null) {
			setSchedulePublish(schedulePublish);
		}

		String queueStatCd = (String)attributes.get("queueStatCd");

		if (queueStatCd != null) {
			setQueueStatCd(queueStatCd);
		}

		String chainCd = (String)attributes.get("chainCd");

		if (chainCd != null) {
			setChainCd(chainCd);
		}

		String notificationEmailId = (String)attributes.get(
				"notificationEmailId");

		if (notificationEmailId != null) {
			setNotificationEmailId(notificationEmailId);
		}

		Date scheduleStart = (Date)attributes.get("scheduleStart");

		if (scheduleStart != null) {
			setScheduleStart(scheduleStart);
		}

		Date scheduleEnd = (Date)attributes.get("scheduleEnd");

		if (scheduleEnd != null) {
			setScheduleEnd(scheduleEnd);
		}

		Date expectedProdPublishDt = (Date)attributes.get(
				"expectedProdPublishDt");

		if (expectedProdPublishDt != null) {
			setExpectedProdPublishDt(expectedProdPublishDt);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String publishLocaleList = (String)attributes.get("publishLocaleList");

		if (publishLocaleList != null) {
			setPublishLocaleList(publishLocaleList);
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
	public long getPublishQueueId() {
		return _publishQueueId;
	}

	@Override
	public void setPublishQueueId(long publishQueueId) {
		_publishQueueId = publishQueueId;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishQueueId", long.class);

				method.invoke(_publishQueueRemoteModel, publishQueueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishFileText() {
		return _publishFileText;
	}

	@Override
	public void setPublishFileText(String publishFileText) {
		_publishFileText = publishFileText;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishFileText",
						String.class);

				method.invoke(_publishQueueRemoteModel, publishFileText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishEnvironment() {
		return _publishEnvironment;
	}

	@Override
	public void setPublishEnvironment(String publishEnvironment) {
		_publishEnvironment = publishEnvironment;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishEnvironment",
						String.class);

				method.invoke(_publishQueueRemoteModel, publishEnvironment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSchedulePublish() {
		return _schedulePublish;
	}

	@Override
	public void setSchedulePublish(Date schedulePublish) {
		_schedulePublish = schedulePublish;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setSchedulePublish", Date.class);

				method.invoke(_publishQueueRemoteModel, schedulePublish);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQueueStatCd() {
		return _queueStatCd;
	}

	@Override
	public void setQueueStatCd(String queueStatCd) {
		_queueStatCd = queueStatCd;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setQueueStatCd", String.class);

				method.invoke(_publishQueueRemoteModel, queueStatCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChainCd() {
		return _chainCd;
	}

	@Override
	public void setChainCd(String chainCd) {
		_chainCd = chainCd;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCd", String.class);

				method.invoke(_publishQueueRemoteModel, chainCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotificationEmailId() {
		return _notificationEmailId;
	}

	@Override
	public void setNotificationEmailId(String notificationEmailId) {
		_notificationEmailId = notificationEmailId;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setNotificationEmailId",
						String.class);

				method.invoke(_publishQueueRemoteModel, notificationEmailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getScheduleStart() {
		return _scheduleStart;
	}

	@Override
	public void setScheduleStart(Date scheduleStart) {
		_scheduleStart = scheduleStart;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setScheduleStart", Date.class);

				method.invoke(_publishQueueRemoteModel, scheduleStart);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getScheduleEnd() {
		return _scheduleEnd;
	}

	@Override
	public void setScheduleEnd(Date scheduleEnd) {
		_scheduleEnd = scheduleEnd;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setScheduleEnd", Date.class);

				method.invoke(_publishQueueRemoteModel, scheduleEnd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpectedProdPublishDt() {
		return _expectedProdPublishDt;
	}

	@Override
	public void setExpectedProdPublishDt(Date expectedProdPublishDt) {
		_expectedProdPublishDt = expectedProdPublishDt;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedProdPublishDt",
						Date.class);

				method.invoke(_publishQueueRemoteModel, expectedProdPublishDt);
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

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_publishQueueRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishLocaleList() {
		return _publishLocaleList;
	}

	@Override
	public void setPublishLocaleList(String publishLocaleList) {
		_publishLocaleList = publishLocaleList;

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishLocaleList",
						String.class);

				method.invoke(_publishQueueRemoteModel, publishLocaleList);
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

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_publishQueueRemoteModel, creatorId);
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

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_publishQueueRemoteModel, createdDate);
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

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_publishQueueRemoteModel, updatedBy);
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

		if (_publishQueueRemoteModel != null) {
			try {
				Class<?> clazz = _publishQueueRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_publishQueueRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublishQueueRemoteModel() {
		return _publishQueueRemoteModel;
	}

	public void setPublishQueueRemoteModel(BaseModel<?> publishQueueRemoteModel) {
		_publishQueueRemoteModel = publishQueueRemoteModel;
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

		Class<?> remoteModelClass = _publishQueueRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publishQueueRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishQueueLocalServiceUtil.addPublishQueue(this);
		}
		else {
			PublishQueueLocalServiceUtil.updatePublishQueue(this);
		}
	}

	@Override
	public PublishQueue toEscapedModel() {
		return (PublishQueue)ProxyUtil.newProxyInstance(PublishQueue.class.getClassLoader(),
			new Class[] { PublishQueue.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishQueueClp clone = new PublishQueueClp();

		clone.setPublishQueueId(getPublishQueueId());
		clone.setPublishFileText(getPublishFileText());
		clone.setPublishEnvironment(getPublishEnvironment());
		clone.setSchedulePublish(getSchedulePublish());
		clone.setQueueStatCd(getQueueStatCd());
		clone.setChainCd(getChainCd());
		clone.setNotificationEmailId(getNotificationEmailId());
		clone.setScheduleStart(getScheduleStart());
		clone.setScheduleEnd(getScheduleEnd());
		clone.setExpectedProdPublishDt(getExpectedProdPublishDt());
		clone.setPublishId(getPublishId());
		clone.setPublishLocaleList(getPublishLocaleList());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(PublishQueue publishQueue) {
		int value = 0;

		if (getPublishQueueId() < publishQueue.getPublishQueueId()) {
			value = -1;
		}
		else if (getPublishQueueId() > publishQueue.getPublishQueueId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof PublishQueueClp)) {
			return false;
		}

		PublishQueueClp publishQueue = (PublishQueueClp)obj;

		long primaryKey = publishQueue.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{publishQueueId=");
		sb.append(getPublishQueueId());
		sb.append(", publishFileText=");
		sb.append(getPublishFileText());
		sb.append(", publishEnvironment=");
		sb.append(getPublishEnvironment());
		sb.append(", schedulePublish=");
		sb.append(getSchedulePublish());
		sb.append(", queueStatCd=");
		sb.append(getQueueStatCd());
		sb.append(", chainCd=");
		sb.append(getChainCd());
		sb.append(", notificationEmailId=");
		sb.append(getNotificationEmailId());
		sb.append(", scheduleStart=");
		sb.append(getScheduleStart());
		sb.append(", scheduleEnd=");
		sb.append(getScheduleEnd());
		sb.append(", expectedProdPublishDt=");
		sb.append(getExpectedProdPublishDt());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", publishLocaleList=");
		sb.append(getPublishLocaleList());
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
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.PublishQueue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishQueueId</column-name><column-value><![CDATA[");
		sb.append(getPublishQueueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishFileText</column-name><column-value><![CDATA[");
		sb.append(getPublishFileText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishEnvironment</column-name><column-value><![CDATA[");
		sb.append(getPublishEnvironment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>schedulePublish</column-name><column-value><![CDATA[");
		sb.append(getSchedulePublish());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>queueStatCd</column-name><column-value><![CDATA[");
		sb.append(getQueueStatCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCd</column-name><column-value><![CDATA[");
		sb.append(getChainCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notificationEmailId</column-name><column-value><![CDATA[");
		sb.append(getNotificationEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleStart</column-name><column-value><![CDATA[");
		sb.append(getScheduleStart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>scheduleEnd</column-name><column-value><![CDATA[");
		sb.append(getScheduleEnd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedProdPublishDt</column-name><column-value><![CDATA[");
		sb.append(getExpectedProdPublishDt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishLocaleList</column-name><column-value><![CDATA[");
		sb.append(getPublishLocaleList());
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

	private long _publishQueueId;
	private String _publishFileText;
	private String _publishEnvironment;
	private Date _schedulePublish;
	private String _queueStatCd;
	private String _chainCd;
	private String _notificationEmailId;
	private Date _scheduleStart;
	private Date _scheduleEnd;
	private Date _expectedProdPublishDt;
	private long _publishId;
	private String _publishLocaleList;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _publishQueueRemoteModel;
}