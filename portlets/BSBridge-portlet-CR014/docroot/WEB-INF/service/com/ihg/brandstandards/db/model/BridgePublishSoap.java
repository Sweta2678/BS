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
public class BridgePublishSoap implements Serializable {
	public static BridgePublishSoap toSoapModel(BridgePublish model) {
		BridgePublishSoap soapModel = new BridgePublishSoap();

		soapModel.setBridgePublishId(model.getBridgePublishId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setStandardId(model.getStandardId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setUnpublishInd(model.getUnpublishInd());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgePublishSoap[] toSoapModels(BridgePublish[] models) {
		BridgePublishSoap[] soapModels = new BridgePublishSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishSoap[][] toSoapModels(BridgePublish[][] models) {
		BridgePublishSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishSoap[] toSoapModels(List<BridgePublish> models) {
		List<BridgePublishSoap> soapModels = new ArrayList<BridgePublishSoap>(models.size());

		for (BridgePublish model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishSoap[soapModels.size()]);
	}

	public BridgePublishSoap() {
	}

	public long getPrimaryKey() {
		return _bridgePublishId;
	}

	public void setPrimaryKey(long pk) {
		setBridgePublishId(pk);
	}

	public long getBridgePublishId() {
		return _bridgePublishId;
	}

	public void setBridgePublishId(long bridgePublishId) {
		_bridgePublishId = bridgePublishId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getStandardId() {
		return _standardId;
	}

	public void setStandardId(long standardId) {
		_standardId = standardId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getUnpublishInd() {
		return _unpublishInd;
	}

	public void setUnpublishInd(String unpublishInd) {
		_unpublishInd = unpublishInd;
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

	private long _bridgePublishId;
	private long _publishId;
	private long _standardId;
	private long _regionId;
	private String _unpublishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}