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
public interface BridgePublishStateExFinder {
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStateEx> getBridgePublishStateEx(
		java.lang.String chainCd, long regionCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishStateEx> getBridgePublishStateEx(
		java.lang.String chainCd, long regionId, java.lang.String filterState,
		java.lang.String filterId)
		throws com.liferay.portal.kernel.exception.SystemException;
}