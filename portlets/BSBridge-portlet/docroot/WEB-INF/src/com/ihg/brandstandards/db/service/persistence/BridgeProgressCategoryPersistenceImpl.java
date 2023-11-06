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

import com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException;
import com.ihg.brandstandards.db.model.BridgeProgressCategory;
import com.ihg.brandstandards.db.model.impl.BridgeProgressCategoryImpl;
import com.ihg.brandstandards.db.model.impl.BridgeProgressCategoryModelImpl;

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
 * The persistence implementation for the bridge progress category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressCategoryPersistence
 * @see BridgeProgressCategoryUtil
 * @generated
 */
public class BridgeProgressCategoryPersistenceImpl extends BasePersistenceImpl<BridgeProgressCategory>
	implements BridgeProgressCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgeProgressCategoryUtil} to access the bridge progress category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgeProgressCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME = new FinderPath(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryModelImpl.FINDER_CACHE_ENABLED,
			BridgeProgressCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByprogressCategoryName",
			new String[] { String.class.getName() },
			BridgeProgressCategoryModelImpl.PROGRESSCATEGORYNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PROGRESSCATEGORYNAME = new FinderPath(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByprogressCategoryName",
			new String[] { String.class.getName() });

	/**
	 * Returns the bridge progress category where progressCategoryName = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException} if it could not be found.
	 *
	 * @param progressCategoryName the progress category name
	 * @return the matching bridge progress category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a matching bridge progress category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory findByprogressCategoryName(
		String progressCategoryName)
		throws NoSuchBridgeProgressCategoryException, SystemException {
		BridgeProgressCategory bridgeProgressCategory = fetchByprogressCategoryName(progressCategoryName);

		if (bridgeProgressCategory == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("progressCategoryName=");
			msg.append(progressCategoryName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBridgeProgressCategoryException(msg.toString());
		}

		return bridgeProgressCategory;
	}

	/**
	 * Returns the bridge progress category where progressCategoryName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param progressCategoryName the progress category name
	 * @return the matching bridge progress category, or <code>null</code> if a matching bridge progress category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory fetchByprogressCategoryName(
		String progressCategoryName) throws SystemException {
		return fetchByprogressCategoryName(progressCategoryName, true);
	}

	/**
	 * Returns the bridge progress category where progressCategoryName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param progressCategoryName the progress category name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bridge progress category, or <code>null</code> if a matching bridge progress category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory fetchByprogressCategoryName(
		String progressCategoryName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { progressCategoryName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
					finderArgs, this);
		}

		if (result instanceof BridgeProgressCategory) {
			BridgeProgressCategory bridgeProgressCategory = (BridgeProgressCategory)result;

			if (!Validator.equals(progressCategoryName,
						bridgeProgressCategory.getProgressCategoryName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BRIDGEPROGRESSCATEGORY_WHERE);

			boolean bindProgressCategoryName = false;

			if (progressCategoryName == null) {
				query.append(_FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_1);
			}
			else if (progressCategoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_3);
			}
			else {
				bindProgressCategoryName = true;

				query.append(_FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProgressCategoryName) {
					qPos.add(progressCategoryName);
				}

				List<BridgeProgressCategory> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BridgeProgressCategoryPersistenceImpl.fetchByprogressCategoryName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BridgeProgressCategory bridgeProgressCategory = list.get(0);

					result = bridgeProgressCategory;

					cacheResult(bridgeProgressCategory);

					if ((bridgeProgressCategory.getProgressCategoryName() == null) ||
							!bridgeProgressCategory.getProgressCategoryName()
													   .equals(progressCategoryName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
							finderArgs, bridgeProgressCategory);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
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
			return (BridgeProgressCategory)result;
		}
	}

	/**
	 * Removes the bridge progress category where progressCategoryName = &#63; from the database.
	 *
	 * @param progressCategoryName the progress category name
	 * @return the bridge progress category that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory removeByprogressCategoryName(
		String progressCategoryName)
		throws NoSuchBridgeProgressCategoryException, SystemException {
		BridgeProgressCategory bridgeProgressCategory = findByprogressCategoryName(progressCategoryName);

		return remove(bridgeProgressCategory);
	}

	/**
	 * Returns the number of bridge progress categories where progressCategoryName = &#63;.
	 *
	 * @param progressCategoryName the progress category name
	 * @return the number of matching bridge progress categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByprogressCategoryName(String progressCategoryName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PROGRESSCATEGORYNAME;

		Object[] finderArgs = new Object[] { progressCategoryName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BRIDGEPROGRESSCATEGORY_WHERE);

			boolean bindProgressCategoryName = false;

			if (progressCategoryName == null) {
				query.append(_FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_1);
			}
			else if (progressCategoryName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_3);
			}
			else {
				bindProgressCategoryName = true;

				query.append(_FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindProgressCategoryName) {
					qPos.add(progressCategoryName);
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

	private static final String _FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_1 =
		"bridgeProgressCategory.progressCategoryName IS NULL";
	private static final String _FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_2 =
		"bridgeProgressCategory.progressCategoryName = ?";
	private static final String _FINDER_COLUMN_PROGRESSCATEGORYNAME_PROGRESSCATEGORYNAME_3 =
		"(bridgeProgressCategory.progressCategoryName IS NULL OR bridgeProgressCategory.progressCategoryName = '')";

	public BridgeProgressCategoryPersistenceImpl() {
		setModelClass(BridgeProgressCategory.class);
	}

	/**
	 * Caches the bridge progress category in the entity cache if it is enabled.
	 *
	 * @param bridgeProgressCategory the bridge progress category
	 */
	@Override
	public void cacheResult(BridgeProgressCategory bridgeProgressCategory) {
		EntityCacheUtil.putResult(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryImpl.class,
			bridgeProgressCategory.getPrimaryKey(), bridgeProgressCategory);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
			new Object[] { bridgeProgressCategory.getProgressCategoryName() },
			bridgeProgressCategory);

		bridgeProgressCategory.resetOriginalValues();
	}

	/**
	 * Caches the bridge progress categories in the entity cache if it is enabled.
	 *
	 * @param bridgeProgressCategories the bridge progress categories
	 */
	@Override
	public void cacheResult(
		List<BridgeProgressCategory> bridgeProgressCategories) {
		for (BridgeProgressCategory bridgeProgressCategory : bridgeProgressCategories) {
			if (EntityCacheUtil.getResult(
						BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
						BridgeProgressCategoryImpl.class,
						bridgeProgressCategory.getPrimaryKey()) == null) {
				cacheResult(bridgeProgressCategory);
			}
			else {
				bridgeProgressCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge progress categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgeProgressCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgeProgressCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge progress category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgeProgressCategory bridgeProgressCategory) {
		EntityCacheUtil.removeResult(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryImpl.class,
			bridgeProgressCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(bridgeProgressCategory);
	}

	@Override
	public void clearCache(
		List<BridgeProgressCategory> bridgeProgressCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgeProgressCategory bridgeProgressCategory : bridgeProgressCategories) {
			EntityCacheUtil.removeResult(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
				BridgeProgressCategoryImpl.class,
				bridgeProgressCategory.getPrimaryKey());

			clearUniqueFindersCache(bridgeProgressCategory);
		}
	}

	protected void cacheUniqueFindersCache(
		BridgeProgressCategory bridgeProgressCategory) {
		if (bridgeProgressCategory.isNew()) {
			Object[] args = new Object[] {
					bridgeProgressCategory.getProgressCategoryName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROGRESSCATEGORYNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
				args, bridgeProgressCategory);
		}
		else {
			BridgeProgressCategoryModelImpl bridgeProgressCategoryModelImpl = (BridgeProgressCategoryModelImpl)bridgeProgressCategory;

			if ((bridgeProgressCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						bridgeProgressCategory.getProgressCategoryName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROGRESSCATEGORYNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
					args, bridgeProgressCategory);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BridgeProgressCategory bridgeProgressCategory) {
		BridgeProgressCategoryModelImpl bridgeProgressCategoryModelImpl = (BridgeProgressCategoryModelImpl)bridgeProgressCategory;

		Object[] args = new Object[] {
				bridgeProgressCategory.getProgressCategoryName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROGRESSCATEGORYNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
			args);

		if ((bridgeProgressCategoryModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					bridgeProgressCategoryModelImpl.getOriginalProgressCategoryName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROGRESSCATEGORYNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROGRESSCATEGORYNAME,
				args);
		}
	}

	/**
	 * Creates a new bridge progress category with the primary key. Does not add the bridge progress category to the database.
	 *
	 * @param progressCategoryId the primary key for the new bridge progress category
	 * @return the new bridge progress category
	 */
	@Override
	public BridgeProgressCategory create(long progressCategoryId) {
		BridgeProgressCategory bridgeProgressCategory = new BridgeProgressCategoryImpl();

		bridgeProgressCategory.setNew(true);
		bridgeProgressCategory.setPrimaryKey(progressCategoryId);

		return bridgeProgressCategory;
	}

	/**
	 * Removes the bridge progress category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progressCategoryId the primary key of the bridge progress category
	 * @return the bridge progress category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a bridge progress category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory remove(long progressCategoryId)
		throws NoSuchBridgeProgressCategoryException, SystemException {
		return remove((Serializable)progressCategoryId);
	}

	/**
	 * Removes the bridge progress category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge progress category
	 * @return the bridge progress category that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a bridge progress category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory remove(Serializable primaryKey)
		throws NoSuchBridgeProgressCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgeProgressCategory bridgeProgressCategory = (BridgeProgressCategory)session.get(BridgeProgressCategoryImpl.class,
					primaryKey);

			if (bridgeProgressCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgeProgressCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgeProgressCategory);
		}
		catch (NoSuchBridgeProgressCategoryException nsee) {
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
	protected BridgeProgressCategory removeImpl(
		BridgeProgressCategory bridgeProgressCategory)
		throws SystemException {
		bridgeProgressCategory = toUnwrappedModel(bridgeProgressCategory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgeProgressCategory)) {
				bridgeProgressCategory = (BridgeProgressCategory)session.get(BridgeProgressCategoryImpl.class,
						bridgeProgressCategory.getPrimaryKeyObj());
			}

			if (bridgeProgressCategory != null) {
				session.delete(bridgeProgressCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgeProgressCategory != null) {
			clearCache(bridgeProgressCategory);
		}

		return bridgeProgressCategory;
	}

	@Override
	public BridgeProgressCategory updateImpl(
		com.ihg.brandstandards.db.model.BridgeProgressCategory bridgeProgressCategory)
		throws SystemException {
		bridgeProgressCategory = toUnwrappedModel(bridgeProgressCategory);

		boolean isNew = bridgeProgressCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bridgeProgressCategory.isNew()) {
				session.save(bridgeProgressCategory);

				bridgeProgressCategory.setNew(false);
			}
			else {
				session.merge(bridgeProgressCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BridgeProgressCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
			BridgeProgressCategoryImpl.class,
			bridgeProgressCategory.getPrimaryKey(), bridgeProgressCategory);

		clearUniqueFindersCache(bridgeProgressCategory);
		cacheUniqueFindersCache(bridgeProgressCategory);

		return bridgeProgressCategory;
	}

	protected BridgeProgressCategory toUnwrappedModel(
		BridgeProgressCategory bridgeProgressCategory) {
		if (bridgeProgressCategory instanceof BridgeProgressCategoryImpl) {
			return bridgeProgressCategory;
		}

		BridgeProgressCategoryImpl bridgeProgressCategoryImpl = new BridgeProgressCategoryImpl();

		bridgeProgressCategoryImpl.setNew(bridgeProgressCategory.isNew());
		bridgeProgressCategoryImpl.setPrimaryKey(bridgeProgressCategory.getPrimaryKey());

		bridgeProgressCategoryImpl.setProgressCategoryId(bridgeProgressCategory.getProgressCategoryId());
		bridgeProgressCategoryImpl.setProgressCategoryName(bridgeProgressCategory.getProgressCategoryName());
		bridgeProgressCategoryImpl.setDisplayOrderNumber(bridgeProgressCategory.getDisplayOrderNumber());
		bridgeProgressCategoryImpl.setCreatorId(bridgeProgressCategory.getCreatorId());
		bridgeProgressCategoryImpl.setCreatedDate(bridgeProgressCategory.getCreatedDate());
		bridgeProgressCategoryImpl.setUpdatedBy(bridgeProgressCategory.getUpdatedBy());
		bridgeProgressCategoryImpl.setUpdatedDate(bridgeProgressCategory.getUpdatedDate());

		return bridgeProgressCategoryImpl;
	}

	/**
	 * Returns the bridge progress category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge progress category
	 * @return the bridge progress category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a bridge progress category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgeProgressCategoryException, SystemException {
		BridgeProgressCategory bridgeProgressCategory = fetchByPrimaryKey(primaryKey);

		if (bridgeProgressCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgeProgressCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgeProgressCategory;
	}

	/**
	 * Returns the bridge progress category with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException} if it could not be found.
	 *
	 * @param progressCategoryId the primary key of the bridge progress category
	 * @return the bridge progress category
	 * @throws com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException if a bridge progress category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory findByPrimaryKey(long progressCategoryId)
		throws NoSuchBridgeProgressCategoryException, SystemException {
		return findByPrimaryKey((Serializable)progressCategoryId);
	}

	/**
	 * Returns the bridge progress category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge progress category
	 * @return the bridge progress category, or <code>null</code> if a bridge progress category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgeProgressCategory bridgeProgressCategory = (BridgeProgressCategory)EntityCacheUtil.getResult(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
				BridgeProgressCategoryImpl.class, primaryKey);

		if (bridgeProgressCategory == _nullBridgeProgressCategory) {
			return null;
		}

		if (bridgeProgressCategory == null) {
			Session session = null;

			try {
				session = openSession();

				bridgeProgressCategory = (BridgeProgressCategory)session.get(BridgeProgressCategoryImpl.class,
						primaryKey);

				if (bridgeProgressCategory != null) {
					cacheResult(bridgeProgressCategory);
				}
				else {
					EntityCacheUtil.putResult(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
						BridgeProgressCategoryImpl.class, primaryKey,
						_nullBridgeProgressCategory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgeProgressCategoryModelImpl.ENTITY_CACHE_ENABLED,
					BridgeProgressCategoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgeProgressCategory;
	}

	/**
	 * Returns the bridge progress category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progressCategoryId the primary key of the bridge progress category
	 * @return the bridge progress category, or <code>null</code> if a bridge progress category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgeProgressCategory fetchByPrimaryKey(long progressCategoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)progressCategoryId);
	}

	/**
	 * Returns all the bridge progress categories.
	 *
	 * @return the bridge progress categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge progress categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge progress categories
	 * @param end the upper bound of the range of bridge progress categories (not inclusive)
	 * @return the range of bridge progress categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge progress categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgeProgressCategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge progress categories
	 * @param end the upper bound of the range of bridge progress categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge progress categories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgeProgressCategory> findAll(int start, int end,
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

		List<BridgeProgressCategory> list = (List<BridgeProgressCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPROGRESSCATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPROGRESSCATEGORY;

				if (pagination) {
					sql = sql.concat(BridgeProgressCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgeProgressCategory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgeProgressCategory>(list);
				}
				else {
					list = (List<BridgeProgressCategory>)QueryUtil.list(q,
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
	 * Removes all the bridge progress categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgeProgressCategory bridgeProgressCategory : findAll()) {
			remove(bridgeProgressCategory);
		}
	}

	/**
	 * Returns the number of bridge progress categories.
	 *
	 * @return the number of bridge progress categories
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPROGRESSCATEGORY);

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
	 * Initializes the bridge progress category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgeProgressCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgeProgressCategory>> listenersList = new ArrayList<ModelListener<BridgeProgressCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgeProgressCategory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgeProgressCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPROGRESSCATEGORY = "SELECT bridgeProgressCategory FROM BridgeProgressCategory bridgeProgressCategory";
	private static final String _SQL_SELECT_BRIDGEPROGRESSCATEGORY_WHERE = "SELECT bridgeProgressCategory FROM BridgeProgressCategory bridgeProgressCategory WHERE ";
	private static final String _SQL_COUNT_BRIDGEPROGRESSCATEGORY = "SELECT COUNT(bridgeProgressCategory) FROM BridgeProgressCategory bridgeProgressCategory";
	private static final String _SQL_COUNT_BRIDGEPROGRESSCATEGORY_WHERE = "SELECT COUNT(bridgeProgressCategory) FROM BridgeProgressCategory bridgeProgressCategory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgeProgressCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgeProgressCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BridgeProgressCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgeProgressCategoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"progressCategoryId", "progressCategoryName",
				"displayOrderNumber", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static BridgeProgressCategory _nullBridgeProgressCategory = new BridgeProgressCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgeProgressCategory> toCacheModel() {
				return _nullBridgeProgressCategoryCacheModel;
			}
		};

	private static CacheModel<BridgeProgressCategory> _nullBridgeProgressCategoryCacheModel =
		new CacheModel<BridgeProgressCategory>() {
			@Override
			public BridgeProgressCategory toEntityModel() {
				return _nullBridgeProgressCategory;
			}
		};
}