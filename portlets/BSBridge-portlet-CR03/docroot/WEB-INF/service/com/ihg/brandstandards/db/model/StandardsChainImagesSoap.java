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

import com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK;

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
public class StandardsChainImagesSoap implements Serializable {
	public static StandardsChainImagesSoap toSoapModel(
		StandardsChainImages model) {
		StandardsChainImagesSoap soapModel = new StandardsChainImagesSoap();

		soapModel.setStdImageId(model.getStdImageId());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsChainImagesSoap[] toSoapModels(
		StandardsChainImages[] models) {
		StandardsChainImagesSoap[] soapModels = new StandardsChainImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsChainImagesSoap[][] toSoapModels(
		StandardsChainImages[][] models) {
		StandardsChainImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsChainImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsChainImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsChainImagesSoap[] toSoapModels(
		List<StandardsChainImages> models) {
		List<StandardsChainImagesSoap> soapModels = new ArrayList<StandardsChainImagesSoap>(models.size());

		for (StandardsChainImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsChainImagesSoap[soapModels.size()]);
	}

	public StandardsChainImagesSoap() {
	}

	public StandardsChainImagesPK getPrimaryKey() {
		return new StandardsChainImagesPK(_stdImageId, _chainCode);
	}

	public void setPrimaryKey(StandardsChainImagesPK pk) {
		setStdImageId(pk.stdImageId);
		setChainCode(pk.chainCode);
	}

	public long getStdImageId() {
		return _stdImageId;
	}

	public void setStdImageId(long stdImageId) {
		_stdImageId = stdImageId;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
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

	private long _stdImageId;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}