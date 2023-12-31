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

import com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException;
import com.ihg.brandstandards.db.model.GEMUniqueGroup;
import com.ihg.brandstandards.db.model.impl.GEMUniqueGroupImpl;
import com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl;

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
 * The persistence implementation for the g e m unique group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMUniqueGroupPersistence
 * @see GEMUniqueGroupUtil
 * @generated
 */
public class GEMUniqueGroupPersistenceImpl extends BasePersistenceImpl<GEMUniqueGroup>
	implements GEMUniqueGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMUniqueGroupUtil} to access the g e m unique group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMUniqueGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONANDREGION =
		new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypublicationAndRegion",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION =
		new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypublicationAndRegion",
			new String[] { Long.class.getName(), Long.class.getName() },
			GEMUniqueGroupModelImpl.PUBLISHID_COLUMN_BITMASK |
			GEMUniqueGroupModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLICATIONANDREGION = new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublicationAndRegion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the g e m unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the matching g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findBypublicationAndRegion(long publishId,
		long regionId) throws SystemException {
		return findBypublicationAndRegion(publishId, regionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of g e m unique groups
	 * @param end the upper bound of the range of g e m unique groups (not inclusive)
	 * @return the range of matching g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findBypublicationAndRegion(long publishId,
		long regionId, int start, int end) throws SystemException {
		return findBypublicationAndRegion(publishId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of g e m unique groups
	 * @param end the upper bound of the range of g e m unique groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findBypublicationAndRegion(long publishId,
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

		List<GEMUniqueGroup> list = (List<GEMUniqueGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMUniqueGroup gemUniqueGroup : list) {
				if ((publishId != gemUniqueGroup.getPublishId()) ||
						(regionId != gemUniqueGroup.getRegionId())) {
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

			query.append(_SQL_SELECT_GEMUNIQUEGROUP_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGION_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMUniqueGroupModelImpl.ORDER_BY_JPQL);
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
					list = (List<GEMUniqueGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMUniqueGroup>(list);
				}
				else {
					list = (List<GEMUniqueGroup>)QueryUtil.list(q,
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
	 * Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup findBypublicationAndRegion_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchGEMUniqueGroupException, SystemException {
		GEMUniqueGroup gemUniqueGroup = fetchBypublicationAndRegion_First(publishId,
				regionId, orderByComparator);

		if (gemUniqueGroup != null) {
			return gemUniqueGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMUniqueGroupException(msg.toString());
	}

	/**
	 * Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup fetchBypublicationAndRegion_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<GEMUniqueGroup> list = findBypublicationAndRegion(publishId,
				regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup findBypublicationAndRegion_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchGEMUniqueGroupException, SystemException {
		GEMUniqueGroup gemUniqueGroup = fetchBypublicationAndRegion_Last(publishId,
				regionId, orderByComparator);

		if (gemUniqueGroup != null) {
			return gemUniqueGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMUniqueGroupException(msg.toString());
	}

	/**
	 * Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup fetchBypublicationAndRegion_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBypublicationAndRegion(publishId, regionId);

		if (count == 0) {
			return null;
		}

		List<GEMUniqueGroup> list = findBypublicationAndRegion(publishId,
				regionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m unique groups before and after the current g e m unique group in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param uniqueGroupId the primary key of the current g e m unique group
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup[] findBypublicationAndRegion_PrevAndNext(
		long uniqueGroupId, long publishId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchGEMUniqueGroupException, SystemException {
		GEMUniqueGroup gemUniqueGroup = findByPrimaryKey(uniqueGroupId);

		Session session = null;

		try {
			session = openSession();

			GEMUniqueGroup[] array = new GEMUniqueGroupImpl[3];

			array[0] = getBypublicationAndRegion_PrevAndNext(session,
					gemUniqueGroup, publishId, regionId, orderByComparator, true);

			array[1] = gemUniqueGroup;

			array[2] = getBypublicationAndRegion_PrevAndNext(session,
					gemUniqueGroup, publishId, regionId, orderByComparator,
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

	protected GEMUniqueGroup getBypublicationAndRegion_PrevAndNext(
		Session session, GEMUniqueGroup gemUniqueGroup, long publishId,
		long regionId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMUNIQUEGROUP_WHERE);

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
			query.append(GEMUniqueGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemUniqueGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMUniqueGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m unique groups where publishId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypublicationAndRegion(long publishId, long regionId)
		throws SystemException {
		for (GEMUniqueGroup gemUniqueGroup : findBypublicationAndRegion(
				publishId, regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(gemUniqueGroup);
		}
	}

	/**
	 * Returns the number of g e m unique groups where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the number of matching g e m unique groups
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

			query.append(_SQL_COUNT_GEMUNIQUEGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_PUBLICATIONANDREGION_PUBLISHID_2 = "gemUniqueGroup.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONANDREGION_REGIONID_2 = "gemUniqueGroup.regionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONANDREGIONANDTYPE =
		new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypublicationAndRegionAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGIONANDTYPE =
		new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypublicationAndRegionAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			GEMUniqueGroupModelImpl.PUBLISHID_COLUMN_BITMASK |
			GEMUniqueGroupModelImpl.REGIONID_COLUMN_BITMASK |
			GEMUniqueGroupModelImpl.GROUPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLICATIONANDREGIONANDTYPE =
		new FinderPath(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublicationAndRegionAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @return the matching g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findBypublicationAndRegionAndType(
		long publishId, long regionId, String groupType)
		throws SystemException {
		return findBypublicationAndRegionAndType(publishId, regionId,
			groupType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @param start the lower bound of the range of g e m unique groups
	 * @param end the upper bound of the range of g e m unique groups (not inclusive)
	 * @return the range of matching g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findBypublicationAndRegionAndType(
		long publishId, long regionId, String groupType, int start, int end)
		throws SystemException {
		return findBypublicationAndRegionAndType(publishId, regionId,
			groupType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @param start the lower bound of the range of g e m unique groups
	 * @param end the upper bound of the range of g e m unique groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findBypublicationAndRegionAndType(
		long publishId, long regionId, String groupType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGIONANDTYPE;
			finderArgs = new Object[] { publishId, regionId, groupType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONANDREGIONANDTYPE;
			finderArgs = new Object[] {
					publishId, regionId, groupType,
					
					start, end, orderByComparator
				};
		}

		List<GEMUniqueGroup> list = (List<GEMUniqueGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GEMUniqueGroup gemUniqueGroup : list) {
				if ((publishId != gemUniqueGroup.getPublishId()) ||
						(regionId != gemUniqueGroup.getRegionId()) ||
						!Validator.equals(groupType,
							gemUniqueGroup.getGroupType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_GEMUNIQUEGROUP_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_REGIONID_2);

			boolean bindGroupType = false;

			if (groupType == null) {
				query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_1);
			}
			else if (groupType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_3);
			}
			else {
				bindGroupType = true;

				query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GEMUniqueGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (bindGroupType) {
					qPos.add(groupType);
				}

				if (!pagination) {
					list = (List<GEMUniqueGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMUniqueGroup>(list);
				}
				else {
					list = (List<GEMUniqueGroup>)QueryUtil.list(q,
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
	 * Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup findBypublicationAndRegionAndType_First(
		long publishId, long regionId, String groupType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMUniqueGroupException, SystemException {
		GEMUniqueGroup gemUniqueGroup = fetchBypublicationAndRegionAndType_First(publishId,
				regionId, groupType, orderByComparator);

		if (gemUniqueGroup != null) {
			return gemUniqueGroup;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", groupType=");
		msg.append(groupType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMUniqueGroupException(msg.toString());
	}

	/**
	 * Returns the first g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup fetchBypublicationAndRegionAndType_First(
		long publishId, long regionId, String groupType,
		OrderByComparator orderByComparator) throws SystemException {
		List<GEMUniqueGroup> list = findBypublicationAndRegionAndType(publishId,
				regionId, groupType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup findBypublicationAndRegionAndType_Last(
		long publishId, long regionId, String groupType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMUniqueGroupException, SystemException {
		GEMUniqueGroup gemUniqueGroup = fetchBypublicationAndRegionAndType_Last(publishId,
				regionId, groupType, orderByComparator);

		if (gemUniqueGroup != null) {
			return gemUniqueGroup;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", groupType=");
		msg.append(groupType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGEMUniqueGroupException(msg.toString());
	}

	/**
	 * Returns the last g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching g e m unique group, or <code>null</code> if a matching g e m unique group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup fetchBypublicationAndRegionAndType_Last(
		long publishId, long regionId, String groupType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBypublicationAndRegionAndType(publishId, regionId,
				groupType);

		if (count == 0) {
			return null;
		}

		List<GEMUniqueGroup> list = findBypublicationAndRegionAndType(publishId,
				regionId, groupType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the g e m unique groups before and after the current g e m unique group in the ordered set where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * @param uniqueGroupId the primary key of the current g e m unique group
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup[] findBypublicationAndRegionAndType_PrevAndNext(
		long uniqueGroupId, long publishId, long regionId, String groupType,
		OrderByComparator orderByComparator)
		throws NoSuchGEMUniqueGroupException, SystemException {
		GEMUniqueGroup gemUniqueGroup = findByPrimaryKey(uniqueGroupId);

		Session session = null;

		try {
			session = openSession();

			GEMUniqueGroup[] array = new GEMUniqueGroupImpl[3];

			array[0] = getBypublicationAndRegionAndType_PrevAndNext(session,
					gemUniqueGroup, publishId, regionId, groupType,
					orderByComparator, true);

			array[1] = gemUniqueGroup;

			array[2] = getBypublicationAndRegionAndType_PrevAndNext(session,
					gemUniqueGroup, publishId, regionId, groupType,
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

	protected GEMUniqueGroup getBypublicationAndRegionAndType_PrevAndNext(
		Session session, GEMUniqueGroup gemUniqueGroup, long publishId,
		long regionId, String groupType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEMUNIQUEGROUP_WHERE);

		query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_REGIONID_2);

		boolean bindGroupType = false;

		if (groupType == null) {
			query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_1);
		}
		else if (groupType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_3);
		}
		else {
			bindGroupType = true;

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_2);
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
			query.append(GEMUniqueGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (bindGroupType) {
			qPos.add(groupType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(gemUniqueGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GEMUniqueGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypublicationAndRegionAndType(long publishId,
		long regionId, String groupType) throws SystemException {
		for (GEMUniqueGroup gemUniqueGroup : findBypublicationAndRegionAndType(
				publishId, regionId, groupType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(gemUniqueGroup);
		}
	}

	/**
	 * Returns the number of g e m unique groups where publishId = &#63; and regionId = &#63; and groupType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param groupType the group type
	 * @return the number of matching g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublicationAndRegionAndType(long publishId,
		long regionId, String groupType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLICATIONANDREGIONANDTYPE;

		Object[] finderArgs = new Object[] { publishId, regionId, groupType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_GEMUNIQUEGROUP_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_REGIONID_2);

			boolean bindGroupType = false;

			if (groupType == null) {
				query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_1);
			}
			else if (groupType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_3);
			}
			else {
				bindGroupType = true;

				query.append(_FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (bindGroupType) {
					qPos.add(groupType);
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

	private static final String _FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_PUBLISHID_2 =
		"gemUniqueGroup.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_REGIONID_2 =
		"gemUniqueGroup.regionId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_1 =
		"gemUniqueGroup.groupType IS NULL";
	private static final String _FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_2 =
		"gemUniqueGroup.groupType = ?";
	private static final String _FINDER_COLUMN_PUBLICATIONANDREGIONANDTYPE_GROUPTYPE_3 =
		"(gemUniqueGroup.groupType IS NULL OR gemUniqueGroup.groupType = '')";

	public GEMUniqueGroupPersistenceImpl() {
		setModelClass(GEMUniqueGroup.class);
	}

	/**
	 * Caches the g e m unique group in the entity cache if it is enabled.
	 *
	 * @param gemUniqueGroup the g e m unique group
	 */
	@Override
	public void cacheResult(GEMUniqueGroup gemUniqueGroup) {
		EntityCacheUtil.putResult(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupImpl.class, gemUniqueGroup.getPrimaryKey(),
			gemUniqueGroup);

		gemUniqueGroup.resetOriginalValues();
	}

	/**
	 * Caches the g e m unique groups in the entity cache if it is enabled.
	 *
	 * @param gemUniqueGroups the g e m unique groups
	 */
	@Override
	public void cacheResult(List<GEMUniqueGroup> gemUniqueGroups) {
		for (GEMUniqueGroup gemUniqueGroup : gemUniqueGroups) {
			if (EntityCacheUtil.getResult(
						GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
						GEMUniqueGroupImpl.class, gemUniqueGroup.getPrimaryKey()) == null) {
				cacheResult(gemUniqueGroup);
			}
			else {
				gemUniqueGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m unique groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMUniqueGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMUniqueGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m unique group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMUniqueGroup gemUniqueGroup) {
		EntityCacheUtil.removeResult(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupImpl.class, gemUniqueGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMUniqueGroup> gemUniqueGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMUniqueGroup gemUniqueGroup : gemUniqueGroups) {
			EntityCacheUtil.removeResult(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
				GEMUniqueGroupImpl.class, gemUniqueGroup.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m unique group with the primary key. Does not add the g e m unique group to the database.
	 *
	 * @param uniqueGroupId the primary key for the new g e m unique group
	 * @return the new g e m unique group
	 */
	@Override
	public GEMUniqueGroup create(long uniqueGroupId) {
		GEMUniqueGroup gemUniqueGroup = new GEMUniqueGroupImpl();

		gemUniqueGroup.setNew(true);
		gemUniqueGroup.setPrimaryKey(uniqueGroupId);

		return gemUniqueGroup;
	}

	/**
	 * Removes the g e m unique group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param uniqueGroupId the primary key of the g e m unique group
	 * @return the g e m unique group that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup remove(long uniqueGroupId)
		throws NoSuchGEMUniqueGroupException, SystemException {
		return remove((Serializable)uniqueGroupId);
	}

	/**
	 * Removes the g e m unique group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m unique group
	 * @return the g e m unique group that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup remove(Serializable primaryKey)
		throws NoSuchGEMUniqueGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMUniqueGroup gemUniqueGroup = (GEMUniqueGroup)session.get(GEMUniqueGroupImpl.class,
					primaryKey);

			if (gemUniqueGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMUniqueGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemUniqueGroup);
		}
		catch (NoSuchGEMUniqueGroupException nsee) {
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
	protected GEMUniqueGroup removeImpl(GEMUniqueGroup gemUniqueGroup)
		throws SystemException {
		gemUniqueGroup = toUnwrappedModel(gemUniqueGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemUniqueGroup)) {
				gemUniqueGroup = (GEMUniqueGroup)session.get(GEMUniqueGroupImpl.class,
						gemUniqueGroup.getPrimaryKeyObj());
			}

			if (gemUniqueGroup != null) {
				session.delete(gemUniqueGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemUniqueGroup != null) {
			clearCache(gemUniqueGroup);
		}

		return gemUniqueGroup;
	}

	@Override
	public GEMUniqueGroup updateImpl(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup)
		throws SystemException {
		gemUniqueGroup = toUnwrappedModel(gemUniqueGroup);

		boolean isNew = gemUniqueGroup.isNew();

		GEMUniqueGroupModelImpl gemUniqueGroupModelImpl = (GEMUniqueGroupModelImpl)gemUniqueGroup;

		Session session = null;

		try {
			session = openSession();

			if (gemUniqueGroup.isNew()) {
				session.save(gemUniqueGroup);

				gemUniqueGroup.setNew(false);
			}
			else {
				session.merge(gemUniqueGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GEMUniqueGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((gemUniqueGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemUniqueGroupModelImpl.getOriginalPublishId(),
						gemUniqueGroupModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONANDREGION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION,
					args);

				args = new Object[] {
						gemUniqueGroupModelImpl.getPublishId(),
						gemUniqueGroupModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONANDREGION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGION,
					args);
			}

			if ((gemUniqueGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGIONANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						gemUniqueGroupModelImpl.getOriginalPublishId(),
						gemUniqueGroupModelImpl.getOriginalRegionId(),
						gemUniqueGroupModelImpl.getOriginalGroupType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONANDREGIONANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGIONANDTYPE,
					args);

				args = new Object[] {
						gemUniqueGroupModelImpl.getPublishId(),
						gemUniqueGroupModelImpl.getRegionId(),
						gemUniqueGroupModelImpl.getGroupType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONANDREGIONANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONANDREGIONANDTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupImpl.class, gemUniqueGroup.getPrimaryKey(),
			gemUniqueGroup);

		return gemUniqueGroup;
	}

	protected GEMUniqueGroup toUnwrappedModel(GEMUniqueGroup gemUniqueGroup) {
		if (gemUniqueGroup instanceof GEMUniqueGroupImpl) {
			return gemUniqueGroup;
		}

		GEMUniqueGroupImpl gemUniqueGroupImpl = new GEMUniqueGroupImpl();

		gemUniqueGroupImpl.setNew(gemUniqueGroup.isNew());
		gemUniqueGroupImpl.setPrimaryKey(gemUniqueGroup.getPrimaryKey());

		gemUniqueGroupImpl.setUniqueGroupId(gemUniqueGroup.getUniqueGroupId());
		gemUniqueGroupImpl.setPublishDeptId(gemUniqueGroup.getPublishDeptId());
		gemUniqueGroupImpl.setPublishId(gemUniqueGroup.getPublishId());
		gemUniqueGroupImpl.setGroupName(gemUniqueGroup.getGroupName());
		gemUniqueGroupImpl.setRegionId(gemUniqueGroup.getRegionId());
		gemUniqueGroupImpl.setPolicyId(gemUniqueGroup.getPolicyId());
		gemUniqueGroupImpl.setLevelId(gemUniqueGroup.getLevelId());
		gemUniqueGroupImpl.setGroupType(gemUniqueGroup.getGroupType());
		gemUniqueGroupImpl.setCreatorId(gemUniqueGroup.getCreatorId());
		gemUniqueGroupImpl.setCreatedDate(gemUniqueGroup.getCreatedDate());
		gemUniqueGroupImpl.setUpdatedBy(gemUniqueGroup.getUpdatedBy());
		gemUniqueGroupImpl.setUpdatedDate(gemUniqueGroup.getUpdatedDate());

		return gemUniqueGroupImpl;
	}

	/**
	 * Returns the g e m unique group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m unique group
	 * @return the g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMUniqueGroupException, SystemException {
		GEMUniqueGroup gemUniqueGroup = fetchByPrimaryKey(primaryKey);

		if (gemUniqueGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMUniqueGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemUniqueGroup;
	}

	/**
	 * Returns the g e m unique group with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException} if it could not be found.
	 *
	 * @param uniqueGroupId the primary key of the g e m unique group
	 * @return the g e m unique group
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup findByPrimaryKey(long uniqueGroupId)
		throws NoSuchGEMUniqueGroupException, SystemException {
		return findByPrimaryKey((Serializable)uniqueGroupId);
	}

	/**
	 * Returns the g e m unique group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m unique group
	 * @return the g e m unique group, or <code>null</code> if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMUniqueGroup gemUniqueGroup = (GEMUniqueGroup)EntityCacheUtil.getResult(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
				GEMUniqueGroupImpl.class, primaryKey);

		if (gemUniqueGroup == _nullGEMUniqueGroup) {
			return null;
		}

		if (gemUniqueGroup == null) {
			Session session = null;

			try {
				session = openSession();

				gemUniqueGroup = (GEMUniqueGroup)session.get(GEMUniqueGroupImpl.class,
						primaryKey);

				if (gemUniqueGroup != null) {
					cacheResult(gemUniqueGroup);
				}
				else {
					EntityCacheUtil.putResult(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
						GEMUniqueGroupImpl.class, primaryKey,
						_nullGEMUniqueGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMUniqueGroupModelImpl.ENTITY_CACHE_ENABLED,
					GEMUniqueGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemUniqueGroup;
	}

	/**
	 * Returns the g e m unique group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param uniqueGroupId the primary key of the g e m unique group
	 * @return the g e m unique group, or <code>null</code> if a g e m unique group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroup fetchByPrimaryKey(long uniqueGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)uniqueGroupId);
	}

	/**
	 * Returns all the g e m unique groups.
	 *
	 * @return the g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m unique groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m unique groups
	 * @param end the upper bound of the range of g e m unique groups (not inclusive)
	 * @return the range of g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m unique groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m unique groups
	 * @param end the upper bound of the range of g e m unique groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m unique groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroup> findAll(int start, int end,
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

		List<GEMUniqueGroup> list = (List<GEMUniqueGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMUNIQUEGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMUNIQUEGROUP;

				if (pagination) {
					sql = sql.concat(GEMUniqueGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMUniqueGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMUniqueGroup>(list);
				}
				else {
					list = (List<GEMUniqueGroup>)QueryUtil.list(q,
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
	 * Removes all the g e m unique groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMUniqueGroup gemUniqueGroup : findAll()) {
			remove(gemUniqueGroup);
		}
	}

	/**
	 * Returns the number of g e m unique groups.
	 *
	 * @return the number of g e m unique groups
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

				Query q = session.createQuery(_SQL_COUNT_GEMUNIQUEGROUP);

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
	 * Initializes the g e m unique group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMUniqueGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMUniqueGroup>> listenersList = new ArrayList<ModelListener<GEMUniqueGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMUniqueGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMUniqueGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMUNIQUEGROUP = "SELECT gemUniqueGroup FROM GEMUniqueGroup gemUniqueGroup";
	private static final String _SQL_SELECT_GEMUNIQUEGROUP_WHERE = "SELECT gemUniqueGroup FROM GEMUniqueGroup gemUniqueGroup WHERE ";
	private static final String _SQL_COUNT_GEMUNIQUEGROUP = "SELECT COUNT(gemUniqueGroup) FROM GEMUniqueGroup gemUniqueGroup";
	private static final String _SQL_COUNT_GEMUNIQUEGROUP_WHERE = "SELECT COUNT(gemUniqueGroup) FROM GEMUniqueGroup gemUniqueGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemUniqueGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMUniqueGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GEMUniqueGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMUniqueGroupPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uniqueGroupId", "publishDeptId", "publishId", "groupName",
				"regionId", "policyId", "levelId", "groupType", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMUniqueGroup _nullGEMUniqueGroup = new GEMUniqueGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMUniqueGroup> toCacheModel() {
				return _nullGEMUniqueGroupCacheModel;
			}
		};

	private static CacheModel<GEMUniqueGroup> _nullGEMUniqueGroupCacheModel = new CacheModel<GEMUniqueGroup>() {
			@Override
			public GEMUniqueGroup toEntityModel() {
				return _nullGEMUniqueGroup;
			}
		};
}