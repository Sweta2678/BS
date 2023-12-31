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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.GlossaryRegionNav;
import com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the GlossaryRegionNav service. Represents a row in the &quot;GLOSSARY_RGN_NAV&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GlossaryRegionNavImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryRegionNavImpl
 * @see com.ihg.brandstandards.db.model.GlossaryRegionNav
 * @generated
 */
public abstract class GlossaryRegionNavBaseImpl
	extends GlossaryRegionNavModelImpl implements GlossaryRegionNav {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a glossary region nav model instance should use the {@link GlossaryRegionNav} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GlossaryRegionNavLocalServiceUtil.addGlossaryRegionNav(this);
		}
		else {
			GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(this);
		}
	}
}