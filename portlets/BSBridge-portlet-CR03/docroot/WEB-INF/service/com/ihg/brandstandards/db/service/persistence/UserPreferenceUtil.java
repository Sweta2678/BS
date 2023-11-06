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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the user preference service. This utility wraps {@link UserPreferencePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UserPreferencePersistence
 * @see UserPreferencePersistenceImpl
 * @generated
 */
public class UserPreferenceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(UserPreference userPreference) {
		getPersistence().clearCache(userPreference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserPreference> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UserPreference update(UserPreference userPreference)
		throws SystemException {
		return getPersistence().update(userPreference);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UserPreference update(UserPreference userPreference,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(userPreference, serviceContext);
	}

	/**
	* Returns the user preference where preferenceId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	*
	* @param preferenceId the preference ID
	* @return the matching user preference
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference findBypreferenceId(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBypreferenceId(preferenceId);
	}

	/**
	* Returns the user preference where preferenceId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param preferenceId the preference ID
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference fetchBypreferenceId(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBypreferenceId(preferenceId);
	}

	/**
	* Returns the user preference where preferenceId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param preferenceId the preference ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference fetchBypreferenceId(
		long preferenceId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBypreferenceId(preferenceId, retrieveFromCache);
	}

	/**
	* Removes the user preference where preferenceId = &#63; from the database.
	*
	* @param preferenceId the preference ID
	* @return the user preference that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference removeBypreferenceId(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBypreferenceId(preferenceId);
	}

	/**
	* Returns the number of user preferences where preferenceId = &#63;.
	*
	* @param preferenceId the preference ID
	* @return the number of matching user preferences
	* @throws SystemException if a system exception occurred
	*/
	public static int countBypreferenceId(long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBypreferenceId(preferenceId);
	}

	/**
	* Returns the user preference where userId = &#63; and moduleName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the matching user preference
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference findByUserIdAndModule(
		long userId, java.lang.String moduleName)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndModule(userId, moduleName);
	}

	/**
	* Returns the user preference where userId = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference fetchByUserIdAndModule(
		long userId, java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserIdAndModule(userId, moduleName);
	}

	/**
	* Returns the user preference where userId = &#63; and moduleName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching user preference, or <code>null</code> if a matching user preference could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference fetchByUserIdAndModule(
		long userId, java.lang.String moduleName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndModule(userId, moduleName, retrieveFromCache);
	}

	/**
	* Removes the user preference where userId = &#63; and moduleName = &#63; from the database.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the user preference that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference removeByUserIdAndModule(
		long userId, java.lang.String moduleName)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUserIdAndModule(userId, moduleName);
	}

	/**
	* Returns the number of user preferences where userId = &#63; and moduleName = &#63;.
	*
	* @param userId the user ID
	* @param moduleName the module name
	* @return the number of matching user preferences
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndModule(long userId,
		java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndModule(userId, moduleName);
	}

	/**
	* Caches the user preference in the entity cache if it is enabled.
	*
	* @param userPreference the user preference
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.UserPreference userPreference) {
		getPersistence().cacheResult(userPreference);
	}

	/**
	* Caches the user preferences in the entity cache if it is enabled.
	*
	* @param userPreferences the user preferences
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.UserPreference> userPreferences) {
		getPersistence().cacheResult(userPreferences);
	}

	/**
	* Creates a new user preference with the primary key. Does not add the user preference to the database.
	*
	* @param preferenceId the primary key for the new user preference
	* @return the new user preference
	*/
	public static com.ihg.brandstandards.db.model.UserPreference create(
		long preferenceId) {
		return getPersistence().create(preferenceId);
	}

	/**
	* Removes the user preference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference that was removed
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference remove(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(preferenceId);
	}

	public static com.ihg.brandstandards.db.model.UserPreference updateImpl(
		com.ihg.brandstandards.db.model.UserPreference userPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(userPreference);
	}

	/**
	* Returns the user preference with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUserPreferenceException} if it could not be found.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference
	* @throws com.ihg.brandstandards.db.NoSuchUserPreferenceException if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference findByPrimaryKey(
		long preferenceId)
		throws com.ihg.brandstandards.db.NoSuchUserPreferenceException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(preferenceId);
	}

	/**
	* Returns the user preference with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference, or <code>null</code> if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.UserPreference fetchByPrimaryKey(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(preferenceId);
	}

	/**
	* Returns all the user preferences.
	*
	* @return the user preferences
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.UserPreference> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.UserPreference> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.UserPreference> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the user preferences from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of user preferences.
	*
	* @return the number of user preferences
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UserPreferencePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UserPreferencePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					UserPreferencePersistence.class.getName());

			ReferenceRegistry.registerReference(UserPreferenceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UserPreferencePersistence persistence) {
	}

	private static UserPreferencePersistence _persistence;
}