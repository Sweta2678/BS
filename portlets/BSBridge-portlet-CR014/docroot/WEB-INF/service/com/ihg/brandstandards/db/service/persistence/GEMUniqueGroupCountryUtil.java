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

import com.ihg.brandstandards.db.model.GEMUniqueGroupCountry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the g e m unique group country service. This utility wraps {@link GEMUniqueGroupCountryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMUniqueGroupCountryPersistence
 * @see GEMUniqueGroupCountryPersistenceImpl
 * @generated
 */
public class GEMUniqueGroupCountryUtil {
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
	public static void clearCache(GEMUniqueGroupCountry gemUniqueGroupCountry) {
		getPersistence().clearCache(gemUniqueGroupCountry);
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
	public static List<GEMUniqueGroupCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GEMUniqueGroupCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GEMUniqueGroupCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static GEMUniqueGroupCountry update(
		GEMUniqueGroupCountry gemUniqueGroupCountry) throws SystemException {
		return getPersistence().update(gemUniqueGroupCountry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static GEMUniqueGroupCountry update(
		GEMUniqueGroupCountry gemUniqueGroupCountry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(gemUniqueGroupCountry, serviceContext);
	}

	/**
	* Caches the g e m unique group country in the entity cache if it is enabled.
	*
	* @param gemUniqueGroupCountry the g e m unique group country
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.GEMUniqueGroupCountry gemUniqueGroupCountry) {
		getPersistence().cacheResult(gemUniqueGroupCountry);
	}

	/**
	* Caches the g e m unique group countries in the entity cache if it is enabled.
	*
	* @param gemUniqueGroupCountries the g e m unique group countries
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroupCountry> gemUniqueGroupCountries) {
		getPersistence().cacheResult(gemUniqueGroupCountries);
	}

	/**
	* Creates a new g e m unique group country with the primary key. Does not add the g e m unique group country to the database.
	*
	* @param groupCountryId the primary key for the new g e m unique group country
	* @return the new g e m unique group country
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroupCountry create(
		long groupCountryId) {
		return getPersistence().create(groupCountryId);
	}

	/**
	* Removes the g e m unique group country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupCountryId the primary key of the g e m unique group country
	* @return the g e m unique group country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException if a g e m unique group country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroupCountry remove(
		long groupCountryId)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(groupCountryId);
	}

	public static com.ihg.brandstandards.db.model.GEMUniqueGroupCountry updateImpl(
		com.ihg.brandstandards.db.model.GEMUniqueGroupCountry gemUniqueGroupCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(gemUniqueGroupCountry);
	}

	/**
	* Returns the g e m unique group country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException} if it could not be found.
	*
	* @param groupCountryId the primary key of the g e m unique group country
	* @return the g e m unique group country
	* @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException if a g e m unique group country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroupCountry findByPrimaryKey(
		long groupCountryId)
		throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(groupCountryId);
	}

	/**
	* Returns the g e m unique group country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupCountryId the primary key of the g e m unique group country
	* @return the g e m unique group country, or <code>null</code> if a g e m unique group country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.GEMUniqueGroupCountry fetchByPrimaryKey(
		long groupCountryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(groupCountryId);
	}

	/**
	* Returns all the g e m unique group countries.
	*
	* @return the g e m unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroupCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the g e m unique group countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m unique group countries
	* @param end the upper bound of the range of g e m unique group countries (not inclusive)
	* @return the range of g e m unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroupCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the g e m unique group countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m unique group countries
	* @param end the upper bound of the range of g e m unique group countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.GEMUniqueGroupCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the g e m unique group countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of g e m unique group countries.
	*
	* @return the number of g e m unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GEMUniqueGroupCountryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GEMUniqueGroupCountryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMUniqueGroupCountryPersistence.class.getName());

			ReferenceRegistry.registerReference(GEMUniqueGroupCountryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GEMUniqueGroupCountryPersistence persistence) {
	}

	private static GEMUniqueGroupCountryPersistence _persistence;
}