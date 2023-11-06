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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the err notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ErrNotificationPersistenceImpl
 * @see ErrNotificationUtil
 * @generated
 */
public interface ErrNotificationPersistence extends BasePersistence<ErrNotification> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ErrNotificationUtil} to access the err notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @return the matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findBycomponentNameAndPublishId_First(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification fetchBycomponentNameAndPublishId_First(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findBycomponentNameAndPublishId_Last(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification fetchBycomponentNameAndPublishId_Last(
		java.lang.String componentName, long publishId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification[] findBycomponentNameAndPublishId_PrevAndNext(
		long notificationId, java.lang.String componentName, long publishId,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of err notifications where componentName = &#63; and publishId = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param publishId the publish ID
	* @param referenceId the reference ID
	* @return the number of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public int countBycomponentNameAndPublishId(
		java.lang.String componentName, long publishId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the err notifications where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @return the matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findByComponentNameAndReferenceId_First(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameAndReferenceId_First(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findByComponentNameAndReferenceId_Last(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last err notification in the ordered set where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching err notification, or <code>null</code> if a matching err notification could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameAndReferenceId_Last(
		java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification[] findByComponentNameAndReferenceId_PrevAndNext(
		long notificationId, java.lang.String componentName, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the err notifications where componentName = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of err notifications where componentName = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param referenceId the reference ID
	* @return the number of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public int countByComponentNameAndReferenceId(
		java.lang.String componentName, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @return the matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification[] findByComponentNameStatusReferenceId_PrevAndNext(
		long notificationId, java.lang.String componentName,
		java.lang.String status, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the err notifications where componentName = &#63; and status = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of err notifications where componentName = &#63; and status = &#63; and referenceId = &#63;.
	*
	* @param componentName the component name
	* @param status the status
	* @param referenceId the reference ID
	* @return the number of matching err notifications
	* @throws SystemException if a system exception occurred
	*/
	public int countByComponentNameStatusReferenceId(
		java.lang.String componentName, java.lang.String status,
		long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusUserReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusUserReferenceId_First(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification findByComponentNameStatusUserReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification fetchByComponentNameStatusUserReferenceId_Last(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.ihg.brandstandards.db.model.ErrNotification[] findByComponentNameStatusUserReferenceId_PrevAndNext(
		long notificationId, java.lang.String componentName,
		java.lang.String status, java.lang.String creatorId, long referenceId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the err notifications where componentName = &#63; and status = &#63; and creatorId = &#63; and referenceId = &#63; from the database.
	*
	* @param componentName the component name
	* @param status the status
	* @param creatorId the creator ID
	* @param referenceId the reference ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByComponentNameStatusUserReferenceId(
		java.lang.String componentName, java.lang.String status,
		java.lang.String creatorId, long referenceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the err notification in the entity cache if it is enabled.
	*
	* @param errNotification the err notification
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.ErrNotification errNotification);

	/**
	* Caches the err notifications in the entity cache if it is enabled.
	*
	* @param errNotifications the err notifications
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.ErrNotification> errNotifications);

	/**
	* Creates a new err notification with the primary key. Does not add the err notification to the database.
	*
	* @param notificationId the primary key for the new err notification
	* @return the new err notification
	*/
	public com.ihg.brandstandards.db.model.ErrNotification create(
		long notificationId);

	/**
	* Removes the err notification with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification that was removed
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ErrNotification remove(
		long notificationId)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.ErrNotification updateImpl(
		com.ihg.brandstandards.db.model.ErrNotification errNotification)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the err notification with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchErrNotificationException} if it could not be found.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification
	* @throws com.ihg.brandstandards.db.NoSuchErrNotificationException if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ErrNotification findByPrimaryKey(
		long notificationId)
		throws com.ihg.brandstandards.db.NoSuchErrNotificationException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the err notification with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param notificationId the primary key of the err notification
	* @return the err notification, or <code>null</code> if a err notification with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.ErrNotification fetchByPrimaryKey(
		long notificationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the err notifications.
	*
	* @return the err notifications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.brandstandards.db.model.ErrNotification> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the err notifications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of err notifications.
	*
	* @return the number of err notifications
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}