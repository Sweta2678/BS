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

import com.ihg.brandstandards.db.NoSuchGlossaryTranslateException;
import com.ihg.brandstandards.db.model.GlossaryTranslate;
import com.ihg.brandstandards.db.model.impl.GlossaryTranslateImpl;
import com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl;

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
 * The persistence implementation for the glossary translate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryTranslatePersistence
 * @see GlossaryTranslateUtil
 * @generated
 */
public class GlossaryTranslatePersistenceImpl extends BasePersistenceImpl<GlossaryTranslate>
	implements GlossaryTranslatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GlossaryTranslateUtil} to access the glossary translate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GlossaryTranslateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED,
			GlossaryTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED,
			GlossaryTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED,
			GlossaryTranslateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByglossaryIdLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() },
			GlossaryTranslateModelImpl.GLOSSARYID_COLUMN_BITMASK |
			GlossaryTranslateModelImpl.LANGCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYIDLOCALECODE = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByglossaryIdLocaleCode",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the glossary translate where glossaryId = &#63; and langCode = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryTranslateException} if it could not be found.
	 *
	 * @param glossaryId the glossary ID
	 * @param langCode the lang code
	 * @return the matching glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate findByglossaryIdLocaleCode(long glossaryId,
		String langCode)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = fetchByglossaryIdLocaleCode(glossaryId,
				langCode);

		if (glossaryTranslate == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("glossaryId=");
			msg.append(glossaryId);

			msg.append(", langCode=");
			msg.append(langCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGlossaryTranslateException(msg.toString());
		}

		return glossaryTranslate;
	}

	/**
	 * Returns the glossary translate where glossaryId = &#63; and langCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param glossaryId the glossary ID
	 * @param langCode the lang code
	 * @return the matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchByglossaryIdLocaleCode(long glossaryId,
		String langCode) throws SystemException {
		return fetchByglossaryIdLocaleCode(glossaryId, langCode, true);
	}

	/**
	 * Returns the glossary translate where glossaryId = &#63; and langCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param glossaryId the glossary ID
	 * @param langCode the lang code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchByglossaryIdLocaleCode(long glossaryId,
		String langCode, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { glossaryId, langCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
					finderArgs, this);
		}

		if (result instanceof GlossaryTranslate) {
			GlossaryTranslate glossaryTranslate = (GlossaryTranslate)result;

			if ((glossaryId != glossaryTranslate.getGlossaryId()) ||
					!Validator.equals(langCode, glossaryTranslate.getLangCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GLOSSARYTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_GLOSSARYID_2);

			boolean bindLangCode = false;

			if (langCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_1);
			}
			else if (langCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_3);
			}
			else {
				bindLangCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				if (bindLangCode) {
					qPos.add(langCode);
				}

				List<GlossaryTranslate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GlossaryTranslatePersistenceImpl.fetchByglossaryIdLocaleCode(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					GlossaryTranslate glossaryTranslate = list.get(0);

					result = glossaryTranslate;

					cacheResult(glossaryTranslate);

					if ((glossaryTranslate.getGlossaryId() != glossaryId) ||
							(glossaryTranslate.getLangCode() == null) ||
							!glossaryTranslate.getLangCode().equals(langCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
							finderArgs, glossaryTranslate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
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
			return (GlossaryTranslate)result;
		}
	}

	/**
	 * Removes the glossary translate where glossaryId = &#63; and langCode = &#63; from the database.
	 *
	 * @param glossaryId the glossary ID
	 * @param langCode the lang code
	 * @return the glossary translate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate removeByglossaryIdLocaleCode(long glossaryId,
		String langCode)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = findByglossaryIdLocaleCode(glossaryId,
				langCode);

		return remove(glossaryTranslate);
	}

	/**
	 * Returns the number of glossary translates where glossaryId = &#63; and langCode = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param langCode the lang code
	 * @return the number of matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryIdLocaleCode(long glossaryId, String langCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYIDLOCALECODE;

		Object[] finderArgs = new Object[] { glossaryId, langCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GLOSSARYTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_GLOSSARYID_2);

			boolean bindLangCode = false;

			if (langCode == null) {
				query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_1);
			}
			else if (langCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_3);
			}
			else {
				bindLangCode = true;

				query.append(_FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				if (bindLangCode) {
					qPos.add(langCode);
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

	private static final String _FINDER_COLUMN_GLOSSARYIDLOCALECODE_GLOSSARYID_2 =
		"glossaryTranslate.glossaryId = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_1 = "glossaryTranslate.langCode IS NULL";
	private static final String _FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_2 = "glossaryTranslate.langCode = ?";
	private static final String _FINDER_COLUMN_GLOSSARYIDLOCALECODE_LANGCODE_3 = "(glossaryTranslate.langCode IS NULL OR glossaryTranslate.langCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGCODE = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED,
			GlossaryTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylangCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGCODE =
		new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED,
			GlossaryTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylangCode",
			new String[] { String.class.getName() },
			GlossaryTranslateModelImpl.LANGCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LANGCODE = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylangCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the glossary translates where langCode = &#63;.
	 *
	 * @param langCode the lang code
	 * @return the matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findBylangCode(String langCode)
		throws SystemException {
		return findBylangCode(langCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the glossary translates where langCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param langCode the lang code
	 * @param start the lower bound of the range of glossary translates
	 * @param end the upper bound of the range of glossary translates (not inclusive)
	 * @return the range of matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findBylangCode(String langCode, int start,
		int end) throws SystemException {
		return findBylangCode(langCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossary translates where langCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param langCode the lang code
	 * @param start the lower bound of the range of glossary translates
	 * @param end the upper bound of the range of glossary translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findBylangCode(String langCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGCODE;
			finderArgs = new Object[] { langCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LANGCODE;
			finderArgs = new Object[] { langCode, start, end, orderByComparator };
		}

		List<GlossaryTranslate> list = (List<GlossaryTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlossaryTranslate glossaryTranslate : list) {
				if (!Validator.equals(langCode, glossaryTranslate.getLangCode())) {
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

			query.append(_SQL_SELECT_GLOSSARYTRANSLATE_WHERE);

			boolean bindLangCode = false;

			if (langCode == null) {
				query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_1);
			}
			else if (langCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_3);
			}
			else {
				bindLangCode = true;

				query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryTranslateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLangCode) {
					qPos.add(langCode);
				}

				if (!pagination) {
					list = (List<GlossaryTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryTranslate>(list);
				}
				else {
					list = (List<GlossaryTranslate>)QueryUtil.list(q,
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
	 * Returns the first glossary translate in the ordered set where langCode = &#63;.
	 *
	 * @param langCode the lang code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate findBylangCode_First(String langCode,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = fetchBylangCode_First(langCode,
				orderByComparator);

		if (glossaryTranslate != null) {
			return glossaryTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("langCode=");
		msg.append(langCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryTranslateException(msg.toString());
	}

	/**
	 * Returns the first glossary translate in the ordered set where langCode = &#63;.
	 *
	 * @param langCode the lang code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchBylangCode_First(String langCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlossaryTranslate> list = findBylangCode(langCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary translate in the ordered set where langCode = &#63;.
	 *
	 * @param langCode the lang code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate findBylangCode_Last(String langCode,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = fetchBylangCode_Last(langCode,
				orderByComparator);

		if (glossaryTranslate != null) {
			return glossaryTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("langCode=");
		msg.append(langCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryTranslateException(msg.toString());
	}

	/**
	 * Returns the last glossary translate in the ordered set where langCode = &#63;.
	 *
	 * @param langCode the lang code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchBylangCode_Last(String langCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBylangCode(langCode);

		if (count == 0) {
			return null;
		}

		List<GlossaryTranslate> list = findBylangCode(langCode, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the glossary translates before and after the current glossary translate in the ordered set where langCode = &#63;.
	 *
	 * @param glossaryXlatId the primary key of the current glossary translate
	 * @param langCode the lang code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate[] findBylangCode_PrevAndNext(long glossaryXlatId,
		String langCode, OrderByComparator orderByComparator)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = findByPrimaryKey(glossaryXlatId);

		Session session = null;

		try {
			session = openSession();

			GlossaryTranslate[] array = new GlossaryTranslateImpl[3];

			array[0] = getBylangCode_PrevAndNext(session, glossaryTranslate,
					langCode, orderByComparator, true);

			array[1] = glossaryTranslate;

			array[2] = getBylangCode_PrevAndNext(session, glossaryTranslate,
					langCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlossaryTranslate getBylangCode_PrevAndNext(Session session,
		GlossaryTranslate glossaryTranslate, String langCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOSSARYTRANSLATE_WHERE);

		boolean bindLangCode = false;

		if (langCode == null) {
			query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_1);
		}
		else if (langCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_3);
		}
		else {
			bindLangCode = true;

			query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_2);
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
			query.append(GlossaryTranslateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindLangCode) {
			qPos.add(langCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(glossaryTranslate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlossaryTranslate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the glossary translates where langCode = &#63; from the database.
	 *
	 * @param langCode the lang code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBylangCode(String langCode) throws SystemException {
		for (GlossaryTranslate glossaryTranslate : findBylangCode(langCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(glossaryTranslate);
		}
	}

	/**
	 * Returns the number of glossary translates where langCode = &#63;.
	 *
	 * @param langCode the lang code
	 * @return the number of matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBylangCode(String langCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LANGCODE;

		Object[] finderArgs = new Object[] { langCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOSSARYTRANSLATE_WHERE);

			boolean bindLangCode = false;

			if (langCode == null) {
				query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_1);
			}
			else if (langCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_3);
			}
			else {
				bindLangCode = true;

				query.append(_FINDER_COLUMN_LANGCODE_LANGCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindLangCode) {
					qPos.add(langCode);
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

	private static final String _FINDER_COLUMN_LANGCODE_LANGCODE_1 = "glossaryTranslate.langCode IS NULL";
	private static final String _FINDER_COLUMN_LANGCODE_LANGCODE_2 = "glossaryTranslate.langCode = ?";
	private static final String _FINDER_COLUMN_LANGCODE_LANGCODE_3 = "(glossaryTranslate.langCode IS NULL OR glossaryTranslate.langCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYID =
		new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED,
			GlossaryTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGlossaryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID =
		new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED,
			GlossaryTranslateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGlossaryId",
			new String[] { Long.class.getName() },
			GlossaryTranslateModelImpl.GLOSSARYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYID = new FinderPath(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGlossaryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the glossary translates where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @return the matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findByGlossaryId(long glossaryId)
		throws SystemException {
		return findByGlossaryId(glossaryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary translates where glossaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param start the lower bound of the range of glossary translates
	 * @param end the upper bound of the range of glossary translates (not inclusive)
	 * @return the range of matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findByGlossaryId(long glossaryId, int start,
		int end) throws SystemException {
		return findByGlossaryId(glossaryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossary translates where glossaryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param start the lower bound of the range of glossary translates
	 * @param end the upper bound of the range of glossary translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findByGlossaryId(long glossaryId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID;
			finderArgs = new Object[] { glossaryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYID;
			finderArgs = new Object[] { glossaryId, start, end, orderByComparator };
		}

		List<GlossaryTranslate> list = (List<GlossaryTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (GlossaryTranslate glossaryTranslate : list) {
				if ((glossaryId != glossaryTranslate.getGlossaryId())) {
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

			query.append(_SQL_SELECT_GLOSSARYTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryTranslateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				if (!pagination) {
					list = (List<GlossaryTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryTranslate>(list);
				}
				else {
					list = (List<GlossaryTranslate>)QueryUtil.list(q,
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
	 * Returns the first glossary translate in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate findByGlossaryId_First(long glossaryId,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = fetchByGlossaryId_First(glossaryId,
				orderByComparator);

		if (glossaryTranslate != null) {
			return glossaryTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryTranslateException(msg.toString());
	}

	/**
	 * Returns the first glossary translate in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchByGlossaryId_First(long glossaryId,
		OrderByComparator orderByComparator) throws SystemException {
		List<GlossaryTranslate> list = findByGlossaryId(glossaryId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary translate in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate findByGlossaryId_Last(long glossaryId,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = fetchByGlossaryId_Last(glossaryId,
				orderByComparator);

		if (glossaryTranslate != null) {
			return glossaryTranslate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryTranslateException(msg.toString());
	}

	/**
	 * Returns the last glossary translate in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary translate, or <code>null</code> if a matching glossary translate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchByGlossaryId_Last(long glossaryId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGlossaryId(glossaryId);

		if (count == 0) {
			return null;
		}

		List<GlossaryTranslate> list = findByGlossaryId(glossaryId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the glossary translates before and after the current glossary translate in the ordered set where glossaryId = &#63;.
	 *
	 * @param glossaryXlatId the primary key of the current glossary translate
	 * @param glossaryId the glossary ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate[] findByGlossaryId_PrevAndNext(
		long glossaryXlatId, long glossaryId,
		OrderByComparator orderByComparator)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = findByPrimaryKey(glossaryXlatId);

		Session session = null;

		try {
			session = openSession();

			GlossaryTranslate[] array = new GlossaryTranslateImpl[3];

			array[0] = getByGlossaryId_PrevAndNext(session, glossaryTranslate,
					glossaryId, orderByComparator, true);

			array[1] = glossaryTranslate;

			array[2] = getByGlossaryId_PrevAndNext(session, glossaryTranslate,
					glossaryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected GlossaryTranslate getByGlossaryId_PrevAndNext(Session session,
		GlossaryTranslate glossaryTranslate, long glossaryId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GLOSSARYTRANSLATE_WHERE);

		query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

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
			query.append(GlossaryTranslateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(glossaryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(glossaryTranslate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<GlossaryTranslate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the glossary translates where glossaryId = &#63; from the database.
	 *
	 * @param glossaryId the glossary ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGlossaryId(long glossaryId) throws SystemException {
		for (GlossaryTranslate glossaryTranslate : findByGlossaryId(
				glossaryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(glossaryTranslate);
		}
	}

	/**
	 * Returns the number of glossary translates where glossaryId = &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @return the number of matching glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGlossaryId(long glossaryId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYID;

		Object[] finderArgs = new Object[] { glossaryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOSSARYTRANSLATE_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

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

	private static final String _FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2 = "glossaryTranslate.glossaryId = ?";

	public GlossaryTranslatePersistenceImpl() {
		setModelClass(GlossaryTranslate.class);
	}

	/**
	 * Caches the glossary translate in the entity cache if it is enabled.
	 *
	 * @param glossaryTranslate the glossary translate
	 */
	@Override
	public void cacheResult(GlossaryTranslate glossaryTranslate) {
		EntityCacheUtil.putResult(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateImpl.class, glossaryTranslate.getPrimaryKey(),
			glossaryTranslate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
			new Object[] {
				glossaryTranslate.getGlossaryId(),
				glossaryTranslate.getLangCode()
			}, glossaryTranslate);

		glossaryTranslate.resetOriginalValues();
	}

	/**
	 * Caches the glossary translates in the entity cache if it is enabled.
	 *
	 * @param glossaryTranslates the glossary translates
	 */
	@Override
	public void cacheResult(List<GlossaryTranslate> glossaryTranslates) {
		for (GlossaryTranslate glossaryTranslate : glossaryTranslates) {
			if (EntityCacheUtil.getResult(
						GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryTranslateImpl.class,
						glossaryTranslate.getPrimaryKey()) == null) {
				cacheResult(glossaryTranslate);
			}
			else {
				glossaryTranslate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all glossary translates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GlossaryTranslateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GlossaryTranslateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the glossary translate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GlossaryTranslate glossaryTranslate) {
		EntityCacheUtil.removeResult(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateImpl.class, glossaryTranslate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(glossaryTranslate);
	}

	@Override
	public void clearCache(List<GlossaryTranslate> glossaryTranslates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GlossaryTranslate glossaryTranslate : glossaryTranslates) {
			EntityCacheUtil.removeResult(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryTranslateImpl.class, glossaryTranslate.getPrimaryKey());

			clearUniqueFindersCache(glossaryTranslate);
		}
	}

	protected void cacheUniqueFindersCache(GlossaryTranslate glossaryTranslate) {
		if (glossaryTranslate.isNew()) {
			Object[] args = new Object[] {
					glossaryTranslate.getGlossaryId(),
					glossaryTranslate.getLangCode()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOSSARYIDLOCALECODE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
				args, glossaryTranslate);
		}
		else {
			GlossaryTranslateModelImpl glossaryTranslateModelImpl = (GlossaryTranslateModelImpl)glossaryTranslate;

			if ((glossaryTranslateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryTranslate.getGlossaryId(),
						glossaryTranslate.getLangCode()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOSSARYIDLOCALECODE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
					args, glossaryTranslate);
			}
		}
	}

	protected void clearUniqueFindersCache(GlossaryTranslate glossaryTranslate) {
		GlossaryTranslateModelImpl glossaryTranslateModelImpl = (GlossaryTranslateModelImpl)glossaryTranslate;

		Object[] args = new Object[] {
				glossaryTranslate.getGlossaryId(),
				glossaryTranslate.getLangCode()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYIDLOCALECODE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
			args);

		if ((glossaryTranslateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE.getColumnBitmask()) != 0) {
			args = new Object[] {
					glossaryTranslateModelImpl.getOriginalGlossaryId(),
					glossaryTranslateModelImpl.getOriginalLangCode()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYIDLOCALECODE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYIDLOCALECODE,
				args);
		}
	}

	/**
	 * Creates a new glossary translate with the primary key. Does not add the glossary translate to the database.
	 *
	 * @param glossaryXlatId the primary key for the new glossary translate
	 * @return the new glossary translate
	 */
	@Override
	public GlossaryTranslate create(long glossaryXlatId) {
		GlossaryTranslate glossaryTranslate = new GlossaryTranslateImpl();

		glossaryTranslate.setNew(true);
		glossaryTranslate.setPrimaryKey(glossaryXlatId);

		return glossaryTranslate;
	}

	/**
	 * Removes the glossary translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param glossaryXlatId the primary key of the glossary translate
	 * @return the glossary translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate remove(long glossaryXlatId)
		throws NoSuchGlossaryTranslateException, SystemException {
		return remove((Serializable)glossaryXlatId);
	}

	/**
	 * Removes the glossary translate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the glossary translate
	 * @return the glossary translate that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate remove(Serializable primaryKey)
		throws NoSuchGlossaryTranslateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GlossaryTranslate glossaryTranslate = (GlossaryTranslate)session.get(GlossaryTranslateImpl.class,
					primaryKey);

			if (glossaryTranslate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlossaryTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(glossaryTranslate);
		}
		catch (NoSuchGlossaryTranslateException nsee) {
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
	protected GlossaryTranslate removeImpl(GlossaryTranslate glossaryTranslate)
		throws SystemException {
		glossaryTranslate = toUnwrappedModel(glossaryTranslate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(glossaryTranslate)) {
				glossaryTranslate = (GlossaryTranslate)session.get(GlossaryTranslateImpl.class,
						glossaryTranslate.getPrimaryKeyObj());
			}

			if (glossaryTranslate != null) {
				session.delete(glossaryTranslate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (glossaryTranslate != null) {
			clearCache(glossaryTranslate);
		}

		return glossaryTranslate;
	}

	@Override
	public GlossaryTranslate updateImpl(
		com.ihg.brandstandards.db.model.GlossaryTranslate glossaryTranslate)
		throws SystemException {
		glossaryTranslate = toUnwrappedModel(glossaryTranslate);

		boolean isNew = glossaryTranslate.isNew();

		GlossaryTranslateModelImpl glossaryTranslateModelImpl = (GlossaryTranslateModelImpl)glossaryTranslate;

		Session session = null;

		try {
			session = openSession();

			if (glossaryTranslate.isNew()) {
				session.save(glossaryTranslate);

				glossaryTranslate.setNew(false);
			}
			else {
				session.merge(glossaryTranslate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GlossaryTranslateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((glossaryTranslateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryTranslateModelImpl.getOriginalLangCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGCODE,
					args);

				args = new Object[] { glossaryTranslateModelImpl.getLangCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LANGCODE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LANGCODE,
					args);
			}

			if ((glossaryTranslateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						glossaryTranslateModelImpl.getOriginalGlossaryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID,
					args);

				args = new Object[] { glossaryTranslateModelImpl.getGlossaryId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GLOSSARYID,
					args);
			}
		}

		EntityCacheUtil.putResult(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryTranslateImpl.class, glossaryTranslate.getPrimaryKey(),
			glossaryTranslate);

		clearUniqueFindersCache(glossaryTranslate);
		cacheUniqueFindersCache(glossaryTranslate);

		return glossaryTranslate;
	}

	protected GlossaryTranslate toUnwrappedModel(
		GlossaryTranslate glossaryTranslate) {
		if (glossaryTranslate instanceof GlossaryTranslateImpl) {
			return glossaryTranslate;
		}

		GlossaryTranslateImpl glossaryTranslateImpl = new GlossaryTranslateImpl();

		glossaryTranslateImpl.setNew(glossaryTranslate.isNew());
		glossaryTranslateImpl.setPrimaryKey(glossaryTranslate.getPrimaryKey());

		glossaryTranslateImpl.setGlossaryXlatId(glossaryTranslate.getGlossaryXlatId());
		glossaryTranslateImpl.setGlossaryId(glossaryTranslate.getGlossaryId());
		glossaryTranslateImpl.setLangCode(glossaryTranslate.getLangCode());
		glossaryTranslateImpl.setGlossaryTermText(glossaryTranslate.getGlossaryTermText());
		glossaryTranslateImpl.setGlossaryTermDesc(glossaryTranslate.getGlossaryTermDesc());
		glossaryTranslateImpl.setIsValidTermTxt(glossaryTranslate.getIsValidTermTxt());
		glossaryTranslateImpl.setIsValidDescTxt(glossaryTranslate.getIsValidDescTxt());
		glossaryTranslateImpl.setCreatorId(glossaryTranslate.getCreatorId());
		glossaryTranslateImpl.setCreatedDate(glossaryTranslate.getCreatedDate());
		glossaryTranslateImpl.setUpdatedBy(glossaryTranslate.getUpdatedBy());
		glossaryTranslateImpl.setUpdatedDate(glossaryTranslate.getUpdatedDate());

		return glossaryTranslateImpl;
	}

	/**
	 * Returns the glossary translate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary translate
	 * @return the glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGlossaryTranslateException, SystemException {
		GlossaryTranslate glossaryTranslate = fetchByPrimaryKey(primaryKey);

		if (glossaryTranslate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGlossaryTranslateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return glossaryTranslate;
	}

	/**
	 * Returns the glossary translate with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryTranslateException} if it could not be found.
	 *
	 * @param glossaryXlatId the primary key of the glossary translate
	 * @return the glossary translate
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryTranslateException if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate findByPrimaryKey(long glossaryXlatId)
		throws NoSuchGlossaryTranslateException, SystemException {
		return findByPrimaryKey((Serializable)glossaryXlatId);
	}

	/**
	 * Returns the glossary translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary translate
	 * @return the glossary translate, or <code>null</code> if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GlossaryTranslate glossaryTranslate = (GlossaryTranslate)EntityCacheUtil.getResult(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryTranslateImpl.class, primaryKey);

		if (glossaryTranslate == _nullGlossaryTranslate) {
			return null;
		}

		if (glossaryTranslate == null) {
			Session session = null;

			try {
				session = openSession();

				glossaryTranslate = (GlossaryTranslate)session.get(GlossaryTranslateImpl.class,
						primaryKey);

				if (glossaryTranslate != null) {
					cacheResult(glossaryTranslate);
				}
				else {
					EntityCacheUtil.putResult(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryTranslateImpl.class, primaryKey,
						_nullGlossaryTranslate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GlossaryTranslateModelImpl.ENTITY_CACHE_ENABLED,
					GlossaryTranslateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return glossaryTranslate;
	}

	/**
	 * Returns the glossary translate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param glossaryXlatId the primary key of the glossary translate
	 * @return the glossary translate, or <code>null</code> if a glossary translate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GlossaryTranslate fetchByPrimaryKey(long glossaryXlatId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)glossaryXlatId);
	}

	/**
	 * Returns all the glossary translates.
	 *
	 * @return the glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossary translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossary translates
	 * @param end the upper bound of the range of glossary translates (not inclusive)
	 * @return the range of glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossary translates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryTranslateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossary translates
	 * @param end the upper bound of the range of glossary translates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of glossary translates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GlossaryTranslate> findAll(int start, int end,
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

		List<GlossaryTranslate> list = (List<GlossaryTranslate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GLOSSARYTRANSLATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GLOSSARYTRANSLATE;

				if (pagination) {
					sql = sql.concat(GlossaryTranslateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GlossaryTranslate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GlossaryTranslate>(list);
				}
				else {
					list = (List<GlossaryTranslate>)QueryUtil.list(q,
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
	 * Removes all the glossary translates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GlossaryTranslate glossaryTranslate : findAll()) {
			remove(glossaryTranslate);
		}
	}

	/**
	 * Returns the number of glossary translates.
	 *
	 * @return the number of glossary translates
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

				Query q = session.createQuery(_SQL_COUNT_GLOSSARYTRANSLATE);

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
	 * Initializes the glossary translate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GlossaryTranslate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GlossaryTranslate>> listenersList = new ArrayList<ModelListener<GlossaryTranslate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GlossaryTranslate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GlossaryTranslateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GLOSSARYTRANSLATE = "SELECT glossaryTranslate FROM GlossaryTranslate glossaryTranslate";
	private static final String _SQL_SELECT_GLOSSARYTRANSLATE_WHERE = "SELECT glossaryTranslate FROM GlossaryTranslate glossaryTranslate WHERE ";
	private static final String _SQL_COUNT_GLOSSARYTRANSLATE = "SELECT COUNT(glossaryTranslate) FROM GlossaryTranslate glossaryTranslate";
	private static final String _SQL_COUNT_GLOSSARYTRANSLATE_WHERE = "SELECT COUNT(glossaryTranslate) FROM GlossaryTranslate glossaryTranslate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "glossaryTranslate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GlossaryTranslate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GlossaryTranslate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GlossaryTranslatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"glossaryXlatId", "glossaryId", "langCode", "glossaryTermText",
				"glossaryTermDesc", "isValidTermTxt", "isValidDescTxt",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static GlossaryTranslate _nullGlossaryTranslate = new GlossaryTranslateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GlossaryTranslate> toCacheModel() {
				return _nullGlossaryTranslateCacheModel;
			}
		};

	private static CacheModel<GlossaryTranslate> _nullGlossaryTranslateCacheModel =
		new CacheModel<GlossaryTranslate>() {
			@Override
			public GlossaryTranslate toEntityModel() {
				return _nullGlossaryTranslate;
			}
		};
}