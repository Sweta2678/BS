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
import com.ihg.brandstandards.db.service.TaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class TaxonomyTranslateClp extends BaseModelImpl<TaxonomyTranslate>
	implements TaxonomyTranslate {
	public TaxonomyTranslateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TaxonomyTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return TaxonomyTranslate.class.getName();
	}

	@Override
	public TaxonomyTranslatePK getPrimaryKey() {
		return new TaxonomyTranslatePK(_taxId, _localeCode);
	}

	@Override
	public void setPrimaryKey(TaxonomyTranslatePK primaryKey) {
		setTaxId(primaryKey.taxId);
		setLocaleCode(primaryKey.localeCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new TaxonomyTranslatePK(_taxId, _localeCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((TaxonomyTranslatePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxId", getTaxId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long taxId = (Long)attributes.get("taxId");

		if (taxId != null) {
			setTaxId(taxId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
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
	public long getTaxId() {
		return _taxId;
	}

	@Override
	public void setTaxId(long taxId) {
		_taxId = taxId;

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxId", long.class);

				method.invoke(_taxonomyTranslateRemoteModel, taxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocaleCode() {
		return _localeCode;
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_taxonomyTranslateRemoteModel, localeCode);
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

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_taxonomyTranslateRemoteModel, title);
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

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setDesc", String.class);

				method.invoke(_taxonomyTranslateRemoteModel, desc);
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

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setImageLoc", String.class);

				method.invoke(_taxonomyTranslateRemoteModel, imageLoc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_taxonomyTranslateRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_taxonomyTranslateRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdatedBy() {
		return _updatedBy;
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_taxonomyTranslateRemoteModel, updatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;

		if (_taxonomyTranslateRemoteModel != null) {
			try {
				Class<?> clazz = _taxonomyTranslateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_taxonomyTranslateRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTaxonomyTranslateRemoteModel() {
		return _taxonomyTranslateRemoteModel;
	}

	public void setTaxonomyTranslateRemoteModel(
		BaseModel<?> taxonomyTranslateRemoteModel) {
		_taxonomyTranslateRemoteModel = taxonomyTranslateRemoteModel;
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

		Class<?> remoteModelClass = _taxonomyTranslateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_taxonomyTranslateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TaxonomyTranslateLocalServiceUtil.addTaxonomyTranslate(this);
		}
		else {
			TaxonomyTranslateLocalServiceUtil.updateTaxonomyTranslate(this);
		}
	}

	@Override
	public TaxonomyTranslate toEscapedModel() {
		return (TaxonomyTranslate)ProxyUtil.newProxyInstance(TaxonomyTranslate.class.getClassLoader(),
			new Class[] { TaxonomyTranslate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TaxonomyTranslateClp clone = new TaxonomyTranslateClp();

		clone.setTaxId(getTaxId());
		clone.setLocaleCode(getLocaleCode());
		clone.setTitle(getTitle());
		clone.setDesc(getDesc());
		clone.setImageLoc(getImageLoc());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(TaxonomyTranslate taxonomyTranslate) {
		TaxonomyTranslatePK primaryKey = taxonomyTranslate.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxonomyTranslateClp)) {
			return false;
		}

		TaxonomyTranslateClp taxonomyTranslate = (TaxonomyTranslateClp)obj;

		TaxonomyTranslatePK primaryKey = taxonomyTranslate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{taxId=");
		sb.append(getTaxId());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", imageLoc=");
		sb.append(getImageLoc());
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
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.TaxonomyTranslate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>taxId</column-name><column-value><![CDATA[");
		sb.append(getTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
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

	private long _taxId;
	private String _localeCode;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _taxonomyTranslateRemoteModel;
}