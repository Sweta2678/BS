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

import com.ihg.brandstandards.db.model.BridgePublishLang;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the bridge publish lang service. This utility wraps {@link BridgePublishLangPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishLangPersistence
 * @see BridgePublishLangPersistenceImpl
 * @generated
 */
public class BridgePublishLangUtil {
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
	public static void clearCache(BridgePublishLang bridgePublishLang) {
		getPersistence().clearCache(bridgePublishLang);
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
	public static List<BridgePublishLang> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BridgePublishLang> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BridgePublishLang> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static BridgePublishLang update(BridgePublishLang bridgePublishLang)
		throws SystemException {
		return getPersistence().update(bridgePublishLang);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static BridgePublishLang update(
		BridgePublishLang bridgePublishLang, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(bridgePublishLang, serviceContext);
	}

	/**
	* Returns all the bridge publish langs where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findByRegion(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRegion(publishId, regionId);
	}

	/**
	* Returns a range of all the bridge publish langs where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publish langs
	* @param end the upper bound of the range of bridge publish langs (not inclusive)
	* @return the range of matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findByRegion(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRegion(publishId, regionId, start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish langs where publishId = &#63; and regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param start the lower bound of the range of bridge publish langs
	* @param end the upper bound of the range of bridge publish langs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findByRegion(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRegion(publishId, regionId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish lang
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang findByRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRegion_First(publishId, regionId, orderByComparator);
	}

	/**
	* Returns the first bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegion_First(publishId, regionId, orderByComparator);
	}

	/**
	* Returns the last bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish lang
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang findByRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRegion_Last(publishId, regionId, orderByComparator);
	}

	/**
	* Returns the last bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegion_Last(publishId, regionId, orderByComparator);
	}

	/**
	* Returns the bridge publish langs before and after the current bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishLangId the primary key of the current bridge publish lang
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish lang
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang[] findByRegion_PrevAndNext(
		long publishLangId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRegion_PrevAndNext(publishLangId, publishId,
			regionId, orderByComparator);
	}

	/**
	* Removes all the bridge publish langs where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRegion(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRegion(publishId, regionId);
	}

	/**
	* Returns the number of bridge publish langs where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRegion(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRegion(publishId, regionId);
	}

	/**
	* Returns the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishLangException} if it could not be found.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @return the matching bridge publish lang
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang findByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRegionAndLocale(publishId, regionId, localeCode);
	}

	/**
	* Returns the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @return the matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegionAndLocale(publishId, regionId, localeCode);
	}

	/**
	* Returns the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRegionAndLocale(publishId, regionId, localeCode,
			retrieveFromCache);
	}

	/**
	* Removes the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @return the bridge publish lang that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang removeByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .removeByRegionAndLocale(publishId, regionId, localeCode);
	}

	/**
	* Returns the number of bridge publish langs where publishId = &#63; and regionId = &#63; and localeCode = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @return the number of matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRegionAndLocale(long publishId, long regionId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByRegionAndLocale(publishId, regionId, localeCode);
	}

	/**
	* Caches the bridge publish lang in the entity cache if it is enabled.
	*
	* @param bridgePublishLang the bridge publish lang
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishLang bridgePublishLang) {
		getPersistence().cacheResult(bridgePublishLang);
	}

	/**
	* Caches the bridge publish langs in the entity cache if it is enabled.
	*
	* @param bridgePublishLangs the bridge publish langs
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> bridgePublishLangs) {
		getPersistence().cacheResult(bridgePublishLangs);
	}

	/**
	* Creates a new bridge publish lang with the primary key. Does not add the bridge publish lang to the database.
	*
	* @param publishLangId the primary key for the new bridge publish lang
	* @return the new bridge publish lang
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang create(
		long publishLangId) {
		return getPersistence().create(publishLangId);
	}

	/**
	* Removes the bridge publish lang with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishLangId the primary key of the bridge publish lang
	* @return the bridge publish lang that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang remove(
		long publishLangId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishLangId);
	}

	public static com.ihg.brandstandards.db.model.BridgePublishLang updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishLang bridgePublishLang)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(bridgePublishLang);
	}

	/**
	* Returns the bridge publish lang with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishLangException} if it could not be found.
	*
	* @param publishLangId the primary key of the bridge publish lang
	* @return the bridge publish lang
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang findByPrimaryKey(
		long publishLangId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishLangId);
	}

	/**
	* Returns the bridge publish lang with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishLangId the primary key of the bridge publish lang
	* @return the bridge publish lang, or <code>null</code> if a bridge publish lang with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.BridgePublishLang fetchByPrimaryKey(
		long publishLangId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishLangId);
	}

	/**
	* Returns all the bridge publish langs.
	*
	* @return the bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the bridge publish langs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish langs
	* @param end the upper bound of the range of bridge publish langs (not inclusive)
	* @return the range of bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the bridge publish langs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish langs
	* @param end the upper bound of the range of bridge publish langs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the bridge publish langs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of bridge publish langs.
	*
	* @return the number of bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static BridgePublishLangPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (BridgePublishLangPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishLangPersistence.class.getName());

			ReferenceRegistry.registerReference(BridgePublishLangUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(BridgePublishLangPersistence persistence) {
	}

	private static BridgePublishLangPersistence _persistence;
}