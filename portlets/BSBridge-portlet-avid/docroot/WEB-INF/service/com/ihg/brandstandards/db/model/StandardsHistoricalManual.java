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
 * The extended model interface for the StandardsHistoricalManual service. Represents a row in the &quot;STD_MNL&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mummanedi
 * @see StandardsHistoricalManualModel
 * @see com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl
 * @generated
 */
public interface StandardsHistoricalManual
	extends StandardsHistoricalManualModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getChain();

	public void setChain(java.lang.String chain);

	public java.lang.String getRegion();

	public void setRegion(java.lang.String region);

	public java.lang.String getHistManualType();

	public void setHistManualType(java.lang.String histManualType);

	public java.lang.String getHistManualTitle();

	public void setHistManualTitle(java.lang.String histManualTitle);
}