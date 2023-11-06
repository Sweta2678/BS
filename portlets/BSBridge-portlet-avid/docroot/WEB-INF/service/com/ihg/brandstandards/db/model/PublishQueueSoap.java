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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class PublishQueueSoap implements Serializable {
	public static PublishQueueSoap toSoapModel(PublishQueue model) {
		PublishQueueSoap soapModel = new PublishQueueSoap();

		soapModel.setPublishQueueId(model.getPublishQueueId());
		soapModel.setPublishFileText(model.getPublishFileText());
		soapModel.setPublishEnvironment(model.getPublishEnvironment());
		soapModel.setSchedulePublish(model.getSchedulePublish());
		soapModel.setQueueStatCd(model.getQueueStatCd());
		soapModel.setChainCd(model.getChainCd());
		soapModel.setNotificationEmailId(model.getNotificationEmailId());
		soapModel.setScheduleStart(model.getScheduleStart());
		soapModel.setScheduleEnd(model.getScheduleEnd());
		soapModel.setExpectedProdPublishDt(model.getExpectedProdPublishDt());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setPublishLocaleList(model.getPublishLocaleList());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static PublishQueueSoap[] toSoapModels(PublishQueue[] models) {
		PublishQueueSoap[] soapModels = new PublishQueueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishQueueSoap[][] toSoapModels(PublishQueue[][] models) {
		PublishQueueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishQueueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishQueueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishQueueSoap[] toSoapModels(List<PublishQueue> models) {
		List<PublishQueueSoap> soapModels = new ArrayList<PublishQueueSoap>(models.size());

		for (PublishQueue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishQueueSoap[soapModels.size()]);
	}

	public PublishQueueSoap() {
	}

	public long getPrimaryKey() {
		return _publishQueueId;
	}

	public void setPrimaryKey(long pk) {
		setPublishQueueId(pk);
	}

	public long getPublishQueueId() {
		return _publishQueueId;
	}

	public void setPublishQueueId(long publishQueueId) {
		_publishQueueId = publishQueueId;
	}

	public String getPublishFileText() {
		return _publishFileText;
	}

	public void setPublishFileText(String publishFileText) {
		_publishFileText = publishFileText;
	}

	public String getPublishEnvironment() {
		return _publishEnvironment;
	}

	public void setPublishEnvironment(String publishEnvironment) {
		_publishEnvironment = publishEnvironment;
	}

	public Date getSchedulePublish() {
		return _schedulePublish;
	}

	public void setSchedulePublish(Date schedulePublish) {
		_schedulePublish = schedulePublish;
	}

	public String getQueueStatCd() {
		return _queueStatCd;
	}

	public void setQueueStatCd(String queueStatCd) {
		_queueStatCd = queueStatCd;
	}

	public String getChainCd() {
		return _chainCd;
	}

	public void setChainCd(String chainCd) {
		_chainCd = chainCd;
	}

	public String getNotificationEmailId() {
		return _notificationEmailId;
	}

	public void setNotificationEmailId(String notificationEmailId) {
		_notificationEmailId = notificationEmailId;
	}

	public Date getScheduleStart() {
		return _scheduleStart;
	}

	public void setScheduleStart(Date scheduleStart) {
		_scheduleStart = scheduleStart;
	}

	public Date getScheduleEnd() {
		return _scheduleEnd;
	}

	public void setScheduleEnd(Date scheduleEnd) {
		_scheduleEnd = scheduleEnd;
	}

	public Date getExpectedProdPublishDt() {
		return _expectedProdPublishDt;
	}

	public void setExpectedProdPublishDt(Date expectedProdPublishDt) {
		_expectedProdPublishDt = expectedProdPublishDt;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public String getPublishLocaleList() {
		return _publishLocaleList;
	}

	public void setPublishLocaleList(String publishLocaleList) {
		_publishLocaleList = publishLocaleList;
	}

	public String getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return _updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
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
}