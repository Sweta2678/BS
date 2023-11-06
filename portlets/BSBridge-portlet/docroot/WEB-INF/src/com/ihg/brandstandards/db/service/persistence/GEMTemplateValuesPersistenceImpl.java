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

import com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException;
import com.ihg.brandstandards.db.model.GEMTemplateValues;
import com.ihg.brandstandards.db.model.impl.GEMTemplateValuesImpl;
import com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl;

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
 * The persistence implementation for the g e m template values service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateValuesPersistence
 * @see GEMTemplateValuesUtil
 * @generated
 */
public class GEMTemplateValuesPersistenceImpl extends BasePersistenceImpl<GEMTemplateValues>
	implements GEMTemplateValuesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMTemplateValuesUtil} to access the g e m template values persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMTemplateValuesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateValuesModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateValuesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateValuesModelImpl.FINDER_CACHE_ENABLED,
			GEMTemplateValuesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateValuesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMTemplateValuesPersistenceImpl() {
		setModelClass(GEMTemplateValues.class);
	}

	/**
	 * Caches the g e m template values in the entity cache if it is enabled.
	 *
	 * @param gemTemplateValues the g e m template values
	 */
	@Override
	public void cacheResult(GEMTemplateValues gemTemplateValues) {
		EntityCacheUtil.putResult(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateValuesImpl.class, gemTemplateValues.getPrimaryKey(),
			gemTemplateValues);

		gemTemplateValues.resetOriginalValues();
	}

	/**
	 * Caches the g e m template valueses in the entity cache if it is enabled.
	 *
	 * @param gemTemplateValueses the g e m template valueses
	 */
	@Override
	public void cacheResult(List<GEMTemplateValues> gemTemplateValueses) {
		for (GEMTemplateValues gemTemplateValues : gemTemplateValueses) {
			if (EntityCacheUtil.getResult(
						GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateValuesImpl.class,
						gemTemplateValues.getPrimaryKey()) == null) {
				cacheResult(gemTemplateValues);
			}
			else {
				gemTemplateValues.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m template valueses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMTemplateValuesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMTemplateValuesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m template values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMTemplateValues gemTemplateValues) {
		EntityCacheUtil.removeResult(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateValuesImpl.class, gemTemplateValues.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMTemplateValues> gemTemplateValueses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMTemplateValues gemTemplateValues : gemTemplateValueses) {
			EntityCacheUtil.removeResult(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateValuesImpl.class, gemTemplateValues.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m template values with the primary key. Does not add the g e m template values to the database.
	 *
	 * @param valueId the primary key for the new g e m template values
	 * @return the new g e m template values
	 */
	@Override
	public GEMTemplateValues create(long valueId) {
		GEMTemplateValues gemTemplateValues = new GEMTemplateValuesImpl();

		gemTemplateValues.setNew(true);
		gemTemplateValues.setPrimaryKey(valueId);

		return gemTemplateValues;
	}

	/**
	 * Removes the g e m template values with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param valueId the primary key of the g e m template values
	 * @return the g e m template values that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException if a g e m template values with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateValues remove(long valueId)
		throws NoSuchGEMTemplateValuesException, SystemException {
		return remove((Serializable)valueId);
	}

	/**
	 * Removes the g e m template values with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m template values
	 * @return the g e m template values that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException if a g e m template values with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateValues remove(Serializable primaryKey)
		throws NoSuchGEMTemplateValuesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMTemplateValues gemTemplateValues = (GEMTemplateValues)session.get(GEMTemplateValuesImpl.class,
					primaryKey);

			if (gemTemplateValues == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMTemplateValuesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemTemplateValues);
		}
		catch (NoSuchGEMTemplateValuesException nsee) {
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
	protected GEMTemplateValues removeImpl(GEMTemplateValues gemTemplateValues)
		throws SystemException {
		gemTemplateValues = toUnwrappedModel(gemTemplateValues);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemTemplateValues)) {
				gemTemplateValues = (GEMTemplateValues)session.get(GEMTemplateValuesImpl.class,
						gemTemplateValues.getPrimaryKeyObj());
			}

			if (gemTemplateValues != null) {
				session.delete(gemTemplateValues);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemTemplateValues != null) {
			clearCache(gemTemplateValues);
		}

		return gemTemplateValues;
	}

	@Override
	public GEMTemplateValues updateImpl(
		com.ihg.brandstandards.db.model.GEMTemplateValues gemTemplateValues)
		throws SystemException {
		gemTemplateValues = toUnwrappedModel(gemTemplateValues);

		boolean isNew = gemTemplateValues.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemTemplateValues.isNew()) {
				session.save(gemTemplateValues);

				gemTemplateValues.setNew(false);
			}
			else {
				session.merge(gemTemplateValues);
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

		EntityCacheUtil.putResult(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
			GEMTemplateValuesImpl.class, gemTemplateValues.getPrimaryKey(),
			gemTemplateValues);

		return gemTemplateValues;
	}

	protected GEMTemplateValues toUnwrappedModel(
		GEMTemplateValues gemTemplateValues) {
		if (gemTemplateValues instanceof GEMTemplateValuesImpl) {
			return gemTemplateValues;
		}

		GEMTemplateValuesImpl gemTemplateValuesImpl = new GEMTemplateValuesImpl();

		gemTemplateValuesImpl.setNew(gemTemplateValues.isNew());
		gemTemplateValuesImpl.setPrimaryKey(gemTemplateValues.getPrimaryKey());

		gemTemplateValuesImpl.setValueId(gemTemplateValues.getValueId());
		gemTemplateValuesImpl.setColumnId(gemTemplateValues.getColumnId());
		gemTemplateValuesImpl.setCategoryId(gemTemplateValues.getCategoryId());
		gemTemplateValuesImpl.setColumnValue(gemTemplateValues.getColumnValue());
		gemTemplateValuesImpl.setDisplayOrderNumber(gemTemplateValues.getDisplayOrderNumber());
		gemTemplateValuesImpl.setCreatorId(gemTemplateValues.getCreatorId());
		gemTemplateValuesImpl.setCreatedDate(gemTemplateValues.getCreatedDate());
		gemTemplateValuesImpl.setUpdatedBy(gemTemplateValues.getUpdatedBy());
		gemTemplateValuesImpl.setUpdatedDate(gemTemplateValues.getUpdatedDate());

		return gemTemplateValuesImpl;
	}

	/**
	 * Returns the g e m template values with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template values
	 * @return the g e m template values
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException if a g e m template values with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateValues findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMTemplateValuesException, SystemException {
		GEMTemplateValues gemTemplateValues = fetchByPrimaryKey(primaryKey);

		if (gemTemplateValues == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMTemplateValuesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemTemplateValues;
	}

	/**
	 * Returns the g e m template values with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException} if it could not be found.
	 *
	 * @param valueId the primary key of the g e m template values
	 * @return the g e m template values
	 * @throws com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException if a g e m template values with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateValues findByPrimaryKey(long valueId)
		throws NoSuchGEMTemplateValuesException, SystemException {
		return findByPrimaryKey((Serializable)valueId);
	}

	/**
	 * Returns the g e m template values with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m template values
	 * @return the g e m template values, or <code>null</code> if a g e m template values with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateValues fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMTemplateValues gemTemplateValues = (GEMTemplateValues)EntityCacheUtil.getResult(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
				GEMTemplateValuesImpl.class, primaryKey);

		if (gemTemplateValues == _nullGEMTemplateValues) {
			return null;
		}

		if (gemTemplateValues == null) {
			Session session = null;

			try {
				session = openSession();

				gemTemplateValues = (GEMTemplateValues)session.get(GEMTemplateValuesImpl.class,
						primaryKey);

				if (gemTemplateValues != null) {
					cacheResult(gemTemplateValues);
				}
				else {
					EntityCacheUtil.putResult(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
						GEMTemplateValuesImpl.class, primaryKey,
						_nullGEMTemplateValues);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMTemplateValuesModelImpl.ENTITY_CACHE_ENABLED,
					GEMTemplateValuesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemTemplateValues;
	}

	/**
	 * Returns the g e m template values with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param valueId the primary key of the g e m template values
	 * @return the g e m template values, or <code>null</code> if a g e m template values with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMTemplateValues fetchByPrimaryKey(long valueId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)valueId);
	}

	/**
	 * Returns all the g e m template valueses.
	 *
	 * @return the g e m template valueses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateValues> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m template valueses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template valueses
	 * @param end the upper bound of the range of g e m template valueses (not inclusive)
	 * @return the range of g e m template valueses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateValues> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m template valueses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m template valueses
	 * @param end the upper bound of the range of g e m template valueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m template valueses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMTemplateValues> findAll(int start, int end,
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

		List<GEMTemplateValues> list = (List<GEMTemplateValues>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMTEMPLATEVALUES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMTEMPLATEVALUES;

				if (pagination) {
					sql = sql.concat(GEMTemplateValuesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMTemplateValues>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMTemplateValues>(list);
				}
				else {
					list = (List<GEMTemplateValues>)QueryUtil.list(q,
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
	 * Removes all the g e m template valueses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMTemplateValues gemTemplateValues : findAll()) {
			remove(gemTemplateValues);
		}
	}

	/**
	 * Returns the number of g e m template valueses.
	 *
	 * @return the number of g e m template valueses
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

				Query q = session.createQuery(_SQL_COUNT_GEMTEMPLATEVALUES);

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
	 * Initializes the g e m template values persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMTemplateValues")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMTemplateValues>> listenersList = new ArrayList<ModelListener<GEMTemplateValues>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMTemplateValues>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMTemplateValuesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMTEMPLATEVALUES = "SELECT gemTemplateValues FROM GEMTemplateValues gemTemplateValues";
	private static final String _SQL_COUNT_GEMTEMPLATEVALUES = "SELECT COUNT(gemTemplateValues) FROM GEMTemplateValues gemTemplateValues";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemTemplateValues.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMTemplateValues exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMTemplateValuesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"valueId", "columnId", "categoryId", "columnValue",
				"displayOrderNumber", "creatorId", "createdDate", "updatedBy",
				"updatedDate"
			});
	private static GEMTemplateValues _nullGEMTemplateValues = new GEMTemplateValuesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMTemplateValues> toCacheModel() {
				return _nullGEMTemplateValuesCacheModel;
			}
		};

	private static CacheModel<GEMTemplateValues> _nullGEMTemplateValuesCacheModel =
		new CacheModel<GEMTemplateValues>() {
			@Override
			public GEMTemplateValues toEntityModel() {
				return _nullGEMTemplateValues;
			}
		};
}