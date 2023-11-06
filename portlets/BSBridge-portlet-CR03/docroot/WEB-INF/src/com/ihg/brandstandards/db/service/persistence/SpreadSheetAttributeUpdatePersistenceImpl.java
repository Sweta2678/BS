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

import com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException;
import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;
import com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateImpl;
import com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl;

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
 * The persistence implementation for the spread sheet attribute update service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see SpreadSheetAttributeUpdatePersistence
 * @see SpreadSheetAttributeUpdateUtil
 * @generated
 */
public class SpreadSheetAttributeUpdatePersistenceImpl
	extends BasePersistenceImpl<SpreadSheetAttributeUpdate>
	implements SpreadSheetAttributeUpdatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpreadSheetAttributeUpdateUtil} to access the spread sheet attribute update persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpreadSheetAttributeUpdateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateModelImpl.FINDER_CACHE_ENABLED,
			SpreadSheetAttributeUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateModelImpl.FINDER_CACHE_ENABLED,
			SpreadSheetAttributeUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateModelImpl.FINDER_CACHE_ENABLED,
			SpreadSheetAttributeUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateModelImpl.FINDER_CACHE_ENABLED,
			SpreadSheetAttributeUpdateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] { String.class.getName() },
			SpreadSheetAttributeUpdateModelImpl.STATUS_COLUMN_BITMASK |
			SpreadSheetAttributeUpdateModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBystatus", new String[] { String.class.getName() });

	/**
	 * Returns all the spread sheet attribute updates where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching spread sheet attribute updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpreadSheetAttributeUpdate> findBystatus(String status)
		throws SystemException {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spread sheet attribute updates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of spread sheet attribute updates
	 * @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	 * @return the range of matching spread sheet attribute updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpreadSheetAttributeUpdate> findBystatus(String status,
		int start, int end) throws SystemException {
		return findBystatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the spread sheet attribute updates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of spread sheet attribute updates
	 * @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching spread sheet attribute updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpreadSheetAttributeUpdate> findBystatus(String status,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<SpreadSheetAttributeUpdate> list = (List<SpreadSheetAttributeUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpreadSheetAttributeUpdate spreadSheetAttributeUpdate : list) {
				if (!Validator.equals(status,
							spreadSheetAttributeUpdate.getStatus())) {
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

			query.append(_SQL_SELECT_SPREADSHEETATTRIBUTEUPDATE_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpreadSheetAttributeUpdateModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<SpreadSheetAttributeUpdate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpreadSheetAttributeUpdate>(list);
				}
				else {
					list = (List<SpreadSheetAttributeUpdate>)QueryUtil.list(q,
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
	 * Returns the first spread sheet attribute update in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spread sheet attribute update
	 * @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a matching spread sheet attribute update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate findBystatus_First(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSpreadSheetAttributeUpdateException, SystemException {
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate = fetchBystatus_First(status,
				orderByComparator);

		if (spreadSheetAttributeUpdate != null) {
			return spreadSheetAttributeUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpreadSheetAttributeUpdateException(msg.toString());
	}

	/**
	 * Returns the first spread sheet attribute update in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching spread sheet attribute update, or <code>null</code> if a matching spread sheet attribute update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate fetchBystatus_First(String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpreadSheetAttributeUpdate> list = findBystatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last spread sheet attribute update in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spread sheet attribute update
	 * @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a matching spread sheet attribute update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate findBystatus_Last(String status,
		OrderByComparator orderByComparator)
		throws NoSuchSpreadSheetAttributeUpdateException, SystemException {
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate = fetchBystatus_Last(status,
				orderByComparator);

		if (spreadSheetAttributeUpdate != null) {
			return spreadSheetAttributeUpdate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpreadSheetAttributeUpdateException(msg.toString());
	}

	/**
	 * Returns the last spread sheet attribute update in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching spread sheet attribute update, or <code>null</code> if a matching spread sheet attribute update could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate fetchBystatus_Last(String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<SpreadSheetAttributeUpdate> list = findBystatus(status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the spread sheet attribute updates before and after the current spread sheet attribute update in the ordered set where status = &#63;.
	 *
	 * @param speardSheetId the primary key of the current spread sheet attribute update
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next spread sheet attribute update
	 * @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate[] findBystatus_PrevAndNext(
		long speardSheetId, String status, OrderByComparator orderByComparator)
		throws NoSuchSpreadSheetAttributeUpdateException, SystemException {
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate = findByPrimaryKey(speardSheetId);

		Session session = null;

		try {
			session = openSession();

			SpreadSheetAttributeUpdate[] array = new SpreadSheetAttributeUpdateImpl[3];

			array[0] = getBystatus_PrevAndNext(session,
					spreadSheetAttributeUpdate, status, orderByComparator, true);

			array[1] = spreadSheetAttributeUpdate;

			array[2] = getBystatus_PrevAndNext(session,
					spreadSheetAttributeUpdate, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpreadSheetAttributeUpdate getBystatus_PrevAndNext(
		Session session, SpreadSheetAttributeUpdate spreadSheetAttributeUpdate,
		String status, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPREADSHEETATTRIBUTEUPDATE_WHERE);

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
			query.append(SpreadSheetAttributeUpdateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(spreadSheetAttributeUpdate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpreadSheetAttributeUpdate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the spread sheet attribute updates where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBystatus(String status) throws SystemException {
		for (SpreadSheetAttributeUpdate spreadSheetAttributeUpdate : findBystatus(
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(spreadSheetAttributeUpdate);
		}
	}

	/**
	 * Returns the number of spread sheet attribute updates where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching spread sheet attribute updates
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

			query.append(_SQL_COUNT_SPREADSHEETATTRIBUTEUPDATE_WHERE);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "spreadSheetAttributeUpdate.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "spreadSheetAttributeUpdate.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(spreadSheetAttributeUpdate.status IS NULL OR spreadSheetAttributeUpdate.status = '')";

	public SpreadSheetAttributeUpdatePersistenceImpl() {
		setModelClass(SpreadSheetAttributeUpdate.class);
	}

	/**
	 * Caches the spread sheet attribute update in the entity cache if it is enabled.
	 *
	 * @param spreadSheetAttributeUpdate the spread sheet attribute update
	 */
	@Override
	public void cacheResult(
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		EntityCacheUtil.putResult(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateImpl.class,
			spreadSheetAttributeUpdate.getPrimaryKey(),
			spreadSheetAttributeUpdate);

		spreadSheetAttributeUpdate.resetOriginalValues();
	}

	/**
	 * Caches the spread sheet attribute updates in the entity cache if it is enabled.
	 *
	 * @param spreadSheetAttributeUpdates the spread sheet attribute updates
	 */
	@Override
	public void cacheResult(
		List<SpreadSheetAttributeUpdate> spreadSheetAttributeUpdates) {
		for (SpreadSheetAttributeUpdate spreadSheetAttributeUpdate : spreadSheetAttributeUpdates) {
			if (EntityCacheUtil.getResult(
						SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
						SpreadSheetAttributeUpdateImpl.class,
						spreadSheetAttributeUpdate.getPrimaryKey()) == null) {
				cacheResult(spreadSheetAttributeUpdate);
			}
			else {
				spreadSheetAttributeUpdate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all spread sheet attribute updates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SpreadSheetAttributeUpdateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SpreadSheetAttributeUpdateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the spread sheet attribute update.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		EntityCacheUtil.removeResult(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateImpl.class,
			spreadSheetAttributeUpdate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SpreadSheetAttributeUpdate> spreadSheetAttributeUpdates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SpreadSheetAttributeUpdate spreadSheetAttributeUpdate : spreadSheetAttributeUpdates) {
			EntityCacheUtil.removeResult(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
				SpreadSheetAttributeUpdateImpl.class,
				spreadSheetAttributeUpdate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new spread sheet attribute update with the primary key. Does not add the spread sheet attribute update to the database.
	 *
	 * @param speardSheetId the primary key for the new spread sheet attribute update
	 * @return the new spread sheet attribute update
	 */
	@Override
	public SpreadSheetAttributeUpdate create(long speardSheetId) {
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate = new SpreadSheetAttributeUpdateImpl();

		spreadSheetAttributeUpdate.setNew(true);
		spreadSheetAttributeUpdate.setPrimaryKey(speardSheetId);

		return spreadSheetAttributeUpdate;
	}

	/**
	 * Removes the spread sheet attribute update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param speardSheetId the primary key of the spread sheet attribute update
	 * @return the spread sheet attribute update that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate remove(long speardSheetId)
		throws NoSuchSpreadSheetAttributeUpdateException, SystemException {
		return remove((Serializable)speardSheetId);
	}

	/**
	 * Removes the spread sheet attribute update with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the spread sheet attribute update
	 * @return the spread sheet attribute update that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate remove(Serializable primaryKey)
		throws NoSuchSpreadSheetAttributeUpdateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SpreadSheetAttributeUpdate spreadSheetAttributeUpdate = (SpreadSheetAttributeUpdate)session.get(SpreadSheetAttributeUpdateImpl.class,
					primaryKey);

			if (spreadSheetAttributeUpdate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpreadSheetAttributeUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(spreadSheetAttributeUpdate);
		}
		catch (NoSuchSpreadSheetAttributeUpdateException nsee) {
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
	protected SpreadSheetAttributeUpdate removeImpl(
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws SystemException {
		spreadSheetAttributeUpdate = toUnwrappedModel(spreadSheetAttributeUpdate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(spreadSheetAttributeUpdate)) {
				spreadSheetAttributeUpdate = (SpreadSheetAttributeUpdate)session.get(SpreadSheetAttributeUpdateImpl.class,
						spreadSheetAttributeUpdate.getPrimaryKeyObj());
			}

			if (spreadSheetAttributeUpdate != null) {
				session.delete(spreadSheetAttributeUpdate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (spreadSheetAttributeUpdate != null) {
			clearCache(spreadSheetAttributeUpdate);
		}

		return spreadSheetAttributeUpdate;
	}

	@Override
	public SpreadSheetAttributeUpdate updateImpl(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
		throws SystemException {
		spreadSheetAttributeUpdate = toUnwrappedModel(spreadSheetAttributeUpdate);

		boolean isNew = spreadSheetAttributeUpdate.isNew();

		SpreadSheetAttributeUpdateModelImpl spreadSheetAttributeUpdateModelImpl = (SpreadSheetAttributeUpdateModelImpl)spreadSheetAttributeUpdate;

		Session session = null;

		try {
			session = openSession();

			if (spreadSheetAttributeUpdate.isNew()) {
				session.save(spreadSheetAttributeUpdate);

				spreadSheetAttributeUpdate.setNew(false);
			}
			else {
				session.merge(spreadSheetAttributeUpdate);
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
				!SpreadSheetAttributeUpdateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((spreadSheetAttributeUpdateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						spreadSheetAttributeUpdateModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						spreadSheetAttributeUpdateModelImpl.getStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
			SpreadSheetAttributeUpdateImpl.class,
			spreadSheetAttributeUpdate.getPrimaryKey(),
			spreadSheetAttributeUpdate);

		return spreadSheetAttributeUpdate;
	}

	protected SpreadSheetAttributeUpdate toUnwrappedModel(
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		if (spreadSheetAttributeUpdate instanceof SpreadSheetAttributeUpdateImpl) {
			return spreadSheetAttributeUpdate;
		}

		SpreadSheetAttributeUpdateImpl spreadSheetAttributeUpdateImpl = new SpreadSheetAttributeUpdateImpl();

		spreadSheetAttributeUpdateImpl.setNew(spreadSheetAttributeUpdate.isNew());
		spreadSheetAttributeUpdateImpl.setPrimaryKey(spreadSheetAttributeUpdate.getPrimaryKey());

		spreadSheetAttributeUpdateImpl.setSpeardSheetId(spreadSheetAttributeUpdate.getSpeardSheetId());
		spreadSheetAttributeUpdateImpl.setRequestTitle(spreadSheetAttributeUpdate.getRequestTitle());
		spreadSheetAttributeUpdateImpl.setStatus(spreadSheetAttributeUpdate.getStatus());
		spreadSheetAttributeUpdateImpl.setCreatorId(spreadSheetAttributeUpdate.getCreatorId());
		spreadSheetAttributeUpdateImpl.setCreatedDate(spreadSheetAttributeUpdate.getCreatedDate());
		spreadSheetAttributeUpdateImpl.setUpdatedBy(spreadSheetAttributeUpdate.getUpdatedBy());
		spreadSheetAttributeUpdateImpl.setUpdatedDate(spreadSheetAttributeUpdate.getUpdatedDate());
		spreadSheetAttributeUpdateImpl.setSpreadSheet(spreadSheetAttributeUpdate.getSpreadSheet());

		return spreadSheetAttributeUpdateImpl;
	}

	/**
	 * Returns the spread sheet attribute update with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the spread sheet attribute update
	 * @return the spread sheet attribute update
	 * @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpreadSheetAttributeUpdateException, SystemException {
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate = fetchByPrimaryKey(primaryKey);

		if (spreadSheetAttributeUpdate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpreadSheetAttributeUpdateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return spreadSheetAttributeUpdate;
	}

	/**
	 * Returns the spread sheet attribute update with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException} if it could not be found.
	 *
	 * @param speardSheetId the primary key of the spread sheet attribute update
	 * @return the spread sheet attribute update
	 * @throws com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException if a spread sheet attribute update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate findByPrimaryKey(long speardSheetId)
		throws NoSuchSpreadSheetAttributeUpdateException, SystemException {
		return findByPrimaryKey((Serializable)speardSheetId);
	}

	/**
	 * Returns the spread sheet attribute update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the spread sheet attribute update
	 * @return the spread sheet attribute update, or <code>null</code> if a spread sheet attribute update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate = (SpreadSheetAttributeUpdate)EntityCacheUtil.getResult(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
				SpreadSheetAttributeUpdateImpl.class, primaryKey);

		if (spreadSheetAttributeUpdate == _nullSpreadSheetAttributeUpdate) {
			return null;
		}

		if (spreadSheetAttributeUpdate == null) {
			Session session = null;

			try {
				session = openSession();

				spreadSheetAttributeUpdate = (SpreadSheetAttributeUpdate)session.get(SpreadSheetAttributeUpdateImpl.class,
						primaryKey);

				if (spreadSheetAttributeUpdate != null) {
					cacheResult(spreadSheetAttributeUpdate);
				}
				else {
					EntityCacheUtil.putResult(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
						SpreadSheetAttributeUpdateImpl.class, primaryKey,
						_nullSpreadSheetAttributeUpdate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SpreadSheetAttributeUpdateModelImpl.ENTITY_CACHE_ENABLED,
					SpreadSheetAttributeUpdateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return spreadSheetAttributeUpdate;
	}

	/**
	 * Returns the spread sheet attribute update with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param speardSheetId the primary key of the spread sheet attribute update
	 * @return the spread sheet attribute update, or <code>null</code> if a spread sheet attribute update with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpreadSheetAttributeUpdate fetchByPrimaryKey(long speardSheetId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)speardSheetId);
	}

	/**
	 * Returns all the spread sheet attribute updates.
	 *
	 * @return the spread sheet attribute updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpreadSheetAttributeUpdate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the spread sheet attribute updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of spread sheet attribute updates
	 * @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	 * @return the range of spread sheet attribute updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpreadSheetAttributeUpdate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the spread sheet attribute updates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of spread sheet attribute updates
	 * @param end the upper bound of the range of spread sheet attribute updates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of spread sheet attribute updates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpreadSheetAttributeUpdate> findAll(int start, int end,
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

		List<SpreadSheetAttributeUpdate> list = (List<SpreadSheetAttributeUpdate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPREADSHEETATTRIBUTEUPDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPREADSHEETATTRIBUTEUPDATE;

				if (pagination) {
					sql = sql.concat(SpreadSheetAttributeUpdateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SpreadSheetAttributeUpdate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpreadSheetAttributeUpdate>(list);
				}
				else {
					list = (List<SpreadSheetAttributeUpdate>)QueryUtil.list(q,
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
	 * Removes all the spread sheet attribute updates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SpreadSheetAttributeUpdate spreadSheetAttributeUpdate : findAll()) {
			remove(spreadSheetAttributeUpdate);
		}
	}

	/**
	 * Returns the number of spread sheet attribute updates.
	 *
	 * @return the number of spread sheet attribute updates
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

				Query q = session.createQuery(_SQL_COUNT_SPREADSHEETATTRIBUTEUPDATE);

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
	 * Initializes the spread sheet attribute update persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SpreadSheetAttributeUpdate>> listenersList = new ArrayList<ModelListener<SpreadSheetAttributeUpdate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SpreadSheetAttributeUpdate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SpreadSheetAttributeUpdateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPREADSHEETATTRIBUTEUPDATE = "SELECT spreadSheetAttributeUpdate FROM SpreadSheetAttributeUpdate spreadSheetAttributeUpdate";
	private static final String _SQL_SELECT_SPREADSHEETATTRIBUTEUPDATE_WHERE = "SELECT spreadSheetAttributeUpdate FROM SpreadSheetAttributeUpdate spreadSheetAttributeUpdate WHERE ";
	private static final String _SQL_COUNT_SPREADSHEETATTRIBUTEUPDATE = "SELECT COUNT(spreadSheetAttributeUpdate) FROM SpreadSheetAttributeUpdate spreadSheetAttributeUpdate";
	private static final String _SQL_COUNT_SPREADSHEETATTRIBUTEUPDATE_WHERE = "SELECT COUNT(spreadSheetAttributeUpdate) FROM SpreadSheetAttributeUpdate spreadSheetAttributeUpdate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "spreadSheetAttributeUpdate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SpreadSheetAttributeUpdate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SpreadSheetAttributeUpdate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SpreadSheetAttributeUpdatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"speardSheetId", "requestTitle", "status", "creatorId",
				"createdDate", "updatedBy", "updatedDate", "spreadSheet"
			});
	private static SpreadSheetAttributeUpdate _nullSpreadSheetAttributeUpdate = new SpreadSheetAttributeUpdateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SpreadSheetAttributeUpdate> toCacheModel() {
				return _nullSpreadSheetAttributeUpdateCacheModel;
			}
		};

	private static CacheModel<SpreadSheetAttributeUpdate> _nullSpreadSheetAttributeUpdateCacheModel =
		new CacheModel<SpreadSheetAttributeUpdate>() {
			@Override
			public SpreadSheetAttributeUpdate toEntityModel() {
				return _nullSpreadSheetAttributeUpdate;
			}
		};
}