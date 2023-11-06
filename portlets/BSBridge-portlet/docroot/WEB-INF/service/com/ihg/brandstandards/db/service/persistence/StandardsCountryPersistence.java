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

import com.ihg.brandstandards.db.model.StandardsCountry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the standards country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryPersistenceImpl
 * @see StandardsCountryUtil
 * @generated
 */
public interface StandardsCountryPersistence extends BasePersistence<StandardsCountry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StandardsCountryUtil} to access the standards country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the standards countries where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the matching standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> findByRegionId(
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards countries where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of standards countries
	* @param end the upper bound of the range of standards countries (not inclusive)
	* @return the range of matching standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> findByRegionId(
		long regionId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards countries where regionId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param regionId the region ID
	* @param start the lower bound of the range of standards countries
	* @param end the upper bound of the range of standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> findByRegionId(
		long regionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards country in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a matching standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry findByRegionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first standards country in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching standards country, or <code>null</code> if a matching standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry fetchByRegionId_First(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards country in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a matching standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry findByRegionId_Last(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last standards country in the ordered set where regionId = &#63;.
	*
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching standards country, or <code>null</code> if a matching standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry fetchByRegionId_Last(
		long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards countries before and after the current standards country in the ordered set where regionId = &#63;.
	*
	* @param countryNameCode the primary key of the current standards country
	* @param regionId the region ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next standards country
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry[] findByRegionId_PrevAndNext(
		java.lang.String countryNameCode, long regionId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards countries where regionId = &#63; from the database.
	*
	* @param regionId the region ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByRegionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards countries where regionId = &#63;.
	*
	* @param regionId the region ID
	* @return the number of matching standards countries
	* @throws SystemException if a system exception occurred
	*/
	public int countByRegionId(long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the standards country in the entity cache if it is enabled.
	*
	* @param standardsCountry the standards country
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.StandardsCountry standardsCountry);

	/**
	* Caches the standards countries in the entity cache if it is enabled.
	*
	* @param standardsCountries the standards countries
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> standardsCountries);

	/**
	* Creates a new standards country with the primary key. Does not add the standards country to the database.
	*
	* @param countryNameCode the primary key for the new standards country
	* @return the new standards country
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry create(
		java.lang.String countryNameCode);

	/**
	* Removes the standards country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param countryNameCode the primary key of the standards country
	* @return the standards country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry remove(
		java.lang.String countryNameCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsCountry updateImpl(
		com.ihg.brandstandards.db.model.StandardsCountry standardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsCountryException} if it could not be found.
	*
	* @param countryNameCode the primary key of the standards country
	* @return the standards country
	* @throws com.ihg.brandstandards.db.NoSuchStandardsCountryException if a standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry findByPrimaryKey(
		java.lang.String countryNameCode)
		throws com.ihg.brandstandards.db.NoSuchStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the standards country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param countryNameCode the primary key of the standards country
	* @return the standards country, or <code>null</code> if a standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.StandardsCountry fetchByPrimaryKey(
		java.lang.String countryNameCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the standards countries.
	*
	* @return the standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards countries
	* @param end the upper bound of the range of standards countries (not inclusive)
	* @return the range of standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of standards countries
	* @param end the upper bound of the range of standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.StandardsCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the standards countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of standards countries.
	*
	* @return the number of standards countries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}