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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Image}.
 * </p>
 *
 * @author Mummanedi
 * @see Image
 * @generated
 */
public class ImageWrapper implements Image, ModelWrapper<Image> {
	public ImageWrapper(Image image) {
		_image = image;
	}

	@Override
	public Class<?> getModelClass() {
		return Image.class;
	}

	@Override
	public String getModelClassName() {
		return Image.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("imageId", getImageId());
		attributes.put("imageUuId", getImageUuId());
		attributes.put("imageDesc", getImageDesc());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageSize", getImageSize());
		attributes.put("imageType", getImageType());
		attributes.put("smallImageId", getSmallImageId());
		attributes.put("imageDimension", getImageDimension());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String imageUuId = (String)attributes.get("imageUuId");

		if (imageUuId != null) {
			setImageUuId(imageUuId);
		}

		String imageDesc = (String)attributes.get("imageDesc");

		if (imageDesc != null) {
			setImageDesc(imageDesc);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		String imageSize = (String)attributes.get("imageSize");

		if (imageSize != null) {
			setImageSize(imageSize);
		}

		String imageType = (String)attributes.get("imageType");

		if (imageType != null) {
			setImageType(imageType);
		}

		String smallImageId = (String)attributes.get("smallImageId");

		if (smallImageId != null) {
			setSmallImageId(smallImageId);
		}

		String imageDimension = (String)attributes.get("imageDimension");

		if (imageDimension != null) {
			setImageDimension(imageDimension);
		}

		String creatorId = (String)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}
	}

	/**
	* Returns the primary key of this image.
	*
	* @return the primary key of this image
	*/
	@Override
	public long getPrimaryKey() {
		return _image.getPrimaryKey();
	}

	/**
	* Sets the primary key of this image.
	*
	* @param primaryKey the primary key of this image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_image.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the image ID of this image.
	*
	* @return the image ID of this image
	*/
	@Override
	public long getImageId() {
		return _image.getImageId();
	}

	/**
	* Sets the image ID of this image.
	*
	* @param imageId the image ID of this image
	*/
	@Override
	public void setImageId(long imageId) {
		_image.setImageId(imageId);
	}

	/**
	* Returns the image uu ID of this image.
	*
	* @return the image uu ID of this image
	*/
	@Override
	public java.lang.String getImageUuId() {
		return _image.getImageUuId();
	}

	/**
	* Sets the image uu ID of this image.
	*
	* @param imageUuId the image uu ID of this image
	*/
	@Override
	public void setImageUuId(java.lang.String imageUuId) {
		_image.setImageUuId(imageUuId);
	}

	/**
	* Returns the image desc of this image.
	*
	* @return the image desc of this image
	*/
	@Override
	public java.lang.String getImageDesc() {
		return _image.getImageDesc();
	}

	/**
	* Sets the image desc of this image.
	*
	* @param imageDesc the image desc of this image
	*/
	@Override
	public void setImageDesc(java.lang.String imageDesc) {
		_image.setImageDesc(imageDesc);
	}

	/**
	* Returns the image title of this image.
	*
	* @return the image title of this image
	*/
	@Override
	public java.lang.String getImageTitle() {
		return _image.getImageTitle();
	}

	/**
	* Sets the image title of this image.
	*
	* @param imageTitle the image title of this image
	*/
	@Override
	public void setImageTitle(java.lang.String imageTitle) {
		_image.setImageTitle(imageTitle);
	}

	/**
	* Returns the image size of this image.
	*
	* @return the image size of this image
	*/
	@Override
	public java.lang.String getImageSize() {
		return _image.getImageSize();
	}

	/**
	* Sets the image size of this image.
	*
	* @param imageSize the image size of this image
	*/
	@Override
	public void setImageSize(java.lang.String imageSize) {
		_image.setImageSize(imageSize);
	}

	/**
	* Returns the image type of this image.
	*
	* @return the image type of this image
	*/
	@Override
	public java.lang.String getImageType() {
		return _image.getImageType();
	}

	/**
	* Sets the image type of this image.
	*
	* @param imageType the image type of this image
	*/
	@Override
	public void setImageType(java.lang.String imageType) {
		_image.setImageType(imageType);
	}

	/**
	* Returns the small image ID of this image.
	*
	* @return the small image ID of this image
	*/
	@Override
	public java.lang.String getSmallImageId() {
		return _image.getSmallImageId();
	}

	/**
	* Sets the small image ID of this image.
	*
	* @param smallImageId the small image ID of this image
	*/
	@Override
	public void setSmallImageId(java.lang.String smallImageId) {
		_image.setSmallImageId(smallImageId);
	}

	/**
	* Returns the image dimension of this image.
	*
	* @return the image dimension of this image
	*/
	@Override
	public java.lang.String getImageDimension() {
		return _image.getImageDimension();
	}

	/**
	* Sets the image dimension of this image.
	*
	* @param imageDimension the image dimension of this image
	*/
	@Override
	public void setImageDimension(java.lang.String imageDimension) {
		_image.setImageDimension(imageDimension);
	}

	/**
	* Returns the creator ID of this image.
	*
	* @return the creator ID of this image
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _image.getCreatorId();
	}

	/**
	* Sets the creator ID of this image.
	*
	* @param creatorId the creator ID of this image
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_image.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this image.
	*
	* @return the created date of this image
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _image.getCreatedDate();
	}

	/**
	* Sets the created date of this image.
	*
	* @param createdDate the created date of this image
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_image.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this image.
	*
	* @return the updated by of this image
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _image.getUpdatedBy();
	}

	/**
	* Sets the updated by of this image.
	*
	* @param updatedBy the updated by of this image
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_image.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this image.
	*
	* @return the updated date of this image
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _image.getUpdatedDate();
	}

	/**
	* Sets the updated date of this image.
	*
	* @param updatedDate the updated date of this image
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_image.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _image.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_image.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _image.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_image.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _image.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _image.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_image.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _image.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_image.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_image.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_image.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ImageWrapper((Image)_image.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.Image image) {
		return _image.compareTo(image);
	}

	@Override
	public int hashCode() {
		return _image.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.Image> toCacheModel() {
		return _image.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.Image toEscapedModel() {
		return new ImageWrapper(_image.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.Image toUnescapedModel() {
		return new ImageWrapper(_image.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _image.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _image.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_image.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageWrapper)) {
			return false;
		}

		ImageWrapper imageWrapper = (ImageWrapper)obj;

		if (Validator.equals(_image, imageWrapper._image)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Image getWrappedImage() {
		return _image;
	}

	@Override
	public Image getWrappedModel() {
		return _image;
	}

	@Override
	public void resetOriginalValues() {
		_image.resetOriginalValues();
	}

	private Image _image;
}