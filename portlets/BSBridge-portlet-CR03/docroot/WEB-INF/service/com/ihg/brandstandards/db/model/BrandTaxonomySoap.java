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
public class BrandTaxonomySoap implements Serializable {
	public static BrandTaxonomySoap toSoapModel(BrandTaxonomy model) {
		BrandTaxonomySoap soapModel = new BrandTaxonomySoap();

		soapModel.setId(model.getId());
		soapModel.setTaxId(model.getTaxId());
		soapModel.setChain(model.getChain());
		soapModel.setTitle(model.getTitle());
		soapModel.setDesc(model.getDesc());
		soapModel.setImageLoc(model.getImageLoc());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BrandTaxonomySoap[] toSoapModels(BrandTaxonomy[] models) {
		BrandTaxonomySoap[] soapModels = new BrandTaxonomySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BrandTaxonomySoap[][] toSoapModels(BrandTaxonomy[][] models) {
		BrandTaxonomySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BrandTaxonomySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BrandTaxonomySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BrandTaxonomySoap[] toSoapModels(List<BrandTaxonomy> models) {
		List<BrandTaxonomySoap> soapModels = new ArrayList<BrandTaxonomySoap>(models.size());

		for (BrandTaxonomy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BrandTaxonomySoap[soapModels.size()]);
	}

	public BrandTaxonomySoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getTaxId() {
		return _taxId;
	}

	public void setTaxId(long taxId) {
		_taxId = taxId;
	}

	public String getChain() {
		return _chain;
	}

	public void setChain(String chain) {
		_chain = chain;
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

	private long _id;
	private long _taxId;
	private String _chain;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _createdBy;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}