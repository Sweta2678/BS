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

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the StandardsExt service. Represents a row in the &quot;STD&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mummanedi
 * @see StandardsExtModel
 * @see com.ihg.brandstandards.db.model.impl.StandardsExtImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsExtModelImpl
 * @generated
 */
public interface StandardsExt extends StandardsExtModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ihg.brandstandards.db.model.impl.StandardsExtImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Get Audit status. For example Audit.
	*
	* @return the auditStatus
	*/
	public java.lang.String getAuditStatus();

	/**
	* Set Audit status.
	*
	* @param auditStatus the auditStatus to set
	*/
	public void setAuditStatus(java.lang.String auditStatus);

	/**
	* Getter for index order.
	*
	* @return the indexOrder
	*/
	public long getIndexOrder();

	/**
	* Setter for index order.
	*
	* @param indexOrder the indexOrder to set
	*/
	public void setIndexOrder(long indexOrder);

	/**
	* Getter for stdManualBuild.
	*
	* @return the stdManualBuild
	*/
	public java.lang.String getStdManualBuild();

	/**
	* Setter for stdManualBuild.
	*
	* @param stdManualBuild the stdManualBuild to set
	*/
	public void setStdManualBuild(java.lang.String stdManualBuild);

	/**
	* Getter for stdManualOperate.
	*
	* @return the stdManualOperate
	*/
	public java.lang.String getStdManualOperate();

	/**
	* Setter for stdManualOperate.
	*
	* @param stdManualOperate the stdManualOperate to set
	*/
	public void setStdManualOperate(java.lang.String stdManualOperate);

	/**
	* Getter for country change status map.
	*
	* @return the countryChngStat
	*/
	public java.util.Map<java.lang.String, java.lang.String> getCountryChngStat();

	/**
	* Setter for country change status map.
	*
	* @param countryChngStat the countryChngStat to set
	*/
	public void setCountryChngStat(
		java.util.Map<java.lang.String, java.lang.String> countryChngStat);

	public java.util.List<java.lang.Long> getFlags();

	public void setFlags(java.util.List<java.lang.Long> flags);
}