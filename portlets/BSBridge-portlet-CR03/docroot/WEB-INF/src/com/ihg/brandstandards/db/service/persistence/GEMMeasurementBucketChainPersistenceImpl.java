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

import com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException;
import com.ihg.brandstandards.db.model.GEMMeasurementBucketChain;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainImpl;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the g e m measurement bucket chain service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementBucketChainPersistence
 * @see GEMMeasurementBucketChainUtil
 * @generated
 */
public class GEMMeasurementBucketChainPersistenceImpl
	extends BasePersistenceImpl<GEMMeasurementBucketChain>
	implements GEMMeasurementBucketChainPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMMeasurementBucketChainUtil} to access the g e m measurement bucket chain persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMMeasurementBucketChainImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementBucketChainModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementBucketChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementBucketChainModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementBucketChainImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementBucketChainModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public GEMMeasurementBucketChainPersistenceImpl() {
		setModelClass(GEMMeasurementBucketChain.class);
	}

	/**
	 * Caches the g e m measurement bucket chain in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementBucketChain the g e m measurement bucket chain
	 */
	@Override
	public void cacheResult(GEMMeasurementBucketChain gemMeasurementBucketChain) {
		EntityCacheUtil.putResult(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementBucketChainImpl.class,
			gemMeasurementBucketChain.getPrimaryKey(), gemMeasurementBucketChain);

		gemMeasurementBucketChain.resetOriginalValues();
	}

	/**
	 * Caches the g e m measurement bucket chains in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementBucketChains the g e m measurement bucket chains
	 */
	@Override
	public void cacheResult(
		List<GEMMeasurementBucketChain> gemMeasurementBucketChains) {
		for (GEMMeasurementBucketChain gemMeasurementBucketChain : gemMeasurementBucketChains) {
			if (EntityCacheUtil.getResult(
						GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementBucketChainImpl.class,
						gemMeasurementBucketChain.getPrimaryKey()) == null) {
				cacheResult(gemMeasurementBucketChain);
			}
			else {
				gemMeasurementBucketChain.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m measurement bucket chains.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMMeasurementBucketChainImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMMeasurementBucketChainImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m measurement bucket chain.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMMeasurementBucketChain gemMeasurementBucketChain) {
		EntityCacheUtil.removeResult(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementBucketChainImpl.class,
			gemMeasurementBucketChain.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<GEMMeasurementBucketChain> gemMeasurementBucketChains) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMMeasurementBucketChain gemMeasurementBucketChain : gemMeasurementBucketChains) {
			EntityCacheUtil.removeResult(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementBucketChainImpl.class,
				gemMeasurementBucketChain.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m measurement bucket chain with the primary key. Does not add the g e m measurement bucket chain to the database.
	 *
	 * @param measurementBucketChainId the primary key for the new g e m measurement bucket chain
	 * @return the new g e m measurement bucket chain
	 */
	@Override
	public GEMMeasurementBucketChain create(long measurementBucketChainId) {
		GEMMeasurementBucketChain gemMeasurementBucketChain = new GEMMeasurementBucketChainImpl();

		gemMeasurementBucketChain.setNew(true);
		gemMeasurementBucketChain.setPrimaryKey(measurementBucketChainId);

		return gemMeasurementBucketChain;
	}

	/**
	 * Removes the g e m measurement bucket chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	 * @return the g e m measurement bucket chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException if a g e m measurement bucket chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementBucketChain remove(long measurementBucketChainId)
		throws NoSuchGEMMeasurementBucketChainException, SystemException {
		return remove((Serializable)measurementBucketChainId);
	}

	/**
	 * Removes the g e m measurement bucket chain with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m measurement bucket chain
	 * @return the g e m measurement bucket chain that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException if a g e m measurement bucket chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementBucketChain remove(Serializable primaryKey)
		throws NoSuchGEMMeasurementBucketChainException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMMeasurementBucketChain gemMeasurementBucketChain = (GEMMeasurementBucketChain)session.get(GEMMeasurementBucketChainImpl.class,
					primaryKey);

			if (gemMeasurementBucketChain == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMMeasurementBucketChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemMeasurementBucketChain);
		}
		catch (NoSuchGEMMeasurementBucketChainException nsee) {
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
	protected GEMMeasurementBucketChain removeImpl(
		GEMMeasurementBucketChain gemMeasurementBucketChain)
		throws SystemException {
		gemMeasurementBucketChain = toUnwrappedModel(gemMeasurementBucketChain);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemMeasurementBucketChain)) {
				gemMeasurementBucketChain = (GEMMeasurementBucketChain)session.get(GEMMeasurementBucketChainImpl.class,
						gemMeasurementBucketChain.getPrimaryKeyObj());
			}

			if (gemMeasurementBucketChain != null) {
				session.delete(gemMeasurementBucketChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemMeasurementBucketChain != null) {
			clearCache(gemMeasurementBucketChain);
		}

		return gemMeasurementBucketChain;
	}

	@Override
	public GEMMeasurementBucketChain updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementBucketChain gemMeasurementBucketChain)
		throws SystemException {
		gemMeasurementBucketChain = toUnwrappedModel(gemMeasurementBucketChain);

		boolean isNew = gemMeasurementBucketChain.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemMeasurementBucketChain.isNew()) {
				session.save(gemMeasurementBucketChain);

				gemMeasurementBucketChain.setNew(false);
			}
			else {
				session.merge(gemMeasurementBucketChain);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementBucketChainImpl.class,
			gemMeasurementBucketChain.getPrimaryKey(), gemMeasurementBucketChain);

		return gemMeasurementBucketChain;
	}

	protected GEMMeasurementBucketChain toUnwrappedModel(
		GEMMeasurementBucketChain gemMeasurementBucketChain) {
		if (gemMeasurementBucketChain instanceof GEMMeasurementBucketChainImpl) {
			return gemMeasurementBucketChain;
		}

		GEMMeasurementBucketChainImpl gemMeasurementBucketChainImpl = new GEMMeasurementBucketChainImpl();

		gemMeasurementBucketChainImpl.setNew(gemMeasurementBucketChain.isNew());
		gemMeasurementBucketChainImpl.setPrimaryKey(gemMeasurementBucketChain.getPrimaryKey());

		gemMeasurementBucketChainImpl.setMeasurementBucketChainId(gemMeasurementBucketChain.getMeasurementBucketChainId());
		gemMeasurementBucketChainImpl.setBucketId(gemMeasurementBucketChain.getBucketId());
		gemMeasurementBucketChainImpl.setSeverityId(gemMeasurementBucketChain.getSeverityId());
		gemMeasurementBucketChainImpl.setMeasurementId(gemMeasurementBucketChain.getMeasurementId());
		gemMeasurementBucketChainImpl.setPublishDeptId(gemMeasurementBucketChain.getPublishDeptId());
		gemMeasurementBucketChainImpl.setPublishId(gemMeasurementBucketChain.getPublishId());
		gemMeasurementBucketChainImpl.setRegionId(gemMeasurementBucketChain.getRegionId());
		gemMeasurementBucketChainImpl.setSubRegionCd(gemMeasurementBucketChain.getSubRegionCd());
		gemMeasurementBucketChainImpl.setCreatorId(gemMeasurementBucketChain.getCreatorId());
		gemMeasurementBucketChainImpl.setCreatedDate(gemMeasurementBucketChain.getCreatedDate());
		gemMeasurementBucketChainImpl.setUpdatedBy(gemMeasurementBucketChain.getUpdatedBy());
		gemMeasurementBucketChainImpl.setUpdatedDate(gemMeasurementBucketChain.getUpdatedDate());

		return gemMeasurementBucketChainImpl;
	}

	/**
	 * Returns the g e m measurement bucket chain with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement bucket chain
	 * @return the g e m measurement bucket chain
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException if a g e m measurement bucket chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementBucketChain findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMMeasurementBucketChainException, SystemException {
		GEMMeasurementBucketChain gemMeasurementBucketChain = fetchByPrimaryKey(primaryKey);

		if (gemMeasurementBucketChain == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMMeasurementBucketChainException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemMeasurementBucketChain;
	}

	/**
	 * Returns the g e m measurement bucket chain with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException} if it could not be found.
	 *
	 * @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	 * @return the g e m measurement bucket chain
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException if a g e m measurement bucket chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementBucketChain findByPrimaryKey(
		long measurementBucketChainId)
		throws NoSuchGEMMeasurementBucketChainException, SystemException {
		return findByPrimaryKey((Serializable)measurementBucketChainId);
	}

	/**
	 * Returns the g e m measurement bucket chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement bucket chain
	 * @return the g e m measurement bucket chain, or <code>null</code> if a g e m measurement bucket chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementBucketChain fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMMeasurementBucketChain gemMeasurementBucketChain = (GEMMeasurementBucketChain)EntityCacheUtil.getResult(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementBucketChainImpl.class, primaryKey);

		if (gemMeasurementBucketChain == _nullGEMMeasurementBucketChain) {
			return null;
		}

		if (gemMeasurementBucketChain == null) {
			Session session = null;

			try {
				session = openSession();

				gemMeasurementBucketChain = (GEMMeasurementBucketChain)session.get(GEMMeasurementBucketChainImpl.class,
						primaryKey);

				if (gemMeasurementBucketChain != null) {
					cacheResult(gemMeasurementBucketChain);
				}
				else {
					EntityCacheUtil.putResult(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementBucketChainImpl.class, primaryKey,
						_nullGEMMeasurementBucketChain);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMMeasurementBucketChainModelImpl.ENTITY_CACHE_ENABLED,
					GEMMeasurementBucketChainImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemMeasurementBucketChain;
	}

	/**
	 * Returns the g e m measurement bucket chain with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param measurementBucketChainId the primary key of the g e m measurement bucket chain
	 * @return the g e m measurement bucket chain, or <code>null</code> if a g e m measurement bucket chain with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementBucketChain fetchByPrimaryKey(
		long measurementBucketChainId) throws SystemException {
		return fetchByPrimaryKey((Serializable)measurementBucketChainId);
	}

	/**
	 * Returns all the g e m measurement bucket chains.
	 *
	 * @return the g e m measurement bucket chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementBucketChain> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m measurement bucket chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement bucket chains
	 * @param end the upper bound of the range of g e m measurement bucket chains (not inclusive)
	 * @return the range of g e m measurement bucket chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementBucketChain> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m measurement bucket chains.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement bucket chains
	 * @param end the upper bound of the range of g e m measurement bucket chains (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m measurement bucket chains
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementBucketChain> findAll(int start, int end,
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

		List<GEMMeasurementBucketChain> list = (List<GEMMeasurementBucketChain>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMMEASUREMENTBUCKETCHAIN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMMEASUREMENTBUCKETCHAIN;

				if (pagination) {
					sql = sql.concat(GEMMeasurementBucketChainModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMMeasurementBucketChain>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMMeasurementBucketChain>(list);
				}
				else {
					list = (List<GEMMeasurementBucketChain>)QueryUtil.list(q,
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
	 * Removes all the g e m measurement bucket chains from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMMeasurementBucketChain gemMeasurementBucketChain : findAll()) {
			remove(gemMeasurementBucketChain);
		}
	}

	/**
	 * Returns the number of g e m measurement bucket chains.
	 *
	 * @return the number of g e m measurement bucket chains
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

				Query q = session.createQuery(_SQL_COUNT_GEMMEASUREMENTBUCKETCHAIN);

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
	 * Initializes the g e m measurement bucket chain persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMMeasurementBucketChain")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMMeasurementBucketChain>> listenersList = new ArrayList<ModelListener<GEMMeasurementBucketChain>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMMeasurementBucketChain>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMMeasurementBucketChainImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMMEASUREMENTBUCKETCHAIN = "SELECT gemMeasurementBucketChain FROM GEMMeasurementBucketChain gemMeasurementBucketChain";
	private static final String _SQL_COUNT_GEMMEASUREMENTBUCKETCHAIN = "SELECT COUNT(gemMeasurementBucketChain) FROM GEMMeasurementBucketChain gemMeasurementBucketChain";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemMeasurementBucketChain.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMMeasurementBucketChain exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMMeasurementBucketChainPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"measurementBucketChainId", "bucketId", "severityId",
				"measurementId", "publishDeptId", "publishId", "regionId",
				"subRegionCd", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static GEMMeasurementBucketChain _nullGEMMeasurementBucketChain = new GEMMeasurementBucketChainImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMMeasurementBucketChain> toCacheModel() {
				return _nullGEMMeasurementBucketChainCacheModel;
			}
		};

	private static CacheModel<GEMMeasurementBucketChain> _nullGEMMeasurementBucketChainCacheModel =
		new CacheModel<GEMMeasurementBucketChain>() {
			@Override
			public GEMMeasurementBucketChain toEntityModel() {
				return _nullGEMMeasurementBucketChain;
			}
		};
}