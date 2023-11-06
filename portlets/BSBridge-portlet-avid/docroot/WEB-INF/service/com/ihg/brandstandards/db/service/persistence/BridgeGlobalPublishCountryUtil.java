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

import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bridge global publish country service. This utility wraps {@link BridgeGlobalPublishCountryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishCountryPersistence
 * @see BridgeGlobalPublishCountryPersistenceImpl
 * @generated
 */
public class BridgeGlobalPublishCountryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		getPersistence().clearCache(bridgeGlobalPublishCountry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BridgeGlobalPublishCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BridgeGlobalPublishCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BridgeGlobalPublishCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BridgeGlobalPublishCountry update(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws SystemException {
		return getPersistence().update(bridgeGlobalPublishCountry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BridgeGlobalPublishCountry update(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(bridgeGlobalPublishCountry, serviceContext);
	}

	/**
	* Returns all the bridge global publish countries where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @return the matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGlobalPublishId(globalPublishId);
	}

	/**
	* Returns a range of all the bridge global publish countries where globalPublishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param globalPublishId the global publish ID
	* @param start the lower bound of the range of bridge global publish countries
	* @param end the upper bound of the range of bridge global publish countries (not inclusive)
	* @return the range of matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalPublishId(globalPublishId, start, end);
	}

	/**
	* Returns an ordered range of all the bridge global publish countries where globalPublishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param globalPublishId the global publish ID
	* @param start the lower bound of the range of bridge global publish countries
	* @param end the upper bound of the range of bridge global publish countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalPublishId(globalPublishId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByGlobalPublishId_First(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalPublishId_First(globalPublishId,
			orderByComparator);
	}

	/**
	* Returns the first bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishId_First(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGlobalPublishId_First(globalPublishId,
			orderByComparator);
	}

	/**
	* Returns the last bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByGlobalPublishId_Last(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalPublishId_Last(globalPublishId,
			orderByComparator);
	}

	/**
	* Returns the last bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishId_Last(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGlobalPublishId_Last(globalPublishId,
			orderByComparator);
	}

	/**
	* Returns the bridge global publish countries before and after the current bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishCtryId the primary key of the current bridge global publish country
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry[] findByGlobalPublishId_PrevAndNext(
		long globalPublishCtryId, long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalPublishId_PrevAndNext(globalPublishCtryId,
			globalPublishId, orderByComparator);
	}

	/**
	* Removes all the bridge global publish countries where globalPublishId = &#63; from the database.
	*
	* @param globalPublishId the global publish ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGlobalPublishId(long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGlobalPublishId(globalPublishId);
	}

	/**
	* Returns the number of bridge global publish countries where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @return the number of matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGlobalPublishId(long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGlobalPublishId(globalPublishId);
	}

	/**
	* Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException} if it could not be found.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the matching bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGlobalPublishIdAndCountryCode(globalPublishId,
			countryCode);
	}

	/**
	* Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGlobalPublishIdAndCountryCode(globalPublishId,
			countryCode);
	}

	/**
	* Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByGlobalPublishIdAndCountryCode(globalPublishId,
			countryCode, retrieveFromCache);
	}

	/**
	* Removes the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; from the database.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the bridge global publish country that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry removeByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByGlobalPublishIdAndCountryCode(globalPublishId,
			countryCode);
	}

	/**
	* Returns the number of bridge global publish countries where globalPublishId = &#63; and countryCode = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the number of matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByGlobalPublishIdAndCountryCode(globalPublishId,
			countryCode);
	}

	/**
	* Caches the bridge global publish country in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		getPersistence().cacheResult(bridgeGlobalPublishCountry);
	}

	/**
	* Caches the bridge global publish countries in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublishCountries the bridge global publish countries
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> bridgeGlobalPublishCountries) {
		getPersistence().cacheResult(bridgeGlobalPublishCountries);
	}

	/**
	* Creates a new bridge global publish country with the primary key. Does not add the bridge global publish country to the database.
	*
	* @param globalPublishCtryId the primary key for the new bridge global publish country
	* @return the new bridge global publish country
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry create(
		long globalPublishCtryId) {
		return getPersistence().create(globalPublishCtryId);
	}

	/**
	* Removes the bridge global publish country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry remove(
		long globalPublishCtryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(globalPublishCtryId);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry updateImpl(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bridgeGlobalPublishCountry);
	}

	/**
	* Returns the bridge global publish country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException} if it could not be found.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByPrimaryKey(
		long globalPublishCtryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(globalPublishCtryId);
	}

	/**
	* Returns the bridge global publish country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country, or <code>null</code> if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByPrimaryKey(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(globalPublishCtryId);
	}

	/**
	* Returns all the bridge global publish countries.
	*
	* @return the bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bridge global publish countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge global publish countries
	* @param end the upper bound of the range of bridge global publish countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bridge global publish countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bridge global publish countries.
	*
	* @return the number of bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BridgeGlobalPublishCountryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BridgeGlobalPublishCountryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgeGlobalPublishCountryPersistence.class.getName());

			ReferenceRegistry.registerReference(BridgeGlobalPublishCountryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		BridgeGlobalPublishCountryPersistence persistence) {
	}

	private static BridgeGlobalPublishCountryPersistence _persistence;
}