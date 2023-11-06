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
import com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil;

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
public class GlossaryClp extends BaseModelImpl<Glossary> implements Glossary {
	public GlossaryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Glossary.class;
	}

	@Override
	public String getModelClassName() {
		return Glossary.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _glossaryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlossaryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _glossaryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryId", getGlossaryId());
		attributes.put("glossaryTermText", getGlossaryTermText());
		attributes.put("glossaryTermDesc", getGlossaryTermDesc());
		attributes.put("activeInd", getActiveInd());
		attributes.put("glossaryOwner", getGlossaryOwner());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String glossaryTermText = (String)attributes.get("glossaryTermText");

		if (glossaryTermText != null) {
			setGlossaryTermText(glossaryTermText);
		}

		String glossaryTermDesc = (String)attributes.get("glossaryTermDesc");

		if (glossaryTermDesc != null) {
			setGlossaryTermDesc(glossaryTermDesc);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		Long glossaryOwner = (Long)attributes.get("glossaryOwner");

		if (glossaryOwner != null) {
			setGlossaryOwner(glossaryOwner);
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
	public long getGlossaryId() {
		return _glossaryId;
	}

	@Override
	public void setGlossaryId(long glossaryId) {
		_glossaryId = glossaryId;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryId", long.class);

				method.invoke(_glossaryRemoteModel, glossaryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlossaryTermText() {
		return _glossaryTermText;
	}

	@Override
	public void setGlossaryTermText(String glossaryTermText) {
		_glossaryTermText = glossaryTermText;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryTermText",
						String.class);

				method.invoke(_glossaryRemoteModel, glossaryTermText);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlossaryTermDesc() {
		return _glossaryTermDesc;
	}

	@Override
	public void setGlossaryTermDesc(String glossaryTermDesc) {
		_glossaryTermDesc = glossaryTermDesc;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryTermDesc",
						String.class);

				method.invoke(_glossaryRemoteModel, glossaryTermDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActiveInd() {
		return _activeInd;
	}

	@Override
	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveInd", String.class);

				method.invoke(_glossaryRemoteModel, activeInd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGlossaryOwner() {
		return _glossaryOwner;
	}

	@Override
	public void setGlossaryOwner(long glossaryOwner) {
		_glossaryOwner = glossaryOwner;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryOwner", long.class);

				method.invoke(_glossaryRemoteModel, glossaryOwner);
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

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_glossaryRemoteModel, creatorId);
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

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_glossaryRemoteModel, createdDate);
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

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_glossaryRemoteModel, updatedBy);
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

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_glossaryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGlossaryRemoteModel() {
		return _glossaryRemoteModel;
	}

	public void setGlossaryRemoteModel(BaseModel<?> glossaryRemoteModel) {
		_glossaryRemoteModel = glossaryRemoteModel;
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

		Class<?> remoteModelClass = _glossaryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_glossaryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GlossaryLocalServiceUtil.addGlossary(this);
		}
		else {
			GlossaryLocalServiceUtil.updateGlossary(this);
		}
	}

	@Override
	public Glossary toEscapedModel() {
		return (Glossary)ProxyUtil.newProxyInstance(Glossary.class.getClassLoader(),
			new Class[] { Glossary.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GlossaryClp clone = new GlossaryClp();

		clone.setGlossaryId(getGlossaryId());
		clone.setGlossaryTermText(getGlossaryTermText());
		clone.setGlossaryTermDesc(getGlossaryTermDesc());
		clone.setActiveInd(getActiveInd());
		clone.setGlossaryOwner(getGlossaryOwner());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(Glossary glossary) {
		long primaryKey = glossary.getPrimaryKey();

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

		if (!(obj instanceof GlossaryClp)) {
			return false;
		}

		GlossaryClp glossary = (GlossaryClp)obj;

		long primaryKey = glossary.getPrimaryKey();

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

		sb.append("{glossaryId=");
		sb.append(getGlossaryId());
		sb.append(", glossaryTermText=");
		sb.append(getGlossaryTermText());
		sb.append(", glossaryTermDesc=");
		sb.append(getGlossaryTermDesc());
		sb.append(", activeInd=");
		sb.append(getActiveInd());
		sb.append(", glossaryOwner=");
		sb.append(getGlossaryOwner());
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
		sb.append("com.ihg.brandstandards.db.model.Glossary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>glossaryId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryTermText</column-name><column-value><![CDATA[");
		sb.append(getGlossaryTermText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryTermDesc</column-name><column-value><![CDATA[");
		sb.append(getGlossaryTermDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeInd</column-name><column-value><![CDATA[");
		sb.append(getActiveInd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryOwner</column-name><column-value><![CDATA[");
		sb.append(getGlossaryOwner());
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

	private long _glossaryId;
	private String _glossaryTermText;
	private String _glossaryTermDesc;
	private String _activeInd;
	private long _glossaryOwner;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _glossaryRemoteModel;
}