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

import com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK;

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
public class StandardsCrossReferenceSoap implements Serializable {
	public static StandardsCrossReferenceSoap toSoapModel(
		StandardsCrossReference model) {
		StandardsCrossReferenceSoap soapModel = new StandardsCrossReferenceSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setXrefStdId(model.getXrefStdId());
		soapModel.setDispOrderNumber(model.getDispOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsCrossReferenceSoap[] toSoapModels(
		StandardsCrossReference[] models) {
		StandardsCrossReferenceSoap[] soapModels = new StandardsCrossReferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsCrossReferenceSoap[][] toSoapModels(
		StandardsCrossReference[][] models) {
		StandardsCrossReferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsCrossReferenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsCrossReferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsCrossReferenceSoap[] toSoapModels(
		List<StandardsCrossReference> models) {
		List<StandardsCrossReferenceSoap> soapModels = new ArrayList<StandardsCrossReferenceSoap>(models.size());

		for (StandardsCrossReference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsCrossReferenceSoap[soapModels.size()]);
	}

	public StandardsCrossReferenceSoap() {
	}

	public StandardsCrossReferencePK getPrimaryKey() {
		return new StandardsCrossReferencePK(_stdId, _xrefStdId);
	}

	public void setPrimaryKey(StandardsCrossReferencePK pk) {
		setStdId(pk.stdId);
		setXrefStdId(pk.xrefStdId);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getXrefStdId() {
		return _xrefStdId;
	}

	public void setXrefStdId(long xrefStdId) {
		_xrefStdId = xrefStdId;
	}

	public long getDispOrderNumber() {
		return _dispOrderNumber;
	}

	public void setDispOrderNumber(long dispOrderNumber) {
		_dispOrderNumber = dispOrderNumber;
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
	private long _xrefStdId;
	private long _dispOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}