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

import com.ihg.brandstandards.db.NoSuchGEMMeasurementException;
import com.ihg.brandstandards.db.model.GEMMeasurement;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementImpl;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl;

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
 * The persistence implementation for the g e m measurement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementPersistence
 * @see GEMMeasurementUtil
 * @generated
 */
public class GEMMeasurementPersistenceImpl extends BasePersistenceImpl<GEMMeasurement>
	implements GEMMeasurementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMMeasurementUtil} to access the g e m measurement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMMeasurementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTemplateId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID =
		new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTemplateId",
			new String[] { Long.class.getName() },
			GEMMeasurementModelImpl.TEMPLATEID_COLUMN_BITMASK |
			GEMMeasurementModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEID = new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTemplateId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the g e m measurements where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findByTemplateId(long templateId)
		throws SystemException {
		return findByTemplateId(templateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m measurements where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of g e m measurements
	 * @param end the upper bound of the range of g e m measurements (not inclusive)
	 * @return the range of matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findByTemplateId(long templateId, int start,
		int end) throws SystemException {
		return findByTemplateId(templateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m measurements where templateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param start the lower bound of the range of g e m measurements
	 * @param end the upper bound of the range of g e m measurements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findByTemplateId(long templateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<GEMMeasurement> list = (List<GEMMeasurement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMMeasurement gemMeasurement : list) {
				if ((templateId != gemMeasurement.getTemplateId())) {
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

			query.append(_SQL_SELECT_GEMMEASUREMENT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMMeasurementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				if (!pagination) {
					list = (List<GEMMeasurement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMMeasurement>(list);
				}
				else {
					list = (List<GEMMeasurement>)QueryUtil.list(q,
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
	 * Returns the first g e m measurement in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement findByTemplateId_First(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = fetchByTemplateId_First(templateId,
				orderByComparator);

		if (gemMeasurement != null) {
			return gemMeasurement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMMeasurementException(msg.toString());
	}

	/**
	 * Returns the first g e m measurement in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByTemplateId_First(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMMeasurement> list = findByTemplateId(templateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m measurement in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement findByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = fetchByTemplateId_Last(templateId,
				orderByComparator);

		if (gemMeasurement != null) {
			return gemMeasurement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMMeasurementException(msg.toString());
	}

	/**
	 * Returns the last g e m measurement in the ordered set where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByTemplateId_Last(long templateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTemplateId(templateId);

		if (count == 0) {
			return null;
		}

		List<GEMMeasurement> list = findByTemplateId(templateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m measurements before and after the current g e m measurement in the ordered set where templateId = &#63;.
	 *
	 * @param measurementId the primary key of the current g e m measurement
	 * @param templateId the template ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement[] findByTemplateId_PrevAndNext(long measurementId,
		long templateId, OrderByComparator orderByComparator)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = findByPrimaryKey(measurementId);

		Session session = null;

		try {
			session = openSession();

			GEMMeasurement[] array = new GEMMeasurementImpl[3];

			array[0] = getByTemplateId_PrevAndNext(session, gemMeasurement,
					templateId, orderByComparator, true);

			array[1] = gemMeasurement;

			array[2] = getByTemplateId_PrevAndNext(session, gemMeasurement,
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

	protected GEMMeasurement getByTemplateId_PrevAndNext(Session session,
		GEMMeasurement gemMeasurement, long templateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMMEASUREMENT_WHERE);

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
			query.append(GEMMeasurementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemMeasurement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMMeasurement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m measurements where templateId = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateId(long templateId) throws SystemException {
		for (GEMMeasurement gemMeasurement : findByTemplateId(templateId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemMeasurement);
		}
	}

	/**
	 * Returns the number of g e m measurements where templateId = &#63;.
	 *
	 * @param templateId the template ID
	 * @return the number of matching g e m measurements
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

			query.append(_SQL_COUNT_GEMMEASUREMENT_WHERE);

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

	private static final String _FINDER_COLUMN_TEMPLATEID_TEMPLATEID_2 = "gemMeasurement.templateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEIDANDTYPE =
		new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTemplateIdAndType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDANDTYPE =
		new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTemplateIdAndType",
			new String[] { Long.class.getName(), String.class.getName() },
			GEMMeasurementModelImpl.TEMPLATEID_COLUMN_BITMASK |
			GEMMeasurementModelImpl.MEASUREMENTTYPE_COLUMN_BITMASK |
			GEMMeasurementModelImpl.DISPLAYORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TEMPLATEIDANDTYPE = new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTemplateIdAndType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the g e m measurements where templateId = &#63; and measurementType = &#63;.
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @return the matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findByTemplateIdAndType(long templateId,
		String measurementType) throws SystemException {
		return findByTemplateIdAndType(templateId, measurementType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m measurements where templateId = &#63; and measurementType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @param start the lower bound of the range of g e m measurements
	 * @param end the upper bound of the range of g e m measurements (not inclusive)
	 * @return the range of matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findByTemplateIdAndType(long templateId,
		String measurementType, int start, int end) throws SystemException {
		return findByTemplateIdAndType(templateId, measurementType, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the g e m measurements where templateId = &#63; and measurementType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @param start the lower bound of the range of g e m measurements
	 * @param end the upper bound of the range of g e m measurements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findByTemplateIdAndType(long templateId,
		String measurementType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDANDTYPE;
			finderArgs = new Object[] { templateId, measurementType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TEMPLATEIDANDTYPE;
			finderArgs = new Object[] {
					templateId, measurementType,
					
					start, end, orderByComparator
				};
		}

		List<GEMMeasurement> list = (List<GEMMeasurement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMMeasurement gemMeasurement : list) {
				if ((templateId != gemMeasurement.getTemplateId()) ||
						!Validator.equals(measurementType,
							gemMeasurement.getMeasurementType())) {
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

			query.append(_SQL_SELECT_GEMMEASUREMENT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_TEMPLATEID_2);

			boolean bindMeasurementType = false;

			if (measurementType == null) {
				query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_1);
			}
			else if (measurementType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_3);
			}
			else {
				bindMeasurementType = true;

				query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMMeasurementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				if (bindMeasurementType) {
					qPos.add(measurementType);
				}

				if (!pagination) {
					list = (List<GEMMeasurement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMMeasurement>(list);
				}
				else {
					list = (List<GEMMeasurement>)QueryUtil.list(q,
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
	 * Returns the first g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement findByTemplateIdAndType_First(long templateId,
		String measurementType, OrderByComparator orderByComparator)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = fetchByTemplateIdAndType_First(templateId,
				measurementType, orderByComparator);

		if (gemMeasurement != null) {
			return gemMeasurement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(", measurementType=");
		msg.append(measurementType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMMeasurementException(msg.toString());
	}

	/**
	 * Returns the first g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByTemplateIdAndType_First(long templateId,
		String measurementType, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMMeasurement> list = findByTemplateIdAndType(templateId,
				measurementType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement findByTemplateIdAndType_Last(long templateId,
		String measurementType, OrderByComparator orderByComparator)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = fetchByTemplateIdAndType_Last(templateId,
				measurementType, orderByComparator);

		if (gemMeasurement != null) {
			return gemMeasurement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("templateId=");
		msg.append(templateId);

		msg.append(", measurementType=");
		msg.append(measurementType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMMeasurementException(msg.toString());
	}

	/**
	 * Returns the last g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByTemplateIdAndType_Last(long templateId,
		String measurementType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByTemplateIdAndType(templateId, measurementType);

		if (count == 0) {
			return null;
		}

		List<GEMMeasurement> list = findByTemplateIdAndType(templateId,
				measurementType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m measurements before and after the current g e m measurement in the ordered set where templateId = &#63; and measurementType = &#63;.
	 *
	 * @param measurementId the primary key of the current g e m measurement
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement[] findByTemplateIdAndType_PrevAndNext(
		long measurementId, long templateId, String measurementType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = findByPrimaryKey(measurementId);

		Session session = null;

		try {
			session = openSession();

			GEMMeasurement[] array = new GEMMeasurementImpl[3];

			array[0] = getByTemplateIdAndType_PrevAndNext(session,
					gemMeasurement, templateId, measurementType,
					orderByComparator, true);

			array[1] = gemMeasurement;

			array[2] = getByTemplateIdAndType_PrevAndNext(session,
					gemMeasurement, templateId, measurementType,
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

	protected GEMMeasurement getByTemplateIdAndType_PrevAndNext(
		Session session, GEMMeasurement gemMeasurement, long templateId,
		String measurementType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMMEASUREMENT_WHERE);

		query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_TEMPLATEID_2);

		boolean bindMeasurementType = false;

		if (measurementType == null) {
			query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_1);
		}
		else if (measurementType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_3);
		}
		else {
			bindMeasurementType = true;

			query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_2);
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
			query.append(GEMMeasurementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(templateId);

		if (bindMeasurementType) {
			qPos.add(measurementType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemMeasurement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMMeasurement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m measurements where templateId = &#63; and measurementType = &#63; from the database.
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTemplateIdAndType(long templateId,
		String measurementType) throws SystemException {
		for (GEMMeasurement gemMeasurement : findByTemplateIdAndType(
				templateId, measurementType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(gemMeasurement);
		}
	}

	/**
	 * Returns the number of g e m measurements where templateId = &#63; and measurementType = &#63;.
	 *
	 * @param templateId the template ID
	 * @param measurementType the measurement type
	 * @return the number of matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTemplateIdAndType(long templateId, String measurementType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TEMPLATEIDANDTYPE;

		Object[] finderArgs = new Object[] { templateId, measurementType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEMMEASUREMENT_WHERE);

			query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_TEMPLATEID_2);

			boolean bindMeasurementType = false;

			if (measurementType == null) {
				query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_1);
			}
			else if (measurementType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_3);
			}
			else {
				bindMeasurementType = true;

				query.append(_FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(templateId);

				if (bindMeasurementType) {
					qPos.add(measurementType);
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

	private static final String _FINDER_COLUMN_TEMPLATEIDANDTYPE_TEMPLATEID_2 = "gemMeasurement.templateId = ? AND ";
	private static final String _FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_1 =
		"gemMeasurement.measurementType IS NULL";
	private static final String _FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_2 =
		"gemMeasurement.measurementType = ?";
	private static final String _FINDER_COLUMN_TEMPLATEIDANDTYPE_MEASUREMENTTYPE_3 =
		"(gemMeasurement.measurementType IS NULL OR gemMeasurement.measurementType = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID = new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNameTypeAndTemplateId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			GEMMeasurementModelImpl.MEASUREMENTNAME_COLUMN_BITMASK |
			GEMMeasurementModelImpl.MEASUREMENTTYPE_COLUMN_BITMASK |
			GEMMeasurementModelImpl.TEMPLATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMETYPEANDTEMPLATEID = new FinderPath(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNameTypeAndTemplateId",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementException} if it could not be found.
	 *
	 * @param measurementName the measurement name
	 * @param measurementType the measurement type
	 * @param templateId the template ID
	 * @return the matching g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement findByNameTypeAndTemplateId(String measurementName,
		String measurementType, long templateId)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = fetchByNameTypeAndTemplateId(measurementName,
				measurementType, templateId);

		if (gemMeasurement == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("measurementName=");
			msg.append(measurementName);

			msg.append(", measurementType=");
			msg.append(measurementType);

			msg.append(", templateId=");
			msg.append(templateId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGEMMeasurementException(msg.toString());
		}

		return gemMeasurement;
	}

	/**
	 * Returns the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param measurementName the measurement name
	 * @param measurementType the measurement type
	 * @param templateId the template ID
	 * @return the matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByNameTypeAndTemplateId(String measurementName,
		String measurementType, long templateId) throws SystemException {
		return fetchByNameTypeAndTemplateId(measurementName, measurementType,
			templateId, true);
	}

	/**
	 * Returns the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param measurementName the measurement name
	 * @param measurementType the measurement type
	 * @param templateId the template ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching g e m measurement, or <code>null</code> if a matching g e m measurement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByNameTypeAndTemplateId(String measurementName,
		String measurementType, long templateId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				measurementName, measurementType, templateId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
					finderArgs, this);
		}

		if (result instanceof GEMMeasurement) {
			GEMMeasurement gemMeasurement = (GEMMeasurement)result;

			if (!Validator.equals(measurementName,
						gemMeasurement.getMeasurementName()) ||
					!Validator.equals(measurementType,
						gemMeasurement.getMeasurementType()) ||
					(templateId != gemMeasurement.getTemplateId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_GEMMEASUREMENT_WHERE);

			boolean bindMeasurementName = false;

			if (measurementName == null) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_1);
			}
			else if (measurementName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_3);
			}
			else {
				bindMeasurementName = true;

				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_2);
			}

			boolean bindMeasurementType = false;

			if (measurementType == null) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_1);
			}
			else if (measurementType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_3);
			}
			else {
				bindMeasurementType = true;

				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_2);
			}

			query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_TEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMeasurementName) {
					qPos.add(measurementName);
				}

				if (bindMeasurementType) {
					qPos.add(measurementType);
				}

				qPos.add(templateId);

				List<GEMMeasurement> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GEMMeasurementPersistenceImpl.fetchByNameTypeAndTemplateId(String, String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GEMMeasurement gemMeasurement = list.get(0);

					result = gemMeasurement;

					cacheResult(gemMeasurement);

					if ((gemMeasurement.getMeasurementName() == null) ||
							!gemMeasurement.getMeasurementName()
											   .equals(measurementName) ||
							(gemMeasurement.getMeasurementType() == null) ||
							!gemMeasurement.getMeasurementType()
											   .equals(measurementType) ||
							(gemMeasurement.getTemplateId() != templateId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
							finderArgs, gemMeasurement);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
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
			return (GEMMeasurement)result;
		}
	}

	/**
	 * Removes the g e m measurement where measurementName = &#63; and measurementType = &#63; and templateId = &#63; from the database.
	 *
	 * @param measurementName the measurement name
	 * @param measurementType the measurement type
	 * @param templateId the template ID
	 * @return the g e m measurement that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement removeByNameTypeAndTemplateId(
		String measurementName, String measurementType, long templateId)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = findByNameTypeAndTemplateId(measurementName,
				measurementType, templateId);

		return remove(gemMeasurement);
	}

	/**
	 * Returns the number of g e m measurements where measurementName = &#63; and measurementType = &#63; and templateId = &#63;.
	 *
	 * @param measurementName the measurement name
	 * @param measurementType the measurement type
	 * @param templateId the template ID
	 * @return the number of matching g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameTypeAndTemplateId(String measurementName,
		String measurementType, long templateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMETYPEANDTEMPLATEID;

		Object[] finderArgs = new Object[] {
				measurementName, measurementType, templateId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEMMEASUREMENT_WHERE);

			boolean bindMeasurementName = false;

			if (measurementName == null) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_1);
			}
			else if (measurementName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_3);
			}
			else {
				bindMeasurementName = true;

				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_2);
			}

			boolean bindMeasurementType = false;

			if (measurementType == null) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_1);
			}
			else if (measurementType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_3);
			}
			else {
				bindMeasurementType = true;

				query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_2);
			}

			query.append(_FINDER_COLUMN_NAMETYPEANDTEMPLATEID_TEMPLATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindMeasurementName) {
					qPos.add(measurementName);
				}

				if (bindMeasurementType) {
					qPos.add(measurementType);
				}

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

	private static final String _FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_1 =
		"gemMeasurement.measurementName IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_2 =
		"gemMeasurement.measurementName = ? AND ";
	private static final String _FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTNAME_3 =
		"(gemMeasurement.measurementName IS NULL OR gemMeasurement.measurementName = '') AND ";
	private static final String _FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_1 =
		"gemMeasurement.measurementType IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_2 =
		"gemMeasurement.measurementType = ? AND ";
	private static final String _FINDER_COLUMN_NAMETYPEANDTEMPLATEID_MEASUREMENTTYPE_3 =
		"(gemMeasurement.measurementType IS NULL OR gemMeasurement.measurementType = '') AND ";
	private static final String _FINDER_COLUMN_NAMETYPEANDTEMPLATEID_TEMPLATEID_2 =
		"gemMeasurement.templateId = ?";

	public GEMMeasurementPersistenceImpl() {
		setModelClass(GEMMeasurement.class);
	}

	/**
	 * Caches the g e m measurement in the entity cache if it is enabled.
	 *
	 * @param gemMeasurement the g e m measurement
	 */
	@Override
	public void cacheResult(GEMMeasurement gemMeasurement) {
		EntityCacheUtil.putResult(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementImpl.class, gemMeasurement.getPrimaryKey(),
			gemMeasurement);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
			new Object[] {
				gemMeasurement.getMeasurementName(),
				gemMeasurement.getMeasurementType(),
				gemMeasurement.getTemplateId()
			}, gemMeasurement);

		gemMeasurement.resetOriginalValues();
	}

	/**
	 * Caches the g e m measurements in the entity cache if it is enabled.
	 *
	 * @param gemMeasurements the g e m measurements
	 */
	@Override
	public void cacheResult(List<GEMMeasurement> gemMeasurements) {
		for (GEMMeasurement gemMeasurement : gemMeasurements) {
			if (EntityCacheUtil.getResult(
						GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementImpl.class, gemMeasurement.getPrimaryKey()) == null) {
				cacheResult(gemMeasurement);
			}
			else {
				gemMeasurement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m measurements.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMMeasurementImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMMeasurementImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m measurement.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMMeasurement gemMeasurement) {
		EntityCacheUtil.removeResult(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementImpl.class, gemMeasurement.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(gemMeasurement);
	}

	@Override
	public void clearCache(List<GEMMeasurement> gemMeasurements) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMMeasurement gemMeasurement : gemMeasurements) {
			EntityCacheUtil.removeResult(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementImpl.class, gemMeasurement.getPrimaryKey());

			clearUniqueFindersCache(gemMeasurement);
		}
	}

	protected void cacheUniqueFindersCache(GEMMeasurement gemMeasurement) {
		if (gemMeasurement.isNew()) {
			Object[] args = new Object[] {
					gemMeasurement.getMeasurementName(),
					gemMeasurement.getMeasurementType(),
					gemMeasurement.getTemplateId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMETYPEANDTEMPLATEID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
				args, gemMeasurement);
		}
		else {
			GEMMeasurementModelImpl gemMeasurementModelImpl = (GEMMeasurementModelImpl)gemMeasurement;

			if ((gemMeasurementModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemMeasurement.getMeasurementName(),
						gemMeasurement.getMeasurementType(),
						gemMeasurement.getTemplateId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMETYPEANDTEMPLATEID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
					args, gemMeasurement);
			}
		}
	}

	protected void clearUniqueFindersCache(GEMMeasurement gemMeasurement) {
		GEMMeasurementModelImpl gemMeasurementModelImpl = (GEMMeasurementModelImpl)gemMeasurement;

		Object[] args = new Object[] {
				gemMeasurement.getMeasurementName(),
				gemMeasurement.getMeasurementType(),
				gemMeasurement.getTemplateId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMETYPEANDTEMPLATEID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
			args);

		if ((gemMeasurementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID.getColumnBitmask()) != 0) {
			args = new Object[] {
					gemMeasurementModelImpl.getOriginalMeasurementName(),
					gemMeasurementModelImpl.getOriginalMeasurementType(),
					gemMeasurementModelImpl.getOriginalTemplateId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMETYPEANDTEMPLATEID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMETYPEANDTEMPLATEID,
				args);
		}
	}

	/**
	 * Creates a new g e m measurement with the primary key. Does not add the g e m measurement to the database.
	 *
	 * @param measurementId the primary key for the new g e m measurement
	 * @return the new g e m measurement
	 */
	@Override
	public GEMMeasurement create(long measurementId) {
		GEMMeasurement gemMeasurement = new GEMMeasurementImpl();

		gemMeasurement.setNew(true);
		gemMeasurement.setPrimaryKey(measurementId);

		return gemMeasurement;
	}

	/**
	 * Removes the g e m measurement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param measurementId the primary key of the g e m measurement
	 * @return the g e m measurement that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement remove(long measurementId)
		throws NoSuchGEMMeasurementException, SystemException {
		return remove((Serializable)measurementId);
	}

	/**
	 * Removes the g e m measurement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m measurement
	 * @return the g e m measurement that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement remove(Serializable primaryKey)
		throws NoSuchGEMMeasurementException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMMeasurement gemMeasurement = (GEMMeasurement)session.get(GEMMeasurementImpl.class,
					primaryKey);

			if (gemMeasurement == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMMeasurementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemMeasurement);
		}
		catch (NoSuchGEMMeasurementException nsee) {
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
	protected GEMMeasurement removeImpl(GEMMeasurement gemMeasurement)
		throws SystemException {
		gemMeasurement = toUnwrappedModel(gemMeasurement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemMeasurement)) {
				gemMeasurement = (GEMMeasurement)session.get(GEMMeasurementImpl.class,
						gemMeasurement.getPrimaryKeyObj());
			}

			if (gemMeasurement != null) {
				session.delete(gemMeasurement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemMeasurement != null) {
			clearCache(gemMeasurement);
		}

		return gemMeasurement;
	}

	@Override
	public GEMMeasurement updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurement gemMeasurement)
		throws SystemException {
		gemMeasurement = toUnwrappedModel(gemMeasurement);

		boolean isNew = gemMeasurement.isNew();

		GEMMeasurementModelImpl gemMeasurementModelImpl = (GEMMeasurementModelImpl)gemMeasurement;

		Session session = null;

		try {
			session = openSession();

			if (gemMeasurement.isNew()) {
				session.save(gemMeasurement);

				gemMeasurement.setNew(false);
			}
			else {
				session.merge(gemMeasurement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMMeasurementModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemMeasurementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemMeasurementModelImpl.getOriginalTemplateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);

				args = new Object[] { gemMeasurementModelImpl.getTemplateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEID,
					args);
			}

			if ((gemMeasurementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemMeasurementModelImpl.getOriginalTemplateId(),
						gemMeasurementModelImpl.getOriginalMeasurementType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDANDTYPE,
					args);

				args = new Object[] {
						gemMeasurementModelImpl.getTemplateId(),
						gemMeasurementModelImpl.getMeasurementType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TEMPLATEIDANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TEMPLATEIDANDTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementImpl.class, gemMeasurement.getPrimaryKey(),
			gemMeasurement);

		clearUniqueFindersCache(gemMeasurement);
		cacheUniqueFindersCache(gemMeasurement);

		return gemMeasurement;
	}

	protected GEMMeasurement toUnwrappedModel(GEMMeasurement gemMeasurement) {
		if (gemMeasurement instanceof GEMMeasurementImpl) {
			return gemMeasurement;
		}

		GEMMeasurementImpl gemMeasurementImpl = new GEMMeasurementImpl();

		gemMeasurementImpl.setNew(gemMeasurement.isNew());
		gemMeasurementImpl.setPrimaryKey(gemMeasurement.getPrimaryKey());

		gemMeasurementImpl.setMeasurementId(gemMeasurement.getMeasurementId());
		gemMeasurementImpl.setMeasurementName(gemMeasurement.getMeasurementName());
		gemMeasurementImpl.setMeasurementType(gemMeasurement.getMeasurementType());
		gemMeasurementImpl.setDisplayOrderNumber(gemMeasurement.getDisplayOrderNumber());
		gemMeasurementImpl.setTemplateId(gemMeasurement.getTemplateId());
		gemMeasurementImpl.setMultiplierQty(gemMeasurement.getMultiplierQty());
		gemMeasurementImpl.setCreatorId(gemMeasurement.getCreatorId());
		gemMeasurementImpl.setCreatedDate(gemMeasurement.getCreatedDate());
		gemMeasurementImpl.setUpdatedBy(gemMeasurement.getUpdatedBy());
		gemMeasurementImpl.setUpdatedDate(gemMeasurement.getUpdatedDate());

		return gemMeasurementImpl;
	}

	/**
	 * Returns the g e m measurement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement
	 * @return the g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMMeasurementException, SystemException {
		GEMMeasurement gemMeasurement = fetchByPrimaryKey(primaryKey);

		if (gemMeasurement == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMMeasurementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemMeasurement;
	}

	/**
	 * Returns the g e m measurement with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementException} if it could not be found.
	 *
	 * @param measurementId the primary key of the g e m measurement
	 * @return the g e m measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementException if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement findByPrimaryKey(long measurementId)
		throws NoSuchGEMMeasurementException, SystemException {
		return findByPrimaryKey((Serializable)measurementId);
	}

	/**
	 * Returns the g e m measurement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement
	 * @return the g e m measurement, or <code>null</code> if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMMeasurement gemMeasurement = (GEMMeasurement)EntityCacheUtil.getResult(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementImpl.class, primaryKey);

		if (gemMeasurement == _nullGEMMeasurement) {
			return null;
		}

		if (gemMeasurement == null) {
			Session session = null;

			try {
				session = openSession();

				gemMeasurement = (GEMMeasurement)session.get(GEMMeasurementImpl.class,
						primaryKey);

				if (gemMeasurement != null) {
					cacheResult(gemMeasurement);
				}
				else {
					EntityCacheUtil.putResult(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementImpl.class, primaryKey,
						_nullGEMMeasurement);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMMeasurementModelImpl.ENTITY_CACHE_ENABLED,
					GEMMeasurementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemMeasurement;
	}

	/**
	 * Returns the g e m measurement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param measurementId the primary key of the g e m measurement
	 * @return the g e m measurement, or <code>null</code> if a g e m measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurement fetchByPrimaryKey(long measurementId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)measurementId);
	}

	/**
	 * Returns all the g e m measurements.
	 *
	 * @return the g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m measurements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurements
	 * @param end the upper bound of the range of g e m measurements (not inclusive)
	 * @return the range of g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m measurements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurements
	 * @param end the upper bound of the range of g e m measurements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurement> findAll(int start, int end,
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

		List<GEMMeasurement> list = (List<GEMMeasurement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMMEASUREMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMMEASUREMENT;

				if (pagination) {
					sql = sql.concat(GEMMeasurementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMMeasurement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMMeasurement>(list);
				}
				else {
					list = (List<GEMMeasurement>)QueryUtil.list(q,
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
	 * Removes all the g e m measurements from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMMeasurement gemMeasurement : findAll()) {
			remove(gemMeasurement);
		}
	}

	/**
	 * Returns the number of g e m measurements.
	 *
	 * @return the number of g e m measurements
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

				Query q = session.createQuery(_SQL_COUNT_GEMMEASUREMENT);

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
	 * Initializes the g e m measurement persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMMeasurement")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMMeasurement>> listenersList = new ArrayList<ModelListener<GEMMeasurement>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMMeasurement>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMMeasurementImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMMEASUREMENT = "SELECT gemMeasurement FROM GEMMeasurement gemMeasurement";
	private static final String _SQL_SELECT_GEMMEASUREMENT_WHERE = "SELECT gemMeasurement FROM GEMMeasurement gemMeasurement WHERE ";
	private static final String _SQL_COUNT_GEMMEASUREMENT = "SELECT COUNT(gemMeasurement) FROM GEMMeasurement gemMeasurement";
	private static final String _SQL_COUNT_GEMMEASUREMENT_WHERE = "SELECT COUNT(gemMeasurement) FROM GEMMeasurement gemMeasurement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemMeasurement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMMeasurement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMMeasurement exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMMeasurementPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"measurementId", "measurementName", "measurementType",
				"displayOrderNumber", "templateId", "multiplierQty", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMMeasurement _nullGEMMeasurement = new GEMMeasurementImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMMeasurement> toCacheModel() {
				return _nullGEMMeasurementCacheModel;
			}
		};

	private static CacheModel<GEMMeasurement> _nullGEMMeasurementCacheModel = new CacheModel<GEMMeasurement>() {
			@Override
			public GEMMeasurement toEntityModel() {
				return _nullGEMMeasurement;
			}
		};
}