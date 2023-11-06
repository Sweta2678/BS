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

import com.ihg.brandstandards.db.NoSuchStandardsException;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.impl.StandardsImpl;
import com.ihg.brandstandards.db.model.impl.StandardsModelImpl;

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
 * The persistence implementation for the standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsPersistence
 * @see StandardsUtil
 * @generated
 */
public class StandardsPersistenceImpl extends BasePersistenceImpl<Standards>
	implements StandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsUtil} to access the standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_STDID = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStdId",
			new String[] { Long.class.getName() },
			StandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the standards where stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @return the matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByStdId(long stdId)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByStdId(stdId);

		if (standards == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsException(msg.toString());
		}

		return standards;
	}

	/**
	 * Returns the standards where stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @return the matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByStdId(long stdId) throws SystemException {
		return fetchByStdId(stdId, true);
	}

	/**
	 * Returns the standards where stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByStdId(long stdId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDID,
					finderArgs, this);
		}

		if (result instanceof Standards) {
			Standards standards = (Standards)result;

			if ((stdId != standards.getStdId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				List<Standards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsPersistenceImpl.fetchByStdId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Standards standards = list.get(0);

					result = standards;

					cacheResult(standards);

					if ((standards.getStdId() != stdId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
							finderArgs, standards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID,
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
			return (Standards)result;
		}
	}

	/**
	 * Removes the standards where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @return the standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards removeByStdId(long stdId)
		throws NoSuchStandardsException, SystemException {
		Standards standards = findByStdId(stdId);

		return remove(standards);
	}

	/**
	 * Returns the number of standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdId(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDID;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standards.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] { Long.class.getName() },
			StandardsModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standardses where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByParentId(long parentId)
		throws SystemException {
		return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the standardses where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @return the range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByParentId(long parentId, int start, int end)
		throws SystemException {
		return findByParentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standardses where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByParentId(long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<Standards> list = (List<Standards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Standards standards : list) {
				if ((parentId != standards.getParentId())) {
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

			query.append(_SQL_SELECT_STANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Standards>(list);
				}
				else {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first standards in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByParentId_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByParentId_First(parentId, orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the first standards in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByParentId_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Standards> list = findByParentId(parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByParentId_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByParentId_Last(parentId, orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the last standards in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByParentId_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByParentId(parentId);

		if (count == 0) {
			return null;
		}

		List<Standards> list = findByParentId(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standardses before and after the current standards in the ordered set where parentId = &#63;.
	 *
	 * @param stdId the primary key of the current standards
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards[] findByParentId_PrevAndNext(long stdId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = findByPrimaryKey(stdId);

		Session session = null;

		try {
			session = openSession();

			Standards[] array = new StandardsImpl[3];

			array[0] = getByParentId_PrevAndNext(session, standards, parentId,
					orderByComparator, true);

			array[1] = standards;

			array[2] = getByParentId_PrevAndNext(session, standards, parentId,
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

	protected Standards getByParentId_PrevAndNext(Session session,
		Standards standards, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDS_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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
			query.append(StandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Standards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standardses where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByParentId(long parentId) throws SystemException {
		for (Standards standards : findByParentId(parentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standards);
		}
	}

	/**
	 * Returns the number of standardses where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByParentId(long parentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDS_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "standards.parentId = ? AND standards.stdId!=standards.parentId";
	public static final FinderPath FINDER_PATH_FETCH_BY_STDTYP = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBystdTyp",
			new String[] { String.class.getName() },
			StandardsModelImpl.STDTYP_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDTYP = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystdTyp",
			new String[] { String.class.getName() });

	/**
	 * Returns the standards where stdTyp = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	 *
	 * @param stdTyp the std typ
	 * @return the matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findBystdTyp(String stdTyp)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchBystdTyp(stdTyp);

		if (standards == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdTyp=");
			msg.append(stdTyp);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsException(msg.toString());
		}

		return standards;
	}

	/**
	 * Returns the standards where stdTyp = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdTyp the std typ
	 * @return the matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchBystdTyp(String stdTyp) throws SystemException {
		return fetchBystdTyp(stdTyp, true);
	}

	/**
	 * Returns the standards where stdTyp = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdTyp the std typ
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchBystdTyp(String stdTyp, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { stdTyp };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STDTYP,
					finderArgs, this);
		}

		if (result instanceof Standards) {
			Standards standards = (Standards)result;

			if (!Validator.equals(stdTyp, standards.getStdTyp())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STANDARDS_WHERE);

			boolean bindStdTyp = false;

			if (stdTyp == null) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_1);
			}
			else if (stdTyp.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_3);
			}
			else {
				bindStdTyp = true;

				query.append(_FINDER_COLUMN_STDTYP_STDTYP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStdTyp) {
					qPos.add(stdTyp);
				}

				List<Standards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsPersistenceImpl.fetchBystdTyp(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Standards standards = list.get(0);

					result = standards;

					cacheResult(standards);

					if ((standards.getStdTyp() == null) ||
							!standards.getStdTyp().equals(stdTyp)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP,
							finderArgs, standards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDTYP,
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
			return (Standards)result;
		}
	}

	/**
	 * Removes the standards where stdTyp = &#63; from the database.
	 *
	 * @param stdTyp the std typ
	 * @return the standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards removeBystdTyp(String stdTyp)
		throws NoSuchStandardsException, SystemException {
		Standards standards = findBystdTyp(stdTyp);

		return remove(standards);
	}

	/**
	 * Returns the number of standardses where stdTyp = &#63;.
	 *
	 * @param stdTyp the std typ
	 * @return the number of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdTyp(String stdTyp) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDTYP;

		Object[] finderArgs = new Object[] { stdTyp };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDS_WHERE);

			boolean bindStdTyp = false;

			if (stdTyp == null) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_1);
			}
			else if (stdTyp.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDTYP_STDTYP_3);
			}
			else {
				bindStdTyp = true;

				query.append(_FINDER_COLUMN_STDTYP_STDTYP_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStdTyp) {
					qPos.add(stdTyp);
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

	private static final String _FINDER_COLUMN_STDTYP_STDTYP_1 = "standards.stdTyp IS NULL";
	private static final String _FINDER_COLUMN_STDTYP_STDTYP_2 = "standards.stdTyp = ?";
	private static final String _FINDER_COLUMN_STDTYP_STDTYP_3 = "(standards.stdTyp IS NULL OR standards.stdTyp = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_STATUS = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBystatus",
			new String[] { String.class.getName() },
			StandardsModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] { String.class.getName() });

	/**
	 * Returns the standards where status = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	 *
	 * @param status the status
	 * @return the matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findBystatus(String status)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchBystatus(status);

		if (standards == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsException(msg.toString());
		}

		return standards;
	}

	/**
	 * Returns the standards where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchBystatus(String status) throws SystemException {
		return fetchBystatus(status, true);
	}

	/**
	 * Returns the standards where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchBystatus(String status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STATUS,
					finderArgs, this);
		}

		if (result instanceof Standards) {
			Standards standards = (Standards)result;

			if (!Validator.equals(status, standards.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STANDARDS_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				List<Standards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsPersistenceImpl.fetchBystatus(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Standards standards = list.get(0);

					result = standards;

					cacheResult(standards);

					if ((standards.getStatus() == null) ||
							!standards.getStatus().equals(status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
							finderArgs, standards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS,
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
			return (Standards)result;
		}
	}

	/**
	 * Removes the standards where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards removeBystatus(String status)
		throws NoSuchStandardsException, SystemException {
		Standards standards = findBystatus(status);

		return remove(standards);
	}

	/**
	 * Returns the number of standardses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystatus(String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDS_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "standards.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "standards.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(standards.status IS NULL OR standards.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAuthor",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR =
		new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAuthor",
			new String[] { String.class.getName() },
			StandardsModelImpl.AUTHOR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHOR = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAuthor",
			new String[] { String.class.getName() });

	/**
	 * Returns all the standardses where author = &#63;.
	 *
	 * @param author the author
	 * @return the matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByAuthor(String author)
		throws SystemException {
		return findByAuthor(author, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standardses where author = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param author the author
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @return the range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByAuthor(String author, int start, int end)
		throws SystemException {
		return findByAuthor(author, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standardses where author = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param author the author
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByAuthor(String author, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { author };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHOR;
			finderArgs = new Object[] { author, start, end, orderByComparator };
		}

		List<Standards> list = (List<Standards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Standards standards : list) {
				if (!Validator.equals(author, standards.getAuthor())) {
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

			query.append(_SQL_SELECT_STANDARDS_WHERE);

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthor) {
					qPos.add(author);
				}

				if (!pagination) {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Standards>(list);
				}
				else {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first standards in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByAuthor_First(String author,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByAuthor_First(author, orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("author=");
		msg.append(author);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the first standards in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByAuthor_First(String author,
		OrderByComparator orderByComparator) throws SystemException {
		List<Standards> list = findByAuthor(author, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByAuthor_Last(String author,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByAuthor_Last(author, orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("author=");
		msg.append(author);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the last standards in the ordered set where author = &#63;.
	 *
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByAuthor_Last(String author,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAuthor(author);

		if (count == 0) {
			return null;
		}

		List<Standards> list = findByAuthor(author, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standardses before and after the current standards in the ordered set where author = &#63;.
	 *
	 * @param stdId the primary key of the current standards
	 * @param author the author
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards[] findByAuthor_PrevAndNext(long stdId, String author,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = findByPrimaryKey(stdId);

		Session session = null;

		try {
			session = openSession();

			Standards[] array = new StandardsImpl[3];

			array[0] = getByAuthor_PrevAndNext(session, standards, author,
					orderByComparator, true);

			array[1] = standards;

			array[2] = getByAuthor_PrevAndNext(session, standards, author,
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

	protected Standards getByAuthor_PrevAndNext(Session session,
		Standards standards, String author,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDS_WHERE);

		boolean bindAuthor = false;

		if (author == null) {
			query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
		}
		else if (author.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
		}
		else {
			bindAuthor = true;

			query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
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
			query.append(StandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAuthor) {
			qPos.add(author);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Standards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standardses where author = &#63; from the database.
	 *
	 * @param author the author
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthor(String author) throws SystemException {
		for (Standards standards : findByAuthor(author, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(standards);
		}
	}

	/**
	 * Returns the number of standardses where author = &#63;.
	 *
	 * @param author the author
	 * @return the number of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthor(String author) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHOR;

		Object[] finderArgs = new Object[] { author };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDS_WHERE);

			boolean bindAuthor = false;

			if (author == null) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_1);
			}
			else if (author.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_3);
			}
			else {
				bindAuthor = true;

				query.append(_FINDER_COLUMN_AUTHOR_AUTHOR_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthor) {
					qPos.add(author);
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

	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_1 = "standards.author IS NULL";
	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_2 = "standards.author = ?";
	private static final String _FINDER_COLUMN_AUTHOR_AUTHOR_3 = "(standards.author IS NULL OR standards.author = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSOWNER =
		new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBusinessOwner",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSOWNER =
		new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBusinessOwner",
			new String[] { String.class.getName() },
			StandardsModelImpl.BUSINESSOWNER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUSINESSOWNER = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBusinessOwner",
			new String[] { String.class.getName() });

	/**
	 * Returns all the standardses where businessOwner = &#63;.
	 *
	 * @param businessOwner the business owner
	 * @return the matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByBusinessOwner(String businessOwner)
		throws SystemException {
		return findByBusinessOwner(businessOwner, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standardses where businessOwner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessOwner the business owner
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @return the range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByBusinessOwner(String businessOwner, int start,
		int end) throws SystemException {
		return findByBusinessOwner(businessOwner, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standardses where businessOwner = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessOwner the business owner
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByBusinessOwner(String businessOwner, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSOWNER;
			finderArgs = new Object[] { businessOwner };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSOWNER;
			finderArgs = new Object[] {
					businessOwner,
					
					start, end, orderByComparator
				};
		}

		List<Standards> list = (List<Standards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Standards standards : list) {
				if (!Validator.equals(businessOwner,
							standards.getBusinessOwner())) {
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

			query.append(_SQL_SELECT_STANDARDS_WHERE);

			boolean bindBusinessOwner = false;

			if (businessOwner == null) {
				query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_1);
			}
			else if (businessOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_3);
			}
			else {
				bindBusinessOwner = true;

				query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBusinessOwner) {
					qPos.add(businessOwner);
				}

				if (!pagination) {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Standards>(list);
				}
				else {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first standards in the ordered set where businessOwner = &#63;.
	 *
	 * @param businessOwner the business owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByBusinessOwner_First(String businessOwner,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByBusinessOwner_First(businessOwner,
				orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessOwner=");
		msg.append(businessOwner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the first standards in the ordered set where businessOwner = &#63;.
	 *
	 * @param businessOwner the business owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByBusinessOwner_First(String businessOwner,
		OrderByComparator orderByComparator) throws SystemException {
		List<Standards> list = findByBusinessOwner(businessOwner, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards in the ordered set where businessOwner = &#63;.
	 *
	 * @param businessOwner the business owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByBusinessOwner_Last(String businessOwner,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByBusinessOwner_Last(businessOwner,
				orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessOwner=");
		msg.append(businessOwner);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the last standards in the ordered set where businessOwner = &#63;.
	 *
	 * @param businessOwner the business owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByBusinessOwner_Last(String businessOwner,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBusinessOwner(businessOwner);

		if (count == 0) {
			return null;
		}

		List<Standards> list = findByBusinessOwner(businessOwner, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standardses before and after the current standards in the ordered set where businessOwner = &#63;.
	 *
	 * @param stdId the primary key of the current standards
	 * @param businessOwner the business owner
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards[] findByBusinessOwner_PrevAndNext(long stdId,
		String businessOwner, OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = findByPrimaryKey(stdId);

		Session session = null;

		try {
			session = openSession();

			Standards[] array = new StandardsImpl[3];

			array[0] = getByBusinessOwner_PrevAndNext(session, standards,
					businessOwner, orderByComparator, true);

			array[1] = standards;

			array[2] = getByBusinessOwner_PrevAndNext(session, standards,
					businessOwner, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Standards getByBusinessOwner_PrevAndNext(Session session,
		Standards standards, String businessOwner,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDS_WHERE);

		boolean bindBusinessOwner = false;

		if (businessOwner == null) {
			query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_1);
		}
		else if (businessOwner.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_3);
		}
		else {
			bindBusinessOwner = true;

			query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_2);
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
			query.append(StandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBusinessOwner) {
			qPos.add(businessOwner);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Standards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standardses where businessOwner = &#63; from the database.
	 *
	 * @param businessOwner the business owner
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBusinessOwner(String businessOwner)
		throws SystemException {
		for (Standards standards : findByBusinessOwner(businessOwner,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standards);
		}
	}

	/**
	 * Returns the number of standardses where businessOwner = &#63;.
	 *
	 * @param businessOwner the business owner
	 * @return the number of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBusinessOwner(String businessOwner)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BUSINESSOWNER;

		Object[] finderArgs = new Object[] { businessOwner };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDS_WHERE);

			boolean bindBusinessOwner = false;

			if (businessOwner == null) {
				query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_1);
			}
			else if (businessOwner.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_3);
			}
			else {
				bindBusinessOwner = true;

				query.append(_FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBusinessOwner) {
					qPos.add(businessOwner);
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

	private static final String _FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_1 = "standards.businessOwner IS NULL";
	private static final String _FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_2 = "standards.businessOwner = ?";
	private static final String _FINDER_COLUMN_BUSINESSOWNER_BUSINESSOWNER_3 = "(standards.businessOwner IS NULL OR standards.businessOwner = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONCODEANDPARENTID =
		new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByregionCodeAndParentId",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODEANDPARENTID =
		new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, StandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByregionCodeAndParentId",
			new String[] { String.class.getName(), Long.class.getName() },
			StandardsModelImpl.REGIONCODE_COLUMN_BITMASK |
			StandardsModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONCODEANDPARENTID = new FinderPath(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByregionCodeAndParentId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the standardses where regionCode = &#63; and parentId = &#63;.
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @return the matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByregionCodeAndParentId(String regionCode,
		long parentId) throws SystemException {
		return findByregionCodeAndParentId(regionCode, parentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standardses where regionCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @return the range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByregionCodeAndParentId(String regionCode,
		long parentId, int start, int end) throws SystemException {
		return findByregionCodeAndParentId(regionCode, parentId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the standardses where regionCode = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findByregionCodeAndParentId(String regionCode,
		long parentId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODEANDPARENTID;
			finderArgs = new Object[] { regionCode, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONCODEANDPARENTID;
			finderArgs = new Object[] {
					regionCode, parentId,
					
					start, end, orderByComparator
				};
		}

		List<Standards> list = (List<Standards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Standards standards : list) {
				if (!Validator.equals(regionCode, standards.getRegionCode()) ||
						(parentId != standards.getParentId())) {
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

			query.append(_SQL_SELECT_STANDARDS_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_2);
			}

			query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Standards>(list);
				}
				else {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByregionCodeAndParentId_First(String regionCode,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByregionCodeAndParentId_First(regionCode,
				parentId, orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionCode=");
		msg.append(regionCode);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the first standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByregionCodeAndParentId_First(String regionCode,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<Standards> list = findByregionCodeAndParentId(regionCode,
				parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByregionCodeAndParentId_Last(String regionCode,
		long parentId, OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByregionCodeAndParentId_Last(regionCode,
				parentId, orderByComparator);

		if (standards != null) {
			return standards;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionCode=");
		msg.append(regionCode);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsException(msg.toString());
	}

	/**
	 * Returns the last standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards, or <code>null</code> if a matching standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByregionCodeAndParentId_Last(String regionCode,
		long parentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByregionCodeAndParentId(regionCode, parentId);

		if (count == 0) {
			return null;
		}

		List<Standards> list = findByregionCodeAndParentId(regionCode,
				parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standardses before and after the current standards in the ordered set where regionCode = &#63; and parentId = &#63;.
	 *
	 * @param stdId the primary key of the current standards
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards[] findByregionCodeAndParentId_PrevAndNext(long stdId,
		String regionCode, long parentId, OrderByComparator orderByComparator)
		throws NoSuchStandardsException, SystemException {
		Standards standards = findByPrimaryKey(stdId);

		Session session = null;

		try {
			session = openSession();

			Standards[] array = new StandardsImpl[3];

			array[0] = getByregionCodeAndParentId_PrevAndNext(session,
					standards, regionCode, parentId, orderByComparator, true);

			array[1] = standards;

			array[2] = getByregionCodeAndParentId_PrevAndNext(session,
					standards, regionCode, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Standards getByregionCodeAndParentId_PrevAndNext(
		Session session, Standards standards, String regionCode, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDS_WHERE);

		boolean bindRegionCode = false;

		if (regionCode == null) {
			query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_1);
		}
		else if (regionCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_3);
		}
		else {
			bindRegionCode = true;

			query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_2);
		}

		query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_PARENTID_2);

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
			query.append(StandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRegionCode) {
			qPos.add(regionCode);
		}

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Standards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standardses where regionCode = &#63; and parentId = &#63; from the database.
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByregionCodeAndParentId(String regionCode, long parentId)
		throws SystemException {
		for (Standards standards : findByregionCodeAndParentId(regionCode,
				parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standards);
		}
	}

	/**
	 * Returns the number of standardses where regionCode = &#63; and parentId = &#63;.
	 *
	 * @param regionCode the region code
	 * @param parentId the parent ID
	 * @return the number of matching standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByregionCodeAndParentId(String regionCode, long parentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONCODEANDPARENTID;

		Object[] finderArgs = new Object[] { regionCode, parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDS_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_2);
			}

			query.append(_FINDER_COLUMN_REGIONCODEANDPARENTID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_1 =
		"standards.regionCode IS NULL AND ";
	private static final String _FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_2 =
		"standards.regionCode = ? AND ";
	private static final String _FINDER_COLUMN_REGIONCODEANDPARENTID_REGIONCODE_3 =
		"(standards.regionCode IS NULL OR standards.regionCode = '') AND ";
	private static final String _FINDER_COLUMN_REGIONCODEANDPARENTID_PARENTID_2 = "standards.parentId = ?";

	public StandardsPersistenceImpl() {
		setModelClass(Standards.class);
	}

	/**
	 * Caches the standards in the entity cache if it is enabled.
	 *
	 * @param standards the standards
	 */
	@Override
	public void cacheResult(Standards standards) {
		EntityCacheUtil.putResult(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImpl.class, standards.getPrimaryKey(), standards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID,
			new Object[] { standards.getStdId() }, standards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP,
			new Object[] { standards.getStdTyp() }, standards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS,
			new Object[] { standards.getStatus() }, standards);

		standards.resetOriginalValues();
	}

	/**
	 * Caches the standardses in the entity cache if it is enabled.
	 *
	 * @param standardses the standardses
	 */
	@Override
	public void cacheResult(List<Standards> standardses) {
		for (Standards standards : standardses) {
			if (EntityCacheUtil.getResult(
						StandardsModelImpl.ENTITY_CACHE_ENABLED,
						StandardsImpl.class, standards.getPrimaryKey()) == null) {
				cacheResult(standards);
			}
			else {
				standards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Standards standards) {
		EntityCacheUtil.removeResult(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImpl.class, standards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standards);
	}

	@Override
	public void clearCache(List<Standards> standardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Standards standards : standardses) {
			EntityCacheUtil.removeResult(StandardsModelImpl.ENTITY_CACHE_ENABLED,
				StandardsImpl.class, standards.getPrimaryKey());

			clearUniqueFindersCache(standards);
		}
	}

	protected void cacheUniqueFindersCache(Standards standards) {
		if (standards.isNew()) {
			Object[] args = new Object[] { standards.getStdId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID, args,
				standards);

			args = new Object[] { standards.getStdTyp() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDTYP, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP, args,
				standards);

			args = new Object[] { standards.getStatus() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
				standards);
		}
		else {
			StandardsModelImpl standardsModelImpl = (StandardsModelImpl)standards;

			if ((standardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { standards.getStdId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDID, args,
					standards);
			}

			if ((standardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STDTYP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { standards.getStdTyp() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STDTYP, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STDTYP, args,
					standards);
			}

			if ((standardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { standards.getStatus() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STATUS, args,
					standards);
			}
		}
	}

	protected void clearUniqueFindersCache(Standards standards) {
		StandardsModelImpl standardsModelImpl = (StandardsModelImpl)standards;

		Object[] args = new Object[] { standards.getStdId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID, args);

		if ((standardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDID.getColumnBitmask()) != 0) {
			args = new Object[] { standardsModelImpl.getOriginalStdId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDID, args);
		}

		args = new Object[] { standards.getStdTyp() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDTYP, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDTYP, args);

		if ((standardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STDTYP.getColumnBitmask()) != 0) {
			args = new Object[] { standardsModelImpl.getOriginalStdTyp() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDTYP, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STDTYP, args);
		}

		args = new Object[] { standards.getStatus() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);

		if ((standardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STATUS.getColumnBitmask()) != 0) {
			args = new Object[] { standardsModelImpl.getOriginalStatus() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STATUS, args);
		}
	}

	/**
	 * Creates a new standards with the primary key. Does not add the standards to the database.
	 *
	 * @param stdId the primary key for the new standards
	 * @return the new standards
	 */
	@Override
	public Standards create(long stdId) {
		Standards standards = new StandardsImpl();

		standards.setNew(true);
		standards.setPrimaryKey(stdId);

		return standards;
	}

	/**
	 * Removes the standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdId the primary key of the standards
	 * @return the standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards remove(long stdId)
		throws NoSuchStandardsException, SystemException {
		return remove((Serializable)stdId);
	}

	/**
	 * Removes the standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards
	 * @return the standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards remove(Serializable primaryKey)
		throws NoSuchStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Standards standards = (Standards)session.get(StandardsImpl.class,
					primaryKey);

			if (standards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standards);
		}
		catch (NoSuchStandardsException nsee) {
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
	protected Standards removeImpl(Standards standards)
		throws SystemException {
		standards = toUnwrappedModel(standards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standards)) {
				standards = (Standards)session.get(StandardsImpl.class,
						standards.getPrimaryKeyObj());
			}

			if (standards != null) {
				session.delete(standards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standards != null) {
			clearCache(standards);
		}

		return standards;
	}

	@Override
	public Standards updateImpl(
		com.ihg.brandstandards.db.model.Standards standards)
		throws SystemException {
		standards = toUnwrappedModel(standards);

		boolean isNew = standards.isNew();

		StandardsModelImpl standardsModelImpl = (StandardsModelImpl)standards;

		Session session = null;

		try {
			session = openSession();

			if (standards.isNew()) {
				session.save(standards);

				standards.setNew(false);
			}
			else {
				session.merge(standards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { standardsModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((standardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsModelImpl.getOriginalAuthor()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);

				args = new Object[] { standardsModelImpl.getAuthor() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHOR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHOR,
					args);
			}

			if ((standardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSOWNER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsModelImpl.getOriginalBusinessOwner()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSOWNER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSOWNER,
					args);

				args = new Object[] { standardsModelImpl.getBusinessOwner() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSOWNER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSOWNER,
					args);
			}

			if ((standardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODEANDPARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsModelImpl.getOriginalRegionCode(),
						standardsModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODEANDPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODEANDPARENTID,
					args);

				args = new Object[] {
						standardsModelImpl.getRegionCode(),
						standardsModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODEANDPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODEANDPARENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsImpl.class, standards.getPrimaryKey(), standards);

		clearUniqueFindersCache(standards);
		cacheUniqueFindersCache(standards);

		return standards;
	}

	protected Standards toUnwrappedModel(Standards standards) {
		if (standards instanceof StandardsImpl) {
			return standards;
		}

		StandardsImpl standardsImpl = new StandardsImpl();

		standardsImpl.setNew(standards.isNew());
		standardsImpl.setPrimaryKey(standards.getPrimaryKey());

		standardsImpl.setStdId(standards.getStdId());
		standardsImpl.setParentId(standards.getParentId());
		standardsImpl.setStdTyp(standards.getStdTyp());
		standardsImpl.setTitle(standards.getTitle());
		standardsImpl.setDescription(standards.getDescription());
		standardsImpl.setAuthor(standards.getAuthor());
		standardsImpl.setBusinessOwner(standards.getBusinessOwner());
		standardsImpl.setEffectiveDate(standards.getEffectiveDate());
		standardsImpl.setImplDate(standards.getImplDate());
		standardsImpl.setWaiver(standards.getWaiver());
		standardsImpl.setStatus(standards.getStatus());
		standardsImpl.setCategory(standards.getCategory());
		standardsImpl.setCreatedBy(standards.getCreatedBy());
		standardsImpl.setChange(standards.getChange());
		standardsImpl.setIsGlobal(standards.getIsGlobal());
		standardsImpl.setRegionCode(standards.getRegionCode());
		standardsImpl.setNotes(standards.getNotes());
		standardsImpl.setFramework(standards.getFramework());
		standardsImpl.setInternalReference(standards.getInternalReference());
		standardsImpl.setOrderNumber(standards.getOrderNumber());
		standardsImpl.setCreatorId(standards.getCreatorId());
		standardsImpl.setCreatedDate(standards.getCreatedDate());
		standardsImpl.setUpdatedBy(standards.getUpdatedBy());
		standardsImpl.setUpdatedDate(standards.getUpdatedDate());
		standardsImpl.setStatusId(standards.getStatusId());
		standardsImpl.setRegionId(standards.getRegionId());

		return standardsImpl;
	}

	/**
	 * Returns the standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards
	 * @return the standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsException, SystemException {
		Standards standards = fetchByPrimaryKey(primaryKey);

		if (standards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standards;
	}

	/**
	 * Returns the standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsException} if it could not be found.
	 *
	 * @param stdId the primary key of the standards
	 * @return the standards
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsException if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards findByPrimaryKey(long stdId)
		throws NoSuchStandardsException, SystemException {
		return findByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns the standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards
	 * @return the standards, or <code>null</code> if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Standards standards = (Standards)EntityCacheUtil.getResult(StandardsModelImpl.ENTITY_CACHE_ENABLED,
				StandardsImpl.class, primaryKey);

		if (standards == _nullStandards) {
			return null;
		}

		if (standards == null) {
			Session session = null;

			try {
				session = openSession();

				standards = (Standards)session.get(StandardsImpl.class,
						primaryKey);

				if (standards != null) {
					cacheResult(standards);
				}
				else {
					EntityCacheUtil.putResult(StandardsModelImpl.ENTITY_CACHE_ENABLED,
						StandardsImpl.class, primaryKey, _nullStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsModelImpl.ENTITY_CACHE_ENABLED,
					StandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standards;
	}

	/**
	 * Returns the standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdId the primary key of the standards
	 * @return the standards, or <code>null</code> if a standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Standards fetchByPrimaryKey(long stdId) throws SystemException {
		return fetchByPrimaryKey((Serializable)stdId);
	}

	/**
	 * Returns all the standardses.
	 *
	 * @return the standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @return the range of standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standardses
	 * @param end the upper bound of the range of standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Standards> findAll(int start, int end,
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

		List<Standards> list = (List<Standards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDS;

				if (pagination) {
					sql = sql.concat(StandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Standards>(list);
				}
				else {
					list = (List<Standards>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Standards standards : findAll()) {
			remove(standards);
		}
	}

	/**
	 * Returns the number of standardses.
	 *
	 * @return the number of standardses
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDS);

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
	 * Initializes the standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.Standards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Standards>> listenersList = new ArrayList<ModelListener<Standards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Standards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDS = "SELECT standards FROM Standards standards";
	private static final String _SQL_SELECT_STANDARDS_WHERE = "SELECT standards FROM Standards standards WHERE ";
	private static final String _SQL_COUNT_STANDARDS = "SELECT COUNT(standards) FROM Standards standards";
	private static final String _SQL_COUNT_STANDARDS_WHERE = "SELECT COUNT(standards) FROM Standards standards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Standards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Standards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "parentId", "stdTyp", "title", "description", "author",
				"businessOwner", "effectiveDate", "implDate", "waiver", "status",
				"category", "createdBy", "change", "isGlobal", "regionCode",
				"notes", "framework", "internalReference", "orderNumber",
				"creatorId", "createdDate", "updatedBy", "updatedDate",
				"statusId", "regionId"
			});
	private static Standards _nullStandards = new StandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Standards> toCacheModel() {
				return _nullStandardsCacheModel;
			}
		};

	private static CacheModel<Standards> _nullStandardsCacheModel = new CacheModel<Standards>() {
			@Override
			public Standards toEntityModel() {
				return _nullStandards;
			}
		};
}