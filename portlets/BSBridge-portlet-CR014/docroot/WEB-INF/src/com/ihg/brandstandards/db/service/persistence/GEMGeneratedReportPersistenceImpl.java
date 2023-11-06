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

import com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException;
import com.ihg.brandstandards.db.model.GEMGeneratedReport;
import com.ihg.brandstandards.db.model.impl.GEMGeneratedReportImpl;
import com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl;

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
 * The persistence implementation for the g e m generated report service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMGeneratedReportPersistence
 * @see GEMGeneratedReportUtil
 * @generated
 */
public class GEMGeneratedReportPersistenceImpl extends BasePersistenceImpl<GEMGeneratedReport>
	implements GEMGeneratedReportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMGeneratedReportUtil} to access the g e m generated report persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMGeneratedReportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTemplateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportModelImpl.FINDER_CACHE_ENABLED,
			GEMGeneratedReportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
			new String[] { Long.class.getName() },
			GEMGeneratedReportModelImpl.TEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m generated reports where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the matching g e m generated reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReport> findByTemplateId(long templateId)
		throws SystemException {
		return findByTemplateId(templateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m generated reports where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of g e m generated reports
	 * @param end the upper bound of the range of g e m generated reports (not inclusive)
	 * @return the range of matching g e m generated reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReport> findByTemplateId(long templateId,
		int start, int end) throws SystemException {
		return findByTemplateId(templateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m generated reports where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of g e m generated reports
	 * @param end the upper bound of the range of g e m generated reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m generated reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReport> findByTemplateId(long templateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID;
			finderArgs = new Object[] { templateId, start, end, orderByComparator };
		}

		List<GEMGeneratedReport> list = (List<GEMGeneratedReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMGeneratedReport gemGeneratedReport : list) {
				if ((templateId != gemGeneratedReport.getTemplateId())) {
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

			query.append(_SQL_SELECT_GEMGENERATEDREPORT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMGeneratedReportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				if (!pagination) {
					list = (List<GEMGeneratedReport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMGeneratedReport>(list);
				}
				else {
					list = (List<GEMGeneratedReport>)QueryUtil.list(q,
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
	 * Returns the first g e m generated report in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m generated report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a matching g e m generated report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport findByTemplateId_First(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMGeneratedReportException, SystemException {
		GEMGeneratedReport gemGeneratedReport = fetchByTemplateId_First(templateId,
				orderByComparator);

		if (gemGeneratedReport != null) {
			return gemGeneratedReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMGeneratedReportException(msg.toString());
	}

	/**
	 * Returns the first g e m generated report in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m generated report, or <code>null</code> if a matching g e m generated report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport fetchByTemplateId_First(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMGeneratedReport> list = findByTemplateId(templateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m generated report in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m generated report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a matching g e m generated report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport findByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMGeneratedReportException, SystemException {
		GEMGeneratedReport gemGeneratedReport = fetchByTemplateId_Last(templateId,
				orderByComparator);

		if (gemGeneratedReport != null) {
			return gemGeneratedReport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMGeneratedReportException(msg.toString());
	}

	/**
	 * Returns the last g e m generated report in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m generated report, or <code>null</code> if a matching g e m generated report could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport fetchByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateId(templateId);

		if (count == 0) {
			return null;
		}

		List<GEMGeneratedReport> list = findByTemplateId(templateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m generated reports before and after the current g e m generated report in the ordered set where templateId = &#63;.
	 *
	 * @param reportId the primary key of the current g e m generated report
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m generated report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport[] findByTemplateId_PrevAndNext(long reportId,
		long templateId, OrderByComparator orderByComparator)
		throws NoSuchGEMGeneratedReportException, SystemException {
		GEMGeneratedReport gemGeneratedReport = findByPrimaryKey(reportId);

		Session session = null;

		try {
			session = openSession();

			GEMGeneratedReport[] array = new GEMGeneratedReportImpl[3];

			array[0] = getByTemplateId_PrevAndNext(session, gemGeneratedReport,
					templateId, orderByComparator, true);

			array[1] = gemGeneratedReport;

			array[2] = getByTemplateId_PrevAndNext(session, gemGeneratedReport,
					templateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GEMGeneratedReport getByTemplateId_PrevAndNext(Session session,
		GEMGeneratedReport gemGeneratedReport, long templateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMGENERATEDREPORT_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

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
			query.append(GEMGeneratedReportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemGeneratedReport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMGeneratedReport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m generated reports where templateId = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateId(long templateId) throws SystemException {
		for (GEMGeneratedReport gemGeneratedReport : findByTemplateId(
				templateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemGeneratedReport);
		}
	}

	/**
	 * Returns the number of g e m generated reports where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the number of matching g e m generated reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateId(long templateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEID;

		Object[] finderArgs = new Object[] { templateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEMGENERATEDREPORT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

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

	private static final String _FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2 = "gemGeneratedReport.templateId = ?";

	public GEMGeneratedReportPersistenceImpl() {
		setModelClass(GEMGeneratedReport.class);
	}

	/**
	 * Caches the g e m generated report in the entity cache if it is enabled.
	 *
	 * @param gemGeneratedReport the g e m generated report
	 */
	@Override
	public void cacheResult(GEMGeneratedReport gemGeneratedReport) {
		EntityCacheUtil.putResult(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportImpl.class, gemGeneratedReport.getPrimaryKey(),
			gemGeneratedReport);

		gemGeneratedReport.resetOriginalValues();
	}

	/**
	 * Caches the g e m generated reports in the entity cache if it is enabled.
	 *
	 * @param gemGeneratedReports the g e m generated reports
	 */
	@Override
	public void cacheResult(List<GEMGeneratedReport> gemGeneratedReports) {
		for (GEMGeneratedReport gemGeneratedReport : gemGeneratedReports) {
			if (EntityCacheUtil.getResult(
						GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
						GEMGeneratedReportImpl.class,
						gemGeneratedReport.getPrimaryKey()) == null) {
				cacheResult(gemGeneratedReport);
			}
			else {
				gemGeneratedReport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m generated reports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMGeneratedReportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMGeneratedReportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m generated report.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMGeneratedReport gemGeneratedReport) {
		EntityCacheUtil.removeResult(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportImpl.class, gemGeneratedReport.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMGeneratedReport> gemGeneratedReports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMGeneratedReport gemGeneratedReport : gemGeneratedReports) {
			EntityCacheUtil.removeResult(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
				GEMGeneratedReportImpl.class, gemGeneratedReport.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m generated report with the primary key. Does not add the g e m generated report to the database.
	 *
	 * @param reportId the primary key for the new g e m generated report
	 * @return the new g e m generated report
	 */
	@Override
	public GEMGeneratedReport create(long reportId) {
		GEMGeneratedReport gemGeneratedReport = new GEMGeneratedReportImpl();

		gemGeneratedReport.setNew(true);
		gemGeneratedReport.setPrimaryKey(reportId);

		return gemGeneratedReport;
	}

	/**
	 * Removes the g e m generated report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reportId the primary key of the g e m generated report
	 * @return the g e m generated report that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport remove(long reportId)
		throws NoSuchGEMGeneratedReportException, SystemException {
		return remove((Serializable)reportId);
	}

	/**
	 * Removes the g e m generated report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m generated report
	 * @return the g e m generated report that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport remove(Serializable primaryKey)
		throws NoSuchGEMGeneratedReportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMGeneratedReport gemGeneratedReport = (GEMGeneratedReport)session.get(GEMGeneratedReportImpl.class,
					primaryKey);

			if (gemGeneratedReport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMGeneratedReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemGeneratedReport);
		}
		catch (NoSuchGEMGeneratedReportException nsee) {
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
	protected GEMGeneratedReport removeImpl(
		GEMGeneratedReport gemGeneratedReport) throws SystemException {
		gemGeneratedReport = toUnwrappedModel(gemGeneratedReport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemGeneratedReport)) {
				gemGeneratedReport = (GEMGeneratedReport)session.get(GEMGeneratedReportImpl.class,
						gemGeneratedReport.getPrimaryKeyObj());
			}

			if (gemGeneratedReport != null) {
				session.delete(gemGeneratedReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemGeneratedReport != null) {
			clearCache(gemGeneratedReport);
		}

		return gemGeneratedReport;
	}

	@Override
	public GEMGeneratedReport updateImpl(
		com.ihg.brandstandards.db.model.GEMGeneratedReport gemGeneratedReport)
		throws SystemException {
		gemGeneratedReport = toUnwrappedModel(gemGeneratedReport);

		boolean isNew = gemGeneratedReport.isNew();

		GEMGeneratedReportModelImpl gemGeneratedReportModelImpl = (GEMGeneratedReportModelImpl)gemGeneratedReport;

		Session session = null;

		try {
			session = openSession();

			if (gemGeneratedReport.isNew()) {
				session.save(gemGeneratedReport);

				gemGeneratedReport.setNew(false);
			}
			else {
				session.merge(gemGeneratedReport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMGeneratedReportModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemGeneratedReportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemGeneratedReportModelImpl.getOriginalTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);

				args = new Object[] { gemGeneratedReportModelImpl.getTemplateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
			GEMGeneratedReportImpl.class, gemGeneratedReport.getPrimaryKey(),
			gemGeneratedReport);

		return gemGeneratedReport;
	}

	protected GEMGeneratedReport toUnwrappedModel(
		GEMGeneratedReport gemGeneratedReport) {
		if (gemGeneratedReport instanceof GEMGeneratedReportImpl) {
			return gemGeneratedReport;
		}

		GEMGeneratedReportImpl gemGeneratedReportImpl = new GEMGeneratedReportImpl();

		gemGeneratedReportImpl.setNew(gemGeneratedReport.isNew());
		gemGeneratedReportImpl.setPrimaryKey(gemGeneratedReport.getPrimaryKey());

		gemGeneratedReportImpl.setReportId(gemGeneratedReport.getReportId());
		gemGeneratedReportImpl.setTemplateId(gemGeneratedReport.getTemplateId());
		gemGeneratedReportImpl.setUniqueGroupId(gemGeneratedReport.getUniqueGroupId());
		gemGeneratedReportImpl.setCreatorId(gemGeneratedReport.getCreatorId());
		gemGeneratedReportImpl.setCreatedDate(gemGeneratedReport.getCreatedDate());
		gemGeneratedReportImpl.setUpdatedBy(gemGeneratedReport.getUpdatedBy());
		gemGeneratedReportImpl.setUpdatedDate(gemGeneratedReport.getUpdatedDate());

		return gemGeneratedReportImpl;
	}

	/**
	 * Returns the g e m generated report with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m generated report
	 * @return the g e m generated report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMGeneratedReportException, SystemException {
		GEMGeneratedReport gemGeneratedReport = fetchByPrimaryKey(primaryKey);

		if (gemGeneratedReport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMGeneratedReportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemGeneratedReport;
	}

	/**
	 * Returns the g e m generated report with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException} if it could not be found.
	 *
	 * @param reportId the primary key of the g e m generated report
	 * @return the g e m generated report
	 * @throws com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException if a g e m generated report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport findByPrimaryKey(long reportId)
		throws NoSuchGEMGeneratedReportException, SystemException {
		return findByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns the g e m generated report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m generated report
	 * @return the g e m generated report, or <code>null</code> if a g e m generated report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMGeneratedReport gemGeneratedReport = (GEMGeneratedReport)EntityCacheUtil.getResult(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
				GEMGeneratedReportImpl.class, primaryKey);

		if (gemGeneratedReport == _nullGEMGeneratedReport) {
			return null;
		}

		if (gemGeneratedReport == null) {
			Session session = null;

			try {
				session = openSession();

				gemGeneratedReport = (GEMGeneratedReport)session.get(GEMGeneratedReportImpl.class,
						primaryKey);

				if (gemGeneratedReport != null) {
					cacheResult(gemGeneratedReport);
				}
				else {
					EntityCacheUtil.putResult(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
						GEMGeneratedReportImpl.class, primaryKey,
						_nullGEMGeneratedReport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMGeneratedReportModelImpl.ENTITY_CACHE_ENABLED,
					GEMGeneratedReportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemGeneratedReport;
	}

	/**
	 * Returns the g e m generated report with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reportId the primary key of the g e m generated report
	 * @return the g e m generated report, or <code>null</code> if a g e m generated report with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMGeneratedReport fetchByPrimaryKey(long reportId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)reportId);
	}

	/**
	 * Returns all the g e m generated reports.
	 *
	 * @return the g e m generated reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m generated reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m generated reports
	 * @param end the upper bound of the range of g e m generated reports (not inclusive)
	 * @return the range of g e m generated reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m generated reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMGeneratedReportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m generated reports
	 * @param end the upper bound of the range of g e m generated reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m generated reports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMGeneratedReport> findAll(int start, int end,
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

		List<GEMGeneratedReport> list = (List<GEMGeneratedReport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMGENERATEDREPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMGENERATEDREPORT;

				if (pagination) {
					sql = sql.concat(GEMGeneratedReportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMGeneratedReport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMGeneratedReport>(list);
				}
				else {
					list = (List<GEMGeneratedReport>)QueryUtil.list(q,
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
	 * Removes all the g e m generated reports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMGeneratedReport gemGeneratedReport : findAll()) {
			remove(gemGeneratedReport);
		}
	}

	/**
	 * Returns the number of g e m generated reports.
	 *
	 * @return the number of g e m generated reports
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

				Query q = session.createQuery(_SQL_COUNT_GEMGENERATEDREPORT);

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
	 * Initializes the g e m generated report persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMGeneratedReport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMGeneratedReport>> listenersList = new ArrayList<ModelListener<GEMGeneratedReport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMGeneratedReport>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMGeneratedReportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMGENERATEDREPORT = "SELECT gemGeneratedReport FROM GEMGeneratedReport gemGeneratedReport";
	private static final String _SQL_SELECT_GEMGENERATEDREPORT_WHERE = "SELECT gemGeneratedReport FROM GEMGeneratedReport gemGeneratedReport WHERE ";
	private static final String _SQL_COUNT_GEMGENERATEDREPORT = "SELECT COUNT(gemGeneratedReport) FROM GEMGeneratedReport gemGeneratedReport";
	private static final String _SQL_COUNT_GEMGENERATEDREPORT_WHERE = "SELECT COUNT(gemGeneratedReport) FROM GEMGeneratedReport gemGeneratedReport WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemGeneratedReport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMGeneratedReport exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMGeneratedReport exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMGeneratedReportPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"reportId", "templateId", "uniqueGroupId", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMGeneratedReport _nullGEMGeneratedReport = new GEMGeneratedReportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMGeneratedReport> toCacheModel() {
				return _nullGEMGeneratedReportCacheModel;
			}
		};

	private static CacheModel<GEMGeneratedReport> _nullGEMGeneratedReportCacheModel =
		new CacheModel<GEMGeneratedReport>() {
			@Override
			public GEMGeneratedReport toEntityModel() {
				return _nullGEMGeneratedReport;
			}
		};
}