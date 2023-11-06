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

import com.ihg.brandstandards.db.model.GEMManagementBucket;
import com.ihg.brandstandards.db.model.GEMManagementBucketModel;

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
 * The base model implementation for the GEMManagementBucket service. Represents a row in the &quot;GEM_MGT_BUCKET&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.GEMManagementBucketModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GEMManagementBucketImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMManagementBucketImpl
 * @see com.ihg.brandstandards.db.model.GEMManagementBucket
 * @see com.ihg.brandstandards.db.model.GEMManagementBucketModel
 * @generated
 */
public class GEMManagementBucketModelImpl extends BaseModelImpl<GEMManagementBucket>
	implements GEMManagementBucketModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a g e m management bucket model instance should use the {@link com.ihg.brandstandards.db.model.GEMManagementBucket} interface instead.
	 */
	public static final String TABLE_NAME = "GEM_MGT_BUCKET";
	public static final Object[][] TABLE_COLUMNS = {
			{ "GEM_MGT_BUCKET_ID", Types.BIGINT },
			{ "GEM_BUCKET_NM", Types.VARCHAR },
			{ "GEM_DEPT_ID", Types.BIGINT },
			{ "ACTV_IND", Types.VARCHAR },
			{ "DISP_ORDER_NBR", Types.BIGINT },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table GEM_MGT_BUCKET (GEM_MGT_BUCKET_ID LONG not null primary key,GEM_BUCKET_NM VARCHAR(75) null,GEM_DEPT_ID LONG,ACTV_IND VARCHAR(75) null,DISP_ORDER_NBR LONG,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table GEM_MGT_BUCKET";
	public static final String ORDER_BY_JPQL = " ORDER BY gemManagementBucket.displayOrderNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GEM_MGT_BUCKET.DISP_ORDER_NBR ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.GEMManagementBucket"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.GEMManagementBucket"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.GEMManagementBucket"),
			true);
	public static long ACTIVEIND_COLUMN_BITMASK = 1L;
	public static long DEPARTMENTID_COLUMN_BITMASK = 2L;
	public static long DISPLAYORDERNUMBER_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.GEMManagementBucket"));

	public GEMManagementBucketModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _bucketId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBucketId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bucketId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GEMManagementBucket.class;
	}

	@Override
	public String getModelClassName() {
		return GEMManagementBucket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bucketId", getBucketId());
		attributes.put("bucketName", getBucketName());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("activeInd", getActiveInd());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bucketId = (Long)attributes.get("bucketId");

		if (bucketId != null) {
			setBucketId(bucketId);
		}

		String bucketName = (String)attributes.get("bucketName");

		if (bucketName != null) {
			setBucketName(bucketName);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
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
	public long getBucketId() {
		return _bucketId;
	}

	@Override
	public void setBucketId(long bucketId) {
		_bucketId = bucketId;
	}

	@Override
	public String getBucketName() {
		if (_bucketName == null) {
			return StringPool.BLANK;
		}
		else {
			return _bucketName;
		}
	}

	@Override
	public void setBucketName(String bucketName) {
		_bucketName = bucketName;
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_columnBitmask |= DEPARTMENTID_COLUMN_BITMASK;

		if (!_setOriginalDepartmentId) {
			_setOriginalDepartmentId = true;

			_originalDepartmentId = _departmentId;
		}

		_departmentId = departmentId;
	}

	public long getOriginalDepartmentId() {
		return _originalDepartmentId;
	}

	@Override
	public String getActiveInd() {
		if (_activeInd == null) {
			return StringPool.BLANK;
		}
		else {
			return _activeInd;
		}
	}

	@Override
	public void setActiveInd(String activeInd) {
		_columnBitmask |= ACTIVEIND_COLUMN_BITMASK;

		if (_originalActiveInd == null) {
			_originalActiveInd = _activeInd;
		}

		_activeInd = activeInd;
	}

	public String getOriginalActiveInd() {
		return GetterUtil.getString(_originalActiveInd);
	}

	@Override
	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_columnBitmask = -1L;

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
			GEMManagementBucket.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GEMManagementBucket toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (GEMManagementBucket)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GEMManagementBucketImpl gemManagementBucketImpl = new GEMManagementBucketImpl();

		gemManagementBucketImpl.setBucketId(getBucketId());
		gemManagementBucketImpl.setBucketName(getBucketName());
		gemManagementBucketImpl.setDepartmentId(getDepartmentId());
		gemManagementBucketImpl.setActiveInd(getActiveInd());
		gemManagementBucketImpl.setDisplayOrderNumber(getDisplayOrderNumber());
		gemManagementBucketImpl.setCreatorId(getCreatorId());
		gemManagementBucketImpl.setCreatedDate(getCreatedDate());
		gemManagementBucketImpl.setUpdatedBy(getUpdatedBy());
		gemManagementBucketImpl.setUpdatedDate(getUpdatedDate());

		gemManagementBucketImpl.resetOriginalValues();

		return gemManagementBucketImpl;
	}

	@Override
	public int compareTo(GEMManagementBucket gemManagementBucket) {
		int value = 0;

		if (getDisplayOrderNumber() < gemManagementBucket.getDisplayOrderNumber()) {
			value = -1;
		}
		else if (getDisplayOrderNumber() > gemManagementBucket.getDisplayOrderNumber()) {
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

		if (!(obj instanceof GEMManagementBucket)) {
			return false;
		}

		GEMManagementBucket gemManagementBucket = (GEMManagementBucket)obj;

		long primaryKey = gemManagementBucket.getPrimaryKey();

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
		GEMManagementBucketModelImpl gemManagementBucketModelImpl = this;

		gemManagementBucketModelImpl._originalDepartmentId = gemManagementBucketModelImpl._departmentId;

		gemManagementBucketModelImpl._setOriginalDepartmentId = false;

		gemManagementBucketModelImpl._originalActiveInd = gemManagementBucketModelImpl._activeInd;

		gemManagementBucketModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GEMManagementBucket> toCacheModel() {
		GEMManagementBucketCacheModel gemManagementBucketCacheModel = new GEMManagementBucketCacheModel();

		gemManagementBucketCacheModel.bucketId = getBucketId();

		gemManagementBucketCacheModel.bucketName = getBucketName();

		String bucketName = gemManagementBucketCacheModel.bucketName;

		if ((bucketName != null) && (bucketName.length() == 0)) {
			gemManagementBucketCacheModel.bucketName = null;
		}

		gemManagementBucketCacheModel.departmentId = getDepartmentId();

		gemManagementBucketCacheModel.activeInd = getActiveInd();

		String activeInd = gemManagementBucketCacheModel.activeInd;

		if ((activeInd != null) && (activeInd.length() == 0)) {
			gemManagementBucketCacheModel.activeInd = null;
		}

		gemManagementBucketCacheModel.displayOrderNumber = getDisplayOrderNumber();

		gemManagementBucketCacheModel.creatorId = getCreatorId();

		String creatorId = gemManagementBucketCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			gemManagementBucketCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			gemManagementBucketCacheModel.createdDate = createdDate.getTime();
		}
		else {
			gemManagementBucketCacheModel.createdDate = Long.MIN_VALUE;
		}

		gemManagementBucketCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = gemManagementBucketCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			gemManagementBucketCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			gemManagementBucketCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			gemManagementBucketCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return gemManagementBucketCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{bucketId=");
		sb.append(getBucketId());
		sb.append(", bucketName=");
		sb.append(getBucketName());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", activeInd=");
		sb.append(getActiveInd());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMManagementBucket");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bucketId</column-name><column-value><![CDATA[");
		sb.append(getBucketId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bucketName</column-name><column-value><![CDATA[");
		sb.append(getBucketName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeInd</column-name><column-value><![CDATA[");
		sb.append(getActiveInd());
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

	private static ClassLoader _classLoader = GEMManagementBucket.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			GEMManagementBucket.class
		};
	private long _bucketId;
	private String _bucketName;
	private long _departmentId;
	private long _originalDepartmentId;
	private boolean _setOriginalDepartmentId;
	private String _activeInd;
	private String _originalActiveInd;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private GEMManagementBucket _escapedModel;
}