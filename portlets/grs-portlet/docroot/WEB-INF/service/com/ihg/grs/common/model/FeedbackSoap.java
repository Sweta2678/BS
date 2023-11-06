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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gulam.vora
 * @generated
 */
public class FeedbackSoap implements Serializable {
	public static FeedbackSoap toSoapModel(Feedback model) {
		FeedbackSoap soapModel = new FeedbackSoap();

		soapModel.setFeedbackId(model.getFeedbackId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setTitle(model.getTitle());
		soapModel.setEmail(model.getEmail());
		soapModel.setOnBehalfOf(model.getOnBehalfOf());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreatedate(model.getCreatedate());
		soapModel.setLastUpdateUserId(model.getLastUpdateUserId());
		soapModel.setUpdatedate(model.getUpdatedate());

		return soapModel;
	}

	public static FeedbackSoap[] toSoapModels(Feedback[] models) {
		FeedbackSoap[] soapModels = new FeedbackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[][] toSoapModels(Feedback[][] models) {
		FeedbackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedbackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedbackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[] toSoapModels(List<Feedback> models) {
		List<FeedbackSoap> soapModels = new ArrayList<FeedbackSoap>(models.size());

		for (Feedback model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedbackSoap[soapModels.size()]);
	}

	public FeedbackSoap() {
	}

	public int getPrimaryKey() {
		return _feedbackId;
	}

	public void setPrimaryKey(int pk) {
		setFeedbackId(pk);
	}

	public int getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		_feedbackId = feedbackId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getOnBehalfOf() {
		return _onBehalfOf;
	}

	public void setOnBehalfOf(String onBehalfOf) {
		_onBehalfOf = onBehalfOf;
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
}