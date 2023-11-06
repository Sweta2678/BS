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

import com.ihg.brandstandards.db.model.BrandTaxonomyTranslate;
import com.ihg.brandstandards.db.model.BrandTaxonomyTranslateModel;
import com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK;

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
 * The base model implementation for the BrandTaxonomyTranslate service. Represents a row in the &quot;BRAND_TAXONOMY_XLAT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.BrandTaxonomyTranslateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BrandTaxonomyTranslateImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomyTranslateImpl
 * @see com.ihg.brandstandards.db.model.BrandTaxonomyTranslate
 * @see com.ihg.brandstandards.db.model.BrandTaxonomyTranslateModel
 * @generated
 */
public class BrandTaxonomyTranslateModelImpl extends BaseModelImpl<BrandTaxonomyTranslate>
	implements BrandTaxonomyTranslateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a brand taxonomy translate model instance should use the {@link com.ihg.brandstandards.db.model.BrandTaxonomyTranslate} interface instead.
	 */
	public static final String TABLE_NAME = "BRAND_TAXONOMY_XLAT";
	public static final Object[][] TABLE_COLUMNS = {
			{ "BRAND_TAXONOMY_ID", Types.BIGINT },
			{ "LOCALE_CD", Types.VARCHAR },
			{ "TITLE_TXT", Types.VARCHAR },
			{ "BRAND_TAXONOMY_DESC", Types.VARCHAR },
			{ "IMAGE_PATH_TXT", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table BRAND_TAXONOMY_XLAT (BRAND_TAXONOMY_ID LONG not null,LOCALE_CD VARCHAR(75) not null,TITLE_TXT VARCHAR(75) null,BRAND_TAXONOMY_DESC VARCHAR(75) null,IMAGE_PATH_TXT VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,primary key (BRAND_TAXONOMY_ID, LOCALE_CD))";
	public static final String TABLE_SQL_DROP = "drop table BRAND_TAXONOMY_XLAT";
	public static final String ORDER_BY_JPQL = " ORDER BY brandTaxonomyTranslate.id.brandTaxId ASC, brandTaxonomyTranslate.id.localeCd ASC";
	public static final String ORDER_BY_SQL = " ORDER BY BRAND_TAXONOMY_XLAT.BRAND_TAXONOMY_ID ASC, BRAND_TAXONOMY_XLAT.LOCALE_CD ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.BrandTaxonomyTranslate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.BrandTaxonomyTranslate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.BrandTaxonomyTranslate"));

	public BrandTaxonomyTranslateModelImpl() {
	}

	@Override
	public BrandTaxonomyTranslatePK getPrimaryKey() {
		return new BrandTaxonomyTranslatePK(_brandTaxId, _localeCd);
	}

	@Override
	public void setPrimaryKey(BrandTaxonomyTranslatePK primaryKey) {
		setBrandTaxId(primaryKey.brandTaxId);
		setLocaleCd(primaryKey.localeCd);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new BrandTaxonomyTranslatePK(_brandTaxId, _localeCd);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BrandTaxonomyTranslatePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return BrandTaxonomyTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return BrandTaxonomyTranslate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brandTaxId", getBrandTaxId());
		attributes.put("localeCd", getLocaleCd());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brandTaxId = (Long)attributes.get("brandTaxId");

		if (brandTaxId != null) {
			setBrandTaxId(brandTaxId);
		}

		String localeCd = (String)attributes.get("localeCd");

		if (localeCd != null) {
			setLocaleCd(localeCd);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		String imageLoc = (String)attributes.get("imageLoc");

		if (imageLoc != null) {
			setImageLoc(imageLoc);
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
	public long getBrandTaxId() {
		return _brandTaxId;
	}

	@Override
	public void setBrandTaxId(long brandTaxId) {
		_brandTaxId = brandTaxId;
	}

	@Override
	public String getLocaleCd() {
		if (_localeCd == null) {
			return StringPool.BLANK;
		}
		else {
			return _localeCd;
		}
	}

	@Override
	public void setLocaleCd(String localeCd) {
		_localeCd = localeCd;
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
	public String getDesc() {
		if (_desc == null) {
			return StringPool.BLANK;
		}
		else {
			return _desc;
		}
	}

	@Override
	public void setDesc(String desc) {
		_desc = desc;
	}

	@Override
	public String getImageLoc() {
		if (_imageLoc == null) {
			return StringPool.BLANK;
		}
		else {
			return _imageLoc;
		}
	}

	@Override
	public void setImageLoc(String imageLoc) {
		_imageLoc = imageLoc;
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

	@Override
	public BrandTaxonomyTranslate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (BrandTaxonomyTranslate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BrandTaxonomyTranslateImpl brandTaxonomyTranslateImpl = new BrandTaxonomyTranslateImpl();

		brandTaxonomyTranslateImpl.setBrandTaxId(getBrandTaxId());
		brandTaxonomyTranslateImpl.setLocaleCd(getLocaleCd());
		brandTaxonomyTranslateImpl.setTitle(getTitle());
		brandTaxonomyTranslateImpl.setDesc(getDesc());
		brandTaxonomyTranslateImpl.setImageLoc(getImageLoc());
		brandTaxonomyTranslateImpl.setCreatorId(getCreatorId());
		brandTaxonomyTranslateImpl.setCreatedDate(getCreatedDate());
		brandTaxonomyTranslateImpl.setUpdatedBy(getUpdatedBy());
		brandTaxonomyTranslateImpl.setUpdatedDate(getUpdatedDate());

		brandTaxonomyTranslateImpl.resetOriginalValues();

		return brandTaxonomyTranslateImpl;
	}

	@Override
	public int compareTo(BrandTaxonomyTranslate brandTaxonomyTranslate) {
		BrandTaxonomyTranslatePK primaryKey = brandTaxonomyTranslate.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BrandTaxonomyTranslate)) {
			return false;
		}

		BrandTaxonomyTranslate brandTaxonomyTranslate = (BrandTaxonomyTranslate)obj;

		BrandTaxonomyTranslatePK primaryKey = brandTaxonomyTranslate.getPrimaryKey();

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
	public CacheModel<BrandTaxonomyTranslate> toCacheModel() {
		BrandTaxonomyTranslateCacheModel brandTaxonomyTranslateCacheModel = new BrandTaxonomyTranslateCacheModel();

		brandTaxonomyTranslateCacheModel.brandTaxId = getBrandTaxId();

		brandTaxonomyTranslateCacheModel.localeCd = getLocaleCd();

		String localeCd = brandTaxonomyTranslateCacheModel.localeCd;

		if ((localeCd != null) && (localeCd.length() == 0)) {
			brandTaxonomyTranslateCacheModel.localeCd = null;
		}

		brandTaxonomyTranslateCacheModel.title = getTitle();

		String title = brandTaxonomyTranslateCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			brandTaxonomyTranslateCacheModel.title = null;
		}

		brandTaxonomyTranslateCacheModel.desc = getDesc();

		String desc = brandTaxonomyTranslateCacheModel.desc;

		if ((desc != null) && (desc.length() == 0)) {
			brandTaxonomyTranslateCacheModel.desc = null;
		}

		brandTaxonomyTranslateCacheModel.imageLoc = getImageLoc();

		String imageLoc = brandTaxonomyTranslateCacheModel.imageLoc;

		if ((imageLoc != null) && (imageLoc.length() == 0)) {
			brandTaxonomyTranslateCacheModel.imageLoc = null;
		}

		brandTaxonomyTranslateCacheModel.creatorId = getCreatorId();

		String creatorId = brandTaxonomyTranslateCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			brandTaxonomyTranslateCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			brandTaxonomyTranslateCacheModel.createdDate = createdDate.getTime();
		}
		else {
			brandTaxonomyTranslateCacheModel.createdDate = Long.MIN_VALUE;
		}

		brandTaxonomyTranslateCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = brandTaxonomyTranslateCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			brandTaxonomyTranslateCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			brandTaxonomyTranslateCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			brandTaxonomyTranslateCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return brandTaxonomyTranslateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{brandTaxId=");
		sb.append(getBrandTaxId());
		sb.append(", localeCd=");
		sb.append(getLocaleCd());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", imageLoc=");
		sb.append(getImageLoc());
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
		sb.append("com.ihg.brandstandards.db.model.BrandTaxonomyTranslate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>brandTaxId</column-name><column-value><![CDATA[");
		sb.append(getBrandTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCd</column-name><column-value><![CDATA[");
		sb.append(getLocaleCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desc</column-name><column-value><![CDATA[");
		sb.append(getDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageLoc</column-name><column-value><![CDATA[");
		sb.append(getImageLoc());
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

	private static ClassLoader _classLoader = BrandTaxonomyTranslate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			BrandTaxonomyTranslate.class
		};
	private long _brandTaxId;
	private String _localeCd;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BrandTaxonomyTranslate _escapedModel;
}