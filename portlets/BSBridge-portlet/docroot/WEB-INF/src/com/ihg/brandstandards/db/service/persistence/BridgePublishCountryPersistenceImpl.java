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

import com.ihg.brandstandards.db.NoSuchBridgePublishCountryException;
import com.ihg.brandstandards.db.model.BridgePublishCountry;
import com.ihg.brandstandards.db.model.impl.BridgePublishCountryImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl;

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
 * The persistence implementation for the bridge publish country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishCountryPersistence
 * @see BridgePublishCountryUtil
 * @generated
 */
public class BridgePublishCountryPersistenceImpl extends BasePersistenceImpl<BridgePublishCountry>
	implements BridgePublishCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishCountryUtil} to access the bridge publish country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishId",
			new String[] { Long.class.getName() },
			BridgePublishCountryModelImpl.BRIDGEPUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHID = new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bridge publish countries where bridgePublishId = &#63;.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @return the matching bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountry> findByPublishId(long bridgePublishId)
		throws SystemException {
		return findByPublishId(bridgePublishId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish countries where bridgePublishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param start the lower bound of the range of bridge publish countries
	 * @param end the upper bound of the range of bridge publish countries (not inclusive)
	 * @return the range of matching bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountry> findByPublishId(long bridgePublishId,
		int start, int end) throws SystemException {
		return findByPublishId(bridgePublishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish countries where bridgePublishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param start the lower bound of the range of bridge publish countries
	 * @param end the upper bound of the range of bridge publish countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountry> findByPublishId(long bridgePublishId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID;
			finderArgs = new Object[] { bridgePublishId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID;
			finderArgs = new Object[] {
					bridgePublishId,
					
					start, end, orderByComparator
				};
		}

		List<BridgePublishCountry> list = (List<BridgePublishCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublishCountry bridgePublishCountry : list) {
				if ((bridgePublishId != bridgePublishCountry.getBridgePublishId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_BRIDGEPUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bridgePublishId);

				if (!pagination) {
					list = (List<BridgePublishCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishCountry>(list);
				}
				else {
					list = (List<BridgePublishCountry>)QueryUtil.list(q,
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
	 * Returns the first bridge publish country in the ordered set where bridgePublishId = &#63;.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a matching bridge publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry findByPublishId_First(long bridgePublishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishCountryException, SystemException {
		BridgePublishCountry bridgePublishCountry = fetchByPublishId_First(bridgePublishId,
				orderByComparator);

		if (bridgePublishCountry != null) {
			return bridgePublishCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bridgePublishId=");
		msg.append(bridgePublishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishCountryException(msg.toString());
	}

	/**
	 * Returns the first bridge publish country in the ordered set where bridgePublishId = &#63;.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry fetchByPublishId_First(long bridgePublishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BridgePublishCountry> list = findByPublishId(bridgePublishId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish country in the ordered set where bridgePublishId = &#63;.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a matching bridge publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry findByPublishId_Last(long bridgePublishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishCountryException, SystemException {
		BridgePublishCountry bridgePublishCountry = fetchByPublishId_Last(bridgePublishId,
				orderByComparator);

		if (bridgePublishCountry != null) {
			return bridgePublishCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bridgePublishId=");
		msg.append(bridgePublishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishCountryException(msg.toString());
	}

	/**
	 * Returns the last bridge publish country in the ordered set where bridgePublishId = &#63;.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry fetchByPublishId_Last(long bridgePublishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishId(bridgePublishId);

		if (count == 0) {
			return null;
		}

		List<BridgePublishCountry> list = findByPublishId(bridgePublishId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publish countries before and after the current bridge publish country in the ordered set where bridgePublishId = &#63;.
	 *
	 * @param publishCtryId the primary key of the current bridge publish country
	 * @param bridgePublishId the bridge publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry[] findByPublishId_PrevAndNext(
		long publishCtryId, long bridgePublishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishCountryException, SystemException {
		BridgePublishCountry bridgePublishCountry = findByPrimaryKey(publishCtryId);

		Session session = null;

		try {
			session = openSession();

			BridgePublishCountry[] array = new BridgePublishCountryImpl[3];

			array[0] = getByPublishId_PrevAndNext(session,
					bridgePublishCountry, bridgePublishId, orderByComparator,
					true);

			array[1] = bridgePublishCountry;

			array[2] = getByPublishId_PrevAndNext(session,
					bridgePublishCountry, bridgePublishId, orderByComparator,
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

	protected BridgePublishCountry getByPublishId_PrevAndNext(Session session,
		BridgePublishCountry bridgePublishCountry, long bridgePublishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPUBLISHCOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHID_BRIDGEPUBLISHID_2);

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
			query.append(BridgePublishCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(bridgePublishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublishCountry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublishCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publish countries where bridgePublishId = &#63; from the database.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishId(long bridgePublishId)
		throws SystemException {
		for (BridgePublishCountry bridgePublishCountry : findByPublishId(
				bridgePublishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublishCountry);
		}
	}

	/**
	 * Returns the number of bridge publish countries where bridgePublishId = &#63;.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @return the number of matching bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishId(long bridgePublishId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHID;

		Object[] finderArgs = new Object[] { bridgePublishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BRIDGEPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_BRIDGEPUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bridgePublishId);

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

	private static final String _FINDER_COLUMN_PUBLISHID_BRIDGEPUBLISHID_2 = "bridgePublishCountry.bridgePublishId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE =
		new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishCountryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByBridgePublishIdAndCountryCode",
			new String[] { Long.class.getName(), String.class.getName() },
			BridgePublishCountryModelImpl.BRIDGEPUBLISHID_COLUMN_BITMASK |
			BridgePublishCountryModelImpl.COUNTRYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE =
		new FinderPath(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBridgePublishIdAndCountryCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishCountryException} if it could not be found.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param countryCode the country code
	 * @return the matching bridge publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a matching bridge publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry findByBridgePublishIdAndCountryCode(
		long bridgePublishId, String countryCode)
		throws NoSuchBridgePublishCountryException, SystemException {
		BridgePublishCountry bridgePublishCountry = fetchByBridgePublishIdAndCountryCode(bridgePublishId,
				countryCode);

		if (bridgePublishCountry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("bridgePublishId=");
			msg.append(bridgePublishId);

			msg.append(", countryCode=");
			msg.append(countryCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgePublishCountryException(msg.toString());
		}

		return bridgePublishCountry;
	}

	/**
	 * Returns the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param countryCode the country code
	 * @return the matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry fetchByBridgePublishIdAndCountryCode(
		long bridgePublishId, String countryCode) throws SystemException {
		return fetchByBridgePublishIdAndCountryCode(bridgePublishId,
			countryCode, true);
	}

	/**
	 * Returns the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param countryCode the country code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge publish country, or <code>null</code> if a matching bridge publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry fetchByBridgePublishIdAndCountryCode(
		long bridgePublishId, String countryCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { bridgePublishId, countryCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
					finderArgs, this);
		}

		if (result instanceof BridgePublishCountry) {
			BridgePublishCountry bridgePublishCountry = (BridgePublishCountry)result;

			if ((bridgePublishId != bridgePublishCountry.getBridgePublishId()) ||
					!Validator.equals(countryCode,
						bridgePublishCountry.getCountryCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BRIDGEPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_BRIDGEPUBLISHID_2);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bridgePublishId);

				if (bindCountryCode) {
					qPos.add(countryCode);
				}

				List<BridgePublishCountry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgePublishCountryPersistenceImpl.fetchByBridgePublishIdAndCountryCode(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgePublishCountry bridgePublishCountry = list.get(0);

					result = bridgePublishCountry;

					cacheResult(bridgePublishCountry);

					if ((bridgePublishCountry.getBridgePublishId() != bridgePublishId) ||
							(bridgePublishCountry.getCountryCode() == null) ||
							!bridgePublishCountry.getCountryCode()
													 .equals(countryCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
							finderArgs, bridgePublishCountry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
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
			return (BridgePublishCountry)result;
		}
	}

	/**
	 * Removes the bridge publish country where bridgePublishId = &#63; and countryCode = &#63; from the database.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param countryCode the country code
	 * @return the bridge publish country that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry removeByBridgePublishIdAndCountryCode(
		long bridgePublishId, String countryCode)
		throws NoSuchBridgePublishCountryException, SystemException {
		BridgePublishCountry bridgePublishCountry = findByBridgePublishIdAndCountryCode(bridgePublishId,
				countryCode);

		return remove(bridgePublishCountry);
	}

	/**
	 * Returns the number of bridge publish countries where bridgePublishId = &#63; and countryCode = &#63;.
	 *
	 * @param bridgePublishId the bridge publish ID
	 * @param countryCode the country code
	 * @return the number of matching bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBridgePublishIdAndCountryCode(long bridgePublishId,
		String countryCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE;

		Object[] finderArgs = new Object[] { bridgePublishId, countryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_BRIDGEPUBLISHID_2);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(bridgePublishId);

				if (bindCountryCode) {
					qPos.add(countryCode);
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

	private static final String _FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_BRIDGEPUBLISHID_2 =
		"bridgePublishCountry.bridgePublishId = ? AND ";
	private static final String _FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_1 =
		"bridgePublishCountry.countryCode IS NULL";
	private static final String _FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_2 =
		"bridgePublishCountry.countryCode = ?";
	private static final String _FINDER_COLUMN_BRIDGEPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_3 =
		"(bridgePublishCountry.countryCode IS NULL OR bridgePublishCountry.countryCode = '')";

	public BridgePublishCountryPersistenceImpl() {
		setModelClass(BridgePublishCountry.class);
	}

	/**
	 * Caches the bridge publish country in the entity cache if it is enabled.
	 *
	 * @param bridgePublishCountry the bridge publish country
	 */
	@Override
	public void cacheResult(BridgePublishCountry bridgePublishCountry) {
		EntityCacheUtil.putResult(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryImpl.class,
			bridgePublishCountry.getPrimaryKey(), bridgePublishCountry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
			new Object[] {
				bridgePublishCountry.getBridgePublishId(),
				bridgePublishCountry.getCountryCode()
			}, bridgePublishCountry);

		bridgePublishCountry.resetOriginalValues();
	}

	/**
	 * Caches the bridge publish countries in the entity cache if it is enabled.
	 *
	 * @param bridgePublishCountries the bridge publish countries
	 */
	@Override
	public void cacheResult(List<BridgePublishCountry> bridgePublishCountries) {
		for (BridgePublishCountry bridgePublishCountry : bridgePublishCountries) {
			if (EntityCacheUtil.getResult(
						BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishCountryImpl.class,
						bridgePublishCountry.getPrimaryKey()) == null) {
				cacheResult(bridgePublishCountry);
			}
			else {
				bridgePublishCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publish countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgePublishCountry bridgePublishCountry) {
		EntityCacheUtil.removeResult(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryImpl.class, bridgePublishCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgePublishCountry);
	}

	@Override
	public void clearCache(List<BridgePublishCountry> bridgePublishCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublishCountry bridgePublishCountry : bridgePublishCountries) {
			EntityCacheUtil.removeResult(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishCountryImpl.class,
				bridgePublishCountry.getPrimaryKey());

			clearUniqueFindersCache(bridgePublishCountry);
		}
	}

	protected void cacheUniqueFindersCache(
		BridgePublishCountry bridgePublishCountry) {
		if (bridgePublishCountry.isNew()) {
			Object[] args = new Object[] {
					bridgePublishCountry.getBridgePublishId(),
					bridgePublishCountry.getCountryCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
				args, bridgePublishCountry);
		}
		else {
			BridgePublishCountryModelImpl bridgePublishCountryModelImpl = (BridgePublishCountryModelImpl)bridgePublishCountry;

			if ((bridgePublishCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishCountry.getBridgePublishId(),
						bridgePublishCountry.getCountryCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
					args, bridgePublishCountry);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BridgePublishCountry bridgePublishCountry) {
		BridgePublishCountryModelImpl bridgePublishCountryModelImpl = (BridgePublishCountryModelImpl)bridgePublishCountry;

		Object[] args = new Object[] {
				bridgePublishCountry.getBridgePublishId(),
				bridgePublishCountry.getCountryCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
			args);

		if ((bridgePublishCountryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgePublishCountryModelImpl.getOriginalBridgePublishId(),
					bridgePublishCountryModelImpl.getOriginalCountryCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BRIDGEPUBLISHIDANDCOUNTRYCODE,
				args);
		}
	}

	/**
	 * Creates a new bridge publish country with the primary key. Does not add the bridge publish country to the database.
	 *
	 * @param publishCtryId the primary key for the new bridge publish country
	 * @return the new bridge publish country
	 */
	@Override
	public BridgePublishCountry create(long publishCtryId) {
		BridgePublishCountry bridgePublishCountry = new BridgePublishCountryImpl();

		bridgePublishCountry.setNew(true);
		bridgePublishCountry.setPrimaryKey(publishCtryId);

		return bridgePublishCountry;
	}

	/**
	 * Removes the bridge publish country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishCtryId the primary key of the bridge publish country
	 * @return the bridge publish country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry remove(long publishCtryId)
		throws NoSuchBridgePublishCountryException, SystemException {
		return remove((Serializable)publishCtryId);
	}

	/**
	 * Removes the bridge publish country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish country
	 * @return the bridge publish country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry remove(Serializable primaryKey)
		throws NoSuchBridgePublishCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublishCountry bridgePublishCountry = (BridgePublishCountry)session.get(BridgePublishCountryImpl.class,
					primaryKey);

			if (bridgePublishCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublishCountry);
		}
		catch (NoSuchBridgePublishCountryException nsee) {
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
	protected BridgePublishCountry removeImpl(
		BridgePublishCountry bridgePublishCountry) throws SystemException {
		bridgePublishCountry = toUnwrappedModel(bridgePublishCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublishCountry)) {
				bridgePublishCountry = (BridgePublishCountry)session.get(BridgePublishCountryImpl.class,
						bridgePublishCountry.getPrimaryKeyObj());
			}

			if (bridgePublishCountry != null) {
				session.delete(bridgePublishCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublishCountry != null) {
			clearCache(bridgePublishCountry);
		}

		return bridgePublishCountry;
	}

	@Override
	public BridgePublishCountry updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishCountry bridgePublishCountry)
		throws SystemException {
		bridgePublishCountry = toUnwrappedModel(bridgePublishCountry);

		boolean isNew = bridgePublishCountry.isNew();

		BridgePublishCountryModelImpl bridgePublishCountryModelImpl = (BridgePublishCountryModelImpl)bridgePublishCountry;

		Session session = null;

		try {
			session = openSession();

			if (bridgePublishCountry.isNew()) {
				session.save(bridgePublishCountry);

				bridgePublishCountry.setNew(false);
			}
			else {
				session.merge(bridgePublishCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BridgePublishCountryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bridgePublishCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishCountryModelImpl.getOriginalBridgePublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);

				args = new Object[] {
						bridgePublishCountryModelImpl.getBridgePublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);
			}
		}

		EntityCacheUtil.putResult(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryImpl.class,
			bridgePublishCountry.getPrimaryKey(), bridgePublishCountry);

		clearUniqueFindersCache(bridgePublishCountry);
		cacheUniqueFindersCache(bridgePublishCountry);

		return bridgePublishCountry;
	}

	protected BridgePublishCountry toUnwrappedModel(
		BridgePublishCountry bridgePublishCountry) {
		if (bridgePublishCountry instanceof BridgePublishCountryImpl) {
			return bridgePublishCountry;
		}

		BridgePublishCountryImpl bridgePublishCountryImpl = new BridgePublishCountryImpl();

		bridgePublishCountryImpl.setNew(bridgePublishCountry.isNew());
		bridgePublishCountryImpl.setPrimaryKey(bridgePublishCountry.getPrimaryKey());

		bridgePublishCountryImpl.setPublishCtryId(bridgePublishCountry.getPublishCtryId());
		bridgePublishCountryImpl.setBridgePublishId(bridgePublishCountry.getBridgePublishId());
		bridgePublishCountryImpl.setCountryCode(bridgePublishCountry.getCountryCode());
		bridgePublishCountryImpl.setStatusCode(bridgePublishCountry.getStatusCode());
		bridgePublishCountryImpl.setPublishInd(bridgePublishCountry.getPublishInd());
		bridgePublishCountryImpl.setCreatorId(bridgePublishCountry.getCreatorId());
		bridgePublishCountryImpl.setCreatedDate(bridgePublishCountry.getCreatedDate());
		bridgePublishCountryImpl.setUpdatedBy(bridgePublishCountry.getUpdatedBy());
		bridgePublishCountryImpl.setUpdatedDate(bridgePublishCountry.getUpdatedDate());

		return bridgePublishCountryImpl;
	}

	/**
	 * Returns the bridge publish country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish country
	 * @return the bridge publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishCountryException, SystemException {
		BridgePublishCountry bridgePublishCountry = fetchByPrimaryKey(primaryKey);

		if (bridgePublishCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublishCountry;
	}

	/**
	 * Returns the bridge publish country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishCountryException} if it could not be found.
	 *
	 * @param publishCtryId the primary key of the bridge publish country
	 * @return the bridge publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryException if a bridge publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry findByPrimaryKey(long publishCtryId)
		throws NoSuchBridgePublishCountryException, SystemException {
		return findByPrimaryKey((Serializable)publishCtryId);
	}

	/**
	 * Returns the bridge publish country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish country
	 * @return the bridge publish country, or <code>null</code> if a bridge publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgePublishCountry bridgePublishCountry = (BridgePublishCountry)EntityCacheUtil.getResult(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishCountryImpl.class, primaryKey);

		if (bridgePublishCountry == _nullBridgePublishCountry) {
			return null;
		}

		if (bridgePublishCountry == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublishCountry = (BridgePublishCountry)session.get(BridgePublishCountryImpl.class,
						primaryKey);

				if (bridgePublishCountry != null) {
					cacheResult(bridgePublishCountry);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishCountryImpl.class, primaryKey,
						_nullBridgePublishCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishCountryModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublishCountry;
	}

	/**
	 * Returns the bridge publish country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishCtryId the primary key of the bridge publish country
	 * @return the bridge publish country, or <code>null</code> if a bridge publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountry fetchByPrimaryKey(long publishCtryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishCtryId);
	}

	/**
	 * Returns all the bridge publish countries.
	 *
	 * @return the bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish countries
	 * @param end the upper bound of the range of bridge publish countries (not inclusive)
	 * @return the range of bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish countries
	 * @param end the upper bound of the range of bridge publish countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountry> findAll(int start, int end,
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

		List<BridgePublishCountry> list = (List<BridgePublishCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISHCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISHCOUNTRY;

				if (pagination) {
					sql = sql.concat(BridgePublishCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublishCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishCountry>(list);
				}
				else {
					list = (List<BridgePublishCountry>)QueryUtil.list(q,
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
	 * Removes all the bridge publish countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublishCountry bridgePublishCountry : findAll()) {
			remove(bridgePublishCountry);
		}
	}

	/**
	 * Returns the number of bridge publish countries.
	 *
	 * @return the number of bridge publish countries
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISHCOUNTRY);

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
	 * Initializes the bridge publish country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublishCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublishCountry>> listenersList = new ArrayList<ModelListener<BridgePublishCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublishCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISHCOUNTRY = "SELECT bridgePublishCountry FROM BridgePublishCountry bridgePublishCountry";
	private static final String _SQL_SELECT_BRIDGEPUBLISHCOUNTRY_WHERE = "SELECT bridgePublishCountry FROM BridgePublishCountry bridgePublishCountry WHERE ";
	private static final String _SQL_COUNT_BRIDGEPUBLISHCOUNTRY = "SELECT COUNT(bridgePublishCountry) FROM BridgePublishCountry bridgePublishCountry";
	private static final String _SQL_COUNT_BRIDGEPUBLISHCOUNTRY_WHERE = "SELECT COUNT(bridgePublishCountry) FROM BridgePublishCountry bridgePublishCountry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublishCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublishCountry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgePublishCountry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishCountryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishCtryId", "bridgePublishId", "countryCode", "statusCode",
				"publishInd", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static BridgePublishCountry _nullBridgePublishCountry = new BridgePublishCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublishCountry> toCacheModel() {
				return _nullBridgePublishCountryCacheModel;
			}
		};

	private static CacheModel<BridgePublishCountry> _nullBridgePublishCountryCacheModel =
		new CacheModel<BridgePublishCountry>() {
			@Override
			public BridgePublishCountry toEntityModel() {
				return _nullBridgePublishCountry;
			}
		};
}