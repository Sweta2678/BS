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

import com.ihg.brandstandards.db.NoSuchBridgePublishImportException;
import com.ihg.brandstandards.db.model.BridgePublishImport;
import com.ihg.brandstandards.db.model.impl.BridgePublishImportImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl;

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
 * The persistence implementation for the bridge publish import service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishImportPersistence
 * @see BridgePublishImportUtil
 * @generated
 */
public class BridgePublishImportPersistenceImpl extends BasePersistenceImpl<BridgePublishImport>
	implements BridgePublishImportPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishImportUtil} to access the bridge publish import persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishImportImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDSTDID =
		new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishIdAndStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID =
		new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndStdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			BridgePublishImportModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishImportModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndStdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishIdAndStdId(long publishId,
		long stdId) throws SystemException {
		return findByPublishIdAndStdId(publishId, stdId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @return the range of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishIdAndStdId(long publishId,
		long stdId, int start, int end) throws SystemException {
		return findByPublishIdAndStdId(publishId, stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish imports where publishId = &#63; and stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishIdAndStdId(long publishId,
		long stdId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID;
			finderArgs = new Object[] { publishId, stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDSTDID;
			finderArgs = new Object[] {
					publishId, stdId,
					
					start, end, orderByComparator
				};
		}

		List<BridgePublishImport> list = (List<BridgePublishImport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublishImport bridgePublishImport : list) {
				if ((publishId != bridgePublishImport.getPublishId()) ||
						(stdId != bridgePublishImport.getStdId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishImportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<BridgePublishImport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishImport>(list);
				}
				else {
					list = (List<BridgePublishImport>)QueryUtil.list(q,
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
	 * Returns the first bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPublishIdAndStdId_First(long publishId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPublishIdAndStdId_First(publishId,
				stdId, orderByComparator);

		if (bridgePublishImport != null) {
			return bridgePublishImport;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishImportException(msg.toString());
	}

	/**
	 * Returns the first bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishIdAndStdId_First(long publishId,
		long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BridgePublishImport> list = findByPublishIdAndStdId(publishId,
				stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPublishIdAndStdId_Last(long publishId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPublishIdAndStdId_Last(publishId,
				stdId, orderByComparator);

		if (bridgePublishImport != null) {
			return bridgePublishImport;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishImportException(msg.toString());
	}

	/**
	 * Returns the last bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishIdAndStdId_Last(long publishId,
		long stdId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndStdId(publishId, stdId);

		if (count == 0) {
			return null;
		}

		List<BridgePublishImport> list = findByPublishIdAndStdId(publishId,
				stdId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishImportId the primary key of the current bridge publish import
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport[] findByPublishIdAndStdId_PrevAndNext(
		long publishImportId, long publishId, long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = findByPrimaryKey(publishImportId);

		Session session = null;

		try {
			session = openSession();

			BridgePublishImport[] array = new BridgePublishImportImpl[3];

			array[0] = getByPublishIdAndStdId_PrevAndNext(session,
					bridgePublishImport, publishId, stdId, orderByComparator,
					true);

			array[1] = bridgePublishImport;

			array[2] = getByPublishIdAndStdId_PrevAndNext(session,
					bridgePublishImport, publishId, stdId, orderByComparator,
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

	protected BridgePublishImport getByPublishIdAndStdId_PrevAndNext(
		Session session, BridgePublishImport bridgePublishImport,
		long publishId, long stdId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STDID_2);

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
			query.append(BridgePublishImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublishImport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublishImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publish imports where publishId = &#63; and stdId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndStdId(long publishId, long stdId)
		throws SystemException {
		for (BridgePublishImport bridgePublishImport : findByPublishIdAndStdId(
				publishId, stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublishImport);
		}
	}

	/**
	 * Returns the number of bridge publish imports where publishId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param stdId the std ID
	 * @return the number of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndStdId(long publishId, long stdId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID;

		Object[] finderArgs = new Object[] { publishId, stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEPUBLISHIMPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

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

	private static final String _FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2 = "bridgePublishImport.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDSTDID_STDID_2 = "bridgePublishImport.stdId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPublishIdRegionIdStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			BridgePublishImportModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishImportModelImpl.REGIONID_COLUMN_BITMASK |
			BridgePublishImportModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDSTDID = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdRegionIdStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishImportException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @return the matching bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPublishIdRegionIdStdId(long publishId,
		long regionId, long stdId)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPublishIdRegionIdStdId(publishId,
				regionId, stdId);

		if (bridgePublishImport == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishId=");
			msg.append(publishId);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(", stdId=");
			msg.append(stdId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgePublishImportException(msg.toString());
		}

		return bridgePublishImport;
	}

	/**
	 * Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @return the matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishIdRegionIdStdId(long publishId,
		long regionId, long stdId) throws SystemException {
		return fetchByPublishIdRegionIdStdId(publishId, regionId, stdId, true);
	}

	/**
	 * Returns the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishIdRegionIdStdId(long publishId,
		long regionId, long stdId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { publishId, regionId, stdId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
					finderArgs, this);
		}

		if (result instanceof BridgePublishImport) {
			BridgePublishImport bridgePublishImport = (BridgePublishImport)result;

			if ((publishId != bridgePublishImport.getPublishId()) ||
					(regionId != bridgePublishImport.getRegionId()) ||
					(stdId != bridgePublishImport.getStdId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(stdId);

				List<BridgePublishImport> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgePublishImportPersistenceImpl.fetchByPublishIdRegionIdStdId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgePublishImport bridgePublishImport = list.get(0);

					result = bridgePublishImport;

					cacheResult(bridgePublishImport);

					if ((bridgePublishImport.getPublishId() != publishId) ||
							(bridgePublishImport.getRegionId() != regionId) ||
							(bridgePublishImport.getStdId() != stdId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
							finderArgs, bridgePublishImport);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
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
			return (BridgePublishImport)result;
		}
	}

	/**
	 * Removes the bridge publish import where publishId = &#63; and regionId = &#63; and stdId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @return the bridge publish import that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport removeByPublishIdRegionIdStdId(long publishId,
		long regionId, long stdId)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = findByPublishIdRegionIdStdId(publishId,
				regionId, stdId);

		return remove(bridgePublishImport);
	}

	/**
	 * Returns the number of bridge publish imports where publishId = &#63; and regionId = &#63; and stdId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param stdId the std ID
	 * @return the number of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdRegionIdStdId(long publishId, long regionId,
		long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDSTDID;

		Object[] finderArgs = new Object[] { publishId, regionId, stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_BRIDGEPUBLISHIMPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

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

	private static final String _FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_PUBLISHID_2 =
		"bridgePublishImport.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_REGIONID_2 =
		"bridgePublishImport.regionId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDREGIONIDSTDID_STDID_2 = "bridgePublishImport.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID =
		new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishIdAndRegionId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID =
		new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndRegionId",
			new String[] { Long.class.getName(), Long.class.getName() },
			BridgePublishImportModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishImportModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDREGIONID = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndRegionId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId) throws SystemException {
		return findByPublishIdAndRegionId(publishId, regionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @return the range of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end)
		throws SystemException {
		return findByPublishIdAndRegionId(publishId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish imports where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishIdAndRegionId(
		long publishId, long regionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID;
			finderArgs = new Object[] { publishId, regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID;
			finderArgs = new Object[] {
					publishId, regionId,
					
					start, end, orderByComparator
				};
		}

		List<BridgePublishImport> list = (List<BridgePublishImport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublishImport bridgePublishImport : list) {
				if ((publishId != bridgePublishImport.getPublishId()) ||
						(regionId != bridgePublishImport.getRegionId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishImportModelImpl.ORDER_BY_JPQL);
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
					list = (List<BridgePublishImport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishImport>(list);
				}
				else {
					list = (List<BridgePublishImport>)QueryUtil.list(q,
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
	 * Returns the first bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPublishIdAndRegionId_First(
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPublishIdAndRegionId_First(publishId,
				regionId, orderByComparator);

		if (bridgePublishImport != null) {
			return bridgePublishImport;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishImportException(msg.toString());
	}

	/**
	 * Returns the first bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishIdAndRegionId_First(
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BridgePublishImport> list = findByPublishIdAndRegionId(publishId,
				regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPublishIdAndRegionId_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPublishIdAndRegionId_Last(publishId,
				regionId, orderByComparator);

		if (bridgePublishImport != null) {
			return bridgePublishImport;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishImportException(msg.toString());
	}

	/**
	 * Returns the last bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishIdAndRegionId_Last(
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndRegionId(publishId, regionId);

		if (count == 0) {
			return null;
		}

		List<BridgePublishImport> list = findByPublishIdAndRegionId(publishId,
				regionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishImportId the primary key of the current bridge publish import
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport[] findByPublishIdAndRegionId_PrevAndNext(
		long publishImportId, long publishId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = findByPrimaryKey(publishImportId);

		Session session = null;

		try {
			session = openSession();

			BridgePublishImport[] array = new BridgePublishImportImpl[3];

			array[0] = getByPublishIdAndRegionId_PrevAndNext(session,
					bridgePublishImport, publishId, regionId,
					orderByComparator, true);

			array[1] = bridgePublishImport;

			array[2] = getByPublishIdAndRegionId_PrevAndNext(session,
					bridgePublishImport, publishId, regionId,
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

	protected BridgePublishImport getByPublishIdAndRegionId_PrevAndNext(
		Session session, BridgePublishImport bridgePublishImport,
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

		query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_REGIONID_2);

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
			query.append(BridgePublishImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublishImport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublishImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publish imports where publishId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndRegionId(long publishId, long regionId)
		throws SystemException {
		for (BridgePublishImport bridgePublishImport : findByPublishIdAndRegionId(
				publishId, regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublishImport);
		}
	}

	/**
	 * Returns the number of bridge publish imports where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the number of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndRegionId(long publishId, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDREGIONID;

		Object[] finderArgs = new Object[] { publishId, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEPUBLISHIMPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_REGIONID_2);

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

	private static final String _FINDER_COLUMN_PUBLISHIDANDREGIONID_PUBLISHID_2 = "bridgePublishImport.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDREGIONID_REGIONID_2 = "bridgePublishImport.regionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishId",
			new String[] { Long.class.getName() },
			BridgePublishImportModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHID = new FinderPath(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bridge publish imports where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishId(long publishId)
		throws SystemException {
		return findByPublishId(publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bridge publish imports where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @return the range of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishId(long publishId, int start,
		int end) throws SystemException {
		return findByPublishId(publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish imports where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findByPublishId(long publishId, int start,
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

		List<BridgePublishImport> list = (List<BridgePublishImport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublishImport bridgePublishImport : list) {
				if ((publishId != bridgePublishImport.getPublishId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishImportModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<BridgePublishImport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishImport>(list);
				}
				else {
					list = (List<BridgePublishImport>)QueryUtil.list(q,
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
	 * Returns the first bridge publish import in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPublishId_First(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPublishId_First(publishId,
				orderByComparator);

		if (bridgePublishImport != null) {
			return bridgePublishImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishImportException(msg.toString());
	}

	/**
	 * Returns the first bridge publish import in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishId_First(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BridgePublishImport> list = findByPublishId(publishId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish import in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPublishId_Last(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPublishId_Last(publishId,
				orderByComparator);

		if (bridgePublishImport != null) {
			return bridgePublishImport;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishImportException(msg.toString());
	}

	/**
	 * Returns the last bridge publish import in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish import, or <code>null</code> if a matching bridge publish import could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPublishId_Last(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishId(publishId);

		if (count == 0) {
			return null;
		}

		List<BridgePublishImport> list = findByPublishId(publishId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publish imports before and after the current bridge publish import in the ordered set where publishId = &#63;.
	 *
	 * @param publishImportId the primary key of the current bridge publish import
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport[] findByPublishId_PrevAndNext(
		long publishImportId, long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = findByPrimaryKey(publishImportId);

		Session session = null;

		try {
			session = openSession();

			BridgePublishImport[] array = new BridgePublishImportImpl[3];

			array[0] = getByPublishId_PrevAndNext(session, bridgePublishImport,
					publishId, orderByComparator, true);

			array[1] = bridgePublishImport;

			array[2] = getByPublishId_PrevAndNext(session, bridgePublishImport,
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

	protected BridgePublishImport getByPublishId_PrevAndNext(Session session,
		BridgePublishImport bridgePublishImport, long publishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE);

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
			query.append(BridgePublishImportModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublishImport);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublishImport> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publish imports where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishId(long publishId) throws SystemException {
		for (BridgePublishImport bridgePublishImport : findByPublishId(
				publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublishImport);
		}
	}

	/**
	 * Returns the number of bridge publish imports where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching bridge publish imports
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

			query.append(_SQL_COUNT_BRIDGEPUBLISHIMPORT_WHERE);

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

	private static final String _FINDER_COLUMN_PUBLISHID_PUBLISHID_2 = "bridgePublishImport.publishId = ?";

	public BridgePublishImportPersistenceImpl() {
		setModelClass(BridgePublishImport.class);
	}

	/**
	 * Caches the bridge publish import in the entity cache if it is enabled.
	 *
	 * @param bridgePublishImport the bridge publish import
	 */
	@Override
	public void cacheResult(BridgePublishImport bridgePublishImport) {
		EntityCacheUtil.putResult(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportImpl.class, bridgePublishImport.getPrimaryKey(),
			bridgePublishImport);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
			new Object[] {
				bridgePublishImport.getPublishId(),
				bridgePublishImport.getRegionId(),
				bridgePublishImport.getStdId()
			}, bridgePublishImport);

		bridgePublishImport.resetOriginalValues();
	}

	/**
	 * Caches the bridge publish imports in the entity cache if it is enabled.
	 *
	 * @param bridgePublishImports the bridge publish imports
	 */
	@Override
	public void cacheResult(List<BridgePublishImport> bridgePublishImports) {
		for (BridgePublishImport bridgePublishImport : bridgePublishImports) {
			if (EntityCacheUtil.getResult(
						BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishImportImpl.class,
						bridgePublishImport.getPrimaryKey()) == null) {
				cacheResult(bridgePublishImport);
			}
			else {
				bridgePublishImport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publish imports.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishImportImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishImportImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish import.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgePublishImport bridgePublishImport) {
		EntityCacheUtil.removeResult(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportImpl.class, bridgePublishImport.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgePublishImport);
	}

	@Override
	public void clearCache(List<BridgePublishImport> bridgePublishImports) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublishImport bridgePublishImport : bridgePublishImports) {
			EntityCacheUtil.removeResult(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishImportImpl.class,
				bridgePublishImport.getPrimaryKey());

			clearUniqueFindersCache(bridgePublishImport);
		}
	}

	protected void cacheUniqueFindersCache(
		BridgePublishImport bridgePublishImport) {
		if (bridgePublishImport.isNew()) {
			Object[] args = new Object[] {
					bridgePublishImport.getPublishId(),
					bridgePublishImport.getRegionId(),
					bridgePublishImport.getStdId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDSTDID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
				args, bridgePublishImport);
		}
		else {
			BridgePublishImportModelImpl bridgePublishImportModelImpl = (BridgePublishImportModelImpl)bridgePublishImport;

			if ((bridgePublishImportModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishImport.getPublishId(),
						bridgePublishImport.getRegionId(),
						bridgePublishImport.getStdId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDSTDID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
					args, bridgePublishImport);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BridgePublishImport bridgePublishImport) {
		BridgePublishImportModelImpl bridgePublishImportModelImpl = (BridgePublishImportModelImpl)bridgePublishImport;

		Object[] args = new Object[] {
				bridgePublishImport.getPublishId(),
				bridgePublishImport.getRegionId(),
				bridgePublishImport.getStdId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDSTDID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
			args);

		if ((bridgePublishImportModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgePublishImportModelImpl.getOriginalPublishId(),
					bridgePublishImportModelImpl.getOriginalRegionId(),
					bridgePublishImportModelImpl.getOriginalStdId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDSTDID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDSTDID,
				args);
		}
	}

	/**
	 * Creates a new bridge publish import with the primary key. Does not add the bridge publish import to the database.
	 *
	 * @param publishImportId the primary key for the new bridge publish import
	 * @return the new bridge publish import
	 */
	@Override
	public BridgePublishImport create(long publishImportId) {
		BridgePublishImport bridgePublishImport = new BridgePublishImportImpl();

		bridgePublishImport.setNew(true);
		bridgePublishImport.setPrimaryKey(publishImportId);

		return bridgePublishImport;
	}

	/**
	 * Removes the bridge publish import with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishImportId the primary key of the bridge publish import
	 * @return the bridge publish import that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport remove(long publishImportId)
		throws NoSuchBridgePublishImportException, SystemException {
		return remove((Serializable)publishImportId);
	}

	/**
	 * Removes the bridge publish import with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish import
	 * @return the bridge publish import that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport remove(Serializable primaryKey)
		throws NoSuchBridgePublishImportException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublishImport bridgePublishImport = (BridgePublishImport)session.get(BridgePublishImportImpl.class,
					primaryKey);

			if (bridgePublishImport == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishImportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublishImport);
		}
		catch (NoSuchBridgePublishImportException nsee) {
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
	protected BridgePublishImport removeImpl(
		BridgePublishImport bridgePublishImport) throws SystemException {
		bridgePublishImport = toUnwrappedModel(bridgePublishImport);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublishImport)) {
				bridgePublishImport = (BridgePublishImport)session.get(BridgePublishImportImpl.class,
						bridgePublishImport.getPrimaryKeyObj());
			}

			if (bridgePublishImport != null) {
				session.delete(bridgePublishImport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublishImport != null) {
			clearCache(bridgePublishImport);
		}

		return bridgePublishImport;
	}

	@Override
	public BridgePublishImport updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport)
		throws SystemException {
		bridgePublishImport = toUnwrappedModel(bridgePublishImport);

		boolean isNew = bridgePublishImport.isNew();

		BridgePublishImportModelImpl bridgePublishImportModelImpl = (BridgePublishImportModelImpl)bridgePublishImport;

		Session session = null;

		try {
			session = openSession();

			if (bridgePublishImport.isNew()) {
				session.save(bridgePublishImport);

				bridgePublishImport.setNew(false);
			}
			else {
				session.merge(bridgePublishImport);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BridgePublishImportModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bridgePublishImportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishImportModelImpl.getOriginalPublishId(),
						bridgePublishImportModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID,
					args);

				args = new Object[] {
						bridgePublishImportModelImpl.getPublishId(),
						bridgePublishImportModelImpl.getStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID,
					args);
			}

			if ((bridgePublishImportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishImportModelImpl.getOriginalPublishId(),
						bridgePublishImportModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID,
					args);

				args = new Object[] {
						bridgePublishImportModelImpl.getPublishId(),
						bridgePublishImportModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID,
					args);
			}

			if ((bridgePublishImportModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishImportModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);

				args = new Object[] { bridgePublishImportModelImpl.getPublishId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);
			}
		}

		EntityCacheUtil.putResult(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImportImpl.class, bridgePublishImport.getPrimaryKey(),
			bridgePublishImport);

		clearUniqueFindersCache(bridgePublishImport);
		cacheUniqueFindersCache(bridgePublishImport);

		return bridgePublishImport;
	}

	protected BridgePublishImport toUnwrappedModel(
		BridgePublishImport bridgePublishImport) {
		if (bridgePublishImport instanceof BridgePublishImportImpl) {
			return bridgePublishImport;
		}

		BridgePublishImportImpl bridgePublishImportImpl = new BridgePublishImportImpl();

		bridgePublishImportImpl.setNew(bridgePublishImport.isNew());
		bridgePublishImportImpl.setPrimaryKey(bridgePublishImport.getPrimaryKey());

		bridgePublishImportImpl.setPublishImportId(bridgePublishImport.getPublishImportId());
		bridgePublishImportImpl.setPublishId(bridgePublishImport.getPublishId());
		bridgePublishImportImpl.setStdId(bridgePublishImport.getStdId());
		bridgePublishImportImpl.setSelectInd(bridgePublishImport.getSelectInd());
		bridgePublishImportImpl.setRegionId(bridgePublishImport.getRegionId());
		bridgePublishImportImpl.setStatus(bridgePublishImport.getStatus());
		bridgePublishImportImpl.setCreatorId(bridgePublishImport.getCreatorId());
		bridgePublishImportImpl.setCreatedDate(bridgePublishImport.getCreatedDate());
		bridgePublishImportImpl.setUpdatedBy(bridgePublishImport.getUpdatedBy());
		bridgePublishImportImpl.setUpdatedDate(bridgePublishImport.getUpdatedDate());

		return bridgePublishImportImpl;
	}

	/**
	 * Returns the bridge publish import with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish import
	 * @return the bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishImportException, SystemException {
		BridgePublishImport bridgePublishImport = fetchByPrimaryKey(primaryKey);

		if (bridgePublishImport == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishImportException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublishImport;
	}

	/**
	 * Returns the bridge publish import with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishImportException} if it could not be found.
	 *
	 * @param publishImportId the primary key of the bridge publish import
	 * @return the bridge publish import
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishImportException if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport findByPrimaryKey(long publishImportId)
		throws NoSuchBridgePublishImportException, SystemException {
		return findByPrimaryKey((Serializable)publishImportId);
	}

	/**
	 * Returns the bridge publish import with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish import
	 * @return the bridge publish import, or <code>null</code> if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgePublishImport bridgePublishImport = (BridgePublishImport)EntityCacheUtil.getResult(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishImportImpl.class, primaryKey);

		if (bridgePublishImport == _nullBridgePublishImport) {
			return null;
		}

		if (bridgePublishImport == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublishImport = (BridgePublishImport)session.get(BridgePublishImportImpl.class,
						primaryKey);

				if (bridgePublishImport != null) {
					cacheResult(bridgePublishImport);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishImportImpl.class, primaryKey,
						_nullBridgePublishImport);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishImportModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishImportImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublishImport;
	}

	/**
	 * Returns the bridge publish import with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishImportId the primary key of the bridge publish import
	 * @return the bridge publish import, or <code>null</code> if a bridge publish import with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishImport fetchByPrimaryKey(long publishImportId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishImportId);
	}

	/**
	 * Returns all the bridge publish imports.
	 *
	 * @return the bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @return the range of bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish imports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishImportModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish imports
	 * @param end the upper bound of the range of bridge publish imports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publish imports
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishImport> findAll(int start, int end,
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

		List<BridgePublishImport> list = (List<BridgePublishImport>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISHIMPORT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISHIMPORT;

				if (pagination) {
					sql = sql.concat(BridgePublishImportModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublishImport>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishImport>(list);
				}
				else {
					list = (List<BridgePublishImport>)QueryUtil.list(q,
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
	 * Removes all the bridge publish imports from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublishImport bridgePublishImport : findAll()) {
			remove(bridgePublishImport);
		}
	}

	/**
	 * Returns the number of bridge publish imports.
	 *
	 * @return the number of bridge publish imports
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISHIMPORT);

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
	 * Initializes the bridge publish import persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublishImport")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublishImport>> listenersList = new ArrayList<ModelListener<BridgePublishImport>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublishImport>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishImportImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISHIMPORT = "SELECT bridgePublishImport FROM BridgePublishImport bridgePublishImport";
	private static final String _SQL_SELECT_BRIDGEPUBLISHIMPORT_WHERE = "SELECT bridgePublishImport FROM BridgePublishImport bridgePublishImport WHERE ";
	private static final String _SQL_COUNT_BRIDGEPUBLISHIMPORT = "SELECT COUNT(bridgePublishImport) FROM BridgePublishImport bridgePublishImport";
	private static final String _SQL_COUNT_BRIDGEPUBLISHIMPORT_WHERE = "SELECT COUNT(bridgePublishImport) FROM BridgePublishImport bridgePublishImport WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublishImport.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublishImport exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgePublishImport exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishImportPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishImportId", "publishId", "stdId", "selectInd", "regionId",
				"status", "creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static BridgePublishImport _nullBridgePublishImport = new BridgePublishImportImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublishImport> toCacheModel() {
				return _nullBridgePublishImportCacheModel;
			}
		};

	private static CacheModel<BridgePublishImport> _nullBridgePublishImportCacheModel =
		new CacheModel<BridgePublishImport>() {
			@Override
			public BridgePublishImport toEntityModel() {
				return _nullBridgePublishImport;
			}
		};
}