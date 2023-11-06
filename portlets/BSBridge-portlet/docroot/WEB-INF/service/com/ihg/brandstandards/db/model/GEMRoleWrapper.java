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
 * This class is a wrapper for {@link GEMRole}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMRole
 * @generated
 */
public class GEMRoleWrapper implements GEMRole, ModelWrapper<GEMRole> {
	public GEMRoleWrapper(GEMRole gemRole) {
		_gemRole = gemRole;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMRole.class;
	}

	@Override
	public String getModelClassName() {
		return GEMRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gemGrpId", getGemGrpId());
		attributes.put("regionId", getRegionId());
		attributes.put("chainCode", getChainCode());
		attributes.put("gemGrpCode", getGemGrpCode());
		attributes.put("ownerGrpId", getOwnerGrpId());
		attributes.put("ownerGrpName", getOwnerGrpName());
		attributes.put("busOwnerName", getBusOwnerName());
		attributes.put("deligate1Name", getDeligate1Name());
		attributes.put("deligate2Name", getDeligate2Name());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gemGrpId = (Long)attributes.get("gemGrpId");

		if (gemGrpId != null) {
			setGemGrpId(gemGrpId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String gemGrpCode = (String)attributes.get("gemGrpCode");

		if (gemGrpCode != null) {
			setGemGrpCode(gemGrpCode);
		}

		String ownerGrpId = (String)attributes.get("ownerGrpId");

		if (ownerGrpId != null) {
			setOwnerGrpId(ownerGrpId);
		}

		String ownerGrpName = (String)attributes.get("ownerGrpName");

		if (ownerGrpName != null) {
			setOwnerGrpName(ownerGrpName);
		}

		String busOwnerName = (String)attributes.get("busOwnerName");

		if (busOwnerName != null) {
			setBusOwnerName(busOwnerName);
		}

		String deligate1Name = (String)attributes.get("deligate1Name");

		if (deligate1Name != null) {
			setDeligate1Name(deligate1Name);
		}

		String deligate2Name = (String)attributes.get("deligate2Name");

		if (deligate2Name != null) {
			setDeligate2Name(deligate2Name);
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
	* Returns the primary key of this g e m role.
	*
	* @return the primary key of this g e m role
	*/
	@Override
	public long getPrimaryKey() {
		return _gemRole.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m role.
	*
	* @param primaryKey the primary key of this g e m role
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemRole.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the gem grp ID of this g e m role.
	*
	* @return the gem grp ID of this g e m role
	*/
	@Override
	public long getGemGrpId() {
		return _gemRole.getGemGrpId();
	}

	/**
	* Sets the gem grp ID of this g e m role.
	*
	* @param gemGrpId the gem grp ID of this g e m role
	*/
	@Override
	public void setGemGrpId(long gemGrpId) {
		_gemRole.setGemGrpId(gemGrpId);
	}

	/**
	* Returns the region ID of this g e m role.
	*
	* @return the region ID of this g e m role
	*/
	@Override
	public long getRegionId() {
		return _gemRole.getRegionId();
	}

	/**
	* Sets the region ID of this g e m role.
	*
	* @param regionId the region ID of this g e m role
	*/
	@Override
	public void setRegionId(long regionId) {
		_gemRole.setRegionId(regionId);
	}

	/**
	* Returns the chain code of this g e m role.
	*
	* @return the chain code of this g e m role
	*/
	@Override
	public java.lang.String getChainCode() {
		return _gemRole.getChainCode();
	}

	/**
	* Sets the chain code of this g e m role.
	*
	* @param chainCode the chain code of this g e m role
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_gemRole.setChainCode(chainCode);
	}

	/**
	* Returns the gem grp code of this g e m role.
	*
	* @return the gem grp code of this g e m role
	*/
	@Override
	public java.lang.String getGemGrpCode() {
		return _gemRole.getGemGrpCode();
	}

	/**
	* Sets the gem grp code of this g e m role.
	*
	* @param gemGrpCode the gem grp code of this g e m role
	*/
	@Override
	public void setGemGrpCode(java.lang.String gemGrpCode) {
		_gemRole.setGemGrpCode(gemGrpCode);
	}

	/**
	* Returns the owner grp ID of this g e m role.
	*
	* @return the owner grp ID of this g e m role
	*/
	@Override
	public java.lang.String getOwnerGrpId() {
		return _gemRole.getOwnerGrpId();
	}

	/**
	* Sets the owner grp ID of this g e m role.
	*
	* @param ownerGrpId the owner grp ID of this g e m role
	*/
	@Override
	public void setOwnerGrpId(java.lang.String ownerGrpId) {
		_gemRole.setOwnerGrpId(ownerGrpId);
	}

	/**
	* Returns the owner grp name of this g e m role.
	*
	* @return the owner grp name of this g e m role
	*/
	@Override
	public java.lang.String getOwnerGrpName() {
		return _gemRole.getOwnerGrpName();
	}

	/**
	* Sets the owner grp name of this g e m role.
	*
	* @param ownerGrpName the owner grp name of this g e m role
	*/
	@Override
	public void setOwnerGrpName(java.lang.String ownerGrpName) {
		_gemRole.setOwnerGrpName(ownerGrpName);
	}

	/**
	* Returns the bus owner name of this g e m role.
	*
	* @return the bus owner name of this g e m role
	*/
	@Override
	public java.lang.String getBusOwnerName() {
		return _gemRole.getBusOwnerName();
	}

	/**
	* Sets the bus owner name of this g e m role.
	*
	* @param busOwnerName the bus owner name of this g e m role
	*/
	@Override
	public void setBusOwnerName(java.lang.String busOwnerName) {
		_gemRole.setBusOwnerName(busOwnerName);
	}

	/**
	* Returns the deligate1 name of this g e m role.
	*
	* @return the deligate1 name of this g e m role
	*/
	@Override
	public java.lang.String getDeligate1Name() {
		return _gemRole.getDeligate1Name();
	}

	/**
	* Sets the deligate1 name of this g e m role.
	*
	* @param deligate1Name the deligate1 name of this g e m role
	*/
	@Override
	public void setDeligate1Name(java.lang.String deligate1Name) {
		_gemRole.setDeligate1Name(deligate1Name);
	}

	/**
	* Returns the deligate2 name of this g e m role.
	*
	* @return the deligate2 name of this g e m role
	*/
	@Override
	public java.lang.String getDeligate2Name() {
		return _gemRole.getDeligate2Name();
	}

	/**
	* Sets the deligate2 name of this g e m role.
	*
	* @param deligate2Name the deligate2 name of this g e m role
	*/
	@Override
	public void setDeligate2Name(java.lang.String deligate2Name) {
		_gemRole.setDeligate2Name(deligate2Name);
	}

	/**
	* Returns the creator ID of this g e m role.
	*
	* @return the creator ID of this g e m role
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemRole.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m role.
	*
	* @param creatorId the creator ID of this g e m role
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemRole.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m role.
	*
	* @return the created date of this g e m role
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemRole.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m role.
	*
	* @param createdDate the created date of this g e m role
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemRole.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m role.
	*
	* @return the updated by of this g e m role
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemRole.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m role.
	*
	* @param updatedBy the updated by of this g e m role
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemRole.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m role.
	*
	* @return the updated date of this g e m role
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemRole.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m role.
	*
	* @param updatedDate the updated date of this g e m role
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemRole.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemRole.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemRole.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemRole.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemRole.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemRole.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemRole.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemRole.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemRole.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemRole.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMRoleWrapper((GEMRole)_gemRole.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.GEMRole gemRole) {
		return _gemRole.compareTo(gemRole);
	}

	@Override
	public int hashCode() {
		return _gemRole.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMRole> toCacheModel() {
		return _gemRole.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMRole toEscapedModel() {
		return new GEMRoleWrapper(_gemRole.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMRole toUnescapedModel() {
		return new GEMRoleWrapper(_gemRole.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemRole.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemRole.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMRoleWrapper)) {
			return false;
		}

		GEMRoleWrapper gemRoleWrapper = (GEMRoleWrapper)obj;

		if (Validator.equals(_gemRole, gemRoleWrapper._gemRole)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMRole getWrappedGEMRole() {
		return _gemRole;
	}

	@Override
	public GEMRole getWrappedModel() {
		return _gemRole;
	}

	@Override
	public void resetOriginalValues() {
		_gemRole.resetOriginalValues();
	}

	private GEMRole _gemRole;
}