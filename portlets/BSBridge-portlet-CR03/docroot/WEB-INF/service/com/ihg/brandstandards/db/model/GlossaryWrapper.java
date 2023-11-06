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
 * This class is a wrapper for {@link Glossary}.
 * </p>
 *
 * @author Mummanedi
 * @see Glossary
 * @generated
 */
public class GlossaryWrapper implements Glossary, ModelWrapper<Glossary> {
	public GlossaryWrapper(Glossary glossary) {
		_glossary = glossary;
	}

	@Override
	public Class<?> getModelClass() {
		return Glossary.class;
	}

	@Override
	public String getModelClassName() {
		return Glossary.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryId", getGlossaryId());
		attributes.put("glossaryTermText", getGlossaryTermText());
		attributes.put("glossaryTermDesc", getGlossaryTermDesc());
		attributes.put("activeInd", getActiveInd());
		attributes.put("glossaryOwner", getGlossaryOwner());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String glossaryTermText = (String)attributes.get("glossaryTermText");

		if (glossaryTermText != null) {
			setGlossaryTermText(glossaryTermText);
		}

		String glossaryTermDesc = (String)attributes.get("glossaryTermDesc");

		if (glossaryTermDesc != null) {
			setGlossaryTermDesc(glossaryTermDesc);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		Long glossaryOwner = (Long)attributes.get("glossaryOwner");

		if (glossaryOwner != null) {
			setGlossaryOwner(glossaryOwner);
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
	* Returns the primary key of this glossary.
	*
	* @return the primary key of this glossary
	*/
	@Override
	public long getPrimaryKey() {
		return _glossary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this glossary.
	*
	* @param primaryKey the primary key of this glossary
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_glossary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the glossary ID of this glossary.
	*
	* @return the glossary ID of this glossary
	*/
	@Override
	public long getGlossaryId() {
		return _glossary.getGlossaryId();
	}

	/**
	* Sets the glossary ID of this glossary.
	*
	* @param glossaryId the glossary ID of this glossary
	*/
	@Override
	public void setGlossaryId(long glossaryId) {
		_glossary.setGlossaryId(glossaryId);
	}

	/**
	* Returns the glossary term text of this glossary.
	*
	* @return the glossary term text of this glossary
	*/
	@Override
	public java.lang.String getGlossaryTermText() {
		return _glossary.getGlossaryTermText();
	}

	/**
	* Sets the glossary term text of this glossary.
	*
	* @param glossaryTermText the glossary term text of this glossary
	*/
	@Override
	public void setGlossaryTermText(java.lang.String glossaryTermText) {
		_glossary.setGlossaryTermText(glossaryTermText);
	}

	/**
	* Returns the glossary term desc of this glossary.
	*
	* @return the glossary term desc of this glossary
	*/
	@Override
	public java.lang.String getGlossaryTermDesc() {
		return _glossary.getGlossaryTermDesc();
	}

	/**
	* Sets the glossary term desc of this glossary.
	*
	* @param glossaryTermDesc the glossary term desc of this glossary
	*/
	@Override
	public void setGlossaryTermDesc(java.lang.String glossaryTermDesc) {
		_glossary.setGlossaryTermDesc(glossaryTermDesc);
	}

	/**
	* Returns the active ind of this glossary.
	*
	* @return the active ind of this glossary
	*/
	@Override
	public java.lang.String getActiveInd() {
		return _glossary.getActiveInd();
	}

	/**
	* Sets the active ind of this glossary.
	*
	* @param activeInd the active ind of this glossary
	*/
	@Override
	public void setActiveInd(java.lang.String activeInd) {
		_glossary.setActiveInd(activeInd);
	}

	/**
	* Returns the glossary owner of this glossary.
	*
	* @return the glossary owner of this glossary
	*/
	@Override
	public long getGlossaryOwner() {
		return _glossary.getGlossaryOwner();
	}

	/**
	* Sets the glossary owner of this glossary.
	*
	* @param glossaryOwner the glossary owner of this glossary
	*/
	@Override
	public void setGlossaryOwner(long glossaryOwner) {
		_glossary.setGlossaryOwner(glossaryOwner);
	}

	/**
	* Returns the creator ID of this glossary.
	*
	* @return the creator ID of this glossary
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _glossary.getCreatorId();
	}

	/**
	* Sets the creator ID of this glossary.
	*
	* @param creatorId the creator ID of this glossary
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_glossary.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this glossary.
	*
	* @return the created date of this glossary
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _glossary.getCreatedDate();
	}

	/**
	* Sets the created date of this glossary.
	*
	* @param createdDate the created date of this glossary
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_glossary.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this glossary.
	*
	* @return the updated by of this glossary
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _glossary.getUpdatedBy();
	}

	/**
	* Sets the updated by of this glossary.
	*
	* @param updatedBy the updated by of this glossary
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_glossary.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this glossary.
	*
	* @return the updated date of this glossary
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _glossary.getUpdatedDate();
	}

	/**
	* Sets the updated date of this glossary.
	*
	* @param updatedDate the updated date of this glossary
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_glossary.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _glossary.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_glossary.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _glossary.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_glossary.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _glossary.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _glossary.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_glossary.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _glossary.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_glossary.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_glossary.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_glossary.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GlossaryWrapper((Glossary)_glossary.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.Glossary glossary) {
		return _glossary.compareTo(glossary);
	}

	@Override
	public int hashCode() {
		return _glossary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.Glossary> toCacheModel() {
		return _glossary.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.Glossary toEscapedModel() {
		return new GlossaryWrapper(_glossary.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.Glossary toUnescapedModel() {
		return new GlossaryWrapper(_glossary.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _glossary.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _glossary.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_glossary.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GlossaryWrapper)) {
			return false;
		}

		GlossaryWrapper glossaryWrapper = (GlossaryWrapper)obj;

		if (Validator.equals(_glossary, glossaryWrapper._glossary)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Glossary getWrappedGlossary() {
		return _glossary;
	}

	@Override
	public Glossary getWrappedModel() {
		return _glossary;
	}

	@Override
	public void resetOriginalValues() {
		_glossary.resetOriginalValues();
	}

	private Glossary _glossary;
}