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

import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.StandardsImagesModel;

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
 * The base model implementation for the StandardsImages service. Represents a row in the &quot;STD_IMAGE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.StandardsImagesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StandardsImagesImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsImagesImpl
 * @see com.ihg.brandstandards.db.model.StandardsImages
 * @see com.ihg.brandstandards.db.model.StandardsImagesModel
 * @generated
 */
public class StandardsImagesModelImpl extends BaseModelImpl<StandardsImages>
	implements StandardsImagesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a standards images model instance should use the {@link com.ihg.brandstandards.db.model.StandardsImages} interface instead.
	 */
	public static final String TABLE_NAME = "STD_IMAGE";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_IMAGE_ID", Types.BIGINT },
			{ "PRNT_STD_IMAGE_ID", Types.BIGINT },
			{ "IMAGE_ID", Types.BIGINT },
			{ "STD_ID", Types.BIGINT },
			{ "LOCALE_CD", Types.VARCHAR },
			{ "IMAGE_TITLE_TXT", Types.VARCHAR },
			{ "SORT_ORDER_NBR", Types.BIGINT },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_IMAGE (STD_IMAGE_ID LONG not null primary key,PRNT_STD_IMAGE_ID LONG,IMAGE_ID LONG,STD_ID LONG,LOCALE_CD VARCHAR(75) null,IMAGE_TITLE_TXT VARCHAR(75) null,SORT_ORDER_NBR LONG,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table STD_IMAGE";
	public static final String ORDER_BY_JPQL = " ORDER BY standardsImages.imageSortOrder ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_IMAGE.SORT_ORDER_NBR ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.StandardsImages"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.StandardsImages"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.StandardsImages"),
			true);
	public static long IMAGEID_COLUMN_BITMASK = 1L;
	public static long LOCALECODE_COLUMN_BITMASK = 2L;
	public static long PARENTIMAGEID_COLUMN_BITMASK = 4L;
	public static long STDID_COLUMN_BITMASK = 8L;
	public static long IMAGESORTORDER_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.StandardsImages"));

	public StandardsImagesModelImpl() {
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
	public Class<?> getModelClass() {
		return StandardsImages.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsImages.class.getName();
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
	}

	@Override
	public long getParentImageId() {
		return _parentImageId;
	}

	@Override
	public void setParentImageId(long parentImageId) {
		_columnBitmask |= PARENTIMAGEID_COLUMN_BITMASK;

		if (!_setOriginalParentImageId) {
			_setOriginalParentImageId = true;

			_originalParentImageId = _parentImageId;
		}

		_parentImageId = parentImageId;
	}

	public long getOriginalParentImageId() {
		return _originalParentImageId;
	}

	@Override
	public long getImageId() {
		return _imageId;
	}

	@Override
	public void setImageId(long imageId) {
		_columnBitmask |= IMAGEID_COLUMN_BITMASK;

		if (!_setOriginalImageId) {
			_setOriginalImageId = true;

			_originalImageId = _imageId;
		}

		_imageId = imageId;
	}

	public long getOriginalImageId() {
		return _originalImageId;
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_columnBitmask |= STDID_COLUMN_BITMASK;

		if (!_setOriginalStdId) {
			_setOriginalStdId = true;

			_originalStdId = _stdId;
		}

		_stdId = stdId;
	}

	public long getOriginalStdId() {
		return _originalStdId;
	}

	@Override
	public String getLocaleCode() {
		if (_localeCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _localeCode;
		}
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_columnBitmask |= LOCALECODE_COLUMN_BITMASK;

		if (_originalLocaleCode == null) {
			_originalLocaleCode = _localeCode;
		}

		_localeCode = localeCode;
	}

	public String getOriginalLocaleCode() {
		return GetterUtil.getString(_originalLocaleCode);
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
	public long getImageSortOrder() {
		return _imageSortOrder;
	}

	@Override
	public void setImageSortOrder(long imageSortOrder) {
		_columnBitmask = -1L;

		_imageSortOrder = imageSortOrder;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			StandardsImages.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StandardsImages toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StandardsImages)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StandardsImagesImpl standardsImagesImpl = new StandardsImagesImpl();

		standardsImagesImpl.setStdImageId(getStdImageId());
		standardsImagesImpl.setParentImageId(getParentImageId());
		standardsImagesImpl.setImageId(getImageId());
		standardsImagesImpl.setStdId(getStdId());
		standardsImagesImpl.setLocaleCode(getLocaleCode());
		standardsImagesImpl.setImageTitle(getImageTitle());
		standardsImagesImpl.setImageSortOrder(getImageSortOrder());
		standardsImagesImpl.setCreatorId(getCreatorId());
		standardsImagesImpl.setCreatedDate(getCreatedDate());
		standardsImagesImpl.setUpdatedBy(getUpdatedBy());
		standardsImagesImpl.setUpdatedDate(getUpdatedDate());

		standardsImagesImpl.resetOriginalValues();

		return standardsImagesImpl;
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

		if (!(obj instanceof StandardsImages)) {
			return false;
		}

		StandardsImages standardsImages = (StandardsImages)obj;

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
	public void resetOriginalValues() {
		StandardsImagesModelImpl standardsImagesModelImpl = this;

		standardsImagesModelImpl._originalParentImageId = standardsImagesModelImpl._parentImageId;

		standardsImagesModelImpl._setOriginalParentImageId = false;

		standardsImagesModelImpl._originalImageId = standardsImagesModelImpl._imageId;

		standardsImagesModelImpl._setOriginalImageId = false;

		standardsImagesModelImpl._originalStdId = standardsImagesModelImpl._stdId;

		standardsImagesModelImpl._setOriginalStdId = false;

		standardsImagesModelImpl._originalLocaleCode = standardsImagesModelImpl._localeCode;

		standardsImagesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StandardsImages> toCacheModel() {
		StandardsImagesCacheModel standardsImagesCacheModel = new StandardsImagesCacheModel();

		standardsImagesCacheModel.stdImageId = getStdImageId();

		standardsImagesCacheModel.parentImageId = getParentImageId();

		standardsImagesCacheModel.imageId = getImageId();

		standardsImagesCacheModel.stdId = getStdId();

		standardsImagesCacheModel.localeCode = getLocaleCode();

		String localeCode = standardsImagesCacheModel.localeCode;

		if ((localeCode != null) && (localeCode.length() == 0)) {
			standardsImagesCacheModel.localeCode = null;
		}

		standardsImagesCacheModel.imageTitle = getImageTitle();

		String imageTitle = standardsImagesCacheModel.imageTitle;

		if ((imageTitle != null) && (imageTitle.length() == 0)) {
			standardsImagesCacheModel.imageTitle = null;
		}

		standardsImagesCacheModel.imageSortOrder = getImageSortOrder();

		standardsImagesCacheModel.creatorId = getCreatorId();

		String creatorId = standardsImagesCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			standardsImagesCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			standardsImagesCacheModel.createdDate = createdDate.getTime();
		}
		else {
			standardsImagesCacheModel.createdDate = Long.MIN_VALUE;
		}

		standardsImagesCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = standardsImagesCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			standardsImagesCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			standardsImagesCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			standardsImagesCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return standardsImagesCacheModel;
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

	private static ClassLoader _classLoader = StandardsImages.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StandardsImages.class
		};
	private long _stdImageId;
	private long _parentImageId;
	private long _originalParentImageId;
	private boolean _setOriginalParentImageId;
	private long _imageId;
	private long _originalImageId;
	private boolean _setOriginalImageId;
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private String _localeCode;
	private String _originalLocaleCode;
	private String _imageTitle;
	private long _imageSortOrder;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private StandardsImages _escapedModel;
}