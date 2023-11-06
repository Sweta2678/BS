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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for BridgeGlobalPublishCountry. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.BridgeGlobalPublishCountryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishCountryLocalService
 * @see com.ihg.brandstandards.db.service.base.BridgeGlobalPublishCountryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.BridgeGlobalPublishCountryLocalServiceImpl
 * @generated
 */
public class BridgeGlobalPublishCountryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.BridgeGlobalPublishCountryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the bridge global publish country to the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	* @return the bridge global publish country that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry addBridgeGlobalPublishCountry(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addBridgeGlobalPublishCountry(bridgeGlobalPublishCountry);
	}

	/**
	* Creates a new bridge global publish country with the primary key. Does not add the bridge global publish country to the database.
	*
	* @param globalPublishCtryId the primary key for the new bridge global publish country
	* @return the new bridge global publish country
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry createBridgeGlobalPublishCountry(
		long globalPublishCtryId) {
		return getService().createBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	/**
	* Deletes the bridge global publish country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country that was removed
	* @throws PortalException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry deleteBridgeGlobalPublishCountry(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	/**
	* Deletes the bridge global publish country from the database. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	* @return the bridge global publish country that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry deleteBridgeGlobalPublishCountry(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteBridgeGlobalPublishCountry(bridgeGlobalPublishCountry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchBridgeGlobalPublishCountry(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	/**
	* Returns the bridge global publish country with the primary key.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country
	* @throws PortalException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getBridgeGlobalPublishCountry(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgeGlobalPublishCountry(globalPublishCtryId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getBridgeGlobalPublishCountries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgeGlobalPublishCountries(start, end);
	}

	/**
	* Returns the number of bridge global publish countries.
	*
	* @return the number of bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static int getBridgeGlobalPublishCountriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getBridgeGlobalPublishCountriesCount();
	}

	/**
	* Updates the bridge global publish country in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	* @return the bridge global publish country that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry updateBridgeGlobalPublishCountry(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateBridgeGlobalPublishCountry(bridgeGlobalPublishCountry);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getCountriesByGlobalPublishId(
		long bridgeGlobalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCountriesByGlobalPublishId(bridgeGlobalPublishId);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getCountriesByGlobalPublishIdAndCountryCode(
		long bridgeGlobalPublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCountriesByGlobalPublishIdAndCountryCode(bridgeGlobalPublishId,
			countryCode);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static void clearService() {
		_service = null;
	}

	public static BridgeGlobalPublishCountryLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					BridgeGlobalPublishCountryLocalService.class.getName());

			if (invokableLocalService instanceof BridgeGlobalPublishCountryLocalService) {
				_service = (BridgeGlobalPublishCountryLocalService)invokableLocalService;
			}
			else {
				_service = new BridgeGlobalPublishCountryLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(BridgeGlobalPublishCountryLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(BridgeGlobalPublishCountryLocalService service) {
	}

	private static BridgeGlobalPublishCountryLocalService _service;
}