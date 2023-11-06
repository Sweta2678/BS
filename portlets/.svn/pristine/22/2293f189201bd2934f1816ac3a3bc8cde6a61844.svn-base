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

package com.ihg.grs.common.model;

import com.ihg.grs.common.service.ClpSerializer;
import com.ihg.grs.common.service.GlossaryLocalServiceUtil;

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
 * @author gulam.vora
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
	public int getPrimaryKey() {
		return _glossaryId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setGlossaryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _glossaryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryId", getGlossaryId());
		attributes.put("term", getTerm());
		attributes.put("description", getDescription());
		attributes.put("activeIndicator", getActiveIndicator());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createdate", getCreatedate());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("updatedate", getUpdatedate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer glossaryId = (Integer)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String term = (String)attributes.get("term");

		if (term != null) {
			setTerm(term);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String activeIndicator = (String)attributes.get("activeIndicator");

		if (activeIndicator != null) {
			setActiveIndicator(activeIndicator);
		}

		String createUserId = (String)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Date createdate = (Date)attributes.get("createdate");

		if (createdate != null) {
			setCreatedate(createdate);
		}

		String lastUpdateUserId = (String)attributes.get("lastUpdateUserId");

		if (lastUpdateUserId != null) {
			setLastUpdateUserId(lastUpdateUserId);
		}

		Date updatedate = (Date)attributes.get("updatedate");

		if (updatedate != null) {
			setUpdatedate(updatedate);
		}
	}

	@Override
	public int getGlossaryId() {
		return _glossaryId;
	}

	@Override
	public void setGlossaryId(int glossaryId) {
		_glossaryId = glossaryId;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryId", int.class);

				method.invoke(_glossaryRemoteModel, glossaryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTerm() {
		return _term;
	}

	@Override
	public void setTerm(String term) {
		_term = term;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setTerm", String.class);

				method.invoke(_glossaryRemoteModel, term);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_glossaryRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActiveIndicator() {
		return _activeIndicator;
	}

	@Override
	public void setActiveIndicator(String activeIndicator) {
		_activeIndicator = activeIndicator;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveIndicator",
						String.class);

				method.invoke(_glossaryRemoteModel, activeIndicator);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreateUserId() {
		return _createUserId;
	}

	@Override
	public void setCreateUserId(String createUserId) {
		_createUserId = createUserId;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateUserId", String.class);

				method.invoke(_glossaryRemoteModel, createUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedate() {
		return _createdate;
	}

	@Override
	public void setCreatedate(Date createdate) {
		_createdate = createdate;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedate", Date.class);

				method.invoke(_glossaryRemoteModel, createdate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastUpdateUserId() {
		return _lastUpdateUserId;
	}

	@Override
	public void setLastUpdateUserId(String lastUpdateUserId) {
		_lastUpdateUserId = lastUpdateUserId;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setLastUpdateUserId",
						String.class);

				method.invoke(_glossaryRemoteModel, lastUpdateUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdatedate() {
		return _updatedate;
	}

	@Override
	public void setUpdatedate(Date updatedate) {
		_updatedate = updatedate;

		if (_glossaryRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedate", Date.class);

				method.invoke(_glossaryRemoteModel, updatedate);
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
		clone.setTerm(getTerm());
		clone.setDescription(getDescription());
		clone.setActiveIndicator(getActiveIndicator());
		clone.setCreateUserId(getCreateUserId());
		clone.setCreatedate(getCreatedate());
		clone.setLastUpdateUserId(getLastUpdateUserId());
		clone.setUpdatedate(getUpdatedate());

		return clone;
	}

	@Override
	public int compareTo(Glossary glossary) {
		int primaryKey = glossary.getPrimaryKey();

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

		int primaryKey = glossary.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{glossaryId=");
		sb.append(getGlossaryId());
		sb.append(", term=");
		sb.append(getTerm());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", activeIndicator=");
		sb.append(getActiveIndicator());
		sb.append(", createUserId=");
		sb.append(getCreateUserId());
		sb.append(", createdate=");
		sb.append(getCreatedate());
		sb.append(", lastUpdateUserId=");
		sb.append(getLastUpdateUserId());
		sb.append(", updatedate=");
		sb.append(getUpdatedate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.grs.common.model.Glossary");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>glossaryId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>term</column-name><column-value><![CDATA[");
		sb.append(getTerm());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeIndicator</column-name><column-value><![CDATA[");
		sb.append(getActiveIndicator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createUserId</column-name><column-value><![CDATA[");
		sb.append(getCreateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdate</column-name><column-value><![CDATA[");
		sb.append(getCreatedate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastUpdateUserId</column-name><column-value><![CDATA[");
		sb.append(getLastUpdateUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _glossaryId;
	private String _term;
	private String _description;
	private String _activeIndicator;
	private String _createUserId;
	private Date _createdate;
	private String _lastUpdateUserId;
	private Date _updatedate;
	private BaseModel<?> _glossaryRemoteModel;
	private Class<?> _clpSerializerClass = com.ihg.grs.common.service.ClpSerializer.class;
}