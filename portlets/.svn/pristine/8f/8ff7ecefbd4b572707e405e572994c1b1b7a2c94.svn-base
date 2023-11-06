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

import com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK;

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
public class TaxonomyTranslateSoap implements Serializable {
	public static TaxonomyTranslateSoap toSoapModel(TaxonomyTranslate model) {
		TaxonomyTranslateSoap soapModel = new TaxonomyTranslateSoap();

		soapModel.setTaxId(model.getTaxId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setDesc(model.getDesc());
		soapModel.setImageLoc(model.getImageLoc());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static TaxonomyTranslateSoap[] toSoapModels(
		TaxonomyTranslate[] models) {
		TaxonomyTranslateSoap[] soapModels = new TaxonomyTranslateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaxonomyTranslateSoap[][] toSoapModels(
		TaxonomyTranslate[][] models) {
		TaxonomyTranslateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaxonomyTranslateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaxonomyTranslateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaxonomyTranslateSoap[] toSoapModels(
		List<TaxonomyTranslate> models) {
		List<TaxonomyTranslateSoap> soapModels = new ArrayList<TaxonomyTranslateSoap>(models.size());

		for (TaxonomyTranslate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaxonomyTranslateSoap[soapModels.size()]);
	}

	public TaxonomyTranslateSoap() {
	}

	public TaxonomyTranslatePK getPrimaryKey() {
		return new TaxonomyTranslatePK(_taxId, _localeCode);
	}

	public void setPrimaryKey(TaxonomyTranslatePK pk) {
		setTaxId(pk.taxId);
		setLocaleCode(pk.localeCode);
	}

	public long getTaxId() {
		return _taxId;
	}

	public void setTaxId(long taxId) {
		_taxId = taxId;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
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

	private long _taxId;
	private String _localeCode;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}