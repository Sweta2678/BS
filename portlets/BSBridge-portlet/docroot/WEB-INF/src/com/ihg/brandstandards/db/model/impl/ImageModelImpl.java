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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.Image;
import com.ihg.brandstandards.db.model.ImageModel;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Image service. Represents a row in the &quot;IMAGE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.ImageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ImageImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see ImageImpl
 * @see com.ihg.brandstandards.db.model.Image
 * @see com.ihg.brandstandards.db.model.ImageModel
 * @generated
 */
public class ImageModelImpl extends BaseModelImpl<Image> implements ImageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a image model instance should use the {@link com.ihg.brandstandards.db.model.Image} interface instead.
	 */
	public static final String TABLE_NAME = "IMAGE";
	public static final Object[][] TABLE_COLUMNS = {
			{ "IMAGE_ID", Types.BIGINT },
			{ "IMAGE_UUID", Types.VARCHAR },
			{ "IMAGE_DESC", Types.VARCHAR },
			{ "IMAGE_TITLE_TXT", Types.VARCHAR },
			{ "IMAGE_SIZE_KILOBYTE_QTY", Types.VARCHAR },
			{ "IMAGE_TYP", Types.VARCHAR },
			{ "SMALL_IMAGE_ID", Types.VARCHAR },
			{ "IMAGE_DIM_TXT", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table IMAGE (IMAGE_ID LONG not null primary key,IMAGE_UUID VARCHAR(75) null,IMAGE_DESC VARCHAR(75) null,IMAGE_TITLE_TXT VARCHAR(75) null,IMAGE_SIZE_KILOBYTE_QTY VARCHAR(75) null,IMAGE_TYP VARCHAR(75) null,SMALL_IMAGE_ID VARCHAR(75) null,IMAGE_DIM_TXT VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table IMAGE";
	public static final String ORDER_BY_JPQL = " ORDER BY image.imageId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY IMAGE.IMAGE_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.Image"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.Image"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.Image"));

	public ImageModelImpl() {
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

	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	@Override
	public String getImageUuId() {
		if (_imageUuId == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageUuId;
		}
	}

	@Override
	public void setImageUuId(String imageUuId) {
		_imageUuId = imageUuId;
	}

	@Override
	public String getImageDesc() {
		if (_imageDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageDesc;
		}
	}

	@Override
	public void setImageDesc(String imageDesc) {
		_imageDesc = imageDesc;
	}

	@Override
	public String getImageTitle() {
		if (_imageTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageTitle;
		}
	}

	@Override
	public void setImageTitle(String imageTitle) {
		_imageTitle = imageTitle;
	}

	@Override
	public String getImageSize() {
		if (_imageSize == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageSize;
		}
	}

	@Override
	public void setImageSize(String imageSize) {
		_imageSize = imageSize;
	}

	@Override
	public String getImageType() {
		if (_imageType == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageType;
		}
	}

	@Override
	public void setImageType(String imageType) {
		_imageType = imageType;
	}

	@Override
	public String getSmallImageId() {
		if (_smallImageId == null) {
			return StringPool.BLANK;
		}
		else {
			return _smallImageId;
		}
	}

	@Override
	public void setSmallImageId(String smallImageId) {
		_smallImageId = smallImageId;
	}

	@Override
	public String getImageDimension() {
		if (_imageDimension == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageDimension;
		}
	}

	@Override
	public void setImageDimension(String imageDimension) {
		_imageDimension = imageDimension;
	}

	@Override
	public String getCreatorId() {
		if (_creatorId == null) {
			return StringPool.BLANK;
		}
		else {
			return _creatorId;
		}
	}

	@Override
	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@Override
	public String getUpdatedBy() {
		if (_updatedBy == null) {
			return StringPool.BLANK;
		}
		else {
			return _updatedBy;
		}
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Image.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Image toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Image)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ImageImpl imageImpl = new ImageImpl();

		imageImpl.setImageId(getImageId());
		imageImpl.setImageUuId(getImageUuId());
		imageImpl.setImageDesc(getImageDesc());
		imageImpl.setImageTitle(getImageTitle());
		imageImpl.setImageSize(getImageSize());
		imageImpl.setImageType(getImageType());
		imageImpl.setSmallImageId(getSmallImageId());
		imageImpl.setImageDimension(getImageDimension());
		imageImpl.setCreatorId(getCreatorId());
		imageImpl.setCreatedDate(getCreatedDate());
		imageImpl.setUpdatedBy(getUpdatedBy());
		imageImpl.setUpdatedDate(getUpdatedDate());

		imageImpl.resetOriginalValues();

		return imageImpl;
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

		if (!(obj instanceof Image)) {
			return false;
		}

		Image image = (Image)obj;

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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Image> toCacheModel() {
		ImageCacheModel imageCacheModel = new ImageCacheModel();

		imageCacheModel.imageId = getImageId();

		imageCacheModel.imageUuId = getImageUuId();

		String imageUuId = imageCacheModel.imageUuId;

		if ((imageUuId != null) && (imageUuId.length() == 0)) {
			imageCacheModel.imageUuId = null;
		}

		imageCacheModel.imageDesc = getImageDesc();

		String imageDesc = imageCacheModel.imageDesc;

		if ((imageDesc != null) && (imageDesc.length() == 0)) {
			imageCacheModel.imageDesc = null;
		}

		imageCacheModel.imageTitle = getImageTitle();

		String imageTitle = imageCacheModel.imageTitle;

		if ((imageTitle != null) && (imageTitle.length() == 0)) {
			imageCacheModel.imageTitle = null;
		}

		imageCacheModel.imageSize = getImageSize();

		String imageSize = imageCacheModel.imageSize;

		if ((imageSize != null) && (imageSize.length() == 0)) {
			imageCacheModel.imageSize = null;
		}

		imageCacheModel.imageType = getImageType();

		String imageType = imageCacheModel.imageType;

		if ((imageType != null) && (imageType.length() == 0)) {
			imageCacheModel.imageType = null;
		}

		imageCacheModel.smallImageId = getSmallImageId();

		String smallImageId = imageCacheModel.smallImageId;

		if ((smallImageId != null) && (smallImageId.length() == 0)) {
			imageCacheModel.smallImageId = null;
		}

		imageCacheModel.imageDimension = getImageDimension();

		String imageDimension = imageCacheModel.imageDimension;

		if ((imageDimension != null) && (imageDimension.length() == 0)) {
			imageCacheModel.imageDimension = null;
		}

		imageCacheModel.creatorId = getCreatorId();

		String creatorId = imageCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			imageCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			imageCacheModel.createdDate = createdDate.getTime();
		}
		else {
			imageCacheModel.createdDate = Long.MIN_VALUE;
		}

		imageCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = imageCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			imageCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			imageCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			imageCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return imageCacheModel;
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

	private static ClassLoader _classLoader = Image.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Image.class };
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
	private Image _escapedModel;
}