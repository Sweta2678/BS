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

import com.ihg.brandstandards.db.NoSuchGEMQlReportException;
import com.ihg.brandstandards.db.model.GEMQlReport;
import com.ihg.brandstandards.db.model.impl.GEMQlReportImpl;
import com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl;

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
 * The persistence implementation for the g e m ql report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMQlReportPersistence
 * @see GEMQlReportUtil
 * @generated
 */
public class GEMQlReportPersistenceImpl extends BasePersistenceImpl<GEMQlReport>
	implements GEMQlReportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMQlReportUtil} to access the g e m ql report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMQlReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDREGIONID =
		new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishIdRegionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDREGIONID =
		new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdRegionId", new String[] { Long.class.getName() },
			GEMQlReportModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDREGIONID = new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdRegionId", new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m ql reports where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findByPublishIdRegionId(long publishId)
		throws SystemException {
		return findByPublishIdRegionId(publishId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m ql reports where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @return the range of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findByPublishIdRegionId(long publishId, int start,
		int end) throws SystemException {
		return findByPublishIdRegionId(publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m ql reports where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findByPublishIdRegionId(long publishId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDREGIONID;
			finderArgs = new Object[] { publishId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDREGIONID;
			finderArgs = new Object[] { publishId, start, end, orderByComparator };
		}

		List<GEMQlReport> list = (List<GEMQlReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMQlReport gemQlReport : list) {
				if ((publishId != gemQlReport.getPublishId())) {
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

			query.append(_SQL_SELECT_GEMQLREPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONID_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMQlReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMQlReport>(list);
				}
				else {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m ql report in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findByPublishIdRegionId_First(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = fetchByPublishIdRegionId_First(publishId,
				orderByComparator);

		if (gemQlReport != null) {
			return gemQlReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMQlReportException(msg.toString());
	}

	/**
	 * Returns the first g e m ql report in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchByPublishIdRegionId_First(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMQlReport> list = findByPublishIdRegionId(publishId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m ql report in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findByPublishIdRegionId_Last(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = fetchByPublishIdRegionId_Last(publishId,
				orderByComparator);

		if (gemQlReport != null) {
			return gemQlReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMQlReportException(msg.toString());
	}

	/**
	 * Returns the last g e m ql report in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchByPublishIdRegionId_Last(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishIdRegionId(publishId);

		if (count == 0) {
			return null;
		}

		List<GEMQlReport> list = findByPublishIdRegionId(publishId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m ql reports before and after the current g e m ql report in the ordered set where publishId = &#63;.
	 *
	 * @param qlReportId the primary key of the current g e m ql report
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport[] findByPublishIdRegionId_PrevAndNext(long qlReportId,
		long publishId, OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = findByPrimaryKey(qlReportId);

		Session session = null;

		try {
			session = openSession();

			GEMQlReport[] array = new GEMQlReportImpl[3];

			array[0] = getByPublishIdRegionId_PrevAndNext(session, gemQlReport,
					publishId, orderByComparator, true);

			array[1] = gemQlReport;

			array[2] = getByPublishIdRegionId_PrevAndNext(session, gemQlReport,
					publishId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMQlReport getByPublishIdRegionId_PrevAndNext(Session session,
		GEMQlReport gemQlReport, long publishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMQLREPORT_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDREGIONID_PUBLISHID_2);

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
			query.append(GEMQlReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemQlReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMQlReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m ql reports where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdRegionId(long publishId)
		throws SystemException {
		for (GEMQlReport gemQlReport : findByPublishIdRegionId(publishId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemQlReport);
		}
	}

	/**
	 * Returns the number of g e m ql reports where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdRegionId(long publishId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDREGIONID;

		Object[] finderArgs = new Object[] { publishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMQLREPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONID_PUBLISHID_2);

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

	private static final String _FINDER_COLUMN_PUBLISHIDREGIONID_PUBLISHID_2 = "gemQlReport.publishId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTQLREPORTID =
		new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparentQlReportId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTQLREPORTID =
		new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByparentQlReportId", new String[] { Long.class.getName() },
			GEMQlReportModelImpl.PARENTQLREPORTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTQLREPORTID = new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByparentQlReportId", new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m ql reports where parentQlReportId = &#63;.
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @return the matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findByparentQlReportId(long parentQlReportId)
		throws SystemException {
		return findByparentQlReportId(parentQlReportId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m ql reports where parentQlReportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @return the range of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findByparentQlReportId(long parentQlReportId,
		int start, int end) throws SystemException {
		return findByparentQlReportId(parentQlReportId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m ql reports where parentQlReportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findByparentQlReportId(long parentQlReportId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTQLREPORTID;
			finderArgs = new Object[] { parentQlReportId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTQLREPORTID;
			finderArgs = new Object[] {
					parentQlReportId,
					
					start, end, orderByComparator
				};
		}

		List<GEMQlReport> list = (List<GEMQlReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMQlReport gemQlReport : list) {
				if ((parentQlReportId != gemQlReport.getParentQlReportId())) {
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

			query.append(_SQL_SELECT_GEMQLREPORT_WHERE);

			query.append(_FINDER_COLUMN_PARENTQLREPORTID_PARENTQLREPORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMQlReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentQlReportId);

				if (!pagination) {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMQlReport>(list);
				}
				else {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m ql report in the ordered set where parentQlReportId = &#63;.
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findByparentQlReportId_First(long parentQlReportId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = fetchByparentQlReportId_First(parentQlReportId,
				orderByComparator);

		if (gemQlReport != null) {
			return gemQlReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentQlReportId=");
		msg.append(parentQlReportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMQlReportException(msg.toString());
	}

	/**
	 * Returns the first g e m ql report in the ordered set where parentQlReportId = &#63;.
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchByparentQlReportId_First(long parentQlReportId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMQlReport> list = findByparentQlReportId(parentQlReportId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m ql report in the ordered set where parentQlReportId = &#63;.
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findByparentQlReportId_Last(long parentQlReportId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = fetchByparentQlReportId_Last(parentQlReportId,
				orderByComparator);

		if (gemQlReport != null) {
			return gemQlReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentQlReportId=");
		msg.append(parentQlReportId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMQlReportException(msg.toString());
	}

	/**
	 * Returns the last g e m ql report in the ordered set where parentQlReportId = &#63;.
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchByparentQlReportId_Last(long parentQlReportId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByparentQlReportId(parentQlReportId);

		if (count == 0) {
			return null;
		}

		List<GEMQlReport> list = findByparentQlReportId(parentQlReportId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m ql reports before and after the current g e m ql report in the ordered set where parentQlReportId = &#63;.
	 *
	 * @param qlReportId the primary key of the current g e m ql report
	 * @param parentQlReportId the parent ql report ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport[] findByparentQlReportId_PrevAndNext(long qlReportId,
		long parentQlReportId, OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = findByPrimaryKey(qlReportId);

		Session session = null;

		try {
			session = openSession();

			GEMQlReport[] array = new GEMQlReportImpl[3];

			array[0] = getByparentQlReportId_PrevAndNext(session, gemQlReport,
					parentQlReportId, orderByComparator, true);

			array[1] = gemQlReport;

			array[2] = getByparentQlReportId_PrevAndNext(session, gemQlReport,
					parentQlReportId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMQlReport getByparentQlReportId_PrevAndNext(Session session,
		GEMQlReport gemQlReport, long parentQlReportId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMQLREPORT_WHERE);

		query.append(_FINDER_COLUMN_PARENTQLREPORTID_PARENTQLREPORTID_2);

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
			query.append(GEMQlReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentQlReportId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemQlReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMQlReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m ql reports where parentQlReportId = &#63; from the database.
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentQlReportId(long parentQlReportId)
		throws SystemException {
		for (GEMQlReport gemQlReport : findByparentQlReportId(
				parentQlReportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemQlReport);
		}
	}

	/**
	 * Returns the number of g e m ql reports where parentQlReportId = &#63;.
	 *
	 * @param parentQlReportId the parent ql report ID
	 * @return the number of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentQlReportId(long parentQlReportId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTQLREPORTID;

		Object[] finderArgs = new Object[] { parentQlReportId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMQLREPORT_WHERE);

			query.append(_FINDER_COLUMN_PARENTQLREPORTID_PARENTQLREPORTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentQlReportId);

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

	private static final String _FINDER_COLUMN_PARENTQLREPORTID_PARENTQLREPORTID_2 =
		"gemQlReport.parentQlReportId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDDUPLICATEPUBLISHID =
		new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBystdIdDuplicatePublishId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDUPLICATEPUBLISHID =
		new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, GEMQlReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBystdIdDuplicatePublishId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			GEMQlReportModelImpl.PUBLISHID_COLUMN_BITMASK |
			GEMQlReportModelImpl.REGIONID_COLUMN_BITMASK |
			GEMQlReportModelImpl.STDID_COLUMN_BITMASK |
			GEMQlReportModelImpl.DUPLICATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDIDDUPLICATEPUBLISHID = new FinderPath(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBystdIdDuplicatePublishId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the g e m ql reports where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @return the matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findBystdIdDuplicatePublishId(long publishId,
		long regionId, long stdId, String duplicate) throws SystemException {
		return findBystdIdDuplicatePublishId(publishId, regionId, stdId,
			duplicate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m ql reports where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @return the range of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findBystdIdDuplicatePublishId(long publishId,
		long regionId, long stdId, String duplicate, int start, int end)
		throws SystemException {
		return findBystdIdDuplicatePublishId(publishId, regionId, stdId,
			duplicate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m ql reports where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findBystdIdDuplicatePublishId(long publishId,
		long regionId, long stdId, String duplicate, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDUPLICATEPUBLISHID;
			finderArgs = new Object[] { publishId, regionId, stdId, duplicate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDIDDUPLICATEPUBLISHID;
			finderArgs = new Object[] {
					publishId, regionId, stdId, duplicate,
					
					start, end, orderByComparator
				};
		}

		List<GEMQlReport> list = (List<GEMQlReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMQlReport gemQlReport : list) {
				if ((publishId != gemQlReport.getPublishId()) ||
						(regionId != gemQlReport.getRegionId()) ||
						(stdId != gemQlReport.getStdId()) ||
						!Validator.equals(duplicate, gemQlReport.getDuplicate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_GEMQLREPORT_WHERE);

			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_REGIONID_2);

			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_STDID_2);

			boolean bindDuplicate = false;

			if (duplicate == null) {
				query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_1);
			}
			else if (duplicate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_3);
			}
			else {
				bindDuplicate = true;

				query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMQlReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(stdId);

				if (bindDuplicate) {
					qPos.add(duplicate);
				}

				if (!pagination) {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMQlReport>(list);
				}
				else {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first g e m ql report in the ordered set where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findBystdIdDuplicatePublishId_First(long publishId,
		long regionId, long stdId, String duplicate,
		OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = fetchBystdIdDuplicatePublishId_First(publishId,
				regionId, stdId, duplicate, orderByComparator);

		if (gemQlReport != null) {
			return gemQlReport;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", duplicate=");
		msg.append(duplicate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMQlReportException(msg.toString());
	}

	/**
	 * Returns the first g e m ql report in the ordered set where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchBystdIdDuplicatePublishId_First(long publishId,
		long regionId, long stdId, String duplicate,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMQlReport> list = findBystdIdDuplicatePublishId(publishId,
				regionId, stdId, duplicate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m ql report in the ordered set where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findBystdIdDuplicatePublishId_Last(long publishId,
		long regionId, long stdId, String duplicate,
		OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = fetchBystdIdDuplicatePublishId_Last(publishId,
				regionId, stdId, duplicate, orderByComparator);

		if (gemQlReport != null) {
			return gemQlReport;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(", duplicate=");
		msg.append(duplicate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMQlReportException(msg.toString());
	}

	/**
	 * Returns the last g e m ql report in the ordered set where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m ql report, or <code>null</code> if a matching g e m ql report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchBystdIdDuplicatePublishId_Last(long publishId,
		long regionId, long stdId, String duplicate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystdIdDuplicatePublishId(publishId, regionId, stdId,
				duplicate);

		if (count == 0) {
			return null;
		}

		List<GEMQlReport> list = findBystdIdDuplicatePublishId(publishId,
				regionId, stdId, duplicate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m ql reports before and after the current g e m ql report in the ordered set where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * @param qlReportId the primary key of the current g e m ql report
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport[] findBystdIdDuplicatePublishId_PrevAndNext(
		long qlReportId, long publishId, long regionId, long stdId,
		String duplicate, OrderByComparator orderByComparator)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = findByPrimaryKey(qlReportId);

		Session session = null;

		try {
			session = openSession();

			GEMQlReport[] array = new GEMQlReportImpl[3];

			array[0] = getBystdIdDuplicatePublishId_PrevAndNext(session,
					gemQlReport, publishId, regionId, stdId, duplicate,
					orderByComparator, true);

			array[1] = gemQlReport;

			array[2] = getBystdIdDuplicatePublishId_PrevAndNext(session,
					gemQlReport, publishId, regionId, stdId, duplicate,
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

	protected GEMQlReport getBystdIdDuplicatePublishId_PrevAndNext(
		Session session, GEMQlReport gemQlReport, long publishId,
		long regionId, long stdId, String duplicate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMQLREPORT_WHERE);

		query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_PUBLISHID_2);

		query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_REGIONID_2);

		query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_STDID_2);

		boolean bindDuplicate = false;

		if (duplicate == null) {
			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_1);
		}
		else if (duplicate.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_3);
		}
		else {
			bindDuplicate = true;

			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_2);
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
			query.append(GEMQlReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		qPos.add(stdId);

		if (bindDuplicate) {
			qPos.add(duplicate);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemQlReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMQlReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m ql reports where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystdIdDuplicatePublishId(long publishId, long regionId,
		long stdId, String duplicate) throws SystemException {
		for (GEMQlReport gemQlReport : findBystdIdDuplicatePublishId(
				publishId, regionId, stdId, duplicate, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(gemQlReport);
		}
	}

	/**
	 * Returns the number of g e m ql reports where publishId = &#63; and regionId = &#63; and stdId = &#63; and duplicate = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param duplicate the duplicate
	 * @return the number of matching g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBystdIdDuplicatePublishId(long publishId, long regionId,
		long stdId, String duplicate) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDIDDUPLICATEPUBLISHID;

		Object[] finderArgs = new Object[] { publishId, regionId, stdId, duplicate };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_GEMQLREPORT_WHERE);

			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_REGIONID_2);

			query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_STDID_2);

			boolean bindDuplicate = false;

			if (duplicate == null) {
				query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_1);
			}
			else if (duplicate.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_3);
			}
			else {
				bindDuplicate = true;

				query.append(_FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(stdId);

				if (bindDuplicate) {
					qPos.add(duplicate);
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

	private static final String _FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_PUBLISHID_2 =
		"gemQlReport.publishId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_REGIONID_2 =
		"gemQlReport.regionId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_STDID_2 = "gemQlReport.stdId = ? AND ";
	private static final String _FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_1 =
		"gemQlReport.duplicate IS NULL";
	private static final String _FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_2 =
		"gemQlReport.duplicate = ?";
	private static final String _FINDER_COLUMN_STDIDDUPLICATEPUBLISHID_DUPLICATE_3 =
		"(gemQlReport.duplicate IS NULL OR gemQlReport.duplicate = '')";

	public GEMQlReportPersistenceImpl() {
		setModelClass(GEMQlReport.class);
	}

	/**
	 * Caches the g e m ql report in the entity cache if it is enabled.
	 *
	 * @param gemQlReport the g e m ql report
	 */
	@Override
	public void cacheResult(GEMQlReport gemQlReport) {
		EntityCacheUtil.putResult(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportImpl.class, gemQlReport.getPrimaryKey(), gemQlReport);

		gemQlReport.resetOriginalValues();
	}

	/**
	 * Caches the g e m ql reports in the entity cache if it is enabled.
	 *
	 * @param gemQlReports the g e m ql reports
	 */
	@Override
	public void cacheResult(List<GEMQlReport> gemQlReports) {
		for (GEMQlReport gemQlReport : gemQlReports) {
			if (EntityCacheUtil.getResult(
						GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
						GEMQlReportImpl.class, gemQlReport.getPrimaryKey()) == null) {
				cacheResult(gemQlReport);
			}
			else {
				gemQlReport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m ql reports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMQlReportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMQlReportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m ql report.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMQlReport gemQlReport) {
		EntityCacheUtil.removeResult(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportImpl.class, gemQlReport.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMQlReport> gemQlReports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMQlReport gemQlReport : gemQlReports) {
			EntityCacheUtil.removeResult(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
				GEMQlReportImpl.class, gemQlReport.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m ql report with the primary key. Does not add the g e m ql report to the database.
	 *
	 * @param qlReportId the primary key for the new g e m ql report
	 * @return the new g e m ql report
	 */
	@Override
	public GEMQlReport create(long qlReportId) {
		GEMQlReport gemQlReport = new GEMQlReportImpl();

		gemQlReport.setNew(true);
		gemQlReport.setPrimaryKey(qlReportId);

		return gemQlReport;
	}

	/**
	 * Removes the g e m ql report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param qlReportId the primary key of the g e m ql report
	 * @return the g e m ql report that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport remove(long qlReportId)
		throws NoSuchGEMQlReportException, SystemException {
		return remove((Serializable)qlReportId);
	}

	/**
	 * Removes the g e m ql report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m ql report
	 * @return the g e m ql report that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport remove(Serializable primaryKey)
		throws NoSuchGEMQlReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMQlReport gemQlReport = (GEMQlReport)session.get(GEMQlReportImpl.class,
					primaryKey);

			if (gemQlReport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMQlReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemQlReport);
		}
		catch (NoSuchGEMQlReportException nsee) {
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
	protected GEMQlReport removeImpl(GEMQlReport gemQlReport)
		throws SystemException {
		gemQlReport = toUnwrappedModel(gemQlReport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemQlReport)) {
				gemQlReport = (GEMQlReport)session.get(GEMQlReportImpl.class,
						gemQlReport.getPrimaryKeyObj());
			}

			if (gemQlReport != null) {
				session.delete(gemQlReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemQlReport != null) {
			clearCache(gemQlReport);
		}

		return gemQlReport;
	}

	@Override
	public GEMQlReport updateImpl(
		com.ihg.brandstandards.db.model.GEMQlReport gemQlReport)
		throws SystemException {
		gemQlReport = toUnwrappedModel(gemQlReport);

		boolean isNew = gemQlReport.isNew();

		GEMQlReportModelImpl gemQlReportModelImpl = (GEMQlReportModelImpl)gemQlReport;

		Session session = null;

		try {
			session = openSession();

			if (gemQlReport.isNew()) {
				session.save(gemQlReport);

				gemQlReport.setNew(false);
			}
			else {
				session.merge(gemQlReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMQlReportModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemQlReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemQlReportModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDREGIONID,
					args);

				args = new Object[] { gemQlReportModelImpl.getPublishId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDREGIONID,
					args);
			}

			if ((gemQlReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTQLREPORTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemQlReportModelImpl.getOriginalParentQlReportId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTQLREPORTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTQLREPORTID,
					args);

				args = new Object[] { gemQlReportModelImpl.getParentQlReportId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTQLREPORTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTQLREPORTID,
					args);
			}

			if ((gemQlReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDUPLICATEPUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemQlReportModelImpl.getOriginalPublishId(),
						gemQlReportModelImpl.getOriginalRegionId(),
						gemQlReportModelImpl.getOriginalStdId(),
						gemQlReportModelImpl.getOriginalDuplicate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDDUPLICATEPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDUPLICATEPUBLISHID,
					args);

				args = new Object[] {
						gemQlReportModelImpl.getPublishId(),
						gemQlReportModelImpl.getRegionId(),
						gemQlReportModelImpl.getStdId(),
						gemQlReportModelImpl.getDuplicate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDIDDUPLICATEPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDIDDUPLICATEPUBLISHID,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMQlReportImpl.class, gemQlReport.getPrimaryKey(), gemQlReport);

		return gemQlReport;
	}

	protected GEMQlReport toUnwrappedModel(GEMQlReport gemQlReport) {
		if (gemQlReport instanceof GEMQlReportImpl) {
			return gemQlReport;
		}

		GEMQlReportImpl gemQlReportImpl = new GEMQlReportImpl();

		gemQlReportImpl.setNew(gemQlReport.isNew());
		gemQlReportImpl.setPrimaryKey(gemQlReport.getPrimaryKey());

		gemQlReportImpl.setQlReportId(gemQlReport.getQlReportId());
		gemQlReportImpl.setPublishDeptId(gemQlReport.getPublishDeptId());
		gemQlReportImpl.setPublishId(gemQlReport.getPublishId());
		gemQlReportImpl.setStdId(gemQlReport.getStdId());
		gemQlReportImpl.setBucketId(gemQlReport.getBucketId());
		gemQlReportImpl.setSeverityId(gemQlReport.getSeverityId());
		gemQlReportImpl.setMeasurementId(gemQlReport.getMeasurementId());
		gemQlReportImpl.setTriggerId(gemQlReport.getTriggerId());
		gemQlReportImpl.setCategoryId(gemQlReport.getCategoryId());
		gemQlReportImpl.setDisplayOrderNumber(gemQlReport.getDisplayOrderNumber());
		gemQlReportImpl.setRegionId(gemQlReport.getRegionId());
		gemQlReportImpl.setComplianceDueDays(gemQlReport.getComplianceDueDays());
		gemQlReportImpl.setGlblMustMeasure(gemQlReport.getGlblMustMeasure());
		gemQlReportImpl.setParentQlReportId(gemQlReport.getParentQlReportId());
		gemQlReportImpl.setDuplicate(gemQlReport.getDuplicate());
		gemQlReportImpl.setCreatorId(gemQlReport.getCreatorId());
		gemQlReportImpl.setCreatedDate(gemQlReport.getCreatedDate());
		gemQlReportImpl.setUpdatedBy(gemQlReport.getUpdatedBy());
		gemQlReportImpl.setUpdatedDate(gemQlReport.getUpdatedDate());

		return gemQlReportImpl;
	}

	/**
	 * Returns the g e m ql report with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m ql report
	 * @return the g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMQlReportException, SystemException {
		GEMQlReport gemQlReport = fetchByPrimaryKey(primaryKey);

		if (gemQlReport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMQlReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemQlReport;
	}

	/**
	 * Returns the g e m ql report with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMQlReportException} if it could not be found.
	 *
	 * @param qlReportId the primary key of the g e m ql report
	 * @return the g e m ql report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMQlReportException if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport findByPrimaryKey(long qlReportId)
		throws NoSuchGEMQlReportException, SystemException {
		return findByPrimaryKey((Serializable)qlReportId);
	}

	/**
	 * Returns the g e m ql report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m ql report
	 * @return the g e m ql report, or <code>null</code> if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMQlReport gemQlReport = (GEMQlReport)EntityCacheUtil.getResult(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
				GEMQlReportImpl.class, primaryKey);

		if (gemQlReport == _nullGEMQlReport) {
			return null;
		}

		if (gemQlReport == null) {
			Session session = null;

			try {
				session = openSession();

				gemQlReport = (GEMQlReport)session.get(GEMQlReportImpl.class,
						primaryKey);

				if (gemQlReport != null) {
					cacheResult(gemQlReport);
				}
				else {
					EntityCacheUtil.putResult(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
						GEMQlReportImpl.class, primaryKey, _nullGEMQlReport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMQlReportModelImpl.ENTITY_CACHE_ENABLED,
					GEMQlReportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemQlReport;
	}

	/**
	 * Returns the g e m ql report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param qlReportId the primary key of the g e m ql report
	 * @return the g e m ql report, or <code>null</code> if a g e m ql report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMQlReport fetchByPrimaryKey(long qlReportId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)qlReportId);
	}

	/**
	 * Returns all the g e m ql reports.
	 *
	 * @return the g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m ql reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @return the range of g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m ql reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMQlReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m ql reports
	 * @param end the upper bound of the range of g e m ql reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m ql reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMQlReport> findAll(int start, int end,
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

		List<GEMQlReport> list = (List<GEMQlReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMQLREPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMQLREPORT;

				if (pagination) {
					sql = sql.concat(GEMQlReportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMQlReport>(list);
				}
				else {
					list = (List<GEMQlReport>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g e m ql reports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMQlReport gemQlReport : findAll()) {
			remove(gemQlReport);
		}
	}

	/**
	 * Returns the number of g e m ql reports.
	 *
	 * @return the number of g e m ql reports
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

				Query q = session.createQuery(_SQL_COUNT_GEMQLREPORT);

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
	 * Initializes the g e m ql report persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMQlReport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMQlReport>> listenersList = new ArrayList<ModelListener<GEMQlReport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMQlReport>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMQlReportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMQLREPORT = "SELECT gemQlReport FROM GEMQlReport gemQlReport";
	private static final String _SQL_SELECT_GEMQLREPORT_WHERE = "SELECT gemQlReport FROM GEMQlReport gemQlReport WHERE ";
	private static final String _SQL_COUNT_GEMQLREPORT = "SELECT COUNT(gemQlReport) FROM GEMQlReport gemQlReport";
	private static final String _SQL_COUNT_GEMQLREPORT_WHERE = "SELECT COUNT(gemQlReport) FROM GEMQlReport gemQlReport WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemQlReport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMQlReport exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMQlReport exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMQlReportPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"qlReportId", "publishDeptId", "publishId", "stdId", "bucketId",
				"severityId", "measurementId", "triggerId", "categoryId",
				"displayOrderNumber", "regionId", "complianceDueDays",
				"glblMustMeasure", "parentQlReportId", "duplicate", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMQlReport _nullGEMQlReport = new GEMQlReportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMQlReport> toCacheModel() {
				return _nullGEMQlReportCacheModel;
			}
		};

	private static CacheModel<GEMQlReport> _nullGEMQlReportCacheModel = new CacheModel<GEMQlReport>() {
			@Override
			public GEMQlReport toEntityModel() {
				return _nullGEMQlReport;
			}
		};
}