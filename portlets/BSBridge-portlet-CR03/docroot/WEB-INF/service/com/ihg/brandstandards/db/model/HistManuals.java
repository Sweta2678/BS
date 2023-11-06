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
 * The extended model interface for the HistManuals service. Represents a row in the &quot;HIST_MNL&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mummanedi
 * @see HistManualsModel
 * @see com.ihg.brandstandards.db.model.impl.HistManualsImpl
 * @see com.ihg.brandstandards.db.model.impl.HistManualsModelImpl
 * @generated
 */
public interface HistManuals extends HistManualsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ihg.brandstandards.db.model.impl.HistManualsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getChain();

	public void setChain(java.lang.String chain);

	public java.lang.String getRegion();

	public void setRegion(java.lang.String region);
}