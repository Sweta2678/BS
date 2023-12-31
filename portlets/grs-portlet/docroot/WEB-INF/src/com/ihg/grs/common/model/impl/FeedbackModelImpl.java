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

package com.ihg.grs.common.model.impl;

import com.ihg.grs.common.model.Feedback;
import com.ihg.grs.common.model.FeedbackModel;

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
 * The base model implementation for the Feedback service. Represents a row in the &quot;GRS_COMM.PORTAL_USR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.grs.common.model.FeedbackModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeedbackImpl}.
 * </p>
 *
 * @author gulam.vora
 * @see FeedbackImpl
 * @see com.ihg.grs.common.model.Feedback
 * @see com.ihg.grs.common.model.FeedbackModel
 * @generated
 */
public class FeedbackModelImpl extends BaseModelImpl<Feedback>
	implements FeedbackModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a feedback model instance should use the {@link com.ihg.grs.common.model.Feedback} interface instead.
	 */
	public static final String TABLE_NAME = "GRS_COMM.PORTAL_USR";
	public static final Object[][] TABLE_COLUMNS = {
			{ "PORTAL_USR_ID", Types.INTEGER },
			{ "USR_FRST_NM", Types.VARCHAR },
			{ "USR_LST_NM", Types.VARCHAR },
			{ "BUS_TITLE_NM", Types.VARCHAR },
			{ "USR_EMAIL_ID", Types.VARCHAR },
			{ "ON_BEHALF_OF_NM", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table GRS_COMM.PORTAL_USR (PORTAL_USR_ID INTEGER not null primary key,USR_FRST_NM VARCHAR(75) null,USR_LST_NM VARCHAR(75) null,BUS_TITLE_NM VARCHAR(75) null,USR_EMAIL_ID VARCHAR(75) null,ON_BEHALF_OF_NM VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table GRS_COMM.PORTAL_USR";
	public static final String ORDER_BY_JPQL = " ORDER BY feedback.feedbackId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY GRS_COMM.PORTAL_USR.PORTAL_USR_ID ASC";
	public static final String DATA_SOURCE = "grsDataSource";
	public static final String SESSION_FACTORY = "grsSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.grs.common.model.Feedback"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.grs.common.model.Feedback"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.grs.common.model.Feedback"));

	public FeedbackModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("feedbackId", getFeedbackId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("title", getTitle());
		attributes.put("email", getEmail());
		attributes.put("onBehalfOf", getOnBehalfOf());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createdate", getCreatedate());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("updatedate", getUpdatedate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer feedbackId = (Integer)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String onBehalfOf = (String)attributes.get("onBehalfOf");

		if (onBehalfOf != null) {
			setOnBehalfOf(onBehalfOf);
		}

		String createUserId = (String)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Date createdate = (Date)attributes.get("createdate");

		if (createdate != null) {
			setCreatedate(createdate);
		}

		String lastUpdateUserId = (String)attributes.get("lastUpdateUserId");

		if (lastUpdateUserId != null) {
			setLastUpdateUserId(lastUpdateUserId);
		}

		Date updatedate = (Date)attributes.get("updatedate");

		if (updatedate != null) {
			setUpdatedate(updatedate);
		}
	}

	@Override
	public int getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(int feedbackId) {
		_feedbackId = feedbackId;
	}

	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
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
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getOnBehalfOf() {
		if (_onBehalfOf == null) {
			return StringPool.BLANK;
		}
		else {
			return _onBehalfOf;
		}
	}

	@Override
	public void setOnBehalfOf(String onBehalfOf) {
		_onBehalfOf = onBehalfOf;
	}

	@Override
	public String getCreateUserId() {
		if (_createUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _createUserId;
		}
	}

	@Override
	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;
	}

	@Override
	public Date getCreatedate() {
		return _createdate;
	}

	@Override
	public void setCreatedate(Date createdate) {
		_createdate = createdate;
	}

	@Override
	public String getLastUpdateUserId() {
		if (_lastUpdateUserId == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastUpdateUserId;
		}
	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		_lastUpdateUserId = lastUpdateUserId;
	}

	@Override
	public Date getUpdatedate() {
		return _updatedate;
	}

	@Override
	public void setUpdatedate(Date updatedate) {
		_updatedate = updatedate;
	}

	@Override
	public Feedback toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Feedback)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setFeedbackId(getFeedbackId());
		feedbackImpl.setFirstName(getFirstName());
		feedbackImpl.setLastName(getLastName());
		feedbackImpl.setTitle(getTitle());
		feedbackImpl.setEmail(getEmail());
		feedbackImpl.setOnBehalfOf(getOnBehalfOf());
		feedbackImpl.setCreateUserId(getCreateUserId());
		feedbackImpl.setCreatedate(getCreatedate());
		feedbackImpl.setLastUpdateUserId(getLastUpdateUserId());
		feedbackImpl.setUpdatedate(getUpdatedate());

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int primaryKey = feedback.getPrimaryKey();

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

		if (!(obj instanceof Feedback)) {
			return false;
		}

		Feedback feedback = (Feedback)obj;

		int primaryKey = feedback.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Feedback> toCacheModel() {
		FeedbackCacheModel feedbackCacheModel = new FeedbackCacheModel();

		feedbackCacheModel.feedbackId = getFeedbackId();

		feedbackCacheModel.firstName = getFirstName();

		String firstName = feedbackCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			feedbackCacheModel.firstName = null;
		}

		feedbackCacheModel.lastName = getLastName();

		String lastName = feedbackCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			feedbackCacheModel.lastName = null;
		}

		feedbackCacheModel.title = getTitle();

		String title = feedbackCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			feedbackCacheModel.title = null;
		}

		feedbackCacheModel.email = getEmail();

		String email = feedbackCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			feedbackCacheModel.email = null;
		}

		feedbackCacheModel.onBehalfOf = getOnBehalfOf();

		String onBehalfOf = feedbackCacheModel.onBehalfOf;

		if ((onBehalfOf != null) && (onBehalfOf.length() == 0)) {
			feedbackCacheModel.onBehalfOf = null;
		}

		feedbackCacheModel.createUserId = getCreateUserId();

		String createUserId = feedbackCacheModel.createUserId;

		if ((createUserId != null) && (createUserId.length() == 0)) {
			feedbackCacheModel.createUserId = null;
		}

		Date createdate = getCreatedate();

		if (createdate != null) {
			feedbackCacheModel.createdate = createdate.getTime();
		}
		else {
			feedbackCacheModel.createdate = Long.MIN_VALUE;
		}

		feedbackCacheModel.lastUpdateUserId = getLastUpdateUserId();

		String lastUpdateUserId = feedbackCacheModel.lastUpdateUserId;

		if ((lastUpdateUserId != null) && (lastUpdateUserId.length() == 0)) {
			feedbackCacheModel.lastUpdateUserId = null;
		}

		Date updatedate = getUpdatedate();

		if (updatedate != null) {
			feedbackCacheModel.updatedate = updatedate.getTime();
		}
		else {
			feedbackCacheModel.updatedate = Long.MIN_VALUE;
		}

		return feedbackCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{feedbackId=");
		sb.append(getFeedbackId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", onBehalfOf=");
		sb.append(getOnBehalfOf());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", createdate=");
		sb.append(getCreatedate());
		sb.append(", lastUpdateUserId=");
		sb.append(getLastUpdateUserId());
		sb.append(", updatedate=");
		sb.append(getUpdatedate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.grs.common.model.Feedback");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>onBehalfOf</column-name><column-value><![CDATA[");
		sb.append(getOnBehalfOf());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdate</column-name><column-value><![CDATA[");
		sb.append(getCreatedate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastUpdateUserId</column-name><column-value><![CDATA[");
		sb.append(getLastUpdateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Feedback.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Feedback.class
		};
	private int _feedbackId;
	private String _firstName;
	private String _lastName;
	private String _title;
	private String _email;
	private String _onBehalfOf;
	private String _createUserId;
	private Date _createdate;
	private String _lastUpdateUserId;
	private Date _updatedate;
	private Feedback _escapedModel;
}