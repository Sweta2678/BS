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
import com.ihg.brandstandards.db.service.GlossaryExtLocalServiceUtil;

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
public class GlossaryExtClp extends BaseModelImpl<GlossaryExt>
	implements GlossaryExt {
	public GlossaryExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GlossaryExt.class;
	}

	@Override
	public String getModelClassName() {
		return GlossaryExt.class.getName();
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
		attributes.put("activeInd", getActiveInd());
		attributes.put("glossaryTermText", getGlossaryTermText());
		attributes.put("glossaryTermDesc", getGlossaryTermDesc());
		attributes.put("glossaryRegions", getGlossaryRegions());
		attributes.put("glossaryChains", getGlossaryChains());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		String glossaryTermText = (String)attributes.get("glossaryTermText");

		if (glossaryTermText != null) {
			setGlossaryTermText(glossaryTermText);
		}

		String glossaryTermDesc = (String)attributes.get("glossaryTermDesc");

		if (glossaryTermDesc != null) {
			setGlossaryTermDesc(glossaryTermDesc);
		}

		String glossaryRegions = (String)attributes.get("glossaryRegions");

		if (glossaryRegions != null) {
			setGlossaryRegions(glossaryRegions);
		}

		String glossaryChains = (String)attributes.get("glossaryChains");

		if (glossaryChains != null) {
			setGlossaryChains(glossaryChains);
		}
	}

	@Override
	public long getGlossaryId() {
		return _glossaryId;
	}

	@Override
	public void setGlossaryId(long glossaryId) {
		_glossaryId = glossaryId;

		if (_glossaryExtRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryId", long.class);

				method.invoke(_glossaryExtRemoteModel, glossaryId);
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

		if (_glossaryExtRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveInd", String.class);

				method.invoke(_glossaryExtRemoteModel, activeInd);
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

		if (_glossaryExtRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryTermText",
						String.class);

				method.invoke(_glossaryExtRemoteModel, glossaryTermText);
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

		if (_glossaryExtRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryTermDesc",
						String.class);

				method.invoke(_glossaryExtRemoteModel, glossaryTermDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlossaryRegions() {
		return _glossaryRegions;
	}

	@Override
	public void setGlossaryRegions(String glossaryRegions) {
		_glossaryRegions = glossaryRegions;

		if (_glossaryExtRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryRegions",
						String.class);

				method.invoke(_glossaryExtRemoteModel, glossaryRegions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGlossaryChains() {
		return _glossaryChains;
	}

	@Override
	public void setGlossaryChains(String glossaryChains) {
		_glossaryChains = glossaryChains;

		if (_glossaryExtRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryExtRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryChains",
						String.class);

				method.invoke(_glossaryExtRemoteModel, glossaryChains);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGlossaryExtRemoteModel() {
		return _glossaryExtRemoteModel;
	}

	public void setGlossaryExtRemoteModel(BaseModel<?> glossaryExtRemoteModel) {
		_glossaryExtRemoteModel = glossaryExtRemoteModel;
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

		Class<?> remoteModelClass = _glossaryExtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_glossaryExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GlossaryExtLocalServiceUtil.addGlossaryExt(this);
		}
		else {
			GlossaryExtLocalServiceUtil.updateGlossaryExt(this);
		}
	}

	@Override
	public GlossaryExt toEscapedModel() {
		return (GlossaryExt)ProxyUtil.newProxyInstance(GlossaryExt.class.getClassLoader(),
			new Class[] { GlossaryExt.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GlossaryExtClp clone = new GlossaryExtClp();

		clone.setGlossaryId(getGlossaryId());
		clone.setActiveInd(getActiveInd());
		clone.setGlossaryTermText(getGlossaryTermText());
		clone.setGlossaryTermDesc(getGlossaryTermDesc());
		clone.setGlossaryRegions(getGlossaryRegions());
		clone.setGlossaryChains(getGlossaryChains());

		return clone;
	}

	@Override
	public int compareTo(GlossaryExt glossaryExt) {
		long primaryKey = glossaryExt.getPrimaryKey();

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

		if (!(obj instanceof GlossaryExtClp)) {
			return false;
		}

		GlossaryExtClp glossaryExt = (GlossaryExtClp)obj;

		long primaryKey = glossaryExt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{glossaryId=");
		sb.append(getGlossaryId());
		sb.append(", activeInd=");
		sb.append(getActiveInd());
		sb.append(", glossaryTermText=");
		sb.append(getGlossaryTermText());
		sb.append(", glossaryTermDesc=");
		sb.append(getGlossaryTermDesc());
		sb.append(", glossaryRegions=");
		sb.append(getGlossaryRegions());
		sb.append(", glossaryChains=");
		sb.append(getGlossaryChains());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GlossaryExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>glossaryId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeInd</column-name><column-value><![CDATA[");
		sb.append(getActiveInd());
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
			"<column><column-name>glossaryRegions</column-name><column-value><![CDATA[");
		sb.append(getGlossaryRegions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryChains</column-name><column-value><![CDATA[");
		sb.append(getGlossaryChains());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _glossaryId;
	private String _activeInd;
	private String _glossaryTermText;
	private String _glossaryTermDesc;
	private String _glossaryRegions;
	private String _glossaryChains;
	private BaseModel<?> _glossaryExtRemoteModel;
}