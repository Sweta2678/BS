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
import com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class UserPreferenceClp extends BaseModelImpl<UserPreference>
	implements UserPreference {
	public UserPreferenceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserPreference.class;
	}

	@Override
	public String getModelClassName() {
		return UserPreference.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _preferenceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPreferenceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _preferenceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("preferenceId", getPreferenceId());
		attributes.put("userId", getUserId());
		attributes.put("langCode", getLangCode());
		attributes.put("pdfLangCode", getPdfLangCode());
		attributes.put("buildType", getBuildType());
		attributes.put("chainCode", getChainCode());
		attributes.put("reportType", getReportType());
		attributes.put("paperSize", getPaperSize());
		attributes.put("itemsPerPage", getItemsPerPage());
		attributes.put("infoDisplay", getInfoDisplay());
		attributes.put("CountryCode", getCountryCode());
		attributes.put("unsubscribeEmail", getUnsubscribeEmail());
		attributes.put("moduleName", getModuleName());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long preferenceId = (Long)attributes.get("preferenceId");

		if (preferenceId != null) {
			setPreferenceId(preferenceId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String langCode = (String)attributes.get("langCode");

		if (langCode != null) {
			setLangCode(langCode);
		}

		String pdfLangCode = (String)attributes.get("pdfLangCode");

		if (pdfLangCode != null) {
			setPdfLangCode(pdfLangCode);
		}

		String buildType = (String)attributes.get("buildType");

		if (buildType != null) {
			setBuildType(buildType);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String reportType = (String)attributes.get("reportType");

		if (reportType != null) {
			setReportType(reportType);
		}

		String paperSize = (String)attributes.get("paperSize");

		if (paperSize != null) {
			setPaperSize(paperSize);
		}

		String itemsPerPage = (String)attributes.get("itemsPerPage");

		if (itemsPerPage != null) {
			setItemsPerPage(itemsPerPage);
		}

		String infoDisplay = (String)attributes.get("infoDisplay");

		if (infoDisplay != null) {
			setInfoDisplay(infoDisplay);
		}

		String CountryCode = (String)attributes.get("CountryCode");

		if (CountryCode != null) {
			setCountryCode(CountryCode);
		}

		String unsubscribeEmail = (String)attributes.get("unsubscribeEmail");

		if (unsubscribeEmail != null) {
			setUnsubscribeEmail(unsubscribeEmail);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
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
	public long getPreferenceId() {
		return _preferenceId;
	}

	@Override
	public void setPreferenceId(long preferenceId) {
		_preferenceId = preferenceId;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPreferenceId", long.class);

				method.invoke(_userPreferenceRemoteModel, preferenceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userPreferenceRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getLangCode() {
		return _langCode;
	}

	@Override
	public void setLangCode(String langCode) {
		_langCode = langCode;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setLangCode", String.class);

				method.invoke(_userPreferenceRemoteModel, langCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPdfLangCode() {
		return _pdfLangCode;
	}

	@Override
	public void setPdfLangCode(String pdfLangCode) {
		_pdfLangCode = pdfLangCode;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfLangCode", String.class);

				method.invoke(_userPreferenceRemoteModel, pdfLangCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBuildType() {
		return _buildType;
	}

	@Override
	public void setBuildType(String buildType) {
		_buildType = buildType;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setBuildType", String.class);

				method.invoke(_userPreferenceRemoteModel, buildType);
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

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_userPreferenceRemoteModel, chainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReportType() {
		return _reportType;
	}

	@Override
	public void setReportType(String reportType) {
		_reportType = reportType;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setReportType", String.class);

				method.invoke(_userPreferenceRemoteModel, reportType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPaperSize() {
		return _paperSize;
	}

	@Override
	public void setPaperSize(String paperSize) {
		_paperSize = paperSize;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setPaperSize", String.class);

				method.invoke(_userPreferenceRemoteModel, paperSize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getItemsPerPage() {
		return _itemsPerPage;
	}

	@Override
	public void setItemsPerPage(String itemsPerPage) {
		_itemsPerPage = itemsPerPage;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setItemsPerPage", String.class);

				method.invoke(_userPreferenceRemoteModel, itemsPerPage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInfoDisplay() {
		return _infoDisplay;
	}

	@Override
	public void setInfoDisplay(String infoDisplay) {
		_infoDisplay = infoDisplay;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setInfoDisplay", String.class);

				method.invoke(_userPreferenceRemoteModel, infoDisplay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _CountryCode;
	}

	@Override
	public void setCountryCode(String CountryCode) {
		_CountryCode = CountryCode;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_userPreferenceRemoteModel, CountryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUnsubscribeEmail() {
		return _unsubscribeEmail;
	}

	@Override
	public void setUnsubscribeEmail(String unsubscribeEmail) {
		_unsubscribeEmail = unsubscribeEmail;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUnsubscribeEmail",
						String.class);

				method.invoke(_userPreferenceRemoteModel, unsubscribeEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleName() {
		return _moduleName;
	}

	@Override
	public void setModuleName(String moduleName) {
		_moduleName = moduleName;

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleName", String.class);

				method.invoke(_userPreferenceRemoteModel, moduleName);
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

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_userPreferenceRemoteModel, creatorId);
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

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_userPreferenceRemoteModel, createdDate);
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

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_userPreferenceRemoteModel, updatedBy);
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

		if (_userPreferenceRemoteModel != null) {
			try {
				Class<?> clazz = _userPreferenceRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_userPreferenceRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserPreferenceRemoteModel() {
		return _userPreferenceRemoteModel;
	}

	public void setUserPreferenceRemoteModel(
		BaseModel<?> userPreferenceRemoteModel) {
		_userPreferenceRemoteModel = userPreferenceRemoteModel;
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

		Class<?> remoteModelClass = _userPreferenceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userPreferenceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserPreferenceLocalServiceUtil.addUserPreference(this);
		}
		else {
			UserPreferenceLocalServiceUtil.updateUserPreference(this);
		}
	}

	@Override
	public UserPreference toEscapedModel() {
		return (UserPreference)ProxyUtil.newProxyInstance(UserPreference.class.getClassLoader(),
			new Class[] { UserPreference.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserPreferenceClp clone = new UserPreferenceClp();

		clone.setPreferenceId(getPreferenceId());
		clone.setUserId(getUserId());
		clone.setLangCode(getLangCode());
		clone.setPdfLangCode(getPdfLangCode());
		clone.setBuildType(getBuildType());
		clone.setChainCode(getChainCode());
		clone.setReportType(getReportType());
		clone.setPaperSize(getPaperSize());
		clone.setItemsPerPage(getItemsPerPage());
		clone.setInfoDisplay(getInfoDisplay());
		clone.setCountryCode(getCountryCode());
		clone.setUnsubscribeEmail(getUnsubscribeEmail());
		clone.setModuleName(getModuleName());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(UserPreference userPreference) {
		long primaryKey = userPreference.getPrimaryKey();

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

		if (!(obj instanceof UserPreferenceClp)) {
			return false;
		}

		UserPreferenceClp userPreference = (UserPreferenceClp)obj;

		long primaryKey = userPreference.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{preferenceId=");
		sb.append(getPreferenceId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", langCode=");
		sb.append(getLangCode());
		sb.append(", pdfLangCode=");
		sb.append(getPdfLangCode());
		sb.append(", buildType=");
		sb.append(getBuildType());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", reportType=");
		sb.append(getReportType());
		sb.append(", paperSize=");
		sb.append(getPaperSize());
		sb.append(", itemsPerPage=");
		sb.append(getItemsPerPage());
		sb.append(", infoDisplay=");
		sb.append(getInfoDisplay());
		sb.append(", CountryCode=");
		sb.append(getCountryCode());
		sb.append(", unsubscribeEmail=");
		sb.append(getUnsubscribeEmail());
		sb.append(", moduleName=");
		sb.append(getModuleName());
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
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.UserPreference");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>preferenceId</column-name><column-value><![CDATA[");
		sb.append(getPreferenceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>langCode</column-name><column-value><![CDATA[");
		sb.append(getLangCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfLangCode</column-name><column-value><![CDATA[");
		sb.append(getPdfLangCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>buildType</column-name><column-value><![CDATA[");
		sb.append(getBuildType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reportType</column-name><column-value><![CDATA[");
		sb.append(getReportType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paperSize</column-name><column-value><![CDATA[");
		sb.append(getPaperSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemsPerPage</column-name><column-value><![CDATA[");
		sb.append(getItemsPerPage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>infoDisplay</column-name><column-value><![CDATA[");
		sb.append(getInfoDisplay());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CountryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unsubscribeEmail</column-name><column-value><![CDATA[");
		sb.append(getUnsubscribeEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleName</column-name><column-value><![CDATA[");
		sb.append(getModuleName());
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

	private long _preferenceId;
	private long _userId;
	private String _userUuid;
	private String _langCode;
	private String _pdfLangCode;
	private String _buildType;
	private String _chainCode;
	private String _reportType;
	private String _paperSize;
	private String _itemsPerPage;
	private String _infoDisplay;
	private String _CountryCode;
	private String _unsubscribeEmail;
	private String _moduleName;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _userPreferenceRemoteModel;
}