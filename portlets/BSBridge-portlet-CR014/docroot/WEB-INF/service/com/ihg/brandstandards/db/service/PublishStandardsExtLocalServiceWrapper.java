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

package com.ihg.brandstandards.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublishStandardsExtLocalService}.
 *
 * @author Mummanedi
 * @see PublishStandardsExtLocalService
 * @generated
 */
public class PublishStandardsExtLocalServiceWrapper
	implements PublishStandardsExtLocalService,
		ServiceWrapper<PublishStandardsExtLocalService> {
	public PublishStandardsExtLocalServiceWrapper(
		PublishStandardsExtLocalService publishStandardsExtLocalService) {
		_publishStandardsExtLocalService = publishStandardsExtLocalService;
	}

	/**
	* Adds the Custom Query mapping to createlist of standards with translations. to the database. Also notifies the appropriate model listeners.
	*
	* @param publishStandardsExt the Custom Query mapping to createlist of standards with translations.
	* @return the Custom Query mapping to createlist of standards with translations. that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt addPublishStandardsExt(
		com.ihg.brandstandards.db.model.PublishStandardsExt publishStandardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.addPublishStandardsExt(publishStandardsExt);
	}

	/**
	* Creates a new Custom Query mapping to createlist of standards with translations. with the primary key. Does not add the Custom Query mapping to createlist of standards with translations. to the database.
	*
	* @param publishStdId the primary key for the new Custom Query mapping to createlist of standards with translations.
	* @return the new Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt createPublishStandardsExt(
		long publishStdId) {
		return _publishStandardsExtLocalService.createPublishStandardsExt(publishStdId);
	}

	/**
	* Deletes the Custom Query mapping to createlist of standards with translations. with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStdId the primary key of the Custom Query mapping to createlist of standards with translations.
	* @return the Custom Query mapping to createlist of standards with translations. that was removed
	* @throws PortalException if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt deletePublishStandardsExt(
		long publishStdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.deletePublishStandardsExt(publishStdId);
	}

	/**
	* Deletes the Custom Query mapping to createlist of standards with translations. from the database. Also notifies the appropriate model listeners.
	*
	* @param publishStandardsExt the Custom Query mapping to createlist of standards with translations.
	* @return the Custom Query mapping to createlist of standards with translations. that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt deletePublishStandardsExt(
		com.ihg.brandstandards.db.model.PublishStandardsExt publishStandardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.deletePublishStandardsExt(publishStandardsExt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publishStandardsExtLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt fetchPublishStandardsExt(
		long publishStdId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.fetchPublishStandardsExt(publishStdId);
	}

	/**
	* Returns the Custom Query mapping to createlist of standards with translations. with the primary key.
	*
	* @param publishStdId the primary key of the Custom Query mapping to createlist of standards with translations.
	* @return the Custom Query mapping to createlist of standards with translations.
	* @throws PortalException if a Custom Query mapping to createlist of standards with translations. with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt getPublishStandardsExt(
		long publishStdId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.getPublishStandardsExt(publishStdId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the Custom Query mapping to createlist of standards with translations.s.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of Custom Query mapping to createlist of standards with translations.s
	* @param end the upper bound of the range of Custom Query mapping to createlist of standards with translations.s (not inclusive)
	* @return the range of Custom Query mapping to createlist of standards with translations.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getPublishStandardsExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.getPublishStandardsExts(start,
			end);
	}

	/**
	* Returns the number of Custom Query mapping to createlist of standards with translations.s.
	*
	* @return the number of Custom Query mapping to createlist of standards with translations.s
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishStandardsExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.getPublishStandardsExtsCount();
	}

	/**
	* Updates the Custom Query mapping to createlist of standards with translations. in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publishStandardsExt the Custom Query mapping to createlist of standards with translations.
	* @return the Custom Query mapping to createlist of standards with translations. that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt updatePublishStandardsExt(
		com.ihg.brandstandards.db.model.PublishStandardsExt publishStandardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.updatePublishStandardsExt(publishStandardsExt);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publishStandardsExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publishStandardsExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publishStandardsExtLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getStandardsByBrandAndCountry(
		java.lang.String localeCode, java.lang.String chainCode,
		java.lang.String countryCode, java.lang.String stdType,
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.getStandardsByBrandAndCountry(localeCode,
			chainCode, countryCode, stdType, query);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getSearchResults(
		java.lang.String localeCode, java.lang.String chainCode,
		java.lang.String countryCode, java.lang.String stdType,
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.getSearchResults(localeCode,
			chainCode, countryCode, stdType, query);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getAllIndexes(
		java.lang.String query) {
		return _publishStandardsExtLocalService.getAllIndexes(query);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getCMSAllIndexes() {
		return _publishStandardsExtLocalService.getCMSAllIndexes();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getWhatChangedOnList(
		java.lang.String query, boolean indexQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publishStandardsExtLocalService.getWhatChangedOnList(query,
			indexQuery);
	}

	@Override
	public void clearCache() {
		_publishStandardsExtLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublishStandardsExtLocalService getWrappedPublishStandardsExtLocalService() {
		return _publishStandardsExtLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublishStandardsExtLocalService(
		PublishStandardsExtLocalService publishStandardsExtLocalService) {
		_publishStandardsExtLocalService = publishStandardsExtLocalService;
	}

	@Override
	public PublishStandardsExtLocalService getWrappedService() {
		return _publishStandardsExtLocalService;
	}

	@Override
	public void setWrappedService(
		PublishStandardsExtLocalService publishStandardsExtLocalService) {
		_publishStandardsExtLocalService = publishStandardsExtLocalService;
	}

	private PublishStandardsExtLocalService _publishStandardsExtLocalService;
}