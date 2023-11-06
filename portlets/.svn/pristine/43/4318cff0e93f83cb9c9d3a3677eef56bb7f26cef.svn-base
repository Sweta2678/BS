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
public class PublishTaxonomyExtSoap implements Serializable {
	public static PublishTaxonomyExtSoap toSoapModel(PublishTaxonomyExt model) {
		PublishTaxonomyExtSoap soapModel = new PublishTaxonomyExtSoap();

		soapModel.setPublishTaxId(model.getPublishTaxId());
		soapModel.setPublishParentId(model.getPublishParentId());
		soapModel.setTitle(model.getTitle());
		soapModel.setLvl(model.getLvl());
		soapModel.setPath(model.getPath());
		soapModel.setLevelSortOrder(model.getLevelSortOrder());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setIndexOrder(model.getIndexOrder());

		return soapModel;
	}

	public static PublishTaxonomyExtSoap[] toSoapModels(
		PublishTaxonomyExt[] models) {
		PublishTaxonomyExtSoap[] soapModels = new PublishTaxonomyExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishTaxonomyExtSoap[][] toSoapModels(
		PublishTaxonomyExt[][] models) {
		PublishTaxonomyExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishTaxonomyExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishTaxonomyExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishTaxonomyExtSoap[] toSoapModels(
		List<PublishTaxonomyExt> models) {
		List<PublishTaxonomyExtSoap> soapModels = new ArrayList<PublishTaxonomyExtSoap>(models.size());

		for (PublishTaxonomyExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishTaxonomyExtSoap[soapModels.size()]);
	}

	public PublishTaxonomyExtSoap() {
	}

	public long getPrimaryKey() {
		return _publishTaxId;
	}

	public void setPrimaryKey(long pk) {
		setPublishTaxId(pk);
	}

	public long getPublishTaxId() {
		return _publishTaxId;
	}

	public void setPublishTaxId(long publishTaxId) {
		_publishTaxId = publishTaxId;
	}

	public long getPublishParentId() {
		return _publishParentId;
	}

	public void setPublishParentId(long publishParentId) {
		_publishParentId = publishParentId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
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

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getIndexOrder() {
		return _indexOrder;
	}

	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;
	}

	private long _publishTaxId;
	private long _publishParentId;
	private String _title;
	private String _lvl;
	private String _path;
	private long _levelSortOrder;
	private long _publishId;
	private long _indexOrder;
}