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

import com.ihg.brandstandards.db.model.CountryStandardsExt;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the country standards ext service. This utility wraps {@link CountryStandardsExtPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see CountryStandardsExtPersistence
 * @see CountryStandardsExtPersistenceImpl
 * @generated
 */
public class CountryStandardsExtUtil {
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
	public static void clearCache(CountryStandardsExt countryStandardsExt) {
		getPersistence().clearCache(countryStandardsExt);
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
	public static List<CountryStandardsExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CountryStandardsExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CountryStandardsExt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CountryStandardsExt update(
		CountryStandardsExt countryStandardsExt) throws SystemException {
		return getPersistence().update(countryStandardsExt);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CountryStandardsExt update(
		CountryStandardsExt countryStandardsExt, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(countryStandardsExt, serviceContext);
	}

	/**
	* Caches the country standards ext in the entity cache if it is enabled.
	*
	* @param countryStandardsExt the country standards ext
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.CountryStandardsExt countryStandardsExt) {
		getPersistence().cacheResult(countryStandardsExt);
	}

	/**
	* Caches the country standards exts in the entity cache if it is enabled.
	*
	* @param countryStandardsExts the country standards exts
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.CountryStandardsExt> countryStandardsExts) {
		getPersistence().cacheResult(countryStandardsExts);
	}

	/**
	* Creates a new country standards ext with the primary key. Does not add the country standards ext to the database.
	*
	* @param countryStandardsExtPK the primary key for the new country standards ext
	* @return the new country standards ext
	*/
	public static com.ihg.brandstandards.db.model.CountryStandardsExt create(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK) {
		return getPersistence().create(countryStandardsExtPK);
	}

	/**
	* Removes the country standards ext with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandardsExtPK the primary key of the country standards ext
	* @return the country standards ext that was removed
	* @throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException if a country standards ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.CountryStandardsExt remove(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK)
		throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(countryStandardsExtPK);
	}

	public static com.ihg.brandstandards.db.model.CountryStandardsExt updateImpl(
		com.ihg.brandstandards.db.model.CountryStandardsExt countryStandardsExt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(countryStandardsExt);
	}

	/**
	* Returns the country standards ext with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchCountryStandardsExtException} if it could not be found.
	*
	* @param countryStandardsExtPK the primary key of the country standards ext
	* @return the country standards ext
	* @throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException if a country standards ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.CountryStandardsExt findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK)
		throws com.ihg.brandstandards.db.NoSuchCountryStandardsExtException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(countryStandardsExtPK);
	}

	/**
	* Returns the country standards ext with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param countryStandardsExtPK the primary key of the country standards ext
	* @return the country standards ext, or <code>null</code> if a country standards ext with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.CountryStandardsExt fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK countryStandardsExtPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(countryStandardsExtPK);
	}

	/**
	* Returns all the country standards exts.
	*
	* @return the country standards exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.CountryStandardsExt> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.CountryStandardsExt> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the country standards exts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of country standards exts
	* @param end the upper bound of the range of country standards exts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of country standards exts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.CountryStandardsExt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the country standards exts from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of country standards exts.
	*
	* @return the number of country standards exts
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CountryStandardsExtPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CountryStandardsExtPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					CountryStandardsExtPersistence.class.getName());

			ReferenceRegistry.registerReference(CountryStandardsExtUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CountryStandardsExtPersistence persistence) {
	}

	private static CountryStandardsExtPersistence _persistence;
}