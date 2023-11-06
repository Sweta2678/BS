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
public class StandardsRegionSoap implements Serializable {
	public static StandardsRegionSoap toSoapModel(StandardsRegion model) {
		StandardsRegionSoap soapModel = new StandardsRegionSoap();

		soapModel.setRegionId(model.getRegionId());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setRegionType(model.getRegionType());
		soapModel.setRegionName(model.getRegionName());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());
		soapModel.setParentRegionId(model.getParentRegionId());

		return soapModel;
	}

	public static StandardsRegionSoap[] toSoapModels(StandardsRegion[] models) {
		StandardsRegionSoap[] soapModels = new StandardsRegionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsRegionSoap[][] toSoapModels(
		StandardsRegion[][] models) {
		StandardsRegionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsRegionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsRegionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsRegionSoap[] toSoapModels(
		List<StandardsRegion> models) {
		List<StandardsRegionSoap> soapModels = new ArrayList<StandardsRegionSoap>(models.size());

		for (StandardsRegion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsRegionSoap[soapModels.size()]);
	}

	public StandardsRegionSoap() {
	}

	public long getPrimaryKey() {
		return _regionId;
	}

	public void setPrimaryKey(long pk) {
		setRegionId(pk);
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getRegionType() {
		return _regionType;
	}

	public void setRegionType(String regionType) {
		_regionType = regionType;
	}

	public String getRegionName() {
		return _regionName;
	}

	public void setRegionName(String regionName) {
		_regionName = regionName;
	}

	public String getIsActive() {
		return _isActive;
	}

	public void setIsActive(String isActive) {
		_isActive = isActive;
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

	public long getParentRegionId() {
		return _parentRegionId;
	}

	public void setParentRegionId(long parentRegionId) {
		_parentRegionId = parentRegionId;
	}

	private long _regionId;
	private String _regionCode;
	private String _regionType;
	private String _regionName;
	private String _isActive;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _parentRegionId;
}