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

import com.ihg.brandstandards.db.model.GEMChainMeasurement;
import com.ihg.brandstandards.db.service.GEMChainMeasurementLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the GEMChainMeasurement service. Represents a row in the &quot;GEM_CHAIN_MSRMNT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GEMChainMeasurementImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMChainMeasurementImpl
 * @see com.ihg.brandstandards.db.model.GEMChainMeasurement
 * @generated
 */
public abstract class GEMChainMeasurementBaseImpl
	extends GEMChainMeasurementModelImpl implements GEMChainMeasurement {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a g e m chain measurement model instance should use the {@link GEMChainMeasurement} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			GEMChainMeasurementLocalServiceUtil.addGEMChainMeasurement(this);
		}
		else {
			GEMChainMeasurementLocalServiceUtil.updateGEMChainMeasurement(this);
		}
	}
}