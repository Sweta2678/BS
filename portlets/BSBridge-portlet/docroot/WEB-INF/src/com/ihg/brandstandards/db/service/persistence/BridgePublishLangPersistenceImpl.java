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

import com.ihg.brandstandards.db.NoSuchBridgePublishLangException;
import com.ihg.brandstandards.db.model.BridgePublishLang;
import com.ihg.brandstandards.db.model.impl.BridgePublishLangImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl;

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
 * The persistence implementation for the bridge publish lang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishLangPersistence
 * @see BridgePublishLangUtil
 * @generated
 */
public class BridgePublishLangPersistenceImpl extends BasePersistenceImpl<BridgePublishLang>
	implements BridgePublishLangPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishLangUtil} to access the bridge publish lang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishLangImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishLangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishLangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGION = new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishLangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRegion",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION =
		new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishLangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRegion",
			new String[] { Long.class.getName(), Long.class.getName() },
			BridgePublishLangModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishLangModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGION = new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegion",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the bridge publish langs where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the matching bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishLang> findByRegion(long publishId, long regionId)
		throws SystemException {
		return findByRegion(publishId, regionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish langs where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge publish langs
	 * @param end the upper bound of the range of bridge publish langs (not inclusive)
	 * @return the range of matching bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishLang> findByRegion(long publishId, long regionId,
		int start, int end) throws SystemException {
		return findByRegion(publishId, regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish langs where publishId = &#63; and regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param start the lower bound of the range of bridge publish langs
	 * @param end the upper bound of the range of bridge publish langs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishLang> findByRegion(long publishId, long regionId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION;
			finderArgs = new Object[] { publishId, regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGION;
			finderArgs = new Object[] {
					publishId, regionId,
					
					start, end, orderByComparator
				};
		}

		List<BridgePublishLang> list = (List<BridgePublishLang>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgePublishLang bridgePublishLang : list) {
				if ((publishId != bridgePublishLang.getPublishId()) ||
						(regionId != bridgePublishLang.getRegionId())) {
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

			query.append(_SQL_SELECT_BRIDGEPUBLISHLANG_WHERE);

			query.append(_FINDER_COLUMN_REGION_PUBLISHID_2);

			query.append(_FINDER_COLUMN_REGION_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgePublishLangModelImpl.ORDER_BY_JPQL);
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
					list = (List<BridgePublishLang>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishLang>(list);
				}
				else {
					list = (List<BridgePublishLang>)QueryUtil.list(q,
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
	 * Returns the first bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish lang
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a matching bridge publish lang could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang findByRegion_First(long publishId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishLangException, SystemException {
		BridgePublishLang bridgePublishLang = fetchByRegion_First(publishId,
				regionId, orderByComparator);

		if (bridgePublishLang != null) {
			return bridgePublishLang;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishLangException(msg.toString());
	}

	/**
	 * Returns the first bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang fetchByRegion_First(long publishId, long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BridgePublishLang> list = findByRegion(publishId, regionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish lang
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a matching bridge publish lang could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang findByRegion_Last(long publishId, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgePublishLangException, SystemException {
		BridgePublishLang bridgePublishLang = fetchByRegion_Last(publishId,
				regionId, orderByComparator);

		if (bridgePublishLang != null) {
			return bridgePublishLang;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgePublishLangException(msg.toString());
	}

	/**
	 * Returns the last bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang fetchByRegion_Last(long publishId, long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRegion(publishId, regionId);

		if (count == 0) {
			return null;
		}

		List<BridgePublishLang> list = findByRegion(publishId, regionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge publish langs before and after the current bridge publish lang in the ordered set where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishLangId the primary key of the current bridge publish lang
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge publish lang
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang[] findByRegion_PrevAndNext(long publishLangId,
		long publishId, long regionId, OrderByComparator orderByComparator)
		throws NoSuchBridgePublishLangException, SystemException {
		BridgePublishLang bridgePublishLang = findByPrimaryKey(publishLangId);

		Session session = null;

		try {
			session = openSession();

			BridgePublishLang[] array = new BridgePublishLangImpl[3];

			array[0] = getByRegion_PrevAndNext(session, bridgePublishLang,
					publishId, regionId, orderByComparator, true);

			array[1] = bridgePublishLang;

			array[2] = getByRegion_PrevAndNext(session, bridgePublishLang,
					publishId, regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BridgePublishLang getByRegion_PrevAndNext(Session session,
		BridgePublishLang bridgePublishLang, long publishId, long regionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPUBLISHLANG_WHERE);

		query.append(_FINDER_COLUMN_REGION_PUBLISHID_2);

		query.append(_FINDER_COLUMN_REGION_REGIONID_2);

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
			query.append(BridgePublishLangModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgePublishLang);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgePublishLang> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge publish langs where publishId = &#63; and regionId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRegion(long publishId, long regionId)
		throws SystemException {
		for (BridgePublishLang bridgePublishLang : findByRegion(publishId,
				regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgePublishLang);
		}
	}

	/**
	 * Returns the number of bridge publish langs where publishId = &#63; and regionId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @return the number of matching bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegion(long publishId, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGION;

		Object[] finderArgs = new Object[] { publishId, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRIDGEPUBLISHLANG_WHERE);

			query.append(_FINDER_COLUMN_REGION_PUBLISHID_2);

			query.append(_FINDER_COLUMN_REGION_REGIONID_2);

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

	private static final String _FINDER_COLUMN_REGION_PUBLISHID_2 = "bridgePublishLang.publishId = ? AND ";
	private static final String _FINDER_COLUMN_REGION_REGIONID_2 = "bridgePublishLang.regionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_REGIONANDLOCALE = new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishLangImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByRegionAndLocale",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			BridgePublishLangModelImpl.PUBLISHID_COLUMN_BITMASK |
			BridgePublishLangModelImpl.REGIONID_COLUMN_BITMASK |
			BridgePublishLangModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONANDLOCALE = new FinderPath(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRegionAndLocale",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishLangException} if it could not be found.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param localeCode the locale code
	 * @return the matching bridge publish lang
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a matching bridge publish lang could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang findByRegionAndLocale(long publishId,
		long regionId, String localeCode)
		throws NoSuchBridgePublishLangException, SystemException {
		BridgePublishLang bridgePublishLang = fetchByRegionAndLocale(publishId,
				regionId, localeCode);

		if (bridgePublishLang == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("publishId=");
			msg.append(publishId);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(", localeCode=");
			msg.append(localeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgePublishLangException(msg.toString());
		}

		return bridgePublishLang;
	}

	/**
	 * Returns the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param localeCode the locale code
	 * @return the matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang fetchByRegionAndLocale(long publishId,
		long regionId, String localeCode) throws SystemException {
		return fetchByRegionAndLocale(publishId, regionId, localeCode, true);
	}

	/**
	 * Returns the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param localeCode the locale code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge publish lang, or <code>null</code> if a matching bridge publish lang could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang fetchByRegionAndLocale(long publishId,
		long regionId, String localeCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { publishId, regionId, localeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
					finderArgs, this);
		}

		if (result instanceof BridgePublishLang) {
			BridgePublishLang bridgePublishLang = (BridgePublishLang)result;

			if ((publishId != bridgePublishLang.getPublishId()) ||
					(regionId != bridgePublishLang.getRegionId()) ||
					!Validator.equals(localeCode,
						bridgePublishLang.getLocaleCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_BRIDGEPUBLISHLANG_WHERE);

			query.append(_FINDER_COLUMN_REGIONANDLOCALE_PUBLISHID_2);

			query.append(_FINDER_COLUMN_REGIONANDLOCALE_REGIONID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				List<BridgePublishLang> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgePublishLangPersistenceImpl.fetchByRegionAndLocale(long, long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgePublishLang bridgePublishLang = list.get(0);

					result = bridgePublishLang;

					cacheResult(bridgePublishLang);

					if ((bridgePublishLang.getPublishId() != publishId) ||
							(bridgePublishLang.getRegionId() != regionId) ||
							(bridgePublishLang.getLocaleCode() == null) ||
							!bridgePublishLang.getLocaleCode().equals(localeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
							finderArgs, bridgePublishLang);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
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
			return (BridgePublishLang)result;
		}
	}

	/**
	 * Removes the bridge publish lang where publishId = &#63; and regionId = &#63; and localeCode = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param localeCode the locale code
	 * @return the bridge publish lang that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang removeByRegionAndLocale(long publishId,
		long regionId, String localeCode)
		throws NoSuchBridgePublishLangException, SystemException {
		BridgePublishLang bridgePublishLang = findByRegionAndLocale(publishId,
				regionId, localeCode);

		return remove(bridgePublishLang);
	}

	/**
	 * Returns the number of bridge publish langs where publishId = &#63; and regionId = &#63; and localeCode = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param regionId the region ID
	 * @param localeCode the locale code
	 * @return the number of matching bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegionAndLocale(long publishId, long regionId,
		String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONANDLOCALE;

		Object[] finderArgs = new Object[] { publishId, regionId, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_BRIDGEPUBLISHLANG_WHERE);

			query.append(_FINDER_COLUMN_REGIONANDLOCALE_PUBLISHID_2);

			query.append(_FINDER_COLUMN_REGIONANDLOCALE_REGIONID_2);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				qPos.add(regionId);

				if (bindLocaleCode) {
					qPos.add(localeCode);
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

	private static final String _FINDER_COLUMN_REGIONANDLOCALE_PUBLISHID_2 = "bridgePublishLang.publishId = ? AND ";
	private static final String _FINDER_COLUMN_REGIONANDLOCALE_REGIONID_2 = "bridgePublishLang.regionId = ? AND ";
	private static final String _FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_1 = "bridgePublishLang.localeCode IS NULL";
	private static final String _FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_2 = "bridgePublishLang.localeCode = ?";
	private static final String _FINDER_COLUMN_REGIONANDLOCALE_LOCALECODE_3 = "(bridgePublishLang.localeCode IS NULL OR bridgePublishLang.localeCode = '')";

	public BridgePublishLangPersistenceImpl() {
		setModelClass(BridgePublishLang.class);
	}

	/**
	 * Caches the bridge publish lang in the entity cache if it is enabled.
	 *
	 * @param bridgePublishLang the bridge publish lang
	 */
	@Override
	public void cacheResult(BridgePublishLang bridgePublishLang) {
		EntityCacheUtil.putResult(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangImpl.class, bridgePublishLang.getPrimaryKey(),
			bridgePublishLang);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
			new Object[] {
				bridgePublishLang.getPublishId(),
				bridgePublishLang.getRegionId(),
				bridgePublishLang.getLocaleCode()
			}, bridgePublishLang);

		bridgePublishLang.resetOriginalValues();
	}

	/**
	 * Caches the bridge publish langs in the entity cache if it is enabled.
	 *
	 * @param bridgePublishLangs the bridge publish langs
	 */
	@Override
	public void cacheResult(List<BridgePublishLang> bridgePublishLangs) {
		for (BridgePublishLang bridgePublishLang : bridgePublishLangs) {
			if (EntityCacheUtil.getResult(
						BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishLangImpl.class,
						bridgePublishLang.getPrimaryKey()) == null) {
				cacheResult(bridgePublishLang);
			}
			else {
				bridgePublishLang.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publish langs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishLangImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishLangImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish lang.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgePublishLang bridgePublishLang) {
		EntityCacheUtil.removeResult(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangImpl.class, bridgePublishLang.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgePublishLang);
	}

	@Override
	public void clearCache(List<BridgePublishLang> bridgePublishLangs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublishLang bridgePublishLang : bridgePublishLangs) {
			EntityCacheUtil.removeResult(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishLangImpl.class, bridgePublishLang.getPrimaryKey());

			clearUniqueFindersCache(bridgePublishLang);
		}
	}

	protected void cacheUniqueFindersCache(BridgePublishLang bridgePublishLang) {
		if (bridgePublishLang.isNew()) {
			Object[] args = new Object[] {
					bridgePublishLang.getPublishId(),
					bridgePublishLang.getRegionId(),
					bridgePublishLang.getLocaleCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONANDLOCALE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
				args, bridgePublishLang);
		}
		else {
			BridgePublishLangModelImpl bridgePublishLangModelImpl = (BridgePublishLangModelImpl)bridgePublishLang;

			if ((bridgePublishLangModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_REGIONANDLOCALE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishLang.getPublishId(),
						bridgePublishLang.getRegionId(),
						bridgePublishLang.getLocaleCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONANDLOCALE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
					args, bridgePublishLang);
			}
		}
	}

	protected void clearUniqueFindersCache(BridgePublishLang bridgePublishLang) {
		BridgePublishLangModelImpl bridgePublishLangModelImpl = (BridgePublishLangModelImpl)bridgePublishLang;

		Object[] args = new Object[] {
				bridgePublishLang.getPublishId(),
				bridgePublishLang.getRegionId(),
				bridgePublishLang.getLocaleCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONANDLOCALE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE, args);

		if ((bridgePublishLangModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REGIONANDLOCALE.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgePublishLangModelImpl.getOriginalPublishId(),
					bridgePublishLangModelImpl.getOriginalRegionId(),
					bridgePublishLangModelImpl.getOriginalLocaleCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONANDLOCALE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONANDLOCALE,
				args);
		}
	}

	/**
	 * Creates a new bridge publish lang with the primary key. Does not add the bridge publish lang to the database.
	 *
	 * @param publishLangId the primary key for the new bridge publish lang
	 * @return the new bridge publish lang
	 */
	@Override
	public BridgePublishLang create(long publishLangId) {
		BridgePublishLang bridgePublishLang = new BridgePublishLangImpl();

		bridgePublishLang.setNew(true);
		bridgePublishLang.setPrimaryKey(publishLangId);

		return bridgePublishLang;
	}

	/**
	 * Removes the bridge publish lang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishLangId the primary key of the bridge publish lang
	 * @return the bridge publish lang that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang remove(long publishLangId)
		throws NoSuchBridgePublishLangException, SystemException {
		return remove((Serializable)publishLangId);
	}

	/**
	 * Removes the bridge publish lang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish lang
	 * @return the bridge publish lang that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang remove(Serializable primaryKey)
		throws NoSuchBridgePublishLangException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublishLang bridgePublishLang = (BridgePublishLang)session.get(BridgePublishLangImpl.class,
					primaryKey);

			if (bridgePublishLang == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishLangException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublishLang);
		}
		catch (NoSuchBridgePublishLangException nsee) {
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
	protected BridgePublishLang removeImpl(BridgePublishLang bridgePublishLang)
		throws SystemException {
		bridgePublishLang = toUnwrappedModel(bridgePublishLang);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublishLang)) {
				bridgePublishLang = (BridgePublishLang)session.get(BridgePublishLangImpl.class,
						bridgePublishLang.getPrimaryKeyObj());
			}

			if (bridgePublishLang != null) {
				session.delete(bridgePublishLang);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublishLang != null) {
			clearCache(bridgePublishLang);
		}

		return bridgePublishLang;
	}

	@Override
	public BridgePublishLang updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishLang bridgePublishLang)
		throws SystemException {
		bridgePublishLang = toUnwrappedModel(bridgePublishLang);

		boolean isNew = bridgePublishLang.isNew();

		BridgePublishLangModelImpl bridgePublishLangModelImpl = (BridgePublishLangModelImpl)bridgePublishLang;

		Session session = null;

		try {
			session = openSession();

			if (bridgePublishLang.isNew()) {
				session.save(bridgePublishLang);

				bridgePublishLang.setNew(false);
			}
			else {
				session.merge(bridgePublishLang);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BridgePublishLangModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bridgePublishLangModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgePublishLangModelImpl.getOriginalPublishId(),
						bridgePublishLangModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION,
					args);

				args = new Object[] {
						bridgePublishLangModelImpl.getPublishId(),
						bridgePublishLangModelImpl.getRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGION,
					args);
			}
		}

		EntityCacheUtil.putResult(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishLangImpl.class, bridgePublishLang.getPrimaryKey(),
			bridgePublishLang);

		clearUniqueFindersCache(bridgePublishLang);
		cacheUniqueFindersCache(bridgePublishLang);

		return bridgePublishLang;
	}

	protected BridgePublishLang toUnwrappedModel(
		BridgePublishLang bridgePublishLang) {
		if (bridgePublishLang instanceof BridgePublishLangImpl) {
			return bridgePublishLang;
		}

		BridgePublishLangImpl bridgePublishLangImpl = new BridgePublishLangImpl();

		bridgePublishLangImpl.setNew(bridgePublishLang.isNew());
		bridgePublishLangImpl.setPrimaryKey(bridgePublishLang.getPrimaryKey());

		bridgePublishLangImpl.setPublishLangId(bridgePublishLang.getPublishLangId());
		bridgePublishLangImpl.setPublishId(bridgePublishLang.getPublishId());
		bridgePublishLangImpl.setRegionId(bridgePublishLang.getRegionId());
		bridgePublishLangImpl.setLocaleCode(bridgePublishLang.getLocaleCode());
		bridgePublishLangImpl.setCreatorId(bridgePublishLang.getCreatorId());
		bridgePublishLangImpl.setCreatedDate(bridgePublishLang.getCreatedDate());
		bridgePublishLangImpl.setUpdatedBy(bridgePublishLang.getUpdatedBy());
		bridgePublishLangImpl.setUpdatedDate(bridgePublishLang.getUpdatedDate());

		return bridgePublishLangImpl;
	}

	/**
	 * Returns the bridge publish lang with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish lang
	 * @return the bridge publish lang
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishLangException, SystemException {
		BridgePublishLang bridgePublishLang = fetchByPrimaryKey(primaryKey);

		if (bridgePublishLang == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishLangException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublishLang;
	}

	/**
	 * Returns the bridge publish lang with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishLangException} if it could not be found.
	 *
	 * @param publishLangId the primary key of the bridge publish lang
	 * @return the bridge publish lang
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishLangException if a bridge publish lang with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang findByPrimaryKey(long publishLangId)
		throws NoSuchBridgePublishLangException, SystemException {
		return findByPrimaryKey((Serializable)publishLangId);
	}

	/**
	 * Returns the bridge publish lang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish lang
	 * @return the bridge publish lang, or <code>null</code> if a bridge publish lang with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgePublishLang bridgePublishLang = (BridgePublishLang)EntityCacheUtil.getResult(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishLangImpl.class, primaryKey);

		if (bridgePublishLang == _nullBridgePublishLang) {
			return null;
		}

		if (bridgePublishLang == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublishLang = (BridgePublishLang)session.get(BridgePublishLangImpl.class,
						primaryKey);

				if (bridgePublishLang != null) {
					cacheResult(bridgePublishLang);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishLangImpl.class, primaryKey,
						_nullBridgePublishLang);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishLangModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishLangImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublishLang;
	}

	/**
	 * Returns the bridge publish lang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishLangId the primary key of the bridge publish lang
	 * @return the bridge publish lang, or <code>null</code> if a bridge publish lang with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishLang fetchByPrimaryKey(long publishLangId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishLangId);
	}

	/**
	 * Returns all the bridge publish langs.
	 *
	 * @return the bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishLang> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish langs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish langs
	 * @param end the upper bound of the range of bridge publish langs (not inclusive)
	 * @return the range of bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishLang> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish langs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish langs
	 * @param end the upper bound of the range of bridge publish langs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publish langs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishLang> findAll(int start, int end,
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

		List<BridgePublishLang> list = (List<BridgePublishLang>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISHLANG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISHLANG;

				if (pagination) {
					sql = sql.concat(BridgePublishLangModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublishLang>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishLang>(list);
				}
				else {
					list = (List<BridgePublishLang>)QueryUtil.list(q,
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
	 * Removes all the bridge publish langs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublishLang bridgePublishLang : findAll()) {
			remove(bridgePublishLang);
		}
	}

	/**
	 * Returns the number of bridge publish langs.
	 *
	 * @return the number of bridge publish langs
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISHLANG);

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
	 * Initializes the bridge publish lang persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublishLang")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublishLang>> listenersList = new ArrayList<ModelListener<BridgePublishLang>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublishLang>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishLangImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISHLANG = "SELECT bridgePublishLang FROM BridgePublishLang bridgePublishLang";
	private static final String _SQL_SELECT_BRIDGEPUBLISHLANG_WHERE = "SELECT bridgePublishLang FROM BridgePublishLang bridgePublishLang WHERE ";
	private static final String _SQL_COUNT_BRIDGEPUBLISHLANG = "SELECT COUNT(bridgePublishLang) FROM BridgePublishLang bridgePublishLang";
	private static final String _SQL_COUNT_BRIDGEPUBLISHLANG_WHERE = "SELECT COUNT(bridgePublishLang) FROM BridgePublishLang bridgePublishLang WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublishLang.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublishLang exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgePublishLang exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishLangPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishLangId", "publishId", "regionId", "localeCode",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static BridgePublishLang _nullBridgePublishLang = new BridgePublishLangImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublishLang> toCacheModel() {
				return _nullBridgePublishLangCacheModel;
			}
		};

	private static CacheModel<BridgePublishLang> _nullBridgePublishLangCacheModel =
		new CacheModel<BridgePublishLang>() {
			@Override
			public BridgePublishLang toEntityModel() {
				return _nullBridgePublishLang;
			}
		};
}