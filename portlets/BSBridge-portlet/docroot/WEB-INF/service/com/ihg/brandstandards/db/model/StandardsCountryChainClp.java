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
import com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK;

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
public class StandardsCountryChainClp extends BaseModelImpl<StandardsCountryChain>
	implements StandardsCountryChain {
	public StandardsCountryChainClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCountryChain.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCountryChain.class.getName();
	}

	@Override
	public StandardsCountryChainPK getPrimaryKey() {
		return new StandardsCountryChainPK(_stdId, _countryCode, _chainCode);
	}

	@Override
	public void setPrimaryKey(StandardsCountryChainPK primaryKey) {
		setStdId(primaryKey.stdId);
		setCountryCode(primaryKey.countryCode);
		setChainCode(primaryKey.chainCode);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardsCountryChainPK(_stdId, _countryCode, _chainCode);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardsCountryChainPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("compDate", getCompDate());
		attributes.put("exprDate", getExprDate());
		attributes.put("expiredIds", getExpiredIds());
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

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		Date compDate = (Date)attributes.get("compDate");

		if (compDate != null) {
			setCompDate(compDate);
		}

		Date exprDate = (Date)attributes.get("exprDate");

		if (exprDate != null) {
			setExprDate(exprDate);
		}

		String expiredIds = (String)attributes.get("expiredIds");

		if (expiredIds != null) {
			setExpiredIds(expiredIds);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsCountryChainRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _countryCode;
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_standardsCountryChainRemoteModel, countryCode);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_standardsCountryChainRemoteModel, chainCode);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_standardsCountryChainRemoteModel, regionCode);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCompDate", Date.class);

				method.invoke(_standardsCountryChainRemoteModel, compDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExprDate() {
		return _exprDate;
	}

	@Override
	public void setExprDate(Date exprDate) {
		_exprDate = exprDate;

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setExprDate", Date.class);

				method.invoke(_standardsCountryChainRemoteModel, exprDate);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredIds", String.class);

				method.invoke(_standardsCountryChainRemoteModel, expiredIds);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsCountryChainRemoteModel, creatorId);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsCountryChainRemoteModel, createdDate);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsCountryChainRemoteModel, updatedBy);
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

		if (_standardsCountryChainRemoteModel != null) {
			try {
				Class<?> clazz = _standardsCountryChainRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsCountryChainRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsCountryChainRemoteModel() {
		return _standardsCountryChainRemoteModel;
	}

	public void setStandardsCountryChainRemoteModel(
		BaseModel<?> standardsCountryChainRemoteModel) {
		_standardsCountryChainRemoteModel = standardsCountryChainRemoteModel;
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

		Class<?> remoteModelClass = _standardsCountryChainRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsCountryChainRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsCountryChainLocalServiceUtil.addStandardsCountryChain(this);
		}
		else {
			StandardsCountryChainLocalServiceUtil.updateStandardsCountryChain(this);
		}
	}

	@Override
	public StandardsCountryChain toEscapedModel() {
		return (StandardsCountryChain)ProxyUtil.newProxyInstance(StandardsCountryChain.class.getClassLoader(),
			new Class[] { StandardsCountryChain.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsCountryChainClp clone = new StandardsCountryChainClp();

		clone.setStdId(getStdId());
		clone.setCountryCode(getCountryCode());
		clone.setChainCode(getChainCode());
		clone.setRegionCode(getRegionCode());
		clone.setCompDate(getCompDate());
		clone.setExprDate(getExprDate());
		clone.setExpiredIds(getExpiredIds());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsCountryChain standardsCountryChain) {
		StandardsCountryChainPK primaryKey = standardsCountryChain.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsCountryChainClp)) {
			return false;
		}

		StandardsCountryChainClp standardsCountryChain = (StandardsCountryChainClp)obj;

		StandardsCountryChainPK primaryKey = standardsCountryChain.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", compDate=");
		sb.append(getCompDate());
		sb.append(", exprDate=");
		sb.append(getExprDate());
		sb.append(", expiredIds=");
		sb.append(getExpiredIds());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsCountryChain");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
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
			"<column><column-name>compDate</column-name><column-value><![CDATA[");
		sb.append(getCompDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>exprDate</column-name><column-value><![CDATA[");
		sb.append(getExprDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredIds</column-name><column-value><![CDATA[");
		sb.append(getExpiredIds());
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
	private String _countryCode;
	private String _chainCode;
	private String _regionCode;
	private Date _compDate;
	private Date _exprDate;
	private String _expiredIds;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _standardsCountryChainRemoteModel;
}