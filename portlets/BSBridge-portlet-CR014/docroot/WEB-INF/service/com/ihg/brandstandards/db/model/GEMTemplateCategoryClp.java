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
import com.ihg.brandstandards.db.service.GEMTemplateCategoryLocalServiceUtil;

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
public class GEMTemplateCategoryClp extends BaseModelImpl<GEMTemplateCategory>
	implements GEMTemplateCategory {
	public GEMTemplateCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplateCategory.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplateCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _templateCatgyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplateCatgyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templateCatgyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateCatgyId", getTemplateCatgyId());
		attributes.put("templateId", getTemplateId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("categoryViewType", getCategoryViewType());
		attributes.put("categoryAnsAll", getCategoryAnsAll());
		attributes.put("duplicatable", getDuplicatable());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateCatgyId = (Long)attributes.get("templateCatgyId");

		if (templateCatgyId != null) {
			setTemplateCatgyId(templateCatgyId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String categoryViewType = (String)attributes.get("categoryViewType");

		if (categoryViewType != null) {
			setCategoryViewType(categoryViewType);
		}

		String categoryAnsAll = (String)attributes.get("categoryAnsAll");

		if (categoryAnsAll != null) {
			setCategoryAnsAll(categoryAnsAll);
		}

		String duplicatable = (String)attributes.get("duplicatable");

		if (duplicatable != null) {
			setDuplicatable(duplicatable);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
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
	public long getTemplateCatgyId() {
		return _templateCatgyId;
	}

	@Override
	public void setTemplateCatgyId(long templateCatgyId) {
		_templateCatgyId = templateCatgyId;

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateCatgyId", long.class);

				method.invoke(_gemTemplateCategoryRemoteModel, templateCatgyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_templateId = templateId;

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_gemTemplateCategoryRemoteModel, templateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_gemTemplateCategoryRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategoryViewType() {
		return _categoryViewType;
	}

	@Override
	public void setCategoryViewType(String categoryViewType) {
		_categoryViewType = categoryViewType;

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryViewType",
						String.class);

				method.invoke(_gemTemplateCategoryRemoteModel, categoryViewType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategoryAnsAll() {
		return _categoryAnsAll;
	}

	@Override
	public void setCategoryAnsAll(String categoryAnsAll) {
		_categoryAnsAll = categoryAnsAll;

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryAnsAll",
						String.class);

				method.invoke(_gemTemplateCategoryRemoteModel, categoryAnsAll);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuplicatable() {
		return _duplicatable;
	}

	@Override
	public void setDuplicatable(String duplicatable) {
		_duplicatable = duplicatable;

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDuplicatable", String.class);

				method.invoke(_gemTemplateCategoryRemoteModel, duplicatable);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemTemplateCategoryRemoteModel,
					displayOrderNumber);
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

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemTemplateCategoryRemoteModel, creatorId);
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

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemTemplateCategoryRemoteModel, createdDate);
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

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemTemplateCategoryRemoteModel, updatedBy);
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

		if (_gemTemplateCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemTemplateCategoryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMTemplateCategoryRemoteModel() {
		return _gemTemplateCategoryRemoteModel;
	}

	public void setGEMTemplateCategoryRemoteModel(
		BaseModel<?> gemTemplateCategoryRemoteModel) {
		_gemTemplateCategoryRemoteModel = gemTemplateCategoryRemoteModel;
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

		Class<?> remoteModelClass = _gemTemplateCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemTemplateCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMTemplateCategoryLocalServiceUtil.addGEMTemplateCategory(this);
		}
		else {
			GEMTemplateCategoryLocalServiceUtil.updateGEMTemplateCategory(this);
		}
	}

	@Override
	public GEMTemplateCategory toEscapedModel() {
		return (GEMTemplateCategory)ProxyUtil.newProxyInstance(GEMTemplateCategory.class.getClassLoader(),
			new Class[] { GEMTemplateCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMTemplateCategoryClp clone = new GEMTemplateCategoryClp();

		clone.setTemplateCatgyId(getTemplateCatgyId());
		clone.setTemplateId(getTemplateId());
		clone.setCategoryId(getCategoryId());
		clone.setCategoryViewType(getCategoryViewType());
		clone.setCategoryAnsAll(getCategoryAnsAll());
		clone.setDuplicatable(getDuplicatable());
		clone.setDisplayOrderNumber(getDisplayOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMTemplateCategory gemTemplateCategory) {
		int value = 0;

		if (getDisplayOrderNumber() < gemTemplateCategory.getDisplayOrderNumber()) {
			value = -1;
		}
		else if (getDisplayOrderNumber() > gemTemplateCategory.getDisplayOrderNumber()) {
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

		if (!(obj instanceof GEMTemplateCategoryClp)) {
			return false;
		}

		GEMTemplateCategoryClp gemTemplateCategory = (GEMTemplateCategoryClp)obj;

		long primaryKey = gemTemplateCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{templateCatgyId=");
		sb.append(getTemplateCatgyId());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", categoryViewType=");
		sb.append(getCategoryViewType());
		sb.append(", categoryAnsAll=");
		sb.append(getCategoryAnsAll());
		sb.append(", duplicatable=");
		sb.append(getDuplicatable());
		sb.append(", displayOrderNumber=");
		sb.append(getDisplayOrderNumber());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMTemplateCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>templateCatgyId</column-name><column-value><![CDATA[");
		sb.append(getTemplateCatgyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryViewType</column-name><column-value><![CDATA[");
		sb.append(getCategoryViewType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryAnsAll</column-name><column-value><![CDATA[");
		sb.append(getCategoryAnsAll());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duplicatable</column-name><column-value><![CDATA[");
		sb.append(getDuplicatable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrderNumber());
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

	private long _templateCatgyId;
	private long _templateId;
	private long _categoryId;
	private String _categoryViewType;
	private String _categoryAnsAll;
	private String _duplicatable;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemTemplateCategoryRemoteModel;
}