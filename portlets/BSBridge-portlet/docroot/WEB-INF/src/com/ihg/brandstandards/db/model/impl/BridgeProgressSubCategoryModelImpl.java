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

import com.ihg.brandstandards.db.model.BridgeProgressSubCategory;
import com.ihg.brandstandards.db.model.BridgeProgressSubCategoryModel;

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
 * The base model implementation for the BridgeProgressSubCategory service. Represents a row in the &quot;BRIDGE_PUBLISH_PROGRESS_SUBCAT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.BridgeProgressSubCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BridgeProgressSubCategoryImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressSubCategoryImpl
 * @see com.ihg.brandstandards.db.model.BridgeProgressSubCategory
 * @see com.ihg.brandstandards.db.model.BridgeProgressSubCategoryModel
 * @generated
 */
public class BridgeProgressSubCategoryModelImpl extends BaseModelImpl<BridgeProgressSubCategory>
	implements BridgeProgressSubCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bridge progress sub category model instance should use the {@link com.ihg.brandstandards.db.model.BridgeProgressSubCategory} interface instead.
	 */
	public static final String TABLE_NAME = "BRIDGE_PUBLISH_PROGRESS_SUBCAT";
	public static final Object[][] TABLE_COLUMNS = {
			{ "BRIDGE_PUB_PROGRESS_SUBCAT_ID", Types.BIGINT },
			{ "BRIDGE_PUB_PROGRESS_CATGY_ID", Types.BIGINT },
			{ "BRIDGE_PUB_PROGRESS_SUBCAT_NM", Types.VARCHAR },
			{ "DISP_ORDER_NBR", Types.BIGINT },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table BRIDGE_PUBLISH_PROGRESS_SUBCAT (BRIDGE_PUB_PROGRESS_SUBCAT_ID LONG not null primary key,BRIDGE_PUB_PROGRESS_CATGY_ID LONG,BRIDGE_PUB_PROGRESS_SUBCAT_NM VARCHAR(75) null,DISP_ORDER_NBR LONG,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table BRIDGE_PUBLISH_PROGRESS_SUBCAT";
	public static final String ORDER_BY_JPQL = " ORDER BY bridgeProgressSubCategory.progressSubCategoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY BRIDGE_PUBLISH_PROGRESS_SUBCAT.BRIDGE_PUB_PROGRESS_SUBCAT_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.BridgeProgressSubCategory"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.BridgeProgressSubCategory"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.BridgeProgressSubCategory"),
			true);
	public static long PROGRESSCATEGORYID_COLUMN_BITMASK = 1L;
	public static long PROGRESSSUBCATEGORYID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.BridgeProgressSubCategory"));

	public BridgeProgressSubCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _progressSubCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProgressSubCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _progressSubCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeProgressSubCategory.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeProgressSubCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("progressSubCategoryId", getProgressSubCategoryId());
		attributes.put("progressCategoryId", getProgressCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long progressSubCategoryId = (Long)attributes.get(
				"progressSubCategoryId");

		if (progressSubCategoryId != null) {
			setProgressSubCategoryId(progressSubCategoryId);
		}

		Long progressCategoryId = (Long)attributes.get("progressCategoryId");

		if (progressCategoryId != null) {
			setProgressCategoryId(progressCategoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
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
	public long getProgressSubCategoryId() {
		return _progressSubCategoryId;
	}

	@Override
	public void setProgressSubCategoryId(long progressSubCategoryId) {
		_columnBitmask |= PROGRESSSUBCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalProgressSubCategoryId) {
			_setOriginalProgressSubCategoryId = true;

			_originalProgressSubCategoryId = _progressSubCategoryId;
		}

		_progressSubCategoryId = progressSubCategoryId;
	}

	public long getOriginalProgressSubCategoryId() {
		return _originalProgressSubCategoryId;
	}

	@Override
	public long getProgressCategoryId() {
		return _progressCategoryId;
	}

	@Override
	public void setProgressCategoryId(long progressCategoryId) {
		_columnBitmask |= PROGRESSCATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalProgressCategoryId) {
			_setOriginalProgressCategoryId = true;

			_originalProgressCategoryId = _progressCategoryId;
		}

		_progressCategoryId = progressCategoryId;
	}

	public long getOriginalProgressCategoryId() {
		return _originalProgressCategoryId;
	}

	@Override
	public String getCategoryName() {
		if (_categoryName == null) {
			return StringPool.BLANK;
		}
		else {
			return _categoryName;
		}
	}

	@Override
	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
	}

	@Override
	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;
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
			BridgeProgressSubCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BridgeProgressSubCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BridgeProgressSubCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BridgeProgressSubCategoryImpl bridgeProgressSubCategoryImpl = new BridgeProgressSubCategoryImpl();

		bridgeProgressSubCategoryImpl.setProgressSubCategoryId(getProgressSubCategoryId());
		bridgeProgressSubCategoryImpl.setProgressCategoryId(getProgressCategoryId());
		bridgeProgressSubCategoryImpl.setCategoryName(getCategoryName());
		bridgeProgressSubCategoryImpl.setDisplayOrderNumber(getDisplayOrderNumber());
		bridgeProgressSubCategoryImpl.setCreatorId(getCreatorId());
		bridgeProgressSubCategoryImpl.setCreatedDate(getCreatedDate());
		bridgeProgressSubCategoryImpl.setUpdatedBy(getUpdatedBy());
		bridgeProgressSubCategoryImpl.setUpdatedDate(getUpdatedDate());

		bridgeProgressSubCategoryImpl.resetOriginalValues();

		return bridgeProgressSubCategoryImpl;
	}

	@Override
	public int compareTo(BridgeProgressSubCategory bridgeProgressSubCategory) {
		long primaryKey = bridgeProgressSubCategory.getPrimaryKey();

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

		if (!(obj instanceof BridgeProgressSubCategory)) {
			return false;
		}

		BridgeProgressSubCategory bridgeProgressSubCategory = (BridgeProgressSubCategory)obj;

		long primaryKey = bridgeProgressSubCategory.getPrimaryKey();

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
		BridgeProgressSubCategoryModelImpl bridgeProgressSubCategoryModelImpl = this;

		bridgeProgressSubCategoryModelImpl._originalProgressSubCategoryId = bridgeProgressSubCategoryModelImpl._progressSubCategoryId;

		bridgeProgressSubCategoryModelImpl._setOriginalProgressSubCategoryId = false;

		bridgeProgressSubCategoryModelImpl._originalProgressCategoryId = bridgeProgressSubCategoryModelImpl._progressCategoryId;

		bridgeProgressSubCategoryModelImpl._setOriginalProgressCategoryId = false;

		bridgeProgressSubCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BridgeProgressSubCategory> toCacheModel() {
		BridgeProgressSubCategoryCacheModel bridgeProgressSubCategoryCacheModel = new BridgeProgressSubCategoryCacheModel();

		bridgeProgressSubCategoryCacheModel.progressSubCategoryId = getProgressSubCategoryId();

		bridgeProgressSubCategoryCacheModel.progressCategoryId = getProgressCategoryId();

		bridgeProgressSubCategoryCacheModel.categoryName = getCategoryName();

		String categoryName = bridgeProgressSubCategoryCacheModel.categoryName;

		if ((categoryName != null) && (categoryName.length() == 0)) {
			bridgeProgressSubCategoryCacheModel.categoryName = null;
		}

		bridgeProgressSubCategoryCacheModel.displayOrderNumber = getDisplayOrderNumber();

		bridgeProgressSubCategoryCacheModel.creatorId = getCreatorId();

		String creatorId = bridgeProgressSubCategoryCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			bridgeProgressSubCategoryCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			bridgeProgressSubCategoryCacheModel.createdDate = createdDate.getTime();
		}
		else {
			bridgeProgressSubCategoryCacheModel.createdDate = Long.MIN_VALUE;
		}

		bridgeProgressSubCategoryCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = bridgeProgressSubCategoryCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			bridgeProgressSubCategoryCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			bridgeProgressSubCategoryCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			bridgeProgressSubCategoryCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return bridgeProgressSubCategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{progressSubCategoryId=");
		sb.append(getProgressSubCategoryId());
		sb.append(", progressCategoryId=");
		sb.append(getProgressCategoryId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgeProgressSubCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>progressSubCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProgressSubCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProgressCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
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

	private static ClassLoader _classLoader = BridgeProgressSubCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BridgeProgressSubCategory.class
		};
	private long _progressSubCategoryId;
	private long _originalProgressSubCategoryId;
	private boolean _setOriginalProgressSubCategoryId;
	private long _progressCategoryId;
	private long _originalProgressCategoryId;
	private boolean _setOriginalProgressCategoryId;
	private String _categoryName;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private BridgeProgressSubCategory _escapedModel;
}