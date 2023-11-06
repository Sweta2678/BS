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
 * The extended model interface for the ExternalLinkStandards service. Represents a row in the &quot;STD_EXTL_LINK&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsModel
 * @see com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsImpl
 * @see com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsModelImpl
 * @generated
 */
public interface ExternalLinkStandards extends ExternalLinkStandardsModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public java.lang.String getRealUrl();

	public java.lang.String getRealTitle();

	/**
	* @return the isLinkTranslationExist
	*/
	public boolean isLinkTranslationExist();

	/**
	* @param isLinkTranslationExist the isLinkTranslationExist to set
	*/
	public void setLinkTranslationExist(boolean isLinkTranslationExist);
}