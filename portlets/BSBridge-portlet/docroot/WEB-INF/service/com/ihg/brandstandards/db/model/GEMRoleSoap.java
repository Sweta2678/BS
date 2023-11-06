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
public class GEMRoleSoap implements Serializable {
	public static GEMRoleSoap toSoapModel(GEMRole model) {
		GEMRoleSoap soapModel = new GEMRoleSoap();

		soapModel.setGemGrpId(model.getGemGrpId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setGemGrpCode(model.getGemGrpCode());
		soapModel.setOwnerGrpId(model.getOwnerGrpId());
		soapModel.setOwnerGrpName(model.getOwnerGrpName());
		soapModel.setBusOwnerName(model.getBusOwnerName());
		soapModel.setDeligate1Name(model.getDeligate1Name());
		soapModel.setDeligate2Name(model.getDeligate2Name());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMRoleSoap[] toSoapModels(GEMRole[] models) {
		GEMRoleSoap[] soapModels = new GEMRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMRoleSoap[][] toSoapModels(GEMRole[][] models) {
		GEMRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMRoleSoap[] toSoapModels(List<GEMRole> models) {
		List<GEMRoleSoap> soapModels = new ArrayList<GEMRoleSoap>(models.size());

		for (GEMRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMRoleSoap[soapModels.size()]);
	}

	public GEMRoleSoap() {
	}

	public long getPrimaryKey() {
		return _gemGrpId;
	}

	public void setPrimaryKey(long pk) {
		setGemGrpId(pk);
	}

	public long getGemGrpId() {
		return _gemGrpId;
	}

	public void setGemGrpId(long gemGrpId) {
		_gemGrpId = gemGrpId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public String getGemGrpCode() {
		return _gemGrpCode;
	}

	public void setGemGrpCode(String gemGrpCode) {
		_gemGrpCode = gemGrpCode;
	}

	public String getOwnerGrpId() {
		return _ownerGrpId;
	}

	public void setOwnerGrpId(String ownerGrpId) {
		_ownerGrpId = ownerGrpId;
	}

	public String getOwnerGrpName() {
		return _ownerGrpName;
	}

	public void setOwnerGrpName(String ownerGrpName) {
		_ownerGrpName = ownerGrpName;
	}

	public String getBusOwnerName() {
		return _busOwnerName;
	}

	public void setBusOwnerName(String busOwnerName) {
		_busOwnerName = busOwnerName;
	}

	public String getDeligate1Name() {
		return _deligate1Name;
	}

	public void setDeligate1Name(String deligate1Name) {
		_deligate1Name = deligate1Name;
	}

	public String getDeligate2Name() {
		return _deligate2Name;
	}

	public void setDeligate2Name(String deligate2Name) {
		_deligate2Name = deligate2Name;
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

	private long _gemGrpId;
	private long _regionId;
	private String _chainCode;
	private String _gemGrpCode;
	private String _ownerGrpId;
	private String _ownerGrpName;
	private String _busOwnerName;
	private String _deligate1Name;
	private String _deligate2Name;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}