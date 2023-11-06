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
public class TaxonomySoap implements Serializable {
	public static TaxonomySoap toSoapModel(Taxonomy model) {
		TaxonomySoap soapModel = new TaxonomySoap();

		soapModel.setTaxId(model.getTaxId());
		soapModel.setParentId(model.getParentId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDesc(model.getDesc());
		soapModel.setImageLoc(model.getImageLoc());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setPosition(model.getPosition());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static TaxonomySoap[] toSoapModels(Taxonomy[] models) {
		TaxonomySoap[] soapModels = new TaxonomySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaxonomySoap[][] toSoapModels(Taxonomy[][] models) {
		TaxonomySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaxonomySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaxonomySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaxonomySoap[] toSoapModels(List<Taxonomy> models) {
		List<TaxonomySoap> soapModels = new ArrayList<TaxonomySoap>(models.size());

		for (Taxonomy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaxonomySoap[soapModels.size()]);
	}

	public TaxonomySoap() {
	}

	public long getPrimaryKey() {
		return _taxId;
	}

	public void setPrimaryKey(long pk) {
		setTaxId(pk);
	}

	public long getTaxId() {
		return _taxId;
	}

	public void setTaxId(long taxId) {
		_taxId = taxId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDesc() {
		return _desc;
	}

	public void setDesc(String desc) {
		_desc = desc;
	}

	public String getImageLoc() {
		return _imageLoc;
	}

	public void setImageLoc(String imageLoc) {
		_imageLoc = imageLoc;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public long getPosition() {
		return _position;
	}

	public void setPosition(long position) {
		_position = position;
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

	private long _taxId;
	private long _parentId;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _createdBy;
	private long _position;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}