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

import com.ihg.brandstandards.db.NoSuchStandardsLocaleException;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.impl.StandardsLocaleImpl;
import com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl;

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
 * The persistence implementation for the standards locale service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsLocalePersistence
 * @see StandardsLocaleUtil
 * @generated
 */
public class StandardsLocalePersistenceImpl extends BasePersistenceImpl<StandardsLocale>
	implements StandardsLocalePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsLocaleUtil} to access the standards locale persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsLocaleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsLocaleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsLocaleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_LOCALECODE = new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsLocaleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBylocaleCode", new String[] { String.class.getName() },
			StandardsLocaleModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCALECODE = new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylocaleCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the standards locale where localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsLocaleException} if it could not be found.
	 *
	 * @param localeCode the locale code
	 * @return the matching standards locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a matching standards locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale findBylocaleCode(String localeCode)
		throws NoSuchStandardsLocaleException, SystemException {
		StandardsLocale standardsLocale = fetchBylocaleCode(localeCode);

		if (standardsLocale == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("localeCode=");
			msg.append(localeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchStandardsLocaleException(msg.toString());
		}

		return standardsLocale;
	}

	/**
	 * Returns the standards locale where localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param localeCode the locale code
	 * @return the matching standards locale, or <code>null</code> if a matching standards locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale fetchBylocaleCode(String localeCode)
		throws SystemException {
		return fetchBylocaleCode(localeCode, true);
	}

	/**
	 * Returns the standards locale where localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param localeCode the locale code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching standards locale, or <code>null</code> if a matching standards locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale fetchBylocaleCode(String localeCode,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { localeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_LOCALECODE,
					finderArgs, this);
		}

		if (result instanceof StandardsLocale) {
			StandardsLocale standardsLocale = (StandardsLocale)result;

			if (!Validator.equals(localeCode, standardsLocale.getLocaleCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STANDARDSLOCALE_WHERE);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				List<StandardsLocale> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"StandardsLocalePersistenceImpl.fetchBylocaleCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					StandardsLocale standardsLocale = list.get(0);

					result = standardsLocale;

					cacheResult(standardsLocale);

					if ((standardsLocale.getLocaleCode() == null) ||
							!standardsLocale.getLocaleCode().equals(localeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODE,
							finderArgs, standardsLocale);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCALECODE,
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
			return (StandardsLocale)result;
		}
	}

	/**
	 * Removes the standards locale where localeCode = &#63; from the database.
	 *
	 * @param localeCode the locale code
	 * @return the standards locale that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale removeBylocaleCode(String localeCode)
		throws NoSuchStandardsLocaleException, SystemException {
		StandardsLocale standardsLocale = findBylocaleCode(localeCode);

		return remove(standardsLocale);
	}

	/**
	 * Returns the number of standards locales where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @return the number of matching standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylocaleCode(String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCALECODE;

		Object[] finderArgs = new Object[] { localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSLOCALE_WHERE);

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_LOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_1 = "standardsLocale.localeCode IS NULL";
	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_2 = "standardsLocale.localeCode = ?";
	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_3 = "(standardsLocale.localeCode IS NULL OR standardsLocale.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVESTATUS =
		new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsLocaleImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByActiveStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATUS =
		new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED,
			StandardsLocaleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActiveStatus",
			new String[] { String.class.getName() },
			StandardsLocaleModelImpl.ISACTIVE_COLUMN_BITMASK |
			StandardsLocaleModelImpl.ORDERNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVESTATUS = new FinderPath(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActiveStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the standards locales where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsLocale> findByActiveStatus(String isActive)
		throws SystemException {
		return findByActiveStatus(isActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards locales where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of standards locales
	 * @param end the upper bound of the range of standards locales (not inclusive)
	 * @return the range of matching standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsLocale> findByActiveStatus(String isActive, int start,
		int end) throws SystemException {
		return findByActiveStatus(isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards locales where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of standards locales
	 * @param end the upper bound of the range of standards locales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsLocale> findByActiveStatus(String isActive, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATUS;
			finderArgs = new Object[] { isActive };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ACTIVESTATUS;
			finderArgs = new Object[] { isActive, start, end, orderByComparator };
		}

		List<StandardsLocale> list = (List<StandardsLocale>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsLocale standardsLocale : list) {
				if (!Validator.equals(isActive, standardsLocale.getIsActive())) {
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

			query.append(_SQL_SELECT_STANDARDSLOCALE_WHERE);

			boolean bindIsActive = false;

			if (isActive == null) {
				query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_1);
			}
			else if (isActive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_3);
			}
			else {
				bindIsActive = true;

				query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsLocaleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIsActive) {
					qPos.add(isActive);
				}

				if (!pagination) {
					list = (List<StandardsLocale>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsLocale>(list);
				}
				else {
					list = (List<StandardsLocale>)QueryUtil.list(q,
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
	 * Returns the first standards locale in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a matching standards locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale findByActiveStatus_First(String isActive,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsLocaleException, SystemException {
		StandardsLocale standardsLocale = fetchByActiveStatus_First(isActive,
				orderByComparator);

		if (standardsLocale != null) {
			return standardsLocale;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsLocaleException(msg.toString());
	}

	/**
	 * Returns the first standards locale in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards locale, or <code>null</code> if a matching standards locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale fetchByActiveStatus_First(String isActive,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsLocale> list = findByActiveStatus(isActive, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards locale in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a matching standards locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale findByActiveStatus_Last(String isActive,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsLocaleException, SystemException {
		StandardsLocale standardsLocale = fetchByActiveStatus_Last(isActive,
				orderByComparator);

		if (standardsLocale != null) {
			return standardsLocale;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsLocaleException(msg.toString());
	}

	/**
	 * Returns the last standards locale in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards locale, or <code>null</code> if a matching standards locale could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale fetchByActiveStatus_Last(String isActive,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByActiveStatus(isActive);

		if (count == 0) {
			return null;
		}

		List<StandardsLocale> list = findByActiveStatus(isActive, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards locales before and after the current standards locale in the ordered set where isActive = &#63;.
	 *
	 * @param localeCode the primary key of the current standards locale
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale[] findByActiveStatus_PrevAndNext(String localeCode,
		String isActive, OrderByComparator orderByComparator)
		throws NoSuchStandardsLocaleException, SystemException {
		StandardsLocale standardsLocale = findByPrimaryKey(localeCode);

		Session session = null;

		try {
			session = openSession();

			StandardsLocale[] array = new StandardsLocaleImpl[3];

			array[0] = getByActiveStatus_PrevAndNext(session, standardsLocale,
					isActive, orderByComparator, true);

			array[1] = standardsLocale;

			array[2] = getByActiveStatus_PrevAndNext(session, standardsLocale,
					isActive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsLocale getByActiveStatus_PrevAndNext(Session session,
		StandardsLocale standardsLocale, String isActive,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSLOCALE_WHERE);

		boolean bindIsActive = false;

		if (isActive == null) {
			query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_1);
		}
		else if (isActive.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_3);
		}
		else {
			bindIsActive = true;

			query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_2);
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
			query.append(StandardsLocaleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIsActive) {
			qPos.add(isActive);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsLocale);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsLocale> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards locales where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByActiveStatus(String isActive) throws SystemException {
		for (StandardsLocale standardsLocale : findByActiveStatus(isActive,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsLocale);
		}
	}

	/**
	 * Returns the number of standards locales where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByActiveStatus(String isActive) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ACTIVESTATUS;

		Object[] finderArgs = new Object[] { isActive };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSLOCALE_WHERE);

			boolean bindIsActive = false;

			if (isActive == null) {
				query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_1);
			}
			else if (isActive.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_3);
			}
			else {
				bindIsActive = true;

				query.append(_FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIsActive) {
					qPos.add(isActive);
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

	private static final String _FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_1 = "standardsLocale.isActive IS NULL";
	private static final String _FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_2 = "standardsLocale.isActive = ?";
	private static final String _FINDER_COLUMN_ACTIVESTATUS_ISACTIVE_3 = "(standardsLocale.isActive IS NULL OR standardsLocale.isActive = '')";

	public StandardsLocalePersistenceImpl() {
		setModelClass(StandardsLocale.class);
	}

	/**
	 * Caches the standards locale in the entity cache if it is enabled.
	 *
	 * @param standardsLocale the standards locale
	 */
	@Override
	public void cacheResult(StandardsLocale standardsLocale) {
		EntityCacheUtil.putResult(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleImpl.class, standardsLocale.getPrimaryKey(),
			standardsLocale);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODE,
			new Object[] { standardsLocale.getLocaleCode() }, standardsLocale);

		standardsLocale.resetOriginalValues();
	}

	/**
	 * Caches the standards locales in the entity cache if it is enabled.
	 *
	 * @param standardsLocales the standards locales
	 */
	@Override
	public void cacheResult(List<StandardsLocale> standardsLocales) {
		for (StandardsLocale standardsLocale : standardsLocales) {
			if (EntityCacheUtil.getResult(
						StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
						StandardsLocaleImpl.class,
						standardsLocale.getPrimaryKey()) == null) {
				cacheResult(standardsLocale);
			}
			else {
				standardsLocale.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards locales.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsLocaleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsLocaleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards locale.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsLocale standardsLocale) {
		EntityCacheUtil.removeResult(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleImpl.class, standardsLocale.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(standardsLocale);
	}

	@Override
	public void clearCache(List<StandardsLocale> standardsLocales) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsLocale standardsLocale : standardsLocales) {
			EntityCacheUtil.removeResult(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
				StandardsLocaleImpl.class, standardsLocale.getPrimaryKey());

			clearUniqueFindersCache(standardsLocale);
		}
	}

	protected void cacheUniqueFindersCache(StandardsLocale standardsLocale) {
		if (standardsLocale.isNew()) {
			Object[] args = new Object[] { standardsLocale.getLocaleCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCALECODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODE, args,
				standardsLocale);
		}
		else {
			StandardsLocaleModelImpl standardsLocaleModelImpl = (StandardsLocaleModelImpl)standardsLocale;

			if ((standardsLocaleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_LOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { standardsLocale.getLocaleCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCALECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_LOCALECODE,
					args, standardsLocale);
			}
		}
	}

	protected void clearUniqueFindersCache(StandardsLocale standardsLocale) {
		StandardsLocaleModelImpl standardsLocaleModelImpl = (StandardsLocaleModelImpl)standardsLocale;

		Object[] args = new Object[] { standardsLocale.getLocaleCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCALECODE, args);

		if ((standardsLocaleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_LOCALECODE.getColumnBitmask()) != 0) {
			args = new Object[] { standardsLocaleModelImpl.getOriginalLocaleCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_LOCALECODE, args);
		}
	}

	/**
	 * Creates a new standards locale with the primary key. Does not add the standards locale to the database.
	 *
	 * @param localeCode the primary key for the new standards locale
	 * @return the new standards locale
	 */
	@Override
	public StandardsLocale create(String localeCode) {
		StandardsLocale standardsLocale = new StandardsLocaleImpl();

		standardsLocale.setNew(true);
		standardsLocale.setPrimaryKey(localeCode);

		return standardsLocale;
	}

	/**
	 * Removes the standards locale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localeCode the primary key of the standards locale
	 * @return the standards locale that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale remove(String localeCode)
		throws NoSuchStandardsLocaleException, SystemException {
		return remove((Serializable)localeCode);
	}

	/**
	 * Removes the standards locale with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards locale
	 * @return the standards locale that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale remove(Serializable primaryKey)
		throws NoSuchStandardsLocaleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsLocale standardsLocale = (StandardsLocale)session.get(StandardsLocaleImpl.class,
					primaryKey);

			if (standardsLocale == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsLocaleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsLocale);
		}
		catch (NoSuchStandardsLocaleException nsee) {
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
	protected StandardsLocale removeImpl(StandardsLocale standardsLocale)
		throws SystemException {
		standardsLocale = toUnwrappedModel(standardsLocale);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsLocale)) {
				standardsLocale = (StandardsLocale)session.get(StandardsLocaleImpl.class,
						standardsLocale.getPrimaryKeyObj());
			}

			if (standardsLocale != null) {
				session.delete(standardsLocale);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsLocale != null) {
			clearCache(standardsLocale);
		}

		return standardsLocale;
	}

	@Override
	public StandardsLocale updateImpl(
		com.ihg.brandstandards.db.model.StandardsLocale standardsLocale)
		throws SystemException {
		standardsLocale = toUnwrappedModel(standardsLocale);

		boolean isNew = standardsLocale.isNew();

		StandardsLocaleModelImpl standardsLocaleModelImpl = (StandardsLocaleModelImpl)standardsLocale;

		Session session = null;

		try {
			session = openSession();

			if (standardsLocale.isNew()) {
				session.save(standardsLocale);

				standardsLocale.setNew(false);
			}
			else {
				session.merge(standardsLocale);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsLocaleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsLocaleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsLocaleModelImpl.getOriginalIsActive()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATUS,
					args);

				args = new Object[] { standardsLocaleModelImpl.getIsActive() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ACTIVESTATUS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ACTIVESTATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
			StandardsLocaleImpl.class, standardsLocale.getPrimaryKey(),
			standardsLocale);

		clearUniqueFindersCache(standardsLocale);
		cacheUniqueFindersCache(standardsLocale);

		return standardsLocale;
	}

	protected StandardsLocale toUnwrappedModel(StandardsLocale standardsLocale) {
		if (standardsLocale instanceof StandardsLocaleImpl) {
			return standardsLocale;
		}

		StandardsLocaleImpl standardsLocaleImpl = new StandardsLocaleImpl();

		standardsLocaleImpl.setNew(standardsLocale.isNew());
		standardsLocaleImpl.setPrimaryKey(standardsLocale.getPrimaryKey());

		standardsLocaleImpl.setLocaleCode(standardsLocale.getLocaleCode());
		standardsLocaleImpl.setCountryCode(standardsLocale.getCountryCode());
		standardsLocaleImpl.setLocaleName(standardsLocale.getLocaleName());
		standardsLocaleImpl.setLanguageCode(standardsLocale.getLanguageCode());
		standardsLocaleImpl.setOrderNumber(standardsLocale.getOrderNumber());
		standardsLocaleImpl.setIsActive(standardsLocale.getIsActive());
		standardsLocaleImpl.setCreatorId(standardsLocale.getCreatorId());
		standardsLocaleImpl.setCreatedDate(standardsLocale.getCreatedDate());
		standardsLocaleImpl.setUpdatedBy(standardsLocale.getUpdatedBy());
		standardsLocaleImpl.setUpdatedDate(standardsLocale.getUpdatedDate());

		return standardsLocaleImpl;
	}

	/**
	 * Returns the standards locale with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards locale
	 * @return the standards locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsLocaleException, SystemException {
		StandardsLocale standardsLocale = fetchByPrimaryKey(primaryKey);

		if (standardsLocale == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsLocaleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsLocale;
	}

	/**
	 * Returns the standards locale with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsLocaleException} if it could not be found.
	 *
	 * @param localeCode the primary key of the standards locale
	 * @return the standards locale
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsLocaleException if a standards locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale findByPrimaryKey(String localeCode)
		throws NoSuchStandardsLocaleException, SystemException {
		return findByPrimaryKey((Serializable)localeCode);
	}

	/**
	 * Returns the standards locale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards locale
	 * @return the standards locale, or <code>null</code> if a standards locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsLocale standardsLocale = (StandardsLocale)EntityCacheUtil.getResult(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
				StandardsLocaleImpl.class, primaryKey);

		if (standardsLocale == _nullStandardsLocale) {
			return null;
		}

		if (standardsLocale == null) {
			Session session = null;

			try {
				session = openSession();

				standardsLocale = (StandardsLocale)session.get(StandardsLocaleImpl.class,
						primaryKey);

				if (standardsLocale != null) {
					cacheResult(standardsLocale);
				}
				else {
					EntityCacheUtil.putResult(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
						StandardsLocaleImpl.class, primaryKey,
						_nullStandardsLocale);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsLocaleModelImpl.ENTITY_CACHE_ENABLED,
					StandardsLocaleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsLocale;
	}

	/**
	 * Returns the standards locale with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localeCode the primary key of the standards locale
	 * @return the standards locale, or <code>null</code> if a standards locale with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsLocale fetchByPrimaryKey(String localeCode)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)localeCode);
	}

	/**
	 * Returns all the standards locales.
	 *
	 * @return the standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsLocale> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards locales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards locales
	 * @param end the upper bound of the range of standards locales (not inclusive)
	 * @return the range of standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsLocale> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards locales.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsLocaleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards locales
	 * @param end the upper bound of the range of standards locales (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards locales
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsLocale> findAll(int start, int end,
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

		List<StandardsLocale> list = (List<StandardsLocale>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSLOCALE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSLOCALE;

				if (pagination) {
					sql = sql.concat(StandardsLocaleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsLocale>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsLocale>(list);
				}
				else {
					list = (List<StandardsLocale>)QueryUtil.list(q,
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
	 * Removes all the standards locales from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsLocale standardsLocale : findAll()) {
			remove(standardsLocale);
		}
	}

	/**
	 * Returns the number of standards locales.
	 *
	 * @return the number of standards locales
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSLOCALE);

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
	 * Initializes the standards locale persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsLocale")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsLocale>> listenersList = new ArrayList<ModelListener<StandardsLocale>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsLocale>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsLocaleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSLOCALE = "SELECT standardsLocale FROM StandardsLocale standardsLocale";
	private static final String _SQL_SELECT_STANDARDSLOCALE_WHERE = "SELECT standardsLocale FROM StandardsLocale standardsLocale WHERE ";
	private static final String _SQL_COUNT_STANDARDSLOCALE = "SELECT COUNT(standardsLocale) FROM StandardsLocale standardsLocale";
	private static final String _SQL_COUNT_STANDARDSLOCALE_WHERE = "SELECT COUNT(standardsLocale) FROM StandardsLocale standardsLocale WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsLocale.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsLocale exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsLocale exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsLocalePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"localeCode", "countryCode", "localeName", "languageCode",
				"orderNumber", "isActive", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static StandardsLocale _nullStandardsLocale = new StandardsLocaleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsLocale> toCacheModel() {
				return _nullStandardsLocaleCacheModel;
			}
		};

	private static CacheModel<StandardsLocale> _nullStandardsLocaleCacheModel = new CacheModel<StandardsLocale>() {
			@Override
			public StandardsLocale toEntityModel() {
				return _nullStandardsLocale;
			}
		};
}