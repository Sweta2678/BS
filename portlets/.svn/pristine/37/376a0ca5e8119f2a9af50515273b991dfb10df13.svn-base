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
import com.ihg.brandstandards.db.service.TaxonomyExtLocalServiceUtil;

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
public class TaxonomyExtClp extends BaseModelImpl<TaxonomyExt>
	implements TaxonomyExt {
	public TaxonomyExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TaxonomyExt.class;
	}

	@Override
	public String getModelClassName() {
		return TaxonomyExt.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _taxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxId", getTaxId());
		attributes.put("parentId", getParentId());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("lvl", getLvl());
		attributes.put("path", getPath());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("indexOrder", getIndexOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taxId = (Long)attributes.get("taxId");

		if (taxId != null) {
			setTaxId(taxId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		String imageLoc = (String)attributes.get("imageLoc");

		if (imageLoc != null) {
			setImageLoc(imageLoc);
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

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}
	}

	@Override
	public long getTaxId() {
		return _taxId;
	}

	@Override
	public void setTaxId(long taxId) {
		_taxId = taxId;

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxId", long.class);

				method.invoke(_taxonomyExtRemoteModel, taxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_taxonomyExtRemoteModel, parentId);
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

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_taxonomyExtRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesc() {
		return _desc;
	}

	@Override
	public void setDesc(String desc) {
		_desc = desc;

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setDesc", String.class);

				method.invoke(_taxonomyExtRemoteModel, desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageLoc() {
		return _imageLoc;
	}

	@Override
	public void setImageLoc(String imageLoc) {
		_imageLoc = imageLoc;

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setImageLoc", String.class);

				method.invoke(_taxonomyExtRemoteModel, imageLoc);
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

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLvl", String.class);

				method.invoke(_taxonomyExtRemoteModel, lvl);
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

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPath", String.class);

				method.invoke(_taxonomyExtRemoteModel, path);
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

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelSortOrder", long.class);

				method.invoke(_taxonomyExtRemoteModel, levelSortOrder);
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

		if (_taxonomyExtRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexOrder", long.class);

				method.invoke(_taxonomyExtRemoteModel, indexOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTaxonomyExtRemoteModel() {
		return _taxonomyExtRemoteModel;
	}

	public void setTaxonomyExtRemoteModel(BaseModel<?> taxonomyExtRemoteModel) {
		_taxonomyExtRemoteModel = taxonomyExtRemoteModel;
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

		Class<?> remoteModelClass = _taxonomyExtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_taxonomyExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TaxonomyExtLocalServiceUtil.addTaxonomyExt(this);
		}
		else {
			TaxonomyExtLocalServiceUtil.updateTaxonomyExt(this);
		}
	}

	@Override
	public TaxonomyExt toEscapedModel() {
		return (TaxonomyExt)ProxyUtil.newProxyInstance(TaxonomyExt.class.getClassLoader(),
			new Class[] { TaxonomyExt.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaxonomyExtClp clone = new TaxonomyExtClp();

		clone.setTaxId(getTaxId());
		clone.setParentId(getParentId());
		clone.setTitle(getTitle());
		clone.setDesc(getDesc());
		clone.setImageLoc(getImageLoc());
		clone.setLvl(getLvl());
		clone.setPath(getPath());
		clone.setLevelSortOrder(getLevelSortOrder());
		clone.setIndexOrder(getIndexOrder());

		return clone;
	}

	@Override
	public int compareTo(TaxonomyExt taxonomyExt) {
		long primaryKey = taxonomyExt.getPrimaryKey();

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

		if (!(obj instanceof TaxonomyExtClp)) {
			return false;
		}

		TaxonomyExtClp taxonomyExt = (TaxonomyExtClp)obj;

		long primaryKey = taxonomyExt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{taxId=");
		sb.append(getTaxId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", imageLoc=");
		sb.append(getImageLoc());
		sb.append(", lvl=");
		sb.append(getLvl());
		sb.append(", path=");
		sb.append(getPath());
		sb.append(", levelSortOrder=");
		sb.append(getLevelSortOrder());
		sb.append(", indexOrder=");
		sb.append(getIndexOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.TaxonomyExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taxId</column-name><column-value><![CDATA[");
		sb.append(getTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desc</column-name><column-value><![CDATA[");
		sb.append(getDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageLoc</column-name><column-value><![CDATA[");
		sb.append(getImageLoc());
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
			"<column><column-name>indexOrder</column-name><column-value><![CDATA[");
		sb.append(getIndexOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _taxId;
	private long _parentId;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _lvl;
	private String _path;
	private long _levelSortOrder;
	private long _indexOrder;
	private BaseModel<?> _taxonomyExtRemoteModel;
}