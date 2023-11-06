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
public class TreeXMLSoap implements Serializable {
	public static TreeXMLSoap toSoapModel(TreeXML model) {
		TreeXMLSoap soapModel = new TreeXMLSoap();

		soapModel.setID(model.getID());
		soapModel.setXMLLOB(model.getXMLLOB());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static TreeXMLSoap[] toSoapModels(TreeXML[] models) {
		TreeXMLSoap[] soapModels = new TreeXMLSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TreeXMLSoap[][] toSoapModels(TreeXML[][] models) {
		TreeXMLSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TreeXMLSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TreeXMLSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TreeXMLSoap[] toSoapModels(List<TreeXML> models) {
		List<TreeXMLSoap> soapModels = new ArrayList<TreeXMLSoap>(models.size());

		for (TreeXML model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TreeXMLSoap[soapModels.size()]);
	}

	public TreeXMLSoap() {
	}

	public long getPrimaryKey() {
		return _ID;
	}

	public void setPrimaryKey(long pk) {
		setID(pk);
	}

	public long getID() {
		return _ID;
	}

	public void setID(long ID) {
		_ID = ID;
	}

	public String getXMLLOB() {
		return _XMLLOB;
	}

	public void setXMLLOB(String XMLLOB) {
		_XMLLOB = XMLLOB;
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

	private long _ID;
	private String _XMLLOB;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}