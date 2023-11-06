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

import com.ihg.brandstandards.db.NoSuchStandardsStatusException;
import com.ihg.brandstandards.db.model.StandardsStatus;
import com.ihg.brandstandards.db.model.impl.StandardsStatusImpl;
import com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl;

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
 * The persistence implementation for the standards status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsStatusPersistence
 * @see StandardsStatusUtil
 * @generated
 */
public class StandardsStatusPersistenceImpl extends BasePersistenceImpl<StandardsStatus>
	implements StandardsStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsStatusUtil} to access the standards status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED,
			StandardsStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED,
			StandardsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID = new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED,
			StandardsStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRegionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID =
		new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED,
			StandardsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRegionId",
			new String[] { Long.class.getName() },
			StandardsStatusModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONID = new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards statuses where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findByRegionId(long regionId)
		throws SystemException {
		return findByRegionId(regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the standards statuses where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of standards statuses
	 * @param end the upper bound of the range of standards statuses (not inclusive)
	 * @return the range of matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findByRegionId(long regionId, int start,
		int end) throws SystemException {
		return findByRegionId(regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards statuses where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of standards statuses
	 * @param end the upper bound of the range of standards statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findByRegionId(long regionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { regionId, start, end, orderByComparator };
		}

		List<StandardsStatus> list = (List<StandardsStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsStatus standardsStatus : list) {
				if ((regionId != standardsStatus.getRegionId())) {
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

			query.append(_SQL_SELECT_STANDARDSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<StandardsStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsStatus>(list);
				}
				else {
					list = (List<StandardsStatus>)QueryUtil.list(q,
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
	 * Returns the first standards status in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus findByRegionId_First(long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsStatusException, SystemException {
		StandardsStatus standardsStatus = fetchByRegionId_First(regionId,
				orderByComparator);

		if (standardsStatus != null) {
			return standardsStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsStatusException(msg.toString());
	}

	/**
	 * Returns the first standards status in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards status, or <code>null</code> if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus fetchByRegionId_First(long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsStatus> list = findByRegionId(regionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards status in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus findByRegionId_Last(long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsStatusException, SystemException {
		StandardsStatus standardsStatus = fetchByRegionId_Last(regionId,
				orderByComparator);

		if (standardsStatus != null) {
			return standardsStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsStatusException(msg.toString());
	}

	/**
	 * Returns the last standards status in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards status, or <code>null</code> if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus fetchByRegionId_Last(long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRegionId(regionId);

		if (count == 0) {
			return null;
		}

		List<StandardsStatus> list = findByRegionId(regionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards statuses before and after the current standards status in the ordered set where regionId = &#63;.
	 *
	 * @param statusId the primary key of the current standards status
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus[] findByRegionId_PrevAndNext(long statusId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchStandardsStatusException, SystemException {
		StandardsStatus standardsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			StandardsStatus[] array = new StandardsStatusImpl[3];

			array[0] = getByRegionId_PrevAndNext(session, standardsStatus,
					regionId, orderByComparator, true);

			array[1] = standardsStatus;

			array[2] = getByRegionId_PrevAndNext(session, standardsStatus,
					regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsStatus getByRegionId_PrevAndNext(Session session,
		StandardsStatus standardsStatus, long regionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSSTATUS_WHERE);

		query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

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
			query.append(StandardsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards statuses where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRegionId(long regionId) throws SystemException {
		for (StandardsStatus standardsStatus : findByRegionId(regionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsStatus);
		}
	}

	/**
	 * Returns the number of standards statuses where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegionId(long regionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONID;

		Object[] finderArgs = new Object[] { regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSSTATUS_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

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

	private static final String _FINDER_COLUMN_REGIONID_REGIONID_2 = "standardsStatus.regionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSCODE =
		new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED,
			StandardsStatusImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatusCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSCODE =
		new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED,
			StandardsStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusCode",
			new String[] { String.class.getName() },
			StandardsStatusModelImpl.STATUSCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUSCODE = new FinderPath(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatusCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the standards statuses where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @return the matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findByStatusCode(String statusCode)
		throws SystemException {
		return findByStatusCode(statusCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards statuses where statusCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param statusCode the status code
	 * @param start the lower bound of the range of standards statuses
	 * @param end the upper bound of the range of standards statuses (not inclusive)
	 * @return the range of matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findByStatusCode(String statusCode, int start,
		int end) throws SystemException {
		return findByStatusCode(statusCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards statuses where statusCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param statusCode the status code
	 * @param start the lower bound of the range of standards statuses
	 * @param end the upper bound of the range of standards statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findByStatusCode(String statusCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSCODE;
			finderArgs = new Object[] { statusCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUSCODE;
			finderArgs = new Object[] { statusCode, start, end, orderByComparator };
		}

		List<StandardsStatus> list = (List<StandardsStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsStatus standardsStatus : list) {
				if (!Validator.equals(statusCode,
							standardsStatus.getStatusCode())) {
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

			query.append(_SQL_SELECT_STANDARDSSTATUS_WHERE);

			boolean bindStatusCode = false;

			if (statusCode == null) {
				query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_1);
			}
			else if (statusCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_3);
			}
			else {
				bindStatusCode = true;

				query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatusCode) {
					qPos.add(statusCode);
				}

				if (!pagination) {
					list = (List<StandardsStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsStatus>(list);
				}
				else {
					list = (List<StandardsStatus>)QueryUtil.list(q,
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
	 * Returns the first standards status in the ordered set where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus findByStatusCode_First(String statusCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsStatusException, SystemException {
		StandardsStatus standardsStatus = fetchByStatusCode_First(statusCode,
				orderByComparator);

		if (standardsStatus != null) {
			return standardsStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusCode=");
		msg.append(statusCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsStatusException(msg.toString());
	}

	/**
	 * Returns the first standards status in the ordered set where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards status, or <code>null</code> if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus fetchByStatusCode_First(String statusCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsStatus> list = findByStatusCode(statusCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards status in the ordered set where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus findByStatusCode_Last(String statusCode,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsStatusException, SystemException {
		StandardsStatus standardsStatus = fetchByStatusCode_Last(statusCode,
				orderByComparator);

		if (standardsStatus != null) {
			return standardsStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("statusCode=");
		msg.append(statusCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsStatusException(msg.toString());
	}

	/**
	 * Returns the last standards status in the ordered set where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards status, or <code>null</code> if a matching standards status could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus fetchByStatusCode_Last(String statusCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatusCode(statusCode);

		if (count == 0) {
			return null;
		}

		List<StandardsStatus> list = findByStatusCode(statusCode, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards statuses before and after the current standards status in the ordered set where statusCode = &#63;.
	 *
	 * @param statusId the primary key of the current standards status
	 * @param statusCode the status code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus[] findByStatusCode_PrevAndNext(long statusId,
		String statusCode, OrderByComparator orderByComparator)
		throws NoSuchStandardsStatusException, SystemException {
		StandardsStatus standardsStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			StandardsStatus[] array = new StandardsStatusImpl[3];

			array[0] = getByStatusCode_PrevAndNext(session, standardsStatus,
					statusCode, orderByComparator, true);

			array[1] = standardsStatus;

			array[2] = getByStatusCode_PrevAndNext(session, standardsStatus,
					statusCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsStatus getByStatusCode_PrevAndNext(Session session,
		StandardsStatus standardsStatus, String statusCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSSTATUS_WHERE);

		boolean bindStatusCode = false;

		if (statusCode == null) {
			query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_1);
		}
		else if (statusCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_3);
		}
		else {
			bindStatusCode = true;

			query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_2);
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
			query.append(StandardsStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatusCode) {
			qPos.add(statusCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsStatus);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards statuses where statusCode = &#63; from the database.
	 *
	 * @param statusCode the status code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatusCode(String statusCode) throws SystemException {
		for (StandardsStatus standardsStatus : findByStatusCode(statusCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsStatus);
		}
	}

	/**
	 * Returns the number of standards statuses where statusCode = &#63;.
	 *
	 * @param statusCode the status code
	 * @return the number of matching standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatusCode(String statusCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUSCODE;

		Object[] finderArgs = new Object[] { statusCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSSTATUS_WHERE);

			boolean bindStatusCode = false;

			if (statusCode == null) {
				query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_1);
			}
			else if (statusCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_3);
			}
			else {
				bindStatusCode = true;

				query.append(_FINDER_COLUMN_STATUSCODE_STATUSCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatusCode) {
					qPos.add(statusCode);
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

	private static final String _FINDER_COLUMN_STATUSCODE_STATUSCODE_1 = "standardsStatus.statusCode IS NULL";
	private static final String _FINDER_COLUMN_STATUSCODE_STATUSCODE_2 = "standardsStatus.statusCode = ?";
	private static final String _FINDER_COLUMN_STATUSCODE_STATUSCODE_3 = "(standardsStatus.statusCode IS NULL OR standardsStatus.statusCode = '')";

	public StandardsStatusPersistenceImpl() {
		setModelClass(StandardsStatus.class);
	}

	/**
	 * Caches the standards status in the entity cache if it is enabled.
	 *
	 * @param standardsStatus the standards status
	 */
	@Override
	public void cacheResult(StandardsStatus standardsStatus) {
		EntityCacheUtil.putResult(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusImpl.class, standardsStatus.getPrimaryKey(),
			standardsStatus);

		standardsStatus.resetOriginalValues();
	}

	/**
	 * Caches the standards statuses in the entity cache if it is enabled.
	 *
	 * @param standardsStatuses the standards statuses
	 */
	@Override
	public void cacheResult(List<StandardsStatus> standardsStatuses) {
		for (StandardsStatus standardsStatus : standardsStatuses) {
			if (EntityCacheUtil.getResult(
						StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
						StandardsStatusImpl.class,
						standardsStatus.getPrimaryKey()) == null) {
				cacheResult(standardsStatus);
			}
			else {
				standardsStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsStatus standardsStatus) {
		EntityCacheUtil.removeResult(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusImpl.class, standardsStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsStatus> standardsStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsStatus standardsStatus : standardsStatuses) {
			EntityCacheUtil.removeResult(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
				StandardsStatusImpl.class, standardsStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards status with the primary key. Does not add the standards status to the database.
	 *
	 * @param statusId the primary key for the new standards status
	 * @return the new standards status
	 */
	@Override
	public StandardsStatus create(long statusId) {
		StandardsStatus standardsStatus = new StandardsStatusImpl();

		standardsStatus.setNew(true);
		standardsStatus.setPrimaryKey(statusId);

		return standardsStatus;
	}

	/**
	 * Removes the standards status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statusId the primary key of the standards status
	 * @return the standards status that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus remove(long statusId)
		throws NoSuchStandardsStatusException, SystemException {
		return remove((Serializable)statusId);
	}

	/**
	 * Removes the standards status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards status
	 * @return the standards status that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus remove(Serializable primaryKey)
		throws NoSuchStandardsStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsStatus standardsStatus = (StandardsStatus)session.get(StandardsStatusImpl.class,
					primaryKey);

			if (standardsStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsStatus);
		}
		catch (NoSuchStandardsStatusException nsee) {
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
	protected StandardsStatus removeImpl(StandardsStatus standardsStatus)
		throws SystemException {
		standardsStatus = toUnwrappedModel(standardsStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsStatus)) {
				standardsStatus = (StandardsStatus)session.get(StandardsStatusImpl.class,
						standardsStatus.getPrimaryKeyObj());
			}

			if (standardsStatus != null) {
				session.delete(standardsStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsStatus != null) {
			clearCache(standardsStatus);
		}

		return standardsStatus;
	}

	@Override
	public StandardsStatus updateImpl(
		com.ihg.brandstandards.db.model.StandardsStatus standardsStatus)
		throws SystemException {
		standardsStatus = toUnwrappedModel(standardsStatus);

		boolean isNew = standardsStatus.isNew();

		StandardsStatusModelImpl standardsStatusModelImpl = (StandardsStatusModelImpl)standardsStatus;

		Session session = null;

		try {
			session = openSession();

			if (standardsStatus.isNew()) {
				session.save(standardsStatus);

				standardsStatus.setNew(false);
			}
			else {
				session.merge(standardsStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsStatusModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsStatusModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);

				args = new Object[] { standardsStatusModelImpl.getRegionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);
			}

			if ((standardsStatusModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsStatusModelImpl.getOriginalStatusCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSCODE,
					args);

				args = new Object[] { standardsStatusModelImpl.getStatusCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUSCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUSCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
			StandardsStatusImpl.class, standardsStatus.getPrimaryKey(),
			standardsStatus);

		return standardsStatus;
	}

	protected StandardsStatus toUnwrappedModel(StandardsStatus standardsStatus) {
		if (standardsStatus instanceof StandardsStatusImpl) {
			return standardsStatus;
		}

		StandardsStatusImpl standardsStatusImpl = new StandardsStatusImpl();

		standardsStatusImpl.setNew(standardsStatus.isNew());
		standardsStatusImpl.setPrimaryKey(standardsStatus.getPrimaryKey());

		standardsStatusImpl.setStatusId(standardsStatus.getStatusId());
		standardsStatusImpl.setStatusCode(standardsStatus.getStatusCode());
		standardsStatusImpl.setTitle(standardsStatus.getTitle());
		standardsStatusImpl.setRegionId(standardsStatus.getRegionId());
		standardsStatusImpl.setCreatorId(standardsStatus.getCreatorId());
		standardsStatusImpl.setCreatedDate(standardsStatus.getCreatedDate());
		standardsStatusImpl.setUpdatedBy(standardsStatus.getUpdatedBy());
		standardsStatusImpl.setUpdatedDate(standardsStatus.getUpdatedDate());

		return standardsStatusImpl;
	}

	/**
	 * Returns the standards status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards status
	 * @return the standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsStatusException, SystemException {
		StandardsStatus standardsStatus = fetchByPrimaryKey(primaryKey);

		if (standardsStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsStatus;
	}

	/**
	 * Returns the standards status with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsStatusException} if it could not be found.
	 *
	 * @param statusId the primary key of the standards status
	 * @return the standards status
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsStatusException if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus findByPrimaryKey(long statusId)
		throws NoSuchStandardsStatusException, SystemException {
		return findByPrimaryKey((Serializable)statusId);
	}

	/**
	 * Returns the standards status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards status
	 * @return the standards status, or <code>null</code> if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsStatus standardsStatus = (StandardsStatus)EntityCacheUtil.getResult(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
				StandardsStatusImpl.class, primaryKey);

		if (standardsStatus == _nullStandardsStatus) {
			return null;
		}

		if (standardsStatus == null) {
			Session session = null;

			try {
				session = openSession();

				standardsStatus = (StandardsStatus)session.get(StandardsStatusImpl.class,
						primaryKey);

				if (standardsStatus != null) {
					cacheResult(standardsStatus);
				}
				else {
					EntityCacheUtil.putResult(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
						StandardsStatusImpl.class, primaryKey,
						_nullStandardsStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsStatusModelImpl.ENTITY_CACHE_ENABLED,
					StandardsStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsStatus;
	}

	/**
	 * Returns the standards status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statusId the primary key of the standards status
	 * @return the standards status, or <code>null</code> if a standards status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsStatus fetchByPrimaryKey(long statusId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)statusId);
	}

	/**
	 * Returns all the standards statuses.
	 *
	 * @return the standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards statuses
	 * @param end the upper bound of the range of standards statuses (not inclusive)
	 * @return the range of standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards statuses
	 * @param end the upper bound of the range of standards statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsStatus> findAll(int start, int end,
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

		List<StandardsStatus> list = (List<StandardsStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSSTATUS;

				if (pagination) {
					sql = sql.concat(StandardsStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsStatus>(list);
				}
				else {
					list = (List<StandardsStatus>)QueryUtil.list(q,
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
	 * Removes all the standards statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsStatus standardsStatus : findAll()) {
			remove(standardsStatus);
		}
	}

	/**
	 * Returns the number of standards statuses.
	 *
	 * @return the number of standards statuses
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSSTATUS);

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
	 * Initializes the standards status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsStatus>> listenersList = new ArrayList<ModelListener<StandardsStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSSTATUS = "SELECT standardsStatus FROM StandardsStatus standardsStatus";
	private static final String _SQL_SELECT_STANDARDSSTATUS_WHERE = "SELECT standardsStatus FROM StandardsStatus standardsStatus WHERE ";
	private static final String _SQL_COUNT_STANDARDSSTATUS = "SELECT COUNT(standardsStatus) FROM StandardsStatus standardsStatus";
	private static final String _SQL_COUNT_STANDARDSSTATUS_WHERE = "SELECT COUNT(standardsStatus) FROM StandardsStatus standardsStatus WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsStatus exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsStatus exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsStatusPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"statusId", "statusCode", "title", "regionId", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static StandardsStatus _nullStandardsStatus = new StandardsStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsStatus> toCacheModel() {
				return _nullStandardsStatusCacheModel;
			}
		};

	private static CacheModel<StandardsStatus> _nullStandardsStatusCacheModel = new CacheModel<StandardsStatus>() {
			@Override
			public StandardsStatus toEntityModel() {
				return _nullStandardsStatus;
			}
		};
}