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

import com.ihg.brandstandards.db.model.UniqueGroupCountry;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the unique group country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroupCountryPersistenceImpl
 * @see UniqueGroupCountryUtil
 * @generated
 */
public interface UniqueGroupCountryPersistence extends BasePersistence<UniqueGroupCountry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UniqueGroupCountryUtil} to access the unique group country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the unique group country in the entity cache if it is enabled.
	*
	* @param uniqueGroupCountry the unique group country
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.UniqueGroupCountry uniqueGroupCountry);

	/**
	* Caches the unique group countries in the entity cache if it is enabled.
	*
	* @param uniqueGroupCountries the unique group countries
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.UniqueGroupCountry> uniqueGroupCountries);

	/**
	* Creates a new unique group country with the primary key. Does not add the unique group country to the database.
	*
	* @param groupCountryId the primary key for the new unique group country
	* @return the new unique group country
	*/
	public com.ihg.brandstandards.db.model.UniqueGroupCountry create(
		long groupCountryId);

	/**
	* Removes the unique group country with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupCountryId the primary key of the unique group country
	* @return the unique group country that was removed
	* @throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException if a unique group country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UniqueGroupCountry remove(
		long groupCountryId)
		throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.UniqueGroupCountry updateImpl(
		com.ihg.brandstandards.db.model.UniqueGroupCountry uniqueGroupCountry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unique group country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException} if it could not be found.
	*
	* @param groupCountryId the primary key of the unique group country
	* @return the unique group country
	* @throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException if a unique group country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UniqueGroupCountry findByPrimaryKey(
		long groupCountryId)
		throws com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unique group country with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupCountryId the primary key of the unique group country
	* @return the unique group country, or <code>null</code> if a unique group country with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UniqueGroupCountry fetchByPrimaryKey(
		long groupCountryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the unique group countries.
	*
	* @return the unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UniqueGroupCountry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the unique group countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unique group countries
	* @param end the upper bound of the range of unique group countries (not inclusive)
	* @return the range of unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UniqueGroupCountry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the unique group countries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unique group countries
	* @param end the upper bound of the range of unique group countries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UniqueGroupCountry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the unique group countries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of unique group countries.
	*
	* @return the number of unique group countries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}