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

import com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException;
import com.ihg.brandstandards.db.model.BridgePublishCountryStateEx;
import com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl;

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
 * The persistence implementation for the bridge publish country state ex service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishCountryStateExPersistence
 * @see BridgePublishCountryStateExUtil
 * @generated
 */
public class BridgePublishCountryStateExPersistenceImpl
	extends BasePersistenceImpl<BridgePublishCountryStateEx>
	implements BridgePublishCountryStateExPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishCountryStateExUtil} to access the bridge publish country state ex persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishCountryStateExImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryStateExModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishCountryStateExImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryStateExModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishCountryStateExImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryStateExModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public BridgePublishCountryStateExPersistenceImpl() {
		setModelClass(BridgePublishCountryStateEx.class);
	}

	/**
	 * Caches the bridge publish country state ex in the entity cache if it is enabled.
	 *
	 * @param bridgePublishCountryStateEx the bridge publish country state ex
	 */
	@Override
	public void cacheResult(
		BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		EntityCacheUtil.putResult(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryStateExImpl.class,
			bridgePublishCountryStateEx.getPrimaryKey(),
			bridgePublishCountryStateEx);

		bridgePublishCountryStateEx.resetOriginalValues();
	}

	/**
	 * Caches the bridge publish country state exs in the entity cache if it is enabled.
	 *
	 * @param bridgePublishCountryStateExs the bridge publish country state exs
	 */
	@Override
	public void cacheResult(
		List<BridgePublishCountryStateEx> bridgePublishCountryStateExs) {
		for (BridgePublishCountryStateEx bridgePublishCountryStateEx : bridgePublishCountryStateExs) {
			if (EntityCacheUtil.getResult(
						BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishCountryStateExImpl.class,
						bridgePublishCountryStateEx.getPrimaryKey()) == null) {
				cacheResult(bridgePublishCountryStateEx);
			}
			else {
				bridgePublishCountryStateEx.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publish country state exs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishCountryStateExImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishCountryStateExImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish country state ex.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		EntityCacheUtil.removeResult(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryStateExImpl.class,
			bridgePublishCountryStateEx.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<BridgePublishCountryStateEx> bridgePublishCountryStateExs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublishCountryStateEx bridgePublishCountryStateEx : bridgePublishCountryStateExs) {
			EntityCacheUtil.removeResult(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishCountryStateExImpl.class,
				bridgePublishCountryStateEx.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bridge publish country state ex with the primary key. Does not add the bridge publish country state ex to the database.
	 *
	 * @param bridgePublishCountryStateExPK the primary key for the new bridge publish country state ex
	 * @return the new bridge publish country state ex
	 */
	@Override
	public BridgePublishCountryStateEx create(
		BridgePublishCountryStateExPK bridgePublishCountryStateExPK) {
		BridgePublishCountryStateEx bridgePublishCountryStateEx = new BridgePublishCountryStateExImpl();

		bridgePublishCountryStateEx.setNew(true);
		bridgePublishCountryStateEx.setPrimaryKey(bridgePublishCountryStateExPK);

		return bridgePublishCountryStateEx;
	}

	/**
	 * Removes the bridge publish country state ex with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	 * @return the bridge publish country state ex that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException if a bridge publish country state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountryStateEx remove(
		BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws NoSuchBridgePublishCountryStateExException, SystemException {
		return remove((Serializable)bridgePublishCountryStateExPK);
	}

	/**
	 * Removes the bridge publish country state ex with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish country state ex
	 * @return the bridge publish country state ex that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException if a bridge publish country state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountryStateEx remove(Serializable primaryKey)
		throws NoSuchBridgePublishCountryStateExException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublishCountryStateEx bridgePublishCountryStateEx = (BridgePublishCountryStateEx)session.get(BridgePublishCountryStateExImpl.class,
					primaryKey);

			if (bridgePublishCountryStateEx == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishCountryStateExException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublishCountryStateEx);
		}
		catch (NoSuchBridgePublishCountryStateExException nsee) {
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
	protected BridgePublishCountryStateEx removeImpl(
		BridgePublishCountryStateEx bridgePublishCountryStateEx)
		throws SystemException {
		bridgePublishCountryStateEx = toUnwrappedModel(bridgePublishCountryStateEx);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublishCountryStateEx)) {
				bridgePublishCountryStateEx = (BridgePublishCountryStateEx)session.get(BridgePublishCountryStateExImpl.class,
						bridgePublishCountryStateEx.getPrimaryKeyObj());
			}

			if (bridgePublishCountryStateEx != null) {
				session.delete(bridgePublishCountryStateEx);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublishCountryStateEx != null) {
			clearCache(bridgePublishCountryStateEx);
		}

		return bridgePublishCountryStateEx;
	}

	@Override
	public BridgePublishCountryStateEx updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishCountryStateEx bridgePublishCountryStateEx)
		throws SystemException {
		bridgePublishCountryStateEx = toUnwrappedModel(bridgePublishCountryStateEx);

		boolean isNew = bridgePublishCountryStateEx.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bridgePublishCountryStateEx.isNew()) {
				session.save(bridgePublishCountryStateEx);

				bridgePublishCountryStateEx.setNew(false);
			}
			else {
				session.merge(bridgePublishCountryStateEx);
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

		EntityCacheUtil.putResult(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishCountryStateExImpl.class,
			bridgePublishCountryStateEx.getPrimaryKey(),
			bridgePublishCountryStateEx);

		return bridgePublishCountryStateEx;
	}

	protected BridgePublishCountryStateEx toUnwrappedModel(
		BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		if (bridgePublishCountryStateEx instanceof BridgePublishCountryStateExImpl) {
			return bridgePublishCountryStateEx;
		}

		BridgePublishCountryStateExImpl bridgePublishCountryStateExImpl = new BridgePublishCountryStateExImpl();

		bridgePublishCountryStateExImpl.setNew(bridgePublishCountryStateEx.isNew());
		bridgePublishCountryStateExImpl.setPrimaryKey(bridgePublishCountryStateEx.getPrimaryKey());

		bridgePublishCountryStateExImpl.setStdId(bridgePublishCountryStateEx.getStdId());
		bridgePublishCountryStateExImpl.setCountryCode(bridgePublishCountryStateEx.getCountryCode());
		bridgePublishCountryStateExImpl.setParentStdId(bridgePublishCountryStateEx.getParentStdId());
		bridgePublishCountryStateExImpl.setType(bridgePublishCountryStateEx.getType());
		bridgePublishCountryStateExImpl.setPublishId(bridgePublishCountryStateEx.getPublishId());
		bridgePublishCountryStateExImpl.setStateCd(bridgePublishCountryStateEx.getStateCd());

		return bridgePublishCountryStateExImpl;
	}

	/**
	 * Returns the bridge publish country state ex with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish country state ex
	 * @return the bridge publish country state ex
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException if a bridge publish country state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountryStateEx findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishCountryStateExException, SystemException {
		BridgePublishCountryStateEx bridgePublishCountryStateEx = fetchByPrimaryKey(primaryKey);

		if (bridgePublishCountryStateEx == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishCountryStateExException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublishCountryStateEx;
	}

	/**
	 * Returns the bridge publish country state ex with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException} if it could not be found.
	 *
	 * @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	 * @return the bridge publish country state ex
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException if a bridge publish country state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountryStateEx findByPrimaryKey(
		BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws NoSuchBridgePublishCountryStateExException, SystemException {
		return findByPrimaryKey((Serializable)bridgePublishCountryStateExPK);
	}

	/**
	 * Returns the bridge publish country state ex with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish country state ex
	 * @return the bridge publish country state ex, or <code>null</code> if a bridge publish country state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountryStateEx fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		BridgePublishCountryStateEx bridgePublishCountryStateEx = (BridgePublishCountryStateEx)EntityCacheUtil.getResult(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishCountryStateExImpl.class, primaryKey);

		if (bridgePublishCountryStateEx == _nullBridgePublishCountryStateEx) {
			return null;
		}

		if (bridgePublishCountryStateEx == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublishCountryStateEx = (BridgePublishCountryStateEx)session.get(BridgePublishCountryStateExImpl.class,
						primaryKey);

				if (bridgePublishCountryStateEx != null) {
					cacheResult(bridgePublishCountryStateEx);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishCountryStateExImpl.class, primaryKey,
						_nullBridgePublishCountryStateEx);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishCountryStateExModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishCountryStateExImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublishCountryStateEx;
	}

	/**
	 * Returns the bridge publish country state ex with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bridgePublishCountryStateExPK the primary key of the bridge publish country state ex
	 * @return the bridge publish country state ex, or <code>null</code> if a bridge publish country state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishCountryStateEx fetchByPrimaryKey(
		BridgePublishCountryStateExPK bridgePublishCountryStateExPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)bridgePublishCountryStateExPK);
	}

	/**
	 * Returns all the bridge publish country state exs.
	 *
	 * @return the bridge publish country state exs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountryStateEx> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish country state exs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish country state exs
	 * @param end the upper bound of the range of bridge publish country state exs (not inclusive)
	 * @return the range of bridge publish country state exs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountryStateEx> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish country state exs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish country state exs
	 * @param end the upper bound of the range of bridge publish country state exs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publish country state exs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishCountryStateEx> findAll(int start, int end,
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

		List<BridgePublishCountryStateEx> list = (List<BridgePublishCountryStateEx>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISHCOUNTRYSTATEEX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISHCOUNTRYSTATEEX;

				if (pagination) {
					sql = sql.concat(BridgePublishCountryStateExModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublishCountryStateEx>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishCountryStateEx>(list);
				}
				else {
					list = (List<BridgePublishCountryStateEx>)QueryUtil.list(q,
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
	 * Removes all the bridge publish country state exs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublishCountryStateEx bridgePublishCountryStateEx : findAll()) {
			remove(bridgePublishCountryStateEx);
		}
	}

	/**
	 * Returns the number of bridge publish country state exs.
	 *
	 * @return the number of bridge publish country state exs
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISHCOUNTRYSTATEEX);

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
	 * Initializes the bridge publish country state ex persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublishCountryStateEx")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublishCountryStateEx>> listenersList = new ArrayList<ModelListener<BridgePublishCountryStateEx>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublishCountryStateEx>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishCountryStateExImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISHCOUNTRYSTATEEX = "SELECT bridgePublishCountryStateEx FROM BridgePublishCountryStateEx bridgePublishCountryStateEx";
	private static final String _SQL_COUNT_BRIDGEPUBLISHCOUNTRYSTATEEX = "SELECT COUNT(bridgePublishCountryStateEx) FROM BridgePublishCountryStateEx bridgePublishCountryStateEx";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublishCountryStateEx.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublishCountryStateEx exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishCountryStateExPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"stdId", "CountryCode", "parentStdId", "type", "publishId",
				"stateCd"
			});
	private static BridgePublishCountryStateEx _nullBridgePublishCountryStateEx = new BridgePublishCountryStateExImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublishCountryStateEx> toCacheModel() {
				return _nullBridgePublishCountryStateExCacheModel;
			}
		};

	private static CacheModel<BridgePublishCountryStateEx> _nullBridgePublishCountryStateExCacheModel =
		new CacheModel<BridgePublishCountryStateEx>() {
			@Override
			public BridgePublishCountryStateEx toEntityModel() {
				return _nullBridgePublishCountryStateEx;
			}
		};
}