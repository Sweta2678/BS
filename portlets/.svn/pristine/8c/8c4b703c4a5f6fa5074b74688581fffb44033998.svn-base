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

import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the external link standards country service. This utility wraps {@link ExternalLinkStandardsCountryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsCountryPersistence
 * @see ExternalLinkStandardsCountryPersistenceImpl
 * @generated
 */
public class ExternalLinkStandardsCountryUtil {
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
		ExternalLinkStandardsCountry externalLinkStandardsCountry) {
		getPersistence().clearCache(externalLinkStandardsCountry);
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
	public static List<ExternalLinkStandardsCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExternalLinkStandardsCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExternalLinkStandardsCountry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ExternalLinkStandardsCountry update(
		ExternalLinkStandardsCountry externalLinkStandardsCountry)
		throws SystemException {
		return getPersistence().update(externalLinkStandardsCountry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ExternalLinkStandardsCountry update(
		ExternalLinkStandardsCountry externalLinkStandardsCountry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(externalLinkStandardsCountry, serviceContext);
	}

	/**
	* Returns all the external link standards countries where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findByextLinkId(
		long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByextLinkId(extLinkId);
	}

	/**
	* Returns a range of all the external link standards countries where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @return the range of matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findByextLinkId(
		long extLinkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByextLinkId(extLinkId, start, end);
	}

	/**
	* Returns an ordered range of all the external link standards countries where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findByextLinkId(
		long extLinkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByextLinkId(extLinkId, start, end, orderByComparator);
	}

	/**
	* Returns the first external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry findByextLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByextLinkId_First(extLinkId, orderByComparator);
	}

	/**
	* Returns the first external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards country, or <code>null</code> if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry fetchByextLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByextLinkId_First(extLinkId, orderByComparator);
	}

	/**
	* Returns the last external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry findByextLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByextLinkId_Last(extLinkId, orderByComparator);
	}

	/**
	* Returns the last external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards country, or <code>null</code> if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry fetchByextLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByextLinkId_Last(extLinkId, orderByComparator);
	}

	/**
	* Returns the external link standards countries before and after the current external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param externalLinkStandardsCountryPK the primary key of the current external link standards country
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry[] findByextLinkId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK,
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByextLinkId_PrevAndNext(externalLinkStandardsCountryPK,
			extLinkId, orderByComparator);
	}

	/**
	* Removes all the external link standards countries where extLinkId = &#63; from the database.
	*
	* @param extLinkId the ext link ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByextLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByextLinkId(extLinkId);
	}

	/**
	* Returns the number of external link standards countries where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the number of matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByextLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByextLinkId(extLinkId);
	}

	/**
	* Caches the external link standards country in the entity cache if it is enabled.
	*
	* @param externalLinkStandardsCountry the external link standards country
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry externalLinkStandardsCountry) {
		getPersistence().cacheResult(externalLinkStandardsCountry);
	}

	/**
	* Caches the external link standards countries in the entity cache if it is enabled.
	*
	* @param externalLinkStandardsCountries the external link standards countries
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> externalLinkStandardsCountries) {
		getPersistence().cacheResult(externalLinkStandardsCountries);
	}

	/**
	* Creates a new external link standards country with the primary key. Does not add the external link standards country to the database.
	*
	* @param externalLinkStandardsCountryPK the primary key for the new external link standards country
	* @return the new external link standards country
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry create(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK) {
		return getPersistence().create(externalLinkStandardsCountryPK);
	}

	/**
	* Removes the external link standards country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param externalLinkStandardsCountryPK the primary key of the external link standards country
	* @return the external link standards country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry remove(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(externalLinkStandardsCountryPK);
	}

	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry updateImpl(
		com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry externalLinkStandardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(externalLinkStandardsCountry);
	}

	/**
	* Returns the external link standards country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException} if it could not be found.
	*
	* @param externalLinkStandardsCountryPK the primary key of the external link standards country
	* @return the external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(externalLinkStandardsCountryPK);
	}

	/**
	* Returns the external link standards country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param externalLinkStandardsCountryPK the primary key of the external link standards country
	* @return the external link standards country, or <code>null</code> if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(externalLinkStandardsCountryPK);
	}

	/**
	* Returns all the external link standards countries.
	*
	* @return the external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the external link standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @return the range of external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the external link standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the external link standards countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of external link standards countries.
	*
	* @return the number of external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ExternalLinkStandardsCountryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ExternalLinkStandardsCountryPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ExternalLinkStandardsCountryPersistence.class.getName());

			ReferenceRegistry.registerReference(ExternalLinkStandardsCountryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(
		ExternalLinkStandardsCountryPersistence persistence) {
	}

	private static ExternalLinkStandardsCountryPersistence _persistence;
}