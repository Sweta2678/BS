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
import com.ihg.brandstandards.db.service.StandardsRegionChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK;

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
public class StandardsRegionChainClp extends BaseModelImpl<StandardsRegionChain>
	implements StandardsRegionChain {
	public StandardsRegionChainClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsRegionChain.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsRegionChain.class.getName();
	}

	@Override
	public StandardsRegionChainPK getPrimaryKey() {
		return new StandardsRegionChainPK(_stdId, _regionCode, _chainCode);
	}

	@Override
	public void setPrimaryKey(StandardsRegionChainPK primaryKey) {
		setStdId(primaryKey.stdId);
		setRegionCode(primaryKey.regionCode);
		setChainCode(primaryKey.chainCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardsRegionChainPK(_stdId, _regionCode, _chainCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardsRegionChainPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("regionCode", getRegionCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("compDate", getCompDate());
		attributes.put("expiredIds", getExpiredIds());
		attributes.put("complianceRule", getComplianceRule());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		Date compDate = (Date)attributes.get("compDate");

		if (compDate != null) {
			setCompDate(compDate);
		}

		String expiredIds = (String)attributes.get("expiredIds");

		if (expiredIds != null) {
			setExpiredIds(expiredIds);
		}

		Long complianceRule = (Long)attributes.get("complianceRule");

		if (complianceRule != null) {
			setComplianceRule(complianceRule);
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
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsRegionChainRemoteModel, stdId);
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

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_standardsRegionChainRemoteModel, regionCode);
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

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_standardsRegionChainRemoteModel, chainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCompDate() {
		return _compDate;
	}

	@Override
	public void setCompDate(Date compDate) {
		_compDate = compDate;

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCompDate", Date.class);

				method.invoke(_standardsRegionChainRemoteModel, compDate);
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

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredIds", String.class);

				method.invoke(_standardsRegionChainRemoteModel, expiredIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getComplianceRule() {
		return _complianceRule;
	}

	@Override
	public void setComplianceRule(long complianceRule) {
		_complianceRule = complianceRule;

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceRule", long.class);

				method.invoke(_standardsRegionChainRemoteModel, complianceRule);
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

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsRegionChainRemoteModel, creatorId);
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

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsRegionChainRemoteModel, createdDate);
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

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsRegionChainRemoteModel, updatedBy);
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

		if (_standardsRegionChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRegionChainRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsRegionChainRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsRegionChainRemoteModel() {
		return _standardsRegionChainRemoteModel;
	}

	public void setStandardsRegionChainRemoteModel(
		BaseModel<?> standardsRegionChainRemoteModel) {
		_standardsRegionChainRemoteModel = standardsRegionChainRemoteModel;
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

		Class<?> remoteModelClass = _standardsRegionChainRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsRegionChainRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsRegionChainLocalServiceUtil.addStandardsRegionChain(this);
		}
		else {
			StandardsRegionChainLocalServiceUtil.updateStandardsRegionChain(this);
		}
	}

	@Override
	public StandardsRegionChain toEscapedModel() {
		return (StandardsRegionChain)ProxyUtil.newProxyInstance(StandardsRegionChain.class.getClassLoader(),
			new Class[] { StandardsRegionChain.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsRegionChainClp clone = new StandardsRegionChainClp();

		clone.setStdId(getStdId());
		clone.setRegionCode(getRegionCode());
		clone.setChainCode(getChainCode());
		clone.setCompDate(getCompDate());
		clone.setExpiredIds(getExpiredIds());
		clone.setComplianceRule(getComplianceRule());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsRegionChain standardsRegionChain) {
		StandardsRegionChainPK primaryKey = standardsRegionChain.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsRegionChainClp)) {
			return false;
		}

		StandardsRegionChainClp standardsRegionChain = (StandardsRegionChainClp)obj;

		StandardsRegionChainPK primaryKey = standardsRegionChain.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", compDate=");
		sb.append(getCompDate());
		sb.append(", expiredIds=");
		sb.append(getExpiredIds());
		sb.append(", complianceRule=");
		sb.append(getComplianceRule());
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
		sb.append("com.ihg.brandstandards.db.model.StandardsRegionChain");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>compDate</column-name><column-value><![CDATA[");
		sb.append(getCompDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredIds</column-name><column-value><![CDATA[");
		sb.append(getExpiredIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceRule</column-name><column-value><![CDATA[");
		sb.append(getComplianceRule());
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

	private long _stdId;
	private String _regionCode;
	private String _chainCode;
	private Date _compDate;
	private String _expiredIds;
	private long _complianceRule;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _standardsRegionChainRemoteModel;
}