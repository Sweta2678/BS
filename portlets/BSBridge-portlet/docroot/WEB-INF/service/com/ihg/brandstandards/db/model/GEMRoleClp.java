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
import com.ihg.brandstandards.db.service.GEMRoleLocalServiceUtil;

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
public class GEMRoleClp extends BaseModelImpl<GEMRole> implements GEMRole {
	public GEMRoleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return GEMRole.class;
	}

	@Override
	public String getModelClassName() {
		return GEMRole.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _gemGrpId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setGemGrpId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _gemGrpId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gemGrpId", getGemGrpId());
		attributes.put("regionId", getRegionId());
		attributes.put("chainCode", getChainCode());
		attributes.put("gemGrpCode", getGemGrpCode());
		attributes.put("ownerGrpId", getOwnerGrpId());
		attributes.put("ownerGrpName", getOwnerGrpName());
		attributes.put("busOwnerName", getBusOwnerName());
		attributes.put("deligate1Name", getDeligate1Name());
		attributes.put("deligate2Name", getDeligate2Name());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gemGrpId = (Long)attributes.get("gemGrpId");

		if (gemGrpId != null) {
			setGemGrpId(gemGrpId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String gemGrpCode = (String)attributes.get("gemGrpCode");

		if (gemGrpCode != null) {
			setGemGrpCode(gemGrpCode);
		}

		String ownerGrpId = (String)attributes.get("ownerGrpId");

		if (ownerGrpId != null) {
			setOwnerGrpId(ownerGrpId);
		}

		String ownerGrpName = (String)attributes.get("ownerGrpName");

		if (ownerGrpName != null) {
			setOwnerGrpName(ownerGrpName);
		}

		String busOwnerName = (String)attributes.get("busOwnerName");

		if (busOwnerName != null) {
			setBusOwnerName(busOwnerName);
		}

		String deligate1Name = (String)attributes.get("deligate1Name");

		if (deligate1Name != null) {
			setDeligate1Name(deligate1Name);
		}

		String deligate2Name = (String)attributes.get("deligate2Name");

		if (deligate2Name != null) {
			setDeligate2Name(deligate2Name);
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
	public long getGemGrpId() {
		return _gemGrpId;
	}

	@Override
	public void setGemGrpId(long gemGrpId) {
		_gemGrpId = gemGrpId;

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setGemGrpId", long.class);

				method.invoke(_gemRoleRemoteModel, gemGrpId);
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

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_gemRoleRemoteModel, regionId);
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

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_gemRoleRemoteModel, chainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGemGrpCode() {
		return _gemGrpCode;
	}

	@Override
	public void setGemGrpCode(String gemGrpCode) {
		_gemGrpCode = gemGrpCode;

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setGemGrpCode", String.class);

				method.invoke(_gemRoleRemoteModel, gemGrpCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOwnerGrpId() {
		return _ownerGrpId;
	}

	@Override
	public void setOwnerGrpId(String ownerGrpId) {
		_ownerGrpId = ownerGrpId;

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerGrpId", String.class);

				method.invoke(_gemRoleRemoteModel, ownerGrpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOwnerGrpName() {
		return _ownerGrpName;
	}

	@Override
	public void setOwnerGrpName(String ownerGrpName) {
		_ownerGrpName = ownerGrpName;

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerGrpName", String.class);

				method.invoke(_gemRoleRemoteModel, ownerGrpName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusOwnerName() {
		return _busOwnerName;
	}

	@Override
	public void setBusOwnerName(String busOwnerName) {
		_busOwnerName = busOwnerName;

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setBusOwnerName", String.class);

				method.invoke(_gemRoleRemoteModel, busOwnerName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeligate1Name() {
		return _deligate1Name;
	}

	@Override
	public void setDeligate1Name(String deligate1Name) {
		_deligate1Name = deligate1Name;

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setDeligate1Name", String.class);

				method.invoke(_gemRoleRemoteModel, deligate1Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDeligate2Name() {
		return _deligate2Name;
	}

	@Override
	public void setDeligate2Name(String deligate2Name) {
		_deligate2Name = deligate2Name;

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setDeligate2Name", String.class);

				method.invoke(_gemRoleRemoteModel, deligate2Name);
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

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_gemRoleRemoteModel, creatorId);
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

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_gemRoleRemoteModel, createdDate);
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

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_gemRoleRemoteModel, updatedBy);
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

		if (_gemRoleRemoteModel != null) {
			try {
				Class<?> clazz = _gemRoleRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_gemRoleRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getGEMRoleRemoteModel() {
		return _gemRoleRemoteModel;
	}

	public void setGEMRoleRemoteModel(BaseModel<?> gemRoleRemoteModel) {
		_gemRoleRemoteModel = gemRoleRemoteModel;
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

		Class<?> remoteModelClass = _gemRoleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_gemRoleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMRoleLocalServiceUtil.addGEMRole(this);
		}
		else {
			GEMRoleLocalServiceUtil.updateGEMRole(this);
		}
	}

	@Override
	public GEMRole toEscapedModel() {
		return (GEMRole)ProxyUtil.newProxyInstance(GEMRole.class.getClassLoader(),
			new Class[] { GEMRole.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		GEMRoleClp clone = new GEMRoleClp();

		clone.setGemGrpId(getGemGrpId());
		clone.setRegionId(getRegionId());
		clone.setChainCode(getChainCode());
		clone.setGemGrpCode(getGemGrpCode());
		clone.setOwnerGrpId(getOwnerGrpId());
		clone.setOwnerGrpName(getOwnerGrpName());
		clone.setBusOwnerName(getBusOwnerName());
		clone.setDeligate1Name(getDeligate1Name());
		clone.setDeligate2Name(getDeligate2Name());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(GEMRole gemRole) {
		int value = 0;

		value = getOwnerGrpName().compareTo(gemRole.getOwnerGrpName());

		if (value != 0) {
			return value;
		}

		value = getGemGrpCode().compareTo(gemRole.getGemGrpCode());

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

		if (!(obj instanceof GEMRoleClp)) {
			return false;
		}

		GEMRoleClp gemRole = (GEMRoleClp)obj;

		long primaryKey = gemRole.getPrimaryKey();

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

		sb.append("{gemGrpId=");
		sb.append(getGemGrpId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", gemGrpCode=");
		sb.append(getGemGrpCode());
		sb.append(", ownerGrpId=");
		sb.append(getOwnerGrpId());
		sb.append(", ownerGrpName=");
		sb.append(getOwnerGrpName());
		sb.append(", busOwnerName=");
		sb.append(getBusOwnerName());
		sb.append(", deligate1Name=");
		sb.append(getDeligate1Name());
		sb.append(", deligate2Name=");
		sb.append(getDeligate2Name());
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
		sb.append("com.ihg.brandstandards.db.model.GEMRole");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>gemGrpId</column-name><column-value><![CDATA[");
		sb.append(getGemGrpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gemGrpCode</column-name><column-value><![CDATA[");
		sb.append(getGemGrpCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerGrpId</column-name><column-value><![CDATA[");
		sb.append(getOwnerGrpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerGrpName</column-name><column-value><![CDATA[");
		sb.append(getOwnerGrpName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>busOwnerName</column-name><column-value><![CDATA[");
		sb.append(getBusOwnerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deligate1Name</column-name><column-value><![CDATA[");
		sb.append(getDeligate1Name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deligate2Name</column-name><column-value><![CDATA[");
		sb.append(getDeligate2Name());
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

	private long _gemGrpId;
	private long _regionId;
	private String _chainCode;
	private String _gemGrpCode;
	private String _ownerGrpId;
	private String _ownerGrpName;
	private String _busOwnerName;
	private String _deligate1Name;
	private String _deligate2Name;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _gemRoleRemoteModel;
}