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

import com.ihg.brandstandards.db.NoSuchGEMScoringValueException;
import com.ihg.brandstandards.db.model.GEMScoringValue;
import com.ihg.brandstandards.db.model.impl.GEMScoringValueImpl;
import com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl;

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
 * The persistence implementation for the g e m scoring value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMScoringValuePersistence
 * @see GEMScoringValueUtil
 * @generated
 */
public class GEMScoringValuePersistenceImpl extends BasePersistenceImpl<GEMScoringValue>
	implements GEMScoringValuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMScoringValueUtil} to access the g e m scoring value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMScoringValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMScoringValueModelImpl.FINDER_CACHE_ENABLED,
			GEMScoringValueImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMScoringValueModelImpl.FINDER_CACHE_ENABLED,
			GEMScoringValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMScoringValueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMScoringValuePersistenceImpl() {
		setModelClass(GEMScoringValue.class);
	}

	/**
	 * Caches the g e m scoring value in the entity cache if it is enabled.
	 *
	 * @param gemScoringValue the g e m scoring value
	 */
	@Override
	public void cacheResult(GEMScoringValue gemScoringValue) {
		EntityCacheUtil.putResult(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMScoringValueImpl.class, gemScoringValue.getPrimaryKey(),
			gemScoringValue);

		gemScoringValue.resetOriginalValues();
	}

	/**
	 * Caches the g e m scoring values in the entity cache if it is enabled.
	 *
	 * @param gemScoringValues the g e m scoring values
	 */
	@Override
	public void cacheResult(List<GEMScoringValue> gemScoringValues) {
		for (GEMScoringValue gemScoringValue : gemScoringValues) {
			if (EntityCacheUtil.getResult(
						GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
						GEMScoringValueImpl.class,
						gemScoringValue.getPrimaryKey()) == null) {
				cacheResult(gemScoringValue);
			}
			else {
				gemScoringValue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m scoring values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMScoringValueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMScoringValueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m scoring value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMScoringValue gemScoringValue) {
		EntityCacheUtil.removeResult(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMScoringValueImpl.class, gemScoringValue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMScoringValue> gemScoringValues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMScoringValue gemScoringValue : gemScoringValues) {
			EntityCacheUtil.removeResult(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
				GEMScoringValueImpl.class, gemScoringValue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m scoring value with the primary key. Does not add the g e m scoring value to the database.
	 *
	 * @param scoringId the primary key for the new g e m scoring value
	 * @return the new g e m scoring value
	 */
	@Override
	public GEMScoringValue create(long scoringId) {
		GEMScoringValue gemScoringValue = new GEMScoringValueImpl();

		gemScoringValue.setNew(true);
		gemScoringValue.setPrimaryKey(scoringId);

		return gemScoringValue;
	}

	/**
	 * Removes the g e m scoring value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param scoringId the primary key of the g e m scoring value
	 * @return the g e m scoring value that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMScoringValueException if a g e m scoring value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMScoringValue remove(long scoringId)
		throws NoSuchGEMScoringValueException, SystemException {
		return remove((Serializable)scoringId);
	}

	/**
	 * Removes the g e m scoring value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m scoring value
	 * @return the g e m scoring value that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMScoringValueException if a g e m scoring value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMScoringValue remove(Serializable primaryKey)
		throws NoSuchGEMScoringValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMScoringValue gemScoringValue = (GEMScoringValue)session.get(GEMScoringValueImpl.class,
					primaryKey);

			if (gemScoringValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMScoringValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemScoringValue);
		}
		catch (NoSuchGEMScoringValueException nsee) {
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
	protected GEMScoringValue removeImpl(GEMScoringValue gemScoringValue)
		throws SystemException {
		gemScoringValue = toUnwrappedModel(gemScoringValue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemScoringValue)) {
				gemScoringValue = (GEMScoringValue)session.get(GEMScoringValueImpl.class,
						gemScoringValue.getPrimaryKeyObj());
			}

			if (gemScoringValue != null) {
				session.delete(gemScoringValue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemScoringValue != null) {
			clearCache(gemScoringValue);
		}

		return gemScoringValue;
	}

	@Override
	public GEMScoringValue updateImpl(
		com.ihg.brandstandards.db.model.GEMScoringValue gemScoringValue)
		throws SystemException {
		gemScoringValue = toUnwrappedModel(gemScoringValue);

		boolean isNew = gemScoringValue.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemScoringValue.isNew()) {
				session.save(gemScoringValue);

				gemScoringValue.setNew(false);
			}
			else {
				session.merge(gemScoringValue);
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

		EntityCacheUtil.putResult(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMScoringValueImpl.class, gemScoringValue.getPrimaryKey(),
			gemScoringValue);

		return gemScoringValue;
	}

	protected GEMScoringValue toUnwrappedModel(GEMScoringValue gemScoringValue) {
		if (gemScoringValue instanceof GEMScoringValueImpl) {
			return gemScoringValue;
		}

		GEMScoringValueImpl gemScoringValueImpl = new GEMScoringValueImpl();

		gemScoringValueImpl.setNew(gemScoringValue.isNew());
		gemScoringValueImpl.setPrimaryKey(gemScoringValue.getPrimaryKey());

		gemScoringValueImpl.setScoringId(gemScoringValue.getScoringId());
		gemScoringValueImpl.setMeasurementBucketChainId(gemScoringValue.getMeasurementBucketChainId());
		gemScoringValueImpl.setTotalMeasurement(gemScoringValue.getTotalMeasurement());
		gemScoringValueImpl.setNetMeasurement(gemScoringValue.getNetMeasurement());
		gemScoringValueImpl.setNonCompliantMeasurement(gemScoringValue.getNonCompliantMeasurement());
		gemScoringValueImpl.setNonCompliantMeasurementPercent(gemScoringValue.getNonCompliantMeasurementPercent());
		gemScoringValueImpl.setCreatorId(gemScoringValue.getCreatorId());
		gemScoringValueImpl.setCreatedDate(gemScoringValue.getCreatedDate());
		gemScoringValueImpl.setUpdatedBy(gemScoringValue.getUpdatedBy());
		gemScoringValueImpl.setUpdatedDate(gemScoringValue.getUpdatedDate());

		return gemScoringValueImpl;
	}

	/**
	 * Returns the g e m scoring value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m scoring value
	 * @return the g e m scoring value
	 * @throws com.ihg.brandstandards.db.NoSuchGEMScoringValueException if a g e m scoring value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMScoringValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMScoringValueException, SystemException {
		GEMScoringValue gemScoringValue = fetchByPrimaryKey(primaryKey);

		if (gemScoringValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMScoringValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemScoringValue;
	}

	/**
	 * Returns the g e m scoring value with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMScoringValueException} if it could not be found.
	 *
	 * @param scoringId the primary key of the g e m scoring value
	 * @return the g e m scoring value
	 * @throws com.ihg.brandstandards.db.NoSuchGEMScoringValueException if a g e m scoring value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMScoringValue findByPrimaryKey(long scoringId)
		throws NoSuchGEMScoringValueException, SystemException {
		return findByPrimaryKey((Serializable)scoringId);
	}

	/**
	 * Returns the g e m scoring value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m scoring value
	 * @return the g e m scoring value, or <code>null</code> if a g e m scoring value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMScoringValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMScoringValue gemScoringValue = (GEMScoringValue)EntityCacheUtil.getResult(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
				GEMScoringValueImpl.class, primaryKey);

		if (gemScoringValue == _nullGEMScoringValue) {
			return null;
		}

		if (gemScoringValue == null) {
			Session session = null;

			try {
				session = openSession();

				gemScoringValue = (GEMScoringValue)session.get(GEMScoringValueImpl.class,
						primaryKey);

				if (gemScoringValue != null) {
					cacheResult(gemScoringValue);
				}
				else {
					EntityCacheUtil.putResult(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
						GEMScoringValueImpl.class, primaryKey,
						_nullGEMScoringValue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMScoringValueModelImpl.ENTITY_CACHE_ENABLED,
					GEMScoringValueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemScoringValue;
	}

	/**
	 * Returns the g e m scoring value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param scoringId the primary key of the g e m scoring value
	 * @return the g e m scoring value, or <code>null</code> if a g e m scoring value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMScoringValue fetchByPrimaryKey(long scoringId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)scoringId);
	}

	/**
	 * Returns all the g e m scoring values.
	 *
	 * @return the g e m scoring values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMScoringValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m scoring values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m scoring values
	 * @param end the upper bound of the range of g e m scoring values (not inclusive)
	 * @return the range of g e m scoring values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMScoringValue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m scoring values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m scoring values
	 * @param end the upper bound of the range of g e m scoring values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m scoring values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMScoringValue> findAll(int start, int end,
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

		List<GEMScoringValue> list = (List<GEMScoringValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMSCORINGVALUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMSCORINGVALUE;

				if (pagination) {
					sql = sql.concat(GEMScoringValueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMScoringValue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMScoringValue>(list);
				}
				else {
					list = (List<GEMScoringValue>)QueryUtil.list(q,
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
	 * Removes all the g e m scoring values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMScoringValue gemScoringValue : findAll()) {
			remove(gemScoringValue);
		}
	}

	/**
	 * Returns the number of g e m scoring values.
	 *
	 * @return the number of g e m scoring values
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

				Query q = session.createQuery(_SQL_COUNT_GEMSCORINGVALUE);

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
	 * Initializes the g e m scoring value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMScoringValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMScoringValue>> listenersList = new ArrayList<ModelListener<GEMScoringValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMScoringValue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMScoringValueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMSCORINGVALUE = "SELECT gemScoringValue FROM GEMScoringValue gemScoringValue";
	private static final String _SQL_COUNT_GEMSCORINGVALUE = "SELECT COUNT(gemScoringValue) FROM GEMScoringValue gemScoringValue";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemScoringValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMScoringValue exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMScoringValuePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"scoringId", "measurementBucketChainId", "totalMeasurement",
				"netMeasurement", "nonCompliantMeasurement",
				"nonCompliantMeasurementPercent", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static GEMScoringValue _nullGEMScoringValue = new GEMScoringValueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMScoringValue> toCacheModel() {
				return _nullGEMScoringValueCacheModel;
			}
		};

	private static CacheModel<GEMScoringValue> _nullGEMScoringValueCacheModel = new CacheModel<GEMScoringValue>() {
			@Override
			public GEMScoringValue toEntityModel() {
				return _nullGEMScoringValue;
			}
		};
}