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
import com.ihg.brandstandards.db.service.StandardsComplianceExtLocalServiceUtil;

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
public class StandardsComplianceExtClp extends BaseModelImpl<StandardsComplianceExt>
	implements StandardsComplianceExt {
	public StandardsComplianceExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsComplianceExt.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsComplianceExt.class.getName();
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
		attributes.put("regionCode", getRegionCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("complianceExpiryDate", getComplianceExpiryDate());
		attributes.put("complianceExpiryRule", getComplianceExpiryRule());
		attributes.put("complianceRuleMonths", getComplianceRuleMonths());
		attributes.put("RuleDate", getRuleDate());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("complianceDateString", getComplianceDateString());
		attributes.put("expiryDateString", getExpiryDateString());

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

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
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

		String expiryDate = (String)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		String complianceDateString = (String)attributes.get(
				"complianceDateString");

		if (complianceDateString != null) {
			setComplianceDateString(complianceDateString);
		}

		String expiryDateString = (String)attributes.get("expiryDateString");

		if (expiryDateString != null) {
			setExpiryDateString(expiryDateString);
		}
	}

	@Override
	public long getStdComplianceId() {
		return _stdComplianceId;
	}

	@Override
	public void setStdComplianceId(long stdComplianceId) {
		_stdComplianceId = stdComplianceId;

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdComplianceId", long.class);

				method.invoke(_standardsComplianceExtRemoteModel,
					stdComplianceId);
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsComplianceExtRemoteModel, stdId);
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_standardsComplianceExtRemoteModel, countryCode);
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_standardsComplianceExtRemoteModel, regionCode);
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_standardsComplianceExtRemoteModel, chainCode);
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceExpiryDate",
						Date.class);

				method.invoke(_standardsComplianceExtRemoteModel,
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceExpiryRule",
						String.class);

				method.invoke(_standardsComplianceExtRemoteModel,
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceRuleMonths",
						long.class);

				method.invoke(_standardsComplianceExtRemoteModel,
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

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRuleDate", String.class);

				method.invoke(_standardsComplianceExtRemoteModel, RuleDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(String expiryDate) {
		_expiryDate = expiryDate;

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDate", String.class);

				method.invoke(_standardsComplianceExtRemoteModel, expiryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComplianceDateString() {
		return _complianceDateString;
	}

	@Override
	public void setComplianceDateString(String complianceDateString) {
		_complianceDateString = complianceDateString;

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceDateString",
						String.class);

				method.invoke(_standardsComplianceExtRemoteModel,
					complianceDateString);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpiryDateString() {
		return _expiryDateString;
	}

	@Override
	public void setExpiryDateString(String expiryDateString) {
		_expiryDateString = expiryDateString;

		if (_standardsComplianceExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsComplianceExtRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDateString",
						String.class);

				method.invoke(_standardsComplianceExtRemoteModel,
					expiryDateString);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStandardsComplianceExtRemoteModel() {
		return _standardsComplianceExtRemoteModel;
	}

	public void setStandardsComplianceExtRemoteModel(
		BaseModel<?> standardsComplianceExtRemoteModel) {
		_standardsComplianceExtRemoteModel = standardsComplianceExtRemoteModel;
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

		Class<?> remoteModelClass = _standardsComplianceExtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsComplianceExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsComplianceExtLocalServiceUtil.addStandardsComplianceExt(this);
		}
		else {
			StandardsComplianceExtLocalServiceUtil.updateStandardsComplianceExt(this);
		}
	}

	@Override
	public StandardsComplianceExt toEscapedModel() {
		return (StandardsComplianceExt)ProxyUtil.newProxyInstance(StandardsComplianceExt.class.getClassLoader(),
			new Class[] { StandardsComplianceExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsComplianceExtClp clone = new StandardsComplianceExtClp();

		clone.setStdComplianceId(getStdComplianceId());
		clone.setStdId(getStdId());
		clone.setCountryCode(getCountryCode());
		clone.setRegionCode(getRegionCode());
		clone.setChainCode(getChainCode());
		clone.setComplianceExpiryDate(getComplianceExpiryDate());
		clone.setComplianceExpiryRule(getComplianceExpiryRule());
		clone.setComplianceRuleMonths(getComplianceRuleMonths());
		clone.setRuleDate(getRuleDate());
		clone.setExpiryDate(getExpiryDate());
		clone.setComplianceDateString(getComplianceDateString());
		clone.setExpiryDateString(getExpiryDateString());

		return clone;
	}

	@Override
	public int compareTo(StandardsComplianceExt standardsComplianceExt) {
		long primaryKey = standardsComplianceExt.getPrimaryKey();

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

		if (!(obj instanceof StandardsComplianceExtClp)) {
			return false;
		}

		StandardsComplianceExtClp standardsComplianceExt = (StandardsComplianceExtClp)obj;

		long primaryKey = standardsComplianceExt.getPrimaryKey();

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
		sb.append(", regionCode=");
		sb.append(getRegionCode());
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
		sb.append(", expiryDate=");
		sb.append(getExpiryDate());
		sb.append(", complianceDateString=");
		sb.append(getComplianceDateString());
		sb.append(", expiryDateString=");
		sb.append(getExpiryDateString());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsComplianceExt");
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
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
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
			"<column><column-name>expiryDate</column-name><column-value><![CDATA[");
		sb.append(getExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceDateString</column-name><column-value><![CDATA[");
		sb.append(getComplianceDateString());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiryDateString</column-name><column-value><![CDATA[");
		sb.append(getExpiryDateString());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stdComplianceId;
	private long _stdId;
	private String _countryCode;
	private String _regionCode;
	private String _chainCode;
	private Date _complianceExpiryDate;
	private String _complianceExpiryRule;
	private long _complianceRuleMonths;
	private String _RuleDate;
	private String _expiryDate;
	private String _complianceDateString;
	private String _expiryDateString;
	private BaseModel<?> _standardsComplianceExtRemoteModel;
}