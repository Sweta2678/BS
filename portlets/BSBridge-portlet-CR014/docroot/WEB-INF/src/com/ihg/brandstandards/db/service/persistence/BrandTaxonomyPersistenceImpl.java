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

import com.ihg.brandstandards.db.NoSuchBrandTaxonomyException;
import com.ihg.brandstandards.db.model.BrandTaxonomy;
import com.ihg.brandstandards.db.model.impl.BrandTaxonomyImpl;
import com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl;

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
 * The persistence implementation for the brand taxonomy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomyPersistence
 * @see BrandTaxonomyUtil
 * @generated
 */
public class BrandTaxonomyPersistenceImpl extends BasePersistenceImpl<BrandTaxonomy>
	implements BrandTaxonomyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BrandTaxonomyUtil} to access the brand taxonomy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BrandTaxonomyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_ID = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByid",
			new String[] { Long.class.getName() },
			BrandTaxonomyModelImpl.ID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ID = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByid",
			new String[] { Long.class.getName() });

	/**
	 * Returns the brand taxonomy where id = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	 *
	 * @param id the ID
	 * @return the matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findByid(long id)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchByid(id);

		if (brandTaxonomy == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("id=");
			msg.append(id);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBrandTaxonomyException(msg.toString());
		}

		return brandTaxonomy;
	}

	/**
	 * Returns the brand taxonomy where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param id the ID
	 * @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchByid(long id) throws SystemException {
		return fetchByid(id, true);
	}

	/**
	 * Returns the brand taxonomy where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param id the ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchByid(long id, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { id };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_ID,
					finderArgs, this);
		}

		if (result instanceof BrandTaxonomy) {
			BrandTaxonomy brandTaxonomy = (BrandTaxonomy)result;

			if ((id != brandTaxonomy.getId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

				List<BrandTaxonomy> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BrandTaxonomyPersistenceImpl.fetchByid(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BrandTaxonomy brandTaxonomy = list.get(0);

					result = brandTaxonomy;

					cacheResult(brandTaxonomy);

					if ((brandTaxonomy.getId() != id)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
							finderArgs, brandTaxonomy);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, finderArgs);

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
			return (BrandTaxonomy)result;
		}
	}

	/**
	 * Removes the brand taxonomy where id = &#63; from the database.
	 *
	 * @param id the ID
	 * @return the brand taxonomy that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy removeByid(long id)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = findByid(id);

		return remove(brandTaxonomy);
	}

	/**
	 * Returns the number of brand taxonomies where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByid(long id) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ID;

		Object[] finderArgs = new Object[] { id };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BRANDTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_ID_ID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(id);

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

	private static final String _FINDER_COLUMN_ID_ID_2 = "brandTaxonomy.id = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAXID = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBytaxId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBytaxId", new String[] { Long.class.getName() },
			BrandTaxonomyModelImpl.TAXID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAXID = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytaxId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the brand taxonomies where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @return the matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBytaxId(long taxId)
		throws SystemException {
		return findBytaxId(taxId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand taxonomies where taxId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxId the tax ID
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @return the range of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBytaxId(long taxId, int start, int end)
		throws SystemException {
		return findBytaxId(taxId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand taxonomies where taxId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param taxId the tax ID
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBytaxId(long taxId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID;
			finderArgs = new Object[] { taxId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAXID;
			finderArgs = new Object[] { taxId, start, end, orderByComparator };
		}

		List<BrandTaxonomy> list = (List<BrandTaxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BrandTaxonomy brandTaxonomy : list) {
				if ((taxId != brandTaxonomy.getTaxId())) {
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

			query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_TAXID_TAXID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BrandTaxonomyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxId);

				if (!pagination) {
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BrandTaxonomy>(list);
				}
				else {
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first brand taxonomy in the ordered set where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findBytaxId_First(long taxId,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchBytaxId_First(taxId,
				orderByComparator);

		if (brandTaxonomy != null) {
			return brandTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxId=");
		msg.append(taxId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrandTaxonomyException(msg.toString());
	}

	/**
	 * Returns the first brand taxonomy in the ordered set where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchBytaxId_First(long taxId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BrandTaxonomy> list = findBytaxId(taxId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand taxonomy in the ordered set where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findBytaxId_Last(long taxId,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchBytaxId_Last(taxId, orderByComparator);

		if (brandTaxonomy != null) {
			return brandTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taxId=");
		msg.append(taxId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrandTaxonomyException(msg.toString());
	}

	/**
	 * Returns the last brand taxonomy in the ordered set where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchBytaxId_Last(long taxId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytaxId(taxId);

		if (count == 0) {
			return null;
		}

		List<BrandTaxonomy> list = findBytaxId(taxId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brand taxonomies before and after the current brand taxonomy in the ordered set where taxId = &#63;.
	 *
	 * @param id the primary key of the current brand taxonomy
	 * @param taxId the tax ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy[] findBytaxId_PrevAndNext(long id, long taxId,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BrandTaxonomy[] array = new BrandTaxonomyImpl[3];

			array[0] = getBytaxId_PrevAndNext(session, brandTaxonomy, taxId,
					orderByComparator, true);

			array[1] = brandTaxonomy;

			array[2] = getBytaxId_PrevAndNext(session, brandTaxonomy, taxId,
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

	protected BrandTaxonomy getBytaxId_PrevAndNext(Session session,
		BrandTaxonomy brandTaxonomy, long taxId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

		query.append(_FINDER_COLUMN_TAXID_TAXID_2);

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
			query.append(BrandTaxonomyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(taxId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(brandTaxonomy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BrandTaxonomy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brand taxonomies where taxId = &#63; from the database.
	 *
	 * @param taxId the tax ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBytaxId(long taxId) throws SystemException {
		for (BrandTaxonomy brandTaxonomy : findBytaxId(taxId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(brandTaxonomy);
		}
	}

	/**
	 * Returns the number of brand taxonomies where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @return the number of matching brand taxonomies
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

			query.append(_SQL_COUNT_BRANDTAXONOMY_WHERE);

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

	private static final String _FINDER_COLUMN_TAXID_TAXID_2 = "brandTaxonomy.taxId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAIN = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBychain",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAIN = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBychain", new String[] { String.class.getName() },
			BrandTaxonomyModelImpl.CHAIN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CHAIN = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBychain",
			new String[] { String.class.getName() });

	/**
	 * Returns all the brand taxonomies where chain = &#63;.
	 *
	 * @param chain the chain
	 * @return the matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBychain(String chain)
		throws SystemException {
		return findBychain(chain, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand taxonomies where chain = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chain the chain
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @return the range of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBychain(String chain, int start, int end)
		throws SystemException {
		return findBychain(chain, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand taxonomies where chain = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param chain the chain
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBychain(String chain, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAIN;
			finderArgs = new Object[] { chain };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CHAIN;
			finderArgs = new Object[] { chain, start, end, orderByComparator };
		}

		List<BrandTaxonomy> list = (List<BrandTaxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BrandTaxonomy brandTaxonomy : list) {
				if (!Validator.equals(chain, brandTaxonomy.getChain())) {
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

			query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

			boolean bindChain = false;

			if (chain == null) {
				query.append(_FINDER_COLUMN_CHAIN_CHAIN_1);
			}
			else if (chain.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAIN_CHAIN_3);
			}
			else {
				bindChain = true;

				query.append(_FINDER_COLUMN_CHAIN_CHAIN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BrandTaxonomyModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChain) {
					qPos.add(chain);
				}

				if (!pagination) {
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BrandTaxonomy>(list);
				}
				else {
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first brand taxonomy in the ordered set where chain = &#63;.
	 *
	 * @param chain the chain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findBychain_First(String chain,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchBychain_First(chain,
				orderByComparator);

		if (brandTaxonomy != null) {
			return brandTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chain=");
		msg.append(chain);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrandTaxonomyException(msg.toString());
	}

	/**
	 * Returns the first brand taxonomy in the ordered set where chain = &#63;.
	 *
	 * @param chain the chain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchBychain_First(String chain,
		OrderByComparator orderByComparator) throws SystemException {
		List<BrandTaxonomy> list = findBychain(chain, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand taxonomy in the ordered set where chain = &#63;.
	 *
	 * @param chain the chain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findBychain_Last(String chain,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchBychain_Last(chain, orderByComparator);

		if (brandTaxonomy != null) {
			return brandTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("chain=");
		msg.append(chain);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrandTaxonomyException(msg.toString());
	}

	/**
	 * Returns the last brand taxonomy in the ordered set where chain = &#63;.
	 *
	 * @param chain the chain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchBychain_Last(String chain,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBychain(chain);

		if (count == 0) {
			return null;
		}

		List<BrandTaxonomy> list = findBychain(chain, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brand taxonomies before and after the current brand taxonomy in the ordered set where chain = &#63;.
	 *
	 * @param id the primary key of the current brand taxonomy
	 * @param chain the chain
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy[] findBychain_PrevAndNext(long id, String chain,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BrandTaxonomy[] array = new BrandTaxonomyImpl[3];

			array[0] = getBychain_PrevAndNext(session, brandTaxonomy, chain,
					orderByComparator, true);

			array[1] = brandTaxonomy;

			array[2] = getBychain_PrevAndNext(session, brandTaxonomy, chain,
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

	protected BrandTaxonomy getBychain_PrevAndNext(Session session,
		BrandTaxonomy brandTaxonomy, String chain,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

		boolean bindChain = false;

		if (chain == null) {
			query.append(_FINDER_COLUMN_CHAIN_CHAIN_1);
		}
		else if (chain.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CHAIN_CHAIN_3);
		}
		else {
			bindChain = true;

			query.append(_FINDER_COLUMN_CHAIN_CHAIN_2);
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
			query.append(BrandTaxonomyModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindChain) {
			qPos.add(chain);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(brandTaxonomy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BrandTaxonomy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brand taxonomies where chain = &#63; from the database.
	 *
	 * @param chain the chain
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBychain(String chain) throws SystemException {
		for (BrandTaxonomy brandTaxonomy : findBychain(chain,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(brandTaxonomy);
		}
	}

	/**
	 * Returns the number of brand taxonomies where chain = &#63;.
	 *
	 * @param chain the chain
	 * @return the number of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBychain(String chain) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CHAIN;

		Object[] finderArgs = new Object[] { chain };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BRANDTAXONOMY_WHERE);

			boolean bindChain = false;

			if (chain == null) {
				query.append(_FINDER_COLUMN_CHAIN_CHAIN_1);
			}
			else if (chain.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CHAIN_CHAIN_3);
			}
			else {
				bindChain = true;

				query.append(_FINDER_COLUMN_CHAIN_CHAIN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindChain) {
					qPos.add(chain);
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

	private static final String _FINDER_COLUMN_CHAIN_CHAIN_1 = "brandTaxonomy.chain IS NULL";
	private static final String _FINDER_COLUMN_CHAIN_CHAIN_2 = "brandTaxonomy.chain = ?";
	private static final String _FINDER_COLUMN_CHAIN_CHAIN_3 = "(brandTaxonomy.chain IS NULL OR brandTaxonomy.chain = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTaxIdAndChainCd",
			new String[] { Long.class.getName(), String.class.getName() },
			BrandTaxonomyModelImpl.TAXID_COLUMN_BITMASK |
			BrandTaxonomyModelImpl.CHAIN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAXIDANDCHAINCD = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaxIdAndChainCd",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the brand taxonomy where taxId = &#63; and chain = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	 *
	 * @param taxId the tax ID
	 * @param chain the chain
	 * @return the matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findByTaxIdAndChainCd(long taxId, String chain)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchByTaxIdAndChainCd(taxId, chain);

		if (brandTaxonomy == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taxId=");
			msg.append(taxId);

			msg.append(", chain=");
			msg.append(chain);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBrandTaxonomyException(msg.toString());
		}

		return brandTaxonomy;
	}

	/**
	 * Returns the brand taxonomy where taxId = &#63; and chain = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taxId the tax ID
	 * @param chain the chain
	 * @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchByTaxIdAndChainCd(long taxId, String chain)
		throws SystemException {
		return fetchByTaxIdAndChainCd(taxId, chain, true);
	}

	/**
	 * Returns the brand taxonomy where taxId = &#63; and chain = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taxId the tax ID
	 * @param chain the chain
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchByTaxIdAndChainCd(long taxId, String chain,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { taxId, chain };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
					finderArgs, this);
		}

		if (result instanceof BrandTaxonomy) {
			BrandTaxonomy brandTaxonomy = (BrandTaxonomy)result;

			if ((taxId != brandTaxonomy.getTaxId()) ||
					!Validator.equals(chain, brandTaxonomy.getChain())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_TAXID_2);

			boolean bindChain = false;

			if (chain == null) {
				query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_1);
			}
			else if (chain.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_3);
			}
			else {
				bindChain = true;

				query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxId);

				if (bindChain) {
					qPos.add(chain);
				}

				List<BrandTaxonomy> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BrandTaxonomyPersistenceImpl.fetchByTaxIdAndChainCd(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BrandTaxonomy brandTaxonomy = list.get(0);

					result = brandTaxonomy;

					cacheResult(brandTaxonomy);

					if ((brandTaxonomy.getTaxId() != taxId) ||
							(brandTaxonomy.getChain() == null) ||
							!brandTaxonomy.getChain().equals(chain)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
							finderArgs, brandTaxonomy);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
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
			return (BrandTaxonomy)result;
		}
	}

	/**
	 * Removes the brand taxonomy where taxId = &#63; and chain = &#63; from the database.
	 *
	 * @param taxId the tax ID
	 * @param chain the chain
	 * @return the brand taxonomy that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy removeByTaxIdAndChainCd(long taxId, String chain)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = findByTaxIdAndChainCd(taxId, chain);

		return remove(brandTaxonomy);
	}

	/**
	 * Returns the number of brand taxonomies where taxId = &#63; and chain = &#63;.
	 *
	 * @param taxId the tax ID
	 * @param chain the chain
	 * @return the number of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTaxIdAndChainCd(long taxId, String chain)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TAXIDANDCHAINCD;

		Object[] finderArgs = new Object[] { taxId, chain };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BRANDTAXONOMY_WHERE);

			query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_TAXID_2);

			boolean bindChain = false;

			if (chain == null) {
				query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_1);
			}
			else if (chain.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_3);
			}
			else {
				bindChain = true;

				query.append(_FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxId);

				if (bindChain) {
					qPos.add(chain);
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

	private static final String _FINDER_COLUMN_TAXIDANDCHAINCD_TAXID_2 = "brandTaxonomy.taxId = ? AND ";
	private static final String _FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_1 = "brandTaxonomy.chain IS NULL";
	private static final String _FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_2 = "brandTaxonomy.chain = ?";
	private static final String _FINDER_COLUMN_TAXIDANDCHAINCD_CHAIN_3 = "(brandTaxonomy.chain IS NULL OR brandTaxonomy.chain = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBycreatorId",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID =
		new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED,
			BrandTaxonomyImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBycreatorId", new String[] { String.class.getName() },
			BrandTaxonomyModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATORID = new FinderPath(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreatorId",
			new String[] { String.class.getName() });

	/**
	 * Returns all the brand taxonomies where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBycreatorId(String creatorId)
		throws SystemException {
		return findBycreatorId(creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the brand taxonomies where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @return the range of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBycreatorId(String creatorId, int start,
		int end) throws SystemException {
		return findBycreatorId(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand taxonomies where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findBycreatorId(String creatorId, int start,
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

		List<BrandTaxonomy> list = (List<BrandTaxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BrandTaxonomy brandTaxonomy : list) {
				if (!Validator.equals(creatorId, brandTaxonomy.getCreatorId())) {
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

			query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

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
				query.append(BrandTaxonomyModelImpl.ORDER_BY_JPQL);
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
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BrandTaxonomy>(list);
				}
				else {
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first brand taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findBycreatorId_First(String creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchBycreatorId_First(creatorId,
				orderByComparator);

		if (brandTaxonomy != null) {
			return brandTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrandTaxonomyException(msg.toString());
	}

	/**
	 * Returns the first brand taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchBycreatorId_First(String creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BrandTaxonomy> list = findBycreatorId(creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last brand taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findBycreatorId_Last(String creatorId,
		OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchBycreatorId_Last(creatorId,
				orderByComparator);

		if (brandTaxonomy != null) {
			return brandTaxonomy;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBrandTaxonomyException(msg.toString());
	}

	/**
	 * Returns the last brand taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching brand taxonomy, or <code>null</code> if a matching brand taxonomy could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchBycreatorId_Last(String creatorId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreatorId(creatorId);

		if (count == 0) {
			return null;
		}

		List<BrandTaxonomy> list = findBycreatorId(creatorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the brand taxonomies before and after the current brand taxonomy in the ordered set where creatorId = &#63;.
	 *
	 * @param id the primary key of the current brand taxonomy
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy[] findBycreatorId_PrevAndNext(long id,
		String creatorId, OrderByComparator orderByComparator)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			BrandTaxonomy[] array = new BrandTaxonomyImpl[3];

			array[0] = getBycreatorId_PrevAndNext(session, brandTaxonomy,
					creatorId, orderByComparator, true);

			array[1] = brandTaxonomy;

			array[2] = getBycreatorId_PrevAndNext(session, brandTaxonomy,
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

	protected BrandTaxonomy getBycreatorId_PrevAndNext(Session session,
		BrandTaxonomy brandTaxonomy, String creatorId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRANDTAXONOMY_WHERE);

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
			query.append(BrandTaxonomyModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(brandTaxonomy);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BrandTaxonomy> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the brand taxonomies where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBycreatorId(String creatorId) throws SystemException {
		for (BrandTaxonomy brandTaxonomy : findBycreatorId(creatorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(brandTaxonomy);
		}
	}

	/**
	 * Returns the number of brand taxonomies where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching brand taxonomies
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

			query.append(_SQL_COUNT_BRANDTAXONOMY_WHERE);

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

	private static final String _FINDER_COLUMN_CREATORID_CREATORID_1 = "brandTaxonomy.creatorId IS NULL";
	private static final String _FINDER_COLUMN_CREATORID_CREATORID_2 = "brandTaxonomy.creatorId = ?";
	private static final String _FINDER_COLUMN_CREATORID_CREATORID_3 = "(brandTaxonomy.creatorId IS NULL OR brandTaxonomy.creatorId = '')";

	public BrandTaxonomyPersistenceImpl() {
		setModelClass(BrandTaxonomy.class);
	}

	/**
	 * Caches the brand taxonomy in the entity cache if it is enabled.
	 *
	 * @param brandTaxonomy the brand taxonomy
	 */
	@Override
	public void cacheResult(BrandTaxonomy brandTaxonomy) {
		EntityCacheUtil.putResult(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyImpl.class, brandTaxonomy.getPrimaryKey(),
			brandTaxonomy);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID,
			new Object[] { brandTaxonomy.getId() }, brandTaxonomy);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
			new Object[] { brandTaxonomy.getTaxId(), brandTaxonomy.getChain() },
			brandTaxonomy);

		brandTaxonomy.resetOriginalValues();
	}

	/**
	 * Caches the brand taxonomies in the entity cache if it is enabled.
	 *
	 * @param brandTaxonomies the brand taxonomies
	 */
	@Override
	public void cacheResult(List<BrandTaxonomy> brandTaxonomies) {
		for (BrandTaxonomy brandTaxonomy : brandTaxonomies) {
			if (EntityCacheUtil.getResult(
						BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
						BrandTaxonomyImpl.class, brandTaxonomy.getPrimaryKey()) == null) {
				cacheResult(brandTaxonomy);
			}
			else {
				brandTaxonomy.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all brand taxonomies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BrandTaxonomyImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BrandTaxonomyImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the brand taxonomy.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BrandTaxonomy brandTaxonomy) {
		EntityCacheUtil.removeResult(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyImpl.class, brandTaxonomy.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(brandTaxonomy);
	}

	@Override
	public void clearCache(List<BrandTaxonomy> brandTaxonomies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BrandTaxonomy brandTaxonomy : brandTaxonomies) {
			EntityCacheUtil.removeResult(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
				BrandTaxonomyImpl.class, brandTaxonomy.getPrimaryKey());

			clearUniqueFindersCache(brandTaxonomy);
		}
	}

	protected void cacheUniqueFindersCache(BrandTaxonomy brandTaxonomy) {
		if (brandTaxonomy.isNew()) {
			Object[] args = new Object[] { brandTaxonomy.getId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID, args,
				brandTaxonomy);

			args = new Object[] {
					brandTaxonomy.getTaxId(), brandTaxonomy.getChain()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAXIDANDCHAINCD,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
				args, brandTaxonomy);
		}
		else {
			BrandTaxonomyModelImpl brandTaxonomyModelImpl = (BrandTaxonomyModelImpl)brandTaxonomy;

			if ((brandTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { brandTaxonomy.getId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_ID, args,
					brandTaxonomy);
			}

			if ((brandTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						brandTaxonomy.getTaxId(), brandTaxonomy.getChain()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAXIDANDCHAINCD,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
					args, brandTaxonomy);
			}
		}
	}

	protected void clearUniqueFindersCache(BrandTaxonomy brandTaxonomy) {
		BrandTaxonomyModelImpl brandTaxonomyModelImpl = (BrandTaxonomyModelImpl)brandTaxonomy;

		Object[] args = new Object[] { brandTaxonomy.getId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);

		if ((brandTaxonomyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ID.getColumnBitmask()) != 0) {
			args = new Object[] { brandTaxonomyModelImpl.getOriginalId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_ID, args);
		}

		args = new Object[] { brandTaxonomy.getTaxId(), brandTaxonomy.getChain() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXIDANDCHAINCD, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD, args);

		if ((brandTaxonomyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD.getColumnBitmask()) != 0) {
			args = new Object[] {
					brandTaxonomyModelImpl.getOriginalTaxId(),
					brandTaxonomyModelImpl.getOriginalChain()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXIDANDCHAINCD,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXIDANDCHAINCD,
				args);
		}
	}

	/**
	 * Creates a new brand taxonomy with the primary key. Does not add the brand taxonomy to the database.
	 *
	 * @param id the primary key for the new brand taxonomy
	 * @return the new brand taxonomy
	 */
	@Override
	public BrandTaxonomy create(long id) {
		BrandTaxonomy brandTaxonomy = new BrandTaxonomyImpl();

		brandTaxonomy.setNew(true);
		brandTaxonomy.setPrimaryKey(id);

		return brandTaxonomy;
	}

	/**
	 * Removes the brand taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the brand taxonomy
	 * @return the brand taxonomy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy remove(long id)
		throws NoSuchBrandTaxonomyException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the brand taxonomy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the brand taxonomy
	 * @return the brand taxonomy that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy remove(Serializable primaryKey)
		throws NoSuchBrandTaxonomyException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BrandTaxonomy brandTaxonomy = (BrandTaxonomy)session.get(BrandTaxonomyImpl.class,
					primaryKey);

			if (brandTaxonomy == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBrandTaxonomyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(brandTaxonomy);
		}
		catch (NoSuchBrandTaxonomyException nsee) {
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
	protected BrandTaxonomy removeImpl(BrandTaxonomy brandTaxonomy)
		throws SystemException {
		brandTaxonomy = toUnwrappedModel(brandTaxonomy);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(brandTaxonomy)) {
				brandTaxonomy = (BrandTaxonomy)session.get(BrandTaxonomyImpl.class,
						brandTaxonomy.getPrimaryKeyObj());
			}

			if (brandTaxonomy != null) {
				session.delete(brandTaxonomy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (brandTaxonomy != null) {
			clearCache(brandTaxonomy);
		}

		return brandTaxonomy;
	}

	@Override
	public BrandTaxonomy updateImpl(
		com.ihg.brandstandards.db.model.BrandTaxonomy brandTaxonomy)
		throws SystemException {
		brandTaxonomy = toUnwrappedModel(brandTaxonomy);

		boolean isNew = brandTaxonomy.isNew();

		BrandTaxonomyModelImpl brandTaxonomyModelImpl = (BrandTaxonomyModelImpl)brandTaxonomy;

		Session session = null;

		try {
			session = openSession();

			if (brandTaxonomy.isNew()) {
				session.save(brandTaxonomy);

				brandTaxonomy.setNew(false);
			}
			else {
				session.merge(brandTaxonomy);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BrandTaxonomyModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((brandTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						brandTaxonomyModelImpl.getOriginalTaxId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID,
					args);

				args = new Object[] { brandTaxonomyModelImpl.getTaxId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAXID,
					args);
			}

			if ((brandTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAIN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						brandTaxonomyModelImpl.getOriginalChain()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAIN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAIN,
					args);

				args = new Object[] { brandTaxonomyModelImpl.getChain() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CHAIN, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CHAIN,
					args);
			}

			if ((brandTaxonomyModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						brandTaxonomyModelImpl.getOriginalCreatorId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);

				args = new Object[] { brandTaxonomyModelImpl.getCreatorId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATORID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATORID,
					args);
			}
		}

		EntityCacheUtil.putResult(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
			BrandTaxonomyImpl.class, brandTaxonomy.getPrimaryKey(),
			brandTaxonomy);

		clearUniqueFindersCache(brandTaxonomy);
		cacheUniqueFindersCache(brandTaxonomy);

		return brandTaxonomy;
	}

	protected BrandTaxonomy toUnwrappedModel(BrandTaxonomy brandTaxonomy) {
		if (brandTaxonomy instanceof BrandTaxonomyImpl) {
			return brandTaxonomy;
		}

		BrandTaxonomyImpl brandTaxonomyImpl = new BrandTaxonomyImpl();

		brandTaxonomyImpl.setNew(brandTaxonomy.isNew());
		brandTaxonomyImpl.setPrimaryKey(brandTaxonomy.getPrimaryKey());

		brandTaxonomyImpl.setId(brandTaxonomy.getId());
		brandTaxonomyImpl.setTaxId(brandTaxonomy.getTaxId());
		brandTaxonomyImpl.setChain(brandTaxonomy.getChain());
		brandTaxonomyImpl.setTitle(brandTaxonomy.getTitle());
		brandTaxonomyImpl.setDesc(brandTaxonomy.getDesc());
		brandTaxonomyImpl.setImageLoc(brandTaxonomy.getImageLoc());
		brandTaxonomyImpl.setCreatedBy(brandTaxonomy.getCreatedBy());
		brandTaxonomyImpl.setCreatorId(brandTaxonomy.getCreatorId());
		brandTaxonomyImpl.setCreatedDate(brandTaxonomy.getCreatedDate());
		brandTaxonomyImpl.setUpdatedBy(brandTaxonomy.getUpdatedBy());
		brandTaxonomyImpl.setUpdatedDate(brandTaxonomy.getUpdatedDate());

		return brandTaxonomyImpl;
	}

	/**
	 * Returns the brand taxonomy with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the brand taxonomy
	 * @return the brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBrandTaxonomyException, SystemException {
		BrandTaxonomy brandTaxonomy = fetchByPrimaryKey(primaryKey);

		if (brandTaxonomy == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBrandTaxonomyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return brandTaxonomy;
	}

	/**
	 * Returns the brand taxonomy with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBrandTaxonomyException} if it could not be found.
	 *
	 * @param id the primary key of the brand taxonomy
	 * @return the brand taxonomy
	 * @throws com.ihg.brandstandards.db.NoSuchBrandTaxonomyException if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy findByPrimaryKey(long id)
		throws NoSuchBrandTaxonomyException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the brand taxonomy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the brand taxonomy
	 * @return the brand taxonomy, or <code>null</code> if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BrandTaxonomy brandTaxonomy = (BrandTaxonomy)EntityCacheUtil.getResult(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
				BrandTaxonomyImpl.class, primaryKey);

		if (brandTaxonomy == _nullBrandTaxonomy) {
			return null;
		}

		if (brandTaxonomy == null) {
			Session session = null;

			try {
				session = openSession();

				brandTaxonomy = (BrandTaxonomy)session.get(BrandTaxonomyImpl.class,
						primaryKey);

				if (brandTaxonomy != null) {
					cacheResult(brandTaxonomy);
				}
				else {
					EntityCacheUtil.putResult(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
						BrandTaxonomyImpl.class, primaryKey, _nullBrandTaxonomy);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BrandTaxonomyModelImpl.ENTITY_CACHE_ENABLED,
					BrandTaxonomyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return brandTaxonomy;
	}

	/**
	 * Returns the brand taxonomy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the brand taxonomy
	 * @return the brand taxonomy, or <code>null</code> if a brand taxonomy with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BrandTaxonomy fetchByPrimaryKey(long id) throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the brand taxonomies.
	 *
	 * @return the brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the brand taxonomies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @return the range of brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the brand taxonomies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of brand taxonomies
	 * @param end the upper bound of the range of brand taxonomies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of brand taxonomies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BrandTaxonomy> findAll(int start, int end,
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

		List<BrandTaxonomy> list = (List<BrandTaxonomy>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRANDTAXONOMY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRANDTAXONOMY;

				if (pagination) {
					sql = sql.concat(BrandTaxonomyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BrandTaxonomy>(list);
				}
				else {
					list = (List<BrandTaxonomy>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the brand taxonomies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BrandTaxonomy brandTaxonomy : findAll()) {
			remove(brandTaxonomy);
		}
	}

	/**
	 * Returns the number of brand taxonomies.
	 *
	 * @return the number of brand taxonomies
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

				Query q = session.createQuery(_SQL_COUNT_BRANDTAXONOMY);

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
	 * Initializes the brand taxonomy persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BrandTaxonomy")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BrandTaxonomy>> listenersList = new ArrayList<ModelListener<BrandTaxonomy>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BrandTaxonomy>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BrandTaxonomyImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRANDTAXONOMY = "SELECT brandTaxonomy FROM BrandTaxonomy brandTaxonomy";
	private static final String _SQL_SELECT_BRANDTAXONOMY_WHERE = "SELECT brandTaxonomy FROM BrandTaxonomy brandTaxonomy WHERE ";
	private static final String _SQL_COUNT_BRANDTAXONOMY = "SELECT COUNT(brandTaxonomy) FROM BrandTaxonomy brandTaxonomy";
	private static final String _SQL_COUNT_BRANDTAXONOMY_WHERE = "SELECT COUNT(brandTaxonomy) FROM BrandTaxonomy brandTaxonomy WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "brandTaxonomy.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BrandTaxonomy exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BrandTaxonomy exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BrandTaxonomyPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id", "taxId", "chain", "title", "desc", "imageLoc", "createdBy",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static BrandTaxonomy _nullBrandTaxonomy = new BrandTaxonomyImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BrandTaxonomy> toCacheModel() {
				return _nullBrandTaxonomyCacheModel;
			}
		};

	private static CacheModel<BrandTaxonomy> _nullBrandTaxonomyCacheModel = new CacheModel<BrandTaxonomy>() {
			@Override
			public BrandTaxonomy toEntityModel() {
				return _nullBrandTaxonomy;
			}
		};
}