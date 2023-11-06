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
public class TaxonomyStandardsSoap implements Serializable {
	public static TaxonomyStandardsSoap toSoapModel(TaxonomyStandards model) {
		TaxonomyStandardsSoap soapModel = new TaxonomyStandardsSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setTaxId(model.getTaxId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static TaxonomyStandardsSoap[] toSoapModels(
		TaxonomyStandards[] models) {
		TaxonomyStandardsSoap[] soapModels = new TaxonomyStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaxonomyStandardsSoap[][] toSoapModels(
		TaxonomyStandards[][] models) {
		TaxonomyStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaxonomyStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaxonomyStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaxonomyStandardsSoap[] toSoapModels(
		List<TaxonomyStandards> models) {
		List<TaxonomyStandardsSoap> soapModels = new ArrayList<TaxonomyStandardsSoap>(models.size());

		for (TaxonomyStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaxonomyStandardsSoap[soapModels.size()]);
	}

	public TaxonomyStandardsSoap() {
	}

	public long getPrimaryKey() {
		return _stdId;
	}

	public void setPrimaryKey(long pk) {
		setStdId(pk);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getTaxId() {
		return _taxId;
	}

	public void setTaxId(long taxId) {
		_taxId = taxId;
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

	private long _stdId;
	private long _taxId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}