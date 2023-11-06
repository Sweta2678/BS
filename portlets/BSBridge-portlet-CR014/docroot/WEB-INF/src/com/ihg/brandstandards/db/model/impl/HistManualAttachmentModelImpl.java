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

import com.ihg.brandstandards.db.model.HistManualAttachment;
import com.ihg.brandstandards.db.model.HistManualAttachmentModel;

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
 * The base model implementation for the HistManualAttachment service. Represents a row in the &quot;MNL_ATTACHMENT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.HistManualAttachmentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HistManualAttachmentImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see HistManualAttachmentImpl
 * @see com.ihg.brandstandards.db.model.HistManualAttachment
 * @see com.ihg.brandstandards.db.model.HistManualAttachmentModel
 * @generated
 */
public class HistManualAttachmentModelImpl extends BaseModelImpl<HistManualAttachment>
	implements HistManualAttachmentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a hist manual attachment model instance should use the {@link com.ihg.brandstandards.db.model.HistManualAttachment} interface instead.
	 */
	public static final String TABLE_NAME = "MNL_ATTACHMENT";
	public static final Object[][] TABLE_COLUMNS = {
			{ "HST_MNL_ID", Types.BIGINT },
			{ "ATTACHMENT_PATH_TXT", Types.VARCHAR },
			{ "CREATE_BY", Types.VARCHAR },
			{ "CREATE_DATE", Types.TIMESTAMP },
			{ "LAST_UPD_BY", Types.VARCHAR },
			{ "LAST_UPD_DATE", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table MNL_ATTACHMENT (HST_MNL_ID LONG not null primary key,ATTACHMENT_PATH_TXT VARCHAR(75) null,CREATE_BY VARCHAR(75) null,CREATE_DATE DATE null,LAST_UPD_BY VARCHAR(75) null,LAST_UPD_DATE DATE null)";
	public static final String TABLE_SQL_DROP = "drop table MNL_ATTACHMENT";
	public static final String ORDER_BY_JPQL = " ORDER BY histManualAttachment.histManualId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY MNL_ATTACHMENT.HST_MNL_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.HistManualAttachment"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.HistManualAttachment"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.HistManualAttachment"));

	public HistManualAttachmentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _histManualId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHistManualId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _histManualId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return HistManualAttachment.class;
	}

	@Override
	public String getModelClassName() {
		return HistManualAttachment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("histManualId", getHistManualId());
		attributes.put("attachmentPath", getAttachmentPath());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long histManualId = (Long)attributes.get("histManualId");

		if (histManualId != null) {
			setHistManualId(histManualId);
		}

		String attachmentPath = (String)attributes.get("attachmentPath");

		if (attachmentPath != null) {
			setAttachmentPath(attachmentPath);
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
	public long getHistManualId() {
		return _histManualId;
	}

	@Override
	public void setHistManualId(long histManualId) {
		_histManualId = histManualId;
	}

	@Override
	public String getAttachmentPath() {
		if (_attachmentPath == null) {
			return StringPool.BLANK;
		}
		else {
			return _attachmentPath;
		}
	}

	@Override
	public void setAttachmentPath(String attachmentPath) {
		_attachmentPath = attachmentPath;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			HistManualAttachment.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public HistManualAttachment toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (HistManualAttachment)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		HistManualAttachmentImpl histManualAttachmentImpl = new HistManualAttachmentImpl();

		histManualAttachmentImpl.setHistManualId(getHistManualId());
		histManualAttachmentImpl.setAttachmentPath(getAttachmentPath());
		histManualAttachmentImpl.setCreatorId(getCreatorId());
		histManualAttachmentImpl.setCreatedDate(getCreatedDate());
		histManualAttachmentImpl.setUpdatedBy(getUpdatedBy());
		histManualAttachmentImpl.setUpdatedDate(getUpdatedDate());

		histManualAttachmentImpl.resetOriginalValues();

		return histManualAttachmentImpl;
	}

	@Override
	public int compareTo(HistManualAttachment histManualAttachment) {
		long primaryKey = histManualAttachment.getPrimaryKey();

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

		if (!(obj instanceof HistManualAttachment)) {
			return false;
		}

		HistManualAttachment histManualAttachment = (HistManualAttachment)obj;

		long primaryKey = histManualAttachment.getPrimaryKey();

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
	}

	@Override
	public CacheModel<HistManualAttachment> toCacheModel() {
		HistManualAttachmentCacheModel histManualAttachmentCacheModel = new HistManualAttachmentCacheModel();

		histManualAttachmentCacheModel.histManualId = getHistManualId();

		histManualAttachmentCacheModel.attachmentPath = getAttachmentPath();

		String attachmentPath = histManualAttachmentCacheModel.attachmentPath;

		if ((attachmentPath != null) && (attachmentPath.length() == 0)) {
			histManualAttachmentCacheModel.attachmentPath = null;
		}

		histManualAttachmentCacheModel.creatorId = getCreatorId();

		String creatorId = histManualAttachmentCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			histManualAttachmentCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			histManualAttachmentCacheModel.createdDate = createdDate.getTime();
		}
		else {
			histManualAttachmentCacheModel.createdDate = Long.MIN_VALUE;
		}

		histManualAttachmentCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = histManualAttachmentCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			histManualAttachmentCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			histManualAttachmentCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			histManualAttachmentCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return histManualAttachmentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{histManualId=");
		sb.append(getHistManualId());
		sb.append(", attachmentPath=");
		sb.append(getAttachmentPath());
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
		sb.append("com.ihg.brandstandards.db.model.HistManualAttachment");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>histManualId</column-name><column-value><![CDATA[");
		sb.append(getHistManualId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentPath</column-name><column-value><![CDATA[");
		sb.append(getAttachmentPath());
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

	private static ClassLoader _classLoader = HistManualAttachment.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			HistManualAttachment.class
		};
	private long _histManualId;
	private String _attachmentPath;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private HistManualAttachment _escapedModel;
}