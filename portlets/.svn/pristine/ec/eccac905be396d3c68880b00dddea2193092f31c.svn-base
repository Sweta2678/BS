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

import com.ihg.brandstandards.db.NoSuchFlagStandardsException;
import com.ihg.brandstandards.db.model.FlagStandards;
import com.ihg.brandstandards.db.model.impl.FlagStandardsImpl;
import com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the flag standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see FlagStandardsPersistence
 * @see FlagStandardsUtil
 * @generated
 */
public class FlagStandardsPersistenceImpl extends BasePersistenceImpl<FlagStandards>
	implements FlagStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FlagStandardsUtil} to access the flag standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FlagStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED,
			FlagStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED,
			FlagStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED,
			FlagStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED,
			FlagStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByStdId", new String[] { Long.class.getName() },
			FlagStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the flag standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagStandards> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flag standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of flag standardses
	 * @param end the upper bound of the range of flag standardses (not inclusive)
	 * @return the range of matching flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagStandards> findByStdId(long stdId, int start, int end)
		throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the flag standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of flag standardses
	 * @param end the upper bound of the range of flag standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagStandards> findByStdId(long stdId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] { stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] { stdId, start, end, orderByComparator };
		}

		List<FlagStandards> list = (List<FlagStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FlagStandards flagStandards : list) {
				if ((stdId != flagStandards.getStdId())) {
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

			query.append(_SQL_SELECT_FLAGSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FlagStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<FlagStandards>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlagStandards>(list);
				}
				else {
					list = (List<FlagStandards>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first flag standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flag standards
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = fetchByStdId_First(stdId,
				orderByComparator);

		if (flagStandards != null) {
			return flagStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlagStandardsException(msg.toString());
	}

	/**
	 * Returns the first flag standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching flag standards, or <code>null</code> if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FlagStandards> list = findByStdId(stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last flag standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flag standards
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = fetchByStdId_Last(stdId, orderByComparator);

		if (flagStandards != null) {
			return flagStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFlagStandardsException(msg.toString());
	}

	/**
	 * Returns the last flag standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching flag standards, or <code>null</code> if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<FlagStandards> list = findByStdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the flag standardses before and after the current flag standards in the ordered set where stdId = &#63;.
	 *
	 * @param flagStandardsPK the primary key of the current flag standards
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next flag standards
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards[] findByStdId_PrevAndNext(
		FlagStandardsPK flagStandardsPK, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = findByPrimaryKey(flagStandardsPK);

		Session session = null;

		try {
			session = openSession();

			FlagStandards[] array = new FlagStandardsImpl[3];

			array[0] = getByStdId_PrevAndNext(session, flagStandards, stdId,
					orderByComparator, true);

			array[1] = flagStandards;

			array[2] = getByStdId_PrevAndNext(session, flagStandards, stdId,
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

	protected FlagStandards getByStdId_PrevAndNext(Session session,
		FlagStandards flagStandards, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FLAGSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_STDID_STDID_2);

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
			query.append(FlagStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(flagStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FlagStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the flag standardses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (FlagStandards flagStandards : findByStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(flagStandards);
		}
	}

	/**
	 * Returns the number of flag standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching flag standardses
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

			query.append(_SQL_COUNT_FLAGSTANDARDS_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "flagStandards.id.stdId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_FLAGCATID = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED,
			FlagStandardsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByFlagCatId", new String[] { Long.class.getName() },
			FlagStandardsModelImpl.FLAGCATID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FLAGCATID = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFlagCatId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the flag standards where flagCatId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	 *
	 * @param flagCatId the flag cat ID
	 * @return the matching flag standards
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards findByFlagCatId(long flagCatId)
		throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = fetchByFlagCatId(flagCatId);

		if (flagStandards == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("flagCatId=");
			msg.append(flagCatId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFlagStandardsException(msg.toString());
		}

		return flagStandards;
	}

	/**
	 * Returns the flag standards where flagCatId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param flagCatId the flag cat ID
	 * @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByFlagCatId(long flagCatId)
		throws SystemException {
		return fetchByFlagCatId(flagCatId, true);
	}

	/**
	 * Returns the flag standards where flagCatId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param flagCatId the flag cat ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByFlagCatId(long flagCatId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { flagCatId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FLAGCATID,
					finderArgs, this);
		}

		if (result instanceof FlagStandards) {
			FlagStandards flagStandards = (FlagStandards)result;

			if ((flagCatId != flagStandards.getFlagCatId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_FLAGSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_FLAGCATID_FLAGCATID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(flagCatId);

				List<FlagStandards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLAGCATID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FlagStandardsPersistenceImpl.fetchByFlagCatId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FlagStandards flagStandards = list.get(0);

					result = flagStandards;

					cacheResult(flagStandards);

					if ((flagStandards.getFlagCatId() != flagCatId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLAGCATID,
							finderArgs, flagStandards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FLAGCATID,
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
			return (FlagStandards)result;
		}
	}

	/**
	 * Removes the flag standards where flagCatId = &#63; from the database.
	 *
	 * @param flagCatId the flag cat ID
	 * @return the flag standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards removeByFlagCatId(long flagCatId)
		throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = findByFlagCatId(flagCatId);

		return remove(flagStandards);
	}

	/**
	 * Returns the number of flag standardses where flagCatId = &#63;.
	 *
	 * @param flagCatId the flag cat ID
	 * @return the number of matching flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByFlagCatId(long flagCatId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FLAGCATID;

		Object[] finderArgs = new Object[] { flagCatId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FLAGSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_FLAGCATID_FLAGCATID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(flagCatId);

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

	private static final String _FINDER_COLUMN_FLAGCATID_FLAGCATID_2 = "flagStandards.id.flagCatId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED,
			FlagStandardsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByStandardAndCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FlagStandardsModelImpl.STDID_COLUMN_BITMASK |
			FlagStandardsModelImpl.FLAGCATID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STANDARDANDCATEGORYID = new FinderPath(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStandardAndCategoryId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the flag standards where stdId = &#63; and flagCatId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	 *
	 * @param stdId the std ID
	 * @param flagCatId the flag cat ID
	 * @return the matching flag standards
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards findByStandardAndCategoryId(long stdId, long flagCatId)
		throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = fetchByStandardAndCategoryId(stdId,
				flagCatId);

		if (flagStandards == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stdId=");
			msg.append(stdId);

			msg.append(", flagCatId=");
			msg.append(flagCatId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchFlagStandardsException(msg.toString());
		}

		return flagStandards;
	}

	/**
	 * Returns the flag standards where stdId = &#63; and flagCatId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stdId the std ID
	 * @param flagCatId the flag cat ID
	 * @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByStandardAndCategoryId(long stdId, long flagCatId)
		throws SystemException {
		return fetchByStandardAndCategoryId(stdId, flagCatId, true);
	}

	/**
	 * Returns the flag standards where stdId = &#63; and flagCatId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stdId the std ID
	 * @param flagCatId the flag cat ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching flag standards, or <code>null</code> if a matching flag standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByStandardAndCategoryId(long stdId,
		long flagCatId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { stdId, flagCatId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
					finderArgs, this);
		}

		if (result instanceof FlagStandards) {
			FlagStandards flagStandards = (FlagStandards)result;

			if ((stdId != flagStandards.getStdId()) ||
					(flagCatId != flagStandards.getFlagCatId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_FLAGSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STANDARDANDCATEGORYID_STDID_2);

			query.append(_FINDER_COLUMN_STANDARDANDCATEGORYID_FLAGCATID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				qPos.add(flagCatId);

				List<FlagStandards> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"FlagStandardsPersistenceImpl.fetchByStandardAndCategoryId(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					FlagStandards flagStandards = list.get(0);

					result = flagStandards;

					cacheResult(flagStandards);

					if ((flagStandards.getStdId() != stdId) ||
							(flagStandards.getFlagCatId() != flagCatId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
							finderArgs, flagStandards);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
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
			return (FlagStandards)result;
		}
	}

	/**
	 * Removes the flag standards where stdId = &#63; and flagCatId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param flagCatId the flag cat ID
	 * @return the flag standards that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards removeByStandardAndCategoryId(long stdId,
		long flagCatId) throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = findByStandardAndCategoryId(stdId,
				flagCatId);

		return remove(flagStandards);
	}

	/**
	 * Returns the number of flag standardses where stdId = &#63; and flagCatId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param flagCatId the flag cat ID
	 * @return the number of matching flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStandardAndCategoryId(long stdId, long flagCatId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STANDARDANDCATEGORYID;

		Object[] finderArgs = new Object[] { stdId, flagCatId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FLAGSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STANDARDANDCATEGORYID_STDID_2);

			query.append(_FINDER_COLUMN_STANDARDANDCATEGORYID_FLAGCATID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				qPos.add(flagCatId);

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

	private static final String _FINDER_COLUMN_STANDARDANDCATEGORYID_STDID_2 = "flagStandards.id.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STANDARDANDCATEGORYID_FLAGCATID_2 =
		"flagStandards.id.flagCatId = ?";

	public FlagStandardsPersistenceImpl() {
		setModelClass(FlagStandards.class);
	}

	/**
	 * Caches the flag standards in the entity cache if it is enabled.
	 *
	 * @param flagStandards the flag standards
	 */
	@Override
	public void cacheResult(FlagStandards flagStandards) {
		EntityCacheUtil.putResult(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsImpl.class, flagStandards.getPrimaryKey(),
			flagStandards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLAGCATID,
			new Object[] { flagStandards.getFlagCatId() }, flagStandards);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
			new Object[] { flagStandards.getStdId(), flagStandards.getFlagCatId() },
			flagStandards);

		flagStandards.resetOriginalValues();
	}

	/**
	 * Caches the flag standardses in the entity cache if it is enabled.
	 *
	 * @param flagStandardses the flag standardses
	 */
	@Override
	public void cacheResult(List<FlagStandards> flagStandardses) {
		for (FlagStandards flagStandards : flagStandardses) {
			if (EntityCacheUtil.getResult(
						FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
						FlagStandardsImpl.class, flagStandards.getPrimaryKey()) == null) {
				cacheResult(flagStandards);
			}
			else {
				flagStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all flag standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FlagStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FlagStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the flag standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FlagStandards flagStandards) {
		EntityCacheUtil.removeResult(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsImpl.class, flagStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(flagStandards);
	}

	@Override
	public void clearCache(List<FlagStandards> flagStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FlagStandards flagStandards : flagStandardses) {
			EntityCacheUtil.removeResult(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
				FlagStandardsImpl.class, flagStandards.getPrimaryKey());

			clearUniqueFindersCache(flagStandards);
		}
	}

	protected void cacheUniqueFindersCache(FlagStandards flagStandards) {
		if (flagStandards.isNew()) {
			Object[] args = new Object[] { flagStandards.getFlagCatId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FLAGCATID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLAGCATID, args,
				flagStandards);

			args = new Object[] {
					flagStandards.getStdId(), flagStandards.getFlagCatId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STANDARDANDCATEGORYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
				args, flagStandards);
		}
		else {
			FlagStandardsModelImpl flagStandardsModelImpl = (FlagStandardsModelImpl)flagStandards;

			if ((flagStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_FLAGCATID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { flagStandards.getFlagCatId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FLAGCATID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FLAGCATID, args,
					flagStandards);
			}

			if ((flagStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flagStandards.getStdId(), flagStandards.getFlagCatId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STANDARDANDCATEGORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
					args, flagStandards);
			}
		}
	}

	protected void clearUniqueFindersCache(FlagStandards flagStandards) {
		FlagStandardsModelImpl flagStandardsModelImpl = (FlagStandardsModelImpl)flagStandards;

		Object[] args = new Object[] { flagStandards.getFlagCatId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FLAGCATID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FLAGCATID, args);

		if ((flagStandardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_FLAGCATID.getColumnBitmask()) != 0) {
			args = new Object[] { flagStandardsModelImpl.getOriginalFlagCatId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FLAGCATID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FLAGCATID, args);
		}

		args = new Object[] {
				flagStandards.getStdId(), flagStandards.getFlagCatId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STANDARDANDCATEGORYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
			args);

		if ((flagStandardsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					flagStandardsModelImpl.getOriginalStdId(),
					flagStandardsModelImpl.getOriginalFlagCatId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STANDARDANDCATEGORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_STANDARDANDCATEGORYID,
				args);
		}
	}

	/**
	 * Creates a new flag standards with the primary key. Does not add the flag standards to the database.
	 *
	 * @param flagStandardsPK the primary key for the new flag standards
	 * @return the new flag standards
	 */
	@Override
	public FlagStandards create(FlagStandardsPK flagStandardsPK) {
		FlagStandards flagStandards = new FlagStandardsImpl();

		flagStandards.setNew(true);
		flagStandards.setPrimaryKey(flagStandardsPK);

		return flagStandards;
	}

	/**
	 * Removes the flag standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param flagStandardsPK the primary key of the flag standards
	 * @return the flag standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards remove(FlagStandardsPK flagStandardsPK)
		throws NoSuchFlagStandardsException, SystemException {
		return remove((Serializable)flagStandardsPK);
	}

	/**
	 * Removes the flag standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the flag standards
	 * @return the flag standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards remove(Serializable primaryKey)
		throws NoSuchFlagStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FlagStandards flagStandards = (FlagStandards)session.get(FlagStandardsImpl.class,
					primaryKey);

			if (flagStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFlagStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(flagStandards);
		}
		catch (NoSuchFlagStandardsException nsee) {
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
	protected FlagStandards removeImpl(FlagStandards flagStandards)
		throws SystemException {
		flagStandards = toUnwrappedModel(flagStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(flagStandards)) {
				flagStandards = (FlagStandards)session.get(FlagStandardsImpl.class,
						flagStandards.getPrimaryKeyObj());
			}

			if (flagStandards != null) {
				session.delete(flagStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (flagStandards != null) {
			clearCache(flagStandards);
		}

		return flagStandards;
	}

	@Override
	public FlagStandards updateImpl(
		com.ihg.brandstandards.db.model.FlagStandards flagStandards)
		throws SystemException {
		flagStandards = toUnwrappedModel(flagStandards);

		boolean isNew = flagStandards.isNew();

		FlagStandardsModelImpl flagStandardsModelImpl = (FlagStandardsModelImpl)flagStandards;

		Session session = null;

		try {
			session = openSession();

			if (flagStandards.isNew()) {
				session.save(flagStandards);

				flagStandards.setNew(false);
			}
			else {
				session.merge(flagStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FlagStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((flagStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						flagStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { flagStandardsModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}
		}

		EntityCacheUtil.putResult(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
			FlagStandardsImpl.class, flagStandards.getPrimaryKey(),
			flagStandards);

		clearUniqueFindersCache(flagStandards);
		cacheUniqueFindersCache(flagStandards);

		return flagStandards;
	}

	protected FlagStandards toUnwrappedModel(FlagStandards flagStandards) {
		if (flagStandards instanceof FlagStandardsImpl) {
			return flagStandards;
		}

		FlagStandardsImpl flagStandardsImpl = new FlagStandardsImpl();

		flagStandardsImpl.setNew(flagStandards.isNew());
		flagStandardsImpl.setPrimaryKey(flagStandards.getPrimaryKey());

		flagStandardsImpl.setFlagCatId(flagStandards.getFlagCatId());
		flagStandardsImpl.setStdId(flagStandards.getStdId());
		flagStandardsImpl.setCreatorId(flagStandards.getCreatorId());
		flagStandardsImpl.setCreatedDate(flagStandards.getCreatedDate());
		flagStandardsImpl.setUpdatedBy(flagStandards.getUpdatedBy());
		flagStandardsImpl.setUpdatedDate(flagStandards.getUpdatedDate());

		return flagStandardsImpl;
	}

	/**
	 * Returns the flag standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the flag standards
	 * @return the flag standards
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFlagStandardsException, SystemException {
		FlagStandards flagStandards = fetchByPrimaryKey(primaryKey);

		if (flagStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFlagStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return flagStandards;
	}

	/**
	 * Returns the flag standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchFlagStandardsException} if it could not be found.
	 *
	 * @param flagStandardsPK the primary key of the flag standards
	 * @return the flag standards
	 * @throws com.ihg.brandstandards.db.NoSuchFlagStandardsException if a flag standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards findByPrimaryKey(FlagStandardsPK flagStandardsPK)
		throws NoSuchFlagStandardsException, SystemException {
		return findByPrimaryKey((Serializable)flagStandardsPK);
	}

	/**
	 * Returns the flag standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the flag standards
	 * @return the flag standards, or <code>null</code> if a flag standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FlagStandards flagStandards = (FlagStandards)EntityCacheUtil.getResult(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
				FlagStandardsImpl.class, primaryKey);

		if (flagStandards == _nullFlagStandards) {
			return null;
		}

		if (flagStandards == null) {
			Session session = null;

			try {
				session = openSession();

				flagStandards = (FlagStandards)session.get(FlagStandardsImpl.class,
						primaryKey);

				if (flagStandards != null) {
					cacheResult(flagStandards);
				}
				else {
					EntityCacheUtil.putResult(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
						FlagStandardsImpl.class, primaryKey, _nullFlagStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FlagStandardsModelImpl.ENTITY_CACHE_ENABLED,
					FlagStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return flagStandards;
	}

	/**
	 * Returns the flag standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param flagStandardsPK the primary key of the flag standards
	 * @return the flag standards, or <code>null</code> if a flag standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FlagStandards fetchByPrimaryKey(FlagStandardsPK flagStandardsPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)flagStandardsPK);
	}

	/**
	 * Returns all the flag standardses.
	 *
	 * @return the flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the flag standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flag standardses
	 * @param end the upper bound of the range of flag standardses (not inclusive)
	 * @return the range of flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the flag standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.FlagStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of flag standardses
	 * @param end the upper bound of the range of flag standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of flag standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FlagStandards> findAll(int start, int end,
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

		List<FlagStandards> list = (List<FlagStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FLAGSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FLAGSTANDARDS;

				if (pagination) {
					sql = sql.concat(FlagStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FlagStandards>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FlagStandards>(list);
				}
				else {
					list = (List<FlagStandards>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the flag standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FlagStandards flagStandards : findAll()) {
			remove(flagStandards);
		}
	}

	/**
	 * Returns the number of flag standardses.
	 *
	 * @return the number of flag standardses
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

				Query q = session.createQuery(_SQL_COUNT_FLAGSTANDARDS);

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
	 * Initializes the flag standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.FlagStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FlagStandards>> listenersList = new ArrayList<ModelListener<FlagStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FlagStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FlagStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FLAGSTANDARDS = "SELECT flagStandards FROM FlagStandards flagStandards";
	private static final String _SQL_SELECT_FLAGSTANDARDS_WHERE = "SELECT flagStandards FROM FlagStandards flagStandards WHERE ";
	private static final String _SQL_COUNT_FLAGSTANDARDS = "SELECT COUNT(flagStandards) FROM FlagStandards flagStandards";
	private static final String _SQL_COUNT_FLAGSTANDARDS_WHERE = "SELECT COUNT(flagStandards) FROM FlagStandards flagStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "flagStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FlagStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FlagStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FlagStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"flagCatId", "stdId", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static FlagStandards _nullFlagStandards = new FlagStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FlagStandards> toCacheModel() {
				return _nullFlagStandardsCacheModel;
			}
		};

	private static CacheModel<FlagStandards> _nullFlagStandardsCacheModel = new CacheModel<FlagStandards>() {
			@Override
			public FlagStandards toEntityModel() {
				return _nullFlagStandards;
			}
		};
}