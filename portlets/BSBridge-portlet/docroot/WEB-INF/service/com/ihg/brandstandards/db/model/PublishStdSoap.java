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
public class PublishStdSoap implements Serializable {
	public static PublishStdSoap toSoapModel(PublishStd model) {
		PublishStdSoap soapModel = new PublishStdSoap();

		soapModel.setPublishStdVerId(model.getPublishStdVerId());
		soapModel.setStdId(model.getStdId());
		soapModel.setParentId(model.getParentId());
		soapModel.setStdTyp(model.getStdTyp());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setBusinessOwner(model.getBusinessOwner());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setImplDate(model.getImplDate());
		soapModel.setWaiver(model.getWaiver());
		soapModel.setStatus(model.getStatus());
		soapModel.setCategory(model.getCategory());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setChange(model.getChange());
		soapModel.setIsGlobal(model.getIsGlobal());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setNotes(model.getNotes());
		soapModel.setFramework(model.getFramework());
		soapModel.setInternalReference(model.getInternalReference());
		soapModel.setOrderNumber(model.getOrderNumber());
		soapModel.setStatusIdentifier(model.getStatusIdentifier());
		soapModel.setRegionIdentifier(model.getRegionIdentifier());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static PublishStdSoap[] toSoapModels(PublishStd[] models) {
		PublishStdSoap[] soapModels = new PublishStdSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishStdSoap[][] toSoapModels(PublishStd[][] models) {
		PublishStdSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishStdSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishStdSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishStdSoap[] toSoapModels(List<PublishStd> models) {
		List<PublishStdSoap> soapModels = new ArrayList<PublishStdSoap>(models.size());

		for (PublishStd model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishStdSoap[soapModels.size()]);
	}

	public PublishStdSoap() {
	}

	public long getPrimaryKey() {
		return _publishStdVerId;
	}

	public void setPrimaryKey(long pk) {
		setPublishStdVerId(pk);
	}

	public long getPublishStdVerId() {
		return _publishStdVerId;
	}

	public void setPublishStdVerId(long publishStdVerId) {
		_publishStdVerId = publishStdVerId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public String getStdTyp() {
		return _stdTyp;
	}

	public void setStdTyp(String stdTyp) {
		_stdTyp = stdTyp;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getBusinessOwner() {
		return _businessOwner;
	}

	public void setBusinessOwner(String businessOwner) {
		_businessOwner = businessOwner;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public Date getImplDate() {
		return _implDate;
	}

	public void setImplDate(Date implDate) {
		_implDate = implDate;
	}

	public String getWaiver() {
		return _waiver;
	}

	public void setWaiver(String waiver) {
		_waiver = waiver;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public String getChange() {
		return _change;
	}

	public void setChange(String change) {
		_change = change;
	}

	public String getIsGlobal() {
		return _isGlobal;
	}

	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public String getFramework() {
		return _framework;
	}

	public void setFramework(String framework) {
		_framework = framework;
	}

	public String getInternalReference() {
		return _internalReference;
	}

	public void setInternalReference(String internalReference) {
		_internalReference = internalReference;
	}

	public long getOrderNumber() {
		return _orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		_orderNumber = orderNumber;
	}

	public long getStatusIdentifier() {
		return _statusIdentifier;
	}

	public void setStatusIdentifier(long statusIdentifier) {
		_statusIdentifier = statusIdentifier;
	}

	public long getRegionIdentifier() {
		return _regionIdentifier;
	}

	public void setRegionIdentifier(long regionIdentifier) {
		_regionIdentifier = regionIdentifier;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
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

	private long _publishStdVerId;
	private long _stdId;
	private long _parentId;
	private String _stdTyp;
	private String _title;
	private String _description;
	private String _author;
	private String _businessOwner;
	private Date _effectiveDate;
	private Date _implDate;
	private String _waiver;
	private String _status;
	private String _category;
	private String _createdBy;
	private String _change;
	private String _isGlobal;
	private String _regionCode;
	private String _notes;
	private String _framework;
	private String _internalReference;
	private long _orderNumber;
	private long _statusIdentifier;
	private long _regionIdentifier;
	private long _publishId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}