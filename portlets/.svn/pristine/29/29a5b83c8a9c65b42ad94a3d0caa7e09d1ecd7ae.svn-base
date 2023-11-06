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

import com.ihg.brandstandards.db.model.ErrNotification;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the err notification service. This utility wraps {@link ErrNotificationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ErrNotificationPersistence
 * @see ErrNotificationPersistenceImpl
 * @generated
 */
public class ErrNotificationUtil {
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
	public static void clearCache(ErrNotification errNotification) {
		getPersistence().clearCache(errNotification);
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
	public static List<ErrNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ErrNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ErrNotification> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ErrNotification update(ErrNotification errNotification)
		throws SystemException {
		return getPersistence().update(errNotification);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ErrNotification update(ErrNotification errNotification,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(errNotification, serviceContext);
	}

	/**
	* Returns all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @return the matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycomponentNameAndPublishId(componentName, publishId,
			referenceId);
	}

	/**
	* Returns a range of all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @return the range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycomponentNameAndPublishId(componentName, publishId,
			referenceId, start, end);
	}

	/**
	* Returns an ordered range of all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycomponentNameAndPublishId(componentName, publishId,
			referenceId, start, end, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findBycomponentNameAndPublishId_First(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycomponentNameAndPublishId_First(componentName,
			publishId, referenceId, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchBycomponentNameAndPublishId_First(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycomponentNameAndPublishId_First(componentName,
			publishId, referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findBycomponentNameAndPublishId_Last(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycomponentNameAndPublishId_Last(componentName,
			publishId, referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchBycomponentNameAndPublishId_Last(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycomponentNameAndPublishId_Last(componentName,
			publishId, referenceId, orderByComparator);
	}

	/**
	* Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param notificationId the primary key of the current err notification
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification[] findBycomponentNameAndPublishId_PrevAndNext(
		long notificationId, java.lang.String componentName, long publishId,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycomponentNameAndPublishId_PrevAndNext(notificationId,
			componentName, publishId, referenceId, orderByComparator);
	}

	/**
	* Removes all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeBycomponentNameAndPublishId(componentName, publishId,
			referenceId);
	}

	/**
	* Returns the number of err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @return the number of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countBycomponentNameAndPublishId(componentName, publishId,
			referenceId);
	}

	/**
	* Returns all the err notifications where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @return the matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameAndReferenceId(componentName, referenceId);
	}

	/**
	* Returns a range of all the err notifications where componentName = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @return the range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameAndReferenceId(componentName,
			referenceId, start, end);
	}

	/**
	* Returns an ordered range of all the err notifications where componentName = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameAndReferenceId(componentName,
			referenceId, start, end, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findByComponentNameAndReferenceId_First(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameAndReferenceId_First(componentName,
			referenceId, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameAndReferenceId_First(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComponentNameAndReferenceId_First(componentName,
			referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findByComponentNameAndReferenceId_Last(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameAndReferenceId_Last(componentName,
			referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameAndReferenceId_Last(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComponentNameAndReferenceId_Last(componentName,
			referenceId, orderByComparator);
	}

	/**
	* Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	*
	* @param notificationId the primary key of the current err notification
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification[] findByComponentNameAndReferenceId_PrevAndNext(
		long notificationId, java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameAndReferenceId_PrevAndNext(notificationId,
			componentName, referenceId, orderByComparator);
	}

	/**
	* Removes all the err notifications where componentName = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByComponentNameAndReferenceId(componentName, referenceId);
	}

	/**
	* Returns the number of err notifications where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @return the number of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByComponentNameAndReferenceId(componentName,
			referenceId);
	}

	/**
	* Returns all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @return the matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusReferenceId(componentName, status,
			referenceId);
	}

	/**
	* Returns a range of all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @return the range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusReferenceId(componentName, status,
			referenceId, start, end);
	}

	/**
	* Returns an ordered range of all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusReferenceId(componentName, status,
			referenceId, start, end, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusReferenceId_First(componentName,
			status, referenceId, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComponentNameStatusReferenceId_First(componentName,
			status, referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusReferenceId_Last(componentName,
			status, referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComponentNameStatusReferenceId_Last(componentName,
			status, referenceId, orderByComparator);
	}

	/**
	* Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param notificationId the primary key of the current err notification
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification[] findByComponentNameStatusReferenceId_PrevAndNext(
		long notificationId, java.lang.String componentName,
		java.lang.String status, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusReferenceId_PrevAndNext(notificationId,
			componentName, status, referenceId, orderByComparator);
	}

	/**
	* Removes all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByComponentNameStatusReferenceId(componentName, status,
			referenceId);
	}

	/**
	* Returns the number of err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @return the number of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByComponentNameStatusReferenceId(componentName,
			status, referenceId);
	}

	/**
	* Returns all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @return the matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusUserReferenceId(componentName,
			status, creatorId, referenceId);
	}

	/**
	* Returns a range of all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @return the range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusUserReferenceId(componentName,
			status, creatorId, referenceId, start, end);
	}

	/**
	* Returns an ordered range of all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusUserReferenceId(componentName,
			status, creatorId, referenceId, start, end, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusUserReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusUserReferenceId_First(componentName,
			status, creatorId, referenceId, orderByComparator);
	}

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusUserReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComponentNameStatusUserReferenceId_First(componentName,
			status, creatorId, referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusUserReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusUserReferenceId_Last(componentName,
			status, creatorId, referenceId, orderByComparator);
	}

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusUserReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByComponentNameStatusUserReferenceId_Last(componentName,
			status, creatorId, referenceId, orderByComparator);
	}

	/**
	* Returns the err notifications before and after the current err notification in the ordered set where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* @param notificationId the primary key of the current err notification
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification[] findByComponentNameStatusUserReferenceId_PrevAndNext(
		long notificationId, java.lang.String componentName,
		java.lang.String status, java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByComponentNameStatusUserReferenceId_PrevAndNext(notificationId,
			componentName, status, creatorId, referenceId, orderByComparator);
	}

	/**
	* Removes all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByComponentNameStatusUserReferenceId(componentName, status,
			creatorId, referenceId);
	}

	/**
	* Returns the number of err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @return the number of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByComponentNameStatusUserReferenceId(componentName,
			status, creatorId, referenceId);
	}

	/**
	* Caches the err notification in the entity cache if it is enabled.
	*
	* @param errNotification the err notification
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.ErrNotification errNotification) {
		getPersistence().cacheResult(errNotification);
	}

	/**
	* Caches the err notifications in the entity cache if it is enabled.
	*
	* @param errNotifications the err notifications
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ErrNotification> errNotifications) {
		getPersistence().cacheResult(errNotifications);
	}

	/**
	* Creates a new err notification with the primary key. Does not add the err notification to the database.
	*
	* @param notificationId the primary key for the new err notification
	* @return the new err notification
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification create(
		long notificationId) {
		return getPersistence().create(notificationId);
	}

	/**
	* Removes the err notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification that was removed
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification remove(
		long notificationId)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(notificationId);
	}

	public static com.ihg.brandstandards.db.model.ErrNotification updateImpl(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(errNotification);
	}

	/**
	* Returns the err notification with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchErrNotificationException} if it could not be found.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification findByPrimaryKey(
		long notificationId)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(notificationId);
	}

	/**
	* Returns the err notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification, or <code>null</code> if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.ErrNotification fetchByPrimaryKey(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(notificationId);
	}

	/**
	* Returns all the err notifications.
	*
	* @return the err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the err notifications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ErrNotificationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of err notifications
	* @param end the upper bound of the range of err notifications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the err notifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of err notifications.
	*
	* @return the number of err notifications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ErrNotificationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ErrNotificationPersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ErrNotificationPersistence.class.getName());

			ReferenceRegistry.registerReference(ErrNotificationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ErrNotificationPersistence persistence) {
	}

	private static ErrNotificationPersistence _persistence;
}