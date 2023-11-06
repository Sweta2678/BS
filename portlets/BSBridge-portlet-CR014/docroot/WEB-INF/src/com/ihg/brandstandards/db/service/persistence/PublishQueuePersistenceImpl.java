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

import com.ihg.brandstandards.db.NoSuchPublishQueueException;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.model.impl.PublishQueueImpl;
import com.ihg.brandstandards.db.model.impl.PublishQueueModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the publish queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishQueuePersistence
 * @see PublishQueueUtil
 * @generated
 */
public class PublishQueuePersistenceImpl extends BasePersistenceImpl<PublishQueue>
	implements PublishQueuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishQueueUtil} to access the publish queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishQueueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, PublishQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, PublishQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHQUEUEBYENVIRONMENT =
		new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, PublishQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishQueueByEnvironment",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHQUEUEBYENVIRONMENT =
		new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, PublishQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishQueueByEnvironment",
			new String[] { String.class.getName() },
			PublishQueueModelImpl.PUBLISHENVIRONMENT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYENVIRONMENT =
		new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishQueueByEnvironment",
			new String[] { String.class.getName() });

	/**
	 * Returns all the publish queues where publishEnvironment = &#63;.
	 *
	 * @param publishEnvironment the publish environment
	 * @return the matching publish queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishQueue> findByPublishQueueByEnvironment(
		String publishEnvironment) throws SystemException {
		return findByPublishQueueByEnvironment(publishEnvironment,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PublishQueue> findByPublishQueueByEnvironment(
		String publishEnvironment, int start, int end)
		throws SystemException {
		return findByPublishQueueByEnvironment(publishEnvironment, start, end,
			null);
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
	@Override
	public List<PublishQueue> findByPublishQueueByEnvironment(
		String publishEnvironment, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHQUEUEBYENVIRONMENT;
			finderArgs = new Object[] { publishEnvironment };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHQUEUEBYENVIRONMENT;
			finderArgs = new Object[] {
					publishEnvironment,
					
					start, end, orderByComparator
				};
		}

		List<PublishQueue> list = (List<PublishQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishQueue publishQueue : list) {
				if (!Validator.equals(publishEnvironment,
							publishQueue.getPublishEnvironment())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PUBLISHQUEUE_WHERE);

			boolean bindPublishEnvironment = false;

			if (publishEnvironment == null) {
				query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_1);
			}
			else if (publishEnvironment.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_3);
			}
			else {
				bindPublishEnvironment = true;

				query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishEnvironment) {
					qPos.add(publishEnvironment);
				}

				if (!pagination) {
					list = (List<PublishQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishQueue>(list);
				}
				else {
					list = (List<PublishQueue>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public PublishQueue findByPublishQueueByEnvironment_First(
		String publishEnvironment, OrderByComparator orderByComparator)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = fetchByPublishQueueByEnvironment_First(publishEnvironment,
				orderByComparator);

		if (publishQueue != null) {
			return publishQueue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishEnvironment=");
		msg.append(publishEnvironment);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishQueueException(msg.toString());
	}

	/**
	 * Returns the first publish queue in the ordered set where publishEnvironment = &#63;.
	 *
	 * @param publishEnvironment the publish environment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish queue, or <code>null</code> if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPublishQueueByEnvironment_First(
		String publishEnvironment, OrderByComparator orderByComparator)
		throws SystemException {
		List<PublishQueue> list = findByPublishQueueByEnvironment(publishEnvironment,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PublishQueue findByPublishQueueByEnvironment_Last(
		String publishEnvironment, OrderByComparator orderByComparator)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = fetchByPublishQueueByEnvironment_Last(publishEnvironment,
				orderByComparator);

		if (publishQueue != null) {
			return publishQueue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishEnvironment=");
		msg.append(publishEnvironment);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishQueueException(msg.toString());
	}

	/**
	 * Returns the last publish queue in the ordered set where publishEnvironment = &#63;.
	 *
	 * @param publishEnvironment the publish environment
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish queue, or <code>null</code> if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPublishQueueByEnvironment_Last(
		String publishEnvironment, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishQueueByEnvironment(publishEnvironment);

		if (count == 0) {
			return null;
		}

		List<PublishQueue> list = findByPublishQueueByEnvironment(publishEnvironment,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PublishQueue[] findByPublishQueueByEnvironment_PrevAndNext(
		long publishQueueId, String publishEnvironment,
		OrderByComparator orderByComparator)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = findByPrimaryKey(publishQueueId);

		Session session = null;

		try {
			session = openSession();

			PublishQueue[] array = new PublishQueueImpl[3];

			array[0] = getByPublishQueueByEnvironment_PrevAndNext(session,
					publishQueue, publishEnvironment, orderByComparator, true);

			array[1] = publishQueue;

			array[2] = getByPublishQueueByEnvironment_PrevAndNext(session,
					publishQueue, publishEnvironment, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishQueue getByPublishQueueByEnvironment_PrevAndNext(
		Session session, PublishQueue publishQueue, String publishEnvironment,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHQUEUE_WHERE);

		boolean bindPublishEnvironment = false;

		if (publishEnvironment == null) {
			query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_1);
		}
		else if (publishEnvironment.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_3);
		}
		else {
			bindPublishEnvironment = true;

			query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PublishQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPublishEnvironment) {
			qPos.add(publishEnvironment);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publish queues where publishEnvironment = &#63; from the database.
	 *
	 * @param publishEnvironment the publish environment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishQueueByEnvironment(String publishEnvironment)
		throws SystemException {
		for (PublishQueue publishQueue : findByPublishQueueByEnvironment(
				publishEnvironment, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishQueue);
		}
	}

	/**
	 * Returns the number of publish queues where publishEnvironment = &#63;.
	 *
	 * @param publishEnvironment the publish environment
	 * @return the number of matching publish queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishQueueByEnvironment(String publishEnvironment)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYENVIRONMENT;

		Object[] finderArgs = new Object[] { publishEnvironment };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHQUEUE_WHERE);

			boolean bindPublishEnvironment = false;

			if (publishEnvironment == null) {
				query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_1);
			}
			else if (publishEnvironment.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_3);
			}
			else {
				bindPublishEnvironment = true;

				query.append(_FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPublishEnvironment) {
					qPos.add(publishEnvironment);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_1 =
		"publishQueue.publishEnvironment IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_2 =
		"publishQueue.publishEnvironment = ?";
	private static final String _FINDER_COLUMN_PUBLISHQUEUEBYENVIRONMENT_PUBLISHENVIRONMENT_3 =
		"(publishQueue.publishEnvironment IS NULL OR publishQueue.publishEnvironment = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHQUEUEID = new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, PublishQueueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPublishQueueId",
			new String[] { Long.class.getName() },
			PublishQueueModelImpl.PUBLISHQUEUEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHQUEUEID = new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishQueueId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the publish queue where publishQueueId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	 *
	 * @param publishQueueId the publish queue ID
	 * @return the matching publish queue
	 * @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue findByPublishQueueId(long publishQueueId)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = fetchByPublishQueueId(publishQueueId);

		if (publishQueue == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishQueueId=");
			msg.append(publishQueueId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishQueueException(msg.toString());
		}

		return publishQueue;
	}

	/**
	 * Returns the publish queue where publishQueueId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishQueueId the publish queue ID
	 * @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPublishQueueId(long publishQueueId)
		throws SystemException {
		return fetchByPublishQueueId(publishQueueId, true);
	}

	/**
	 * Returns the publish queue where publishQueueId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishQueueId the publish queue ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPublishQueueId(long publishQueueId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { publishQueueId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
					finderArgs, this);
		}

		if (result instanceof PublishQueue) {
			PublishQueue publishQueue = (PublishQueue)result;

			if ((publishQueueId != publishQueue.getPublishQueueId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHQUEUE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHQUEUEID_PUBLISHQUEUEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishQueueId);

				List<PublishQueue> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishQueuePersistenceImpl.fetchByPublishQueueId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishQueue publishQueue = list.get(0);

					result = publishQueue;

					cacheResult(publishQueue);

					if ((publishQueue.getPublishQueueId() != publishQueueId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
							finderArgs, publishQueue);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PublishQueue)result;
		}
	}

	/**
	 * Removes the publish queue where publishQueueId = &#63; from the database.
	 *
	 * @param publishQueueId the publish queue ID
	 * @return the publish queue that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue removeByPublishQueueId(long publishQueueId)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = findByPublishQueueId(publishQueueId);

		return remove(publishQueue);
	}

	/**
	 * Returns the number of publish queues where publishQueueId = &#63;.
	 *
	 * @param publishQueueId the publish queue ID
	 * @return the number of matching publish queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishQueueId(long publishQueueId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHQUEUEID;

		Object[] finderArgs = new Object[] { publishQueueId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHQUEUE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHQUEUEID_PUBLISHQUEUEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishQueueId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PUBLISHQUEUEID_PUBLISHQUEUEID_2 = "publishQueue.publishQueueId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID = new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, PublishQueueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByPublishQueueByPublishId",
			new String[] { Long.class.getName() },
			PublishQueueModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYPUBLISHID = new FinderPath(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishQueueByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the publish queue where publishId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @return the matching publish queue
	 * @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue findByPublishQueueByPublishId(long publishId)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = fetchByPublishQueueByPublishId(publishId);

		if (publishQueue == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishId=");
			msg.append(publishId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishQueueException(msg.toString());
		}

		return publishQueue;
	}

	/**
	 * Returns the publish queue where publishId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPublishQueueByPublishId(long publishId)
		throws SystemException {
		return fetchByPublishQueueByPublishId(publishId, true);
	}

	/**
	 * Returns the publish queue where publishId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish queue, or <code>null</code> if a matching publish queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPublishQueueByPublishId(long publishId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { publishId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
					finderArgs, this);
		}

		if (result instanceof PublishQueue) {
			PublishQueue publishQueue = (PublishQueue)result;

			if ((publishId != publishQueue.getPublishId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHQUEUE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHQUEUEBYPUBLISHID_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				List<PublishQueue> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishQueuePersistenceImpl.fetchByPublishQueueByPublishId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishQueue publishQueue = list.get(0);

					result = publishQueue;

					cacheResult(publishQueue);

					if ((publishQueue.getPublishId() != publishId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
							finderArgs, publishQueue);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PublishQueue)result;
		}
	}

	/**
	 * Removes the publish queue where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @return the publish queue that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue removeByPublishQueueByPublishId(long publishId)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = findByPublishQueueByPublishId(publishId);

		return remove(publishQueue);
	}

	/**
	 * Returns the number of publish queues where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching publish queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishQueueByPublishId(long publishId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYPUBLISHID;

		Object[] finderArgs = new Object[] { publishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHQUEUE_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHQUEUEBYPUBLISHID_PUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PUBLISHQUEUEBYPUBLISHID_PUBLISHID_2 =
		"publishQueue.publishId = ?";

	public PublishQueuePersistenceImpl() {
		setModelClass(PublishQueue.class);
	}

	/**
	 * Caches the publish queue in the entity cache if it is enabled.
	 *
	 * @param publishQueue the publish queue
	 */
	@Override
	public void cacheResult(PublishQueue publishQueue) {
		EntityCacheUtil.putResult(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueImpl.class, publishQueue.getPrimaryKey(), publishQueue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
			new Object[] { publishQueue.getPublishQueueId() }, publishQueue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
			new Object[] { publishQueue.getPublishId() }, publishQueue);

		publishQueue.resetOriginalValues();
	}

	/**
	 * Caches the publish queues in the entity cache if it is enabled.
	 *
	 * @param publishQueues the publish queues
	 */
	@Override
	public void cacheResult(List<PublishQueue> publishQueues) {
		for (PublishQueue publishQueue : publishQueues) {
			if (EntityCacheUtil.getResult(
						PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
						PublishQueueImpl.class, publishQueue.getPrimaryKey()) == null) {
				cacheResult(publishQueue);
			}
			else {
				publishQueue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publish queues.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishQueueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishQueueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publish queue.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishQueue publishQueue) {
		EntityCacheUtil.removeResult(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueImpl.class, publishQueue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publishQueue);
	}

	@Override
	public void clearCache(List<PublishQueue> publishQueues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishQueue publishQueue : publishQueues) {
			EntityCacheUtil.removeResult(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
				PublishQueueImpl.class, publishQueue.getPrimaryKey());

			clearUniqueFindersCache(publishQueue);
		}
	}

	protected void cacheUniqueFindersCache(PublishQueue publishQueue) {
		if (publishQueue.isNew()) {
			Object[] args = new Object[] { publishQueue.getPublishQueueId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
				args, publishQueue);

			args = new Object[] { publishQueue.getPublishId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYPUBLISHID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
				args, publishQueue);
		}
		else {
			PublishQueueModelImpl publishQueueModelImpl = (PublishQueueModelImpl)publishQueue;

			if ((publishQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHQUEUEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { publishQueue.getPublishQueueId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
					args, publishQueue);
			}

			if ((publishQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { publishQueue.getPublishId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYPUBLISHID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
					args, publishQueue);
			}
		}
	}

	protected void clearUniqueFindersCache(PublishQueue publishQueue) {
		PublishQueueModelImpl publishQueueModelImpl = (PublishQueueModelImpl)publishQueue;

		Object[] args = new Object[] { publishQueue.getPublishQueueId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID, args);

		if ((publishQueueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHQUEUEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					publishQueueModelImpl.getOriginalPublishQueueId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEID,
				args);
		}

		args = new Object[] { publishQueue.getPublishId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYPUBLISHID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
			args);

		if ((publishQueueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID.getColumnBitmask()) != 0) {
			args = new Object[] { publishQueueModelImpl.getOriginalPublishId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYPUBLISHID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHQUEUEBYPUBLISHID,
				args);
		}
	}

	/**
	 * Creates a new publish queue with the primary key. Does not add the publish queue to the database.
	 *
	 * @param publishQueueId the primary key for the new publish queue
	 * @return the new publish queue
	 */
	@Override
	public PublishQueue create(long publishQueueId) {
		PublishQueue publishQueue = new PublishQueueImpl();

		publishQueue.setNew(true);
		publishQueue.setPrimaryKey(publishQueueId);

		return publishQueue;
	}

	/**
	 * Removes the publish queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishQueueId the primary key of the publish queue
	 * @return the publish queue that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue remove(long publishQueueId)
		throws NoSuchPublishQueueException, SystemException {
		return remove((Serializable)publishQueueId);
	}

	/**
	 * Removes the publish queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publish queue
	 * @return the publish queue that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue remove(Serializable primaryKey)
		throws NoSuchPublishQueueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishQueue publishQueue = (PublishQueue)session.get(PublishQueueImpl.class,
					primaryKey);

			if (publishQueue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishQueue);
		}
		catch (NoSuchPublishQueueException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PublishQueue removeImpl(PublishQueue publishQueue)
		throws SystemException {
		publishQueue = toUnwrappedModel(publishQueue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishQueue)) {
				publishQueue = (PublishQueue)session.get(PublishQueueImpl.class,
						publishQueue.getPrimaryKeyObj());
			}

			if (publishQueue != null) {
				session.delete(publishQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishQueue != null) {
			clearCache(publishQueue);
		}

		return publishQueue;
	}

	@Override
	public PublishQueue updateImpl(
		com.ihg.brandstandards.db.model.PublishQueue publishQueue)
		throws SystemException {
		publishQueue = toUnwrappedModel(publishQueue);

		boolean isNew = publishQueue.isNew();

		PublishQueueModelImpl publishQueueModelImpl = (PublishQueueModelImpl)publishQueue;

		Session session = null;

		try {
			session = openSession();

			if (publishQueue.isNew()) {
				session.save(publishQueue);

				publishQueue.setNew(false);
			}
			else {
				session.merge(publishQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublishQueueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((publishQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHQUEUEBYENVIRONMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishQueueModelImpl.getOriginalPublishEnvironment()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYENVIRONMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHQUEUEBYENVIRONMENT,
					args);

				args = new Object[] {
						publishQueueModelImpl.getPublishEnvironment()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHQUEUEBYENVIRONMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHQUEUEBYENVIRONMENT,
					args);
			}
		}

		EntityCacheUtil.putResult(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
			PublishQueueImpl.class, publishQueue.getPrimaryKey(), publishQueue);

		clearUniqueFindersCache(publishQueue);
		cacheUniqueFindersCache(publishQueue);

		return publishQueue;
	}

	protected PublishQueue toUnwrappedModel(PublishQueue publishQueue) {
		if (publishQueue instanceof PublishQueueImpl) {
			return publishQueue;
		}

		PublishQueueImpl publishQueueImpl = new PublishQueueImpl();

		publishQueueImpl.setNew(publishQueue.isNew());
		publishQueueImpl.setPrimaryKey(publishQueue.getPrimaryKey());

		publishQueueImpl.setPublishQueueId(publishQueue.getPublishQueueId());
		publishQueueImpl.setPublishFileText(publishQueue.getPublishFileText());
		publishQueueImpl.setPublishEnvironment(publishQueue.getPublishEnvironment());
		publishQueueImpl.setSchedulePublish(publishQueue.getSchedulePublish());
		publishQueueImpl.setQueueStatCd(publishQueue.getQueueStatCd());
		publishQueueImpl.setChainCd(publishQueue.getChainCd());
		publishQueueImpl.setNotificationEmailId(publishQueue.getNotificationEmailId());
		publishQueueImpl.setScheduleStart(publishQueue.getScheduleStart());
		publishQueueImpl.setScheduleEnd(publishQueue.getScheduleEnd());
		publishQueueImpl.setExpectedProdPublishDt(publishQueue.getExpectedProdPublishDt());
		publishQueueImpl.setPublishId(publishQueue.getPublishId());
		publishQueueImpl.setPublishLocaleList(publishQueue.getPublishLocaleList());
		publishQueueImpl.setCreatorId(publishQueue.getCreatorId());
		publishQueueImpl.setCreatedDate(publishQueue.getCreatedDate());
		publishQueueImpl.setUpdatedBy(publishQueue.getUpdatedBy());
		publishQueueImpl.setUpdatedDate(publishQueue.getUpdatedDate());

		return publishQueueImpl;
	}

	/**
	 * Returns the publish queue with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish queue
	 * @return the publish queue
	 * @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishQueueException, SystemException {
		PublishQueue publishQueue = fetchByPrimaryKey(primaryKey);

		if (publishQueue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishQueue;
	}

	/**
	 * Returns the publish queue with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishQueueException} if it could not be found.
	 *
	 * @param publishQueueId the primary key of the publish queue
	 * @return the publish queue
	 * @throws com.ihg.brandstandards.db.NoSuchPublishQueueException if a publish queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue findByPrimaryKey(long publishQueueId)
		throws NoSuchPublishQueueException, SystemException {
		return findByPrimaryKey((Serializable)publishQueueId);
	}

	/**
	 * Returns the publish queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish queue
	 * @return the publish queue, or <code>null</code> if a publish queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishQueue publishQueue = (PublishQueue)EntityCacheUtil.getResult(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
				PublishQueueImpl.class, primaryKey);

		if (publishQueue == _nullPublishQueue) {
			return null;
		}

		if (publishQueue == null) {
			Session session = null;

			try {
				session = openSession();

				publishQueue = (PublishQueue)session.get(PublishQueueImpl.class,
						primaryKey);

				if (publishQueue != null) {
					cacheResult(publishQueue);
				}
				else {
					EntityCacheUtil.putResult(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
						PublishQueueImpl.class, primaryKey, _nullPublishQueue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishQueueModelImpl.ENTITY_CACHE_ENABLED,
					PublishQueueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishQueue;
	}

	/**
	 * Returns the publish queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishQueueId the primary key of the publish queue
	 * @return the publish queue, or <code>null</code> if a publish queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishQueue fetchByPrimaryKey(long publishQueueId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishQueueId);
	}

	/**
	 * Returns all the publish queues.
	 *
	 * @return the publish queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishQueue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PublishQueue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<PublishQueue> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<PublishQueue> list = (List<PublishQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHQUEUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHQUEUE;

				if (pagination) {
					sql = sql.concat(PublishQueueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishQueue>(list);
				}
				else {
					list = (List<PublishQueue>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the publish queues from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishQueue publishQueue : findAll()) {
			remove(publishQueue);
		}
	}

	/**
	 * Returns the number of publish queues.
	 *
	 * @return the number of publish queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PUBLISHQUEUE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the publish queue persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishQueue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishQueue>> listenersList = new ArrayList<ModelListener<PublishQueue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishQueue>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(PublishQueueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHQUEUE = "SELECT publishQueue FROM PublishQueue publishQueue";
	private static final String _SQL_SELECT_PUBLISHQUEUE_WHERE = "SELECT publishQueue FROM PublishQueue publishQueue WHERE ";
	private static final String _SQL_COUNT_PUBLISHQUEUE = "SELECT COUNT(publishQueue) FROM PublishQueue publishQueue";
	private static final String _SQL_COUNT_PUBLISHQUEUE_WHERE = "SELECT COUNT(publishQueue) FROM PublishQueue publishQueue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishQueue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishQueue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PublishQueue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishQueuePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishQueueId", "publishFileText", "publishEnvironment",
				"schedulePublish", "queueStatCd", "chainCd",
				"notificationEmailId", "scheduleStart", "scheduleEnd",
				"expectedProdPublishDt", "publishId", "publishLocaleList",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static PublishQueue _nullPublishQueue = new PublishQueueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishQueue> toCacheModel() {
				return _nullPublishQueueCacheModel;
			}
		};

	private static CacheModel<PublishQueue> _nullPublishQueueCacheModel = new CacheModel<PublishQueue>() {
			@Override
			public PublishQueue toEntityModel() {
				return _nullPublishQueue;
			}
		};
}