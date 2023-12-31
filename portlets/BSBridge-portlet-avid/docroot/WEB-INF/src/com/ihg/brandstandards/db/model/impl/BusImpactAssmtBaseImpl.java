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

import com.ihg.brandstandards.db.model.BusImpactAssmt;
import com.ihg.brandstandards.db.service.BusImpactAssmtLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the BusImpactAssmt service. Represents a row in the &quot;BUS_IMPACT_ASSMT_MNL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BusImpactAssmtImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BusImpactAssmtImpl
 * @see com.ihg.brandstandards.db.model.BusImpactAssmt
 * @generated
 */
public abstract class BusImpactAssmtBaseImpl extends BusImpactAssmtModelImpl
	implements BusImpactAssmt {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a bus impact assmt model instance should use the {@link BusImpactAssmt} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusImpactAssmtLocalServiceUtil.addBusImpactAssmt(this);
		}
		else {
			BusImpactAssmtLocalServiceUtil.updateBusImpactAssmt(this);
		}
	}
}