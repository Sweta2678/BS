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
public class PublishParmSoap implements Serializable {
	public static PublishParmSoap toSoapModel(PublishParm model) {
		PublishParmSoap soapModel = new PublishParmSoap();

		soapModel.setPublishParmId(model.getPublishParmId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setParmName(model.getParmName());
		soapModel.setParmValue(model.getParmValue());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static PublishParmSoap[] toSoapModels(PublishParm[] models) {
		PublishParmSoap[] soapModels = new PublishParmSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishParmSoap[][] toSoapModels(PublishParm[][] models) {
		PublishParmSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishParmSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishParmSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishParmSoap[] toSoapModels(List<PublishParm> models) {
		List<PublishParmSoap> soapModels = new ArrayList<PublishParmSoap>(models.size());

		for (PublishParm model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishParmSoap[soapModels.size()]);
	}

	public PublishParmSoap() {
	}

	public long getPrimaryKey() {
		return _publishParmId;
	}

	public void setPrimaryKey(long pk) {
		setPublishParmId(pk);
	}

	public long getPublishParmId() {
		return _publishParmId;
	}

	public void setPublishParmId(long publishParmId) {
		_publishParmId = publishParmId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public String getParmName() {
		return _parmName;
	}

	public void setParmName(String parmName) {
		_parmName = parmName;
	}

	public String getParmValue() {
		return _parmValue;
	}

	public void setParmValue(String parmValue) {
		_parmValue = parmValue;
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

	private long _publishParmId;
	private long _publishId;
	private String _parmName;
	private String _parmValue;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}