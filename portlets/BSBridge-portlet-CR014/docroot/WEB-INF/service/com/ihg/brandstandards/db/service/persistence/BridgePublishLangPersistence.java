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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge publish lang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishLangPersistenceImpl
 * @see BridgePublishLangUtil
 * @generated
 */
public interface BridgePublishLangPersistence extends BasePersistence<BridgePublishLang> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishLangUtil} to access the bridge publish lang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bridge publish langs where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findByRegion(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findByRegion(
		long publishId, long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findByRegion(
		long publishId, long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.BridgePublishLang findByRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegion_First(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.BridgePublishLang findByRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegion_Last(
		long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.BridgePublishLang[] findByRegion_PrevAndNext(
		long publishLangId, long publishId, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish langs where publishId = &#63; and regionId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRegion(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish langs where publishId = &#63; and regionId = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @return the number of matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public int countByRegion(long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.BridgePublishLang findByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @return the matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.BridgePublishLang fetchByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; from the database.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @return the bridge publish lang that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang removeByRegionAndLocale(
		long publishId, long regionId, java.lang.String localeCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish langs where publishId = &#63; and regionId = &#63; and localeCode = &#63;.
	*
	* @param publishId the publish ID
	* @param regionId the region ID
	* @param localeCode the locale code
	* @return the number of matching bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public int countByRegionAndLocale(long publishId, long regionId,
		java.lang.String localeCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge publish lang in the entity cache if it is enabled.
	*
	* @param bridgePublishLang the bridge publish lang
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishLang bridgePublishLang);

	/**
	* Caches the bridge publish langs in the entity cache if it is enabled.
	*
	* @param bridgePublishLangs the bridge publish langs
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> bridgePublishLangs);

	/**
	* Creates a new bridge publish lang with the primary key. Does not add the bridge publish lang to the database.
	*
	* @param publishLangId the primary key for the new bridge publish lang
	* @return the new bridge publish lang
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang create(
		long publishLangId);

	/**
	* Removes the bridge publish lang with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishLangId the primary key of the bridge publish lang
	* @return the bridge publish lang that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang remove(
		long publishLangId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublishLang updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishLang bridgePublishLang)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish lang with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishLangException} if it could not be found.
	*
	* @param publishLangId the primary key of the bridge publish lang
	* @return the bridge publish lang
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang findByPrimaryKey(
		long publishLangId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish lang with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishLangId the primary key of the bridge publish lang
	* @return the bridge publish lang, or <code>null</code> if a bridge publish lang with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishLang fetchByPrimaryKey(
		long publishLangId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publish langs.
	*
	* @return the bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishLang> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish langs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish langs.
	*
	* @return the number of bridge publish langs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}