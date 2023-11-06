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

import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the external link standards country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsCountryPersistenceImpl
 * @see ExternalLinkStandardsCountryUtil
 * @generated
 */
public interface ExternalLinkStandardsCountryPersistence extends BasePersistence<ExternalLinkStandardsCountry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExternalLinkStandardsCountryUtil} to access the external link standards country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the external link standards countries where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findByextLinkId(
		long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standards countries where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @return the range of matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findByextLinkId(
		long extLinkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standards countries where extLinkId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param extLinkId the ext link ID
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findByextLinkId(
		long extLinkId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry findByextLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching external link standards country, or <code>null</code> if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry fetchByextLinkId_First(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry findByextLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching external link standards country, or <code>null</code> if a matching external link standards country could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry fetchByextLinkId_Last(
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standards countries before and after the current external link standards country in the ordered set where extLinkId = &#63;.
	*
	* @param externalLinkStandardsCountryPK the primary key of the current external link standards country
	* @param extLinkId the ext link ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry[] findByextLinkId_PrevAndNext(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK,
		long extLinkId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standards countries where extLinkId = &#63; from the database.
	*
	* @param extLinkId the ext link ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByextLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standards countries where extLinkId = &#63;.
	*
	* @param extLinkId the ext link ID
	* @return the number of matching external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public int countByextLinkId(long extLinkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the external link standards country in the entity cache if it is enabled.
	*
	* @param externalLinkStandardsCountry the external link standards country
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry externalLinkStandardsCountry);

	/**
	* Caches the external link standards countries in the entity cache if it is enabled.
	*
	* @param externalLinkStandardsCountries the external link standards countries
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> externalLinkStandardsCountries);

	/**
	* Creates a new external link standards country with the primary key. Does not add the external link standards country to the database.
	*
	* @param externalLinkStandardsCountryPK the primary key for the new external link standards country
	* @return the new external link standards country
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry create(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK);

	/**
	* Removes the external link standards country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param externalLinkStandardsCountryPK the primary key of the external link standards country
	* @return the external link standards country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry remove(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry updateImpl(
		com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry externalLinkStandardsCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standards country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException} if it could not be found.
	*
	* @param externalLinkStandardsCountryPK the primary key of the external link standards country
	* @return the external link standards country
	* @throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry findByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the external link standards country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param externalLinkStandardsCountryPK the primary key of the external link standards country
	* @return the external link standards country, or <code>null</code> if a external link standards country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry fetchByPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the external link standards countries.
	*
	* @return the external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the external link standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @return the range of external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the external link standards countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of external link standards countries
	* @param end the upper bound of the range of external link standards countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the external link standards countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of external link standards countries.
	*
	* @return the number of external link standards countries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}