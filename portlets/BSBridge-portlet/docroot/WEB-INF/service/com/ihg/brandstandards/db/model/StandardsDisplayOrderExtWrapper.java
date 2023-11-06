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
 * This class is a wrapper for {@link StandardsDisplayOrderExt}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderExt
 * @generated
 */
public class StandardsDisplayOrderExtWrapper implements StandardsDisplayOrderExt,
	ModelWrapper<StandardsDisplayOrderExt> {
	public StandardsDisplayOrderExtWrapper(
		StandardsDisplayOrderExt standardsDisplayOrderExt) {
		_standardsDisplayOrderExt = standardsDisplayOrderExt;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsDisplayOrderExt.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsDisplayOrderExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("title", getTitle());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("framework", getFramework());
		attributes.put("chainCode", getChainCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("displayOrder", getDisplayOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}
	}

	/**
	* Returns the primary key of this standards display order ext.
	*
	* @return the primary key of this standards display order ext
	*/
	@Override
	public long getPrimaryKey() {
		return _standardsDisplayOrderExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards display order ext.
	*
	* @param primaryKey the primary key of this standards display order ext
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_standardsDisplayOrderExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this standards display order ext.
	*
	* @return the std ID of this standards display order ext
	*/
	@Override
	public long getStdId() {
		return _standardsDisplayOrderExt.getStdId();
	}

	/**
	* Sets the std ID of this standards display order ext.
	*
	* @param stdId the std ID of this standards display order ext
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsDisplayOrderExt.setStdId(stdId);
	}

	/**
	* Returns the title of this standards display order ext.
	*
	* @return the title of this standards display order ext
	*/
	@Override
	public java.lang.String getTitle() {
		return _standardsDisplayOrderExt.getTitle();
	}

	/**
	* Sets the title of this standards display order ext.
	*
	* @param title the title of this standards display order ext
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_standardsDisplayOrderExt.setTitle(title);
	}

	/**
	* Returns the is global of this standards display order ext.
	*
	* @return the is global of this standards display order ext
	*/
	@Override
	public java.lang.String getIsGlobal() {
		return _standardsDisplayOrderExt.getIsGlobal();
	}

	/**
	* Sets the is global of this standards display order ext.
	*
	* @param isGlobal the is global of this standards display order ext
	*/
	@Override
	public void setIsGlobal(java.lang.String isGlobal) {
		_standardsDisplayOrderExt.setIsGlobal(isGlobal);
	}

	/**
	* Returns the framework of this standards display order ext.
	*
	* @return the framework of this standards display order ext
	*/
	@Override
	public java.lang.String getFramework() {
		return _standardsDisplayOrderExt.getFramework();
	}

	/**
	* Sets the framework of this standards display order ext.
	*
	* @param framework the framework of this standards display order ext
	*/
	@Override
	public void setFramework(java.lang.String framework) {
		_standardsDisplayOrderExt.setFramework(framework);
	}

	/**
	* Returns the chain code of this standards display order ext.
	*
	* @return the chain code of this standards display order ext
	*/
	@Override
	public java.lang.String getChainCode() {
		return _standardsDisplayOrderExt.getChainCode();
	}

	/**
	* Sets the chain code of this standards display order ext.
	*
	* @param chainCode the chain code of this standards display order ext
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_standardsDisplayOrderExt.setChainCode(chainCode);
	}

	/**
	* Returns the region code of this standards display order ext.
	*
	* @return the region code of this standards display order ext
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _standardsDisplayOrderExt.getRegionCode();
	}

	/**
	* Sets the region code of this standards display order ext.
	*
	* @param regionCode the region code of this standards display order ext
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_standardsDisplayOrderExt.setRegionCode(regionCode);
	}

	/**
	* Returns the display order of this standards display order ext.
	*
	* @return the display order of this standards display order ext
	*/
	@Override
	public long getDisplayOrder() {
		return _standardsDisplayOrderExt.getDisplayOrder();
	}

	/**
	* Sets the display order of this standards display order ext.
	*
	* @param displayOrder the display order of this standards display order ext
	*/
	@Override
	public void setDisplayOrder(long displayOrder) {
		_standardsDisplayOrderExt.setDisplayOrder(displayOrder);
	}

	@Override
	public boolean isNew() {
		return _standardsDisplayOrderExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsDisplayOrderExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsDisplayOrderExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsDisplayOrderExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsDisplayOrderExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsDisplayOrderExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsDisplayOrderExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsDisplayOrderExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsDisplayOrderExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsDisplayOrderExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsDisplayOrderExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsDisplayOrderExtWrapper((StandardsDisplayOrderExt)_standardsDisplayOrderExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsDisplayOrderExt standardsDisplayOrderExt) {
		return _standardsDisplayOrderExt.compareTo(standardsDisplayOrderExt);
	}

	@Override
	public int hashCode() {
		return _standardsDisplayOrderExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsDisplayOrderExt> toCacheModel() {
		return _standardsDisplayOrderExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrderExt toEscapedModel() {
		return new StandardsDisplayOrderExtWrapper(_standardsDisplayOrderExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsDisplayOrderExt toUnescapedModel() {
		return new StandardsDisplayOrderExtWrapper(_standardsDisplayOrderExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsDisplayOrderExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsDisplayOrderExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsDisplayOrderExt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsDisplayOrderExtWrapper)) {
			return false;
		}

		StandardsDisplayOrderExtWrapper standardsDisplayOrderExtWrapper = (StandardsDisplayOrderExtWrapper)obj;

		if (Validator.equals(_standardsDisplayOrderExt,
					standardsDisplayOrderExtWrapper._standardsDisplayOrderExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsDisplayOrderExt getWrappedStandardsDisplayOrderExt() {
		return _standardsDisplayOrderExt;
	}

	@Override
	public StandardsDisplayOrderExt getWrappedModel() {
		return _standardsDisplayOrderExt;
	}

	@Override
	public void resetOriginalValues() {
		_standardsDisplayOrderExt.resetOriginalValues();
	}

	private StandardsDisplayOrderExt _standardsDisplayOrderExt;
}