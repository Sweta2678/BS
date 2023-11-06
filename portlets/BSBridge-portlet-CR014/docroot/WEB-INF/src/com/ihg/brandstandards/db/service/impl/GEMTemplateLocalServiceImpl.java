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

import java.util.List;

import com.ihg.brandstandards.db.NoSuchGEMTemplateException;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.service.base.GEMTemplateLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the g e m template local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GEMTemplateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GEMTemplateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil
 */
public class GEMTemplateLocalServiceImpl extends GEMTemplateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil} to access the g e m template local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(GEMTemplateLocalServiceImpl.class);
	
	public void clearCache(){
		try {
			gemTemplatePersistence.clearCache();
		} catch (Exception e) {
		}
	}

	/**
	 * 
	 * @param templateType
	 * @param regionId
	 * @param publishId
	 * @return
	 * @throws NoSuchGEMTemplateException
	 * @throws SystemException
	 */
	public GEMTemplate getByTypeAndRegionAndPublication (String templateType, long regionId, long publishId) throws NoSuchGEMTemplateException, SystemException {
		return gemTemplatePersistence.findByTypeAndRegionAndPublication(templateType, regionId, publishId);
	}
	
	public List<GEMTemplate> getByTypeAndRegionAndPublicationList(String templateType, long regionId, long publishId) throws SystemException {
		return gemTemplatePersistence.findByTypeAndRegionAndPublicationList(templateType, regionId, publishId);
	}
	
	/**
	 * @param publishId This is a publish department id
	 */
	public List<GEMTemplate> getByPublishId(long publishId) throws SystemException{
		return gemTemplatePersistence.findByPublishId(publishId);
	}
	
	public List<GEMTemplate> getByPublishIdAndRgnId(long publishId, long regionId) throws SystemException{
		return gemTemplatePersistence.findByPublishIdAndRgnId(publishId, regionId);
	}
	
	public List<GEMTemplate> getByPublishIdAndRgnIdAndType(long publishId, long regionId, String templateType) throws SystemException {
		return gemTemplatePersistence.findByPublishIdAndRgnIdAndType(publishId, regionId, templateType);
	}
	
	public List<GEMTemplate> getByPublishIdAndTemplateType(long publishId, String templateType) throws SystemException {
		return gemTemplatePersistence.findByPublishIdAndTemplateType(publishId, templateType);
	}
	
	public List<GEMTemplate> getByTemplateType(String templateType) throws SystemException {
		return gemTemplatePersistence.findByTemplateType(templateType);
	}
	
	/**
	 * @param templateId
	 * Delete data from template, columns and values table.
	 */
	public void deleteTemplateConfigurations (long templateId) throws SystemException {
		
		gemTemplateFinder.deleteTemplateConfigurations(templateId);
		try{
			gemGeneratedReportValPersistence.clearCache();
			gemGeneratedReportPersistence.clearCache();
			gemTemplateValuesPersistence.clearCache();
			gemTemplateColumnPersistence.clearCache();
			gemCategoryPersistence.clearCache();
			gemTemplatePersistence.clearCache();
		} catch(Exception e){
			LOG.error(e);
		}
	}
	
	/**
	 * 
	 * @param sequenceNumber
	 * @return primaryKey
	 */
	public long getSequenceNumber (String sequenceNumber) {
		return gemTemplateFinder.getSequenceNumber(sequenceNumber);
	}
	
	/**
	 * 
	 * @param columnId
	 * @param columnValue
	 * @param categoryId
	 * @param orderNumber
	 * @param createUserId
	 * @return boolean
	 * @throws SystemException
	 */
    public boolean insertTemplateValueUsingSequence (long columnId, String columnValue, long categoryId, long orderNumber, String createUserId) throws SystemException {
    	return gemTemplateFinder.insertTemplateValueUsingSequence(columnId, columnValue, categoryId, orderNumber, createUserId);
    }

}