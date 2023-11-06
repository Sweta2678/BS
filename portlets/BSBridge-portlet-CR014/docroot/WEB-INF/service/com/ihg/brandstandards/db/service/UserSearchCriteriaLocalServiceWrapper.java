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
 * Provides a wrapper for {@link UserSearchCriteriaLocalService}.
 *
 * @author Mummanedi
 * @see UserSearchCriteriaLocalService
 * @generated
 */
public class UserSearchCriteriaLocalServiceWrapper
	implements UserSearchCriteriaLocalService,
		ServiceWrapper<UserSearchCriteriaLocalService> {
	public UserSearchCriteriaLocalServiceWrapper(
		UserSearchCriteriaLocalService userSearchCriteriaLocalService) {
		_userSearchCriteriaLocalService = userSearchCriteriaLocalService;
	}

	/**
	* Adds the user search criteria to the database. Also notifies the appropriate model listeners.
	*
	* @param userSearchCriteria the user search criteria
	* @return the user search criteria that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria addUserSearchCriteria(
		com.ihg.brandstandards.db.model.UserSearchCriteria userSearchCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.addUserSearchCriteria(userSearchCriteria);
	}

	/**
	* Creates a new user search criteria with the primary key. Does not add the user search criteria to the database.
	*
	* @param userSearchId the primary key for the new user search criteria
	* @return the new user search criteria
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria createUserSearchCriteria(
		long userSearchId) {
		return _userSearchCriteriaLocalService.createUserSearchCriteria(userSearchId);
	}

	/**
	* Deletes the user search criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userSearchId the primary key of the user search criteria
	* @return the user search criteria that was removed
	* @throws PortalException if a user search criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria deleteUserSearchCriteria(
		long userSearchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.deleteUserSearchCriteria(userSearchId);
	}

	/**
	* Deletes the user search criteria from the database. Also notifies the appropriate model listeners.
	*
	* @param userSearchCriteria the user search criteria
	* @return the user search criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria deleteUserSearchCriteria(
		com.ihg.brandstandards.db.model.UserSearchCriteria userSearchCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.deleteUserSearchCriteria(userSearchCriteria);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userSearchCriteriaLocalService.dynamicQuery();
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
		return _userSearchCriteriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserSearchCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userSearchCriteriaLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UserSearchCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _userSearchCriteriaLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _userSearchCriteriaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _userSearchCriteriaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria fetchUserSearchCriteria(
		long userSearchId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.fetchUserSearchCriteria(userSearchId);
	}

	/**
	* Returns the user search criteria with the primary key.
	*
	* @param userSearchId the primary key of the user search criteria
	* @return the user search criteria
	* @throws PortalException if a user search criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria getUserSearchCriteria(
		long userSearchId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.getUserSearchCriteria(userSearchId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.UserSearchCriteria> getUserSearchCriterias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.getUserSearchCriterias(start, end);
	}

	/**
	* Returns the number of user search criterias.
	*
	* @return the number of user search criterias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getUserSearchCriteriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.getUserSearchCriteriasCount();
	}

	/**
	* Updates the user search criteria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param userSearchCriteria the user search criteria
	* @return the user search criteria that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria updateUserSearchCriteria(
		com.ihg.brandstandards.db.model.UserSearchCriteria userSearchCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.updateUserSearchCriteria(userSearchCriteria);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _userSearchCriteriaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_userSearchCriteriaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _userSearchCriteriaLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public void clearCache() {
		_userSearchCriteriaLocalService.clearCache();
	}

	@Override
	public com.ihg.brandstandards.db.model.UserSearchCriteria getSearchCriteriaBySearchName(
		long userId, java.lang.String searchName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userSearchCriteriaLocalService.getSearchCriteriaBySearchName(userId,
			searchName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public UserSearchCriteriaLocalService getWrappedUserSearchCriteriaLocalService() {
		return _userSearchCriteriaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedUserSearchCriteriaLocalService(
		UserSearchCriteriaLocalService userSearchCriteriaLocalService) {
		_userSearchCriteriaLocalService = userSearchCriteriaLocalService;
	}

	@Override
	public UserSearchCriteriaLocalService getWrappedService() {
		return _userSearchCriteriaLocalService;
	}

	@Override
	public void setWrappedService(
		UserSearchCriteriaLocalService userSearchCriteriaLocalService) {
		_userSearchCriteriaLocalService = userSearchCriteriaLocalService;
	}

	private UserSearchCriteriaLocalService _userSearchCriteriaLocalService;
}