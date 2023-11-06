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
public interface PublishStandardsExtFinder {
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getStandardsByCountryAndBrand(
		java.lang.String localeCode, java.lang.String chainCode,
		java.lang.String countryCode, java.lang.String stdType,
		java.lang.String query);

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getSearchResults(
		java.lang.String localeCode, java.lang.String chainCode,
		java.lang.String countryCode, java.lang.String stdType,
		java.lang.String query);

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getAllIndexes(
		java.lang.String query);

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getCMSAllIndexes(
		java.lang.String query);

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getWhatChangedOnList(
		java.lang.String query, boolean indexQuery);
}