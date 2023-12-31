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

import com.ihg.brandstandards.db.model.BridgePublishCountryStateEx;
import com.ihg.brandstandards.db.model.BridgePublishCountryStateExModel;
import com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the BridgePublishCountryStateEx service. Represents a row in the &quot;BRIDGE_PUBLISH_STAT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.BridgePublishCountryStateExModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BridgePublishCountryStateExImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishCountryStateExImpl
 * @see com.ihg.brandstandards.db.model.BridgePublishCountryStateEx
 * @see com.ihg.brandstandards.db.model.BridgePublishCountryStateExModel
 * @generated
 */
public class BridgePublishCountryStateExModelImpl extends BaseModelImpl<BridgePublishCountryStateEx>
	implements BridgePublishCountryStateExModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bridge publish country state ex model instance should use the {@link com.ihg.brandstandards.db.model.BridgePublishCountryStateEx} interface instead.
	 */
	public static final String TABLE_NAME = "BRIDGE_PUBLISH_STAT";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_ID", Types.BIGINT },
			{ "CTRY_NM_CD", Types.VARCHAR },
			{ "PRNT_STD_ID", Types.BIGINT },
			{ "STD_TYP", Types.VARCHAR },
			{ "BRIDGE_PUBLISH_ID", Types.BIGINT },
			{ "BRIDGE_PUBLISH_STAT_CD", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table BRIDGE_PUBLISH_STAT (STD_ID LONG not null,CTRY_NM_CD VARCHAR(75) not null,PRNT_STD_ID LONG,STD_TYP VARCHAR(75) null,BRIDGE_PUBLISH_ID LONG,BRIDGE_PUBLISH_STAT_CD VARCHAR(75) null,primary key (STD_ID, CTRY_NM_CD))";
	public static final String TABLE_SQL_DROP = "drop table BRIDGE_PUBLISH_STAT";
	public static final String ORDER_BY_JPQL = " ORDER BY bridgePublishCountryStateEx.id.stdId ASC, bridgePublishCountryStateEx.id.CountryCode ASC";
	public static final String ORDER_BY_SQL = " ORDER BY BRIDGE_PUBLISH_STAT.STD_ID ASC, BRIDGE_PUBLISH_STAT.CTRY_NM_CD ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.BridgePublishCountryStateEx"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.BridgePublishCountryStateEx"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.BridgePublishCountryStateEx"));

	public BridgePublishCountryStateExModelImpl() {
	}

	@Override
	public BridgePublishCountryStateExPK getPrimaryKey() {
		return new BridgePublishCountryStateExPK(_stdId, _CountryCode);
	}

	@Override
	public void setPrimaryKey(BridgePublishCountryStateExPK primaryKey) {
		setStdId(primaryKey.stdId);
		setCountryCode(primaryKey.CountryCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new BridgePublishCountryStateExPK(_stdId, _CountryCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BridgePublishCountryStateExPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishCountryStateEx.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishCountryStateEx.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("CountryCode", getCountryCode());
		attributes.put("parentStdId", getParentStdId());
		attributes.put("type", getType());
		attributes.put("publishId", getPublishId());
		attributes.put("stateCd", getStateCd());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String CountryCode = (String)attributes.get("CountryCode");

		if (CountryCode != null) {
			setCountryCode(CountryCode);
		}

		Long parentStdId = (Long)attributes.get("parentStdId");

		if (parentStdId != null) {
			setParentStdId(parentStdId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String stateCd = (String)attributes.get("stateCd");

		if (stateCd != null) {
			setStateCd(stateCd);
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	@Override
	public String getCountryCode() {
		if (_CountryCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _CountryCode;
		}
	}

	@Override
	public void setCountryCode(String CountryCode) {
		_CountryCode = CountryCode;
	}

	@Override
	public long getParentStdId() {
		return _parentStdId;
	}

	@Override
	public void setParentStdId(long parentStdId) {
		_parentStdId = parentStdId;
	}

	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	@Override
	public String getStateCd() {
		if (_stateCd == null) {
			return StringPool.BLANK;
		}
		else {
			return _stateCd;
		}
	}

	@Override
	public void setStateCd(String stateCd) {
		_stateCd = stateCd;
	}

	@Override
	public BridgePublishCountryStateEx toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BridgePublishCountryStateEx)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BridgePublishCountryStateExImpl bridgePublishCountryStateExImpl = new BridgePublishCountryStateExImpl();

		bridgePublishCountryStateExImpl.setStdId(getStdId());
		bridgePublishCountryStateExImpl.setCountryCode(getCountryCode());
		bridgePublishCountryStateExImpl.setParentStdId(getParentStdId());
		bridgePublishCountryStateExImpl.setType(getType());
		bridgePublishCountryStateExImpl.setPublishId(getPublishId());
		bridgePublishCountryStateExImpl.setStateCd(getStateCd());

		bridgePublishCountryStateExImpl.resetOriginalValues();

		return bridgePublishCountryStateExImpl;
	}

	@Override
	public int compareTo(
		BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		BridgePublishCountryStateExPK primaryKey = bridgePublishCountryStateEx.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishCountryStateEx)) {
			return false;
		}

		BridgePublishCountryStateEx bridgePublishCountryStateEx = (BridgePublishCountryStateEx)obj;

		BridgePublishCountryStateExPK primaryKey = bridgePublishCountryStateEx.getPrimaryKey();

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
	}

	@Override
	public CacheModel<BridgePublishCountryStateEx> toCacheModel() {
		BridgePublishCountryStateExCacheModel bridgePublishCountryStateExCacheModel =
			new BridgePublishCountryStateExCacheModel();

		bridgePublishCountryStateExCacheModel.stdId = getStdId();

		bridgePublishCountryStateExCacheModel.CountryCode = getCountryCode();

		String CountryCode = bridgePublishCountryStateExCacheModel.CountryCode;

		if ((CountryCode != null) && (CountryCode.length() == 0)) {
			bridgePublishCountryStateExCacheModel.CountryCode = null;
		}

		bridgePublishCountryStateExCacheModel.parentStdId = getParentStdId();

		bridgePublishCountryStateExCacheModel.type = getType();

		String type = bridgePublishCountryStateExCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			bridgePublishCountryStateExCacheModel.type = null;
		}

		bridgePublishCountryStateExCacheModel.publishId = getPublishId();

		bridgePublishCountryStateExCacheModel.stateCd = getStateCd();

		String stateCd = bridgePublishCountryStateExCacheModel.stateCd;

		if ((stateCd != null) && (stateCd.length() == 0)) {
			bridgePublishCountryStateExCacheModel.stateCd = null;
		}

		return bridgePublishCountryStateExCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", CountryCode=");
		sb.append(getCountryCode());
		sb.append(", parentStdId=");
		sb.append(getParentStdId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", stateCd=");
		sb.append(getStateCd());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgePublishCountryStateEx");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CountryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentStdId</column-name><column-value><![CDATA[");
		sb.append(getParentStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateCd</column-name><column-value><![CDATA[");
		sb.append(getStateCd());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = BridgePublishCountryStateEx.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BridgePublishCountryStateEx.class
		};
	private long _stdId;
	private String _CountryCode;
	private long _parentStdId;
	private String _type;
	private long _publishId;
	private String _stateCd;
	private BridgePublishCountryStateEx _escapedModel;
}