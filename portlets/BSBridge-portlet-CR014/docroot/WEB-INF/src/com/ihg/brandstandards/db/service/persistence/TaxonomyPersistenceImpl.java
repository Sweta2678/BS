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

import com.ihg.brandstandards.db.NoSuchTaxonomyException;
import com.ihg.brandstandards.db.model.Taxonomy;
import com.ihg.brandstandards.db.model.impl.TaxonomyImpl;
import com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl;

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
 * The persistence implementation for the taxonomy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyPersistence
 * @see TaxonomyUtil
 * @generated
 */
public class TaxonomyPersistenceImpl extends BasePersistenceImpl<Taxonomy>
	implements TaxonomyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxonomyUtil} to access the taxonomy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxonomyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, TaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, TaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_TAXID = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, TaxonomyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBytaxId",
			new String[] { Long.class.getName() },
			TaxonomyModelImpl.TAXID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAXID = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytaxId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the taxonomy where taxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyException} if it could not be found.
	 *
	 * @param taxId the tax ID
	 * @return the matching taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy findBytaxId(long taxId)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = fetchBytaxId(taxId);

		if (taxonomy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taxId=");
			msg.append(taxId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTaxonomyException(msg.toString());
		}

		return taxonomy;
	}

	/**
	 * Returns the taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taxId the tax ID
	 * @return the matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchBytaxId(long taxId) throws SystemException {
		return fetchBytaxId(taxId, true);
	}

	/**
	 * Returns the taxonomy where taxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taxId the tax ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchBytaxId(long taxId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { taxId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TAXID,
					finderArgs, this);
		}

		if (result instanceof Taxonomy) {
			Taxonomy taxonomy = (Taxonomy)result;

			if ((taxId != taxonomy.getTaxId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_TAXID_TAXID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxId);

				List<Taxonomy> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TaxonomyPersistenceImpl.fetchBytaxId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Taxonomy taxonomy = list.get(0);

					result = taxonomy;

					cacheResult(taxonomy);

					if ((taxonomy.getTaxId() != taxId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID,
							finderArgs, taxonomy);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXID,
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
			return (Taxonomy)result;
		}
	}

	/**
	 * Removes the taxonomy where taxId = &#63; from the database.
	 *
	 * @param taxId the tax ID
	 * @return the taxonomy that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy removeBytaxId(long taxId)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = findBytaxId(taxId);

		return remove(taxonomy);
	}

	/**
	 * Returns the number of taxonomies where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @return the number of matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBytaxId(long taxId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAXID;

		Object[] finderArgs = new Object[] { taxId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_TAXID_TAXID_2);

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

	private static final String _FINDER_COLUMN_TAXID_TAXID_2 = "taxonomy.taxId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, TaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByparentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
		new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, TaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByparentId",
			new String[] { Long.class.getName() },
			TaxonomyModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByparentId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the taxonomies where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findByparentId(long parentId)
		throws SystemException {
		return findByparentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the taxonomies where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of taxonomies
	 * @param end the upper bound of the range of taxonomies (not inclusive)
	 * @return the range of matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findByparentId(long parentId, int start, int end)
		throws SystemException {
		return findByparentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the taxonomies where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of taxonomies
	 * @param end the upper bound of the range of taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findByparentId(long parentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
			finderArgs = new Object[] { parentId, start, end, orderByComparator };
		}

		List<Taxonomy> list = (List<Taxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Taxonomy taxonomy : list) {
				if ((parentId != taxonomy.getParentId())) {
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

			query.append(_SQL_SELECT_TAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TaxonomyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Taxonomy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Taxonomy>(list);
				}
				else {
					list = (List<Taxonomy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first taxonomy in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy findByparentId_First(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = fetchByparentId_First(parentId, orderByComparator);

		if (taxonomy != null) {
			return taxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaxonomyException(msg.toString());
	}

	/**
	 * Returns the first taxonomy in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchByparentId_First(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Taxonomy> list = findByparentId(parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last taxonomy in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy findByparentId_Last(long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = fetchByparentId_Last(parentId, orderByComparator);

		if (taxonomy != null) {
			return taxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaxonomyException(msg.toString());
	}

	/**
	 * Returns the last taxonomy in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchByparentId_Last(long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByparentId(parentId);

		if (count == 0) {
			return null;
		}

		List<Taxonomy> list = findByparentId(parentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the taxonomies before and after the current taxonomy in the ordered set where parentId = &#63;.
	 *
	 * @param taxId the primary key of the current taxonomy
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy[] findByparentId_PrevAndNext(long taxId, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = findByPrimaryKey(taxId);

		Session session = null;

		try {
			session = openSession();

			Taxonomy[] array = new TaxonomyImpl[3];

			array[0] = getByparentId_PrevAndNext(session, taxonomy, parentId,
					orderByComparator, true);

			array[1] = taxonomy;

			array[2] = getByparentId_PrevAndNext(session, taxonomy, parentId,
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

	protected Taxonomy getByparentId_PrevAndNext(Session session,
		Taxonomy taxonomy, long parentId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAXONOMY_WHERE);

		query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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
			query.append(TaxonomyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(taxonomy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Taxonomy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the taxonomies where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByparentId(long parentId) throws SystemException {
		for (Taxonomy taxonomy : findByparentId(parentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(taxonomy);
		}
	}

	/**
	 * Returns the number of taxonomies where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByparentId(long parentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PARENTID;

		Object[] finderArgs = new Object[] { parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "taxonomy.parentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, TaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreatorId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, TaxonomyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreatorId",
			new String[] { String.class.getName() },
			TaxonomyModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATORID = new FinderPath(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreatorId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the taxonomies where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findBycreatorId(String creatorId)
		throws SystemException {
		return findBycreatorId(creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the taxonomies where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of taxonomies
	 * @param end the upper bound of the range of taxonomies (not inclusive)
	 * @return the range of matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findBycreatorId(String creatorId, int start, int end)
		throws SystemException {
		return findBycreatorId(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the taxonomies where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of taxonomies
	 * @param end the upper bound of the range of taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findBycreatorId(String creatorId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Taxonomy> list = (List<Taxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Taxonomy taxonomy : list) {
				if (!Validator.equals(creatorId, taxonomy.getCreatorId())) {
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

			query.append(_SQL_SELECT_TAXONOMY_WHERE);

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
				query.append(TaxonomyModelImpl.ORDER_BY_JPQL);
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
					list = (List<Taxonomy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Taxonomy>(list);
				}
				else {
					list = (List<Taxonomy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy findBycreatorId_First(String creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = fetchBycreatorId_First(creatorId, orderByComparator);

		if (taxonomy != null) {
			return taxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaxonomyException(msg.toString());
	}

	/**
	 * Returns the first taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchBycreatorId_First(String creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Taxonomy> list = findBycreatorId(creatorId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy findBycreatorId_Last(String creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = fetchBycreatorId_Last(creatorId, orderByComparator);

		if (taxonomy != null) {
			return taxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaxonomyException(msg.toString());
	}

	/**
	 * Returns the last taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching taxonomy, or <code>null</code> if a matching taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchBycreatorId_Last(String creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreatorId(creatorId);

		if (count == 0) {
			return null;
		}

		List<Taxonomy> list = findBycreatorId(creatorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the taxonomies before and after the current taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param taxId the primary key of the current taxonomy
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy[] findBycreatorId_PrevAndNext(long taxId, String creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = findByPrimaryKey(taxId);

		Session session = null;

		try {
			session = openSession();

			Taxonomy[] array = new TaxonomyImpl[3];

			array[0] = getBycreatorId_PrevAndNext(session, taxonomy, creatorId,
					orderByComparator, true);

			array[1] = taxonomy;

			array[2] = getBycreatorId_PrevAndNext(session, taxonomy, creatorId,
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

	protected Taxonomy getBycreatorId_PrevAndNext(Session session,
		Taxonomy taxonomy, String creatorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TAXONOMY_WHERE);

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
			query.append(TaxonomyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(taxonomy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Taxonomy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the taxonomies where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycreatorId(String creatorId) throws SystemException {
		for (Taxonomy taxonomy : findBycreatorId(creatorId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(taxonomy);
		}
	}

	/**
	 * Returns the number of taxonomies where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching taxonomies
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

			query.append(_SQL_COUNT_TAXONOMY_WHERE);

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

	private static final String _FINDER_COLUMN_CREATORID_CREATORID_1 = "taxonomy.creatorId IS NULL";
	private static final String _FINDER_COLUMN_CREATORID_CREATORID_2 = "taxonomy.creatorId = ?";
	private static final String _FINDER_COLUMN_CREATORID_CREATORID_3 = "(taxonomy.creatorId IS NULL OR taxonomy.creatorId = '')";

	public TaxonomyPersistenceImpl() {
		setModelClass(Taxonomy.class);
	}

	/**
	 * Caches the taxonomy in the entity cache if it is enabled.
	 *
	 * @param taxonomy the taxonomy
	 */
	@Override
	public void cacheResult(Taxonomy taxonomy) {
		EntityCacheUtil.putResult(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyImpl.class, taxonomy.getPrimaryKey(), taxonomy);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID,
			new Object[] { taxonomy.getTaxId() }, taxonomy);

		taxonomy.resetOriginalValues();
	}

	/**
	 * Caches the taxonomies in the entity cache if it is enabled.
	 *
	 * @param taxonomies the taxonomies
	 */
	@Override
	public void cacheResult(List<Taxonomy> taxonomies) {
		for (Taxonomy taxonomy : taxonomies) {
			if (EntityCacheUtil.getResult(
						TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyImpl.class, taxonomy.getPrimaryKey()) == null) {
				cacheResult(taxonomy);
			}
			else {
				taxonomy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all taxonomies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaxonomyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaxonomyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the taxonomy.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Taxonomy taxonomy) {
		EntityCacheUtil.removeResult(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyImpl.class, taxonomy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(taxonomy);
	}

	@Override
	public void clearCache(List<Taxonomy> taxonomies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Taxonomy taxonomy : taxonomies) {
			EntityCacheUtil.removeResult(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyImpl.class, taxonomy.getPrimaryKey());

			clearUniqueFindersCache(taxonomy);
		}
	}

	protected void cacheUniqueFindersCache(Taxonomy taxonomy) {
		if (taxonomy.isNew()) {
			Object[] args = new Object[] { taxonomy.getTaxId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAXID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID, args, taxonomy);
		}
		else {
			TaxonomyModelImpl taxonomyModelImpl = (TaxonomyModelImpl)taxonomy;

			if ((taxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TAXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { taxonomy.getTaxId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAXID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID, args,
					taxonomy);
			}
		}
	}

	protected void clearUniqueFindersCache(Taxonomy taxonomy) {
		TaxonomyModelImpl taxonomyModelImpl = (TaxonomyModelImpl)taxonomy;

		Object[] args = new Object[] { taxonomy.getTaxId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXID, args);

		if ((taxonomyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TAXID.getColumnBitmask()) != 0) {
			args = new Object[] { taxonomyModelImpl.getOriginalTaxId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXID, args);
		}
	}

	/**
	 * Creates a new taxonomy with the primary key. Does not add the taxonomy to the database.
	 *
	 * @param taxId the primary key for the new taxonomy
	 * @return the new taxonomy
	 */
	@Override
	public Taxonomy create(long taxId) {
		Taxonomy taxonomy = new TaxonomyImpl();

		taxonomy.setNew(true);
		taxonomy.setPrimaryKey(taxId);

		return taxonomy;
	}

	/**
	 * Removes the taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taxId the primary key of the taxonomy
	 * @return the taxonomy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy remove(long taxId)
		throws NoSuchTaxonomyException, SystemException {
		return remove((Serializable)taxId);
	}

	/**
	 * Removes the taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the taxonomy
	 * @return the taxonomy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy remove(Serializable primaryKey)
		throws NoSuchTaxonomyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Taxonomy taxonomy = (Taxonomy)session.get(TaxonomyImpl.class,
					primaryKey);

			if (taxonomy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxonomyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxonomy);
		}
		catch (NoSuchTaxonomyException nsee) {
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
	protected Taxonomy removeImpl(Taxonomy taxonomy) throws SystemException {
		taxonomy = toUnwrappedModel(taxonomy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxonomy)) {
				taxonomy = (Taxonomy)session.get(TaxonomyImpl.class,
						taxonomy.getPrimaryKeyObj());
			}

			if (taxonomy != null) {
				session.delete(taxonomy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxonomy != null) {
			clearCache(taxonomy);
		}

		return taxonomy;
	}

	@Override
	public Taxonomy updateImpl(
		com.ihg.brandstandards.db.model.Taxonomy taxonomy)
		throws SystemException {
		taxonomy = toUnwrappedModel(taxonomy);

		boolean isNew = taxonomy.isNew();

		TaxonomyModelImpl taxonomyModelImpl = (TaxonomyModelImpl)taxonomy;

		Session session = null;

		try {
			session = openSession();

			if (taxonomy.isNew()) {
				session.save(taxonomy);

				taxonomy.setNew(false);
			}
			else {
				session.merge(taxonomy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaxonomyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((taxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taxonomyModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);

				args = new Object[] { taxonomyModelImpl.getParentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
					args);
			}

			if ((taxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taxonomyModelImpl.getOriginalCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);

				args = new Object[] { taxonomyModelImpl.getCreatorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);
			}
		}

		EntityCacheUtil.putResult(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyImpl.class, taxonomy.getPrimaryKey(), taxonomy);

		clearUniqueFindersCache(taxonomy);
		cacheUniqueFindersCache(taxonomy);

		return taxonomy;
	}

	protected Taxonomy toUnwrappedModel(Taxonomy taxonomy) {
		if (taxonomy instanceof TaxonomyImpl) {
			return taxonomy;
		}

		TaxonomyImpl taxonomyImpl = new TaxonomyImpl();

		taxonomyImpl.setNew(taxonomy.isNew());
		taxonomyImpl.setPrimaryKey(taxonomy.getPrimaryKey());

		taxonomyImpl.setTaxId(taxonomy.getTaxId());
		taxonomyImpl.setParentId(taxonomy.getParentId());
		taxonomyImpl.setTitle(taxonomy.getTitle());
		taxonomyImpl.setDesc(taxonomy.getDesc());
		taxonomyImpl.setImageLoc(taxonomy.getImageLoc());
		taxonomyImpl.setCreatedBy(taxonomy.getCreatedBy());
		taxonomyImpl.setPosition(taxonomy.getPosition());
		taxonomyImpl.setCreatorId(taxonomy.getCreatorId());
		taxonomyImpl.setCreatedDate(taxonomy.getCreatedDate());
		taxonomyImpl.setUpdatedBy(taxonomy.getUpdatedBy());
		taxonomyImpl.setUpdatedDate(taxonomy.getUpdatedDate());

		return taxonomyImpl;
	}

	/**
	 * Returns the taxonomy with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the taxonomy
	 * @return the taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxonomyException, SystemException {
		Taxonomy taxonomy = fetchByPrimaryKey(primaryKey);

		if (taxonomy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxonomyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxonomy;
	}

	/**
	 * Returns the taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyException} if it could not be found.
	 *
	 * @param taxId the primary key of the taxonomy
	 * @return the taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyException if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy findByPrimaryKey(long taxId)
		throws NoSuchTaxonomyException, SystemException {
		return findByPrimaryKey((Serializable)taxId);
	}

	/**
	 * Returns the taxonomy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the taxonomy
	 * @return the taxonomy, or <code>null</code> if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Taxonomy taxonomy = (Taxonomy)EntityCacheUtil.getResult(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyImpl.class, primaryKey);

		if (taxonomy == _nullTaxonomy) {
			return null;
		}

		if (taxonomy == null) {
			Session session = null;

			try {
				session = openSession();

				taxonomy = (Taxonomy)session.get(TaxonomyImpl.class, primaryKey);

				if (taxonomy != null) {
					cacheResult(taxonomy);
				}
				else {
					EntityCacheUtil.putResult(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyImpl.class, primaryKey, _nullTaxonomy);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaxonomyModelImpl.ENTITY_CACHE_ENABLED,
					TaxonomyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxonomy;
	}

	/**
	 * Returns the taxonomy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taxId the primary key of the taxonomy
	 * @return the taxonomy, or <code>null</code> if a taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Taxonomy fetchByPrimaryKey(long taxId) throws SystemException {
		return fetchByPrimaryKey((Serializable)taxId);
	}

	/**
	 * Returns all the taxonomies.
	 *
	 * @return the taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the taxonomies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of taxonomies
	 * @param end the upper bound of the range of taxonomies (not inclusive)
	 * @return the range of taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the taxonomies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of taxonomies
	 * @param end the upper bound of the range of taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Taxonomy> findAll(int start, int end,
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

		List<Taxonomy> list = (List<Taxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAXONOMY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXONOMY;

				if (pagination) {
					sql = sql.concat(TaxonomyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Taxonomy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Taxonomy>(list);
				}
				else {
					list = (List<Taxonomy>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the taxonomies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Taxonomy taxonomy : findAll()) {
			remove(taxonomy);
		}
	}

	/**
	 * Returns the number of taxonomies.
	 *
	 * @return the number of taxonomies
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

				Query q = session.createQuery(_SQL_COUNT_TAXONOMY);

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
	 * Initializes the taxonomy persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.Taxonomy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Taxonomy>> listenersList = new ArrayList<ModelListener<Taxonomy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Taxonomy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaxonomyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAXONOMY = "SELECT taxonomy FROM Taxonomy taxonomy";
	private static final String _SQL_SELECT_TAXONOMY_WHERE = "SELECT taxonomy FROM Taxonomy taxonomy WHERE ";
	private static final String _SQL_COUNT_TAXONOMY = "SELECT COUNT(taxonomy) FROM Taxonomy taxonomy";
	private static final String _SQL_COUNT_TAXONOMY_WHERE = "SELECT COUNT(taxonomy) FROM Taxonomy taxonomy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxonomy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Taxonomy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Taxonomy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaxonomyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"taxId", "parentId", "title", "desc", "imageLoc", "createdBy",
				"position", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static Taxonomy _nullTaxonomy = new TaxonomyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Taxonomy> toCacheModel() {
				return _nullTaxonomyCacheModel;
			}
		};

	private static CacheModel<Taxonomy> _nullTaxonomyCacheModel = new CacheModel<Taxonomy>() {
			@Override
			public Taxonomy toEntityModel() {
				return _nullTaxonomy;
			}
		};
}