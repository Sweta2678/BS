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

package com.ihg.brandstandards.db.service.persistence;

/**
 * @author Mummanedi
 */
public interface BridgeGlobalPublishFinder {
	public java.util.List<com.ihg.brandstandards.db.model.MustPublish> getMustPublishStandardsByIdsAndBrand(
		java.lang.String stdIdsByCommaSeprated, java.lang.String brand,
		boolean mustPublish)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgeGlobalPublish getNewBridgeGlobalPublish();

	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getNewBridgeGlobalPublishCountry();

	public java.util.Map<java.lang.String, java.lang.Long> getTotalIssuesforMustpublish(
		java.lang.String isMustPublish, long publishId, java.lang.String brand);

	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getCountriesByGlobalPublishIdAndRegionId(
		long bridgeGlobalPublishId, long regionId);

	public void importGlobalMustPublishStandards(long publishId,
		java.lang.String chainCode, java.lang.String screenName,
		java.lang.String stdIds)
		throws com.liferay.portal.kernel.exception.SystemException;
}