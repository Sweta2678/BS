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
 * Provides a wrapper for {@link ErrNotificationLocalService}.
 *
 * @author Mummanedi
 * @see ErrNotificationLocalService
 * @generated
 */
public class ErrNotificationLocalServiceWrapper
	implements ErrNotificationLocalService,
		ServiceWrapper<ErrNotificationLocalService> {
	public ErrNotificationLocalServiceWrapper(
		ErrNotificationLocalService errNotificationLocalService) {
		_errNotificationLocalService = errNotificationLocalService;
	}

	/**
	* Adds the err notification to the database. Also notifies the appropriate model listeners.
	*
	* @param errNotification the err notification
	* @return the err notification that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ErrNotification addErrNotification(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.addErrNotification(errNotification);
	}

	/**
	* Creates a new err notification with the primary key. Does not add the err notification to the database.
	*
	* @param notificationId the primary key for the new err notification
	* @return the new err notification
	*/
	@Override
	public com.ihg.brandstandards.db.model.ErrNotification createErrNotification(
		long notificationId) {
		return _errNotificationLocalService.createErrNotification(notificationId);
	}

	/**
	* Deletes the err notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification that was removed
	* @throws PortalException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ErrNotification deleteErrNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.deleteErrNotification(notificationId);
	}

	/**
	* Deletes the err notification from the database. Also notifies the appropriate model listeners.
	*
	* @param errNotification the err notification
	* @return the err notification that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ErrNotification deleteErrNotification(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.deleteErrNotification(errNotification);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _errNotificationLocalService.dynamicQuery();
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
		return _errNotificationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _errNotificationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _errNotificationLocalService.dynamicQuery(dynamicQuery, start,
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
		return _errNotificationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _errNotificationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.brandstandards.db.model.ErrNotification fetchErrNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.fetchErrNotification(notificationId);
	}

	/**
	* Returns the err notification with the primary key.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification
	* @throws PortalException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ErrNotification getErrNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.getErrNotification(notificationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the err notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @return the range of err notifications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getErrNotifications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.getErrNotifications(start, end);
	}

	/**
	* Returns the number of err notifications.
	*
	* @return the number of err notifications
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getErrNotificationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.getErrNotificationsCount();
	}

	/**
	* Updates the err notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param errNotification the err notification
	* @return the err notification that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.brandstandards.db.model.ErrNotification updateErrNotification(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.updateErrNotification(errNotification);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _errNotificationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_errNotificationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _errNotificationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* Clear cache.
	*/
	@Override
	public void clearCache() {
		_errNotificationLocalService.clearCache();
	}

	/**
	* Find notifications.
	*
	* @param componentName
	* @param publishId
	* @param rgnId
	* @return List<ErrNotification>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getMessagesByComponentTypeAndPublication(
		java.lang.String componentName, long publishId, long rgnId) {
		return _errNotificationLocalService.getMessagesByComponentTypeAndPublication(componentName,
			publishId, rgnId);
	}

	/**
	* Find notifications.
	*
	* @param componentName
	* @param publishId
	* @param rgnId
	* @return List<ErrNotification>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getNotificationsByComponentNameAndReferenceId(
		java.lang.String componentName, long refId) {
		return _errNotificationLocalService.getNotificationsByComponentNameAndReferenceId(componentName,
			refId);
	}

	/**
	* Find new notifications for processing.
	*
	* @param componentName
	* @param publishId
	* @param rgnId
	* @return List<ErrNotification>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getNewNotificationsForProcessing(
		java.lang.String componentName, long refId, java.lang.String userId) {
		return _errNotificationLocalService.getNewNotificationsForProcessing(componentName,
			refId, userId);
	}

	/**
	* Find new notifications which are more then 1 hour old.
	*
	* @param componentName
	* @param publishId
	* @param rgnId
	* @return List<ErrNotification>
	*/
	@Override
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getUnprocessedNewNotifications(
		java.lang.String componentName) {
		return _errNotificationLocalService.getUnprocessedNewNotifications(componentName);
	}

	@Override
	public com.ihg.brandstandards.db.model.ErrNotification createErrNotificationOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _errNotificationLocalService.createErrNotificationOraSequence();
	}

	@Override
	public boolean acknowledgeNotifications(java.lang.String notifcationIds) {
		return _errNotificationLocalService.acknowledgeNotifications(notifcationIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ErrNotificationLocalService getWrappedErrNotificationLocalService() {
		return _errNotificationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedErrNotificationLocalService(
		ErrNotificationLocalService errNotificationLocalService) {
		_errNotificationLocalService = errNotificationLocalService;
	}

	@Override
	public ErrNotificationLocalService getWrappedService() {
		return _errNotificationLocalService;
	}

	@Override
	public void setWrappedService(
		ErrNotificationLocalService errNotificationLocalService) {
		_errNotificationLocalService = errNotificationLocalService;
	}

	private ErrNotificationLocalService _errNotificationLocalService;
}