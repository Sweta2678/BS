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

import com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException;
import com.ihg.brandstandards.db.model.BridgeProgressSubCategory;
import com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryImpl;
import com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the bridge progress sub category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressSubCategoryPersistence
 * @see BridgeProgressSubCategoryUtil
 * @generated
 */
public class BridgeProgressSubCategoryPersistenceImpl
	extends BasePersistenceImpl<BridgeProgressSubCategory>
	implements BridgeProgressSubCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgeProgressSubCategoryUtil} to access the bridge progress sub category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgeProgressSubCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID =
		new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBybridgeProgressSubCategoryId",
			new String[] { Long.class.getName() },
			BridgeProgressSubCategoryModelImpl.PROGRESSSUBCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BRIDGEPROGRESSSUBCATEGORYID =
		new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybridgeProgressSubCategoryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the bridge progress sub category where progressSubCategoryId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException} if it could not be found.
	 *
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the matching bridge progress sub category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a matching bridge progress sub category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory findBybridgeProgressSubCategoryId(
		long progressSubCategoryId)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		BridgeProgressSubCategory bridgeProgressSubCategory = fetchBybridgeProgressSubCategoryId(progressSubCategoryId);

		if (bridgeProgressSubCategory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("progressSubCategoryId=");
			msg.append(progressSubCategoryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgeProgressSubCategoryException(msg.toString());
		}

		return bridgeProgressSubCategory;
	}

	/**
	 * Returns the bridge progress sub category where progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory fetchBybridgeProgressSubCategoryId(
		long progressSubCategoryId) throws SystemException {
		return fetchBybridgeProgressSubCategoryId(progressSubCategoryId, true);
	}

	/**
	 * Returns the bridge progress sub category where progressSubCategoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param progressSubCategoryId the progress sub category ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory fetchBybridgeProgressSubCategoryId(
		long progressSubCategoryId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { progressSubCategoryId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
					finderArgs, this);
		}

		if (result instanceof BridgeProgressSubCategory) {
			BridgeProgressSubCategory bridgeProgressSubCategory = (BridgeProgressSubCategory)result;

			if ((progressSubCategoryId != bridgeProgressSubCategory.getProgressSubCategoryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BRIDGEPROGRESSSUBCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_BRIDGEPROGRESSSUBCATEGORYID_PROGRESSSUBCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progressSubCategoryId);

				List<BridgeProgressSubCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgeProgressSubCategoryPersistenceImpl.fetchBybridgeProgressSubCategoryId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgeProgressSubCategory bridgeProgressSubCategory = list.get(0);

					result = bridgeProgressSubCategory;

					cacheResult(bridgeProgressSubCategory);

					if ((bridgeProgressSubCategory.getProgressSubCategoryId() != progressSubCategoryId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
							finderArgs, bridgeProgressSubCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
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
			return (BridgeProgressSubCategory)result;
		}
	}

	/**
	 * Removes the bridge progress sub category where progressSubCategoryId = &#63; from the database.
	 *
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the bridge progress sub category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory removeBybridgeProgressSubCategoryId(
		long progressSubCategoryId)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		BridgeProgressSubCategory bridgeProgressSubCategory = findBybridgeProgressSubCategoryId(progressSubCategoryId);

		return remove(bridgeProgressSubCategory);
	}

	/**
	 * Returns the number of bridge progress sub categories where progressSubCategoryId = &#63;.
	 *
	 * @param progressSubCategoryId the progress sub category ID
	 * @return the number of matching bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybridgeProgressSubCategoryId(long progressSubCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BRIDGEPROGRESSSUBCATEGORYID;

		Object[] finderArgs = new Object[] { progressSubCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BRIDGEPROGRESSSUBCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_BRIDGEPROGRESSSUBCATEGORYID_PROGRESSSUBCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progressSubCategoryId);

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

	private static final String _FINDER_COLUMN_BRIDGEPROGRESSSUBCATEGORYID_PROGRESSSUBCATEGORYID_2 =
		"bridgeProgressSubCategory.progressSubCategoryId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROGRESSCATEGORYID =
		new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByprogressCategoryId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROGRESSCATEGORYID =
		new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByprogressCategoryId", new String[] { Long.class.getName() },
			BridgeProgressSubCategoryModelImpl.PROGRESSCATEGORYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROGRESSCATEGORYID = new FinderPath(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByprogressCategoryId", new String[] { Long.class.getName() });

	/**
	 * Returns all the bridge progress sub categories where progressCategoryId = &#63;.
	 *
	 * @param progressCategoryId the progress category ID
	 * @return the matching bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressSubCategory> findByprogressCategoryId(
		long progressCategoryId) throws SystemException {
		return findByprogressCategoryId(progressCategoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge progress sub categories where progressCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param progressCategoryId the progress category ID
	 * @param start the lower bound of the range of bridge progress sub categories
	 * @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	 * @return the range of matching bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressSubCategory> findByprogressCategoryId(
		long progressCategoryId, int start, int end) throws SystemException {
		return findByprogressCategoryId(progressCategoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge progress sub categories where progressCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param progressCategoryId the progress category ID
	 * @param start the lower bound of the range of bridge progress sub categories
	 * @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressSubCategory> findByprogressCategoryId(
		long progressCategoryId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROGRESSCATEGORYID;
			finderArgs = new Object[] { progressCategoryId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROGRESSCATEGORYID;
			finderArgs = new Object[] {
					progressCategoryId,
					
					start, end, orderByComparator
				};
		}

		List<BridgeProgressSubCategory> list = (List<BridgeProgressSubCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BridgeProgressSubCategory bridgeProgressSubCategory : list) {
				if ((progressCategoryId != bridgeProgressSubCategory.getProgressCategoryId())) {
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

			query.append(_SQL_SELECT_BRIDGEPROGRESSSUBCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PROGRESSCATEGORYID_PROGRESSCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BridgeProgressSubCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progressCategoryId);

				if (!pagination) {
					list = (List<BridgeProgressSubCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeProgressSubCategory>(list);
				}
				else {
					list = (List<BridgeProgressSubCategory>)QueryUtil.list(q,
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
	 * Returns the first bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	 *
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge progress sub category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a matching bridge progress sub category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory findByprogressCategoryId_First(
		long progressCategoryId, OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		BridgeProgressSubCategory bridgeProgressSubCategory = fetchByprogressCategoryId_First(progressCategoryId,
				orderByComparator);

		if (bridgeProgressSubCategory != null) {
			return bridgeProgressSubCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("progressCategoryId=");
		msg.append(progressCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeProgressSubCategoryException(msg.toString());
	}

	/**
	 * Returns the first bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	 *
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory fetchByprogressCategoryId_First(
		long progressCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BridgeProgressSubCategory> list = findByprogressCategoryId(progressCategoryId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	 *
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge progress sub category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a matching bridge progress sub category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory findByprogressCategoryId_Last(
		long progressCategoryId, OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		BridgeProgressSubCategory bridgeProgressSubCategory = fetchByprogressCategoryId_Last(progressCategoryId,
				orderByComparator);

		if (bridgeProgressSubCategory != null) {
			return bridgeProgressSubCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("progressCategoryId=");
		msg.append(progressCategoryId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBridgeProgressSubCategoryException(msg.toString());
	}

	/**
	 * Returns the last bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	 *
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bridge progress sub category, or <code>null</code> if a matching bridge progress sub category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory fetchByprogressCategoryId_Last(
		long progressCategoryId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByprogressCategoryId(progressCategoryId);

		if (count == 0) {
			return null;
		}

		List<BridgeProgressSubCategory> list = findByprogressCategoryId(progressCategoryId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bridge progress sub categories before and after the current bridge progress sub category in the ordered set where progressCategoryId = &#63;.
	 *
	 * @param progressSubCategoryId the primary key of the current bridge progress sub category
	 * @param progressCategoryId the progress category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bridge progress sub category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory[] findByprogressCategoryId_PrevAndNext(
		long progressSubCategoryId, long progressCategoryId,
		OrderByComparator orderByComparator)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		BridgeProgressSubCategory bridgeProgressSubCategory = findByPrimaryKey(progressSubCategoryId);

		Session session = null;

		try {
			session = openSession();

			BridgeProgressSubCategory[] array = new BridgeProgressSubCategoryImpl[3];

			array[0] = getByprogressCategoryId_PrevAndNext(session,
					bridgeProgressSubCategory, progressCategoryId,
					orderByComparator, true);

			array[1] = bridgeProgressSubCategory;

			array[2] = getByprogressCategoryId_PrevAndNext(session,
					bridgeProgressSubCategory, progressCategoryId,
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

	protected BridgeProgressSubCategory getByprogressCategoryId_PrevAndNext(
		Session session, BridgeProgressSubCategory bridgeProgressSubCategory,
		long progressCategoryId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BRIDGEPROGRESSSUBCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_PROGRESSCATEGORYID_PROGRESSCATEGORYID_2);

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
			query.append(BridgeProgressSubCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(progressCategoryId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(bridgeProgressSubCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BridgeProgressSubCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bridge progress sub categories where progressCategoryId = &#63; from the database.
	 *
	 * @param progressCategoryId the progress category ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByprogressCategoryId(long progressCategoryId)
		throws SystemException {
		for (BridgeProgressSubCategory bridgeProgressSubCategory : findByprogressCategoryId(
				progressCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(bridgeProgressSubCategory);
		}
	}

	/**
	 * Returns the number of bridge progress sub categories where progressCategoryId = &#63;.
	 *
	 * @param progressCategoryId the progress category ID
	 * @return the number of matching bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprogressCategoryId(long progressCategoryId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROGRESSCATEGORYID;

		Object[] finderArgs = new Object[] { progressCategoryId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BRIDGEPROGRESSSUBCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_PROGRESSCATEGORYID_PROGRESSCATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(progressCategoryId);

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

	private static final String _FINDER_COLUMN_PROGRESSCATEGORYID_PROGRESSCATEGORYID_2 =
		"bridgeProgressSubCategory.progressCategoryId = ?";

	public BridgeProgressSubCategoryPersistenceImpl() {
		setModelClass(BridgeProgressSubCategory.class);
	}

	/**
	 * Caches the bridge progress sub category in the entity cache if it is enabled.
	 *
	 * @param bridgeProgressSubCategory the bridge progress sub category
	 */
	@Override
	public void cacheResult(BridgeProgressSubCategory bridgeProgressSubCategory) {
		EntityCacheUtil.putResult(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class,
			bridgeProgressSubCategory.getPrimaryKey(), bridgeProgressSubCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
			new Object[] { bridgeProgressSubCategory.getProgressSubCategoryId() },
			bridgeProgressSubCategory);

		bridgeProgressSubCategory.resetOriginalValues();
	}

	/**
	 * Caches the bridge progress sub categories in the entity cache if it is enabled.
	 *
	 * @param bridgeProgressSubCategories the bridge progress sub categories
	 */
	@Override
	public void cacheResult(
		List<BridgeProgressSubCategory> bridgeProgressSubCategories) {
		for (BridgeProgressSubCategory bridgeProgressSubCategory : bridgeProgressSubCategories) {
			if (EntityCacheUtil.getResult(
						BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
						BridgeProgressSubCategoryImpl.class,
						bridgeProgressSubCategory.getPrimaryKey()) == null) {
				cacheResult(bridgeProgressSubCategory);
			}
			else {
				bridgeProgressSubCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge progress sub categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgeProgressSubCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgeProgressSubCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge progress sub category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgeProgressSubCategory bridgeProgressSubCategory) {
		EntityCacheUtil.removeResult(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class,
			bridgeProgressSubCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgeProgressSubCategory);
	}

	@Override
	public void clearCache(
		List<BridgeProgressSubCategory> bridgeProgressSubCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgeProgressSubCategory bridgeProgressSubCategory : bridgeProgressSubCategories) {
			EntityCacheUtil.removeResult(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
				BridgeProgressSubCategoryImpl.class,
				bridgeProgressSubCategory.getPrimaryKey());

			clearUniqueFindersCache(bridgeProgressSubCategory);
		}
	}

	protected void cacheUniqueFindersCache(
		BridgeProgressSubCategory bridgeProgressSubCategory) {
		if (bridgeProgressSubCategory.isNew()) {
			Object[] args = new Object[] {
					bridgeProgressSubCategory.getProgressSubCategoryId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BRIDGEPROGRESSSUBCATEGORYID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
				args, bridgeProgressSubCategory);
		}
		else {
			BridgeProgressSubCategoryModelImpl bridgeProgressSubCategoryModelImpl =
				(BridgeProgressSubCategoryModelImpl)bridgeProgressSubCategory;

			if ((bridgeProgressSubCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeProgressSubCategory.getProgressSubCategoryId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BRIDGEPROGRESSSUBCATEGORYID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
					args, bridgeProgressSubCategory);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BridgeProgressSubCategory bridgeProgressSubCategory) {
		BridgeProgressSubCategoryModelImpl bridgeProgressSubCategoryModelImpl = (BridgeProgressSubCategoryModelImpl)bridgeProgressSubCategory;

		Object[] args = new Object[] {
				bridgeProgressSubCategory.getProgressSubCategoryId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRIDGEPROGRESSSUBCATEGORYID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
			args);

		if ((bridgeProgressSubCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgeProgressSubCategoryModelImpl.getOriginalProgressSubCategoryId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BRIDGEPROGRESSSUBCATEGORYID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BRIDGEPROGRESSSUBCATEGORYID,
				args);
		}
	}

	/**
	 * Creates a new bridge progress sub category with the primary key. Does not add the bridge progress sub category to the database.
	 *
	 * @param progressSubCategoryId the primary key for the new bridge progress sub category
	 * @return the new bridge progress sub category
	 */
	@Override
	public BridgeProgressSubCategory create(long progressSubCategoryId) {
		BridgeProgressSubCategory bridgeProgressSubCategory = new BridgeProgressSubCategoryImpl();

		bridgeProgressSubCategory.setNew(true);
		bridgeProgressSubCategory.setPrimaryKey(progressSubCategoryId);

		return bridgeProgressSubCategory;
	}

	/**
	 * Removes the bridge progress sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progressSubCategoryId the primary key of the bridge progress sub category
	 * @return the bridge progress sub category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory remove(long progressSubCategoryId)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		return remove((Serializable)progressSubCategoryId);
	}

	/**
	 * Removes the bridge progress sub category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge progress sub category
	 * @return the bridge progress sub category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory remove(Serializable primaryKey)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgeProgressSubCategory bridgeProgressSubCategory = (BridgeProgressSubCategory)session.get(BridgeProgressSubCategoryImpl.class,
					primaryKey);

			if (bridgeProgressSubCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgeProgressSubCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgeProgressSubCategory);
		}
		catch (NoSuchBridgeProgressSubCategoryException nsee) {
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
	protected BridgeProgressSubCategory removeImpl(
		BridgeProgressSubCategory bridgeProgressSubCategory)
		throws SystemException {
		bridgeProgressSubCategory = toUnwrappedModel(bridgeProgressSubCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgeProgressSubCategory)) {
				bridgeProgressSubCategory = (BridgeProgressSubCategory)session.get(BridgeProgressSubCategoryImpl.class,
						bridgeProgressSubCategory.getPrimaryKeyObj());
			}

			if (bridgeProgressSubCategory != null) {
				session.delete(bridgeProgressSubCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgeProgressSubCategory != null) {
			clearCache(bridgeProgressSubCategory);
		}

		return bridgeProgressSubCategory;
	}

	@Override
	public BridgeProgressSubCategory updateImpl(
		com.ihg.brandstandards.db.model.BridgeProgressSubCategory bridgeProgressSubCategory)
		throws SystemException {
		bridgeProgressSubCategory = toUnwrappedModel(bridgeProgressSubCategory);

		boolean isNew = bridgeProgressSubCategory.isNew();

		BridgeProgressSubCategoryModelImpl bridgeProgressSubCategoryModelImpl = (BridgeProgressSubCategoryModelImpl)bridgeProgressSubCategory;

		Session session = null;

		try {
			session = openSession();

			if (bridgeProgressSubCategory.isNew()) {
				session.save(bridgeProgressSubCategory);

				bridgeProgressSubCategory.setNew(false);
			}
			else {
				session.merge(bridgeProgressSubCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!BridgeProgressSubCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((bridgeProgressSubCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROGRESSCATEGORYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeProgressSubCategoryModelImpl.getOriginalProgressCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROGRESSCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROGRESSCATEGORYID,
					args);

				args = new Object[] {
						bridgeProgressSubCategoryModelImpl.getProgressCategoryId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROGRESSCATEGORYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROGRESSCATEGORYID,
					args);
			}
		}

		EntityCacheUtil.putResult(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressSubCategoryImpl.class,
			bridgeProgressSubCategory.getPrimaryKey(), bridgeProgressSubCategory);

		clearUniqueFindersCache(bridgeProgressSubCategory);
		cacheUniqueFindersCache(bridgeProgressSubCategory);

		return bridgeProgressSubCategory;
	}

	protected BridgeProgressSubCategory toUnwrappedModel(
		BridgeProgressSubCategory bridgeProgressSubCategory) {
		if (bridgeProgressSubCategory instanceof BridgeProgressSubCategoryImpl) {
			return bridgeProgressSubCategory;
		}

		BridgeProgressSubCategoryImpl bridgeProgressSubCategoryImpl = new BridgeProgressSubCategoryImpl();

		bridgeProgressSubCategoryImpl.setNew(bridgeProgressSubCategory.isNew());
		bridgeProgressSubCategoryImpl.setPrimaryKey(bridgeProgressSubCategory.getPrimaryKey());

		bridgeProgressSubCategoryImpl.setProgressSubCategoryId(bridgeProgressSubCategory.getProgressSubCategoryId());
		bridgeProgressSubCategoryImpl.setProgressCategoryId(bridgeProgressSubCategory.getProgressCategoryId());
		bridgeProgressSubCategoryImpl.setCategoryName(bridgeProgressSubCategory.getCategoryName());
		bridgeProgressSubCategoryImpl.setDisplayOrderNumber(bridgeProgressSubCategory.getDisplayOrderNumber());
		bridgeProgressSubCategoryImpl.setCreatorId(bridgeProgressSubCategory.getCreatorId());
		bridgeProgressSubCategoryImpl.setCreatedDate(bridgeProgressSubCategory.getCreatedDate());
		bridgeProgressSubCategoryImpl.setUpdatedBy(bridgeProgressSubCategory.getUpdatedBy());
		bridgeProgressSubCategoryImpl.setUpdatedDate(bridgeProgressSubCategory.getUpdatedDate());

		return bridgeProgressSubCategoryImpl;
	}

	/**
	 * Returns the bridge progress sub category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge progress sub category
	 * @return the bridge progress sub category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		BridgeProgressSubCategory bridgeProgressSubCategory = fetchByPrimaryKey(primaryKey);

		if (bridgeProgressSubCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgeProgressSubCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgeProgressSubCategory;
	}

	/**
	 * Returns the bridge progress sub category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException} if it could not be found.
	 *
	 * @param progressSubCategoryId the primary key of the bridge progress sub category
	 * @return the bridge progress sub category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException if a bridge progress sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory findByPrimaryKey(
		long progressSubCategoryId)
		throws NoSuchBridgeProgressSubCategoryException, SystemException {
		return findByPrimaryKey((Serializable)progressSubCategoryId);
	}

	/**
	 * Returns the bridge progress sub category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge progress sub category
	 * @return the bridge progress sub category, or <code>null</code> if a bridge progress sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgeProgressSubCategory bridgeProgressSubCategory = (BridgeProgressSubCategory)EntityCacheUtil.getResult(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
				BridgeProgressSubCategoryImpl.class, primaryKey);

		if (bridgeProgressSubCategory == _nullBridgeProgressSubCategory) {
			return null;
		}

		if (bridgeProgressSubCategory == null) {
			Session session = null;

			try {
				session = openSession();

				bridgeProgressSubCategory = (BridgeProgressSubCategory)session.get(BridgeProgressSubCategoryImpl.class,
						primaryKey);

				if (bridgeProgressSubCategory != null) {
					cacheResult(bridgeProgressSubCategory);
				}
				else {
					EntityCacheUtil.putResult(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
						BridgeProgressSubCategoryImpl.class, primaryKey,
						_nullBridgeProgressSubCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgeProgressSubCategoryModelImpl.ENTITY_CACHE_ENABLED,
					BridgeProgressSubCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgeProgressSubCategory;
	}

	/**
	 * Returns the bridge progress sub category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progressSubCategoryId the primary key of the bridge progress sub category
	 * @return the bridge progress sub category, or <code>null</code> if a bridge progress sub category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressSubCategory fetchByPrimaryKey(
		long progressSubCategoryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)progressSubCategoryId);
	}

	/**
	 * Returns all the bridge progress sub categories.
	 *
	 * @return the bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressSubCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge progress sub categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge progress sub categories
	 * @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	 * @return the range of bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressSubCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge progress sub categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge progress sub categories
	 * @param end the upper bound of the range of bridge progress sub categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge progress sub categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressSubCategory> findAll(int start, int end,
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

		List<BridgeProgressSubCategory> list = (List<BridgeProgressSubCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPROGRESSSUBCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPROGRESSSUBCATEGORY;

				if (pagination) {
					sql = sql.concat(BridgeProgressSubCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgeProgressSubCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeProgressSubCategory>(list);
				}
				else {
					list = (List<BridgeProgressSubCategory>)QueryUtil.list(q,
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
	 * Removes all the bridge progress sub categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgeProgressSubCategory bridgeProgressSubCategory : findAll()) {
			remove(bridgeProgressSubCategory);
		}
	}

	/**
	 * Returns the number of bridge progress sub categories.
	 *
	 * @return the number of bridge progress sub categories
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPROGRESSSUBCATEGORY);

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
	 * Initializes the bridge progress sub category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgeProgressSubCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgeProgressSubCategory>> listenersList = new ArrayList<ModelListener<BridgeProgressSubCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgeProgressSubCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgeProgressSubCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPROGRESSSUBCATEGORY = "SELECT bridgeProgressSubCategory FROM BridgeProgressSubCategory bridgeProgressSubCategory";
	private static final String _SQL_SELECT_BRIDGEPROGRESSSUBCATEGORY_WHERE = "SELECT bridgeProgressSubCategory FROM BridgeProgressSubCategory bridgeProgressSubCategory WHERE ";
	private static final String _SQL_COUNT_BRIDGEPROGRESSSUBCATEGORY = "SELECT COUNT(bridgeProgressSubCategory) FROM BridgeProgressSubCategory bridgeProgressSubCategory";
	private static final String _SQL_COUNT_BRIDGEPROGRESSSUBCATEGORY_WHERE = "SELECT COUNT(bridgeProgressSubCategory) FROM BridgeProgressSubCategory bridgeProgressSubCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgeProgressSubCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgeProgressSubCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgeProgressSubCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgeProgressSubCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"progressSubCategoryId", "progressCategoryId", "categoryName",
				"displayOrderNumber", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static BridgeProgressSubCategory _nullBridgeProgressSubCategory = new BridgeProgressSubCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgeProgressSubCategory> toCacheModel() {
				return _nullBridgeProgressSubCategoryCacheModel;
			}
		};

	private static CacheModel<BridgeProgressSubCategory> _nullBridgeProgressSubCategoryCacheModel =
		new CacheModel<BridgeProgressSubCategory>() {
			@Override
			public BridgeProgressSubCategory toEntityModel() {
				return _nullBridgeProgressSubCategory;
			}
		};
}