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
import com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalServiceUtil;

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
public class StandardsDisplayOrderExtClp extends BaseModelImpl<StandardsDisplayOrderExt>
	implements StandardsDisplayOrderExt {
	public StandardsDisplayOrderExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsDisplayOrderExt.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsDisplayOrderExt.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stdId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("title", getTitle());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("framework", getFramework());
		attributes.put("chainCode", getChainCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("displayOrder", getDisplayOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_standardsDisplayOrderExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsDisplayOrderExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsDisplayOrderExtRemoteModel, stdId);
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

		if (_standardsDisplayOrderExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsDisplayOrderExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_standardsDisplayOrderExtRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsGlobal() {
		return _isGlobal;
	}

	@Override
	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;

		if (_standardsDisplayOrderExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsDisplayOrderExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIsGlobal", String.class);

				method.invoke(_standardsDisplayOrderExtRemoteModel, isGlobal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFramework() {
		return _framework;
	}

	@Override
	public void setFramework(String framework) {
		_framework = framework;

		if (_standardsDisplayOrderExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsDisplayOrderExtRemoteModel.getClass();

				Method method = clazz.getMethod("setFramework", String.class);

				method.invoke(_standardsDisplayOrderExtRemoteModel, framework);
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

		if (_standardsDisplayOrderExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsDisplayOrderExtRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_standardsDisplayOrderExtRemoteModel, chainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;

		if (_standardsDisplayOrderExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsDisplayOrderExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_standardsDisplayOrderExtRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisplayOrder() {
		return _displayOrder;
	}

	@Override
	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;

		if (_standardsDisplayOrderExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsDisplayOrderExtRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrder", long.class);

				method.invoke(_standardsDisplayOrderExtRemoteModel, displayOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsDisplayOrderExtRemoteModel() {
		return _standardsDisplayOrderExtRemoteModel;
	}

	public void setStandardsDisplayOrderExtRemoteModel(
		BaseModel<?> standardsDisplayOrderExtRemoteModel) {
		_standardsDisplayOrderExtRemoteModel = standardsDisplayOrderExtRemoteModel;
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

		Class<?> remoteModelClass = _standardsDisplayOrderExtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsDisplayOrderExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsDisplayOrderExtLocalServiceUtil.addStandardsDisplayOrderExt(this);
		}
		else {
			StandardsDisplayOrderExtLocalServiceUtil.updateStandardsDisplayOrderExt(this);
		}
	}

	@Override
	public StandardsDisplayOrderExt toEscapedModel() {
		return (StandardsDisplayOrderExt)ProxyUtil.newProxyInstance(StandardsDisplayOrderExt.class.getClassLoader(),
			new Class[] { StandardsDisplayOrderExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsDisplayOrderExtClp clone = new StandardsDisplayOrderExtClp();

		clone.setStdId(getStdId());
		clone.setTitle(getTitle());
		clone.setIsGlobal(getIsGlobal());
		clone.setFramework(getFramework());
		clone.setChainCode(getChainCode());
		clone.setRegionCode(getRegionCode());
		clone.setDisplayOrder(getDisplayOrder());

		return clone;
	}

	@Override
	public int compareTo(StandardsDisplayOrderExt standardsDisplayOrderExt) {
		long primaryKey = standardsDisplayOrderExt.getPrimaryKey();

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

		if (!(obj instanceof StandardsDisplayOrderExtClp)) {
			return false;
		}

		StandardsDisplayOrderExtClp standardsDisplayOrderExt = (StandardsDisplayOrderExtClp)obj;

		long primaryKey = standardsDisplayOrderExt.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", isGlobal=");
		sb.append(getIsGlobal());
		sb.append(", framework=");
		sb.append(getFramework());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", displayOrder=");
		sb.append(getDisplayOrder());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsDisplayOrderExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isGlobal</column-name><column-value><![CDATA[");
		sb.append(getIsGlobal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>framework</column-name><column-value><![CDATA[");
		sb.append(getFramework());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrder</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrder());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stdId;
	private String _title;
	private String _isGlobal;
	private String _framework;
	private String _chainCode;
	private String _regionCode;
	private long _displayOrder;
	private BaseModel<?> _standardsDisplayOrderExtRemoteModel;
}