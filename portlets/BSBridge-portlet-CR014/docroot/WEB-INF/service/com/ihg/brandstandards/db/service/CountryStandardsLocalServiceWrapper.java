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
 * Provides a wrapper for {@link CountryStandardsLocalService}.
 *
 * @author Mummanedi
 * @see CountryStandardsLocalService
 * @generated
 */
public class CountryStandardsLocalServiceWrapper
	implements CountryStandardsLocalService,
		ServiceWrapper<CountryStandardsLocalService> {
	public CountryStandardsLocalServiceWrapper(
		CountryStandardsLocalService countryStandardsLocalService) {
		_countryStandardsLocalService = countryStandardsLocalService;
	}

	/**
	* Adds the country standards to the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandards the country standards
	* @return the country standards that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandards addCountryStandards(
		com.ihg.brandstandards.db.model.CountryStandards countryStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.addCountryStandards(countryStandards);
	}

	/**
	* Creates a new country standards with the primary key. Does not add the country standards to the database.
	*
	* @param countryStandardsPK the primary key for the new country standards
	* @return the new country standards
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandards createCountryStandards(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK) {
		return _countryStandardsLocalService.createCountryStandards(countryStandardsPK);
	}

	/**
	* Deletes the country standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandardsPK the primary key of the country standards
	* @return the country standards that was removed
	* @throws PortalException if a country standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandards deleteCountryStandards(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.deleteCountryStandards(countryStandardsPK);
	}

	/**
	* Deletes the country standards from the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandards the country standards
	* @return the country standards that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandards deleteCountryStandards(
		com.ihg.brandstandards.db.model.CountryStandards countryStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.deleteCountryStandards(countryStandards);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _countryStandardsLocalService.dynamicQuery();
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
		return _countryStandardsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _countryStandardsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _countryStandardsLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _countryStandardsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _countryStandardsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.CountryStandards fetchCountryStandards(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.fetchCountryStandards(countryStandardsPK);
	}

	/**
	* Returns the country standards with the primary key.
	*
	* @param countryStandardsPK the primary key of the country standards
	* @return the country standards
	* @throws PortalException if a country standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandards getCountryStandards(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.getCountryStandards(countryStandardsPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the country standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of country standardses
	* @param end the upper bound of the range of country standardses (not inclusive)
	* @return the range of country standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> getCountryStandardses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.getCountryStandardses(start, end);
	}

	/**
	* Returns the number of country standardses.
	*
	* @return the number of country standardses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCountryStandardsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.getCountryStandardsesCount();
	}

	/**
	* Updates the country standards in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param countryStandards the country standards
	* @return the country standards that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandards updateCountryStandards(
		com.ihg.brandstandards.db.model.CountryStandards countryStandards)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.updateCountryStandards(countryStandards);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _countryStandardsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_countryStandardsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _countryStandardsLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.brandstandards.db.model.CountryStandards getCountryStandardsObject() {
		return _countryStandardsLocalService.getCountryStandardsObject();
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> getCountryStandardsByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsLocalService.getCountryStandardsByStdId(stdId);
	}

	@Override
	public void clearCache() {
		_countryStandardsLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CountryStandardsLocalService getWrappedCountryStandardsLocalService() {
		return _countryStandardsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCountryStandardsLocalService(
		CountryStandardsLocalService countryStandardsLocalService) {
		_countryStandardsLocalService = countryStandardsLocalService;
	}

	@Override
	public CountryStandardsLocalService getWrappedService() {
		return _countryStandardsLocalService;
	}

	@Override
	public void setWrappedService(
		CountryStandardsLocalService countryStandardsLocalService) {
		_countryStandardsLocalService = countryStandardsLocalService;
	}

	private CountryStandardsLocalService _countryStandardsLocalService;
}