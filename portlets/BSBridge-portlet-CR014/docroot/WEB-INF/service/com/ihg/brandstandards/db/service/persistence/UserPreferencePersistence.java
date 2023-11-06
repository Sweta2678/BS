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

import com.ihg.brandstandards.db.model.UserPreference;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the user preference service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UserPreferencePersistenceImpl
 * @see UserPreferenceUtil
 * @generated
 */
public interface UserPreferencePersistence extends BasePersistence<UserPreference> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserPreferenceUtil} to access the user preference persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the user preference where preferenceId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	*
	* @param preferenceId the preference ID
	* @return the matching user preference
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference findBypreferenceId(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user preference where preferenceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param preferenceId the preference ID
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference fetchBypreferenceId(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user preference where preferenceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param preferenceId the preference ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference fetchBypreferenceId(
		long preferenceId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user preference where preferenceId = &#63; from the database.
	*
	* @param preferenceId the preference ID
	* @return the user preference that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference removeBypreferenceId(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user preferences where preferenceId = &#63;.
	*
	* @param preferenceId the preference ID
	* @return the number of matching user preferences
	* @throws SystemException if a system exception occurred
	*/
	public int countBypreferenceId(long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user preference where userId = &#63; and moduleName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the matching user preference
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference findByUserIdAndModule(
		long userId, java.lang.String moduleName)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user preference where userId = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference fetchByUserIdAndModule(
		long userId, java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user preference where userId = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference fetchByUserIdAndModule(
		long userId, java.lang.String moduleName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the user preference where userId = &#63; and moduleName = &#63; from the database.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the user preference that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference removeByUserIdAndModule(
		long userId, java.lang.String moduleName)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user preferences where userId = &#63; and moduleName = &#63;.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the number of matching user preferences
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndModule(long userId, java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the user preference in the entity cache if it is enabled.
	*
	* @param userPreference the user preference
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.UserPreference userPreference);

	/**
	* Caches the user preferences in the entity cache if it is enabled.
	*
	* @param userPreferences the user preferences
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.UserPreference> userPreferences);

	/**
	* Creates a new user preference with the primary key. Does not add the user preference to the database.
	*
	* @param preferenceId the primary key for the new user preference
	* @return the new user preference
	*/
	public com.ihg.brandstandards.db.model.UserPreference create(
		long preferenceId);

	/**
	* Removes the user preference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference that was removed
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference remove(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.UserPreference updateImpl(
		com.ihg.brandstandards.db.model.UserPreference userPreference)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user preference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference findByPrimaryKey(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the user preference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference, or <code>null</code> if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.UserPreference fetchByPrimaryKey(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the user preferences.
	*
	* @return the user preferences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UserPreference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the user preferences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user preferences
	* @param end the upper bound of the range of user preferences (not inclusive)
	* @return the range of user preferences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UserPreference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the user preferences.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of user preferences
	* @param end the upper bound of the range of user preferences (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of user preferences
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.UserPreference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the user preferences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of user preferences.
	*
	* @return the number of user preferences
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}