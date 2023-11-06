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
public interface GEMUniqueGroupFinder {
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreview(
		java.lang.String groupName, java.lang.String chainCd, long regionId,
		java.lang.String filterIds, java.lang.String searchIds,
		java.lang.String selByState, java.lang.String locale,
		long bridgePublishId, java.lang.String groupType);

	public java.util.List<com.ihg.brandstandards.custom.model.GroupCountryDetails> getGroupAndCountryDetails(
		long publishId, long regionId, java.lang.String groupType);

	public java.util.Map<java.lang.String, java.lang.String> getStdUniqueGrpAndCtrys(
		long publishId, long regionId, java.lang.String groupType,
		java.lang.String stdId);
}