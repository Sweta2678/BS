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
public class GlossaryRegionNavSoap implements Serializable {
	public static GlossaryRegionNavSoap toSoapModel(GlossaryRegionNav model) {
		GlossaryRegionNavSoap soapModel = new GlossaryRegionNavSoap();

		soapModel.setGlossaryRgnNavId(model.getGlossaryRgnNavId());
		soapModel.setGlossaryId(model.getGlossaryId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setNavItemText(model.getNavItemText());
		soapModel.setActiveInd(model.getActiveInd());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GlossaryRegionNavSoap[] toSoapModels(
		GlossaryRegionNav[] models) {
		GlossaryRegionNavSoap[] soapModels = new GlossaryRegionNavSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GlossaryRegionNavSoap[][] toSoapModels(
		GlossaryRegionNav[][] models) {
		GlossaryRegionNavSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GlossaryRegionNavSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GlossaryRegionNavSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GlossaryRegionNavSoap[] toSoapModels(
		List<GlossaryRegionNav> models) {
		List<GlossaryRegionNavSoap> soapModels = new ArrayList<GlossaryRegionNavSoap>(models.size());

		for (GlossaryRegionNav model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GlossaryRegionNavSoap[soapModels.size()]);
	}

	public GlossaryRegionNavSoap() {
	}

	public long getPrimaryKey() {
		return _glossaryRgnNavId;
	}

	public void setPrimaryKey(long pk) {
		setGlossaryRgnNavId(pk);
	}

	public long getGlossaryRgnNavId() {
		return _glossaryRgnNavId;
	}

	public void setGlossaryRgnNavId(long glossaryRgnNavId) {
		_glossaryRgnNavId = glossaryRgnNavId;
	}

	public long getGlossaryId() {
		return _glossaryId;
	}

	public void setGlossaryId(long glossaryId) {
		_glossaryId = glossaryId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getNavItemText() {
		return _navItemText;
	}

	public void setNavItemText(String navItemText) {
		_navItemText = navItemText;
	}

	public String getActiveInd() {
		return _activeInd;
	}

	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
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

	private long _glossaryRgnNavId;
	private long _glossaryId;
	private long _regionId;
	private String _navItemText;
	private String _activeInd;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}