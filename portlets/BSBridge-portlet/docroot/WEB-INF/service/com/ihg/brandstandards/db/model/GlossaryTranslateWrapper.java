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
 * This class is a wrapper for {@link GlossaryTranslate}.
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryTranslate
 * @generated
 */
public class GlossaryTranslateWrapper implements GlossaryTranslate,
	ModelWrapper<GlossaryTranslate> {
	public GlossaryTranslateWrapper(GlossaryTranslate glossaryTranslate) {
		_glossaryTranslate = glossaryTranslate;
	}

	@Override
	public Class<?> getModelClass() {
		return GlossaryTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return GlossaryTranslate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryXlatId", getGlossaryXlatId());
		attributes.put("glossaryId", getGlossaryId());
		attributes.put("langCode", getLangCode());
		attributes.put("glossaryTermText", getGlossaryTermText());
		attributes.put("glossaryTermDesc", getGlossaryTermDesc());
		attributes.put("isValidTermTxt", getIsValidTermTxt());
		attributes.put("isValidDescTxt", getIsValidDescTxt());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryXlatId = (Long)attributes.get("glossaryXlatId");

		if (glossaryXlatId != null) {
			setGlossaryXlatId(glossaryXlatId);
		}

		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String langCode = (String)attributes.get("langCode");

		if (langCode != null) {
			setLangCode(langCode);
		}

		String glossaryTermText = (String)attributes.get("glossaryTermText");

		if (glossaryTermText != null) {
			setGlossaryTermText(glossaryTermText);
		}

		String glossaryTermDesc = (String)attributes.get("glossaryTermDesc");

		if (glossaryTermDesc != null) {
			setGlossaryTermDesc(glossaryTermDesc);
		}

		String isValidTermTxt = (String)attributes.get("isValidTermTxt");

		if (isValidTermTxt != null) {
			setIsValidTermTxt(isValidTermTxt);
		}

		String isValidDescTxt = (String)attributes.get("isValidDescTxt");

		if (isValidDescTxt != null) {
			setIsValidDescTxt(isValidDescTxt);
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
	* Returns the primary key of this glossary translate.
	*
	* @return the primary key of this glossary translate
	*/
	@Override
	public long getPrimaryKey() {
		return _glossaryTranslate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this glossary translate.
	*
	* @param primaryKey the primary key of this glossary translate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_glossaryTranslate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the glossary xlat ID of this glossary translate.
	*
	* @return the glossary xlat ID of this glossary translate
	*/
	@Override
	public long getGlossaryXlatId() {
		return _glossaryTranslate.getGlossaryXlatId();
	}

	/**
	* Sets the glossary xlat ID of this glossary translate.
	*
	* @param glossaryXlatId the glossary xlat ID of this glossary translate
	*/
	@Override
	public void setGlossaryXlatId(long glossaryXlatId) {
		_glossaryTranslate.setGlossaryXlatId(glossaryXlatId);
	}

	/**
	* Returns the glossary ID of this glossary translate.
	*
	* @return the glossary ID of this glossary translate
	*/
	@Override
	public long getGlossaryId() {
		return _glossaryTranslate.getGlossaryId();
	}

	/**
	* Sets the glossary ID of this glossary translate.
	*
	* @param glossaryId the glossary ID of this glossary translate
	*/
	@Override
	public void setGlossaryId(long glossaryId) {
		_glossaryTranslate.setGlossaryId(glossaryId);
	}

	/**
	* Returns the lang code of this glossary translate.
	*
	* @return the lang code of this glossary translate
	*/
	@Override
	public java.lang.String getLangCode() {
		return _glossaryTranslate.getLangCode();
	}

	/**
	* Sets the lang code of this glossary translate.
	*
	* @param langCode the lang code of this glossary translate
	*/
	@Override
	public void setLangCode(java.lang.String langCode) {
		_glossaryTranslate.setLangCode(langCode);
	}

	/**
	* Returns the glossary term text of this glossary translate.
	*
	* @return the glossary term text of this glossary translate
	*/
	@Override
	public java.lang.String getGlossaryTermText() {
		return _glossaryTranslate.getGlossaryTermText();
	}

	/**
	* Sets the glossary term text of this glossary translate.
	*
	* @param glossaryTermText the glossary term text of this glossary translate
	*/
	@Override
	public void setGlossaryTermText(java.lang.String glossaryTermText) {
		_glossaryTranslate.setGlossaryTermText(glossaryTermText);
	}

	/**
	* Returns the glossary term desc of this glossary translate.
	*
	* @return the glossary term desc of this glossary translate
	*/
	@Override
	public java.lang.String getGlossaryTermDesc() {
		return _glossaryTranslate.getGlossaryTermDesc();
	}

	/**
	* Sets the glossary term desc of this glossary translate.
	*
	* @param glossaryTermDesc the glossary term desc of this glossary translate
	*/
	@Override
	public void setGlossaryTermDesc(java.lang.String glossaryTermDesc) {
		_glossaryTranslate.setGlossaryTermDesc(glossaryTermDesc);
	}

	/**
	* Returns the is valid term txt of this glossary translate.
	*
	* @return the is valid term txt of this glossary translate
	*/
	@Override
	public java.lang.String getIsValidTermTxt() {
		return _glossaryTranslate.getIsValidTermTxt();
	}

	/**
	* Sets the is valid term txt of this glossary translate.
	*
	* @param isValidTermTxt the is valid term txt of this glossary translate
	*/
	@Override
	public void setIsValidTermTxt(java.lang.String isValidTermTxt) {
		_glossaryTranslate.setIsValidTermTxt(isValidTermTxt);
	}

	/**
	* Returns the is valid desc txt of this glossary translate.
	*
	* @return the is valid desc txt of this glossary translate
	*/
	@Override
	public java.lang.String getIsValidDescTxt() {
		return _glossaryTranslate.getIsValidDescTxt();
	}

	/**
	* Sets the is valid desc txt of this glossary translate.
	*
	* @param isValidDescTxt the is valid desc txt of this glossary translate
	*/
	@Override
	public void setIsValidDescTxt(java.lang.String isValidDescTxt) {
		_glossaryTranslate.setIsValidDescTxt(isValidDescTxt);
	}

	/**
	* Returns the creator ID of this glossary translate.
	*
	* @return the creator ID of this glossary translate
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _glossaryTranslate.getCreatorId();
	}

	/**
	* Sets the creator ID of this glossary translate.
	*
	* @param creatorId the creator ID of this glossary translate
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_glossaryTranslate.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this glossary translate.
	*
	* @return the created date of this glossary translate
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _glossaryTranslate.getCreatedDate();
	}

	/**
	* Sets the created date of this glossary translate.
	*
	* @param createdDate the created date of this glossary translate
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_glossaryTranslate.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this glossary translate.
	*
	* @return the updated by of this glossary translate
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _glossaryTranslate.getUpdatedBy();
	}

	/**
	* Sets the updated by of this glossary translate.
	*
	* @param updatedBy the updated by of this glossary translate
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_glossaryTranslate.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this glossary translate.
	*
	* @return the updated date of this glossary translate
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _glossaryTranslate.getUpdatedDate();
	}

	/**
	* Sets the updated date of this glossary translate.
	*
	* @param updatedDate the updated date of this glossary translate
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_glossaryTranslate.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _glossaryTranslate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_glossaryTranslate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _glossaryTranslate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_glossaryTranslate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _glossaryTranslate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _glossaryTranslate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_glossaryTranslate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _glossaryTranslate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_glossaryTranslate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_glossaryTranslate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_glossaryTranslate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GlossaryTranslateWrapper((GlossaryTranslate)_glossaryTranslate.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate) {
		return _glossaryTranslate.compareTo(glossaryTranslate);
	}

	@Override
	public int hashCode() {
		return _glossaryTranslate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GlossaryTranslate> toCacheModel() {
		return _glossaryTranslate.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate toEscapedModel() {
		return new GlossaryTranslateWrapper(_glossaryTranslate.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryTranslate toUnescapedModel() {
		return new GlossaryTranslateWrapper(_glossaryTranslate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _glossaryTranslate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _glossaryTranslate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_glossaryTranslate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GlossaryTranslateWrapper)) {
			return false;
		}

		GlossaryTranslateWrapper glossaryTranslateWrapper = (GlossaryTranslateWrapper)obj;

		if (Validator.equals(_glossaryTranslate,
					glossaryTranslateWrapper._glossaryTranslate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GlossaryTranslate getWrappedGlossaryTranslate() {
		return _glossaryTranslate;
	}

	@Override
	public GlossaryTranslate getWrappedModel() {
		return _glossaryTranslate;
	}

	@Override
	public void resetOriginalValues() {
		_glossaryTranslate.resetOriginalValues();
	}

	private GlossaryTranslate _glossaryTranslate;
}