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

import com.ihg.brandstandards.db.model.GlossaryTranslate;
import com.ihg.brandstandards.db.model.GlossaryTranslateModel;

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
 * The base model implementation for the GlossaryTranslate service. Represents a row in the &quot;GLOSSARY_XLAT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.GlossaryTranslateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GlossaryTranslateImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryTranslateImpl
 * @see com.ihg.brandstandards.db.model.GlossaryTranslate
 * @see com.ihg.brandstandards.db.model.GlossaryTranslateModel
 * @generated
 */
public class GlossaryTranslateModelImpl extends BaseModelImpl<GlossaryTranslate>
	implements GlossaryTranslateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a glossary translate model instance should use the {@link com.ihg.brandstandards.db.model.GlossaryTranslate} interface instead.
	 */
	public static final String TABLE_NAME = "GLOSSARY_XLAT";
	public static final Object[][] TABLE_COLUMNS = {
			{ "GLOSSARY_XLAT_ID", Types.BIGINT },
			{ "GLOSSARY_ID", Types.BIGINT },
			{ "LOCALE_CD", Types.VARCHAR },
			{ "GLOSSARY_TERM_TXT", Types.VARCHAR },
			{ "GLOSSARY_TERM_DESC", Types.VARCHAR },
			{ "TERM_XLAT_IND", Types.VARCHAR },
			{ "DESC_XLAT_IND", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table GLOSSARY_XLAT (GLOSSARY_XLAT_ID LONG not null primary key,GLOSSARY_ID LONG,LOCALE_CD VARCHAR(75) null,GLOSSARY_TERM_TXT VARCHAR(75) null,GLOSSARY_TERM_DESC VARCHAR(75) null,TERM_XLAT_IND VARCHAR(75) null,DESC_XLAT_IND VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table GLOSSARY_XLAT";
	public static final String ORDER_BY_JPQL = " ORDER BY glossaryTranslate.glossaryXlatId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GLOSSARY_XLAT.GLOSSARY_XLAT_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.GlossaryTranslate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.GlossaryTranslate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.GlossaryTranslate"),
			true);
	public static long GLOSSARYID_COLUMN_BITMASK = 1L;
	public static long LANGCODE_COLUMN_BITMASK = 2L;
	public static long GLOSSARYXLATID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.GlossaryTranslate"));

	public GlossaryTranslateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _glossaryXlatId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlossaryXlatId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _glossaryXlatId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GlossaryTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return GlossaryTranslate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryXlatId", getGlossaryXlatId());
		attributes.put("glossaryId", getGlossaryId());
		attributes.put("langCode", getLangCode());
		attributes.put("glossaryTermText", getGlossaryTermText());
		attributes.put("glossaryTermDesc", getGlossaryTermDesc());
		attributes.put("isValidTermTxt", getIsValidTermTxt());
		attributes.put("isValidDescTxt", getIsValidDescTxt());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryXlatId = (Long)attributes.get("glossaryXlatId");

		if (glossaryXlatId != null) {
			setGlossaryXlatId(glossaryXlatId);
		}

		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String langCode = (String)attributes.get("langCode");

		if (langCode != null) {
			setLangCode(langCode);
		}

		String glossaryTermText = (String)attributes.get("glossaryTermText");

		if (glossaryTermText != null) {
			setGlossaryTermText(glossaryTermText);
		}

		String glossaryTermDesc = (String)attributes.get("glossaryTermDesc");

		if (glossaryTermDesc != null) {
			setGlossaryTermDesc(glossaryTermDesc);
		}

		String isValidTermTxt = (String)attributes.get("isValidTermTxt");

		if (isValidTermTxt != null) {
			setIsValidTermTxt(isValidTermTxt);
		}

		String isValidDescTxt = (String)attributes.get("isValidDescTxt");

		if (isValidDescTxt != null) {
			setIsValidDescTxt(isValidDescTxt);
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
	public long getGlossaryXlatId() {
		return _glossaryXlatId;
	}

	@Override
	public void setGlossaryXlatId(long glossaryXlatId) {
		_glossaryXlatId = glossaryXlatId;
	}

	@Override
	public long getGlossaryId() {
		return _glossaryId;
	}

	@Override
	public void setGlossaryId(long glossaryId) {
		_columnBitmask |= GLOSSARYID_COLUMN_BITMASK;

		if (!_setOriginalGlossaryId) {
			_setOriginalGlossaryId = true;

			_originalGlossaryId = _glossaryId;
		}

		_glossaryId = glossaryId;
	}

	public long getOriginalGlossaryId() {
		return _originalGlossaryId;
	}

	@Override
	public String getLangCode() {
		if (_langCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _langCode;
		}
	}

	@Override
	public void setLangCode(String langCode) {
		_columnBitmask |= LANGCODE_COLUMN_BITMASK;

		if (_originalLangCode == null) {
			_originalLangCode = _langCode;
		}

		_langCode = langCode;
	}

	public String getOriginalLangCode() {
		return GetterUtil.getString(_originalLangCode);
	}

	@Override
	public String getGlossaryTermText() {
		if (_glossaryTermText == null) {
			return StringPool.BLANK;
		}
		else {
			return _glossaryTermText;
		}
	}

	@Override
	public void setGlossaryTermText(String glossaryTermText) {
		_glossaryTermText = glossaryTermText;
	}

	@Override
	public String getGlossaryTermDesc() {
		if (_glossaryTermDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _glossaryTermDesc;
		}
	}

	@Override
	public void setGlossaryTermDesc(String glossaryTermDesc) {
		_glossaryTermDesc = glossaryTermDesc;
	}

	@Override
	public String getIsValidTermTxt() {
		if (_isValidTermTxt == null) {
			return StringPool.BLANK;
		}
		else {
			return _isValidTermTxt;
		}
	}

	@Override
	public void setIsValidTermTxt(String isValidTermTxt) {
		_isValidTermTxt = isValidTermTxt;
	}

	@Override
	public String getIsValidDescTxt() {
		if (_isValidDescTxt == null) {
			return StringPool.BLANK;
		}
		else {
			return _isValidDescTxt;
		}
	}

	@Override
	public void setIsValidDescTxt(String isValidDescTxt) {
		_isValidDescTxt = isValidDescTxt;
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
			GlossaryTranslate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GlossaryTranslate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (GlossaryTranslate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GlossaryTranslateImpl glossaryTranslateImpl = new GlossaryTranslateImpl();

		glossaryTranslateImpl.setGlossaryXlatId(getGlossaryXlatId());
		glossaryTranslateImpl.setGlossaryId(getGlossaryId());
		glossaryTranslateImpl.setLangCode(getLangCode());
		glossaryTranslateImpl.setGlossaryTermText(getGlossaryTermText());
		glossaryTranslateImpl.setGlossaryTermDesc(getGlossaryTermDesc());
		glossaryTranslateImpl.setIsValidTermTxt(getIsValidTermTxt());
		glossaryTranslateImpl.setIsValidDescTxt(getIsValidDescTxt());
		glossaryTranslateImpl.setCreatorId(getCreatorId());
		glossaryTranslateImpl.setCreatedDate(getCreatedDate());
		glossaryTranslateImpl.setUpdatedBy(getUpdatedBy());
		glossaryTranslateImpl.setUpdatedDate(getUpdatedDate());

		glossaryTranslateImpl.resetOriginalValues();

		return glossaryTranslateImpl;
	}

	@Override
	public int compareTo(GlossaryTranslate glossaryTranslate) {
		long primaryKey = glossaryTranslate.getPrimaryKey();

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

		if (!(obj instanceof GlossaryTranslate)) {
			return false;
		}

		GlossaryTranslate glossaryTranslate = (GlossaryTranslate)obj;

		long primaryKey = glossaryTranslate.getPrimaryKey();

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
		GlossaryTranslateModelImpl glossaryTranslateModelImpl = this;

		glossaryTranslateModelImpl._originalGlossaryId = glossaryTranslateModelImpl._glossaryId;

		glossaryTranslateModelImpl._setOriginalGlossaryId = false;

		glossaryTranslateModelImpl._originalLangCode = glossaryTranslateModelImpl._langCode;

		glossaryTranslateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GlossaryTranslate> toCacheModel() {
		GlossaryTranslateCacheModel glossaryTranslateCacheModel = new GlossaryTranslateCacheModel();

		glossaryTranslateCacheModel.glossaryXlatId = getGlossaryXlatId();

		glossaryTranslateCacheModel.glossaryId = getGlossaryId();

		glossaryTranslateCacheModel.langCode = getLangCode();

		String langCode = glossaryTranslateCacheModel.langCode;

		if ((langCode != null) && (langCode.length() == 0)) {
			glossaryTranslateCacheModel.langCode = null;
		}

		glossaryTranslateCacheModel.glossaryTermText = getGlossaryTermText();

		String glossaryTermText = glossaryTranslateCacheModel.glossaryTermText;

		if ((glossaryTermText != null) && (glossaryTermText.length() == 0)) {
			glossaryTranslateCacheModel.glossaryTermText = null;
		}

		glossaryTranslateCacheModel.glossaryTermDesc = getGlossaryTermDesc();

		String glossaryTermDesc = glossaryTranslateCacheModel.glossaryTermDesc;

		if ((glossaryTermDesc != null) && (glossaryTermDesc.length() == 0)) {
			glossaryTranslateCacheModel.glossaryTermDesc = null;
		}

		glossaryTranslateCacheModel.isValidTermTxt = getIsValidTermTxt();

		String isValidTermTxt = glossaryTranslateCacheModel.isValidTermTxt;

		if ((isValidTermTxt != null) && (isValidTermTxt.length() == 0)) {
			glossaryTranslateCacheModel.isValidTermTxt = null;
		}

		glossaryTranslateCacheModel.isValidDescTxt = getIsValidDescTxt();

		String isValidDescTxt = glossaryTranslateCacheModel.isValidDescTxt;

		if ((isValidDescTxt != null) && (isValidDescTxt.length() == 0)) {
			glossaryTranslateCacheModel.isValidDescTxt = null;
		}

		glossaryTranslateCacheModel.creatorId = getCreatorId();

		String creatorId = glossaryTranslateCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			glossaryTranslateCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			glossaryTranslateCacheModel.createdDate = createdDate.getTime();
		}
		else {
			glossaryTranslateCacheModel.createdDate = Long.MIN_VALUE;
		}

		glossaryTranslateCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = glossaryTranslateCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			glossaryTranslateCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			glossaryTranslateCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			glossaryTranslateCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return glossaryTranslateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{glossaryXlatId=");
		sb.append(getGlossaryXlatId());
		sb.append(", glossaryId=");
		sb.append(getGlossaryId());
		sb.append(", langCode=");
		sb.append(getLangCode());
		sb.append(", glossaryTermText=");
		sb.append(getGlossaryTermText());
		sb.append(", glossaryTermDesc=");
		sb.append(getGlossaryTermDesc());
		sb.append(", isValidTermTxt=");
		sb.append(getIsValidTermTxt());
		sb.append(", isValidDescTxt=");
		sb.append(getIsValidDescTxt());
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
		sb.append("com.ihg.brandstandards.db.model.GlossaryTranslate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>glossaryXlatId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryXlatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>langCode</column-name><column-value><![CDATA[");
		sb.append(getLangCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryTermText</column-name><column-value><![CDATA[");
		sb.append(getGlossaryTermText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryTermDesc</column-name><column-value><![CDATA[");
		sb.append(getGlossaryTermDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isValidTermTxt</column-name><column-value><![CDATA[");
		sb.append(getIsValidTermTxt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isValidDescTxt</column-name><column-value><![CDATA[");
		sb.append(getIsValidDescTxt());
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

	private static ClassLoader _classLoader = GlossaryTranslate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			GlossaryTranslate.class
		};
	private long _glossaryXlatId;
	private long _glossaryId;
	private long _originalGlossaryId;
	private boolean _setOriginalGlossaryId;
	private String _langCode;
	private String _originalLangCode;
	private String _glossaryTermText;
	private String _glossaryTermDesc;
	private String _isValidTermTxt;
	private String _isValidDescTxt;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private GlossaryTranslate _escapedModel;
}