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
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;

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
public class StandardsImagesClp extends BaseModelImpl<StandardsImages>
	implements StandardsImages {
	public StandardsImagesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsImages.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsImages.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stdImageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdImageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdImageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdImageId", getStdImageId());
		attributes.put("parentImageId", getParentImageId());
		attributes.put("imageId", getImageId());
		attributes.put("stdId", getStdId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("imageTitle", getImageTitle());
		attributes.put("imageSortOrder", getImageSortOrder());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdImageId = (Long)attributes.get("stdImageId");

		if (stdImageId != null) {
			setStdImageId(stdImageId);
		}

		Long parentImageId = (Long)attributes.get("parentImageId");

		if (parentImageId != null) {
			setParentImageId(parentImageId);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String imageTitle = (String)attributes.get("imageTitle");

		if (imageTitle != null) {
			setImageTitle(imageTitle);
		}

		Long imageSortOrder = (Long)attributes.get("imageSortOrder");

		if (imageSortOrder != null) {
			setImageSortOrder(imageSortOrder);
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
	public long getStdImageId() {
		return _stdImageId;
	}

	@Override
	public void setStdImageId(long stdImageId) {
		_stdImageId = stdImageId;

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setStdImageId", long.class);

				method.invoke(_standardsImagesRemoteModel, stdImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentImageId() {
		return _parentImageId;
	}

	@Override
	public void setParentImageId(long parentImageId) {
		_parentImageId = parentImageId;

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setParentImageId", long.class);

				method.invoke(_standardsImagesRemoteModel, parentImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_imageId = imageId;

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setImageId", long.class);

				method.invoke(_standardsImagesRemoteModel, imageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsImagesRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocaleCode() {
		return _localeCode;
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_standardsImagesRemoteModel, localeCode);
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

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setImageTitle", String.class);

				method.invoke(_standardsImagesRemoteModel, imageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageSortOrder() {
		return _imageSortOrder;
	}

	@Override
	public void setImageSortOrder(long imageSortOrder) {
		_imageSortOrder = imageSortOrder;

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setImageSortOrder", long.class);

				method.invoke(_standardsImagesRemoteModel, imageSortOrder);
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

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsImagesRemoteModel, creatorId);
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

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsImagesRemoteModel, createdDate);
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

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsImagesRemoteModel, updatedBy);
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

		if (_standardsImagesRemoteModel != null) {
			try {
				Class<?> clazz = _standardsImagesRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsImagesRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsTranslationExist() {
		try {
			String methodName = "getIsTranslationExist";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.ihg.brandstandards.db.model.Image getImage() {
		try {
			String methodName = "getImage";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.ihg.brandstandards.db.model.Image returnObj = (com.ihg.brandstandards.db.model.Image)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public com.ihg.brandstandards.db.model.Image getDBImage() {
		try {
			String methodName = "getDBImage";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			com.ihg.brandstandards.db.model.Image returnObj = (com.ihg.brandstandards.db.model.Image)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setImage(com.ihg.brandstandards.db.model.Image image) {
		try {
			String methodName = "setImage";

			Class<?>[] parameterTypes = new Class<?>[] {
					com.ihg.brandstandards.db.model.Image.class
				};

			Object[] parameterValues = new Object[] { image };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setIsTranslationExist(boolean isTranslationExist) {
		try {
			String methodName = "setIsTranslationExist";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { isTranslationExist };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getStandardsImagesRemoteModel() {
		return _standardsImagesRemoteModel;
	}

	public void setStandardsImagesRemoteModel(
		BaseModel<?> standardsImagesRemoteModel) {
		_standardsImagesRemoteModel = standardsImagesRemoteModel;
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

		Class<?> remoteModelClass = _standardsImagesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsImagesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsImagesLocalServiceUtil.addStandardsImages(this);
		}
		else {
			StandardsImagesLocalServiceUtil.updateStandardsImages(this);
		}
	}

	@Override
	public StandardsImages toEscapedModel() {
		return (StandardsImages)ProxyUtil.newProxyInstance(StandardsImages.class.getClassLoader(),
			new Class[] { StandardsImages.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsImagesClp clone = new StandardsImagesClp();

		clone.setStdImageId(getStdImageId());
		clone.setParentImageId(getParentImageId());
		clone.setImageId(getImageId());
		clone.setStdId(getStdId());
		clone.setLocaleCode(getLocaleCode());
		clone.setImageTitle(getImageTitle());
		clone.setImageSortOrder(getImageSortOrder());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsImages standardsImages) {
		int value = 0;

		if (getImageSortOrder() < standardsImages.getImageSortOrder()) {
			value = -1;
		}
		else if (getImageSortOrder() > standardsImages.getImageSortOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsImagesClp)) {
			return false;
		}

		StandardsImagesClp standardsImages = (StandardsImagesClp)obj;

		long primaryKey = standardsImages.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{stdImageId=");
		sb.append(getStdImageId());
		sb.append(", parentImageId=");
		sb.append(getParentImageId());
		sb.append(", imageId=");
		sb.append(getImageId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
		sb.append(", imageTitle=");
		sb.append(getImageTitle());
		sb.append(", imageSortOrder=");
		sb.append(getImageSortOrder());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsImages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdImageId</column-name><column-value><![CDATA[");
		sb.append(getStdImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentImageId</column-name><column-value><![CDATA[");
		sb.append(getParentImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageId</column-name><column-value><![CDATA[");
		sb.append(getImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageTitle</column-name><column-value><![CDATA[");
		sb.append(getImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageSortOrder</column-name><column-value><![CDATA[");
		sb.append(getImageSortOrder());
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
	private BaseModel<?> _standardsImagesRemoteModel;
}