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
public class GlossaryExtSoap implements Serializable {
	public static GlossaryExtSoap toSoapModel(GlossaryExt model) {
		GlossaryExtSoap soapModel = new GlossaryExtSoap();

		soapModel.setGlossaryId(model.getGlossaryId());
		soapModel.setActiveInd(model.getActiveInd());
		soapModel.setGlossaryTermText(model.getGlossaryTermText());
		soapModel.setGlossaryTermDesc(model.getGlossaryTermDesc());
		soapModel.setGlossaryRegions(model.getGlossaryRegions());
		soapModel.setGlossaryChains(model.getGlossaryChains());

		return soapModel;
	}

	public static GlossaryExtSoap[] toSoapModels(GlossaryExt[] models) {
		GlossaryExtSoap[] soapModels = new GlossaryExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GlossaryExtSoap[][] toSoapModels(GlossaryExt[][] models) {
		GlossaryExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GlossaryExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GlossaryExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GlossaryExtSoap[] toSoapModels(List<GlossaryExt> models) {
		List<GlossaryExtSoap> soapModels = new ArrayList<GlossaryExtSoap>(models.size());

		for (GlossaryExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GlossaryExtSoap[soapModels.size()]);
	}

	public GlossaryExtSoap() {
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

	public String getActiveInd() {
		return _activeInd;
	}

	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;
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

	public String getGlossaryRegions() {
		return _glossaryRegions;
	}

	public void setGlossaryRegions(String glossaryRegions) {
		_glossaryRegions = glossaryRegions;
	}

	public String getGlossaryChains() {
		return _glossaryChains;
	}

	public void setGlossaryChains(String glossaryChains) {
		_glossaryChains = glossaryChains;
	}

	private long _glossaryId;
	private String _activeInd;
	private String _glossaryTermText;
	private String _glossaryTermDesc;
	private String _glossaryRegions;
	private String _glossaryChains;
}