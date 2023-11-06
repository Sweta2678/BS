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
public class UniqueGroupStandardSoap implements Serializable {
	public static UniqueGroupStandardSoap toSoapModel(UniqueGroupStandard model) {
		UniqueGroupStandardSoap soapModel = new UniqueGroupStandardSoap();

		soapModel.setGroupStandardId(model.getGroupStandardId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setStdId(model.getStdId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static UniqueGroupStandardSoap[] toSoapModels(
		UniqueGroupStandard[] models) {
		UniqueGroupStandardSoap[] soapModels = new UniqueGroupStandardSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UniqueGroupStandardSoap[][] toSoapModels(
		UniqueGroupStandard[][] models) {
		UniqueGroupStandardSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UniqueGroupStandardSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UniqueGroupStandardSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UniqueGroupStandardSoap[] toSoapModels(
		List<UniqueGroupStandard> models) {
		List<UniqueGroupStandardSoap> soapModels = new ArrayList<UniqueGroupStandardSoap>(models.size());

		for (UniqueGroupStandard model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UniqueGroupStandardSoap[soapModels.size()]);
	}

	public UniqueGroupStandardSoap() {
	}

	public long getPrimaryKey() {
		return _groupStandardId;
	}

	public void setPrimaryKey(long pk) {
		setGroupStandardId(pk);
	}

	public long getGroupStandardId() {
		return _groupStandardId;
	}

	public void setGroupStandardId(long groupStandardId) {
		_groupStandardId = groupStandardId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
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

	private long _groupStandardId;
	private long _groupId;
	private long _stdId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}