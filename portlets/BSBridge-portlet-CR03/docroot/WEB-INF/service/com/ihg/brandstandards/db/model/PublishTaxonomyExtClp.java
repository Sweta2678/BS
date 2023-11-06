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
import com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalServiceUtil;

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
public class PublishTaxonomyExtClp extends BaseModelImpl<PublishTaxonomyExt>
	implements PublishTaxonomyExt {
	public PublishTaxonomyExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PublishTaxonomyExt.class;
	}

	@Override
	public String getModelClassName() {
		return PublishTaxonomyExt.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publishTaxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishTaxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishTaxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishTaxId", getPublishTaxId());
		attributes.put("publishParentId", getPublishParentId());
		attributes.put("title", getTitle());
		attributes.put("lvl", getLvl());
		attributes.put("path", getPath());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("publishId", getPublishId());
		attributes.put("indexOrder", getIndexOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishTaxId = (Long)attributes.get("publishTaxId");

		if (publishTaxId != null) {
			setPublishTaxId(publishTaxId);
		}

		Long publishParentId = (Long)attributes.get("publishParentId");

		if (publishParentId != null) {
			setPublishParentId(publishParentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String lvl = (String)attributes.get("lvl");

		if (lvl != null) {
			setLvl(lvl);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long levelSortOrder = (Long)attributes.get("levelSortOrder");

		if (levelSortOrder != null) {
			setLevelSortOrder(levelSortOrder);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}
	}

	@Override
	public long getPublishTaxId() {
		return _publishTaxId;
	}

	@Override
	public void setPublishTaxId(long publishTaxId) {
		_publishTaxId = publishTaxId;

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishTaxId", long.class);

				method.invoke(_publishTaxonomyExtRemoteModel, publishTaxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishParentId() {
		return _publishParentId;
	}

	@Override
	public void setPublishParentId(long publishParentId) {
		_publishParentId = publishParentId;

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishParentId", long.class);

				method.invoke(_publishTaxonomyExtRemoteModel, publishParentId);
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

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_publishTaxonomyExtRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLvl() {
		return _lvl;
	}

	@Override
	public void setLvl(String lvl) {
		_lvl = lvl;

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLvl", String.class);

				method.invoke(_publishTaxonomyExtRemoteModel, lvl);
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

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPath", String.class);

				method.invoke(_publishTaxonomyExtRemoteModel, path);
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

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelSortOrder", long.class);

				method.invoke(_publishTaxonomyExtRemoteModel, levelSortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_publishTaxonomyExtRemoteModel, publishId);
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

		if (_publishTaxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexOrder", long.class);

				method.invoke(_publishTaxonomyExtRemoteModel, indexOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublishTaxonomyExtRemoteModel() {
		return _publishTaxonomyExtRemoteModel;
	}

	public void setPublishTaxonomyExtRemoteModel(
		BaseModel<?> publishTaxonomyExtRemoteModel) {
		_publishTaxonomyExtRemoteModel = publishTaxonomyExtRemoteModel;
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

		Class<?> remoteModelClass = _publishTaxonomyExtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publishTaxonomyExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishTaxonomyExtLocalServiceUtil.addPublishTaxonomyExt(this);
		}
		else {
			PublishTaxonomyExtLocalServiceUtil.updatePublishTaxonomyExt(this);
		}
	}

	@Override
	public PublishTaxonomyExt toEscapedModel() {
		return (PublishTaxonomyExt)ProxyUtil.newProxyInstance(PublishTaxonomyExt.class.getClassLoader(),
			new Class[] { PublishTaxonomyExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishTaxonomyExtClp clone = new PublishTaxonomyExtClp();

		clone.setPublishTaxId(getPublishTaxId());
		clone.setPublishParentId(getPublishParentId());
		clone.setTitle(getTitle());
		clone.setLvl(getLvl());
		clone.setPath(getPath());
		clone.setLevelSortOrder(getLevelSortOrder());
		clone.setPublishId(getPublishId());
		clone.setIndexOrder(getIndexOrder());

		return clone;
	}

	@Override
	public int compareTo(PublishTaxonomyExt publishTaxonomyExt) {
		long primaryKey = publishTaxonomyExt.getPrimaryKey();

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

		if (!(obj instanceof PublishTaxonomyExtClp)) {
			return false;
		}

		PublishTaxonomyExtClp publishTaxonomyExt = (PublishTaxonomyExtClp)obj;

		long primaryKey = publishTaxonomyExt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{publishTaxId=");
		sb.append(getPublishTaxId());
		sb.append(", publishParentId=");
		sb.append(getPublishParentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", lvl=");
		sb.append(getLvl());
		sb.append(", path=");
		sb.append(getPath());
		sb.append(", levelSortOrder=");
		sb.append(getLevelSortOrder());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", indexOrder=");
		sb.append(getIndexOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.PublishTaxonomyExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishTaxId</column-name><column-value><![CDATA[");
		sb.append(getPublishTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishParentId</column-name><column-value><![CDATA[");
		sb.append(getPublishParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lvl</column-name><column-value><![CDATA[");
		sb.append(getLvl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelSortOrder</column-name><column-value><![CDATA[");
		sb.append(getLevelSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexOrder</column-name><column-value><![CDATA[");
		sb.append(getIndexOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _publishTaxId;
	private long _publishParentId;
	private String _title;
	private String _lvl;
	private String _path;
	private long _levelSortOrder;
	private long _publishId;
	private long _indexOrder;
	private BaseModel<?> _publishTaxonomyExtRemoteModel;
}