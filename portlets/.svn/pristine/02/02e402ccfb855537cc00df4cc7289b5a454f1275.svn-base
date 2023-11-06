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

import com.ihg.brandstandards.db.NoSuchHistManualRegionException;
import com.ihg.brandstandards.db.model.HistManualRegion;
import com.ihg.brandstandards.db.model.impl.HistManualRegionImpl;
import com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl;

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
 * The persistence implementation for the hist manual region service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualRegionPersistence
 * @see HistManualRegionUtil
 * @generated
 */
public class HistManualRegionPersistenceImpl extends BasePersistenceImpl<HistManualRegion>
	implements HistManualRegionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistManualRegionUtil} to access the hist manual region persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistManualRegionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionModelImpl.FINDER_CACHE_ENABLED,
			HistManualRegionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionModelImpl.FINDER_CACHE_ENABLED,
			HistManualRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HISTMANUALID =
		new FinderPath(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionModelImpl.FINDER_CACHE_ENABLED,
			HistManualRegionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByhistManualId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID =
		new FinderPath(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionModelImpl.FINDER_CACHE_ENABLED,
			HistManualRegionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByhistManualId",
			new String[] { Long.class.getName() },
			HistManualRegionModelImpl.HISTMANUALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HISTMANUALID = new FinderPath(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByhistManualId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the hist manual regions where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @return the matching hist manual regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualRegion> findByhistManualId(long histManualId)
		throws SystemException {
		return findByhistManualId(histManualId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hist manual regions where histManualId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param histManualId the hist manual ID
	 * @param start the lower bound of the range of hist manual regions
	 * @param end the upper bound of the range of hist manual regions (not inclusive)
	 * @return the range of matching hist manual regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualRegion> findByhistManualId(long histManualId,
		int start, int end) throws SystemException {
		return findByhistManualId(histManualId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the hist manual regions where histManualId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param histManualId the hist manual ID
	 * @param start the lower bound of the range of hist manual regions
	 * @param end the upper bound of the range of hist manual regions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hist manual regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualRegion> findByhistManualId(long histManualId,
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

		List<HistManualRegion> list = (List<HistManualRegion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (HistManualRegion histManualRegion : list) {
				if ((histManualId != histManualRegion.getHistManualId())) {
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

			query.append(_SQL_SELECT_HISTMANUALREGION_WHERE);

			query.append(_FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(HistManualRegionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(histManualId);

				if (!pagination) {
					list = (List<HistManualRegion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistManualRegion>(list);
				}
				else {
					list = (List<HistManualRegion>)QueryUtil.list(q,
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
	 * Returns the first hist manual region in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hist manual region
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a matching hist manual region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion findByhistManualId_First(long histManualId,
		OrderByComparator orderByComparator)
		throws NoSuchHistManualRegionException, SystemException {
		HistManualRegion histManualRegion = fetchByhistManualId_First(histManualId,
				orderByComparator);

		if (histManualRegion != null) {
			return histManualRegion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("histManualId=");
		msg.append(histManualId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHistManualRegionException(msg.toString());
	}

	/**
	 * Returns the first hist manual region in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hist manual region, or <code>null</code> if a matching hist manual region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion fetchByhistManualId_First(long histManualId,
		OrderByComparator orderByComparator) throws SystemException {
		List<HistManualRegion> list = findByhistManualId(histManualId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last hist manual region in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hist manual region
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a matching hist manual region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion findByhistManualId_Last(long histManualId,
		OrderByComparator orderByComparator)
		throws NoSuchHistManualRegionException, SystemException {
		HistManualRegion histManualRegion = fetchByhistManualId_Last(histManualId,
				orderByComparator);

		if (histManualRegion != null) {
			return histManualRegion;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("histManualId=");
		msg.append(histManualId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchHistManualRegionException(msg.toString());
	}

	/**
	 * Returns the last hist manual region in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hist manual region, or <code>null</code> if a matching hist manual region could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion fetchByhistManualId_Last(long histManualId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByhistManualId(histManualId);

		if (count == 0) {
			return null;
		}

		List<HistManualRegion> list = findByhistManualId(histManualId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the hist manual regions before and after the current hist manual region in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualRegionPK the primary key of the current hist manual region
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hist manual region
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion[] findByhistManualId_PrevAndNext(
		HistManualRegionPK histManualRegionPK, long histManualId,
		OrderByComparator orderByComparator)
		throws NoSuchHistManualRegionException, SystemException {
		HistManualRegion histManualRegion = findByPrimaryKey(histManualRegionPK);

		Session session = null;

		try {
			session = openSession();

			HistManualRegion[] array = new HistManualRegionImpl[3];

			array[0] = getByhistManualId_PrevAndNext(session, histManualRegion,
					histManualId, orderByComparator, true);

			array[1] = histManualRegion;

			array[2] = getByhistManualId_PrevAndNext(session, histManualRegion,
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

	protected HistManualRegion getByhistManualId_PrevAndNext(Session session,
		HistManualRegion histManualRegion, long histManualId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_HISTMANUALREGION_WHERE);

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
			query.append(HistManualRegionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(histManualId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(histManualRegion);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<HistManualRegion> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the hist manual regions where histManualId = &#63; from the database.
	 *
	 * @param histManualId the hist manual ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByhistManualId(long histManualId)
		throws SystemException {
		for (HistManualRegion histManualRegion : findByhistManualId(
				histManualId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(histManualRegion);
		}
	}

	/**
	 * Returns the number of hist manual regions where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @return the number of matching hist manual regions
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

			query.append(_SQL_COUNT_HISTMANUALREGION_WHERE);

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

	private static final String _FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2 = "histManualRegion.id.histManualId = ?";

	public HistManualRegionPersistenceImpl() {
		setModelClass(HistManualRegion.class);
	}

	/**
	 * Caches the hist manual region in the entity cache if it is enabled.
	 *
	 * @param histManualRegion the hist manual region
	 */
	@Override
	public void cacheResult(HistManualRegion histManualRegion) {
		EntityCacheUtil.putResult(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionImpl.class, histManualRegion.getPrimaryKey(),
			histManualRegion);

		histManualRegion.resetOriginalValues();
	}

	/**
	 * Caches the hist manual regions in the entity cache if it is enabled.
	 *
	 * @param histManualRegions the hist manual regions
	 */
	@Override
	public void cacheResult(List<HistManualRegion> histManualRegions) {
		for (HistManualRegion histManualRegion : histManualRegions) {
			if (EntityCacheUtil.getResult(
						HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
						HistManualRegionImpl.class,
						histManualRegion.getPrimaryKey()) == null) {
				cacheResult(histManualRegion);
			}
			else {
				histManualRegion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hist manual regions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistManualRegionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistManualRegionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hist manual region.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HistManualRegion histManualRegion) {
		EntityCacheUtil.removeResult(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionImpl.class, histManualRegion.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HistManualRegion> histManualRegions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HistManualRegion histManualRegion : histManualRegions) {
			EntityCacheUtil.removeResult(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
				HistManualRegionImpl.class, histManualRegion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hist manual region with the primary key. Does not add the hist manual region to the database.
	 *
	 * @param histManualRegionPK the primary key for the new hist manual region
	 * @return the new hist manual region
	 */
	@Override
	public HistManualRegion create(HistManualRegionPK histManualRegionPK) {
		HistManualRegion histManualRegion = new HistManualRegionImpl();

		histManualRegion.setNew(true);
		histManualRegion.setPrimaryKey(histManualRegionPK);

		return histManualRegion;
	}

	/**
	 * Removes the hist manual region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param histManualRegionPK the primary key of the hist manual region
	 * @return the hist manual region that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion remove(HistManualRegionPK histManualRegionPK)
		throws NoSuchHistManualRegionException, SystemException {
		return remove((Serializable)histManualRegionPK);
	}

	/**
	 * Removes the hist manual region with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hist manual region
	 * @return the hist manual region that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion remove(Serializable primaryKey)
		throws NoSuchHistManualRegionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HistManualRegion histManualRegion = (HistManualRegion)session.get(HistManualRegionImpl.class,
					primaryKey);

			if (histManualRegion == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistManualRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(histManualRegion);
		}
		catch (NoSuchHistManualRegionException nsee) {
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
	protected HistManualRegion removeImpl(HistManualRegion histManualRegion)
		throws SystemException {
		histManualRegion = toUnwrappedModel(histManualRegion);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(histManualRegion)) {
				histManualRegion = (HistManualRegion)session.get(HistManualRegionImpl.class,
						histManualRegion.getPrimaryKeyObj());
			}

			if (histManualRegion != null) {
				session.delete(histManualRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (histManualRegion != null) {
			clearCache(histManualRegion);
		}

		return histManualRegion;
	}

	@Override
	public HistManualRegion updateImpl(
		com.ihg.brandstandards.db.model.HistManualRegion histManualRegion)
		throws SystemException {
		histManualRegion = toUnwrappedModel(histManualRegion);

		boolean isNew = histManualRegion.isNew();

		HistManualRegionModelImpl histManualRegionModelImpl = (HistManualRegionModelImpl)histManualRegion;

		Session session = null;

		try {
			session = openSession();

			if (histManualRegion.isNew()) {
				session.save(histManualRegion);

				histManualRegion.setNew(false);
			}
			else {
				session.merge(histManualRegion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !HistManualRegionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((histManualRegionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						histManualRegionModelImpl.getOriginalHistManualId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HISTMANUALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID,
					args);

				args = new Object[] { histManualRegionModelImpl.getHistManualId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HISTMANUALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID,
					args);
			}
		}

		EntityCacheUtil.putResult(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
			HistManualRegionImpl.class, histManualRegion.getPrimaryKey(),
			histManualRegion);

		return histManualRegion;
	}

	protected HistManualRegion toUnwrappedModel(
		HistManualRegion histManualRegion) {
		if (histManualRegion instanceof HistManualRegionImpl) {
			return histManualRegion;
		}

		HistManualRegionImpl histManualRegionImpl = new HistManualRegionImpl();

		histManualRegionImpl.setNew(histManualRegion.isNew());
		histManualRegionImpl.setPrimaryKey(histManualRegion.getPrimaryKey());

		histManualRegionImpl.setRegionCode(histManualRegion.getRegionCode());
		histManualRegionImpl.setHistManualId(histManualRegion.getHistManualId());
		histManualRegionImpl.setCreatorId(histManualRegion.getCreatorId());
		histManualRegionImpl.setCreatedDate(histManualRegion.getCreatedDate());
		histManualRegionImpl.setUpdatedBy(histManualRegion.getUpdatedBy());
		histManualRegionImpl.setUpdatedDate(histManualRegion.getUpdatedDate());

		return histManualRegionImpl;
	}

	/**
	 * Returns the hist manual region with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manual region
	 * @return the hist manual region
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistManualRegionException, SystemException {
		HistManualRegion histManualRegion = fetchByPrimaryKey(primaryKey);

		if (histManualRegion == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistManualRegionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return histManualRegion;
	}

	/**
	 * Returns the hist manual region with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualRegionException} if it could not be found.
	 *
	 * @param histManualRegionPK the primary key of the hist manual region
	 * @return the hist manual region
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualRegionException if a hist manual region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion findByPrimaryKey(
		HistManualRegionPK histManualRegionPK)
		throws NoSuchHistManualRegionException, SystemException {
		return findByPrimaryKey((Serializable)histManualRegionPK);
	}

	/**
	 * Returns the hist manual region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manual region
	 * @return the hist manual region, or <code>null</code> if a hist manual region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		HistManualRegion histManualRegion = (HistManualRegion)EntityCacheUtil.getResult(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
				HistManualRegionImpl.class, primaryKey);

		if (histManualRegion == _nullHistManualRegion) {
			return null;
		}

		if (histManualRegion == null) {
			Session session = null;

			try {
				session = openSession();

				histManualRegion = (HistManualRegion)session.get(HistManualRegionImpl.class,
						primaryKey);

				if (histManualRegion != null) {
					cacheResult(histManualRegion);
				}
				else {
					EntityCacheUtil.putResult(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
						HistManualRegionImpl.class, primaryKey,
						_nullHistManualRegion);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HistManualRegionModelImpl.ENTITY_CACHE_ENABLED,
					HistManualRegionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return histManualRegion;
	}

	/**
	 * Returns the hist manual region with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param histManualRegionPK the primary key of the hist manual region
	 * @return the hist manual region, or <code>null</code> if a hist manual region with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManualRegion fetchByPrimaryKey(
		HistManualRegionPK histManualRegionPK) throws SystemException {
		return fetchByPrimaryKey((Serializable)histManualRegionPK);
	}

	/**
	 * Returns all the hist manual regions.
	 *
	 * @return the hist manual regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualRegion> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hist manual regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manual regions
	 * @param end the upper bound of the range of hist manual regions (not inclusive)
	 * @return the range of hist manual regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualRegion> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hist manual regions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualRegionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manual regions
	 * @param end the upper bound of the range of hist manual regions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hist manual regions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManualRegion> findAll(int start, int end,
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

		List<HistManualRegion> list = (List<HistManualRegion>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTMANUALREGION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTMANUALREGION;

				if (pagination) {
					sql = sql.concat(HistManualRegionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HistManualRegion>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistManualRegion>(list);
				}
				else {
					list = (List<HistManualRegion>)QueryUtil.list(q,
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
	 * Removes all the hist manual regions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (HistManualRegion histManualRegion : findAll()) {
			remove(histManualRegion);
		}
	}

	/**
	 * Returns the number of hist manual regions.
	 *
	 * @return the number of hist manual regions
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

				Query q = session.createQuery(_SQL_COUNT_HISTMANUALREGION);

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
	 * Initializes the hist manual region persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.HistManualRegion")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HistManualRegion>> listenersList = new ArrayList<ModelListener<HistManualRegion>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HistManualRegion>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistManualRegionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HISTMANUALREGION = "SELECT histManualRegion FROM HistManualRegion histManualRegion";
	private static final String _SQL_SELECT_HISTMANUALREGION_WHERE = "SELECT histManualRegion FROM HistManualRegion histManualRegion WHERE ";
	private static final String _SQL_COUNT_HISTMANUALREGION = "SELECT COUNT(histManualRegion) FROM HistManualRegion histManualRegion";
	private static final String _SQL_COUNT_HISTMANUALREGION_WHERE = "SELECT COUNT(histManualRegion) FROM HistManualRegion histManualRegion WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "histManualRegion.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HistManualRegion exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No HistManualRegion exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistManualRegionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"regionCode", "histManualId", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static HistManualRegion _nullHistManualRegion = new HistManualRegionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HistManualRegion> toCacheModel() {
				return _nullHistManualRegionCacheModel;
			}
		};

	private static CacheModel<HistManualRegion> _nullHistManualRegionCacheModel = new CacheModel<HistManualRegion>() {
			@Override
			public HistManualRegion toEntityModel() {
				return _nullHistManualRegion;
			}
		};
}