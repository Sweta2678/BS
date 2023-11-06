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

import com.ihg.brandstandards.db.NoSuchGEMManagementBucketException;
import com.ihg.brandstandards.db.model.GEMManagementBucket;
import com.ihg.brandstandards.db.model.impl.GEMManagementBucketImpl;
import com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl;

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
 * The persistence implementation for the g e m management bucket service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMManagementBucketPersistence
 * @see GEMManagementBucketUtil
 * @generated
 */
public class GEMManagementBucketPersistenceImpl extends BasePersistenceImpl<GEMManagementBucket>
	implements GEMManagementBucketPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMManagementBucketUtil} to access the g e m management bucket persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMManagementBucketImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementBucketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementBucketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID =
		new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementBucketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID =
		new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementBucketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartmentId",
			new String[] { Long.class.getName() },
			GEMManagementBucketModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			GEMManagementBucketModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTID = new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartmentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m management buckets where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findByDepartmentId(long departmentId)
		throws SystemException {
		return findByDepartmentId(departmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m management buckets where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of g e m management buckets
	 * @param end the upper bound of the range of g e m management buckets (not inclusive)
	 * @return the range of matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findByDepartmentId(long departmentId,
		int start, int end) throws SystemException {
		return findByDepartmentId(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m management buckets where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of g e m management buckets
	 * @param end the upper bound of the range of g e m management buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findByDepartmentId(long departmentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID;
			finderArgs = new Object[] { departmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTID;
			finderArgs = new Object[] {
					departmentId,
					
					start, end, orderByComparator
				};
		}

		List<GEMManagementBucket> list = (List<GEMManagementBucket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMManagementBucket gemManagementBucket : list) {
				if ((departmentId != gemManagementBucket.getDepartmentId())) {
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

			query.append(_SQL_SELECT_GEMMANAGEMENTBUCKET_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMManagementBucketModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				if (!pagination) {
					list = (List<GEMManagementBucket>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMManagementBucket>(list);
				}
				else {
					list = (List<GEMManagementBucket>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first g e m management bucket in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket findByDepartmentId_First(long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMManagementBucketException, SystemException {
		GEMManagementBucket gemManagementBucket = fetchByDepartmentId_First(departmentId,
				orderByComparator);

		if (gemManagementBucket != null) {
			return gemManagementBucket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMManagementBucketException(msg.toString());
	}

	/**
	 * Returns the first g e m management bucket in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket fetchByDepartmentId_First(long departmentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMManagementBucket> list = findByDepartmentId(departmentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m management bucket in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket findByDepartmentId_Last(long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMManagementBucketException, SystemException {
		GEMManagementBucket gemManagementBucket = fetchByDepartmentId_Last(departmentId,
				orderByComparator);

		if (gemManagementBucket != null) {
			return gemManagementBucket;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMManagementBucketException(msg.toString());
	}

	/**
	 * Returns the last g e m management bucket in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket fetchByDepartmentId_Last(long departmentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDepartmentId(departmentId);

		if (count == 0) {
			return null;
		}

		List<GEMManagementBucket> list = findByDepartmentId(departmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m management buckets before and after the current g e m management bucket in the ordered set where departmentId = &#63;.
	 *
	 * @param bucketId the primary key of the current g e m management bucket
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket[] findByDepartmentId_PrevAndNext(long bucketId,
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchGEMManagementBucketException, SystemException {
		GEMManagementBucket gemManagementBucket = findByPrimaryKey(bucketId);

		Session session = null;

		try {
			session = openSession();

			GEMManagementBucket[] array = new GEMManagementBucketImpl[3];

			array[0] = getByDepartmentId_PrevAndNext(session,
					gemManagementBucket, departmentId, orderByComparator, true);

			array[1] = gemManagementBucket;

			array[2] = getByDepartmentId_PrevAndNext(session,
					gemManagementBucket, departmentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMManagementBucket getByDepartmentId_PrevAndNext(
		Session session, GEMManagementBucket gemManagementBucket,
		long departmentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMMANAGEMENTBUCKET_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

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
			query.append(GEMManagementBucketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemManagementBucket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMManagementBucket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m management buckets where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDepartmentId(long departmentId)
		throws SystemException {
		for (GEMManagementBucket gemManagementBucket : findByDepartmentId(
				departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemManagementBucket);
		}
	}

	/**
	 * Returns the number of g e m management buckets where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDepartmentId(long departmentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENTID;

		Object[] finderArgs = new Object[] { departmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMMANAGEMENTBUCKET_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_DEPARTMENTID_DEPARTMENTID_2 = "gemManagementBucket.departmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTIDANDSTATUS =
		new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementBucketImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentIdAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTIDANDSTATUS =
		new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED,
			GEMManagementBucketImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentIdAndStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			GEMManagementBucketModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			GEMManagementBucketModelImpl.ACTIVEIND_COLUMN_BITMASK |
			GEMManagementBucketModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTIDANDSTATUS = new FinderPath(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentIdAndStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @return the matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, String activeInd) throws SystemException {
		return findByDepartmentIdAndStatus(departmentId, activeInd,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of g e m management buckets
	 * @param end the upper bound of the range of g e m management buckets (not inclusive)
	 * @return the range of matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, String activeInd, int start, int end)
		throws SystemException {
		return findByDepartmentIdAndStatus(departmentId, activeInd, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @param start the lower bound of the range of g e m management buckets
	 * @param end the upper bound of the range of g e m management buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findByDepartmentIdAndStatus(
		long departmentId, String activeInd, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTIDANDSTATUS;
			finderArgs = new Object[] { departmentId, activeInd };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTIDANDSTATUS;
			finderArgs = new Object[] {
					departmentId, activeInd,
					
					start, end, orderByComparator
				};
		}

		List<GEMManagementBucket> list = (List<GEMManagementBucket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMManagementBucket gemManagementBucket : list) {
				if ((departmentId != gemManagementBucket.getDepartmentId()) ||
						!Validator.equals(activeInd,
							gemManagementBucket.getActiveInd())) {
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

			query.append(_SQL_SELECT_GEMMANAGEMENTBUCKET_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_DEPARTMENTID_2);

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMManagementBucketModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				if (bindActiveInd) {
					qPos.add(activeInd);
				}

				if (!pagination) {
					list = (List<GEMManagementBucket>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMManagementBucket>(list);
				}
				else {
					list = (List<GEMManagementBucket>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket findByDepartmentIdAndStatus_First(
		long departmentId, String activeInd, OrderByComparator orderByComparator)
		throws NoSuchGEMManagementBucketException, SystemException {
		GEMManagementBucket gemManagementBucket = fetchByDepartmentIdAndStatus_First(departmentId,
				activeInd, orderByComparator);

		if (gemManagementBucket != null) {
			return gemManagementBucket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMManagementBucketException(msg.toString());
	}

	/**
	 * Returns the first g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket fetchByDepartmentIdAndStatus_First(
		long departmentId, String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMManagementBucket> list = findByDepartmentIdAndStatus(departmentId,
				activeInd, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket findByDepartmentIdAndStatus_Last(
		long departmentId, String activeInd, OrderByComparator orderByComparator)
		throws NoSuchGEMManagementBucketException, SystemException {
		GEMManagementBucket gemManagementBucket = fetchByDepartmentIdAndStatus_Last(departmentId,
				activeInd, orderByComparator);

		if (gemManagementBucket != null) {
			return gemManagementBucket;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", activeInd=");
		msg.append(activeInd);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMManagementBucketException(msg.toString());
	}

	/**
	 * Returns the last g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m management bucket, or <code>null</code> if a matching g e m management bucket could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket fetchByDepartmentIdAndStatus_Last(
		long departmentId, String activeInd, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartmentIdAndStatus(departmentId, activeInd);

		if (count == 0) {
			return null;
		}

		List<GEMManagementBucket> list = findByDepartmentIdAndStatus(departmentId,
				activeInd, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m management buckets before and after the current g e m management bucket in the ordered set where departmentId = &#63; and activeInd = &#63;.
	 *
	 * @param bucketId the primary key of the current g e m management bucket
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket[] findByDepartmentIdAndStatus_PrevAndNext(
		long bucketId, long departmentId, String activeInd,
		OrderByComparator orderByComparator)
		throws NoSuchGEMManagementBucketException, SystemException {
		GEMManagementBucket gemManagementBucket = findByPrimaryKey(bucketId);

		Session session = null;

		try {
			session = openSession();

			GEMManagementBucket[] array = new GEMManagementBucketImpl[3];

			array[0] = getByDepartmentIdAndStatus_PrevAndNext(session,
					gemManagementBucket, departmentId, activeInd,
					orderByComparator, true);

			array[1] = gemManagementBucket;

			array[2] = getByDepartmentIdAndStatus_PrevAndNext(session,
					gemManagementBucket, departmentId, activeInd,
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

	protected GEMManagementBucket getByDepartmentIdAndStatus_PrevAndNext(
		Session session, GEMManagementBucket gemManagementBucket,
		long departmentId, String activeInd,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMMANAGEMENTBUCKET_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_DEPARTMENTID_2);

		boolean bindActiveInd = false;

		if (activeInd == null) {
			query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_1);
		}
		else if (activeInd.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_3);
		}
		else {
			bindActiveInd = true;

			query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_2);
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
			query.append(GEMManagementBucketModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (bindActiveInd) {
			qPos.add(activeInd);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemManagementBucket);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMManagementBucket> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m management buckets where departmentId = &#63; and activeInd = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDepartmentIdAndStatus(long departmentId,
		String activeInd) throws SystemException {
		for (GEMManagementBucket gemManagementBucket : findByDepartmentIdAndStatus(
				departmentId, activeInd, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(gemManagementBucket);
		}
	}

	/**
	 * Returns the number of g e m management buckets where departmentId = &#63; and activeInd = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param activeInd the active ind
	 * @return the number of matching g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDepartmentIdAndStatus(long departmentId, String activeInd)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENTIDANDSTATUS;

		Object[] finderArgs = new Object[] { departmentId, activeInd };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMMANAGEMENTBUCKET_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_DEPARTMENTID_2);

			boolean bindActiveInd = false;

			if (activeInd == null) {
				query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_1);
			}
			else if (activeInd.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_3);
			}
			else {
				bindActiveInd = true;

				query.append(_FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				if (bindActiveInd) {
					qPos.add(activeInd);
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

	private static final String _FINDER_COLUMN_DEPARTMENTIDANDSTATUS_DEPARTMENTID_2 =
		"gemManagementBucket.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_1 =
		"gemManagementBucket.activeInd IS NULL";
	private static final String _FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_2 =
		"gemManagementBucket.activeInd = ?";
	private static final String _FINDER_COLUMN_DEPARTMENTIDANDSTATUS_ACTIVEIND_3 =
		"(gemManagementBucket.activeInd IS NULL OR gemManagementBucket.activeInd = '')";

	public GEMManagementBucketPersistenceImpl() {
		setModelClass(GEMManagementBucket.class);
	}

	/**
	 * Caches the g e m management bucket in the entity cache if it is enabled.
	 *
	 * @param gemManagementBucket the g e m management bucket
	 */
	@Override
	public void cacheResult(GEMManagementBucket gemManagementBucket) {
		EntityCacheUtil.putResult(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketImpl.class, gemManagementBucket.getPrimaryKey(),
			gemManagementBucket);

		gemManagementBucket.resetOriginalValues();
	}

	/**
	 * Caches the g e m management buckets in the entity cache if it is enabled.
	 *
	 * @param gemManagementBuckets the g e m management buckets
	 */
	@Override
	public void cacheResult(List<GEMManagementBucket> gemManagementBuckets) {
		for (GEMManagementBucket gemManagementBucket : gemManagementBuckets) {
			if (EntityCacheUtil.getResult(
						GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
						GEMManagementBucketImpl.class,
						gemManagementBucket.getPrimaryKey()) == null) {
				cacheResult(gemManagementBucket);
			}
			else {
				gemManagementBucket.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m management buckets.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMManagementBucketImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMManagementBucketImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m management bucket.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMManagementBucket gemManagementBucket) {
		EntityCacheUtil.removeResult(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketImpl.class, gemManagementBucket.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMManagementBucket> gemManagementBuckets) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMManagementBucket gemManagementBucket : gemManagementBuckets) {
			EntityCacheUtil.removeResult(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
				GEMManagementBucketImpl.class,
				gemManagementBucket.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m management bucket with the primary key. Does not add the g e m management bucket to the database.
	 *
	 * @param bucketId the primary key for the new g e m management bucket
	 * @return the new g e m management bucket
	 */
	@Override
	public GEMManagementBucket create(long bucketId) {
		GEMManagementBucket gemManagementBucket = new GEMManagementBucketImpl();

		gemManagementBucket.setNew(true);
		gemManagementBucket.setPrimaryKey(bucketId);

		return gemManagementBucket;
	}

	/**
	 * Removes the g e m management bucket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bucketId the primary key of the g e m management bucket
	 * @return the g e m management bucket that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket remove(long bucketId)
		throws NoSuchGEMManagementBucketException, SystemException {
		return remove((Serializable)bucketId);
	}

	/**
	 * Removes the g e m management bucket with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m management bucket
	 * @return the g e m management bucket that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket remove(Serializable primaryKey)
		throws NoSuchGEMManagementBucketException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMManagementBucket gemManagementBucket = (GEMManagementBucket)session.get(GEMManagementBucketImpl.class,
					primaryKey);

			if (gemManagementBucket == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMManagementBucketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemManagementBucket);
		}
		catch (NoSuchGEMManagementBucketException nsee) {
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
	protected GEMManagementBucket removeImpl(
		GEMManagementBucket gemManagementBucket) throws SystemException {
		gemManagementBucket = toUnwrappedModel(gemManagementBucket);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemManagementBucket)) {
				gemManagementBucket = (GEMManagementBucket)session.get(GEMManagementBucketImpl.class,
						gemManagementBucket.getPrimaryKeyObj());
			}

			if (gemManagementBucket != null) {
				session.delete(gemManagementBucket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemManagementBucket != null) {
			clearCache(gemManagementBucket);
		}

		return gemManagementBucket;
	}

	@Override
	public GEMManagementBucket updateImpl(
		com.ihg.brandstandards.db.model.GEMManagementBucket gemManagementBucket)
		throws SystemException {
		gemManagementBucket = toUnwrappedModel(gemManagementBucket);

		boolean isNew = gemManagementBucket.isNew();

		GEMManagementBucketModelImpl gemManagementBucketModelImpl = (GEMManagementBucketModelImpl)gemManagementBucket;

		Session session = null;

		try {
			session = openSession();

			if (gemManagementBucket.isNew()) {
				session.save(gemManagementBucket);

				gemManagementBucket.setNew(false);
			}
			else {
				session.merge(gemManagementBucket);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMManagementBucketModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemManagementBucketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemManagementBucketModelImpl.getOriginalDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID,
					args);

				args = new Object[] {
						gemManagementBucketModelImpl.getDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTID,
					args);
			}

			if ((gemManagementBucketModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTIDANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemManagementBucketModelImpl.getOriginalDepartmentId(),
						gemManagementBucketModelImpl.getOriginalActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTIDANDSTATUS,
					args);

				args = new Object[] {
						gemManagementBucketModelImpl.getDepartmentId(),
						gemManagementBucketModelImpl.getActiveInd()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTIDANDSTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTIDANDSTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
			GEMManagementBucketImpl.class, gemManagementBucket.getPrimaryKey(),
			gemManagementBucket);

		return gemManagementBucket;
	}

	protected GEMManagementBucket toUnwrappedModel(
		GEMManagementBucket gemManagementBucket) {
		if (gemManagementBucket instanceof GEMManagementBucketImpl) {
			return gemManagementBucket;
		}

		GEMManagementBucketImpl gemManagementBucketImpl = new GEMManagementBucketImpl();

		gemManagementBucketImpl.setNew(gemManagementBucket.isNew());
		gemManagementBucketImpl.setPrimaryKey(gemManagementBucket.getPrimaryKey());

		gemManagementBucketImpl.setBucketId(gemManagementBucket.getBucketId());
		gemManagementBucketImpl.setBucketName(gemManagementBucket.getBucketName());
		gemManagementBucketImpl.setDepartmentId(gemManagementBucket.getDepartmentId());
		gemManagementBucketImpl.setActiveInd(gemManagementBucket.getActiveInd());
		gemManagementBucketImpl.setDisplayOrderNumber(gemManagementBucket.getDisplayOrderNumber());
		gemManagementBucketImpl.setBucketCode(gemManagementBucket.getBucketCode());
		gemManagementBucketImpl.setCreatorId(gemManagementBucket.getCreatorId());
		gemManagementBucketImpl.setCreatedDate(gemManagementBucket.getCreatedDate());
		gemManagementBucketImpl.setUpdatedBy(gemManagementBucket.getUpdatedBy());
		gemManagementBucketImpl.setUpdatedDate(gemManagementBucket.getUpdatedDate());

		return gemManagementBucketImpl;
	}

	/**
	 * Returns the g e m management bucket with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m management bucket
	 * @return the g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMManagementBucketException, SystemException {
		GEMManagementBucket gemManagementBucket = fetchByPrimaryKey(primaryKey);

		if (gemManagementBucket == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMManagementBucketException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemManagementBucket;
	}

	/**
	 * Returns the g e m management bucket with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMManagementBucketException} if it could not be found.
	 *
	 * @param bucketId the primary key of the g e m management bucket
	 * @return the g e m management bucket
	 * @throws com.ihg.brandstandards.db.NoSuchGEMManagementBucketException if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket findByPrimaryKey(long bucketId)
		throws NoSuchGEMManagementBucketException, SystemException {
		return findByPrimaryKey((Serializable)bucketId);
	}

	/**
	 * Returns the g e m management bucket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m management bucket
	 * @return the g e m management bucket, or <code>null</code> if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMManagementBucket gemManagementBucket = (GEMManagementBucket)EntityCacheUtil.getResult(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
				GEMManagementBucketImpl.class, primaryKey);

		if (gemManagementBucket == _nullGEMManagementBucket) {
			return null;
		}

		if (gemManagementBucket == null) {
			Session session = null;

			try {
				session = openSession();

				gemManagementBucket = (GEMManagementBucket)session.get(GEMManagementBucketImpl.class,
						primaryKey);

				if (gemManagementBucket != null) {
					cacheResult(gemManagementBucket);
				}
				else {
					EntityCacheUtil.putResult(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
						GEMManagementBucketImpl.class, primaryKey,
						_nullGEMManagementBucket);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMManagementBucketModelImpl.ENTITY_CACHE_ENABLED,
					GEMManagementBucketImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemManagementBucket;
	}

	/**
	 * Returns the g e m management bucket with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bucketId the primary key of the g e m management bucket
	 * @return the g e m management bucket, or <code>null</code> if a g e m management bucket with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMManagementBucket fetchByPrimaryKey(long bucketId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)bucketId);
	}

	/**
	 * Returns all the g e m management buckets.
	 *
	 * @return the g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m management buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m management buckets
	 * @param end the upper bound of the range of g e m management buckets (not inclusive)
	 * @return the range of g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m management buckets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMManagementBucketModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m management buckets
	 * @param end the upper bound of the range of g e m management buckets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m management buckets
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMManagementBucket> findAll(int start, int end,
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

		List<GEMManagementBucket> list = (List<GEMManagementBucket>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMMANAGEMENTBUCKET);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMMANAGEMENTBUCKET;

				if (pagination) {
					sql = sql.concat(GEMManagementBucketModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMManagementBucket>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMManagementBucket>(list);
				}
				else {
					list = (List<GEMManagementBucket>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the g e m management buckets from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMManagementBucket gemManagementBucket : findAll()) {
			remove(gemManagementBucket);
		}
	}

	/**
	 * Returns the number of g e m management buckets.
	 *
	 * @return the number of g e m management buckets
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

				Query q = session.createQuery(_SQL_COUNT_GEMMANAGEMENTBUCKET);

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
	 * Initializes the g e m management bucket persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMManagementBucket")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMManagementBucket>> listenersList = new ArrayList<ModelListener<GEMManagementBucket>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMManagementBucket>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMManagementBucketImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMMANAGEMENTBUCKET = "SELECT gemManagementBucket FROM GEMManagementBucket gemManagementBucket";
	private static final String _SQL_SELECT_GEMMANAGEMENTBUCKET_WHERE = "SELECT gemManagementBucket FROM GEMManagementBucket gemManagementBucket WHERE ";
	private static final String _SQL_COUNT_GEMMANAGEMENTBUCKET = "SELECT COUNT(gemManagementBucket) FROM GEMManagementBucket gemManagementBucket";
	private static final String _SQL_COUNT_GEMMANAGEMENTBUCKET_WHERE = "SELECT COUNT(gemManagementBucket) FROM GEMManagementBucket gemManagementBucket WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemManagementBucket.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMManagementBucket exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMManagementBucket exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMManagementBucketPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"bucketId", "bucketName", "departmentId", "activeInd",
				"displayOrderNumber", "bucketCode", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static GEMManagementBucket _nullGEMManagementBucket = new GEMManagementBucketImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMManagementBucket> toCacheModel() {
				return _nullGEMManagementBucketCacheModel;
			}
		};

	private static CacheModel<GEMManagementBucket> _nullGEMManagementBucketCacheModel =
		new CacheModel<GEMManagementBucket>() {
			@Override
			public GEMManagementBucket toEntityModel() {
				return _nullGEMManagementBucket;
			}
		};
}