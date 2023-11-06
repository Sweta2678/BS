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

import com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException;
import com.ihg.brandstandards.db.model.GEMMeasurementType;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeImpl;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl;

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
 * The persistence implementation for the g e m measurement type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementTypePersistence
 * @see GEMMeasurementTypeUtil
 * @generated
 */
public class GEMMeasurementTypePersistenceImpl extends BasePersistenceImpl<GEMMeasurementType>
	implements GEMMeasurementTypePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMMeasurementTypeUtil} to access the g e m measurement type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMMeasurementTypeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementTypeModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementTypeModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementTypeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementTypeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMMeasurementTypePersistenceImpl() {
		setModelClass(GEMMeasurementType.class);
	}

	/**
	 * Caches the g e m measurement type in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementType the g e m measurement type
	 */
	@Override
	public void cacheResult(GEMMeasurementType gemMeasurementType) {
		EntityCacheUtil.putResult(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementTypeImpl.class, gemMeasurementType.getPrimaryKey(),
			gemMeasurementType);

		gemMeasurementType.resetOriginalValues();
	}

	/**
	 * Caches the g e m measurement types in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementTypes the g e m measurement types
	 */
	@Override
	public void cacheResult(List<GEMMeasurementType> gemMeasurementTypes) {
		for (GEMMeasurementType gemMeasurementType : gemMeasurementTypes) {
			if (EntityCacheUtil.getResult(
						GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementTypeImpl.class,
						gemMeasurementType.getPrimaryKey()) == null) {
				cacheResult(gemMeasurementType);
			}
			else {
				gemMeasurementType.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m measurement types.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMMeasurementTypeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMMeasurementTypeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m measurement type.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMMeasurementType gemMeasurementType) {
		EntityCacheUtil.removeResult(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementTypeImpl.class, gemMeasurementType.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMMeasurementType> gemMeasurementTypes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMMeasurementType gemMeasurementType : gemMeasurementTypes) {
			EntityCacheUtil.removeResult(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementTypeImpl.class, gemMeasurementType.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m measurement type with the primary key. Does not add the g e m measurement type to the database.
	 *
	 * @param measurementType the primary key for the new g e m measurement type
	 * @return the new g e m measurement type
	 */
	@Override
	public GEMMeasurementType create(String measurementType) {
		GEMMeasurementType gemMeasurementType = new GEMMeasurementTypeImpl();

		gemMeasurementType.setNew(true);
		gemMeasurementType.setPrimaryKey(measurementType);

		return gemMeasurementType;
	}

	/**
	 * Removes the g e m measurement type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param measurementType the primary key of the g e m measurement type
	 * @return the g e m measurement type that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException if a g e m measurement type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementType remove(String measurementType)
		throws NoSuchGEMMeasurementTypeException, SystemException {
		return remove((Serializable)measurementType);
	}

	/**
	 * Removes the g e m measurement type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m measurement type
	 * @return the g e m measurement type that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException if a g e m measurement type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementType remove(Serializable primaryKey)
		throws NoSuchGEMMeasurementTypeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMMeasurementType gemMeasurementType = (GEMMeasurementType)session.get(GEMMeasurementTypeImpl.class,
					primaryKey);

			if (gemMeasurementType == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMMeasurementTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemMeasurementType);
		}
		catch (NoSuchGEMMeasurementTypeException nsee) {
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
	protected GEMMeasurementType removeImpl(
		GEMMeasurementType gemMeasurementType) throws SystemException {
		gemMeasurementType = toUnwrappedModel(gemMeasurementType);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemMeasurementType)) {
				gemMeasurementType = (GEMMeasurementType)session.get(GEMMeasurementTypeImpl.class,
						gemMeasurementType.getPrimaryKeyObj());
			}

			if (gemMeasurementType != null) {
				session.delete(gemMeasurementType);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemMeasurementType != null) {
			clearCache(gemMeasurementType);
		}

		return gemMeasurementType;
	}

	@Override
	public GEMMeasurementType updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementType gemMeasurementType)
		throws SystemException {
		gemMeasurementType = toUnwrappedModel(gemMeasurementType);

		boolean isNew = gemMeasurementType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemMeasurementType.isNew()) {
				session.save(gemMeasurementType);

				gemMeasurementType.setNew(false);
			}
			else {
				session.merge(gemMeasurementType);
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

		EntityCacheUtil.putResult(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementTypeImpl.class, gemMeasurementType.getPrimaryKey(),
			gemMeasurementType);

		return gemMeasurementType;
	}

	protected GEMMeasurementType toUnwrappedModel(
		GEMMeasurementType gemMeasurementType) {
		if (gemMeasurementType instanceof GEMMeasurementTypeImpl) {
			return gemMeasurementType;
		}

		GEMMeasurementTypeImpl gemMeasurementTypeImpl = new GEMMeasurementTypeImpl();

		gemMeasurementTypeImpl.setNew(gemMeasurementType.isNew());
		gemMeasurementTypeImpl.setPrimaryKey(gemMeasurementType.getPrimaryKey());

		gemMeasurementTypeImpl.setMeasurementType(gemMeasurementType.getMeasurementType());
		gemMeasurementTypeImpl.setMeasurementTypeDesc(gemMeasurementType.getMeasurementTypeDesc());
		gemMeasurementTypeImpl.setCreatorId(gemMeasurementType.getCreatorId());
		gemMeasurementTypeImpl.setCreatedDate(gemMeasurementType.getCreatedDate());
		gemMeasurementTypeImpl.setUpdatedBy(gemMeasurementType.getUpdatedBy());
		gemMeasurementTypeImpl.setUpdatedDate(gemMeasurementType.getUpdatedDate());

		return gemMeasurementTypeImpl;
	}

	/**
	 * Returns the g e m measurement type with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement type
	 * @return the g e m measurement type
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException if a g e m measurement type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMMeasurementTypeException, SystemException {
		GEMMeasurementType gemMeasurementType = fetchByPrimaryKey(primaryKey);

		if (gemMeasurementType == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMMeasurementTypeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemMeasurementType;
	}

	/**
	 * Returns the g e m measurement type with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException} if it could not be found.
	 *
	 * @param measurementType the primary key of the g e m measurement type
	 * @return the g e m measurement type
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException if a g e m measurement type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementType findByPrimaryKey(String measurementType)
		throws NoSuchGEMMeasurementTypeException, SystemException {
		return findByPrimaryKey((Serializable)measurementType);
	}

	/**
	 * Returns the g e m measurement type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement type
	 * @return the g e m measurement type, or <code>null</code> if a g e m measurement type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementType fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMMeasurementType gemMeasurementType = (GEMMeasurementType)EntityCacheUtil.getResult(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementTypeImpl.class, primaryKey);

		if (gemMeasurementType == _nullGEMMeasurementType) {
			return null;
		}

		if (gemMeasurementType == null) {
			Session session = null;

			try {
				session = openSession();

				gemMeasurementType = (GEMMeasurementType)session.get(GEMMeasurementTypeImpl.class,
						primaryKey);

				if (gemMeasurementType != null) {
					cacheResult(gemMeasurementType);
				}
				else {
					EntityCacheUtil.putResult(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementTypeImpl.class, primaryKey,
						_nullGEMMeasurementType);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMMeasurementTypeModelImpl.ENTITY_CACHE_ENABLED,
					GEMMeasurementTypeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemMeasurementType;
	}

	/**
	 * Returns the g e m measurement type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param measurementType the primary key of the g e m measurement type
	 * @return the g e m measurement type, or <code>null</code> if a g e m measurement type with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementType fetchByPrimaryKey(String measurementType)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)measurementType);
	}

	/**
	 * Returns all the g e m measurement types.
	 *
	 * @return the g e m measurement types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementType> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m measurement types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement types
	 * @param end the upper bound of the range of g e m measurement types (not inclusive)
	 * @return the range of g e m measurement types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementType> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m measurement types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement types
	 * @param end the upper bound of the range of g e m measurement types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m measurement types
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementType> findAll(int start, int end,
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

		List<GEMMeasurementType> list = (List<GEMMeasurementType>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMMEASUREMENTTYPE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMMEASUREMENTTYPE;

				if (pagination) {
					sql = sql.concat(GEMMeasurementTypeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMMeasurementType>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMMeasurementType>(list);
				}
				else {
					list = (List<GEMMeasurementType>)QueryUtil.list(q,
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
	 * Removes all the g e m measurement types from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMMeasurementType gemMeasurementType : findAll()) {
			remove(gemMeasurementType);
		}
	}

	/**
	 * Returns the number of g e m measurement types.
	 *
	 * @return the number of g e m measurement types
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

				Query q = session.createQuery(_SQL_COUNT_GEMMEASUREMENTTYPE);

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
	 * Initializes the g e m measurement type persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMMeasurementType")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMMeasurementType>> listenersList = new ArrayList<ModelListener<GEMMeasurementType>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMMeasurementType>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMMeasurementTypeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMMEASUREMENTTYPE = "SELECT gemMeasurementType FROM GEMMeasurementType gemMeasurementType";
	private static final String _SQL_COUNT_GEMMEASUREMENTTYPE = "SELECT COUNT(gemMeasurementType) FROM GEMMeasurementType gemMeasurementType";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemMeasurementType.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMMeasurementType exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMMeasurementTypePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"measurementType", "measurementTypeDesc", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMMeasurementType _nullGEMMeasurementType = new GEMMeasurementTypeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMMeasurementType> toCacheModel() {
				return _nullGEMMeasurementTypeCacheModel;
			}
		};

	private static CacheModel<GEMMeasurementType> _nullGEMMeasurementTypeCacheModel =
		new CacheModel<GEMMeasurementType>() {
			@Override
			public GEMMeasurementType toEntityModel() {
				return _nullGEMMeasurementType;
			}
		};
}