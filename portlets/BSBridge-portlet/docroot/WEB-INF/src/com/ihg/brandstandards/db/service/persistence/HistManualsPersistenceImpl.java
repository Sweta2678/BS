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

import com.ihg.brandstandards.db.NoSuchHistManualsException;
import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.model.impl.HistManualsImpl;
import com.ihg.brandstandards.db.model.impl.HistManualsModelImpl;

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
 * The persistence implementation for the hist manuals service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see HistManualsPersistence
 * @see HistManualsUtil
 * @generated
 */
public class HistManualsPersistenceImpl extends BasePersistenceImpl<HistManuals>
	implements HistManualsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link HistManualsUtil} to access the hist manuals persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = HistManualsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
			HistManualsModelImpl.FINDER_CACHE_ENABLED, HistManualsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
			HistManualsModelImpl.FINDER_CACHE_ENABLED, HistManualsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
			HistManualsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public HistManualsPersistenceImpl() {
		setModelClass(HistManuals.class);
	}

	/**
	 * Caches the hist manuals in the entity cache if it is enabled.
	 *
	 * @param histManuals the hist manuals
	 */
	@Override
	public void cacheResult(HistManuals histManuals) {
		EntityCacheUtil.putResult(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
			HistManualsImpl.class, histManuals.getPrimaryKey(), histManuals);

		histManuals.resetOriginalValues();
	}

	/**
	 * Caches the hist manualses in the entity cache if it is enabled.
	 *
	 * @param histManualses the hist manualses
	 */
	@Override
	public void cacheResult(List<HistManuals> histManualses) {
		for (HistManuals histManuals : histManualses) {
			if (EntityCacheUtil.getResult(
						HistManualsModelImpl.ENTITY_CACHE_ENABLED,
						HistManualsImpl.class, histManuals.getPrimaryKey()) == null) {
				cacheResult(histManuals);
			}
			else {
				histManuals.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all hist manualses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(HistManualsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(HistManualsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hist manuals.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HistManuals histManuals) {
		EntityCacheUtil.removeResult(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
			HistManualsImpl.class, histManuals.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<HistManuals> histManualses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (HistManuals histManuals : histManualses) {
			EntityCacheUtil.removeResult(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
				HistManualsImpl.class, histManuals.getPrimaryKey());
		}
	}

	/**
	 * Creates a new hist manuals with the primary key. Does not add the hist manuals to the database.
	 *
	 * @param histManualId the primary key for the new hist manuals
	 * @return the new hist manuals
	 */
	@Override
	public HistManuals create(long histManualId) {
		HistManuals histManuals = new HistManualsImpl();

		histManuals.setNew(true);
		histManuals.setPrimaryKey(histManualId);

		return histManuals;
	}

	/**
	 * Removes the hist manuals with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param histManualId the primary key of the hist manuals
	 * @return the hist manuals that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualsException if a hist manuals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManuals remove(long histManualId)
		throws NoSuchHistManualsException, SystemException {
		return remove((Serializable)histManualId);
	}

	/**
	 * Removes the hist manuals with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hist manuals
	 * @return the hist manuals that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualsException if a hist manuals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManuals remove(Serializable primaryKey)
		throws NoSuchHistManualsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			HistManuals histManuals = (HistManuals)session.get(HistManualsImpl.class,
					primaryKey);

			if (histManuals == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistManualsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(histManuals);
		}
		catch (NoSuchHistManualsException nsee) {
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
	protected HistManuals removeImpl(HistManuals histManuals)
		throws SystemException {
		histManuals = toUnwrappedModel(histManuals);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(histManuals)) {
				histManuals = (HistManuals)session.get(HistManualsImpl.class,
						histManuals.getPrimaryKeyObj());
			}

			if (histManuals != null) {
				session.delete(histManuals);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (histManuals != null) {
			clearCache(histManuals);
		}

		return histManuals;
	}

	@Override
	public HistManuals updateImpl(
		com.ihg.brandstandards.db.model.HistManuals histManuals)
		throws SystemException {
		histManuals = toUnwrappedModel(histManuals);

		boolean isNew = histManuals.isNew();

		Session session = null;

		try {
			session = openSession();

			if (histManuals.isNew()) {
				session.save(histManuals);

				histManuals.setNew(false);
			}
			else {
				session.merge(histManuals);
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

		EntityCacheUtil.putResult(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
			HistManualsImpl.class, histManuals.getPrimaryKey(), histManuals);

		return histManuals;
	}

	protected HistManuals toUnwrappedModel(HistManuals histManuals) {
		if (histManuals instanceof HistManualsImpl) {
			return histManuals;
		}

		HistManualsImpl histManualsImpl = new HistManualsImpl();

		histManualsImpl.setNew(histManuals.isNew());
		histManualsImpl.setPrimaryKey(histManuals.getPrimaryKey());

		histManualsImpl.setHistManualId(histManuals.getHistManualId());
		histManualsImpl.setTitle(histManuals.getTitle());
		histManualsImpl.setType(histManuals.getType());
		histManualsImpl.setPubDate(histManuals.getPubDate());
		histManualsImpl.setStatus(histManuals.getStatus());
		histManualsImpl.setCreatorId(histManuals.getCreatorId());
		histManualsImpl.setCreatedDate(histManuals.getCreatedDate());
		histManualsImpl.setUpdatedBy(histManuals.getUpdatedBy());
		histManualsImpl.setUpdatedDate(histManuals.getUpdatedDate());

		return histManualsImpl;
	}

	/**
	 * Returns the hist manuals with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manuals
	 * @return the hist manuals
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualsException if a hist manuals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManuals findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistManualsException, SystemException {
		HistManuals histManuals = fetchByPrimaryKey(primaryKey);

		if (histManuals == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistManualsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return histManuals;
	}

	/**
	 * Returns the hist manuals with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchHistManualsException} if it could not be found.
	 *
	 * @param histManualId the primary key of the hist manuals
	 * @return the hist manuals
	 * @throws com.ihg.brandstandards.db.NoSuchHistManualsException if a hist manuals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManuals findByPrimaryKey(long histManualId)
		throws NoSuchHistManualsException, SystemException {
		return findByPrimaryKey((Serializable)histManualId);
	}

	/**
	 * Returns the hist manuals with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hist manuals
	 * @return the hist manuals, or <code>null</code> if a hist manuals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManuals fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		HistManuals histManuals = (HistManuals)EntityCacheUtil.getResult(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
				HistManualsImpl.class, primaryKey);

		if (histManuals == _nullHistManuals) {
			return null;
		}

		if (histManuals == null) {
			Session session = null;

			try {
				session = openSession();

				histManuals = (HistManuals)session.get(HistManualsImpl.class,
						primaryKey);

				if (histManuals != null) {
					cacheResult(histManuals);
				}
				else {
					EntityCacheUtil.putResult(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
						HistManualsImpl.class, primaryKey, _nullHistManuals);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(HistManualsModelImpl.ENTITY_CACHE_ENABLED,
					HistManualsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return histManuals;
	}

	/**
	 * Returns the hist manuals with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param histManualId the primary key of the hist manuals
	 * @return the hist manuals, or <code>null</code> if a hist manuals with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public HistManuals fetchByPrimaryKey(long histManualId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)histManualId);
	}

	/**
	 * Returns all the hist manualses.
	 *
	 * @return the hist manualses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManuals> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hist manualses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manualses
	 * @param end the upper bound of the range of hist manualses (not inclusive)
	 * @return the range of hist manualses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManuals> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hist manualses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.HistManualsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of hist manualses
	 * @param end the upper bound of the range of hist manualses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hist manualses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<HistManuals> findAll(int start, int end,
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

		List<HistManuals> list = (List<HistManuals>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_HISTMANUALS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_HISTMANUALS;

				if (pagination) {
					sql = sql.concat(HistManualsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<HistManuals>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<HistManuals>(list);
				}
				else {
					list = (List<HistManuals>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the hist manualses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (HistManuals histManuals : findAll()) {
			remove(histManuals);
		}
	}

	/**
	 * Returns the number of hist manualses.
	 *
	 * @return the number of hist manualses
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

				Query q = session.createQuery(_SQL_COUNT_HISTMANUALS);

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
	 * Initializes the hist manuals persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.HistManuals")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<HistManuals>> listenersList = new ArrayList<ModelListener<HistManuals>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<HistManuals>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(HistManualsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_HISTMANUALS = "SELECT histManuals FROM HistManuals histManuals";
	private static final String _SQL_COUNT_HISTMANUALS = "SELECT COUNT(histManuals) FROM HistManuals histManuals";
	private static final String _ORDER_BY_ENTITY_ALIAS = "histManuals.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No HistManuals exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(HistManualsPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"histManualId", "title", "type", "pubDate", "status",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static HistManuals _nullHistManuals = new HistManualsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<HistManuals> toCacheModel() {
				return _nullHistManualsCacheModel;
			}
		};

	private static CacheModel<HistManuals> _nullHistManualsCacheModel = new CacheModel<HistManuals>() {
			@Override
			public HistManuals toEntityModel() {
				return _nullHistManuals;
			}
		};
}