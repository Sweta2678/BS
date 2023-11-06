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

import com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsImpl;
import com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl;

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
 * The persistence implementation for the chain external link standards service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see ChainExternalLinkStandardsPersistence
 * @see ChainExternalLinkStandardsUtil
 * @generated
 */
public class ChainExternalLinkStandardsPersistenceImpl
	extends BasePersistenceImpl<ChainExternalLinkStandards>
	implements ChainExternalLinkStandardsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ChainExternalLinkStandardsUtil} to access the chain external link standards persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ChainExternalLinkStandardsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LINKID = new FinderPath(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLinkId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKID =
		new FinderPath(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			ChainExternalLinkStandardsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLinkId",
			new String[] { Long.class.getName() },
			ChainExternalLinkStandardsModelImpl.EXTLINKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LINKID = new FinderPath(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByLinkId", new String[] { Long.class.getName() });

	/**
	 * Returns all the chain external link standardses where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @return the matching chain external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainExternalLinkStandards> findByLinkId(long extLinkId)
		throws SystemException {
		return findByLinkId(extLinkId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the chain external link standardses where extLinkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extLinkId the ext link ID
	 * @param start the lower bound of the range of chain external link standardses
	 * @param end the upper bound of the range of chain external link standardses (not inclusive)
	 * @return the range of matching chain external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainExternalLinkStandards> findByLinkId(long extLinkId,
		int start, int end) throws SystemException {
		return findByLinkId(extLinkId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chain external link standardses where extLinkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param extLinkId the ext link ID
	 * @param start the lower bound of the range of chain external link standardses
	 * @param end the upper bound of the range of chain external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chain external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainExternalLinkStandards> findByLinkId(long extLinkId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKID;
			finderArgs = new Object[] { extLinkId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LINKID;
			finderArgs = new Object[] { extLinkId, start, end, orderByComparator };
		}

		List<ChainExternalLinkStandards> list = (List<ChainExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ChainExternalLinkStandards chainExternalLinkStandards : list) {
				if ((extLinkId != chainExternalLinkStandards.getExtLinkId())) {
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

			query.append(_SQL_SELECT_CHAINEXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_LINKID_EXTLINKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ChainExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(extLinkId);

				if (!pagination) {
					list = (List<ChainExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChainExternalLinkStandards>(list);
				}
				else {
					list = (List<ChainExternalLinkStandards>)QueryUtil.list(q,
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
	 * Returns the first chain external link standards in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a matching chain external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards findByLinkId_First(long extLinkId,
		OrderByComparator orderByComparator)
		throws NoSuchChainExternalLinkStandardsException, SystemException {
		ChainExternalLinkStandards chainExternalLinkStandards = fetchByLinkId_First(extLinkId,
				orderByComparator);

		if (chainExternalLinkStandards != null) {
			return chainExternalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extLinkId=");
		msg.append(extLinkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the first chain external link standards in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chain external link standards, or <code>null</code> if a matching chain external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards fetchByLinkId_First(long extLinkId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ChainExternalLinkStandards> list = findByLinkId(extLinkId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chain external link standards in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a matching chain external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards findByLinkId_Last(long extLinkId,
		OrderByComparator orderByComparator)
		throws NoSuchChainExternalLinkStandardsException, SystemException {
		ChainExternalLinkStandards chainExternalLinkStandards = fetchByLinkId_Last(extLinkId,
				orderByComparator);

		if (chainExternalLinkStandards != null) {
			return chainExternalLinkStandards;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("extLinkId=");
		msg.append(extLinkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchChainExternalLinkStandardsException(msg.toString());
	}

	/**
	 * Returns the last chain external link standards in the ordered set where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chain external link standards, or <code>null</code> if a matching chain external link standards could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards fetchByLinkId_Last(long extLinkId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLinkId(extLinkId);

		if (count == 0) {
			return null;
		}

		List<ChainExternalLinkStandards> list = findByLinkId(extLinkId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chain external link standardses before and after the current chain external link standards in the ordered set where extLinkId = &#63;.
	 *
	 * @param chainExternalLinkStandardsPK the primary key of the current chain external link standards
	 * @param extLinkId the ext link ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chain external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards[] findByLinkId_PrevAndNext(
		ChainExternalLinkStandardsPK chainExternalLinkStandardsPK,
		long extLinkId, OrderByComparator orderByComparator)
		throws NoSuchChainExternalLinkStandardsException, SystemException {
		ChainExternalLinkStandards chainExternalLinkStandards = findByPrimaryKey(chainExternalLinkStandardsPK);

		Session session = null;

		try {
			session = openSession();

			ChainExternalLinkStandards[] array = new ChainExternalLinkStandardsImpl[3];

			array[0] = getByLinkId_PrevAndNext(session,
					chainExternalLinkStandards, extLinkId, orderByComparator,
					true);

			array[1] = chainExternalLinkStandards;

			array[2] = getByLinkId_PrevAndNext(session,
					chainExternalLinkStandards, extLinkId, orderByComparator,
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

	protected ChainExternalLinkStandards getByLinkId_PrevAndNext(
		Session session, ChainExternalLinkStandards chainExternalLinkStandards,
		long extLinkId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CHAINEXTERNALLINKSTANDARDS_WHERE);

		query.append(_FINDER_COLUMN_LINKID_EXTLINKID_2);

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
			query.append(ChainExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(extLinkId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(chainExternalLinkStandards);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ChainExternalLinkStandards> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chain external link standardses where extLinkId = &#63; from the database.
	 *
	 * @param extLinkId the ext link ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLinkId(long extLinkId) throws SystemException {
		for (ChainExternalLinkStandards chainExternalLinkStandards : findByLinkId(
				extLinkId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(chainExternalLinkStandards);
		}
	}

	/**
	 * Returns the number of chain external link standardses where extLinkId = &#63;.
	 *
	 * @param extLinkId the ext link ID
	 * @return the number of matching chain external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLinkId(long extLinkId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LINKID;

		Object[] finderArgs = new Object[] { extLinkId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CHAINEXTERNALLINKSTANDARDS_WHERE);

			query.append(_FINDER_COLUMN_LINKID_EXTLINKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(extLinkId);

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

	private static final String _FINDER_COLUMN_LINKID_EXTLINKID_2 = "chainExternalLinkStandards.id.extLinkId = ?";

	public ChainExternalLinkStandardsPersistenceImpl() {
		setModelClass(ChainExternalLinkStandards.class);
	}

	/**
	 * Caches the chain external link standards in the entity cache if it is enabled.
	 *
	 * @param chainExternalLinkStandards the chain external link standards
	 */
	@Override
	public void cacheResult(
		ChainExternalLinkStandards chainExternalLinkStandards) {
		EntityCacheUtil.putResult(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsImpl.class,
			chainExternalLinkStandards.getPrimaryKey(),
			chainExternalLinkStandards);

		chainExternalLinkStandards.resetOriginalValues();
	}

	/**
	 * Caches the chain external link standardses in the entity cache if it is enabled.
	 *
	 * @param chainExternalLinkStandardses the chain external link standardses
	 */
	@Override
	public void cacheResult(
		List<ChainExternalLinkStandards> chainExternalLinkStandardses) {
		for (ChainExternalLinkStandards chainExternalLinkStandards : chainExternalLinkStandardses) {
			if (EntityCacheUtil.getResult(
						ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ChainExternalLinkStandardsImpl.class,
						chainExternalLinkStandards.getPrimaryKey()) == null) {
				cacheResult(chainExternalLinkStandards);
			}
			else {
				chainExternalLinkStandards.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all chain external link standardses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ChainExternalLinkStandardsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ChainExternalLinkStandardsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chain external link standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ChainExternalLinkStandards chainExternalLinkStandards) {
		EntityCacheUtil.removeResult(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsImpl.class,
			chainExternalLinkStandards.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ChainExternalLinkStandards> chainExternalLinkStandardses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ChainExternalLinkStandards chainExternalLinkStandards : chainExternalLinkStandardses) {
			EntityCacheUtil.removeResult(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ChainExternalLinkStandardsImpl.class,
				chainExternalLinkStandards.getPrimaryKey());
		}
	}

	/**
	 * Creates a new chain external link standards with the primary key. Does not add the chain external link standards to the database.
	 *
	 * @param chainExternalLinkStandardsPK the primary key for the new chain external link standards
	 * @return the new chain external link standards
	 */
	@Override
	public ChainExternalLinkStandards create(
		ChainExternalLinkStandardsPK chainExternalLinkStandardsPK) {
		ChainExternalLinkStandards chainExternalLinkStandards = new ChainExternalLinkStandardsImpl();

		chainExternalLinkStandards.setNew(true);
		chainExternalLinkStandards.setPrimaryKey(chainExternalLinkStandardsPK);

		return chainExternalLinkStandards;
	}

	/**
	 * Removes the chain external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	 * @return the chain external link standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards remove(
		ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws NoSuchChainExternalLinkStandardsException, SystemException {
		return remove((Serializable)chainExternalLinkStandardsPK);
	}

	/**
	 * Removes the chain external link standards with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chain external link standards
	 * @return the chain external link standards that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards remove(Serializable primaryKey)
		throws NoSuchChainExternalLinkStandardsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ChainExternalLinkStandards chainExternalLinkStandards = (ChainExternalLinkStandards)session.get(ChainExternalLinkStandardsImpl.class,
					primaryKey);

			if (chainExternalLinkStandards == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChainExternalLinkStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(chainExternalLinkStandards);
		}
		catch (NoSuchChainExternalLinkStandardsException nsee) {
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
	protected ChainExternalLinkStandards removeImpl(
		ChainExternalLinkStandards chainExternalLinkStandards)
		throws SystemException {
		chainExternalLinkStandards = toUnwrappedModel(chainExternalLinkStandards);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chainExternalLinkStandards)) {
				chainExternalLinkStandards = (ChainExternalLinkStandards)session.get(ChainExternalLinkStandardsImpl.class,
						chainExternalLinkStandards.getPrimaryKeyObj());
			}

			if (chainExternalLinkStandards != null) {
				session.delete(chainExternalLinkStandards);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (chainExternalLinkStandards != null) {
			clearCache(chainExternalLinkStandards);
		}

		return chainExternalLinkStandards;
	}

	@Override
	public ChainExternalLinkStandards updateImpl(
		com.ihg.brandstandards.db.model.ChainExternalLinkStandards chainExternalLinkStandards)
		throws SystemException {
		chainExternalLinkStandards = toUnwrappedModel(chainExternalLinkStandards);

		boolean isNew = chainExternalLinkStandards.isNew();

		ChainExternalLinkStandardsModelImpl chainExternalLinkStandardsModelImpl = (ChainExternalLinkStandardsModelImpl)chainExternalLinkStandards;

		Session session = null;

		try {
			session = openSession();

			if (chainExternalLinkStandards.isNew()) {
				session.save(chainExternalLinkStandards);

				chainExternalLinkStandards.setNew(false);
			}
			else {
				session.merge(chainExternalLinkStandards);
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
				!ChainExternalLinkStandardsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((chainExternalLinkStandardsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						chainExternalLinkStandardsModelImpl.getOriginalExtLinkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LINKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKID,
					args);

				args = new Object[] {
						chainExternalLinkStandardsModelImpl.getExtLinkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LINKID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LINKID,
					args);
			}
		}

		EntityCacheUtil.putResult(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
			ChainExternalLinkStandardsImpl.class,
			chainExternalLinkStandards.getPrimaryKey(),
			chainExternalLinkStandards);

		return chainExternalLinkStandards;
	}

	protected ChainExternalLinkStandards toUnwrappedModel(
		ChainExternalLinkStandards chainExternalLinkStandards) {
		if (chainExternalLinkStandards instanceof ChainExternalLinkStandardsImpl) {
			return chainExternalLinkStandards;
		}

		ChainExternalLinkStandardsImpl chainExternalLinkStandardsImpl = new ChainExternalLinkStandardsImpl();

		chainExternalLinkStandardsImpl.setNew(chainExternalLinkStandards.isNew());
		chainExternalLinkStandardsImpl.setPrimaryKey(chainExternalLinkStandards.getPrimaryKey());

		chainExternalLinkStandardsImpl.setExtLinkId(chainExternalLinkStandards.getExtLinkId());
		chainExternalLinkStandardsImpl.setChainCode(chainExternalLinkStandards.getChainCode());
		chainExternalLinkStandardsImpl.setCreatorId(chainExternalLinkStandards.getCreatorId());
		chainExternalLinkStandardsImpl.setCreatedDate(chainExternalLinkStandards.getCreatedDate());
		chainExternalLinkStandardsImpl.setUpdatedBy(chainExternalLinkStandards.getUpdatedBy());
		chainExternalLinkStandardsImpl.setUpdatedDate(chainExternalLinkStandards.getUpdatedDate());

		return chainExternalLinkStandardsImpl;
	}

	/**
	 * Returns the chain external link standards with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the chain external link standards
	 * @return the chain external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChainExternalLinkStandardsException, SystemException {
		ChainExternalLinkStandards chainExternalLinkStandards = fetchByPrimaryKey(primaryKey);

		if (chainExternalLinkStandards == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChainExternalLinkStandardsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return chainExternalLinkStandards;
	}

	/**
	 * Returns the chain external link standards with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException} if it could not be found.
	 *
	 * @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	 * @return the chain external link standards
	 * @throws com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException if a chain external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards findByPrimaryKey(
		ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws NoSuchChainExternalLinkStandardsException, SystemException {
		return findByPrimaryKey((Serializable)chainExternalLinkStandardsPK);
	}

	/**
	 * Returns the chain external link standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chain external link standards
	 * @return the chain external link standards, or <code>null</code> if a chain external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ChainExternalLinkStandards chainExternalLinkStandards = (ChainExternalLinkStandards)EntityCacheUtil.getResult(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
				ChainExternalLinkStandardsImpl.class, primaryKey);

		if (chainExternalLinkStandards == _nullChainExternalLinkStandards) {
			return null;
		}

		if (chainExternalLinkStandards == null) {
			Session session = null;

			try {
				session = openSession();

				chainExternalLinkStandards = (ChainExternalLinkStandards)session.get(ChainExternalLinkStandardsImpl.class,
						primaryKey);

				if (chainExternalLinkStandards != null) {
					cacheResult(chainExternalLinkStandards);
				}
				else {
					EntityCacheUtil.putResult(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
						ChainExternalLinkStandardsImpl.class, primaryKey,
						_nullChainExternalLinkStandards);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ChainExternalLinkStandardsModelImpl.ENTITY_CACHE_ENABLED,
					ChainExternalLinkStandardsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return chainExternalLinkStandards;
	}

	/**
	 * Returns the chain external link standards with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chainExternalLinkStandardsPK the primary key of the chain external link standards
	 * @return the chain external link standards, or <code>null</code> if a chain external link standards with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ChainExternalLinkStandards fetchByPrimaryKey(
		ChainExternalLinkStandardsPK chainExternalLinkStandardsPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)chainExternalLinkStandardsPK);
	}

	/**
	 * Returns all the chain external link standardses.
	 *
	 * @return the chain external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainExternalLinkStandards> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chain external link standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chain external link standardses
	 * @param end the upper bound of the range of chain external link standardses (not inclusive)
	 * @return the range of chain external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainExternalLinkStandards> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chain external link standardses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of chain external link standardses
	 * @param end the upper bound of the range of chain external link standardses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chain external link standardses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ChainExternalLinkStandards> findAll(int start, int end,
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

		List<ChainExternalLinkStandards> list = (List<ChainExternalLinkStandards>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CHAINEXTERNALLINKSTANDARDS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CHAINEXTERNALLINKSTANDARDS;

				if (pagination) {
					sql = sql.concat(ChainExternalLinkStandardsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ChainExternalLinkStandards>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ChainExternalLinkStandards>(list);
				}
				else {
					list = (List<ChainExternalLinkStandards>)QueryUtil.list(q,
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
	 * Removes all the chain external link standardses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ChainExternalLinkStandards chainExternalLinkStandards : findAll()) {
			remove(chainExternalLinkStandards);
		}
	}

	/**
	 * Returns the number of chain external link standardses.
	 *
	 * @return the number of chain external link standardses
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

				Query q = session.createQuery(_SQL_COUNT_CHAINEXTERNALLINKSTANDARDS);

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
	 * Initializes the chain external link standards persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.ChainExternalLinkStandards")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ChainExternalLinkStandards>> listenersList = new ArrayList<ModelListener<ChainExternalLinkStandards>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ChainExternalLinkStandards>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ChainExternalLinkStandardsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CHAINEXTERNALLINKSTANDARDS = "SELECT chainExternalLinkStandards FROM ChainExternalLinkStandards chainExternalLinkStandards";
	private static final String _SQL_SELECT_CHAINEXTERNALLINKSTANDARDS_WHERE = "SELECT chainExternalLinkStandards FROM ChainExternalLinkStandards chainExternalLinkStandards WHERE ";
	private static final String _SQL_COUNT_CHAINEXTERNALLINKSTANDARDS = "SELECT COUNT(chainExternalLinkStandards) FROM ChainExternalLinkStandards chainExternalLinkStandards";
	private static final String _SQL_COUNT_CHAINEXTERNALLINKSTANDARDS_WHERE = "SELECT COUNT(chainExternalLinkStandards) FROM ChainExternalLinkStandards chainExternalLinkStandards WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "chainExternalLinkStandards.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ChainExternalLinkStandards exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ChainExternalLinkStandards exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ChainExternalLinkStandardsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"extLinkId", "chainCode", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static ChainExternalLinkStandards _nullChainExternalLinkStandards = new ChainExternalLinkStandardsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ChainExternalLinkStandards> toCacheModel() {
				return _nullChainExternalLinkStandardsCacheModel;
			}
		};

	private static CacheModel<ChainExternalLinkStandards> _nullChainExternalLinkStandardsCacheModel =
		new CacheModel<ChainExternalLinkStandards>() {
			@Override
			public ChainExternalLinkStandards toEntityModel() {
				return _nullChainExternalLinkStandards;
			}
		};
}