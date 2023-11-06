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

import com.ihg.brandstandards.db.model.GEMMeasurement;
import com.ihg.brandstandards.db.model.GEMMeasurementModel;

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
 * The base model implementation for the GEMMeasurement service. Represents a row in the &quot;GEM_MSRMNT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.GEMMeasurementModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GEMMeasurementImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementImpl
 * @see com.ihg.brandstandards.db.model.GEMMeasurement
 * @see com.ihg.brandstandards.db.model.GEMMeasurementModel
 * @generated
 */
public class GEMMeasurementModelImpl extends BaseModelImpl<GEMMeasurement>
	implements GEMMeasurementModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a g e m measurement model instance should use the {@link com.ihg.brandstandards.db.model.GEMMeasurement} interface instead.
	 */
	public static final String TABLE_NAME = "GEM_MSRMNT";
	public static final Object[][] TABLE_COLUMNS = {
			{ "GEM_MSRMNT_ID", Types.BIGINT },
			{ "GEM_MSRMNT_NM", Types.VARCHAR },
			{ "GEM_MSRMNT_TYP_CD", Types.VARCHAR },
			{ "DISP_ORDER_NBR", Types.BIGINT },
			{ "GEM_TEMPLATE_ID", Types.BIGINT },
			{ "GEM_MSRMNT_MULTR_QTY", Types.BIGINT },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table GEM_MSRMNT (GEM_MSRMNT_ID LONG not null primary key,GEM_MSRMNT_NM VARCHAR(75) null,GEM_MSRMNT_TYP_CD VARCHAR(75) null,DISP_ORDER_NBR LONG,GEM_TEMPLATE_ID LONG,GEM_MSRMNT_MULTR_QTY LONG,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table GEM_MSRMNT";
	public static final String ORDER_BY_JPQL = " ORDER BY gemMeasurement.displayOrderNumber ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GEM_MSRMNT.DISP_ORDER_NBR ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.GEMMeasurement"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.GEMMeasurement"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.GEMMeasurement"),
			true);
	public static long MEASUREMENTNAME_COLUMN_BITMASK = 1L;
	public static long MEASUREMENTTYPE_COLUMN_BITMASK = 2L;
	public static long TEMPLATEID_COLUMN_BITMASK = 4L;
	public static long DISPLAYORDERNUMBER_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.GEMMeasurement"));

	public GEMMeasurementModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _measurementId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMeasurementId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _measurementId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurement.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("measurementId", getMeasurementId());
		attributes.put("measurementName", getMeasurementName());
		attributes.put("measurementType", getMeasurementType());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("templateId", getTemplateId());
		attributes.put("multiplierQty", getMultiplierQty());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long measurementId = (Long)attributes.get("measurementId");

		if (measurementId != null) {
			setMeasurementId(measurementId);
		}

		String measurementName = (String)attributes.get("measurementName");

		if (measurementName != null) {
			setMeasurementName(measurementName);
		}

		String measurementType = (String)attributes.get("measurementType");

		if (measurementType != null) {
			setMeasurementType(measurementType);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long multiplierQty = (Long)attributes.get("multiplierQty");

		if (multiplierQty != null) {
			setMultiplierQty(multiplierQty);
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
	public long getMeasurementId() {
		return _measurementId;
	}

	@Override
	public void setMeasurementId(long measurementId) {
		_measurementId = measurementId;
	}

	@Override
	public String getMeasurementName() {
		if (_measurementName == null) {
			return StringPool.BLANK;
		}
		else {
			return _measurementName;
		}
	}

	@Override
	public void setMeasurementName(String measurementName) {
		_columnBitmask |= MEASUREMENTNAME_COLUMN_BITMASK;

		if (_originalMeasurementName == null) {
			_originalMeasurementName = _measurementName;
		}

		_measurementName = measurementName;
	}

	public String getOriginalMeasurementName() {
		return GetterUtil.getString(_originalMeasurementName);
	}

	@Override
	public String getMeasurementType() {
		if (_measurementType == null) {
			return StringPool.BLANK;
		}
		else {
			return _measurementType;
		}
	}

	@Override
	public void setMeasurementType(String measurementType) {
		_columnBitmask |= MEASUREMENTTYPE_COLUMN_BITMASK;

		if (_originalMeasurementType == null) {
			_originalMeasurementType = _measurementType;
		}

		_measurementType = measurementType;
	}

	public String getOriginalMeasurementType() {
		return GetterUtil.getString(_originalMeasurementType);
	}

	@Override
	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_columnBitmask = -1L;

		_displayOrderNumber = displayOrderNumber;
	}

	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_columnBitmask |= TEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalTemplateId) {
			_setOriginalTemplateId = true;

			_originalTemplateId = _templateId;
		}

		_templateId = templateId;
	}

	public long getOriginalTemplateId() {
		return _originalTemplateId;
	}

	@Override
	public long getMultiplierQty() {
		return _multiplierQty;
	}

	@Override
	public void setMultiplierQty(long multiplierQty) {
		_multiplierQty = multiplierQty;
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
			GEMMeasurement.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GEMMeasurement toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (GEMMeasurement)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GEMMeasurementImpl gemMeasurementImpl = new GEMMeasurementImpl();

		gemMeasurementImpl.setMeasurementId(getMeasurementId());
		gemMeasurementImpl.setMeasurementName(getMeasurementName());
		gemMeasurementImpl.setMeasurementType(getMeasurementType());
		gemMeasurementImpl.setDisplayOrderNumber(getDisplayOrderNumber());
		gemMeasurementImpl.setTemplateId(getTemplateId());
		gemMeasurementImpl.setMultiplierQty(getMultiplierQty());
		gemMeasurementImpl.setCreatorId(getCreatorId());
		gemMeasurementImpl.setCreatedDate(getCreatedDate());
		gemMeasurementImpl.setUpdatedBy(getUpdatedBy());
		gemMeasurementImpl.setUpdatedDate(getUpdatedDate());

		gemMeasurementImpl.resetOriginalValues();

		return gemMeasurementImpl;
	}

	@Override
	public int compareTo(GEMMeasurement gemMeasurement) {
		int value = 0;

		if (getDisplayOrderNumber() < gemMeasurement.getDisplayOrderNumber()) {
			value = -1;
		}
		else if (getDisplayOrderNumber() > gemMeasurement.getDisplayOrderNumber()) {
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

		if (!(obj instanceof GEMMeasurement)) {
			return false;
		}

		GEMMeasurement gemMeasurement = (GEMMeasurement)obj;

		long primaryKey = gemMeasurement.getPrimaryKey();

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
		GEMMeasurementModelImpl gemMeasurementModelImpl = this;

		gemMeasurementModelImpl._originalMeasurementName = gemMeasurementModelImpl._measurementName;

		gemMeasurementModelImpl._originalMeasurementType = gemMeasurementModelImpl._measurementType;

		gemMeasurementModelImpl._originalTemplateId = gemMeasurementModelImpl._templateId;

		gemMeasurementModelImpl._setOriginalTemplateId = false;

		gemMeasurementModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GEMMeasurement> toCacheModel() {
		GEMMeasurementCacheModel gemMeasurementCacheModel = new GEMMeasurementCacheModel();

		gemMeasurementCacheModel.measurementId = getMeasurementId();

		gemMeasurementCacheModel.measurementName = getMeasurementName();

		String measurementName = gemMeasurementCacheModel.measurementName;

		if ((measurementName != null) && (measurementName.length() == 0)) {
			gemMeasurementCacheModel.measurementName = null;
		}

		gemMeasurementCacheModel.measurementType = getMeasurementType();

		String measurementType = gemMeasurementCacheModel.measurementType;

		if ((measurementType != null) && (measurementType.length() == 0)) {
			gemMeasurementCacheModel.measurementType = null;
		}

		gemMeasurementCacheModel.displayOrderNumber = getDisplayOrderNumber();

		gemMeasurementCacheModel.templateId = getTemplateId();

		gemMeasurementCacheModel.multiplierQty = getMultiplierQty();

		gemMeasurementCacheModel.creatorId = getCreatorId();

		String creatorId = gemMeasurementCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			gemMeasurementCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			gemMeasurementCacheModel.createdDate = createdDate.getTime();
		}
		else {
			gemMeasurementCacheModel.createdDate = Long.MIN_VALUE;
		}

		gemMeasurementCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = gemMeasurementCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			gemMeasurementCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			gemMeasurementCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			gemMeasurementCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return gemMeasurementCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{measurementId=");
		sb.append(getMeasurementId());
		sb.append(", measurementName=");
		sb.append(getMeasurementName());
		sb.append(", measurementType=");
		sb.append(getMeasurementType());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", multiplierQty=");
		sb.append(getMultiplierQty());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMMeasurement");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>measurementId</column-name><column-value><![CDATA[");
		sb.append(getMeasurementId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementName</column-name><column-value><![CDATA[");
		sb.append(getMeasurementName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>measurementType</column-name><column-value><![CDATA[");
		sb.append(getMeasurementType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>multiplierQty</column-name><column-value><![CDATA[");
		sb.append(getMultiplierQty());
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

	private static ClassLoader _classLoader = GEMMeasurement.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			GEMMeasurement.class
		};
	private long _measurementId;
	private String _measurementName;
	private String _originalMeasurementName;
	private String _measurementType;
	private String _originalMeasurementType;
	private long _displayOrderNumber;
	private long _templateId;
	private long _originalTemplateId;
	private boolean _setOriginalTemplateId;
	private long _multiplierQty;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private GEMMeasurement _escapedModel;
}