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

package com.ihg.brandstandards.db.service.impl;

import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.NoSuchGEMMeasurementException;
import com.ihg.brandstandards.db.model.GEMMeasurement;
import com.ihg.brandstandards.db.service.base.GEMMeasurementLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the g e m measurement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GEMMeasurementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GEMMeasurementLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GEMMeasurementLocalServiceUtil
 */
public class GEMMeasurementLocalServiceImpl
	extends GEMMeasurementLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GEMMeasurementLocalServiceUtil} to access the g e m measurement local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(GEMMeasurementLocalServiceImpl.class);
	
	public void clearCache(){
		try {
			gemMeasurementPersistence.clearCache();
		} catch (Exception e) {
		}
	}
	
	public GEMMeasurement getByNameTypeAndTemplateId(String measurementName, String measurementType, long templateId) throws NoSuchGEMMeasurementException, SystemException {
		return gemMeasurementPersistence.findByNameTypeAndTemplateId(measurementName, measurementType, templateId);
	}
	
	public List<GEMMeasurement> getByTemplateId(long templateId) throws SystemException {
		return gemMeasurementPersistence.findByTemplateId(templateId);
	}
	
	public List<GEMMeasurement> getByTemplateIdAndType(long templateId, String measurementType) throws SystemException {
		return gemMeasurementPersistence.findByTemplateIdAndType(templateId, measurementType);
	}
	
	public GEMMeasurement addGEMMeasurement(String measurementName, String measurementType, long templateId, String creatorId, long dispOrderNo){
		GEMMeasurement gemMeasurement = null;
		try {
			gemMeasurement = gemMeasurementPersistence.create(gemTemplateFinder.getSequenceNumber("GEM_MSRMNT_ID_SEQ"));
			gemMeasurement.setMeasurementName(measurementName);
			gemMeasurement.setMeasurementType(measurementType);
			gemMeasurement.setDisplayOrderNumber(dispOrderNo);
			gemMeasurement.setTemplateId(templateId);
			gemMeasurement.setMultiplierQty(1);
			
			gemMeasurement.setCreatorId(creatorId);
			gemMeasurement.setCreatedDate(new Date());
			gemMeasurement.setUpdatedBy(creatorId);
			gemMeasurement.setUpdatedDate(new Date());
			gemMeasurement = gemMeasurementPersistence.update(gemMeasurement);
		} catch(Exception e){
			LOG.error("Failed to add Measurement category", e);
		}
		
		return gemMeasurement;
	}
}