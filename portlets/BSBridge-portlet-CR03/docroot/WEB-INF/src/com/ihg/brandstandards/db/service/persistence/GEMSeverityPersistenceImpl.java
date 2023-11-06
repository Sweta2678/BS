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

import com.ihg.brandstandards.db.NoSuchGEMSeverityException;
import com.ihg.brandstandards.db.model.GEMSeverity;
import com.ihg.brandstandards.db.model.impl.GEMSeverityImpl;
import com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl;

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
 * The persistence implementation for the g e m severity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMSeverityPersistence
 * @see GEMSeverityUtil
 * @generated
 */
public class GEMSeverityPersistenceImpl extends BasePersistenceImpl<GEMSeverity>
	implements GEMSeverityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMSeverityUtil} to access the g e m severity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMSeverityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
			GEMSeverityModelImpl.FINDER_CACHE_ENABLED, GEMSeverityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
			GEMSeverityModelImpl.FINDER_CACHE_ENABLED, GEMSeverityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
			GEMSeverityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMSeverityPersistenceImpl() {
		setModelClass(GEMSeverity.class);
	}

	/**
	 * Caches the g e m severity in the entity cache if it is enabled.
	 *
	 * @param gemSeverity the g e m severity
	 */
	@Override
	public void cacheResult(GEMSeverity gemSeverity) {
		EntityCacheUtil.putResult(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
			GEMSeverityImpl.class, gemSeverity.getPrimaryKey(), gemSeverity);

		gemSeverity.resetOriginalValues();
	}

	/**
	 * Caches the g e m severities in the entity cache if it is enabled.
	 *
	 * @param gemSeverities the g e m severities
	 */
	@Override
	public void cacheResult(List<GEMSeverity> gemSeverities) {
		for (GEMSeverity gemSeverity : gemSeverities) {
			if (EntityCacheUtil.getResult(
						GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
						GEMSeverityImpl.class, gemSeverity.getPrimaryKey()) == null) {
				cacheResult(gemSeverity);
			}
			else {
				gemSeverity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m severities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMSeverityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMSeverityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m severity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMSeverity gemSeverity) {
		EntityCacheUtil.removeResult(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
			GEMSeverityImpl.class, gemSeverity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMSeverity> gemSeverities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMSeverity gemSeverity : gemSeverities) {
			EntityCacheUtil.removeResult(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
				GEMSeverityImpl.class, gemSeverity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m severity with the primary key. Does not add the g e m severity to the database.
	 *
	 * @param severityId the primary key for the new g e m severity
	 * @return the new g e m severity
	 */
	@Override
	public GEMSeverity create(long severityId) {
		GEMSeverity gemSeverity = new GEMSeverityImpl();

		gemSeverity.setNew(true);
		gemSeverity.setPrimaryKey(severityId);

		return gemSeverity;
	}

	/**
	 * Removes the g e m severity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param severityId the primary key of the g e m severity
	 * @return the g e m severity that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMSeverityException if a g e m severity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMSeverity remove(long severityId)
		throws NoSuchGEMSeverityException, SystemException {
		return remove((Serializable)severityId);
	}

	/**
	 * Removes the g e m severity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m severity
	 * @return the g e m severity that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMSeverityException if a g e m severity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMSeverity remove(Serializable primaryKey)
		throws NoSuchGEMSeverityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMSeverity gemSeverity = (GEMSeverity)session.get(GEMSeverityImpl.class,
					primaryKey);

			if (gemSeverity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMSeverityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemSeverity);
		}
		catch (NoSuchGEMSeverityException nsee) {
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
	protected GEMSeverity removeImpl(GEMSeverity gemSeverity)
		throws SystemException {
		gemSeverity = toUnwrappedModel(gemSeverity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemSeverity)) {
				gemSeverity = (GEMSeverity)session.get(GEMSeverityImpl.class,
						gemSeverity.getPrimaryKeyObj());
			}

			if (gemSeverity != null) {
				session.delete(gemSeverity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemSeverity != null) {
			clearCache(gemSeverity);
		}

		return gemSeverity;
	}

	@Override
	public GEMSeverity updateImpl(
		com.ihg.brandstandards.db.model.GEMSeverity gemSeverity)
		throws SystemException {
		gemSeverity = toUnwrappedModel(gemSeverity);

		boolean isNew = gemSeverity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemSeverity.isNew()) {
				session.save(gemSeverity);

				gemSeverity.setNew(false);
			}
			else {
				session.merge(gemSeverity);
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

		EntityCacheUtil.putResult(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
			GEMSeverityImpl.class, gemSeverity.getPrimaryKey(), gemSeverity);

		return gemSeverity;
	}

	protected GEMSeverity toUnwrappedModel(GEMSeverity gemSeverity) {
		if (gemSeverity instanceof GEMSeverityImpl) {
			return gemSeverity;
		}

		GEMSeverityImpl gemSeverityImpl = new GEMSeverityImpl();

		gemSeverityImpl.setNew(gemSeverity.isNew());
		gemSeverityImpl.setPrimaryKey(gemSeverity.getPrimaryKey());

		gemSeverityImpl.setSeverityId(gemSeverity.getSeverityId());
		gemSeverityImpl.setSeverityName(gemSeverity.getSeverityName());
		gemSeverityImpl.setCreatorId(gemSeverity.getCreatorId());
		gemSeverityImpl.setCreatedDate(gemSeverity.getCreatedDate());
		gemSeverityImpl.setUpdatedBy(gemSeverity.getUpdatedBy());
		gemSeverityImpl.setUpdatedDate(gemSeverity.getUpdatedDate());

		return gemSeverityImpl;
	}

	/**
	 * Returns the g e m severity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m severity
	 * @return the g e m severity
	 * @throws com.ihg.brandstandards.db.NoSuchGEMSeverityException if a g e m severity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMSeverity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMSeverityException, SystemException {
		GEMSeverity gemSeverity = fetchByPrimaryKey(primaryKey);

		if (gemSeverity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMSeverityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemSeverity;
	}

	/**
	 * Returns the g e m severity with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMSeverityException} if it could not be found.
	 *
	 * @param severityId the primary key of the g e m severity
	 * @return the g e m severity
	 * @throws com.ihg.brandstandards.db.NoSuchGEMSeverityException if a g e m severity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMSeverity findByPrimaryKey(long severityId)
		throws NoSuchGEMSeverityException, SystemException {
		return findByPrimaryKey((Serializable)severityId);
	}

	/**
	 * Returns the g e m severity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m severity
	 * @return the g e m severity, or <code>null</code> if a g e m severity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMSeverity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMSeverity gemSeverity = (GEMSeverity)EntityCacheUtil.getResult(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
				GEMSeverityImpl.class, primaryKey);

		if (gemSeverity == _nullGEMSeverity) {
			return null;
		}

		if (gemSeverity == null) {
			Session session = null;

			try {
				session = openSession();

				gemSeverity = (GEMSeverity)session.get(GEMSeverityImpl.class,
						primaryKey);

				if (gemSeverity != null) {
					cacheResult(gemSeverity);
				}
				else {
					EntityCacheUtil.putResult(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
						GEMSeverityImpl.class, primaryKey, _nullGEMSeverity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMSeverityModelImpl.ENTITY_CACHE_ENABLED,
					GEMSeverityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemSeverity;
	}

	/**
	 * Returns the g e m severity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param severityId the primary key of the g e m severity
	 * @return the g e m severity, or <code>null</code> if a g e m severity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMSeverity fetchByPrimaryKey(long severityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)severityId);
	}

	/**
	 * Returns all the g e m severities.
	 *
	 * @return the g e m severities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMSeverity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m severities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m severities
	 * @param end the upper bound of the range of g e m severities (not inclusive)
	 * @return the range of g e m severities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMSeverity> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m severities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m severities
	 * @param end the upper bound of the range of g e m severities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m severities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMSeverity> findAll(int start, int end,
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

		List<GEMSeverity> list = (List<GEMSeverity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMSEVERITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMSEVERITY;

				if (pagination) {
					sql = sql.concat(GEMSeverityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMSeverity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMSeverity>(list);
				}
				else {
					list = (List<GEMSeverity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the g e m severities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMSeverity gemSeverity : findAll()) {
			remove(gemSeverity);
		}
	}

	/**
	 * Returns the number of g e m severities.
	 *
	 * @return the number of g e m severities
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

				Query q = session.createQuery(_SQL_COUNT_GEMSEVERITY);

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
	 * Initializes the g e m severity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMSeverity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMSeverity>> listenersList = new ArrayList<ModelListener<GEMSeverity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMSeverity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMSeverityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMSEVERITY = "SELECT gemSeverity FROM GEMSeverity gemSeverity";
	private static final String _SQL_COUNT_GEMSEVERITY = "SELECT COUNT(gemSeverity) FROM GEMSeverity gemSeverity";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemSeverity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMSeverity exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMSeverityPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"severityId", "severityName", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static GEMSeverity _nullGEMSeverity = new GEMSeverityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMSeverity> toCacheModel() {
				return _nullGEMSeverityCacheModel;
			}
		};

	private static CacheModel<GEMSeverity> _nullGEMSeverityCacheModel = new CacheModel<GEMSeverity>() {
			@Override
			public GEMSeverity toEntityModel() {
				return _nullGEMSeverity;
			}
		};
}