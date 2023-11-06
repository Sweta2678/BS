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

import com.ihg.brandstandards.db.NoSuchPublishTaxonomyException;
import com.ihg.brandstandards.db.model.PublishTaxonomy;
import com.ihg.brandstandards.db.model.impl.PublishTaxonomyImpl;
import com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl;

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
 * The persistence implementation for the publish taxonomy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see PublishTaxonomyPersistence
 * @see PublishTaxonomyUtil
 * @generated
 */
public class PublishTaxonomyPersistenceImpl extends BasePersistenceImpl<PublishTaxonomy>
	implements PublishTaxonomyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublishTaxonomyUtil} to access the publish taxonomy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublishTaxonomyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PUBLISHTAXID = new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBypublishTaxId", new String[] { Long.class.getName() },
			PublishTaxonomyModelImpl.TAXID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHTAXID = new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypublishTaxId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the publish taxonomy where taxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchPublishTaxonomyException} if it could not be found.
	 *
	 * @param taxId the tax ID
	 * @return the matching publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy findBypublishTaxId(long taxId)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = fetchBypublishTaxId(taxId);

		if (publishTaxonomy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taxId=");
			msg.append(taxId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchPublishTaxonomyException(msg.toString());
		}

		return publishTaxonomy;
	}

	/**
	 * Returns the publish taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taxId the tax ID
	 * @return the matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchBypublishTaxId(long taxId)
		throws SystemException {
		return fetchBypublishTaxId(taxId, true);
	}

	/**
	 * Returns the publish taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taxId the tax ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchBypublishTaxId(long taxId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { taxId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
					finderArgs, this);
		}

		if (result instanceof PublishTaxonomy) {
			PublishTaxonomy publishTaxonomy = (PublishTaxonomy)result;

			if ((taxId != publishTaxonomy.getTaxId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_PUBLISHTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHTAXID_TAXID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxId);

				List<PublishTaxonomy> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"PublishTaxonomyPersistenceImpl.fetchBypublishTaxId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					PublishTaxonomy publishTaxonomy = list.get(0);

					result = publishTaxonomy;

					cacheResult(publishTaxonomy);

					if ((publishTaxonomy.getTaxId() != taxId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
							finderArgs, publishTaxonomy);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
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
			return (PublishTaxonomy)result;
		}
	}

	/**
	 * Removes the publish taxonomy where taxId = &#63; from the database.
	 *
	 * @param taxId the tax ID
	 * @return the publish taxonomy that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy removeBypublishTaxId(long taxId)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = findBypublishTaxId(taxId);

		return remove(publishTaxonomy);
	}

	/**
	 * Returns the number of publish taxonomies where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @return the number of matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublishTaxId(long taxId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHTAXID;

		Object[] finderArgs = new Object[] { taxId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHTAXID_TAXID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxId);

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

	private static final String _FINDER_COLUMN_PUBLISHTAXID_TAXID_2 = "publishTaxonomy.taxId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHPARENTID =
		new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBypublishParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPARENTID =
		new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypublishParentId",
			new String[] { Long.class.getName() },
			PublishTaxonomyModelImpl.PUBLISHPARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PUBLISHPARENTID = new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBypublishParentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the publish taxonomies where publishParentId = &#63;.
	 *
	 * @param publishParentId the publish parent ID
	 * @return the matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findBypublishParentId(long publishParentId)
		throws SystemException {
		return findBypublishParentId(publishParentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publish taxonomies where publishParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishParentId the publish parent ID
	 * @param start the lower bound of the range of publish taxonomies
	 * @param end the upper bound of the range of publish taxonomies (not inclusive)
	 * @return the range of matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findBypublishParentId(long publishParentId,
		int start, int end) throws SystemException {
		return findBypublishParentId(publishParentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish taxonomies where publishParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publishParentId the publish parent ID
	 * @param start the lower bound of the range of publish taxonomies
	 * @param end the upper bound of the range of publish taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findBypublishParentId(long publishParentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPARENTID;
			finderArgs = new Object[] { publishParentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PUBLISHPARENTID;
			finderArgs = new Object[] {
					publishParentId,
					
					start, end, orderByComparator
				};
		}

		List<PublishTaxonomy> list = (List<PublishTaxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishTaxonomy publishTaxonomy : list) {
				if ((publishParentId != publishTaxonomy.getPublishParentId())) {
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

			query.append(_SQL_SELECT_PUBLISHTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHPARENTID_PUBLISHPARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishTaxonomyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishParentId);

				if (!pagination) {
					list = (List<PublishTaxonomy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishTaxonomy>(list);
				}
				else {
					list = (List<PublishTaxonomy>)QueryUtil.list(q,
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
	 * Returns the first publish taxonomy in the ordered set where publishParentId = &#63;.
	 *
	 * @param publishParentId the publish parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy findBypublishParentId_First(long publishParentId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = fetchBypublishParentId_First(publishParentId,
				orderByComparator);

		if (publishTaxonomy != null) {
			return publishTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishParentId=");
		msg.append(publishParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishTaxonomyException(msg.toString());
	}

	/**
	 * Returns the first publish taxonomy in the ordered set where publishParentId = &#63;.
	 *
	 * @param publishParentId the publish parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchBypublishParentId_First(long publishParentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishTaxonomy> list = findBypublishParentId(publishParentId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publish taxonomy in the ordered set where publishParentId = &#63;.
	 *
	 * @param publishParentId the publish parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy findBypublishParentId_Last(long publishParentId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = fetchBypublishParentId_Last(publishParentId,
				orderByComparator);

		if (publishTaxonomy != null) {
			return publishTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("publishParentId=");
		msg.append(publishParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishTaxonomyException(msg.toString());
	}

	/**
	 * Returns the last publish taxonomy in the ordered set where publishParentId = &#63;.
	 *
	 * @param publishParentId the publish parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchBypublishParentId_Last(long publishParentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBypublishParentId(publishParentId);

		if (count == 0) {
			return null;
		}

		List<PublishTaxonomy> list = findBypublishParentId(publishParentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publish taxonomies before and after the current publish taxonomy in the ordered set where publishParentId = &#63;.
	 *
	 * @param publishTaxId the primary key of the current publish taxonomy
	 * @param publishParentId the publish parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy[] findBypublishParentId_PrevAndNext(
		long publishTaxId, long publishParentId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = findByPrimaryKey(publishTaxId);

		Session session = null;

		try {
			session = openSession();

			PublishTaxonomy[] array = new PublishTaxonomyImpl[3];

			array[0] = getBypublishParentId_PrevAndNext(session,
					publishTaxonomy, publishParentId, orderByComparator, true);

			array[1] = publishTaxonomy;

			array[2] = getBypublishParentId_PrevAndNext(session,
					publishTaxonomy, publishParentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishTaxonomy getBypublishParentId_PrevAndNext(
		Session session, PublishTaxonomy publishTaxonomy, long publishParentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHTAXONOMY_WHERE);

		query.append(_FINDER_COLUMN_PUBLISHPARENTID_PUBLISHPARENTID_2);

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
			query.append(PublishTaxonomyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(publishParentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishTaxonomy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishTaxonomy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publish taxonomies where publishParentId = &#63; from the database.
	 *
	 * @param publishParentId the publish parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBypublishParentId(long publishParentId)
		throws SystemException {
		for (PublishTaxonomy publishTaxonomy : findBypublishParentId(
				publishParentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishTaxonomy);
		}
	}

	/**
	 * Returns the number of publish taxonomies where publishParentId = &#63;.
	 *
	 * @param publishParentId the publish parent ID
	 * @return the number of matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBypublishParentId(long publishParentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PUBLISHPARENTID;

		Object[] finderArgs = new Object[] { publishParentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_PUBLISHPARENTID_PUBLISHPARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(publishParentId);

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

	private static final String _FINDER_COLUMN_PUBLISHPARENTID_PUBLISHPARENTID_2 =
		"publishTaxonomy.publishParentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycreatorId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			PublishTaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreatorId",
			new String[] { String.class.getName() },
			PublishTaxonomyModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATORID = new FinderPath(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreatorId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the publish taxonomies where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findBycreatorId(String creatorId)
		throws SystemException {
		return findBycreatorId(creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the publish taxonomies where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of publish taxonomies
	 * @param end the upper bound of the range of publish taxonomies (not inclusive)
	 * @return the range of matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findBycreatorId(String creatorId, int start,
		int end) throws SystemException {
		return findBycreatorId(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish taxonomies where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of publish taxonomies
	 * @param end the upper bound of the range of publish taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findBycreatorId(String creatorId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID;
			finderArgs = new Object[] { creatorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORID;
			finderArgs = new Object[] { creatorId, start, end, orderByComparator };
		}

		List<PublishTaxonomy> list = (List<PublishTaxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PublishTaxonomy publishTaxonomy : list) {
				if (!Validator.equals(creatorId, publishTaxonomy.getCreatorId())) {
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

			query.append(_SQL_SELECT_PUBLISHTAXONOMY_WHERE);

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_CREATORID_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATORID_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_CREATORID_CREATORID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PublishTaxonomyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatorId) {
					qPos.add(creatorId);
				}

				if (!pagination) {
					list = (List<PublishTaxonomy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishTaxonomy>(list);
				}
				else {
					list = (List<PublishTaxonomy>)QueryUtil.list(q,
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
	 * Returns the first publish taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy findBycreatorId_First(String creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = fetchBycreatorId_First(creatorId,
				orderByComparator);

		if (publishTaxonomy != null) {
			return publishTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishTaxonomyException(msg.toString());
	}

	/**
	 * Returns the first publish taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchBycreatorId_First(String creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PublishTaxonomy> list = findBycreatorId(creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publish taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy findBycreatorId_Last(String creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = fetchBycreatorId_Last(creatorId,
				orderByComparator);

		if (publishTaxonomy != null) {
			return publishTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPublishTaxonomyException(msg.toString());
	}

	/**
	 * Returns the last publish taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publish taxonomy, or <code>null</code> if a matching publish taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchBycreatorId_Last(String creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreatorId(creatorId);

		if (count == 0) {
			return null;
		}

		List<PublishTaxonomy> list = findBycreatorId(creatorId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publish taxonomies before and after the current publish taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param publishTaxId the primary key of the current publish taxonomy
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy[] findBycreatorId_PrevAndNext(long publishTaxId,
		String creatorId, OrderByComparator orderByComparator)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = findByPrimaryKey(publishTaxId);

		Session session = null;

		try {
			session = openSession();

			PublishTaxonomy[] array = new PublishTaxonomyImpl[3];

			array[0] = getBycreatorId_PrevAndNext(session, publishTaxonomy,
					creatorId, orderByComparator, true);

			array[1] = publishTaxonomy;

			array[2] = getBycreatorId_PrevAndNext(session, publishTaxonomy,
					creatorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublishTaxonomy getBycreatorId_PrevAndNext(Session session,
		PublishTaxonomy publishTaxonomy, String creatorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PUBLISHTAXONOMY_WHERE);

		boolean bindCreatorId = false;

		if (creatorId == null) {
			query.append(_FINDER_COLUMN_CREATORID_CREATORID_1);
		}
		else if (creatorId.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CREATORID_CREATORID_3);
		}
		else {
			bindCreatorId = true;

			query.append(_FINDER_COLUMN_CREATORID_CREATORID_2);
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
			query.append(PublishTaxonomyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCreatorId) {
			qPos.add(creatorId);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(publishTaxonomy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PublishTaxonomy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publish taxonomies where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycreatorId(String creatorId) throws SystemException {
		for (PublishTaxonomy publishTaxonomy : findBycreatorId(creatorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(publishTaxonomy);
		}
	}

	/**
	 * Returns the number of publish taxonomies where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycreatorId(String creatorId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATORID;

		Object[] finderArgs = new Object[] { creatorId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PUBLISHTAXONOMY_WHERE);

			boolean bindCreatorId = false;

			if (creatorId == null) {
				query.append(_FINDER_COLUMN_CREATORID_CREATORID_1);
			}
			else if (creatorId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CREATORID_CREATORID_3);
			}
			else {
				bindCreatorId = true;

				query.append(_FINDER_COLUMN_CREATORID_CREATORID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCreatorId) {
					qPos.add(creatorId);
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

	private static final String _FINDER_COLUMN_CREATORID_CREATORID_1 = "publishTaxonomy.creatorId IS NULL";
	private static final String _FINDER_COLUMN_CREATORID_CREATORID_2 = "publishTaxonomy.creatorId = ?";
	private static final String _FINDER_COLUMN_CREATORID_CREATORID_3 = "(publishTaxonomy.creatorId IS NULL OR publishTaxonomy.creatorId = '')";

	public PublishTaxonomyPersistenceImpl() {
		setModelClass(PublishTaxonomy.class);
	}

	/**
	 * Caches the publish taxonomy in the entity cache if it is enabled.
	 *
	 * @param publishTaxonomy the publish taxonomy
	 */
	@Override
	public void cacheResult(PublishTaxonomy publishTaxonomy) {
		EntityCacheUtil.putResult(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyImpl.class, publishTaxonomy.getPrimaryKey(),
			publishTaxonomy);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
			new Object[] { publishTaxonomy.getTaxId() }, publishTaxonomy);

		publishTaxonomy.resetOriginalValues();
	}

	/**
	 * Caches the publish taxonomies in the entity cache if it is enabled.
	 *
	 * @param publishTaxonomies the publish taxonomies
	 */
	@Override
	public void cacheResult(List<PublishTaxonomy> publishTaxonomies) {
		for (PublishTaxonomy publishTaxonomy : publishTaxonomies) {
			if (EntityCacheUtil.getResult(
						PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
						PublishTaxonomyImpl.class,
						publishTaxonomy.getPrimaryKey()) == null) {
				cacheResult(publishTaxonomy);
			}
			else {
				publishTaxonomy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publish taxonomies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublishTaxonomyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublishTaxonomyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publish taxonomy.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublishTaxonomy publishTaxonomy) {
		EntityCacheUtil.removeResult(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyImpl.class, publishTaxonomy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(publishTaxonomy);
	}

	@Override
	public void clearCache(List<PublishTaxonomy> publishTaxonomies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PublishTaxonomy publishTaxonomy : publishTaxonomies) {
			EntityCacheUtil.removeResult(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
				PublishTaxonomyImpl.class, publishTaxonomy.getPrimaryKey());

			clearUniqueFindersCache(publishTaxonomy);
		}
	}

	protected void cacheUniqueFindersCache(PublishTaxonomy publishTaxonomy) {
		if (publishTaxonomy.isNew()) {
			Object[] args = new Object[] { publishTaxonomy.getTaxId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID, args,
				publishTaxonomy);
		}
		else {
			PublishTaxonomyModelImpl publishTaxonomyModelImpl = (PublishTaxonomyModelImpl)publishTaxonomy;

			if ((publishTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PUBLISHTAXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { publishTaxonomy.getTaxId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID,
					args, publishTaxonomy);
			}
		}
	}

	protected void clearUniqueFindersCache(PublishTaxonomy publishTaxonomy) {
		PublishTaxonomyModelImpl publishTaxonomyModelImpl = (PublishTaxonomyModelImpl)publishTaxonomy;

		Object[] args = new Object[] { publishTaxonomy.getTaxId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID, args);

		if ((publishTaxonomyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PUBLISHTAXID.getColumnBitmask()) != 0) {
			args = new Object[] { publishTaxonomyModelImpl.getOriginalTaxId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHTAXID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PUBLISHTAXID, args);
		}
	}

	/**
	 * Creates a new publish taxonomy with the primary key. Does not add the publish taxonomy to the database.
	 *
	 * @param publishTaxId the primary key for the new publish taxonomy
	 * @return the new publish taxonomy
	 */
	@Override
	public PublishTaxonomy create(long publishTaxId) {
		PublishTaxonomy publishTaxonomy = new PublishTaxonomyImpl();

		publishTaxonomy.setNew(true);
		publishTaxonomy.setPrimaryKey(publishTaxId);

		return publishTaxonomy;
	}

	/**
	 * Removes the publish taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishTaxId the primary key of the publish taxonomy
	 * @return the publish taxonomy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy remove(long publishTaxId)
		throws NoSuchPublishTaxonomyException, SystemException {
		return remove((Serializable)publishTaxId);
	}

	/**
	 * Removes the publish taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publish taxonomy
	 * @return the publish taxonomy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy remove(Serializable primaryKey)
		throws NoSuchPublishTaxonomyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PublishTaxonomy publishTaxonomy = (PublishTaxonomy)session.get(PublishTaxonomyImpl.class,
					primaryKey);

			if (publishTaxonomy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublishTaxonomyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publishTaxonomy);
		}
		catch (NoSuchPublishTaxonomyException nsee) {
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
	protected PublishTaxonomy removeImpl(PublishTaxonomy publishTaxonomy)
		throws SystemException {
		publishTaxonomy = toUnwrappedModel(publishTaxonomy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publishTaxonomy)) {
				publishTaxonomy = (PublishTaxonomy)session.get(PublishTaxonomyImpl.class,
						publishTaxonomy.getPrimaryKeyObj());
			}

			if (publishTaxonomy != null) {
				session.delete(publishTaxonomy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publishTaxonomy != null) {
			clearCache(publishTaxonomy);
		}

		return publishTaxonomy;
	}

	@Override
	public PublishTaxonomy updateImpl(
		com.ihg.brandstandards.db.model.PublishTaxonomy publishTaxonomy)
		throws SystemException {
		publishTaxonomy = toUnwrappedModel(publishTaxonomy);

		boolean isNew = publishTaxonomy.isNew();

		PublishTaxonomyModelImpl publishTaxonomyModelImpl = (PublishTaxonomyModelImpl)publishTaxonomy;

		Session session = null;

		try {
			session = openSession();

			if (publishTaxonomy.isNew()) {
				session.save(publishTaxonomy);

				publishTaxonomy.setNew(false);
			}
			else {
				session.merge(publishTaxonomy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PublishTaxonomyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((publishTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishTaxonomyModelImpl.getOriginalPublishParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPARENTID,
					args);

				args = new Object[] {
						publishTaxonomyModelImpl.getPublishParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PUBLISHPARENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PUBLISHPARENTID,
					args);
			}

			if ((publishTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						publishTaxonomyModelImpl.getOriginalCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);

				args = new Object[] { publishTaxonomyModelImpl.getCreatorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);
			}
		}

		EntityCacheUtil.putResult(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			PublishTaxonomyImpl.class, publishTaxonomy.getPrimaryKey(),
			publishTaxonomy);

		clearUniqueFindersCache(publishTaxonomy);
		cacheUniqueFindersCache(publishTaxonomy);

		return publishTaxonomy;
	}

	protected PublishTaxonomy toUnwrappedModel(PublishTaxonomy publishTaxonomy) {
		if (publishTaxonomy instanceof PublishTaxonomyImpl) {
			return publishTaxonomy;
		}

		PublishTaxonomyImpl publishTaxonomyImpl = new PublishTaxonomyImpl();

		publishTaxonomyImpl.setNew(publishTaxonomy.isNew());
		publishTaxonomyImpl.setPrimaryKey(publishTaxonomy.getPrimaryKey());

		publishTaxonomyImpl.setPublishTaxId(publishTaxonomy.getPublishTaxId());
		publishTaxonomyImpl.setPublishId(publishTaxonomy.getPublishId());
		publishTaxonomyImpl.setTaxId(publishTaxonomy.getTaxId());
		publishTaxonomyImpl.setPublishParentId(publishTaxonomy.getPublishParentId());
		publishTaxonomyImpl.setTitle(publishTaxonomy.getTitle());
		publishTaxonomyImpl.setDesc(publishTaxonomy.getDesc());
		publishTaxonomyImpl.setImageLoc(publishTaxonomy.getImageLoc());
		publishTaxonomyImpl.setCreatedBy(publishTaxonomy.getCreatedBy());
		publishTaxonomyImpl.setPosition(publishTaxonomy.getPosition());
		publishTaxonomyImpl.setCreatorId(publishTaxonomy.getCreatorId());
		publishTaxonomyImpl.setCreatedDate(publishTaxonomy.getCreatedDate());
		publishTaxonomyImpl.setUpdatedBy(publishTaxonomy.getUpdatedBy());
		publishTaxonomyImpl.setUpdatedDate(publishTaxonomy.getUpdatedDate());

		return publishTaxonomyImpl;
	}

	/**
	 * Returns the publish taxonomy with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish taxonomy
	 * @return the publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublishTaxonomyException, SystemException {
		PublishTaxonomy publishTaxonomy = fetchByPrimaryKey(primaryKey);

		if (publishTaxonomy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublishTaxonomyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publishTaxonomy;
	}

	/**
	 * Returns the publish taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchPublishTaxonomyException} if it could not be found.
	 *
	 * @param publishTaxId the primary key of the publish taxonomy
	 * @return the publish taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchPublishTaxonomyException if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy findByPrimaryKey(long publishTaxId)
		throws NoSuchPublishTaxonomyException, SystemException {
		return findByPrimaryKey((Serializable)publishTaxId);
	}

	/**
	 * Returns the publish taxonomy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publish taxonomy
	 * @return the publish taxonomy, or <code>null</code> if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PublishTaxonomy publishTaxonomy = (PublishTaxonomy)EntityCacheUtil.getResult(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
				PublishTaxonomyImpl.class, primaryKey);

		if (publishTaxonomy == _nullPublishTaxonomy) {
			return null;
		}

		if (publishTaxonomy == null) {
			Session session = null;

			try {
				session = openSession();

				publishTaxonomy = (PublishTaxonomy)session.get(PublishTaxonomyImpl.class,
						primaryKey);

				if (publishTaxonomy != null) {
					cacheResult(publishTaxonomy);
				}
				else {
					EntityCacheUtil.putResult(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
						PublishTaxonomyImpl.class, primaryKey,
						_nullPublishTaxonomy);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublishTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
					PublishTaxonomyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publishTaxonomy;
	}

	/**
	 * Returns the publish taxonomy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishTaxId the primary key of the publish taxonomy
	 * @return the publish taxonomy, or <code>null</code> if a publish taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PublishTaxonomy fetchByPrimaryKey(long publishTaxId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishTaxId);
	}

	/**
	 * Returns all the publish taxonomies.
	 *
	 * @return the publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publish taxonomies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish taxonomies
	 * @param end the upper bound of the range of publish taxonomies (not inclusive)
	 * @return the range of publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publish taxonomies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.PublishTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publish taxonomies
	 * @param end the upper bound of the range of publish taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publish taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PublishTaxonomy> findAll(int start, int end,
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

		List<PublishTaxonomy> list = (List<PublishTaxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHTAXONOMY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHTAXONOMY;

				if (pagination) {
					sql = sql.concat(PublishTaxonomyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PublishTaxonomy>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PublishTaxonomy>(list);
				}
				else {
					list = (List<PublishTaxonomy>)QueryUtil.list(q,
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
	 * Removes all the publish taxonomies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PublishTaxonomy publishTaxonomy : findAll()) {
			remove(publishTaxonomy);
		}
	}

	/**
	 * Returns the number of publish taxonomies.
	 *
	 * @return the number of publish taxonomies
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHTAXONOMY);

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
	 * Initializes the publish taxonomy persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.PublishTaxonomy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PublishTaxonomy>> listenersList = new ArrayList<ModelListener<PublishTaxonomy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PublishTaxonomy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublishTaxonomyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHTAXONOMY = "SELECT publishTaxonomy FROM PublishTaxonomy publishTaxonomy";
	private static final String _SQL_SELECT_PUBLISHTAXONOMY_WHERE = "SELECT publishTaxonomy FROM PublishTaxonomy publishTaxonomy WHERE ";
	private static final String _SQL_COUNT_PUBLISHTAXONOMY = "SELECT COUNT(publishTaxonomy) FROM PublishTaxonomy publishTaxonomy";
	private static final String _SQL_COUNT_PUBLISHTAXONOMY_WHERE = "SELECT COUNT(publishTaxonomy) FROM PublishTaxonomy publishTaxonomy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publishTaxonomy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PublishTaxonomy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PublishTaxonomy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublishTaxonomyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishTaxId", "publishId", "taxId", "publishParentId", "title",
				"desc", "imageLoc", "createdBy", "position", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static PublishTaxonomy _nullPublishTaxonomy = new PublishTaxonomyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PublishTaxonomy> toCacheModel() {
				return _nullPublishTaxonomyCacheModel;
			}
		};

	private static CacheModel<PublishTaxonomy> _nullPublishTaxonomyCacheModel = new CacheModel<PublishTaxonomy>() {
			@Override
			public PublishTaxonomy toEntityModel() {
				return _nullPublishTaxonomy;
			}
		};
}