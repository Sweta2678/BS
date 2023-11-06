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
import java.util.Map;

import com.ihg.brandstandards.db.NoSuchGEMCategoryException;
import com.ihg.brandstandards.db.model.GEMCategory;
import com.ihg.brandstandards.db.service.base.GEMCategoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the g e m category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GEMCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GEMCategoryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil
 */
public class GEMCategoryLocalServiceImpl extends GEMCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil} to access the g e m category local service.
	 */
	public void clearCache(){
		try {
			gemCategoryPersistence.clearCache();
		} catch (Exception e) {
		}
	}
	
	public GEMCategory getByCMSCategoryId(long cmsCategoryId) throws NoSuchGEMCategoryException, SystemException {
		return gemCategoryPersistence.findByCMSCategoryId(cmsCategoryId);
	}
	
	public GEMCategory getByGEMCategoryId(String gemCategoryId) throws NoSuchGEMCategoryException, SystemException {
		return gemCategoryPersistence.findByGEMCategoryId(gemCategoryId);
	}
	
	public List<GEMCategory> getByGemPrntCategoryId(String gemPrntCategoryId) throws SystemException {
		return gemCategoryPersistence.findByGemPrntCategoryId(gemPrntCategoryId);
	}
	
	public List<GEMCategory> getByCategoryName(String categoryName) throws SystemException {
		return gemCategoryPersistence.findByCategoryName(categoryName);
	}
	
	public GEMCategory getByGEMCategoryIdAndName(String gemCategoryId, String categoryName) throws NoSuchGEMCategoryException, SystemException {
		return gemCategoryPersistence.findByGEMCategoryIdAndName(gemCategoryId, categoryName);
	}
	
	public long getGEMMappingCMSCategoryId(String cmsLookupCatgyIds, String gemCategoryName) {
		return gemCategoryFinder.getGEMMappingCMSCategoryId(cmsLookupCatgyIds, gemCategoryName);
	}
	
	public List<GEMCategory> getGEMTemplateCategories(long gemTemplateIds) {
		return gemCategoryFinder.getGEMTemplateCategories(gemTemplateIds);
	}
	
	public Map<Long, String> getGEMTemplateCategoriesInMap(long gemTemplateIds) {
		return gemCategoryFinder.getGEMTemplateCategoriesInMap(gemTemplateIds);
	}
	
	public Map<Long, String> getScoringSECategories(long gemSETemplateId) {
		return gemCategoryFinder.getScoringSECategories(gemSETemplateId);
	}
	
	public Map<Long, String> getQLFormSAAndSECategories(String gemSESATemplateIds) {
		return gemCategoryFinder.getQLFormSAAndSECategories(gemSESATemplateIds);
	}
}