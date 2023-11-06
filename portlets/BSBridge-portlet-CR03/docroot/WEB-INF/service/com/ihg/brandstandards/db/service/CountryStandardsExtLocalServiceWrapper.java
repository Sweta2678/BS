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
 * Provides a wrapper for {@link CountryStandardsExtLocalService}.
 *
 * @author Mummanedi
 * @see CountryStandardsExtLocalService
 * @generated
 */
public class CountryStandardsExtLocalServiceWrapper
	implements CountryStandardsExtLocalService,
		ServiceWrapper<CountryStandardsExtLocalService> {
	public CountryStandardsExtLocalServiceWrapper(
		CountryStandardsExtLocalService countryStandardsExtLocalService) {
		_countryStandardsExtLocalService = countryStandardsExtLocalService;
	}

	/**
	* Adds the country standards ext to the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandardsExt the country standards ext
	* @return the country standards ext that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt addCountryStandardsExt(
		com.ihg.brandstandards.db.model.CountryStandardsExt countryStandardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.addCountryStandardsExt(countryStandardsExt);
	}

	/**
	* Creates a new country standards ext with the primary key. Does not add the country standards ext to the database.
	*
	* @param countryStandardsExtPK the primary key for the new country standards ext
	* @return the new country standards ext
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt createCountryStandardsExt(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK) {
		return _countryStandardsExtLocalService.createCountryStandardsExt(countryStandardsExtPK);
	}

	/**
	* Deletes the country standards ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandardsExtPK the primary key of the country standards ext
	* @return the country standards ext that was removed
	* @throws PortalException if a country standards ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt deleteCountryStandardsExt(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.deleteCountryStandardsExt(countryStandardsExtPK);
	}

	/**
	* Deletes the country standards ext from the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandardsExt the country standards ext
	* @return the country standards ext that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt deleteCountryStandardsExt(
		com.ihg.brandstandards.db.model.CountryStandardsExt countryStandardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.deleteCountryStandardsExt(countryStandardsExt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _countryStandardsExtLocalService.dynamicQuery();
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
		return _countryStandardsExtLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _countryStandardsExtLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _countryStandardsExtLocalService.dynamicQuery(dynamicQuery,
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
		return _countryStandardsExtLocalService.dynamicQueryCount(dynamicQuery);
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
		return _countryStandardsExtLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt fetchCountryStandardsExt(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.fetchCountryStandardsExt(countryStandardsExtPK);
	}

	/**
	* Returns the country standards ext with the primary key.
	*
	* @param countryStandardsExtPK the primary key of the country standards ext
	* @return the country standards ext
	* @throws PortalException if a country standards ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt getCountryStandardsExt(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.getCountryStandardsExt(countryStandardsExtPK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the country standards exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of country standards exts
	* @param end the upper bound of the range of country standards exts (not inclusive)
	* @return the range of country standards exts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandardsExt> getCountryStandardsExts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.getCountryStandardsExts(start,
			end);
	}

	/**
	* Returns the number of country standards exts.
	*
	* @return the number of country standards exts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCountryStandardsExtsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.getCountryStandardsExtsCount();
	}

	/**
	* Updates the country standards ext in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param countryStandardsExt the country standards ext
	* @return the country standards ext that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt updateCountryStandardsExt(
		com.ihg.brandstandards.db.model.CountryStandardsExt countryStandardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.updateCountryStandardsExt(countryStandardsExt);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _countryStandardsExtLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_countryStandardsExtLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _countryStandardsExtLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandardsExt> getCountriesByStandard(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return _countryStandardsExtLocalService.getCountriesByStandard(stdId);
	}

	@Override
	public java.util.List<java.lang.Object> getRegionsCountryCount(long stdId) {
		return _countryStandardsExtLocalService.getRegionsCountryCount(stdId);
	}

	@Override
	public void clearCache() {
		_countryStandardsExtLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CountryStandardsExtLocalService getWrappedCountryStandardsExtLocalService() {
		return _countryStandardsExtLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCountryStandardsExtLocalService(
		CountryStandardsExtLocalService countryStandardsExtLocalService) {
		_countryStandardsExtLocalService = countryStandardsExtLocalService;
	}

	@Override
	public CountryStandardsExtLocalService getWrappedService() {
		return _countryStandardsExtLocalService;
	}

	@Override
	public void setWrappedService(
		CountryStandardsExtLocalService countryStandardsExtLocalService) {
		_countryStandardsExtLocalService = countryStandardsExtLocalService;
	}

	private CountryStandardsExtLocalService _countryStandardsExtLocalService;
}