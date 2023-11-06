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
import com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil;

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
public class GEMCategoryClp extends BaseModelImpl<GEMCategory>
	implements GEMCategory {
	public GEMCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMCategory.class;
	}

	@Override
	public String getModelClassName() {
		return GEMCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("cmsCategoryId", getCmsCategoryId());
		attributes.put("gemCategoryCode", getGemCategoryCode());
		attributes.put("gemPrntCategoryId", getGemPrntCategoryId());
		attributes.put("categoryName", getCategoryName());
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
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long cmsCategoryId = (Long)attributes.get("cmsCategoryId");

		if (cmsCategoryId != null) {
			setCmsCategoryId(cmsCategoryId);
		}

		String gemCategoryCode = (String)attributes.get("gemCategoryCode");

		if (gemCategoryCode != null) {
			setGemCategoryCode(gemCategoryCode);
		}

		String gemPrntCategoryId = (String)attributes.get("gemPrntCategoryId");

		if (gemPrntCategoryId != null) {
			setGemPrntCategoryId(gemPrntCategoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
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
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_gemCategoryRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCmsCategoryId() {
		return _cmsCategoryId;
	}

	@Override
	public void setCmsCategoryId(long cmsCategoryId) {
		_cmsCategoryId = cmsCategoryId;

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCmsCategoryId", long.class);

				method.invoke(_gemCategoryRemoteModel, cmsCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGemCategoryCode() {
		return _gemCategoryCode;
	}

	@Override
	public void setGemCategoryCode(String gemCategoryCode) {
		_gemCategoryCode = gemCategoryCode;

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGemCategoryCode",
						String.class);

				method.invoke(_gemCategoryRemoteModel, gemCategoryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGemPrntCategoryId() {
		return _gemPrntCategoryId;
	}

	@Override
	public void setGemPrntCategoryId(String gemPrntCategoryId) {
		_gemPrntCategoryId = gemPrntCategoryId;

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGemPrntCategoryId",
						String.class);

				method.invoke(_gemCategoryRemoteModel, gemPrntCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategoryName() {
		return _categoryName;
	}

	@Override
	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryName", String.class);

				method.invoke(_gemCategoryRemoteModel, categoryName);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryViewType",
						String.class);

				method.invoke(_gemCategoryRemoteModel, categoryViewType);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryAnsAll",
						String.class);

				method.invoke(_gemCategoryRemoteModel, categoryAnsAll);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDuplicatable", String.class);

				method.invoke(_gemCategoryRemoteModel, duplicatable);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrderNumber",
						long.class);

				method.invoke(_gemCategoryRemoteModel, displayOrderNumber);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemCategoryRemoteModel, creatorId);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemCategoryRemoteModel, createdDate);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemCategoryRemoteModel, updatedBy);
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

		if (_gemCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemCategoryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMCategoryRemoteModel() {
		return _gemCategoryRemoteModel;
	}

	public void setGEMCategoryRemoteModel(BaseModel<?> gemCategoryRemoteModel) {
		_gemCategoryRemoteModel = gemCategoryRemoteModel;
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

		Class<?> remoteModelClass = _gemCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMCategoryLocalServiceUtil.addGEMCategory(this);
		}
		else {
			GEMCategoryLocalServiceUtil.updateGEMCategory(this);
		}
	}

	@Override
	public GEMCategory toEscapedModel() {
		return (GEMCategory)ProxyUtil.newProxyInstance(GEMCategory.class.getClassLoader(),
			new Class[] { GEMCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMCategoryClp clone = new GEMCategoryClp();

		clone.setCategoryId(getCategoryId());
		clone.setCmsCategoryId(getCmsCategoryId());
		clone.setGemCategoryCode(getGemCategoryCode());
		clone.setGemPrntCategoryId(getGemPrntCategoryId());
		clone.setCategoryName(getCategoryName());
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
	public int compareTo(GEMCategory gemCategory) {
		int value = 0;

		if (getDisplayOrderNumber() < gemCategory.getDisplayOrderNumber()) {
			value = -1;
		}
		else if (getDisplayOrderNumber() > gemCategory.getDisplayOrderNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getCategoryId() < gemCategory.getCategoryId()) {
			value = -1;
		}
		else if (getCategoryId() > gemCategory.getCategoryId()) {
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

		if (!(obj instanceof GEMCategoryClp)) {
			return false;
		}

		GEMCategoryClp gemCategory = (GEMCategoryClp)obj;

		long primaryKey = gemCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", cmsCategoryId=");
		sb.append(getCmsCategoryId());
		sb.append(", gemCategoryCode=");
		sb.append(getGemCategoryCode());
		sb.append(", gemPrntCategoryId=");
		sb.append(getGemPrntCategoryId());
		sb.append(", categoryName=");
		sb.append(getCategoryName());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmsCategoryId</column-name><column-value><![CDATA[");
		sb.append(getCmsCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gemCategoryCode</column-name><column-value><![CDATA[");
		sb.append(getGemCategoryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gemPrntCategoryId</column-name><column-value><![CDATA[");
		sb.append(getGemPrntCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryName</column-name><column-value><![CDATA[");
		sb.append(getCategoryName());
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

	private long _categoryId;
	private long _cmsCategoryId;
	private String _gemCategoryCode;
	private String _gemPrntCategoryId;
	private String _categoryName;
	private String _categoryViewType;
	private String _categoryAnsAll;
	private String _duplicatable;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemCategoryRemoteModel;
}