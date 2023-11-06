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

import com.ihg.brandstandards.db.model.TreeXML;
import com.ihg.brandstandards.db.model.TreeXMLModel;

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
 * The base model implementation for the TreeXML service. Represents a row in the &quot;XML&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.brandstandards.db.model.TreeXMLModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TreeXMLImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see TreeXMLImpl
 * @see com.ihg.brandstandards.db.model.TreeXML
 * @see com.ihg.brandstandards.db.model.TreeXMLModel
 * @generated
 */
public class TreeXMLModelImpl extends BaseModelImpl<TreeXML>
	implements TreeXMLModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a tree x m l model instance should use the {@link com.ihg.brandstandards.db.model.TreeXML} interface instead.
	 */
	public static final String TABLE_NAME = "XML";
	public static final Object[][] TABLE_COLUMNS = {
			{ "XML_ID", Types.BIGINT },
			{ "XML_CLOB", Types.VARCHAR },
			{ "CREAT_USR_ID", Types.VARCHAR },
			{ "CREAT_TS", Types.TIMESTAMP },
			{ "LST_UPDT_USR_ID", Types.VARCHAR },
			{ "LST_UPDT_TS", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table XML (XML_ID LONG not null primary key,XML_CLOB VARCHAR(75) null,CREAT_USR_ID VARCHAR(75) null,CREAT_TS DATE null,LST_UPDT_USR_ID VARCHAR(75) null,LST_UPDT_TS DATE null)";
	public static final String TABLE_SQL_DROP = "drop table XML";
	public static final String ORDER_BY_JPQL = " ORDER BY treeXML.ID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY XML.XML_ID ASC";
	public static final String DATA_SOURCE = "brandstandDataSource";
	public static final String SESSION_FACTORY = "BRNDSTNDSessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.brandstandards.db.model.TreeXML"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.brandstandards.db.model.TreeXML"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.brandstandards.db.model.TreeXML"));

	public TreeXMLModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TreeXML.class;
	}

	@Override
	public String getModelClassName() {
		return TreeXML.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("XMLLOB", getXMLLOB());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID = (Long)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String XMLLOB = (String)attributes.get("XMLLOB");

		if (XMLLOB != null) {
			setXMLLOB(XMLLOB);
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
	public long getID() {
		return _ID;
	}

	@Override
	public void setID(long ID) {
		_ID = ID;
	}

	@Override
	public String getXMLLOB() {
		if (_XMLLOB == null) {
			return StringPool.BLANK;
		}
		else {
			return _XMLLOB;
		}
	}

	@Override
	public void setXMLLOB(String XMLLOB) {
		_XMLLOB = XMLLOB;
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
			TreeXML.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TreeXML toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TreeXML)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TreeXMLImpl treeXMLImpl = new TreeXMLImpl();

		treeXMLImpl.setID(getID());
		treeXMLImpl.setXMLLOB(getXMLLOB());
		treeXMLImpl.setCreatorId(getCreatorId());
		treeXMLImpl.setCreatedDate(getCreatedDate());
		treeXMLImpl.setUpdatedBy(getUpdatedBy());
		treeXMLImpl.setUpdatedDate(getUpdatedDate());

		treeXMLImpl.resetOriginalValues();

		return treeXMLImpl;
	}

	@Override
	public int compareTo(TreeXML treeXML) {
		long primaryKey = treeXML.getPrimaryKey();

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

		if (!(obj instanceof TreeXML)) {
			return false;
		}

		TreeXML treeXML = (TreeXML)obj;

		long primaryKey = treeXML.getPrimaryKey();

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
	public CacheModel<TreeXML> toCacheModel() {
		TreeXMLCacheModel treeXMLCacheModel = new TreeXMLCacheModel();

		treeXMLCacheModel.ID = getID();

		treeXMLCacheModel.XMLLOB = getXMLLOB();

		String XMLLOB = treeXMLCacheModel.XMLLOB;

		if ((XMLLOB != null) && (XMLLOB.length() == 0)) {
			treeXMLCacheModel.XMLLOB = null;
		}

		treeXMLCacheModel.creatorId = getCreatorId();

		String creatorId = treeXMLCacheModel.creatorId;

		if ((creatorId != null) && (creatorId.length() == 0)) {
			treeXMLCacheModel.creatorId = null;
		}

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			treeXMLCacheModel.createdDate = createdDate.getTime();
		}
		else {
			treeXMLCacheModel.createdDate = Long.MIN_VALUE;
		}

		treeXMLCacheModel.updatedBy = getUpdatedBy();

		String updatedBy = treeXMLCacheModel.updatedBy;

		if ((updatedBy != null) && (updatedBy.length() == 0)) {
			treeXMLCacheModel.updatedBy = null;
		}

		Date updatedDate = getUpdatedDate();

		if (updatedDate != null) {
			treeXMLCacheModel.updatedDate = updatedDate.getTime();
		}
		else {
			treeXMLCacheModel.updatedDate = Long.MIN_VALUE;
		}

		return treeXMLCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ID=");
		sb.append(getID());
		sb.append(", XMLLOB=");
		sb.append(getXMLLOB());
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
		sb.append("com.ihg.brandstandards.db.model.TreeXML");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ID</column-name><column-value><![CDATA[");
		sb.append(getID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>XMLLOB</column-name><column-value><![CDATA[");
		sb.append(getXMLLOB());
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

	private static ClassLoader _classLoader = TreeXML.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			TreeXML.class
		};
	private long _ID;
	private String _XMLLOB;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private TreeXML _escapedModel;
}