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

import com.ihg.brandstandards.db.model.BridgeGlobalPublish;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry;
import com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.BridgeGlobalPublishLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the bridge global publish local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgeGlobalPublishLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil
 */
public class BridgeGlobalPublishLocalServiceImpl extends BridgeGlobalPublishLocalServiceBaseImpl 
{
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil} to access the bridge global publish local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(BridgeGlobalPublishLocalServiceBaseImpl.class);
	
	public void clearCache()
    {
        try
        {
            bridgeGlobalPublishPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	public List getMustPublishStandardsByIdsAndBrand(String stdIdsByCommaSeprated, String brand,boolean mustPublish)
	{
		try {
			return bridgeGlobalPublishFinder.getMustPublishStandardsByIdsAndBrand(stdIdsByCommaSeprated, brand, mustPublish);
		} catch (SystemException e) {
		    LOG.error(StackTraceUtil.getStackTrace(e));
		}
		return null;
	}
	
	public Map<String, Long> getTotalIssuesforMustpublish(String isMustPublish,long publishId, String brand )
    {
			return bridgeGlobalPublishFinder.getTotalIssuesforMustpublish(isMustPublish, publishId, brand);
    }
	
	public BridgeGlobalPublish getByPublishIdAndStdId(long publishId, long stdId)
	{
    	try {
			return bridgeGlobalPublishPersistence.fetchByPublishIdAndStdId(publishId, stdId,false);
		} catch (SystemException e) {
		    LOG.error(StackTraceUtil.getStackTrace(e));
		}
    	return null;
    }
    
    public BridgeGlobalPublish getByStdIdAndMustPublishInd(long publishId,long stdId,String mustPublishInd)
	{
    	try {
    		return bridgeGlobalPublishPersistence.fetchByStdIdAndMustPublishInd(stdId, mustPublishInd,publishId, false);
    	} catch (SystemException e) {
		    LOG.error(StackTraceUtil.getStackTrace(e));
		}
    	return null;
	}
    
    public List<Long> getGlobalStandardsByPublishIdAndIndicator(String indicator, long publishId) throws SystemException
    {
    	List<Long> arlStandardIds = new ArrayList<Long>();
    	List<BridgeGlobalPublish> arlGlobalPublish = new ArrayList<BridgeGlobalPublish>();
    	
    	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(BridgeGlobalPublish.class);
    	Criterion stdCriterion = RestrictionsFactoryUtil.eq("mustPublishInd", indicator);
        Criterion publishIdCriterion = RestrictionsFactoryUtil.eq("publishId", publishId);
        dynamicQuery.add(stdCriterion);
        dynamicQuery.add(publishIdCriterion);
        arlGlobalPublish = BridgeGlobalPublishLocalServiceUtil.dynamicQuery(dynamicQuery);
        
        for(BridgeGlobalPublish globalPublish: arlGlobalPublish)
        {
        	arlStandardIds.add(globalPublish.getStdId());
        }
        
        return arlStandardIds;
    }
    
    public BridgeGlobalPublish getNewBridgeGlobalPublish()
    {
    	return bridgeGlobalPublishFinder.getNewBridgeGlobalPublish();
    }
    
    public BridgeGlobalPublishCountry getNewBridgeGlobalPublishCountry()
    {
    	return bridgeGlobalPublishFinder.getNewBridgeGlobalPublishCountry();
    }
    
    public List<BridgeGlobalPublishCountry> getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId(long bridgeGlobalPublishId, long regionId)
    {
    	return bridgeGlobalPublishFinder.getCountriesByGlobalPublishIdAndRegionId(bridgeGlobalPublishId, regionId);
    }
    
    public void importGlobalMustPublishStandards(long publishId, String chainCode, String screenName, String stdIds) throws SystemException {
    	bridgeGlobalPublishFinder.importGlobalMustPublishStandards(publishId, chainCode, screenName, stdIds);
    }
}