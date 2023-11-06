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

import com.ihg.brandstandards.db.model.StandardsRegionLocale;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the standards region locale service. This utility wraps {@link StandardsRegionLocalePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionLocalePersistence
 * @see StandardsRegionLocalePersistenceImpl
 * @generated
 */
public class StandardsRegionLocaleUtil {
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
	public static void clearCache(StandardsRegionLocale standardsRegionLocale) {
		getPersistence().clearCache(standardsRegionLocale);
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
	public static List<StandardsRegionLocale> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StandardsRegionLocale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StandardsRegionLocale> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static StandardsRegionLocale update(
		StandardsRegionLocale standardsRegionLocale) throws SystemException {
		return getPersistence().update(standardsRegionLocale);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static StandardsRegionLocale update(
		StandardsRegionLocale standardsRegionLocale,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(standardsRegionLocale, serviceContext);
	}

	/**
	* Returns all the standards region locales where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the matching standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionLocale> findByregionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByregionId(regionId);
	}

	/**
	* Returns a range of all the standards region locales where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of standards region locales
	* @param end the upper bound of the range of standards region locales (not inclusive)
	* @return the range of matching standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionLocale> findByregionId(
		long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByregionId(regionId, start, end);
	}

	/**
	* Returns an ordered range of all the standards region locales where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of standards region locales
	* @param end the upper bound of the range of standards region locales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionLocale> findByregionId(
		long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByregionId(regionId, start, end, orderByComparator);
	}

	/**
	* Returns the first standards region locale in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards region locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale findByregionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByregionId_First(regionId, orderByComparator);
	}

	/**
	* Returns the first standards region locale in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale fetchByregionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByregionId_First(regionId, orderByComparator);
	}

	/**
	* Returns the last standards region locale in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards region locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale findByregionId_Last(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByregionId_Last(regionId, orderByComparator);
	}

	/**
	* Returns the last standards region locale in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale fetchByregionId_Last(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByregionId_Last(regionId, orderByComparator);
	}

	/**
	* Returns the standards region locales before and after the current standards region locale in the ordered set where regionId = &#63;.
	*
	* @param standardsRegionLocalePK the primary key of the current standards region locale
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards region locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale[] findByregionId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK standardsRegionLocalePK,
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByregionId_PrevAndNext(standardsRegionLocalePK,
			regionId, orderByComparator);
	}

	/**
	* Removes all the standards region locales where regionId = &#63; from the database.
	*
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByregionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByregionId(regionId);
	}

	/**
	* Returns the number of standards region locales where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the number of matching standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static int countByregionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByregionId(regionId);
	}

	/**
	* Returns the standards region locale where isDefault = &#63; and regionId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException} if it could not be found.
	*
	* @param isDefault the is default
	* @param regionId the region ID
	* @return the matching standards region locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale findByregionIdIsDefault(
		java.lang.String isDefault, long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByregionIdIsDefault(isDefault, regionId);
	}

	/**
	* Returns the standards region locale where isDefault = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param isDefault the is default
	* @param regionId the region ID
	* @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale fetchByregionIdIsDefault(
		java.lang.String isDefault, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByregionIdIsDefault(isDefault, regionId);
	}

	/**
	* Returns the standards region locale where isDefault = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param isDefault the is default
	* @param regionId the region ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale fetchByregionIdIsDefault(
		java.lang.String isDefault, long regionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByregionIdIsDefault(isDefault, regionId,
			retrieveFromCache);
	}

	/**
	* Removes the standards region locale where isDefault = &#63; and regionId = &#63; from the database.
	*
	* @param isDefault the is default
	* @param regionId the region ID
	* @return the standards region locale that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale removeByregionIdIsDefault(
		java.lang.String isDefault, long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByregionIdIsDefault(isDefault, regionId);
	}

	/**
	* Returns the number of standards region locales where isDefault = &#63; and regionId = &#63;.
	*
	* @param isDefault the is default
	* @param regionId the region ID
	* @return the number of matching standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static int countByregionIdIsDefault(java.lang.String isDefault,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByregionIdIsDefault(isDefault, regionId);
	}

	/**
	* Returns the standards region locale where localeCode = &#63; and regionId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException} if it could not be found.
	*
	* @param localeCode the locale code
	* @param regionId the region ID
	* @return the matching standards region locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale findBylocaleCodeRegionId(
		java.lang.String localeCode, long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBylocaleCodeRegionId(localeCode, regionId);
	}

	/**
	* Returns the standards region locale where localeCode = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param localeCode the locale code
	* @param regionId the region ID
	* @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale fetchBylocaleCodeRegionId(
		java.lang.String localeCode, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBylocaleCodeRegionId(localeCode, regionId);
	}

	/**
	* Returns the standards region locale where localeCode = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param localeCode the locale code
	* @param regionId the region ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale fetchBylocaleCodeRegionId(
		java.lang.String localeCode, long regionId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBylocaleCodeRegionId(localeCode, regionId,
			retrieveFromCache);
	}

	/**
	* Removes the standards region locale where localeCode = &#63; and regionId = &#63; from the database.
	*
	* @param localeCode the locale code
	* @param regionId the region ID
	* @return the standards region locale that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale removeBylocaleCodeRegionId(
		java.lang.String localeCode, long regionId)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBylocaleCodeRegionId(localeCode, regionId);
	}

	/**
	* Returns the number of standards region locales where localeCode = &#63; and regionId = &#63;.
	*
	* @param localeCode the locale code
	* @param regionId the region ID
	* @return the number of matching standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static int countBylocaleCodeRegionId(java.lang.String localeCode,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBylocaleCodeRegionId(localeCode, regionId);
	}

	/**
	* Caches the standards region locale in the entity cache if it is enabled.
	*
	* @param standardsRegionLocale the standards region locale
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.StandardsRegionLocale standardsRegionLocale) {
		getPersistence().cacheResult(standardsRegionLocale);
	}

	/**
	* Caches the standards region locales in the entity cache if it is enabled.
	*
	* @param standardsRegionLocales the standards region locales
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsRegionLocale> standardsRegionLocales) {
		getPersistence().cacheResult(standardsRegionLocales);
	}

	/**
	* Creates a new standards region locale with the primary key. Does not add the standards region locale to the database.
	*
	* @param standardsRegionLocalePK the primary key for the new standards region locale
	* @return the new standards region locale
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale create(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK standardsRegionLocalePK) {
		return getPersistence().create(standardsRegionLocalePK);
	}

	/**
	* Removes the standards region locale with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param standardsRegionLocalePK the primary key of the standards region locale
	* @return the standards region locale that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale remove(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK standardsRegionLocalePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(standardsRegionLocalePK);
	}

	public static com.ihg.brandstandards.db.model.StandardsRegionLocale updateImpl(
		com.ihg.brandstandards.db.model.StandardsRegionLocale standardsRegionLocale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(standardsRegionLocale);
	}

	/**
	* Returns the standards region locale with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException} if it could not be found.
	*
	* @param standardsRegionLocalePK the primary key of the standards region locale
	* @return the standards region locale
	* @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK standardsRegionLocalePK)
		throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(standardsRegionLocalePK);
	}

	/**
	* Returns the standards region locale with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param standardsRegionLocalePK the primary key of the standards region locale
	* @return the standards region locale, or <code>null</code> if a standards region locale with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.StandardsRegionLocale fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK standardsRegionLocalePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(standardsRegionLocalePK);
	}

	/**
	* Returns all the standards region locales.
	*
	* @return the standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionLocale> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the standards region locales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards region locales
	* @param end the upper bound of the range of standards region locales (not inclusive)
	* @return the range of standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionLocale> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the standards region locales.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards region locales
	* @param end the upper bound of the range of standards region locales (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsRegionLocale> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the standards region locales from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of standards region locales.
	*
	* @return the number of standards region locales
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StandardsRegionLocalePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StandardsRegionLocalePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsRegionLocalePersistence.class.getName());

			ReferenceRegistry.registerReference(StandardsRegionLocaleUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StandardsRegionLocalePersistence persistence) {
	}

	private static StandardsRegionLocalePersistence _persistence;
}