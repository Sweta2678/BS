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

import com.ihg.brandstandards.db.service.persistence.StandardTagPK;

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
public class StandardTagSoap implements Serializable {
	public static StandardTagSoap toSoapModel(StandardTag model) {
		StandardTagSoap soapModel = new StandardTagSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setTag(model.getTag());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardTagSoap[] toSoapModels(StandardTag[] models) {
		StandardTagSoap[] soapModels = new StandardTagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardTagSoap[][] toSoapModels(StandardTag[][] models) {
		StandardTagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardTagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardTagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardTagSoap[] toSoapModels(List<StandardTag> models) {
		List<StandardTagSoap> soapModels = new ArrayList<StandardTagSoap>(models.size());

		for (StandardTag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardTagSoap[soapModels.size()]);
	}

	public StandardTagSoap() {
	}

	public StandardTagPK getPrimaryKey() {
		return new StandardTagPK(_stdId, _tag);
	}

	public void setPrimaryKey(StandardTagPK pk) {
		setStdId(pk.stdId);
		setTag(pk.tag);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getTag() {
		return _tag;
	}

	public void setTag(String tag) {
		_tag = tag;
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
	private String _tag;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}