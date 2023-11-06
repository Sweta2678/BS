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

import com.ihg.brandstandards.db.model.StandardsCountryChain;
import com.ihg.brandstandards.db.model.StandardsCountryChainModel;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK;

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
 * The base model implementation for the StandardsCountryChain service. Represents a row in the &quot;STD_CTRY_CHAIN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.StandardsCountryChainModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StandardsCountryChainImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryChainImpl
 * @see com.ihg.brandstandards.db.model.StandardsCountryChain
 * @see com.ihg.brandstandards.db.model.StandardsCountryChainModel
 * @generated
 */
public class StandardsCountryChainModelImpl extends BaseModelImpl<StandardsCountryChain>
	implements StandardsCountryChainModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a standards country chain model instance should use the {@link com.ihg.brandstandards.db.model.StandardsCountryChain} interface instead.
	 */
	public static final String TABLE_NAME = "STD_CTRY_CHAIN";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_ID", Types.BIGINT },
			{ "CTRY_NM_CD", Types.VARCHAR },
			{ "CHAIN_CD", Types.VARCHAR },
			{ "RGN_CD", Types.VARCHAR },
			{ "CMPLY_DT", Types.TIMESTAMP },
			{ "EXPR_DT", Types.TIMESTAMP },
			{ "EXPIRED_BY_REF_TXT", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_CTRY_CHAIN (STD_ID LONG not null,CTRY_NM_CD VARCHAR(75) not null,CHAIN_CD VARCHAR(75) not null,RGN_CD VARCHAR(75) null,CMPLY_DT DATE null,EXPR_DT DATE null,EXPIRED_BY_REF_TXT VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,primary key (STD_ID, CTRY_NM_CD, CHAIN_CD))";
	public static final String TABLE_SQL_DROP = "drop table STD_CTRY_CHAIN";
	public static final String ORDER_BY_JPQL = " ORDER BY standardsCountryChain.id.stdId ASC, standardsCountryChain.id.countryCode ASC, standardsCountryChain.id.chainCode ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_CTRY_CHAIN.STD_ID ASC, STD_CTRY_CHAIN.CTRY_NM_CD ASC, STD_CTRY_CHAIN.CHAIN_CD ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.StandardsCountryChain"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.StandardsCountryChain"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.StandardsCountryChain"),
			true);
	public static long CHAINCODE_COLUMN_BITMASK = 1L;
	public static long COMPDATE_COLUMN_BITMASK = 2L;
	public static long REGIONCODE_COLUMN_BITMASK = 4L;
	public static long STDID_COLUMN_BITMASK = 8L;
	public static long COUNTRYCODE_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.StandardsCountryChain"));

	public StandardsCountryChainModelImpl() {
	}

	@Override
	public StandardsCountryChainPK getPrimaryKey() {
		return new StandardsCountryChainPK(_stdId, _countryCode, _chainCode);
	}

	@Override
	public void setPrimaryKey(StandardsCountryChainPK primaryKey) {
		setStdId(primaryKey.stdId);
		setCountryCode(primaryKey.countryCode);
		setChainCode(primaryKey.chainCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardsCountryChainPK(_stdId, _countryCode, _chainCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardsCountryChainPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCountryChain.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCountryChain.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("compDate", getCompDate());
		attributes.put("exprDate", getExprDate());
		attributes.put("expiredIds", getExpiredIds());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		Date compDate = (Date)attributes.get("compDate");

		if (compDate != null) {
			setCompDate(compDate);
		}

		Date exprDate = (Date)attributes.get("exprDate");

		if (exprDate != null) {
			setExprDate(exprDate);
		}

		String expiredIds = (String)attributes.get("expiredIds");

		if (expiredIds != null) {
			setExpiredIds(expiredIds);
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
		_countryCode = countryCode;
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
	public Date getCompDate() {
		return _compDate;
	}

	@Override
	public void setCompDate(Date compDate) {
		_columnBitmask |= COMPDATE_COLUMN_BITMASK;

		if (_originalCompDate == null) {
			_originalCompDate = _compDate;
		}

		_compDate = compDate;
	}

	public Date getOriginalCompDate() {
		return _originalCompDate;
	}

	@Override
	public Date getExprDate() {
		return _exprDate;
	}

	@Override
	public void setExprDate(Date exprDate) {
		_exprDate = exprDate;
	}

	@Override
	public String getExpiredIds() {
		if (_expiredIds == null) {
			return StringPool.BLANK;
		}
		else {
			return _expiredIds;
		}
	}

	@Override
	public void setExpiredIds(String expiredIds) {
		_expiredIds = expiredIds;
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
	public StandardsCountryChain toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StandardsCountryChain)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StandardsCountryChainImpl standardsCountryChainImpl = new StandardsCountryChainImpl();

		standardsCountryChainImpl.setStdId(getStdId());
		standardsCountryChainImpl.setCountryCode(getCountryCode());
		standardsCountryChainImpl.setChainCode(getChainCode());
		standardsCountryChainImpl.setRegionCode(getRegionCode());
		standardsCountryChainImpl.setCompDate(getCompDate());
		standardsCountryChainImpl.setExprDate(getExprDate());
		standardsCountryChainImpl.setExpiredIds(getExpiredIds());
		standardsCountryChainImpl.setCreatorId(getCreatorId());
		standardsCountryChainImpl.setCreatedDate(getCreatedDate());
		standardsCountryChainImpl.setUpdatedBy(getUpdatedBy());
		standardsCountryChainImpl.setUpdatedDate(getUpdatedDate());

		standardsCountryChainImpl.resetOriginalValues();

		return standardsCountryChainImpl;
	}

	@Override
	public int compareTo(StandardsCountryChain standardsCountryChain) {
		StandardsCountryChainPK primaryKey = standardsCountryChain.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsCountryChain)) {
			return false;
		}

		StandardsCountryChain standardsCountryChain = (StandardsCountryChain)obj;

		StandardsCountryChainPK primaryKey = standardsCountryChain.getPrimaryKey();

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
		StandardsCountryChainModelImpl standardsCountryChainModelImpl = this;

		standardsCountryChainModelImpl._originalStdId = standardsCountryChainModelImpl._stdId;

		standardsCountryChainModelImpl._setOriginalStdId = false;

		standardsCountryChainModelImpl._originalChainCode = standardsCountryChainModelImpl._chainCode;

		standardsCountryChainModelImpl._originalRegionCode = standardsCountryChainModelImpl._regionCode;

		standardsCountryChainModelImpl._originalCompDate = standardsCountryChainModelImpl._compDate;

		standardsCountryChainModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StandardsCountryChain> toCacheModel() {
		StandardsCountryChainCacheModel standardsCountryChainCacheModel = new StandardsCountryChainCacheModel();

		standardsCountryChainCacheModel.stdId = getStdId();

		standardsCountryChainCacheModel.countryCode = getCountryCode();

		String countryCode = standardsCountryChainCacheModel.countryCode;

		if ((countryCode != null) && (countryCode.length() == 0)) {
			standardsCountryChainCacheModel.countryCode = null;
		}

		standardsCountryChainCacheModel.chainCode = getChainCode();

		String chainCode = standardsCountryChainCacheModel.chainCode;

		if ((chainCode != null) && (chainCode.length() == 0)) {
			standardsCountryChainCacheModel.chainCode = null;
		}

		standardsCountryChainCacheModel.regionCode = getRegionCode();

		String regionCode = standardsCountryChainCacheModel.regionCode;

		if ((regionCode != null) && (regionCode.length() == 0)) {
			standardsCountryChainCacheModel.regionCode = null;
		}

		Date compDate = getCompDate();

		if (compDate != null) {
			standardsCountryChainCacheModel.compDate = compDate.getTime();
		}
		else {
			standardsCountryChainCacheModel.compDate = Long.MIN_VALUE;
		}

		Date exprDate = getExprDate();

		if (exprDate != null) {
			standardsCountryChainCacheModel.exprDate = exprDate.getTime();
		}
		else {
			standardsCountryChainCacheModel.exprDate = Long.MIN_VALUE;
		}

		standardsCountryChainCacheModel.expiredIds = getExpiredIds();

		String expiredIds = standardsCountryChainCacheModel.expiredIds;

		if ((expiredIds != null) && (expiredIds.length() == 0)) {
			standardsCountryChainCacheModel.expiredIds = null;
		}

		standardsCountryChainCacheModel.creatorId = getCreatorId();

		String creatorId = standardsCountryChainCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			standardsCountryChainCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			standardsCountryChainCacheModel.createdDate = createdDate.getTime();
		}
		else {
			standardsCountryChainCacheModel.createdDate = Long.MIN_VALUE;
		}

		standardsCountryChainCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = standardsCountryChainCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			standardsCountryChainCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			standardsCountryChainCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			standardsCountryChainCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return standardsCountryChainCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", compDate=");
		sb.append(getCompDate());
		sb.append(", exprDate=");
		sb.append(getExprDate());
		sb.append(", expiredIds=");
		sb.append(getExpiredIds());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsCountryChain");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>compDate</column-name><column-value><![CDATA[");
		sb.append(getCompDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>exprDate</column-name><column-value><![CDATA[");
		sb.append(getExprDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredIds</column-name><column-value><![CDATA[");
		sb.append(getExpiredIds());
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

	private static ClassLoader _classLoader = StandardsCountryChain.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StandardsCountryChain.class
		};
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private String _countryCode;
	private String _chainCode;
	private String _originalChainCode;
	private String _regionCode;
	private String _originalRegionCode;
	private Date _compDate;
	private Date _originalCompDate;
	private Date _exprDate;
	private String _expiredIds;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private StandardsCountryChain _escapedModel;
}