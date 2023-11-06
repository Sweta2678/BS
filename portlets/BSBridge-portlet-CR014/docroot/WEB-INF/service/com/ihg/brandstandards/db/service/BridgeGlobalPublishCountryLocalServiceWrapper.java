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
 * Provides a wrapper for {@link BridgeGlobalPublishCountryLocalService}.
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishCountryLocalService
 * @generated
 */
public class BridgeGlobalPublishCountryLocalServiceWrapper
	implements BridgeGlobalPublishCountryLocalService,
		ServiceWrapper<BridgeGlobalPublishCountryLocalService> {
	public BridgeGlobalPublishCountryLocalServiceWrapper(
		BridgeGlobalPublishCountryLocalService bridgeGlobalPublishCountryLocalService) {
		_bridgeGlobalPublishCountryLocalService = bridgeGlobalPublishCountryLocalService;
	}

	/**
	* Adds the bridge global publish country to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	* @return the bridge global publish country that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry addBridgeGlobalPublishCountry(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.addBridgeGlobalPublishCountry(bridgeGlobalPublishCountry);
	}

	/**
	* Creates a new bridge global publish country with the primary key. Does not add the bridge global publish country to the database.
	*
	* @param globalPublishCtryId the primary key for the new bridge global publish country
	* @return the new bridge global publish country
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry createBridgeGlobalPublishCountry(
		long globalPublishCtryId) {
		return _bridgeGlobalPublishCountryLocalService.createBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	/**
	* Deletes the bridge global publish country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country that was removed
	* @throws PortalException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry deleteBridgeGlobalPublishCountry(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.deleteBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	/**
	* Deletes the bridge global publish country from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	* @return the bridge global publish country that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry deleteBridgeGlobalPublishCountry(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.deleteBridgeGlobalPublishCountry(bridgeGlobalPublishCountry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bridgeGlobalPublishCountryLocalService.dynamicQuery();
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
		return _bridgeGlobalPublishCountryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bridgeGlobalPublishCountryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _bridgeGlobalPublishCountryLocalService.dynamicQuery(dynamicQuery,
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
		return _bridgeGlobalPublishCountryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _bridgeGlobalPublishCountryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchBridgeGlobalPublishCountry(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.fetchBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	/**
	* Returns the bridge global publish country with the primary key.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country
	* @throws PortalException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getBridgeGlobalPublishCountry(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.getBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bridge global publish countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publish countries
	* @param end the upper bound of the range of bridge global publish countries (not inclusive)
	* @return the range of bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getBridgeGlobalPublishCountries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.getBridgeGlobalPublishCountries(start,
			end);
	}

	/**
	* Returns the number of bridge global publish countries.
	*
	* @return the number of bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBridgeGlobalPublishCountriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.getBridgeGlobalPublishCountriesCount();
	}

	/**
	* Updates the bridge global publish country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	* @return the bridge global publish country that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry updateBridgeGlobalPublishCountry(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.updateBridgeGlobalPublishCountry(bridgeGlobalPublishCountry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bridgeGlobalPublishCountryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bridgeGlobalPublishCountryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bridgeGlobalPublishCountryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getCountriesByGlobalPublishId(
		long bridgeGlobalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.getCountriesByGlobalPublishId(bridgeGlobalPublishId);
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getCountriesByGlobalPublishIdAndCountryCode(
		long bridgeGlobalPublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return _bridgeGlobalPublishCountryLocalService.getCountriesByGlobalPublishIdAndCountryCode(bridgeGlobalPublishId,
			countryCode);
	}

	@Override
	public void clearCache() {
		_bridgeGlobalPublishCountryLocalService.clearCache();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BridgeGlobalPublishCountryLocalService getWrappedBridgeGlobalPublishCountryLocalService() {
		return _bridgeGlobalPublishCountryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBridgeGlobalPublishCountryLocalService(
		BridgeGlobalPublishCountryLocalService bridgeGlobalPublishCountryLocalService) {
		_bridgeGlobalPublishCountryLocalService = bridgeGlobalPublishCountryLocalService;
	}

	@Override
	public BridgeGlobalPublishCountryLocalService getWrappedService() {
		return _bridgeGlobalPublishCountryLocalService;
	}

	@Override
	public void setWrappedService(
		BridgeGlobalPublishCountryLocalService bridgeGlobalPublishCountryLocalService) {
		_bridgeGlobalPublishCountryLocalService = bridgeGlobalPublishCountryLocalService;
	}

	private BridgeGlobalPublishCountryLocalService _bridgeGlobalPublishCountryLocalService;
}