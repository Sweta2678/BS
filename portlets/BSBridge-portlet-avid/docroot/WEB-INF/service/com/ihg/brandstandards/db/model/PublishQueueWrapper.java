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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PublishQueue}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishQueue
 * @generated
 */
public class PublishQueueWrapper implements PublishQueue,
	ModelWrapper<PublishQueue> {
	public PublishQueueWrapper(PublishQueue publishQueue) {
		_publishQueue = publishQueue;
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

	/**
	* Returns the primary key of this publish queue.
	*
	* @return the primary key of this publish queue
	*/
	@Override
	public long getPrimaryKey() {
		return _publishQueue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this publish queue.
	*
	* @param primaryKey the primary key of this publish queue
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publishQueue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish queue ID of this publish queue.
	*
	* @return the publish queue ID of this publish queue
	*/
	@Override
	public long getPublishQueueId() {
		return _publishQueue.getPublishQueueId();
	}

	/**
	* Sets the publish queue ID of this publish queue.
	*
	* @param publishQueueId the publish queue ID of this publish queue
	*/
	@Override
	public void setPublishQueueId(long publishQueueId) {
		_publishQueue.setPublishQueueId(publishQueueId);
	}

	/**
	* Returns the publish file text of this publish queue.
	*
	* @return the publish file text of this publish queue
	*/
	@Override
	public java.lang.String getPublishFileText() {
		return _publishQueue.getPublishFileText();
	}

	/**
	* Sets the publish file text of this publish queue.
	*
	* @param publishFileText the publish file text of this publish queue
	*/
	@Override
	public void setPublishFileText(java.lang.String publishFileText) {
		_publishQueue.setPublishFileText(publishFileText);
	}

	/**
	* Returns the publish environment of this publish queue.
	*
	* @return the publish environment of this publish queue
	*/
	@Override
	public java.lang.String getPublishEnvironment() {
		return _publishQueue.getPublishEnvironment();
	}

	/**
	* Sets the publish environment of this publish queue.
	*
	* @param publishEnvironment the publish environment of this publish queue
	*/
	@Override
	public void setPublishEnvironment(java.lang.String publishEnvironment) {
		_publishQueue.setPublishEnvironment(publishEnvironment);
	}

	/**
	* Returns the schedule publish of this publish queue.
	*
	* @return the schedule publish of this publish queue
	*/
	@Override
	public java.util.Date getSchedulePublish() {
		return _publishQueue.getSchedulePublish();
	}

	/**
	* Sets the schedule publish of this publish queue.
	*
	* @param schedulePublish the schedule publish of this publish queue
	*/
	@Override
	public void setSchedulePublish(java.util.Date schedulePublish) {
		_publishQueue.setSchedulePublish(schedulePublish);
	}

	/**
	* Returns the queue stat cd of this publish queue.
	*
	* @return the queue stat cd of this publish queue
	*/
	@Override
	public java.lang.String getQueueStatCd() {
		return _publishQueue.getQueueStatCd();
	}

	/**
	* Sets the queue stat cd of this publish queue.
	*
	* @param queueStatCd the queue stat cd of this publish queue
	*/
	@Override
	public void setQueueStatCd(java.lang.String queueStatCd) {
		_publishQueue.setQueueStatCd(queueStatCd);
	}

	/**
	* Returns the chain cd of this publish queue.
	*
	* @return the chain cd of this publish queue
	*/
	@Override
	public java.lang.String getChainCd() {
		return _publishQueue.getChainCd();
	}

	/**
	* Sets the chain cd of this publish queue.
	*
	* @param chainCd the chain cd of this publish queue
	*/
	@Override
	public void setChainCd(java.lang.String chainCd) {
		_publishQueue.setChainCd(chainCd);
	}

	/**
	* Returns the notification email ID of this publish queue.
	*
	* @return the notification email ID of this publish queue
	*/
	@Override
	public java.lang.String getNotificationEmailId() {
		return _publishQueue.getNotificationEmailId();
	}

	/**
	* Sets the notification email ID of this publish queue.
	*
	* @param notificationEmailId the notification email ID of this publish queue
	*/
	@Override
	public void setNotificationEmailId(java.lang.String notificationEmailId) {
		_publishQueue.setNotificationEmailId(notificationEmailId);
	}

	/**
	* Returns the schedule start of this publish queue.
	*
	* @return the schedule start of this publish queue
	*/
	@Override
	public java.util.Date getScheduleStart() {
		return _publishQueue.getScheduleStart();
	}

	/**
	* Sets the schedule start of this publish queue.
	*
	* @param scheduleStart the schedule start of this publish queue
	*/
	@Override
	public void setScheduleStart(java.util.Date scheduleStart) {
		_publishQueue.setScheduleStart(scheduleStart);
	}

	/**
	* Returns the schedule end of this publish queue.
	*
	* @return the schedule end of this publish queue
	*/
	@Override
	public java.util.Date getScheduleEnd() {
		return _publishQueue.getScheduleEnd();
	}

	/**
	* Sets the schedule end of this publish queue.
	*
	* @param scheduleEnd the schedule end of this publish queue
	*/
	@Override
	public void setScheduleEnd(java.util.Date scheduleEnd) {
		_publishQueue.setScheduleEnd(scheduleEnd);
	}

	/**
	* Returns the expected prod publish dt of this publish queue.
	*
	* @return the expected prod publish dt of this publish queue
	*/
	@Override
	public java.util.Date getExpectedProdPublishDt() {
		return _publishQueue.getExpectedProdPublishDt();
	}

	/**
	* Sets the expected prod publish dt of this publish queue.
	*
	* @param expectedProdPublishDt the expected prod publish dt of this publish queue
	*/
	@Override
	public void setExpectedProdPublishDt(java.util.Date expectedProdPublishDt) {
		_publishQueue.setExpectedProdPublishDt(expectedProdPublishDt);
	}

	/**
	* Returns the publish ID of this publish queue.
	*
	* @return the publish ID of this publish queue
	*/
	@Override
	public long getPublishId() {
		return _publishQueue.getPublishId();
	}

	/**
	* Sets the publish ID of this publish queue.
	*
	* @param publishId the publish ID of this publish queue
	*/
	@Override
	public void setPublishId(long publishId) {
		_publishQueue.setPublishId(publishId);
	}

	/**
	* Returns the publish locale list of this publish queue.
	*
	* @return the publish locale list of this publish queue
	*/
	@Override
	public java.lang.String getPublishLocaleList() {
		return _publishQueue.getPublishLocaleList();
	}

	/**
	* Sets the publish locale list of this publish queue.
	*
	* @param publishLocaleList the publish locale list of this publish queue
	*/
	@Override
	public void setPublishLocaleList(java.lang.String publishLocaleList) {
		_publishQueue.setPublishLocaleList(publishLocaleList);
	}

	/**
	* Returns the creator ID of this publish queue.
	*
	* @return the creator ID of this publish queue
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _publishQueue.getCreatorId();
	}

	/**
	* Sets the creator ID of this publish queue.
	*
	* @param creatorId the creator ID of this publish queue
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_publishQueue.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this publish queue.
	*
	* @return the created date of this publish queue
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _publishQueue.getCreatedDate();
	}

	/**
	* Sets the created date of this publish queue.
	*
	* @param createdDate the created date of this publish queue
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_publishQueue.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this publish queue.
	*
	* @return the updated by of this publish queue
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _publishQueue.getUpdatedBy();
	}

	/**
	* Sets the updated by of this publish queue.
	*
	* @param updatedBy the updated by of this publish queue
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_publishQueue.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this publish queue.
	*
	* @return the updated date of this publish queue
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _publishQueue.getUpdatedDate();
	}

	/**
	* Sets the updated date of this publish queue.
	*
	* @param updatedDate the updated date of this publish queue
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_publishQueue.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _publishQueue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publishQueue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publishQueue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publishQueue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publishQueue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publishQueue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publishQueue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publishQueue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publishQueue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publishQueue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publishQueue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublishQueueWrapper((PublishQueue)_publishQueue.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue) {
		return _publishQueue.compareTo(publishQueue);
	}

	@Override
	public int hashCode() {
		return _publishQueue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.PublishQueue> toCacheModel() {
		return _publishQueue.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishQueue toEscapedModel() {
		return new PublishQueueWrapper(_publishQueue.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishQueue toUnescapedModel() {
		return new PublishQueueWrapper(_publishQueue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publishQueue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publishQueue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishQueue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishQueueWrapper)) {
			return false;
		}

		PublishQueueWrapper publishQueueWrapper = (PublishQueueWrapper)obj;

		if (Validator.equals(_publishQueue, publishQueueWrapper._publishQueue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PublishQueue getWrappedPublishQueue() {
		return _publishQueue;
	}

	@Override
	public PublishQueue getWrappedModel() {
		return _publishQueue;
	}

	@Override
	public void resetOriginalValues() {
		_publishQueue.resetOriginalValues();
	}

	private PublishQueue _publishQueue;
}