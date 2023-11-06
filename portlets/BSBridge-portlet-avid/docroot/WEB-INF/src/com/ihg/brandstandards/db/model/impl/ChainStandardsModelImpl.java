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

import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.ChainStandardsModel;
import com.ihg.brandstandards.db.service.persistence.ChainStandardsPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ChainStandards service. Represents a row in the &quot;CHAIN_STD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.ChainStandardsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChainStandardsImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see ChainStandardsImpl
 * @see com.ihg.brandstandards.db.model.ChainStandards
 * @see com.ihg.brandstandards.db.model.ChainStandardsModel
 * @generated
 */
public class ChainStandardsModelImpl extends BaseModelImpl<ChainStandards>
	implements ChainStandardsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chain standards model instance should use the {@link com.ihg.brandstandards.db.model.ChainStandards} interface instead.
	 */
	public static final String TABLE_NAME = "CHAIN_STD";
	public static final Object[][] TABLE_COLUMNS = {
			{ "CHAIN_CD", Types.VARCHAR },
			{ "STD_ID", Types.BIGINT },
			{ "STAT_ID", Types.BIGINT },
			{ "ACTV_IND", Types.VARCHAR },
			{ "LST_PUBLISHED_TS", Types.TIMESTAMP },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table CHAIN_STD (CHAIN_CD VARCHAR(75) not null,STD_ID LONG not null,STAT_ID LONG,ACTV_IND VARCHAR(75) null,LST_PUBLISHED_TS DATE null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,primary key (CHAIN_CD, STD_ID))";
	public static final String TABLE_SQL_DROP = "drop table CHAIN_STD";
	public static final String ORDER_BY_JPQL = " ORDER BY chainStandards.id.chainCode ASC, chainStandards.id.stdId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CHAIN_STD.CHAIN_CD ASC, CHAIN_STD.STD_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.ChainStandards"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.ChainStandards"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.ChainStandards"),
			true);
	public static long CHAINCODE_COLUMN_BITMASK = 1L;
	public static long ISACTIVE_COLUMN_BITMASK = 2L;
	public static long STDID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.ChainStandards"));

	public ChainStandardsModelImpl() {
	}

	@Override
	public ChainStandardsPK getPrimaryKey() {
		return new ChainStandardsPK(_chainCode, _stdId);
	}

	@Override
	public void setPrimaryKey(ChainStandardsPK primaryKey) {
		setChainCode(primaryKey.chainCode);
		setStdId(primaryKey.stdId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ChainStandardsPK(_chainCode, _stdId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ChainStandardsPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ChainStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ChainStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chainCode", getChainCode());
		attributes.put("stdId", getStdId());
		attributes.put("statusId", getStatusId());
		attributes.put("isActive", getIsActive());
		attributes.put("lastPublishedDate", getLastPublishedDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long statusId = (Long)attributes.get("statusId");

		if (statusId != null) {
			setStatusId(statusId);
		}

		String isActive = (String)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Date lastPublishedDate = (Date)attributes.get("lastPublishedDate");

		if (lastPublishedDate != null) {
			setLastPublishedDate(lastPublishedDate);
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
	public String getChainCode() {
		if (_chainCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _chainCode;
		}
	}

	@Override
	public void setChainCode(String chainCode) {
		_columnBitmask |= CHAINCODE_COLUMN_BITMASK;

		if (_originalChainCode == null) {
			_originalChainCode = _chainCode;
		}

		_chainCode = chainCode;
	}

	public String getOriginalChainCode() {
		return GetterUtil.getString(_originalChainCode);
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
	public long getStatusId() {
		return _statusId;
	}

	@Override
	public void setStatusId(long statusId) {
		_statusId = statusId;
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
		_columnBitmask |= ISACTIVE_COLUMN_BITMASK;

		if (_originalIsActive == null) {
			_originalIsActive = _isActive;
		}

		_isActive = isActive;
	}

	public String getOriginalIsActive() {
		return GetterUtil.getString(_originalIsActive);
	}

	@Override
	public Date getLastPublishedDate() {
		return _lastPublishedDate;
	}

	@Override
	public void setLastPublishedDate(Date lastPublishedDate) {
		_lastPublishedDate = lastPublishedDate;
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
	public ChainStandards toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ChainStandards)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChainStandardsImpl chainStandardsImpl = new ChainStandardsImpl();

		chainStandardsImpl.setChainCode(getChainCode());
		chainStandardsImpl.setStdId(getStdId());
		chainStandardsImpl.setStatusId(getStatusId());
		chainStandardsImpl.setIsActive(getIsActive());
		chainStandardsImpl.setLastPublishedDate(getLastPublishedDate());
		chainStandardsImpl.setCreatorId(getCreatorId());
		chainStandardsImpl.setCreatedDate(getCreatedDate());
		chainStandardsImpl.setUpdatedBy(getUpdatedBy());
		chainStandardsImpl.setUpdatedDate(getUpdatedDate());

		chainStandardsImpl.resetOriginalValues();

		return chainStandardsImpl;
	}

	@Override
	public int compareTo(ChainStandards chainStandards) {
		ChainStandardsPK primaryKey = chainStandards.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChainStandards)) {
			return false;
		}

		ChainStandards chainStandards = (ChainStandards)obj;

		ChainStandardsPK primaryKey = chainStandards.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public void resetOriginalValues() {
		ChainStandardsModelImpl chainStandardsModelImpl = this;

		chainStandardsModelImpl._originalChainCode = chainStandardsModelImpl._chainCode;

		chainStandardsModelImpl._originalStdId = chainStandardsModelImpl._stdId;

		chainStandardsModelImpl._setOriginalStdId = false;

		chainStandardsModelImpl._originalIsActive = chainStandardsModelImpl._isActive;

		chainStandardsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ChainStandards> toCacheModel() {
		ChainStandardsCacheModel chainStandardsCacheModel = new ChainStandardsCacheModel();

		chainStandardsCacheModel.chainCode = getChainCode();

		String chainCode = chainStandardsCacheModel.chainCode;

		if ((chainCode != null) && (chainCode.length() == 0)) {
			chainStandardsCacheModel.chainCode = null;
		}

		chainStandardsCacheModel.stdId = getStdId();

		chainStandardsCacheModel.statusId = getStatusId();

		chainStandardsCacheModel.isActive = getIsActive();

		String isActive = chainStandardsCacheModel.isActive;

		if ((isActive != null) && (isActive.length() == 0)) {
			chainStandardsCacheModel.isActive = null;
		}

		Date lastPublishedDate = getLastPublishedDate();

		if (lastPublishedDate != null) {
			chainStandardsCacheModel.lastPublishedDate = lastPublishedDate.getTime();
		}
		else {
			chainStandardsCacheModel.lastPublishedDate = Long.MIN_VALUE;
		}

		chainStandardsCacheModel.creatorId = getCreatorId();

		String creatorId = chainStandardsCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			chainStandardsCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			chainStandardsCacheModel.createdDate = createdDate.getTime();
		}
		else {
			chainStandardsCacheModel.createdDate = Long.MIN_VALUE;
		}

		chainStandardsCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = chainStandardsCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			chainStandardsCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			chainStandardsCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			chainStandardsCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return chainStandardsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{chainCode=");
		sb.append(getChainCode());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", statusId=");
		sb.append(getStatusId());
		sb.append(", isActive=");
		sb.append(getIsActive());
		sb.append(", lastPublishedDate=");
		sb.append(getLastPublishedDate());
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
		sb.append("com.ihg.brandstandards.db.model.ChainStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isActive</column-name><column-value><![CDATA[");
		sb.append(getIsActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPublishedDate</column-name><column-value><![CDATA[");
		sb.append(getLastPublishedDate());
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

	private static ClassLoader _classLoader = ChainStandards.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ChainStandards.class
		};
	private String _chainCode;
	private String _originalChainCode;
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private long _statusId;
	private String _isActive;
	private String _originalIsActive;
	private Date _lastPublishedDate;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private ChainStandards _escapedModel;
}