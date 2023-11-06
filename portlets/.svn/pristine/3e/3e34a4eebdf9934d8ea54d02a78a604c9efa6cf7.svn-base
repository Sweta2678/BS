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

import com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK;

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
public class StandardsDisplayOrderSoap implements Serializable {
	public static StandardsDisplayOrderSoap toSoapModel(
		StandardsDisplayOrder model) {
		StandardsDisplayOrderSoap soapModel = new StandardsDisplayOrderSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setDisplayOrder(model.getDisplayOrder());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsDisplayOrderSoap[] toSoapModels(
		StandardsDisplayOrder[] models) {
		StandardsDisplayOrderSoap[] soapModels = new StandardsDisplayOrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsDisplayOrderSoap[][] toSoapModels(
		StandardsDisplayOrder[][] models) {
		StandardsDisplayOrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsDisplayOrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsDisplayOrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsDisplayOrderSoap[] toSoapModels(
		List<StandardsDisplayOrder> models) {
		List<StandardsDisplayOrderSoap> soapModels = new ArrayList<StandardsDisplayOrderSoap>(models.size());

		for (StandardsDisplayOrder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsDisplayOrderSoap[soapModels.size()]);
	}

	public StandardsDisplayOrderSoap() {
	}

	public StandardsDisplayOrderPK getPrimaryKey() {
		return new StandardsDisplayOrderPK(_stdId, _regionCode, _chainCode);
	}

	public void setPrimaryKey(StandardsDisplayOrderPK pk) {
		setStdId(pk.stdId);
		setRegionCode(pk.regionCode);
		setChainCode(pk.chainCode);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public long getDisplayOrder() {
		return _displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;
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
	private String _regionCode;
	private String _chainCode;
	private long _displayOrder;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}