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

package com.ihg.brandstandards.db.model;

import com.ihg.brandstandards.db.service.BridgePublishStateExLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class BridgePublishStateExClp extends BaseModelImpl<BridgePublishStateEx>
	implements BridgePublishStateEx {
	public BridgePublishStateExClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishStateEx.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishStateEx.class.getName();
	}

	@Override
	public BridgePublishStateExPK getPrimaryKey() {
		return new BridgePublishStateExPK(_publishId, _stdId);
	}

	@Override
	public void setPrimaryKey(BridgePublishStateExPK primaryKey) {
		setPublishId(primaryKey.publishId);
		setStdId(primaryKey.stdId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new BridgePublishStateExPK(_publishId, _stdId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BridgePublishStateExPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("taxonomyTitle", getTaxonomyTitle());
		attributes.put("title", getTitle());
		attributes.put("path", getPath());
		attributes.put("parentStdId", getParentStdId());
		attributes.put("stateCd", getStateCd());
		attributes.put("type", getType());
		attributes.put("manualType", getManualType());
		attributes.put("count", getCount());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("taxonomyId", getTaxonomyId());
		attributes.put("parentTaxonomyId", getParentTaxonomyId());
		attributes.put("indexOrder", getIndexOrder());
		attributes.put("level", getLevel());
		attributes.put("levelSortOrder", getLevelSortOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String taxonomyTitle = (String)attributes.get("taxonomyTitle");

		if (taxonomyTitle != null) {
			setTaxonomyTitle(taxonomyTitle);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long parentStdId = (Long)attributes.get("parentStdId");

		if (parentStdId != null) {
			setParentStdId(parentStdId);
		}

		String stateCd = (String)attributes.get("stateCd");

		if (stateCd != null) {
			setStateCd(stateCd);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String manualType = (String)attributes.get("manualType");

		if (manualType != null) {
			setManualType(manualType);
		}

		Long count = (Long)attributes.get("count");

		if (count != null) {
			setCount(count);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}

		Long taxonomyId = (Long)attributes.get("taxonomyId");

		if (taxonomyId != null) {
			setTaxonomyId(taxonomyId);
		}

		Long parentTaxonomyId = (Long)attributes.get("parentTaxonomyId");

		if (parentTaxonomyId != null) {
			setParentTaxonomyId(parentTaxonomyId);
		}

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}

		Long level = (Long)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long levelSortOrder = (Long)attributes.get("levelSortOrder");

		if (levelSortOrder != null) {
			setLevelSortOrder(levelSortOrder);
		}
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTaxonomyTitle() {
		return _taxonomyTitle;
	}

	@Override
	public void setTaxonomyTitle(String taxonomyTitle) {
		_taxonomyTitle = taxonomyTitle;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonomyTitle", String.class);

				method.invoke(_bridgePublishStateExRemoteModel, taxonomyTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_bridgePublishStateExRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPath() {
		return _path;
	}

	@Override
	public void setPath(String path) {
		_path = path;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setPath", String.class);

				method.invoke(_bridgePublishStateExRemoteModel, path);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentStdId() {
		return _parentStdId;
	}

	@Override
	public void setParentStdId(long parentStdId) {
		_parentStdId = parentStdId;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setParentStdId", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, parentStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStateCd() {
		return _stateCd;
	}

	@Override
	public void setStateCd(String stateCd) {
		_stateCd = stateCd;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setStateCd", String.class);

				method.invoke(_bridgePublishStateExRemoteModel, stateCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_bridgePublishStateExRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getManualType() {
		return _manualType;
	}

	@Override
	public void setManualType(String manualType) {
		_manualType = manualType;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setManualType", String.class);

				method.invoke(_bridgePublishStateExRemoteModel, manualType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCount() {
		return _count;
	}

	@Override
	public void setCount(long count) {
		_count = count;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setCount", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, count);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisplayOrder() {
		return _displayOrder;
	}

	@Override
	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrder", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, displayOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTaxonomyId() {
		return _taxonomyId;
	}

	@Override
	public void setTaxonomyId(long taxonomyId) {
		_taxonomyId = taxonomyId;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonomyId", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, taxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentTaxonomyId() {
		return _parentTaxonomyId;
	}

	@Override
	public void setParentTaxonomyId(long parentTaxonomyId) {
		_parentTaxonomyId = parentTaxonomyId;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setParentTaxonomyId",
						long.class);

				method.invoke(_bridgePublishStateExRemoteModel, parentTaxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexOrder() {
		return _indexOrder;
	}

	@Override
	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexOrder", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, indexOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel() {
		return _level;
	}

	@Override
	public void setLevel(long level) {
		_level = level;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, level);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevelSortOrder() {
		return _levelSortOrder;
	}

	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_levelSortOrder = levelSortOrder;

		if (_bridgePublishStateExRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishStateExRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelSortOrder", long.class);

				method.invoke(_bridgePublishStateExRemoteModel, levelSortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgePublishStateExRemoteModel() {
		return _bridgePublishStateExRemoteModel;
	}

	public void setBridgePublishStateExRemoteModel(
		BaseModel<?> bridgePublishStateExRemoteModel) {
		_bridgePublishStateExRemoteModel = bridgePublishStateExRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _bridgePublishStateExRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_bridgePublishStateExRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgePublishStateExLocalServiceUtil.addBridgePublishStateEx(this);
		}
		else {
			BridgePublishStateExLocalServiceUtil.updateBridgePublishStateEx(this);
		}
	}

	@Override
	public BridgePublishStateEx toEscapedModel() {
		return (BridgePublishStateEx)ProxyUtil.newProxyInstance(BridgePublishStateEx.class.getClassLoader(),
			new Class[] { BridgePublishStateEx.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgePublishStateExClp clone = new BridgePublishStateExClp();

		clone.setPublishId(getPublishId());
		clone.setStdId(getStdId());
		clone.setTaxonomyTitle(getTaxonomyTitle());
		clone.setTitle(getTitle());
		clone.setPath(getPath());
		clone.setParentStdId(getParentStdId());
		clone.setStateCd(getStateCd());
		clone.setType(getType());
		clone.setManualType(getManualType());
		clone.setCount(getCount());
		clone.setDisplayOrder(getDisplayOrder());
		clone.setTaxonomyId(getTaxonomyId());
		clone.setParentTaxonomyId(getParentTaxonomyId());
		clone.setIndexOrder(getIndexOrder());
		clone.setLevel(getLevel());
		clone.setLevelSortOrder(getLevelSortOrder());

		return clone;
	}

	@Override
	public int compareTo(BridgePublishStateEx bridgePublishStateEx) {
		BridgePublishStateExPK primaryKey = bridgePublishStateEx.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishStateExClp)) {
			return false;
		}

		BridgePublishStateExClp bridgePublishStateEx = (BridgePublishStateExClp)obj;

		BridgePublishStateExPK primaryKey = bridgePublishStateEx.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{publishId=");
		sb.append(getPublishId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", taxonomyTitle=");
		sb.append(getTaxonomyTitle());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", path=");
		sb.append(getPath());
		sb.append(", parentStdId=");
		sb.append(getParentStdId());
		sb.append(", stateCd=");
		sb.append(getStateCd());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", manualType=");
		sb.append(getManualType());
		sb.append(", count=");
		sb.append(getCount());
		sb.append(", displayOrder=");
		sb.append(getDisplayOrder());
		sb.append(", taxonomyId=");
		sb.append(getTaxonomyId());
		sb.append(", parentTaxonomyId=");
		sb.append(getParentTaxonomyId());
		sb.append(", indexOrder=");
		sb.append(getIndexOrder());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", levelSortOrder=");
		sb.append(getLevelSortOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgePublishStateEx");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxonomyTitle</column-name><column-value><![CDATA[");
		sb.append(getTaxonomyTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentStdId</column-name><column-value><![CDATA[");
		sb.append(getParentStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stateCd</column-name><column-value><![CDATA[");
		sb.append(getStateCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manualType</column-name><column-value><![CDATA[");
		sb.append(getManualType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>count</column-name><column-value><![CDATA[");
		sb.append(getCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrder</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxonomyId</column-name><column-value><![CDATA[");
		sb.append(getTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentTaxonomyId</column-name><column-value><![CDATA[");
		sb.append(getParentTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexOrder</column-name><column-value><![CDATA[");
		sb.append(getIndexOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelSortOrder</column-name><column-value><![CDATA[");
		sb.append(getLevelSortOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _publishId;
	private long _stdId;
	private String _taxonomyTitle;
	private String _title;
	private String _path;
	private long _parentStdId;
	private String _stateCd;
	private String _type;
	private String _manualType;
	private long _count;
	private long _displayOrder;
	private long _taxonomyId;
	private long _parentTaxonomyId;
	private long _indexOrder;
	private long _level;
	private long _levelSortOrder;
	private BaseModel<?> _bridgePublishStateExRemoteModel;
}