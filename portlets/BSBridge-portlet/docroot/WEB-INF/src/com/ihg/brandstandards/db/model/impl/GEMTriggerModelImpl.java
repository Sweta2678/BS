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

import com.ihg.brandstandards.db.model.GEMTrigger;
import com.ihg.brandstandards.db.model.GEMTriggerModel;

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
 * The base model implementation for the GEMTrigger service. Represents a row in the &quot;GEM_TRIGGER&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.GEMTriggerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GEMTriggerImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTriggerImpl
 * @see com.ihg.brandstandards.db.model.GEMTrigger
 * @see com.ihg.brandstandards.db.model.GEMTriggerModel
 * @generated
 */
public class GEMTriggerModelImpl extends BaseModelImpl<GEMTrigger>
	implements GEMTriggerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a g e m trigger model instance should use the {@link com.ihg.brandstandards.db.model.GEMTrigger} interface instead.
	 */
	public static final String TABLE_NAME = "GEM_TRIGGER";
	public static final Object[][] TABLE_COLUMNS = {
			{ "GEM_TRIGGER_ID", Types.BIGINT },
			{ "GEM_PUBLISH_DEPT_ID", Types.BIGINT },
			{ "PUBLISH_ID", Types.BIGINT },
			{ "TRIGGER_QSTN_TXT", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table GEM_TRIGGER (GEM_TRIGGER_ID LONG not null primary key,GEM_PUBLISH_DEPT_ID LONG,PUBLISH_ID LONG,TRIGGER_QSTN_TXT VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table GEM_TRIGGER";
	public static final String ORDER_BY_JPQL = " ORDER BY gemTrigger.triggerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GEM_TRIGGER.GEM_TRIGGER_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.GEMTrigger"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.GEMTrigger"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.GEMTrigger"),
			true);
	public static long PUBLISHID_COLUMN_BITMASK = 1L;
	public static long QUESTION_COLUMN_BITMASK = 2L;
	public static long TRIGGERID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.GEMTrigger"));

	public GEMTriggerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _triggerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTriggerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _triggerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTrigger.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTrigger.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("triggerId", getTriggerId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("question", getQuestion());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long triggerId = (Long)attributes.get("triggerId");

		if (triggerId != null) {
			setTriggerId(triggerId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
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
	public long getTriggerId() {
		return _triggerId;
	}

	@Override
	public void setTriggerId(long triggerId) {
		_columnBitmask = -1L;

		_triggerId = triggerId;
	}

	@Override
	public long getPublishDeptId() {
		return _publishDeptId;
	}

	@Override
	public void setPublishDeptId(long publishDeptId) {
		_publishDeptId = publishDeptId;
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_columnBitmask |= PUBLISHID_COLUMN_BITMASK;

		if (!_setOriginalPublishId) {
			_setOriginalPublishId = true;

			_originalPublishId = _publishId;
		}

		_publishId = publishId;
	}

	public long getOriginalPublishId() {
		return _originalPublishId;
	}

	@Override
	public String getQuestion() {
		if (_question == null) {
			return StringPool.BLANK;
		}
		else {
			return _question;
		}
	}

	@Override
	public void setQuestion(String question) {
		_columnBitmask |= QUESTION_COLUMN_BITMASK;

		if (_originalQuestion == null) {
			_originalQuestion = _question;
		}

		_question = question;
	}

	public String getOriginalQuestion() {
		return GetterUtil.getString(_originalQuestion);
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
			GEMTrigger.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public GEMTrigger toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (GEMTrigger)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		GEMTriggerImpl gemTriggerImpl = new GEMTriggerImpl();

		gemTriggerImpl.setTriggerId(getTriggerId());
		gemTriggerImpl.setPublishDeptId(getPublishDeptId());
		gemTriggerImpl.setPublishId(getPublishId());
		gemTriggerImpl.setQuestion(getQuestion());
		gemTriggerImpl.setCreatorId(getCreatorId());
		gemTriggerImpl.setCreatedDate(getCreatedDate());
		gemTriggerImpl.setUpdatedBy(getUpdatedBy());
		gemTriggerImpl.setUpdatedDate(getUpdatedDate());

		gemTriggerImpl.resetOriginalValues();

		return gemTriggerImpl;
	}

	@Override
	public int compareTo(GEMTrigger gemTrigger) {
		int value = 0;

		if (getTriggerId() < gemTrigger.getTriggerId()) {
			value = -1;
		}
		else if (getTriggerId() > gemTrigger.getTriggerId()) {
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

		if (!(obj instanceof GEMTrigger)) {
			return false;
		}

		GEMTrigger gemTrigger = (GEMTrigger)obj;

		long primaryKey = gemTrigger.getPrimaryKey();

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
		GEMTriggerModelImpl gemTriggerModelImpl = this;

		gemTriggerModelImpl._originalPublishId = gemTriggerModelImpl._publishId;

		gemTriggerModelImpl._setOriginalPublishId = false;

		gemTriggerModelImpl._originalQuestion = gemTriggerModelImpl._question;

		gemTriggerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<GEMTrigger> toCacheModel() {
		GEMTriggerCacheModel gemTriggerCacheModel = new GEMTriggerCacheModel();

		gemTriggerCacheModel.triggerId = getTriggerId();

		gemTriggerCacheModel.publishDeptId = getPublishDeptId();

		gemTriggerCacheModel.publishId = getPublishId();

		gemTriggerCacheModel.question = getQuestion();

		String question = gemTriggerCacheModel.question;

		if ((question != null) && (question.length() == 0)) {
			gemTriggerCacheModel.question = null;
		}

		gemTriggerCacheModel.creatorId = getCreatorId();

		String creatorId = gemTriggerCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			gemTriggerCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			gemTriggerCacheModel.createdDate = createdDate.getTime();
		}
		else {
			gemTriggerCacheModel.createdDate = Long.MIN_VALUE;
		}

		gemTriggerCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = gemTriggerCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			gemTriggerCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			gemTriggerCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			gemTriggerCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return gemTriggerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{triggerId=");
		sb.append(getTriggerId());
		sb.append(", publishDeptId=");
		sb.append(getPublishDeptId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", question=");
		sb.append(getQuestion());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMTrigger");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>triggerId</column-name><column-value><![CDATA[");
		sb.append(getTriggerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDeptId</column-name><column-value><![CDATA[");
		sb.append(getPublishDeptId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>question</column-name><column-value><![CDATA[");
		sb.append(getQuestion());
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

	private static ClassLoader _classLoader = GEMTrigger.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			GEMTrigger.class
		};
	private long _triggerId;
	private long _publishDeptId;
	private long _publishId;
	private long _originalPublishId;
	private boolean _setOriginalPublishId;
	private String _question;
	private String _originalQuestion;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _columnBitmask;
	private GEMTrigger _escapedModel;
}