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

import com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException;
import com.ihg.brandstandards.db.model.UniqueGroupStandard;
import com.ihg.brandstandards.db.model.impl.UniqueGroupStandardImpl;
import com.ihg.brandstandards.db.model.impl.UniqueGroupStandardModelImpl;

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
 * The persistence implementation for the unique group standard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroupStandardPersistence
 * @see UniqueGroupStandardUtil
 * @generated
 */
public class UniqueGroupStandardPersistenceImpl extends BasePersistenceImpl<UniqueGroupStandard>
	implements UniqueGroupStandardPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UniqueGroupStandardUtil} to access the unique group standard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UniqueGroupStandardImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupStandardModelImpl.FINDER_CACHE_ENABLED,
			UniqueGroupStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupStandardModelImpl.FINDER_CACHE_ENABLED,
			UniqueGroupStandardImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupStandardModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public UniqueGroupStandardPersistenceImpl() {
		setModelClass(UniqueGroupStandard.class);
	}

	/**
	 * Caches the unique group standard in the entity cache if it is enabled.
	 *
	 * @param uniqueGroupStandard the unique group standard
	 */
	@Override
	public void cacheResult(UniqueGroupStandard uniqueGroupStandard) {
		EntityCacheUtil.putResult(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupStandardImpl.class, uniqueGroupStandard.getPrimaryKey(),
			uniqueGroupStandard);

		uniqueGroupStandard.resetOriginalValues();
	}

	/**
	 * Caches the unique group standards in the entity cache if it is enabled.
	 *
	 * @param uniqueGroupStandards the unique group standards
	 */
	@Override
	public void cacheResult(List<UniqueGroupStandard> uniqueGroupStandards) {
		for (UniqueGroupStandard uniqueGroupStandard : uniqueGroupStandards) {
			if (EntityCacheUtil.getResult(
						UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
						UniqueGroupStandardImpl.class,
						uniqueGroupStandard.getPrimaryKey()) == null) {
				cacheResult(uniqueGroupStandard);
			}
			else {
				uniqueGroupStandard.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all unique group standards.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UniqueGroupStandardImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UniqueGroupStandardImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the unique group standard.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UniqueGroupStandard uniqueGroupStandard) {
		EntityCacheUtil.removeResult(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupStandardImpl.class, uniqueGroupStandard.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UniqueGroupStandard> uniqueGroupStandards) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UniqueGroupStandard uniqueGroupStandard : uniqueGroupStandards) {
			EntityCacheUtil.removeResult(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
				UniqueGroupStandardImpl.class,
				uniqueGroupStandard.getPrimaryKey());
		}
	}

	/**
	 * Creates a new unique group standard with the primary key. Does not add the unique group standard to the database.
	 *
	 * @param groupStandardId the primary key for the new unique group standard
	 * @return the new unique group standard
	 */
	@Override
	public UniqueGroupStandard create(long groupStandardId) {
		UniqueGroupStandard uniqueGroupStandard = new UniqueGroupStandardImpl();

		uniqueGroupStandard.setNew(true);
		uniqueGroupStandard.setPrimaryKey(groupStandardId);

		return uniqueGroupStandard;
	}

	/**
	 * Removes the unique group standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupStandardId the primary key of the unique group standard
	 * @return the unique group standard that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException if a unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupStandard remove(long groupStandardId)
		throws NoSuchUniqueGroupStandardException, SystemException {
		return remove((Serializable)groupStandardId);
	}

	/**
	 * Removes the unique group standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the unique group standard
	 * @return the unique group standard that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException if a unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupStandard remove(Serializable primaryKey)
		throws NoSuchUniqueGroupStandardException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UniqueGroupStandard uniqueGroupStandard = (UniqueGroupStandard)session.get(UniqueGroupStandardImpl.class,
					primaryKey);

			if (uniqueGroupStandard == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUniqueGroupStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(uniqueGroupStandard);
		}
		catch (NoSuchUniqueGroupStandardException nsee) {
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
	protected UniqueGroupStandard removeImpl(
		UniqueGroupStandard uniqueGroupStandard) throws SystemException {
		uniqueGroupStandard = toUnwrappedModel(uniqueGroupStandard);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(uniqueGroupStandard)) {
				uniqueGroupStandard = (UniqueGroupStandard)session.get(UniqueGroupStandardImpl.class,
						uniqueGroupStandard.getPrimaryKeyObj());
			}

			if (uniqueGroupStandard != null) {
				session.delete(uniqueGroupStandard);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (uniqueGroupStandard != null) {
			clearCache(uniqueGroupStandard);
		}

		return uniqueGroupStandard;
	}

	@Override
	public UniqueGroupStandard updateImpl(
		com.ihg.brandstandards.db.model.UniqueGroupStandard uniqueGroupStandard)
		throws SystemException {
		uniqueGroupStandard = toUnwrappedModel(uniqueGroupStandard);

		boolean isNew = uniqueGroupStandard.isNew();

		Session session = null;

		try {
			session = openSession();

			if (uniqueGroupStandard.isNew()) {
				session.save(uniqueGroupStandard);

				uniqueGroupStandard.setNew(false);
			}
			else {
				session.merge(uniqueGroupStandard);
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

		EntityCacheUtil.putResult(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
			UniqueGroupStandardImpl.class, uniqueGroupStandard.getPrimaryKey(),
			uniqueGroupStandard);

		return uniqueGroupStandard;
	}

	protected UniqueGroupStandard toUnwrappedModel(
		UniqueGroupStandard uniqueGroupStandard) {
		if (uniqueGroupStandard instanceof UniqueGroupStandardImpl) {
			return uniqueGroupStandard;
		}

		UniqueGroupStandardImpl uniqueGroupStandardImpl = new UniqueGroupStandardImpl();

		uniqueGroupStandardImpl.setNew(uniqueGroupStandard.isNew());
		uniqueGroupStandardImpl.setPrimaryKey(uniqueGroupStandard.getPrimaryKey());

		uniqueGroupStandardImpl.setGroupStandardId(uniqueGroupStandard.getGroupStandardId());
		uniqueGroupStandardImpl.setGroupId(uniqueGroupStandard.getGroupId());
		uniqueGroupStandardImpl.setStdId(uniqueGroupStandard.getStdId());
		uniqueGroupStandardImpl.setCreatorId(uniqueGroupStandard.getCreatorId());
		uniqueGroupStandardImpl.setCreatedDate(uniqueGroupStandard.getCreatedDate());
		uniqueGroupStandardImpl.setUpdatedBy(uniqueGroupStandard.getUpdatedBy());
		uniqueGroupStandardImpl.setUpdatedDate(uniqueGroupStandard.getUpdatedDate());

		return uniqueGroupStandardImpl;
	}

	/**
	 * Returns the unique group standard with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the unique group standard
	 * @return the unique group standard
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException if a unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupStandard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUniqueGroupStandardException, SystemException {
		UniqueGroupStandard uniqueGroupStandard = fetchByPrimaryKey(primaryKey);

		if (uniqueGroupStandard == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUniqueGroupStandardException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return uniqueGroupStandard;
	}

	/**
	 * Returns the unique group standard with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException} if it could not be found.
	 *
	 * @param groupStandardId the primary key of the unique group standard
	 * @return the unique group standard
	 * @throws com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException if a unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupStandard findByPrimaryKey(long groupStandardId)
		throws NoSuchUniqueGroupStandardException, SystemException {
		return findByPrimaryKey((Serializable)groupStandardId);
	}

	/**
	 * Returns the unique group standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the unique group standard
	 * @return the unique group standard, or <code>null</code> if a unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupStandard fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UniqueGroupStandard uniqueGroupStandard = (UniqueGroupStandard)EntityCacheUtil.getResult(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
				UniqueGroupStandardImpl.class, primaryKey);

		if (uniqueGroupStandard == _nullUniqueGroupStandard) {
			return null;
		}

		if (uniqueGroupStandard == null) {
			Session session = null;

			try {
				session = openSession();

				uniqueGroupStandard = (UniqueGroupStandard)session.get(UniqueGroupStandardImpl.class,
						primaryKey);

				if (uniqueGroupStandard != null) {
					cacheResult(uniqueGroupStandard);
				}
				else {
					EntityCacheUtil.putResult(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
						UniqueGroupStandardImpl.class, primaryKey,
						_nullUniqueGroupStandard);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UniqueGroupStandardModelImpl.ENTITY_CACHE_ENABLED,
					UniqueGroupStandardImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return uniqueGroupStandard;
	}

	/**
	 * Returns the unique group standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupStandardId the primary key of the unique group standard
	 * @return the unique group standard, or <code>null</code> if a unique group standard with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UniqueGroupStandard fetchByPrimaryKey(long groupStandardId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupStandardId);
	}

	/**
	 * Returns all the unique group standards.
	 *
	 * @return the unique group standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroupStandard> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the unique group standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unique group standards
	 * @param end the upper bound of the range of unique group standards (not inclusive)
	 * @return the range of unique group standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroupStandard> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the unique group standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.UniqueGroupStandardModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unique group standards
	 * @param end the upper bound of the range of unique group standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of unique group standards
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UniqueGroupStandard> findAll(int start, int end,
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

		List<UniqueGroupStandard> list = (List<UniqueGroupStandard>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UNIQUEGROUPSTANDARD);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNIQUEGROUPSTANDARD;

				if (pagination) {
					sql = sql.concat(UniqueGroupStandardModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UniqueGroupStandard>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UniqueGroupStandard>(list);
				}
				else {
					list = (List<UniqueGroupStandard>)QueryUtil.list(q,
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
	 * Removes all the unique group standards from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UniqueGroupStandard uniqueGroupStandard : findAll()) {
			remove(uniqueGroupStandard);
		}
	}

	/**
	 * Returns the number of unique group standards.
	 *
	 * @return the number of unique group standards
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

				Query q = session.createQuery(_SQL_COUNT_UNIQUEGROUPSTANDARD);

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
	 * Initializes the unique group standard persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.UniqueGroupStandard")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UniqueGroupStandard>> listenersList = new ArrayList<ModelListener<UniqueGroupStandard>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UniqueGroupStandard>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UniqueGroupStandardImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UNIQUEGROUPSTANDARD = "SELECT uniqueGroupStandard FROM UniqueGroupStandard uniqueGroupStandard";
	private static final String _SQL_COUNT_UNIQUEGROUPSTANDARD = "SELECT COUNT(uniqueGroupStandard) FROM UniqueGroupStandard uniqueGroupStandard";
	private static final String _ORDER_BY_ENTITY_ALIAS = "uniqueGroupStandard.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UniqueGroupStandard exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UniqueGroupStandardPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"groupStandardId", "groupId", "stdId", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static UniqueGroupStandard _nullUniqueGroupStandard = new UniqueGroupStandardImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UniqueGroupStandard> toCacheModel() {
				return _nullUniqueGroupStandardCacheModel;
			}
		};

	private static CacheModel<UniqueGroupStandard> _nullUniqueGroupStandardCacheModel =
		new CacheModel<UniqueGroupStandard>() {
			@Override
			public UniqueGroupStandard toEntityModel() {
				return _nullUniqueGroupStandard;
			}
		};
}