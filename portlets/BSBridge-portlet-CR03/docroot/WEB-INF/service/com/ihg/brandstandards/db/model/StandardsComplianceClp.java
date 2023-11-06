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
import com.ihg.brandstandards.db.service.StandardsComplianceLocalServiceUtil;

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
public class StandardsComplianceClp extends BaseModelImpl<StandardsCompliance>
	implements StandardsCompliance {
	public StandardsComplianceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCompliance.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCompliance.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stdComplianceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdComplianceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdComplianceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdComplianceId", getStdComplianceId());
		attributes.put("stdId", getStdId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("complianceExpiryDate", getComplianceExpiryDate());
		attributes.put("complianceExpiryRule", getComplianceExpiryRule());
		attributes.put("complianceRuleMonths", getComplianceRuleMonths());
		attributes.put("RuleDate", getRuleDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdComplianceId = (Long)attributes.get("stdComplianceId");

		if (stdComplianceId != null) {
			setStdComplianceId(stdComplianceId);
		}

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

		Date complianceExpiryDate = (Date)attributes.get("complianceExpiryDate");

		if (complianceExpiryDate != null) {
			setComplianceExpiryDate(complianceExpiryDate);
		}

		String complianceExpiryRule = (String)attributes.get(
				"complianceExpiryRule");

		if (complianceExpiryRule != null) {
			setComplianceExpiryRule(complianceExpiryRule);
		}

		Long complianceRuleMonths = (Long)attributes.get("complianceRuleMonths");

		if (complianceRuleMonths != null) {
			setComplianceRuleMonths(complianceRuleMonths);
		}

		String RuleDate = (String)attributes.get("RuleDate");

		if (RuleDate != null) {
			setRuleDate(RuleDate);
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
	public long getStdComplianceId() {
		return _stdComplianceId;
	}

	@Override
	public void setStdComplianceId(long stdComplianceId) {
		_stdComplianceId = stdComplianceId;

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setStdComplianceId", long.class);

				method.invoke(_standardsComplianceRemoteModel, stdComplianceId);
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

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsComplianceRemoteModel, stdId);
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

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_standardsComplianceRemoteModel, countryCode);
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

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_standardsComplianceRemoteModel, chainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getComplianceExpiryDate() {
		return _complianceExpiryDate;
	}

	@Override
	public void setComplianceExpiryDate(Date complianceExpiryDate) {
		_complianceExpiryDate = complianceExpiryDate;

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceExpiryDate",
						Date.class);

				method.invoke(_standardsComplianceRemoteModel,
					complianceExpiryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComplianceExpiryRule() {
		return _complianceExpiryRule;
	}

	@Override
	public void setComplianceExpiryRule(String complianceExpiryRule) {
		_complianceExpiryRule = complianceExpiryRule;

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceExpiryRule",
						String.class);

				method.invoke(_standardsComplianceRemoteModel,
					complianceExpiryRule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getComplianceRuleMonths() {
		return _complianceRuleMonths;
	}

	@Override
	public void setComplianceRuleMonths(long complianceRuleMonths) {
		_complianceRuleMonths = complianceRuleMonths;

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceRuleMonths",
						long.class);

				method.invoke(_standardsComplianceRemoteModel,
					complianceRuleMonths);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRuleDate() {
		return _RuleDate;
	}

	@Override
	public void setRuleDate(String RuleDate) {
		_RuleDate = RuleDate;

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setRuleDate", String.class);

				method.invoke(_standardsComplianceRemoteModel, RuleDate);
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

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsComplianceRemoteModel, creatorId);
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

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsComplianceRemoteModel, createdDate);
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

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsComplianceRemoteModel, updatedBy);
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

		if (_standardsComplianceRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsComplianceRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsComplianceRemoteModel() {
		return _standardsComplianceRemoteModel;
	}

	public void setStandardsComplianceRemoteModel(
		BaseModel<?> standardsComplianceRemoteModel) {
		_standardsComplianceRemoteModel = standardsComplianceRemoteModel;
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

		Class<?> remoteModelClass = _standardsComplianceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsComplianceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsComplianceLocalServiceUtil.addStandardsCompliance(this);
		}
		else {
			StandardsComplianceLocalServiceUtil.updateStandardsCompliance(this);
		}
	}

	@Override
	public StandardsCompliance toEscapedModel() {
		return (StandardsCompliance)ProxyUtil.newProxyInstance(StandardsCompliance.class.getClassLoader(),
			new Class[] { StandardsCompliance.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsComplianceClp clone = new StandardsComplianceClp();

		clone.setStdComplianceId(getStdComplianceId());
		clone.setStdId(getStdId());
		clone.setCountryCode(getCountryCode());
		clone.setChainCode(getChainCode());
		clone.setComplianceExpiryDate(getComplianceExpiryDate());
		clone.setComplianceExpiryRule(getComplianceExpiryRule());
		clone.setComplianceRuleMonths(getComplianceRuleMonths());
		clone.setRuleDate(getRuleDate());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(StandardsCompliance standardsCompliance) {
		long primaryKey = standardsCompliance.getPrimaryKey();

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

		if (!(obj instanceof StandardsComplianceClp)) {
			return false;
		}

		StandardsComplianceClp standardsCompliance = (StandardsComplianceClp)obj;

		long primaryKey = standardsCompliance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{stdComplianceId=");
		sb.append(getStdComplianceId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", complianceExpiryDate=");
		sb.append(getComplianceExpiryDate());
		sb.append(", complianceExpiryRule=");
		sb.append(getComplianceExpiryRule());
		sb.append(", complianceRuleMonths=");
		sb.append(getComplianceRuleMonths());
		sb.append(", RuleDate=");
		sb.append(getRuleDate());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsCompliance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdComplianceId</column-name><column-value><![CDATA[");
		sb.append(getStdComplianceId());
		sb.append("]]></column-value></column>");
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
			"<column><column-name>complianceExpiryDate</column-name><column-value><![CDATA[");
		sb.append(getComplianceExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceExpiryRule</column-name><column-value><![CDATA[");
		sb.append(getComplianceExpiryRule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceRuleMonths</column-name><column-value><![CDATA[");
		sb.append(getComplianceRuleMonths());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RuleDate</column-name><column-value><![CDATA[");
		sb.append(getRuleDate());
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

	private long _stdComplianceId;
	private long _stdId;
	private String _countryCode;
	private String _chainCode;
	private Date _complianceExpiryDate;
	private String _complianceExpiryRule;
	private long _complianceRuleMonths;
	private String _RuleDate;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _standardsComplianceRemoteModel;
}