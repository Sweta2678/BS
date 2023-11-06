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

package com.ihg.grs.common.model;

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
 * @author gulam.vora
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
		attributes.put("term", getTerm());
		attributes.put("description", getDescription());
		attributes.put("activeIndicator", getActiveIndicator());
		attributes.put("createUserId", getCreateUserId());
		attributes.put("createdate", getCreatedate());
		attributes.put("lastUpdateUserId", getLastUpdateUserId());
		attributes.put("updatedate", getUpdatedate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer glossaryId = (Integer)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String term = (String)attributes.get("term");

		if (term != null) {
			setTerm(term);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String activeIndicator = (String)attributes.get("activeIndicator");

		if (activeIndicator != null) {
			setActiveIndicator(activeIndicator);
		}

		String createUserId = (String)attributes.get("createUserId");

		if (createUserId != null) {
			setCreateUserId(createUserId);
		}

		Date createdate = (Date)attributes.get("createdate");

		if (createdate != null) {
			setCreatedate(createdate);
		}

		String lastUpdateUserId = (String)attributes.get("lastUpdateUserId");

		if (lastUpdateUserId != null) {
			setLastUpdateUserId(lastUpdateUserId);
		}

		Date updatedate = (Date)attributes.get("updatedate");

		if (updatedate != null) {
			setUpdatedate(updatedate);
		}
	}

	/**
	* Returns the primary key of this glossary.
	*
	* @return the primary key of this glossary
	*/
	@Override
	public int getPrimaryKey() {
		return _glossary.getPrimaryKey();
	}

	/**
	* Sets the primary key of this glossary.
	*
	* @param primaryKey the primary key of this glossary
	*/
	@Override
	public void setPrimaryKey(int primaryKey) {
		_glossary.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the glossary ID of this glossary.
	*
	* @return the glossary ID of this glossary
	*/
	@Override
	public int getGlossaryId() {
		return _glossary.getGlossaryId();
	}

	/**
	* Sets the glossary ID of this glossary.
	*
	* @param glossaryId the glossary ID of this glossary
	*/
	@Override
	public void setGlossaryId(int glossaryId) {
		_glossary.setGlossaryId(glossaryId);
	}

	/**
	* Returns the term of this glossary.
	*
	* @return the term of this glossary
	*/
	@Override
	public java.lang.String getTerm() {
		return _glossary.getTerm();
	}

	/**
	* Sets the term of this glossary.
	*
	* @param term the term of this glossary
	*/
	@Override
	public void setTerm(java.lang.String term) {
		_glossary.setTerm(term);
	}

	/**
	* Returns the description of this glossary.
	*
	* @return the description of this glossary
	*/
	@Override
	public java.lang.String getDescription() {
		return _glossary.getDescription();
	}

	/**
	* Sets the description of this glossary.
	*
	* @param description the description of this glossary
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_glossary.setDescription(description);
	}

	/**
	* Returns the active indicator of this glossary.
	*
	* @return the active indicator of this glossary
	*/
	@Override
	public java.lang.String getActiveIndicator() {
		return _glossary.getActiveIndicator();
	}

	/**
	* Sets the active indicator of this glossary.
	*
	* @param activeIndicator the active indicator of this glossary
	*/
	@Override
	public void setActiveIndicator(java.lang.String activeIndicator) {
		_glossary.setActiveIndicator(activeIndicator);
	}

	/**
	* Returns the create user ID of this glossary.
	*
	* @return the create user ID of this glossary
	*/
	@Override
	public java.lang.String getCreateUserId() {
		return _glossary.getCreateUserId();
	}

	/**
	* Sets the create user ID of this glossary.
	*
	* @param createUserId the create user ID of this glossary
	*/
	@Override
	public void setCreateUserId(java.lang.String createUserId) {
		_glossary.setCreateUserId(createUserId);
	}

	/**
	* Returns the createdate of this glossary.
	*
	* @return the createdate of this glossary
	*/
	@Override
	public java.util.Date getCreatedate() {
		return _glossary.getCreatedate();
	}

	/**
	* Sets the createdate of this glossary.
	*
	* @param createdate the createdate of this glossary
	*/
	@Override
	public void setCreatedate(java.util.Date createdate) {
		_glossary.setCreatedate(createdate);
	}

	/**
	* Returns the last update user ID of this glossary.
	*
	* @return the last update user ID of this glossary
	*/
	@Override
	public java.lang.String getLastUpdateUserId() {
		return _glossary.getLastUpdateUserId();
	}

	/**
	* Sets the last update user ID of this glossary.
	*
	* @param lastUpdateUserId the last update user ID of this glossary
	*/
	@Override
	public void setLastUpdateUserId(java.lang.String lastUpdateUserId) {
		_glossary.setLastUpdateUserId(lastUpdateUserId);
	}

	/**
	* Returns the updatedate of this glossary.
	*
	* @return the updatedate of this glossary
	*/
	@Override
	public java.util.Date getUpdatedate() {
		return _glossary.getUpdatedate();
	}

	/**
	* Sets the updatedate of this glossary.
	*
	* @param updatedate the updatedate of this glossary
	*/
	@Override
	public void setUpdatedate(java.util.Date updatedate) {
		_glossary.setUpdatedate(updatedate);
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
	public int compareTo(com.ihg.grs.common.model.Glossary glossary) {
		return _glossary.compareTo(glossary);
	}

	@Override
	public int hashCode() {
		return _glossary.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.grs.common.model.Glossary> toCacheModel() {
		return _glossary.toCacheModel();
	}

	@Override
	public com.ihg.grs.common.model.Glossary toEscapedModel() {
		return new GlossaryWrapper(_glossary.toEscapedModel());
	}

	@Override
	public com.ihg.grs.common.model.Glossary toUnescapedModel() {
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