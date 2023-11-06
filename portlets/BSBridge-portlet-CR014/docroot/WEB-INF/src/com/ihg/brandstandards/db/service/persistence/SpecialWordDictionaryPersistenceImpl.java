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

import com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException;
import com.ihg.brandstandards.db.model.SpecialWordDictionary;
import com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryImpl;
import com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl;

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
 * The persistence implementation for the special word dictionary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see SpecialWordDictionaryPersistence
 * @see SpecialWordDictionaryUtil
 * @generated
 */
public class SpecialWordDictionaryPersistenceImpl extends BasePersistenceImpl<SpecialWordDictionary>
	implements SpecialWordDictionaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpecialWordDictionaryUtil} to access the special word dictionary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpecialWordDictionaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALECODE =
		new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocaleCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE =
		new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocaleCode",
			new String[] { String.class.getName() },
			SpecialWordDictionaryModelImpl.LOCALECODE_COLUMN_BITMASK |
			SpecialWordDictionaryModelImpl.REPLACEDWORDTXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LOCALECODE = new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocaleCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the special word dictionaries where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @return the matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findByLocaleCode(String localeCode)
		throws SystemException {
		return findByLocaleCode(localeCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the special word dictionaries where localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of special word dictionaries
	 * @param end the upper bound of the range of special word dictionaries (not inclusive)
	 * @return the range of matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findByLocaleCode(String localeCode,
		int start, int end) throws SystemException {
		return findByLocaleCode(localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the special word dictionaries where localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of special word dictionaries
	 * @param end the upper bound of the range of special word dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findByLocaleCode(String localeCode,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE;
			finderArgs = new Object[] { localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALECODE;
			finderArgs = new Object[] { localeCode, start, end, orderByComparator };
		}

		List<SpecialWordDictionary> list = (List<SpecialWordDictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpecialWordDictionary specialWordDictionary : list) {
				if (!Validator.equals(localeCode,
							specialWordDictionary.getLocaleCode())) {
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

			query.append(_SQL_SELECT_SPECIALWORDDICTIONARY_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpecialWordDictionaryModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<SpecialWordDictionary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpecialWordDictionary>(list);
				}
				else {
					list = (List<SpecialWordDictionary>)QueryUtil.list(q,
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
	 * Returns the first special word dictionary in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary findByLocaleCode_First(String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = fetchByLocaleCode_First(localeCode,
				orderByComparator);

		if (specialWordDictionary != null) {
			return specialWordDictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecialWordDictionaryException(msg.toString());
	}

	/**
	 * Returns the first special word dictionary in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByLocaleCode_First(String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpecialWordDictionary> list = findByLocaleCode(localeCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last special word dictionary in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary findByLocaleCode_Last(String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = fetchByLocaleCode_Last(localeCode,
				orderByComparator);

		if (specialWordDictionary != null) {
			return specialWordDictionary;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecialWordDictionaryException(msg.toString());
	}

	/**
	 * Returns the last special word dictionary in the ordered set where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByLocaleCode_Last(String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLocaleCode(localeCode);

		if (count == 0) {
			return null;
		}

		List<SpecialWordDictionary> list = findByLocaleCode(localeCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the special word dictionaries before and after the current special word dictionary in the ordered set where localeCode = &#63;.
	 *
	 * @param specialWordId the primary key of the current special word dictionary
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary[] findByLocaleCode_PrevAndNext(
		long specialWordId, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = findByPrimaryKey(specialWordId);

		Session session = null;

		try {
			session = openSession();

			SpecialWordDictionary[] array = new SpecialWordDictionaryImpl[3];

			array[0] = getByLocaleCode_PrevAndNext(session,
					specialWordDictionary, localeCode, orderByComparator, true);

			array[1] = specialWordDictionary;

			array[2] = getByLocaleCode_PrevAndNext(session,
					specialWordDictionary, localeCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SpecialWordDictionary getByLocaleCode_PrevAndNext(
		Session session, SpecialWordDictionary specialWordDictionary,
		String localeCode, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPECIALWORDDICTIONARY_WHERE);

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
			query.append(SpecialWordDictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(specialWordDictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpecialWordDictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the special word dictionaries where localeCode = &#63; from the database.
	 *
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLocaleCode(String localeCode) throws SystemException {
		for (SpecialWordDictionary specialWordDictionary : findByLocaleCode(
				localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(specialWordDictionary);
		}
	}

	/**
	 * Returns the number of special word dictionaries where localeCode = &#63;.
	 *
	 * @param localeCode the locale code
	 * @return the number of matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLocaleCode(String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LOCALECODE;

		Object[] finderArgs = new Object[] { localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPECIALWORDDICTIONARY_WHERE);

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

	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_1 = "specialWordDictionary.localeCode IS NULL";
	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_2 = "specialWordDictionary.localeCode = ?";
	private static final String _FINDER_COLUMN_LOCALECODE_LOCALECODE_3 = "(specialWordDictionary.localeCode IS NULL OR specialWordDictionary.localeCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE =
		new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByReplacedWordTxtAndLocaleCode",
			new String[] { String.class.getName(), String.class.getName() },
			SpecialWordDictionaryModelImpl.REPLACEDWORDTXT_COLUMN_BITMASK |
			SpecialWordDictionaryModelImpl.LOCALECODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPLACEDWORDTXTANDLOCALECODE =
		new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReplacedWordTxtAndLocaleCode",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException} if it could not be found.
	 *
	 * @param replacedWordTxt the replaced word txt
	 * @param localeCode the locale code
	 * @return the matching special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary findByReplacedWordTxtAndLocaleCode(
		String replacedWordTxt, String localeCode)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = fetchByReplacedWordTxtAndLocaleCode(replacedWordTxt,
				localeCode);

		if (specialWordDictionary == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("replacedWordTxt=");
			msg.append(replacedWordTxt);

			msg.append(", localeCode=");
			msg.append(localeCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpecialWordDictionaryException(msg.toString());
		}

		return specialWordDictionary;
	}

	/**
	 * Returns the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param replacedWordTxt the replaced word txt
	 * @param localeCode the locale code
	 * @return the matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByReplacedWordTxtAndLocaleCode(
		String replacedWordTxt, String localeCode) throws SystemException {
		return fetchByReplacedWordTxtAndLocaleCode(replacedWordTxt, localeCode,
			true);
	}

	/**
	 * Returns the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param replacedWordTxt the replaced word txt
	 * @param localeCode the locale code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByReplacedWordTxtAndLocaleCode(
		String replacedWordTxt, String localeCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { replacedWordTxt, localeCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
					finderArgs, this);
		}

		if (result instanceof SpecialWordDictionary) {
			SpecialWordDictionary specialWordDictionary = (SpecialWordDictionary)result;

			if (!Validator.equals(replacedWordTxt,
						specialWordDictionary.getReplacedWordTxt()) ||
					!Validator.equals(localeCode,
						specialWordDictionary.getLocaleCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SPECIALWORDDICTIONARY_WHERE);

			boolean bindReplacedWordTxt = false;

			if (replacedWordTxt == null) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_1);
			}
			else if (replacedWordTxt.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_3);
			}
			else {
				bindReplacedWordTxt = true;

				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_2);
			}

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReplacedWordTxt) {
					qPos.add(replacedWordTxt);
				}

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				List<SpecialWordDictionary> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SpecialWordDictionaryPersistenceImpl.fetchByReplacedWordTxtAndLocaleCode(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SpecialWordDictionary specialWordDictionary = list.get(0);

					result = specialWordDictionary;

					cacheResult(specialWordDictionary);

					if ((specialWordDictionary.getReplacedWordTxt() == null) ||
							!specialWordDictionary.getReplacedWordTxt()
													  .equals(replacedWordTxt) ||
							(specialWordDictionary.getLocaleCode() == null) ||
							!specialWordDictionary.getLocaleCode()
													  .equals(localeCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
							finderArgs, specialWordDictionary);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
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
			return (SpecialWordDictionary)result;
		}
	}

	/**
	 * Removes the special word dictionary where replacedWordTxt = &#63; and localeCode = &#63; from the database.
	 *
	 * @param replacedWordTxt the replaced word txt
	 * @param localeCode the locale code
	 * @return the special word dictionary that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary removeByReplacedWordTxtAndLocaleCode(
		String replacedWordTxt, String localeCode)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = findByReplacedWordTxtAndLocaleCode(replacedWordTxt,
				localeCode);

		return remove(specialWordDictionary);
	}

	/**
	 * Returns the number of special word dictionaries where replacedWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param replacedWordTxt the replaced word txt
	 * @param localeCode the locale code
	 * @return the number of matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReplacedWordTxtAndLocaleCode(String replacedWordTxt,
		String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPLACEDWORDTXTANDLOCALECODE;

		Object[] finderArgs = new Object[] { replacedWordTxt, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPECIALWORDDICTIONARY_WHERE);

			boolean bindReplacedWordTxt = false;

			if (replacedWordTxt == null) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_1);
			}
			else if (replacedWordTxt.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_3);
			}
			else {
				bindReplacedWordTxt = true;

				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_2);
			}

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReplacedWordTxt) {
					qPos.add(replacedWordTxt);
				}

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

	private static final String _FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_1 =
		"specialWordDictionary.replacedWordTxt IS NULL AND ";
	private static final String _FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_2 =
		"specialWordDictionary.replacedWordTxt = ? AND ";
	private static final String _FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_REPLACEDWORDTXT_3 =
		"(specialWordDictionary.replacedWordTxt IS NULL OR specialWordDictionary.replacedWordTxt = '') AND ";
	private static final String _FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_1 =
		"specialWordDictionary.localeCode IS NULL";
	private static final String _FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_2 =
		"specialWordDictionary.localeCode = ?";
	private static final String _FINDER_COLUMN_REPLACEDWORDTXTANDLOCALECODE_LOCALECODE_3 =
		"(specialWordDictionary.localeCode IS NULL OR specialWordDictionary.localeCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REPLACEMENTWORDTXTANDLOCALECODE =
		new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByReplacementWordTxtAndLocaleCode",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPLACEMENTWORDTXTANDLOCALECODE =
		new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByReplacementWordTxtAndLocaleCode",
			new String[] { String.class.getName(), String.class.getName() },
			SpecialWordDictionaryModelImpl.REPLACEMENTWORDTXT_COLUMN_BITMASK |
			SpecialWordDictionaryModelImpl.LOCALECODE_COLUMN_BITMASK |
			SpecialWordDictionaryModelImpl.REPLACEDWORDTXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REPLACEMENTWORDTXTANDLOCALECODE =
		new FinderPath(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByReplacementWordTxtAndLocaleCode",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @return the matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findByReplacementWordTxtAndLocaleCode(
		String replacementWordTxt, String localeCode) throws SystemException {
		return findByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of special word dictionaries
	 * @param end the upper bound of the range of special word dictionaries (not inclusive)
	 * @return the range of matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findByReplacementWordTxtAndLocaleCode(
		String replacementWordTxt, String localeCode, int start, int end)
		throws SystemException {
		return findByReplacementWordTxtAndLocaleCode(replacementWordTxt,
			localeCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @param start the lower bound of the range of special word dictionaries
	 * @param end the upper bound of the range of special word dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findByReplacementWordTxtAndLocaleCode(
		String replacementWordTxt, String localeCode, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPLACEMENTWORDTXTANDLOCALECODE;
			finderArgs = new Object[] { replacementWordTxt, localeCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REPLACEMENTWORDTXTANDLOCALECODE;
			finderArgs = new Object[] {
					replacementWordTxt, localeCode,
					
					start, end, orderByComparator
				};
		}

		List<SpecialWordDictionary> list = (List<SpecialWordDictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SpecialWordDictionary specialWordDictionary : list) {
				if (!Validator.equals(replacementWordTxt,
							specialWordDictionary.getReplacementWordTxt()) ||
						!Validator.equals(localeCode,
							specialWordDictionary.getLocaleCode())) {
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

			query.append(_SQL_SELECT_SPECIALWORDDICTIONARY_WHERE);

			boolean bindReplacementWordTxt = false;

			if (replacementWordTxt == null) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_1);
			}
			else if (replacementWordTxt.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_3);
			}
			else {
				bindReplacementWordTxt = true;

				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_2);
			}

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpecialWordDictionaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReplacementWordTxt) {
					qPos.add(replacementWordTxt);
				}

				if (bindLocaleCode) {
					qPos.add(localeCode);
				}

				if (!pagination) {
					list = (List<SpecialWordDictionary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpecialWordDictionary>(list);
				}
				else {
					list = (List<SpecialWordDictionary>)QueryUtil.list(q,
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
	 * Returns the first special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary findByReplacementWordTxtAndLocaleCode_First(
		String replacementWordTxt, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = fetchByReplacementWordTxtAndLocaleCode_First(replacementWordTxt,
				localeCode, orderByComparator);

		if (specialWordDictionary != null) {
			return specialWordDictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("replacementWordTxt=");
		msg.append(replacementWordTxt);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecialWordDictionaryException(msg.toString());
	}

	/**
	 * Returns the first special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByReplacementWordTxtAndLocaleCode_First(
		String replacementWordTxt, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<SpecialWordDictionary> list = findByReplacementWordTxtAndLocaleCode(replacementWordTxt,
				localeCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary findByReplacementWordTxtAndLocaleCode_Last(
		String replacementWordTxt, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = fetchByReplacementWordTxtAndLocaleCode_Last(replacementWordTxt,
				localeCode, orderByComparator);

		if (specialWordDictionary != null) {
			return specialWordDictionary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("replacementWordTxt=");
		msg.append(replacementWordTxt);

		msg.append(", localeCode=");
		msg.append(localeCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecialWordDictionaryException(msg.toString());
	}

	/**
	 * Returns the last special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching special word dictionary, or <code>null</code> if a matching special word dictionary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByReplacementWordTxtAndLocaleCode_Last(
		String replacementWordTxt, String localeCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByReplacementWordTxtAndLocaleCode(replacementWordTxt,
				localeCode);

		if (count == 0) {
			return null;
		}

		List<SpecialWordDictionary> list = findByReplacementWordTxtAndLocaleCode(replacementWordTxt,
				localeCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the special word dictionaries before and after the current special word dictionary in the ordered set where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param specialWordId the primary key of the current special word dictionary
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary[] findByReplacementWordTxtAndLocaleCode_PrevAndNext(
		long specialWordId, String replacementWordTxt, String localeCode,
		OrderByComparator orderByComparator)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = findByPrimaryKey(specialWordId);

		Session session = null;

		try {
			session = openSession();

			SpecialWordDictionary[] array = new SpecialWordDictionaryImpl[3];

			array[0] = getByReplacementWordTxtAndLocaleCode_PrevAndNext(session,
					specialWordDictionary, replacementWordTxt, localeCode,
					orderByComparator, true);

			array[1] = specialWordDictionary;

			array[2] = getByReplacementWordTxtAndLocaleCode_PrevAndNext(session,
					specialWordDictionary, replacementWordTxt, localeCode,
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

	protected SpecialWordDictionary getByReplacementWordTxtAndLocaleCode_PrevAndNext(
		Session session, SpecialWordDictionary specialWordDictionary,
		String replacementWordTxt, String localeCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPECIALWORDDICTIONARY_WHERE);

		boolean bindReplacementWordTxt = false;

		if (replacementWordTxt == null) {
			query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_1);
		}
		else if (replacementWordTxt.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_3);
		}
		else {
			bindReplacementWordTxt = true;

			query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_2);
		}

		boolean bindLocaleCode = false;

		if (localeCode == null) {
			query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_1);
		}
		else if (localeCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_3);
		}
		else {
			bindLocaleCode = true;

			query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_2);
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
			query.append(SpecialWordDictionaryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindReplacementWordTxt) {
			qPos.add(replacementWordTxt);
		}

		if (bindLocaleCode) {
			qPos.add(localeCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(specialWordDictionary);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SpecialWordDictionary> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63; from the database.
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByReplacementWordTxtAndLocaleCode(
		String replacementWordTxt, String localeCode) throws SystemException {
		for (SpecialWordDictionary specialWordDictionary : findByReplacementWordTxtAndLocaleCode(
				replacementWordTxt, localeCode, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(specialWordDictionary);
		}
	}

	/**
	 * Returns the number of special word dictionaries where replacementWordTxt = &#63; and localeCode = &#63;.
	 *
	 * @param replacementWordTxt the replacement word txt
	 * @param localeCode the locale code
	 * @return the number of matching special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByReplacementWordTxtAndLocaleCode(
		String replacementWordTxt, String localeCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REPLACEMENTWORDTXTANDLOCALECODE;

		Object[] finderArgs = new Object[] { replacementWordTxt, localeCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPECIALWORDDICTIONARY_WHERE);

			boolean bindReplacementWordTxt = false;

			if (replacementWordTxt == null) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_1);
			}
			else if (replacementWordTxt.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_3);
			}
			else {
				bindReplacementWordTxt = true;

				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_2);
			}

			boolean bindLocaleCode = false;

			if (localeCode == null) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_1);
			}
			else if (localeCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_3);
			}
			else {
				bindLocaleCode = true;

				query.append(_FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindReplacementWordTxt) {
					qPos.add(replacementWordTxt);
				}

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

	private static final String _FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_1 =
		"specialWordDictionary.replacementWordTxt IS NULL AND ";
	private static final String _FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_2 =
		"specialWordDictionary.replacementWordTxt = ? AND ";
	private static final String _FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_REPLACEMENTWORDTXT_3 =
		"(specialWordDictionary.replacementWordTxt IS NULL OR specialWordDictionary.replacementWordTxt = '') AND ";
	private static final String _FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_1 =
		"specialWordDictionary.localeCode IS NULL";
	private static final String _FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_2 =
		"specialWordDictionary.localeCode = ?";
	private static final String _FINDER_COLUMN_REPLACEMENTWORDTXTANDLOCALECODE_LOCALECODE_3 =
		"(specialWordDictionary.localeCode IS NULL OR specialWordDictionary.localeCode = '')";

	public SpecialWordDictionaryPersistenceImpl() {
		setModelClass(SpecialWordDictionary.class);
	}

	/**
	 * Caches the special word dictionary in the entity cache if it is enabled.
	 *
	 * @param specialWordDictionary the special word dictionary
	 */
	@Override
	public void cacheResult(SpecialWordDictionary specialWordDictionary) {
		EntityCacheUtil.putResult(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			specialWordDictionary.getPrimaryKey(), specialWordDictionary);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
			new Object[] {
				specialWordDictionary.getReplacedWordTxt(),
				specialWordDictionary.getLocaleCode()
			}, specialWordDictionary);

		specialWordDictionary.resetOriginalValues();
	}

	/**
	 * Caches the special word dictionaries in the entity cache if it is enabled.
	 *
	 * @param specialWordDictionaries the special word dictionaries
	 */
	@Override
	public void cacheResult(List<SpecialWordDictionary> specialWordDictionaries) {
		for (SpecialWordDictionary specialWordDictionary : specialWordDictionaries) {
			if (EntityCacheUtil.getResult(
						SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
						SpecialWordDictionaryImpl.class,
						specialWordDictionary.getPrimaryKey()) == null) {
				cacheResult(specialWordDictionary);
			}
			else {
				specialWordDictionary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all special word dictionaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SpecialWordDictionaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SpecialWordDictionaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the special word dictionary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SpecialWordDictionary specialWordDictionary) {
		EntityCacheUtil.removeResult(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			specialWordDictionary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(specialWordDictionary);
	}

	@Override
	public void clearCache(List<SpecialWordDictionary> specialWordDictionaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SpecialWordDictionary specialWordDictionary : specialWordDictionaries) {
			EntityCacheUtil.removeResult(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
				SpecialWordDictionaryImpl.class,
				specialWordDictionary.getPrimaryKey());

			clearUniqueFindersCache(specialWordDictionary);
		}
	}

	protected void cacheUniqueFindersCache(
		SpecialWordDictionary specialWordDictionary) {
		if (specialWordDictionary.isNew()) {
			Object[] args = new Object[] {
					specialWordDictionary.getReplacedWordTxt(),
					specialWordDictionary.getLocaleCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPLACEDWORDTXTANDLOCALECODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
				args, specialWordDictionary);
		}
		else {
			SpecialWordDictionaryModelImpl specialWordDictionaryModelImpl = (SpecialWordDictionaryModelImpl)specialWordDictionary;

			if ((specialWordDictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						specialWordDictionary.getReplacedWordTxt(),
						specialWordDictionary.getLocaleCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REPLACEDWORDTXTANDLOCALECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
					args, specialWordDictionary);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SpecialWordDictionary specialWordDictionary) {
		SpecialWordDictionaryModelImpl specialWordDictionaryModelImpl = (SpecialWordDictionaryModelImpl)specialWordDictionary;

		Object[] args = new Object[] {
				specialWordDictionary.getReplacedWordTxt(),
				specialWordDictionary.getLocaleCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPLACEDWORDTXTANDLOCALECODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
			args);

		if ((specialWordDictionaryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					specialWordDictionaryModelImpl.getOriginalReplacedWordTxt(),
					specialWordDictionaryModelImpl.getOriginalLocaleCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPLACEDWORDTXTANDLOCALECODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REPLACEDWORDTXTANDLOCALECODE,
				args);
		}
	}

	/**
	 * Creates a new special word dictionary with the primary key. Does not add the special word dictionary to the database.
	 *
	 * @param specialWordId the primary key for the new special word dictionary
	 * @return the new special word dictionary
	 */
	@Override
	public SpecialWordDictionary create(long specialWordId) {
		SpecialWordDictionary specialWordDictionary = new SpecialWordDictionaryImpl();

		specialWordDictionary.setNew(true);
		specialWordDictionary.setPrimaryKey(specialWordId);

		return specialWordDictionary;
	}

	/**
	 * Removes the special word dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specialWordId the primary key of the special word dictionary
	 * @return the special word dictionary that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary remove(long specialWordId)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		return remove((Serializable)specialWordId);
	}

	/**
	 * Removes the special word dictionary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the special word dictionary
	 * @return the special word dictionary that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary remove(Serializable primaryKey)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SpecialWordDictionary specialWordDictionary = (SpecialWordDictionary)session.get(SpecialWordDictionaryImpl.class,
					primaryKey);

			if (specialWordDictionary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecialWordDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(specialWordDictionary);
		}
		catch (NoSuchSpecialWordDictionaryException nsee) {
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
	protected SpecialWordDictionary removeImpl(
		SpecialWordDictionary specialWordDictionary) throws SystemException {
		specialWordDictionary = toUnwrappedModel(specialWordDictionary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specialWordDictionary)) {
				specialWordDictionary = (SpecialWordDictionary)session.get(SpecialWordDictionaryImpl.class,
						specialWordDictionary.getPrimaryKeyObj());
			}

			if (specialWordDictionary != null) {
				session.delete(specialWordDictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (specialWordDictionary != null) {
			clearCache(specialWordDictionary);
		}

		return specialWordDictionary;
	}

	@Override
	public SpecialWordDictionary updateImpl(
		com.ihg.brandstandards.db.model.SpecialWordDictionary specialWordDictionary)
		throws SystemException {
		specialWordDictionary = toUnwrappedModel(specialWordDictionary);

		boolean isNew = specialWordDictionary.isNew();

		SpecialWordDictionaryModelImpl specialWordDictionaryModelImpl = (SpecialWordDictionaryModelImpl)specialWordDictionary;

		Session session = null;

		try {
			session = openSession();

			if (specialWordDictionary.isNew()) {
				session.save(specialWordDictionary);

				specialWordDictionary.setNew(false);
			}
			else {
				session.merge(specialWordDictionary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SpecialWordDictionaryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((specialWordDictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						specialWordDictionaryModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE,
					args);

				args = new Object[] {
						specialWordDictionaryModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALECODE,
					args);
			}

			if ((specialWordDictionaryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPLACEMENTWORDTXTANDLOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						specialWordDictionaryModelImpl.getOriginalReplacementWordTxt(),
						specialWordDictionaryModelImpl.getOriginalLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPLACEMENTWORDTXTANDLOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPLACEMENTWORDTXTANDLOCALECODE,
					args);

				args = new Object[] {
						specialWordDictionaryModelImpl.getReplacementWordTxt(),
						specialWordDictionaryModelImpl.getLocaleCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REPLACEMENTWORDTXTANDLOCALECODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REPLACEMENTWORDTXTANDLOCALECODE,
					args);
			}
		}

		EntityCacheUtil.putResult(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
			SpecialWordDictionaryImpl.class,
			specialWordDictionary.getPrimaryKey(), specialWordDictionary);

		clearUniqueFindersCache(specialWordDictionary);
		cacheUniqueFindersCache(specialWordDictionary);

		return specialWordDictionary;
	}

	protected SpecialWordDictionary toUnwrappedModel(
		SpecialWordDictionary specialWordDictionary) {
		if (specialWordDictionary instanceof SpecialWordDictionaryImpl) {
			return specialWordDictionary;
		}

		SpecialWordDictionaryImpl specialWordDictionaryImpl = new SpecialWordDictionaryImpl();

		specialWordDictionaryImpl.setNew(specialWordDictionary.isNew());
		specialWordDictionaryImpl.setPrimaryKey(specialWordDictionary.getPrimaryKey());

		specialWordDictionaryImpl.setSpecialWordId(specialWordDictionary.getSpecialWordId());
		specialWordDictionaryImpl.setReplacedWordTxt(specialWordDictionary.getReplacedWordTxt());
		specialWordDictionaryImpl.setReplacementWordTxt(specialWordDictionary.getReplacementWordTxt());
		specialWordDictionaryImpl.setLocaleCode(specialWordDictionary.getLocaleCode());
		specialWordDictionaryImpl.setCreatorId(specialWordDictionary.getCreatorId());
		specialWordDictionaryImpl.setCreatedDate(specialWordDictionary.getCreatedDate());
		specialWordDictionaryImpl.setUpdatedBy(specialWordDictionary.getUpdatedBy());
		specialWordDictionaryImpl.setUpdatedDate(specialWordDictionary.getUpdatedDate());

		return specialWordDictionaryImpl;
	}

	/**
	 * Returns the special word dictionary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the special word dictionary
	 * @return the special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		SpecialWordDictionary specialWordDictionary = fetchByPrimaryKey(primaryKey);

		if (specialWordDictionary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecialWordDictionaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return specialWordDictionary;
	}

	/**
	 * Returns the special word dictionary with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException} if it could not be found.
	 *
	 * @param specialWordId the primary key of the special word dictionary
	 * @return the special word dictionary
	 * @throws com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary findByPrimaryKey(long specialWordId)
		throws NoSuchSpecialWordDictionaryException, SystemException {
		return findByPrimaryKey((Serializable)specialWordId);
	}

	/**
	 * Returns the special word dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the special word dictionary
	 * @return the special word dictionary, or <code>null</code> if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SpecialWordDictionary specialWordDictionary = (SpecialWordDictionary)EntityCacheUtil.getResult(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
				SpecialWordDictionaryImpl.class, primaryKey);

		if (specialWordDictionary == _nullSpecialWordDictionary) {
			return null;
		}

		if (specialWordDictionary == null) {
			Session session = null;

			try {
				session = openSession();

				specialWordDictionary = (SpecialWordDictionary)session.get(SpecialWordDictionaryImpl.class,
						primaryKey);

				if (specialWordDictionary != null) {
					cacheResult(specialWordDictionary);
				}
				else {
					EntityCacheUtil.putResult(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
						SpecialWordDictionaryImpl.class, primaryKey,
						_nullSpecialWordDictionary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SpecialWordDictionaryModelImpl.ENTITY_CACHE_ENABLED,
					SpecialWordDictionaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return specialWordDictionary;
	}

	/**
	 * Returns the special word dictionary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specialWordId the primary key of the special word dictionary
	 * @return the special word dictionary, or <code>null</code> if a special word dictionary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SpecialWordDictionary fetchByPrimaryKey(long specialWordId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)specialWordId);
	}

	/**
	 * Returns all the special word dictionaries.
	 *
	 * @return the special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the special word dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of special word dictionaries
	 * @param end the upper bound of the range of special word dictionaries (not inclusive)
	 * @return the range of special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the special word dictionaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of special word dictionaries
	 * @param end the upper bound of the range of special word dictionaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of special word dictionaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SpecialWordDictionary> findAll(int start, int end,
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

		List<SpecialWordDictionary> list = (List<SpecialWordDictionary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPECIALWORDDICTIONARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPECIALWORDDICTIONARY;

				if (pagination) {
					sql = sql.concat(SpecialWordDictionaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SpecialWordDictionary>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SpecialWordDictionary>(list);
				}
				else {
					list = (List<SpecialWordDictionary>)QueryUtil.list(q,
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
	 * Removes all the special word dictionaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SpecialWordDictionary specialWordDictionary : findAll()) {
			remove(specialWordDictionary);
		}
	}

	/**
	 * Returns the number of special word dictionaries.
	 *
	 * @return the number of special word dictionaries
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

				Query q = session.createQuery(_SQL_COUNT_SPECIALWORDDICTIONARY);

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
	 * Initializes the special word dictionary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.SpecialWordDictionary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SpecialWordDictionary>> listenersList = new ArrayList<ModelListener<SpecialWordDictionary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SpecialWordDictionary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SpecialWordDictionaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPECIALWORDDICTIONARY = "SELECT specialWordDictionary FROM SpecialWordDictionary specialWordDictionary";
	private static final String _SQL_SELECT_SPECIALWORDDICTIONARY_WHERE = "SELECT specialWordDictionary FROM SpecialWordDictionary specialWordDictionary WHERE ";
	private static final String _SQL_COUNT_SPECIALWORDDICTIONARY = "SELECT COUNT(specialWordDictionary) FROM SpecialWordDictionary specialWordDictionary";
	private static final String _SQL_COUNT_SPECIALWORDDICTIONARY_WHERE = "SELECT COUNT(specialWordDictionary) FROM SpecialWordDictionary specialWordDictionary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "specialWordDictionary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SpecialWordDictionary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SpecialWordDictionary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SpecialWordDictionaryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"specialWordId", "replacedWordTxt", "replacementWordTxt",
				"localeCode", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static SpecialWordDictionary _nullSpecialWordDictionary = new SpecialWordDictionaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SpecialWordDictionary> toCacheModel() {
				return _nullSpecialWordDictionaryCacheModel;
			}
		};

	private static CacheModel<SpecialWordDictionary> _nullSpecialWordDictionaryCacheModel =
		new CacheModel<SpecialWordDictionary>() {
			@Override
			public SpecialWordDictionary toEntityModel() {
				return _nullSpecialWordDictionary;
			}
		};
}