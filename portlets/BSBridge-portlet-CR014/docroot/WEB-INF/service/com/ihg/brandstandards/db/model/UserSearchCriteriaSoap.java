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
public class UserSearchCriteriaSoap implements Serializable {
	public static UserSearchCriteriaSoap toSoapModel(UserSearchCriteria model) {
		UserSearchCriteriaSoap soapModel = new UserSearchCriteriaSoap();

		soapModel.setUserSearchId(model.getUserSearchId());
		soapModel.setSearchName(model.getSearchName());
		soapModel.setSearchCriteria(model.getSearchCriteria());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());
		soapModel.setModuleName(model.getModuleName());

		return soapModel;
	}

	public static UserSearchCriteriaSoap[] toSoapModels(
		UserSearchCriteria[] models) {
		UserSearchCriteriaSoap[] soapModels = new UserSearchCriteriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserSearchCriteriaSoap[][] toSoapModels(
		UserSearchCriteria[][] models) {
		UserSearchCriteriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserSearchCriteriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserSearchCriteriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserSearchCriteriaSoap[] toSoapModels(
		List<UserSearchCriteria> models) {
		List<UserSearchCriteriaSoap> soapModels = new ArrayList<UserSearchCriteriaSoap>(models.size());

		for (UserSearchCriteria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserSearchCriteriaSoap[soapModels.size()]);
	}

	public UserSearchCriteriaSoap() {
	}

	public long getPrimaryKey() {
		return _userSearchId;
	}

	public void setPrimaryKey(long pk) {
		setUserSearchId(pk);
	}

	public long getUserSearchId() {
		return _userSearchId;
	}

	public void setUserSearchId(long userSearchId) {
		_userSearchId = userSearchId;
	}

	public String getSearchName() {
		return _searchName;
	}

	public void setSearchName(String searchName) {
		_searchName = searchName;
	}

	public String getSearchCriteria() {
		return _searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		_searchCriteria = searchCriteria;
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

	public String getModuleName() {
		return _moduleName;
	}

	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
	}

	private long _userSearchId;
	private String _searchName;
	private String _searchCriteria;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private String _moduleName;
}