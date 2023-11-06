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
public class PublishExtStdSoap implements Serializable {
	public static PublishExtStdSoap toSoapModel(PublishExtStd model) {
		PublishExtStdSoap soapModel = new PublishExtStdSoap();

		soapModel.setCompDate(model.getCompDate());
		soapModel.setStdId(model.getStdId());
		soapModel.setParentId(model.getParentId());
		soapModel.setTitle(model.getTitle());
		soapModel.setExpiredIds(model.getExpiredIds());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setIsGlobal(model.getIsGlobal());
		soapModel.setFramework(model.getFramework());

		return soapModel;
	}

	public static PublishExtStdSoap[] toSoapModels(PublishExtStd[] models) {
		PublishExtStdSoap[] soapModels = new PublishExtStdSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishExtStdSoap[][] toSoapModels(PublishExtStd[][] models) {
		PublishExtStdSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishExtStdSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishExtStdSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishExtStdSoap[] toSoapModels(List<PublishExtStd> models) {
		List<PublishExtStdSoap> soapModels = new ArrayList<PublishExtStdSoap>(models.size());

		for (PublishExtStd model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishExtStdSoap[soapModels.size()]);
	}

	public PublishExtStdSoap() {
	}

	public long getPrimaryKey() {
		return _stdId;
	}

	public void setPrimaryKey(long pk) {
		setStdId(pk);
	}

	public Date getCompDate() {
		return _compDate;
	}

	public void setCompDate(Date compDate) {
		_compDate = compDate;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getExpiredIds() {
		return _expiredIds;
	}

	public void setExpiredIds(String expiredIds) {
		_expiredIds = expiredIds;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
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

	private Date _compDate;
	private long _stdId;
	private long _parentId;
	private String _title;
	private String _expiredIds;
	private String _regionCode;
	private String _isGlobal;
	private String _framework;
}