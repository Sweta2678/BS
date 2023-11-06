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

import com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException;
import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy;
import com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyImpl;
import com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl;

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
 * The persistence implementation for the bridge progress discrepancy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressDiscrepancyPersistence
 * @see BridgeProgressDiscrepancyUtil
 * @generated
 */
public class BridgeProgressDiscrepancyPersistenceImpl
	extends BasePersistenceImpl<BridgeProgressDiscrepancy>
	implements BridgeProgressDiscrepancyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgeProgressDiscrepancyUtil} to access the bridge progress discrepancy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgeProgressDiscrepancyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGN =
		new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypublicationPublishRgn",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGN =
		new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypublicationPublishRgn",
			new String[] { Long.class.getName(), Long.class.getName() },
			BridgeProgressDiscrepancyModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgeProgressDiscrepancyModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGN = new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublicationPublishRgn",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId) throws SystemException {
		return findBypublicationPublishRgn(publishId, regionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge progress discrepancies
	 * @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	 * @return the range of matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId, int start, int end)
		throws SystemException {
		return findBypublicationPublishRgn(publishId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge progress discrepancies
	 * @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findBypublicationPublishRgn(
		long publishId, long regionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGN;
			finderArgs = new Object[] { publishId, regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGN;
			finderArgs = new Object[] {
					publishId, regionId,
					
					start, end, orderByComparator
				};
		}

		List<BridgeProgressDiscrepancy> list = (List<BridgeProgressDiscrepancy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgeProgressDiscrepancy bridgeProgressDiscrepancy : list) {
				if ((publishId != bridgeProgressDiscrepancy.getPublishId()) ||
						(regionId != bridgeProgressDiscrepancy.getRegionId())) {
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

			query.append(_SQL_SELECT_BRIDGEPROGRESSDISCREPANCY_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGN_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGN_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgeProgressDiscrepancyModelImpl.ORDER_BY_JPQL);
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
					list = (List<BridgeProgressDiscrepancy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeProgressDiscrepancy>(list);
				}
				else {
					list = (List<BridgeProgressDiscrepancy>)QueryUtil.list(q,
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
	 * Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy findBypublicationPublishRgn_First(
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = fetchBypublicationPublishRgn_First(publishId,
				regionId, orderByComparator);

		if (bridgeProgressDiscrepancy != null) {
			return bridgeProgressDiscrepancy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeProgressDiscrepancyException(msg.toString());
	}

	/**
	 * Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchBypublicationPublishRgn_First(
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BridgeProgressDiscrepancy> list = findBypublicationPublishRgn(publishId,
				regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy findBypublicationPublishRgn_Last(
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = fetchBypublicationPublishRgn_Last(publishId,
				regionId, orderByComparator);

		if (bridgeProgressDiscrepancy != null) {
			return bridgeProgressDiscrepancy;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeProgressDiscrepancyException(msg.toString());
	}

	/**
	 * Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchBypublicationPublishRgn_Last(
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBypublicationPublishRgn(publishId, regionId);

		if (count == 0) {
			return null;
		}

		List<BridgeProgressDiscrepancy> list = findBypublicationPublishRgn(publishId,
				regionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge progress discrepancies before and after the current bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param bridgeProgressDiscrepancyPK the primary key of the current bridge progress discrepancy
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy[] findBypublicationPublishRgn_PrevAndNext(
		BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK,
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = findByPrimaryKey(bridgeProgressDiscrepancyPK);

		Session session = null;

		try {
			session = openSession();

			BridgeProgressDiscrepancy[] array = new BridgeProgressDiscrepancyImpl[3];

			array[0] = getBypublicationPublishRgn_PrevAndNext(session,
					bridgeProgressDiscrepancy, publishId, regionId,
					orderByComparator, true);

			array[1] = bridgeProgressDiscrepancy;

			array[2] = getBypublicationPublishRgn_PrevAndNext(session,
					bridgeProgressDiscrepancy, publishId, regionId,
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

	protected BridgeProgressDiscrepancy getBypublicationPublishRgn_PrevAndNext(
		Session session, BridgeProgressDiscrepancy bridgeProgressDiscrepancy,
		long publishId, long regionId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPROGRESSDISCREPANCY_WHERE);

		query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGN_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGN_REGIONID_2);

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
			query.append(BridgeProgressDiscrepancyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgeProgressDiscrepancy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgeProgressDiscrepancy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypublicationPublishRgn(long publishId, long regionId)
		throws SystemException {
		for (BridgeProgressDiscrepancy bridgeProgressDiscrepancy : findBypublicationPublishRgn(
				publishId, regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgeProgressDiscrepancy);
		}
	}

	/**
	 * Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the number of matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublicationPublishRgn(long publishId, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGN;

		Object[] finderArgs = new Object[] { publishId, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEPROGRESSDISCREPANCY_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGN_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGN_REGIONID_2);

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

	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGN_PUBLISHID_2 =
		"bridgeProgressDiscrepancy.id.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGN_REGIONID_2 = "bridgeProgressDiscrepancy.id.regionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGNCATEGORY =
		new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypublicationPublishRgnCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGNCATEGORY =
		new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBypublicationPublishRgnCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			BridgeProgressDiscrepancyModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgeProgressDiscrepancyModelImpl.REGIONID_COLUMN_BITMASK |
			BridgeProgressDiscrepancyModelImpl.PROGRESSCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATEGORY =
		new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublicationPublishRgnCategory",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @return the matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId)
		throws SystemException {
		return findBypublicationPublishRgnCategory(publishId, regionId,
			progressCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param start the lower bound of the range of bridge progress discrepancies
	 * @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	 * @return the range of matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId, int start,
		int end) throws SystemException {
		return findBypublicationPublishRgnCategory(publishId, regionId,
			progressCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param start the lower bound of the range of bridge progress discrepancies
	 * @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findBypublicationPublishRgnCategory(
		long publishId, long regionId, long progressCategoryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGNCATEGORY;
			finderArgs = new Object[] { publishId, regionId, progressCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGNCATEGORY;
			finderArgs = new Object[] {
					publishId, regionId, progressCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<BridgeProgressDiscrepancy> list = (List<BridgeProgressDiscrepancy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgeProgressDiscrepancy bridgeProgressDiscrepancy : list) {
				if ((publishId != bridgeProgressDiscrepancy.getPublishId()) ||
						(regionId != bridgeProgressDiscrepancy.getRegionId()) ||
						(progressCategoryId != bridgeProgressDiscrepancy.getProgressCategoryId())) {
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

			query.append(_SQL_SELECT_BRIDGEPROGRESSDISCREPANCY_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PROGRESSCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgeProgressDiscrepancyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(progressCategoryId);

				if (!pagination) {
					list = (List<BridgeProgressDiscrepancy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeProgressDiscrepancy>(list);
				}
				else {
					list = (List<BridgeProgressDiscrepancy>)QueryUtil.list(q,
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
	 * Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy findBypublicationPublishRgnCategory_First(
		long publishId, long regionId, long progressCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = fetchBypublicationPublishRgnCategory_First(publishId,
				regionId, progressCategoryId, orderByComparator);

		if (bridgeProgressDiscrepancy != null) {
			return bridgeProgressDiscrepancy;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", progressCategoryId=");
		msg.append(progressCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeProgressDiscrepancyException(msg.toString());
	}

	/**
	 * Returns the first bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchBypublicationPublishRgnCategory_First(
		long publishId, long regionId, long progressCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BridgeProgressDiscrepancy> list = findBypublicationPublishRgnCategory(publishId,
				regionId, progressCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy findBypublicationPublishRgnCategory_Last(
		long publishId, long regionId, long progressCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = fetchBypublicationPublishRgnCategory_Last(publishId,
				regionId, progressCategoryId, orderByComparator);

		if (bridgeProgressDiscrepancy != null) {
			return bridgeProgressDiscrepancy;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(", progressCategoryId=");
		msg.append(progressCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeProgressDiscrepancyException(msg.toString());
	}

	/**
	 * Returns the last bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchBypublicationPublishRgnCategory_Last(
		long publishId, long regionId, long progressCategoryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBypublicationPublishRgnCategory(publishId, regionId,
				progressCategoryId);

		if (count == 0) {
			return null;
		}

		List<BridgeProgressDiscrepancy> list = findBypublicationPublishRgnCategory(publishId,
				regionId, progressCategoryId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge progress discrepancies before and after the current bridge progress discrepancy in the ordered set where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * @param bridgeProgressDiscrepancyPK the primary key of the current bridge progress discrepancy
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy[] findBypublicationPublishRgnCategory_PrevAndNext(
		BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK,
		long publishId, long regionId, long progressCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = findByPrimaryKey(bridgeProgressDiscrepancyPK);

		Session session = null;

		try {
			session = openSession();

			BridgeProgressDiscrepancy[] array = new BridgeProgressDiscrepancyImpl[3];

			array[0] = getBypublicationPublishRgnCategory_PrevAndNext(session,
					bridgeProgressDiscrepancy, publishId, regionId,
					progressCategoryId, orderByComparator, true);

			array[1] = bridgeProgressDiscrepancy;

			array[2] = getBypublicationPublishRgnCategory_PrevAndNext(session,
					bridgeProgressDiscrepancy, publishId, regionId,
					progressCategoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BridgeProgressDiscrepancy getBypublicationPublishRgnCategory_PrevAndNext(
		Session session, BridgeProgressDiscrepancy bridgeProgressDiscrepancy,
		long publishId, long regionId, long progressCategoryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPROGRESSDISCREPANCY_WHERE);

		query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_REGIONID_2);

		query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PROGRESSCATEGORYID_2);

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
			query.append(BridgeProgressDiscrepancyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		qPos.add(progressCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgeProgressDiscrepancy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgeProgressDiscrepancy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypublicationPublishRgnCategory(long publishId,
		long regionId, long progressCategoryId) throws SystemException {
		for (BridgeProgressDiscrepancy bridgeProgressDiscrepancy : findBypublicationPublishRgnCategory(
				publishId, regionId, progressCategoryId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(bridgeProgressDiscrepancy);
		}
	}

	/**
	 * Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @return the number of matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublicationPublishRgnCategory(long publishId,
		long regionId, long progressCategoryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATEGORY;

		Object[] finderArgs = new Object[] {
				publishId, regionId, progressCategoryId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_BRIDGEPROGRESSDISCREPANCY_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PROGRESSCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(progressCategoryId);

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

	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PUBLISHID_2 =
		"bridgeProgressDiscrepancy.id.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_REGIONID_2 =
		"bridgeProgressDiscrepancy.id.regionId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATEGORY_PROGRESSCATEGORYID_2 =
		"bridgeProgressDiscrepancy.id.progressCategoryId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT =
		new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypublicationPublishRgnCatSubCat",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			BridgeProgressDiscrepancyModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgeProgressDiscrepancyModelImpl.REGIONID_COLUMN_BITMASK |
			BridgeProgressDiscrepancyModelImpl.PROGRESSCATEGORYID_COLUMN_BITMASK |
			BridgeProgressDiscrepancyModelImpl.PROGRESSSUBCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATSUBCAT =
		new FinderPath(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublicationPublishRgnCatSubCat",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the matching bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy findBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = fetchBypublicationPublishRgnCatSubCat(publishId,
				regionId, progressCategoryId, progressSubCategoryId);

		if (bridgeProgressDiscrepancy == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishId=");
			msg.append(publishId);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(", progressCategoryId=");
			msg.append(progressCategoryId);

			msg.append(", progressSubCategoryId=");
			msg.append(progressSubCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgeProgressDiscrepancyException(msg.toString());
		}

		return bridgeProgressDiscrepancy;
	}

	/**
	 * Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId) throws SystemException {
		return fetchBypublicationPublishRgnCatSubCat(publishId, regionId,
			progressCategoryId, progressSubCategoryId, true);
	}

	/**
	 * Returns the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param progressSubCategoryId the progress sub category ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge progress discrepancy, or <code>null</code> if a matching bridge progress discrepancy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				publishId, regionId, progressCategoryId, progressSubCategoryId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
					finderArgs, this);
		}

		if (result instanceof BridgeProgressDiscrepancy) {
			BridgeProgressDiscrepancy bridgeProgressDiscrepancy = (BridgeProgressDiscrepancy)result;

			if ((publishId != bridgeProgressDiscrepancy.getPublishId()) ||
					(regionId != bridgeProgressDiscrepancy.getRegionId()) ||
					(progressCategoryId != bridgeProgressDiscrepancy.getProgressCategoryId()) ||
					(progressSubCategoryId != bridgeProgressDiscrepancy.getProgressSubCategoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_BRIDGEPROGRESSDISCREPANCY_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PROGRESSCATEGORYID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PROGRESSSUBCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(progressCategoryId);

				qPos.add(progressSubCategoryId);

				List<BridgeProgressDiscrepancy> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgeProgressDiscrepancyPersistenceImpl.fetchBypublicationPublishRgnCatSubCat(long, long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgeProgressDiscrepancy bridgeProgressDiscrepancy = list.get(0);

					result = bridgeProgressDiscrepancy;

					cacheResult(bridgeProgressDiscrepancy);

					if ((bridgeProgressDiscrepancy.getPublishId() != publishId) ||
							(bridgeProgressDiscrepancy.getRegionId() != regionId) ||
							(bridgeProgressDiscrepancy.getProgressCategoryId() != progressCategoryId) ||
							(bridgeProgressDiscrepancy.getProgressSubCategoryId() != progressSubCategoryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
							finderArgs, bridgeProgressDiscrepancy);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
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
			return (BridgeProgressDiscrepancy)result;
		}
	}

	/**
	 * Removes the bridge progress discrepancy where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the bridge progress discrepancy that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy removeBypublicationPublishRgnCatSubCat(
		long publishId, long regionId, long progressCategoryId,
		long progressSubCategoryId)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = findBypublicationPublishRgnCatSubCat(publishId,
				regionId, progressCategoryId, progressSubCategoryId);

		return remove(bridgeProgressDiscrepancy);
	}

	/**
	 * Returns the number of bridge progress discrepancies where publishId = &#63; and regionId = &#63; and progressCategoryId = &#63; and progressSubCategoryId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param progressCategoryId the progress category ID
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the number of matching bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublicationPublishRgnCatSubCat(long publishId,
		long regionId, long progressCategoryId, long progressSubCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATSUBCAT;

		Object[] finderArgs = new Object[] {
				publishId, regionId, progressCategoryId, progressSubCategoryId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_BRIDGEPROGRESSDISCREPANCY_WHERE);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PROGRESSCATEGORYID_2);

			query.append(_FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PROGRESSSUBCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(progressCategoryId);

				qPos.add(progressSubCategoryId);

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

	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PUBLISHID_2 =
		"bridgeProgressDiscrepancy.id.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_REGIONID_2 =
		"bridgeProgressDiscrepancy.id.regionId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PROGRESSCATEGORYID_2 =
		"bridgeProgressDiscrepancy.id.progressCategoryId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLICATIONPUBLISHRGNCATSUBCAT_PROGRESSSUBCATEGORYID_2 =
		"bridgeProgressDiscrepancy.id.progressSubCategoryId = ?";

	public BridgeProgressDiscrepancyPersistenceImpl() {
		setModelClass(BridgeProgressDiscrepancy.class);
	}

	/**
	 * Caches the bridge progress discrepancy in the entity cache if it is enabled.
	 *
	 * @param bridgeProgressDiscrepancy the bridge progress discrepancy
	 */
	@Override
	public void cacheResult(BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		EntityCacheUtil.putResult(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			bridgeProgressDiscrepancy.getPrimaryKey(), bridgeProgressDiscrepancy);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
			new Object[] {
				bridgeProgressDiscrepancy.getPublishId(),
				bridgeProgressDiscrepancy.getRegionId(),
				bridgeProgressDiscrepancy.getProgressCategoryId(),
				bridgeProgressDiscrepancy.getProgressSubCategoryId()
			}, bridgeProgressDiscrepancy);

		bridgeProgressDiscrepancy.resetOriginalValues();
	}

	/**
	 * Caches the bridge progress discrepancies in the entity cache if it is enabled.
	 *
	 * @param bridgeProgressDiscrepancies the bridge progress discrepancies
	 */
	@Override
	public void cacheResult(
		List<BridgeProgressDiscrepancy> bridgeProgressDiscrepancies) {
		for (BridgeProgressDiscrepancy bridgeProgressDiscrepancy : bridgeProgressDiscrepancies) {
			if (EntityCacheUtil.getResult(
						BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
						BridgeProgressDiscrepancyImpl.class,
						bridgeProgressDiscrepancy.getPrimaryKey()) == null) {
				cacheResult(bridgeProgressDiscrepancy);
			}
			else {
				bridgeProgressDiscrepancy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge progress discrepancies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgeProgressDiscrepancyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgeProgressDiscrepancyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge progress discrepancy.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		EntityCacheUtil.removeResult(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			bridgeProgressDiscrepancy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgeProgressDiscrepancy);
	}

	@Override
	public void clearCache(
		List<BridgeProgressDiscrepancy> bridgeProgressDiscrepancies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgeProgressDiscrepancy bridgeProgressDiscrepancy : bridgeProgressDiscrepancies) {
			EntityCacheUtil.removeResult(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
				BridgeProgressDiscrepancyImpl.class,
				bridgeProgressDiscrepancy.getPrimaryKey());

			clearUniqueFindersCache(bridgeProgressDiscrepancy);
		}
	}

	protected void cacheUniqueFindersCache(
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		if (bridgeProgressDiscrepancy.isNew()) {
			Object[] args = new Object[] {
					bridgeProgressDiscrepancy.getPublishId(),
					bridgeProgressDiscrepancy.getRegionId(),
					bridgeProgressDiscrepancy.getProgressCategoryId(),
					bridgeProgressDiscrepancy.getProgressSubCategoryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
				args, bridgeProgressDiscrepancy);
		}
		else {
			BridgeProgressDiscrepancyModelImpl bridgeProgressDiscrepancyModelImpl =
				(BridgeProgressDiscrepancyModelImpl)bridgeProgressDiscrepancy;

			if ((bridgeProgressDiscrepancyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeProgressDiscrepancy.getPublishId(),
						bridgeProgressDiscrepancy.getRegionId(),
						bridgeProgressDiscrepancy.getProgressCategoryId(),
						bridgeProgressDiscrepancy.getProgressSubCategoryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
					args, bridgeProgressDiscrepancy);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		BridgeProgressDiscrepancyModelImpl bridgeProgressDiscrepancyModelImpl = (BridgeProgressDiscrepancyModelImpl)bridgeProgressDiscrepancy;

		Object[] args = new Object[] {
				bridgeProgressDiscrepancy.getPublishId(),
				bridgeProgressDiscrepancy.getRegionId(),
				bridgeProgressDiscrepancy.getProgressCategoryId(),
				bridgeProgressDiscrepancy.getProgressSubCategoryId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
			args);

		if ((bridgeProgressDiscrepancyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgeProgressDiscrepancyModelImpl.getOriginalPublishId(),
					bridgeProgressDiscrepancyModelImpl.getOriginalRegionId(),
					bridgeProgressDiscrepancyModelImpl.getOriginalProgressCategoryId(),
					bridgeProgressDiscrepancyModelImpl.getOriginalProgressSubCategoryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLICATIONPUBLISHRGNCATSUBCAT,
				args);
		}
	}

	/**
	 * Creates a new bridge progress discrepancy with the primary key. Does not add the bridge progress discrepancy to the database.
	 *
	 * @param bridgeProgressDiscrepancyPK the primary key for the new bridge progress discrepancy
	 * @return the new bridge progress discrepancy
	 */
	@Override
	public BridgeProgressDiscrepancy create(
		BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK) {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = new BridgeProgressDiscrepancyImpl();

		bridgeProgressDiscrepancy.setNew(true);
		bridgeProgressDiscrepancy.setPrimaryKey(bridgeProgressDiscrepancyPK);

		return bridgeProgressDiscrepancy;
	}

	/**
	 * Removes the bridge progress discrepancy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	 * @return the bridge progress discrepancy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy remove(
		BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		return remove((Serializable)bridgeProgressDiscrepancyPK);
	}

	/**
	 * Removes the bridge progress discrepancy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge progress discrepancy
	 * @return the bridge progress discrepancy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy remove(Serializable primaryKey)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgeProgressDiscrepancy bridgeProgressDiscrepancy = (BridgeProgressDiscrepancy)session.get(BridgeProgressDiscrepancyImpl.class,
					primaryKey);

			if (bridgeProgressDiscrepancy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgeProgressDiscrepancyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgeProgressDiscrepancy);
		}
		catch (NoSuchBridgeProgressDiscrepancyException nsee) {
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
	protected BridgeProgressDiscrepancy removeImpl(
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy)
		throws SystemException {
		bridgeProgressDiscrepancy = toUnwrappedModel(bridgeProgressDiscrepancy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgeProgressDiscrepancy)) {
				bridgeProgressDiscrepancy = (BridgeProgressDiscrepancy)session.get(BridgeProgressDiscrepancyImpl.class,
						bridgeProgressDiscrepancy.getPrimaryKeyObj());
			}

			if (bridgeProgressDiscrepancy != null) {
				session.delete(bridgeProgressDiscrepancy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgeProgressDiscrepancy != null) {
			clearCache(bridgeProgressDiscrepancy);
		}

		return bridgeProgressDiscrepancy;
	}

	@Override
	public BridgeProgressDiscrepancy updateImpl(
		com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy bridgeProgressDiscrepancy)
		throws SystemException {
		bridgeProgressDiscrepancy = toUnwrappedModel(bridgeProgressDiscrepancy);

		boolean isNew = bridgeProgressDiscrepancy.isNew();

		BridgeProgressDiscrepancyModelImpl bridgeProgressDiscrepancyModelImpl = (BridgeProgressDiscrepancyModelImpl)bridgeProgressDiscrepancy;

		Session session = null;

		try {
			session = openSession();

			if (bridgeProgressDiscrepancy.isNew()) {
				session.save(bridgeProgressDiscrepancy);

				bridgeProgressDiscrepancy.setNew(false);
			}
			else {
				session.merge(bridgeProgressDiscrepancy);
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
				!BridgeProgressDiscrepancyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bridgeProgressDiscrepancyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeProgressDiscrepancyModelImpl.getOriginalPublishId(),
						bridgeProgressDiscrepancyModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGN,
					args);

				args = new Object[] {
						bridgeProgressDiscrepancyModelImpl.getPublishId(),
						bridgeProgressDiscrepancyModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGN,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGN,
					args);
			}

			if ((bridgeProgressDiscrepancyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGNCATEGORY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeProgressDiscrepancyModelImpl.getOriginalPublishId(),
						bridgeProgressDiscrepancyModelImpl.getOriginalRegionId(),
						bridgeProgressDiscrepancyModelImpl.getOriginalProgressCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGNCATEGORY,
					args);

				args = new Object[] {
						bridgeProgressDiscrepancyModelImpl.getPublishId(),
						bridgeProgressDiscrepancyModelImpl.getRegionId(),
						bridgeProgressDiscrepancyModelImpl.getProgressCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLICATIONPUBLISHRGNCATEGORY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLICATIONPUBLISHRGNCATEGORY,
					args);
			}
		}

		EntityCacheUtil.putResult(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressDiscrepancyImpl.class,
			bridgeProgressDiscrepancy.getPrimaryKey(), bridgeProgressDiscrepancy);

		clearUniqueFindersCache(bridgeProgressDiscrepancy);
		cacheUniqueFindersCache(bridgeProgressDiscrepancy);

		return bridgeProgressDiscrepancy;
	}

	protected BridgeProgressDiscrepancy toUnwrappedModel(
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		if (bridgeProgressDiscrepancy instanceof BridgeProgressDiscrepancyImpl) {
			return bridgeProgressDiscrepancy;
		}

		BridgeProgressDiscrepancyImpl bridgeProgressDiscrepancyImpl = new BridgeProgressDiscrepancyImpl();

		bridgeProgressDiscrepancyImpl.setNew(bridgeProgressDiscrepancy.isNew());
		bridgeProgressDiscrepancyImpl.setPrimaryKey(bridgeProgressDiscrepancy.getPrimaryKey());

		bridgeProgressDiscrepancyImpl.setProgressCategoryId(bridgeProgressDiscrepancy.getProgressCategoryId());
		bridgeProgressDiscrepancyImpl.setProgressSubCategoryId(bridgeProgressDiscrepancy.getProgressSubCategoryId());
		bridgeProgressDiscrepancyImpl.setPublishId(bridgeProgressDiscrepancy.getPublishId());
		bridgeProgressDiscrepancyImpl.setRegionId(bridgeProgressDiscrepancy.getRegionId());
		bridgeProgressDiscrepancyImpl.setErrorCount(bridgeProgressDiscrepancy.getErrorCount());
		bridgeProgressDiscrepancyImpl.setCreatorId(bridgeProgressDiscrepancy.getCreatorId());
		bridgeProgressDiscrepancyImpl.setCreatedDate(bridgeProgressDiscrepancy.getCreatedDate());
		bridgeProgressDiscrepancyImpl.setUpdatedBy(bridgeProgressDiscrepancy.getUpdatedBy());
		bridgeProgressDiscrepancyImpl.setUpdatedDate(bridgeProgressDiscrepancy.getUpdatedDate());

		return bridgeProgressDiscrepancyImpl;
	}

	/**
	 * Returns the bridge progress discrepancy with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge progress discrepancy
	 * @return the bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = fetchByPrimaryKey(primaryKey);

		if (bridgeProgressDiscrepancy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgeProgressDiscrepancyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgeProgressDiscrepancy;
	}

	/**
	 * Returns the bridge progress discrepancy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException} if it could not be found.
	 *
	 * @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	 * @return the bridge progress discrepancy
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy findByPrimaryKey(
		BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws NoSuchBridgeProgressDiscrepancyException, SystemException {
		return findByPrimaryKey((Serializable)bridgeProgressDiscrepancyPK);
	}

	/**
	 * Returns the bridge progress discrepancy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge progress discrepancy
	 * @return the bridge progress discrepancy, or <code>null</code> if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy = (BridgeProgressDiscrepancy)EntityCacheUtil.getResult(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
				BridgeProgressDiscrepancyImpl.class, primaryKey);

		if (bridgeProgressDiscrepancy == _nullBridgeProgressDiscrepancy) {
			return null;
		}

		if (bridgeProgressDiscrepancy == null) {
			Session session = null;

			try {
				session = openSession();

				bridgeProgressDiscrepancy = (BridgeProgressDiscrepancy)session.get(BridgeProgressDiscrepancyImpl.class,
						primaryKey);

				if (bridgeProgressDiscrepancy != null) {
					cacheResult(bridgeProgressDiscrepancy);
				}
				else {
					EntityCacheUtil.putResult(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
						BridgeProgressDiscrepancyImpl.class, primaryKey,
						_nullBridgeProgressDiscrepancy);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgeProgressDiscrepancyModelImpl.ENTITY_CACHE_ENABLED,
					BridgeProgressDiscrepancyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgeProgressDiscrepancy;
	}

	/**
	 * Returns the bridge progress discrepancy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bridgeProgressDiscrepancyPK the primary key of the bridge progress discrepancy
	 * @return the bridge progress discrepancy, or <code>null</code> if a bridge progress discrepancy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressDiscrepancy fetchByPrimaryKey(
		BridgeProgressDiscrepancyPK bridgeProgressDiscrepancyPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)bridgeProgressDiscrepancyPK);
	}

	/**
	 * Returns all the bridge progress discrepancies.
	 *
	 * @return the bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge progress discrepancies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge progress discrepancies
	 * @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	 * @return the range of bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge progress discrepancies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge progress discrepancies
	 * @param end the upper bound of the range of bridge progress discrepancies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge progress discrepancies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressDiscrepancy> findAll(int start, int end,
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

		List<BridgeProgressDiscrepancy> list = (List<BridgeProgressDiscrepancy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPROGRESSDISCREPANCY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPROGRESSDISCREPANCY;

				if (pagination) {
					sql = sql.concat(BridgeProgressDiscrepancyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgeProgressDiscrepancy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeProgressDiscrepancy>(list);
				}
				else {
					list = (List<BridgeProgressDiscrepancy>)QueryUtil.list(q,
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
	 * Removes all the bridge progress discrepancies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgeProgressDiscrepancy bridgeProgressDiscrepancy : findAll()) {
			remove(bridgeProgressDiscrepancy);
		}
	}

	/**
	 * Returns the number of bridge progress discrepancies.
	 *
	 * @return the number of bridge progress discrepancies
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPROGRESSDISCREPANCY);

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
	 * Initializes the bridge progress discrepancy persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgeProgressDiscrepancy>> listenersList = new ArrayList<ModelListener<BridgeProgressDiscrepancy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgeProgressDiscrepancy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgeProgressDiscrepancyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPROGRESSDISCREPANCY = "SELECT bridgeProgressDiscrepancy FROM BridgeProgressDiscrepancy bridgeProgressDiscrepancy";
	private static final String _SQL_SELECT_BRIDGEPROGRESSDISCREPANCY_WHERE = "SELECT bridgeProgressDiscrepancy FROM BridgeProgressDiscrepancy bridgeProgressDiscrepancy WHERE ";
	private static final String _SQL_COUNT_BRIDGEPROGRESSDISCREPANCY = "SELECT COUNT(bridgeProgressDiscrepancy) FROM BridgeProgressDiscrepancy bridgeProgressDiscrepancy";
	private static final String _SQL_COUNT_BRIDGEPROGRESSDISCREPANCY_WHERE = "SELECT COUNT(bridgeProgressDiscrepancy) FROM BridgeProgressDiscrepancy bridgeProgressDiscrepancy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgeProgressDiscrepancy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgeProgressDiscrepancy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgeProgressDiscrepancy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgeProgressDiscrepancyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"progressCategoryId", "progressSubCategoryId", "publishId",
				"regionId", "errorCount", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static BridgeProgressDiscrepancy _nullBridgeProgressDiscrepancy = new BridgeProgressDiscrepancyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgeProgressDiscrepancy> toCacheModel() {
				return _nullBridgeProgressDiscrepancyCacheModel;
			}
		};

	private static CacheModel<BridgeProgressDiscrepancy> _nullBridgeProgressDiscrepancyCacheModel =
		new CacheModel<BridgeProgressDiscrepancy>() {
			@Override
			public BridgeProgressDiscrepancy toEntityModel() {
				return _nullBridgeProgressDiscrepancy;
			}
		};
}