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
 * The extended model interface for the Standards service. Represents a row in the &quot;STD&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mummanedi
 * @see StandardsModel
 * @see com.ihg.brandstandards.db.model.impl.StandardsImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsModelImpl
 * @generated
 */
public interface Standards extends StandardsModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ihg.brandstandards.db.model.impl.StandardsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* @return the isTextTransExist
	*/
	public boolean isTextTransExist();

	/**
	* @param isTextTransExist the isTextTransExist to set
	*/
	public void setTextTransExist(boolean isTextTransExist);

	/**
	* @return the isContextTransExist
	*/
	public boolean isContextTransExist();

	/**
	* @param isContextTransExist the isContextTransExist to set
	*/
	public void setContextTransExist(boolean isContextTransExist);

	/**
	* @param isSearchMatches the isSearchMatches to set
	*/
	public boolean isSearchMatches();

	public void setSearchMatches(boolean isSearchMatches);
}