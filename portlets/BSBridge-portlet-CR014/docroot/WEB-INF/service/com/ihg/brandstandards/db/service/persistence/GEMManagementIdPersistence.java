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

import com.ihg.brandstandards.db.model.GEMManagementId;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the g e m management ID service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMManagementIdPersistenceImpl
 * @see GEMManagementIdUtil
 * @generated
 */
public interface GEMManagementIdPersistence extends BasePersistence<GEMManagementId> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GEMManagementIdUtil} to access the g e m management ID persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the g e m management ID where countryCode = &#63; and chainCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMManagementIdException} if it could not be found.
	*
	* @param countryCode the country code
	* @param chainCode the chain code
	* @return the matching g e m management ID
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a matching g e m management ID could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId findByCountryCodeAndChainCode(
		java.lang.String countryCode, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m management ID where countryCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param countryCode the country code
	* @param chainCode the chain code
	* @return the matching g e m management ID, or <code>null</code> if a matching g e m management ID could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId fetchByCountryCodeAndChainCode(
		java.lang.String countryCode, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m management ID where countryCode = &#63; and chainCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param countryCode the country code
	* @param chainCode the chain code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching g e m management ID, or <code>null</code> if a matching g e m management ID could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId fetchByCountryCodeAndChainCode(
		java.lang.String countryCode, java.lang.String chainCode,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the g e m management ID where countryCode = &#63; and chainCode = &#63; from the database.
	*
	* @param countryCode the country code
	* @param chainCode the chain code
	* @return the g e m management ID that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId removeByCountryCodeAndChainCode(
		java.lang.String countryCode, java.lang.String chainCode)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m management IDs where countryCode = &#63; and chainCode = &#63;.
	*
	* @param countryCode the country code
	* @param chainCode the chain code
	* @return the number of matching g e m management IDs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryCodeAndChainCode(java.lang.String countryCode,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the g e m management ID in the entity cache if it is enabled.
	*
	* @param gemManagementId the g e m management ID
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.GEMManagementId gemManagementId);

	/**
	* Caches the g e m management IDs in the entity cache if it is enabled.
	*
	* @param gemManagementIds the g e m management IDs
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.GEMManagementId> gemManagementIds);

	/**
	* Creates a new g e m management ID with the primary key. Does not add the g e m management ID to the database.
	*
	* @param managementId the primary key for the new g e m management ID
	* @return the new g e m management ID
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId create(
		long managementId);

	/**
	* Removes the g e m management ID with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param managementId the primary key of the g e m management ID
	* @return the g e m management ID that was removed
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a g e m management ID with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId remove(
		long managementId)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.GEMManagementId updateImpl(
		com.ihg.brandstandards.db.model.GEMManagementId gemManagementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m management ID with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMManagementIdException} if it could not be found.
	*
	* @param managementId the primary key of the g e m management ID
	* @return the g e m management ID
	* @throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException if a g e m management ID with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId findByPrimaryKey(
		long managementId)
		throws com.ihg.brandstandards.db.NoSuchGEMManagementIdException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the g e m management ID with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param managementId the primary key of the g e m management ID
	* @return the g e m management ID, or <code>null</code> if a g e m management ID with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.GEMManagementId fetchByPrimaryKey(
		long managementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the g e m management IDs.
	*
	* @return the g e m management IDs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementId> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the g e m management IDs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m management IDs
	* @param end the upper bound of the range of g e m management IDs (not inclusive)
	* @return the range of g e m management IDs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementId> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the g e m management IDs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementIdModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of g e m management IDs
	* @param end the upper bound of the range of g e m management IDs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of g e m management IDs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.GEMManagementId> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the g e m management IDs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of g e m management IDs.
	*
	* @return the number of g e m management IDs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}