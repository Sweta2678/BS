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
import com.ihg.brandstandards.db.service.GEMTemplateReferenceLocalServiceUtil;

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
public class GEMTemplateReferenceClp extends BaseModelImpl<GEMTemplateReference>
	implements GEMTemplateReference {
	public GEMTemplateReferenceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplateReference.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplateReference.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _templateRefId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplateRefId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templateRefId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templateRefId", getTemplateRefId());
		attributes.put("templateId", getTemplateId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("regionId", getRegionId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templateRefId = (Long)attributes.get("templateRefId");

		if (templateRefId != null) {
			setTemplateRefId(templateRefId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
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
	public long getTemplateRefId() {
		return _templateRefId;
	}

	@Override
	public void setTemplateRefId(long templateRefId) {
		_templateRefId = templateRefId;

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateRefId", long.class);

				method.invoke(_gemTemplateReferenceRemoteModel, templateRefId);
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

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateId", long.class);

				method.invoke(_gemTemplateReferenceRemoteModel, templateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishDeptId() {
		return _publishDeptId;
	}

	@Override
	public void setPublishDeptId(long publishDeptId) {
		_publishDeptId = publishDeptId;

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDeptId", long.class);

				method.invoke(_gemTemplateReferenceRemoteModel, publishDeptId);
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

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemTemplateReferenceRemoteModel, regionId);
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

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemTemplateReferenceRemoteModel, creatorId);
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

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemTemplateReferenceRemoteModel, createdDate);
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

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemTemplateReferenceRemoteModel, updatedBy);
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

		if (_gemTemplateReferenceRemoteModel != null) {
			try {
				Class<?> clazz = _gemTemplateReferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemTemplateReferenceRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMTemplateReferenceRemoteModel() {
		return _gemTemplateReferenceRemoteModel;
	}

	public void setGEMTemplateReferenceRemoteModel(
		BaseModel<?> gemTemplateReferenceRemoteModel) {
		_gemTemplateReferenceRemoteModel = gemTemplateReferenceRemoteModel;
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

		Class<?> remoteModelClass = _gemTemplateReferenceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemTemplateReferenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMTemplateReferenceLocalServiceUtil.addGEMTemplateReference(this);
		}
		else {
			GEMTemplateReferenceLocalServiceUtil.updateGEMTemplateReference(this);
		}
	}

	@Override
	public GEMTemplateReference toEscapedModel() {
		return (GEMTemplateReference)ProxyUtil.newProxyInstance(GEMTemplateReference.class.getClassLoader(),
			new Class[] { GEMTemplateReference.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMTemplateReferenceClp clone = new GEMTemplateReferenceClp();

		clone.setTemplateRefId(getTemplateRefId());
		clone.setTemplateId(getTemplateId());
		clone.setPublishDeptId(getPublishDeptId());
		clone.setRegionId(getRegionId());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMTemplateReference gemTemplateReference) {
		long primaryKey = gemTemplateReference.getPrimaryKey();

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

		if (!(obj instanceof GEMTemplateReferenceClp)) {
			return false;
		}

		GEMTemplateReferenceClp gemTemplateReference = (GEMTemplateReferenceClp)obj;

		long primaryKey = gemTemplateReference.getPrimaryKey();

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

		sb.append("{templateRefId=");
		sb.append(getTemplateRefId());
		sb.append(", templateId=");
		sb.append(getTemplateId());
		sb.append(", publishDeptId=");
		sb.append(getPublishDeptId());
		sb.append(", regionId=");
		sb.append(getRegionId());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GEMTemplateReference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>templateRefId</column-name><column-value><![CDATA[");
		sb.append(getTemplateRefId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateId</column-name><column-value><![CDATA[");
		sb.append(getTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDeptId</column-name><column-value><![CDATA[");
		sb.append(getPublishDeptId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
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

	private long _templateRefId;
	private long _templateId;
	private long _publishDeptId;
	private long _regionId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemTemplateReferenceRemoteModel;
}