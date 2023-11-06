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

import com.ihg.brandstandards.db.model.StandardsCompliance;
import com.ihg.brandstandards.db.model.StandardsComplianceModel;

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
 * The base model implementation for the StandardsCompliance service. Represents a row in the &quot;STD_CMPLY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.StandardsComplianceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StandardsComplianceImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsComplianceImpl
 * @see com.ihg.brandstandards.db.model.StandardsCompliance
 * @see com.ihg.brandstandards.db.model.StandardsComplianceModel
 * @generated
 */
public class StandardsComplianceModelImpl extends BaseModelImpl<StandardsCompliance>
	implements StandardsComplianceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a standards compliance model instance should use the {@link com.ihg.brandstandards.db.model.StandardsCompliance} interface instead.
	 */
	public static final String TABLE_NAME = "STD_CMPLY";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_CMPLY_ID", Types.BIGINT },
			{ "STD_ID", Types.BIGINT },
			{ "CTRY_NM_CD", Types.VARCHAR },
			{ "CHAIN_CD", Types.VARCHAR },
			{ "CMPLY_EXPR_DT", Types.TIMESTAMP },
			{ "CMPLY_EXPR_RULE_CD", Types.VARCHAR },
			{ "CMPLY_RULE_MO_QTY", Types.BIGINT },
			{ "RULE_DT_CD", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_CMPLY (STD_CMPLY_ID LONG not null primary key,STD_ID LONG,CTRY_NM_CD VARCHAR(75) null,CHAIN_CD VARCHAR(75) null,CMPLY_EXPR_DT DATE null,CMPLY_EXPR_RULE_CD VARCHAR(75) null,CMPLY_RULE_MO_QTY LONG,RULE_DT_CD VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table STD_CMPLY";
	public static final String ORDER_BY_JPQL = " ORDER BY standardsCompliance.stdComplianceId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_CMPLY.STD_CMPLY_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.StandardsCompliance"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.StandardsCompliance"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.StandardsCompliance"),
			true);
	public static long CHAINCODE_COLUMN_BITMASK = 1L;
	public static long COUNTRYCODE_COLUMN_BITMASK = 2L;
	public static long STDID_COLUMN_BITMASK = 4L;
	public static long STDCOMPLIANCEID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.StandardsCompliance"));

	public StandardsComplianceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _stdComplianceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdComplianceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdComplianceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCompliance.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCompliance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdComplianceId", getStdComplianceId());
		attributes.put("stdId", getStdId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("complianceExpiryDate", getComplianceExpiryDate());
		attributes.put("complianceExpiryRule", getComplianceExpiryRule());
		attributes.put("complianceRuleMonths", getComplianceRuleMonths());
		attributes.put("RuleDate", getRuleDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdComplianceId = (Long)attributes.get("stdComplianceId");

		if (stdComplianceId != null) {
			setStdComplianceId(stdComplianceId);
		}

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

		Date complianceExpiryDate = (Date)attributes.get("complianceExpiryDate");

		if (complianceExpiryDate != null) {
			setComplianceExpiryDate(complianceExpiryDate);
		}

		String complianceExpiryRule = (String)attributes.get(
				"complianceExpiryRule");

		if (complianceExpiryRule != null) {
			setComplianceExpiryRule(complianceExpiryRule);
		}

		Long complianceRuleMonths = (Long)attributes.get("complianceRuleMonths");

		if (complianceRuleMonths != null) {
			setComplianceRuleMonths(complianceRuleMonths);
		}

		String RuleDate = (String)attributes.get("RuleDate");

		if (RuleDate != null) {
			setRuleDate(RuleDate);
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
	public long getStdComplianceId() {
		return _stdComplianceId;
	}

	@Override
	public void setStdComplianceId(long stdComplianceId) {
		_stdComplianceId = stdComplianceId;
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
	public Date getComplianceExpiryDate() {
		return _complianceExpiryDate;
	}

	@Override
	public void setComplianceExpiryDate(Date complianceExpiryDate) {
		_complianceExpiryDate = complianceExpiryDate;
	}

	@Override
	public String getComplianceExpiryRule() {
		if (_complianceExpiryRule == null) {
			return StringPool.BLANK;
		}
		else {
			return _complianceExpiryRule;
		}
	}

	@Override
	public void setComplianceExpiryRule(String complianceExpiryRule) {
		_complianceExpiryRule = complianceExpiryRule;
	}

	@Override
	public long getComplianceRuleMonths() {
		return _complianceRuleMonths;
	}

	@Override
	public void setComplianceRuleMonths(long complianceRuleMonths) {
		_complianceRuleMonths = complianceRuleMonths;
	}

	@Override
	public String getRuleDate() {
		if (_RuleDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _RuleDate;
		}
	}

	@Override
	public void setRuleDate(String RuleDate) {
		_RuleDate = RuleDate;
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
			StandardsCompliance.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StandardsCompliance toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StandardsCompliance)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StandardsComplianceImpl standardsComplianceImpl = new StandardsComplianceImpl();

		standardsComplianceImpl.setStdComplianceId(getStdComplianceId());
		standardsComplianceImpl.setStdId(getStdId());
		standardsComplianceImpl.setCountryCode(getCountryCode());
		standardsComplianceImpl.setChainCode(getChainCode());
		standardsComplianceImpl.setComplianceExpiryDate(getComplianceExpiryDate());
		standardsComplianceImpl.setComplianceExpiryRule(getComplianceExpiryRule());
		standardsComplianceImpl.setComplianceRuleMonths(getComplianceRuleMonths());
		standardsComplianceImpl.setRuleDate(getRuleDate());
		standardsComplianceImpl.setCreatorId(getCreatorId());
		standardsComplianceImpl.setCreatedDate(getCreatedDate());
		standardsComplianceImpl.setUpdatedBy(getUpdatedBy());
		standardsComplianceImpl.setUpdatedDate(getUpdatedDate());

		standardsComplianceImpl.resetOriginalValues();

		return standardsComplianceImpl;
	}

	@Override
	public int compareTo(StandardsCompliance standardsCompliance) {
		long primaryKey = standardsCompliance.getPrimaryKey();

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

		if (!(obj instanceof StandardsCompliance)) {
			return false;
		}

		StandardsCompliance standardsCompliance = (StandardsCompliance)obj;

		long primaryKey = standardsCompliance.getPrimaryKey();

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
		StandardsComplianceModelImpl standardsComplianceModelImpl = this;

		standardsComplianceModelImpl._originalStdId = standardsComplianceModelImpl._stdId;

		standardsComplianceModelImpl._setOriginalStdId = false;

		standardsComplianceModelImpl._originalCountryCode = standardsComplianceModelImpl._countryCode;

		standardsComplianceModelImpl._originalChainCode = standardsComplianceModelImpl._chainCode;

		standardsComplianceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StandardsCompliance> toCacheModel() {
		StandardsComplianceCacheModel standardsComplianceCacheModel = new StandardsComplianceCacheModel();

		standardsComplianceCacheModel.stdComplianceId = getStdComplianceId();

		standardsComplianceCacheModel.stdId = getStdId();

		standardsComplianceCacheModel.countryCode = getCountryCode();

		String countryCode = standardsComplianceCacheModel.countryCode;

		if ((countryCode != null) && (countryCode.length() == 0)) {
			standardsComplianceCacheModel.countryCode = null;
		}

		standardsComplianceCacheModel.chainCode = getChainCode();

		String chainCode = standardsComplianceCacheModel.chainCode;

		if ((chainCode != null) && (chainCode.length() == 0)) {
			standardsComplianceCacheModel.chainCode = null;
		}

		Date complianceExpiryDate = getComplianceExpiryDate();

		if (complianceExpiryDate != null) {
			standardsComplianceCacheModel.complianceExpiryDate = complianceExpiryDate.getTime();
		}
		else {
			standardsComplianceCacheModel.complianceExpiryDate = Long.MIN_VALUE;
		}

		standardsComplianceCacheModel.complianceExpiryRule = getComplianceExpiryRule();

		String complianceExpiryRule = standardsComplianceCacheModel.complianceExpiryRule;

		if ((complianceExpiryRule != null) &&
				(complianceExpiryRule.length() == 0)) {
			standardsComplianceCacheModel.complianceExpiryRule = null;
		}

		standardsComplianceCacheModel.complianceRuleMonths = getComplianceRuleMonths();

		standardsComplianceCacheModel.RuleDate = getRuleDate();

		String RuleDate = standardsComplianceCacheModel.RuleDate;

		if ((RuleDate != null) && (RuleDate.length() == 0)) {
			standardsComplianceCacheModel.RuleDate = null;
		}

		standardsComplianceCacheModel.creatorId = getCreatorId();

		String creatorId = standardsComplianceCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			standardsComplianceCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			standardsComplianceCacheModel.createdDate = createdDate.getTime();
		}
		else {
			standardsComplianceCacheModel.createdDate = Long.MIN_VALUE;
		}

		standardsComplianceCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = standardsComplianceCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			standardsComplianceCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			standardsComplianceCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			standardsComplianceCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return standardsComplianceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{stdComplianceId=");
		sb.append(getStdComplianceId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", complianceExpiryDate=");
		sb.append(getComplianceExpiryDate());
		sb.append(", complianceExpiryRule=");
		sb.append(getComplianceExpiryRule());
		sb.append(", complianceRuleMonths=");
		sb.append(getComplianceRuleMonths());
		sb.append(", RuleDate=");
		sb.append(getRuleDate());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsCompliance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdComplianceId</column-name><column-value><![CDATA[");
		sb.append(getStdComplianceId());
		sb.append("]]></column-value></column>");
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
			"<column><column-name>complianceExpiryDate</column-name><column-value><![CDATA[");
		sb.append(getComplianceExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceExpiryRule</column-name><column-value><![CDATA[");
		sb.append(getComplianceExpiryRule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceRuleMonths</column-name><column-value><![CDATA[");
		sb.append(getComplianceRuleMonths());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RuleDate</column-name><column-value><![CDATA[");
		sb.append(getRuleDate());
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

	private static ClassLoader _classLoader = StandardsCompliance.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StandardsCompliance.class
		};
	private long _stdComplianceId;
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private String _countryCode;
	private String _originalCountryCode;
	private String _chainCode;
	private String _originalChainCode;
	private Date _complianceExpiryDate;
	private String _complianceExpiryRule;
	private long _complianceRuleMonths;
	private String _RuleDate;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private StandardsCompliance _escapedModel;
}