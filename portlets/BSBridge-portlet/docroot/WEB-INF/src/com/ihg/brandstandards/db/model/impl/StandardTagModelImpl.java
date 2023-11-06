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

import com.ihg.brandstandards.db.model.StandardTag;
import com.ihg.brandstandards.db.model.StandardTagModel;
import com.ihg.brandstandards.db.service.persistence.StandardTagPK;

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
 * The base model implementation for the StandardTag service. Represents a row in the &quot;STD_TAG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.StandardTagModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StandardTagImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardTagImpl
 * @see com.ihg.brandstandards.db.model.StandardTag
 * @see com.ihg.brandstandards.db.model.StandardTagModel
 * @generated
 */
public class StandardTagModelImpl extends BaseModelImpl<StandardTag>
	implements StandardTagModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a standard tag model instance should use the {@link com.ihg.brandstandards.db.model.StandardTag} interface instead.
	 */
	public static final String TABLE_NAME = "STD_TAG";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_ID", Types.BIGINT },
			{ "TAG_TXT", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_TAG (STD_ID LONG not null,TAG_TXT VARCHAR(75) not null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,primary key (STD_ID, TAG_TXT))";
	public static final String TABLE_SQL_DROP = "drop table STD_TAG";
	public static final String ORDER_BY_JPQL = " ORDER BY standardTag.id.stdId ASC, standardTag.id.tag ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_TAG.STD_ID ASC, STD_TAG.TAG_TXT ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.StandardTag"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.StandardTag"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.StandardTag"),
			true);
	public static long STDID_COLUMN_BITMASK = 1L;
	public static long TAG_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.StandardTag"));

	public StandardTagModelImpl() {
	}

	@Override
	public StandardTagPK getPrimaryKey() {
		return new StandardTagPK(_stdId, _tag);
	}

	@Override
	public void setPrimaryKey(StandardTagPK primaryKey) {
		setStdId(primaryKey.stdId);
		setTag(primaryKey.tag);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardTagPK(_stdId, _tag);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardTagPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return StandardTag.class;
	}

	@Override
	public String getModelClassName() {
		return StandardTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("tag", getTag());
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

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
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
	public String getTag() {
		if (_tag == null) {
			return StringPool.BLANK;
		}
		else {
			return _tag;
		}
	}

	@Override
	public void setTag(String tag) {
		_columnBitmask |= TAG_COLUMN_BITMASK;

		if (_originalTag == null) {
			_originalTag = _tag;
		}

		_tag = tag;
	}

	public String getOriginalTag() {
		return GetterUtil.getString(_originalTag);
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
	public StandardTag toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StandardTag)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StandardTagImpl standardTagImpl = new StandardTagImpl();

		standardTagImpl.setStdId(getStdId());
		standardTagImpl.setTag(getTag());
		standardTagImpl.setCreatorId(getCreatorId());
		standardTagImpl.setCreatedDate(getCreatedDate());
		standardTagImpl.setUpdatedBy(getUpdatedBy());
		standardTagImpl.setUpdatedDate(getUpdatedDate());

		standardTagImpl.resetOriginalValues();

		return standardTagImpl;
	}

	@Override
	public int compareTo(StandardTag standardTag) {
		StandardTagPK primaryKey = standardTag.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardTag)) {
			return false;
		}

		StandardTag standardTag = (StandardTag)obj;

		StandardTagPK primaryKey = standardTag.getPrimaryKey();

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
		StandardTagModelImpl standardTagModelImpl = this;

		standardTagModelImpl._originalStdId = standardTagModelImpl._stdId;

		standardTagModelImpl._setOriginalStdId = false;

		standardTagModelImpl._originalTag = standardTagModelImpl._tag;

		standardTagModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StandardTag> toCacheModel() {
		StandardTagCacheModel standardTagCacheModel = new StandardTagCacheModel();

		standardTagCacheModel.stdId = getStdId();

		standardTagCacheModel.tag = getTag();

		String tag = standardTagCacheModel.tag;

		if ((tag != null) && (tag.length() == 0)) {
			standardTagCacheModel.tag = null;
		}

		standardTagCacheModel.creatorId = getCreatorId();

		String creatorId = standardTagCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			standardTagCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			standardTagCacheModel.createdDate = createdDate.getTime();
		}
		else {
			standardTagCacheModel.createdDate = Long.MIN_VALUE;
		}

		standardTagCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = standardTagCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			standardTagCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			standardTagCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			standardTagCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return standardTagCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", tag=");
		sb.append(getTag());
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
		sb.append("com.ihg.brandstandards.db.model.StandardTag");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tag</column-name><column-value><![CDATA[");
		sb.append(getTag());
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

	private static ClassLoader _classLoader = StandardTag.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StandardTag.class
		};
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private String _tag;
	private String _originalTag;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private StandardTag _escapedModel;
}