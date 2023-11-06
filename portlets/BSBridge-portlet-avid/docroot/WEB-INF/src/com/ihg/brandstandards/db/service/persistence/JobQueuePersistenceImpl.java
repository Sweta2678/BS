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

import com.ihg.brandstandards.db.NoSuchJobQueueException;
import com.ihg.brandstandards.db.model.JobQueue;
import com.ihg.brandstandards.db.model.impl.JobQueueImpl;
import com.ihg.brandstandards.db.model.impl.JobQueueModelImpl;

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
 * The persistence implementation for the job queue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see JobQueuePersistence
 * @see JobQueueUtil
 * @generated
 */
public class JobQueuePersistenceImpl extends BasePersistenceImpl<JobQueue>
	implements JobQueuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link JobQueueUtil} to access the job queue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = JobQueueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_JOBID = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByJobId",
			new String[] { Long.class.getName() },
			JobQueueModelImpl.JOBID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBID = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the job queue where jobId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchJobQueueException} if it could not be found.
	 *
	 * @param jobId the job ID
	 * @return the matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobId(long jobId)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobId(jobId);

		if (jobQueue == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("jobId=");
			msg.append(jobId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchJobQueueException(msg.toString());
		}

		return jobQueue;
	}

	/**
	 * Returns the job queue where jobId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param jobId the job ID
	 * @return the matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobId(long jobId) throws SystemException {
		return fetchByJobId(jobId, true);
	}

	/**
	 * Returns the job queue where jobId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param jobId the job ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobId(long jobId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { jobId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_JOBID,
					finderArgs, this);
		}

		if (result instanceof JobQueue) {
			JobQueue jobQueue = (JobQueue)result;

			if ((jobId != jobQueue.getJobId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_JOBQUEUE_WHERE);

			query.append(_FINDER_COLUMN_JOBID_JOBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobId);

				List<JobQueue> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"JobQueuePersistenceImpl.fetchByJobId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					JobQueue jobQueue = list.get(0);

					result = jobQueue;

					cacheResult(jobQueue);

					if ((jobQueue.getJobId() != jobId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
							finderArgs, jobQueue);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBID,
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
			return (JobQueue)result;
		}
	}

	/**
	 * Removes the job queue where jobId = &#63; from the database.
	 *
	 * @param jobId the job ID
	 * @return the job queue that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue removeByJobId(long jobId)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = findByJobId(jobId);

		return remove(jobQueue);
	}

	/**
	 * Returns the number of job queues where jobId = &#63;.
	 *
	 * @param jobId the job ID
	 * @return the number of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobId(long jobId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBID;

		Object[] finderArgs = new Object[] { jobId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOBQUEUE_WHERE);

			query.append(_FINDER_COLUMN_JOBID_JOBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(jobId);

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

	private static final String _FINDER_COLUMN_JOBID_JOBID_2 = "jobQueue.jobId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNER = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobOwner",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNER =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobOwner",
			new String[] { String.class.getName() },
			JobQueueModelImpl.JOBOWNER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBOWNER = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobOwner",
			new String[] { String.class.getName() });

	/**
	 * Returns all the job queues where jobOwner = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @return the matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwner(String jobOwner)
		throws SystemException {
		return findByJobOwner(jobOwner, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the job queues where jobOwner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @return the range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwner(String jobOwner, int start, int end)
		throws SystemException {
		return findByJobOwner(jobOwner, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job queues where jobOwner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwner(String jobOwner, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNER;
			finderArgs = new Object[] { jobOwner };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNER;
			finderArgs = new Object[] { jobOwner, start, end, orderByComparator };
		}

		List<JobQueue> list = (List<JobQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobQueue jobQueue : list) {
				if (!Validator.equals(jobOwner, jobQueue.getJobOwner())) {
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

			query.append(_SQL_SELECT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
				}

				if (!pagination) {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobQueue>(list);
				}
				else {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job queue in the ordered set where jobOwner = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwner_First(String jobOwner,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwner_First(jobOwner, orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the first job queue in the ordered set where jobOwner = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwner_First(String jobOwner,
		OrderByComparator orderByComparator) throws SystemException {
		List<JobQueue> list = findByJobOwner(jobOwner, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwner_Last(String jobOwner,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwner_Last(jobOwner, orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwner_Last(String jobOwner,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByJobOwner(jobOwner);

		if (count == 0) {
			return null;
		}

		List<JobQueue> list = findByJobOwner(jobOwner, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63;.
	 *
	 * @param jobId the primary key of the current job queue
	 * @param jobOwner the job owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue[] findByJobOwner_PrevAndNext(long jobId, String jobOwner,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			JobQueue[] array = new JobQueueImpl[3];

			array[0] = getByJobOwner_PrevAndNext(session, jobQueue, jobOwner,
					orderByComparator, true);

			array[1] = jobQueue;

			array[2] = getByJobOwner_PrevAndNext(session, jobQueue, jobOwner,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobQueue getByJobOwner_PrevAndNext(Session session,
		JobQueue jobQueue, String jobOwner,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBQUEUE_WHERE);

		boolean bindJobOwner = false;

		if (jobOwner == null) {
			query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_1);
		}
		else if (jobOwner.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_3);
		}
		else {
			bindJobOwner = true;

			query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_2);
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
			query.append(JobQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobOwner) {
			qPos.add(jobOwner);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job queues where jobOwner = &#63; from the database.
	 *
	 * @param jobOwner the job owner
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJobOwner(String jobOwner) throws SystemException {
		for (JobQueue jobQueue : findByJobOwner(jobOwner, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(jobQueue);
		}
	}

	/**
	 * Returns the number of job queues where jobOwner = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @return the number of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobOwner(String jobOwner) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBOWNER;

		Object[] finderArgs = new Object[] { jobOwner };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNER_JOBOWNER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
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

	private static final String _FINDER_COLUMN_JOBOWNER_JOBOWNER_1 = "jobQueue.jobOwner IS NULL";
	private static final String _FINDER_COLUMN_JOBOWNER_JOBOWNER_2 = "jobQueue.jobOwner = ?";
	private static final String _FINDER_COLUMN_JOBOWNER_JOBOWNER_3 = "(jobQueue.jobOwner IS NULL OR jobQueue.jobOwner = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNERANDSTATUS =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobOwnerAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDSTATUS =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByJobOwnerAndStatus",
			new String[] { String.class.getName(), String.class.getName() },
			JobQueueModelImpl.JOBOWNER_COLUMN_BITMASK |
			JobQueueModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBOWNERANDSTATUS = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJobOwnerAndStatus",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the job queues where jobOwner = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @return the matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerAndStatus(String jobOwner, String status)
		throws SystemException {
		return findByJobOwnerAndStatus(jobOwner, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job queues where jobOwner = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @return the range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerAndStatus(String jobOwner,
		String status, int start, int end) throws SystemException {
		return findByJobOwnerAndStatus(jobOwner, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job queues where jobOwner = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerAndStatus(String jobOwner,
		String status, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDSTATUS;
			finderArgs = new Object[] { jobOwner, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNERANDSTATUS;
			finderArgs = new Object[] {
					jobOwner, status,
					
					start, end, orderByComparator
				};
		}

		List<JobQueue> list = (List<JobQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobQueue jobQueue : list) {
				if (!Validator.equals(jobOwner, jobQueue.getJobOwner()) ||
						!Validator.equals(status, jobQueue.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
				}

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobQueue>(list);
				}
				else {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwnerAndStatus_First(String jobOwner,
		String status, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwnerAndStatus_First(jobOwner, status,
				orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the first job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwnerAndStatus_First(String jobOwner,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		List<JobQueue> list = findByJobOwnerAndStatus(jobOwner, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwnerAndStatus_Last(String jobOwner,
		String status, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwnerAndStatus_Last(jobOwner, status,
				orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwnerAndStatus_Last(String jobOwner,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByJobOwnerAndStatus(jobOwner, status);

		if (count == 0) {
			return null;
		}

		List<JobQueue> list = findByJobOwnerAndStatus(jobOwner, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63; and status = &#63;.
	 *
	 * @param jobId the primary key of the current job queue
	 * @param jobOwner the job owner
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue[] findByJobOwnerAndStatus_PrevAndNext(long jobId,
		String jobOwner, String status, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			JobQueue[] array = new JobQueueImpl[3];

			array[0] = getByJobOwnerAndStatus_PrevAndNext(session, jobQueue,
					jobOwner, status, orderByComparator, true);

			array[1] = jobQueue;

			array[2] = getByJobOwnerAndStatus_PrevAndNext(session, jobQueue,
					jobOwner, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobQueue getByJobOwnerAndStatus_PrevAndNext(Session session,
		JobQueue jobQueue, String jobOwner, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBQUEUE_WHERE);

		boolean bindJobOwner = false;

		if (jobOwner == null) {
			query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_1);
		}
		else if (jobOwner.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_3);
		}
		else {
			bindJobOwner = true;

			query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_2);
		}

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_2);
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
			query.append(JobQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobOwner) {
			qPos.add(jobOwner);
		}

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job queues where jobOwner = &#63; and status = &#63; from the database.
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJobOwnerAndStatus(String jobOwner, String status)
		throws SystemException {
		for (JobQueue jobQueue : findByJobOwnerAndStatus(jobOwner, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobQueue);
		}
	}

	/**
	 * Returns the number of job queues where jobOwner = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param status the status
	 * @return the number of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobOwnerAndStatus(String jobOwner, String status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBOWNERANDSTATUS;

		Object[] finderArgs = new Object[] { jobOwner, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
				}

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_1 = "jobQueue.jobOwner IS NULL AND ";
	private static final String _FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_2 = "jobQueue.jobOwner = ? AND ";
	private static final String _FINDER_COLUMN_JOBOWNERANDSTATUS_JOBOWNER_3 = "(jobQueue.jobOwner IS NULL OR jobQueue.jobOwner = '') AND ";
	private static final String _FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_1 = "jobQueue.status IS NULL";
	private static final String _FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_2 = "jobQueue.status = ?";
	private static final String _FINDER_COLUMN_JOBOWNERANDSTATUS_STATUS_3 = "(jobQueue.status IS NULL OR jobQueue.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBTYPE = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPE =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobType",
			new String[] { String.class.getName() },
			JobQueueModelImpl.JOBTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBTYPE = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByJobType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the job queues where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @return the matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobType(String jobType)
		throws SystemException {
		return findByJobType(jobType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job queues where jobType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobType the job type
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @return the range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobType(String jobType, int start, int end)
		throws SystemException {
		return findByJobType(jobType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job queues where jobType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobType the job type
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobType(String jobType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPE;
			finderArgs = new Object[] { jobType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBTYPE;
			finderArgs = new Object[] { jobType, start, end, orderByComparator };
		}

		List<JobQueue> list = (List<JobQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobQueue jobQueue : list) {
				if (!Validator.equals(jobType, jobQueue.getJobType())) {
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

			query.append(_SQL_SELECT_JOBQUEUE_WHERE);

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobType) {
					qPos.add(jobType);
				}

				if (!pagination) {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobQueue>(list);
				}
				else {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job queue in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobType_First(String jobType,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobType_First(jobType, orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobType=");
		msg.append(jobType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the first job queue in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobType_First(String jobType,
		OrderByComparator orderByComparator) throws SystemException {
		List<JobQueue> list = findByJobType(jobType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job queue in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobType_Last(String jobType,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobType_Last(jobType, orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobType=");
		msg.append(jobType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the last job queue in the ordered set where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobType_Last(String jobType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByJobType(jobType);

		if (count == 0) {
			return null;
		}

		List<JobQueue> list = findByJobType(jobType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job queues before and after the current job queue in the ordered set where jobType = &#63;.
	 *
	 * @param jobId the primary key of the current job queue
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue[] findByJobType_PrevAndNext(long jobId, String jobType,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			JobQueue[] array = new JobQueueImpl[3];

			array[0] = getByJobType_PrevAndNext(session, jobQueue, jobType,
					orderByComparator, true);

			array[1] = jobQueue;

			array[2] = getByJobType_PrevAndNext(session, jobQueue, jobType,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobQueue getByJobType_PrevAndNext(Session session,
		JobQueue jobQueue, String jobType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBQUEUE_WHERE);

		boolean bindJobType = false;

		if (jobType == null) {
			query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_1);
		}
		else if (jobType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_3);
		}
		else {
			bindJobType = true;

			query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_2);
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
			query.append(JobQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobType) {
			qPos.add(jobType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job queues where jobType = &#63; from the database.
	 *
	 * @param jobType the job type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJobType(String jobType) throws SystemException {
		for (JobQueue jobQueue : findByJobType(jobType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(jobQueue);
		}
	}

	/**
	 * Returns the number of job queues where jobType = &#63;.
	 *
	 * @param jobType the job type
	 * @return the number of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobType(String jobType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBTYPE;

		Object[] finderArgs = new Object[] { jobType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_JOBQUEUE_WHERE);

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBTYPE_JOBTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobType) {
					qPos.add(jobType);
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

	private static final String _FINDER_COLUMN_JOBTYPE_JOBTYPE_1 = "jobQueue.jobType IS NULL";
	private static final String _FINDER_COLUMN_JOBTYPE_JOBTYPE_2 = "jobQueue.jobType = ?";
	private static final String _FINDER_COLUMN_JOBTYPE_JOBTYPE_3 = "(jobQueue.jobType IS NULL OR jobQueue.jobType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBTYPEANDSTATUS =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobTypeAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPEANDSTATUS =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByJobTypeAndStatus",
			new String[] { String.class.getName(), String.class.getName() },
			JobQueueModelImpl.JOBTYPE_COLUMN_BITMASK |
			JobQueueModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBTYPEANDSTATUS = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJobTypeAndStatus",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the job queues where jobType = &#63; and status = &#63;.
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @return the matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobTypeAndStatus(String jobType, String status)
		throws SystemException {
		return findByJobTypeAndStatus(jobType, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job queues where jobType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @return the range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobTypeAndStatus(String jobType, String status,
		int start, int end) throws SystemException {
		return findByJobTypeAndStatus(jobType, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job queues where jobType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobTypeAndStatus(String jobType, String status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPEANDSTATUS;
			finderArgs = new Object[] { jobType, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBTYPEANDSTATUS;
			finderArgs = new Object[] {
					jobType, status,
					
					start, end, orderByComparator
				};
		}

		List<JobQueue> list = (List<JobQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobQueue jobQueue : list) {
				if (!Validator.equals(jobType, jobQueue.getJobType()) ||
						!Validator.equals(status, jobQueue.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_JOBQUEUE_WHERE);

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobType) {
					qPos.add(jobType);
				}

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobQueue>(list);
				}
				else {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job queue in the ordered set where jobType = &#63; and status = &#63;.
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobTypeAndStatus_First(String jobType, String status,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobTypeAndStatus_First(jobType, status,
				orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobType=");
		msg.append(jobType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the first job queue in the ordered set where jobType = &#63; and status = &#63;.
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobTypeAndStatus_First(String jobType,
		String status, OrderByComparator orderByComparator)
		throws SystemException {
		List<JobQueue> list = findByJobTypeAndStatus(jobType, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job queue in the ordered set where jobType = &#63; and status = &#63;.
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobTypeAndStatus_Last(String jobType, String status,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobTypeAndStatus_Last(jobType, status,
				orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobType=");
		msg.append(jobType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the last job queue in the ordered set where jobType = &#63; and status = &#63;.
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobTypeAndStatus_Last(String jobType, String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByJobTypeAndStatus(jobType, status);

		if (count == 0) {
			return null;
		}

		List<JobQueue> list = findByJobTypeAndStatus(jobType, status,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job queues before and after the current job queue in the ordered set where jobType = &#63; and status = &#63;.
	 *
	 * @param jobId the primary key of the current job queue
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue[] findByJobTypeAndStatus_PrevAndNext(long jobId,
		String jobType, String status, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			JobQueue[] array = new JobQueueImpl[3];

			array[0] = getByJobTypeAndStatus_PrevAndNext(session, jobQueue,
					jobType, status, orderByComparator, true);

			array[1] = jobQueue;

			array[2] = getByJobTypeAndStatus_PrevAndNext(session, jobQueue,
					jobType, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobQueue getByJobTypeAndStatus_PrevAndNext(Session session,
		JobQueue jobQueue, String jobType, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBQUEUE_WHERE);

		boolean bindJobType = false;

		if (jobType == null) {
			query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_1);
		}
		else if (jobType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_3);
		}
		else {
			bindJobType = true;

			query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_2);
		}

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_2);
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
			query.append(JobQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobType) {
			qPos.add(jobType);
		}

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job queues where jobType = &#63; and status = &#63; from the database.
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJobTypeAndStatus(String jobType, String status)
		throws SystemException {
		for (JobQueue jobQueue : findByJobTypeAndStatus(jobType, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobQueue);
		}
	}

	/**
	 * Returns the number of job queues where jobType = &#63; and status = &#63;.
	 *
	 * @param jobType the job type
	 * @param status the status
	 * @return the number of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobTypeAndStatus(String jobType, String status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBTYPEANDSTATUS;

		Object[] finderArgs = new Object[] { jobType, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOBQUEUE_WHERE);

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobType) {
					qPos.add(jobType);
				}

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_1 = "jobQueue.jobType IS NULL AND ";
	private static final String _FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_2 = "jobQueue.jobType = ? AND ";
	private static final String _FINDER_COLUMN_JOBTYPEANDSTATUS_JOBTYPE_3 = "(jobQueue.jobType IS NULL OR jobQueue.jobType = '') AND ";
	private static final String _FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_1 = "jobQueue.status IS NULL";
	private static final String _FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_2 = "jobQueue.status = ?";
	private static final String _FINDER_COLUMN_JOBTYPEANDSTATUS_STATUS_3 = "(jobQueue.status IS NULL OR jobQueue.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNERANDTYPE =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByJobOwnerAndType",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDTYPE =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByJobOwnerAndType",
			new String[] { String.class.getName(), String.class.getName() },
			JobQueueModelImpl.JOBOWNER_COLUMN_BITMASK |
			JobQueueModelImpl.JOBTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBOWNERANDTYPE = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJobOwnerAndType",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the job queues where jobOwner = &#63; and jobType = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @return the matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerAndType(String jobOwner, String jobType)
		throws SystemException {
		return findByJobOwnerAndType(jobOwner, jobType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job queues where jobOwner = &#63; and jobType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @return the range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerAndType(String jobOwner,
		String jobType, int start, int end) throws SystemException {
		return findByJobOwnerAndType(jobOwner, jobType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the job queues where jobOwner = &#63; and jobType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerAndType(String jobOwner,
		String jobType, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDTYPE;
			finderArgs = new Object[] { jobOwner, jobType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNERANDTYPE;
			finderArgs = new Object[] {
					jobOwner, jobType,
					
					start, end, orderByComparator
				};
		}

		List<JobQueue> list = (List<JobQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobQueue jobQueue : list) {
				if (!Validator.equals(jobOwner, jobQueue.getJobOwner()) ||
						!Validator.equals(jobType, jobQueue.getJobType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_2);
			}

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
				}

				if (bindJobType) {
					qPos.add(jobType);
				}

				if (!pagination) {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobQueue>(list);
				}
				else {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwnerAndType_First(String jobOwner,
		String jobType, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwnerAndType_First(jobOwner, jobType,
				orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(", jobType=");
		msg.append(jobType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwnerAndType_First(String jobOwner,
		String jobType, OrderByComparator orderByComparator)
		throws SystemException {
		List<JobQueue> list = findByJobOwnerAndType(jobOwner, jobType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwnerAndType_Last(String jobOwner, String jobType,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwnerAndType_Last(jobOwner, jobType,
				orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(", jobType=");
		msg.append(jobType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwnerAndType_Last(String jobOwner,
		String jobType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByJobOwnerAndType(jobOwner, jobType);

		if (count == 0) {
			return null;
		}

		List<JobQueue> list = findByJobOwnerAndType(jobOwner, jobType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63; and jobType = &#63;.
	 *
	 * @param jobId the primary key of the current job queue
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue[] findByJobOwnerAndType_PrevAndNext(long jobId,
		String jobOwner, String jobType, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			JobQueue[] array = new JobQueueImpl[3];

			array[0] = getByJobOwnerAndType_PrevAndNext(session, jobQueue,
					jobOwner, jobType, orderByComparator, true);

			array[1] = jobQueue;

			array[2] = getByJobOwnerAndType_PrevAndNext(session, jobQueue,
					jobOwner, jobType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobQueue getByJobOwnerAndType_PrevAndNext(Session session,
		JobQueue jobQueue, String jobOwner, String jobType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBQUEUE_WHERE);

		boolean bindJobOwner = false;

		if (jobOwner == null) {
			query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_1);
		}
		else if (jobOwner.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_3);
		}
		else {
			bindJobOwner = true;

			query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_2);
		}

		boolean bindJobType = false;

		if (jobType == null) {
			query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_1);
		}
		else if (jobType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_3);
		}
		else {
			bindJobType = true;

			query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_2);
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
			query.append(JobQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobOwner) {
			qPos.add(jobOwner);
		}

		if (bindJobType) {
			qPos.add(jobType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job queues where jobOwner = &#63; and jobType = &#63; from the database.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJobOwnerAndType(String jobOwner, String jobType)
		throws SystemException {
		for (JobQueue jobQueue : findByJobOwnerAndType(jobOwner, jobType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobQueue);
		}
	}

	/**
	 * Returns the number of job queues where jobOwner = &#63; and jobType = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @return the number of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobOwnerAndType(String jobOwner, String jobType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBOWNERANDTYPE;

		Object[] finderArgs = new Object[] { jobOwner, jobType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_2);
			}

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
				}

				if (bindJobType) {
					qPos.add(jobType);
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

	private static final String _FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_1 = "jobQueue.jobOwner IS NULL AND ";
	private static final String _FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_2 = "jobQueue.jobOwner = ? AND ";
	private static final String _FINDER_COLUMN_JOBOWNERANDTYPE_JOBOWNER_3 = "(jobQueue.jobOwner IS NULL OR jobQueue.jobOwner = '') AND ";
	private static final String _FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_1 = "jobQueue.jobType IS NULL";
	private static final String _FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_2 = "jobQueue.jobType = ?";
	private static final String _FINDER_COLUMN_JOBOWNERANDTYPE_JOBTYPE_3 = "(jobQueue.jobType IS NULL OR jobQueue.jobType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNERTYPEANDSTATUS =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByJobOwnerTypeAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERTYPEANDSTATUS =
		new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, JobQueueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByJobOwnerTypeAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			JobQueueModelImpl.JOBOWNER_COLUMN_BITMASK |
			JobQueueModelImpl.JOBTYPE_COLUMN_BITMASK |
			JobQueueModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOBOWNERTYPEANDSTATUS = new FinderPath(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJobOwnerTypeAndStatus",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @return the matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerTypeAndStatus(String jobOwner,
		String jobType, String status) throws SystemException {
		return findByJobOwnerTypeAndStatus(jobOwner, jobType, status,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @return the range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerTypeAndStatus(String jobOwner,
		String jobType, String status, int start, int end)
		throws SystemException {
		return findByJobOwnerTypeAndStatus(jobOwner, jobType, status, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findByJobOwnerTypeAndStatus(String jobOwner,
		String jobType, String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERTYPEANDSTATUS;
			finderArgs = new Object[] { jobOwner, jobType, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_JOBOWNERTYPEANDSTATUS;
			finderArgs = new Object[] {
					jobOwner, jobType, status,
					
					start, end, orderByComparator
				};
		}

		List<JobQueue> list = (List<JobQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (JobQueue jobQueue : list) {
				if (!Validator.equals(jobOwner, jobQueue.getJobOwner()) ||
						!Validator.equals(jobType, jobQueue.getJobType()) ||
						!Validator.equals(status, jobQueue.getStatus())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_2);
			}

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(JobQueueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
				}

				if (bindJobType) {
					qPos.add(jobType);
				}

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobQueue>(list);
				}
				else {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwnerTypeAndStatus_First(String jobOwner,
		String jobType, String status, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwnerTypeAndStatus_First(jobOwner,
				jobType, status, orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(", jobType=");
		msg.append(jobType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the first job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwnerTypeAndStatus_First(String jobOwner,
		String jobType, String status, OrderByComparator orderByComparator)
		throws SystemException {
		List<JobQueue> list = findByJobOwnerTypeAndStatus(jobOwner, jobType,
				status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByJobOwnerTypeAndStatus_Last(String jobOwner,
		String jobType, String status, OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByJobOwnerTypeAndStatus_Last(jobOwner,
				jobType, status, orderByComparator);

		if (jobQueue != null) {
			return jobQueue;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("jobOwner=");
		msg.append(jobOwner);

		msg.append(", jobType=");
		msg.append(jobType);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchJobQueueException(msg.toString());
	}

	/**
	 * Returns the last job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching job queue, or <code>null</code> if a matching job queue could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByJobOwnerTypeAndStatus_Last(String jobOwner,
		String jobType, String status, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByJobOwnerTypeAndStatus(jobOwner, jobType, status);

		if (count == 0) {
			return null;
		}

		List<JobQueue> list = findByJobOwnerTypeAndStatus(jobOwner, jobType,
				status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the job queues before and after the current job queue in the ordered set where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * @param jobId the primary key of the current job queue
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue[] findByJobOwnerTypeAndStatus_PrevAndNext(long jobId,
		String jobOwner, String jobType, String status,
		OrderByComparator orderByComparator)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = findByPrimaryKey(jobId);

		Session session = null;

		try {
			session = openSession();

			JobQueue[] array = new JobQueueImpl[3];

			array[0] = getByJobOwnerTypeAndStatus_PrevAndNext(session,
					jobQueue, jobOwner, jobType, status, orderByComparator, true);

			array[1] = jobQueue;

			array[2] = getByJobOwnerTypeAndStatus_PrevAndNext(session,
					jobQueue, jobOwner, jobType, status, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected JobQueue getByJobOwnerTypeAndStatus_PrevAndNext(Session session,
		JobQueue jobQueue, String jobOwner, String jobType, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_JOBQUEUE_WHERE);

		boolean bindJobOwner = false;

		if (jobOwner == null) {
			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_1);
		}
		else if (jobOwner.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_3);
		}
		else {
			bindJobOwner = true;

			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_2);
		}

		boolean bindJobType = false;

		if (jobType == null) {
			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_1);
		}
		else if (jobType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_3);
		}
		else {
			bindJobType = true;

			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_2);
		}

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_2);
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
			query.append(JobQueueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindJobOwner) {
			qPos.add(jobOwner);
		}

		if (bindJobType) {
			qPos.add(jobType);
		}

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(jobQueue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<JobQueue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the job queues where jobOwner = &#63; and jobType = &#63; and status = &#63; from the database.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByJobOwnerTypeAndStatus(String jobOwner, String jobType,
		String status) throws SystemException {
		for (JobQueue jobQueue : findByJobOwnerTypeAndStatus(jobOwner, jobType,
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(jobQueue);
		}
	}

	/**
	 * Returns the number of job queues where jobOwner = &#63; and jobType = &#63; and status = &#63;.
	 *
	 * @param jobOwner the job owner
	 * @param jobType the job type
	 * @param status the status
	 * @return the number of matching job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByJobOwnerTypeAndStatus(String jobOwner, String jobType,
		String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOBOWNERTYPEANDSTATUS;

		Object[] finderArgs = new Object[] { jobOwner, jobType, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_JOBQUEUE_WHERE);

			boolean bindJobOwner = false;

			if (jobOwner == null) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_1);
			}
			else if (jobOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_3);
			}
			else {
				bindJobOwner = true;

				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_2);
			}

			boolean bindJobType = false;

			if (jobType == null) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_1);
			}
			else if (jobType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_3);
			}
			else {
				bindJobType = true;

				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_2);
			}

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindJobOwner) {
					qPos.add(jobOwner);
				}

				if (bindJobType) {
					qPos.add(jobType);
				}

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_1 = "jobQueue.jobOwner IS NULL AND ";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_2 = "jobQueue.jobOwner = ? AND ";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBOWNER_3 = "(jobQueue.jobOwner IS NULL OR jobQueue.jobOwner = '') AND ";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_1 = "jobQueue.jobType IS NULL AND ";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_2 = "jobQueue.jobType = ? AND ";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_JOBTYPE_3 = "(jobQueue.jobType IS NULL OR jobQueue.jobType = '') AND ";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_1 = "jobQueue.status IS NULL";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_2 = "jobQueue.status = ?";
	private static final String _FINDER_COLUMN_JOBOWNERTYPEANDSTATUS_STATUS_3 = "(jobQueue.status IS NULL OR jobQueue.status = '')";

	public JobQueuePersistenceImpl() {
		setModelClass(JobQueue.class);
	}

	/**
	 * Caches the job queue in the entity cache if it is enabled.
	 *
	 * @param jobQueue the job queue
	 */
	@Override
	public void cacheResult(JobQueue jobQueue) {
		EntityCacheUtil.putResult(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueImpl.class, jobQueue.getPrimaryKey(), jobQueue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID,
			new Object[] { jobQueue.getJobId() }, jobQueue);

		jobQueue.resetOriginalValues();
	}

	/**
	 * Caches the job queues in the entity cache if it is enabled.
	 *
	 * @param jobQueues the job queues
	 */
	@Override
	public void cacheResult(List<JobQueue> jobQueues) {
		for (JobQueue jobQueue : jobQueues) {
			if (EntityCacheUtil.getResult(
						JobQueueModelImpl.ENTITY_CACHE_ENABLED,
						JobQueueImpl.class, jobQueue.getPrimaryKey()) == null) {
				cacheResult(jobQueue);
			}
			else {
				jobQueue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all job queues.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(JobQueueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(JobQueueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the job queue.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(JobQueue jobQueue) {
		EntityCacheUtil.removeResult(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueImpl.class, jobQueue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(jobQueue);
	}

	@Override
	public void clearCache(List<JobQueue> jobQueues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (JobQueue jobQueue : jobQueues) {
			EntityCacheUtil.removeResult(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
				JobQueueImpl.class, jobQueue.getPrimaryKey());

			clearUniqueFindersCache(jobQueue);
		}
	}

	protected void cacheUniqueFindersCache(JobQueue jobQueue) {
		if (jobQueue.isNew()) {
			Object[] args = new Object[] { jobQueue.getJobId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOBID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID, args, jobQueue);
		}
		else {
			JobQueueModelImpl jobQueueModelImpl = (JobQueueModelImpl)jobQueue;

			if ((jobQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_JOBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { jobQueue.getJobId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_JOBID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_JOBID, args,
					jobQueue);
			}
		}
	}

	protected void clearUniqueFindersCache(JobQueue jobQueue) {
		JobQueueModelImpl jobQueueModelImpl = (JobQueueModelImpl)jobQueue;

		Object[] args = new Object[] { jobQueue.getJobId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBID, args);

		if ((jobQueueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_JOBID.getColumnBitmask()) != 0) {
			args = new Object[] { jobQueueModelImpl.getOriginalJobId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_JOBID, args);
		}
	}

	/**
	 * Creates a new job queue with the primary key. Does not add the job queue to the database.
	 *
	 * @param jobId the primary key for the new job queue
	 * @return the new job queue
	 */
	@Override
	public JobQueue create(long jobId) {
		JobQueue jobQueue = new JobQueueImpl();

		jobQueue.setNew(true);
		jobQueue.setPrimaryKey(jobId);

		return jobQueue;
	}

	/**
	 * Removes the job queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param jobId the primary key of the job queue
	 * @return the job queue that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue remove(long jobId)
		throws NoSuchJobQueueException, SystemException {
		return remove((Serializable)jobId);
	}

	/**
	 * Removes the job queue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the job queue
	 * @return the job queue that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue remove(Serializable primaryKey)
		throws NoSuchJobQueueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			JobQueue jobQueue = (JobQueue)session.get(JobQueueImpl.class,
					primaryKey);

			if (jobQueue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchJobQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(jobQueue);
		}
		catch (NoSuchJobQueueException nsee) {
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
	protected JobQueue removeImpl(JobQueue jobQueue) throws SystemException {
		jobQueue = toUnwrappedModel(jobQueue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(jobQueue)) {
				jobQueue = (JobQueue)session.get(JobQueueImpl.class,
						jobQueue.getPrimaryKeyObj());
			}

			if (jobQueue != null) {
				session.delete(jobQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (jobQueue != null) {
			clearCache(jobQueue);
		}

		return jobQueue;
	}

	@Override
	public JobQueue updateImpl(
		com.ihg.brandstandards.db.model.JobQueue jobQueue)
		throws SystemException {
		jobQueue = toUnwrappedModel(jobQueue);

		boolean isNew = jobQueue.isNew();

		JobQueueModelImpl jobQueueModelImpl = (JobQueueModelImpl)jobQueue;

		Session session = null;

		try {
			session = openSession();

			if (jobQueue.isNew()) {
				session.save(jobQueue);

				jobQueue.setNew(false);
			}
			else {
				session.merge(jobQueue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !JobQueueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((jobQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobQueueModelImpl.getOriginalJobOwner()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNER,
					args);

				args = new Object[] { jobQueueModelImpl.getJobOwner() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNER, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNER,
					args);
			}

			if ((jobQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobQueueModelImpl.getOriginalJobOwner(),
						jobQueueModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNERANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDSTATUS,
					args);

				args = new Object[] {
						jobQueueModelImpl.getJobOwner(),
						jobQueueModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNERANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDSTATUS,
					args);
			}

			if ((jobQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobQueueModelImpl.getOriginalJobType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPE,
					args);

				args = new Object[] { jobQueueModelImpl.getJobType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPE,
					args);
			}

			if ((jobQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobQueueModelImpl.getOriginalJobType(),
						jobQueueModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPEANDSTATUS,
					args);

				args = new Object[] {
						jobQueueModelImpl.getJobType(),
						jobQueueModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBTYPEANDSTATUS,
					args);
			}

			if ((jobQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobQueueModelImpl.getOriginalJobOwner(),
						jobQueueModelImpl.getOriginalJobType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNERANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDTYPE,
					args);

				args = new Object[] {
						jobQueueModelImpl.getJobOwner(),
						jobQueueModelImpl.getJobType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNERANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERANDTYPE,
					args);
			}

			if ((jobQueueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERTYPEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						jobQueueModelImpl.getOriginalJobOwner(),
						jobQueueModelImpl.getOriginalJobType(),
						jobQueueModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNERTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERTYPEANDSTATUS,
					args);

				args = new Object[] {
						jobQueueModelImpl.getJobOwner(),
						jobQueueModelImpl.getJobType(),
						jobQueueModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_JOBOWNERTYPEANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_JOBOWNERTYPEANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
			JobQueueImpl.class, jobQueue.getPrimaryKey(), jobQueue);

		clearUniqueFindersCache(jobQueue);
		cacheUniqueFindersCache(jobQueue);

		return jobQueue;
	}

	protected JobQueue toUnwrappedModel(JobQueue jobQueue) {
		if (jobQueue instanceof JobQueueImpl) {
			return jobQueue;
		}

		JobQueueImpl jobQueueImpl = new JobQueueImpl();

		jobQueueImpl.setNew(jobQueue.isNew());
		jobQueueImpl.setPrimaryKey(jobQueue.getPrimaryKey());

		jobQueueImpl.setJobId(jobQueue.getJobId());
		jobQueueImpl.setJobOwner(jobQueue.getJobOwner());
		jobQueueImpl.setJobType(jobQueue.getJobType());
		jobQueueImpl.setMetadata(jobQueue.getMetadata());
		jobQueueImpl.setLink(jobQueue.getLink());
		jobQueueImpl.setNotificationEmail(jobQueue.getNotificationEmail());
		jobQueueImpl.setStartTime(jobQueue.getStartTime());
		jobQueueImpl.setEndTime(jobQueue.getEndTime());
		jobQueueImpl.setStatus(jobQueue.getStatus());
		jobQueueImpl.setCreatorId(jobQueue.getCreatorId());
		jobQueueImpl.setCreatedDate(jobQueue.getCreatedDate());
		jobQueueImpl.setUpdatedBy(jobQueue.getUpdatedBy());
		jobQueueImpl.setUpdatedDate(jobQueue.getUpdatedDate());

		return jobQueueImpl;
	}

	/**
	 * Returns the job queue with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the job queue
	 * @return the job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchJobQueueException, SystemException {
		JobQueue jobQueue = fetchByPrimaryKey(primaryKey);

		if (jobQueue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchJobQueueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return jobQueue;
	}

	/**
	 * Returns the job queue with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchJobQueueException} if it could not be found.
	 *
	 * @param jobId the primary key of the job queue
	 * @return the job queue
	 * @throws com.ihg.brandstandards.db.NoSuchJobQueueException if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue findByPrimaryKey(long jobId)
		throws NoSuchJobQueueException, SystemException {
		return findByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns the job queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the job queue
	 * @return the job queue, or <code>null</code> if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		JobQueue jobQueue = (JobQueue)EntityCacheUtil.getResult(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
				JobQueueImpl.class, primaryKey);

		if (jobQueue == _nullJobQueue) {
			return null;
		}

		if (jobQueue == null) {
			Session session = null;

			try {
				session = openSession();

				jobQueue = (JobQueue)session.get(JobQueueImpl.class, primaryKey);

				if (jobQueue != null) {
					cacheResult(jobQueue);
				}
				else {
					EntityCacheUtil.putResult(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
						JobQueueImpl.class, primaryKey, _nullJobQueue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(JobQueueModelImpl.ENTITY_CACHE_ENABLED,
					JobQueueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return jobQueue;
	}

	/**
	 * Returns the job queue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param jobId the primary key of the job queue
	 * @return the job queue, or <code>null</code> if a job queue with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public JobQueue fetchByPrimaryKey(long jobId) throws SystemException {
		return fetchByPrimaryKey((Serializable)jobId);
	}

	/**
	 * Returns all the job queues.
	 *
	 * @return the job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the job queues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @return the range of job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the job queues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.JobQueueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of job queues
	 * @param end the upper bound of the range of job queues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of job queues
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<JobQueue> findAll(int start, int end,
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

		List<JobQueue> list = (List<JobQueue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_JOBQUEUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_JOBQUEUE;

				if (pagination) {
					sql = sql.concat(JobQueueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<JobQueue>(list);
				}
				else {
					list = (List<JobQueue>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the job queues from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (JobQueue jobQueue : findAll()) {
			remove(jobQueue);
		}
	}

	/**
	 * Returns the number of job queues.
	 *
	 * @return the number of job queues
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

				Query q = session.createQuery(_SQL_COUNT_JOBQUEUE);

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
	 * Initializes the job queue persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.JobQueue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<JobQueue>> listenersList = new ArrayList<ModelListener<JobQueue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<JobQueue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(JobQueueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_JOBQUEUE = "SELECT jobQueue FROM JobQueue jobQueue";
	private static final String _SQL_SELECT_JOBQUEUE_WHERE = "SELECT jobQueue FROM JobQueue jobQueue WHERE ";
	private static final String _SQL_COUNT_JOBQUEUE = "SELECT COUNT(jobQueue) FROM JobQueue jobQueue";
	private static final String _SQL_COUNT_JOBQUEUE_WHERE = "SELECT COUNT(jobQueue) FROM JobQueue jobQueue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "jobQueue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No JobQueue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No JobQueue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(JobQueuePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"jobId", "jobOwner", "jobType", "metadata", "link",
				"notificationEmail", "startTime", "endTime", "status",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static JobQueue _nullJobQueue = new JobQueueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<JobQueue> toCacheModel() {
				return _nullJobQueueCacheModel;
			}
		};

	private static CacheModel<JobQueue> _nullJobQueueCacheModel = new CacheModel<JobQueue>() {
			@Override
			public JobQueue toEntityModel() {
				return _nullJobQueue;
			}
		};
}