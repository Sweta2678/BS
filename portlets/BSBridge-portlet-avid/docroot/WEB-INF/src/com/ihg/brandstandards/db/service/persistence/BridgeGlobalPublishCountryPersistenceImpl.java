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

import com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry;
import com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryImpl;
import com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl;

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
 * The persistence implementation for the bridge global publish country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishCountryPersistence
 * @see BridgeGlobalPublishCountryUtil
 * @generated
 */
public class BridgeGlobalPublishCountryPersistenceImpl
	extends BasePersistenceImpl<BridgeGlobalPublishCountry>
	implements BridgeGlobalPublishCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgeGlobalPublishCountryUtil} to access the bridge global publish country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgeGlobalPublishCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOBALPUBLISHID =
		new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGlobalPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALPUBLISHID =
		new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGlobalPublishId",
			new String[] { Long.class.getName() },
			BridgeGlobalPublishCountryModelImpl.GLOBALPUBLISHID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOBALPUBLISHID = new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGlobalPublishId", new String[] { Long.class.getName() });

	/**
	 * Returns all the bridge global publish countries where globalPublishId = &#63;.
	 *
	 * @param globalPublishId the global publish ID
	 * @return the matching bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId) throws SystemException {
		return findByGlobalPublishId(globalPublishId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge global publish countries where globalPublishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param globalPublishId the global publish ID
	 * @param start the lower bound of the range of bridge global publish countries
	 * @param end the upper bound of the range of bridge global publish countries (not inclusive)
	 * @return the range of matching bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId, int start, int end) throws SystemException {
		return findByGlobalPublishId(globalPublishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge global publish countries where globalPublishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param globalPublishId the global publish ID
	 * @param start the lower bound of the range of bridge global publish countries
	 * @param end the upper bound of the range of bridge global publish countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublishCountry> findByGlobalPublishId(
		long globalPublishId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALPUBLISHID;
			finderArgs = new Object[] { globalPublishId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOBALPUBLISHID;
			finderArgs = new Object[] {
					globalPublishId,
					
					start, end, orderByComparator
				};
		}

		List<BridgeGlobalPublishCountry> list = (List<BridgeGlobalPublishCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgeGlobalPublishCountry bridgeGlobalPublishCountry : list) {
				if ((globalPublishId != bridgeGlobalPublishCountry.getGlobalPublishId())) {
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

			query.append(_SQL_SELECT_BRIDGEGLOBALPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_GLOBALPUBLISHID_GLOBALPUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgeGlobalPublishCountryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(globalPublishId);

				if (!pagination) {
					list = (List<BridgeGlobalPublishCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeGlobalPublishCountry>(list);
				}
				else {
					list = (List<BridgeGlobalPublishCountry>)QueryUtil.list(q,
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
	 * Returns the first bridge global publish country in the ordered set where globalPublishId = &#63;.
	 *
	 * @param globalPublishId the global publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge global publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry findByGlobalPublishId_First(
		long globalPublishId, OrderByComparator orderByComparator)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = fetchByGlobalPublishId_First(globalPublishId,
				orderByComparator);

		if (bridgeGlobalPublishCountry != null) {
			return bridgeGlobalPublishCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("globalPublishId=");
		msg.append(globalPublishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeGlobalPublishCountryException(msg.toString());
	}

	/**
	 * Returns the first bridge global publish country in the ordered set where globalPublishId = &#63;.
	 *
	 * @param globalPublishId the global publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry fetchByGlobalPublishId_First(
		long globalPublishId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BridgeGlobalPublishCountry> list = findByGlobalPublishId(globalPublishId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge global publish country in the ordered set where globalPublishId = &#63;.
	 *
	 * @param globalPublishId the global publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge global publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry findByGlobalPublishId_Last(
		long globalPublishId, OrderByComparator orderByComparator)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = fetchByGlobalPublishId_Last(globalPublishId,
				orderByComparator);

		if (bridgeGlobalPublishCountry != null) {
			return bridgeGlobalPublishCountry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("globalPublishId=");
		msg.append(globalPublishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeGlobalPublishCountryException(msg.toString());
	}

	/**
	 * Returns the last bridge global publish country in the ordered set where globalPublishId = &#63;.
	 *
	 * @param globalPublishId the global publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry fetchByGlobalPublishId_Last(
		long globalPublishId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByGlobalPublishId(globalPublishId);

		if (count == 0) {
			return null;
		}

		List<BridgeGlobalPublishCountry> list = findByGlobalPublishId(globalPublishId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge global publish countries before and after the current bridge global publish country in the ordered set where globalPublishId = &#63;.
	 *
	 * @param globalPublishCtryId the primary key of the current bridge global publish country
	 * @param globalPublishId the global publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge global publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry[] findByGlobalPublishId_PrevAndNext(
		long globalPublishCtryId, long globalPublishId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = findByPrimaryKey(globalPublishCtryId);

		Session session = null;

		try {
			session = openSession();

			BridgeGlobalPublishCountry[] array = new BridgeGlobalPublishCountryImpl[3];

			array[0] = getByGlobalPublishId_PrevAndNext(session,
					bridgeGlobalPublishCountry, globalPublishId,
					orderByComparator, true);

			array[1] = bridgeGlobalPublishCountry;

			array[2] = getByGlobalPublishId_PrevAndNext(session,
					bridgeGlobalPublishCountry, globalPublishId,
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

	protected BridgeGlobalPublishCountry getByGlobalPublishId_PrevAndNext(
		Session session, BridgeGlobalPublishCountry bridgeGlobalPublishCountry,
		long globalPublishId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEGLOBALPUBLISHCOUNTRY_WHERE);

		query.append(_FINDER_COLUMN_GLOBALPUBLISHID_GLOBALPUBLISHID_2);

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
			query.append(BridgeGlobalPublishCountryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(globalPublishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgeGlobalPublishCountry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgeGlobalPublishCountry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge global publish countries where globalPublishId = &#63; from the database.
	 *
	 * @param globalPublishId the global publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGlobalPublishId(long globalPublishId)
		throws SystemException {
		for (BridgeGlobalPublishCountry bridgeGlobalPublishCountry : findByGlobalPublishId(
				globalPublishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgeGlobalPublishCountry);
		}
	}

	/**
	 * Returns the number of bridge global publish countries where globalPublishId = &#63;.
	 *
	 * @param globalPublishId the global publish ID
	 * @return the number of matching bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGlobalPublishId(long globalPublishId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOBALPUBLISHID;

		Object[] finderArgs = new Object[] { globalPublishId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BRIDGEGLOBALPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_GLOBALPUBLISHID_GLOBALPUBLISHID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(globalPublishId);

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

	private static final String _FINDER_COLUMN_GLOBALPUBLISHID_GLOBALPUBLISHID_2 =
		"bridgeGlobalPublishCountry.globalPublishId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE =
		new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByGlobalPublishIdAndCountryCode",
			new String[] { Long.class.getName(), String.class.getName() },
			BridgeGlobalPublishCountryModelImpl.GLOBALPUBLISHID_COLUMN_BITMASK |
			BridgeGlobalPublishCountryModelImpl.COUNTRYCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOBALPUBLISHIDANDCOUNTRYCODE =
		new FinderPath(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGlobalPublishIdAndCountryCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException} if it could not be found.
	 *
	 * @param globalPublishId the global publish ID
	 * @param countryCode the country code
	 * @return the matching bridge global publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a matching bridge global publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry findByGlobalPublishIdAndCountryCode(
		long globalPublishId, String countryCode)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = fetchByGlobalPublishIdAndCountryCode(globalPublishId,
				countryCode);

		if (bridgeGlobalPublishCountry == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("globalPublishId=");
			msg.append(globalPublishId);

			msg.append(", countryCode=");
			msg.append(countryCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgeGlobalPublishCountryException(msg.toString());
		}

		return bridgeGlobalPublishCountry;
	}

	/**
	 * Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param globalPublishId the global publish ID
	 * @param countryCode the country code
	 * @return the matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry fetchByGlobalPublishIdAndCountryCode(
		long globalPublishId, String countryCode) throws SystemException {
		return fetchByGlobalPublishIdAndCountryCode(globalPublishId,
			countryCode, true);
	}

	/**
	 * Returns the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param globalPublishId the global publish ID
	 * @param countryCode the country code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge global publish country, or <code>null</code> if a matching bridge global publish country could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry fetchByGlobalPublishIdAndCountryCode(
		long globalPublishId, String countryCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { globalPublishId, countryCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
					finderArgs, this);
		}

		if (result instanceof BridgeGlobalPublishCountry) {
			BridgeGlobalPublishCountry bridgeGlobalPublishCountry = (BridgeGlobalPublishCountry)result;

			if ((globalPublishId != bridgeGlobalPublishCountry.getGlobalPublishId()) ||
					!Validator.equals(countryCode,
						bridgeGlobalPublishCountry.getCountryCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BRIDGEGLOBALPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_GLOBALPUBLISHID_2);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(globalPublishId);

				if (bindCountryCode) {
					qPos.add(countryCode);
				}

				List<BridgeGlobalPublishCountry> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgeGlobalPublishCountryPersistenceImpl.fetchByGlobalPublishIdAndCountryCode(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgeGlobalPublishCountry bridgeGlobalPublishCountry = list.get(0);

					result = bridgeGlobalPublishCountry;

					cacheResult(bridgeGlobalPublishCountry);

					if ((bridgeGlobalPublishCountry.getGlobalPublishId() != globalPublishId) ||
							(bridgeGlobalPublishCountry.getCountryCode() == null) ||
							!bridgeGlobalPublishCountry.getCountryCode()
														   .equals(countryCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
							finderArgs, bridgeGlobalPublishCountry);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
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
			return (BridgeGlobalPublishCountry)result;
		}
	}

	/**
	 * Removes the bridge global publish country where globalPublishId = &#63; and countryCode = &#63; from the database.
	 *
	 * @param globalPublishId the global publish ID
	 * @param countryCode the country code
	 * @return the bridge global publish country that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry removeByGlobalPublishIdAndCountryCode(
		long globalPublishId, String countryCode)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = findByGlobalPublishIdAndCountryCode(globalPublishId,
				countryCode);

		return remove(bridgeGlobalPublishCountry);
	}

	/**
	 * Returns the number of bridge global publish countries where globalPublishId = &#63; and countryCode = &#63;.
	 *
	 * @param globalPublishId the global publish ID
	 * @param countryCode the country code
	 * @return the number of matching bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGlobalPublishIdAndCountryCode(long globalPublishId,
		String countryCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOBALPUBLISHIDANDCOUNTRYCODE;

		Object[] finderArgs = new Object[] { globalPublishId, countryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEGLOBALPUBLISHCOUNTRY_WHERE);

			query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_GLOBALPUBLISHID_2);

			boolean bindCountryCode = false;

			if (countryCode == null) {
				query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_1);
			}
			else if (countryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_3);
			}
			else {
				bindCountryCode = true;

				query.append(_FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(globalPublishId);

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

	private static final String _FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_GLOBALPUBLISHID_2 =
		"bridgeGlobalPublishCountry.globalPublishId = ? AND ";
	private static final String _FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_1 =
		"bridgeGlobalPublishCountry.countryCode IS NULL";
	private static final String _FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_2 =
		"bridgeGlobalPublishCountry.countryCode = ?";
	private static final String _FINDER_COLUMN_GLOBALPUBLISHIDANDCOUNTRYCODE_COUNTRYCODE_3 =
		"(bridgeGlobalPublishCountry.countryCode IS NULL OR bridgeGlobalPublishCountry.countryCode = '')";

	public BridgeGlobalPublishCountryPersistenceImpl() {
		setModelClass(BridgeGlobalPublishCountry.class);
	}

	/**
	 * Caches the bridge global publish country in the entity cache if it is enabled.
	 *
	 * @param bridgeGlobalPublishCountry the bridge global publish country
	 */
	@Override
	public void cacheResult(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		EntityCacheUtil.putResult(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class,
			bridgeGlobalPublishCountry.getPrimaryKey(),
			bridgeGlobalPublishCountry);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
			new Object[] {
				bridgeGlobalPublishCountry.getGlobalPublishId(),
				bridgeGlobalPublishCountry.getCountryCode()
			}, bridgeGlobalPublishCountry);

		bridgeGlobalPublishCountry.resetOriginalValues();
	}

	/**
	 * Caches the bridge global publish countries in the entity cache if it is enabled.
	 *
	 * @param bridgeGlobalPublishCountries the bridge global publish countries
	 */
	@Override
	public void cacheResult(
		List<BridgeGlobalPublishCountry> bridgeGlobalPublishCountries) {
		for (BridgeGlobalPublishCountry bridgeGlobalPublishCountry : bridgeGlobalPublishCountries) {
			if (EntityCacheUtil.getResult(
						BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
						BridgeGlobalPublishCountryImpl.class,
						bridgeGlobalPublishCountry.getPrimaryKey()) == null) {
				cacheResult(bridgeGlobalPublishCountry);
			}
			else {
				bridgeGlobalPublishCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge global publish countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgeGlobalPublishCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgeGlobalPublishCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge global publish country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		EntityCacheUtil.removeResult(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class,
			bridgeGlobalPublishCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgeGlobalPublishCountry);
	}

	@Override
	public void clearCache(
		List<BridgeGlobalPublishCountry> bridgeGlobalPublishCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgeGlobalPublishCountry bridgeGlobalPublishCountry : bridgeGlobalPublishCountries) {
			EntityCacheUtil.removeResult(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
				BridgeGlobalPublishCountryImpl.class,
				bridgeGlobalPublishCountry.getPrimaryKey());

			clearUniqueFindersCache(bridgeGlobalPublishCountry);
		}
	}

	protected void cacheUniqueFindersCache(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		if (bridgeGlobalPublishCountry.isNew()) {
			Object[] args = new Object[] {
					bridgeGlobalPublishCountry.getGlobalPublishId(),
					bridgeGlobalPublishCountry.getCountryCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
				args, bridgeGlobalPublishCountry);
		}
		else {
			BridgeGlobalPublishCountryModelImpl bridgeGlobalPublishCountryModelImpl =
				(BridgeGlobalPublishCountryModelImpl)bridgeGlobalPublishCountry;

			if ((bridgeGlobalPublishCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeGlobalPublishCountry.getGlobalPublishId(),
						bridgeGlobalPublishCountry.getCountryCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
					args, bridgeGlobalPublishCountry);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		BridgeGlobalPublishCountryModelImpl bridgeGlobalPublishCountryModelImpl = (BridgeGlobalPublishCountryModelImpl)bridgeGlobalPublishCountry;

		Object[] args = new Object[] {
				bridgeGlobalPublishCountry.getGlobalPublishId(),
				bridgeGlobalPublishCountry.getCountryCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
			args);

		if ((bridgeGlobalPublishCountryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgeGlobalPublishCountryModelImpl.getOriginalGlobalPublishId(),
					bridgeGlobalPublishCountryModelImpl.getOriginalCountryCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOBALPUBLISHIDANDCOUNTRYCODE,
				args);
		}
	}

	/**
	 * Creates a new bridge global publish country with the primary key. Does not add the bridge global publish country to the database.
	 *
	 * @param globalPublishCtryId the primary key for the new bridge global publish country
	 * @return the new bridge global publish country
	 */
	@Override
	public BridgeGlobalPublishCountry create(long globalPublishCtryId) {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = new BridgeGlobalPublishCountryImpl();

		bridgeGlobalPublishCountry.setNew(true);
		bridgeGlobalPublishCountry.setPrimaryKey(globalPublishCtryId);

		return bridgeGlobalPublishCountry;
	}

	/**
	 * Removes the bridge global publish country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param globalPublishCtryId the primary key of the bridge global publish country
	 * @return the bridge global publish country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry remove(long globalPublishCtryId)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		return remove((Serializable)globalPublishCtryId);
	}

	/**
	 * Removes the bridge global publish country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge global publish country
	 * @return the bridge global publish country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry remove(Serializable primaryKey)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgeGlobalPublishCountry bridgeGlobalPublishCountry = (BridgeGlobalPublishCountry)session.get(BridgeGlobalPublishCountryImpl.class,
					primaryKey);

			if (bridgeGlobalPublishCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgeGlobalPublishCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgeGlobalPublishCountry);
		}
		catch (NoSuchBridgeGlobalPublishCountryException nsee) {
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
	protected BridgeGlobalPublishCountry removeImpl(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws SystemException {
		bridgeGlobalPublishCountry = toUnwrappedModel(bridgeGlobalPublishCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgeGlobalPublishCountry)) {
				bridgeGlobalPublishCountry = (BridgeGlobalPublishCountry)session.get(BridgeGlobalPublishCountryImpl.class,
						bridgeGlobalPublishCountry.getPrimaryKeyObj());
			}

			if (bridgeGlobalPublishCountry != null) {
				session.delete(bridgeGlobalPublishCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgeGlobalPublishCountry != null) {
			clearCache(bridgeGlobalPublishCountry);
		}

		return bridgeGlobalPublishCountry;
	}

	@Override
	public BridgeGlobalPublishCountry updateImpl(
		com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry bridgeGlobalPublishCountry)
		throws SystemException {
		bridgeGlobalPublishCountry = toUnwrappedModel(bridgeGlobalPublishCountry);

		boolean isNew = bridgeGlobalPublishCountry.isNew();

		BridgeGlobalPublishCountryModelImpl bridgeGlobalPublishCountryModelImpl = (BridgeGlobalPublishCountryModelImpl)bridgeGlobalPublishCountry;

		Session session = null;

		try {
			session = openSession();

			if (bridgeGlobalPublishCountry.isNew()) {
				session.save(bridgeGlobalPublishCountry);

				bridgeGlobalPublishCountry.setNew(false);
			}
			else {
				session.merge(bridgeGlobalPublishCountry);
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
				!BridgeGlobalPublishCountryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bridgeGlobalPublishCountryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALPUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeGlobalPublishCountryModelImpl.getOriginalGlobalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOBALPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALPUBLISHID,
					args);

				args = new Object[] {
						bridgeGlobalPublishCountryModelImpl.getGlobalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOBALPUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOBALPUBLISHID,
					args);
			}
		}

		EntityCacheUtil.putResult(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeGlobalPublishCountryImpl.class,
			bridgeGlobalPublishCountry.getPrimaryKey(),
			bridgeGlobalPublishCountry);

		clearUniqueFindersCache(bridgeGlobalPublishCountry);
		cacheUniqueFindersCache(bridgeGlobalPublishCountry);

		return bridgeGlobalPublishCountry;
	}

	protected BridgeGlobalPublishCountry toUnwrappedModel(
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry) {
		if (bridgeGlobalPublishCountry instanceof BridgeGlobalPublishCountryImpl) {
			return bridgeGlobalPublishCountry;
		}

		BridgeGlobalPublishCountryImpl bridgeGlobalPublishCountryImpl = new BridgeGlobalPublishCountryImpl();

		bridgeGlobalPublishCountryImpl.setNew(bridgeGlobalPublishCountry.isNew());
		bridgeGlobalPublishCountryImpl.setPrimaryKey(bridgeGlobalPublishCountry.getPrimaryKey());

		bridgeGlobalPublishCountryImpl.setGlobalPublishCtryId(bridgeGlobalPublishCountry.getGlobalPublishCtryId());
		bridgeGlobalPublishCountryImpl.setGlobalPublishId(bridgeGlobalPublishCountry.getGlobalPublishId());
		bridgeGlobalPublishCountryImpl.setCountryCode(bridgeGlobalPublishCountry.getCountryCode());
		bridgeGlobalPublishCountryImpl.setPublishInd(bridgeGlobalPublishCountry.getPublishInd());
		bridgeGlobalPublishCountryImpl.setCreatorId(bridgeGlobalPublishCountry.getCreatorId());
		bridgeGlobalPublishCountryImpl.setCreatedDate(bridgeGlobalPublishCountry.getCreatedDate());
		bridgeGlobalPublishCountryImpl.setUpdatedBy(bridgeGlobalPublishCountry.getUpdatedBy());
		bridgeGlobalPublishCountryImpl.setUpdatedDate(bridgeGlobalPublishCountry.getUpdatedDate());

		return bridgeGlobalPublishCountryImpl;
	}

	/**
	 * Returns the bridge global publish country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge global publish country
	 * @return the bridge global publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = fetchByPrimaryKey(primaryKey);

		if (bridgeGlobalPublishCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgeGlobalPublishCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgeGlobalPublishCountry;
	}

	/**
	 * Returns the bridge global publish country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException} if it could not be found.
	 *
	 * @param globalPublishCtryId the primary key of the bridge global publish country
	 * @return the bridge global publish country
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException if a bridge global publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry findByPrimaryKey(long globalPublishCtryId)
		throws NoSuchBridgeGlobalPublishCountryException, SystemException {
		return findByPrimaryKey((Serializable)globalPublishCtryId);
	}

	/**
	 * Returns the bridge global publish country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge global publish country
	 * @return the bridge global publish country, or <code>null</code> if a bridge global publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgeGlobalPublishCountry bridgeGlobalPublishCountry = (BridgeGlobalPublishCountry)EntityCacheUtil.getResult(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
				BridgeGlobalPublishCountryImpl.class, primaryKey);

		if (bridgeGlobalPublishCountry == _nullBridgeGlobalPublishCountry) {
			return null;
		}

		if (bridgeGlobalPublishCountry == null) {
			Session session = null;

			try {
				session = openSession();

				bridgeGlobalPublishCountry = (BridgeGlobalPublishCountry)session.get(BridgeGlobalPublishCountryImpl.class,
						primaryKey);

				if (bridgeGlobalPublishCountry != null) {
					cacheResult(bridgeGlobalPublishCountry);
				}
				else {
					EntityCacheUtil.putResult(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
						BridgeGlobalPublishCountryImpl.class, primaryKey,
						_nullBridgeGlobalPublishCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgeGlobalPublishCountryModelImpl.ENTITY_CACHE_ENABLED,
					BridgeGlobalPublishCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgeGlobalPublishCountry;
	}

	/**
	 * Returns the bridge global publish country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param globalPublishCtryId the primary key of the bridge global publish country
	 * @return the bridge global publish country, or <code>null</code> if a bridge global publish country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeGlobalPublishCountry fetchByPrimaryKey(
		long globalPublishCtryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)globalPublishCtryId);
	}

	/**
	 * Returns all the bridge global publish countries.
	 *
	 * @return the bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublishCountry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge global publish countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge global publish countries
	 * @param end the upper bound of the range of bridge global publish countries (not inclusive)
	 * @return the range of bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublishCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge global publish countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge global publish countries
	 * @param end the upper bound of the range of bridge global publish countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge global publish countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeGlobalPublishCountry> findAll(int start, int end,
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

		List<BridgeGlobalPublishCountry> list = (List<BridgeGlobalPublishCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEGLOBALPUBLISHCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEGLOBALPUBLISHCOUNTRY;

				if (pagination) {
					sql = sql.concat(BridgeGlobalPublishCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgeGlobalPublishCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeGlobalPublishCountry>(list);
				}
				else {
					list = (List<BridgeGlobalPublishCountry>)QueryUtil.list(q,
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
	 * Removes all the bridge global publish countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgeGlobalPublishCountry bridgeGlobalPublishCountry : findAll()) {
			remove(bridgeGlobalPublishCountry);
		}
	}

	/**
	 * Returns the number of bridge global publish countries.
	 *
	 * @return the number of bridge global publish countries
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEGLOBALPUBLISHCOUNTRY);

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
	 * Initializes the bridge global publish country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgeGlobalPublishCountry>> listenersList = new ArrayList<ModelListener<BridgeGlobalPublishCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgeGlobalPublishCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgeGlobalPublishCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEGLOBALPUBLISHCOUNTRY = "SELECT bridgeGlobalPublishCountry FROM BridgeGlobalPublishCountry bridgeGlobalPublishCountry";
	private static final String _SQL_SELECT_BRIDGEGLOBALPUBLISHCOUNTRY_WHERE = "SELECT bridgeGlobalPublishCountry FROM BridgeGlobalPublishCountry bridgeGlobalPublishCountry WHERE ";
	private static final String _SQL_COUNT_BRIDGEGLOBALPUBLISHCOUNTRY = "SELECT COUNT(bridgeGlobalPublishCountry) FROM BridgeGlobalPublishCountry bridgeGlobalPublishCountry";
	private static final String _SQL_COUNT_BRIDGEGLOBALPUBLISHCOUNTRY_WHERE = "SELECT COUNT(bridgeGlobalPublishCountry) FROM BridgeGlobalPublishCountry bridgeGlobalPublishCountry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgeGlobalPublishCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgeGlobalPublishCountry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgeGlobalPublishCountry exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgeGlobalPublishCountryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"globalPublishCtryId", "globalPublishId", "countryCode",
				"publishInd", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static BridgeGlobalPublishCountry _nullBridgeGlobalPublishCountry = new BridgeGlobalPublishCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgeGlobalPublishCountry> toCacheModel() {
				return _nullBridgeGlobalPublishCountryCacheModel;
			}
		};

	private static CacheModel<BridgeGlobalPublishCountry> _nullBridgeGlobalPublishCountryCacheModel =
		new CacheModel<BridgeGlobalPublishCountry>() {
			@Override
			public BridgeGlobalPublishCountry toEntityModel() {
				return _nullBridgeGlobalPublishCountry;
			}
		};
}