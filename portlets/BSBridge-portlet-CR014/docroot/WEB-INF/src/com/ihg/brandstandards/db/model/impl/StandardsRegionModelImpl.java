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

import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.model.StandardsRegionModel;

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
 * The base model implementation for the StandardsRegion service. Represents a row in the &quot;BRNDSTND_RGN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.StandardsRegionModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StandardsRegionImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionImpl
 * @see com.ihg.brandstandards.db.model.StandardsRegion
 * @see com.ihg.brandstandards.db.model.StandardsRegionModel
 * @generated
 */
public class StandardsRegionModelImpl extends BaseModelImpl<StandardsRegion>
	implements StandardsRegionModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a standards region model instance should use the {@link com.ihg.brandstandards.db.model.StandardsRegion} interface instead.
	 */
	public static final String TABLE_NAME = "BRNDSTND_RGN";
	public static final Object[][] TABLE_COLUMNS = {
			{ "RGN_ID", Types.BIGINT },
			{ "RGN_CD", Types.VARCHAR },
			{ "RGN_TYP_CD", Types.VARCHAR },
			{ "RGN_NM", Types.VARCHAR },
			{ "ACTV_IND", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table BRNDSTND_RGN (RGN_ID LONG not null primary key,RGN_CD VARCHAR(75) null,RGN_TYP_CD VARCHAR(75) null,RGN_NM VARCHAR(75) null,ACTV_IND VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table BRNDSTND_RGN";
	public static final String ORDER_BY_JPQL = " ORDER BY standardsRegion.regionId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY BRNDSTND_RGN.RGN_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.StandardsRegion"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.StandardsRegion"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.StandardsRegion"),
			true);
	public static long REGIONCODE_COLUMN_BITMASK = 1L;
	public static long REGIONID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.StandardsRegion"));

	public StandardsRegionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _regionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRegionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _regionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsRegion.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsRegion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("regionId", getRegionId());
		attributes.put("regionCode", getRegionCode());
		attributes.put("regionType", getRegionType());
		attributes.put("regionName", getRegionName());
		attributes.put("isActive", getIsActive());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String regionType = (String)attributes.get("regionType");

		if (regionType != null) {
			setRegionType(regionType);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}

		String isActive = (String)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
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
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_columnBitmask |= REGIONID_COLUMN_BITMASK;

		if (!_setOriginalRegionId) {
			_setOriginalRegionId = true;

			_originalRegionId = _regionId;
		}

		_regionId = regionId;
	}

	public long getOriginalRegionId() {
		return _originalRegionId;
	}

	@Override
	public String getRegionCode() {
		if (_regionCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _regionCode;
		}
	}

	@Override
	public void setRegionCode(String regionCode) {
		_columnBitmask |= REGIONCODE_COLUMN_BITMASK;

		if (_originalRegionCode == null) {
			_originalRegionCode = _regionCode;
		}

		_regionCode = regionCode;
	}

	public String getOriginalRegionCode() {
		return GetterUtil.getString(_originalRegionCode);
	}

	@Override
	public String getRegionType() {
		if (_regionType == null) {
			return StringPool.BLANK;
		}
		else {
			return _regionType;
		}
	}

	@Override
	public void setRegionType(String regionType) {
		_regionType = regionType;
	}

	@Override
	public String getRegionName() {
		if (_regionName == null) {
			return StringPool.BLANK;
		}
		else {
			return _regionName;
		}
	}

	@Override
	public void setRegionName(String regionName) {
		_regionName = regionName;
	}

	@Override
	public String getIsActive() {
		if (_isActive == null) {
			return StringPool.BLANK;
		}
		else {
			return _isActive;
		}
	}

	@Override
	public void setIsActive(String isActive) {
		_isActive = isActive;
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
			StandardsRegion.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StandardsRegion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StandardsRegion)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StandardsRegionImpl standardsRegionImpl = new StandardsRegionImpl();

		standardsRegionImpl.setRegionId(getRegionId());
		standardsRegionImpl.setRegionCode(getRegionCode());
		standardsRegionImpl.setRegionType(getRegionType());
		standardsRegionImpl.setRegionName(getRegionName());
		standardsRegionImpl.setIsActive(getIsActive());
		standardsRegionImpl.setCreatorId(getCreatorId());
		standardsRegionImpl.setCreatedDate(getCreatedDate());
		standardsRegionImpl.setUpdatedBy(getUpdatedBy());
		standardsRegionImpl.setUpdatedDate(getUpdatedDate());

		standardsRegionImpl.resetOriginalValues();

		return standardsRegionImpl;
	}

	@Override
	public int compareTo(StandardsRegion standardsRegion) {
		long primaryKey = standardsRegion.getPrimaryKey();

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

		if (!(obj instanceof StandardsRegion)) {
			return false;
		}

		StandardsRegion standardsRegion = (StandardsRegion)obj;

		long primaryKey = standardsRegion.getPrimaryKey();

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
		StandardsRegionModelImpl standardsRegionModelImpl = this;

		standardsRegionModelImpl._originalRegionId = standardsRegionModelImpl._regionId;

		standardsRegionModelImpl._setOriginalRegionId = false;

		standardsRegionModelImpl._originalRegionCode = standardsRegionModelImpl._regionCode;

		standardsRegionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StandardsRegion> toCacheModel() {
		StandardsRegionCacheModel standardsRegionCacheModel = new StandardsRegionCacheModel();

		standardsRegionCacheModel.regionId = getRegionId();

		standardsRegionCacheModel.regionCode = getRegionCode();

		String regionCode = standardsRegionCacheModel.regionCode;

		if ((regionCode != null) && (regionCode.length() == 0)) {
			standardsRegionCacheModel.regionCode = null;
		}

		standardsRegionCacheModel.regionType = getRegionType();

		String regionType = standardsRegionCacheModel.regionType;

		if ((regionType != null) && (regionType.length() == 0)) {
			standardsRegionCacheModel.regionType = null;
		}

		standardsRegionCacheModel.regionName = getRegionName();

		String regionName = standardsRegionCacheModel.regionName;

		if ((regionName != null) && (regionName.length() == 0)) {
			standardsRegionCacheModel.regionName = null;
		}

		standardsRegionCacheModel.isActive = getIsActive();

		String isActive = standardsRegionCacheModel.isActive;

		if ((isActive != null) && (isActive.length() == 0)) {
			standardsRegionCacheModel.isActive = null;
		}

		standardsRegionCacheModel.creatorId = getCreatorId();

		String creatorId = standardsRegionCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			standardsRegionCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			standardsRegionCacheModel.createdDate = createdDate.getTime();
		}
		else {
			standardsRegionCacheModel.createdDate = Long.MIN_VALUE;
		}

		standardsRegionCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = standardsRegionCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			standardsRegionCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			standardsRegionCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			standardsRegionCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return standardsRegionCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{regionId=");
		sb.append(getRegionId());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", regionType=");
		sb.append(getRegionType());
		sb.append(", regionName=");
		sb.append(getRegionName());
		sb.append(", isActive=");
		sb.append(getIsActive());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsRegion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionType</column-name><column-value><![CDATA[");
		sb.append(getRegionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionName</column-name><column-value><![CDATA[");
		sb.append(getRegionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
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

	private static ClassLoader _classLoader = StandardsRegion.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StandardsRegion.class
		};
	private long _regionId;
	private long _originalRegionId;
	private boolean _setOriginalRegionId;
	private String _regionCode;
	private String _originalRegionCode;
	private String _regionType;
	private String _regionName;
	private String _isActive;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private StandardsRegion _escapedModel;
}