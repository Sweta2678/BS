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

import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.ImageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class ImageClp extends BaseModelImpl<Image> implements Image {
	public ImageClp() {
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
	public long getPrimaryKey() {
		return _imageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _imageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_imageId = imageId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageId", long.class);

				method.invoke(_imageRemoteModel, imageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUuId() {
		return _imageUuId;
	}

	@Override
	public void setImageUuId(String imageUuId) {
		_imageUuId = imageUuId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUuId", String.class);

				method.invoke(_imageRemoteModel, imageUuId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageDesc() {
		return _imageDesc;
	}

	@Override
	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageDesc", String.class);

				method.invoke(_imageRemoteModel, imageDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageTitle() {
		return _imageTitle;
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_imageRemoteModel, imageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageSize() {
		return _imageSize;
	}

	@Override
	public void setImageSize(String imageSize) {
		_imageSize = imageSize;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageSize", String.class);

				method.invoke(_imageRemoteModel, imageSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageType() {
		return _imageType;
	}

	@Override
	public void setImageType(String imageType) {
		_imageType = imageType;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageType", String.class);

				method.invoke(_imageRemoteModel, imageType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSmallImageId() {
		return _smallImageId;
	}

	@Override
	public void setSmallImageId(String smallImageId) {
		_smallImageId = smallImageId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setSmallImageId", String.class);

				method.invoke(_imageRemoteModel, smallImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageDimension() {
		return _imageDimension;
	}

	@Override
	public void setImageDimension(String imageDimension) {
		_imageDimension = imageDimension;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setImageDimension",
						String.class);

				method.invoke(_imageRemoteModel, imageDimension);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_imageRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_imageRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdatedBy() {
		return _updatedBy;
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_imageRemoteModel, updatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;

		if (_imageRemoteModel != null) {
			try {
				Class<?> clazz = _imageRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_imageRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getImageRemoteModel() {
		return _imageRemoteModel;
	}

	public void setImageRemoteModel(BaseModel<?> imageRemoteModel) {
		_imageRemoteModel = imageRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _imageRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_imageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ImageLocalServiceUtil.addImage(this);
		}
		else {
			ImageLocalServiceUtil.updateImage(this);
		}
	}

	@Override
	public Image toEscapedModel() {
		return (Image)ProxyUtil.newProxyInstance(Image.class.getClassLoader(),
			new Class[] { Image.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ImageClp clone = new ImageClp();

		clone.setImageId(getImageId());
		clone.setImageUuId(getImageUuId());
		clone.setImageDesc(getImageDesc());
		clone.setImageTitle(getImageTitle());
		clone.setImageSize(getImageSize());
		clone.setImageType(getImageType());
		clone.setSmallImageId(getSmallImageId());
		clone.setImageDimension(getImageDimension());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(Image image) {
		long primaryKey = image.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ImageClp)) {
			return false;
		}

		ImageClp image = (ImageClp)obj;

		long primaryKey = image.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{imageId=");
		sb.append(getImageId());
		sb.append(", imageUuId=");
		sb.append(getImageUuId());
		sb.append(", imageDesc=");
		sb.append(getImageDesc());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageSize=");
		sb.append(getImageSize());
		sb.append(", imageType=");
		sb.append(getImageType());
		sb.append(", smallImageId=");
		sb.append(getSmallImageId());
		sb.append(", imageDimension=");
		sb.append(getImageDimension());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.Image");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUuId</column-name><column-value><![CDATA[");
		sb.append(getImageUuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageDesc</column-name><column-value><![CDATA[");
		sb.append(getImageDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageSize</column-name><column-value><![CDATA[");
		sb.append(getImageSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageType</column-name><column-value><![CDATA[");
		sb.append(getImageType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>smallImageId</column-name><column-value><![CDATA[");
		sb.append(getSmallImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageDimension</column-name><column-value><![CDATA[");
		sb.append(getImageDimension());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedDate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _imageRemoteModel;
}