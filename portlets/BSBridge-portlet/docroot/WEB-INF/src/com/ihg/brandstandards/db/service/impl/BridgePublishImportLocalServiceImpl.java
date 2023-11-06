/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.BridgePublishImport;
import com.ihg.brandstandards.db.model.impl.BridgePublishImportImpl;
import com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.BridgePublishImportLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the bridge publish import local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgePublishImportLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgePublishImportLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil
 */
public class BridgePublishImportLocalServiceImpl extends BridgePublishImportLocalServiceBaseImpl {
    
    private static final Log LOG = LogFactoryUtil.getLog(BridgePublishImportLocalServiceImpl.class);
            
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil} to access the bridge publish import local service.
	 */
    
    public BridgePublishImport createOraSequence() throws SystemException
    {
        return bridgePublishImportFinder.createOraSequence();
    }
    
    public int addBridgePublishImport(List<Long> stdIds, long publishId, String chainCode, long rgnId, String userId) throws SystemException
    {
        return bridgePublishImportFinder.addBridgePublishImport(stdIds, publishId, chainCode, rgnId, userId);
    }
    
    public BridgePublishImport findByPublishIdAndStdId(long publishId, long stdId) throws SystemException
    {
    	BridgePublishImport publishImport = new BridgePublishImportImpl();
    	
    	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(BridgePublishImport.class);
    	Criterion stdCriterion = RestrictionsFactoryUtil.eq("stdId",stdId);
    	Criterion publishCriterion = RestrictionsFactoryUtil.eq("publishId",publishId);
    	dynamicQuery.add(stdCriterion);
        dynamicQuery.add(publishCriterion);
        @SuppressWarnings("unchecked")
        List<BridgePublishImport> arlStandards = BridgePublishImportLocalServiceUtil.dynamicQuery(dynamicQuery);
        
        for(BridgePublishImport birdgeImport:arlStandards)
        {
        	publishImport = birdgeImport;
        }
        
    	return publishImport;
    }
    
    public int getBridgeImportedRecordsCount(long publishId, long regionId) throws SystemException
    {
    	return bridgePublishImportFinder.getBridgeImportedRecordsCount(publishId, regionId);
    }
    
    public List<BridgePublishImport> findByPublishIdAndRegionId(long publishId, long rgnId) throws SystemException
    {
        bridgePublishImportPersistence.clearCache();
    	List<BridgePublishImport> arlStandards = bridgePublishImportPersistence.findByPublishIdAndRegionId(publishId, rgnId);
    	return arlStandards != null ? arlStandards : new ArrayList<BridgePublishImport>();
    }
    
    public List<Long> findByPublishIdRegionIdandSelectionInd(long publishId,long  rgnId) throws SystemException
    {
    	List<Long> arlStandards = new ArrayList<Long>();
    	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(BridgePublishImport.class);
    	Criterion rgnCriterion = RestrictionsFactoryUtil.eq("regionId",rgnId);
    	Criterion publishCriterion = RestrictionsFactoryUtil.eq("publishId",publishId);
    	Criterion selectionCriterion = RestrictionsFactoryUtil.eq("selectInd","Y");
    	dynamicQuery.add(rgnCriterion);
        dynamicQuery.add(publishCriterion);
        dynamicQuery.add(selectionCriterion);
        @SuppressWarnings("unchecked")
        List<BridgePublishImport> arlStandardsImport = BridgePublishImportLocalServiceUtil.dynamicQuery(dynamicQuery);
        for(BridgePublishImport bridgeImport : arlStandardsImport)
        {
        	arlStandards.add(bridgeImport.getStdId());
        }
       
    	return arlStandards;
    }
    
    public void deleteBridgeImportByPublishIdAndRegionId(long publishId, long regionId) throws SystemException
    {
        bridgePublishImportFinder.deleteBridgeImportByPublishIdAndRegionId(publishId, regionId);
        bridgePublishImportPersistence.clearCache();
    }
    
    public void updateBridgePublishImport(long publishId, List<Long> mustPublish, List<Long> mustNotPublish, List<Long> unPublish, 
            List<Long> wrongBrand, List<Long> wrongRgn, List<Long> doPublish, List<Long> discont,  List<Long> missing, List<Long> orphan) throws SystemException
    {
        bridgePublishImportFinder.updateBridgePublishImport(publishId, mustPublish, mustNotPublish, unPublish, 
                wrongBrand, wrongRgn, doPublish, discont, missing, orphan);
    }
    
    public List<Long> getStandardsByRegion(long publishId, long regionId) throws SystemException
    {
        return bridgePublishImportFinder.getStandardsByRegion(publishId, regionId);
    }
    
    public List<Long> getDiscountinuedStandards(List<Long> stdIds, String chainCode) throws SystemException
    {
        return bridgePublishImportFinder.getDiscountinuedStandards(stdIds, chainCode);
    }

    public long getMyPublicationIssuesCount(long publishId, long regionId, String vldStatusExclude){
    	return bridgePublishImportFinder.getMyPublicationIssuesCount(publishId, regionId, vldStatusExclude);
    }

    public void clearCache()
    {
        bridgePublishImportPersistence.clearCache();
    }
    
    public void updateGlobalRegionalStdCountries(long publishId, long stdId, long cmsRegionId, String userScreenName)
    {
        bridgePublishImportFinder.updateGlobalRegionalStdCountries(publishId, stdId, cmsRegionId, userScreenName);
    }
    
    public void updateStdCountriesState(long publishId, long stdId, long cmsRegionId, String userScreenName)
    {
        bridgePublishImportFinder.updateStdCountriesState(publishId, stdId, cmsRegionId, userScreenName);
    }
    
    public void setBridgePublishForImport(long publishId, long rgnId, Map<Long, String> importSelection) throws SystemException
    {
        bridgePublishImportFinder.setBridgePublishForImport(publishId, rgnId, importSelection);
    }
    
    public long getSTDToBeAddedCount(long publishId, long rgnId)
    {
        return bridgePublishImportFinder.getSTDToBeAddedCount(publishId, rgnId);
    }
}