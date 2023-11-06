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
public class DirectorySoap implements Serializable {
	public static DirectorySoap toSoapModel(Directory model) {
		DirectorySoap soapModel = new DirectorySoap();

		soapModel.setDirectoryId(model.getDirectoryId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setBusinessTitle(model.getBusinessTitle());
		soapModel.setGeoRegion(model.getGeoRegion());
		soapModel.setRole(model.getRole());
		soapModel.setRegionType(model.getRegionType());
		soapModel.setOrganizationName(model.getOrganizationName());
		soapModel.setPortraitURL(model.getPortraitURL());
		soapModel.setCreatedate(model.getCreatedate());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setLastUpdateUserId(model.getLastUpdateUserId());
		soapModel.setUpdatedate(model.getUpdatedate());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static DirectorySoap[] toSoapModels(Directory[] models) {
		DirectorySoap[] soapModels = new DirectorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DirectorySoap[][] toSoapModels(Directory[][] models) {
		DirectorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DirectorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new DirectorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DirectorySoap[] toSoapModels(List<Directory> models) {
		List<DirectorySoap> soapModels = new ArrayList<DirectorySoap>(models.size());

		for (Directory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DirectorySoap[soapModels.size()]);
	}

	public DirectorySoap() {
	}

	public int getPrimaryKey() {
		return _directoryId;
	}

	public void setPrimaryKey(int pk) {
		setDirectoryId(pk);
	}

	public int getDirectoryId() {
		return _directoryId;
	}

	public void setDirectoryId(int directoryId) {
		_directoryId = directoryId;
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

	public String getBusinessTitle() {
		return _businessTitle;
	}

	public void setBusinessTitle(String businessTitle) {
		_businessTitle = businessTitle;
	}

	public String getGeoRegion() {
		return _geoRegion;
	}

	public void setGeoRegion(String geoRegion) {
		_geoRegion = geoRegion;
	}

	public String getRole() {
		return _role;
	}

	public void setRole(String role) {
		_role = role;
	}

	public String getRegionType() {
		return _regionType;
	}

	public void setRegionType(String regionType) {
		_regionType = regionType;
	}

	public String getOrganizationName() {
		return _organizationName;
	}

	public void setOrganizationName(String organizationName) {
		_organizationName = organizationName;
	}

	public String getPortraitURL() {
		return _portraitURL;
	}

	public void setPortraitURL(String portraitURL) {
		_portraitURL = portraitURL;
	}

	public Date getCreatedate() {
		return _createdate;
	}

	public void setCreatedate(Date createdate) {
		_createdate = createdate;
	}

	public String getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;
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

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private int _directoryId;
	private String _firstName;
	private String _lastName;
	private String _businessTitle;
	private String _geoRegion;
	private String _role;
	private String _regionType;
	private String _organizationName;
	private String _portraitURL;
	private Date _createdate;
	private String _createUserId;
	private String _lastUpdateUserId;
	private Date _updatedate;
	private String _email;
}