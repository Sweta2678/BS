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
 * This class is a wrapper for {@link StandardsHistoricalManual}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsHistoricalManual
 * @generated
 */
public class StandardsHistoricalManualWrapper
	implements StandardsHistoricalManual,
		ModelWrapper<StandardsHistoricalManual> {
	public StandardsHistoricalManualWrapper(
		StandardsHistoricalManual standardsHistoricalManual) {
		_standardsHistoricalManual = standardsHistoricalManual;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsHistoricalManual.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsHistoricalManual.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdMnlId", getStdMnlId());
		attributes.put("stdId", getStdId());
		attributes.put("histManualId", getHistManualId());
		attributes.put("change", getChange());
		attributes.put("title", getTitle());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdMnlId = (Long)attributes.get("stdMnlId");

		if (stdMnlId != null) {
			setStdMnlId(stdMnlId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long histManualId = (Long)attributes.get("histManualId");

		if (histManualId != null) {
			setHistManualId(histManualId);
		}

		String change = (String)attributes.get("change");

		if (change != null) {
			setChange(change);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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
	* Returns the primary key of this standards historical manual.
	*
	* @return the primary key of this standards historical manual
	*/
	@Override
	public long getPrimaryKey() {
		return _standardsHistoricalManual.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards historical manual.
	*
	* @param primaryKey the primary key of this standards historical manual
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_standardsHistoricalManual.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std mnl ID of this standards historical manual.
	*
	* @return the std mnl ID of this standards historical manual
	*/
	@Override
	public long getStdMnlId() {
		return _standardsHistoricalManual.getStdMnlId();
	}

	/**
	* Sets the std mnl ID of this standards historical manual.
	*
	* @param stdMnlId the std mnl ID of this standards historical manual
	*/
	@Override
	public void setStdMnlId(long stdMnlId) {
		_standardsHistoricalManual.setStdMnlId(stdMnlId);
	}

	/**
	* Returns the std ID of this standards historical manual.
	*
	* @return the std ID of this standards historical manual
	*/
	@Override
	public long getStdId() {
		return _standardsHistoricalManual.getStdId();
	}

	/**
	* Sets the std ID of this standards historical manual.
	*
	* @param stdId the std ID of this standards historical manual
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsHistoricalManual.setStdId(stdId);
	}

	/**
	* Returns the hist manual ID of this standards historical manual.
	*
	* @return the hist manual ID of this standards historical manual
	*/
	@Override
	public long getHistManualId() {
		return _standardsHistoricalManual.getHistManualId();
	}

	/**
	* Sets the hist manual ID of this standards historical manual.
	*
	* @param histManualId the hist manual ID of this standards historical manual
	*/
	@Override
	public void setHistManualId(long histManualId) {
		_standardsHistoricalManual.setHistManualId(histManualId);
	}

	/**
	* Returns the change of this standards historical manual.
	*
	* @return the change of this standards historical manual
	*/
	@Override
	public java.lang.String getChange() {
		return _standardsHistoricalManual.getChange();
	}

	/**
	* Sets the change of this standards historical manual.
	*
	* @param change the change of this standards historical manual
	*/
	@Override
	public void setChange(java.lang.String change) {
		_standardsHistoricalManual.setChange(change);
	}

	/**
	* Returns the title of this standards historical manual.
	*
	* @return the title of this standards historical manual
	*/
	@Override
	public java.lang.String getTitle() {
		return _standardsHistoricalManual.getTitle();
	}

	/**
	* Sets the title of this standards historical manual.
	*
	* @param title the title of this standards historical manual
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_standardsHistoricalManual.setTitle(title);
	}

	/**
	* Returns the creator ID of this standards historical manual.
	*
	* @return the creator ID of this standards historical manual
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsHistoricalManual.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards historical manual.
	*
	* @param creatorId the creator ID of this standards historical manual
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsHistoricalManual.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards historical manual.
	*
	* @return the created date of this standards historical manual
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsHistoricalManual.getCreatedDate();
	}

	/**
	* Sets the created date of this standards historical manual.
	*
	* @param createdDate the created date of this standards historical manual
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsHistoricalManual.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards historical manual.
	*
	* @return the updated by of this standards historical manual
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsHistoricalManual.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards historical manual.
	*
	* @param updatedBy the updated by of this standards historical manual
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsHistoricalManual.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards historical manual.
	*
	* @return the updated date of this standards historical manual
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsHistoricalManual.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards historical manual.
	*
	* @param updatedDate the updated date of this standards historical manual
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsHistoricalManual.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsHistoricalManual.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsHistoricalManual.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsHistoricalManual.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsHistoricalManual.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsHistoricalManual.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsHistoricalManual.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsHistoricalManual.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsHistoricalManual.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsHistoricalManual.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsHistoricalManual.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsHistoricalManual.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsHistoricalManualWrapper((StandardsHistoricalManual)_standardsHistoricalManual.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsHistoricalManual standardsHistoricalManual) {
		return _standardsHistoricalManual.compareTo(standardsHistoricalManual);
	}

	@Override
	public int hashCode() {
		return _standardsHistoricalManual.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsHistoricalManual> toCacheModel() {
		return _standardsHistoricalManual.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsHistoricalManual toEscapedModel() {
		return new StandardsHistoricalManualWrapper(_standardsHistoricalManual.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsHistoricalManual toUnescapedModel() {
		return new StandardsHistoricalManualWrapper(_standardsHistoricalManual.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsHistoricalManual.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsHistoricalManual.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsHistoricalManual.persist();
	}

	@Override
	public java.lang.String getChain() {
		return _standardsHistoricalManual.getChain();
	}

	@Override
	public void setChain(java.lang.String chain) {
		_standardsHistoricalManual.setChain(chain);
	}

	@Override
	public java.lang.String getRegion() {
		return _standardsHistoricalManual.getRegion();
	}

	@Override
	public void setRegion(java.lang.String region) {
		_standardsHistoricalManual.setRegion(region);
	}

	@Override
	public java.lang.String getHistManualType() {
		return _standardsHistoricalManual.getHistManualType();
	}

	@Override
	public void setHistManualType(java.lang.String histManualType) {
		_standardsHistoricalManual.setHistManualType(histManualType);
	}

	@Override
	public java.lang.String getHistManualTitle() {
		return _standardsHistoricalManual.getHistManualTitle();
	}

	@Override
	public void setHistManualTitle(java.lang.String histManualTitle) {
		_standardsHistoricalManual.setHistManualTitle(histManualTitle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsHistoricalManualWrapper)) {
			return false;
		}

		StandardsHistoricalManualWrapper standardsHistoricalManualWrapper = (StandardsHistoricalManualWrapper)obj;

		if (Validator.equals(_standardsHistoricalManual,
					standardsHistoricalManualWrapper._standardsHistoricalManual)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsHistoricalManual getWrappedStandardsHistoricalManual() {
		return _standardsHistoricalManual;
	}

	@Override
	public StandardsHistoricalManual getWrappedModel() {
		return _standardsHistoricalManual;
	}

	@Override
	public void resetOriginalValues() {
		_standardsHistoricalManual.resetOriginalValues();
	}

	private StandardsHistoricalManual _standardsHistoricalManual;
}