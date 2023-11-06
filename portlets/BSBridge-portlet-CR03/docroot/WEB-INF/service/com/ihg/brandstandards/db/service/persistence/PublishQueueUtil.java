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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the publish queue service. This utility wraps {@link PublishQueuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishQueuePersistence
 * @see PublishQueuePersistenceImpl
 * @generated
 */
public class PublishQueueUtil {
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
	public static void clearCache(PublishQueue publishQueue) {
		getPersistence().clearCache(publishQueue);
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
	public static List<PublishQueue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PublishQueue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PublishQueue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static PublishQueue update(PublishQueue publishQueue)
		throws SystemException {
		return getPersistence().update(publishQueue);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static PublishQueue update(PublishQueue publishQueue,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publishQueue, serviceContext);
	}

	/**
	* Returns all the publish queues where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @return the matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findByPublishQueueByEnvironment(
		java.lang.String publishEnvironment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishQueueByEnvironment(publishEnvironment);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findByPublishQueueByEnvironment(
		java.lang.String publishEnvironment, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishQueueByEnvironment(publishEnvironment, start,
			end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findByPublishQueueByEnvironment(
		java.lang.String publishEnvironment, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishQueueByEnvironment(publishEnvironment, start,
			end, orderByComparator);
	}

	/**
	* Returns the first publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueByEnvironment_First(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishQueueByEnvironment_First(publishEnvironment,
			orderByComparator);
	}

	/**
	* Returns the first publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByEnvironment_First(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishQueueByEnvironment_First(publishEnvironment,
			orderByComparator);
	}

	/**
	* Returns the last publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueByEnvironment_Last(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishQueueByEnvironment_Last(publishEnvironment,
			orderByComparator);
	}

	/**
	* Returns the last publish queue in the ordered set where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByEnvironment_Last(
		java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishQueueByEnvironment_Last(publishEnvironment,
			orderByComparator);
	}

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
	public static com.ihg.brandstandards.db.model.PublishQueue[] findByPublishQueueByEnvironment_PrevAndNext(
		long publishQueueId, java.lang.String publishEnvironment,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPublishQueueByEnvironment_PrevAndNext(publishQueueId,
			publishEnvironment, orderByComparator);
	}

	/**
	* Removes all the publish queues where publishEnvironment = &#63; from the database.
	*
	* @param publishEnvironment the publish environment
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPublishQueueByEnvironment(
		java.lang.String publishEnvironment)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPublishQueueByEnvironment(publishEnvironment);
	}

	/**
	* Returns the number of publish queues where publishEnvironment = &#63;.
	*
	* @param publishEnvironment the publish environment
	* @return the number of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishQueueByEnvironment(
		java.lang.String publishEnvironment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByPublishQueueByEnvironment(publishEnvironment);
	}

	/**
	* Returns the publish queue where publishQueueId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	*
	* @param publishQueueId the publish queue ID
	* @return the matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueId(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishQueueId(publishQueueId);
	}

	/**
	* Returns the publish queue where publishQueueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishQueueId the publish queue ID
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueId(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPublishQueueId(publishQueueId);
	}

	/**
	* Returns the publish queue where publishQueueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishQueueId the publish queue ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueId(
		long publishQueueId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishQueueId(publishQueueId, retrieveFromCache);
	}

	/**
	* Removes the publish queue where publishQueueId = &#63; from the database.
	*
	* @param publishQueueId the publish queue ID
	* @return the publish queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue removeByPublishQueueId(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPublishQueueId(publishQueueId);
	}

	/**
	* Returns the number of publish queues where publishQueueId = &#63;.
	*
	* @param publishQueueId the publish queue ID
	* @return the number of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishQueueId(long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishQueueId(publishQueueId);
	}

	/**
	* Returns the publish queue where publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	*
	* @param publishId the publish ID
	* @return the matching publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue findByPublishQueueByPublishId(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPublishQueueByPublishId(publishId);
	}

	/**
	* Returns the publish queue where publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param publishId the publish ID
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByPublishId(
		long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPublishQueueByPublishId(publishId);
	}

	/**
	* Returns the publish queue where publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param publishId the publish ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue fetchByPublishQueueByPublishId(
		long publishId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPublishQueueByPublishId(publishId, retrieveFromCache);
	}

	/**
	* Removes the publish queue where publishId = &#63; from the database.
	*
	* @param publishId the publish ID
	* @return the publish queue that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue removeByPublishQueueByPublishId(
		long publishId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByPublishQueueByPublishId(publishId);
	}

	/**
	* Returns the number of publish queues where publishId = &#63;.
	*
	* @param publishId the publish ID
	* @return the number of matching publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPublishQueueByPublishId(long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPublishQueueByPublishId(publishId);
	}

	/**
	* Caches the publish queue in the entity cache if it is enabled.
	*
	* @param publishQueue the publish queue
	*/
	public static void cacheResult(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue) {
		getPersistence().cacheResult(publishQueue);
	}

	/**
	* Caches the publish queues in the entity cache if it is enabled.
	*
	* @param publishQueues the publish queues
	*/
	public static void cacheResult(
		java.util.List<com.ihg.brandstandards.db.model.PublishQueue> publishQueues) {
		getPersistence().cacheResult(publishQueues);
	}

	/**
	* Creates a new publish queue with the primary key. Does not add the publish queue to the database.
	*
	* @param publishQueueId the primary key for the new publish queue
	* @return the new publish queue
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue create(
		long publishQueueId) {
		return getPersistence().create(publishQueueId);
	}

	/**
	* Removes the publish queue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue that was removed
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue remove(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(publishQueueId);
	}

	public static com.ihg.brandstandards.db.model.PublishQueue updateImpl(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publishQueue);
	}

	/**
	* Returns the publish queue with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue
	* @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue findByPrimaryKey(
		long publishQueueId)
		throws com.ihg.brandstandards.db.NoSuchPublishQueueException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(publishQueueId);
	}

	/**
	* Returns the publish queue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publishQueueId the primary key of the publish queue
	* @return the publish queue, or <code>null</code> if a publish queue with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.brandstandards.db.model.PublishQueue fetchByPrimaryKey(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publishQueueId);
	}

	/**
	* Returns all the publish queues.
	*
	* @return the publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the publish queues from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of publish queues.
	*
	* @return the number of publish queues
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PublishQueuePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PublishQueuePersistence)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishQueuePersistence.class.getName());

			ReferenceRegistry.registerReference(PublishQueueUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PublishQueuePersistence persistence) {
	}

	private static PublishQueuePersistence _persistence;
}