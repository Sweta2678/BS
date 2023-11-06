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

import com.ihg.brandstandards.db.NoSuchTaxonomyExtException;
import com.ihg.brandstandards.db.model.TaxonomyExt;
import com.ihg.brandstandards.db.model.impl.TaxonomyExtImpl;
import com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl;

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
 * The persistence implementation for the Custom Query mapping to create index path. service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyExtPersistence
 * @see TaxonomyExtUtil
 * @generated
 */
public class TaxonomyExtPersistenceImpl extends BasePersistenceImpl<TaxonomyExt>
	implements TaxonomyExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaxonomyExtUtil} to access the Custom Query mapping to create index path. persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaxonomyExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtModelImpl.FINDER_CACHE_ENABLED, TaxonomyExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtModelImpl.FINDER_CACHE_ENABLED, TaxonomyExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_TAXID = new FinderPath(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtModelImpl.FINDER_CACHE_ENABLED, TaxonomyExtImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBytaxId",
			new String[] { Long.class.getName() },
			TaxonomyExtModelImpl.TAXID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TAXID = new FinderPath(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytaxId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the Custom Query mapping to create index path. where taxId = &#63; or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyExtException} if it could not be found.
	 *
	 * @param taxId the tax ID
	 * @return the matching Custom Query mapping to create index path.
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a matching Custom Query mapping to create index path. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt findBytaxId(long taxId)
		throws NoSuchTaxonomyExtException, SystemException {
		TaxonomyExt taxonomyExt = fetchBytaxId(taxId);

		if (taxonomyExt == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("taxId=");
			msg.append(taxId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTaxonomyExtException(msg.toString());
		}

		return taxonomyExt;
	}

	/**
	 * Returns the Custom Query mapping to create index path. where taxId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param taxId the tax ID
	 * @return the matching Custom Query mapping to create index path., or <code>null</code> if a matching Custom Query mapping to create index path. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt fetchBytaxId(long taxId) throws SystemException {
		return fetchBytaxId(taxId, true);
	}

	/**
	 * Returns the Custom Query mapping to create index path. where taxId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param taxId the tax ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching Custom Query mapping to create index path., or <code>null</code> if a matching Custom Query mapping to create index path. could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt fetchBytaxId(long taxId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { taxId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TAXID,
					finderArgs, this);
		}

		if (result instanceof TaxonomyExt) {
			TaxonomyExt taxonomyExt = (TaxonomyExt)result;

			if ((taxId != taxonomyExt.getTaxId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TAXONOMYEXT_WHERE);

			query.append(_FINDER_COLUMN_TAXID_TAXID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taxId);

				List<TaxonomyExt> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TaxonomyExtPersistenceImpl.fetchBytaxId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TaxonomyExt taxonomyExt = list.get(0);

					result = taxonomyExt;

					cacheResult(taxonomyExt);

					if ((taxonomyExt.getTaxId() != taxId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID,
							finderArgs, taxonomyExt);
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
			return (TaxonomyExt)result;
		}
	}

	/**
	 * Removes the Custom Query mapping to create index path. where taxId = &#63; from the database.
	 *
	 * @param taxId the tax ID
	 * @return the Custom Query mapping to create index path. that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt removeBytaxId(long taxId)
		throws NoSuchTaxonomyExtException, SystemException {
		TaxonomyExt taxonomyExt = findBytaxId(taxId);

		return remove(taxonomyExt);
	}

	/**
	 * Returns the number of Custom Query mapping to create index path.s where taxId = &#63;.
	 *
	 * @param taxId the tax ID
	 * @return the number of matching Custom Query mapping to create index path.s
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

			query.append(_SQL_COUNT_TAXONOMYEXT_WHERE);

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

	private static final String _FINDER_COLUMN_TAXID_TAXID_2 = "taxonomyExt.taxId = ?";

	public TaxonomyExtPersistenceImpl() {
		setModelClass(TaxonomyExt.class);
	}

	/**
	 * Caches the Custom Query mapping to create index path. in the entity cache if it is enabled.
	 *
	 * @param taxonomyExt the Custom Query mapping to create index path.
	 */
	@Override
	public void cacheResult(TaxonomyExt taxonomyExt) {
		EntityCacheUtil.putResult(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtImpl.class, taxonomyExt.getPrimaryKey(), taxonomyExt);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID,
			new Object[] { taxonomyExt.getTaxId() }, taxonomyExt);

		taxonomyExt.resetOriginalValues();
	}

	/**
	 * Caches the Custom Query mapping to create index path.s in the entity cache if it is enabled.
	 *
	 * @param taxonomyExts the Custom Query mapping to create index path.s
	 */
	@Override
	public void cacheResult(List<TaxonomyExt> taxonomyExts) {
		for (TaxonomyExt taxonomyExt : taxonomyExts) {
			if (EntityCacheUtil.getResult(
						TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyExtImpl.class, taxonomyExt.getPrimaryKey()) == null) {
				cacheResult(taxonomyExt);
			}
			else {
				taxonomyExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all Custom Query mapping to create index path.s.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaxonomyExtImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaxonomyExtImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Custom Query mapping to create index path..
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaxonomyExt taxonomyExt) {
		EntityCacheUtil.removeResult(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtImpl.class, taxonomyExt.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(taxonomyExt);
	}

	@Override
	public void clearCache(List<TaxonomyExt> taxonomyExts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaxonomyExt taxonomyExt : taxonomyExts) {
			EntityCacheUtil.removeResult(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyExtImpl.class, taxonomyExt.getPrimaryKey());

			clearUniqueFindersCache(taxonomyExt);
		}
	}

	protected void cacheUniqueFindersCache(TaxonomyExt taxonomyExt) {
		if (taxonomyExt.isNew()) {
			Object[] args = new Object[] { taxonomyExt.getTaxId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAXID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID, args,
				taxonomyExt);
		}
		else {
			TaxonomyExtModelImpl taxonomyExtModelImpl = (TaxonomyExtModelImpl)taxonomyExt;

			if ((taxonomyExtModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TAXID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { taxonomyExt.getTaxId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAXID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TAXID, args,
					taxonomyExt);
			}
		}
	}

	protected void clearUniqueFindersCache(TaxonomyExt taxonomyExt) {
		TaxonomyExtModelImpl taxonomyExtModelImpl = (TaxonomyExtModelImpl)taxonomyExt;

		Object[] args = new Object[] { taxonomyExt.getTaxId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXID, args);

		if ((taxonomyExtModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TAXID.getColumnBitmask()) != 0) {
			args = new Object[] { taxonomyExtModelImpl.getOriginalTaxId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAXID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TAXID, args);
		}
	}

	/**
	 * Creates a new Custom Query mapping to create index path. with the primary key. Does not add the Custom Query mapping to create index path. to the database.
	 *
	 * @param taxId the primary key for the new Custom Query mapping to create index path.
	 * @return the new Custom Query mapping to create index path.
	 */
	@Override
	public TaxonomyExt create(long taxId) {
		TaxonomyExt taxonomyExt = new TaxonomyExtImpl();

		taxonomyExt.setNew(true);
		taxonomyExt.setPrimaryKey(taxId);

		return taxonomyExt;
	}

	/**
	 * Removes the Custom Query mapping to create index path. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taxId the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt remove(long taxId)
		throws NoSuchTaxonomyExtException, SystemException {
		return remove((Serializable)taxId);
	}

	/**
	 * Removes the Custom Query mapping to create index path. with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path. that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt remove(Serializable primaryKey)
		throws NoSuchTaxonomyExtException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaxonomyExt taxonomyExt = (TaxonomyExt)session.get(TaxonomyExtImpl.class,
					primaryKey);

			if (taxonomyExt == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaxonomyExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taxonomyExt);
		}
		catch (NoSuchTaxonomyExtException nsee) {
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
	protected TaxonomyExt removeImpl(TaxonomyExt taxonomyExt)
		throws SystemException {
		taxonomyExt = toUnwrappedModel(taxonomyExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taxonomyExt)) {
				taxonomyExt = (TaxonomyExt)session.get(TaxonomyExtImpl.class,
						taxonomyExt.getPrimaryKeyObj());
			}

			if (taxonomyExt != null) {
				session.delete(taxonomyExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taxonomyExt != null) {
			clearCache(taxonomyExt);
		}

		return taxonomyExt;
	}

	@Override
	public TaxonomyExt updateImpl(
		com.ihg.brandstandards.db.model.TaxonomyExt taxonomyExt)
		throws SystemException {
		taxonomyExt = toUnwrappedModel(taxonomyExt);

		boolean isNew = taxonomyExt.isNew();

		Session session = null;

		try {
			session = openSession();

			if (taxonomyExt.isNew()) {
				session.save(taxonomyExt);

				taxonomyExt.setNew(false);
			}
			else {
				session.merge(taxonomyExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaxonomyExtModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
			TaxonomyExtImpl.class, taxonomyExt.getPrimaryKey(), taxonomyExt);

		clearUniqueFindersCache(taxonomyExt);
		cacheUniqueFindersCache(taxonomyExt);

		return taxonomyExt;
	}

	protected TaxonomyExt toUnwrappedModel(TaxonomyExt taxonomyExt) {
		if (taxonomyExt instanceof TaxonomyExtImpl) {
			return taxonomyExt;
		}

		TaxonomyExtImpl taxonomyExtImpl = new TaxonomyExtImpl();

		taxonomyExtImpl.setNew(taxonomyExt.isNew());
		taxonomyExtImpl.setPrimaryKey(taxonomyExt.getPrimaryKey());

		taxonomyExtImpl.setTaxId(taxonomyExt.getTaxId());
		taxonomyExtImpl.setParentId(taxonomyExt.getParentId());
		taxonomyExtImpl.setTitle(taxonomyExt.getTitle());
		taxonomyExtImpl.setDesc(taxonomyExt.getDesc());
		taxonomyExtImpl.setImageLoc(taxonomyExt.getImageLoc());
		taxonomyExtImpl.setLvl(taxonomyExt.getLvl());
		taxonomyExtImpl.setPath(taxonomyExt.getPath());
		taxonomyExtImpl.setLevelSortOrder(taxonomyExt.getLevelSortOrder());
		taxonomyExtImpl.setIndexOrder(taxonomyExt.getIndexOrder());

		return taxonomyExtImpl;
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path.
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaxonomyExtException, SystemException {
		TaxonomyExt taxonomyExt = fetchByPrimaryKey(primaryKey);

		if (taxonomyExt == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaxonomyExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taxonomyExt;
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchTaxonomyExtException} if it could not be found.
	 *
	 * @param taxId the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path.
	 * @throws com.ihg.brandstandards.db.NoSuchTaxonomyExtException if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt findByPrimaryKey(long taxId)
		throws NoSuchTaxonomyExtException, SystemException {
		return findByPrimaryKey((Serializable)taxId);
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path., or <code>null</code> if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TaxonomyExt taxonomyExt = (TaxonomyExt)EntityCacheUtil.getResult(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
				TaxonomyExtImpl.class, primaryKey);

		if (taxonomyExt == _nullTaxonomyExt) {
			return null;
		}

		if (taxonomyExt == null) {
			Session session = null;

			try {
				session = openSession();

				taxonomyExt = (TaxonomyExt)session.get(TaxonomyExtImpl.class,
						primaryKey);

				if (taxonomyExt != null) {
					cacheResult(taxonomyExt);
				}
				else {
					EntityCacheUtil.putResult(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
						TaxonomyExtImpl.class, primaryKey, _nullTaxonomyExt);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaxonomyExtModelImpl.ENTITY_CACHE_ENABLED,
					TaxonomyExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taxonomyExt;
	}

	/**
	 * Returns the Custom Query mapping to create index path. with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taxId the primary key of the Custom Query mapping to create index path.
	 * @return the Custom Query mapping to create index path., or <code>null</code> if a Custom Query mapping to create index path. with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaxonomyExt fetchByPrimaryKey(long taxId) throws SystemException {
		return fetchByPrimaryKey((Serializable)taxId);
	}

	/**
	 * Returns all the Custom Query mapping to create index path.s.
	 *
	 * @return the Custom Query mapping to create index path.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyExt> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Custom Query mapping to create index path.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping to create index path.s
	 * @param end the upper bound of the range of Custom Query mapping to create index path.s (not inclusive)
	 * @return the range of Custom Query mapping to create index path.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyExt> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Custom Query mapping to create index path.s.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.TaxonomyExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of Custom Query mapping to create index path.s
	 * @param end the upper bound of the range of Custom Query mapping to create index path.s (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Custom Query mapping to create index path.s
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaxonomyExt> findAll(int start, int end,
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

		List<TaxonomyExt> list = (List<TaxonomyExt>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TAXONOMYEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TAXONOMYEXT;

				if (pagination) {
					sql = sql.concat(TaxonomyExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaxonomyExt>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaxonomyExt>(list);
				}
				else {
					list = (List<TaxonomyExt>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the Custom Query mapping to create index path.s from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TaxonomyExt taxonomyExt : findAll()) {
			remove(taxonomyExt);
		}
	}

	/**
	 * Returns the number of Custom Query mapping to create index path.s.
	 *
	 * @return the number of Custom Query mapping to create index path.s
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

				Query q = session.createQuery(_SQL_COUNT_TAXONOMYEXT);

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
	 * Initializes the Custom Query mapping to create index path. persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.TaxonomyExt")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaxonomyExt>> listenersList = new ArrayList<ModelListener<TaxonomyExt>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaxonomyExt>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TaxonomyExtImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TAXONOMYEXT = "SELECT taxonomyExt FROM TaxonomyExt taxonomyExt";
	private static final String _SQL_SELECT_TAXONOMYEXT_WHERE = "SELECT taxonomyExt FROM TaxonomyExt taxonomyExt WHERE ";
	private static final String _SQL_COUNT_TAXONOMYEXT = "SELECT COUNT(taxonomyExt) FROM TaxonomyExt taxonomyExt";
	private static final String _SQL_COUNT_TAXONOMYEXT_WHERE = "SELECT COUNT(taxonomyExt) FROM TaxonomyExt taxonomyExt WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taxonomyExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaxonomyExt exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaxonomyExt exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaxonomyExtPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"taxId", "parentId", "title", "desc", "imageLoc", "lvl", "path",
				"levelSortOrder", "indexOrder"
			});
	private static TaxonomyExt _nullTaxonomyExt = new TaxonomyExtImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaxonomyExt> toCacheModel() {
				return _nullTaxonomyExtCacheModel;
			}
		};

	private static CacheModel<TaxonomyExt> _nullTaxonomyExtCacheModel = new CacheModel<TaxonomyExt>() {
			@Override
			public TaxonomyExt toEntityModel() {
				return _nullTaxonomyExt;
			}
		};
}