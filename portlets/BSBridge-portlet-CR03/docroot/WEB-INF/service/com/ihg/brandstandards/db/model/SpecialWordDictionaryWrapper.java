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
 * This class is a wrapper for {@link SpecialWordDictionary}.
 * </p>
 *
 * @author Mummanedi
 * @see SpecialWordDictionary
 * @generated
 */
public class SpecialWordDictionaryWrapper implements SpecialWordDictionary,
	ModelWrapper<SpecialWordDictionary> {
	public SpecialWordDictionaryWrapper(
		SpecialWordDictionary specialWordDictionary) {
		_specialWordDictionary = specialWordDictionary;
	}

	@Override
	public Class<?> getModelClass() {
		return SpecialWordDictionary.class;
	}

	@Override
	public String getModelClassName() {
		return SpecialWordDictionary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("specialWordId", getSpecialWordId());
		attributes.put("replacedWordTxt", getReplacedWordTxt());
		attributes.put("replacementWordTxt", getReplacementWordTxt());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long specialWordId = (Long)attributes.get("specialWordId");

		if (specialWordId != null) {
			setSpecialWordId(specialWordId);
		}

		String replacedWordTxt = (String)attributes.get("replacedWordTxt");

		if (replacedWordTxt != null) {
			setReplacedWordTxt(replacedWordTxt);
		}

		String replacementWordTxt = (String)attributes.get("replacementWordTxt");

		if (replacementWordTxt != null) {
			setReplacementWordTxt(replacementWordTxt);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
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
	* Returns the primary key of this special word dictionary.
	*
	* @return the primary key of this special word dictionary
	*/
	@Override
	public long getPrimaryKey() {
		return _specialWordDictionary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this special word dictionary.
	*
	* @param primaryKey the primary key of this special word dictionary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_specialWordDictionary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the special word ID of this special word dictionary.
	*
	* @return the special word ID of this special word dictionary
	*/
	@Override
	public long getSpecialWordId() {
		return _specialWordDictionary.getSpecialWordId();
	}

	/**
	* Sets the special word ID of this special word dictionary.
	*
	* @param specialWordId the special word ID of this special word dictionary
	*/
	@Override
	public void setSpecialWordId(long specialWordId) {
		_specialWordDictionary.setSpecialWordId(specialWordId);
	}

	/**
	* Returns the replaced word txt of this special word dictionary.
	*
	* @return the replaced word txt of this special word dictionary
	*/
	@Override
	public java.lang.String getReplacedWordTxt() {
		return _specialWordDictionary.getReplacedWordTxt();
	}

	/**
	* Sets the replaced word txt of this special word dictionary.
	*
	* @param replacedWordTxt the replaced word txt of this special word dictionary
	*/
	@Override
	public void setReplacedWordTxt(java.lang.String replacedWordTxt) {
		_specialWordDictionary.setReplacedWordTxt(replacedWordTxt);
	}

	/**
	* Returns the replacement word txt of this special word dictionary.
	*
	* @return the replacement word txt of this special word dictionary
	*/
	@Override
	public java.lang.String getReplacementWordTxt() {
		return _specialWordDictionary.getReplacementWordTxt();
	}

	/**
	* Sets the replacement word txt of this special word dictionary.
	*
	* @param replacementWordTxt the replacement word txt of this special word dictionary
	*/
	@Override
	public void setReplacementWordTxt(java.lang.String replacementWordTxt) {
		_specialWordDictionary.setReplacementWordTxt(replacementWordTxt);
	}

	/**
	* Returns the locale code of this special word dictionary.
	*
	* @return the locale code of this special word dictionary
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _specialWordDictionary.getLocaleCode();
	}

	/**
	* Sets the locale code of this special word dictionary.
	*
	* @param localeCode the locale code of this special word dictionary
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_specialWordDictionary.setLocaleCode(localeCode);
	}

	/**
	* Returns the creator ID of this special word dictionary.
	*
	* @return the creator ID of this special word dictionary
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _specialWordDictionary.getCreatorId();
	}

	/**
	* Sets the creator ID of this special word dictionary.
	*
	* @param creatorId the creator ID of this special word dictionary
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_specialWordDictionary.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this special word dictionary.
	*
	* @return the created date of this special word dictionary
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _specialWordDictionary.getCreatedDate();
	}

	/**
	* Sets the created date of this special word dictionary.
	*
	* @param createdDate the created date of this special word dictionary
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_specialWordDictionary.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this special word dictionary.
	*
	* @return the updated by of this special word dictionary
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _specialWordDictionary.getUpdatedBy();
	}

	/**
	* Sets the updated by of this special word dictionary.
	*
	* @param updatedBy the updated by of this special word dictionary
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_specialWordDictionary.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this special word dictionary.
	*
	* @return the updated date of this special word dictionary
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _specialWordDictionary.getUpdatedDate();
	}

	/**
	* Sets the updated date of this special word dictionary.
	*
	* @param updatedDate the updated date of this special word dictionary
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_specialWordDictionary.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _specialWordDictionary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_specialWordDictionary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _specialWordDictionary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_specialWordDictionary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _specialWordDictionary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _specialWordDictionary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_specialWordDictionary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _specialWordDictionary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_specialWordDictionary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_specialWordDictionary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_specialWordDictionary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SpecialWordDictionaryWrapper((SpecialWordDictionary)_specialWordDictionary.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.SpecialWordDictionary specialWordDictionary) {
		return _specialWordDictionary.compareTo(specialWordDictionary);
	}

	@Override
	public int hashCode() {
		return _specialWordDictionary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.SpecialWordDictionary> toCacheModel() {
		return _specialWordDictionary.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary toEscapedModel() {
		return new SpecialWordDictionaryWrapper(_specialWordDictionary.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.SpecialWordDictionary toUnescapedModel() {
		return new SpecialWordDictionaryWrapper(_specialWordDictionary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _specialWordDictionary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _specialWordDictionary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_specialWordDictionary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpecialWordDictionaryWrapper)) {
			return false;
		}

		SpecialWordDictionaryWrapper specialWordDictionaryWrapper = (SpecialWordDictionaryWrapper)obj;

		if (Validator.equals(_specialWordDictionary,
					specialWordDictionaryWrapper._specialWordDictionary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SpecialWordDictionary getWrappedSpecialWordDictionary() {
		return _specialWordDictionary;
	}

	@Override
	public SpecialWordDictionary getWrappedModel() {
		return _specialWordDictionary;
	}

	@Override
	public void resetOriginalValues() {
		_specialWordDictionary.resetOriginalValues();
	}

	private SpecialWordDictionary _specialWordDictionary;
}