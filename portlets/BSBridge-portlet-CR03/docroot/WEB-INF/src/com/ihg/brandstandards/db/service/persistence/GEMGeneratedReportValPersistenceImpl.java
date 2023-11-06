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

import com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException;
import com.ihg.brandstandards.db.model.GEMGeneratedReportVal;
import com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValImpl;
import com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl;

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
 * The persistence implementation for the g e m generated report val service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMGeneratedReportValPersistence
 * @see GEMGeneratedReportValUtil
 * @generated
 */
public class GEMGeneratedReportValPersistenceImpl extends BasePersistenceImpl<GEMGeneratedReportVal>
	implements GEMGeneratedReportValPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMGeneratedReportValUtil} to access the g e m generated report val persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMGeneratedReportValImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportValImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportValImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTID = new FinderPath(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportValImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByReportId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTID =
		new FinderPath(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportValImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByReportId",
			new String[] { Long.class.getName() },
			GEMGeneratedReportValModelImpl.REPORTID_COLUMN_BITMASK |
			GEMGeneratedReportValModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPORTID = new FinderPath(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByReportId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m generated report vals where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the matching g e m generated report vals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReportVal> findByReportId(long reportId)
		throws SystemException {
		return findByReportId(reportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the g e m generated report vals where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of g e m generated report vals
	 * @param end the upper bound of the range of g e m generated report vals (not inclusive)
	 * @return the range of matching g e m generated report vals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReportVal> findByReportId(long reportId, int start,
		int end) throws SystemException {
		return findByReportId(reportId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m generated report vals where reportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param reportId the report ID
	 * @param start the lower bound of the range of g e m generated report vals
	 * @param end the upper bound of the range of g e m generated report vals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m generated report vals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReportVal> findByReportId(long reportId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTID;
			finderArgs = new Object[] { reportId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPORTID;
			finderArgs = new Object[] { reportId, start, end, orderByComparator };
		}

		List<GEMGeneratedReportVal> list = (List<GEMGeneratedReportVal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMGeneratedReportVal gemGeneratedReportVal : list) {
				if ((reportId != gemGeneratedReportVal.getReportId())) {
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

			query.append(_SQL_SELECT_GEMGENERATEDREPORTVAL_WHERE);

			query.append(_FINDER_COLUMN_REPORTID_REPORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMGeneratedReportValModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

				if (!pagination) {
					list = (List<GEMGeneratedReportVal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMGeneratedReportVal>(list);
				}
				else {
					list = (List<GEMGeneratedReportVal>)QueryUtil.list(q,
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
	 * Returns the first g e m generated report val in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m generated report val
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a matching g e m generated report val could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal findByReportId_First(long reportId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMGeneratedReportValException, SystemException {
		GEMGeneratedReportVal gemGeneratedReportVal = fetchByReportId_First(reportId,
				orderByComparator);

		if (gemGeneratedReportVal != null) {
			return gemGeneratedReportVal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMGeneratedReportValException(msg.toString());
	}

	/**
	 * Returns the first g e m generated report val in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m generated report val, or <code>null</code> if a matching g e m generated report val could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal fetchByReportId_First(long reportId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMGeneratedReportVal> list = findByReportId(reportId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m generated report val in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m generated report val
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a matching g e m generated report val could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal findByReportId_Last(long reportId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMGeneratedReportValException, SystemException {
		GEMGeneratedReportVal gemGeneratedReportVal = fetchByReportId_Last(reportId,
				orderByComparator);

		if (gemGeneratedReportVal != null) {
			return gemGeneratedReportVal;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("reportId=");
		msg.append(reportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMGeneratedReportValException(msg.toString());
	}

	/**
	 * Returns the last g e m generated report val in the ordered set where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m generated report val, or <code>null</code> if a matching g e m generated report val could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal fetchByReportId_Last(long reportId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReportId(reportId);

		if (count == 0) {
			return null;
		}

		List<GEMGeneratedReportVal> list = findByReportId(reportId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m generated report vals before and after the current g e m generated report val in the ordered set where reportId = &#63;.
	 *
	 * @param gemGeneratedReportValPK the primary key of the current g e m generated report val
	 * @param reportId the report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m generated report val
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal[] findByReportId_PrevAndNext(
		GEMGeneratedReportValPK gemGeneratedReportValPK, long reportId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMGeneratedReportValException, SystemException {
		GEMGeneratedReportVal gemGeneratedReportVal = findByPrimaryKey(gemGeneratedReportValPK);

		Session session = null;

		try {
			session = openSession();

			GEMGeneratedReportVal[] array = new GEMGeneratedReportValImpl[3];

			array[0] = getByReportId_PrevAndNext(session,
					gemGeneratedReportVal, reportId, orderByComparator, true);

			array[1] = gemGeneratedReportVal;

			array[2] = getByReportId_PrevAndNext(session,
					gemGeneratedReportVal, reportId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMGeneratedReportVal getByReportId_PrevAndNext(Session session,
		GEMGeneratedReportVal gemGeneratedReportVal, long reportId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMGENERATEDREPORTVAL_WHERE);

		query.append(_FINDER_COLUMN_REPORTID_REPORTID_2);

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
			query.append(GEMGeneratedReportValModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(reportId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemGeneratedReportVal);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMGeneratedReportVal> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m generated report vals where reportId = &#63; from the database.
	 *
	 * @param reportId the report ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReportId(long reportId) throws SystemException {
		for (GEMGeneratedReportVal gemGeneratedReportVal : findByReportId(
				reportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemGeneratedReportVal);
		}
	}

	/**
	 * Returns the number of g e m generated report vals where reportId = &#63;.
	 *
	 * @param reportId the report ID
	 * @return the number of matching g e m generated report vals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReportId(long reportId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPORTID;

		Object[] finderArgs = new Object[] { reportId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMGENERATEDREPORTVAL_WHERE);

			query.append(_FINDER_COLUMN_REPORTID_REPORTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(reportId);

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

	private static final String _FINDER_COLUMN_REPORTID_REPORTID_2 = "gemGeneratedReportVal.id.reportId = ?";

	public GEMGeneratedReportValPersistenceImpl() {
		setModelClass(GEMGeneratedReportVal.class);
	}

	/**
	 * Caches the g e m generated report val in the entity cache if it is enabled.
	 *
	 * @param gemGeneratedReportVal the g e m generated report val
	 */
	@Override
	public void cacheResult(GEMGeneratedReportVal gemGeneratedReportVal) {
		EntityCacheUtil.putResult(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValImpl.class,
			gemGeneratedReportVal.getPrimaryKey(), gemGeneratedReportVal);

		gemGeneratedReportVal.resetOriginalValues();
	}

	/**
	 * Caches the g e m generated report vals in the entity cache if it is enabled.
	 *
	 * @param gemGeneratedReportVals the g e m generated report vals
	 */
	@Override
	public void cacheResult(List<GEMGeneratedReportVal> gemGeneratedReportVals) {
		for (GEMGeneratedReportVal gemGeneratedReportVal : gemGeneratedReportVals) {
			if (EntityCacheUtil.getResult(
						GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
						GEMGeneratedReportValImpl.class,
						gemGeneratedReportVal.getPrimaryKey()) == null) {
				cacheResult(gemGeneratedReportVal);
			}
			else {
				gemGeneratedReportVal.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m generated report vals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMGeneratedReportValImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMGeneratedReportValImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m generated report val.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMGeneratedReportVal gemGeneratedReportVal) {
		EntityCacheUtil.removeResult(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValImpl.class,
			gemGeneratedReportVal.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMGeneratedReportVal> gemGeneratedReportVals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMGeneratedReportVal gemGeneratedReportVal : gemGeneratedReportVals) {
			EntityCacheUtil.removeResult(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
				GEMGeneratedReportValImpl.class,
				gemGeneratedReportVal.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m generated report val with the primary key. Does not add the g e m generated report val to the database.
	 *
	 * @param gemGeneratedReportValPK the primary key for the new g e m generated report val
	 * @return the new g e m generated report val
	 */
	@Override
	public GEMGeneratedReportVal create(
		GEMGeneratedReportValPK gemGeneratedReportValPK) {
		GEMGeneratedReportVal gemGeneratedReportVal = new GEMGeneratedReportValImpl();

		gemGeneratedReportVal.setNew(true);
		gemGeneratedReportVal.setPrimaryKey(gemGeneratedReportValPK);

		return gemGeneratedReportVal;
	}

	/**
	 * Removes the g e m generated report val with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param gemGeneratedReportValPK the primary key of the g e m generated report val
	 * @return the g e m generated report val that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal remove(
		GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws NoSuchGEMGeneratedReportValException, SystemException {
		return remove((Serializable)gemGeneratedReportValPK);
	}

	/**
	 * Removes the g e m generated report val with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m generated report val
	 * @return the g e m generated report val that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal remove(Serializable primaryKey)
		throws NoSuchGEMGeneratedReportValException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMGeneratedReportVal gemGeneratedReportVal = (GEMGeneratedReportVal)session.get(GEMGeneratedReportValImpl.class,
					primaryKey);

			if (gemGeneratedReportVal == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMGeneratedReportValException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemGeneratedReportVal);
		}
		catch (NoSuchGEMGeneratedReportValException nsee) {
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
	protected GEMGeneratedReportVal removeImpl(
		GEMGeneratedReportVal gemGeneratedReportVal) throws SystemException {
		gemGeneratedReportVal = toUnwrappedModel(gemGeneratedReportVal);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemGeneratedReportVal)) {
				gemGeneratedReportVal = (GEMGeneratedReportVal)session.get(GEMGeneratedReportValImpl.class,
						gemGeneratedReportVal.getPrimaryKeyObj());
			}

			if (gemGeneratedReportVal != null) {
				session.delete(gemGeneratedReportVal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemGeneratedReportVal != null) {
			clearCache(gemGeneratedReportVal);
		}

		return gemGeneratedReportVal;
	}

	@Override
	public GEMGeneratedReportVal updateImpl(
		com.ihg.brandstandards.db.model.GEMGeneratedReportVal gemGeneratedReportVal)
		throws SystemException {
		gemGeneratedReportVal = toUnwrappedModel(gemGeneratedReportVal);

		boolean isNew = gemGeneratedReportVal.isNew();

		GEMGeneratedReportValModelImpl gemGeneratedReportValModelImpl = (GEMGeneratedReportValModelImpl)gemGeneratedReportVal;

		Session session = null;

		try {
			session = openSession();

			if (gemGeneratedReportVal.isNew()) {
				session.save(gemGeneratedReportVal);

				gemGeneratedReportVal.setNew(false);
			}
			else {
				session.merge(gemGeneratedReportVal);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMGeneratedReportValModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemGeneratedReportValModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemGeneratedReportValModelImpl.getOriginalReportId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTID,
					args);

				args = new Object[] { gemGeneratedReportValModelImpl.getReportId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPORTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPORTID,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportValImpl.class,
			gemGeneratedReportVal.getPrimaryKey(), gemGeneratedReportVal);

		return gemGeneratedReportVal;
	}

	protected GEMGeneratedReportVal toUnwrappedModel(
		GEMGeneratedReportVal gemGeneratedReportVal) {
		if (gemGeneratedReportVal instanceof GEMGeneratedReportValImpl) {
			return gemGeneratedReportVal;
		}

		GEMGeneratedReportValImpl gemGeneratedReportValImpl = new GEMGeneratedReportValImpl();

		gemGeneratedReportValImpl.setNew(gemGeneratedReportVal.isNew());
		gemGeneratedReportValImpl.setPrimaryKey(gemGeneratedReportVal.getPrimaryKey());

		gemGeneratedReportValImpl.setReportValId(gemGeneratedReportVal.getReportValId());
		gemGeneratedReportValImpl.setReportId(gemGeneratedReportVal.getReportId());
		gemGeneratedReportValImpl.setColumnId(gemGeneratedReportVal.getColumnId());
		gemGeneratedReportValImpl.setGeneratedValue(gemGeneratedReportVal.getGeneratedValue());
		gemGeneratedReportValImpl.setDisplayOrderNumber(gemGeneratedReportVal.getDisplayOrderNumber());
		gemGeneratedReportValImpl.setCreatorId(gemGeneratedReportVal.getCreatorId());
		gemGeneratedReportValImpl.setCreatedDate(gemGeneratedReportVal.getCreatedDate());
		gemGeneratedReportValImpl.setUpdatedBy(gemGeneratedReportVal.getUpdatedBy());
		gemGeneratedReportValImpl.setUpdatedDate(gemGeneratedReportVal.getUpdatedDate());

		return gemGeneratedReportValImpl;
	}

	/**
	 * Returns the g e m generated report val with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m generated report val
	 * @return the g e m generated report val
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMGeneratedReportValException, SystemException {
		GEMGeneratedReportVal gemGeneratedReportVal = fetchByPrimaryKey(primaryKey);

		if (gemGeneratedReportVal == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMGeneratedReportValException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemGeneratedReportVal;
	}

	/**
	 * Returns the g e m generated report val with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException} if it could not be found.
	 *
	 * @param gemGeneratedReportValPK the primary key of the g e m generated report val
	 * @return the g e m generated report val
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException if a g e m generated report val with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal findByPrimaryKey(
		GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws NoSuchGEMGeneratedReportValException, SystemException {
		return findByPrimaryKey((Serializable)gemGeneratedReportValPK);
	}

	/**
	 * Returns the g e m generated report val with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m generated report val
	 * @return the g e m generated report val, or <code>null</code> if a g e m generated report val with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMGeneratedReportVal gemGeneratedReportVal = (GEMGeneratedReportVal)EntityCacheUtil.getResult(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
				GEMGeneratedReportValImpl.class, primaryKey);

		if (gemGeneratedReportVal == _nullGEMGeneratedReportVal) {
			return null;
		}

		if (gemGeneratedReportVal == null) {
			Session session = null;

			try {
				session = openSession();

				gemGeneratedReportVal = (GEMGeneratedReportVal)session.get(GEMGeneratedReportValImpl.class,
						primaryKey);

				if (gemGeneratedReportVal != null) {
					cacheResult(gemGeneratedReportVal);
				}
				else {
					EntityCacheUtil.putResult(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
						GEMGeneratedReportValImpl.class, primaryKey,
						_nullGEMGeneratedReportVal);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMGeneratedReportValModelImpl.ENTITY_CACHE_ENABLED,
					GEMGeneratedReportValImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemGeneratedReportVal;
	}

	/**
	 * Returns the g e m generated report val with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param gemGeneratedReportValPK the primary key of the g e m generated report val
	 * @return the g e m generated report val, or <code>null</code> if a g e m generated report val with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReportVal fetchByPrimaryKey(
		GEMGeneratedReportValPK gemGeneratedReportValPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)gemGeneratedReportValPK);
	}

	/**
	 * Returns all the g e m generated report vals.
	 *
	 * @return the g e m generated report vals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReportVal> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m generated report vals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m generated report vals
	 * @param end the upper bound of the range of g e m generated report vals (not inclusive)
	 * @return the range of g e m generated report vals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReportVal> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m generated report vals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m generated report vals
	 * @param end the upper bound of the range of g e m generated report vals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m generated report vals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReportVal> findAll(int start, int end,
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

		List<GEMGeneratedReportVal> list = (List<GEMGeneratedReportVal>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMGENERATEDREPORTVAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMGENERATEDREPORTVAL;

				if (pagination) {
					sql = sql.concat(GEMGeneratedReportValModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMGeneratedReportVal>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMGeneratedReportVal>(list);
				}
				else {
					list = (List<GEMGeneratedReportVal>)QueryUtil.list(q,
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
	 * Removes all the g e m generated report vals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMGeneratedReportVal gemGeneratedReportVal : findAll()) {
			remove(gemGeneratedReportVal);
		}
	}

	/**
	 * Returns the number of g e m generated report vals.
	 *
	 * @return the number of g e m generated report vals
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

				Query q = session.createQuery(_SQL_COUNT_GEMGENERATEDREPORTVAL);

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
	 * Initializes the g e m generated report val persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMGeneratedReportVal")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMGeneratedReportVal>> listenersList = new ArrayList<ModelListener<GEMGeneratedReportVal>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMGeneratedReportVal>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMGeneratedReportValImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMGENERATEDREPORTVAL = "SELECT gemGeneratedReportVal FROM GEMGeneratedReportVal gemGeneratedReportVal";
	private static final String _SQL_SELECT_GEMGENERATEDREPORTVAL_WHERE = "SELECT gemGeneratedReportVal FROM GEMGeneratedReportVal gemGeneratedReportVal WHERE ";
	private static final String _SQL_COUNT_GEMGENERATEDREPORTVAL = "SELECT COUNT(gemGeneratedReportVal) FROM GEMGeneratedReportVal gemGeneratedReportVal";
	private static final String _SQL_COUNT_GEMGENERATEDREPORTVAL_WHERE = "SELECT COUNT(gemGeneratedReportVal) FROM GEMGeneratedReportVal gemGeneratedReportVal WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemGeneratedReportVal.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMGeneratedReportVal exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMGeneratedReportVal exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMGeneratedReportValPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"reportValId", "reportId", "columnId", "generatedValue",
				"displayOrderNumber", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static GEMGeneratedReportVal _nullGEMGeneratedReportVal = new GEMGeneratedReportValImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMGeneratedReportVal> toCacheModel() {
				return _nullGEMGeneratedReportValCacheModel;
			}
		};

	private static CacheModel<GEMGeneratedReportVal> _nullGEMGeneratedReportValCacheModel =
		new CacheModel<GEMGeneratedReportVal>() {
			@Override
			public GEMGeneratedReportVal toEntityModel() {
				return _nullGEMGeneratedReportVal;
			}
		};
}