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

import com.ihg.brandstandards.db.NoSuchBridgePublishStateExException;
import com.ihg.brandstandards.db.model.BridgePublishStateEx;
import com.ihg.brandstandards.db.model.impl.BridgePublishStateExImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishStateExModelImpl;

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
 * The persistence implementation for the bridge publish state ex service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishStateExPersistence
 * @see BridgePublishStateExUtil
 * @generated
 */
public class BridgePublishStateExPersistenceImpl extends BasePersistenceImpl<BridgePublishStateEx>
	implements BridgePublishStateExPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishStateExUtil} to access the bridge publish state ex persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishStateExImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStateExModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishStateExImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStateExModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishStateExImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStateExModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BridgePublishStateExPersistenceImpl() {
		setModelClass(BridgePublishStateEx.class);
	}

	/**
	 * Caches the bridge publish state ex in the entity cache if it is enabled.
	 *
	 * @param bridgePublishStateEx the bridge publish state ex
	 */
	@Override
	public void cacheResult(BridgePublishStateEx bridgePublishStateEx) {
		EntityCacheUtil.putResult(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStateExImpl.class,
			bridgePublishStateEx.getPrimaryKey(), bridgePublishStateEx);

		bridgePublishStateEx.resetOriginalValues();
	}

	/**
	 * Caches the bridge publish state exs in the entity cache if it is enabled.
	 *
	 * @param bridgePublishStateExs the bridge publish state exs
	 */
	@Override
	public void cacheResult(List<BridgePublishStateEx> bridgePublishStateExs) {
		for (BridgePublishStateEx bridgePublishStateEx : bridgePublishStateExs) {
			if (EntityCacheUtil.getResult(
						BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishStateExImpl.class,
						bridgePublishStateEx.getPrimaryKey()) == null) {
				cacheResult(bridgePublishStateEx);
			}
			else {
				bridgePublishStateEx.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publish state exs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishStateExImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishStateExImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish state ex.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgePublishStateEx bridgePublishStateEx) {
		EntityCacheUtil.removeResult(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStateExImpl.class, bridgePublishStateEx.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BridgePublishStateEx> bridgePublishStateExs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublishStateEx bridgePublishStateEx : bridgePublishStateExs) {
			EntityCacheUtil.removeResult(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishStateExImpl.class,
				bridgePublishStateEx.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bridge publish state ex with the primary key. Does not add the bridge publish state ex to the database.
	 *
	 * @param bridgePublishStateExPK the primary key for the new bridge publish state ex
	 * @return the new bridge publish state ex
	 */
	@Override
	public BridgePublishStateEx create(
		BridgePublishStateExPK bridgePublishStateExPK) {
		BridgePublishStateEx bridgePublishStateEx = new BridgePublishStateExImpl();

		bridgePublishStateEx.setNew(true);
		bridgePublishStateEx.setPrimaryKey(bridgePublishStateExPK);

		return bridgePublishStateEx;
	}

	/**
	 * Removes the bridge publish state ex with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bridgePublishStateExPK the primary key of the bridge publish state ex
	 * @return the bridge publish state ex that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStateExException if a bridge publish state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStateEx remove(
		BridgePublishStateExPK bridgePublishStateExPK)
		throws NoSuchBridgePublishStateExException, SystemException {
		return remove((Serializable)bridgePublishStateExPK);
	}

	/**
	 * Removes the bridge publish state ex with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish state ex
	 * @return the bridge publish state ex that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStateExException if a bridge publish state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStateEx remove(Serializable primaryKey)
		throws NoSuchBridgePublishStateExException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublishStateEx bridgePublishStateEx = (BridgePublishStateEx)session.get(BridgePublishStateExImpl.class,
					primaryKey);

			if (bridgePublishStateEx == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishStateExException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublishStateEx);
		}
		catch (NoSuchBridgePublishStateExException nsee) {
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
	protected BridgePublishStateEx removeImpl(
		BridgePublishStateEx bridgePublishStateEx) throws SystemException {
		bridgePublishStateEx = toUnwrappedModel(bridgePublishStateEx);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublishStateEx)) {
				bridgePublishStateEx = (BridgePublishStateEx)session.get(BridgePublishStateExImpl.class,
						bridgePublishStateEx.getPrimaryKeyObj());
			}

			if (bridgePublishStateEx != null) {
				session.delete(bridgePublishStateEx);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublishStateEx != null) {
			clearCache(bridgePublishStateEx);
		}

		return bridgePublishStateEx;
	}

	@Override
	public BridgePublishStateEx updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishStateEx bridgePublishStateEx)
		throws SystemException {
		bridgePublishStateEx = toUnwrappedModel(bridgePublishStateEx);

		boolean isNew = bridgePublishStateEx.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bridgePublishStateEx.isNew()) {
				session.save(bridgePublishStateEx);

				bridgePublishStateEx.setNew(false);
			}
			else {
				session.merge(bridgePublishStateEx);
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

		EntityCacheUtil.putResult(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStateExImpl.class,
			bridgePublishStateEx.getPrimaryKey(), bridgePublishStateEx);

		return bridgePublishStateEx;
	}

	protected BridgePublishStateEx toUnwrappedModel(
		BridgePublishStateEx bridgePublishStateEx) {
		if (bridgePublishStateEx instanceof BridgePublishStateExImpl) {
			return bridgePublishStateEx;
		}

		BridgePublishStateExImpl bridgePublishStateExImpl = new BridgePublishStateExImpl();

		bridgePublishStateExImpl.setNew(bridgePublishStateEx.isNew());
		bridgePublishStateExImpl.setPrimaryKey(bridgePublishStateEx.getPrimaryKey());

		bridgePublishStateExImpl.setPublishId(bridgePublishStateEx.getPublishId());
		bridgePublishStateExImpl.setStdId(bridgePublishStateEx.getStdId());
		bridgePublishStateExImpl.setTaxonomyTitle(bridgePublishStateEx.getTaxonomyTitle());
		bridgePublishStateExImpl.setTitle(bridgePublishStateEx.getTitle());
		bridgePublishStateExImpl.setPath(bridgePublishStateEx.getPath());
		bridgePublishStateExImpl.setParentStdId(bridgePublishStateEx.getParentStdId());
		bridgePublishStateExImpl.setStateCd(bridgePublishStateEx.getStateCd());
		bridgePublishStateExImpl.setType(bridgePublishStateEx.getType());
		bridgePublishStateExImpl.setManualType(bridgePublishStateEx.getManualType());
		bridgePublishStateExImpl.setCount(bridgePublishStateEx.getCount());
		bridgePublishStateExImpl.setDisplayOrder(bridgePublishStateEx.getDisplayOrder());
		bridgePublishStateExImpl.setTaxonomyId(bridgePublishStateEx.getTaxonomyId());
		bridgePublishStateExImpl.setParentTaxonomyId(bridgePublishStateEx.getParentTaxonomyId());
		bridgePublishStateExImpl.setIndexOrder(bridgePublishStateEx.getIndexOrder());
		bridgePublishStateExImpl.setLevel(bridgePublishStateEx.getLevel());
		bridgePublishStateExImpl.setLevelSortOrder(bridgePublishStateEx.getLevelSortOrder());

		return bridgePublishStateExImpl;
	}

	/**
	 * Returns the bridge publish state ex with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish state ex
	 * @return the bridge publish state ex
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStateExException if a bridge publish state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStateEx findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishStateExException, SystemException {
		BridgePublishStateEx bridgePublishStateEx = fetchByPrimaryKey(primaryKey);

		if (bridgePublishStateEx == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishStateExException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublishStateEx;
	}

	/**
	 * Returns the bridge publish state ex with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishStateExException} if it could not be found.
	 *
	 * @param bridgePublishStateExPK the primary key of the bridge publish state ex
	 * @return the bridge publish state ex
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStateExException if a bridge publish state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStateEx findByPrimaryKey(
		BridgePublishStateExPK bridgePublishStateExPK)
		throws NoSuchBridgePublishStateExException, SystemException {
		return findByPrimaryKey((Serializable)bridgePublishStateExPK);
	}

	/**
	 * Returns the bridge publish state ex with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish state ex
	 * @return the bridge publish state ex, or <code>null</code> if a bridge publish state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStateEx fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgePublishStateEx bridgePublishStateEx = (BridgePublishStateEx)EntityCacheUtil.getResult(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishStateExImpl.class, primaryKey);

		if (bridgePublishStateEx == _nullBridgePublishStateEx) {
			return null;
		}

		if (bridgePublishStateEx == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublishStateEx = (BridgePublishStateEx)session.get(BridgePublishStateExImpl.class,
						primaryKey);

				if (bridgePublishStateEx != null) {
					cacheResult(bridgePublishStateEx);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishStateExImpl.class, primaryKey,
						_nullBridgePublishStateEx);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishStateExModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishStateExImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublishStateEx;
	}

	/**
	 * Returns the bridge publish state ex with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bridgePublishStateExPK the primary key of the bridge publish state ex
	 * @return the bridge publish state ex, or <code>null</code> if a bridge publish state ex with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStateEx fetchByPrimaryKey(
		BridgePublishStateExPK bridgePublishStateExPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)bridgePublishStateExPK);
	}

	/**
	 * Returns all the bridge publish state exs.
	 *
	 * @return the bridge publish state exs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishStateEx> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish state exs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish state exs
	 * @param end the upper bound of the range of bridge publish state exs (not inclusive)
	 * @return the range of bridge publish state exs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishStateEx> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish state exs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStateExModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish state exs
	 * @param end the upper bound of the range of bridge publish state exs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publish state exs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishStateEx> findAll(int start, int end,
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

		List<BridgePublishStateEx> list = (List<BridgePublishStateEx>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISHSTATEEX);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISHSTATEEX;

				if (pagination) {
					sql = sql.concat(BridgePublishStateExModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublishStateEx>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishStateEx>(list);
				}
				else {
					list = (List<BridgePublishStateEx>)QueryUtil.list(q,
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
	 * Removes all the bridge publish state exs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublishStateEx bridgePublishStateEx : findAll()) {
			remove(bridgePublishStateEx);
		}
	}

	/**
	 * Returns the number of bridge publish state exs.
	 *
	 * @return the number of bridge publish state exs
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISHSTATEEX);

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
	 * Initializes the bridge publish state ex persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublishStateEx")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublishStateEx>> listenersList = new ArrayList<ModelListener<BridgePublishStateEx>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublishStateEx>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishStateExImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISHSTATEEX = "SELECT bridgePublishStateEx FROM BridgePublishStateEx bridgePublishStateEx";
	private static final String _SQL_COUNT_BRIDGEPUBLISHSTATEEX = "SELECT COUNT(bridgePublishStateEx) FROM BridgePublishStateEx bridgePublishStateEx";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublishStateEx.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublishStateEx exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishStateExPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishId", "stdId", "taxonomyTitle", "title", "path",
				"parentStdId", "stateCd", "type", "manualType", "count",
				"displayOrder", "taxonomyId", "parentTaxonomyId", "indexOrder",
				"level", "levelSortOrder"
			});
	private static BridgePublishStateEx _nullBridgePublishStateEx = new BridgePublishStateExImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublishStateEx> toCacheModel() {
				return _nullBridgePublishStateExCacheModel;
			}
		};

	private static CacheModel<BridgePublishStateEx> _nullBridgePublishStateExCacheModel =
		new CacheModel<BridgePublishStateEx>() {
			@Override
			public BridgePublishStateEx toEntityModel() {
				return _nullBridgePublishStateEx;
			}
		};
}