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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for ErrNotification. This utility wraps
 * {@link com.ihg.brandstandards.db.service.impl.ErrNotificationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mummanedi
 * @see ErrNotificationLocalService
 * @see com.ihg.brandstandards.db.service.base.ErrNotificationLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.impl.ErrNotificationLocalServiceImpl
 * @generated
 */
public class ErrNotificationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.brandstandards.db.service.impl.ErrNotificationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the err notification to the database. Also notifies the appropriate model listeners.
	*
	* @param errNotification the err notification
	* @return the err notification that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification addErrNotification(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addErrNotification(errNotification);
	}

	/**
	* Creates a new err notification with the primary key. Does not add the err notification to the database.
	*
	* @param notificationId the primary key for the new err notification
	* @return the new err notification
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification createErrNotification(
		long notificationId) {
		return getService().createErrNotification(notificationId);
	}

	/**
	* Deletes the err notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification that was removed
	* @throws PortalException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification deleteErrNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteErrNotification(notificationId);
	}

	/**
	* Deletes the err notification from the database. Also notifies the appropriate model listeners.
	*
	* @param errNotification the err notification
	* @return the err notification that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification deleteErrNotification(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteErrNotification(errNotification);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.brandstandards.db.model.ErrNotification fetchErrNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchErrNotification(notificationId);
	}

	/**
	* Returns the err notification with the primary key.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification
	* @throws PortalException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification getErrNotification(
		long notificationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getErrNotification(notificationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getErrNotifications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getErrNotifications(start, end);
	}

	/**
	* Returns the number of err notifications.
	*
	* @return the number of err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int getErrNotificationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getErrNotificationsCount();
	}

	/**
	* Updates the err notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param errNotification the err notification
	* @return the err notification that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification updateErrNotification(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateErrNotification(errNotification);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Clear cache.
	*/
	public static void clearCache() {
		getService().clearCache();
	}

	/**
	* Find notifications.
	*
	* @param componentName
	* @param publishId
	* @param rgnId
	* @return List<ErrNotification>
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getMessagesByComponentTypeAndPublication(
		java.lang.String componentName, long publishId, long rgnId) {
		return getService()
				   .getMessagesByComponentTypeAndPublication(componentName,
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
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getNotificationsByComponentNameAndReferenceId(
		java.lang.String componentName, long refId) {
		return getService()
				   .getNotificationsByComponentNameAndReferenceId(componentName,
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
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getNewNotificationsForProcessing(
		java.lang.String componentName, long refId, java.lang.String userId) {
		return getService()
				   .getNewNotificationsForProcessing(componentName, refId,
			userId);
	}

	/**
	* Find new notifications which are more then 1 hour old.
	*
	* @param componentName
	* @param publishId
	* @param rgnId
	* @return List<ErrNotification>
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getUnprocessedNewNotifications(
		java.lang.String componentName) {
		return getService().getUnprocessedNewNotifications(componentName);
	}

	public static com.ihg.brandstandards.db.model.ErrNotification createErrNotificationOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().createErrNotificationOraSequence();
	}

	public static boolean acknowledgeNotifications(
		java.lang.String notifcationIds) {
		return getService().acknowledgeNotifications(notifcationIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static ErrNotificationLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ErrNotificationLocalService.class.getName());

			if (invokableLocalService instanceof ErrNotificationLocalService) {
				_service = (ErrNotificationLocalService)invokableLocalService;
			}
			else {
				_service = new ErrNotificationLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ErrNotificationLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(ErrNotificationLocalService service) {
	}

	private static ErrNotificationLocalService _service;
}