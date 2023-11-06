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

import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsChainImagesModel;
import com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK;

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
 * The base model implementation for the StandardsChainImages service. Represents a row in the &quot;STD_IMAGE_CHAIN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.StandardsChainImagesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StandardsChainImagesImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsChainImagesImpl
 * @see com.ihg.brandstandards.db.model.StandardsChainImages
 * @see com.ihg.brandstandards.db.model.StandardsChainImagesModel
 * @generated
 */
public class StandardsChainImagesModelImpl extends BaseModelImpl<StandardsChainImages>
	implements StandardsChainImagesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a standards chain images model instance should use the {@link com.ihg.brandstandards.db.model.StandardsChainImages} interface instead.
	 */
	public static final String TABLE_NAME = "STD_IMAGE_CHAIN";
	public static final Object[][] TABLE_COLUMNS = {
			{ "STD_IMAGE_ID", Types.BIGINT },
			{ "CHAIN_CD", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table STD_IMAGE_CHAIN (STD_IMAGE_ID LONG not null,CHAIN_CD VARCHAR(75) not null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,primary key (STD_IMAGE_ID, CHAIN_CD))";
	public static final String TABLE_SQL_DROP = "drop table STD_IMAGE_CHAIN";
	public static final String ORDER_BY_JPQL = " ORDER BY standardsChainImages.id.stdImageId ASC, standardsChainImages.id.chainCode ASC";
	public static final String ORDER_BY_SQL = " ORDER BY STD_IMAGE_CHAIN.STD_IMAGE_ID ASC, STD_IMAGE_CHAIN.CHAIN_CD ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.StandardsChainImages"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.StandardsChainImages"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.StandardsChainImages"),
			true);
	public static long STDIMAGEID_COLUMN_BITMASK = 1L;
	public static long CHAINCODE_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.StandardsChainImages"));

	public StandardsChainImagesModelImpl() {
	}

	@Override
	public StandardsChainImagesPK getPrimaryKey() {
		return new StandardsChainImagesPK(_stdImageId, _chainCode);
	}

	@Override
	public void setPrimaryKey(StandardsChainImagesPK primaryKey) {
		setStdImageId(primaryKey.stdImageId);
		setChainCode(primaryKey.chainCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardsChainImagesPK(_stdImageId, _chainCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardsChainImagesPK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsChainImages.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsChainImages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdImageId", getStdImageId());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdImageId = (Long)attributes.get("stdImageId");

		if (stdImageId != null) {
			setStdImageId(stdImageId);
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
	public long getStdImageId() {
		return _stdImageId;
	}

	@Override
	public void setStdImageId(long stdImageId) {
		_columnBitmask |= STDIMAGEID_COLUMN_BITMASK;

		if (!_setOriginalStdImageId) {
			_setOriginalStdImageId = true;

			_originalStdImageId = _stdImageId;
		}

		_stdImageId = stdImageId;
	}

	public long getOriginalStdImageId() {
		return _originalStdImageId;
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
	public StandardsChainImages toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StandardsChainImages)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StandardsChainImagesImpl standardsChainImagesImpl = new StandardsChainImagesImpl();

		standardsChainImagesImpl.setStdImageId(getStdImageId());
		standardsChainImagesImpl.setChainCode(getChainCode());
		standardsChainImagesImpl.setCreatorId(getCreatorId());
		standardsChainImagesImpl.setCreatedDate(getCreatedDate());
		standardsChainImagesImpl.setUpdatedBy(getUpdatedBy());
		standardsChainImagesImpl.setUpdatedDate(getUpdatedDate());

		standardsChainImagesImpl.resetOriginalValues();

		return standardsChainImagesImpl;
	}

	@Override
	public int compareTo(StandardsChainImages standardsChainImages) {
		StandardsChainImagesPK primaryKey = standardsChainImages.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsChainImages)) {
			return false;
		}

		StandardsChainImages standardsChainImages = (StandardsChainImages)obj;

		StandardsChainImagesPK primaryKey = standardsChainImages.getPrimaryKey();

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
		StandardsChainImagesModelImpl standardsChainImagesModelImpl = this;

		standardsChainImagesModelImpl._originalStdImageId = standardsChainImagesModelImpl._stdImageId;

		standardsChainImagesModelImpl._setOriginalStdImageId = false;

		standardsChainImagesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StandardsChainImages> toCacheModel() {
		StandardsChainImagesCacheModel standardsChainImagesCacheModel = new StandardsChainImagesCacheModel();

		standardsChainImagesCacheModel.stdImageId = getStdImageId();

		standardsChainImagesCacheModel.chainCode = getChainCode();

		String chainCode = standardsChainImagesCacheModel.chainCode;

		if ((chainCode != null) && (chainCode.length() == 0)) {
			standardsChainImagesCacheModel.chainCode = null;
		}

		standardsChainImagesCacheModel.creatorId = getCreatorId();

		String creatorId = standardsChainImagesCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			standardsChainImagesCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			standardsChainImagesCacheModel.createdDate = createdDate.getTime();
		}
		else {
			standardsChainImagesCacheModel.createdDate = Long.MIN_VALUE;
		}

		standardsChainImagesCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = standardsChainImagesCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			standardsChainImagesCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			standardsChainImagesCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			standardsChainImagesCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return standardsChainImagesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{stdImageId=");
		sb.append(getStdImageId());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsChainImages");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdImageId</column-name><column-value><![CDATA[");
		sb.append(getStdImageId());
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

	private static ClassLoader _classLoader = StandardsChainImages.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			StandardsChainImages.class
		};
	private long _stdImageId;
	private long _originalStdImageId;
	private boolean _setOriginalStdImageId;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private StandardsChainImages _escapedModel;
}