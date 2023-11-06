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

import com.ihg.brandstandards.db.model.AttachmentsStandardsCountry;
import com.ihg.brandstandards.db.model.AttachmentsStandardsCountryModel;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK;

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
 * The base model implementation for the AttachmentsStandardsCountry service. Represents a row in the &quot;STD_ATTACHMENT_CTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.AttachmentsStandardsCountryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AttachmentsStandardsCountryImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandardsCountryImpl
 * @see com.ihg.brandstandards.db.model.AttachmentsStandardsCountry
 * @see com.ihg.brandstandards.db.model.AttachmentsStandardsCountryModel
 * @generated
 */
public class AttachmentsStandardsCountryModelImpl extends BaseModelImpl<AttachmentsStandardsCountry>
	implements AttachmentsStandardsCountryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a attachments standards country model instance should use the {@link com.ihg.brandstandards.db.model.AttachmentsStandardsCountry} interface instead.
	 */
	public static final String TABLE_NAME = "STD_ATTACHMENT_CTRY";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_ATTACHEMENT_ID", Types.BIGINT },
			{ "CTRY_NM_CD", Types.VARCHAR },
			{ "LOCALE_CD", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_ATTACHMENT_CTRY (STD_ATTACHEMENT_ID LONG not null,CTRY_NM_CD VARCHAR(75) not null,LOCALE_CD VARCHAR(75) not null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,primary key (STD_ATTACHEMENT_ID, CTRY_NM_CD, LOCALE_CD))";
	public static final String TABLE_SQL_DROP = "drop table STD_ATTACHMENT_CTRY";
	public static final String ORDER_BY_JPQL = " ORDER BY attachmentsStandardsCountry.id.attachmentId ASC, attachmentsStandardsCountry.id.countryCode ASC, attachmentsStandardsCountry.id.localeCode ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_ATTACHMENT_CTRY.STD_ATTACHEMENT_ID ASC, STD_ATTACHMENT_CTRY.CTRY_NM_CD ASC, STD_ATTACHMENT_CTRY.LOCALE_CD ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.AttachmentsStandardsCountry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.AttachmentsStandardsCountry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.AttachmentsStandardsCountry"),
			true);
	public static long ATTACHMENTID_COLUMN_BITMASK = 1L;
	public static long COUNTRYCODE_COLUMN_BITMASK = 2L;
	public static long LOCALECODE_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.AttachmentsStandardsCountry"));

	public AttachmentsStandardsCountryModelImpl() {
	}

	@Override
	public AttachmentsStandardsCountryPK getPrimaryKey() {
		return new AttachmentsStandardsCountryPK(_attachmentId, _countryCode,
			_localeCode);
	}

	@Override
	public void setPrimaryKey(AttachmentsStandardsCountryPK primaryKey) {
		setAttachmentId(primaryKey.attachmentId);
		setCountryCode(primaryKey.countryCode);
		setLocaleCode(primaryKey.localeCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new AttachmentsStandardsCountryPK(_attachmentId, _countryCode,
			_localeCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((AttachmentsStandardsCountryPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return AttachmentsStandardsCountry.class;
	}

	@Override
	public String getModelClassName() {
		return AttachmentsStandardsCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
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
	public long getAttachmentId() {
		return _attachmentId;
	}

	@Override
	public void setAttachmentId(long attachmentId) {
		_columnBitmask |= ATTACHMENTID_COLUMN_BITMASK;

		if (!_setOriginalAttachmentId) {
			_setOriginalAttachmentId = true;

			_originalAttachmentId = _attachmentId;
		}

		_attachmentId = attachmentId;
	}

	public long getOriginalAttachmentId() {
		return _originalAttachmentId;
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
		_localeCode = localeCode;
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
	public AttachmentsStandardsCountry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AttachmentsStandardsCountry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AttachmentsStandardsCountryImpl attachmentsStandardsCountryImpl = new AttachmentsStandardsCountryImpl();

		attachmentsStandardsCountryImpl.setAttachmentId(getAttachmentId());
		attachmentsStandardsCountryImpl.setCountryCode(getCountryCode());
		attachmentsStandardsCountryImpl.setLocaleCode(getLocaleCode());
		attachmentsStandardsCountryImpl.setCreatorId(getCreatorId());
		attachmentsStandardsCountryImpl.setCreatedDate(getCreatedDate());
		attachmentsStandardsCountryImpl.setUpdatedBy(getUpdatedBy());
		attachmentsStandardsCountryImpl.setUpdatedDate(getUpdatedDate());

		attachmentsStandardsCountryImpl.resetOriginalValues();

		return attachmentsStandardsCountryImpl;
	}

	@Override
	public int compareTo(
		AttachmentsStandardsCountry attachmentsStandardsCountry) {
		AttachmentsStandardsCountryPK primaryKey = attachmentsStandardsCountry.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentsStandardsCountry)) {
			return false;
		}

		AttachmentsStandardsCountry attachmentsStandardsCountry = (AttachmentsStandardsCountry)obj;

		AttachmentsStandardsCountryPK primaryKey = attachmentsStandardsCountry.getPrimaryKey();

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
		AttachmentsStandardsCountryModelImpl attachmentsStandardsCountryModelImpl =
			this;

		attachmentsStandardsCountryModelImpl._originalAttachmentId = attachmentsStandardsCountryModelImpl._attachmentId;

		attachmentsStandardsCountryModelImpl._setOriginalAttachmentId = false;

		attachmentsStandardsCountryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AttachmentsStandardsCountry> toCacheModel() {
		AttachmentsStandardsCountryCacheModel attachmentsStandardsCountryCacheModel =
			new AttachmentsStandardsCountryCacheModel();

		attachmentsStandardsCountryCacheModel.attachmentId = getAttachmentId();

		attachmentsStandardsCountryCacheModel.countryCode = getCountryCode();

		String countryCode = attachmentsStandardsCountryCacheModel.countryCode;

		if ((countryCode != null) && (countryCode.length() == 0)) {
			attachmentsStandardsCountryCacheModel.countryCode = null;
		}

		attachmentsStandardsCountryCacheModel.localeCode = getLocaleCode();

		String localeCode = attachmentsStandardsCountryCacheModel.localeCode;

		if ((localeCode != null) && (localeCode.length() == 0)) {
			attachmentsStandardsCountryCacheModel.localeCode = null;
		}

		attachmentsStandardsCountryCacheModel.creatorId = getCreatorId();

		String creatorId = attachmentsStandardsCountryCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			attachmentsStandardsCountryCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			attachmentsStandardsCountryCacheModel.createdDate = createdDate.getTime();
		}
		else {
			attachmentsStandardsCountryCacheModel.createdDate = Long.MIN_VALUE;
		}

		attachmentsStandardsCountryCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = attachmentsStandardsCountryCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			attachmentsStandardsCountryCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			attachmentsStandardsCountryCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			attachmentsStandardsCountryCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return attachmentsStandardsCountryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{attachmentId=");
		sb.append(getAttachmentId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
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
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.AttachmentsStandardsCountry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>attachmentId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
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

	private static ClassLoader _classLoader = AttachmentsStandardsCountry.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AttachmentsStandardsCountry.class
		};
	private long _attachmentId;
	private long _originalAttachmentId;
	private boolean _setOriginalAttachmentId;
	private String _countryCode;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private AttachmentsStandardsCountry _escapedModel;
}