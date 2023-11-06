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

import com.ihg.brandstandards.db.NoSuchHistManualChainException;
import com.ihg.brandstandards.db.model.HistManualChain;
import com.ihg.brandstandards.db.model.impl.HistManualChainImpl;
import com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl;

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
 * The persistence implementation for the hist manual chain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualChainPersistence
 * @see HistManualChainUtil
 * @generated
 */
public class HistManualChainPersistenceImpl extends BasePersistenceImpl<HistManualChain>
	implements HistManualChainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistManualChainUtil} to access the hist manual chain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistManualChainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainModelImpl.FINDER_CACHE_ENABLED,
			HistManualChainImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainModelImpl.FINDER_CACHE_ENABLED,
			HistManualChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HISTMANUALID =
		new FinderPath(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainModelImpl.FINDER_CACHE_ENABLED,
			HistManualChainImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByhistManualId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID =
		new FinderPath(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainModelImpl.FINDER_CACHE_ENABLED,
			HistManualChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByhistManualId",
			new String[] { Long.class.getName() },
			HistManualChainModelImpl.HISTMANUALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HISTMANUALID = new FinderPath(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByhistManualId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the hist manual chains where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @return the matching hist manual chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualChain> findByhistManualId(long histManualId)
		throws SystemException {
		return findByhistManualId(histManualId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hist manual chains where histManualId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param histManualId the hist manual ID
	 * @param start the lower bound of the range of hist manual chains
	 * @param end the upper bound of the range of hist manual chains (not inclusive)
	 * @return the range of matching hist manual chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualChain> findByhistManualId(long histManualId,
		int start, int end) throws SystemException {
		return findByhistManualId(histManualId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hist manual chains where histManualId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param histManualId the hist manual ID
	 * @param start the lower bound of the range of hist manual chains
	 * @param end the upper bound of the range of hist manual chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hist manual chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualChain> findByhistManualId(long histManualId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID;
			finderArgs = new Object[] { histManualId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_HISTMANUALID;
			finderArgs = new Object[] {
					histManualId,
					
					start, end, orderByComparator
				};
		}

		List<HistManualChain> list = (List<HistManualChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (HistManualChain histManualChain : list) {
				if ((histManualId != histManualChain.getHistManualId())) {
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

			query.append(_SQL_SELECT_HISTMANUALCHAIN_WHERE);

			query.append(_FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HistManualChainModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(histManualId);

				if (!pagination) {
					list = (List<HistManualChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistManualChain>(list);
				}
				else {
					list = (List<HistManualChain>)QueryUtil.list(q,
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
	 * Returns the first hist manual chain in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hist manual chain
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a matching hist manual chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain findByhistManualId_First(long histManualId,
		OrderByComparator orderByComparator)
		throws NoSuchHistManualChainException, SystemException {
		HistManualChain histManualChain = fetchByhistManualId_First(histManualId,
				orderByComparator);

		if (histManualChain != null) {
			return histManualChain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("histManualId=");
		msg.append(histManualId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHistManualChainException(msg.toString());
	}

	/**
	 * Returns the first hist manual chain in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hist manual chain, or <code>null</code> if a matching hist manual chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain fetchByhistManualId_First(long histManualId,
		OrderByComparator orderByComparator) throws SystemException {
		List<HistManualChain> list = findByhistManualId(histManualId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hist manual chain in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hist manual chain
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a matching hist manual chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain findByhistManualId_Last(long histManualId,
		OrderByComparator orderByComparator)
		throws NoSuchHistManualChainException, SystemException {
		HistManualChain histManualChain = fetchByhistManualId_Last(histManualId,
				orderByComparator);

		if (histManualChain != null) {
			return histManualChain;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("histManualId=");
		msg.append(histManualId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHistManualChainException(msg.toString());
	}

	/**
	 * Returns the last hist manual chain in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hist manual chain, or <code>null</code> if a matching hist manual chain could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain fetchByhistManualId_Last(long histManualId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByhistManualId(histManualId);

		if (count == 0) {
			return null;
		}

		List<HistManualChain> list = findByhistManualId(histManualId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hist manual chains before and after the current hist manual chain in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualChainPK the primary key of the current hist manual chain
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hist manual chain
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain[] findByhistManualId_PrevAndNext(
		HistManualChainPK histManualChainPK, long histManualId,
		OrderByComparator orderByComparator)
		throws NoSuchHistManualChainException, SystemException {
		HistManualChain histManualChain = findByPrimaryKey(histManualChainPK);

		Session session = null;

		try {
			session = openSession();

			HistManualChain[] array = new HistManualChainImpl[3];

			array[0] = getByhistManualId_PrevAndNext(session, histManualChain,
					histManualId, orderByComparator, true);

			array[1] = histManualChain;

			array[2] = getByhistManualId_PrevAndNext(session, histManualChain,
					histManualId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected HistManualChain getByhistManualId_PrevAndNext(Session session,
		HistManualChain histManualChain, long histManualId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HISTMANUALCHAIN_WHERE);

		query.append(_FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2);

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
			query.append(HistManualChainModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(histManualId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(histManualChain);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HistManualChain> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hist manual chains where histManualId = &#63; from the database.
	 *
	 * @param histManualId the hist manual ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByhistManualId(long histManualId)
		throws SystemException {
		for (HistManualChain histManualChain : findByhistManualId(
				histManualId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(histManualChain);
		}
	}

	/**
	 * Returns the number of hist manual chains where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @return the number of matching hist manual chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByhistManualId(long histManualId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HISTMANUALID;

		Object[] finderArgs = new Object[] { histManualId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_HISTMANUALCHAIN_WHERE);

			query.append(_FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(histManualId);

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

	private static final String _FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2 = "histManualChain.id.histManualId = ?";

	public HistManualChainPersistenceImpl() {
		setModelClass(HistManualChain.class);
	}

	/**
	 * Caches the hist manual chain in the entity cache if it is enabled.
	 *
	 * @param histManualChain the hist manual chain
	 */
	@Override
	public void cacheResult(HistManualChain histManualChain) {
		EntityCacheUtil.putResult(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainImpl.class, histManualChain.getPrimaryKey(),
			histManualChain);

		histManualChain.resetOriginalValues();
	}

	/**
	 * Caches the hist manual chains in the entity cache if it is enabled.
	 *
	 * @param histManualChains the hist manual chains
	 */
	@Override
	public void cacheResult(List<HistManualChain> histManualChains) {
		for (HistManualChain histManualChain : histManualChains) {
			if (EntityCacheUtil.getResult(
						HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
						HistManualChainImpl.class,
						histManualChain.getPrimaryKey()) == null) {
				cacheResult(histManualChain);
			}
			else {
				histManualChain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hist manual chains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistManualChainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistManualChainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hist manual chain.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HistManualChain histManualChain) {
		EntityCacheUtil.removeResult(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainImpl.class, histManualChain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HistManualChain> histManualChains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HistManualChain histManualChain : histManualChains) {
			EntityCacheUtil.removeResult(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
				HistManualChainImpl.class, histManualChain.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hist manual chain with the primary key. Does not add the hist manual chain to the database.
	 *
	 * @param histManualChainPK the primary key for the new hist manual chain
	 * @return the new hist manual chain
	 */
	@Override
	public HistManualChain create(HistManualChainPK histManualChainPK) {
		HistManualChain histManualChain = new HistManualChainImpl();

		histManualChain.setNew(true);
		histManualChain.setPrimaryKey(histManualChainPK);

		return histManualChain;
	}

	/**
	 * Removes the hist manual chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param histManualChainPK the primary key of the hist manual chain
	 * @return the hist manual chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain remove(HistManualChainPK histManualChainPK)
		throws NoSuchHistManualChainException, SystemException {
		return remove((Serializable)histManualChainPK);
	}

	/**
	 * Removes the hist manual chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hist manual chain
	 * @return the hist manual chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain remove(Serializable primaryKey)
		throws NoSuchHistManualChainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HistManualChain histManualChain = (HistManualChain)session.get(HistManualChainImpl.class,
					primaryKey);

			if (histManualChain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistManualChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(histManualChain);
		}
		catch (NoSuchHistManualChainException nsee) {
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
	protected HistManualChain removeImpl(HistManualChain histManualChain)
		throws SystemException {
		histManualChain = toUnwrappedModel(histManualChain);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(histManualChain)) {
				histManualChain = (HistManualChain)session.get(HistManualChainImpl.class,
						histManualChain.getPrimaryKeyObj());
			}

			if (histManualChain != null) {
				session.delete(histManualChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (histManualChain != null) {
			clearCache(histManualChain);
		}

		return histManualChain;
	}

	@Override
	public HistManualChain updateImpl(
		com.ihg.brandstandards.db.model.HistManualChain histManualChain)
		throws SystemException {
		histManualChain = toUnwrappedModel(histManualChain);

		boolean isNew = histManualChain.isNew();

		HistManualChainModelImpl histManualChainModelImpl = (HistManualChainModelImpl)histManualChain;

		Session session = null;

		try {
			session = openSession();

			if (histManualChain.isNew()) {
				session.save(histManualChain);

				histManualChain.setNew(false);
			}
			else {
				session.merge(histManualChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HistManualChainModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((histManualChainModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						histManualChainModelImpl.getOriginalHistManualId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HISTMANUALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID,
					args);

				args = new Object[] { histManualChainModelImpl.getHistManualId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HISTMANUALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID,
					args);
			}
		}

		EntityCacheUtil.putResult(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
			HistManualChainImpl.class, histManualChain.getPrimaryKey(),
			histManualChain);

		return histManualChain;
	}

	protected HistManualChain toUnwrappedModel(HistManualChain histManualChain) {
		if (histManualChain instanceof HistManualChainImpl) {
			return histManualChain;
		}

		HistManualChainImpl histManualChainImpl = new HistManualChainImpl();

		histManualChainImpl.setNew(histManualChain.isNew());
		histManualChainImpl.setPrimaryKey(histManualChain.getPrimaryKey());

		histManualChainImpl.setChainCode(histManualChain.getChainCode());
		histManualChainImpl.setHistManualId(histManualChain.getHistManualId());
		histManualChainImpl.setCreatorId(histManualChain.getCreatorId());
		histManualChainImpl.setCreatedDate(histManualChain.getCreatedDate());
		histManualChainImpl.setUpdatedBy(histManualChain.getUpdatedBy());
		histManualChainImpl.setUpdatedDate(histManualChain.getUpdatedDate());

		return histManualChainImpl;
	}

	/**
	 * Returns the hist manual chain with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manual chain
	 * @return the hist manual chain
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistManualChainException, SystemException {
		HistManualChain histManualChain = fetchByPrimaryKey(primaryKey);

		if (histManualChain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistManualChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return histManualChain;
	}

	/**
	 * Returns the hist manual chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualChainException} if it could not be found.
	 *
	 * @param histManualChainPK the primary key of the hist manual chain
	 * @return the hist manual chain
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualChainException if a hist manual chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain findByPrimaryKey(HistManualChainPK histManualChainPK)
		throws NoSuchHistManualChainException, SystemException {
		return findByPrimaryKey((Serializable)histManualChainPK);
	}

	/**
	 * Returns the hist manual chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manual chain
	 * @return the hist manual chain, or <code>null</code> if a hist manual chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		HistManualChain histManualChain = (HistManualChain)EntityCacheUtil.getResult(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
				HistManualChainImpl.class, primaryKey);

		if (histManualChain == _nullHistManualChain) {
			return null;
		}

		if (histManualChain == null) {
			Session session = null;

			try {
				session = openSession();

				histManualChain = (HistManualChain)session.get(HistManualChainImpl.class,
						primaryKey);

				if (histManualChain != null) {
					cacheResult(histManualChain);
				}
				else {
					EntityCacheUtil.putResult(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
						HistManualChainImpl.class, primaryKey,
						_nullHistManualChain);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HistManualChainModelImpl.ENTITY_CACHE_ENABLED,
					HistManualChainImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return histManualChain;
	}

	/**
	 * Returns the hist manual chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param histManualChainPK the primary key of the hist manual chain
	 * @return the hist manual chain, or <code>null</code> if a hist manual chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualChain fetchByPrimaryKey(
		HistManualChainPK histManualChainPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)histManualChainPK);
	}

	/**
	 * Returns all the hist manual chains.
	 *
	 * @return the hist manual chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualChain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hist manual chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manual chains
	 * @param end the upper bound of the range of hist manual chains (not inclusive)
	 * @return the range of hist manual chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualChain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hist manual chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manual chains
	 * @param end the upper bound of the range of hist manual chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hist manual chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualChain> findAll(int start, int end,
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

		List<HistManualChain> list = (List<HistManualChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTMANUALCHAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTMANUALCHAIN;

				if (pagination) {
					sql = sql.concat(HistManualChainModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HistManualChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistManualChain>(list);
				}
				else {
					list = (List<HistManualChain>)QueryUtil.list(q,
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
	 * Removes all the hist manual chains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (HistManualChain histManualChain : findAll()) {
			remove(histManualChain);
		}
	}

	/**
	 * Returns the number of hist manual chains.
	 *
	 * @return the number of hist manual chains
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

				Query q = session.createQuery(_SQL_COUNT_HISTMANUALCHAIN);

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
	 * Initializes the hist manual chain persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.HistManualChain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HistManualChain>> listenersList = new ArrayList<ModelListener<HistManualChain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HistManualChain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistManualChainImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HISTMANUALCHAIN = "SELECT histManualChain FROM HistManualChain histManualChain";
	private static final String _SQL_SELECT_HISTMANUALCHAIN_WHERE = "SELECT histManualChain FROM HistManualChain histManualChain WHERE ";
	private static final String _SQL_COUNT_HISTMANUALCHAIN = "SELECT COUNT(histManualChain) FROM HistManualChain histManualChain";
	private static final String _SQL_COUNT_HISTMANUALCHAIN_WHERE = "SELECT COUNT(histManualChain) FROM HistManualChain histManualChain WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "histManualChain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HistManualChain exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HistManualChain exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistManualChainPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"chainCode", "histManualId", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static HistManualChain _nullHistManualChain = new HistManualChainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HistManualChain> toCacheModel() {
				return _nullHistManualChainCacheModel;
			}
		};

	private static CacheModel<HistManualChain> _nullHistManualChainCacheModel = new CacheModel<HistManualChain>() {
			@Override
			public HistManualChain toEntityModel() {
				return _nullHistManualChain;
			}
		};
}