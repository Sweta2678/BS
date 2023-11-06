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

import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.MustPublishLocalServiceUtil;

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
public class MustPublishClp extends BaseModelImpl<MustPublish>
	implements MustPublish {
	public MustPublishClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return MustPublish.class;
	}

	@Override
	public String getModelClassName() {
		return MustPublish.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stdId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parentId", getParentId());
		attributes.put("stdId", getStdId());
		attributes.put("title", getTitle());
		attributes.put("stdType", getStdType());
		attributes.put("path", getPath());
		attributes.put("currentPath", getCurrentPath());
		attributes.put("regionCode", getRegionCode());
		attributes.put("amer", getAmer());
		attributes.put("amea", getAmea());
		attributes.put("euro", getEuro());
		attributes.put("gc", getGc());
		attributes.put("status", getStatus());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("taxonomyId", getTaxonomyId());
		attributes.put("parentTaxonomyId", getParentTaxonomyId());
		attributes.put("indexOrder", getIndexOrder());
		attributes.put("level", getLevel());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("framework", getFramework());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String stdType = (String)attributes.get("stdType");

		if (stdType != null) {
			setStdType(stdType);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String currentPath = (String)attributes.get("currentPath");

		if (currentPath != null) {
			setCurrentPath(currentPath);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String amer = (String)attributes.get("amer");

		if (amer != null) {
			setAmer(amer);
		}

		String amea = (String)attributes.get("amea");

		if (amea != null) {
			setAmea(amea);
		}

		String euro = (String)attributes.get("euro");

		if (euro != null) {
			setEuro(euro);
		}

		String gc = (String)attributes.get("gc");

		if (gc != null) {
			setGc(gc);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_mustPublishRemoteModel, parentId);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_mustPublishRemoteModel, stdId);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_mustPublishRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdType() {
		return _stdType;
	}

	@Override
	public void setStdType(String stdType) {
		_stdType = stdType;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setStdType", String.class);

				method.invoke(_mustPublishRemoteModel, stdType);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setPath", String.class);

				method.invoke(_mustPublishRemoteModel, path);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentPath() {
		return _currentPath;
	}

	@Override
	public void setCurrentPath(String currentPath) {
		_currentPath = currentPath;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentPath", String.class);

				method.invoke(_mustPublishRemoteModel, currentPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_mustPublishRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAmer() {
		return _amer;
	}

	@Override
	public void setAmer(String amer) {
		_amer = amer;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setAmer", String.class);

				method.invoke(_mustPublishRemoteModel, amer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAmea() {
		return _amea;
	}

	@Override
	public void setAmea(String amea) {
		_amea = amea;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setAmea", String.class);

				method.invoke(_mustPublishRemoteModel, amea);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEuro() {
		return _euro;
	}

	@Override
	public void setEuro(String euro) {
		_euro = euro;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setEuro", String.class);

				method.invoke(_mustPublishRemoteModel, euro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGc() {
		return _gc;
	}

	@Override
	public void setGc(String gc) {
		_gc = gc;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setGc", String.class);

				method.invoke(_mustPublishRemoteModel, gc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_mustPublishRemoteModel, status);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrder", long.class);

				method.invoke(_mustPublishRemoteModel, displayOrder);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonomyId", long.class);

				method.invoke(_mustPublishRemoteModel, taxonomyId);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setParentTaxonomyId",
						long.class);

				method.invoke(_mustPublishRemoteModel, parentTaxonomyId);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexOrder", long.class);

				method.invoke(_mustPublishRemoteModel, indexOrder);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", long.class);

				method.invoke(_mustPublishRemoteModel, level);
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

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelSortOrder", long.class);

				method.invoke(_mustPublishRemoteModel, levelSortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsGlobal() {
		return _isGlobal;
	}

	@Override
	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setIsGlobal", String.class);

				method.invoke(_mustPublishRemoteModel, isGlobal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFramework() {
		return _framework;
	}

	@Override
	public void setFramework(String framework) {
		_framework = framework;

		if (_mustPublishRemoteModel != null) {
			try {
				Class<?> clazz = _mustPublishRemoteModel.getClass();

				Method method = clazz.getMethod("setFramework", String.class);

				method.invoke(_mustPublishRemoteModel, framework);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getMustPublishRemoteModel() {
		return _mustPublishRemoteModel;
	}

	public void setMustPublishRemoteModel(BaseModel<?> mustPublishRemoteModel) {
		_mustPublishRemoteModel = mustPublishRemoteModel;
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

		Class<?> remoteModelClass = _mustPublishRemoteModel.getClass();

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

		Object returnValue = method.invoke(_mustPublishRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			MustPublishLocalServiceUtil.addMustPublish(this);
		}
		else {
			MustPublishLocalServiceUtil.updateMustPublish(this);
		}
	}

	@Override
	public MustPublish toEscapedModel() {
		return (MustPublish)ProxyUtil.newProxyInstance(MustPublish.class.getClassLoader(),
			new Class[] { MustPublish.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MustPublishClp clone = new MustPublishClp();

		clone.setParentId(getParentId());
		clone.setStdId(getStdId());
		clone.setTitle(getTitle());
		clone.setStdType(getStdType());
		clone.setPath(getPath());
		clone.setCurrentPath(getCurrentPath());
		clone.setRegionCode(getRegionCode());
		clone.setAmer(getAmer());
		clone.setAmea(getAmea());
		clone.setEuro(getEuro());
		clone.setGc(getGc());
		clone.setStatus(getStatus());
		clone.setDisplayOrder(getDisplayOrder());
		clone.setTaxonomyId(getTaxonomyId());
		clone.setParentTaxonomyId(getParentTaxonomyId());
		clone.setIndexOrder(getIndexOrder());
		clone.setLevel(getLevel());
		clone.setLevelSortOrder(getLevelSortOrder());
		clone.setIsGlobal(getIsGlobal());
		clone.setFramework(getFramework());

		return clone;
	}

	@Override
	public int compareTo(MustPublish mustPublish) {
		int value = 0;

		if (getParentId() < mustPublish.getParentId()) {
			value = -1;
		}
		else if (getParentId() > mustPublish.getParentId()) {
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

		if (!(obj instanceof MustPublishClp)) {
			return false;
		}

		MustPublishClp mustPublish = (MustPublishClp)obj;

		long primaryKey = mustPublish.getPrimaryKey();

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
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{parentId=");
		sb.append(getParentId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", stdType=");
		sb.append(getStdType());
		sb.append(", path=");
		sb.append(getPath());
		sb.append(", currentPath=");
		sb.append(getCurrentPath());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", amer=");
		sb.append(getAmer());
		sb.append(", amea=");
		sb.append(getAmea());
		sb.append(", euro=");
		sb.append(getEuro());
		sb.append(", gc=");
		sb.append(getGc());
		sb.append(", status=");
		sb.append(getStatus());
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
		sb.append(", isGlobal=");
		sb.append(getIsGlobal());
		sb.append(", framework=");
		sb.append(getFramework());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.MustPublish");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdType</column-name><column-value><![CDATA[");
		sb.append(getStdType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentPath</column-name><column-value><![CDATA[");
		sb.append(getCurrentPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amer</column-name><column-value><![CDATA[");
		sb.append(getAmer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amea</column-name><column-value><![CDATA[");
		sb.append(getAmea());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>euro</column-name><column-value><![CDATA[");
		sb.append(getEuro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gc</column-name><column-value><![CDATA[");
		sb.append(getGc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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
		sb.append(
			"<column><column-name>isGlobal</column-name><column-value><![CDATA[");
		sb.append(getIsGlobal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>framework</column-name><column-value><![CDATA[");
		sb.append(getFramework());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _parentId;
	private long _stdId;
	private String _title;
	private String _stdType;
	private String _path;
	private String _currentPath;
	private String _regionCode;
	private String _amer;
	private String _amea;
	private String _euro;
	private String _gc;
	private String _status;
	private long _displayOrder;
	private long _taxonomyId;
	private long _parentTaxonomyId;
	private long _indexOrder;
	private long _level;
	private long _levelSortOrder;
	private String _isGlobal;
	private String _framework;
	private BaseModel<?> _mustPublishRemoteModel;
}