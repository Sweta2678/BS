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

import com.ihg.brandstandards.db.NoSuchBridgePublishException;
import com.ihg.brandstandards.db.model.BridgePublish;
import com.ihg.brandstandards.db.model.impl.BridgePublishImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl;

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
 * The persistence implementation for the bridge publish service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishPersistence
 * @see BridgePublishUtil
 * @generated
 */
public class BridgePublishPersistenceImpl extends BasePersistenceImpl<BridgePublish>
	implements BridgePublishPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishUtil} to access the bridge publish persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishId", new String[] { Long.class.getName() },
			BridgePublishModelImpl.PUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHID = new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bridge publishs where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishId(long publishId)
		throws SystemException {
		return findByPublishId(publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bridge publishs where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @return the range of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishId(long publishId, int start,
		int end) throws SystemException {
		return findByPublishId(publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publishs where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishId(long publishId, int start,
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

		List<BridgePublish> list = (List<BridgePublish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublish bridgePublish : list) {
				if ((publishId != bridgePublish.getPublishId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublish>(list);
				}
				else {
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bridge publish in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPublishId_First(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPublishId_First(publishId,
				orderByComparator);

		if (bridgePublish != null) {
			return bridgePublish;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishException(msg.toString());
	}

	/**
	 * Returns the first bridge publish in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishId_First(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BridgePublish> list = findByPublishId(publishId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPublishId_Last(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPublishId_Last(publishId,
				orderByComparator);

		if (bridgePublish != null) {
			return bridgePublish;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishException(msg.toString());
	}

	/**
	 * Returns the last bridge publish in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishId_Last(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishId(publishId);

		if (count == 0) {
			return null;
		}

		List<BridgePublish> list = findByPublishId(publishId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publishs before and after the current bridge publish in the ordered set where publishId = &#63;.
	 *
	 * @param bridgePublishId the primary key of the current bridge publish
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish[] findByPublishId_PrevAndNext(long bridgePublishId,
		long publishId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = findByPrimaryKey(bridgePublishId);

		Session session = null;

		try {
			session = openSession();

			BridgePublish[] array = new BridgePublishImpl[3];

			array[0] = getByPublishId_PrevAndNext(session, bridgePublish,
					publishId, orderByComparator, true);

			array[1] = bridgePublish;

			array[2] = getByPublishId_PrevAndNext(session, bridgePublish,
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

	protected BridgePublish getByPublishId_PrevAndNext(Session session,
		BridgePublish bridgePublish, long publishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPUBLISH_WHERE);

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
			query.append(BridgePublishModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublish);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublish> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publishs where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishId(long publishId) throws SystemException {
		for (BridgePublish bridgePublish : findByPublishId(publishId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublish);
		}
	}

	/**
	 * Returns the number of bridge publishs where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching bridge publishs
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

			query.append(_SQL_COUNT_BRIDGEPUBLISH_WHERE);

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

	private static final String _FINDER_COLUMN_PUBLISHID_PUBLISHID_2 = "bridgePublish.publishId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDSTDID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishIdAndStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndStdId",
			new String[] { Long.class.getName(), Long.class.getName() },
			BridgePublishModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishModelImpl.STANDARDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID = new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndStdId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bridge publishs where publishId = &#63; and standardId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @return the matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishIdAndStdId(long publishId,
		long standardId) throws SystemException {
		return findByPublishIdAndStdId(publishId, standardId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publishs where publishId = &#63; and standardId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @return the range of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishIdAndStdId(long publishId,
		long standardId, int start, int end) throws SystemException {
		return findByPublishIdAndStdId(publishId, standardId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publishs where publishId = &#63; and standardId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishIdAndStdId(long publishId,
		long standardId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID;
			finderArgs = new Object[] { publishId, standardId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDSTDID;
			finderArgs = new Object[] {
					publishId, standardId,
					
					start, end, orderByComparator
				};
		}

		List<BridgePublish> list = (List<BridgePublish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublish bridgePublish : list) {
				if ((publishId != bridgePublish.getPublishId()) ||
						(standardId != bridgePublish.getStandardId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STANDARDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(standardId);

				if (!pagination) {
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublish>(list);
				}
				else {
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPublishIdAndStdId_First(long publishId,
		long standardId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPublishIdAndStdId_First(publishId,
				standardId, orderByComparator);

		if (bridgePublish != null) {
			return bridgePublish;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", standardId=");
		msg.append(standardId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishException(msg.toString());
	}

	/**
	 * Returns the first bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishIdAndStdId_First(long publishId,
		long standardId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BridgePublish> list = findByPublishIdAndStdId(publishId,
				standardId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPublishIdAndStdId_Last(long publishId,
		long standardId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPublishIdAndStdId_Last(publishId,
				standardId, orderByComparator);

		if (bridgePublish != null) {
			return bridgePublish;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", standardId=");
		msg.append(standardId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishException(msg.toString());
	}

	/**
	 * Returns the last bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishIdAndStdId_Last(long publishId,
		long standardId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndStdId(publishId, standardId);

		if (count == 0) {
			return null;
		}

		List<BridgePublish> list = findByPublishIdAndStdId(publishId,
				standardId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publishs before and after the current bridge publish in the ordered set where publishId = &#63; and standardId = &#63;.
	 *
	 * @param bridgePublishId the primary key of the current bridge publish
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish[] findByPublishIdAndStdId_PrevAndNext(
		long bridgePublishId, long publishId, long standardId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = findByPrimaryKey(bridgePublishId);

		Session session = null;

		try {
			session = openSession();

			BridgePublish[] array = new BridgePublishImpl[3];

			array[0] = getByPublishIdAndStdId_PrevAndNext(session,
					bridgePublish, publishId, standardId, orderByComparator,
					true);

			array[1] = bridgePublish;

			array[2] = getByPublishIdAndStdId_PrevAndNext(session,
					bridgePublish, publishId, standardId, orderByComparator,
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

	protected BridgePublish getByPublishIdAndStdId_PrevAndNext(
		Session session, BridgePublish bridgePublish, long publishId,
		long standardId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPUBLISH_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

		query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STANDARDID_2);

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
			query.append(BridgePublishModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(standardId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublish);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublish> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publishs where publishId = &#63; and standardId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndStdId(long publishId, long standardId)
		throws SystemException {
		for (BridgePublish bridgePublish : findByPublishIdAndStdId(publishId,
				standardId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublish);
		}
	}

	/**
	 * Returns the number of bridge publishs where publishId = &#63; and standardId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param standardId the standard ID
	 * @return the number of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdAndStdId(long publishId, long standardId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID;

		Object[] finderArgs = new Object[] { publishId, standardId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDSTDID_STANDARDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(standardId);

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

	private static final String _FINDER_COLUMN_PUBLISHIDANDSTDID_PUBLISHID_2 = "bridgePublish.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDSTDID_STANDARDID_2 = "bridgePublish.standardId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishIdAndRegionId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishIdAndRegionId",
			new String[] { Long.class.getName(), Long.class.getName() },
			BridgePublishModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDANDREGIONID = new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdAndRegionId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bridge publishs where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishIdAndRegionId(long publishId,
		long regionId) throws SystemException {
		return findByPublishIdAndRegionId(publishId, regionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publishs where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @return the range of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishIdAndRegionId(long publishId,
		long regionId, int start, int end) throws SystemException {
		return findByPublishIdAndRegionId(publishId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publishs where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findByPublishIdAndRegionId(long publishId,
		long regionId, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<BridgePublish> list = (List<BridgePublish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublish bridgePublish : list) {
				if ((publishId != bridgePublish.getPublishId()) ||
						(regionId != bridgePublish.getRegionId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDANDREGIONID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishModelImpl.ORDER_BY_JPQL);
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
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublish>(list);
				}
				else {
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPublishIdAndRegionId_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPublishIdAndRegionId_First(publishId,
				regionId, orderByComparator);

		if (bridgePublish != null) {
			return bridgePublish;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishException(msg.toString());
	}

	/**
	 * Returns the first bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishIdAndRegionId_First(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BridgePublish> list = findByPublishIdAndRegionId(publishId,
				regionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPublishIdAndRegionId_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPublishIdAndRegionId_Last(publishId,
				regionId, orderByComparator);

		if (bridgePublish != null) {
			return bridgePublish;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishException(msg.toString());
	}

	/**
	 * Returns the last bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishIdAndRegionId_Last(long publishId,
		long regionId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishIdAndRegionId(publishId, regionId);

		if (count == 0) {
			return null;
		}

		List<BridgePublish> list = findByPublishIdAndRegionId(publishId,
				regionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publishs before and after the current bridge publish in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param bridgePublishId the primary key of the current bridge publish
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish[] findByPublishIdAndRegionId_PrevAndNext(
		long bridgePublishId, long publishId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = findByPrimaryKey(bridgePublishId);

		Session session = null;

		try {
			session = openSession();

			BridgePublish[] array = new BridgePublishImpl[3];

			array[0] = getByPublishIdAndRegionId_PrevAndNext(session,
					bridgePublish, publishId, regionId, orderByComparator, true);

			array[1] = bridgePublish;

			array[2] = getByPublishIdAndRegionId_PrevAndNext(session,
					bridgePublish, publishId, regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BridgePublish getByPublishIdAndRegionId_PrevAndNext(
		Session session, BridgePublish bridgePublish, long publishId,
		long regionId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPUBLISH_WHERE);

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
			query.append(BridgePublishModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublish);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublish> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publishs where publishId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishIdAndRegionId(long publishId, long regionId)
		throws SystemException {
		for (BridgePublish bridgePublish : findByPublishIdAndRegionId(
				publishId, regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublish);
		}
	}

	/**
	 * Returns the number of bridge publishs where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the number of matching bridge publishs
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

			query.append(_SQL_COUNT_BRIDGEPUBLISH_WHERE);

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

	private static final String _FINDER_COLUMN_PUBLISHIDANDREGIONID_PUBLISHID_2 = "bridgePublish.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDANDREGIONID_REGIONID_2 = "bridgePublish.regionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPublishIdRegionIdAndStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			BridgePublishModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishModelImpl.REGIONID_COLUMN_BITMASK |
			BridgePublishModelImpl.STANDARDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDANDSTDID =
		new FinderPath(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishIdRegionIdAndStdId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param standardId the standard ID
	 * @return the matching bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPublishIdRegionIdAndStdId(long publishId,
		long regionId, long standardId)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPublishIdRegionIdAndStdId(publishId,
				regionId, standardId);

		if (bridgePublish == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishId=");
			msg.append(publishId);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(", standardId=");
			msg.append(standardId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgePublishException(msg.toString());
		}

		return bridgePublish;
	}

	/**
	 * Returns the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param standardId the standard ID
	 * @return the matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishIdRegionIdAndStdId(long publishId,
		long regionId, long standardId) throws SystemException {
		return fetchByPublishIdRegionIdAndStdId(publishId, regionId,
			standardId, true);
	}

	/**
	 * Returns the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param standardId the standard ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge publish, or <code>null</code> if a matching bridge publish could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPublishIdRegionIdAndStdId(long publishId,
		long regionId, long standardId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { publishId, regionId, standardId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
					finderArgs, this);
		}

		if (result instanceof BridgePublish) {
			BridgePublish bridgePublish = (BridgePublish)result;

			if ((publishId != bridgePublish.getPublishId()) ||
					(regionId != bridgePublish.getRegionId()) ||
					(standardId != bridgePublish.getStandardId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_BRIDGEPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_STANDARDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(standardId);

				List<BridgePublish> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgePublishPersistenceImpl.fetchByPublishIdRegionIdAndStdId(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgePublish bridgePublish = list.get(0);

					result = bridgePublish;

					cacheResult(bridgePublish);

					if ((bridgePublish.getPublishId() != publishId) ||
							(bridgePublish.getRegionId() != regionId) ||
							(bridgePublish.getStandardId() != standardId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
							finderArgs, bridgePublish);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
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
			return (BridgePublish)result;
		}
	}

	/**
	 * Removes the bridge publish where publishId = &#63; and regionId = &#63; and standardId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param standardId the standard ID
	 * @return the bridge publish that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish removeByPublishIdRegionIdAndStdId(long publishId,
		long regionId, long standardId)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = findByPublishIdRegionIdAndStdId(publishId,
				regionId, standardId);

		return remove(bridgePublish);
	}

	/**
	 * Returns the number of bridge publishs where publishId = &#63; and regionId = &#63; and standardId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param standardId the standard ID
	 * @return the number of matching bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishIdRegionIdAndStdId(long publishId, long regionId,
		long standardId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDANDSTDID;

		Object[] finderArgs = new Object[] { publishId, regionId, standardId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_BRIDGEPUBLISH_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_PUBLISHID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_REGIONID_2);

			query.append(_FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_STANDARDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				qPos.add(standardId);

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

	private static final String _FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_PUBLISHID_2 =
		"bridgePublish.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_REGIONID_2 =
		"bridgePublish.regionId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHIDREGIONIDANDSTDID_STANDARDID_2 =
		"bridgePublish.standardId = ?";

	public BridgePublishPersistenceImpl() {
		setModelClass(BridgePublish.class);
	}

	/**
	 * Caches the bridge publish in the entity cache if it is enabled.
	 *
	 * @param bridgePublish the bridge publish
	 */
	@Override
	public void cacheResult(BridgePublish bridgePublish) {
		EntityCacheUtil.putResult(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImpl.class, bridgePublish.getPrimaryKey(),
			bridgePublish);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
			new Object[] {
				bridgePublish.getPublishId(), bridgePublish.getRegionId(),
				bridgePublish.getStandardId()
			}, bridgePublish);

		bridgePublish.resetOriginalValues();
	}

	/**
	 * Caches the bridge publishs in the entity cache if it is enabled.
	 *
	 * @param bridgePublishs the bridge publishs
	 */
	@Override
	public void cacheResult(List<BridgePublish> bridgePublishs) {
		for (BridgePublish bridgePublish : bridgePublishs) {
			if (EntityCacheUtil.getResult(
						BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishImpl.class, bridgePublish.getPrimaryKey()) == null) {
				cacheResult(bridgePublish);
			}
			else {
				bridgePublish.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publishs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgePublish bridgePublish) {
		EntityCacheUtil.removeResult(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImpl.class, bridgePublish.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgePublish);
	}

	@Override
	public void clearCache(List<BridgePublish> bridgePublishs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublish bridgePublish : bridgePublishs) {
			EntityCacheUtil.removeResult(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishImpl.class, bridgePublish.getPrimaryKey());

			clearUniqueFindersCache(bridgePublish);
		}
	}

	protected void cacheUniqueFindersCache(BridgePublish bridgePublish) {
		if (bridgePublish.isNew()) {
			Object[] args = new Object[] {
					bridgePublish.getPublishId(), bridgePublish.getRegionId(),
					bridgePublish.getStandardId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDANDSTDID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
				args, bridgePublish);
		}
		else {
			BridgePublishModelImpl bridgePublishModelImpl = (BridgePublishModelImpl)bridgePublish;

			if ((bridgePublishModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublish.getPublishId(),
						bridgePublish.getRegionId(),
						bridgePublish.getStandardId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDANDSTDID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
					args, bridgePublish);
			}
		}
	}

	protected void clearUniqueFindersCache(BridgePublish bridgePublish) {
		BridgePublishModelImpl bridgePublishModelImpl = (BridgePublishModelImpl)bridgePublish;

		Object[] args = new Object[] {
				bridgePublish.getPublishId(), bridgePublish.getRegionId(),
				bridgePublish.getStandardId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDANDSTDID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
			args);

		if ((bridgePublishModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgePublishModelImpl.getOriginalPublishId(),
					bridgePublishModelImpl.getOriginalRegionId(),
					bridgePublishModelImpl.getOriginalStandardId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDREGIONIDANDSTDID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHIDREGIONIDANDSTDID,
				args);
		}
	}

	/**
	 * Creates a new bridge publish with the primary key. Does not add the bridge publish to the database.
	 *
	 * @param bridgePublishId the primary key for the new bridge publish
	 * @return the new bridge publish
	 */
	@Override
	public BridgePublish create(long bridgePublishId) {
		BridgePublish bridgePublish = new BridgePublishImpl();

		bridgePublish.setNew(true);
		bridgePublish.setPrimaryKey(bridgePublishId);

		return bridgePublish;
	}

	/**
	 * Removes the bridge publish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bridgePublishId the primary key of the bridge publish
	 * @return the bridge publish that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish remove(long bridgePublishId)
		throws NoSuchBridgePublishException, SystemException {
		return remove((Serializable)bridgePublishId);
	}

	/**
	 * Removes the bridge publish with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish
	 * @return the bridge publish that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish remove(Serializable primaryKey)
		throws NoSuchBridgePublishException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublish bridgePublish = (BridgePublish)session.get(BridgePublishImpl.class,
					primaryKey);

			if (bridgePublish == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublish);
		}
		catch (NoSuchBridgePublishException nsee) {
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
	protected BridgePublish removeImpl(BridgePublish bridgePublish)
		throws SystemException {
		bridgePublish = toUnwrappedModel(bridgePublish);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublish)) {
				bridgePublish = (BridgePublish)session.get(BridgePublishImpl.class,
						bridgePublish.getPrimaryKeyObj());
			}

			if (bridgePublish != null) {
				session.delete(bridgePublish);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublish != null) {
			clearCache(bridgePublish);
		}

		return bridgePublish;
	}

	@Override
	public BridgePublish updateImpl(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish)
		throws SystemException {
		bridgePublish = toUnwrappedModel(bridgePublish);

		boolean isNew = bridgePublish.isNew();

		BridgePublishModelImpl bridgePublishModelImpl = (BridgePublishModelImpl)bridgePublish;

		Session session = null;

		try {
			session = openSession();

			if (bridgePublish.isNew()) {
				session.save(bridgePublish);

				bridgePublish.setNew(false);
			}
			else {
				session.merge(bridgePublish);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BridgePublishModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bridgePublishModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);

				args = new Object[] { bridgePublishModelImpl.getPublishId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);
			}

			if ((bridgePublishModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishModelImpl.getOriginalPublishId(),
						bridgePublishModelImpl.getOriginalStandardId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID,
					args);

				args = new Object[] {
						bridgePublishModelImpl.getPublishId(),
						bridgePublishModelImpl.getStandardId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDSTDID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDSTDID,
					args);
			}

			if ((bridgePublishModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishModelImpl.getOriginalPublishId(),
						bridgePublishModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID,
					args);

				args = new Object[] {
						bridgePublishModelImpl.getPublishId(),
						bridgePublishModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHIDANDREGIONID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHIDANDREGIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishImpl.class, bridgePublish.getPrimaryKey(),
			bridgePublish);

		clearUniqueFindersCache(bridgePublish);
		cacheUniqueFindersCache(bridgePublish);

		return bridgePublish;
	}

	protected BridgePublish toUnwrappedModel(BridgePublish bridgePublish) {
		if (bridgePublish instanceof BridgePublishImpl) {
			return bridgePublish;
		}

		BridgePublishImpl bridgePublishImpl = new BridgePublishImpl();

		bridgePublishImpl.setNew(bridgePublish.isNew());
		bridgePublishImpl.setPrimaryKey(bridgePublish.getPrimaryKey());

		bridgePublishImpl.setBridgePublishId(bridgePublish.getBridgePublishId());
		bridgePublishImpl.setPublishId(bridgePublish.getPublishId());
		bridgePublishImpl.setStandardId(bridgePublish.getStandardId());
		bridgePublishImpl.setRegionId(bridgePublish.getRegionId());
		bridgePublishImpl.setUnpublishInd(bridgePublish.getUnpublishInd());
		bridgePublishImpl.setCreatorId(bridgePublish.getCreatorId());
		bridgePublishImpl.setCreatedDate(bridgePublish.getCreatedDate());
		bridgePublishImpl.setUpdatedBy(bridgePublish.getUpdatedBy());
		bridgePublishImpl.setUpdatedDate(bridgePublish.getUpdatedDate());

		return bridgePublishImpl;
	}

	/**
	 * Returns the bridge publish with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish
	 * @return the bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishException, SystemException {
		BridgePublish bridgePublish = fetchByPrimaryKey(primaryKey);

		if (bridgePublish == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublish;
	}

	/**
	 * Returns the bridge publish with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishException} if it could not be found.
	 *
	 * @param bridgePublishId the primary key of the bridge publish
	 * @return the bridge publish
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishException if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish findByPrimaryKey(long bridgePublishId)
		throws NoSuchBridgePublishException, SystemException {
		return findByPrimaryKey((Serializable)bridgePublishId);
	}

	/**
	 * Returns the bridge publish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish
	 * @return the bridge publish, or <code>null</code> if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgePublish bridgePublish = (BridgePublish)EntityCacheUtil.getResult(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishImpl.class, primaryKey);

		if (bridgePublish == _nullBridgePublish) {
			return null;
		}

		if (bridgePublish == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublish = (BridgePublish)session.get(BridgePublishImpl.class,
						primaryKey);

				if (bridgePublish != null) {
					cacheResult(bridgePublish);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishImpl.class, primaryKey, _nullBridgePublish);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublish;
	}

	/**
	 * Returns the bridge publish with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bridgePublishId the primary key of the bridge publish
	 * @return the bridge publish, or <code>null</code> if a bridge publish with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublish fetchByPrimaryKey(long bridgePublishId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)bridgePublishId);
	}

	/**
	 * Returns all the bridge publishs.
	 *
	 * @return the bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publishs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @return the range of bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publishs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publishs
	 * @param end the upper bound of the range of bridge publishs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publishs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublish> findAll(int start, int end,
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

		List<BridgePublish> list = (List<BridgePublish>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISH);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISH;

				if (pagination) {
					sql = sql.concat(BridgePublishModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublish>(list);
				}
				else {
					list = (List<BridgePublish>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bridge publishs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublish bridgePublish : findAll()) {
			remove(bridgePublish);
		}
	}

	/**
	 * Returns the number of bridge publishs.
	 *
	 * @return the number of bridge publishs
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISH);

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
	 * Initializes the bridge publish persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublish")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublish>> listenersList = new ArrayList<ModelListener<BridgePublish>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublish>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISH = "SELECT bridgePublish FROM BridgePublish bridgePublish";
	private static final String _SQL_SELECT_BRIDGEPUBLISH_WHERE = "SELECT bridgePublish FROM BridgePublish bridgePublish WHERE ";
	private static final String _SQL_COUNT_BRIDGEPUBLISH = "SELECT COUNT(bridgePublish) FROM BridgePublish bridgePublish";
	private static final String _SQL_COUNT_BRIDGEPUBLISH_WHERE = "SELECT COUNT(bridgePublish) FROM BridgePublish bridgePublish WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublish.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublish exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgePublish exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"bridgePublishId", "publishId", "standardId", "regionId",
				"unpublishInd", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static BridgePublish _nullBridgePublish = new BridgePublishImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublish> toCacheModel() {
				return _nullBridgePublishCacheModel;
			}
		};

	private static CacheModel<BridgePublish> _nullBridgePublishCacheModel = new CacheModel<BridgePublish>() {
			@Override
			public BridgePublish toEntityModel() {
				return _nullBridgePublish;
			}
		};
}