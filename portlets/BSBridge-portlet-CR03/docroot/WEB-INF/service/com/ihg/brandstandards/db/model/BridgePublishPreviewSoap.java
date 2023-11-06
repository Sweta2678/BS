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
public class BridgePublishPreviewSoap implements Serializable {
	public static BridgePublishPreviewSoap toSoapModel(
		BridgePublishPreview model) {
		BridgePublishPreviewSoap soapModel = new BridgePublishPreviewSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setTaxonomyTitle(model.getTaxonomyTitle());
		soapModel.setTitle(model.getTitle());
		soapModel.setPath(model.getPath());
		soapModel.setParentStdId(model.getParentStdId());
		soapModel.setCurrentTitle(model.getCurrentTitle());
		soapModel.setType(model.getType());
		soapModel.setDisplayOrder(model.getDisplayOrder());
		soapModel.setTaxonomyId(model.getTaxonomyId());
		soapModel.setParentTaxonomyId(model.getParentTaxonomyId());
		soapModel.setIndexOrder(model.getIndexOrder());
		soapModel.setLevel(model.getLevel());
		soapModel.setLevelSortOrder(model.getLevelSortOrder());
		soapModel.setStatus(model.getStatus());
		soapModel.setImageCount(model.getImageCount());
		soapModel.setAttachmentCount(model.getAttachmentCount());
		soapModel.setXRefCount(model.getXRefCount());
		soapModel.setHotelLifeCycle(model.getHotelLifeCycle());
		soapModel.setComplianceCount(model.getComplianceCount());
		soapModel.setHotelAttributes(model.getHotelAttributes());
		soapModel.setComplianceDate(model.getComplianceDate());
		soapModel.setStdReference(model.getStdReference());

		return soapModel;
	}

	public static BridgePublishPreviewSoap[] toSoapModels(
		BridgePublishPreview[] models) {
		BridgePublishPreviewSoap[] soapModels = new BridgePublishPreviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishPreviewSoap[][] toSoapModels(
		BridgePublishPreview[][] models) {
		BridgePublishPreviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishPreviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishPreviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishPreviewSoap[] toSoapModels(
		List<BridgePublishPreview> models) {
		List<BridgePublishPreviewSoap> soapModels = new ArrayList<BridgePublishPreviewSoap>(models.size());

		for (BridgePublishPreview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishPreviewSoap[soapModels.size()]);
	}

	public BridgePublishPreviewSoap() {
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

	public String getCurrentTitle() {
		return _currentTitle;
	}

	public void setCurrentTitle(String currentTitle) {
		_currentTitle = currentTitle;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
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

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getImageCount() {
		return _imageCount;
	}

	public void setImageCount(long imageCount) {
		_imageCount = imageCount;
	}

	public long getAttachmentCount() {
		return _attachmentCount;
	}

	public void setAttachmentCount(long attachmentCount) {
		_attachmentCount = attachmentCount;
	}

	public long getXRefCount() {
		return _xRefCount;
	}

	public void setXRefCount(long xRefCount) {
		_xRefCount = xRefCount;
	}

	public long getHotelLifeCycle() {
		return _hotelLifeCycle;
	}

	public void setHotelLifeCycle(long hotelLifeCycle) {
		_hotelLifeCycle = hotelLifeCycle;
	}

	public long getComplianceCount() {
		return _complianceCount;
	}

	public void setComplianceCount(long complianceCount) {
		_complianceCount = complianceCount;
	}

	public String getHotelAttributes() {
		return _hotelAttributes;
	}

	public void setHotelAttributes(String hotelAttributes) {
		_hotelAttributes = hotelAttributes;
	}

	public String getComplianceDate() {
		return _complianceDate;
	}

	public void setComplianceDate(String complianceDate) {
		_complianceDate = complianceDate;
	}

	public String getStdReference() {
		return _stdReference;
	}

	public void setStdReference(String stdReference) {
		_stdReference = stdReference;
	}

	private long _stdId;
	private String _taxonomyTitle;
	private String _title;
	private String _path;
	private long _parentStdId;
	private String _currentTitle;
	private String _type;
	private long _displayOrder;
	private long _taxonomyId;
	private long _parentTaxonomyId;
	private long _indexOrder;
	private long _level;
	private long _levelSortOrder;
	private String _status;
	private long _imageCount;
	private long _attachmentCount;
	private long _xRefCount;
	private long _hotelLifeCycle;
	private long _complianceCount;
	private String _hotelAttributes;
	private String _complianceDate;
	private String _stdReference;
}