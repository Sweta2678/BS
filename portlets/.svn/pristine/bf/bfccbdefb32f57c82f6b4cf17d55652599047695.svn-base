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

import com.ihg.brandstandards.db.NoSuchPublishedPdfListException;
import com.ihg.brandstandards.db.model.PublishedPdfList;
import com.ihg.brandstandards.db.model.impl.PublishedPdfListImpl;
import com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl;

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
 * The persistence implementation for the published pdf list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishedPdfListPersistence
 * @see PublishedPdfListUtil
 * @generated
 */
public class PublishedPdfListPersistenceImpl extends BasePersistenceImpl<PublishedPdfList>
	implements PublishedPdfListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishedPdfListUtil} to access the published pdf list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishedPdfListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PDFID = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByPdfId", new String[] { Long.class.getName() },
			PublishedPdfListModelImpl.PDFID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PDFID = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPdfId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the published pdf list where pdfId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishedPdfListException} if it could not be found.
	 *
	 * @param pdfId the pdf ID
	 * @return the matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfId(long pdfId)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfId(pdfId);

		if (publishedPdfList == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("pdfId=");
			msg.append(pdfId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishedPdfListException(msg.toString());
		}

		return publishedPdfList;
	}

	/**
	 * Returns the published pdf list where pdfId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param pdfId the pdf ID
	 * @return the matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfId(long pdfId) throws SystemException {
		return fetchByPdfId(pdfId, true);
	}

	/**
	 * Returns the published pdf list where pdfId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param pdfId the pdf ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfId(long pdfId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { pdfId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PDFID,
					finderArgs, this);
		}

		if (result instanceof PublishedPdfList) {
			PublishedPdfList publishedPdfList = (PublishedPdfList)result;

			if ((pdfId != publishedPdfList.getPdfId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PDFID_PDFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pdfId);

				List<PublishedPdfList> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PDFID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishedPdfListPersistenceImpl.fetchByPdfId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishedPdfList publishedPdfList = list.get(0);

					result = publishedPdfList;

					cacheResult(publishedPdfList);

					if ((publishedPdfList.getPdfId() != pdfId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PDFID,
							finderArgs, publishedPdfList);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PDFID,
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
			return (PublishedPdfList)result;
		}
	}

	/**
	 * Removes the published pdf list where pdfId = &#63; from the database.
	 *
	 * @param pdfId the pdf ID
	 * @return the published pdf list that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList removeByPdfId(long pdfId)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPdfId(pdfId);

		return remove(publishedPdfList);
	}

	/**
	 * Returns the number of published pdf lists where pdfId = &#63;.
	 *
	 * @param pdfId the pdf ID
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPdfId(long pdfId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PDFID;

		Object[] finderArgs = new Object[] { pdfId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PDFID_PDFID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(pdfId);

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

	private static final String _FINDER_COLUMN_PDFID_PDFID_2 = "publishedPdfList.pdfId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublishId",
			new String[] { Long.class.getName() },
			PublishedPdfListModelImpl.PUBLISHID_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHID = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublishId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the published pdf lists where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishId(long publishId)
		throws SystemException {
		return findByPublishId(publishId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the published pdf lists where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishId(long publishId, int start,
		int end) throws SystemException {
		return findByPublishId(publishId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where publishId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishId(long publishId, int start,
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

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if ((publishId != publishedPdfList.getPublishId())) {
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

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHID_PUBLISHID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPublishId_First(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPublishId_First(publishId,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPublishId_First(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishedPdfList> list = findByPublishId(publishId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPublishId_Last(long publishId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPublishId_Last(publishId,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPublishId_Last(long publishId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishId(publishId);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPublishId(publishId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param publishId the publish ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPublishId_PrevAndNext(long pdfId,
		long publishId, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPublishId_PrevAndNext(session, publishedPdfList,
					publishId, orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPublishId_PrevAndNext(session, publishedPdfList,
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

	protected PublishedPdfList getByPublishId_PrevAndNext(Session session,
		PublishedPdfList publishedPdfList, long publishId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where publishId = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishId(long publishId) throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPublishId(publishId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where publishId = &#63;.
	 *
	 * @param publishId the publish ID
	 * @return the number of matching published pdf lists
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

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

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

	private static final String _FINDER_COLUMN_PUBLISHID_PUBLISHID_2 = "publishedPdfList.publishId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFCHAINCODE =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPdfChainCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCHAINCODE =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPdfChainCode",
			new String[] { String.class.getName() },
			PublishedPdfListModelImpl.PDFCHAINCODE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PDFCHAINCODE = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPdfChainCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the published pdf lists where pdfChainCode = &#63;.
	 *
	 * @param pdfChainCode the pdf chain code
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfChainCode(String pdfChainCode)
		throws SystemException {
		return findByPdfChainCode(pdfChainCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where pdfChainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfChainCode the pdf chain code
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfChainCode(String pdfChainCode,
		int start, int end) throws SystemException {
		return findByPdfChainCode(pdfChainCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where pdfChainCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfChainCode the pdf chain code
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfChainCode(String pdfChainCode,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCHAINCODE;
			finderArgs = new Object[] { pdfChainCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFCHAINCODE;
			finderArgs = new Object[] {
					pdfChainCode,
					
					start, end, orderByComparator
				};
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if (!Validator.equals(pdfChainCode,
							publishedPdfList.getPdfChainCode())) {
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

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfChainCode = false;

			if (pdfChainCode == null) {
				query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_1);
			}
			else if (pdfChainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_3);
			}
			else {
				bindPdfChainCode = true;

				query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfChainCode) {
					qPos.add(pdfChainCode);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where pdfChainCode = &#63;.
	 *
	 * @param pdfChainCode the pdf chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfChainCode_First(String pdfChainCode,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfChainCode_First(pdfChainCode,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfChainCode=");
		msg.append(pdfChainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where pdfChainCode = &#63;.
	 *
	 * @param pdfChainCode the pdf chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfChainCode_First(String pdfChainCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishedPdfList> list = findByPdfChainCode(pdfChainCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfChainCode = &#63;.
	 *
	 * @param pdfChainCode the pdf chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfChainCode_Last(String pdfChainCode,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfChainCode_Last(pdfChainCode,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfChainCode=");
		msg.append(pdfChainCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfChainCode = &#63;.
	 *
	 * @param pdfChainCode the pdf chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfChainCode_Last(String pdfChainCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPdfChainCode(pdfChainCode);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPdfChainCode(pdfChainCode,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfChainCode = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param pdfChainCode the pdf chain code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPdfChainCode_PrevAndNext(long pdfId,
		String pdfChainCode, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPdfChainCode_PrevAndNext(session, publishedPdfList,
					pdfChainCode, orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPdfChainCode_PrevAndNext(session, publishedPdfList,
					pdfChainCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishedPdfList getByPdfChainCode_PrevAndNext(Session session,
		PublishedPdfList publishedPdfList, String pdfChainCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		boolean bindPdfChainCode = false;

		if (pdfChainCode == null) {
			query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_1);
		}
		else if (pdfChainCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_3);
		}
		else {
			bindPdfChainCode = true;

			query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPdfChainCode) {
			qPos.add(pdfChainCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where pdfChainCode = &#63; from the database.
	 *
	 * @param pdfChainCode the pdf chain code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPdfChainCode(String pdfChainCode)
		throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPdfChainCode(
				pdfChainCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where pdfChainCode = &#63;.
	 *
	 * @param pdfChainCode the pdf chain code
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPdfChainCode(String pdfChainCode)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PDFCHAINCODE;

		Object[] finderArgs = new Object[] { pdfChainCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfChainCode = false;

			if (pdfChainCode == null) {
				query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_1);
			}
			else if (pdfChainCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_3);
			}
			else {
				bindPdfChainCode = true;

				query.append(_FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfChainCode) {
					qPos.add(pdfChainCode);
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

	private static final String _FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_1 = "publishedPdfList.pdfChainCode IS NULL";
	private static final String _FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_2 = "publishedPdfList.pdfChainCode = ?";
	private static final String _FINDER_COLUMN_PDFCHAINCODE_PDFCHAINCODE_3 = "(publishedPdfList.pdfChainCode IS NULL OR publishedPdfList.pdfChainCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFCTRYCODE =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPdfCtryCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCTRYCODE =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPdfCtryCode",
			new String[] { String.class.getName() },
			PublishedPdfListModelImpl.PDFCTRYCODE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PDFCTRYCODE = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPdfCtryCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the published pdf lists where pdfCtryCode = &#63;.
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfCtryCode(String pdfCtryCode)
		throws SystemException {
		return findByPdfCtryCode(pdfCtryCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where pdfCtryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfCtryCode(String pdfCtryCode,
		int start, int end) throws SystemException {
		return findByPdfCtryCode(pdfCtryCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where pdfCtryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfCtryCode(String pdfCtryCode,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCTRYCODE;
			finderArgs = new Object[] { pdfCtryCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFCTRYCODE;
			finderArgs = new Object[] { pdfCtryCode, start, end, orderByComparator };
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if (!Validator.equals(pdfCtryCode,
							publishedPdfList.getPdfCtryCode())) {
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

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where pdfCtryCode = &#63;.
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfCtryCode_First(String pdfCtryCode,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfCtryCode_First(pdfCtryCode,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where pdfCtryCode = &#63;.
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfCtryCode_First(String pdfCtryCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishedPdfList> list = findByPdfCtryCode(pdfCtryCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfCtryCode = &#63;.
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfCtryCode_Last(String pdfCtryCode,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfCtryCode_Last(pdfCtryCode,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfCtryCode = &#63;.
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfCtryCode_Last(String pdfCtryCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPdfCtryCode(pdfCtryCode);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPdfCtryCode(pdfCtryCode, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfCtryCode = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param pdfCtryCode the pdf ctry code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPdfCtryCode_PrevAndNext(long pdfId,
		String pdfCtryCode, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPdfCtryCode_PrevAndNext(session, publishedPdfList,
					pdfCtryCode, orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPdfCtryCode_PrevAndNext(session, publishedPdfList,
					pdfCtryCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishedPdfList getByPdfCtryCode_PrevAndNext(Session session,
		PublishedPdfList publishedPdfList, String pdfCtryCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		boolean bindPdfCtryCode = false;

		if (pdfCtryCode == null) {
			query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_1);
		}
		else if (pdfCtryCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_3);
		}
		else {
			bindPdfCtryCode = true;

			query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPdfCtryCode) {
			qPos.add(pdfCtryCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where pdfCtryCode = &#63; from the database.
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPdfCtryCode(String pdfCtryCode)
		throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPdfCtryCode(
				pdfCtryCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where pdfCtryCode = &#63;.
	 *
	 * @param pdfCtryCode the pdf ctry code
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPdfCtryCode(String pdfCtryCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PDFCTRYCODE;

		Object[] finderArgs = new Object[] { pdfCtryCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
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

	private static final String _FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_1 = "publishedPdfList.pdfCtryCode IS NULL";
	private static final String _FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_2 = "publishedPdfList.pdfCtryCode = ?";
	private static final String _FINDER_COLUMN_PDFCTRYCODE_PDFCTRYCODE_3 = "(publishedPdfList.pdfCtryCode IS NULL OR publishedPdfList.pdfCtryCode = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFFILENAME =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPdfFileName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAME =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPdfFileName",
			new String[] { String.class.getName() },
			PublishedPdfListModelImpl.PDFFILENAME_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PDFFILENAME = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPdfFileName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the published pdf lists where pdfFileName = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileName(String pdfFileName)
		throws SystemException {
		return findByPdfFileName(pdfFileName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where pdfFileName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfFileName the pdf file name
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileName(String pdfFileName,
		int start, int end) throws SystemException {
		return findByPdfFileName(pdfFileName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where pdfFileName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfFileName the pdf file name
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileName(String pdfFileName,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAME;
			finderArgs = new Object[] { pdfFileName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFFILENAME;
			finderArgs = new Object[] { pdfFileName, start, end, orderByComparator };
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if (!Validator.equals(pdfFileName,
							publishedPdfList.getPdfFileName())) {
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

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfFileName = false;

			if (pdfFileName == null) {
				query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_1);
			}
			else if (pdfFileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_3);
			}
			else {
				bindPdfFileName = true;

				query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfFileName) {
					qPos.add(pdfFileName);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where pdfFileName = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfFileName_First(String pdfFileName,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfFileName_First(pdfFileName,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfFileName=");
		msg.append(pdfFileName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where pdfFileName = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfFileName_First(String pdfFileName,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishedPdfList> list = findByPdfFileName(pdfFileName, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfFileName = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfFileName_Last(String pdfFileName,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfFileName_Last(pdfFileName,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfFileName=");
		msg.append(pdfFileName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfFileName = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfFileName_Last(String pdfFileName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPdfFileName(pdfFileName);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPdfFileName(pdfFileName, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfFileName = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param pdfFileName the pdf file name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPdfFileName_PrevAndNext(long pdfId,
		String pdfFileName, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPdfFileName_PrevAndNext(session, publishedPdfList,
					pdfFileName, orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPdfFileName_PrevAndNext(session, publishedPdfList,
					pdfFileName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishedPdfList getByPdfFileName_PrevAndNext(Session session,
		PublishedPdfList publishedPdfList, String pdfFileName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		boolean bindPdfFileName = false;

		if (pdfFileName == null) {
			query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_1);
		}
		else if (pdfFileName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_3);
		}
		else {
			bindPdfFileName = true;

			query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPdfFileName) {
			qPos.add(pdfFileName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where pdfFileName = &#63; from the database.
	 *
	 * @param pdfFileName the pdf file name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPdfFileName(String pdfFileName)
		throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPdfFileName(
				pdfFileName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where pdfFileName = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPdfFileName(String pdfFileName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PDFFILENAME;

		Object[] finderArgs = new Object[] { pdfFileName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfFileName = false;

			if (pdfFileName == null) {
				query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_1);
			}
			else if (pdfFileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_3);
			}
			else {
				bindPdfFileName = true;

				query.append(_FINDER_COLUMN_PDFFILENAME_PDFFILENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfFileName) {
					qPos.add(pdfFileName);
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

	private static final String _FINDER_COLUMN_PDFFILENAME_PDFFILENAME_1 = "publishedPdfList.pdfFileName IS NULL";
	private static final String _FINDER_COLUMN_PDFFILENAME_PDFFILENAME_2 = "publishedPdfList.pdfFileName = ?";
	private static final String _FINDER_COLUMN_PDFFILENAME_PDFFILENAME_3 = "(publishedPdfList.pdfFileName IS NULL OR publishedPdfList.pdfFileName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFFILEURLTEXT =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPdfFileURLText",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILEURLTEXT =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPdfFileURLText",
			new String[] { String.class.getName() },
			PublishedPdfListModelImpl.PDFFILEURLTEXT_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PDFFILEURLTEXT = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPdfFileURLText",
			new String[] { String.class.getName() });

	/**
	 * Returns all the published pdf lists where pdfFileURLText = &#63;.
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileURLText(String pdfFileURLText)
		throws SystemException {
		return findByPdfFileURLText(pdfFileURLText, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where pdfFileURLText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileURLText(String pdfFileURLText,
		int start, int end) throws SystemException {
		return findByPdfFileURLText(pdfFileURLText, start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where pdfFileURLText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileURLText(String pdfFileURLText,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILEURLTEXT;
			finderArgs = new Object[] { pdfFileURLText };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFFILEURLTEXT;
			finderArgs = new Object[] {
					pdfFileURLText,
					
					start, end, orderByComparator
				};
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if (!Validator.equals(pdfFileURLText,
							publishedPdfList.getPdfFileURLText())) {
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

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfFileURLText = false;

			if (pdfFileURLText == null) {
				query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_1);
			}
			else if (pdfFileURLText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_3);
			}
			else {
				bindPdfFileURLText = true;

				query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfFileURLText) {
					qPos.add(pdfFileURLText);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where pdfFileURLText = &#63;.
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfFileURLText_First(String pdfFileURLText,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfFileURLText_First(pdfFileURLText,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfFileURLText=");
		msg.append(pdfFileURLText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where pdfFileURLText = &#63;.
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfFileURLText_First(String pdfFileURLText,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishedPdfList> list = findByPdfFileURLText(pdfFileURLText, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfFileURLText = &#63;.
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfFileURLText_Last(String pdfFileURLText,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfFileURLText_Last(pdfFileURLText,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfFileURLText=");
		msg.append(pdfFileURLText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfFileURLText = &#63;.
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfFileURLText_Last(String pdfFileURLText,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPdfFileURLText(pdfFileURLText);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPdfFileURLText(pdfFileURLText,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfFileURLText = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPdfFileURLText_PrevAndNext(long pdfId,
		String pdfFileURLText, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPdfFileURLText_PrevAndNext(session,
					publishedPdfList, pdfFileURLText, orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPdfFileURLText_PrevAndNext(session,
					publishedPdfList, pdfFileURLText, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishedPdfList getByPdfFileURLText_PrevAndNext(
		Session session, PublishedPdfList publishedPdfList,
		String pdfFileURLText, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		boolean bindPdfFileURLText = false;

		if (pdfFileURLText == null) {
			query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_1);
		}
		else if (pdfFileURLText.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_3);
		}
		else {
			bindPdfFileURLText = true;

			query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPdfFileURLText) {
			qPos.add(pdfFileURLText);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where pdfFileURLText = &#63; from the database.
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPdfFileURLText(String pdfFileURLText)
		throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPdfFileURLText(
				pdfFileURLText, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where pdfFileURLText = &#63;.
	 *
	 * @param pdfFileURLText the pdf file u r l text
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPdfFileURLText(String pdfFileURLText)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PDFFILEURLTEXT;

		Object[] finderArgs = new Object[] { pdfFileURLText };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfFileURLText = false;

			if (pdfFileURLText == null) {
				query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_1);
			}
			else if (pdfFileURLText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_3);
			}
			else {
				bindPdfFileURLText = true;

				query.append(_FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfFileURLText) {
					qPos.add(pdfFileURLText);
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

	private static final String _FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_1 = "publishedPdfList.pdfFileURLText IS NULL";
	private static final String _FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_2 = "publishedPdfList.pdfFileURLText = ?";
	private static final String _FINDER_COLUMN_PDFFILEURLTEXT_PDFFILEURLTEXT_3 = "(publishedPdfList.pdfFileURLText IS NULL OR publishedPdfList.pdfFileURLText = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFFILENAMEANDURL =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPdfFileNameAndURL",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAMEANDURL =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPdfFileNameAndURL",
			new String[] { String.class.getName(), String.class.getName() },
			PublishedPdfListModelImpl.PDFFILENAME_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFFILEURLTEXT_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PDFFILENAMEANDURL = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPdfFileNameAndURL",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileNameAndURL(String pdfFileName,
		String pdfFileURLText) throws SystemException {
		return findByPdfFileNameAndURL(pdfFileName, pdfFileURLText,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileNameAndURL(String pdfFileName,
		String pdfFileURLText, int start, int end) throws SystemException {
		return findByPdfFileNameAndURL(pdfFileName, pdfFileURLText, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfFileNameAndURL(String pdfFileName,
		String pdfFileURLText, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAMEANDURL;
			finderArgs = new Object[] { pdfFileName, pdfFileURLText };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFFILENAMEANDURL;
			finderArgs = new Object[] {
					pdfFileName, pdfFileURLText,
					
					start, end, orderByComparator
				};
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if (!Validator.equals(pdfFileName,
							publishedPdfList.getPdfFileName()) ||
						!Validator.equals(pdfFileURLText,
							publishedPdfList.getPdfFileURLText())) {
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

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfFileName = false;

			if (pdfFileName == null) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_1);
			}
			else if (pdfFileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_3);
			}
			else {
				bindPdfFileName = true;

				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_2);
			}

			boolean bindPdfFileURLText = false;

			if (pdfFileURLText == null) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_1);
			}
			else if (pdfFileURLText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_3);
			}
			else {
				bindPdfFileURLText = true;

				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfFileName) {
					qPos.add(pdfFileName);
				}

				if (bindPdfFileURLText) {
					qPos.add(pdfFileURLText);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfFileNameAndURL_First(String pdfFileName,
		String pdfFileURLText, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfFileNameAndURL_First(pdfFileName,
				pdfFileURLText, orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfFileName=");
		msg.append(pdfFileName);

		msg.append(", pdfFileURLText=");
		msg.append(pdfFileURLText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfFileNameAndURL_First(String pdfFileName,
		String pdfFileURLText, OrderByComparator orderByComparator)
		throws SystemException {
		List<PublishedPdfList> list = findByPdfFileNameAndURL(pdfFileName,
				pdfFileURLText, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfFileNameAndURL_Last(String pdfFileName,
		String pdfFileURLText, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfFileNameAndURL_Last(pdfFileName,
				pdfFileURLText, orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pdfFileName=");
		msg.append(pdfFileName);

		msg.append(", pdfFileURLText=");
		msg.append(pdfFileURLText);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfFileNameAndURL_Last(String pdfFileName,
		String pdfFileURLText, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPdfFileNameAndURL(pdfFileName, pdfFileURLText);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPdfFileNameAndURL(pdfFileName,
				pdfFileURLText, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPdfFileNameAndURL_PrevAndNext(long pdfId,
		String pdfFileName, String pdfFileURLText,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPdfFileNameAndURL_PrevAndNext(session,
					publishedPdfList, pdfFileName, pdfFileURLText,
					orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPdfFileNameAndURL_PrevAndNext(session,
					publishedPdfList, pdfFileName, pdfFileURLText,
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

	protected PublishedPdfList getByPdfFileNameAndURL_PrevAndNext(
		Session session, PublishedPdfList publishedPdfList, String pdfFileName,
		String pdfFileURLText, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		boolean bindPdfFileName = false;

		if (pdfFileName == null) {
			query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_1);
		}
		else if (pdfFileName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_3);
		}
		else {
			bindPdfFileName = true;

			query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_2);
		}

		boolean bindPdfFileURLText = false;

		if (pdfFileURLText == null) {
			query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_1);
		}
		else if (pdfFileURLText.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_3);
		}
		else {
			bindPdfFileURLText = true;

			query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPdfFileName) {
			qPos.add(pdfFileName);
		}

		if (bindPdfFileURLText) {
			qPos.add(pdfFileURLText);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63; from the database.
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPdfFileNameAndURL(String pdfFileName,
		String pdfFileURLText) throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPdfFileNameAndURL(
				pdfFileName, pdfFileURLText, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where pdfFileName = &#63; and pdfFileURLText = &#63;.
	 *
	 * @param pdfFileName the pdf file name
	 * @param pdfFileURLText the pdf file u r l text
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPdfFileNameAndURL(String pdfFileName,
		String pdfFileURLText) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PDFFILENAMEANDURL;

		Object[] finderArgs = new Object[] { pdfFileName, pdfFileURLText };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			boolean bindPdfFileName = false;

			if (pdfFileName == null) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_1);
			}
			else if (pdfFileName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_3);
			}
			else {
				bindPdfFileName = true;

				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_2);
			}

			boolean bindPdfFileURLText = false;

			if (pdfFileURLText == null) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_1);
			}
			else if (pdfFileURLText.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_3);
			}
			else {
				bindPdfFileURLText = true;

				query.append(_FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPdfFileName) {
					qPos.add(pdfFileName);
				}

				if (bindPdfFileURLText) {
					qPos.add(pdfFileURLText);
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

	private static final String _FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_1 = "publishedPdfList.pdfFileName IS NULL AND ";
	private static final String _FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_2 = "publishedPdfList.pdfFileName = ? AND ";
	private static final String _FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILENAME_3 = "(publishedPdfList.pdfFileName IS NULL OR publishedPdfList.pdfFileName = '') AND ";
	private static final String _FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_1 =
		"publishedPdfList.pdfFileURLText IS NULL";
	private static final String _FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_2 =
		"publishedPdfList.pdfFileURLText = ?";
	private static final String _FINDER_COLUMN_PDFFILENAMEANDURL_PDFFILEURLTEXT_3 =
		"(publishedPdfList.pdfFileURLText IS NULL OR publishedPdfList.pdfFileURLText = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFMANUALPARAMS =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPdfManualParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFMANUALPARAMS =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPdfManualParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			PublishedPdfListModelImpl.PUBLISHID_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFCTRYCODE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFLOCALECODE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFBUILDTYPE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PAGESIZEORIENTATIONTYPE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PDFMANUALPARAMS = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPdfManualParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfManualParams(long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType) throws SystemException {
		return findByPdfManualParams(publishId, pdfCtryCode, pdfLocaleCode,
			pdfBuildType, pageSizeOrientationType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfManualParams(long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType, int start, int end)
		throws SystemException {
		return findByPdfManualParams(publishId, pdfCtryCode, pdfLocaleCode,
			pdfBuildType, pageSizeOrientationType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPdfManualParams(long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFMANUALPARAMS;
			finderArgs = new Object[] {
					publishId, pdfCtryCode, pdfLocaleCode, pdfBuildType,
					pageSizeOrientationType
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PDFMANUALPARAMS;
			finderArgs = new Object[] {
					publishId, pdfCtryCode, pdfLocaleCode, pdfBuildType,
					pageSizeOrientationType,
					
					start, end, orderByComparator
				};
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if ((publishId != publishedPdfList.getPublishId()) ||
						!Validator.equals(pdfCtryCode,
							publishedPdfList.getPdfCtryCode()) ||
						!Validator.equals(pdfLocaleCode,
							publishedPdfList.getPdfLocaleCode()) ||
						!Validator.equals(pdfBuildType,
							publishedPdfList.getPdfBuildType()) ||
						!Validator.equals(pageSizeOrientationType,
							publishedPdfList.getPageSizeOrientationType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(7 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(7);
			}

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PUBLISHID_2);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_2);
			}

			boolean bindPdfLocaleCode = false;

			if (pdfLocaleCode == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_1);
			}
			else if (pdfLocaleCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_3);
			}
			else {
				bindPdfLocaleCode = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_2);
			}

			boolean bindPdfBuildType = false;

			if (pdfBuildType == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_1);
			}
			else if (pdfBuildType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_3);
			}
			else {
				bindPdfBuildType = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_2);
			}

			boolean bindPageSizeOrientationType = false;

			if (pageSizeOrientationType == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1);
			}
			else if (pageSizeOrientationType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3);
			}
			else {
				bindPageSizeOrientationType = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
				}

				if (bindPdfLocaleCode) {
					qPos.add(pdfLocaleCode);
				}

				if (bindPdfBuildType) {
					qPos.add(pdfBuildType);
				}

				if (bindPageSizeOrientationType) {
					qPos.add(pageSizeOrientationType);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfManualParams_First(long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfManualParams_First(publishId,
				pdfCtryCode, pdfLocaleCode, pdfBuildType,
				pageSizeOrientationType, orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(", pdfLocaleCode=");
		msg.append(pdfLocaleCode);

		msg.append(", pdfBuildType=");
		msg.append(pdfBuildType);

		msg.append(", pageSizeOrientationType=");
		msg.append(pageSizeOrientationType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfManualParams_First(long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws SystemException {
		List<PublishedPdfList> list = findByPdfManualParams(publishId,
				pdfCtryCode, pdfLocaleCode, pdfBuildType,
				pageSizeOrientationType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPdfManualParams_Last(long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPdfManualParams_Last(publishId,
				pdfCtryCode, pdfLocaleCode, pdfBuildType,
				pageSizeOrientationType, orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(12);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(", pdfLocaleCode=");
		msg.append(pdfLocaleCode);

		msg.append(", pdfBuildType=");
		msg.append(pdfBuildType);

		msg.append(", pageSizeOrientationType=");
		msg.append(pageSizeOrientationType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPdfManualParams_Last(long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPdfManualParams(publishId, pdfCtryCode,
				pdfLocaleCode, pdfBuildType, pageSizeOrientationType);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPdfManualParams(publishId,
				pdfCtryCode, pdfLocaleCode, pdfBuildType,
				pageSizeOrientationType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPdfManualParams_PrevAndNext(long pdfId,
		long publishId, String pdfCtryCode, String pdfLocaleCode,
		String pdfBuildType, String pageSizeOrientationType,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPdfManualParams_PrevAndNext(session,
					publishedPdfList, publishId, pdfCtryCode, pdfLocaleCode,
					pdfBuildType, pageSizeOrientationType, orderByComparator,
					true);

			array[1] = publishedPdfList;

			array[2] = getByPdfManualParams_PrevAndNext(session,
					publishedPdfList, publishId, pdfCtryCode, pdfLocaleCode,
					pdfBuildType, pageSizeOrientationType, orderByComparator,
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

	protected PublishedPdfList getByPdfManualParams_PrevAndNext(
		Session session, PublishedPdfList publishedPdfList, long publishId,
		String pdfCtryCode, String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PUBLISHID_2);

		boolean bindPdfCtryCode = false;

		if (pdfCtryCode == null) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_1);
		}
		else if (pdfCtryCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_3);
		}
		else {
			bindPdfCtryCode = true;

			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_2);
		}

		boolean bindPdfLocaleCode = false;

		if (pdfLocaleCode == null) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_1);
		}
		else if (pdfLocaleCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_3);
		}
		else {
			bindPdfLocaleCode = true;

			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_2);
		}

		boolean bindPdfBuildType = false;

		if (pdfBuildType == null) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_1);
		}
		else if (pdfBuildType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_3);
		}
		else {
			bindPdfBuildType = true;

			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_2);
		}

		boolean bindPageSizeOrientationType = false;

		if (pageSizeOrientationType == null) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1);
		}
		else if (pageSizeOrientationType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3);
		}
		else {
			bindPageSizeOrientationType = true;

			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (bindPdfCtryCode) {
			qPos.add(pdfCtryCode);
		}

		if (bindPdfLocaleCode) {
			qPos.add(pdfLocaleCode);
		}

		if (bindPdfBuildType) {
			qPos.add(pdfBuildType);
		}

		if (bindPageSizeOrientationType) {
			qPos.add(pageSizeOrientationType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPdfManualParams(long publishId, String pdfCtryCode,
		String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType) throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPdfManualParams(
				publishId, pdfCtryCode, pdfLocaleCode, pdfBuildType,
				pageSizeOrientationType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfLocaleCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfLocaleCode the pdf locale code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPdfManualParams(long publishId, String pdfCtryCode,
		String pdfLocaleCode, String pdfBuildType,
		String pageSizeOrientationType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PDFMANUALPARAMS;

		Object[] finderArgs = new Object[] {
				publishId, pdfCtryCode, pdfLocaleCode, pdfBuildType,
				pageSizeOrientationType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PUBLISHID_2);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_2);
			}

			boolean bindPdfLocaleCode = false;

			if (pdfLocaleCode == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_1);
			}
			else if (pdfLocaleCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_3);
			}
			else {
				bindPdfLocaleCode = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_2);
			}

			boolean bindPdfBuildType = false;

			if (pdfBuildType == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_1);
			}
			else if (pdfBuildType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_3);
			}
			else {
				bindPdfBuildType = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_2);
			}

			boolean bindPageSizeOrientationType = false;

			if (pageSizeOrientationType == null) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1);
			}
			else if (pageSizeOrientationType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3);
			}
			else {
				bindPageSizeOrientationType = true;

				query.append(_FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
				}

				if (bindPdfLocaleCode) {
					qPos.add(pdfLocaleCode);
				}

				if (bindPdfBuildType) {
					qPos.add(pdfBuildType);
				}

				if (bindPageSizeOrientationType) {
					qPos.add(pageSizeOrientationType);
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

	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PUBLISHID_2 = "publishedPdfList.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_1 = "publishedPdfList.pdfCtryCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_2 = "publishedPdfList.pdfCtryCode = ? AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFCTRYCODE_3 = "(publishedPdfList.pdfCtryCode IS NULL OR publishedPdfList.pdfCtryCode = '') AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_1 = "publishedPdfList.pdfLocaleCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_2 = "publishedPdfList.pdfLocaleCode = ? AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFLOCALECODE_3 = "(publishedPdfList.pdfLocaleCode IS NULL OR publishedPdfList.pdfLocaleCode = '') AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_1 = "publishedPdfList.pdfBuildType IS NULL AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_2 = "publishedPdfList.pdfBuildType = ? AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PDFBUILDTYPE_3 = "(publishedPdfList.pdfBuildType IS NULL OR publishedPdfList.pdfBuildType = '') AND ";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1 =
		"publishedPdfList.pageSizeOrientationType IS NULL";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2 =
		"publishedPdfList.pageSizeOrientationType = ?";
	private static final String _FINDER_COLUMN_PDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3 =
		"(publishedPdfList.pageSizeOrientationType IS NULL OR publishedPdfList.pageSizeOrientationType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHPDFMANUALPARAMS =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishPdfManualParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPDFMANUALPARAMS =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishPdfManualParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			PublishedPdfListModelImpl.PUBLISHID_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFCTRYCODE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFBUILDTYPE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PAGESIZEORIENTATIONTYPE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHPDFMANUALPARAMS = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishPdfManualParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishPdfManualParams(long publishId,
		String pdfCtryCode, String pdfBuildType, String pageSizeOrientationType)
		throws SystemException {
		return findByPublishPdfManualParams(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishPdfManualParams(long publishId,
		String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, int start, int end)
		throws SystemException {
		return findByPublishPdfManualParams(publishId, pdfCtryCode,
			pdfBuildType, pageSizeOrientationType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishPdfManualParams(long publishId,
		String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPDFMANUALPARAMS;
			finderArgs = new Object[] {
					publishId, pdfCtryCode, pdfBuildType,
					pageSizeOrientationType
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHPDFMANUALPARAMS;
			finderArgs = new Object[] {
					publishId, pdfCtryCode, pdfBuildType,
					pageSizeOrientationType,
					
					start, end, orderByComparator
				};
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if ((publishId != publishedPdfList.getPublishId()) ||
						!Validator.equals(pdfCtryCode,
							publishedPdfList.getPdfCtryCode()) ||
						!Validator.equals(pdfBuildType,
							publishedPdfList.getPdfBuildType()) ||
						!Validator.equals(pageSizeOrientationType,
							publishedPdfList.getPageSizeOrientationType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PUBLISHID_2);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_2);
			}

			boolean bindPdfBuildType = false;

			if (pdfBuildType == null) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_1);
			}
			else if (pdfBuildType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_3);
			}
			else {
				bindPdfBuildType = true;

				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_2);
			}

			boolean bindPageSizeOrientationType = false;

			if (pageSizeOrientationType == null) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1);
			}
			else if (pageSizeOrientationType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3);
			}
			else {
				bindPageSizeOrientationType = true;

				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
				}

				if (bindPdfBuildType) {
					qPos.add(pdfBuildType);
				}

				if (bindPageSizeOrientationType) {
					qPos.add(pageSizeOrientationType);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPublishPdfManualParams_First(long publishId,
		String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPublishPdfManualParams_First(publishId,
				pdfCtryCode, pdfBuildType, pageSizeOrientationType,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(", pdfBuildType=");
		msg.append(pdfBuildType);

		msg.append(", pageSizeOrientationType=");
		msg.append(pageSizeOrientationType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPublishPdfManualParams_First(
		long publishId, String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws SystemException {
		List<PublishedPdfList> list = findByPublishPdfManualParams(publishId,
				pdfCtryCode, pdfBuildType, pageSizeOrientationType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPublishPdfManualParams_Last(long publishId,
		String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPublishPdfManualParams_Last(publishId,
				pdfCtryCode, pdfBuildType, pageSizeOrientationType,
				orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(", pdfBuildType=");
		msg.append(pdfBuildType);

		msg.append(", pageSizeOrientationType=");
		msg.append(pageSizeOrientationType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPublishPdfManualParams_Last(long publishId,
		String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByPublishPdfManualParams(publishId, pdfCtryCode,
				pdfBuildType, pageSizeOrientationType);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPublishPdfManualParams(publishId,
				pdfCtryCode, pdfBuildType, pageSizeOrientationType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPublishPdfManualParams_PrevAndNext(
		long pdfId, long publishId, String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPublishPdfManualParams_PrevAndNext(session,
					publishedPdfList, publishId, pdfCtryCode, pdfBuildType,
					pageSizeOrientationType, orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPublishPdfManualParams_PrevAndNext(session,
					publishedPdfList, publishId, pdfCtryCode, pdfBuildType,
					pageSizeOrientationType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishedPdfList getByPublishPdfManualParams_PrevAndNext(
		Session session, PublishedPdfList publishedPdfList, long publishId,
		String pdfCtryCode, String pdfBuildType,
		String pageSizeOrientationType, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PUBLISHID_2);

		boolean bindPdfCtryCode = false;

		if (pdfCtryCode == null) {
			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_1);
		}
		else if (pdfCtryCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_3);
		}
		else {
			bindPdfCtryCode = true;

			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_2);
		}

		boolean bindPdfBuildType = false;

		if (pdfBuildType == null) {
			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_1);
		}
		else if (pdfBuildType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_3);
		}
		else {
			bindPdfBuildType = true;

			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_2);
		}

		boolean bindPageSizeOrientationType = false;

		if (pageSizeOrientationType == null) {
			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1);
		}
		else if (pageSizeOrientationType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3);
		}
		else {
			bindPageSizeOrientationType = true;

			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (bindPdfCtryCode) {
			qPos.add(pdfCtryCode);
		}

		if (bindPdfBuildType) {
			qPos.add(pdfBuildType);
		}

		if (bindPageSizeOrientationType) {
			qPos.add(pageSizeOrientationType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishPdfManualParams(long publishId,
		String pdfCtryCode, String pdfBuildType, String pageSizeOrientationType)
		throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPublishPdfManualParams(
				publishId, pdfCtryCode, pdfBuildType, pageSizeOrientationType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; and pageSizeOrientationType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param pageSizeOrientationType the page size orientation type
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishPdfManualParams(long publishId,
		String pdfCtryCode, String pdfBuildType, String pageSizeOrientationType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHPDFMANUALPARAMS;

		Object[] finderArgs = new Object[] {
				publishId, pdfCtryCode, pdfBuildType, pageSizeOrientationType
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PUBLISHID_2);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_2);
			}

			boolean bindPdfBuildType = false;

			if (pdfBuildType == null) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_1);
			}
			else if (pdfBuildType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_3);
			}
			else {
				bindPdfBuildType = true;

				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_2);
			}

			boolean bindPageSizeOrientationType = false;

			if (pageSizeOrientationType == null) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1);
			}
			else if (pageSizeOrientationType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3);
			}
			else {
				bindPageSizeOrientationType = true;

				query.append(_FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
				}

				if (bindPdfBuildType) {
					qPos.add(pdfBuildType);
				}

				if (bindPageSizeOrientationType) {
					qPos.add(pageSizeOrientationType);
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

	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PUBLISHID_2 =
		"publishedPdfList.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_1 =
		"publishedPdfList.pdfCtryCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_2 =
		"publishedPdfList.pdfCtryCode = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFCTRYCODE_3 =
		"(publishedPdfList.pdfCtryCode IS NULL OR publishedPdfList.pdfCtryCode = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_1 =
		"publishedPdfList.pdfBuildType IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_2 =
		"publishedPdfList.pdfBuildType = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PDFBUILDTYPE_3 =
		"(publishedPdfList.pdfBuildType IS NULL OR publishedPdfList.pdfBuildType = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_1 =
		"publishedPdfList.pageSizeOrientationType IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_2 =
		"publishedPdfList.pageSizeOrientationType = ?";
	private static final String _FINDER_COLUMN_PUBLISHPDFMANUALPARAMS_PAGESIZEORIENTATIONTYPE_3 =
		"(publishedPdfList.pageSizeOrientationType IS NULL OR publishedPdfList.pageSizeOrientationType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHEDPDFPARAMS =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublishedPDFParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHEDPDFPARAMS =
		new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED,
			PublishedPdfListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublishedPDFParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			PublishedPdfListModelImpl.PUBLISHID_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFCTRYCODE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.PDFBUILDTYPE_COLUMN_BITMASK |
			PublishedPdfListModelImpl.UPDATEDDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHEDPDFPARAMS = new FinderPath(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublishedPDFParams",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @return the matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishedPDFParams(long publishId,
		String pdfCtryCode, String pdfBuildType) throws SystemException {
		return findByPublishedPDFParams(publishId, pdfCtryCode, pdfBuildType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishedPDFParams(long publishId,
		String pdfCtryCode, String pdfBuildType, int start, int end)
		throws SystemException {
		return findByPublishedPDFParams(publishId, pdfCtryCode, pdfBuildType,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findByPublishedPDFParams(long publishId,
		String pdfCtryCode, String pdfBuildType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHEDPDFPARAMS;
			finderArgs = new Object[] { publishId, pdfCtryCode, pdfBuildType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHEDPDFPARAMS;
			finderArgs = new Object[] {
					publishId, pdfCtryCode, pdfBuildType,
					
					start, end, orderByComparator
				};
		}

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishedPdfList publishedPdfList : list) {
				if ((publishId != publishedPdfList.getPublishId()) ||
						!Validator.equals(pdfCtryCode,
							publishedPdfList.getPdfCtryCode()) ||
						!Validator.equals(pdfBuildType,
							publishedPdfList.getPdfBuildType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PUBLISHID_2);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_2);
			}

			boolean bindPdfBuildType = false;

			if (pdfBuildType == null) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_1);
			}
			else if (pdfBuildType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_3);
			}
			else {
				bindPdfBuildType = true;

				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
				}

				if (bindPdfBuildType) {
					qPos.add(pdfBuildType);
				}

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPublishedPDFParams_First(long publishId,
		String pdfCtryCode, String pdfBuildType,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPublishedPDFParams_First(publishId,
				pdfCtryCode, pdfBuildType, orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(", pdfBuildType=");
		msg.append(pdfBuildType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the first published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPublishedPDFParams_First(long publishId,
		String pdfCtryCode, String pdfBuildType,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishedPdfList> list = findByPublishedPDFParams(publishId,
				pdfCtryCode, pdfBuildType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPublishedPDFParams_Last(long publishId,
		String pdfCtryCode, String pdfBuildType,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPublishedPDFParams_Last(publishId,
				pdfCtryCode, pdfBuildType, orderByComparator);

		if (publishedPdfList != null) {
			return publishedPdfList;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishId=");
		msg.append(publishId);

		msg.append(", pdfCtryCode=");
		msg.append(pdfCtryCode);

		msg.append(", pdfBuildType=");
		msg.append(pdfBuildType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishedPdfListException(msg.toString());
	}

	/**
	 * Returns the last published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching published pdf list, or <code>null</code> if a matching published pdf list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPublishedPDFParams_Last(long publishId,
		String pdfCtryCode, String pdfBuildType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPublishedPDFParams(publishId, pdfCtryCode,
				pdfBuildType);

		if (count == 0) {
			return null;
		}

		List<PublishedPdfList> list = findByPublishedPDFParams(publishId,
				pdfCtryCode, pdfBuildType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the published pdf lists before and after the current published pdf list in the ordered set where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * @param pdfId the primary key of the current published pdf list
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList[] findByPublishedPDFParams_PrevAndNext(long pdfId,
		long publishId, String pdfCtryCode, String pdfBuildType,
		OrderByComparator orderByComparator)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = findByPrimaryKey(pdfId);

		Session session = null;

		try {
			session = openSession();

			PublishedPdfList[] array = new PublishedPdfListImpl[3];

			array[0] = getByPublishedPDFParams_PrevAndNext(session,
					publishedPdfList, publishId, pdfCtryCode, pdfBuildType,
					orderByComparator, true);

			array[1] = publishedPdfList;

			array[2] = getByPublishedPDFParams_PrevAndNext(session,
					publishedPdfList, publishId, pdfCtryCode, pdfBuildType,
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

	protected PublishedPdfList getByPublishedPDFParams_PrevAndNext(
		Session session, PublishedPdfList publishedPdfList, long publishId,
		String pdfCtryCode, String pdfBuildType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHEDPDFLIST_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PUBLISHID_2);

		boolean bindPdfCtryCode = false;

		if (pdfCtryCode == null) {
			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_1);
		}
		else if (pdfCtryCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_3);
		}
		else {
			bindPdfCtryCode = true;

			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_2);
		}

		boolean bindPdfBuildType = false;

		if (pdfBuildType == null) {
			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_1);
		}
		else if (pdfBuildType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_3);
		}
		else {
			bindPdfBuildType = true;

			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_2);
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
			query.append(PublishedPdfListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishId);

		if (bindPdfCtryCode) {
			qPos.add(pdfCtryCode);
		}

		if (bindPdfBuildType) {
			qPos.add(pdfBuildType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishedPdfList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishedPdfList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63; from the database.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPublishedPDFParams(long publishId, String pdfCtryCode,
		String pdfBuildType) throws SystemException {
		for (PublishedPdfList publishedPdfList : findByPublishedPDFParams(
				publishId, pdfCtryCode, pdfBuildType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists where publishId = &#63; and pdfCtryCode = &#63; and pdfBuildType = &#63;.
	 *
	 * @param publishId the publish ID
	 * @param pdfCtryCode the pdf ctry code
	 * @param pdfBuildType the pdf build type
	 * @return the number of matching published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPublishedPDFParams(long publishId, String pdfCtryCode,
		String pdfBuildType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHEDPDFPARAMS;

		Object[] finderArgs = new Object[] { publishId, pdfCtryCode, pdfBuildType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_PUBLISHEDPDFLIST_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PUBLISHID_2);

			boolean bindPdfCtryCode = false;

			if (pdfCtryCode == null) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_1);
			}
			else if (pdfCtryCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_3);
			}
			else {
				bindPdfCtryCode = true;

				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_2);
			}

			boolean bindPdfBuildType = false;

			if (pdfBuildType == null) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_1);
			}
			else if (pdfBuildType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_3);
			}
			else {
				bindPdfBuildType = true;

				query.append(_FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishId);

				if (bindPdfCtryCode) {
					qPos.add(pdfCtryCode);
				}

				if (bindPdfBuildType) {
					qPos.add(pdfBuildType);
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

	private static final String _FINDER_COLUMN_PUBLISHEDPDFPARAMS_PUBLISHID_2 = "publishedPdfList.publishId = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_1 = "publishedPdfList.pdfCtryCode IS NULL AND ";
	private static final String _FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_2 = "publishedPdfList.pdfCtryCode = ? AND ";
	private static final String _FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFCTRYCODE_3 = "(publishedPdfList.pdfCtryCode IS NULL OR publishedPdfList.pdfCtryCode = '') AND ";
	private static final String _FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_1 =
		"publishedPdfList.pdfBuildType IS NULL";
	private static final String _FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_2 =
		"publishedPdfList.pdfBuildType = ?";
	private static final String _FINDER_COLUMN_PUBLISHEDPDFPARAMS_PDFBUILDTYPE_3 =
		"(publishedPdfList.pdfBuildType IS NULL OR publishedPdfList.pdfBuildType = '')";

	public PublishedPdfListPersistenceImpl() {
		setModelClass(PublishedPdfList.class);
	}

	/**
	 * Caches the published pdf list in the entity cache if it is enabled.
	 *
	 * @param publishedPdfList the published pdf list
	 */
	@Override
	public void cacheResult(PublishedPdfList publishedPdfList) {
		EntityCacheUtil.putResult(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListImpl.class, publishedPdfList.getPrimaryKey(),
			publishedPdfList);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PDFID,
			new Object[] { publishedPdfList.getPdfId() }, publishedPdfList);

		publishedPdfList.resetOriginalValues();
	}

	/**
	 * Caches the published pdf lists in the entity cache if it is enabled.
	 *
	 * @param publishedPdfLists the published pdf lists
	 */
	@Override
	public void cacheResult(List<PublishedPdfList> publishedPdfLists) {
		for (PublishedPdfList publishedPdfList : publishedPdfLists) {
			if (EntityCacheUtil.getResult(
						PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
						PublishedPdfListImpl.class,
						publishedPdfList.getPrimaryKey()) == null) {
				cacheResult(publishedPdfList);
			}
			else {
				publishedPdfList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all published pdf lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishedPdfListImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishedPdfListImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the published pdf list.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishedPdfList publishedPdfList) {
		EntityCacheUtil.removeResult(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListImpl.class, publishedPdfList.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publishedPdfList);
	}

	@Override
	public void clearCache(List<PublishedPdfList> publishedPdfLists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishedPdfList publishedPdfList : publishedPdfLists) {
			EntityCacheUtil.removeResult(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
				PublishedPdfListImpl.class, publishedPdfList.getPrimaryKey());

			clearUniqueFindersCache(publishedPdfList);
		}
	}

	protected void cacheUniqueFindersCache(PublishedPdfList publishedPdfList) {
		if (publishedPdfList.isNew()) {
			Object[] args = new Object[] { publishedPdfList.getPdfId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PDFID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PDFID, args,
				publishedPdfList);
		}
		else {
			PublishedPdfListModelImpl publishedPdfListModelImpl = (PublishedPdfListModelImpl)publishedPdfList;

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PDFID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { publishedPdfList.getPdfId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PDFID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PDFID, args,
					publishedPdfList);
			}
		}
	}

	protected void clearUniqueFindersCache(PublishedPdfList publishedPdfList) {
		PublishedPdfListModelImpl publishedPdfListModelImpl = (PublishedPdfListModelImpl)publishedPdfList;

		Object[] args = new Object[] { publishedPdfList.getPdfId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PDFID, args);

		if ((publishedPdfListModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PDFID.getColumnBitmask()) != 0) {
			args = new Object[] { publishedPdfListModelImpl.getOriginalPdfId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PDFID, args);
		}
	}

	/**
	 * Creates a new published pdf list with the primary key. Does not add the published pdf list to the database.
	 *
	 * @param pdfId the primary key for the new published pdf list
	 * @return the new published pdf list
	 */
	@Override
	public PublishedPdfList create(long pdfId) {
		PublishedPdfList publishedPdfList = new PublishedPdfListImpl();

		publishedPdfList.setNew(true);
		publishedPdfList.setPrimaryKey(pdfId);

		return publishedPdfList;
	}

	/**
	 * Removes the published pdf list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pdfId the primary key of the published pdf list
	 * @return the published pdf list that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList remove(long pdfId)
		throws NoSuchPublishedPdfListException, SystemException {
		return remove((Serializable)pdfId);
	}

	/**
	 * Removes the published pdf list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the published pdf list
	 * @return the published pdf list that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList remove(Serializable primaryKey)
		throws NoSuchPublishedPdfListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishedPdfList publishedPdfList = (PublishedPdfList)session.get(PublishedPdfListImpl.class,
					primaryKey);

			if (publishedPdfList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishedPdfListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishedPdfList);
		}
		catch (NoSuchPublishedPdfListException nsee) {
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
	protected PublishedPdfList removeImpl(PublishedPdfList publishedPdfList)
		throws SystemException {
		publishedPdfList = toUnwrappedModel(publishedPdfList);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishedPdfList)) {
				publishedPdfList = (PublishedPdfList)session.get(PublishedPdfListImpl.class,
						publishedPdfList.getPrimaryKeyObj());
			}

			if (publishedPdfList != null) {
				session.delete(publishedPdfList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishedPdfList != null) {
			clearCache(publishedPdfList);
		}

		return publishedPdfList;
	}

	@Override
	public PublishedPdfList updateImpl(
		com.ihg.brandstandards.db.model.PublishedPdfList publishedPdfList)
		throws SystemException {
		publishedPdfList = toUnwrappedModel(publishedPdfList);

		boolean isNew = publishedPdfList.isNew();

		PublishedPdfListModelImpl publishedPdfListModelImpl = (PublishedPdfListModelImpl)publishedPdfList;

		Session session = null;

		try {
			session = openSession();

			if (publishedPdfList.isNew()) {
				session.save(publishedPdfList);

				publishedPdfList.setNew(false);
			}
			else {
				session.merge(publishedPdfList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublishedPdfListModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPublishId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);

				args = new Object[] { publishedPdfListModelImpl.getPublishId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHID,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCHAINCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPdfChainCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFCHAINCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCHAINCODE,
					args);

				args = new Object[] { publishedPdfListModelImpl.getPdfChainCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFCHAINCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCHAINCODE,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCTRYCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPdfCtryCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFCTRYCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCTRYCODE,
					args);

				args = new Object[] { publishedPdfListModelImpl.getPdfCtryCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFCTRYCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFCTRYCODE,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPdfFileName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFFILENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAME,
					args);

				args = new Object[] { publishedPdfListModelImpl.getPdfFileName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFFILENAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAME,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILEURLTEXT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPdfFileURLText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFFILEURLTEXT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILEURLTEXT,
					args);

				args = new Object[] {
						publishedPdfListModelImpl.getPdfFileURLText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFFILEURLTEXT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILEURLTEXT,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAMEANDURL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPdfFileName(),
						publishedPdfListModelImpl.getOriginalPdfFileURLText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFFILENAMEANDURL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAMEANDURL,
					args);

				args = new Object[] {
						publishedPdfListModelImpl.getPdfFileName(),
						publishedPdfListModelImpl.getPdfFileURLText()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFFILENAMEANDURL,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFFILENAMEANDURL,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFMANUALPARAMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPublishId(),
						publishedPdfListModelImpl.getOriginalPdfCtryCode(),
						publishedPdfListModelImpl.getOriginalPdfLocaleCode(),
						publishedPdfListModelImpl.getOriginalPdfBuildType(),
						publishedPdfListModelImpl.getOriginalPageSizeOrientationType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFMANUALPARAMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFMANUALPARAMS,
					args);

				args = new Object[] {
						publishedPdfListModelImpl.getPublishId(),
						publishedPdfListModelImpl.getPdfCtryCode(),
						publishedPdfListModelImpl.getPdfLocaleCode(),
						publishedPdfListModelImpl.getPdfBuildType(),
						publishedPdfListModelImpl.getPageSizeOrientationType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PDFMANUALPARAMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PDFMANUALPARAMS,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPDFMANUALPARAMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPublishId(),
						publishedPdfListModelImpl.getOriginalPdfCtryCode(),
						publishedPdfListModelImpl.getOriginalPdfBuildType(),
						publishedPdfListModelImpl.getOriginalPageSizeOrientationType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHPDFMANUALPARAMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPDFMANUALPARAMS,
					args);

				args = new Object[] {
						publishedPdfListModelImpl.getPublishId(),
						publishedPdfListModelImpl.getPdfCtryCode(),
						publishedPdfListModelImpl.getPdfBuildType(),
						publishedPdfListModelImpl.getPageSizeOrientationType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHPDFMANUALPARAMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPDFMANUALPARAMS,
					args);
			}

			if ((publishedPdfListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHEDPDFPARAMS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishedPdfListModelImpl.getOriginalPublishId(),
						publishedPdfListModelImpl.getOriginalPdfCtryCode(),
						publishedPdfListModelImpl.getOriginalPdfBuildType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHEDPDFPARAMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHEDPDFPARAMS,
					args);

				args = new Object[] {
						publishedPdfListModelImpl.getPublishId(),
						publishedPdfListModelImpl.getPdfCtryCode(),
						publishedPdfListModelImpl.getPdfBuildType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHEDPDFPARAMS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHEDPDFPARAMS,
					args);
			}
		}

		EntityCacheUtil.putResult(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
			PublishedPdfListImpl.class, publishedPdfList.getPrimaryKey(),
			publishedPdfList);

		clearUniqueFindersCache(publishedPdfList);
		cacheUniqueFindersCache(publishedPdfList);

		return publishedPdfList;
	}

	protected PublishedPdfList toUnwrappedModel(
		PublishedPdfList publishedPdfList) {
		if (publishedPdfList instanceof PublishedPdfListImpl) {
			return publishedPdfList;
		}

		PublishedPdfListImpl publishedPdfListImpl = new PublishedPdfListImpl();

		publishedPdfListImpl.setNew(publishedPdfList.isNew());
		publishedPdfListImpl.setPrimaryKey(publishedPdfList.getPrimaryKey());

		publishedPdfListImpl.setPdfId(publishedPdfList.getPdfId());
		publishedPdfListImpl.setPdfChainCode(publishedPdfList.getPdfChainCode());
		publishedPdfListImpl.setPdfCtryCode(publishedPdfList.getPdfCtryCode());
		publishedPdfListImpl.setPdfBuildType(publishedPdfList.getPdfBuildType());
		publishedPdfListImpl.setPdfYearNumber(publishedPdfList.getPdfYearNumber());
		publishedPdfListImpl.setPdfLocaleCode(publishedPdfList.getPdfLocaleCode());
		publishedPdfListImpl.setPdfVersionNumber(publishedPdfList.getPdfVersionNumber());
		publishedPdfListImpl.setPdfFileName(publishedPdfList.getPdfFileName());
		publishedPdfListImpl.setPdfFileURLText(publishedPdfList.getPdfFileURLText());
		publishedPdfListImpl.setPublishId(publishedPdfList.getPublishId());
		publishedPdfListImpl.setPageSizeOrientationType(publishedPdfList.getPageSizeOrientationType());
		publishedPdfListImpl.setCreatedBy(publishedPdfList.getCreatedBy());
		publishedPdfListImpl.setCreatedDate(publishedPdfList.getCreatedDate());
		publishedPdfListImpl.setUpdatedBy(publishedPdfList.getUpdatedBy());
		publishedPdfListImpl.setUpdatedDate(publishedPdfList.getUpdatedDate());

		return publishedPdfListImpl;
	}

	/**
	 * Returns the published pdf list with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the published pdf list
	 * @return the published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishedPdfListException, SystemException {
		PublishedPdfList publishedPdfList = fetchByPrimaryKey(primaryKey);

		if (publishedPdfList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishedPdfListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishedPdfList;
	}

	/**
	 * Returns the published pdf list with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishedPdfListException} if it could not be found.
	 *
	 * @param pdfId the primary key of the published pdf list
	 * @return the published pdf list
	 * @throws com.ihg.brandstandards.db.NoSuchPublishedPdfListException if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList findByPrimaryKey(long pdfId)
		throws NoSuchPublishedPdfListException, SystemException {
		return findByPrimaryKey((Serializable)pdfId);
	}

	/**
	 * Returns the published pdf list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the published pdf list
	 * @return the published pdf list, or <code>null</code> if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishedPdfList publishedPdfList = (PublishedPdfList)EntityCacheUtil.getResult(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
				PublishedPdfListImpl.class, primaryKey);

		if (publishedPdfList == _nullPublishedPdfList) {
			return null;
		}

		if (publishedPdfList == null) {
			Session session = null;

			try {
				session = openSession();

				publishedPdfList = (PublishedPdfList)session.get(PublishedPdfListImpl.class,
						primaryKey);

				if (publishedPdfList != null) {
					cacheResult(publishedPdfList);
				}
				else {
					EntityCacheUtil.putResult(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
						PublishedPdfListImpl.class, primaryKey,
						_nullPublishedPdfList);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishedPdfListModelImpl.ENTITY_CACHE_ENABLED,
					PublishedPdfListImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishedPdfList;
	}

	/**
	 * Returns the published pdf list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param pdfId the primary key of the published pdf list
	 * @return the published pdf list, or <code>null</code> if a published pdf list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishedPdfList fetchByPrimaryKey(long pdfId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)pdfId);
	}

	/**
	 * Returns all the published pdf lists.
	 *
	 * @return the published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the published pdf lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @return the range of published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the published pdf lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishedPdfListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of published pdf lists
	 * @param end the upper bound of the range of published pdf lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of published pdf lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishedPdfList> findAll(int start, int end,
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

		List<PublishedPdfList> list = (List<PublishedPdfList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHEDPDFLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHEDPDFLIST;

				if (pagination) {
					sql = sql.concat(PublishedPdfListModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishedPdfList>(list);
				}
				else {
					list = (List<PublishedPdfList>)QueryUtil.list(q,
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
	 * Removes all the published pdf lists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishedPdfList publishedPdfList : findAll()) {
			remove(publishedPdfList);
		}
	}

	/**
	 * Returns the number of published pdf lists.
	 *
	 * @return the number of published pdf lists
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHEDPDFLIST);

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
	 * Initializes the published pdf list persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishedPdfList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishedPdfList>> listenersList = new ArrayList<ModelListener<PublishedPdfList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishedPdfList>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublishedPdfListImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHEDPDFLIST = "SELECT publishedPdfList FROM PublishedPdfList publishedPdfList";
	private static final String _SQL_SELECT_PUBLISHEDPDFLIST_WHERE = "SELECT publishedPdfList FROM PublishedPdfList publishedPdfList WHERE ";
	private static final String _SQL_COUNT_PUBLISHEDPDFLIST = "SELECT COUNT(publishedPdfList) FROM PublishedPdfList publishedPdfList";
	private static final String _SQL_COUNT_PUBLISHEDPDFLIST_WHERE = "SELECT COUNT(publishedPdfList) FROM PublishedPdfList publishedPdfList WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishedPdfList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishedPdfList exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PublishedPdfList exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishedPdfListPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"pdfId", "pdfChainCode", "pdfCtryCode", "pdfBuildType",
				"pdfYearNumber", "pdfLocaleCode", "pdfVersionNumber",
				"pdfFileName", "pdfFileURLText", "publishId",
				"pageSizeOrientationType", "createdBy", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static PublishedPdfList _nullPublishedPdfList = new PublishedPdfListImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishedPdfList> toCacheModel() {
				return _nullPublishedPdfListCacheModel;
			}
		};

	private static CacheModel<PublishedPdfList> _nullPublishedPdfListCacheModel = new CacheModel<PublishedPdfList>() {
			@Override
			public PublishedPdfList toEntityModel() {
				return _nullPublishedPdfList;
			}
		};
}