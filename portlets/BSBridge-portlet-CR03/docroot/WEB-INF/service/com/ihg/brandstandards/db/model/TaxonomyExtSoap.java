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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class TaxonomyExtSoap implements Serializable {
	public static TaxonomyExtSoap toSoapModel(TaxonomyExt model) {
		TaxonomyExtSoap soapModel = new TaxonomyExtSoap();

		soapModel.setTaxId(model.getTaxId());
		soapModel.setParentId(model.getParentId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDesc(model.getDesc());
		soapModel.setImageLoc(model.getImageLoc());
		soapModel.setLvl(model.getLvl());
		soapModel.setPath(model.getPath());
		soapModel.setLevelSortOrder(model.getLevelSortOrder());
		soapModel.setIndexOrder(model.getIndexOrder());

		return soapModel;
	}

	public static TaxonomyExtSoap[] toSoapModels(TaxonomyExt[] models) {
		TaxonomyExtSoap[] soapModels = new TaxonomyExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TaxonomyExtSoap[][] toSoapModels(TaxonomyExt[][] models) {
		TaxonomyExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TaxonomyExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TaxonomyExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TaxonomyExtSoap[] toSoapModels(List<TaxonomyExt> models) {
		List<TaxonomyExtSoap> soapModels = new ArrayList<TaxonomyExtSoap>(models.size());

		for (TaxonomyExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TaxonomyExtSoap[soapModels.size()]);
	}

	public TaxonomyExtSoap() {
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

	public String getLvl() {
		return _lvl;
	}

	public void setLvl(String lvl) {
		_lvl = lvl;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public long getLevelSortOrder() {
		return _levelSortOrder;
	}

	public void setLevelSortOrder(long levelSortOrder) {
		_levelSortOrder = levelSortOrder;
	}

	public long getIndexOrder() {
		return _indexOrder;
	}

	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;
	}

	private long _taxId;
	private long _parentId;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _lvl;
	private String _path;
	private long _levelSortOrder;
	private long _indexOrder;
}