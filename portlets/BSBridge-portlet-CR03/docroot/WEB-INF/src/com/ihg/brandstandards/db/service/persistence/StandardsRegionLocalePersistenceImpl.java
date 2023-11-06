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

import com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException;
import com.ihg.brandstandards.db.model.StandardsRegionLocale;
import com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleImpl;
import com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl;

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
 * The persistence implementation for the standards region locale service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionLocalePersistence
 * @see StandardsRegionLocaleUtil
 * @generated
 */
public class StandardsRegionLocalePersistenceImpl extends BasePersistenceImpl<StandardsRegionLocale>
	implements StandardsRegionLocalePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsRegionLocaleUtil} to access the standards region locale persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsRegionLocaleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByregionId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID =
		new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByregionId",
			new String[] { Long.class.getName() },
			StandardsRegionLocaleModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONID = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByregionId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards region locales where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the matching standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionLocale> findByregionId(long regionId)
		throws SystemException {
		return findByregionId(regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the standards region locales where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of standards region locales
	 * @param end the upper bound of the range of standards region locales (not inclusive)
	 * @return the range of matching standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionLocale> findByregionId(long regionId, int start,
		int end) throws SystemException {
		return findByregionId(regionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards region locales where regionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionId the region ID
	 * @param start the lower bound of the range of standards region locales
	 * @param end the upper bound of the range of standards region locales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionLocale> findByregionId(long regionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { regionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONID;
			finderArgs = new Object[] { regionId, start, end, orderByComparator };
		}

		List<StandardsRegionLocale> list = (List<StandardsRegionLocale>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsRegionLocale standardsRegionLocale : list) {
				if ((regionId != standardsRegionLocale.getRegionId())) {
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

			query.append(_SQL_SELECT_STANDARDSREGIONLOCALE_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsRegionLocaleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(regionId);

				if (!pagination) {
					list = (List<StandardsRegionLocale>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsRegionLocale>(list);
				}
				else {
					list = (List<StandardsRegionLocale>)QueryUtil.list(q,
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
	 * Returns the first standards region locale in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards region locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale findByregionId_First(long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = fetchByregionId_First(regionId,
				orderByComparator);

		if (standardsRegionLocale != null) {
			return standardsRegionLocale;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsRegionLocaleException(msg.toString());
	}

	/**
	 * Returns the first standards region locale in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchByregionId_First(long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsRegionLocale> list = findByregionId(regionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards region locale in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards region locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale findByregionId_Last(long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = fetchByregionId_Last(regionId,
				orderByComparator);

		if (standardsRegionLocale != null) {
			return standardsRegionLocale;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionId=");
		msg.append(regionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsRegionLocaleException(msg.toString());
	}

	/**
	 * Returns the last standards region locale in the ordered set where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchByregionId_Last(long regionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByregionId(regionId);

		if (count == 0) {
			return null;
		}

		List<StandardsRegionLocale> list = findByregionId(regionId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards region locales before and after the current standards region locale in the ordered set where regionId = &#63;.
	 *
	 * @param standardsRegionLocalePK the primary key of the current standards region locale
	 * @param regionId the region ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards region locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale[] findByregionId_PrevAndNext(
		StandardsRegionLocalePK standardsRegionLocalePK, long regionId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = findByPrimaryKey(standardsRegionLocalePK);

		Session session = null;

		try {
			session = openSession();

			StandardsRegionLocale[] array = new StandardsRegionLocaleImpl[3];

			array[0] = getByregionId_PrevAndNext(session,
					standardsRegionLocale, regionId, orderByComparator, true);

			array[1] = standardsRegionLocale;

			array[2] = getByregionId_PrevAndNext(session,
					standardsRegionLocale, regionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsRegionLocale getByregionId_PrevAndNext(Session session,
		StandardsRegionLocale standardsRegionLocale, long regionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSREGIONLOCALE_WHERE);

		query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

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
			query.append(StandardsRegionLocaleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(regionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsRegionLocale);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsRegionLocale> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards region locales where regionId = &#63; from the database.
	 *
	 * @param regionId the region ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByregionId(long regionId) throws SystemException {
		for (StandardsRegionLocale standardsRegionLocale : findByregionId(
				regionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsRegionLocale);
		}
	}

	/**
	 * Returns the number of standards region locales where regionId = &#63;.
	 *
	 * @param regionId the region ID
	 * @return the number of matching standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByregionId(long regionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONID;

		Object[] finderArgs = new Object[] { regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSREGIONLOCALE_WHERE);

			query.append(_FINDER_COLUMN_REGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_REGIONID_REGIONID_2 = "standardsRegionLocale.id.regionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByregionIdIsDefault",
			new String[] { String.class.getName(), Long.class.getName() },
			StandardsRegionLocaleModelImpl.ISDEFAULT_COLUMN_BITMASK |
			StandardsRegionLocaleModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONIDISDEFAULT = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByregionIdIsDefault",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the standards region locale where isDefault = &#63; and regionId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException} if it could not be found.
	 *
	 * @param isDefault the is default
	 * @param regionId the region ID
	 * @return the matching standards region locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale findByregionIdIsDefault(String isDefault,
		long regionId)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = fetchByregionIdIsDefault(isDefault,
				regionId);

		if (standardsRegionLocale == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("isDefault=");
			msg.append(isDefault);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsRegionLocaleException(msg.toString());
		}

		return standardsRegionLocale;
	}

	/**
	 * Returns the standards region locale where isDefault = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param isDefault the is default
	 * @param regionId the region ID
	 * @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchByregionIdIsDefault(String isDefault,
		long regionId) throws SystemException {
		return fetchByregionIdIsDefault(isDefault, regionId, true);
	}

	/**
	 * Returns the standards region locale where isDefault = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param isDefault the is default
	 * @param regionId the region ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchByregionIdIsDefault(String isDefault,
		long regionId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { isDefault, regionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
					finderArgs, this);
		}

		if (result instanceof StandardsRegionLocale) {
			StandardsRegionLocale standardsRegionLocale = (StandardsRegionLocale)result;

			if (!Validator.equals(isDefault,
						standardsRegionLocale.getIsDefault()) ||
					(regionId != standardsRegionLocale.getRegionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STANDARDSREGIONLOCALE_WHERE);

			boolean bindIsDefault = false;

			if (isDefault == null) {
				query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_1);
			}
			else if (isDefault.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_3);
			}
			else {
				bindIsDefault = true;

				query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_2);
			}

			query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIsDefault) {
					qPos.add(isDefault);
				}

				qPos.add(regionId);

				List<StandardsRegionLocale> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsRegionLocalePersistenceImpl.fetchByregionIdIsDefault(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsRegionLocale standardsRegionLocale = list.get(0);

					result = standardsRegionLocale;

					cacheResult(standardsRegionLocale);

					if ((standardsRegionLocale.getIsDefault() == null) ||
							!standardsRegionLocale.getIsDefault()
													  .equals(isDefault) ||
							(standardsRegionLocale.getRegionId() != regionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
							finderArgs, standardsRegionLocale);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
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
			return (StandardsRegionLocale)result;
		}
	}

	/**
	 * Removes the standards region locale where isDefault = &#63; and regionId = &#63; from the database.
	 *
	 * @param isDefault the is default
	 * @param regionId the region ID
	 * @return the standards region locale that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale removeByregionIdIsDefault(String isDefault,
		long regionId)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = findByregionIdIsDefault(isDefault,
				regionId);

		return remove(standardsRegionLocale);
	}

	/**
	 * Returns the number of standards region locales where isDefault = &#63; and regionId = &#63;.
	 *
	 * @param isDefault the is default
	 * @param regionId the region ID
	 * @return the number of matching standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByregionIdIsDefault(String isDefault, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONIDISDEFAULT;

		Object[] finderArgs = new Object[] { isDefault, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSREGIONLOCALE_WHERE);

			boolean bindIsDefault = false;

			if (isDefault == null) {
				query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_1);
			}
			else if (isDefault.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_3);
			}
			else {
				bindIsDefault = true;

				query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_2);
			}

			query.append(_FINDER_COLUMN_REGIONIDISDEFAULT_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIsDefault) {
					qPos.add(isDefault);
				}

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

	private static final String _FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_1 = "standardsRegionLocale.isDefault IS NULL AND ";
	private static final String _FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_2 = "standardsRegionLocale.isDefault = ? AND ";
	private static final String _FINDER_COLUMN_REGIONIDISDEFAULT_ISDEFAULT_3 = "(standardsRegionLocale.isDefault IS NULL OR standardsRegionLocale.isDefault = '') AND ";
	private static final String _FINDER_COLUMN_REGIONIDISDEFAULT_REGIONID_2 = "standardsRegionLocale.id.regionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_LOCALECODEREGIONID = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBylocaleCodeRegionId",
			new String[] { String.class.getName(), Long.class.getName() },
			StandardsRegionLocaleModelImpl.LOCALECODE_COLUMN_BITMASK |
			StandardsRegionLocaleModelImpl.REGIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCALECODEREGIONID = new FinderPath(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBylocaleCodeRegionId",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the standards region locale where localeCode = &#63; and regionId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException} if it could not be found.
	 *
	 * @param localeCode the locale code
	 * @param regionId the region ID
	 * @return the matching standards region locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale findBylocaleCodeRegionId(String localeCode,
		long regionId)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = fetchBylocaleCodeRegionId(localeCode,
				regionId);

		if (standardsRegionLocale == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("localeCode=");
			msg.append(localeCode);

			msg.append(", regionId=");
			msg.append(regionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsRegionLocaleException(msg.toString());
		}

		return standardsRegionLocale;
	}

	/**
	 * Returns the standards region locale where localeCode = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param localeCode the locale code
	 * @param regionId the region ID
	 * @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchBylocaleCodeRegionId(String localeCode,
		long regionId) throws SystemException {
		return fetchBylocaleCodeRegionId(localeCode, regionId, true);
	}

	/**
	 * Returns the standards region locale where localeCode = &#63; and regionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param localeCode the locale code
	 * @param regionId the region ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards region locale, or <code>null</code> if a matching standards region locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchBylocaleCodeRegionId(String localeCode,
		long regionId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { localeCode, regionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
					finderArgs, this);
		}

		if (result instanceof StandardsRegionLocale) {
			StandardsRegionLocale standardsRegionLocale = (StandardsRegionLocale)result;

			if (!Validator.equals(localeCode,
						standardsRegionLocale.getLocaleCode()) ||
					(regionId != standardsRegionLocale.getRegionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STANDARDSREGIONLOCALE_WHERE);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_2);
			}

			query.append(_FINDER_COLUMN_LOCALECODEREGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				qPos.add(regionId);

				List<StandardsRegionLocale> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsRegionLocalePersistenceImpl.fetchBylocaleCodeRegionId(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsRegionLocale standardsRegionLocale = list.get(0);

					result = standardsRegionLocale;

					cacheResult(standardsRegionLocale);

					if ((standardsRegionLocale.getLocaleCode() == null) ||
							!standardsRegionLocale.getLocaleCode()
													  .equals(localeCode) ||
							(standardsRegionLocale.getRegionId() != regionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
							finderArgs, standardsRegionLocale);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
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
			return (StandardsRegionLocale)result;
		}
	}

	/**
	 * Removes the standards region locale where localeCode = &#63; and regionId = &#63; from the database.
	 *
	 * @param localeCode the locale code
	 * @param regionId the region ID
	 * @return the standards region locale that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale removeBylocaleCodeRegionId(String localeCode,
		long regionId)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = findBylocaleCodeRegionId(localeCode,
				regionId);

		return remove(standardsRegionLocale);
	}

	/**
	 * Returns the number of standards region locales where localeCode = &#63; and regionId = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param regionId the region ID
	 * @return the number of matching standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylocaleCodeRegionId(String localeCode, long regionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCALECODEREGIONID;

		Object[] finderArgs = new Object[] { localeCode, regionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSREGIONLOCALE_WHERE);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_2);
			}

			query.append(_FINDER_COLUMN_LOCALECODEREGIONID_REGIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

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

	private static final String _FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_1 = "standardsRegionLocale.id.localeCode IS NULL AND ";
	private static final String _FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_2 = "standardsRegionLocale.id.localeCode = ? AND ";
	private static final String _FINDER_COLUMN_LOCALECODEREGIONID_LOCALECODE_3 = "(standardsRegionLocale.id.localeCode IS NULL OR standardsRegionLocale.id.localeCode = '') AND ";
	private static final String _FINDER_COLUMN_LOCALECODEREGIONID_REGIONID_2 = "standardsRegionLocale.id.regionId = ?";

	public StandardsRegionLocalePersistenceImpl() {
		setModelClass(StandardsRegionLocale.class);
	}

	/**
	 * Caches the standards region locale in the entity cache if it is enabled.
	 *
	 * @param standardsRegionLocale the standards region locale
	 */
	@Override
	public void cacheResult(StandardsRegionLocale standardsRegionLocale) {
		EntityCacheUtil.putResult(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class,
			standardsRegionLocale.getPrimaryKey(), standardsRegionLocale);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
			new Object[] {
				standardsRegionLocale.getIsDefault(),
				standardsRegionLocale.getRegionId()
			}, standardsRegionLocale);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
			new Object[] {
				standardsRegionLocale.getLocaleCode(),
				standardsRegionLocale.getRegionId()
			}, standardsRegionLocale);

		standardsRegionLocale.resetOriginalValues();
	}

	/**
	 * Caches the standards region locales in the entity cache if it is enabled.
	 *
	 * @param standardsRegionLocales the standards region locales
	 */
	@Override
	public void cacheResult(List<StandardsRegionLocale> standardsRegionLocales) {
		for (StandardsRegionLocale standardsRegionLocale : standardsRegionLocales) {
			if (EntityCacheUtil.getResult(
						StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
						StandardsRegionLocaleImpl.class,
						standardsRegionLocale.getPrimaryKey()) == null) {
				cacheResult(standardsRegionLocale);
			}
			else {
				standardsRegionLocale.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards region locales.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsRegionLocaleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsRegionLocaleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards region locale.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsRegionLocale standardsRegionLocale) {
		EntityCacheUtil.removeResult(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class,
			standardsRegionLocale.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardsRegionLocale);
	}

	@Override
	public void clearCache(List<StandardsRegionLocale> standardsRegionLocales) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsRegionLocale standardsRegionLocale : standardsRegionLocales) {
			EntityCacheUtil.removeResult(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
				StandardsRegionLocaleImpl.class,
				standardsRegionLocale.getPrimaryKey());

			clearUniqueFindersCache(standardsRegionLocale);
		}
	}

	protected void cacheUniqueFindersCache(
		StandardsRegionLocale standardsRegionLocale) {
		if (standardsRegionLocale.isNew()) {
			Object[] args = new Object[] {
					standardsRegionLocale.getIsDefault(),
					standardsRegionLocale.getRegionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONIDISDEFAULT,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
				args, standardsRegionLocale);

			args = new Object[] {
					standardsRegionLocale.getLocaleCode(),
					standardsRegionLocale.getRegionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCALECODEREGIONID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
				args, standardsRegionLocale);
		}
		else {
			StandardsRegionLocaleModelImpl standardsRegionLocaleModelImpl = (StandardsRegionLocaleModelImpl)standardsRegionLocale;

			if ((standardsRegionLocaleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsRegionLocale.getIsDefault(),
						standardsRegionLocale.getRegionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONIDISDEFAULT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
					args, standardsRegionLocale);
			}

			if ((standardsRegionLocaleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LOCALECODEREGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsRegionLocale.getLocaleCode(),
						standardsRegionLocale.getRegionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCALECODEREGIONID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
					args, standardsRegionLocale);
			}
		}
	}

	protected void clearUniqueFindersCache(
		StandardsRegionLocale standardsRegionLocale) {
		StandardsRegionLocaleModelImpl standardsRegionLocaleModelImpl = (StandardsRegionLocaleModelImpl)standardsRegionLocale;

		Object[] args = new Object[] {
				standardsRegionLocale.getIsDefault(),
				standardsRegionLocale.getRegionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONIDISDEFAULT,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
			args);

		if ((standardsRegionLocaleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT.getColumnBitmask()) != 0) {
			args = new Object[] {
					standardsRegionLocaleModelImpl.getOriginalIsDefault(),
					standardsRegionLocaleModelImpl.getOriginalRegionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONIDISDEFAULT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONIDISDEFAULT,
				args);
		}

		args = new Object[] {
				standardsRegionLocale.getLocaleCode(),
				standardsRegionLocale.getRegionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODEREGIONID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
			args);

		if ((standardsRegionLocaleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LOCALECODEREGIONID.getColumnBitmask()) != 0) {
			args = new Object[] {
					standardsRegionLocaleModelImpl.getOriginalLocaleCode(),
					standardsRegionLocaleModelImpl.getOriginalRegionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODEREGIONID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCALECODEREGIONID,
				args);
		}
	}

	/**
	 * Creates a new standards region locale with the primary key. Does not add the standards region locale to the database.
	 *
	 * @param standardsRegionLocalePK the primary key for the new standards region locale
	 * @return the new standards region locale
	 */
	@Override
	public StandardsRegionLocale create(
		StandardsRegionLocalePK standardsRegionLocalePK) {
		StandardsRegionLocale standardsRegionLocale = new StandardsRegionLocaleImpl();

		standardsRegionLocale.setNew(true);
		standardsRegionLocale.setPrimaryKey(standardsRegionLocalePK);

		return standardsRegionLocale;
	}

	/**
	 * Removes the standards region locale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param standardsRegionLocalePK the primary key of the standards region locale
	 * @return the standards region locale that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale remove(
		StandardsRegionLocalePK standardsRegionLocalePK)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		return remove((Serializable)standardsRegionLocalePK);
	}

	/**
	 * Removes the standards region locale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards region locale
	 * @return the standards region locale that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale remove(Serializable primaryKey)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsRegionLocale standardsRegionLocale = (StandardsRegionLocale)session.get(StandardsRegionLocaleImpl.class,
					primaryKey);

			if (standardsRegionLocale == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsRegionLocaleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsRegionLocale);
		}
		catch (NoSuchStandardsRegionLocaleException nsee) {
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
	protected StandardsRegionLocale removeImpl(
		StandardsRegionLocale standardsRegionLocale) throws SystemException {
		standardsRegionLocale = toUnwrappedModel(standardsRegionLocale);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsRegionLocale)) {
				standardsRegionLocale = (StandardsRegionLocale)session.get(StandardsRegionLocaleImpl.class,
						standardsRegionLocale.getPrimaryKeyObj());
			}

			if (standardsRegionLocale != null) {
				session.delete(standardsRegionLocale);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsRegionLocale != null) {
			clearCache(standardsRegionLocale);
		}

		return standardsRegionLocale;
	}

	@Override
	public StandardsRegionLocale updateImpl(
		com.ihg.brandstandards.db.model.StandardsRegionLocale standardsRegionLocale)
		throws SystemException {
		standardsRegionLocale = toUnwrappedModel(standardsRegionLocale);

		boolean isNew = standardsRegionLocale.isNew();

		StandardsRegionLocaleModelImpl standardsRegionLocaleModelImpl = (StandardsRegionLocaleModelImpl)standardsRegionLocale;

		Session session = null;

		try {
			session = openSession();

			if (standardsRegionLocale.isNew()) {
				session.save(standardsRegionLocale);

				standardsRegionLocale.setNew(false);
			}
			else {
				session.merge(standardsRegionLocale);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsRegionLocaleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsRegionLocaleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsRegionLocaleModelImpl.getOriginalRegionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);

				args = new Object[] { standardsRegionLocaleModelImpl.getRegionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONID,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsRegionLocaleImpl.class,
			standardsRegionLocale.getPrimaryKey(), standardsRegionLocale);

		clearUniqueFindersCache(standardsRegionLocale);
		cacheUniqueFindersCache(standardsRegionLocale);

		return standardsRegionLocale;
	}

	protected StandardsRegionLocale toUnwrappedModel(
		StandardsRegionLocale standardsRegionLocale) {
		if (standardsRegionLocale instanceof StandardsRegionLocaleImpl) {
			return standardsRegionLocale;
		}

		StandardsRegionLocaleImpl standardsRegionLocaleImpl = new StandardsRegionLocaleImpl();

		standardsRegionLocaleImpl.setNew(standardsRegionLocale.isNew());
		standardsRegionLocaleImpl.setPrimaryKey(standardsRegionLocale.getPrimaryKey());

		standardsRegionLocaleImpl.setRegionId(standardsRegionLocale.getRegionId());
		standardsRegionLocaleImpl.setLocaleCode(standardsRegionLocale.getLocaleCode());
		standardsRegionLocaleImpl.setIsDefault(standardsRegionLocale.getIsDefault());
		standardsRegionLocaleImpl.setCreatorId(standardsRegionLocale.getCreatorId());
		standardsRegionLocaleImpl.setCreatedDate(standardsRegionLocale.getCreatedDate());
		standardsRegionLocaleImpl.setUpdatedBy(standardsRegionLocale.getUpdatedBy());
		standardsRegionLocaleImpl.setUpdatedDate(standardsRegionLocale.getUpdatedDate());

		return standardsRegionLocaleImpl;
	}

	/**
	 * Returns the standards region locale with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards region locale
	 * @return the standards region locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		StandardsRegionLocale standardsRegionLocale = fetchByPrimaryKey(primaryKey);

		if (standardsRegionLocale == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsRegionLocaleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsRegionLocale;
	}

	/**
	 * Returns the standards region locale with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException} if it could not be found.
	 *
	 * @param standardsRegionLocalePK the primary key of the standards region locale
	 * @return the standards region locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException if a standards region locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale findByPrimaryKey(
		StandardsRegionLocalePK standardsRegionLocalePK)
		throws NoSuchStandardsRegionLocaleException, SystemException {
		return findByPrimaryKey((Serializable)standardsRegionLocalePK);
	}

	/**
	 * Returns the standards region locale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards region locale
	 * @return the standards region locale, or <code>null</code> if a standards region locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsRegionLocale standardsRegionLocale = (StandardsRegionLocale)EntityCacheUtil.getResult(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
				StandardsRegionLocaleImpl.class, primaryKey);

		if (standardsRegionLocale == _nullStandardsRegionLocale) {
			return null;
		}

		if (standardsRegionLocale == null) {
			Session session = null;

			try {
				session = openSession();

				standardsRegionLocale = (StandardsRegionLocale)session.get(StandardsRegionLocaleImpl.class,
						primaryKey);

				if (standardsRegionLocale != null) {
					cacheResult(standardsRegionLocale);
				}
				else {
					EntityCacheUtil.putResult(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
						StandardsRegionLocaleImpl.class, primaryKey,
						_nullStandardsRegionLocale);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsRegionLocaleModelImpl.ENTITY_CACHE_ENABLED,
					StandardsRegionLocaleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsRegionLocale;
	}

	/**
	 * Returns the standards region locale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param standardsRegionLocalePK the primary key of the standards region locale
	 * @return the standards region locale, or <code>null</code> if a standards region locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsRegionLocale fetchByPrimaryKey(
		StandardsRegionLocalePK standardsRegionLocalePK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)standardsRegionLocalePK);
	}

	/**
	 * Returns all the standards region locales.
	 *
	 * @return the standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionLocale> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards region locales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards region locales
	 * @param end the upper bound of the range of standards region locales (not inclusive)
	 * @return the range of standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionLocale> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards region locales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards region locales
	 * @param end the upper bound of the range of standards region locales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards region locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsRegionLocale> findAll(int start, int end,
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

		List<StandardsRegionLocale> list = (List<StandardsRegionLocale>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSREGIONLOCALE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSREGIONLOCALE;

				if (pagination) {
					sql = sql.concat(StandardsRegionLocaleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsRegionLocale>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsRegionLocale>(list);
				}
				else {
					list = (List<StandardsRegionLocale>)QueryUtil.list(q,
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
	 * Removes all the standards region locales from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsRegionLocale standardsRegionLocale : findAll()) {
			remove(standardsRegionLocale);
		}
	}

	/**
	 * Returns the number of standards region locales.
	 *
	 * @return the number of standards region locales
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSREGIONLOCALE);

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
	 * Initializes the standards region locale persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsRegionLocale")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsRegionLocale>> listenersList = new ArrayList<ModelListener<StandardsRegionLocale>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsRegionLocale>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsRegionLocaleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSREGIONLOCALE = "SELECT standardsRegionLocale FROM StandardsRegionLocale standardsRegionLocale";
	private static final String _SQL_SELECT_STANDARDSREGIONLOCALE_WHERE = "SELECT standardsRegionLocale FROM StandardsRegionLocale standardsRegionLocale WHERE ";
	private static final String _SQL_COUNT_STANDARDSREGIONLOCALE = "SELECT COUNT(standardsRegionLocale) FROM StandardsRegionLocale standardsRegionLocale";
	private static final String _SQL_COUNT_STANDARDSREGIONLOCALE_WHERE = "SELECT COUNT(standardsRegionLocale) FROM StandardsRegionLocale standardsRegionLocale WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsRegionLocale.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsRegionLocale exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsRegionLocale exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsRegionLocalePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"regionId", "localeCode", "isDefault", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static StandardsRegionLocale _nullStandardsRegionLocale = new StandardsRegionLocaleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsRegionLocale> toCacheModel() {
				return _nullStandardsRegionLocaleCacheModel;
			}
		};

	private static CacheModel<StandardsRegionLocale> _nullStandardsRegionLocaleCacheModel =
		new CacheModel<StandardsRegionLocale>() {
			@Override
			public StandardsRegionLocale toEntityModel() {
				return _nullStandardsRegionLocale;
			}
		};
}