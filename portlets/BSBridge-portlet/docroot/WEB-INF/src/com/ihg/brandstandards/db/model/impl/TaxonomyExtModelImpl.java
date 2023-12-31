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

import com.ihg.brandstandards.db.model.TaxonomyExt;
import com.ihg.brandstandards.db.model.TaxonomyExtModel;

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

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the TaxonomyExt service. Represents a row in the &quot;Taxonomy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.TaxonomyExtModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaxonomyExtImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyExtImpl
 * @see com.ihg.brandstandards.db.model.TaxonomyExt
 * @see com.ihg.brandstandards.db.model.TaxonomyExtModel
 * @generated
 */
public class TaxonomyExtModelImpl extends BaseModelImpl<TaxonomyExt>
	implements TaxonomyExtModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a Custom Query mapping to create index path. model instance should use the {@link com.ihg.brandstandards.db.model.TaxonomyExt} interface instead.
	 */
	public static final String TABLE_NAME = "Taxonomy";
	public static final Object[][] TABLE_COLUMNS = {
			{ "TAXONOMY_ID", Types.BIGINT },
			{ "PRNT_TAXONOMY_ID", Types.BIGINT },
			{ "TITLE_TXT", Types.VARCHAR },
			{ "TAXONOMY_DESC", Types.VARCHAR },
			{ "IMAGE_PATH_TXT", Types.VARCHAR },
			{ "LVL", Types.VARCHAR },
			{ "PATH", Types.VARCHAR },
			{ "HIER_LVL_NBR", Types.BIGINT },
			{ "INDX_ORDER", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table Taxonomy (TAXONOMY_ID LONG not null primary key,PRNT_TAXONOMY_ID LONG,TITLE_TXT VARCHAR(75) null,TAXONOMY_DESC VARCHAR(75) null,IMAGE_PATH_TXT VARCHAR(75) null,LVL VARCHAR(75) null,PATH VARCHAR(75) null,HIER_LVL_NBR LONG,INDX_ORDER LONG)";
	public static final String TABLE_SQL_DROP = "drop table Taxonomy";
	public static final String ORDER_BY_JPQL = " ORDER BY taxonomyExt.taxId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Taxonomy.TAXONOMY_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.TaxonomyExt"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.TaxonomyExt"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.TaxonomyExt"),
			true);
	public static long TAXID_COLUMN_BITMASK = 1L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.TaxonomyExt"));

	public TaxonomyExtModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _taxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TaxonomyExt.class;
	}

	@Override
	public String getModelClassName() {
		return TaxonomyExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxId", getTaxId());
		attributes.put("parentId", getParentId());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("lvl", getLvl());
		attributes.put("path", getPath());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("indexOrder", getIndexOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taxId = (Long)attributes.get("taxId");

		if (taxId != null) {
			setTaxId(taxId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
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

		String lvl = (String)attributes.get("lvl");

		if (lvl != null) {
			setLvl(lvl);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long levelSortOrder = (Long)attributes.get("levelSortOrder");

		if (levelSortOrder != null) {
			setLevelSortOrder(levelSortOrder);
		}

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}
	}

	@Override
	public long getTaxId() {
		return _taxId;
	}

	@Override
	public void setTaxId(long taxId) {
		_columnBitmask |= TAXID_COLUMN_BITMASK;

		if (!_setOriginalTaxId) {
			_setOriginalTaxId = true;

			_originalTaxId = _taxId;
		}

		_taxId = taxId;
	}

	public long getOriginalTaxId() {
		return _originalTaxId;
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;
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
	public String getLvl() {
		if (_lvl == null) {
			return StringPool.BLANK;
		}
		else {
			return _lvl;
		}
	}

	@Override
	public void setLvl(String lvl) {
		_lvl = lvl;
	}

	@Override
	public String getPath() {
		if (_path == null) {
			return StringPool.BLANK;
		}
		else {
			return _path;
		}
	}

	@Override
	public void setPath(String path) {
		_path = path;
	}

	@Override
	public long getLevelSortOrder() {
		return _levelSortOrder;
	}

	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_levelSortOrder = levelSortOrder;
	}

	@Override
	public long getIndexOrder() {
		return _indexOrder;
	}

	@Override
	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			TaxonomyExt.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TaxonomyExt toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TaxonomyExt)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TaxonomyExtImpl taxonomyExtImpl = new TaxonomyExtImpl();

		taxonomyExtImpl.setTaxId(getTaxId());
		taxonomyExtImpl.setParentId(getParentId());
		taxonomyExtImpl.setTitle(getTitle());
		taxonomyExtImpl.setDesc(getDesc());
		taxonomyExtImpl.setImageLoc(getImageLoc());
		taxonomyExtImpl.setLvl(getLvl());
		taxonomyExtImpl.setPath(getPath());
		taxonomyExtImpl.setLevelSortOrder(getLevelSortOrder());
		taxonomyExtImpl.setIndexOrder(getIndexOrder());

		taxonomyExtImpl.resetOriginalValues();

		return taxonomyExtImpl;
	}

	@Override
	public int compareTo(TaxonomyExt taxonomyExt) {
		long primaryKey = taxonomyExt.getPrimaryKey();

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

		if (!(obj instanceof TaxonomyExt)) {
			return false;
		}

		TaxonomyExt taxonomyExt = (TaxonomyExt)obj;

		long primaryKey = taxonomyExt.getPrimaryKey();

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
		TaxonomyExtModelImpl taxonomyExtModelImpl = this;

		taxonomyExtModelImpl._originalTaxId = taxonomyExtModelImpl._taxId;

		taxonomyExtModelImpl._setOriginalTaxId = false;

		taxonomyExtModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TaxonomyExt> toCacheModel() {
		TaxonomyExtCacheModel taxonomyExtCacheModel = new TaxonomyExtCacheModel();

		taxonomyExtCacheModel.taxId = getTaxId();

		taxonomyExtCacheModel.parentId = getParentId();

		taxonomyExtCacheModel.title = getTitle();

		String title = taxonomyExtCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			taxonomyExtCacheModel.title = null;
		}

		taxonomyExtCacheModel.desc = getDesc();

		String desc = taxonomyExtCacheModel.desc;

		if ((desc != null) && (desc.length() == 0)) {
			taxonomyExtCacheModel.desc = null;
		}

		taxonomyExtCacheModel.imageLoc = getImageLoc();

		String imageLoc = taxonomyExtCacheModel.imageLoc;

		if ((imageLoc != null) && (imageLoc.length() == 0)) {
			taxonomyExtCacheModel.imageLoc = null;
		}

		taxonomyExtCacheModel.lvl = getLvl();

		String lvl = taxonomyExtCacheModel.lvl;

		if ((lvl != null) && (lvl.length() == 0)) {
			taxonomyExtCacheModel.lvl = null;
		}

		taxonomyExtCacheModel.path = getPath();

		String path = taxonomyExtCacheModel.path;

		if ((path != null) && (path.length() == 0)) {
			taxonomyExtCacheModel.path = null;
		}

		taxonomyExtCacheModel.levelSortOrder = getLevelSortOrder();

		taxonomyExtCacheModel.indexOrder = getIndexOrder();

		return taxonomyExtCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{taxId=");
		sb.append(getTaxId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", imageLoc=");
		sb.append(getImageLoc());
		sb.append(", lvl=");
		sb.append(getLvl());
		sb.append(", path=");
		sb.append(getPath());
		sb.append(", levelSortOrder=");
		sb.append(getLevelSortOrder());
		sb.append(", indexOrder=");
		sb.append(getIndexOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.TaxonomyExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taxId</column-name><column-value><![CDATA[");
		sb.append(getTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
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
			"<column><column-name>lvl</column-name><column-value><![CDATA[");
		sb.append(getLvl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelSortOrder</column-name><column-value><![CDATA[");
		sb.append(getLevelSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexOrder</column-name><column-value><![CDATA[");
		sb.append(getIndexOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = TaxonomyExt.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TaxonomyExt.class
		};
	private long _taxId;
	private long _originalTaxId;
	private boolean _setOriginalTaxId;
	private long _parentId;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _lvl;
	private String _path;
	private long _levelSortOrder;
	private long _indexOrder;
	private long _columnBitmask;
	private TaxonomyExt _escapedModel;
}