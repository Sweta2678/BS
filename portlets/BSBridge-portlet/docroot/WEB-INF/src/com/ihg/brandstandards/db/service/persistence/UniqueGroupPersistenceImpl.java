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

import com.ihg.brandstandards.db.NoSuchUniqueGroupException;
import com.ihg.brandstandards.db.model.UniqueGroup;
import com.ihg.brandstandards.db.model.impl.UniqueGroupImpl;
import com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl;

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
 * The persistence implementation for the unique group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroupPersistence
 * @see UniqueGroupUtil
 * @generated
 */
public class UniqueGroupPersistenceImpl extends BasePersistenceImpl<UniqueGroup>
	implements UniqueGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UniqueGroupUtil} to access the unique group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UniqueGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupModelImpl.FINDER_CACHE_ENABLED, UniqueGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupModelImpl.FINDER_CACHE_ENABLED, UniqueGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONANDREGION =
		new FinderPath(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupModelImpl.FINDER_CACHE_ENABLED, UniqueGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypublicationAndRegion",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION =
		new FinderPath(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupModelImpl.FINDER_CACHE_ENABLED, UniqueGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypublicationAndRegion",
			new String[] { Long.class.getName(), Long.class.getName() },
			UniqueGroupModelImpl.PUBLISHID_COLUMN_BITMASK |
			UniqueGroupModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLICATIONANDREGION = new FinderPath(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublicationAndRegion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the matching unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroup> findBypublicationAndRegion(long publishId,
		long regionId) throws SystemException {
		return findBypublicationAndRegion(publishId, regionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of unique groups
	 * @param end the upper bound of the range of unique groups (not inclusive)
	 * @return the range of matching unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroup> findBypublicationAndRegion(long publishId,
		long regionId, int start, int end) throws SystemException {
		return findBypublicationAndRegion(publishId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of unique groups
	 * @param end the upper bound of the range of unique groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroup> findBypublicationAndRegion(long publishId,
		long regionId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION;
			finderArgs = new Object[] { publishId, regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONANDREGION;
			finderArgs = new Object[] {
					publishId, regionId,
					
					start, end, orderByComparator
				};
		}

		List<UniqueGroup> list = (List<UniqueGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UniqueGroup uniqueGroup : list) {
				if ((publishId != uniqueGroup.getPublishId()) ||
						(regionId != uniqueGroup.getRegionId())) {
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

			query.append(_SQL_SELECT_UNIQUEGROUP_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UniqueGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<UniqueGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UniqueGroup>(list);
				}
				else {
					list = (List<UniqueGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unique group
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a matching unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup findBypublicationAndRegion_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchUniqueGroupException, SystemException {
		UniqueGroup uniqueGroup = fetchBypublicationAndRegion_First(publishId,
				regionId, orderByComparator);

		if (uniqueGroup != null) {
			return uniqueGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUniqueGroupException(msg.toString());
	}

	/**
	 * Returns the first unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unique group, or <code>null</code> if a matching unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup fetchBypublicationAndRegion_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<UniqueGroup> list = findBypublicationAndRegion(publishId,
				regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unique group
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a matching unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup findBypublicationAndRegion_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchUniqueGroupException, SystemException {
		UniqueGroup uniqueGroup = fetchBypublicationAndRegion_Last(publishId,
				regionId, orderByComparator);

		if (uniqueGroup != null) {
			return uniqueGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUniqueGroupException(msg.toString());
	}

	/**
	 * Returns the last unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unique group, or <code>null</code> if a matching unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup fetchBypublicationAndRegion_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBypublicationAndRegion(publishId, regionId);

		if (count == 0) {
			return null;
		}

		List<UniqueGroup> list = findBypublicationAndRegion(publishId,
				regionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the unique groups before and after the current unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param uniqueGroupId the primary key of the current unique group
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next unique group
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup[] findBypublicationAndRegion_PrevAndNext(
		long uniqueGroupId, long publishId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchUniqueGroupException, SystemException {
		UniqueGroup uniqueGroup = findByPrimaryKey(uniqueGroupId);

		Session session = null;

		try {
			session = openSession();

			UniqueGroup[] array = new UniqueGroupImpl[3];

			array[0] = getBypublicationAndRegion_PrevAndNext(session,
					uniqueGroup, publishId, regionId, orderByComparator, true);

			array[1] = uniqueGroup;

			array[2] = getBypublicationAndRegion_PrevAndNext(session,
					uniqueGroup, publishId, regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UniqueGroup getBypublicationAndRegion_PrevAndNext(
		Session session, UniqueGroup uniqueGroup, long publishId,
		long regionId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UNIQUEGROUP_WHERE);

		query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_REGIONID_2);

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
			query.append(UniqueGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(uniqueGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UniqueGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the unique groups where publishId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypublicationAndRegion(long publishId, long regionId)
		throws SystemException {
		for (UniqueGroup uniqueGroup : findBypublicationAndRegion(publishId,
				regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(uniqueGroup);
		}
	}

	/**
	 * Returns the number of unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the number of matching unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublicationAndRegion(long publishId, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLICATIONANDREGION;

		Object[] finderArgs = new Object[] { publishId, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_UNIQUEGROUP_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

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

	private static final String _FINDER_COLUMN_PUBLICATIONANDREGION_PUBLISHID_2 = "uniqueGroup.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONANDREGION_REGIONID_2 = "uniqueGroup.regionId = ?";

	public UniqueGroupPersistenceImpl() {
		setModelClass(UniqueGroup.class);
	}

	/**
	 * Caches the unique group in the entity cache if it is enabled.
	 *
	 * @param uniqueGroup the unique group
	 */
	@Override
	public void cacheResult(UniqueGroup uniqueGroup) {
		EntityCacheUtil.putResult(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupImpl.class, uniqueGroup.getPrimaryKey(), uniqueGroup);

		uniqueGroup.resetOriginalValues();
	}

	/**
	 * Caches the unique groups in the entity cache if it is enabled.
	 *
	 * @param uniqueGroups the unique groups
	 */
	@Override
	public void cacheResult(List<UniqueGroup> uniqueGroups) {
		for (UniqueGroup uniqueGroup : uniqueGroups) {
			if (EntityCacheUtil.getResult(
						UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
						UniqueGroupImpl.class, uniqueGroup.getPrimaryKey()) == null) {
				cacheResult(uniqueGroup);
			}
			else {
				uniqueGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all unique groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UniqueGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UniqueGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the unique group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UniqueGroup uniqueGroup) {
		EntityCacheUtil.removeResult(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupImpl.class, uniqueGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UniqueGroup> uniqueGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UniqueGroup uniqueGroup : uniqueGroups) {
			EntityCacheUtil.removeResult(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
				UniqueGroupImpl.class, uniqueGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new unique group with the primary key. Does not add the unique group to the database.
	 *
	 * @param uniqueGroupId the primary key for the new unique group
	 * @return the new unique group
	 */
	@Override
	public UniqueGroup create(long uniqueGroupId) {
		UniqueGroup uniqueGroup = new UniqueGroupImpl();

		uniqueGroup.setNew(true);
		uniqueGroup.setPrimaryKey(uniqueGroupId);

		return uniqueGroup;
	}

	/**
	 * Removes the unique group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uniqueGroupId the primary key of the unique group
	 * @return the unique group that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup remove(long uniqueGroupId)
		throws NoSuchUniqueGroupException, SystemException {
		return remove((Serializable)uniqueGroupId);
	}

	/**
	 * Removes the unique group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the unique group
	 * @return the unique group that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup remove(Serializable primaryKey)
		throws NoSuchUniqueGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UniqueGroup uniqueGroup = (UniqueGroup)session.get(UniqueGroupImpl.class,
					primaryKey);

			if (uniqueGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUniqueGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(uniqueGroup);
		}
		catch (NoSuchUniqueGroupException nsee) {
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
	protected UniqueGroup removeImpl(UniqueGroup uniqueGroup)
		throws SystemException {
		uniqueGroup = toUnwrappedModel(uniqueGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(uniqueGroup)) {
				uniqueGroup = (UniqueGroup)session.get(UniqueGroupImpl.class,
						uniqueGroup.getPrimaryKeyObj());
			}

			if (uniqueGroup != null) {
				session.delete(uniqueGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (uniqueGroup != null) {
			clearCache(uniqueGroup);
		}

		return uniqueGroup;
	}

	@Override
	public UniqueGroup updateImpl(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup)
		throws SystemException {
		uniqueGroup = toUnwrappedModel(uniqueGroup);

		boolean isNew = uniqueGroup.isNew();

		UniqueGroupModelImpl uniqueGroupModelImpl = (UniqueGroupModelImpl)uniqueGroup;

		Session session = null;

		try {
			session = openSession();

			if (uniqueGroup.isNew()) {
				session.save(uniqueGroup);

				uniqueGroup.setNew(false);
			}
			else {
				session.merge(uniqueGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UniqueGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((uniqueGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						uniqueGroupModelImpl.getOriginalPublishId(),
						uniqueGroupModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONANDREGION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION,
					args);

				args = new Object[] {
						uniqueGroupModelImpl.getPublishId(),
						uniqueGroupModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONANDREGION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION,
					args);
			}
		}

		EntityCacheUtil.putResult(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupImpl.class, uniqueGroup.getPrimaryKey(), uniqueGroup);

		return uniqueGroup;
	}

	protected UniqueGroup toUnwrappedModel(UniqueGroup uniqueGroup) {
		if (uniqueGroup instanceof UniqueGroupImpl) {
			return uniqueGroup;
		}

		UniqueGroupImpl uniqueGroupImpl = new UniqueGroupImpl();

		uniqueGroupImpl.setNew(uniqueGroup.isNew());
		uniqueGroupImpl.setPrimaryKey(uniqueGroup.getPrimaryKey());

		uniqueGroupImpl.setUniqueGroupId(uniqueGroup.getUniqueGroupId());
		uniqueGroupImpl.setPublishId(uniqueGroup.getPublishId());
		uniqueGroupImpl.setGroupName(uniqueGroup.getGroupName());
		uniqueGroupImpl.setRegionId(uniqueGroup.getRegionId());
		uniqueGroupImpl.setGroupType(uniqueGroup.getGroupType());
		uniqueGroupImpl.setCreatorId(uniqueGroup.getCreatorId());
		uniqueGroupImpl.setCreatedDate(uniqueGroup.getCreatedDate());
		uniqueGroupImpl.setUpdatedBy(uniqueGroup.getUpdatedBy());
		uniqueGroupImpl.setUpdatedDate(uniqueGroup.getUpdatedDate());

		return uniqueGroupImpl;
	}

	/**
	 * Returns the unique group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the unique group
	 * @return the unique group
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUniqueGroupException, SystemException {
		UniqueGroup uniqueGroup = fetchByPrimaryKey(primaryKey);

		if (uniqueGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUniqueGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return uniqueGroup;
	}

	/**
	 * Returns the unique group with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUniqueGroupException} if it could not be found.
	 *
	 * @param uniqueGroupId the primary key of the unique group
	 * @return the unique group
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupException if a unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup findByPrimaryKey(long uniqueGroupId)
		throws NoSuchUniqueGroupException, SystemException {
		return findByPrimaryKey((Serializable)uniqueGroupId);
	}

	/**
	 * Returns the unique group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the unique group
	 * @return the unique group, or <code>null</code> if a unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UniqueGroup uniqueGroup = (UniqueGroup)EntityCacheUtil.getResult(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
				UniqueGroupImpl.class, primaryKey);

		if (uniqueGroup == _nullUniqueGroup) {
			return null;
		}

		if (uniqueGroup == null) {
			Session session = null;

			try {
				session = openSession();

				uniqueGroup = (UniqueGroup)session.get(UniqueGroupImpl.class,
						primaryKey);

				if (uniqueGroup != null) {
					cacheResult(uniqueGroup);
				}
				else {
					EntityCacheUtil.putResult(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
						UniqueGroupImpl.class, primaryKey, _nullUniqueGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
					UniqueGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return uniqueGroup;
	}

	/**
	 * Returns the unique group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uniqueGroupId the primary key of the unique group
	 * @return the unique group, or <code>null</code> if a unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroup fetchByPrimaryKey(long uniqueGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)uniqueGroupId);
	}

	/**
	 * Returns all the unique groups.
	 *
	 * @return the unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the unique groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unique groups
	 * @param end the upper bound of the range of unique groups (not inclusive)
	 * @return the range of unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the unique groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unique groups
	 * @param end the upper bound of the range of unique groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroup> findAll(int start, int end,
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

		List<UniqueGroup> list = (List<UniqueGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UNIQUEGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNIQUEGROUP;

				if (pagination) {
					sql = sql.concat(UniqueGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UniqueGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UniqueGroup>(list);
				}
				else {
					list = (List<UniqueGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the unique groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UniqueGroup uniqueGroup : findAll()) {
			remove(uniqueGroup);
		}
	}

	/**
	 * Returns the number of unique groups.
	 *
	 * @return the number of unique groups
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

				Query q = session.createQuery(_SQL_COUNT_UNIQUEGROUP);

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
	 * Initializes the unique group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.UniqueGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UniqueGroup>> listenersList = new ArrayList<ModelListener<UniqueGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UniqueGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UniqueGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UNIQUEGROUP = "SELECT uniqueGroup FROM UniqueGroup uniqueGroup";
	private static final String _SQL_SELECT_UNIQUEGROUP_WHERE = "SELECT uniqueGroup FROM UniqueGroup uniqueGroup WHERE ";
	private static final String _SQL_COUNT_UNIQUEGROUP = "SELECT COUNT(uniqueGroup) FROM UniqueGroup uniqueGroup";
	private static final String _SQL_COUNT_UNIQUEGROUP_WHERE = "SELECT COUNT(uniqueGroup) FROM UniqueGroup uniqueGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "uniqueGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UniqueGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UniqueGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UniqueGroupPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uniqueGroupId", "publishId", "groupName", "regionId",
				"groupType", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static UniqueGroup _nullUniqueGroup = new UniqueGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UniqueGroup> toCacheModel() {
				return _nullUniqueGroupCacheModel;
			}
		};

	private static CacheModel<UniqueGroup> _nullUniqueGroupCacheModel = new CacheModel<UniqueGroup>() {
			@Override
			public UniqueGroup toEntityModel() {
				return _nullUniqueGroup;
			}
		};
}