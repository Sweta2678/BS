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
public class PublishCountryStandardSoap implements Serializable {
	public static PublishCountryStandardSoap toSoapModel(
		PublishCountryStandard model) {
		PublishCountryStandardSoap soapModel = new PublishCountryStandardSoap();

		soapModel.setPublishCountryStdId(model.getPublishCountryStdId());
		soapModel.setPublishVerId(model.getPublishVerId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setExpiredRefTxt(model.getExpiredRefTxt());
		soapModel.setPublishStatCode(model.getPublishStatCode());
		soapModel.setStdComplyDeadlineDate(model.getStdComplyDeadlineDate());
		soapModel.setOrderNumber(model.getOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static PublishCountryStandardSoap[] toSoapModels(
		PublishCountryStandard[] models) {
		PublishCountryStandardSoap[] soapModels = new PublishCountryStandardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishCountryStandardSoap[][] toSoapModels(
		PublishCountryStandard[][] models) {
		PublishCountryStandardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishCountryStandardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishCountryStandardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishCountryStandardSoap[] toSoapModels(
		List<PublishCountryStandard> models) {
		List<PublishCountryStandardSoap> soapModels = new ArrayList<PublishCountryStandardSoap>(models.size());

		for (PublishCountryStandard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishCountryStandardSoap[soapModels.size()]);
	}

	public PublishCountryStandardSoap() {
	}

	public String getPrimaryKey() {
		return _publishCountryStdId;
	}

	public void setPrimaryKey(String pk) {
		setPublishCountryStdId(pk);
	}

	public String getPublishCountryStdId() {
		return _publishCountryStdId;
	}

	public void setPublishCountryStdId(String publishCountryStdId) {
		_publishCountryStdId = publishCountryStdId;
	}

	public long getPublishVerId() {
		return _publishVerId;
	}

	public void setPublishVerId(long publishVerId) {
		_publishVerId = publishVerId;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getExpiredRefTxt() {
		return _expiredRefTxt;
	}

	public void setExpiredRefTxt(String expiredRefTxt) {
		_expiredRefTxt = expiredRefTxt;
	}

	public String getPublishStatCode() {
		return _publishStatCode;
	}

	public void setPublishStatCode(String publishStatCode) {
		_publishStatCode = publishStatCode;
	}

	public Date getStdComplyDeadlineDate() {
		return _stdComplyDeadlineDate;
	}

	public void setStdComplyDeadlineDate(Date stdComplyDeadlineDate) {
		_stdComplyDeadlineDate = stdComplyDeadlineDate;
	}

	public long getOrderNumber() {
		return _orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		_orderNumber = orderNumber;
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

	private String _publishCountryStdId;
	private long _publishVerId;
	private String _countryCode;
	private String _expiredRefTxt;
	private String _publishStatCode;
	private Date _stdComplyDeadlineDate;
	private long _orderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}