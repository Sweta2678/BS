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

import com.ihg.brandstandards.db.NoSuchGEMStdCategoryException;
import com.ihg.brandstandards.db.model.GEMStdCategory;
import com.ihg.brandstandards.db.service.base.GEMStdCategoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the g e m std category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GEMStdCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GEMStdCategoryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GEMStdCategoryLocalServiceUtil
 */
public class GEMStdCategoryLocalServiceImpl
	extends GEMStdCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GEMStdCategoryLocalServiceUtil} to access the g e m std category local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(GEMStdCategoryLocalServiceImpl.class);
	public void clearCache(){
		try {
			gemStdCategoryPersistence.clearCache();
		} catch (Exception e) {
		}
	}
	
	public GEMStdCategory getByStdCatgyMapping(long stdId, long categoryId, String templateType, String chainCode) throws NoSuchGEMStdCategoryException, SystemException {
		return gemStdCategoryPersistence.findByStdCatgyMapping(stdId, categoryId, templateType, chainCode);
	}
	
	public List<GEMStdCategory> getByCatgyTemplateAndChain(long categoryId, String templateType, String chainCode) throws SystemException {
		return gemStdCategoryPersistence.findByCatgyTemplateAndChain(categoryId, templateType, chainCode);
	}
	public List<GEMStdCategory> getByCatgyAndChain(long categoryId, String chainCode) throws SystemException {
		return gemStdCategoryPersistence.findByCatgyAndChain(categoryId, chainCode);
	}
	public List<GEMStdCategory> getByCategoryId(long categoryId) throws SystemException {
		return gemStdCategoryPersistence.findByCategoryId(categoryId);
	}
	
	public GEMStdCategory addGEMStdCategoryMaping(long stdId, long categoryId, String templateType, String chainCode, String creatorId) throws SystemException{
		GEMStdCategory gemStdCategory = gemStdCategoryPersistence.create(gemTemplateFinder.getSequenceNumber("GEM_STD_CATGY_ID_SEQ"));
		gemStdCategory.setStdId(stdId);
		gemStdCategory.setCategoryId(categoryId);
		gemStdCategory.setTemplateType(templateType);
		gemStdCategory.setChainCode(chainCode);
		
		gemStdCategory.setCreatorId(creatorId);
		gemStdCategory.setCreatedDate(new Date());
		gemStdCategory.setUpdatedBy(creatorId);
		gemStdCategory.setUpdatedDate(new Date());
		gemStdCategory = gemStdCategoryPersistence.update(gemStdCategory);
		return gemStdCategory;
	}
	
	public GEMStdCategory updateGEMStdCategoryMaping(long stdId, long categoryId, String templateType, String chainCode, String creatorId) throws SystemException{
		
		GEMStdCategory gemStdCategory = null;
		try {
			gemStdCategory = gemStdCategoryPersistence.findByStdCatgyMapping(stdId, categoryId, templateType, chainCode);
		} catch(Exception e){
			LOG.info("Standard and Category Mapping not exist");
		}
		if(gemStdCategory == null) {
			gemStdCategory = addGEMStdCategoryMaping(stdId, categoryId, templateType, chainCode, creatorId);
		} else {
			gemStdCategory.setStdId(stdId);
			gemStdCategory.setCategoryId(categoryId);
			gemStdCategory.setTemplateType(templateType);
			gemStdCategory.setChainCode(chainCode);
			
			gemStdCategory.setUpdatedBy(creatorId);
			gemStdCategory.setUpdatedDate(new Date());
			gemStdCategory = gemStdCategoryPersistence.update(gemStdCategory);
		}
		return gemStdCategory;
	}
}