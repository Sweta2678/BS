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

import com.ihg.brandstandards.db.NoSuchCountryStandardsException;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.impl.CountryStandardsImpl;
import com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl;

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
 * The persistence implementation for the country standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see CountryStandardsPersistence
 * @see CountryStandardsUtil
 * @generated
 */
public class CountryStandardsPersistenceImpl extends BasePersistenceImpl<CountryStandards>
	implements CountryStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CountryStandardsUtil} to access the country standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CountryStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsModelImpl.FINDER_CACHE_ENABLED,
			CountryStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsModelImpl.FINDER_CACHE_ENABLED,
			CountryStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsModelImpl.FINDER_CACHE_ENABLED,
			CountryStandardsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsModelImpl.FINDER_CACHE_ENABLED,
			CountryStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			CountryStandardsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the country standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching country standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandards> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the country standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of country standardses
	 * @param end the upper bound of the range of country standardses (not inclusive)
	 * @return the range of matching country standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandards> findByStdId(long stdId, int start, int end)
		throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the country standardses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of country standardses
	 * @param end the upper bound of the range of country standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching country standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandards> findByStdId(long stdId, int start, int end,
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

		List<CountryStandards> list = (List<CountryStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CountryStandards countryStandards : list) {
				if ((stdId != countryStandards.getStdId())) {
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

			query.append(_SQL_SELECT_COUNTRYSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CountryStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<CountryStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CountryStandards>(list);
				}
				else {
					list = (List<CountryStandards>)QueryUtil.list(q,
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
	 * Returns the first country standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country standards
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a matching country standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchCountryStandardsException, SystemException {
		CountryStandards countryStandards = fetchByStdId_First(stdId,
				orderByComparator);

		if (countryStandards != null) {
			return countryStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCountryStandardsException(msg.toString());
	}

	/**
	 * Returns the first country standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching country standards, or <code>null</code> if a matching country standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CountryStandards> list = findByStdId(stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last country standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country standards
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a matching country standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchCountryStandardsException, SystemException {
		CountryStandards countryStandards = fetchByStdId_Last(stdId,
				orderByComparator);

		if (countryStandards != null) {
			return countryStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCountryStandardsException(msg.toString());
	}

	/**
	 * Returns the last country standards in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching country standards, or <code>null</code> if a matching country standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<CountryStandards> list = findByStdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the country standardses before and after the current country standards in the ordered set where stdId = &#63;.
	 *
	 * @param countryStandardsPK the primary key of the current country standards
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next country standards
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards[] findByStdId_PrevAndNext(
		CountryStandardsPK countryStandardsPK, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchCountryStandardsException, SystemException {
		CountryStandards countryStandards = findByPrimaryKey(countryStandardsPK);

		Session session = null;

		try {
			session = openSession();

			CountryStandards[] array = new CountryStandardsImpl[3];

			array[0] = getByStdId_PrevAndNext(session, countryStandards, stdId,
					orderByComparator, true);

			array[1] = countryStandards;

			array[2] = getByStdId_PrevAndNext(session, countryStandards, stdId,
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

	protected CountryStandards getByStdId_PrevAndNext(Session session,
		CountryStandards countryStandards, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COUNTRYSTANDARDS_WHERE);

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
			query.append(CountryStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(countryStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CountryStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the country standardses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (CountryStandards countryStandards : findByStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(countryStandards);
		}
	}

	/**
	 * Returns the number of country standardses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching country standardses
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

			query.append(_SQL_COUNT_COUNTRYSTANDARDS_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "countryStandards.id.stdId = ?";

	public CountryStandardsPersistenceImpl() {
		setModelClass(CountryStandards.class);
	}

	/**
	 * Caches the country standards in the entity cache if it is enabled.
	 *
	 * @param countryStandards the country standards
	 */
	@Override
	public void cacheResult(CountryStandards countryStandards) {
		EntityCacheUtil.putResult(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsImpl.class, countryStandards.getPrimaryKey(),
			countryStandards);

		countryStandards.resetOriginalValues();
	}

	/**
	 * Caches the country standardses in the entity cache if it is enabled.
	 *
	 * @param countryStandardses the country standardses
	 */
	@Override
	public void cacheResult(List<CountryStandards> countryStandardses) {
		for (CountryStandards countryStandards : countryStandardses) {
			if (EntityCacheUtil.getResult(
						CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
						CountryStandardsImpl.class,
						countryStandards.getPrimaryKey()) == null) {
				cacheResult(countryStandards);
			}
			else {
				countryStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all country standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CountryStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CountryStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the country standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CountryStandards countryStandards) {
		EntityCacheUtil.removeResult(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsImpl.class, countryStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CountryStandards> countryStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CountryStandards countryStandards : countryStandardses) {
			EntityCacheUtil.removeResult(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
				CountryStandardsImpl.class, countryStandards.getPrimaryKey());
		}
	}

	/**
	 * Creates a new country standards with the primary key. Does not add the country standards to the database.
	 *
	 * @param countryStandardsPK the primary key for the new country standards
	 * @return the new country standards
	 */
	@Override
	public CountryStandards create(CountryStandardsPK countryStandardsPK) {
		CountryStandards countryStandards = new CountryStandardsImpl();

		countryStandards.setNew(true);
		countryStandards.setPrimaryKey(countryStandardsPK);

		return countryStandards;
	}

	/**
	 * Removes the country standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param countryStandardsPK the primary key of the country standards
	 * @return the country standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards remove(CountryStandardsPK countryStandardsPK)
		throws NoSuchCountryStandardsException, SystemException {
		return remove((Serializable)countryStandardsPK);
	}

	/**
	 * Removes the country standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the country standards
	 * @return the country standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards remove(Serializable primaryKey)
		throws NoSuchCountryStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CountryStandards countryStandards = (CountryStandards)session.get(CountryStandardsImpl.class,
					primaryKey);

			if (countryStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCountryStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(countryStandards);
		}
		catch (NoSuchCountryStandardsException nsee) {
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
	protected CountryStandards removeImpl(CountryStandards countryStandards)
		throws SystemException {
		countryStandards = toUnwrappedModel(countryStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(countryStandards)) {
				countryStandards = (CountryStandards)session.get(CountryStandardsImpl.class,
						countryStandards.getPrimaryKeyObj());
			}

			if (countryStandards != null) {
				session.delete(countryStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (countryStandards != null) {
			clearCache(countryStandards);
		}

		return countryStandards;
	}

	@Override
	public CountryStandards updateImpl(
		com.ihg.brandstandards.db.model.CountryStandards countryStandards)
		throws SystemException {
		countryStandards = toUnwrappedModel(countryStandards);

		boolean isNew = countryStandards.isNew();

		CountryStandardsModelImpl countryStandardsModelImpl = (CountryStandardsModelImpl)countryStandards;

		Session session = null;

		try {
			session = openSession();

			if (countryStandards.isNew()) {
				session.save(countryStandards);

				countryStandards.setNew(false);
			}
			else {
				session.merge(countryStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CountryStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((countryStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						countryStandardsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { countryStandardsModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}
		}

		EntityCacheUtil.putResult(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
			CountryStandardsImpl.class, countryStandards.getPrimaryKey(),
			countryStandards);

		return countryStandards;
	}

	protected CountryStandards toUnwrappedModel(
		CountryStandards countryStandards) {
		if (countryStandards instanceof CountryStandardsImpl) {
			return countryStandards;
		}

		CountryStandardsImpl countryStandardsImpl = new CountryStandardsImpl();

		countryStandardsImpl.setNew(countryStandards.isNew());
		countryStandardsImpl.setPrimaryKey(countryStandards.getPrimaryKey());

		countryStandardsImpl.setCountry(countryStandards.getCountry());
		countryStandardsImpl.setStdId(countryStandards.getStdId());
		countryStandardsImpl.setCreatorId(countryStandards.getCreatorId());
		countryStandardsImpl.setCreatedDate(countryStandards.getCreatedDate());
		countryStandardsImpl.setUpdatedBy(countryStandards.getUpdatedBy());
		countryStandardsImpl.setUpdatedDate(countryStandards.getUpdatedDate());

		return countryStandardsImpl;
	}

	/**
	 * Returns the country standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the country standards
	 * @return the country standards
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCountryStandardsException, SystemException {
		CountryStandards countryStandards = fetchByPrimaryKey(primaryKey);

		if (countryStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCountryStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return countryStandards;
	}

	/**
	 * Returns the country standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchCountryStandardsException} if it could not be found.
	 *
	 * @param countryStandardsPK the primary key of the country standards
	 * @return the country standards
	 * @throws com.ihg.brandstandards.db.NoSuchCountryStandardsException if a country standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards findByPrimaryKey(
		CountryStandardsPK countryStandardsPK)
		throws NoSuchCountryStandardsException, SystemException {
		return findByPrimaryKey((Serializable)countryStandardsPK);
	}

	/**
	 * Returns the country standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the country standards
	 * @return the country standards, or <code>null</code> if a country standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CountryStandards countryStandards = (CountryStandards)EntityCacheUtil.getResult(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
				CountryStandardsImpl.class, primaryKey);

		if (countryStandards == _nullCountryStandards) {
			return null;
		}

		if (countryStandards == null) {
			Session session = null;

			try {
				session = openSession();

				countryStandards = (CountryStandards)session.get(CountryStandardsImpl.class,
						primaryKey);

				if (countryStandards != null) {
					cacheResult(countryStandards);
				}
				else {
					EntityCacheUtil.putResult(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
						CountryStandardsImpl.class, primaryKey,
						_nullCountryStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CountryStandardsModelImpl.ENTITY_CACHE_ENABLED,
					CountryStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return countryStandards;
	}

	/**
	 * Returns the country standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param countryStandardsPK the primary key of the country standards
	 * @return the country standards, or <code>null</code> if a country standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CountryStandards fetchByPrimaryKey(
		CountryStandardsPK countryStandardsPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)countryStandardsPK);
	}

	/**
	 * Returns all the country standardses.
	 *
	 * @return the country standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the country standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of country standardses
	 * @param end the upper bound of the range of country standardses (not inclusive)
	 * @return the range of country standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the country standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.CountryStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of country standardses
	 * @param end the upper bound of the range of country standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of country standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CountryStandards> findAll(int start, int end,
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

		List<CountryStandards> list = (List<CountryStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COUNTRYSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COUNTRYSTANDARDS;

				if (pagination) {
					sql = sql.concat(CountryStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CountryStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CountryStandards>(list);
				}
				else {
					list = (List<CountryStandards>)QueryUtil.list(q,
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
	 * Removes all the country standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CountryStandards countryStandards : findAll()) {
			remove(countryStandards);
		}
	}

	/**
	 * Returns the number of country standardses.
	 *
	 * @return the number of country standardses
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

				Query q = session.createQuery(_SQL_COUNT_COUNTRYSTANDARDS);

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
	 * Initializes the country standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.CountryStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CountryStandards>> listenersList = new ArrayList<ModelListener<CountryStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CountryStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CountryStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COUNTRYSTANDARDS = "SELECT countryStandards FROM CountryStandards countryStandards";
	private static final String _SQL_SELECT_COUNTRYSTANDARDS_WHERE = "SELECT countryStandards FROM CountryStandards countryStandards WHERE ";
	private static final String _SQL_COUNT_COUNTRYSTANDARDS = "SELECT COUNT(countryStandards) FROM CountryStandards countryStandards";
	private static final String _SQL_COUNT_COUNTRYSTANDARDS_WHERE = "SELECT COUNT(countryStandards) FROM CountryStandards countryStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "countryStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CountryStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CountryStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CountryStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"country", "stdId", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static CountryStandards _nullCountryStandards = new CountryStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CountryStandards> toCacheModel() {
				return _nullCountryStandardsCacheModel;
			}
		};

	private static CacheModel<CountryStandards> _nullCountryStandardsCacheModel = new CacheModel<CountryStandards>() {
			@Override
			public CountryStandards toEntityModel() {
				return _nullCountryStandards;
			}
		};
}