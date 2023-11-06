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

import com.ihg.brandstandards.db.NoSuchPublishParmException;
import com.ihg.brandstandards.db.model.PublishParm;
import com.ihg.brandstandards.db.model.impl.PublishParmImpl;
import com.ihg.brandstandards.db.model.impl.PublishParmModelImpl;

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
 * The persistence implementation for the publish parm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishParmPersistence
 * @see PublishParmUtil
 * @generated
 */
public class PublishParmPersistenceImpl extends BasePersistenceImpl<PublishParm>
	implements PublishParmPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishParmUtil} to access the publish parm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishParmImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmModelImpl.FINDER_CACHE_ENABLED, PublishParmImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmModelImpl.FINDER_CACHE_ENABLED, PublishParmImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmModelImpl.FINDER_CACHE_ENABLED, PublishParmImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmModelImpl.FINDER_CACHE_ENABLED, PublishParmImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishId",
			new String[] { Long.class.getName() },
			PublishParmModelImpl.PUBLISHID_COLUMN_BITMASK |
			PublishParmModelImpl.PARMNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHID = new FinderPath(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the publish parms where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the matching publish parms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishParm> findByPublishId(long publishId)
		throws SystemException {
		return findByPublishId(publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the publish parms where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of publish parms
	 * @param end the upper bound of the range of publish parms (not inclusive)
	 * @return the range of matching publish parms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishParm> findByPublishId(long publishId, int start, int end)
		throws SystemException {
		return findByPublishId(publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish parms where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of publish parms
	 * @param end the upper bound of the range of publish parms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publish parms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishParm> findByPublishId(long publishId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID;
			finderArgs = new Object[] { publishId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID;
			finderArgs = new Object[] { publishId, start, end, orderByComparator };
		}

		List<PublishParm> list = (List<PublishParm>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishParm publishParm : list) {
				if ((publishId != publishParm.getPublishId())) {
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

			query.append(_SQL_SELECT_PUBLISHPARM_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishParmModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<PublishParm>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishParm>(list);
				}
				else {
					list = (List<PublishParm>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first publish parm in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish parm
	 * @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a matching publish parm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm findByPublishId_First(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishParmException, SystemException {
		PublishParm publishParm = fetchByPublishId_First(publishId,
				orderByComparator);

		if (publishParm != null) {
			return publishParm;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishParmException(msg.toString());
	}

	/**
	 * Returns the first publish parm in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish parm, or <code>null</code> if a matching publish parm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm fetchByPublishId_First(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishParm> list = findByPublishId(publishId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publish parm in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish parm
	 * @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a matching publish parm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm findByPublishId_Last(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishParmException, SystemException {
		PublishParm publishParm = fetchByPublishId_Last(publishId,
				orderByComparator);

		if (publishParm != null) {
			return publishParm;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishParmException(msg.toString());
	}

	/**
	 * Returns the last publish parm in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish parm, or <code>null</code> if a matching publish parm could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm fetchByPublishId_Last(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishId(publishId);

		if (count == 0) {
			return null;
		}

		List<PublishParm> list = findByPublishId(publishId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publish parms before and after the current publish parm in the ordered set where publishId = &#63;.
	 *
	 * @param publishParmId the primary key of the current publish parm
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publish parm
	 * @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm[] findByPublishId_PrevAndNext(long publishParmId,
		long publishId, OrderByComparator orderByComparator)
		throws NoSuchPublishParmException, SystemException {
		PublishParm publishParm = findByPrimaryKey(publishParmId);

		Session session = null;

		try {
			session = openSession();

			PublishParm[] array = new PublishParmImpl[3];

			array[0] = getByPublishId_PrevAndNext(session, publishParm,
					publishId, orderByComparator, true);

			array[1] = publishParm;

			array[2] = getByPublishId_PrevAndNext(session, publishParm,
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

	protected PublishParm getByPublishId_PrevAndNext(Session session,
		PublishParm publishParm, long publishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHPARM_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

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
			query.append(PublishParmModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishParm);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishParm> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publish parms where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishId(long publishId) throws SystemException {
		for (PublishParm publishParm : findByPublishId(publishId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishParm);
		}
	}

	/**
	 * Returns the number of publish parms where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching publish parms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishId(long publishId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHID;

		Object[] finderArgs = new Object[] { publishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHPARM_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

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

	private static final String _FINDER_COLUMN_PUBLISHID_PUBLISHID_2 = "publishParm.publishId = ?";

	public PublishParmPersistenceImpl() {
		setModelClass(PublishParm.class);
	}

	/**
	 * Caches the publish parm in the entity cache if it is enabled.
	 *
	 * @param publishParm the publish parm
	 */
	@Override
	public void cacheResult(PublishParm publishParm) {
		EntityCacheUtil.putResult(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmImpl.class, publishParm.getPrimaryKey(), publishParm);

		publishParm.resetOriginalValues();
	}

	/**
	 * Caches the publish parms in the entity cache if it is enabled.
	 *
	 * @param publishParms the publish parms
	 */
	@Override
	public void cacheResult(List<PublishParm> publishParms) {
		for (PublishParm publishParm : publishParms) {
			if (EntityCacheUtil.getResult(
						PublishParmModelImpl.ENTITY_CACHE_ENABLED,
						PublishParmImpl.class, publishParm.getPrimaryKey()) == null) {
				cacheResult(publishParm);
			}
			else {
				publishParm.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publish parms.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishParmImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishParmImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publish parm.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishParm publishParm) {
		EntityCacheUtil.removeResult(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmImpl.class, publishParm.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PublishParm> publishParms) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishParm publishParm : publishParms) {
			EntityCacheUtil.removeResult(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
				PublishParmImpl.class, publishParm.getPrimaryKey());
		}
	}

	/**
	 * Creates a new publish parm with the primary key. Does not add the publish parm to the database.
	 *
	 * @param publishParmId the primary key for the new publish parm
	 * @return the new publish parm
	 */
	@Override
	public PublishParm create(long publishParmId) {
		PublishParm publishParm = new PublishParmImpl();

		publishParm.setNew(true);
		publishParm.setPrimaryKey(publishParmId);

		return publishParm;
	}

	/**
	 * Removes the publish parm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishParmId the primary key of the publish parm
	 * @return the publish parm that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm remove(long publishParmId)
		throws NoSuchPublishParmException, SystemException {
		return remove((Serializable)publishParmId);
	}

	/**
	 * Removes the publish parm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publish parm
	 * @return the publish parm that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm remove(Serializable primaryKey)
		throws NoSuchPublishParmException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishParm publishParm = (PublishParm)session.get(PublishParmImpl.class,
					primaryKey);

			if (publishParm == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishParmException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishParm);
		}
		catch (NoSuchPublishParmException nsee) {
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
	protected PublishParm removeImpl(PublishParm publishParm)
		throws SystemException {
		publishParm = toUnwrappedModel(publishParm);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishParm)) {
				publishParm = (PublishParm)session.get(PublishParmImpl.class,
						publishParm.getPrimaryKeyObj());
			}

			if (publishParm != null) {
				session.delete(publishParm);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishParm != null) {
			clearCache(publishParm);
		}

		return publishParm;
	}

	@Override
	public PublishParm updateImpl(
		com.ihg.brandstandards.db.model.PublishParm publishParm)
		throws SystemException {
		publishParm = toUnwrappedModel(publishParm);

		boolean isNew = publishParm.isNew();

		PublishParmModelImpl publishParmModelImpl = (PublishParmModelImpl)publishParm;

		Session session = null;

		try {
			session = openSession();

			if (publishParm.isNew()) {
				session.save(publishParm);

				publishParm.setNew(false);
			}
			else {
				session.merge(publishParm);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublishParmModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((publishParmModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishParmModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);

				args = new Object[] { publishParmModelImpl.getPublishId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);
			}
		}

		EntityCacheUtil.putResult(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
			PublishParmImpl.class, publishParm.getPrimaryKey(), publishParm);

		return publishParm;
	}

	protected PublishParm toUnwrappedModel(PublishParm publishParm) {
		if (publishParm instanceof PublishParmImpl) {
			return publishParm;
		}

		PublishParmImpl publishParmImpl = new PublishParmImpl();

		publishParmImpl.setNew(publishParm.isNew());
		publishParmImpl.setPrimaryKey(publishParm.getPrimaryKey());

		publishParmImpl.setPublishParmId(publishParm.getPublishParmId());
		publishParmImpl.setPublishId(publishParm.getPublishId());
		publishParmImpl.setParmName(publishParm.getParmName());
		publishParmImpl.setParmValue(publishParm.getParmValue());
		publishParmImpl.setCreatorId(publishParm.getCreatorId());
		publishParmImpl.setCreatedDate(publishParm.getCreatedDate());
		publishParmImpl.setUpdatedBy(publishParm.getUpdatedBy());
		publishParmImpl.setUpdatedDate(publishParm.getUpdatedDate());

		return publishParmImpl;
	}

	/**
	 * Returns the publish parm with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish parm
	 * @return the publish parm
	 * @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishParmException, SystemException {
		PublishParm publishParm = fetchByPrimaryKey(primaryKey);

		if (publishParm == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishParmException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishParm;
	}

	/**
	 * Returns the publish parm with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishParmException} if it could not be found.
	 *
	 * @param publishParmId the primary key of the publish parm
	 * @return the publish parm
	 * @throws com.ihg.brandstandards.db.NoSuchPublishParmException if a publish parm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm findByPrimaryKey(long publishParmId)
		throws NoSuchPublishParmException, SystemException {
		return findByPrimaryKey((Serializable)publishParmId);
	}

	/**
	 * Returns the publish parm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish parm
	 * @return the publish parm, or <code>null</code> if a publish parm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishParm publishParm = (PublishParm)EntityCacheUtil.getResult(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
				PublishParmImpl.class, primaryKey);

		if (publishParm == _nullPublishParm) {
			return null;
		}

		if (publishParm == null) {
			Session session = null;

			try {
				session = openSession();

				publishParm = (PublishParm)session.get(PublishParmImpl.class,
						primaryKey);

				if (publishParm != null) {
					cacheResult(publishParm);
				}
				else {
					EntityCacheUtil.putResult(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
						PublishParmImpl.class, primaryKey, _nullPublishParm);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishParmModelImpl.ENTITY_CACHE_ENABLED,
					PublishParmImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishParm;
	}

	/**
	 * Returns the publish parm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishParmId the primary key of the publish parm
	 * @return the publish parm, or <code>null</code> if a publish parm with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishParm fetchByPrimaryKey(long publishParmId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishParmId);
	}

	/**
	 * Returns all the publish parms.
	 *
	 * @return the publish parms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishParm> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publish parms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish parms
	 * @param end the upper bound of the range of publish parms (not inclusive)
	 * @return the range of publish parms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishParm> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish parms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishParmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish parms
	 * @param end the upper bound of the range of publish parms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publish parms
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishParm> findAll(int start, int end,
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

		List<PublishParm> list = (List<PublishParm>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHPARM);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHPARM;

				if (pagination) {
					sql = sql.concat(PublishParmModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishParm>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishParm>(list);
				}
				else {
					list = (List<PublishParm>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the publish parms from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishParm publishParm : findAll()) {
			remove(publishParm);
		}
	}

	/**
	 * Returns the number of publish parms.
	 *
	 * @return the number of publish parms
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHPARM);

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
	 * Initializes the publish parm persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishParm")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishParm>> listenersList = new ArrayList<ModelListener<PublishParm>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishParm>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublishParmImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHPARM = "SELECT publishParm FROM PublishParm publishParm";
	private static final String _SQL_SELECT_PUBLISHPARM_WHERE = "SELECT publishParm FROM PublishParm publishParm WHERE ";
	private static final String _SQL_COUNT_PUBLISHPARM = "SELECT COUNT(publishParm) FROM PublishParm publishParm";
	private static final String _SQL_COUNT_PUBLISHPARM_WHERE = "SELECT COUNT(publishParm) FROM PublishParm publishParm WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishParm.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishParm exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PublishParm exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishParmPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishParmId", "publishId", "parmName", "parmValue",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static PublishParm _nullPublishParm = new PublishParmImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishParm> toCacheModel() {
				return _nullPublishParmCacheModel;
			}
		};

	private static CacheModel<PublishParm> _nullPublishParmCacheModel = new CacheModel<PublishParm>() {
			@Override
			public PublishParm toEntityModel() {
				return _nullPublishParm;
			}
		};
}