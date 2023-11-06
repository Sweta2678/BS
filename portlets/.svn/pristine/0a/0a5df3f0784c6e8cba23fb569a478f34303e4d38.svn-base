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

import com.ihg.brandstandards.db.NoSuchGlossaryException;
import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.impl.GlossaryImpl;
import com.ihg.brandstandards.db.model.impl.GlossaryModelImpl;

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
import com.liferay.portal.kernel.util.CharPool;
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
 * The persistence implementation for the glossary service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GlossaryPersistence
 * @see GlossaryUtil
 * @generated
 */
public class GlossaryPersistenceImpl extends BasePersistenceImpl<Glossary>
	implements GlossaryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GlossaryUtil} to access the glossary persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GlossaryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, GlossaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, GlossaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYID =
		new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, GlossaryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByglossaryId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_GLOSSARYID =
		new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByglossaryId",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @return the matching glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findByglossaryId(long glossaryId,
		String glossaryTermText) throws SystemException {
		return findByglossaryId(glossaryId, glossaryTermText,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @param start the lower bound of the range of glossaries
	 * @param end the upper bound of the range of glossaries (not inclusive)
	 * @return the range of matching glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findByglossaryId(long glossaryId,
		String glossaryTermText, int start, int end) throws SystemException {
		return findByglossaryId(glossaryId, glossaryTermText, start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @param start the lower bound of the range of glossaries
	 * @param end the upper bound of the range of glossaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findByglossaryId(long glossaryId,
		String glossaryTermText, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GLOSSARYID;
		finderArgs = new Object[] {
				glossaryId, glossaryTermText,
				
				start, end, orderByComparator
			};

		List<Glossary> list = (List<Glossary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Glossary glossary : list) {
				if ((glossaryId != glossary.getGlossaryId()) ||
						!StringUtil.wildcardMatches(
							glossary.getGlossaryTermText(), glossaryTermText,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
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

			query.append(_SQL_SELECT_GLOSSARY_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

			boolean bindGlossaryTermText = false;

			if (glossaryTermText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_1);
			}
			else if (glossaryTermText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_3);
			}
			else {
				bindGlossaryTermText = true;

				query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GlossaryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				if (bindGlossaryTermText) {
					qPos.add(glossaryTermText);
				}

				if (!pagination) {
					list = (List<Glossary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Glossary>(list);
				}
				else {
					list = (List<Glossary>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a matching glossary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary findByglossaryId_First(long glossaryId,
		String glossaryTermText, OrderByComparator orderByComparator)
		throws NoSuchGlossaryException, SystemException {
		Glossary glossary = fetchByglossaryId_First(glossaryId,
				glossaryTermText, orderByComparator);

		if (glossary != null) {
			return glossary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(", glossaryTermText=");
		msg.append(glossaryTermText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryException(msg.toString());
	}

	/**
	 * Returns the first glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching glossary, or <code>null</code> if a matching glossary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByglossaryId_First(long glossaryId,
		String glossaryTermText, OrderByComparator orderByComparator)
		throws SystemException {
		List<Glossary> list = findByglossaryId(glossaryId, glossaryTermText, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a matching glossary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary findByglossaryId_Last(long glossaryId,
		String glossaryTermText, OrderByComparator orderByComparator)
		throws NoSuchGlossaryException, SystemException {
		Glossary glossary = fetchByglossaryId_Last(glossaryId,
				glossaryTermText, orderByComparator);

		if (glossary != null) {
			return glossary;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("glossaryId=");
		msg.append(glossaryId);

		msg.append(", glossaryTermText=");
		msg.append(glossaryTermText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGlossaryException(msg.toString());
	}

	/**
	 * Returns the last glossary in the ordered set where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching glossary, or <code>null</code> if a matching glossary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByglossaryId_Last(long glossaryId,
		String glossaryTermText, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByglossaryId(glossaryId, glossaryTermText);

		if (count == 0) {
			return null;
		}

		List<Glossary> list = findByglossaryId(glossaryId, glossaryTermText,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63; from the database.
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByglossaryId(long glossaryId, String glossaryTermText)
		throws SystemException {
		for (Glossary glossary : findByglossaryId(glossaryId, glossaryTermText,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(glossary);
		}
	}

	/**
	 * Returns the number of glossaries where glossaryId = &#63; and glossaryTermText LIKE &#63;.
	 *
	 * @param glossaryId the glossary ID
	 * @param glossaryTermText the glossary term text
	 * @return the number of matching glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryId(long glossaryId, String glossaryTermText)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_GLOSSARYID;

		Object[] finderArgs = new Object[] { glossaryId, glossaryTermText };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GLOSSARY_WHERE);

			query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2);

			boolean bindGlossaryTermText = false;

			if (glossaryTermText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_1);
			}
			else if (glossaryTermText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_3);
			}
			else {
				bindGlossaryTermText = true;

				query.append(_FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(glossaryId);

				if (bindGlossaryTermText) {
					qPos.add(glossaryTermText);
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

	private static final String _FINDER_COLUMN_GLOSSARYID_GLOSSARYID_2 = "glossary.glossaryId = ? AND ";
	private static final String _FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_1 = "glossary.glossaryTermText LIKE NULL";
	private static final String _FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_2 = "glossary.glossaryTermText LIKE ?";
	private static final String _FINDER_COLUMN_GLOSSARYID_GLOSSARYTERMTEXT_3 = "(glossary.glossaryTermText IS NULL OR glossary.glossaryTermText LIKE '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, GlossaryImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByglossaryTermText",
			new String[] { String.class.getName() },
			GlossaryModelImpl.GLOSSARYTERMTEXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GLOSSARYTERMTEXT = new FinderPath(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByglossaryTermText", new String[] { String.class.getName() });

	/**
	 * Returns the glossary where glossaryTermText = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryException} if it could not be found.
	 *
	 * @param glossaryTermText the glossary term text
	 * @return the matching glossary
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a matching glossary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary findByglossaryTermText(String glossaryTermText)
		throws NoSuchGlossaryException, SystemException {
		Glossary glossary = fetchByglossaryTermText(glossaryTermText);

		if (glossary == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("glossaryTermText=");
			msg.append(glossaryTermText);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchGlossaryException(msg.toString());
		}

		return glossary;
	}

	/**
	 * Returns the glossary where glossaryTermText = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param glossaryTermText the glossary term text
	 * @return the matching glossary, or <code>null</code> if a matching glossary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByglossaryTermText(String glossaryTermText)
		throws SystemException {
		return fetchByglossaryTermText(glossaryTermText, true);
	}

	/**
	 * Returns the glossary where glossaryTermText = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param glossaryTermText the glossary term text
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching glossary, or <code>null</code> if a matching glossary could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByglossaryTermText(String glossaryTermText,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { glossaryTermText };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
					finderArgs, this);
		}

		if (result instanceof Glossary) {
			Glossary glossary = (Glossary)result;

			if (!Validator.equals(glossaryTermText,
						glossary.getGlossaryTermText())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_GLOSSARY_WHERE);

			boolean bindGlossaryTermText = false;

			if (glossaryTermText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_1);
			}
			else if (glossaryTermText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_3);
			}
			else {
				bindGlossaryTermText = true;

				query.append(_FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGlossaryTermText) {
					qPos.add(glossaryTermText.toLowerCase());
				}

				List<Glossary> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"GlossaryPersistenceImpl.fetchByglossaryTermText(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Glossary glossary = list.get(0);

					result = glossary;

					cacheResult(glossary);

					if ((glossary.getGlossaryTermText() == null) ||
							!glossary.getGlossaryTermText()
										 .equals(glossaryTermText)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
							finderArgs, glossary);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
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
			return (Glossary)result;
		}
	}

	/**
	 * Removes the glossary where glossaryTermText = &#63; from the database.
	 *
	 * @param glossaryTermText the glossary term text
	 * @return the glossary that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary removeByglossaryTermText(String glossaryTermText)
		throws NoSuchGlossaryException, SystemException {
		Glossary glossary = findByglossaryTermText(glossaryTermText);

		return remove(glossary);
	}

	/**
	 * Returns the number of glossaries where glossaryTermText = &#63;.
	 *
	 * @param glossaryTermText the glossary term text
	 * @return the number of matching glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByglossaryTermText(String glossaryTermText)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GLOSSARYTERMTEXT;

		Object[] finderArgs = new Object[] { glossaryTermText };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GLOSSARY_WHERE);

			boolean bindGlossaryTermText = false;

			if (glossaryTermText == null) {
				query.append(_FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_1);
			}
			else if (glossaryTermText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_3);
			}
			else {
				bindGlossaryTermText = true;

				query.append(_FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindGlossaryTermText) {
					qPos.add(glossaryTermText.toLowerCase());
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

	private static final String _FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_1 =
		"glossary.glossaryTermText IS NULL";
	private static final String _FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_2 =
		"lower(glossary.glossaryTermText) = ?";
	private static final String _FINDER_COLUMN_GLOSSARYTERMTEXT_GLOSSARYTERMTEXT_3 =
		"(glossary.glossaryTermText IS NULL OR glossary.glossaryTermText = '')";

	public GlossaryPersistenceImpl() {
		setModelClass(Glossary.class);
	}

	/**
	 * Caches the glossary in the entity cache if it is enabled.
	 *
	 * @param glossary the glossary
	 */
	@Override
	public void cacheResult(Glossary glossary) {
		EntityCacheUtil.putResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryImpl.class, glossary.getPrimaryKey(), glossary);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
			new Object[] { glossary.getGlossaryTermText() }, glossary);

		glossary.resetOriginalValues();
	}

	/**
	 * Caches the glossaries in the entity cache if it is enabled.
	 *
	 * @param glossaries the glossaries
	 */
	@Override
	public void cacheResult(List<Glossary> glossaries) {
		for (Glossary glossary : glossaries) {
			if (EntityCacheUtil.getResult(
						GlossaryModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryImpl.class, glossary.getPrimaryKey()) == null) {
				cacheResult(glossary);
			}
			else {
				glossary.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all glossaries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GlossaryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GlossaryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the glossary.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Glossary glossary) {
		EntityCacheUtil.removeResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryImpl.class, glossary.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(glossary);
	}

	@Override
	public void clearCache(List<Glossary> glossaries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Glossary glossary : glossaries) {
			EntityCacheUtil.removeResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryImpl.class, glossary.getPrimaryKey());

			clearUniqueFindersCache(glossary);
		}
	}

	protected void cacheUniqueFindersCache(Glossary glossary) {
		if (glossary.isNew()) {
			Object[] args = new Object[] { glossary.getGlossaryTermText() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOSSARYTERMTEXT,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
				args, glossary);
		}
		else {
			GlossaryModelImpl glossaryModelImpl = (GlossaryModelImpl)glossary;

			if ((glossaryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { glossary.getGlossaryTermText() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GLOSSARYTERMTEXT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
					args, glossary);
			}
		}
	}

	protected void clearUniqueFindersCache(Glossary glossary) {
		GlossaryModelImpl glossaryModelImpl = (GlossaryModelImpl)glossary;

		Object[] args = new Object[] { glossary.getGlossaryTermText() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYTERMTEXT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT, args);

		if ((glossaryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT.getColumnBitmask()) != 0) {
			args = new Object[] { glossaryModelImpl.getOriginalGlossaryTermText() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GLOSSARYTERMTEXT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GLOSSARYTERMTEXT,
				args);
		}
	}

	/**
	 * Creates a new glossary with the primary key. Does not add the glossary to the database.
	 *
	 * @param glossaryId the primary key for the new glossary
	 * @return the new glossary
	 */
	@Override
	public Glossary create(long glossaryId) {
		Glossary glossary = new GlossaryImpl();

		glossary.setNew(true);
		glossary.setPrimaryKey(glossaryId);

		return glossary;
	}

	/**
	 * Removes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param glossaryId the primary key of the glossary
	 * @return the glossary that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary remove(long glossaryId)
		throws NoSuchGlossaryException, SystemException {
		return remove((Serializable)glossaryId);
	}

	/**
	 * Removes the glossary with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the glossary
	 * @return the glossary that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary remove(Serializable primaryKey)
		throws NoSuchGlossaryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Glossary glossary = (Glossary)session.get(GlossaryImpl.class,
					primaryKey);

			if (glossary == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGlossaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(glossary);
		}
		catch (NoSuchGlossaryException nsee) {
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
	protected Glossary removeImpl(Glossary glossary) throws SystemException {
		glossary = toUnwrappedModel(glossary);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(glossary)) {
				glossary = (Glossary)session.get(GlossaryImpl.class,
						glossary.getPrimaryKeyObj());
			}

			if (glossary != null) {
				session.delete(glossary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (glossary != null) {
			clearCache(glossary);
		}

		return glossary;
	}

	@Override
	public Glossary updateImpl(
		com.ihg.brandstandards.db.model.Glossary glossary)
		throws SystemException {
		glossary = toUnwrappedModel(glossary);

		boolean isNew = glossary.isNew();

		Session session = null;

		try {
			session = openSession();

			if (glossary.isNew()) {
				session.save(glossary);

				glossary.setNew(false);
			}
			else {
				session.merge(glossary);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !GlossaryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
			GlossaryImpl.class, glossary.getPrimaryKey(), glossary);

		clearUniqueFindersCache(glossary);
		cacheUniqueFindersCache(glossary);

		return glossary;
	}

	protected Glossary toUnwrappedModel(Glossary glossary) {
		if (glossary instanceof GlossaryImpl) {
			return glossary;
		}

		GlossaryImpl glossaryImpl = new GlossaryImpl();

		glossaryImpl.setNew(glossary.isNew());
		glossaryImpl.setPrimaryKey(glossary.getPrimaryKey());

		glossaryImpl.setGlossaryId(glossary.getGlossaryId());
		glossaryImpl.setGlossaryTermText(glossary.getGlossaryTermText());
		glossaryImpl.setGlossaryTermDesc(glossary.getGlossaryTermDesc());
		glossaryImpl.setActiveInd(glossary.getActiveInd());
		glossaryImpl.setGlossaryOwner(glossary.getGlossaryOwner());
		glossaryImpl.setCreatorId(glossary.getCreatorId());
		glossaryImpl.setCreatedDate(glossary.getCreatedDate());
		glossaryImpl.setUpdatedBy(glossary.getUpdatedBy());
		glossaryImpl.setUpdatedDate(glossary.getUpdatedDate());

		return glossaryImpl;
	}

	/**
	 * Returns the glossary with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary
	 * @return the glossary
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGlossaryException, SystemException {
		Glossary glossary = fetchByPrimaryKey(primaryKey);

		if (glossary == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGlossaryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return glossary;
	}

	/**
	 * Returns the glossary with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGlossaryException} if it could not be found.
	 *
	 * @param glossaryId the primary key of the glossary
	 * @return the glossary
	 * @throws com.ihg.brandstandards.db.NoSuchGlossaryException if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary findByPrimaryKey(long glossaryId)
		throws NoSuchGlossaryException, SystemException {
		return findByPrimaryKey((Serializable)glossaryId);
	}

	/**
	 * Returns the glossary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the glossary
	 * @return the glossary, or <code>null</code> if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Glossary glossary = (Glossary)EntityCacheUtil.getResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
				GlossaryImpl.class, primaryKey);

		if (glossary == _nullGlossary) {
			return null;
		}

		if (glossary == null) {
			Session session = null;

			try {
				session = openSession();

				glossary = (Glossary)session.get(GlossaryImpl.class, primaryKey);

				if (glossary != null) {
					cacheResult(glossary);
				}
				else {
					EntityCacheUtil.putResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
						GlossaryImpl.class, primaryKey, _nullGlossary);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GlossaryModelImpl.ENTITY_CACHE_ENABLED,
					GlossaryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return glossary;
	}

	/**
	 * Returns the glossary with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param glossaryId the primary key of the glossary
	 * @return the glossary, or <code>null</code> if a glossary with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Glossary fetchByPrimaryKey(long glossaryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)glossaryId);
	}

	/**
	 * Returns all the glossaries.
	 *
	 * @return the glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the glossaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossaries
	 * @param end the upper bound of the range of glossaries (not inclusive)
	 * @return the range of glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the glossaries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GlossaryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of glossaries
	 * @param end the upper bound of the range of glossaries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of glossaries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Glossary> findAll(int start, int end,
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

		List<Glossary> list = (List<Glossary>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GLOSSARY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GLOSSARY;

				if (pagination) {
					sql = sql.concat(GlossaryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Glossary>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Glossary>(list);
				}
				else {
					list = (List<Glossary>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the glossaries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Glossary glossary : findAll()) {
			remove(glossary);
		}
	}

	/**
	 * Returns the number of glossaries.
	 *
	 * @return the number of glossaries
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

				Query q = session.createQuery(_SQL_COUNT_GLOSSARY);

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
	 * Initializes the glossary persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.Glossary")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Glossary>> listenersList = new ArrayList<ModelListener<Glossary>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Glossary>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GlossaryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GLOSSARY = "SELECT glossary FROM Glossary glossary";
	private static final String _SQL_SELECT_GLOSSARY_WHERE = "SELECT glossary FROM Glossary glossary WHERE ";
	private static final String _SQL_COUNT_GLOSSARY = "SELECT COUNT(glossary) FROM Glossary glossary";
	private static final String _SQL_COUNT_GLOSSARY_WHERE = "SELECT COUNT(glossary) FROM Glossary glossary WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "glossary.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Glossary exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Glossary exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GlossaryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"glossaryId", "glossaryTermText", "glossaryTermDesc",
				"activeInd", "glossaryOwner", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static Glossary _nullGlossary = new GlossaryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Glossary> toCacheModel() {
				return _nullGlossaryCacheModel;
			}
		};

	private static CacheModel<Glossary> _nullGlossaryCacheModel = new CacheModel<Glossary>() {
			@Override
			public Glossary toEntityModel() {
				return _nullGlossary;
			}
		};
}