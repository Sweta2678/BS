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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gulam.vora
 * @generated
 */
public class FeedbackDetailSoap implements Serializable {
	public static FeedbackDetailSoap toSoapModel(FeedbackDetail model) {
		FeedbackDetailSoap soapModel = new FeedbackDetailSoap();

		soapModel.setPORTAL_FEEDBACK_DTL_ID(model.getPORTAL_FEEDBACK_DTL_ID());
		soapModel.setFeedbackId(model.getFeedbackId());
		soapModel.setFeedbackType(model.getFeedbackType());
		soapModel.setSubject(model.getSubject());
		soapModel.setMessage(model.getMessage());
		soapModel.setFileName(model.getFileName());
		soapModel.setFileContent(model.getFileContent());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreatedate(model.getCreatedate());
		soapModel.setLastUpdateUserId(model.getLastUpdateUserId());
		soapModel.setUpdatedate(model.getUpdatedate());

		return soapModel;
	}

	public static FeedbackDetailSoap[] toSoapModels(FeedbackDetail[] models) {
		FeedbackDetailSoap[] soapModels = new FeedbackDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedbackDetailSoap[][] toSoapModels(FeedbackDetail[][] models) {
		FeedbackDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedbackDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedbackDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedbackDetailSoap[] toSoapModels(List<FeedbackDetail> models) {
		List<FeedbackDetailSoap> soapModels = new ArrayList<FeedbackDetailSoap>(models.size());

		for (FeedbackDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedbackDetailSoap[soapModels.size()]);
	}

	public FeedbackDetailSoap() {
	}

	public int getPrimaryKey() {
		return _PORTAL_FEEDBACK_DTL_ID;
	}

	public void setPrimaryKey(int pk) {
		setPORTAL_FEEDBACK_DTL_ID(pk);
	}

	public int getPORTAL_FEEDBACK_DTL_ID() {
		return _PORTAL_FEEDBACK_DTL_ID;
	}

	public void setPORTAL_FEEDBACK_DTL_ID(int PORTAL_FEEDBACK_DTL_ID) {
		_PORTAL_FEEDBACK_DTL_ID = PORTAL_FEEDBACK_DTL_ID;
	}

	public int getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		_feedbackId = feedbackId;
	}

	public String getFeedbackType() {
		return _feedbackType;
	}

	public void setFeedbackType(String feedbackType) {
		_feedbackType = feedbackType;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getFileName() {
		return _fileName;
	}

	public void setFileName(String fileName) {
		_fileName = fileName;
	}

	public Blob getFileContent() {
		return _fileContent;
	}

	public void setFileContent(Blob fileContent) {
		_fileContent = fileContent;
	}

	public String getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;
	}

	public Date getCreatedate() {
		return _createdate;
	}

	public void setCreatedate(Date createdate) {
		_createdate = createdate;
	}

	public String getLastUpdateUserId() {
		return _lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		_lastUpdateUserId = lastUpdateUserId;
	}

	public Date getUpdatedate() {
		return _updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		_updatedate = updatedate;
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
}