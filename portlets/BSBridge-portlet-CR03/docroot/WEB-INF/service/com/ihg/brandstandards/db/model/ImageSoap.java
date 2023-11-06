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
public class ImageSoap implements Serializable {
	public static ImageSoap toSoapModel(Image model) {
		ImageSoap soapModel = new ImageSoap();

		soapModel.setImageId(model.getImageId());
		soapModel.setImageUuId(model.getImageUuId());
		soapModel.setImageDesc(model.getImageDesc());
		soapModel.setImageTitle(model.getImageTitle());
		soapModel.setImageSize(model.getImageSize());
		soapModel.setImageType(model.getImageType());
		soapModel.setSmallImageId(model.getSmallImageId());
		soapModel.setImageDimension(model.getImageDimension());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static ImageSoap[] toSoapModels(Image[] models) {
		ImageSoap[] soapModels = new ImageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ImageSoap[][] toSoapModels(Image[][] models) {
		ImageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ImageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ImageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ImageSoap[] toSoapModels(List<Image> models) {
		List<ImageSoap> soapModels = new ArrayList<ImageSoap>(models.size());

		for (Image model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ImageSoap[soapModels.size()]);
	}

	public ImageSoap() {
	}

	public long getPrimaryKey() {
		return _imageId;
	}

	public void setPrimaryKey(long pk) {
		setImageId(pk);
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getImageUuId() {
		return _imageUuId;
	}

	public void setImageUuId(String imageUuId) {
		_imageUuId = imageUuId;
	}

	public String getImageDesc() {
		return _imageDesc;
	}

	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;
	}

	public String getImageTitle() {
		return _imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	public String getImageSize() {
		return _imageSize;
	}

	public void setImageSize(String imageSize) {
		_imageSize = imageSize;
	}

	public String getImageType() {
		return _imageType;
	}

	public void setImageType(String imageType) {
		_imageType = imageType;
	}

	public String getSmallImageId() {
		return _smallImageId;
	}

	public void setSmallImageId(String smallImageId) {
		_smallImageId = smallImageId;
	}

	public String getImageDimension() {
		return _imageDimension;
	}

	public void setImageDimension(String imageDimension) {
		_imageDimension = imageDimension;
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

	private long _imageId;
	private String _imageUuId;
	private String _imageDesc;
	private String _imageTitle;
	private String _imageSize;
	private String _imageType;
	private String _smallImageId;
	private String _imageDimension;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}