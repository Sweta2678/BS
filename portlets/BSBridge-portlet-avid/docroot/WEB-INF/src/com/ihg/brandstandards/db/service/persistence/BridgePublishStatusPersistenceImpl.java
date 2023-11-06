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

import com.ihg.brandstandards.db.NoSuchBridgePublishStatusException;
import com.ihg.brandstandards.db.model.BridgePublishStatus;
import com.ihg.brandstandards.db.model.impl.BridgePublishStatusImpl;
import com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl;

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
 * The persistence implementation for the bridge publish status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishStatusPersistence
 * @see BridgePublishStatusUtil
 * @generated
 */
public class BridgePublishStatusPersistenceImpl extends BasePersistenceImpl<BridgePublishStatus>
	implements BridgePublishStatusPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BridgePublishStatusUtil} to access the bridge publish status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BridgePublishStatusImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStatusModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStatusModelImpl.FINDER_CACHE_ENABLED,
			BridgePublishStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStatusModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BridgePublishStatusPersistenceImpl() {
		setModelClass(BridgePublishStatus.class);
	}

	/**
	 * Caches the bridge publish status in the entity cache if it is enabled.
	 *
	 * @param bridgePublishStatus the bridge publish status
	 */
	@Override
	public void cacheResult(BridgePublishStatus bridgePublishStatus) {
		EntityCacheUtil.putResult(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStatusImpl.class, bridgePublishStatus.getPrimaryKey(),
			bridgePublishStatus);

		bridgePublishStatus.resetOriginalValues();
	}

	/**
	 * Caches the bridge publish statuses in the entity cache if it is enabled.
	 *
	 * @param bridgePublishStatuses the bridge publish statuses
	 */
	@Override
	public void cacheResult(List<BridgePublishStatus> bridgePublishStatuses) {
		for (BridgePublishStatus bridgePublishStatus : bridgePublishStatuses) {
			if (EntityCacheUtil.getResult(
						BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishStatusImpl.class,
						bridgePublishStatus.getPrimaryKey()) == null) {
				cacheResult(bridgePublishStatus);
			}
			else {
				bridgePublishStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bridge publish statuses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BridgePublishStatusImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BridgePublishStatusImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bridge publish status.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BridgePublishStatus bridgePublishStatus) {
		EntityCacheUtil.removeResult(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStatusImpl.class, bridgePublishStatus.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BridgePublishStatus> bridgePublishStatuses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BridgePublishStatus bridgePublishStatus : bridgePublishStatuses) {
			EntityCacheUtil.removeResult(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishStatusImpl.class,
				bridgePublishStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bridge publish status with the primary key. Does not add the bridge publish status to the database.
	 *
	 * @param publishStatusCode the primary key for the new bridge publish status
	 * @return the new bridge publish status
	 */
	@Override
	public BridgePublishStatus create(String publishStatusCode) {
		BridgePublishStatus bridgePublishStatus = new BridgePublishStatusImpl();

		bridgePublishStatus.setNew(true);
		bridgePublishStatus.setPrimaryKey(publishStatusCode);

		return bridgePublishStatus;
	}

	/**
	 * Removes the bridge publish status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publishStatusCode the primary key of the bridge publish status
	 * @return the bridge publish status that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStatus remove(String publishStatusCode)
		throws NoSuchBridgePublishStatusException, SystemException {
		return remove((Serializable)publishStatusCode);
	}

	/**
	 * Removes the bridge publish status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bridge publish status
	 * @return the bridge publish status that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStatus remove(Serializable primaryKey)
		throws NoSuchBridgePublishStatusException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BridgePublishStatus bridgePublishStatus = (BridgePublishStatus)session.get(BridgePublishStatusImpl.class,
					primaryKey);

			if (bridgePublishStatus == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBridgePublishStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(bridgePublishStatus);
		}
		catch (NoSuchBridgePublishStatusException nsee) {
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
	protected BridgePublishStatus removeImpl(
		BridgePublishStatus bridgePublishStatus) throws SystemException {
		bridgePublishStatus = toUnwrappedModel(bridgePublishStatus);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bridgePublishStatus)) {
				bridgePublishStatus = (BridgePublishStatus)session.get(BridgePublishStatusImpl.class,
						bridgePublishStatus.getPrimaryKeyObj());
			}

			if (bridgePublishStatus != null) {
				session.delete(bridgePublishStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (bridgePublishStatus != null) {
			clearCache(bridgePublishStatus);
		}

		return bridgePublishStatus;
	}

	@Override
	public BridgePublishStatus updateImpl(
		com.ihg.brandstandards.db.model.BridgePublishStatus bridgePublishStatus)
		throws SystemException {
		bridgePublishStatus = toUnwrappedModel(bridgePublishStatus);

		boolean isNew = bridgePublishStatus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (bridgePublishStatus.isNew()) {
				session.save(bridgePublishStatus);

				bridgePublishStatus.setNew(false);
			}
			else {
				session.merge(bridgePublishStatus);
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

		EntityCacheUtil.putResult(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
			BridgePublishStatusImpl.class, bridgePublishStatus.getPrimaryKey(),
			bridgePublishStatus);

		return bridgePublishStatus;
	}

	protected BridgePublishStatus toUnwrappedModel(
		BridgePublishStatus bridgePublishStatus) {
		if (bridgePublishStatus instanceof BridgePublishStatusImpl) {
			return bridgePublishStatus;
		}

		BridgePublishStatusImpl bridgePublishStatusImpl = new BridgePublishStatusImpl();

		bridgePublishStatusImpl.setNew(bridgePublishStatus.isNew());
		bridgePublishStatusImpl.setPrimaryKey(bridgePublishStatus.getPrimaryKey());

		bridgePublishStatusImpl.setPublishStatusCode(bridgePublishStatus.getPublishStatusCode());
		bridgePublishStatusImpl.setPublishStatusName(bridgePublishStatus.getPublishStatusName());
		bridgePublishStatusImpl.setCreatorId(bridgePublishStatus.getCreatorId());
		bridgePublishStatusImpl.setCreatedDate(bridgePublishStatus.getCreatedDate());
		bridgePublishStatusImpl.setUpdatedBy(bridgePublishStatus.getUpdatedBy());
		bridgePublishStatusImpl.setUpdatedDate(bridgePublishStatus.getUpdatedDate());

		return bridgePublishStatusImpl;
	}

	/**
	 * Returns the bridge publish status with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish status
	 * @return the bridge publish status
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBridgePublishStatusException, SystemException {
		BridgePublishStatus bridgePublishStatus = fetchByPrimaryKey(primaryKey);

		if (bridgePublishStatus == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBridgePublishStatusException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return bridgePublishStatus;
	}

	/**
	 * Returns the bridge publish status with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchBridgePublishStatusException} if it could not be found.
	 *
	 * @param publishStatusCode the primary key of the bridge publish status
	 * @return the bridge publish status
	 * @throws com.ihg.brandstandards.db.NoSuchBridgePublishStatusException if a bridge publish status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStatus findByPrimaryKey(String publishStatusCode)
		throws NoSuchBridgePublishStatusException, SystemException {
		return findByPrimaryKey((Serializable)publishStatusCode);
	}

	/**
	 * Returns the bridge publish status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bridge publish status
	 * @return the bridge publish status, or <code>null</code> if a bridge publish status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStatus fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BridgePublishStatus bridgePublishStatus = (BridgePublishStatus)EntityCacheUtil.getResult(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
				BridgePublishStatusImpl.class, primaryKey);

		if (bridgePublishStatus == _nullBridgePublishStatus) {
			return null;
		}

		if (bridgePublishStatus == null) {
			Session session = null;

			try {
				session = openSession();

				bridgePublishStatus = (BridgePublishStatus)session.get(BridgePublishStatusImpl.class,
						primaryKey);

				if (bridgePublishStatus != null) {
					cacheResult(bridgePublishStatus);
				}
				else {
					EntityCacheUtil.putResult(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
						BridgePublishStatusImpl.class, primaryKey,
						_nullBridgePublishStatus);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BridgePublishStatusModelImpl.ENTITY_CACHE_ENABLED,
					BridgePublishStatusImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return bridgePublishStatus;
	}

	/**
	 * Returns the bridge publish status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publishStatusCode the primary key of the bridge publish status
	 * @return the bridge publish status, or <code>null</code> if a bridge publish status with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BridgePublishStatus fetchByPrimaryKey(String publishStatusCode)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publishStatusCode);
	}

	/**
	 * Returns all the bridge publish statuses.
	 *
	 * @return the bridge publish statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishStatus> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bridge publish statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish statuses
	 * @param end the upper bound of the range of bridge publish statuses (not inclusive)
	 * @return the range of bridge publish statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishStatus> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bridge publish statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bridge publish statuses
	 * @param end the upper bound of the range of bridge publish statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bridge publish statuses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BridgePublishStatus> findAll(int start, int end,
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

		List<BridgePublishStatus> list = (List<BridgePublishStatus>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BRIDGEPUBLISHSTATUS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BRIDGEPUBLISHSTATUS;

				if (pagination) {
					sql = sql.concat(BridgePublishStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BridgePublishStatus>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BridgePublishStatus>(list);
				}
				else {
					list = (List<BridgePublishStatus>)QueryUtil.list(q,
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
	 * Removes all the bridge publish statuses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BridgePublishStatus bridgePublishStatus : findAll()) {
			remove(bridgePublishStatus);
		}
	}

	/**
	 * Returns the number of bridge publish statuses.
	 *
	 * @return the number of bridge publish statuses
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

				Query q = session.createQuery(_SQL_COUNT_BRIDGEPUBLISHSTATUS);

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
	 * Initializes the bridge publish status persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.BridgePublishStatus")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BridgePublishStatus>> listenersList = new ArrayList<ModelListener<BridgePublishStatus>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BridgePublishStatus>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BridgePublishStatusImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BRIDGEPUBLISHSTATUS = "SELECT bridgePublishStatus FROM BridgePublishStatus bridgePublishStatus";
	private static final String _SQL_COUNT_BRIDGEPUBLISHSTATUS = "SELECT COUNT(bridgePublishStatus) FROM BridgePublishStatus bridgePublishStatus";
	private static final String _ORDER_BY_ENTITY_ALIAS = "bridgePublishStatus.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BridgePublishStatus exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BridgePublishStatusPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"publishStatusCode", "publishStatusName", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static BridgePublishStatus _nullBridgePublishStatus = new BridgePublishStatusImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BridgePublishStatus> toCacheModel() {
				return _nullBridgePublishStatusCacheModel;
			}
		};

	private static CacheModel<BridgePublishStatus> _nullBridgePublishStatusCacheModel =
		new CacheModel<BridgePublishStatus>() {
			@Override
			public BridgePublishStatus toEntityModel() {
				return _nullBridgePublishStatus;
			}
		};
}