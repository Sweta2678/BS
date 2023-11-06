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
public class MustPublishSoap implements Serializable {
	public static MustPublishSoap toSoapModel(MustPublish model) {
		MustPublishSoap soapModel = new MustPublishSoap();

		soapModel.setParentId(model.getParentId());
		soapModel.setStdId(model.getStdId());
		soapModel.setTitle(model.getTitle());
		soapModel.setStdType(model.getStdType());
		soapModel.setPath(model.getPath());
		soapModel.setCurrentPath(model.getCurrentPath());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setAmer(model.getAmer());
		soapModel.setAmea(model.getAmea());
		soapModel.setEuro(model.getEuro());
		soapModel.setGc(model.getGc());
		soapModel.setStatus(model.getStatus());
		soapModel.setDisplayOrder(model.getDisplayOrder());
		soapModel.setTaxonomyId(model.getTaxonomyId());
		soapModel.setParentTaxonomyId(model.getParentTaxonomyId());
		soapModel.setIndexOrder(model.getIndexOrder());
		soapModel.setLevel(model.getLevel());
		soapModel.setLevelSortOrder(model.getLevelSortOrder());
		soapModel.setIsGlobal(model.getIsGlobal());
		soapModel.setFramework(model.getFramework());

		return soapModel;
	}

	public static MustPublishSoap[] toSoapModels(MustPublish[] models) {
		MustPublishSoap[] soapModels = new MustPublishSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MustPublishSoap[][] toSoapModels(MustPublish[][] models) {
		MustPublishSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MustPublishSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MustPublishSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MustPublishSoap[] toSoapModels(List<MustPublish> models) {
		List<MustPublishSoap> soapModels = new ArrayList<MustPublishSoap>(models.size());

		for (MustPublish model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MustPublishSoap[soapModels.size()]);
	}

	public MustPublishSoap() {
	}

	public long getPrimaryKey() {
		return _stdId;
	}

	public void setPrimaryKey(long pk) {
		setStdId(pk);
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getStdType() {
		return _stdType;
	}

	public void setStdType(String stdType) {
		_stdType = stdType;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public String getCurrentPath() {
		return _currentPath;
	}

	public void setCurrentPath(String currentPath) {
		_currentPath = currentPath;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getAmer() {
		return _amer;
	}

	public void setAmer(String amer) {
		_amer = amer;
	}

	public String getAmea() {
		return _amea;
	}

	public void setAmea(String amea) {
		_amea = amea;
	}

	public String getEuro() {
		return _euro;
	}

	public void setEuro(String euro) {
		_euro = euro;
	}

	public String getGc() {
		return _gc;
	}

	public void setGc(String gc) {
		_gc = gc;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getDisplayOrder() {
		return _displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;
	}

	public long getTaxonomyId() {
		return _taxonomyId;
	}

	public void setTaxonomyId(long taxonomyId) {
		_taxonomyId = taxonomyId;
	}

	public long getParentTaxonomyId() {
		return _parentTaxonomyId;
	}

	public void setParentTaxonomyId(long parentTaxonomyId) {
		_parentTaxonomyId = parentTaxonomyId;
	}

	public long getIndexOrder() {
		return _indexOrder;
	}

	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;
	}

	public long getLevel() {
		return _level;
	}

	public void setLevel(long level) {
		_level = level;
	}

	public long getLevelSortOrder() {
		return _levelSortOrder;
	}

	public void setLevelSortOrder(long levelSortOrder) {
		_levelSortOrder = levelSortOrder;
	}

	public String getIsGlobal() {
		return _isGlobal;
	}

	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;
	}

	public String getFramework() {
		return _framework;
	}

	public void setFramework(String framework) {
		_framework = framework;
	}

	private long _parentId;
	private long _stdId;
	private String _title;
	private String _stdType;
	private String _path;
	private String _currentPath;
	private String _regionCode;
	private String _amer;
	private String _amea;
	private String _euro;
	private String _gc;
	private String _status;
	private long _displayOrder;
	private long _taxonomyId;
	private long _parentTaxonomyId;
	private long _indexOrder;
	private long _level;
	private long _levelSortOrder;
	private String _isGlobal;
	private String _framework;
}