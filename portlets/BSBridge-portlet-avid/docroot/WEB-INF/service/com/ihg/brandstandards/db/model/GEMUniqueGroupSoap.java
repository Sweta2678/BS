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
public class GEMUniqueGroupSoap implements Serializable {
	public static GEMUniqueGroupSoap toSoapModel(GEMUniqueGroup model) {
		GEMUniqueGroupSoap soapModel = new GEMUniqueGroupSoap();

		soapModel.setUniqueGroupId(model.getUniqueGroupId());
		soapModel.setPublishDeptId(model.getPublishDeptId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setGroupName(model.getGroupName());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setPolicyId(model.getPolicyId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setGroupType(model.getGroupType());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMUniqueGroupSoap[] toSoapModels(GEMUniqueGroup[] models) {
		GEMUniqueGroupSoap[] soapModels = new GEMUniqueGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMUniqueGroupSoap[][] toSoapModels(GEMUniqueGroup[][] models) {
		GEMUniqueGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMUniqueGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMUniqueGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMUniqueGroupSoap[] toSoapModels(List<GEMUniqueGroup> models) {
		List<GEMUniqueGroupSoap> soapModels = new ArrayList<GEMUniqueGroupSoap>(models.size());

		for (GEMUniqueGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMUniqueGroupSoap[soapModels.size()]);
	}

	public GEMUniqueGroupSoap() {
	}

	public long getPrimaryKey() {
		return _uniqueGroupId;
	}

	public void setPrimaryKey(long pk) {
		setUniqueGroupId(pk);
	}

	public long getUniqueGroupId() {
		return _uniqueGroupId;
	}

	public void setUniqueGroupId(long uniqueGroupId) {
		_uniqueGroupId = uniqueGroupId;
	}

	public long getPublishDeptId() {
		return _publishDeptId;
	}

	public void setPublishDeptId(long publishDeptId) {
		_publishDeptId = publishDeptId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public String getGroupName() {
		return _groupName;
	}

	public void setGroupName(String groupName) {
		_groupName = groupName;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getPolicyId() {
		return _policyId;
	}

	public void setPolicyId(String policyId) {
		_policyId = policyId;
	}

	public String getLevelId() {
		return _levelId;
	}

	public void setLevelId(String levelId) {
		_levelId = levelId;
	}

	public String getGroupType() {
		return _groupType;
	}

	public void setGroupType(String groupType) {
		_groupType = groupType;
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

	private long _uniqueGroupId;
	private long _publishDeptId;
	private long _publishId;
	private String _groupName;
	private long _regionId;
	private String _policyId;
	private String _levelId;
	private String _groupType;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}