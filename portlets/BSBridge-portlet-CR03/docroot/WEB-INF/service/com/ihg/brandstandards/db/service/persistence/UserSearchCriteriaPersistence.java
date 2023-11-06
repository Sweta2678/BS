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

import com.ihg.brandstandards.db.model.UserSearchCriteria;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user search criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UserSearchCriteriaPersistenceImpl
 * @see UserSearchCriteriaUtil
 * @generated
 */
public interface UserSearchCriteriaPersistence extends BasePersistence<UserSearchCriteria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserSearchCriteriaUtil} to access the user search criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user search criteria where creatorId = &#63; and searchName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException} if it could not be found.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the matching user search criteria
	* @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a matching user search criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria findBySearchName(
		java.lang.String creatorId, java.lang.String searchName)
		throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria fetchBySearchName(
		java.lang.String creatorId, java.lang.String searchName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria fetchBySearchName(
		java.lang.String creatorId, java.lang.String searchName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user search criteria where creatorId = &#63; and searchName = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the user search criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria removeBySearchName(
		java.lang.String creatorId, java.lang.String searchName)
		throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user search criterias where creatorId = &#63; and searchName = &#63;.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the number of matching user search criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countBySearchName(java.lang.String creatorId,
		java.lang.String searchName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user search criteria where creatorId = &#63; and searchName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException} if it could not be found.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the matching user search criteria
	* @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a matching user search criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria findBySearchNameCreatorId(
		java.lang.String creatorId, java.lang.String searchName)
		throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria fetchBySearchNameCreatorId(
		java.lang.String creatorId, java.lang.String searchName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user search criteria where creatorId = &#63; and searchName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user search criteria, or <code>null</code> if a matching user search criteria could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria fetchBySearchNameCreatorId(
		java.lang.String creatorId, java.lang.String searchName,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user search criteria where creatorId = &#63; and searchName = &#63; from the database.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the user search criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria removeBySearchNameCreatorId(
		java.lang.String creatorId, java.lang.String searchName)
		throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user search criterias where creatorId = &#63; and searchName = &#63;.
	*
	* @param creatorId the creator ID
	* @param searchName the search name
	* @return the number of matching user search criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countBySearchNameCreatorId(java.lang.String creatorId,
		java.lang.String searchName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user search criteria in the entity cache if it is enabled.
	*
	* @param userSearchCriteria the user search criteria
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.UserSearchCriteria userSearchCriteria);

	/**
	* Caches the user search criterias in the entity cache if it is enabled.
	*
	* @param userSearchCriterias the user search criterias
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.UserSearchCriteria> userSearchCriterias);

	/**
	* Creates a new user search criteria with the primary key. Does not add the user search criteria to the database.
	*
	* @param userSearchId the primary key for the new user search criteria
	* @return the new user search criteria
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria create(
		long userSearchId);

	/**
	* Removes the user search criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSearchId the primary key of the user search criteria
	* @return the user search criteria that was removed
	* @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a user search criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria remove(
		long userSearchId)
		throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.UserSearchCriteria updateImpl(
		com.ihg.brandstandards.db.model.UserSearchCriteria userSearchCriteria)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user search criteria with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException} if it could not be found.
	*
	* @param userSearchId the primary key of the user search criteria
	* @return the user search criteria
	* @throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException if a user search criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria findByPrimaryKey(
		long userSearchId)
		throws com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user search criteria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userSearchId the primary key of the user search criteria
	* @return the user search criteria, or <code>null</code> if a user search criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserSearchCriteria fetchByPrimaryKey(
		long userSearchId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user search criterias.
	*
	* @return the user search criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UserSearchCriteria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user search criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserSearchCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user search criterias
	* @param end the upper bound of the range of user search criterias (not inclusive)
	* @return the range of user search criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UserSearchCriteria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user search criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserSearchCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user search criterias
	* @param end the upper bound of the range of user search criterias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user search criterias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UserSearchCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user search criterias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user search criterias.
	*
	* @return the number of user search criterias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}