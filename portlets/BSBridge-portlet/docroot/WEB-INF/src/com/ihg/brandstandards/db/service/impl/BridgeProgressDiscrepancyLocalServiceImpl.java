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

import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.custom.model.BridgeProgressCount;
import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy;
import com.ihg.brandstandards.db.service.base.BridgeProgressDiscrepancyLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the bridge progress discrepancy local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgeProgressDiscrepancyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgeProgressDiscrepancyLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgeProgressDiscrepancyLocalServiceUtil
 */
public class BridgeProgressDiscrepancyLocalServiceImpl
	extends BridgeProgressDiscrepancyLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgeProgressDiscrepancyLocalServiceUtil} to access the bridge progress discrepancy local service.
	 */
	
	public void deleteDeactivatedBridgePublishProgress(List<Long> deactivatedBridgePublishIds){
		try {
			//bridgePublishCountryPersistence.removeByPublishId(bridgePublishId);
			bridgeProgressDiscrepancyFinder.deleteDeactivatedBridgePublishProgress(deactivatedBridgePublishIds);
		} catch (Exception e) {
			LOG.error("Failed to delete deleteBridgePublishProgress with bridgePublishId:" + StringUtils.join(deactivatedBridgePublishIds,",") + "  Error Message:"+ e.getMessage());
		}
	}
	
	public void addBridgeProgressValues(final List<BridgeProgressCount> progressDiscrepancy,final String screenName){
		bridgeProgressDiscrepancyFinder.addBridgeProgressValues(progressDiscrepancy,screenName,bridgeProgressDiscrepancyPersistence.getDataSource());
	}
	
	public List<BridgeProgressDiscrepancy> findDiscrepancyByCatPubReg(long publishId,long regionId,long progressCategoryId) throws SystemException{
		return bridgeProgressDiscrepancyPersistence.findBypublicationPublishRgnCategory(publishId, regionId, progressCategoryId);
	}
	
	private static final Log LOG = LogFactoryUtil.getLog(BridgeProgressDiscrepancyLocalServiceImpl.class);
}