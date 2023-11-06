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
public class StandardsDisplayOrderExtSoap implements Serializable {
	public static StandardsDisplayOrderExtSoap toSoapModel(
		StandardsDisplayOrderExt model) {
		StandardsDisplayOrderExtSoap soapModel = new StandardsDisplayOrderExtSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setTitle(model.getTitle());
		soapModel.setIsGlobal(model.getIsGlobal());
		soapModel.setFramework(model.getFramework());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setDisplayOrder(model.getDisplayOrder());

		return soapModel;
	}

	public static StandardsDisplayOrderExtSoap[] toSoapModels(
		StandardsDisplayOrderExt[] models) {
		StandardsDisplayOrderExtSoap[] soapModels = new StandardsDisplayOrderExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsDisplayOrderExtSoap[][] toSoapModels(
		StandardsDisplayOrderExt[][] models) {
		StandardsDisplayOrderExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsDisplayOrderExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsDisplayOrderExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsDisplayOrderExtSoap[] toSoapModels(
		List<StandardsDisplayOrderExt> models) {
		List<StandardsDisplayOrderExtSoap> soapModels = new ArrayList<StandardsDisplayOrderExtSoap>(models.size());

		for (StandardsDisplayOrderExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsDisplayOrderExtSoap[soapModels.size()]);
	}

	public StandardsDisplayOrderExtSoap() {
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getIsGlobal() {
		return _isGlobal;
	}

	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;
	}

	public String getFramework() {
		return _framework;
	}

	public void setFramework(String framework) {
		_framework = framework;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public long getDisplayOrder() {
		return _displayOrder;
	}

	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;
	}

	private long _stdId;
	private String _title;
	private String _isGlobal;
	private String _framework;
	private String _chainCode;
	private String _regionCode;
	private long _displayOrder;
}