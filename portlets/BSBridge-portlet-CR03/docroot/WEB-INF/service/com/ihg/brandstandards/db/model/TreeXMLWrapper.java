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
 * This class is a wrapper for {@link TreeXML}.
 * </p>
 *
 * @author Mummanedi
 * @see TreeXML
 * @generated
 */
public class TreeXMLWrapper implements TreeXML, ModelWrapper<TreeXML> {
	public TreeXMLWrapper(TreeXML treeXML) {
		_treeXML = treeXML;
	}

	@Override
	public Class<?> getModelClass() {
		return TreeXML.class;
	}

	@Override
	public String getModelClassName() {
		return TreeXML.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ID", getID());
		attributes.put("XMLLOB", getXMLLOB());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ID = (Long)attributes.get("ID");

		if (ID != null) {
			setID(ID);
		}

		String XMLLOB = (String)attributes.get("XMLLOB");

		if (XMLLOB != null) {
			setXMLLOB(XMLLOB);
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
	* Returns the primary key of this tree x m l.
	*
	* @return the primary key of this tree x m l
	*/
	@Override
	public long getPrimaryKey() {
		return _treeXML.getPrimaryKey();
	}

	/**
	* Sets the primary key of this tree x m l.
	*
	* @param primaryKey the primary key of this tree x m l
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_treeXML.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the i d of this tree x m l.
	*
	* @return the i d of this tree x m l
	*/
	@Override
	public long getID() {
		return _treeXML.getID();
	}

	/**
	* Sets the i d of this tree x m l.
	*
	* @param ID the i d of this tree x m l
	*/
	@Override
	public void setID(long ID) {
		_treeXML.setID(ID);
	}

	/**
	* Returns the x m l l o b of this tree x m l.
	*
	* @return the x m l l o b of this tree x m l
	*/
	@Override
	public java.lang.String getXMLLOB() {
		return _treeXML.getXMLLOB();
	}

	/**
	* Sets the x m l l o b of this tree x m l.
	*
	* @param XMLLOB the x m l l o b of this tree x m l
	*/
	@Override
	public void setXMLLOB(java.lang.String XMLLOB) {
		_treeXML.setXMLLOB(XMLLOB);
	}

	/**
	* Returns the creator ID of this tree x m l.
	*
	* @return the creator ID of this tree x m l
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _treeXML.getCreatorId();
	}

	/**
	* Sets the creator ID of this tree x m l.
	*
	* @param creatorId the creator ID of this tree x m l
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_treeXML.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this tree x m l.
	*
	* @return the created date of this tree x m l
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _treeXML.getCreatedDate();
	}

	/**
	* Sets the created date of this tree x m l.
	*
	* @param createdDate the created date of this tree x m l
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_treeXML.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this tree x m l.
	*
	* @return the updated by of this tree x m l
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _treeXML.getUpdatedBy();
	}

	/**
	* Sets the updated by of this tree x m l.
	*
	* @param updatedBy the updated by of this tree x m l
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_treeXML.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this tree x m l.
	*
	* @return the updated date of this tree x m l
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _treeXML.getUpdatedDate();
	}

	/**
	* Sets the updated date of this tree x m l.
	*
	* @param updatedDate the updated date of this tree x m l
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_treeXML.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _treeXML.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_treeXML.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _treeXML.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_treeXML.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _treeXML.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _treeXML.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_treeXML.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _treeXML.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_treeXML.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_treeXML.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_treeXML.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TreeXMLWrapper((TreeXML)_treeXML.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.TreeXML treeXML) {
		return _treeXML.compareTo(treeXML);
	}

	@Override
	public int hashCode() {
		return _treeXML.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.TreeXML> toCacheModel() {
		return _treeXML.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.TreeXML toEscapedModel() {
		return new TreeXMLWrapper(_treeXML.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.TreeXML toUnescapedModel() {
		return new TreeXMLWrapper(_treeXML.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _treeXML.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _treeXML.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_treeXML.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TreeXMLWrapper)) {
			return false;
		}

		TreeXMLWrapper treeXMLWrapper = (TreeXMLWrapper)obj;

		if (Validator.equals(_treeXML, treeXMLWrapper._treeXML)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TreeXML getWrappedTreeXML() {
		return _treeXML;
	}

	@Override
	public TreeXML getWrappedModel() {
		return _treeXML;
	}

	@Override
	public void resetOriginalValues() {
		_treeXML.resetOriginalValues();
	}

	private TreeXML _treeXML;
}