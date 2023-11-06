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

import com.ihg.brandstandards.db.model.BridgePublishCountry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge publish country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishCountryPersistenceImpl
 * @see BridgePublishCountryUtil
 * @generated
 */
public interface BridgePublishCountryPersistence extends BasePersistence<BridgePublishCountry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgePublishCountryUtil} to access the bridge publish country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bridge publish countries where bridgePublishId = &#63;.
	*
	* @param bridgePublishId the bridge publish ID
	* @return the matching bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountry> findByPublishId(
		long bridgePublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish countries where bridgePublishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bridgePublishId the bridge publish ID
	* @param start the lower bound of the range of bridge publish countries
	* @param end the upper bound of the range of bridge publish countries (not inclusive)
	* @return the range of matching bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountry> findByPublishId(
		long bridgePublishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish countries where bridgePublishId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bridgePublishId the bridge publish ID
	* @param start the lower bound of the range of bridge publish countries
	* @param end the upper bound of the range of bridge publish countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountry> findByPublishId(
		long bridgePublishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish country in the ordered set where bridgePublishId = &#63;.
	*
	* @param bridgePublishId the bridge publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a matching bridge publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry findByPublishId_First(
		long bridgePublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge publish country in the ordered set where bridgePublishId = &#63;.
	*
	* @param bridgePublishId the bridge publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry fetchByPublishId_First(
		long bridgePublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish country in the ordered set where bridgePublishId = &#63;.
	*
	* @param bridgePublishId the bridge publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a matching bridge publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry findByPublishId_Last(
		long bridgePublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge publish country in the ordered set where bridgePublishId = &#63;.
	*
	* @param bridgePublishId the bridge publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry fetchByPublishId_Last(
		long bridgePublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish countries before and after the current bridge publish country in the ordered set where bridgePublishId = &#63;.
	*
	* @param publishCtryId the primary key of the current bridge publish country
	* @param bridgePublishId the bridge publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next bridge publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry[] findByPublishId_PrevAndNext(
		long publishCtryId, long bridgePublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish countries where bridgePublishId = &#63; from the database.
	*
	* @param bridgePublishId the bridge publish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishId(long bridgePublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish countries where bridgePublishId = &#63;.
	*
	* @param bridgePublishId the bridge publish ID
	* @return the number of matching bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishId(long bridgePublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishCountryException} if it could not be found.
	*
	* @param bridgePublishId the bridge publish ID
	* @param countryCode the country code
	* @return the matching bridge publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a matching bridge publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry findByBridgePublishIdAndCountryCode(
		long bridgePublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param bridgePublishId the bridge publish ID
	* @param countryCode the country code
	* @return the matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry fetchByBridgePublishIdAndCountryCode(
		long bridgePublishId, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param bridgePublishId the bridge publish ID
	* @param countryCode the country code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry fetchByBridgePublishIdAndCountryCode(
		long bridgePublishId, java.lang.String countryCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; from the database.
	*
	* @param bridgePublishId the bridge publish ID
	* @param countryCode the country code
	* @return the bridge publish country that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry removeByBridgePublishIdAndCountryCode(
		long bridgePublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish countries where bridgePublishId = &#63; and countryCode = &#63;.
	*
	* @param bridgePublishId the bridge publish ID
	* @param countryCode the country code
	* @return the number of matching bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public int countByBridgePublishIdAndCountryCode(long bridgePublishId,
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge publish country in the entity cache if it is enabled.
	*
	* @param bridgePublishCountry the bridge publish country
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgePublishCountry bridgePublishCountry);

	/**
	* Caches the bridge publish countries in the entity cache if it is enabled.
	*
	* @param bridgePublishCountries the bridge publish countries
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountry> bridgePublishCountries);

	/**
	* Creates a new bridge publish country with the primary key. Does not add the bridge publish country to the database.
	*
	* @param publishCtryId the primary key for the new bridge publish country
	* @return the new bridge publish country
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry create(
		long publishCtryId);

	/**
	* Removes the bridge publish country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishCtryId the primary key of the bridge publish country
	* @return the bridge publish country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry remove(
		long publishCtryId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublishCountry updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishCountry bridgePublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishCountryException} if it could not be found.
	*
	* @param publishCtryId the primary key of the bridge publish country
	* @return the bridge publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry findByPrimaryKey(
		long publishCtryId)
		throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge publish country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishCtryId the primary key of the bridge publish country
	* @return the bridge publish country, or <code>null</code> if a bridge publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgePublishCountry fetchByPrimaryKey(
		long publishCtryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge publish countries.
	*
	* @return the bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the bridge publish countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish countries
	* @param end the upper bound of the range of bridge publish countries (not inclusive)
	* @return the range of bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the bridge publish countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bridge publish countries
	* @param end the upper bound of the range of bridge publish countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgePublishCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge publish countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge publish countries.
	*
	* @return the number of bridge publish countries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}