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
import com.ihg.brandstandards.db.service.PublishExtStdLocalServiceUtil;

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
public class PublishExtStdClp extends BaseModelImpl<PublishExtStd>
	implements PublishExtStd {
	public PublishExtStdClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PublishExtStd.class;
	}

	@Override
	public String getModelClassName() {
		return PublishExtStd.class.getName();
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

		attributes.put("compDate", getCompDate());
		attributes.put("stdId", getStdId());
		attributes.put("parentId", getParentId());
		attributes.put("title", getTitle());
		attributes.put("expiredIds", getExpiredIds());
		attributes.put("regionCode", getRegionCode());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("framework", getFramework());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Date compDate = (Date)attributes.get("compDate");

		if (compDate != null) {
			setCompDate(compDate);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String expiredIds = (String)attributes.get("expiredIds");

		if (expiredIds != null) {
			setExpiredIds(expiredIds);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}
	}

	@Override
	public Date getCompDate() {
		return _compDate;
	}

	@Override
	public void setCompDate(Date compDate) {
		_compDate = compDate;

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setCompDate", Date.class);

				method.invoke(_publishExtStdRemoteModel, compDate);
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

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_publishExtStdRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_publishExtStdRemoteModel, parentId);
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

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_publishExtStdRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpiredIds() {
		return _expiredIds;
	}

	@Override
	public void setExpiredIds(String expiredIds) {
		_expiredIds = expiredIds;

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredIds", String.class);

				method.invoke(_publishExtStdRemoteModel, expiredIds);
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

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_publishExtStdRemoteModel, regionCode);
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

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setIsGlobal", String.class);

				method.invoke(_publishExtStdRemoteModel, isGlobal);
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

		if (_publishExtStdRemoteModel != null) {
			try {
				Class<?> clazz = _publishExtStdRemoteModel.getClass();

				Method method = clazz.getMethod("setFramework", String.class);

				method.invoke(_publishExtStdRemoteModel, framework);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublishExtStdRemoteModel() {
		return _publishExtStdRemoteModel;
	}

	public void setPublishExtStdRemoteModel(
		BaseModel<?> publishExtStdRemoteModel) {
		_publishExtStdRemoteModel = publishExtStdRemoteModel;
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

		Class<?> remoteModelClass = _publishExtStdRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publishExtStdRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishExtStdLocalServiceUtil.addPublishExtStd(this);
		}
		else {
			PublishExtStdLocalServiceUtil.updatePublishExtStd(this);
		}
	}

	@Override
	public PublishExtStd toEscapedModel() {
		return (PublishExtStd)ProxyUtil.newProxyInstance(PublishExtStd.class.getClassLoader(),
			new Class[] { PublishExtStd.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishExtStdClp clone = new PublishExtStdClp();

		clone.setCompDate(getCompDate());
		clone.setStdId(getStdId());
		clone.setParentId(getParentId());
		clone.setTitle(getTitle());
		clone.setExpiredIds(getExpiredIds());
		clone.setRegionCode(getRegionCode());
		clone.setIsGlobal(getIsGlobal());
		clone.setFramework(getFramework());

		return clone;
	}

	@Override
	public int compareTo(PublishExtStd publishExtStd) {
		long primaryKey = publishExtStd.getPrimaryKey();

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

		if (!(obj instanceof PublishExtStdClp)) {
			return false;
		}

		PublishExtStdClp publishExtStd = (PublishExtStdClp)obj;

		long primaryKey = publishExtStd.getPrimaryKey();

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

		sb.append("{compDate=");
		sb.append(getCompDate());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", expiredIds=");
		sb.append(getExpiredIds());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", isGlobal=");
		sb.append(getIsGlobal());
		sb.append(", framework=");
		sb.append(getFramework());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.PublishExtStd");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>compDate</column-name><column-value><![CDATA[");
		sb.append(getCompDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredIds</column-name><column-value><![CDATA[");
		sb.append(getExpiredIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isGlobal</column-name><column-value><![CDATA[");
		sb.append(getIsGlobal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>framework</column-name><column-value><![CDATA[");
		sb.append(getFramework());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private Date _compDate;
	private long _stdId;
	private long _parentId;
	private String _title;
	private String _expiredIds;
	private String _regionCode;
	private String _isGlobal;
	private String _framework;
	private BaseModel<?> _publishExtStdRemoteModel;
}