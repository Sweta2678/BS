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
import com.ihg.brandstandards.db.service.GEMStdCategoryLocalServiceUtil;

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
public class GEMStdCategoryClp extends BaseModelImpl<GEMStdCategory>
	implements GEMStdCategory {
	public GEMStdCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMStdCategory.class;
	}

	@Override
	public String getModelClassName() {
		return GEMStdCategory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _gemStdCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGemStdCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gemStdCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gemStdCategoryId", getGemStdCategoryId());
		attributes.put("stdId", getStdId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("templateType", getTemplateType());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gemStdCategoryId = (Long)attributes.get("gemStdCategoryId");

		if (gemStdCategoryId != null) {
			setGemStdCategoryId(gemStdCategoryId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String templateType = (String)attributes.get("templateType");

		if (templateType != null) {
			setTemplateType(templateType);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
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
	public long getGemStdCategoryId() {
		return _gemStdCategoryId;
	}

	@Override
	public void setGemStdCategoryId(long gemStdCategoryId) {
		_gemStdCategoryId = gemStdCategoryId;

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGemStdCategoryId",
						long.class);

				method.invoke(_gemStdCategoryRemoteModel, gemStdCategoryId);
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

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_gemStdCategoryRemoteModel, stdId);
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

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_gemStdCategoryRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplateType() {
		return _templateType;
	}

	@Override
	public void setTemplateType(String templateType) {
		_templateType = templateType;

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateType", String.class);

				method.invoke(_gemStdCategoryRemoteModel, templateType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChainCode() {
		return _chainCode;
	}

	@Override
	public void setChainCode(String chainCode) {
		_chainCode = chainCode;

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_gemStdCategoryRemoteModel, chainCode);
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

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemStdCategoryRemoteModel, creatorId);
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

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemStdCategoryRemoteModel, createdDate);
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

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemStdCategoryRemoteModel, updatedBy);
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

		if (_gemStdCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _gemStdCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemStdCategoryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMStdCategoryRemoteModel() {
		return _gemStdCategoryRemoteModel;
	}

	public void setGEMStdCategoryRemoteModel(
		BaseModel<?> gemStdCategoryRemoteModel) {
		_gemStdCategoryRemoteModel = gemStdCategoryRemoteModel;
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

		Class<?> remoteModelClass = _gemStdCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemStdCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMStdCategoryLocalServiceUtil.addGEMStdCategory(this);
		}
		else {
			GEMStdCategoryLocalServiceUtil.updateGEMStdCategory(this);
		}
	}

	@Override
	public GEMStdCategory toEscapedModel() {
		return (GEMStdCategory)ProxyUtil.newProxyInstance(GEMStdCategory.class.getClassLoader(),
			new Class[] { GEMStdCategory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMStdCategoryClp clone = new GEMStdCategoryClp();

		clone.setGemStdCategoryId(getGemStdCategoryId());
		clone.setStdId(getStdId());
		clone.setCategoryId(getCategoryId());
		clone.setTemplateType(getTemplateType());
		clone.setChainCode(getChainCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMStdCategory gemStdCategory) {
		int value = 0;

		if (getGemStdCategoryId() < gemStdCategory.getGemStdCategoryId()) {
			value = -1;
		}
		else if (getGemStdCategoryId() > gemStdCategory.getGemStdCategoryId()) {
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

		if (!(obj instanceof GEMStdCategoryClp)) {
			return false;
		}

		GEMStdCategoryClp gemStdCategory = (GEMStdCategoryClp)obj;

		long primaryKey = gemStdCategory.getPrimaryKey();

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

		sb.append("{gemStdCategoryId=");
		sb.append(getGemStdCategoryId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", templateType=");
		sb.append(getTemplateType());
		sb.append(", chainCode=");
		sb.append(getChainCode());
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
		sb.append("com.ihg.brandstandards.db.model.GEMStdCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>gemStdCategoryId</column-name><column-value><![CDATA[");
		sb.append(getGemStdCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateType</column-name><column-value><![CDATA[");
		sb.append(getTemplateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
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

	private long _gemStdCategoryId;
	private long _stdId;
	private long _categoryId;
	private String _templateType;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemStdCategoryRemoteModel;
}