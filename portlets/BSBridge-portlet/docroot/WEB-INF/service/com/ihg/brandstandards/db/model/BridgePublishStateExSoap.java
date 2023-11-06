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

import com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class BridgePublishStateExSoap implements Serializable {
	public static BridgePublishStateExSoap toSoapModel(
		BridgePublishStateEx model) {
		BridgePublishStateExSoap soapModel = new BridgePublishStateExSoap();

		soapModel.setPublishId(model.getPublishId());
		soapModel.setStdId(model.getStdId());
		soapModel.setTaxonomyTitle(model.getTaxonomyTitle());
		soapModel.setTitle(model.getTitle());
		soapModel.setPath(model.getPath());
		soapModel.setParentStdId(model.getParentStdId());
		soapModel.setStateCd(model.getStateCd());
		soapModel.setType(model.getType());
		soapModel.setManualType(model.getManualType());
		soapModel.setCount(model.getCount());
		soapModel.setDisplayOrder(model.getDisplayOrder());
		soapModel.setTaxonomyId(model.getTaxonomyId());
		soapModel.setParentTaxonomyId(model.getParentTaxonomyId());
		soapModel.setIndexOrder(model.getIndexOrder());
		soapModel.setLevel(model.getLevel());
		soapModel.setLevelSortOrder(model.getLevelSortOrder());

		return soapModel;
	}

	public static BridgePublishStateExSoap[] toSoapModels(
		BridgePublishStateEx[] models) {
		BridgePublishStateExSoap[] soapModels = new BridgePublishStateExSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishStateExSoap[][] toSoapModels(
		BridgePublishStateEx[][] models) {
		BridgePublishStateExSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishStateExSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishStateExSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishStateExSoap[] toSoapModels(
		List<BridgePublishStateEx> models) {
		List<BridgePublishStateExSoap> soapModels = new ArrayList<BridgePublishStateExSoap>(models.size());

		for (BridgePublishStateEx model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishStateExSoap[soapModels.size()]);
	}

	public BridgePublishStateExSoap() {
	}

	public BridgePublishStateExPK getPrimaryKey() {
		return new BridgePublishStateExPK(_publishId, _stdId);
	}

	public void setPrimaryKey(BridgePublishStateExPK pk) {
		setPublishId(pk.publishId);
		setStdId(pk.stdId);
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getTaxonomyTitle() {
		return _taxonomyTitle;
	}

	public void setTaxonomyTitle(String taxonomyTitle) {
		_taxonomyTitle = taxonomyTitle;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getPath() {
		return _path;
	}

	public void setPath(String path) {
		_path = path;
	}

	public long getParentStdId() {
		return _parentStdId;
	}

	public void setParentStdId(long parentStdId) {
		_parentStdId = parentStdId;
	}

	public String getStateCd() {
		return _stateCd;
	}

	public void setStateCd(String stateCd) {
		_stateCd = stateCd;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getManualType() {
		return _manualType;
	}

	public void setManualType(String manualType) {
		_manualType = manualType;
	}

	public long getCount() {
		return _count;
	}

	public void setCount(long count) {
		_count = count;
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

	private long _publishId;
	private long _stdId;
	private String _taxonomyTitle;
	private String _title;
	private String _path;
	private long _parentStdId;
	private String _stateCd;
	private String _type;
	private String _manualType;
	private long _count;
	private long _displayOrder;
	private long _taxonomyId;
	private long _parentTaxonomyId;
	private long _indexOrder;
	private long _level;
	private long _levelSortOrder;
}