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

package com.ihg.brandstandards.db.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserPreferenceLocalService}.
 *
 * @author Mummanedi
 * @see UserPreferenceLocalService
 * @generated
 */
public class UserPreferenceLocalServiceWrapper
	implements UserPreferenceLocalService,
		ServiceWrapper<UserPreferenceLocalService> {
	public UserPreferenceLocalServiceWrapper(
		UserPreferenceLocalService userPreferenceLocalService) {
		_userPreferenceLocalService = userPreferenceLocalService;
	}

	/**
	* Adds the user preference to the database. Also notifies the appropriate model listeners.
	*
	* @param userPreference the user preference
	* @return the user preference that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserPreference addUserPreference(
		com.ihg.brandstandards.db.model.UserPreference userPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.addUserPreference(userPreference);
	}

	/**
	* Creates a new user preference with the primary key. Does not add the user preference to the database.
	*
	* @param preferenceId the primary key for the new user preference
	* @return the new user preference
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserPreference createUserPreference(
		long preferenceId) {
		return _userPreferenceLocalService.createUserPreference(preferenceId);
	}

	/**
	* Deletes the user preference with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference that was removed
	* @throws PortalException if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserPreference deleteUserPreference(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.deleteUserPreference(preferenceId);
	}

	/**
	* Deletes the user preference from the database. Also notifies the appropriate model listeners.
	*
	* @param userPreference the user preference
	* @return the user preference that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserPreference deleteUserPreference(
		com.ihg.brandstandards.db.model.UserPreference userPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.deleteUserPreference(userPreference);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPreferenceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserPreferenceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.UserPreference fetchUserPreference(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.fetchUserPreference(preferenceId);
	}

	/**
	* Returns the user preference with the primary key.
	*
	* @param preferenceId the primary key of the user preference
	* @return the user preference
	* @throws PortalException if a user preference with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserPreference getUserPreference(
		long preferenceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.getUserPreference(preferenceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.UserPreference> getUserPreferences(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.getUserPreferences(start, end);
	}

	/**
	* Returns the number of user preferences.
	*
	* @return the number of user preferences
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserPreferencesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.getUserPreferencesCount();
	}

	/**
	* Updates the user preference in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userPreference the user preference
	* @return the user preference that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserPreference updateUserPreference(
		com.ihg.brandstandards.db.model.UserPreference userPreference)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.updateUserPreference(userPreference);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userPreferenceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userPreferenceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userPreferenceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public void clearCache() {
		_userPreferenceLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.UserPreference getUserPreferencesByUserId(
		long userId, java.lang.String moduleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.getUserPreferencesByUserId(userId,
			moduleName);
	}

	@Override
	public long getUserPreferencePK()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userPreferenceLocalService.getUserPreferencePK();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserPreferenceLocalService getWrappedUserPreferenceLocalService() {
		return _userPreferenceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserPreferenceLocalService(
		UserPreferenceLocalService userPreferenceLocalService) {
		_userPreferenceLocalService = userPreferenceLocalService;
	}

	@Override
	public UserPreferenceLocalService getWrappedService() {
		return _userPreferenceLocalService;
	}

	@Override
	public void setWrappedService(
		UserPreferenceLocalService userPreferenceLocalService) {
		_userPreferenceLocalService = userPreferenceLocalService;
	}

	private UserPreferenceLocalService _userPreferenceLocalService;
}