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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author gulam.vora
 * @see Feedback
 * @generated
 */
public class FeedbackWrapper implements Feedback, ModelWrapper<Feedback> {
	public FeedbackWrapper(Feedback feedback) {
		_feedback = feedback;
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

	/**
	* Returns the primary key of this feedback.
	*
	* @return the primary key of this feedback
	*/
	@Override
	public int getPrimaryKey() {
		return _feedback.getPrimaryKey();
	}

	/**
	* Sets the primary key of this feedback.
	*
	* @param primaryKey the primary key of this feedback
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_feedback.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the feedback ID of this feedback.
	*
	* @return the feedback ID of this feedback
	*/
	@Override
	public int getFeedbackId() {
		return _feedback.getFeedbackId();
	}

	/**
	* Sets the feedback ID of this feedback.
	*
	* @param feedbackId the feedback ID of this feedback
	*/
	@Override
	public void setFeedbackId(int feedbackId) {
		_feedback.setFeedbackId(feedbackId);
	}

	/**
	* Returns the first name of this feedback.
	*
	* @return the first name of this feedback
	*/
	@Override
	public java.lang.String getFirstName() {
		return _feedback.getFirstName();
	}

	/**
	* Sets the first name of this feedback.
	*
	* @param firstName the first name of this feedback
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_feedback.setFirstName(firstName);
	}

	/**
	* Returns the last name of this feedback.
	*
	* @return the last name of this feedback
	*/
	@Override
	public java.lang.String getLastName() {
		return _feedback.getLastName();
	}

	/**
	* Sets the last name of this feedback.
	*
	* @param lastName the last name of this feedback
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_feedback.setLastName(lastName);
	}

	/**
	* Returns the title of this feedback.
	*
	* @return the title of this feedback
	*/
	@Override
	public java.lang.String getTitle() {
		return _feedback.getTitle();
	}

	/**
	* Sets the title of this feedback.
	*
	* @param title the title of this feedback
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_feedback.setTitle(title);
	}

	/**
	* Returns the email of this feedback.
	*
	* @return the email of this feedback
	*/
	@Override
	public java.lang.String getEmail() {
		return _feedback.getEmail();
	}

	/**
	* Sets the email of this feedback.
	*
	* @param email the email of this feedback
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_feedback.setEmail(email);
	}

	/**
	* Returns the on behalf of of this feedback.
	*
	* @return the on behalf of of this feedback
	*/
	@Override
	public java.lang.String getOnBehalfOf() {
		return _feedback.getOnBehalfOf();
	}

	/**
	* Sets the on behalf of of this feedback.
	*
	* @param onBehalfOf the on behalf of of this feedback
	*/
	@Override
	public void setOnBehalfOf(java.lang.String onBehalfOf) {
		_feedback.setOnBehalfOf(onBehalfOf);
	}

	/**
	* Returns the create user ID of this feedback.
	*
	* @return the create user ID of this feedback
	*/
	@Override
	public java.lang.String getCreateUserId() {
		return _feedback.getCreateUserId();
	}

	/**
	* Sets the create user ID of this feedback.
	*
	* @param createUserId the create user ID of this feedback
	*/
	@Override
	public void setCreateUserId(java.lang.String createUserId) {
		_feedback.setCreateUserId(createUserId);
	}

	/**
	* Returns the createdate of this feedback.
	*
	* @return the createdate of this feedback
	*/
	@Override
	public java.util.Date getCreatedate() {
		return _feedback.getCreatedate();
	}

	/**
	* Sets the createdate of this feedback.
	*
	* @param createdate the createdate of this feedback
	*/
	@Override
	public void setCreatedate(java.util.Date createdate) {
		_feedback.setCreatedate(createdate);
	}

	/**
	* Returns the last update user ID of this feedback.
	*
	* @return the last update user ID of this feedback
	*/
	@Override
	public java.lang.String getLastUpdateUserId() {
		return _feedback.getLastUpdateUserId();
	}

	/**
	* Sets the last update user ID of this feedback.
	*
	* @param lastUpdateUserId the last update user ID of this feedback
	*/
	@Override
	public void setLastUpdateUserId(java.lang.String lastUpdateUserId) {
		_feedback.setLastUpdateUserId(lastUpdateUserId);
	}

	/**
	* Returns the updatedate of this feedback.
	*
	* @return the updatedate of this feedback
	*/
	@Override
	public java.util.Date getUpdatedate() {
		return _feedback.getUpdatedate();
	}

	/**
	* Sets the updatedate of this feedback.
	*
	* @param updatedate the updatedate of this feedback
	*/
	@Override
	public void setUpdatedate(java.util.Date updatedate) {
		_feedback.setUpdatedate(updatedate);
	}

	@Override
	public boolean isNew() {
		return _feedback.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feedback.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feedback.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedback.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feedback.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feedback.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feedback.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feedback.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feedback.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feedback.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feedback.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeedbackWrapper((Feedback)_feedback.clone());
	}

	@Override
	public int compareTo(com.ihg.grs.common.model.Feedback feedback) {
		return _feedback.compareTo(feedback);
	}

	@Override
	public int hashCode() {
		return _feedback.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.grs.common.model.Feedback> toCacheModel() {
		return _feedback.toCacheModel();
	}

	@Override
	public com.ihg.grs.common.model.Feedback toEscapedModel() {
		return new FeedbackWrapper(_feedback.toEscapedModel());
	}

	@Override
	public com.ihg.grs.common.model.Feedback toUnescapedModel() {
		return new FeedbackWrapper(_feedback.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feedback.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feedback.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feedback.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackWrapper)) {
			return false;
		}

		FeedbackWrapper feedbackWrapper = (FeedbackWrapper)obj;

		if (Validator.equals(_feedback, feedbackWrapper._feedback)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Feedback getWrappedFeedback() {
		return _feedback;
	}

	@Override
	public Feedback getWrappedModel() {
		return _feedback;
	}

	@Override
	public void resetOriginalValues() {
		_feedback.resetOriginalValues();
	}

	private Feedback _feedback;
}