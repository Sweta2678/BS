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
 * Provides a wrapper for {@link StandardsCountryLocalService}.
 *
 * @author Mummanedi
 * @see StandardsCountryLocalService
 * @generated
 */
public class StandardsCountryLocalServiceWrapper
	implements StandardsCountryLocalService,
		ServiceWrapper<StandardsCountryLocalService> {
	public StandardsCountryLocalServiceWrapper(
		StandardsCountryLocalService standardsCountryLocalService) {
		_standardsCountryLocalService = standardsCountryLocalService;
	}

	/**
	* Adds the standards country to the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountry the standards country
	* @return the standards country that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountry addStandardsCountry(
		com.ihg.brandstandards.db.model.StandardsCountry standardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.addStandardsCountry(standardsCountry);
	}

	/**
	* Creates a new standards country with the primary key. Does not add the standards country to the database.
	*
	* @param countryNameCode the primary key for the new standards country
	* @return the new standards country
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountry createStandardsCountry(
		java.lang.String countryNameCode) {
		return _standardsCountryLocalService.createStandardsCountry(countryNameCode);
	}

	/**
	* Deletes the standards country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryNameCode the primary key of the standards country
	* @return the standards country that was removed
	* @throws PortalException if a standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountry deleteStandardsCountry(
		java.lang.String countryNameCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.deleteStandardsCountry(countryNameCode);
	}

	/**
	* Deletes the standards country from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsCountry the standards country
	* @return the standards country that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountry deleteStandardsCountry(
		com.ihg.brandstandards.db.model.StandardsCountry standardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.deleteStandardsCountry(standardsCountry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _standardsCountryLocalService.dynamicQuery();
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
		return _standardsCountryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsCountryLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _standardsCountryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _standardsCountryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _standardsCountryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountry fetchStandardsCountry(
		java.lang.String countryNameCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.fetchStandardsCountry(countryNameCode);
	}

	/**
	* Returns the standards country with the primary key.
	*
	* @param countryNameCode the primary key of the standards country
	* @return the standards country
	* @throws PortalException if a standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountry getStandardsCountry(
		java.lang.String countryNameCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.getStandardsCountry(countryNameCode);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards countries
	* @param end the upper bound of the range of standards countries (not inclusive)
	* @return the range of standards countries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> getStandardsCountries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.getStandardsCountries(start, end);
	}

	/**
	* Returns the number of standards countries.
	*
	* @return the number of standards countries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStandardsCountriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.getStandardsCountriesCount();
	}

	/**
	* Updates the standards country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param standardsCountry the standards country
	* @return the standards country that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.StandardsCountry updateStandardsCountry(
		com.ihg.brandstandards.db.model.StandardsCountry standardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _standardsCountryLocalService.updateStandardsCountry(standardsCountry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _standardsCountryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_standardsCountryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _standardsCountryLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_standardsCountryLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StandardsCountryLocalService getWrappedStandardsCountryLocalService() {
		return _standardsCountryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStandardsCountryLocalService(
		StandardsCountryLocalService standardsCountryLocalService) {
		_standardsCountryLocalService = standardsCountryLocalService;
	}

	@Override
	public StandardsCountryLocalService getWrappedService() {
		return _standardsCountryLocalService;
	}

	@Override
	public void setWrappedService(
		StandardsCountryLocalService standardsCountryLocalService) {
		_standardsCountryLocalService = standardsCountryLocalService;
	}

	private StandardsCountryLocalService _standardsCountryLocalService;
}