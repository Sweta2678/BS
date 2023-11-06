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
public class StandardsAuthorsSoap implements Serializable {
	public static StandardsAuthorsSoap toSoapModel(StandardsAuthors model) {
		StandardsAuthorsSoap soapModel = new StandardsAuthorsSoap();

		soapModel.setStdAuthorId(model.getStdAuthorId());
		soapModel.setStdId(model.getStdId());
		soapModel.setAuthorName(model.getAuthorName());
		soapModel.setIsPrimary(model.getIsPrimary());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsAuthorsSoap[] toSoapModels(StandardsAuthors[] models) {
		StandardsAuthorsSoap[] soapModels = new StandardsAuthorsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsAuthorsSoap[][] toSoapModels(
		StandardsAuthors[][] models) {
		StandardsAuthorsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsAuthorsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsAuthorsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsAuthorsSoap[] toSoapModels(
		List<StandardsAuthors> models) {
		List<StandardsAuthorsSoap> soapModels = new ArrayList<StandardsAuthorsSoap>(models.size());

		for (StandardsAuthors model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsAuthorsSoap[soapModels.size()]);
	}

	public StandardsAuthorsSoap() {
	}

	public long getPrimaryKey() {
		return _stdAuthorId;
	}

	public void setPrimaryKey(long pk) {
		setStdAuthorId(pk);
	}

	public long getStdAuthorId() {
		return _stdAuthorId;
	}

	public void setStdAuthorId(long stdAuthorId) {
		_stdAuthorId = stdAuthorId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getAuthorName() {
		return _authorName;
	}

	public void setAuthorName(String authorName) {
		_authorName = authorName;
	}

	public String getIsPrimary() {
		return _isPrimary;
	}

	public void setIsPrimary(String isPrimary) {
		_isPrimary = isPrimary;
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

	private long _stdAuthorId;
	private long _stdId;
	private String _authorName;
	private String _isPrimary;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}