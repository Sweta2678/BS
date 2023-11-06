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

package com.ihg.grs.common.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gulam.vora
 * @generated
 */
public class GlossarySoap implements Serializable {
	public static GlossarySoap toSoapModel(Glossary model) {
		GlossarySoap soapModel = new GlossarySoap();

		soapModel.setGlossaryId(model.getGlossaryId());
		soapModel.setTerm(model.getTerm());
		soapModel.setDescription(model.getDescription());
		soapModel.setActiveIndicator(model.getActiveIndicator());
		soapModel.setCreateUserId(model.getCreateUserId());
		soapModel.setCreatedate(model.getCreatedate());
		soapModel.setLastUpdateUserId(model.getLastUpdateUserId());
		soapModel.setUpdatedate(model.getUpdatedate());

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

	public int getPrimaryKey() {
		return _glossaryId;
	}

	public void setPrimaryKey(int pk) {
		setGlossaryId(pk);
	}

	public int getGlossaryId() {
		return _glossaryId;
	}

	public void setGlossaryId(int glossaryId) {
		_glossaryId = glossaryId;
	}

	public String getTerm() {
		return _term;
	}

	public void setTerm(String term) {
		_term = term;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getActiveIndicator() {
		return _activeIndicator;
	}

	public void setActiveIndicator(String activeIndicator) {
		_activeIndicator = activeIndicator;
	}

	public String getCreateUserId() {
		return _createUserId;
	}

	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;
	}

	public Date getCreatedate() {
		return _createdate;
	}

	public void setCreatedate(Date createdate) {
		_createdate = createdate;
	}

	public String getLastUpdateUserId() {
		return _lastUpdateUserId;
	}

	public void setLastUpdateUserId(String lastUpdateUserId) {
		_lastUpdateUserId = lastUpdateUserId;
	}

	public Date getUpdatedate() {
		return _updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		_updatedate = updatedate;
	}

	private int _glossaryId;
	private String _term;
	private String _description;
	private String _activeIndicator;
	private String _createUserId;
	private Date _createdate;
	private String _lastUpdateUserId;
	private Date _updatedate;
}