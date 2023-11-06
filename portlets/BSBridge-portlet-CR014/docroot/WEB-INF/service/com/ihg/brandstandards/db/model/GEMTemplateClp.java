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
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;

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
public class GEMTemplateClp extends BaseModelImpl<GEMTemplate>
	implements GEMTemplate {
	public GEMTemplateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _templateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateId", getTemplateId());
		attributes.put("templateName", getTemplateName());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("templateType", getTemplateType());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String templateType = (String)attributes.get("templateType");

		if (templateType != null) {
			setTemplateType(templateType);
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
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_templateId = templateId;

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_gemTemplateRemoteModel, templateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplateName() {
		return _templateName;
	}

	@Override
	public void setTemplateName(String templateName) {
		_templateName = templateName;

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateName", String.class);

				method.invoke(_gemTemplateRemoteModel, templateName);
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

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_gemTemplateRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_regionId = regionId;

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemTemplateRemoteModel, regionId);
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

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateType", String.class);

				method.invoke(_gemTemplateRemoteModel, templateType);
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

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemTemplateRemoteModel, creatorId);
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

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemTemplateRemoteModel, createdDate);
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

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemTemplateRemoteModel, updatedBy);
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

		if (_gemTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemTemplateRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMTemplateRemoteModel() {
		return _gemTemplateRemoteModel;
	}

	public void setGEMTemplateRemoteModel(BaseModel<?> gemTemplateRemoteModel) {
		_gemTemplateRemoteModel = gemTemplateRemoteModel;
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

		Class<?> remoteModelClass = _gemTemplateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemTemplateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMTemplateLocalServiceUtil.addGEMTemplate(this);
		}
		else {
			GEMTemplateLocalServiceUtil.updateGEMTemplate(this);
		}
	}

	@Override
	public GEMTemplate toEscapedModel() {
		return (GEMTemplate)ProxyUtil.newProxyInstance(GEMTemplate.class.getClassLoader(),
			new Class[] { GEMTemplate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMTemplateClp clone = new GEMTemplateClp();

		clone.setTemplateId(getTemplateId());
		clone.setTemplateName(getTemplateName());
		clone.setPublishId(getPublishId());
		clone.setRegionId(getRegionId());
		clone.setTemplateType(getTemplateType());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMTemplate gemTemplate) {
		long primaryKey = gemTemplate.getPrimaryKey();

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

		if (!(obj instanceof GEMTemplateClp)) {
			return false;
		}

		GEMTemplateClp gemTemplate = (GEMTemplateClp)obj;

		long primaryKey = gemTemplate.getPrimaryKey();

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

		sb.append("{templateId=");
		sb.append(getTemplateId());
		sb.append(", templateName=");
		sb.append(getTemplateName());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", templateType=");
		sb.append(getTemplateType());
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
		sb.append("com.ihg.brandstandards.db.model.GEMTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateName</column-name><column-value><![CDATA[");
		sb.append(getTemplateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateType</column-name><column-value><![CDATA[");
		sb.append(getTemplateType());
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

	private long _templateId;
	private String _templateName;
	private long _publishId;
	private long _regionId;
	private String _templateType;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemTemplateRemoteModel;
}