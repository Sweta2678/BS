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

import com.ihg.brandstandards.db.model.GEMStdCategory;
import com.ihg.brandstandards.db.model.GEMStdCategoryModel;

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
 * The base model implementation for the GEMStdCategory service. Represents a row in the &quot;GEM_STD_CATGY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.GEMStdCategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GEMStdCategoryImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMStdCategoryImpl
 * @see com.ihg.brandstandards.db.model.GEMStdCategory
 * @see com.ihg.brandstandards.db.model.GEMStdCategoryModel
 * @generated
 */
public class GEMStdCategoryModelImpl extends BaseModelImpl<GEMStdCategory>
	implements GEMStdCategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a g e m std category model instance should use the {@link com.ihg.brandstandards.db.model.GEMStdCategory} interface instead.
	 */
	public static final String TABLE_NAME = "GEM_STD_CATGY";
	public static final Object[][] TABLE_COLUMNS = {
			{ "GEM_STD_CATGY_ID", Types.BIGINT },
			{ "STD_ID", Types.BIGINT },
			{ "GEM_CATGY_ID", Types.BIGINT },
			{ "TEMPLATE_TYP_CD", Types.VARCHAR },
			{ "CHAIN_CD", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table GEM_STD_CATGY (GEM_STD_CATGY_ID LONG not null primary key,STD_ID LONG,GEM_CATGY_ID LONG,TEMPLATE_TYP_CD VARCHAR(75) null,CHAIN_CD VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table GEM_STD_CATGY";
	public static final String ORDER_BY_JPQL = " ORDER BY gemStdCategory.gemStdCategoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GEM_STD_CATGY.GEM_STD_CATGY_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.GEMStdCategory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.GEMStdCategory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.GEMStdCategory"),
			true);
	public static long CATEGORYID_COLUMN_BITMASK = 1L;
	public static long CHAINCODE_COLUMN_BITMASK = 2L;
	public static long STDID_COLUMN_BITMASK = 4L;
	public static long TEMPLATETYPE_COLUMN_BITMASK = 8L;
	public static long GEMSTDCATEGORYID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.GEMStdCategory"));

	public GEMStdCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _gemStdCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGemStdCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gemStdCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GEMStdCategory.class;
	}

	@Override
	public String getModelClassName() {
		return GEMStdCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gemStdCategoryId", getGemStdCategoryId());
		attributes.put("stdId", getStdId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("templateType", getTemplateType());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gemStdCategoryId = (Long)attributes.get("gemStdCategoryId");

		if (gemStdCategoryId != null) {
			setGemStdCategoryId(gemStdCategoryId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String templateType = (String)attributes.get("templateType");

		if (templateType != null) {
			setTemplateType(templateType);
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
	public long getGemStdCategoryId() {
		return _gemStdCategoryId;
	}

	@Override
	public void setGemStdCategoryId(long gemStdCategoryId) {
		_columnBitmask = -1L;

		_gemStdCategoryId = gemStdCategoryId;
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
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@Override
	public String getTemplateType() {
		if (_templateType == null) {
			return StringPool.BLANK;
		}
		else {
			return _templateType;
		}
	}

	@Override
	public void setTemplateType(String templateType) {
		_columnBitmask |= TEMPLATETYPE_COLUMN_BITMASK;

		if (_originalTemplateType == null) {
			_originalTemplateType = _templateType;
		}

		_templateType = templateType;
	}

	public String getOriginalTemplateType() {
		return GetterUtil.getString(_originalTemplateType);
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
			GEMStdCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GEMStdCategory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (GEMStdCategory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GEMStdCategoryImpl gemStdCategoryImpl = new GEMStdCategoryImpl();

		gemStdCategoryImpl.setGemStdCategoryId(getGemStdCategoryId());
		gemStdCategoryImpl.setStdId(getStdId());
		gemStdCategoryImpl.setCategoryId(getCategoryId());
		gemStdCategoryImpl.setTemplateType(getTemplateType());
		gemStdCategoryImpl.setChainCode(getChainCode());
		gemStdCategoryImpl.setCreatorId(getCreatorId());
		gemStdCategoryImpl.setCreatedDate(getCreatedDate());
		gemStdCategoryImpl.setUpdatedBy(getUpdatedBy());
		gemStdCategoryImpl.setUpdatedDate(getUpdatedDate());

		gemStdCategoryImpl.resetOriginalValues();

		return gemStdCategoryImpl;
	}

	@Override
	public int compareTo(GEMStdCategory gemStdCategory) {
		int value = 0;

		if (getGemStdCategoryId() < gemStdCategory.getGemStdCategoryId()) {
			value = -1;
		}
		else if (getGemStdCategoryId() > gemStdCategory.getGemStdCategoryId()) {
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

		if (!(obj instanceof GEMStdCategory)) {
			return false;
		}

		GEMStdCategory gemStdCategory = (GEMStdCategory)obj;

		long primaryKey = gemStdCategory.getPrimaryKey();

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
		GEMStdCategoryModelImpl gemStdCategoryModelImpl = this;

		gemStdCategoryModelImpl._originalStdId = gemStdCategoryModelImpl._stdId;

		gemStdCategoryModelImpl._setOriginalStdId = false;

		gemStdCategoryModelImpl._originalCategoryId = gemStdCategoryModelImpl._categoryId;

		gemStdCategoryModelImpl._setOriginalCategoryId = false;

		gemStdCategoryModelImpl._originalTemplateType = gemStdCategoryModelImpl._templateType;

		gemStdCategoryModelImpl._originalChainCode = gemStdCategoryModelImpl._chainCode;

		gemStdCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GEMStdCategory> toCacheModel() {
		GEMStdCategoryCacheModel gemStdCategoryCacheModel = new GEMStdCategoryCacheModel();

		gemStdCategoryCacheModel.gemStdCategoryId = getGemStdCategoryId();

		gemStdCategoryCacheModel.stdId = getStdId();

		gemStdCategoryCacheModel.categoryId = getCategoryId();

		gemStdCategoryCacheModel.templateType = getTemplateType();

		String templateType = gemStdCategoryCacheModel.templateType;

		if ((templateType != null) && (templateType.length() == 0)) {
			gemStdCategoryCacheModel.templateType = null;
		}

		gemStdCategoryCacheModel.chainCode = getChainCode();

		String chainCode = gemStdCategoryCacheModel.chainCode;

		if ((chainCode != null) && (chainCode.length() == 0)) {
			gemStdCategoryCacheModel.chainCode = null;
		}

		gemStdCategoryCacheModel.creatorId = getCreatorId();

		String creatorId = gemStdCategoryCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			gemStdCategoryCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			gemStdCategoryCacheModel.createdDate = createdDate.getTime();
		}
		else {
			gemStdCategoryCacheModel.createdDate = Long.MIN_VALUE;
		}

		gemStdCategoryCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = gemStdCategoryCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			gemStdCategoryCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			gemStdCategoryCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			gemStdCategoryCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return gemStdCategoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{gemStdCategoryId=");
		sb.append(getGemStdCategoryId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", templateType=");
		sb.append(getTemplateType());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMStdCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>gemStdCategoryId</column-name><column-value><![CDATA[");
		sb.append(getGemStdCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateType</column-name><column-value><![CDATA[");
		sb.append(getTemplateType());
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

	private static ClassLoader _classLoader = GEMStdCategory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			GEMStdCategory.class
		};
	private long _gemStdCategoryId;
	private long _stdId;
	private long _originalStdId;
	private boolean _setOriginalStdId;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private String _templateType;
	private String _originalTemplateType;
	private String _chainCode;
	private String _originalChainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private GEMStdCategory _escapedModel;
}