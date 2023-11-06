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
import com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil;

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
public class GlossaryRegionNavClp extends BaseModelImpl<GlossaryRegionNav>
	implements GlossaryRegionNav {
	public GlossaryRegionNavClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GlossaryRegionNav.class;
	}

	@Override
	public String getModelClassName() {
		return GlossaryRegionNav.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _glossaryRgnNavId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGlossaryRgnNavId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _glossaryRgnNavId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryRgnNavId", getGlossaryRgnNavId());
		attributes.put("glossaryId", getGlossaryId());
		attributes.put("regionId", getRegionId());
		attributes.put("navItemText", getNavItemText());
		attributes.put("activeInd", getActiveInd());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryRgnNavId = (Long)attributes.get("glossaryRgnNavId");

		if (glossaryRgnNavId != null) {
			setGlossaryRgnNavId(glossaryRgnNavId);
		}

		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String navItemText = (String)attributes.get("navItemText");

		if (navItemText != null) {
			setNavItemText(navItemText);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
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
	public long getGlossaryRgnNavId() {
		return _glossaryRgnNavId;
	}

	@Override
	public void setGlossaryRgnNavId(long glossaryRgnNavId) {
		_glossaryRgnNavId = glossaryRgnNavId;

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryRgnNavId",
						long.class);

				method.invoke(_glossaryRegionNavRemoteModel, glossaryRgnNavId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGlossaryId() {
		return _glossaryId;
	}

	@Override
	public void setGlossaryId(long glossaryId) {
		_glossaryId = glossaryId;

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setGlossaryId", long.class);

				method.invoke(_glossaryRegionNavRemoteModel, glossaryId);
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

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_glossaryRegionNavRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNavItemText() {
		return _navItemText;
	}

	@Override
	public void setNavItemText(String navItemText) {
		_navItemText = navItemText;

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setNavItemText", String.class);

				method.invoke(_glossaryRegionNavRemoteModel, navItemText);
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

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveInd", String.class);

				method.invoke(_glossaryRegionNavRemoteModel, activeInd);
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

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_glossaryRegionNavRemoteModel, chainCode);
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

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_glossaryRegionNavRemoteModel, creatorId);
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

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_glossaryRegionNavRemoteModel, createdDate);
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

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_glossaryRegionNavRemoteModel, updatedBy);
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

		if (_glossaryRegionNavRemoteModel != null) {
			try {
				Class<?> clazz = _glossaryRegionNavRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_glossaryRegionNavRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGlossaryRegionNavRemoteModel() {
		return _glossaryRegionNavRemoteModel;
	}

	public void setGlossaryRegionNavRemoteModel(
		BaseModel<?> glossaryRegionNavRemoteModel) {
		_glossaryRegionNavRemoteModel = glossaryRegionNavRemoteModel;
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

		Class<?> remoteModelClass = _glossaryRegionNavRemoteModel.getClass();

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

		Object returnValue = method.invoke(_glossaryRegionNavRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GlossaryRegionNavLocalServiceUtil.addGlossaryRegionNav(this);
		}
		else {
			GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(this);
		}
	}

	@Override
	public GlossaryRegionNav toEscapedModel() {
		return (GlossaryRegionNav)ProxyUtil.newProxyInstance(GlossaryRegionNav.class.getClassLoader(),
			new Class[] { GlossaryRegionNav.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GlossaryRegionNavClp clone = new GlossaryRegionNavClp();

		clone.setGlossaryRgnNavId(getGlossaryRgnNavId());
		clone.setGlossaryId(getGlossaryId());
		clone.setRegionId(getRegionId());
		clone.setNavItemText(getNavItemText());
		clone.setActiveInd(getActiveInd());
		clone.setChainCode(getChainCode());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GlossaryRegionNav glossaryRegionNav) {
		int value = 0;

		value = getNavItemText().compareTo(glossaryRegionNav.getNavItemText());

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

		if (!(obj instanceof GlossaryRegionNavClp)) {
			return false;
		}

		GlossaryRegionNavClp glossaryRegionNav = (GlossaryRegionNavClp)obj;

		long primaryKey = glossaryRegionNav.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{glossaryRgnNavId=");
		sb.append(getGlossaryRgnNavId());
		sb.append(", glossaryId=");
		sb.append(getGlossaryId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", navItemText=");
		sb.append(getNavItemText());
		sb.append(", activeInd=");
		sb.append(getActiveInd());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.GlossaryRegionNav");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>glossaryRgnNavId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryRgnNavId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>glossaryId</column-name><column-value><![CDATA[");
		sb.append(getGlossaryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>navItemText</column-name><column-value><![CDATA[");
		sb.append(getNavItemText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeInd</column-name><column-value><![CDATA[");
		sb.append(getActiveInd());
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

	private long _glossaryRgnNavId;
	private long _glossaryId;
	private long _regionId;
	private String _navItemText;
	private String _activeInd;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _glossaryRegionNavRemoteModel;
}