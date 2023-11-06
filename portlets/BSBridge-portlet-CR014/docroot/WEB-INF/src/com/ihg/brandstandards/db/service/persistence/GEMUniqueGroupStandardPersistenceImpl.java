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

import com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException;
import com.ihg.brandstandards.db.model.GEMUniqueGroupStandard;
import com.ihg.brandstandards.db.model.impl.GEMUniqueGroupStandardImpl;
import com.ihg.brandstandards.db.model.impl.GEMUniqueGroupStandardModelImpl;

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
 * The persistence implementation for the g e m unique group standard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMUniqueGroupStandardPersistence
 * @see GEMUniqueGroupStandardUtil
 * @generated
 */
public class GEMUniqueGroupStandardPersistenceImpl extends BasePersistenceImpl<GEMUniqueGroupStandard>
	implements GEMUniqueGroupStandardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMUniqueGroupStandardUtil} to access the g e m unique group standard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMUniqueGroupStandardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupStandardModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupStandardModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMUniqueGroupStandardPersistenceImpl() {
		setModelClass(GEMUniqueGroupStandard.class);
	}

	/**
	 * Caches the g e m unique group standard in the entity cache if it is enabled.
	 *
	 * @param gemUniqueGroupStandard the g e m unique group standard
	 */
	@Override
	public void cacheResult(GEMUniqueGroupStandard gemUniqueGroupStandard) {
		EntityCacheUtil.putResult(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupStandardImpl.class,
			gemUniqueGroupStandard.getPrimaryKey(), gemUniqueGroupStandard);

		gemUniqueGroupStandard.resetOriginalValues();
	}

	/**
	 * Caches the g e m unique group standards in the entity cache if it is enabled.
	 *
	 * @param gemUniqueGroupStandards the g e m unique group standards
	 */
	@Override
	public void cacheResult(
		List<GEMUniqueGroupStandard> gemUniqueGroupStandards) {
		for (GEMUniqueGroupStandard gemUniqueGroupStandard : gemUniqueGroupStandards) {
			if (EntityCacheUtil.getResult(
						GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
						GEMUniqueGroupStandardImpl.class,
						gemUniqueGroupStandard.getPrimaryKey()) == null) {
				cacheResult(gemUniqueGroupStandard);
			}
			else {
				gemUniqueGroupStandard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m unique group standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMUniqueGroupStandardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMUniqueGroupStandardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m unique group standard.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMUniqueGroupStandard gemUniqueGroupStandard) {
		EntityCacheUtil.removeResult(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupStandardImpl.class,
			gemUniqueGroupStandard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMUniqueGroupStandard> gemUniqueGroupStandards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMUniqueGroupStandard gemUniqueGroupStandard : gemUniqueGroupStandards) {
			EntityCacheUtil.removeResult(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
				GEMUniqueGroupStandardImpl.class,
				gemUniqueGroupStandard.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m unique group standard with the primary key. Does not add the g e m unique group standard to the database.
	 *
	 * @param groupStandardId the primary key for the new g e m unique group standard
	 * @return the new g e m unique group standard
	 */
	@Override
	public GEMUniqueGroupStandard create(long groupStandardId) {
		GEMUniqueGroupStandard gemUniqueGroupStandard = new GEMUniqueGroupStandardImpl();

		gemUniqueGroupStandard.setNew(true);
		gemUniqueGroupStandard.setPrimaryKey(groupStandardId);

		return gemUniqueGroupStandard;
	}

	/**
	 * Removes the g e m unique group standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupStandardId the primary key of the g e m unique group standard
	 * @return the g e m unique group standard that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException if a g e m unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupStandard remove(long groupStandardId)
		throws NoSuchGEMUniqueGroupStandardException, SystemException {
		return remove((Serializable)groupStandardId);
	}

	/**
	 * Removes the g e m unique group standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m unique group standard
	 * @return the g e m unique group standard that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException if a g e m unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupStandard remove(Serializable primaryKey)
		throws NoSuchGEMUniqueGroupStandardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMUniqueGroupStandard gemUniqueGroupStandard = (GEMUniqueGroupStandard)session.get(GEMUniqueGroupStandardImpl.class,
					primaryKey);

			if (gemUniqueGroupStandard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMUniqueGroupStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemUniqueGroupStandard);
		}
		catch (NoSuchGEMUniqueGroupStandardException nsee) {
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
	protected GEMUniqueGroupStandard removeImpl(
		GEMUniqueGroupStandard gemUniqueGroupStandard)
		throws SystemException {
		gemUniqueGroupStandard = toUnwrappedModel(gemUniqueGroupStandard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemUniqueGroupStandard)) {
				gemUniqueGroupStandard = (GEMUniqueGroupStandard)session.get(GEMUniqueGroupStandardImpl.class,
						gemUniqueGroupStandard.getPrimaryKeyObj());
			}

			if (gemUniqueGroupStandard != null) {
				session.delete(gemUniqueGroupStandard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemUniqueGroupStandard != null) {
			clearCache(gemUniqueGroupStandard);
		}

		return gemUniqueGroupStandard;
	}

	@Override
	public GEMUniqueGroupStandard updateImpl(
		com.ihg.brandstandards.db.model.GEMUniqueGroupStandard gemUniqueGroupStandard)
		throws SystemException {
		gemUniqueGroupStandard = toUnwrappedModel(gemUniqueGroupStandard);

		boolean isNew = gemUniqueGroupStandard.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemUniqueGroupStandard.isNew()) {
				session.save(gemUniqueGroupStandard);

				gemUniqueGroupStandard.setNew(false);
			}
			else {
				session.merge(gemUniqueGroupStandard);
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

		EntityCacheUtil.putResult(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupStandardImpl.class,
			gemUniqueGroupStandard.getPrimaryKey(), gemUniqueGroupStandard);

		return gemUniqueGroupStandard;
	}

	protected GEMUniqueGroupStandard toUnwrappedModel(
		GEMUniqueGroupStandard gemUniqueGroupStandard) {
		if (gemUniqueGroupStandard instanceof GEMUniqueGroupStandardImpl) {
			return gemUniqueGroupStandard;
		}

		GEMUniqueGroupStandardImpl gemUniqueGroupStandardImpl = new GEMUniqueGroupStandardImpl();

		gemUniqueGroupStandardImpl.setNew(gemUniqueGroupStandard.isNew());
		gemUniqueGroupStandardImpl.setPrimaryKey(gemUniqueGroupStandard.getPrimaryKey());

		gemUniqueGroupStandardImpl.setGroupStandardId(gemUniqueGroupStandard.getGroupStandardId());
		gemUniqueGroupStandardImpl.setGroupId(gemUniqueGroupStandard.getGroupId());
		gemUniqueGroupStandardImpl.setStdId(gemUniqueGroupStandard.getStdId());
		gemUniqueGroupStandardImpl.setCreatorId(gemUniqueGroupStandard.getCreatorId());
		gemUniqueGroupStandardImpl.setCreatedDate(gemUniqueGroupStandard.getCreatedDate());
		gemUniqueGroupStandardImpl.setUpdatedBy(gemUniqueGroupStandard.getUpdatedBy());
		gemUniqueGroupStandardImpl.setUpdatedDate(gemUniqueGroupStandard.getUpdatedDate());

		return gemUniqueGroupStandardImpl;
	}

	/**
	 * Returns the g e m unique group standard with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m unique group standard
	 * @return the g e m unique group standard
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException if a g e m unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupStandard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMUniqueGroupStandardException, SystemException {
		GEMUniqueGroupStandard gemUniqueGroupStandard = fetchByPrimaryKey(primaryKey);

		if (gemUniqueGroupStandard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMUniqueGroupStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemUniqueGroupStandard;
	}

	/**
	 * Returns the g e m unique group standard with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException} if it could not be found.
	 *
	 * @param groupStandardId the primary key of the g e m unique group standard
	 * @return the g e m unique group standard
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException if a g e m unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupStandard findByPrimaryKey(long groupStandardId)
		throws NoSuchGEMUniqueGroupStandardException, SystemException {
		return findByPrimaryKey((Serializable)groupStandardId);
	}

	/**
	 * Returns the g e m unique group standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m unique group standard
	 * @return the g e m unique group standard, or <code>null</code> if a g e m unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupStandard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMUniqueGroupStandard gemUniqueGroupStandard = (GEMUniqueGroupStandard)EntityCacheUtil.getResult(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
				GEMUniqueGroupStandardImpl.class, primaryKey);

		if (gemUniqueGroupStandard == _nullGEMUniqueGroupStandard) {
			return null;
		}

		if (gemUniqueGroupStandard == null) {
			Session session = null;

			try {
				session = openSession();

				gemUniqueGroupStandard = (GEMUniqueGroupStandard)session.get(GEMUniqueGroupStandardImpl.class,
						primaryKey);

				if (gemUniqueGroupStandard != null) {
					cacheResult(gemUniqueGroupStandard);
				}
				else {
					EntityCacheUtil.putResult(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
						GEMUniqueGroupStandardImpl.class, primaryKey,
						_nullGEMUniqueGroupStandard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMUniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
					GEMUniqueGroupStandardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemUniqueGroupStandard;
	}

	/**
	 * Returns the g e m unique group standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupStandardId the primary key of the g e m unique group standard
	 * @return the g e m unique group standard, or <code>null</code> if a g e m unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupStandard fetchByPrimaryKey(long groupStandardId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupStandardId);
	}

	/**
	 * Returns all the g e m unique group standards.
	 *
	 * @return the g e m unique group standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroupStandard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m unique group standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m unique group standards
	 * @param end the upper bound of the range of g e m unique group standards (not inclusive)
	 * @return the range of g e m unique group standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroupStandard> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m unique group standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m unique group standards
	 * @param end the upper bound of the range of g e m unique group standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m unique group standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroupStandard> findAll(int start, int end,
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

		List<GEMUniqueGroupStandard> list = (List<GEMUniqueGroupStandard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMUNIQUEGROUPSTANDARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMUNIQUEGROUPSTANDARD;

				if (pagination) {
					sql = sql.concat(GEMUniqueGroupStandardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMUniqueGroupStandard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMUniqueGroupStandard>(list);
				}
				else {
					list = (List<GEMUniqueGroupStandard>)QueryUtil.list(q,
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
	 * Removes all the g e m unique group standards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMUniqueGroupStandard gemUniqueGroupStandard : findAll()) {
			remove(gemUniqueGroupStandard);
		}
	}

	/**
	 * Returns the number of g e m unique group standards.
	 *
	 * @return the number of g e m unique group standards
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

				Query q = session.createQuery(_SQL_COUNT_GEMUNIQUEGROUPSTANDARD);

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
	 * Initializes the g e m unique group standard persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMUniqueGroupStandard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMUniqueGroupStandard>> listenersList = new ArrayList<ModelListener<GEMUniqueGroupStandard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMUniqueGroupStandard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMUniqueGroupStandardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMUNIQUEGROUPSTANDARD = "SELECT gemUniqueGroupStandard FROM GEMUniqueGroupStandard gemUniqueGroupStandard";
	private static final String _SQL_COUNT_GEMUNIQUEGROUPSTANDARD = "SELECT COUNT(gemUniqueGroupStandard) FROM GEMUniqueGroupStandard gemUniqueGroupStandard";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemUniqueGroupStandard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMUniqueGroupStandard exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMUniqueGroupStandardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"groupStandardId", "groupId", "stdId", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMUniqueGroupStandard _nullGEMUniqueGroupStandard = new GEMUniqueGroupStandardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMUniqueGroupStandard> toCacheModel() {
				return _nullGEMUniqueGroupStandardCacheModel;
			}
		};

	private static CacheModel<GEMUniqueGroupStandard> _nullGEMUniqueGroupStandardCacheModel =
		new CacheModel<GEMUniqueGroupStandard>() {
			@Override
			public GEMUniqueGroupStandard toEntityModel() {
				return _nullGEMUniqueGroupStandard;
			}
		};
}