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

import com.ihg.brandstandards.db.model.StandardsLocale;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards locale service. This utility wraps {@link StandardsLocalePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsLocalePersistence
 * @see StandardsLocalePersistenceImpl
 * @generated
 */
public class StandardsLocaleUtil {
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
	public static void clearCache(StandardsLocale standardsLocale) {
		getPersistence().clearCache(standardsLocale);
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
	public static List<StandardsLocale> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsLocale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsLocale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsLocale update(StandardsLocale standardsLocale)
		throws SystemException {
		return getPersistence().update(standardsLocale);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsLocale update(StandardsLocale standardsLocale,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsLocale, serviceContext);
	}

	/**
	* Returns the standards locale where localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsLocaleException} if it could not be found.
	*
	* @param localeCode the locale code
	* @return the matching standards locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a matching standards locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale findBylocaleCode(
		java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylocaleCode(localeCode);
	}

	/**
	* Returns the standards locale where localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param localeCode the locale code
	* @return the matching standards locale, or <code>null</code> if a matching standards locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale fetchBylocaleCode(
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylocaleCode(localeCode);
	}

	/**
	* Returns the standards locale where localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param localeCode the locale code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards locale, or <code>null</code> if a matching standards locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale fetchBylocaleCode(
		java.lang.String localeCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylocaleCode(localeCode, retrieveFromCache);
	}

	/**
	* Removes the standards locale where localeCode = &#63; from the database.
	*
	* @param localeCode the locale code
	* @return the standards locale that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale removeBylocaleCode(
		java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBylocaleCode(localeCode);
	}

	/**
	* Returns the number of standards locales where localeCode = &#63;.
	*
	* @param localeCode the locale code
	* @return the number of matching standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylocaleCode(java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylocaleCode(localeCode);
	}

	/**
	* Returns all the standards locales where isActive = &#63;.
	*
	* @param isActive the is active
	* @return the matching standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> findByActiveStatus(
		java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActiveStatus(isActive);
	}

	/**
	* Returns a range of all the standards locales where isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isActive the is active
	* @param start the lower bound of the range of standards locales
	* @param end the upper bound of the range of standards locales (not inclusive)
	* @return the range of matching standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> findByActiveStatus(
		java.lang.String isActive, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByActiveStatus(isActive, start, end);
	}

	/**
	* Returns an ordered range of all the standards locales where isActive = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param isActive the is active
	* @param start the lower bound of the range of standards locales
	* @param end the upper bound of the range of standards locales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> findByActiveStatus(
		java.lang.String isActive, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveStatus(isActive, start, end, orderByComparator);
	}

	/**
	* Returns the first standards locale in the ordered set where isActive = &#63;.
	*
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a matching standards locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale findByActiveStatus_First(
		java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveStatus_First(isActive, orderByComparator);
	}

	/**
	* Returns the first standards locale in the ordered set where isActive = &#63;.
	*
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards locale, or <code>null</code> if a matching standards locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale fetchByActiveStatus_First(
		java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveStatus_First(isActive, orderByComparator);
	}

	/**
	* Returns the last standards locale in the ordered set where isActive = &#63;.
	*
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a matching standards locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale findByActiveStatus_Last(
		java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveStatus_Last(isActive, orderByComparator);
	}

	/**
	* Returns the last standards locale in the ordered set where isActive = &#63;.
	*
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards locale, or <code>null</code> if a matching standards locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale fetchByActiveStatus_Last(
		java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByActiveStatus_Last(isActive, orderByComparator);
	}

	/**
	* Returns the standards locales before and after the current standards locale in the ordered set where isActive = &#63;.
	*
	* @param localeCode the primary key of the current standards locale
	* @param isActive the is active
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale[] findByActiveStatus_PrevAndNext(
		java.lang.String localeCode, java.lang.String isActive,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByActiveStatus_PrevAndNext(localeCode, isActive,
			orderByComparator);
	}

	/**
	* Removes all the standards locales where isActive = &#63; from the database.
	*
	* @param isActive the is active
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByActiveStatus(java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByActiveStatus(isActive);
	}

	/**
	* Returns the number of standards locales where isActive = &#63;.
	*
	* @param isActive the is active
	* @return the number of matching standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static int countByActiveStatus(java.lang.String isActive)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByActiveStatus(isActive);
	}

	/**
	* Caches the standards locale in the entity cache if it is enabled.
	*
	* @param standardsLocale the standards locale
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsLocale standardsLocale) {
		getPersistence().cacheResult(standardsLocale);
	}

	/**
	* Caches the standards locales in the entity cache if it is enabled.
	*
	* @param standardsLocales the standards locales
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> standardsLocales) {
		getPersistence().cacheResult(standardsLocales);
	}

	/**
	* Creates a new standards locale with the primary key. Does not add the standards locale to the database.
	*
	* @param localeCode the primary key for the new standards locale
	* @return the new standards locale
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale create(
		java.lang.String localeCode) {
		return getPersistence().create(localeCode);
	}

	/**
	* Removes the standards locale with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param localeCode the primary key of the standards locale
	* @return the standards locale that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale remove(
		java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(localeCode);
	}

	public static com.ihg.brandstandards.db.model.StandardsLocale updateImpl(
		com.ihg.brandstandards.db.model.StandardsLocale standardsLocale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsLocale);
	}

	/**
	* Returns the standards locale with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsLocaleException} if it could not be found.
	*
	* @param localeCode the primary key of the standards locale
	* @return the standards locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale findByPrimaryKey(
		java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(localeCode);
	}

	/**
	* Returns the standards locale with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param localeCode the primary key of the standards locale
	* @return the standards locale, or <code>null</code> if a standards locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsLocale fetchByPrimaryKey(
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(localeCode);
	}

	/**
	* Returns all the standards locales.
	*
	* @return the standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards locales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards locales
	* @param end the upper bound of the range of standards locales (not inclusive)
	* @return the range of standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards locales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards locales
	* @param end the upper bound of the range of standards locales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards locales from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards locales.
	*
	* @return the number of standards locales
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsLocalePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsLocalePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsLocalePersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsLocaleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsLocalePersistence persistence) {
	}

	private static StandardsLocalePersistence _persistence;
}