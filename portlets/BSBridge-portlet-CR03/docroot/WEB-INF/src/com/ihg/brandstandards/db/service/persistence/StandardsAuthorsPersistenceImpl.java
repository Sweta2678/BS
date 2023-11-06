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

import com.ihg.brandstandards.db.NoSuchStandardsAuthorsException;
import com.ihg.brandstandards.db.model.StandardsAuthors;
import com.ihg.brandstandards.db.model.impl.StandardsAuthorsImpl;
import com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl;

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
 * The persistence implementation for the standards authors service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see StandardsAuthorsPersistence
 * @see StandardsAuthorsUtil
 * @generated
 */
public class StandardsAuthorsPersistenceImpl extends BasePersistenceImpl<StandardsAuthors>
	implements StandardsAuthorsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StandardsAuthorsUtil} to access the standards authors persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StandardsAuthorsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStdId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdId",
			new String[] { Long.class.getName() },
			StandardsAuthorsModelImpl.STDID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDID = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the standards authorses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByStdId(long stdId)
		throws SystemException {
		return findByStdId(stdId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards authorses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @return the range of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByStdId(long stdId, int start, int end)
		throws SystemException {
		return findByStdId(stdId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards authorses where stdId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByStdId(long stdId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] { stdId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDID;
			finderArgs = new Object[] { stdId, start, end, orderByComparator };
		}

		List<StandardsAuthors> list = (List<StandardsAuthors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsAuthors standardsAuthors : list) {
				if ((stdId != standardsAuthors.getStdId())) {
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

			query.append(_SQL_SELECT_STANDARDSAUTHORS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsAuthorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (!pagination) {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsAuthors>(list);
				}
				else {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
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
	 * Returns the first standards authors in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByStdId_First(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = fetchByStdId_First(stdId,
				orderByComparator);

		if (standardsAuthors != null) {
			return standardsAuthors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsAuthorsException(msg.toString());
	}

	/**
	 * Returns the first standards authors in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards authors, or <code>null</code> if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByStdId_First(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		List<StandardsAuthors> list = findByStdId(stdId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards authors in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByStdId_Last(long stdId,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = fetchByStdId_Last(stdId,
				orderByComparator);

		if (standardsAuthors != null) {
			return standardsAuthors;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsAuthorsException(msg.toString());
	}

	/**
	 * Returns the last standards authors in the ordered set where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards authors, or <code>null</code> if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByStdId_Last(long stdId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStdId(stdId);

		if (count == 0) {
			return null;
		}

		List<StandardsAuthors> list = findByStdId(stdId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards authorses before and after the current standards authors in the ordered set where stdId = &#63;.
	 *
	 * @param stdAuthorId the primary key of the current standards authors
	 * @param stdId the std ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors[] findByStdId_PrevAndNext(long stdAuthorId,
		long stdId, OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = findByPrimaryKey(stdAuthorId);

		Session session = null;

		try {
			session = openSession();

			StandardsAuthors[] array = new StandardsAuthorsImpl[3];

			array[0] = getByStdId_PrevAndNext(session, standardsAuthors, stdId,
					orderByComparator, true);

			array[1] = standardsAuthors;

			array[2] = getByStdId_PrevAndNext(session, standardsAuthors, stdId,
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

	protected StandardsAuthors getByStdId_PrevAndNext(Session session,
		StandardsAuthors standardsAuthors, long stdId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSAUTHORS_WHERE);

		query.append(_FINDER_COLUMN_STDID_STDID_2);

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
			query.append(StandardsAuthorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsAuthors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsAuthors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards authorses where stdId = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdId(long stdId) throws SystemException {
		for (StandardsAuthors standardsAuthors : findByStdId(stdId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsAuthors);
		}
	}

	/**
	 * Returns the number of standards authorses where stdId = &#63;.
	 *
	 * @param stdId the std ID
	 * @return the number of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdId(long stdId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDID;

		Object[] finderArgs = new Object[] { stdId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STANDARDSAUTHORS_WHERE);

			query.append(_FINDER_COLUMN_STDID_STDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_STDID_STDID_2 = "standardsAuthors.stdId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STDAUTHOR =
		new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStdAuthor",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDAUTHOR =
		new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStdAuthor",
			new String[] { String.class.getName(), String.class.getName() },
			StandardsAuthorsModelImpl.AUTHORNAME_COLUMN_BITMASK |
			StandardsAuthorsModelImpl.ISPRIMARY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STDAUTHOR = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStdAuthor",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the standards authorses where authorName = &#63; and isPrimary = &#63;.
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @return the matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByStdAuthor(String authorName,
		String isPrimary) throws SystemException {
		return findByStdAuthor(authorName, isPrimary, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards authorses where authorName = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @return the range of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByStdAuthor(String authorName,
		String isPrimary, int start, int end) throws SystemException {
		return findByStdAuthor(authorName, isPrimary, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards authorses where authorName = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByStdAuthor(String authorName,
		String isPrimary, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDAUTHOR;
			finderArgs = new Object[] { authorName, isPrimary };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STDAUTHOR;
			finderArgs = new Object[] {
					authorName, isPrimary,
					
					start, end, orderByComparator
				};
		}

		List<StandardsAuthors> list = (List<StandardsAuthors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsAuthors standardsAuthors : list) {
				if (!Validator.equals(authorName,
							standardsAuthors.getAuthorName()) ||
						!Validator.equals(isPrimary,
							standardsAuthors.getIsPrimary())) {
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

			query.append(_SQL_SELECT_STANDARDSAUTHORS_WHERE);

			boolean bindAuthorName = false;

			if (authorName == null) {
				query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_1);
			}
			else if (authorName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_3);
			}
			else {
				bindAuthorName = true;

				query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_2);
			}

			boolean bindIsPrimary = false;

			if (isPrimary == null) {
				query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_1);
			}
			else if (isPrimary.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_3);
			}
			else {
				bindIsPrimary = true;

				query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsAuthorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthorName) {
					qPos.add(authorName);
				}

				if (bindIsPrimary) {
					qPos.add(isPrimary);
				}

				if (!pagination) {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsAuthors>(list);
				}
				else {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
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
	 * Returns the first standards authors in the ordered set where authorName = &#63; and isPrimary = &#63;.
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByStdAuthor_First(String authorName,
		String isPrimary, OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = fetchByStdAuthor_First(authorName,
				isPrimary, orderByComparator);

		if (standardsAuthors != null) {
			return standardsAuthors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorName=");
		msg.append(authorName);

		msg.append(", isPrimary=");
		msg.append(isPrimary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsAuthorsException(msg.toString());
	}

	/**
	 * Returns the first standards authors in the ordered set where authorName = &#63; and isPrimary = &#63;.
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards authors, or <code>null</code> if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByStdAuthor_First(String authorName,
		String isPrimary, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsAuthors> list = findByStdAuthor(authorName, isPrimary, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards authors in the ordered set where authorName = &#63; and isPrimary = &#63;.
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByStdAuthor_Last(String authorName,
		String isPrimary, OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = fetchByStdAuthor_Last(authorName,
				isPrimary, orderByComparator);

		if (standardsAuthors != null) {
			return standardsAuthors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("authorName=");
		msg.append(authorName);

		msg.append(", isPrimary=");
		msg.append(isPrimary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsAuthorsException(msg.toString());
	}

	/**
	 * Returns the last standards authors in the ordered set where authorName = &#63; and isPrimary = &#63;.
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards authors, or <code>null</code> if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByStdAuthor_Last(String authorName,
		String isPrimary, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByStdAuthor(authorName, isPrimary);

		if (count == 0) {
			return null;
		}

		List<StandardsAuthors> list = findByStdAuthor(authorName, isPrimary,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards authorses before and after the current standards authors in the ordered set where authorName = &#63; and isPrimary = &#63;.
	 *
	 * @param stdAuthorId the primary key of the current standards authors
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors[] findByStdAuthor_PrevAndNext(long stdAuthorId,
		String authorName, String isPrimary, OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = findByPrimaryKey(stdAuthorId);

		Session session = null;

		try {
			session = openSession();

			StandardsAuthors[] array = new StandardsAuthorsImpl[3];

			array[0] = getByStdAuthor_PrevAndNext(session, standardsAuthors,
					authorName, isPrimary, orderByComparator, true);

			array[1] = standardsAuthors;

			array[2] = getByStdAuthor_PrevAndNext(session, standardsAuthors,
					authorName, isPrimary, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsAuthors getByStdAuthor_PrevAndNext(Session session,
		StandardsAuthors standardsAuthors, String authorName, String isPrimary,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSAUTHORS_WHERE);

		boolean bindAuthorName = false;

		if (authorName == null) {
			query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_1);
		}
		else if (authorName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_3);
		}
		else {
			bindAuthorName = true;

			query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_2);
		}

		boolean bindIsPrimary = false;

		if (isPrimary == null) {
			query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_1);
		}
		else if (isPrimary.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_3);
		}
		else {
			bindIsPrimary = true;

			query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_2);
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
			query.append(StandardsAuthorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAuthorName) {
			qPos.add(authorName);
		}

		if (bindIsPrimary) {
			qPos.add(isPrimary);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsAuthors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsAuthors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards authorses where authorName = &#63; and isPrimary = &#63; from the database.
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStdAuthor(String authorName, String isPrimary)
		throws SystemException {
		for (StandardsAuthors standardsAuthors : findByStdAuthor(authorName,
				isPrimary, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsAuthors);
		}
	}

	/**
	 * Returns the number of standards authorses where authorName = &#63; and isPrimary = &#63;.
	 *
	 * @param authorName the author name
	 * @param isPrimary the is primary
	 * @return the number of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStdAuthor(String authorName, String isPrimary)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STDAUTHOR;

		Object[] finderArgs = new Object[] { authorName, isPrimary };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSAUTHORS_WHERE);

			boolean bindAuthorName = false;

			if (authorName == null) {
				query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_1);
			}
			else if (authorName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_3);
			}
			else {
				bindAuthorName = true;

				query.append(_FINDER_COLUMN_STDAUTHOR_AUTHORNAME_2);
			}

			boolean bindIsPrimary = false;

			if (isPrimary == null) {
				query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_1);
			}
			else if (isPrimary.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_3);
			}
			else {
				bindIsPrimary = true;

				query.append(_FINDER_COLUMN_STDAUTHOR_ISPRIMARY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAuthorName) {
					qPos.add(authorName);
				}

				if (bindIsPrimary) {
					qPos.add(isPrimary);
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

	private static final String _FINDER_COLUMN_STDAUTHOR_AUTHORNAME_1 = "standardsAuthors.authorName IS NULL AND ";
	private static final String _FINDER_COLUMN_STDAUTHOR_AUTHORNAME_2 = "standardsAuthors.authorName = ? AND ";
	private static final String _FINDER_COLUMN_STDAUTHOR_AUTHORNAME_3 = "(standardsAuthors.authorName IS NULL OR standardsAuthors.authorName = '') AND ";
	private static final String _FINDER_COLUMN_STDAUTHOR_ISPRIMARY_1 = "standardsAuthors.isPrimary IS NULL";
	private static final String _FINDER_COLUMN_STDAUTHOR_ISPRIMARY_2 = "standardsAuthors.isPrimary = ?";
	private static final String _FINDER_COLUMN_STDAUTHOR_ISPRIMARY_3 = "(standardsAuthors.isPrimary IS NULL OR standardsAuthors.isPrimary = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORSTDIDPRIMARY =
		new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByAuthorStdIdPrimary",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORSTDIDPRIMARY =
		new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED,
			StandardsAuthorsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByAuthorStdIdPrimary",
			new String[] { Long.class.getName(), String.class.getName() },
			StandardsAuthorsModelImpl.STDID_COLUMN_BITMASK |
			StandardsAuthorsModelImpl.ISPRIMARY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORSTDIDPRIMARY = new FinderPath(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAuthorStdIdPrimary",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the standards authorses where stdId = &#63; and isPrimary = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @return the matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByAuthorStdIdPrimary(long stdId,
		String isPrimary) throws SystemException {
		return findByAuthorStdIdPrimary(stdId, isPrimary, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards authorses where stdId = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @return the range of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByAuthorStdIdPrimary(long stdId,
		String isPrimary, int start, int end) throws SystemException {
		return findByAuthorStdIdPrimary(stdId, isPrimary, start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards authorses where stdId = &#63; and isPrimary = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findByAuthorStdIdPrimary(long stdId,
		String isPrimary, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORSTDIDPRIMARY;
			finderArgs = new Object[] { stdId, isPrimary };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORSTDIDPRIMARY;
			finderArgs = new Object[] {
					stdId, isPrimary,
					
					start, end, orderByComparator
				};
		}

		List<StandardsAuthors> list = (List<StandardsAuthors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (StandardsAuthors standardsAuthors : list) {
				if ((stdId != standardsAuthors.getStdId()) ||
						!Validator.equals(isPrimary,
							standardsAuthors.getIsPrimary())) {
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

			query.append(_SQL_SELECT_STANDARDSAUTHORS_WHERE);

			query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_STDID_2);

			boolean bindIsPrimary = false;

			if (isPrimary == null) {
				query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_1);
			}
			else if (isPrimary.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_3);
			}
			else {
				bindIsPrimary = true;

				query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StandardsAuthorsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindIsPrimary) {
					qPos.add(isPrimary);
				}

				if (!pagination) {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsAuthors>(list);
				}
				else {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
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
	 * Returns the first standards authors in the ordered set where stdId = &#63; and isPrimary = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByAuthorStdIdPrimary_First(long stdId,
		String isPrimary, OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = fetchByAuthorStdIdPrimary_First(stdId,
				isPrimary, orderByComparator);

		if (standardsAuthors != null) {
			return standardsAuthors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", isPrimary=");
		msg.append(isPrimary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsAuthorsException(msg.toString());
	}

	/**
	 * Returns the first standards authors in the ordered set where stdId = &#63; and isPrimary = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching standards authors, or <code>null</code> if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByAuthorStdIdPrimary_First(long stdId,
		String isPrimary, OrderByComparator orderByComparator)
		throws SystemException {
		List<StandardsAuthors> list = findByAuthorStdIdPrimary(stdId,
				isPrimary, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last standards authors in the ordered set where stdId = &#63; and isPrimary = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByAuthorStdIdPrimary_Last(long stdId,
		String isPrimary, OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = fetchByAuthorStdIdPrimary_Last(stdId,
				isPrimary, orderByComparator);

		if (standardsAuthors != null) {
			return standardsAuthors;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stdId=");
		msg.append(stdId);

		msg.append(", isPrimary=");
		msg.append(isPrimary);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStandardsAuthorsException(msg.toString());
	}

	/**
	 * Returns the last standards authors in the ordered set where stdId = &#63; and isPrimary = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching standards authors, or <code>null</code> if a matching standards authors could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByAuthorStdIdPrimary_Last(long stdId,
		String isPrimary, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByAuthorStdIdPrimary(stdId, isPrimary);

		if (count == 0) {
			return null;
		}

		List<StandardsAuthors> list = findByAuthorStdIdPrimary(stdId,
				isPrimary, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the standards authorses before and after the current standards authors in the ordered set where stdId = &#63; and isPrimary = &#63;.
	 *
	 * @param stdAuthorId the primary key of the current standards authors
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors[] findByAuthorStdIdPrimary_PrevAndNext(
		long stdAuthorId, long stdId, String isPrimary,
		OrderByComparator orderByComparator)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = findByPrimaryKey(stdAuthorId);

		Session session = null;

		try {
			session = openSession();

			StandardsAuthors[] array = new StandardsAuthorsImpl[3];

			array[0] = getByAuthorStdIdPrimary_PrevAndNext(session,
					standardsAuthors, stdId, isPrimary, orderByComparator, true);

			array[1] = standardsAuthors;

			array[2] = getByAuthorStdIdPrimary_PrevAndNext(session,
					standardsAuthors, stdId, isPrimary, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StandardsAuthors getByAuthorStdIdPrimary_PrevAndNext(
		Session session, StandardsAuthors standardsAuthors, long stdId,
		String isPrimary, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STANDARDSAUTHORS_WHERE);

		query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_STDID_2);

		boolean bindIsPrimary = false;

		if (isPrimary == null) {
			query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_1);
		}
		else if (isPrimary.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_3);
		}
		else {
			bindIsPrimary = true;

			query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_2);
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
			query.append(StandardsAuthorsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(stdId);

		if (bindIsPrimary) {
			qPos.add(isPrimary);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(standardsAuthors);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StandardsAuthors> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the standards authorses where stdId = &#63; and isPrimary = &#63; from the database.
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByAuthorStdIdPrimary(long stdId, String isPrimary)
		throws SystemException {
		for (StandardsAuthors standardsAuthors : findByAuthorStdIdPrimary(
				stdId, isPrimary, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(standardsAuthors);
		}
	}

	/**
	 * Returns the number of standards authorses where stdId = &#63; and isPrimary = &#63;.
	 *
	 * @param stdId the std ID
	 * @param isPrimary the is primary
	 * @return the number of matching standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByAuthorStdIdPrimary(long stdId, String isPrimary)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORSTDIDPRIMARY;

		Object[] finderArgs = new Object[] { stdId, isPrimary };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STANDARDSAUTHORS_WHERE);

			query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_STDID_2);

			boolean bindIsPrimary = false;

			if (isPrimary == null) {
				query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_1);
			}
			else if (isPrimary.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_3);
			}
			else {
				bindIsPrimary = true;

				query.append(_FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(stdId);

				if (bindIsPrimary) {
					qPos.add(isPrimary);
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

	private static final String _FINDER_COLUMN_AUTHORSTDIDPRIMARY_STDID_2 = "standardsAuthors.stdId = ? AND ";
	private static final String _FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_1 = "standardsAuthors.isPrimary IS NULL";
	private static final String _FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_2 = "standardsAuthors.isPrimary = ?";
	private static final String _FINDER_COLUMN_AUTHORSTDIDPRIMARY_ISPRIMARY_3 = "(standardsAuthors.isPrimary IS NULL OR standardsAuthors.isPrimary = '')";

	public StandardsAuthorsPersistenceImpl() {
		setModelClass(StandardsAuthors.class);
	}

	/**
	 * Caches the standards authors in the entity cache if it is enabled.
	 *
	 * @param standardsAuthors the standards authors
	 */
	@Override
	public void cacheResult(StandardsAuthors standardsAuthors) {
		EntityCacheUtil.putResult(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsImpl.class, standardsAuthors.getPrimaryKey(),
			standardsAuthors);

		standardsAuthors.resetOriginalValues();
	}

	/**
	 * Caches the standards authorses in the entity cache if it is enabled.
	 *
	 * @param standardsAuthorses the standards authorses
	 */
	@Override
	public void cacheResult(List<StandardsAuthors> standardsAuthorses) {
		for (StandardsAuthors standardsAuthors : standardsAuthorses) {
			if (EntityCacheUtil.getResult(
						StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
						StandardsAuthorsImpl.class,
						standardsAuthors.getPrimaryKey()) == null) {
				cacheResult(standardsAuthors);
			}
			else {
				standardsAuthors.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all standards authorses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StandardsAuthorsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StandardsAuthorsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the standards authors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StandardsAuthors standardsAuthors) {
		EntityCacheUtil.removeResult(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsImpl.class, standardsAuthors.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StandardsAuthors> standardsAuthorses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StandardsAuthors standardsAuthors : standardsAuthorses) {
			EntityCacheUtil.removeResult(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
				StandardsAuthorsImpl.class, standardsAuthors.getPrimaryKey());
		}
	}

	/**
	 * Creates a new standards authors with the primary key. Does not add the standards authors to the database.
	 *
	 * @param stdAuthorId the primary key for the new standards authors
	 * @return the new standards authors
	 */
	@Override
	public StandardsAuthors create(long stdAuthorId) {
		StandardsAuthors standardsAuthors = new StandardsAuthorsImpl();

		standardsAuthors.setNew(true);
		standardsAuthors.setPrimaryKey(stdAuthorId);

		return standardsAuthors;
	}

	/**
	 * Removes the standards authors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stdAuthorId the primary key of the standards authors
	 * @return the standards authors that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors remove(long stdAuthorId)
		throws NoSuchStandardsAuthorsException, SystemException {
		return remove((Serializable)stdAuthorId);
	}

	/**
	 * Removes the standards authors with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the standards authors
	 * @return the standards authors that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors remove(Serializable primaryKey)
		throws NoSuchStandardsAuthorsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			StandardsAuthors standardsAuthors = (StandardsAuthors)session.get(StandardsAuthorsImpl.class,
					primaryKey);

			if (standardsAuthors == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStandardsAuthorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(standardsAuthors);
		}
		catch (NoSuchStandardsAuthorsException nsee) {
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
	protected StandardsAuthors removeImpl(StandardsAuthors standardsAuthors)
		throws SystemException {
		standardsAuthors = toUnwrappedModel(standardsAuthors);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(standardsAuthors)) {
				standardsAuthors = (StandardsAuthors)session.get(StandardsAuthorsImpl.class,
						standardsAuthors.getPrimaryKeyObj());
			}

			if (standardsAuthors != null) {
				session.delete(standardsAuthors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (standardsAuthors != null) {
			clearCache(standardsAuthors);
		}

		return standardsAuthors;
	}

	@Override
	public StandardsAuthors updateImpl(
		com.ihg.brandstandards.db.model.StandardsAuthors standardsAuthors)
		throws SystemException {
		standardsAuthors = toUnwrappedModel(standardsAuthors);

		boolean isNew = standardsAuthors.isNew();

		StandardsAuthorsModelImpl standardsAuthorsModelImpl = (StandardsAuthorsModelImpl)standardsAuthors;

		Session session = null;

		try {
			session = openSession();

			if (standardsAuthors.isNew()) {
				session.save(standardsAuthors);

				standardsAuthors.setNew(false);
			}
			else {
				session.merge(standardsAuthors);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StandardsAuthorsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((standardsAuthorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsAuthorsModelImpl.getOriginalStdId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);

				args = new Object[] { standardsAuthorsModelImpl.getStdId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDID,
					args);
			}

			if ((standardsAuthorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDAUTHOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsAuthorsModelImpl.getOriginalAuthorName(),
						standardsAuthorsModelImpl.getOriginalIsPrimary()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDAUTHOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDAUTHOR,
					args);

				args = new Object[] {
						standardsAuthorsModelImpl.getAuthorName(),
						standardsAuthorsModelImpl.getIsPrimary()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STDAUTHOR,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STDAUTHOR,
					args);
			}

			if ((standardsAuthorsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORSTDIDPRIMARY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						standardsAuthorsModelImpl.getOriginalStdId(),
						standardsAuthorsModelImpl.getOriginalIsPrimary()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORSTDIDPRIMARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORSTDIDPRIMARY,
					args);

				args = new Object[] {
						standardsAuthorsModelImpl.getStdId(),
						standardsAuthorsModelImpl.getIsPrimary()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORSTDIDPRIMARY,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORSTDIDPRIMARY,
					args);
			}
		}

		EntityCacheUtil.putResult(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
			StandardsAuthorsImpl.class, standardsAuthors.getPrimaryKey(),
			standardsAuthors);

		return standardsAuthors;
	}

	protected StandardsAuthors toUnwrappedModel(
		StandardsAuthors standardsAuthors) {
		if (standardsAuthors instanceof StandardsAuthorsImpl) {
			return standardsAuthors;
		}

		StandardsAuthorsImpl standardsAuthorsImpl = new StandardsAuthorsImpl();

		standardsAuthorsImpl.setNew(standardsAuthors.isNew());
		standardsAuthorsImpl.setPrimaryKey(standardsAuthors.getPrimaryKey());

		standardsAuthorsImpl.setStdAuthorId(standardsAuthors.getStdAuthorId());
		standardsAuthorsImpl.setStdId(standardsAuthors.getStdId());
		standardsAuthorsImpl.setAuthorName(standardsAuthors.getAuthorName());
		standardsAuthorsImpl.setIsPrimary(standardsAuthors.getIsPrimary());
		standardsAuthorsImpl.setCreatorId(standardsAuthors.getCreatorId());
		standardsAuthorsImpl.setCreatedDate(standardsAuthors.getCreatedDate());
		standardsAuthorsImpl.setUpdatedBy(standardsAuthors.getUpdatedBy());
		standardsAuthorsImpl.setUpdatedDate(standardsAuthors.getUpdatedDate());

		return standardsAuthorsImpl;
	}

	/**
	 * Returns the standards authors with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards authors
	 * @return the standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStandardsAuthorsException, SystemException {
		StandardsAuthors standardsAuthors = fetchByPrimaryKey(primaryKey);

		if (standardsAuthors == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStandardsAuthorsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return standardsAuthors;
	}

	/**
	 * Returns the standards authors with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchStandardsAuthorsException} if it could not be found.
	 *
	 * @param stdAuthorId the primary key of the standards authors
	 * @return the standards authors
	 * @throws com.ihg.brandstandards.db.NoSuchStandardsAuthorsException if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors findByPrimaryKey(long stdAuthorId)
		throws NoSuchStandardsAuthorsException, SystemException {
		return findByPrimaryKey((Serializable)stdAuthorId);
	}

	/**
	 * Returns the standards authors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the standards authors
	 * @return the standards authors, or <code>null</code> if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		StandardsAuthors standardsAuthors = (StandardsAuthors)EntityCacheUtil.getResult(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
				StandardsAuthorsImpl.class, primaryKey);

		if (standardsAuthors == _nullStandardsAuthors) {
			return null;
		}

		if (standardsAuthors == null) {
			Session session = null;

			try {
				session = openSession();

				standardsAuthors = (StandardsAuthors)session.get(StandardsAuthorsImpl.class,
						primaryKey);

				if (standardsAuthors != null) {
					cacheResult(standardsAuthors);
				}
				else {
					EntityCacheUtil.putResult(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
						StandardsAuthorsImpl.class, primaryKey,
						_nullStandardsAuthors);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StandardsAuthorsModelImpl.ENTITY_CACHE_ENABLED,
					StandardsAuthorsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return standardsAuthors;
	}

	/**
	 * Returns the standards authors with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stdAuthorId the primary key of the standards authors
	 * @return the standards authors, or <code>null</code> if a standards authors with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public StandardsAuthors fetchByPrimaryKey(long stdAuthorId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)stdAuthorId);
	}

	/**
	 * Returns all the standards authorses.
	 *
	 * @return the standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the standards authorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @return the range of standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the standards authorses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of standards authorses
	 * @param end the upper bound of the range of standards authorses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of standards authorses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<StandardsAuthors> findAll(int start, int end,
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

		List<StandardsAuthors> list = (List<StandardsAuthors>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STANDARDSAUTHORS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STANDARDSAUTHORS;

				if (pagination) {
					sql = sql.concat(StandardsAuthorsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<StandardsAuthors>(list);
				}
				else {
					list = (List<StandardsAuthors>)QueryUtil.list(q,
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
	 * Removes all the standards authorses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (StandardsAuthors standardsAuthors : findAll()) {
			remove(standardsAuthors);
		}
	}

	/**
	 * Returns the number of standards authorses.
	 *
	 * @return the number of standards authorses
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

				Query q = session.createQuery(_SQL_COUNT_STANDARDSAUTHORS);

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
	 * Initializes the standards authors persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.StandardsAuthors")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<StandardsAuthors>> listenersList = new ArrayList<ModelListener<StandardsAuthors>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<StandardsAuthors>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(StandardsAuthorsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STANDARDSAUTHORS = "SELECT standardsAuthors FROM StandardsAuthors standardsAuthors";
	private static final String _SQL_SELECT_STANDARDSAUTHORS_WHERE = "SELECT standardsAuthors FROM StandardsAuthors standardsAuthors WHERE ";
	private static final String _SQL_COUNT_STANDARDSAUTHORS = "SELECT COUNT(standardsAuthors) FROM StandardsAuthors standardsAuthors";
	private static final String _SQL_COUNT_STANDARDSAUTHORS_WHERE = "SELECT COUNT(standardsAuthors) FROM StandardsAuthors standardsAuthors WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "standardsAuthors.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StandardsAuthors exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StandardsAuthors exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StandardsAuthorsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdAuthorId", "stdId", "authorName", "isPrimary", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static StandardsAuthors _nullStandardsAuthors = new StandardsAuthorsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<StandardsAuthors> toCacheModel() {
				return _nullStandardsAuthorsCacheModel;
			}
		};

	private static CacheModel<StandardsAuthors> _nullStandardsAuthorsCacheModel = new CacheModel<StandardsAuthors>() {
			@Override
			public StandardsAuthors toEntityModel() {
				return _nullStandardsAuthors;
			}
		};
}