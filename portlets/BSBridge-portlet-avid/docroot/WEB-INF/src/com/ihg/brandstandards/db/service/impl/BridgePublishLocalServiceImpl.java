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

import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.NoSuchBridgePublishException;
import com.ihg.brandstandards.db.model.BridgePublish;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.service.base.BridgePublishLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the bridge publish local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgePublishLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgePublishLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil
 */
public class BridgePublishLocalServiceImpl extends BridgePublishLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil} to access the bridge publish local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(BridgePublishLocalServiceImpl.class);   
	 
    public void clearCache()
    {
        try
        {
            bridgePublishPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<BridgePublish> getByPublish(long publishId) throws SystemException
    {
        return bridgePublishPersistence.findByPublishId(publishId);
    }
    
    public List<BridgePublish> getByPublishIdAndStdId(long publishId, long standardId) throws SystemException
    {
        return bridgePublishPersistence.findByPublishIdAndStdId(publishId, standardId);
    }
    
    public List<BridgePublish> getByPublishIdAndRegionId(long publishId, long regionId) throws SystemException
    {
        return bridgePublishPersistence.findByPublishIdAndRegionId(publishId, regionId);
    }
    
    public BridgePublish getByPublishIdRegionIdAndStdId(long publishId, long regionCode, long standardId) throws NoSuchBridgePublishException, SystemException 
    {
        return bridgePublishPersistence.findByPublishIdRegionIdAndStdId(publishId, regionCode, standardId);
    }
    
    public List<Long> getStandardIds (long publishId) 
    {
        return this.bridgePublishFinder.getStandardIds(publishId);
    }
    
    public Map<String, Long> getBridgeProgress(long publishId, String chainCode, Date publishDate, long regionId, boolean allRegions, String progressType) throws SystemException 
    {
    	return this.bridgePublishFinder.getBridgeProgress(publishId, chainCode, publishDate, regionId, allRegions, progressType);
    }
    
    public Map<String, Long> getOverallProgress(long publishId, long regionId, boolean allRegions) 
    {
        return this.bridgePublishFinder.getOverallProgress(publishId, regionId, allRegions);
    }
    
    public Map<String, Long> getTranslationProgress(long publishId, long regionId, boolean allRegions) throws SystemException 
    {
        return this.bridgePublishFinder.getTranslationProgress(publishId, regionId, allRegions);
    }
    
    public Map<String, Long> getIndexTranslationProgress(long publishId, String chainCode, long regionId, boolean allRegions) throws SystemException 
    {
        return this.bridgePublishFinder.getIndexTranslationProgress(publishId, chainCode, regionId, allRegions);
    }
    
    public List<PublishStandardsExt> getProgressViewDetailsStandards(long publishId, long regionId, String chainCode, Date publishDate, String localeCode, String statIndText)
    {
        return this.bridgePublishFinder.getProgressViewDetailsStandards(publishId, regionId, chainCode, publishDate, localeCode, statIndText);
    }
    
    public List<PublishStandardsExt> getUnpublishedDetailsStandards(long publishId, long regionId, String chainCode, String regionCode, String stdIds)
    {
        return this.bridgePublishFinder.getUnpublishedDetailsStandards(publishId, regionId, chainCode, regionCode, stdIds);
    }
    
    public List getTranslationViewDetailsStandards(long publishId, long regionId, String localeCode)
    {
        return this.bridgePublishFinder.getTranslationViewDetailsStandards(publishId, regionId, localeCode);
    }
    
    public List<PublishQueue> getPublishQueueRecords (String brandCode, String environment, String status) 
    {
        return this.bridgePublishFinder.getPublishQueueRecords(brandCode, environment, status);
    }
    
    public void resetBridgePublication(long bridgePublishId, long regionId, String chainCode, String userScreenName) throws SystemException
    {
        bridgePublishFinder.resetBridgePublication(bridgePublishId, regionId, chainCode, userScreenName);
    }
    
    public void updateUnpublishedToPublishedRecords(long publishId, String brandCode, long regionId, String screenName, String stdIds)
    {
    	 bridgePublishFinder.updateUnpublishedToPublishedRecords(publishId, brandCode, regionId, screenName, stdIds);
    }
    
    public void createDraftPublication(long publishId, String brandCode, String screenName)
    {
        bridgePublishFinder.createDraftPublication(publishId, brandCode, screenName);
    }
    
    public List<PublishStandardsExt> getMyPublicationByBrand(String chainCode, String regionCode, String query) throws SystemException
    {
    	List<PublishStandardsExt> arlStandards = new ArrayList<PublishStandardsExt>();
		try
		{
			arlStandards = bridgePublishFinder.getMyPublicationByBrand(chainCode,regionCode, query);
		}
		catch(Exception e)
		{
		    LOG.error(StackTraceUtil.getStackTrace(e));
		}
		
		return arlStandards;
    }
    
    /**
     * 
     * @param publishId
     * @return long
     */
    public long getStandardCountForPublication (long publishId) {
    	return bridgePublishFinder.getStandardCountForPublication(publishId);
    }
    
    public BridgePublish createOraSequence() throws SystemException
    {
    	return bridgePublishFinder.createOraSequence();
    }
 
    public boolean updateBridgePublishAndCountryFromImport(long bridgePublishId, long prodPublishId, String brandCode, long regionId, String screenName ) throws SystemException
    {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("inside local service impl to update bridge publish from import");
    	}
    	return bridgePublishFinder.updateBridgePublishAndCountryFromImport(bridgePublishId, prodPublishId, brandCode, regionId, screenName);
    }
    
    public List<Long> getBridgePublishStandardsByParent(String query) throws SystemException
    {
    	return bridgePublishFinder.getBridgePublishStandardsByParent(query);
    }
    
    public BridgePublish getBridgePublishStandardsById(String query) throws SystemException
    {
    	return bridgePublishFinder.getBridgePublishStandardsById(query);
    }
    
    public List<Standard> getStandardDetails (String query) {
    	    	
    	return bridgePublishFinder.getStandardDetails(query);
    }
    
    public List<PublishStandardsExt> getPublishedStandardsCompliance(List<Long> stdIds, String stdType, String brandCd, String regionCode,
            String fromDate, String toDate) throws SystemException
    {
        return bridgePublishFinder.getPublishedStandardsCompliance(stdIds, stdType, brandCd, regionCode, fromDate, toDate);
    }
    
    public Map<String, String> getPublishedStandardComplianceDetails(long stdId, String brandCode, String regionCode) throws SystemException
    {
        return bridgePublishFinder.getPublishedStandardComplianceDetails(stdId, brandCode, regionCode);
    }
    
    public List<PublishStandardsExt> getBridgeStandardsCompliance(List<Long> stdIds, String stdType, String brandCd, String regionCode,
            String fromDate, String toDate) throws SystemException
    {
        return bridgePublishFinder.getBridgeStandardsCompliance(stdIds, stdType, brandCd, regionCode, fromDate, toDate);
    }
    
    public Map<String, String> getBridgeStandardComplianceDetails(long stdId, String brandCode, String regionCode) throws SystemException
    {
        return bridgePublishFinder.getBridgeStandardComplianceDetails(stdId, brandCode, regionCode);
    }
    
    public void createManuals (long publishQueueId, long publishId, String emailAddress, String userName) {
    	bridgePublishFinder.createManuals(publishQueueId, publishId, emailAddress, userName);
    }
    
    public List<Long> getMissingReferences (long publishId, long regionId) throws SystemException {
    	return bridgePublishFinder.getMissingReferences(publishId, regionId);
    }
    
    public void addStdToBridgeForAddById(long bridgePublishId, long prodPublishId, String brandCode, 
            long regionId, List<Long> stdIds, String screenName)
    {
        bridgePublishFinder.addStdToBridgeForAddById(bridgePublishId, prodPublishId, brandCode, regionId, stdIds, screenName);
        try {
        	bridgePublishPersistence.clearCache();
        } catch (Exception e) {
        	LOG.error(e.getMessage(), e);
        }
    }
    
    /**
     * Get active Bridge Publish Ids for specified standard id.
     * @param stdId standard id
     * @return String
     */
    public List<Long> getBridgePublishIdsByStdId(long stdId) throws SystemException
    {
        return bridgePublishFinder.getBridgePublishIdsByStdId(stdId);
    }
    
    /**
     * 
     * @param publishId
     * @param stdId
     * @return
     */
    public List<Long> getRegionsByPublishIdAndStdId (long publishId, long stdId) {
    	return bridgePublishFinder.getRegionsByPublishIdAndStdId(publishId, stdId);
    }
}