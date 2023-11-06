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

import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandardsModel;

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
 * The base model implementation for the ExternalLinkStandards service. Represents a row in the &quot;STD_EXTL_LINK&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.ExternalLinkStandardsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExternalLinkStandardsImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsImpl
 * @see com.ihg.brandstandards.db.model.ExternalLinkStandards
 * @see com.ihg.brandstandards.db.model.ExternalLinkStandardsModel
 * @generated
 */
public class ExternalLinkStandardsModelImpl extends BaseModelImpl<ExternalLinkStandards>
	implements ExternalLinkStandardsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a external link standards model instance should use the {@link com.ihg.brandstandards.db.model.ExternalLinkStandards} interface instead.
	 */
	public static final String TABLE_NAME = "STD_EXTL_LINK";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_EXTL_LINK_ID", Types.BIGINT },
			{ "PRNT_STD_EXTL_LINK_ID", Types.BIGINT },
			{ "STD_ID", Types.BIGINT },
			{ "URL_TXT", Types.VARCHAR },
			{ "LINK_TITLE_TXT", Types.VARCHAR },
			{ "XLAT_IND", Types.VARCHAR },
			{ "LOCALE_CD", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_EXTL_LINK (STD_EXTL_LINK_ID LONG not null primary key,PRNT_STD_EXTL_LINK_ID LONG,STD_ID LONG,URL_TXT VARCHAR(75) null,LINK_TITLE_TXT VARCHAR(75) null,XLAT_IND VARCHAR(75) null,LOCALE_CD VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table STD_EXTL_LINK";
	public static final String ORDER_BY_JPQL = " ORDER BY externalLinkStandards.extLinkId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_EXTL_LINK.STD_EXTL_LINK_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.ExternalLinkStandards"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.ExternalLinkStandards"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.ExternalLinkStandards"),
			true);
	public static long LOCALECODE_COLUMN_BITMASK = 1L;
	public static long PARENTEXTLINKID_COLUMN_BITMASK = 2L;
	public static long STDID_COLUMN_BITMASK = 4L;
	public static long EXTLINKID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.ExternalLinkStandards"));

	public ExternalLinkStandardsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _extLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExtLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _extLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ExternalLinkStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ExternalLinkStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("extLinkId", getExtLinkId());
		attributes.put("parentExtLinkId", getParentExtLinkId());
		attributes.put("stdId", getStdId());
		attributes.put("url", getUrl());
		attributes.put("title", getTitle());
		attributes.put("translationIndicator", getTranslationIndicator());
		attributes.put("localeCode", getLocaleCode());
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

		Long parentExtLinkId = (Long)attributes.get("parentExtLinkId");

		if (parentExtLinkId != null) {
			setParentExtLinkId(parentExtLinkId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String translationIndicator = (String)attributes.get(
				"translationIndicator");

		if (translationIndicator != null) {
			setTranslationIndicator(translationIndicator);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
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
		_extLinkId = extLinkId;
	}

	@Override
	public long getParentExtLinkId() {
		return _parentExtLinkId;
	}

	@Override
	public void setParentExtLinkId(long parentExtLinkId) {
		_columnBitmask |= PARENTEXTLINKID_COLUMN_BITMASK;

		if (!_setOriginalParentExtLinkId) {
			_setOriginalParentExtLinkId = true;

			_originalParentExtLinkId = _parentExtLinkId;
		}

		_parentExtLinkId = parentExtLinkId;
	}

	public long getOriginalParentExtLinkId() {
		return _originalParentExtLinkId;
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
	public String getUrl() {
		if (_url == null) {
			return StringPool.BLANK;
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_url = url;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public String getTranslationIndicator() {
		if (_translationIndicator == null) {
			return StringPool.BLANK;
		}
		else {
			return _translationIndicator;
		}
	}

	@Override
	public void setTranslationIndicator(String translationIndicator) {
		_translationIndicator = translationIndicator;
	}

	@Override
	public String getLocaleCode() {
		if (_localeCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _localeCode;
		}
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_columnBitmask |= LOCALECODE_COLUMN_BITMASK;

		if (_originalLocaleCode == null) {
			_originalLocaleCode = _localeCode;
		}

		_localeCode = localeCode;
	}

	public String getOriginalLocaleCode() {
		return GetterUtil.getString(_originalLocaleCode);
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
			ExternalLinkStandards.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ExternalLinkStandards toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ExternalLinkStandards)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ExternalLinkStandardsImpl externalLinkStandardsImpl = new ExternalLinkStandardsImpl();

		externalLinkStandardsImpl.setExtLinkId(getExtLinkId());
		externalLinkStandardsImpl.setParentExtLinkId(getParentExtLinkId());
		externalLinkStandardsImpl.setStdId(getStdId());
		externalLinkStandardsImpl.setUrl(getUrl());
		externalLinkStandardsImpl.setTitle(getTitle());
		externalLinkStandardsImpl.setTranslationIndicator(getTranslationIndicator());
		externalLinkStandardsImpl.setLocaleCode(getLocaleCode());
		externalLinkStandardsImpl.setCreatorId(getCreatorId());
		externalLinkStandardsImpl.setCreatedDate(getCreatedDate());
		externalLinkStandardsImpl.setUpdatedBy(getUpdatedBy());
		externalLinkStandardsImpl.setUpdatedDate(getUpdatedDate());

		externalLinkStandardsImpl.resetOriginalValues();

		return externalLinkStandardsImpl;
	}

	@Override
	public int compareTo(ExternalLinkStandards externalLinkStandards) {
		long primaryKey = externalLinkStandards.getPrimaryKey();

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

		if (!(obj instanceof ExternalLinkStandards)) {
			return false;
		}

		ExternalLinkStandards externalLinkStandards = (ExternalLinkStandards)obj;

		long primaryKey = externalLinkStandards.getPrimaryKey();

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
		ExternalLinkStandardsModelImpl externalLinkStandardsModelImpl = this;

		externalLinkStandardsModelImpl._originalParentExtLinkId = externalLinkStandardsModelImpl._parentExtLinkId;

		externalLinkStandardsModelImpl._setOriginalParentExtLinkId = false;

		externalLinkStandardsModelImpl._originalStdId = externalLinkStandardsModelImpl._stdId;

		externalLinkStandardsModelImpl._setOriginalStdId = false;

		externalLinkStandardsModelImpl._originalLocaleCode = externalLinkStandardsModelImpl._localeCode;

		externalLinkStandardsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ExternalLinkStandards> toCacheModel() {
		ExternalLinkStandardsCacheModel externalLinkStandardsCacheModel = new ExternalLinkStandardsCacheModel();

		externalLinkStandardsCacheModel.extLinkId = getExtLinkId();

		externalLinkStandardsCacheModel.parentExtLinkId = getParentExtLinkId();

		externalLinkStandardsCacheModel.stdId = getStdId();

		externalLinkStandardsCacheModel.url = getUrl();

		String url = externalLinkStandardsCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			externalLinkStandardsCacheModel.url = null;
		}

		externalLinkStandardsCacheModel.title = getTitle();

		String title = externalLinkStandardsCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			externalLinkStandardsCacheModel.title = null;
		}

		externalLinkStandardsCacheModel.translationIndicator = getTranslationIndicator();

		String translationIndicator = externalLinkStandardsCacheModel.translationIndicator;

		if ((translationIndicator != null) &&
				(translationIndicator.length() == 0)) {
			externalLinkStandardsCacheModel.translationIndicator = null;
		}

		externalLinkStandardsCacheModel.localeCode = getLocaleCode();

		String localeCode = externalLinkStandardsCacheModel.localeCode;

		if ((localeCode != null) && (localeCode.length() == 0)) {
			externalLinkStandardsCacheModel.localeCode = null;
		}

		externalLinkStandardsCacheModel.creatorId = getCreatorId();

		String creatorId = externalLinkStandardsCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			externalLinkStandardsCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			externalLinkStandardsCacheModel.createdDate = createdDate.getTime();
		}
		else {
			externalLinkStandardsCacheModel.createdDate = Long.MIN_VALUE;
		}

		externalLinkStandardsCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = externalLinkStandardsCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			externalLinkStandardsCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			externalLinkStandardsCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			externalLinkStandardsCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return externalLinkStandardsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{extLinkId=");
		sb.append(getExtLinkId());
		sb.append(", parentExtLinkId=");
		sb.append(getParentExtLinkId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", translationIndicator=");
		sb.append(getTranslationIndicator());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
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
		sb.append("com.ihg.brandstandards.db.model.ExternalLinkStandards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>extLinkId</column-name><column-value><![CDATA[");
		sb.append(getExtLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentExtLinkId</column-name><column-value><![CDATA[");
		sb.append(getParentExtLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>translationIndicator</column-name><column-value><![CDATA[");
		sb.append(getTranslationIndicator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
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

	private static ClassLoader _classLoader = ExternalLinkStandards.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			ExternalLinkStandards.class
		};
	private long _extLinkId;
	private long _parentExtLinkId;
	private long _originalParentExtLinkId;
	private boolean _setOriginalParentExtLinkId;
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private String _url;
	private String _title;
	private String _translationIndicator;
	private String _localeCode;
	private String _originalLocaleCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private ExternalLinkStandards _escapedModel;
}