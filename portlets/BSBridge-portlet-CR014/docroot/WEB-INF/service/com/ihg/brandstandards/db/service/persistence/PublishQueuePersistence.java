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

import com.ihg.brandstandards.db.model.PublishQueue;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the publish queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishQueuePersistenceImpl
 * @see PublishQueueUtil
 * @generated
 */
public interface PublishQueuePersistence extends BasePersistence<PublishQueue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublishQueueUtil} to access the publish queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the publish queues where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @return the matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findByPublishQueueByEnvironment(
		java.lang.String publishEnvironment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publish queues where publishEnvironment = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishEnvironment the publish environment
	* @param start the lower bound of the range of publish queues
	* @param end the upper bound of the range of publish queues (not inclusive)
	* @return the range of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findByPublishQueueByEnvironment(
		java.lang.String publishEnvironment, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publish queues where publishEnvironment = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param publishEnvironment the publish environment
	* @param start the lower bound of the range of publish queues
	* @param end the upper bound of the range of publish queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findByPublishQueueByEnvironment(
		java.lang.String publishEnvironment, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueByEnvironment_First(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByEnvironment_First(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueByEnvironment_Last(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByEnvironment_Last(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queues before and after the current publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishQueueId the primary key of the current publish queue
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue[] findByPublishQueueByEnvironment_PrevAndNext(
		long publishQueueId, java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publish queues where publishEnvironment = &#63; from the database.
	*
	* @param publishEnvironment the publish environment
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPublishQueueByEnvironment(
		java.lang.String publishEnvironment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish queues where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @return the number of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishQueueByEnvironment(
		java.lang.String publishEnvironment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue where publishQueueId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	*
	* @param publishQueueId the publish queue ID
	* @return the matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueId(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue where publishQueueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishQueueId the publish queue ID
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueId(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue where publishQueueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishQueueId the publish queue ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueId(
		long publishQueueId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publish queue where publishQueueId = &#63; from the database.
	*
	* @param publishQueueId the publish queue ID
	* @return the publish queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue removeByPublishQueueId(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish queues where publishQueueId = &#63;.
	*
	* @param publishQueueId the publish queue ID
	* @return the number of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishQueueId(long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue where publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	*
	* @param publishId the publish ID
	* @return the matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueByPublishId(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue where publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue where publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByPublishId(
		long publishId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the publish queue where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @return the publish queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue removeByPublishQueueByPublishId(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish queues where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public int countByPublishQueueByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the publish queue in the entity cache if it is enabled.
	*
	* @param publishQueue the publish queue
	*/
	public void cacheResult(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue);

	/**
	* Caches the publish queues in the entity cache if it is enabled.
	*
	* @param publishQueues the publish queues
	*/
	public void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishQueue> publishQueues);

	/**
	* Creates a new publish queue with the primary key. Does not add the publish queue to the database.
	*
	* @param publishQueueId the primary key for the new publish queue
	* @return the new publish queue
	*/
	public com.ihg.brandstandards.db.model.PublishQueue create(
		long publishQueueId);

	/**
	* Removes the publish queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue remove(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.PublishQueue updateImpl(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue findByPrimaryKey(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publish queue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue, or <code>null</code> if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.brandstandards.db.model.PublishQueue fetchByPrimaryKey(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publish queues.
	*
	* @return the publish queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the publish queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish queues
	* @param end the upper bound of the range of publish queues (not inclusive)
	* @return the range of publish queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the publish queues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publish queues
	* @param end the upper bound of the range of publish queues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publish queues
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publish queues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publish queues.
	*
	* @return the number of publish queues
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}