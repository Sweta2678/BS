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
public class GlossarySoap implements Serializable {
	public static GlossarySoap toSoapModel(Glossary model) {
		GlossarySoap soapModel = new GlossarySoap();

		soapModel.setGlossaryId(model.getGlossaryId());
		soapModel.setGlossaryTermText(model.getGlossaryTermText());
		soapModel.setGlossaryTermDesc(model.getGlossaryTermDesc());
		soapModel.setActiveInd(model.getActiveInd());
		soapModel.setGlossaryOwner(model.getGlossaryOwner());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GlossarySoap[] toSoapModels(Glossary[] models) {
		GlossarySoap[] soapModels = new GlossarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GlossarySoap[][] toSoapModels(Glossary[][] models) {
		GlossarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GlossarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GlossarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GlossarySoap[] toSoapModels(List<Glossary> models) {
		List<GlossarySoap> soapModels = new ArrayList<GlossarySoap>(models.size());

		for (Glossary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GlossarySoap[soapModels.size()]);
	}

	public GlossarySoap() {
	}

	public long getPrimaryKey() {
		return _glossaryId;
	}

	public void setPrimaryKey(long pk) {
		setGlossaryId(pk);
	}

	public long getGlossaryId() {
		return _glossaryId;
	}

	public void setGlossaryId(long glossaryId) {
		_glossaryId = glossaryId;
	}

	public String getGlossaryTermText() {
		return _glossaryTermText;
	}

	public void setGlossaryTermText(String glossaryTermText) {
		_glossaryTermText = glossaryTermText;
	}

	public String getGlossaryTermDesc() {
		return _glossaryTermDesc;
	}

	public void setGlossaryTermDesc(String glossaryTermDesc) {
		_glossaryTermDesc = glossaryTermDesc;
	}

	public String getActiveInd() {
		return _activeInd;
	}

	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;
	}

	public long getGlossaryOwner() {
		return _glossaryOwner;
	}

	public void setGlossaryOwner(long glossaryOwner) {
		_glossaryOwner = glossaryOwner;
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

	private long _glossaryId;
	private String _glossaryTermText;
	private String _glossaryTermDesc;
	private String _activeInd;
	private long _glossaryOwner;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}