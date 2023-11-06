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

import com.ihg.brandstandards.db.model.UserSearchCriteria;
import com.ihg.brandstandards.db.model.UserSearchCriteriaModel;

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
 * The base model implementation for the UserSearchCriteria service. Represents a row in the &quot;USR_SEARCH_CRIT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.UserSearchCriteriaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserSearchCriteriaImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see UserSearchCriteriaImpl
 * @see com.ihg.brandstandards.db.model.UserSearchCriteria
 * @see com.ihg.brandstandards.db.model.UserSearchCriteriaModel
 * @generated
 */
public class UserSearchCriteriaModelImpl extends BaseModelImpl<UserSearchCriteria>
	implements UserSearchCriteriaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user search criteria model instance should use the {@link com.ihg.brandstandards.db.model.UserSearchCriteria} interface instead.
	 */
	public static final String TABLE_NAME = "USR_SEARCH_CRIT";
	public static final Object[][] TABLE_COLUMNS = {
			{ "USR_SEARCH_ID", Types.BIGINT },
			{ "SEARCH_NM", Types.VARCHAR },
			{ "SEARCH_CRIT", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP },
			{ "MODULE_NM", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table USR_SEARCH_CRIT (USR_SEARCH_ID LONG not null primary key,SEARCH_NM VARCHAR(75) null,SEARCH_CRIT VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null,MODULE_NM VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table USR_SEARCH_CRIT";
	public static final String ORDER_BY_JPQL = " ORDER BY userSearchCriteria.userSearchId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY USR_SEARCH_CRIT.USR_SEARCH_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.UserSearchCriteria"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.UserSearchCriteria"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.brandstandards.db.model.UserSearchCriteria"),
			true);
	public static long CREATORID_COLUMN_BITMASK = 1L;
	public static long SEARCHNAME_COLUMN_BITMASK = 2L;
	public static long USERSEARCHID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.UserSearchCriteria"));

	public UserSearchCriteriaModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userSearchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserSearchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userSearchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return UserSearchCriteria.class;
	}

	@Override
	public String getModelClassName() {
		return UserSearchCriteria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userSearchId", getUserSearchId());
		attributes.put("searchName", getSearchName());
		attributes.put("searchCriteria", getSearchCriteria());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("moduleName", getModuleName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userSearchId = (Long)attributes.get("userSearchId");

		if (userSearchId != null) {
			setUserSearchId(userSearchId);
		}

		String searchName = (String)attributes.get("searchName");

		if (searchName != null) {
			setSearchName(searchName);
		}

		String searchCriteria = (String)attributes.get("searchCriteria");

		if (searchCriteria != null) {
			setSearchCriteria(searchCriteria);
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

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}
	}

	@Override
	public long getUserSearchId() {
		return _userSearchId;
	}

	@Override
	public void setUserSearchId(long userSearchId) {
		_userSearchId = userSearchId;
	}

	@Override
	public String getSearchName() {
		if (_searchName == null) {
			return StringPool.BLANK;
		}
		else {
			return _searchName;
		}
	}

	@Override
	public void setSearchName(String searchName) {
		_columnBitmask |= SEARCHNAME_COLUMN_BITMASK;

		if (_originalSearchName == null) {
			_originalSearchName = _searchName;
		}

		_searchName = searchName;
	}

	public String getOriginalSearchName() {
		return GetterUtil.getString(_originalSearchName);
	}

	@Override
	public String getSearchCriteria() {
		if (_searchCriteria == null) {
			return StringPool.BLANK;
		}
		else {
			return _searchCriteria;
		}
	}

	@Override
	public void setSearchCriteria(String searchCriteria) {
		_searchCriteria = searchCriteria;
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
		_columnBitmask |= CREATORID_COLUMN_BITMASK;

		if (_originalCreatorId == null) {
			_originalCreatorId = _creatorId;
		}

		_creatorId = creatorId;
	}

	public String getOriginalCreatorId() {
		return GetterUtil.getString(_originalCreatorId);
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
	public String getModuleName() {
		if (_moduleName == null) {
			return StringPool.BLANK;
		}
		else {
			return _moduleName;
		}
	}

	@Override
	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			UserSearchCriteria.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public UserSearchCriteria toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (UserSearchCriteria)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		UserSearchCriteriaImpl userSearchCriteriaImpl = new UserSearchCriteriaImpl();

		userSearchCriteriaImpl.setUserSearchId(getUserSearchId());
		userSearchCriteriaImpl.setSearchName(getSearchName());
		userSearchCriteriaImpl.setSearchCriteria(getSearchCriteria());
		userSearchCriteriaImpl.setCreatorId(getCreatorId());
		userSearchCriteriaImpl.setCreatedDate(getCreatedDate());
		userSearchCriteriaImpl.setUpdatedBy(getUpdatedBy());
		userSearchCriteriaImpl.setUpdatedDate(getUpdatedDate());
		userSearchCriteriaImpl.setModuleName(getModuleName());

		userSearchCriteriaImpl.resetOriginalValues();

		return userSearchCriteriaImpl;
	}

	@Override
	public int compareTo(UserSearchCriteria userSearchCriteria) {
		long primaryKey = userSearchCriteria.getPrimaryKey();

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

		if (!(obj instanceof UserSearchCriteria)) {
			return false;
		}

		UserSearchCriteria userSearchCriteria = (UserSearchCriteria)obj;

		long primaryKey = userSearchCriteria.getPrimaryKey();

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
		UserSearchCriteriaModelImpl userSearchCriteriaModelImpl = this;

		userSearchCriteriaModelImpl._originalSearchName = userSearchCriteriaModelImpl._searchName;

		userSearchCriteriaModelImpl._originalCreatorId = userSearchCriteriaModelImpl._creatorId;

		userSearchCriteriaModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<UserSearchCriteria> toCacheModel() {
		UserSearchCriteriaCacheModel userSearchCriteriaCacheModel = new UserSearchCriteriaCacheModel();

		userSearchCriteriaCacheModel.userSearchId = getUserSearchId();

		userSearchCriteriaCacheModel.searchName = getSearchName();

		String searchName = userSearchCriteriaCacheModel.searchName;

		if ((searchName != null) && (searchName.length() == 0)) {
			userSearchCriteriaCacheModel.searchName = null;
		}

		userSearchCriteriaCacheModel.searchCriteria = getSearchCriteria();

		String searchCriteria = userSearchCriteriaCacheModel.searchCriteria;

		if ((searchCriteria != null) && (searchCriteria.length() == 0)) {
			userSearchCriteriaCacheModel.searchCriteria = null;
		}

		userSearchCriteriaCacheModel.creatorId = getCreatorId();

		String creatorId = userSearchCriteriaCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			userSearchCriteriaCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			userSearchCriteriaCacheModel.createdDate = createdDate.getTime();
		}
		else {
			userSearchCriteriaCacheModel.createdDate = Long.MIN_VALUE;
		}

		userSearchCriteriaCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = userSearchCriteriaCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			userSearchCriteriaCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			userSearchCriteriaCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			userSearchCriteriaCacheModel.updatedDate = Long.MIN_VALUE;
		}

		userSearchCriteriaCacheModel.moduleName = getModuleName();

		String moduleName = userSearchCriteriaCacheModel.moduleName;

		if ((moduleName != null) && (moduleName.length() == 0)) {
			userSearchCriteriaCacheModel.moduleName = null;
		}

		return userSearchCriteriaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userSearchId=");
		sb.append(getUserSearchId());
		sb.append(", searchName=");
		sb.append(getSearchName());
		sb.append(", searchCriteria=");
		sb.append(getSearchCriteria());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append(", moduleName=");
		sb.append(getModuleName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.UserSearchCriteria");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userSearchId</column-name><column-value><![CDATA[");
		sb.append(getUserSearchId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchName</column-name><column-value><![CDATA[");
		sb.append(getSearchName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>searchCriteria</column-name><column-value><![CDATA[");
		sb.append(getSearchCriteria());
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
		sb.append(
			"<column><column-name>moduleName</column-name><column-value><![CDATA[");
		sb.append(getModuleName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = UserSearchCriteria.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			UserSearchCriteria.class
		};
	private long _userSearchId;
	private String _searchName;
	private String _originalSearchName;
	private String _searchCriteria;
	private String _creatorId;
	private String _originalCreatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private String _moduleName;
	private long _columnBitmask;
	private UserSearchCriteria _escapedModel;
}