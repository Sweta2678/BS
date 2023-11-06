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

import com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException;
import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualImpl;
import com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl;

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
 * The persistence implementation for the standards historical manual service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsHistoricalManualPersistence
 * @see StandardsHistoricalManualUtil
 * @generated
 */
public class StandardsHistoricalManualPersistenceImpl
	extends BasePersistenceImpl<StandardsHistoricalManual>
	implements StandardsHistoricalManualPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsHistoricalManualUtil} to access the standards historical manual persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsHistoricalManualImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			StandardsHistoricalManualModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStdId", new String[] { Long.class.getName() });

	/**
	 * Returns all the standards historical manuals where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards historical manuals where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards historical manuals
	 * @param end the upper bound of the range of standards historical manuals (not inclusive)
	 * @return the range of matching standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findByStdId(long stdId, int start,
		int end) throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards historical manuals where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards historical manuals
	 * @param end the upper bound of the range of standards historical manuals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findByStdId(long stdId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<StandardsHistoricalManual> list = (List<StandardsHistoricalManual>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsHistoricalManual standardsHistoricalManual : list) {
				if ((stdId != standardsHistoricalManual.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSHISTORICALMANUAL_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsHistoricalManualModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardsHistoricalManual>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsHistoricalManual>(list);
				}
				else {
					list = (List<StandardsHistoricalManual>)QueryUtil.list(q,
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
	 * Returns the first standards historical manual in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		StandardsHistoricalManual standardsHistoricalManual = fetchByStdId_First(stdId,
				orderByComparator);

		if (standardsHistoricalManual != null) {
			return standardsHistoricalManual;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsHistoricalManualException(msg.toString());
	}

	/**
	 * Returns the first standards historical manual in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsHistoricalManual> list = findByStdId(stdId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards historical manual in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		StandardsHistoricalManual standardsHistoricalManual = fetchByStdId_Last(stdId,
				orderByComparator);

		if (standardsHistoricalManual != null) {
			return standardsHistoricalManual;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsHistoricalManualException(msg.toString());
	}

	/**
	 * Returns the last standards historical manual in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<StandardsHistoricalManual> list = findByStdId(stdId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards historical manuals before and after the current standards historical manual in the ordered set where stdId = &#63;.
	 *
	 * @param stdMnlId the primary key of the current standards historical manual
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual[] findByStdId_PrevAndNext(long stdMnlId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		StandardsHistoricalManual standardsHistoricalManual = findByPrimaryKey(stdMnlId);

		Session session = null;

		try {
			session = openSession();

			StandardsHistoricalManual[] array = new StandardsHistoricalManualImpl[3];

			array[0] = getByStdId_PrevAndNext(session,
					standardsHistoricalManual, stdId, orderByComparator, true);

			array[1] = standardsHistoricalManual;

			array[2] = getByStdId_PrevAndNext(session,
					standardsHistoricalManual, stdId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsHistoricalManual getByStdId_PrevAndNext(
		Session session, StandardsHistoricalManual standardsHistoricalManual,
		long stdId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSHISTORICALMANUAL_WHERE);

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
			query.append(StandardsHistoricalManualModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsHistoricalManual);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsHistoricalManual> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards historical manuals where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (StandardsHistoricalManual standardsHistoricalManual : findByStdId(
				stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsHistoricalManual);
		}
	}

	/**
	 * Returns the number of standards historical manuals where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standards historical manuals
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

			query.append(_SQL_COUNT_STANDARDSHISTORICALMANUAL_WHERE);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standardsHistoricalManual.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_HISTMANUALID =
		new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHistManualId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID =
		new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHistManualId",
			new String[] { Long.class.getName() },
			StandardsHistoricalManualModelImpl.HISTMANUALID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_HISTMANUALID = new FinderPath(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByHistManualId", new String[] { Long.class.getName() });

	/**
	 * Returns all the standards historical manuals where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @return the matching standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findByHistManualId(long histManualId)
		throws SystemException {
		return findByHistManualId(histManualId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards historical manuals where histManualId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param histManualId the hist manual ID
	 * @param start the lower bound of the range of standards historical manuals
	 * @param end the upper bound of the range of standards historical manuals (not inclusive)
	 * @return the range of matching standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findByHistManualId(
		long histManualId, int start, int end) throws SystemException {
		return findByHistManualId(histManualId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards historical manuals where histManualId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param histManualId the hist manual ID
	 * @param start the lower bound of the range of standards historical manuals
	 * @param end the upper bound of the range of standards historical manuals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findByHistManualId(
		long histManualId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<StandardsHistoricalManual> list = (List<StandardsHistoricalManual>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsHistoricalManual standardsHistoricalManual : list) {
				if ((histManualId != standardsHistoricalManual.getHistManualId())) {
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

			query.append(_SQL_SELECT_STANDARDSHISTORICALMANUAL_WHERE);

			query.append(_FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsHistoricalManualModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(histManualId);

				if (!pagination) {
					list = (List<StandardsHistoricalManual>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsHistoricalManual>(list);
				}
				else {
					list = (List<StandardsHistoricalManual>)QueryUtil.list(q,
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
	 * Returns the first standards historical manual in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual findByHistManualId_First(
		long histManualId, OrderByComparator orderByComparator)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		StandardsHistoricalManual standardsHistoricalManual = fetchByHistManualId_First(histManualId,
				orderByComparator);

		if (standardsHistoricalManual != null) {
			return standardsHistoricalManual;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("histManualId=");
		msg.append(histManualId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsHistoricalManualException(msg.toString());
	}

	/**
	 * Returns the first standards historical manual in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual fetchByHistManualId_First(
		long histManualId, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsHistoricalManual> list = findByHistManualId(histManualId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards historical manual in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual findByHistManualId_Last(
		long histManualId, OrderByComparator orderByComparator)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		StandardsHistoricalManual standardsHistoricalManual = fetchByHistManualId_Last(histManualId,
				orderByComparator);

		if (standardsHistoricalManual != null) {
			return standardsHistoricalManual;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("histManualId=");
		msg.append(histManualId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsHistoricalManualException(msg.toString());
	}

	/**
	 * Returns the last standards historical manual in the ordered set where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards historical manual, or <code>null</code> if a matching standards historical manual could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual fetchByHistManualId_Last(
		long histManualId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByHistManualId(histManualId);

		if (count == 0) {
			return null;
		}

		List<StandardsHistoricalManual> list = findByHistManualId(histManualId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards historical manuals before and after the current standards historical manual in the ordered set where histManualId = &#63;.
	 *
	 * @param stdMnlId the primary key of the current standards historical manual
	 * @param histManualId the hist manual ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual[] findByHistManualId_PrevAndNext(
		long stdMnlId, long histManualId, OrderByComparator orderByComparator)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		StandardsHistoricalManual standardsHistoricalManual = findByPrimaryKey(stdMnlId);

		Session session = null;

		try {
			session = openSession();

			StandardsHistoricalManual[] array = new StandardsHistoricalManualImpl[3];

			array[0] = getByHistManualId_PrevAndNext(session,
					standardsHistoricalManual, histManualId, orderByComparator,
					true);

			array[1] = standardsHistoricalManual;

			array[2] = getByHistManualId_PrevAndNext(session,
					standardsHistoricalManual, histManualId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsHistoricalManual getByHistManualId_PrevAndNext(
		Session session, StandardsHistoricalManual standardsHistoricalManual,
		long histManualId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSHISTORICALMANUAL_WHERE);

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
			query.append(StandardsHistoricalManualModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(histManualId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsHistoricalManual);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsHistoricalManual> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards historical manuals where histManualId = &#63; from the database.
	 *
	 * @param histManualId the hist manual ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByHistManualId(long histManualId)
		throws SystemException {
		for (StandardsHistoricalManual standardsHistoricalManual : findByHistManualId(
				histManualId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsHistoricalManual);
		}
	}

	/**
	 * Returns the number of standards historical manuals where histManualId = &#63;.
	 *
	 * @param histManualId the hist manual ID
	 * @return the number of matching standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByHistManualId(long histManualId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_HISTMANUALID;

		Object[] finderArgs = new Object[] { histManualId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSHISTORICALMANUAL_WHERE);

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

	private static final String _FINDER_COLUMN_HISTMANUALID_HISTMANUALID_2 = "standardsHistoricalManual.histManualId = ?";

	public StandardsHistoricalManualPersistenceImpl() {
		setModelClass(StandardsHistoricalManual.class);
	}

	/**
	 * Caches the standards historical manual in the entity cache if it is enabled.
	 *
	 * @param standardsHistoricalManual the standards historical manual
	 */
	@Override
	public void cacheResult(StandardsHistoricalManual standardsHistoricalManual) {
		EntityCacheUtil.putResult(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			standardsHistoricalManual.getPrimaryKey(), standardsHistoricalManual);

		standardsHistoricalManual.resetOriginalValues();
	}

	/**
	 * Caches the standards historical manuals in the entity cache if it is enabled.
	 *
	 * @param standardsHistoricalManuals the standards historical manuals
	 */
	@Override
	public void cacheResult(
		List<StandardsHistoricalManual> standardsHistoricalManuals) {
		for (StandardsHistoricalManual standardsHistoricalManual : standardsHistoricalManuals) {
			if (EntityCacheUtil.getResult(
						StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
						StandardsHistoricalManualImpl.class,
						standardsHistoricalManual.getPrimaryKey()) == null) {
				cacheResult(standardsHistoricalManual);
			}
			else {
				standardsHistoricalManual.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards historical manuals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsHistoricalManualImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsHistoricalManualImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards historical manual.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsHistoricalManual standardsHistoricalManual) {
		EntityCacheUtil.removeResult(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			standardsHistoricalManual.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<StandardsHistoricalManual> standardsHistoricalManuals) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsHistoricalManual standardsHistoricalManual : standardsHistoricalManuals) {
			EntityCacheUtil.removeResult(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
				StandardsHistoricalManualImpl.class,
				standardsHistoricalManual.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards historical manual with the primary key. Does not add the standards historical manual to the database.
	 *
	 * @param stdMnlId the primary key for the new standards historical manual
	 * @return the new standards historical manual
	 */
	@Override
	public StandardsHistoricalManual create(long stdMnlId) {
		StandardsHistoricalManual standardsHistoricalManual = new StandardsHistoricalManualImpl();

		standardsHistoricalManual.setNew(true);
		standardsHistoricalManual.setPrimaryKey(stdMnlId);

		return standardsHistoricalManual;
	}

	/**
	 * Removes the standards historical manual with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdMnlId the primary key of the standards historical manual
	 * @return the standards historical manual that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual remove(long stdMnlId)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		return remove((Serializable)stdMnlId);
	}

	/**
	 * Removes the standards historical manual with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards historical manual
	 * @return the standards historical manual that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual remove(Serializable primaryKey)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsHistoricalManual standardsHistoricalManual = (StandardsHistoricalManual)session.get(StandardsHistoricalManualImpl.class,
					primaryKey);

			if (standardsHistoricalManual == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsHistoricalManualException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsHistoricalManual);
		}
		catch (NoSuchStandardsHistoricalManualException nsee) {
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
	protected StandardsHistoricalManual removeImpl(
		StandardsHistoricalManual standardsHistoricalManual)
		throws SystemException {
		standardsHistoricalManual = toUnwrappedModel(standardsHistoricalManual);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsHistoricalManual)) {
				standardsHistoricalManual = (StandardsHistoricalManual)session.get(StandardsHistoricalManualImpl.class,
						standardsHistoricalManual.getPrimaryKeyObj());
			}

			if (standardsHistoricalManual != null) {
				session.delete(standardsHistoricalManual);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsHistoricalManual != null) {
			clearCache(standardsHistoricalManual);
		}

		return standardsHistoricalManual;
	}

	@Override
	public StandardsHistoricalManual updateImpl(
		com.ihg.brandstandards.db.model.StandardsHistoricalManual standardsHistoricalManual)
		throws SystemException {
		standardsHistoricalManual = toUnwrappedModel(standardsHistoricalManual);

		boolean isNew = standardsHistoricalManual.isNew();

		StandardsHistoricalManualModelImpl standardsHistoricalManualModelImpl = (StandardsHistoricalManualModelImpl)standardsHistoricalManual;

		Session session = null;

		try {
			session = openSession();

			if (standardsHistoricalManual.isNew()) {
				session.save(standardsHistoricalManual);

				standardsHistoricalManual.setNew(false);
			}
			else {
				session.merge(standardsHistoricalManual);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!StandardsHistoricalManualModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsHistoricalManualModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsHistoricalManualModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] {
						standardsHistoricalManualModelImpl.getStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((standardsHistoricalManualModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsHistoricalManualModelImpl.getOriginalHistManualId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HISTMANUALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID,
					args);

				args = new Object[] {
						standardsHistoricalManualModelImpl.getHistManualId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_HISTMANUALID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_HISTMANUALID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
			StandardsHistoricalManualImpl.class,
			standardsHistoricalManual.getPrimaryKey(), standardsHistoricalManual);

		return standardsHistoricalManual;
	}

	protected StandardsHistoricalManual toUnwrappedModel(
		StandardsHistoricalManual standardsHistoricalManual) {
		if (standardsHistoricalManual instanceof StandardsHistoricalManualImpl) {
			return standardsHistoricalManual;
		}

		StandardsHistoricalManualImpl standardsHistoricalManualImpl = new StandardsHistoricalManualImpl();

		standardsHistoricalManualImpl.setNew(standardsHistoricalManual.isNew());
		standardsHistoricalManualImpl.setPrimaryKey(standardsHistoricalManual.getPrimaryKey());

		standardsHistoricalManualImpl.setStdMnlId(standardsHistoricalManual.getStdMnlId());
		standardsHistoricalManualImpl.setStdId(standardsHistoricalManual.getStdId());
		standardsHistoricalManualImpl.setHistManualId(standardsHistoricalManual.getHistManualId());
		standardsHistoricalManualImpl.setChange(standardsHistoricalManual.getChange());
		standardsHistoricalManualImpl.setTitle(standardsHistoricalManual.getTitle());
		standardsHistoricalManualImpl.setCreatorId(standardsHistoricalManual.getCreatorId());
		standardsHistoricalManualImpl.setCreatedDate(standardsHistoricalManual.getCreatedDate());
		standardsHistoricalManualImpl.setUpdatedBy(standardsHistoricalManual.getUpdatedBy());
		standardsHistoricalManualImpl.setUpdatedDate(standardsHistoricalManual.getUpdatedDate());

		return standardsHistoricalManualImpl;
	}

	/**
	 * Returns the standards historical manual with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards historical manual
	 * @return the standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		StandardsHistoricalManual standardsHistoricalManual = fetchByPrimaryKey(primaryKey);

		if (standardsHistoricalManual == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsHistoricalManualException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsHistoricalManual;
	}

	/**
	 * Returns the standards historical manual with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException} if it could not be found.
	 *
	 * @param stdMnlId the primary key of the standards historical manual
	 * @return the standards historical manual
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual findByPrimaryKey(long stdMnlId)
		throws NoSuchStandardsHistoricalManualException, SystemException {
		return findByPrimaryKey((Serializable)stdMnlId);
	}

	/**
	 * Returns the standards historical manual with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards historical manual
	 * @return the standards historical manual, or <code>null</code> if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsHistoricalManual standardsHistoricalManual = (StandardsHistoricalManual)EntityCacheUtil.getResult(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
				StandardsHistoricalManualImpl.class, primaryKey);

		if (standardsHistoricalManual == _nullStandardsHistoricalManual) {
			return null;
		}

		if (standardsHistoricalManual == null) {
			Session session = null;

			try {
				session = openSession();

				standardsHistoricalManual = (StandardsHistoricalManual)session.get(StandardsHistoricalManualImpl.class,
						primaryKey);

				if (standardsHistoricalManual != null) {
					cacheResult(standardsHistoricalManual);
				}
				else {
					EntityCacheUtil.putResult(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
						StandardsHistoricalManualImpl.class, primaryKey,
						_nullStandardsHistoricalManual);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsHistoricalManualModelImpl.ENTITY_CACHE_ENABLED,
					StandardsHistoricalManualImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsHistoricalManual;
	}

	/**
	 * Returns the standards historical manual with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdMnlId the primary key of the standards historical manual
	 * @return the standards historical manual, or <code>null</code> if a standards historical manual with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsHistoricalManual fetchByPrimaryKey(long stdMnlId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdMnlId);
	}

	/**
	 * Returns all the standards historical manuals.
	 *
	 * @return the standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards historical manuals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards historical manuals
	 * @param end the upper bound of the range of standards historical manuals (not inclusive)
	 * @return the range of standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards historical manuals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards historical manuals
	 * @param end the upper bound of the range of standards historical manuals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards historical manuals
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsHistoricalManual> findAll(int start, int end,
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

		List<StandardsHistoricalManual> list = (List<StandardsHistoricalManual>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSHISTORICALMANUAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSHISTORICALMANUAL;

				if (pagination) {
					sql = sql.concat(StandardsHistoricalManualModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsHistoricalManual>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsHistoricalManual>(list);
				}
				else {
					list = (List<StandardsHistoricalManual>)QueryUtil.list(q,
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
	 * Removes all the standards historical manuals from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsHistoricalManual standardsHistoricalManual : findAll()) {
			remove(standardsHistoricalManual);
		}
	}

	/**
	 * Returns the number of standards historical manuals.
	 *
	 * @return the number of standards historical manuals
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSHISTORICALMANUAL);

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
	 * Initializes the standards historical manual persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsHistoricalManual")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsHistoricalManual>> listenersList = new ArrayList<ModelListener<StandardsHistoricalManual>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsHistoricalManual>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsHistoricalManualImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSHISTORICALMANUAL = "SELECT standardsHistoricalManual FROM StandardsHistoricalManual standardsHistoricalManual";
	private static final String _SQL_SELECT_STANDARDSHISTORICALMANUAL_WHERE = "SELECT standardsHistoricalManual FROM StandardsHistoricalManual standardsHistoricalManual WHERE ";
	private static final String _SQL_COUNT_STANDARDSHISTORICALMANUAL = "SELECT COUNT(standardsHistoricalManual) FROM StandardsHistoricalManual standardsHistoricalManual";
	private static final String _SQL_COUNT_STANDARDSHISTORICALMANUAL_WHERE = "SELECT COUNT(standardsHistoricalManual) FROM StandardsHistoricalManual standardsHistoricalManual WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsHistoricalManual.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsHistoricalManual exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsHistoricalManual exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsHistoricalManualPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdMnlId", "stdId", "histManualId", "change", "title",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static StandardsHistoricalManual _nullStandardsHistoricalManual = new StandardsHistoricalManualImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsHistoricalManual> toCacheModel() {
				return _nullStandardsHistoricalManualCacheModel;
			}
		};

	private static CacheModel<StandardsHistoricalManual> _nullStandardsHistoricalManualCacheModel =
		new CacheModel<StandardsHistoricalManual>() {
			@Override
			public StandardsHistoricalManual toEntityModel() {
				return _nullStandardsHistoricalManual;
			}
		};
}