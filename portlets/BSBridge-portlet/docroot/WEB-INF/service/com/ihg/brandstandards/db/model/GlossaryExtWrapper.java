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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GlossaryExt}.
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryExt
 * @generated
 */
public class GlossaryExtWrapper implements GlossaryExt,
	ModelWrapper<GlossaryExt> {
	public GlossaryExtWrapper(GlossaryExt glossaryExt) {
		_glossaryExt = glossaryExt;
	}

	@Override
	public Class<?> getModelClass() {
		return GlossaryExt.class;
	}

	@Override
	public String getModelClassName() {
		return GlossaryExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("glossaryId", getGlossaryId());
		attributes.put("activeInd", getActiveInd());
		attributes.put("glossaryTermText", getGlossaryTermText());
		attributes.put("glossaryTermDesc", getGlossaryTermDesc());
		attributes.put("glossaryRegions", getGlossaryRegions());
		attributes.put("glossaryChains", getGlossaryChains());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long glossaryId = (Long)attributes.get("glossaryId");

		if (glossaryId != null) {
			setGlossaryId(glossaryId);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		String glossaryTermText = (String)attributes.get("glossaryTermText");

		if (glossaryTermText != null) {
			setGlossaryTermText(glossaryTermText);
		}

		String glossaryTermDesc = (String)attributes.get("glossaryTermDesc");

		if (glossaryTermDesc != null) {
			setGlossaryTermDesc(glossaryTermDesc);
		}

		String glossaryRegions = (String)attributes.get("glossaryRegions");

		if (glossaryRegions != null) {
			setGlossaryRegions(glossaryRegions);
		}

		String glossaryChains = (String)attributes.get("glossaryChains");

		if (glossaryChains != null) {
			setGlossaryChains(glossaryChains);
		}
	}

	/**
	* Returns the primary key of this glossary ext.
	*
	* @return the primary key of this glossary ext
	*/
	@Override
	public long getPrimaryKey() {
		return _glossaryExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this glossary ext.
	*
	* @param primaryKey the primary key of this glossary ext
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_glossaryExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the glossary ID of this glossary ext.
	*
	* @return the glossary ID of this glossary ext
	*/
	@Override
	public long getGlossaryId() {
		return _glossaryExt.getGlossaryId();
	}

	/**
	* Sets the glossary ID of this glossary ext.
	*
	* @param glossaryId the glossary ID of this glossary ext
	*/
	@Override
	public void setGlossaryId(long glossaryId) {
		_glossaryExt.setGlossaryId(glossaryId);
	}

	/**
	* Returns the active ind of this glossary ext.
	*
	* @return the active ind of this glossary ext
	*/
	@Override
	public java.lang.String getActiveInd() {
		return _glossaryExt.getActiveInd();
	}

	/**
	* Sets the active ind of this glossary ext.
	*
	* @param activeInd the active ind of this glossary ext
	*/
	@Override
	public void setActiveInd(java.lang.String activeInd) {
		_glossaryExt.setActiveInd(activeInd);
	}

	/**
	* Returns the glossary term text of this glossary ext.
	*
	* @return the glossary term text of this glossary ext
	*/
	@Override
	public java.lang.String getGlossaryTermText() {
		return _glossaryExt.getGlossaryTermText();
	}

	/**
	* Sets the glossary term text of this glossary ext.
	*
	* @param glossaryTermText the glossary term text of this glossary ext
	*/
	@Override
	public void setGlossaryTermText(java.lang.String glossaryTermText) {
		_glossaryExt.setGlossaryTermText(glossaryTermText);
	}

	/**
	* Returns the glossary term desc of this glossary ext.
	*
	* @return the glossary term desc of this glossary ext
	*/
	@Override
	public java.lang.String getGlossaryTermDesc() {
		return _glossaryExt.getGlossaryTermDesc();
	}

	/**
	* Sets the glossary term desc of this glossary ext.
	*
	* @param glossaryTermDesc the glossary term desc of this glossary ext
	*/
	@Override
	public void setGlossaryTermDesc(java.lang.String glossaryTermDesc) {
		_glossaryExt.setGlossaryTermDesc(glossaryTermDesc);
	}

	/**
	* Returns the glossary regions of this glossary ext.
	*
	* @return the glossary regions of this glossary ext
	*/
	@Override
	public java.lang.String getGlossaryRegions() {
		return _glossaryExt.getGlossaryRegions();
	}

	/**
	* Sets the glossary regions of this glossary ext.
	*
	* @param glossaryRegions the glossary regions of this glossary ext
	*/
	@Override
	public void setGlossaryRegions(java.lang.String glossaryRegions) {
		_glossaryExt.setGlossaryRegions(glossaryRegions);
	}

	/**
	* Returns the glossary chains of this glossary ext.
	*
	* @return the glossary chains of this glossary ext
	*/
	@Override
	public java.lang.String getGlossaryChains() {
		return _glossaryExt.getGlossaryChains();
	}

	/**
	* Sets the glossary chains of this glossary ext.
	*
	* @param glossaryChains the glossary chains of this glossary ext
	*/
	@Override
	public void setGlossaryChains(java.lang.String glossaryChains) {
		_glossaryExt.setGlossaryChains(glossaryChains);
	}

	@Override
	public boolean isNew() {
		return _glossaryExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_glossaryExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _glossaryExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_glossaryExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _glossaryExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _glossaryExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_glossaryExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _glossaryExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_glossaryExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_glossaryExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_glossaryExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GlossaryExtWrapper((GlossaryExt)_glossaryExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GlossaryExt glossaryExt) {
		return _glossaryExt.compareTo(glossaryExt);
	}

	@Override
	public int hashCode() {
		return _glossaryExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GlossaryExt> toCacheModel() {
		return _glossaryExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt toEscapedModel() {
		return new GlossaryExtWrapper(_glossaryExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GlossaryExt toUnescapedModel() {
		return new GlossaryExtWrapper(_glossaryExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _glossaryExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _glossaryExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_glossaryExt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GlossaryExtWrapper)) {
			return false;
		}

		GlossaryExtWrapper glossaryExtWrapper = (GlossaryExtWrapper)obj;

		if (Validator.equals(_glossaryExt, glossaryExtWrapper._glossaryExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GlossaryExt getWrappedGlossaryExt() {
		return _glossaryExt;
	}

	@Override
	public GlossaryExt getWrappedModel() {
		return _glossaryExt;
	}

	@Override
	public void resetOriginalValues() {
		_glossaryExt.resetOriginalValues();
	}

	private GlossaryExt _glossaryExt;
}