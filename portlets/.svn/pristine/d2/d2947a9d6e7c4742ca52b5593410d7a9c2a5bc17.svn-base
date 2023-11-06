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
public class StandardsImagesSoap implements Serializable {
	public static StandardsImagesSoap toSoapModel(StandardsImages model) {
		StandardsImagesSoap soapModel = new StandardsImagesSoap();

		soapModel.setStdImageId(model.getStdImageId());
		soapModel.setParentImageId(model.getParentImageId());
		soapModel.setImageId(model.getImageId());
		soapModel.setStdId(model.getStdId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageSortOrder(model.getImageSortOrder());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsImagesSoap[] toSoapModels(StandardsImages[] models) {
		StandardsImagesSoap[] soapModels = new StandardsImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsImagesSoap[][] toSoapModels(
		StandardsImages[][] models) {
		StandardsImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsImagesSoap[] toSoapModels(
		List<StandardsImages> models) {
		List<StandardsImagesSoap> soapModels = new ArrayList<StandardsImagesSoap>(models.size());

		for (StandardsImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsImagesSoap[soapModels.size()]);
	}

	public StandardsImagesSoap() {
	}

	public long getPrimaryKey() {
		return _stdImageId;
	}

	public void setPrimaryKey(long pk) {
		setStdImageId(pk);
	}

	public long getStdImageId() {
		return _stdImageId;
	}

	public void setStdImageId(long stdImageId) {
		_stdImageId = stdImageId;
	}

	public long getParentImageId() {
		return _parentImageId;
	}

	public void setParentImageId(long parentImageId) {
		_parentImageId = parentImageId;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
	}

	public String getImageTitle() {
		return _imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	public long getImageSortOrder() {
		return _imageSortOrder;
	}

	public void setImageSortOrder(long imageSortOrder) {
		_imageSortOrder = imageSortOrder;
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

	private long _stdImageId;
	private long _parentImageId;
	private long _imageId;
	private long _stdId;
	private String _localeCode;
	private String _imageTitle;
	private long _imageSortOrder;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}