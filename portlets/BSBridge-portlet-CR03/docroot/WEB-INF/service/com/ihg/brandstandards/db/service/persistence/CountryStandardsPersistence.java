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

import com.ihg.brandstandards.db.model.CountryStandards;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the country standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see CountryStandardsPersistenceImpl
 * @see CountryStandardsUtil
 * @generated
 */
public interface CountryStandardsPersistence extends BasePersistence<CountryStandards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CountryStandardsUtil} to access the country standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the country standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the matching country standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> findByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the country standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of country standardses
	* @param end the upper bound of the range of country standardses (not inclusive)
	* @return the range of matching country standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> findByStdId(
		long stdId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the country standardses where stdId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param stdId the std ID
	* @param start the lower bound of the range of country standardses
	* @param end the upper bound of the range of country standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching country standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> findByStdId(
		long stdId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first country standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching country standards
	* @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a matching country standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards findByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchCountryStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first country standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching country standards, or <code>null</code> if a matching country standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards fetchByStdId_First(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last country standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching country standards
	* @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a matching country standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards findByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchCountryStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last country standards in the ordered set where stdId = &#63;.
	*
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching country standards, or <code>null</code> if a matching country standards could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards fetchByStdId_Last(
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the country standardses before and after the current country standards in the ordered set where stdId = &#63;.
	*
	* @param countryStandardsPK the primary key of the current country standards
	* @param stdId the std ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next country standards
	* @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards[] findByStdId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK,
		long stdId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchCountryStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the country standardses where stdId = &#63; from the database.
	*
	* @param stdId the std ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of country standardses where stdId = &#63;.
	*
	* @param stdId the std ID
	* @return the number of matching country standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the country standards in the entity cache if it is enabled.
	*
	* @param countryStandards the country standards
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.CountryStandards countryStandards);

	/**
	* Caches the country standardses in the entity cache if it is enabled.
	*
	* @param countryStandardses the country standardses
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.CountryStandards> countryStandardses);

	/**
	* Creates a new country standards with the primary key. Does not add the country standards to the database.
	*
	* @param countryStandardsPK the primary key for the new country standards
	* @return the new country standards
	*/
	public com.ihg.brandstandards.db.model.CountryStandards create(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK);

	/**
	* Removes the country standards with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryStandardsPK the primary key of the country standards
	* @return the country standards that was removed
	* @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards remove(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchCountryStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.CountryStandards updateImpl(
		com.ihg.brandstandards.db.model.CountryStandards countryStandards)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the country standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchCountryStandardsException} if it could not be found.
	*
	* @param countryStandardsPK the primary key of the country standards
	* @return the country standards
	* @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK)
		throws com.ihg.brandstandards.db.NoSuchCountryStandardsException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the country standards with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param countryStandardsPK the primary key of the country standards
	* @return the country standards, or <code>null</code> if a country standards with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.CountryStandards fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK countryStandardsPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the country standardses.
	*
	* @return the country standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the country standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of country standardses
	* @param end the upper bound of the range of country standardses (not inclusive)
	* @return the range of country standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the country standardses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of country standardses
	* @param end the upper bound of the range of country standardses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of country standardses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.CountryStandards> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the country standardses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of country standardses.
	*
	* @return the number of country standardses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}