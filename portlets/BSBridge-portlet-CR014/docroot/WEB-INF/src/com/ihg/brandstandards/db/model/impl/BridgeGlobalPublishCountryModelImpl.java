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

import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountryModel;

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
 * The base model implementation for the BridgeGlobalPublishCountry service. Represents a row in the &quot;BRIDGE_GBL_PUBLISH_CTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.BridgeGlobalPublishCountryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BridgeGlobalPublishCountryImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishCountryImpl
 * @see com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry
 * @see com.ihg.brandstandards.db.model.BridgeGlobalPublishCountryModel
 * @generated
 */
public class BridgeGlobalPublishCountryModelImpl extends BaseModelImpl<BridgeGlobalPublishCountry>
	implements BridgeGlobalPublishCountryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bridge global publish country model instance should use the {@link com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry} interface instead.
	 */
	public static final String TABLE_NAME = "BRIDGE_GBL_PUBLISH_CTRY";
	public static final Object[][] TABLE_COLUMNS = {
			{ "BRIDGE_GBL_PUBLISH_CTRY_ID", Types.BIGINT },
			{ "BRIDGE_GBL_PUBLISH_ID", Types.BIGINT },
			{ "CTRY_NM_CD", Types.VARCHAR },
			{ "PUBLISH_IND", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table BRIDGE_GBL_PUBLISH_CTRY (BRIDGE_GBL_PUBLISH_CTRY_ID LONG not null primary key,BRIDGE_GBL_PUBLISH_ID LONG,CTRY_NM_CD VARCHAR(75) null,PUBLISH_IND VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table BRIDGE_GBL_PUBLISH_CTRY";
	public static final String ORDER_BY_JPQL = " ORDER BY bridgeGlobalPublishCountry.globalPublishCtryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY BRIDGE_GBL_PUBLISH_CTRY.BRIDGE_GBL_PUBLISH_CTRY_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry"),
			true);
	public static long COUNTRYCODE_COLUMN_BITMASK = 1L;
	public static long GLOBALPUBLISHID_COLUMN_BITMASK = 2L;
	public static long GLOBALPUBLISHCTRYID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry"));

	public BridgeGlobalPublishCountryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _globalPublishCtryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlobalPublishCtryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _globalPublishCtryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeGlobalPublishCountry.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeGlobalPublishCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("globalPublishCtryId", getGlobalPublishCtryId());
		attributes.put("globalPublishId", getGlobalPublishId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("publishInd", getPublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long globalPublishCtryId = (Long)attributes.get("globalPublishCtryId");

		if (globalPublishCtryId != null) {
			setGlobalPublishCtryId(globalPublishCtryId);
		}

		Long globalPublishId = (Long)attributes.get("globalPublishId");

		if (globalPublishId != null) {
			setGlobalPublishId(globalPublishId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String publishInd = (String)attributes.get("publishInd");

		if (publishInd != null) {
			setPublishInd(publishInd);
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
	public long getGlobalPublishCtryId() {
		return _globalPublishCtryId;
	}

	@Override
	public void setGlobalPublishCtryId(long globalPublishCtryId) {
		_columnBitmask = -1L;

		_globalPublishCtryId = globalPublishCtryId;
	}

	@Override
	public long getGlobalPublishId() {
		return _globalPublishId;
	}

	@Override
	public void setGlobalPublishId(long globalPublishId) {
		_columnBitmask |= GLOBALPUBLISHID_COLUMN_BITMASK;

		if (!_setOriginalGlobalPublishId) {
			_setOriginalGlobalPublishId = true;

			_originalGlobalPublishId = _globalPublishId;
		}

		_globalPublishId = globalPublishId;
	}

	public long getOriginalGlobalPublishId() {
		return _originalGlobalPublishId;
	}

	@Override
	public String getCountryCode() {
		if (_countryCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _countryCode;
		}
	}

	@Override
	public void setCountryCode(String countryCode) {
		_columnBitmask |= COUNTRYCODE_COLUMN_BITMASK;

		if (_originalCountryCode == null) {
			_originalCountryCode = _countryCode;
		}

		_countryCode = countryCode;
	}

	public String getOriginalCountryCode() {
		return GetterUtil.getString(_originalCountryCode);
	}

	@Override
	public String getPublishInd() {
		if (_publishInd == null) {
			return StringPool.BLANK;
		}
		else {
			return _publishInd;
		}
	}

	@Override
	public void setPublishInd(String publishInd) {
		_publishInd = publishInd;
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
			BridgeGlobalPublishCountry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BridgeGlobalPublishCountry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BridgeGlobalPublishCountry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BridgeGlobalPublishCountryImpl bridgeGlobalPublishCountryImpl = new BridgeGlobalPublishCountryImpl();

		bridgeGlobalPublishCountryImpl.setGlobalPublishCtryId(getGlobalPublishCtryId());
		bridgeGlobalPublishCountryImpl.setGlobalPublishId(getGlobalPublishId());
		bridgeGlobalPublishCountryImpl.setCountryCode(getCountryCode());
		bridgeGlobalPublishCountryImpl.setPublishInd(getPublishInd());
		bridgeGlobalPublishCountryImpl.setCreatorId(getCreatorId());
		bridgeGlobalPublishCountryImpl.setCreatedDate(getCreatedDate());
		bridgeGlobalPublishCountryImpl.setUpdatedBy(getUpdatedBy());
		bridgeGlobalPublishCountryImpl.setUpdatedDate(getUpdatedDate());

		bridgeGlobalPublishCountryImpl.resetOriginalValues();

		return bridgeGlobalPublishCountryImpl;
	}

	@Override
	public int compareTo(BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		int value = 0;

		if (getGlobalPublishCtryId() < bridgeGlobalPublishCountry.getGlobalPublishCtryId()) {
			value = -1;
		}
		else if (getGlobalPublishCtryId() > bridgeGlobalPublishCountry.getGlobalPublishCtryId()) {
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

		if (!(obj instanceof BridgeGlobalPublishCountry)) {
			return false;
		}

		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = (BridgeGlobalPublishCountry)obj;

		long primaryKey = bridgeGlobalPublishCountry.getPrimaryKey();

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
		BridgeGlobalPublishCountryModelImpl bridgeGlobalPublishCountryModelImpl = this;

		bridgeGlobalPublishCountryModelImpl._originalGlobalPublishId = bridgeGlobalPublishCountryModelImpl._globalPublishId;

		bridgeGlobalPublishCountryModelImpl._setOriginalGlobalPublishId = false;

		bridgeGlobalPublishCountryModelImpl._originalCountryCode = bridgeGlobalPublishCountryModelImpl._countryCode;

		bridgeGlobalPublishCountryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BridgeGlobalPublishCountry> toCacheModel() {
		BridgeGlobalPublishCountryCacheModel bridgeGlobalPublishCountryCacheModel =
			new BridgeGlobalPublishCountryCacheModel();

		bridgeGlobalPublishCountryCacheModel.globalPublishCtryId = getGlobalPublishCtryId();

		bridgeGlobalPublishCountryCacheModel.globalPublishId = getGlobalPublishId();

		bridgeGlobalPublishCountryCacheModel.countryCode = getCountryCode();

		String countryCode = bridgeGlobalPublishCountryCacheModel.countryCode;

		if ((countryCode != null) && (countryCode.length() == 0)) {
			bridgeGlobalPublishCountryCacheModel.countryCode = null;
		}

		bridgeGlobalPublishCountryCacheModel.publishInd = getPublishInd();

		String publishInd = bridgeGlobalPublishCountryCacheModel.publishInd;

		if ((publishInd != null) && (publishInd.length() == 0)) {
			bridgeGlobalPublishCountryCacheModel.publishInd = null;
		}

		bridgeGlobalPublishCountryCacheModel.creatorId = getCreatorId();

		String creatorId = bridgeGlobalPublishCountryCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			bridgeGlobalPublishCountryCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			bridgeGlobalPublishCountryCacheModel.createdDate = createdDate.getTime();
		}
		else {
			bridgeGlobalPublishCountryCacheModel.createdDate = Long.MIN_VALUE;
		}

		bridgeGlobalPublishCountryCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = bridgeGlobalPublishCountryCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			bridgeGlobalPublishCountryCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			bridgeGlobalPublishCountryCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			bridgeGlobalPublishCountryCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return bridgeGlobalPublishCountryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{globalPublishCtryId=");
		sb.append(getGlobalPublishCtryId());
		sb.append(", globalPublishId=");
		sb.append(getGlobalPublishId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", publishInd=");
		sb.append(getPublishInd());
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
		sb.append("com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>globalPublishCtryId</column-name><column-value><![CDATA[");
		sb.append(getGlobalPublishCtryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>globalPublishId</column-name><column-value><![CDATA[");
		sb.append(getGlobalPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishInd</column-name><column-value><![CDATA[");
		sb.append(getPublishInd());
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

	private static ClassLoader _classLoader = BridgeGlobalPublishCountry.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BridgeGlobalPublishCountry.class
		};
	private long _globalPublishCtryId;
	private long _globalPublishId;
	private long _originalGlobalPublishId;
	private boolean _setOriginalGlobalPublishId;
	private String _countryCode;
	private String _originalCountryCode;
	private String _publishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private BridgeGlobalPublishCountry _escapedModel;
}