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

import com.ihg.brandstandards.db.model.BridgeGlobalPublish;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishModel;

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
 * The base model implementation for the BridgeGlobalPublish service. Represents a row in the &quot;BRIDGE_GBL_PUBLISH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.BridgeGlobalPublishModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BridgeGlobalPublishImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishImpl
 * @see com.ihg.brandstandards.db.model.BridgeGlobalPublish
 * @see com.ihg.brandstandards.db.model.BridgeGlobalPublishModel
 * @generated
 */
public class BridgeGlobalPublishModelImpl extends BaseModelImpl<BridgeGlobalPublish>
	implements BridgeGlobalPublishModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bridge global publish model instance should use the {@link com.ihg.brandstandards.db.model.BridgeGlobalPublish} interface instead.
	 */
	public static final String TABLE_NAME = "BRIDGE_GBL_PUBLISH";
	public static final Object[][] TABLE_COLUMNS = {
			{ "BRIDGE_GBL_PUBLISH_ID", Types.BIGINT },
			{ "PUBLISH_ID", Types.BIGINT },
			{ "STD_ID", Types.BIGINT },
			{ "MUST_PUBLISH_IND", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table BRIDGE_GBL_PUBLISH (BRIDGE_GBL_PUBLISH_ID LONG not null primary key,PUBLISH_ID LONG,STD_ID LONG,MUST_PUBLISH_IND VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table BRIDGE_GBL_PUBLISH";
	public static final String ORDER_BY_JPQL = " ORDER BY bridgeGlobalPublish.globalPublishId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY BRIDGE_GBL_PUBLISH.BRIDGE_GBL_PUBLISH_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.BridgeGlobalPublish"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.BridgeGlobalPublish"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.BridgeGlobalPublish"),
			true);
	public static long MUSTPUBLISHIND_COLUMN_BITMASK = 1L;
	public static long PUBLISHID_COLUMN_BITMASK = 2L;
	public static long STDID_COLUMN_BITMASK = 4L;
	public static long GLOBALPUBLISHID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.BridgeGlobalPublish"));

	public BridgeGlobalPublishModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _globalPublishId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlobalPublishId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _globalPublishId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeGlobalPublish.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeGlobalPublish.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("globalPublishId", getGlobalPublishId());
		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("mustPublishInd", getMustPublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long globalPublishId = (Long)attributes.get("globalPublishId");

		if (globalPublishId != null) {
			setGlobalPublishId(globalPublishId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String mustPublishInd = (String)attributes.get("mustPublishInd");

		if (mustPublishInd != null) {
			setMustPublishInd(mustPublishInd);
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
	public long getGlobalPublishId() {
		return _globalPublishId;
	}

	@Override
	public void setGlobalPublishId(long globalPublishId) {
		_columnBitmask = -1L;

		_globalPublishId = globalPublishId;
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_columnBitmask |= PUBLISHID_COLUMN_BITMASK;

		if (!_setOriginalPublishId) {
			_setOriginalPublishId = true;

			_originalPublishId = _publishId;
		}

		_publishId = publishId;
	}

	public long getOriginalPublishId() {
		return _originalPublishId;
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
	public String getMustPublishInd() {
		if (_mustPublishInd == null) {
			return StringPool.BLANK;
		}
		else {
			return _mustPublishInd;
		}
	}

	@Override
	public void setMustPublishInd(String mustPublishInd) {
		_columnBitmask |= MUSTPUBLISHIND_COLUMN_BITMASK;

		if (_originalMustPublishInd == null) {
			_originalMustPublishInd = _mustPublishInd;
		}

		_mustPublishInd = mustPublishInd;
	}

	public String getOriginalMustPublishInd() {
		return GetterUtil.getString(_originalMustPublishInd);
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
			BridgeGlobalPublish.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public BridgeGlobalPublish toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BridgeGlobalPublish)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BridgeGlobalPublishImpl bridgeGlobalPublishImpl = new BridgeGlobalPublishImpl();

		bridgeGlobalPublishImpl.setGlobalPublishId(getGlobalPublishId());
		bridgeGlobalPublishImpl.setPublishId(getPublishId());
		bridgeGlobalPublishImpl.setStdId(getStdId());
		bridgeGlobalPublishImpl.setMustPublishInd(getMustPublishInd());
		bridgeGlobalPublishImpl.setCreatorId(getCreatorId());
		bridgeGlobalPublishImpl.setCreatedDate(getCreatedDate());
		bridgeGlobalPublishImpl.setUpdatedBy(getUpdatedBy());
		bridgeGlobalPublishImpl.setUpdatedDate(getUpdatedDate());

		bridgeGlobalPublishImpl.resetOriginalValues();

		return bridgeGlobalPublishImpl;
	}

	@Override
	public int compareTo(BridgeGlobalPublish bridgeGlobalPublish) {
		int value = 0;

		if (getGlobalPublishId() < bridgeGlobalPublish.getGlobalPublishId()) {
			value = -1;
		}
		else if (getGlobalPublishId() > bridgeGlobalPublish.getGlobalPublishId()) {
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

		if (!(obj instanceof BridgeGlobalPublish)) {
			return false;
		}

		BridgeGlobalPublish bridgeGlobalPublish = (BridgeGlobalPublish)obj;

		long primaryKey = bridgeGlobalPublish.getPrimaryKey();

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
		BridgeGlobalPublishModelImpl bridgeGlobalPublishModelImpl = this;

		bridgeGlobalPublishModelImpl._originalPublishId = bridgeGlobalPublishModelImpl._publishId;

		bridgeGlobalPublishModelImpl._setOriginalPublishId = false;

		bridgeGlobalPublishModelImpl._originalStdId = bridgeGlobalPublishModelImpl._stdId;

		bridgeGlobalPublishModelImpl._setOriginalStdId = false;

		bridgeGlobalPublishModelImpl._originalMustPublishInd = bridgeGlobalPublishModelImpl._mustPublishInd;

		bridgeGlobalPublishModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<BridgeGlobalPublish> toCacheModel() {
		BridgeGlobalPublishCacheModel bridgeGlobalPublishCacheModel = new BridgeGlobalPublishCacheModel();

		bridgeGlobalPublishCacheModel.globalPublishId = getGlobalPublishId();

		bridgeGlobalPublishCacheModel.publishId = getPublishId();

		bridgeGlobalPublishCacheModel.stdId = getStdId();

		bridgeGlobalPublishCacheModel.mustPublishInd = getMustPublishInd();

		String mustPublishInd = bridgeGlobalPublishCacheModel.mustPublishInd;

		if ((mustPublishInd != null) && (mustPublishInd.length() == 0)) {
			bridgeGlobalPublishCacheModel.mustPublishInd = null;
		}

		bridgeGlobalPublishCacheModel.creatorId = getCreatorId();

		String creatorId = bridgeGlobalPublishCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			bridgeGlobalPublishCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			bridgeGlobalPublishCacheModel.createdDate = createdDate.getTime();
		}
		else {
			bridgeGlobalPublishCacheModel.createdDate = Long.MIN_VALUE;
		}

		bridgeGlobalPublishCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = bridgeGlobalPublishCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			bridgeGlobalPublishCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			bridgeGlobalPublishCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			bridgeGlobalPublishCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return bridgeGlobalPublishCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{globalPublishId=");
		sb.append(getGlobalPublishId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", mustPublishInd=");
		sb.append(getMustPublishInd());
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
		sb.append("com.ihg.brandstandards.db.model.BridgeGlobalPublish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>globalPublishId</column-name><column-value><![CDATA[");
		sb.append(getGlobalPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mustPublishInd</column-name><column-value><![CDATA[");
		sb.append(getMustPublishInd());
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

	private static ClassLoader _classLoader = BridgeGlobalPublish.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BridgeGlobalPublish.class
		};
	private long _globalPublishId;
	private long _publishId;
	private long _originalPublishId;
	private boolean _setOriginalPublishId;
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private String _mustPublishInd;
	private String _originalMustPublishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private BridgeGlobalPublish _escapedModel;
}