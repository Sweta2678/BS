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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserPreference}.
 * </p>
 *
 * @author Mummanedi
 * @see UserPreference
 * @generated
 */
public class UserPreferenceWrapper implements UserPreference,
	ModelWrapper<UserPreference> {
	public UserPreferenceWrapper(UserPreference userPreference) {
		_userPreference = userPreference;
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

	/**
	* Returns the primary key of this user preference.
	*
	* @return the primary key of this user preference
	*/
	@Override
	public long getPrimaryKey() {
		return _userPreference.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user preference.
	*
	* @param primaryKey the primary key of this user preference
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userPreference.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the preference ID of this user preference.
	*
	* @return the preference ID of this user preference
	*/
	@Override
	public long getPreferenceId() {
		return _userPreference.getPreferenceId();
	}

	/**
	* Sets the preference ID of this user preference.
	*
	* @param preferenceId the preference ID of this user preference
	*/
	@Override
	public void setPreferenceId(long preferenceId) {
		_userPreference.setPreferenceId(preferenceId);
	}

	/**
	* Returns the user ID of this user preference.
	*
	* @return the user ID of this user preference
	*/
	@Override
	public long getUserId() {
		return _userPreference.getUserId();
	}

	/**
	* Sets the user ID of this user preference.
	*
	* @param userId the user ID of this user preference
	*/
	@Override
	public void setUserId(long userId) {
		_userPreference.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user preference.
	*
	* @return the user uuid of this user preference
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreference.getUserUuid();
	}

	/**
	* Sets the user uuid of this user preference.
	*
	* @param userUuid the user uuid of this user preference
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userPreference.setUserUuid(userUuid);
	}

	/**
	* Returns the lang code of this user preference.
	*
	* @return the lang code of this user preference
	*/
	@Override
	public java.lang.String getLangCode() {
		return _userPreference.getLangCode();
	}

	/**
	* Sets the lang code of this user preference.
	*
	* @param langCode the lang code of this user preference
	*/
	@Override
	public void setLangCode(java.lang.String langCode) {
		_userPreference.setLangCode(langCode);
	}

	/**
	* Returns the pdf lang code of this user preference.
	*
	* @return the pdf lang code of this user preference
	*/
	@Override
	public java.lang.String getPdfLangCode() {
		return _userPreference.getPdfLangCode();
	}

	/**
	* Sets the pdf lang code of this user preference.
	*
	* @param pdfLangCode the pdf lang code of this user preference
	*/
	@Override
	public void setPdfLangCode(java.lang.String pdfLangCode) {
		_userPreference.setPdfLangCode(pdfLangCode);
	}

	/**
	* Returns the build type of this user preference.
	*
	* @return the build type of this user preference
	*/
	@Override
	public java.lang.String getBuildType() {
		return _userPreference.getBuildType();
	}

	/**
	* Sets the build type of this user preference.
	*
	* @param buildType the build type of this user preference
	*/
	@Override
	public void setBuildType(java.lang.String buildType) {
		_userPreference.setBuildType(buildType);
	}

	/**
	* Returns the chain code of this user preference.
	*
	* @return the chain code of this user preference
	*/
	@Override
	public java.lang.String getChainCode() {
		return _userPreference.getChainCode();
	}

	/**
	* Sets the chain code of this user preference.
	*
	* @param chainCode the chain code of this user preference
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_userPreference.setChainCode(chainCode);
	}

	/**
	* Returns the report type of this user preference.
	*
	* @return the report type of this user preference
	*/
	@Override
	public java.lang.String getReportType() {
		return _userPreference.getReportType();
	}

	/**
	* Sets the report type of this user preference.
	*
	* @param reportType the report type of this user preference
	*/
	@Override
	public void setReportType(java.lang.String reportType) {
		_userPreference.setReportType(reportType);
	}

	/**
	* Returns the paper size of this user preference.
	*
	* @return the paper size of this user preference
	*/
	@Override
	public java.lang.String getPaperSize() {
		return _userPreference.getPaperSize();
	}

	/**
	* Sets the paper size of this user preference.
	*
	* @param paperSize the paper size of this user preference
	*/
	@Override
	public void setPaperSize(java.lang.String paperSize) {
		_userPreference.setPaperSize(paperSize);
	}

	/**
	* Returns the items per page of this user preference.
	*
	* @return the items per page of this user preference
	*/
	@Override
	public java.lang.String getItemsPerPage() {
		return _userPreference.getItemsPerPage();
	}

	/**
	* Sets the items per page of this user preference.
	*
	* @param itemsPerPage the items per page of this user preference
	*/
	@Override
	public void setItemsPerPage(java.lang.String itemsPerPage) {
		_userPreference.setItemsPerPage(itemsPerPage);
	}

	/**
	* Returns the info display of this user preference.
	*
	* @return the info display of this user preference
	*/
	@Override
	public java.lang.String getInfoDisplay() {
		return _userPreference.getInfoDisplay();
	}

	/**
	* Sets the info display of this user preference.
	*
	* @param infoDisplay the info display of this user preference
	*/
	@Override
	public void setInfoDisplay(java.lang.String infoDisplay) {
		_userPreference.setInfoDisplay(infoDisplay);
	}

	/**
	* Returns the country code of this user preference.
	*
	* @return the country code of this user preference
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _userPreference.getCountryCode();
	}

	/**
	* Sets the country code of this user preference.
	*
	* @param CountryCode the country code of this user preference
	*/
	@Override
	public void setCountryCode(java.lang.String CountryCode) {
		_userPreference.setCountryCode(CountryCode);
	}

	/**
	* Returns the unsubscribe email of this user preference.
	*
	* @return the unsubscribe email of this user preference
	*/
	@Override
	public java.lang.String getUnsubscribeEmail() {
		return _userPreference.getUnsubscribeEmail();
	}

	/**
	* Sets the unsubscribe email of this user preference.
	*
	* @param unsubscribeEmail the unsubscribe email of this user preference
	*/
	@Override
	public void setUnsubscribeEmail(java.lang.String unsubscribeEmail) {
		_userPreference.setUnsubscribeEmail(unsubscribeEmail);
	}

	/**
	* Returns the module name of this user preference.
	*
	* @return the module name of this user preference
	*/
	@Override
	public java.lang.String getModuleName() {
		return _userPreference.getModuleName();
	}

	/**
	* Sets the module name of this user preference.
	*
	* @param moduleName the module name of this user preference
	*/
	@Override
	public void setModuleName(java.lang.String moduleName) {
		_userPreference.setModuleName(moduleName);
	}

	/**
	* Returns the creator ID of this user preference.
	*
	* @return the creator ID of this user preference
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _userPreference.getCreatorId();
	}

	/**
	* Sets the creator ID of this user preference.
	*
	* @param creatorId the creator ID of this user preference
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_userPreference.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this user preference.
	*
	* @return the created date of this user preference
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _userPreference.getCreatedDate();
	}

	/**
	* Sets the created date of this user preference.
	*
	* @param createdDate the created date of this user preference
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_userPreference.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this user preference.
	*
	* @return the updated by of this user preference
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _userPreference.getUpdatedBy();
	}

	/**
	* Sets the updated by of this user preference.
	*
	* @param updatedBy the updated by of this user preference
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_userPreference.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this user preference.
	*
	* @return the updated date of this user preference
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _userPreference.getUpdatedDate();
	}

	/**
	* Sets the updated date of this user preference.
	*
	* @param updatedDate the updated date of this user preference
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_userPreference.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _userPreference.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userPreference.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userPreference.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userPreference.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userPreference.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userPreference.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userPreference.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userPreference.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userPreference.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userPreference.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userPreference.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserPreferenceWrapper((UserPreference)_userPreference.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.UserPreference userPreference) {
		return _userPreference.compareTo(userPreference);
	}

	@Override
	public int hashCode() {
		return _userPreference.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.UserPreference> toCacheModel() {
		return _userPreference.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.UserPreference toEscapedModel() {
		return new UserPreferenceWrapper(_userPreference.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.UserPreference toUnescapedModel() {
		return new UserPreferenceWrapper(_userPreference.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userPreference.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userPreference.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userPreference.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserPreferenceWrapper)) {
			return false;
		}

		UserPreferenceWrapper userPreferenceWrapper = (UserPreferenceWrapper)obj;

		if (Validator.equals(_userPreference,
					userPreferenceWrapper._userPreference)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserPreference getWrappedUserPreference() {
		return _userPreference;
	}

	@Override
	public UserPreference getWrappedModel() {
		return _userPreference;
	}

	@Override
	public void resetOriginalValues() {
		_userPreference.resetOriginalValues();
	}

	private UserPreference _userPreference;
}