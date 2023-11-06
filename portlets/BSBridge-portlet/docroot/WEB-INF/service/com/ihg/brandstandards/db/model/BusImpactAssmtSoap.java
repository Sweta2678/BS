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
public class BusImpactAssmtSoap implements Serializable {
	public static BusImpactAssmtSoap toSoapModel(BusImpactAssmt model) {
		BusImpactAssmtSoap soapModel = new BusImpactAssmtSoap();

		soapModel.setBusImpactAssmtId(model.getBusImpactAssmtId());
		soapModel.setStdId(model.getStdId());
		soapModel.setChain(model.getChain());
		soapModel.setRegion(model.getRegion());
		soapModel.setProfileLossImpact(model.getProfileLossImpact());
		soapModel.setCapExpenseImpact(model.getCapExpenseImpact());
		soapModel.setImplTimeScale(model.getImplTimeScale());
		soapModel.setChangeFromRegional(model.getChangeFromRegional());
		soapModel.setBiaComments(model.getBiaComments());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BusImpactAssmtSoap[] toSoapModels(BusImpactAssmt[] models) {
		BusImpactAssmtSoap[] soapModels = new BusImpactAssmtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BusImpactAssmtSoap[][] toSoapModels(BusImpactAssmt[][] models) {
		BusImpactAssmtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BusImpactAssmtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BusImpactAssmtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BusImpactAssmtSoap[] toSoapModels(List<BusImpactAssmt> models) {
		List<BusImpactAssmtSoap> soapModels = new ArrayList<BusImpactAssmtSoap>(models.size());

		for (BusImpactAssmt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BusImpactAssmtSoap[soapModels.size()]);
	}

	public BusImpactAssmtSoap() {
	}

	public long getPrimaryKey() {
		return _busImpactAssmtId;
	}

	public void setPrimaryKey(long pk) {
		setBusImpactAssmtId(pk);
	}

	public long getBusImpactAssmtId() {
		return _busImpactAssmtId;
	}

	public void setBusImpactAssmtId(long busImpactAssmtId) {
		_busImpactAssmtId = busImpactAssmtId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getChain() {
		return _chain;
	}

	public void setChain(String chain) {
		_chain = chain;
	}

	public String getRegion() {
		return _region;
	}

	public void setRegion(String region) {
		_region = region;
	}

	public String getProfileLossImpact() {
		return _profileLossImpact;
	}

	public void setProfileLossImpact(String profileLossImpact) {
		_profileLossImpact = profileLossImpact;
	}

	public String getCapExpenseImpact() {
		return _CapExpenseImpact;
	}

	public void setCapExpenseImpact(String CapExpenseImpact) {
		_CapExpenseImpact = CapExpenseImpact;
	}

	public String getImplTimeScale() {
		return _ImplTimeScale;
	}

	public void setImplTimeScale(String ImplTimeScale) {
		_ImplTimeScale = ImplTimeScale;
	}

	public String getChangeFromRegional() {
		return _changeFromRegional;
	}

	public void setChangeFromRegional(String changeFromRegional) {
		_changeFromRegional = changeFromRegional;
	}

	public String getBiaComments() {
		return _biaComments;
	}

	public void setBiaComments(String biaComments) {
		_biaComments = biaComments;
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

	private long _busImpactAssmtId;
	private long _stdId;
	private String _chain;
	private String _region;
	private String _profileLossImpact;
	private String _CapExpenseImpact;
	private String _ImplTimeScale;
	private String _changeFromRegional;
	private String _biaComments;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}