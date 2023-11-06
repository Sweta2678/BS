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

import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandardsModel;
import com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK;

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
 * The base model implementation for the ChainExternalLinkStandards service. Represents a row in the &quot;STD_EXTL_LINK_CHAIN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.ChainExternalLinkStandardsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ChainExternalLinkStandardsImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see ChainExternalLinkStandardsImpl
 * @see com.ihg.brandstandards.db.model.ChainExternalLinkStandards
 * @see com.ihg.brandstandards.db.model.ChainExternalLinkStandardsModel
 * @generated
 */
public class ChainExternalLinkStandardsModelImpl extends BaseModelImpl<ChainExternalLinkStandards>
	implements ChainExternalLinkStandardsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a chain external link standards model instance should use the {@link com.ihg.brandstandards.db.model.ChainExternalLinkStandards} interface instead.
	 */
	public static final String TABLE_NAME = "STD_EXTL_LINK_CHAIN";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_EXTL_LINK_ID", Types.BIGINT },
			{ "CHAIN_CD", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_EXTL_LINK_CHAIN (STD_EXTL_LINK_ID LONG not null,CHAIN_CD VARCHAR(75) not null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,primary key (STD_EXTL_LINK_ID, CHAIN_CD))";
	public static final String TABLE_SQL_DROP = "drop table STD_EXTL_LINK_CHAIN";
	public static final String ORDER_BY_JPQL = " ORDER BY chainExternalLinkStandards.id.extLinkId ASC, chainExternalLinkStandards.id.chainCode ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_EXTL_LINK_CHAIN.STD_EXTL_LINK_ID ASC, STD_EXTL_LINK_CHAIN.CHAIN_CD ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.ChainExternalLinkStandards"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.ChainExternalLinkStandards"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.ChainExternalLinkStandards"),
			true);
	public static long EXTLINKID_COLUMN_BITMASK = 1L;
	public static long CHAINCODE_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.ChainExternalLinkStandards"));

	public ChainExternalLinkStandardsModelImpl() {
	}

	@Override
	public ChainExternalLinkStandardsPK getPrimaryKey() {
		return new ChainExternalLinkStandardsPK(_extLinkId, _chainCode);
	}

	@Override
	public void setPrimaryKey(ChainExternalLinkStandardsPK primaryKey) {
		setExtLinkId(primaryKey.extLinkId);
		setChainCode(primaryKey.chainCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ChainExternalLinkStandardsPK(_extLinkId, _chainCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ChainExternalLinkStandardsPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return ChainExternalLinkStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ChainExternalLinkStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("extLinkId", getExtLinkId());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long extLinkId = (Long)attributes.get("extLinkId");

		if (extLinkId != null) {
			setExtLinkId(extLinkId);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
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
	public long getExtLinkId() {
		return _extLinkId;
	}

	@Override
	public void setExtLinkId(long extLinkId) {
		_columnBitmask |= EXTLINKID_COLUMN_BITMASK;

		if (!_setOriginalExtLinkId) {
			_setOriginalExtLinkId = true;

			_originalExtLinkId = _extLinkId;
		}

		_extLinkId = extLinkId;
	}

	public long getOriginalExtLinkId() {
		return _originalExtLinkId;
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
		_chainCode = chainCode;
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
	public ChainExternalLinkStandards toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ChainExternalLinkStandards)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ChainExternalLinkStandardsImpl chainExternalLinkStandardsImpl = new ChainExternalLinkStandardsImpl();

		chainExternalLinkStandardsImpl.setExtLinkId(getExtLinkId());
		chainExternalLinkStandardsImpl.setChainCode(getChainCode());
		chainExternalLinkStandardsImpl.setCreatorId(getCreatorId());
		chainExternalLinkStandardsImpl.setCreatedDate(getCreatedDate());
		chainExternalLinkStandardsImpl.setUpdatedBy(getUpdatedBy());
		chainExternalLinkStandardsImpl.setUpdatedDate(getUpdatedDate());

		chainExternalLinkStandardsImpl.resetOriginalValues();

		return chainExternalLinkStandardsImpl;
	}

	@Override
	public int compareTo(ChainExternalLinkStandards chainExternalLinkStandards) {
		ChainExternalLinkStandardsPK primaryKey = chainExternalLinkStandards.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChainExternalLinkStandards)) {
			return false;
		}

		ChainExternalLinkStandards chainExternalLinkStandards = (ChainExternalLinkStandards)obj;

		ChainExternalLinkStandardsPK primaryKey = chainExternalLinkStandards.getPrimaryKey();

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
		ChainExternalLinkStandardsModelImpl chainExternalLinkStandardsModelImpl = this;

		chainExternalLinkStandardsModelImpl._originalExtLinkId = chainExternalLinkStandardsModelImpl._extLinkId;

		chainExternalLinkStandardsModelImpl._setOriginalExtLinkId = false;

		chainExternalLinkStandardsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ChainExternalLinkStandards> toCacheModel() {
		ChainExternalLinkStandardsCacheModel chainExternalLinkStandardsCacheModel =
			new ChainExternalLinkStandardsCacheModel();

		chainExternalLinkStandardsCacheModel.extLinkId = getExtLinkId();

		chainExternalLinkStandardsCacheModel.chainCode = getChainCode();

		String chainCode = chainExternalLinkStandardsCacheModel.chainCode;

		if ((chainCode != null) && (chainCode.length() == 0)) {
			chainExternalLinkStandardsCacheModel.chainCode = null;
		}

		chainExternalLinkStandardsCacheModel.creatorId = getCreatorId();

		String creatorId = chainExternalLinkStandardsCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			chainExternalLinkStandardsCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			chainExternalLinkStandardsCacheModel.createdDate = createdDate.getTime();
		}
		else {
			chainExternalLinkStandardsCacheModel.createdDate = Long.MIN_VALUE;
		}

		chainExternalLinkStandardsCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = chainExternalLinkStandardsCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			chainExternalLinkStandardsCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			chainExternalLinkStandardsCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			chainExternalLinkStandardsCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return chainExternalLinkStandardsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{extLinkId=");
		sb.append(getExtLinkId());
		sb.append(", chainCode=");
		sb.append(getChainCode());
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
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.ChainExternalLinkStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>extLinkId</column-name><column-value><![CDATA[");
		sb.append(getExtLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
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

	private static ClassLoader _classLoader = ChainExternalLinkStandards.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ChainExternalLinkStandards.class
		};
	private long _extLinkId;
	private long _originalExtLinkId;
	private boolean _setOriginalExtLinkId;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private ChainExternalLinkStandards _escapedModel;
}