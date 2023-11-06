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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the bridge global publish country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishCountryPersistenceImpl
 * @see BridgeGlobalPublishCountryUtil
 * @generated
 */
public interface BridgeGlobalPublishCountryPersistence extends BasePersistence<BridgeGlobalPublishCountry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BridgeGlobalPublishCountryUtil} to access the bridge global publish country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the bridge global publish countries where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @return the matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByGlobalPublishId_First(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishId_First(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByGlobalPublishId_Last(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last bridge global publish country in the ordered set where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishId_Last(
		long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry[] findByGlobalPublishId_PrevAndNext(
		long globalPublishCtryId, long globalPublishId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge global publish countries where globalPublishId = &#63; from the database.
	*
	* @param globalPublishId the global publish ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGlobalPublishId(long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge global publish countries where globalPublishId = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @return the number of matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGlobalPublishId(long globalPublishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException} if it could not be found.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the matching bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; from the database.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the bridge global publish country that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry removeByGlobalPublishIdAndCountryCode(
		long globalPublishId, java.lang.String countryCode)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge global publish countries where globalPublishId = &#63; and countryCode = &#63;.
	*
	* @param globalPublishId the global publish ID
	* @param countryCode the country code
	* @return the number of matching bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public int countByGlobalPublishIdAndCountryCode(long globalPublishId,
		java.lang.String countryCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the bridge global publish country in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublishCountry the bridge global publish country
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry);

	/**
	* Caches the bridge global publish countries in the entity cache if it is enabled.
	*
	* @param bridgeGlobalPublishCountries the bridge global publish countries
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> bridgeGlobalPublishCountries);

	/**
	* Creates a new bridge global publish country with the primary key. Does not add the bridge global publish country to the database.
	*
	* @param globalPublishCtryId the primary key for the new bridge global publish country
	* @return the new bridge global publish country
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry create(
		long globalPublishCtryId);

	/**
	* Removes the bridge global publish country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry remove(
		long globalPublishCtryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry updateImpl(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException} if it could not be found.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country
	* @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry findByPrimaryKey(
		long globalPublishCtryId)
		throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bridge global publish country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param globalPublishCtryId the primary key of the bridge global publish country
	* @return the bridge global publish country, or <code>null</code> if a bridge global publish country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry fetchByPrimaryKey(
		long globalPublishCtryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the bridge global publish countries.
	*
	* @return the bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the bridge global publish countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bridge global publish countries.
	*
	* @return the number of bridge global publish countries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}