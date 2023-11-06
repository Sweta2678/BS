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

import com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK;

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
public class BrandTaxonomyTranslateSoap implements Serializable {
	public static BrandTaxonomyTranslateSoap toSoapModel(
		BrandTaxonomyTranslate model) {
		BrandTaxonomyTranslateSoap soapModel = new BrandTaxonomyTranslateSoap();

		soapModel.setBrandTaxId(model.getBrandTaxId());
		soapModel.setLocaleCd(model.getLocaleCd());
		soapModel.setTitle(model.getTitle());
		soapModel.setDesc(model.getDesc());
		soapModel.setImageLoc(model.getImageLoc());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BrandTaxonomyTranslateSoap[] toSoapModels(
		BrandTaxonomyTranslate[] models) {
		BrandTaxonomyTranslateSoap[] soapModels = new BrandTaxonomyTranslateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BrandTaxonomyTranslateSoap[][] toSoapModels(
		BrandTaxonomyTranslate[][] models) {
		BrandTaxonomyTranslateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BrandTaxonomyTranslateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BrandTaxonomyTranslateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BrandTaxonomyTranslateSoap[] toSoapModels(
		List<BrandTaxonomyTranslate> models) {
		List<BrandTaxonomyTranslateSoap> soapModels = new ArrayList<BrandTaxonomyTranslateSoap>(models.size());

		for (BrandTaxonomyTranslate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BrandTaxonomyTranslateSoap[soapModels.size()]);
	}

	public BrandTaxonomyTranslateSoap() {
	}

	public BrandTaxonomyTranslatePK getPrimaryKey() {
		return new BrandTaxonomyTranslatePK(_brandTaxId, _localeCd);
	}

	public void setPrimaryKey(BrandTaxonomyTranslatePK pk) {
		setBrandTaxId(pk.brandTaxId);
		setLocaleCd(pk.localeCd);
	}

	public long getBrandTaxId() {
		return _brandTaxId;
	}

	public void setBrandTaxId(long brandTaxId) {
		_brandTaxId = brandTaxId;
	}

	public String getLocaleCd() {
		return _localeCd;
	}

	public void setLocaleCd(String localeCd) {
		_localeCd = localeCd;
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

	private long _brandTaxId;
	private String _localeCd;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}