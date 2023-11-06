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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FeedbackDetail}.
 * </p>
 *
 * @author gulam.vora
 * @see FeedbackDetail
 * @generated
 */
public class FeedbackDetailWrapper implements FeedbackDetail,
	ModelWrapper<FeedbackDetail> {
	public FeedbackDetailWrapper(FeedbackDetail feedbackDetail) {
		_feedbackDetail = feedbackDetail;
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

	/**
	* Returns the primary key of this feedback detail.
	*
	* @return the primary key of this feedback detail
	*/
	@Override
	public int getPrimaryKey() {
		return _feedbackDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this feedback detail.
	*
	* @param primaryKey the primary key of this feedback detail
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_feedbackDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the p o r t a l_ f e e d b a c k_ d t l_ i d of this feedback detail.
	*
	* @return the p o r t a l_ f e e d b a c k_ d t l_ i d of this feedback detail
	*/
	@Override
	public int getPORTAL_FEEDBACK_DTL_ID() {
		return _feedbackDetail.getPORTAL_FEEDBACK_DTL_ID();
	}

	/**
	* Sets the p o r t a l_ f e e d b a c k_ d t l_ i d of this feedback detail.
	*
	* @param PORTAL_FEEDBACK_DTL_ID the p o r t a l_ f e e d b a c k_ d t l_ i d of this feedback detail
	*/
	@Override
	public void setPORTAL_FEEDBACK_DTL_ID(int PORTAL_FEEDBACK_DTL_ID) {
		_feedbackDetail.setPORTAL_FEEDBACK_DTL_ID(PORTAL_FEEDBACK_DTL_ID);
	}

	/**
	* Returns the feedback ID of this feedback detail.
	*
	* @return the feedback ID of this feedback detail
	*/
	@Override
	public int getFeedbackId() {
		return _feedbackDetail.getFeedbackId();
	}

	/**
	* Sets the feedback ID of this feedback detail.
	*
	* @param feedbackId the feedback ID of this feedback detail
	*/
	@Override
	public void setFeedbackId(int feedbackId) {
		_feedbackDetail.setFeedbackId(feedbackId);
	}

	/**
	* Returns the feedback type of this feedback detail.
	*
	* @return the feedback type of this feedback detail
	*/
	@Override
	public java.lang.String getFeedbackType() {
		return _feedbackDetail.getFeedbackType();
	}

	/**
	* Sets the feedback type of this feedback detail.
	*
	* @param feedbackType the feedback type of this feedback detail
	*/
	@Override
	public void setFeedbackType(java.lang.String feedbackType) {
		_feedbackDetail.setFeedbackType(feedbackType);
	}

	/**
	* Returns the subject of this feedback detail.
	*
	* @return the subject of this feedback detail
	*/
	@Override
	public java.lang.String getSubject() {
		return _feedbackDetail.getSubject();
	}

	/**
	* Sets the subject of this feedback detail.
	*
	* @param subject the subject of this feedback detail
	*/
	@Override
	public void setSubject(java.lang.String subject) {
		_feedbackDetail.setSubject(subject);
	}

	/**
	* Returns the message of this feedback detail.
	*
	* @return the message of this feedback detail
	*/
	@Override
	public java.lang.String getMessage() {
		return _feedbackDetail.getMessage();
	}

	/**
	* Sets the message of this feedback detail.
	*
	* @param message the message of this feedback detail
	*/
	@Override
	public void setMessage(java.lang.String message) {
		_feedbackDetail.setMessage(message);
	}

	/**
	* Returns the file name of this feedback detail.
	*
	* @return the file name of this feedback detail
	*/
	@Override
	public java.lang.String getFileName() {
		return _feedbackDetail.getFileName();
	}

	/**
	* Sets the file name of this feedback detail.
	*
	* @param fileName the file name of this feedback detail
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_feedbackDetail.setFileName(fileName);
	}

	/**
	* Returns the file content of this feedback detail.
	*
	* @return the file content of this feedback detail
	*/
	@Override
	public java.sql.Blob getFileContent() {
		return _feedbackDetail.getFileContent();
	}

	/**
	* Sets the file content of this feedback detail.
	*
	* @param fileContent the file content of this feedback detail
	*/
	@Override
	public void setFileContent(java.sql.Blob fileContent) {
		_feedbackDetail.setFileContent(fileContent);
	}

	/**
	* Returns the create user ID of this feedback detail.
	*
	* @return the create user ID of this feedback detail
	*/
	@Override
	public java.lang.String getCreateUserId() {
		return _feedbackDetail.getCreateUserId();
	}

	/**
	* Sets the create user ID of this feedback detail.
	*
	* @param createUserId the create user ID of this feedback detail
	*/
	@Override
	public void setCreateUserId(java.lang.String createUserId) {
		_feedbackDetail.setCreateUserId(createUserId);
	}

	/**
	* Returns the createdate of this feedback detail.
	*
	* @return the createdate of this feedback detail
	*/
	@Override
	public java.util.Date getCreatedate() {
		return _feedbackDetail.getCreatedate();
	}

	/**
	* Sets the createdate of this feedback detail.
	*
	* @param createdate the createdate of this feedback detail
	*/
	@Override
	public void setCreatedate(java.util.Date createdate) {
		_feedbackDetail.setCreatedate(createdate);
	}

	/**
	* Returns the last update user ID of this feedback detail.
	*
	* @return the last update user ID of this feedback detail
	*/
	@Override
	public java.lang.String getLastUpdateUserId() {
		return _feedbackDetail.getLastUpdateUserId();
	}

	/**
	* Sets the last update user ID of this feedback detail.
	*
	* @param lastUpdateUserId the last update user ID of this feedback detail
	*/
	@Override
	public void setLastUpdateUserId(java.lang.String lastUpdateUserId) {
		_feedbackDetail.setLastUpdateUserId(lastUpdateUserId);
	}

	/**
	* Returns the updatedate of this feedback detail.
	*
	* @return the updatedate of this feedback detail
	*/
	@Override
	public java.util.Date getUpdatedate() {
		return _feedbackDetail.getUpdatedate();
	}

	/**
	* Sets the updatedate of this feedback detail.
	*
	* @param updatedate the updatedate of this feedback detail
	*/
	@Override
	public void setUpdatedate(java.util.Date updatedate) {
		_feedbackDetail.setUpdatedate(updatedate);
	}

	@Override
	public boolean isNew() {
		return _feedbackDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_feedbackDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _feedbackDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_feedbackDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _feedbackDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _feedbackDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_feedbackDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _feedbackDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_feedbackDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_feedbackDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_feedbackDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FeedbackDetailWrapper((FeedbackDetail)_feedbackDetail.clone());
	}

	@Override
	public int compareTo(com.ihg.grs.common.model.FeedbackDetail feedbackDetail) {
		return _feedbackDetail.compareTo(feedbackDetail);
	}

	@Override
	public int hashCode() {
		return _feedbackDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.grs.common.model.FeedbackDetail> toCacheModel() {
		return _feedbackDetail.toCacheModel();
	}

	@Override
	public com.ihg.grs.common.model.FeedbackDetail toEscapedModel() {
		return new FeedbackDetailWrapper(_feedbackDetail.toEscapedModel());
	}

	@Override
	public com.ihg.grs.common.model.FeedbackDetail toUnescapedModel() {
		return new FeedbackDetailWrapper(_feedbackDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _feedbackDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _feedbackDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_feedbackDetail.persist();
	}

	@Override
	public java.io.File getFeedbackFile() {
		return _feedbackDetail.getFeedbackFile();
	}

	@Override
	public void setFeedbackFile(java.io.File feedbackFile) {
		_feedbackDetail.setFeedbackFile(feedbackFile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackDetailWrapper)) {
			return false;
		}

		FeedbackDetailWrapper feedbackDetailWrapper = (FeedbackDetailWrapper)obj;

		if (Validator.equals(_feedbackDetail,
					feedbackDetailWrapper._feedbackDetail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FeedbackDetail getWrappedFeedbackDetail() {
		return _feedbackDetail;
	}

	@Override
	public FeedbackDetail getWrappedModel() {
		return _feedbackDetail;
	}

	@Override
	public void resetOriginalValues() {
		_feedbackDetail.resetOriginalValues();
	}

	private FeedbackDetail _feedbackDetail;
}