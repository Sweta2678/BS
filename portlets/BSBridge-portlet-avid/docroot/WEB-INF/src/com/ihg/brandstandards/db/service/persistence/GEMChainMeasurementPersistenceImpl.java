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

import com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException;
import com.ihg.brandstandards.db.model.GEMChainMeasurement;
import com.ihg.brandstandards.db.model.impl.GEMChainMeasurementImpl;
import com.ihg.brandstandards.db.model.impl.GEMChainMeasurementModelImpl;

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
 * The persistence implementation for the g e m chain measurement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMChainMeasurementPersistence
 * @see GEMChainMeasurementUtil
 * @generated
 */
public class GEMChainMeasurementPersistenceImpl extends BasePersistenceImpl<GEMChainMeasurement>
	implements GEMChainMeasurementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMChainMeasurementUtil} to access the g e m chain measurement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMChainMeasurementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMChainMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMChainMeasurementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMChainMeasurementModelImpl.FINDER_CACHE_ENABLED,
			GEMChainMeasurementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMChainMeasurementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMChainMeasurementPersistenceImpl() {
		setModelClass(GEMChainMeasurement.class);
	}

	/**
	 * Caches the g e m chain measurement in the entity cache if it is enabled.
	 *
	 * @param gemChainMeasurement the g e m chain measurement
	 */
	@Override
	public void cacheResult(GEMChainMeasurement gemChainMeasurement) {
		EntityCacheUtil.putResult(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMChainMeasurementImpl.class, gemChainMeasurement.getPrimaryKey(),
			gemChainMeasurement);

		gemChainMeasurement.resetOriginalValues();
	}

	/**
	 * Caches the g e m chain measurements in the entity cache if it is enabled.
	 *
	 * @param gemChainMeasurements the g e m chain measurements
	 */
	@Override
	public void cacheResult(List<GEMChainMeasurement> gemChainMeasurements) {
		for (GEMChainMeasurement gemChainMeasurement : gemChainMeasurements) {
			if (EntityCacheUtil.getResult(
						GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
						GEMChainMeasurementImpl.class,
						gemChainMeasurement.getPrimaryKey()) == null) {
				cacheResult(gemChainMeasurement);
			}
			else {
				gemChainMeasurement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m chain measurements.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMChainMeasurementImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMChainMeasurementImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m chain measurement.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMChainMeasurement gemChainMeasurement) {
		EntityCacheUtil.removeResult(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMChainMeasurementImpl.class, gemChainMeasurement.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMChainMeasurement> gemChainMeasurements) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMChainMeasurement gemChainMeasurement : gemChainMeasurements) {
			EntityCacheUtil.removeResult(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
				GEMChainMeasurementImpl.class,
				gemChainMeasurement.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m chain measurement with the primary key. Does not add the g e m chain measurement to the database.
	 *
	 * @param chainMeasurementId the primary key for the new g e m chain measurement
	 * @return the new g e m chain measurement
	 */
	@Override
	public GEMChainMeasurement create(long chainMeasurementId) {
		GEMChainMeasurement gemChainMeasurement = new GEMChainMeasurementImpl();

		gemChainMeasurement.setNew(true);
		gemChainMeasurement.setPrimaryKey(chainMeasurementId);

		return gemChainMeasurement;
	}

	/**
	 * Removes the g e m chain measurement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param chainMeasurementId the primary key of the g e m chain measurement
	 * @return the g e m chain measurement that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException if a g e m chain measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMChainMeasurement remove(long chainMeasurementId)
		throws NoSuchGEMChainMeasurementException, SystemException {
		return remove((Serializable)chainMeasurementId);
	}

	/**
	 * Removes the g e m chain measurement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m chain measurement
	 * @return the g e m chain measurement that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException if a g e m chain measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMChainMeasurement remove(Serializable primaryKey)
		throws NoSuchGEMChainMeasurementException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMChainMeasurement gemChainMeasurement = (GEMChainMeasurement)session.get(GEMChainMeasurementImpl.class,
					primaryKey);

			if (gemChainMeasurement == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMChainMeasurementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemChainMeasurement);
		}
		catch (NoSuchGEMChainMeasurementException nsee) {
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
	protected GEMChainMeasurement removeImpl(
		GEMChainMeasurement gemChainMeasurement) throws SystemException {
		gemChainMeasurement = toUnwrappedModel(gemChainMeasurement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemChainMeasurement)) {
				gemChainMeasurement = (GEMChainMeasurement)session.get(GEMChainMeasurementImpl.class,
						gemChainMeasurement.getPrimaryKeyObj());
			}

			if (gemChainMeasurement != null) {
				session.delete(gemChainMeasurement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemChainMeasurement != null) {
			clearCache(gemChainMeasurement);
		}

		return gemChainMeasurement;
	}

	@Override
	public GEMChainMeasurement updateImpl(
		com.ihg.brandstandards.db.model.GEMChainMeasurement gemChainMeasurement)
		throws SystemException {
		gemChainMeasurement = toUnwrappedModel(gemChainMeasurement);

		boolean isNew = gemChainMeasurement.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemChainMeasurement.isNew()) {
				session.save(gemChainMeasurement);

				gemChainMeasurement.setNew(false);
			}
			else {
				session.merge(gemChainMeasurement);
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

		EntityCacheUtil.putResult(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
			GEMChainMeasurementImpl.class, gemChainMeasurement.getPrimaryKey(),
			gemChainMeasurement);

		return gemChainMeasurement;
	}

	protected GEMChainMeasurement toUnwrappedModel(
		GEMChainMeasurement gemChainMeasurement) {
		if (gemChainMeasurement instanceof GEMChainMeasurementImpl) {
			return gemChainMeasurement;
		}

		GEMChainMeasurementImpl gemChainMeasurementImpl = new GEMChainMeasurementImpl();

		gemChainMeasurementImpl.setNew(gemChainMeasurement.isNew());
		gemChainMeasurementImpl.setPrimaryKey(gemChainMeasurement.getPrimaryKey());

		gemChainMeasurementImpl.setChainMeasurementId(gemChainMeasurement.getChainMeasurementId());
		gemChainMeasurementImpl.setMeasurementId(gemChainMeasurement.getMeasurementId());
		gemChainMeasurementImpl.setPublishDeptId(gemChainMeasurement.getPublishDeptId());
		gemChainMeasurementImpl.setPublishId(gemChainMeasurement.getPublishId());
		gemChainMeasurementImpl.setRegionId(gemChainMeasurement.getRegionId());
		gemChainMeasurementImpl.setUniqueGroupId(gemChainMeasurement.getUniqueGroupId());
		gemChainMeasurementImpl.setMeasurementItemCount(gemChainMeasurement.getMeasurementItemCount());
		gemChainMeasurementImpl.setCreatorId(gemChainMeasurement.getCreatorId());
		gemChainMeasurementImpl.setCreatedDate(gemChainMeasurement.getCreatedDate());
		gemChainMeasurementImpl.setUpdatedBy(gemChainMeasurement.getUpdatedBy());
		gemChainMeasurementImpl.setUpdatedDate(gemChainMeasurement.getUpdatedDate());

		return gemChainMeasurementImpl;
	}

	/**
	 * Returns the g e m chain measurement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m chain measurement
	 * @return the g e m chain measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException if a g e m chain measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMChainMeasurement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMChainMeasurementException, SystemException {
		GEMChainMeasurement gemChainMeasurement = fetchByPrimaryKey(primaryKey);

		if (gemChainMeasurement == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMChainMeasurementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemChainMeasurement;
	}

	/**
	 * Returns the g e m chain measurement with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException} if it could not be found.
	 *
	 * @param chainMeasurementId the primary key of the g e m chain measurement
	 * @return the g e m chain measurement
	 * @throws com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException if a g e m chain measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMChainMeasurement findByPrimaryKey(long chainMeasurementId)
		throws NoSuchGEMChainMeasurementException, SystemException {
		return findByPrimaryKey((Serializable)chainMeasurementId);
	}

	/**
	 * Returns the g e m chain measurement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m chain measurement
	 * @return the g e m chain measurement, or <code>null</code> if a g e m chain measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMChainMeasurement fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMChainMeasurement gemChainMeasurement = (GEMChainMeasurement)EntityCacheUtil.getResult(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
				GEMChainMeasurementImpl.class, primaryKey);

		if (gemChainMeasurement == _nullGEMChainMeasurement) {
			return null;
		}

		if (gemChainMeasurement == null) {
			Session session = null;

			try {
				session = openSession();

				gemChainMeasurement = (GEMChainMeasurement)session.get(GEMChainMeasurementImpl.class,
						primaryKey);

				if (gemChainMeasurement != null) {
					cacheResult(gemChainMeasurement);
				}
				else {
					EntityCacheUtil.putResult(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
						GEMChainMeasurementImpl.class, primaryKey,
						_nullGEMChainMeasurement);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMChainMeasurementModelImpl.ENTITY_CACHE_ENABLED,
					GEMChainMeasurementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemChainMeasurement;
	}

	/**
	 * Returns the g e m chain measurement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param chainMeasurementId the primary key of the g e m chain measurement
	 * @return the g e m chain measurement, or <code>null</code> if a g e m chain measurement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMChainMeasurement fetchByPrimaryKey(long chainMeasurementId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)chainMeasurementId);
	}

	/**
	 * Returns all the g e m chain measurements.
	 *
	 * @return the g e m chain measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMChainMeasurement> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m chain measurements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMChainMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m chain measurements
	 * @param end the upper bound of the range of g e m chain measurements (not inclusive)
	 * @return the range of g e m chain measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMChainMeasurement> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m chain measurements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMChainMeasurementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m chain measurements
	 * @param end the upper bound of the range of g e m chain measurements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m chain measurements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMChainMeasurement> findAll(int start, int end,
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

		List<GEMChainMeasurement> list = (List<GEMChainMeasurement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMCHAINMEASUREMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMCHAINMEASUREMENT;

				if (pagination) {
					sql = sql.concat(GEMChainMeasurementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMChainMeasurement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMChainMeasurement>(list);
				}
				else {
					list = (List<GEMChainMeasurement>)QueryUtil.list(q,
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
	 * Removes all the g e m chain measurements from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMChainMeasurement gemChainMeasurement : findAll()) {
			remove(gemChainMeasurement);
		}
	}

	/**
	 * Returns the number of g e m chain measurements.
	 *
	 * @return the number of g e m chain measurements
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

				Query q = session.createQuery(_SQL_COUNT_GEMCHAINMEASUREMENT);

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
	 * Initializes the g e m chain measurement persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMChainMeasurement")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMChainMeasurement>> listenersList = new ArrayList<ModelListener<GEMChainMeasurement>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMChainMeasurement>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMChainMeasurementImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMCHAINMEASUREMENT = "SELECT gemChainMeasurement FROM GEMChainMeasurement gemChainMeasurement";
	private static final String _SQL_COUNT_GEMCHAINMEASUREMENT = "SELECT COUNT(gemChainMeasurement) FROM GEMChainMeasurement gemChainMeasurement";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemChainMeasurement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMChainMeasurement exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMChainMeasurementPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"chainMeasurementId", "measurementId", "publishDeptId",
				"publishId", "regionId", "uniqueGroupId", "measurementItemCount",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static GEMChainMeasurement _nullGEMChainMeasurement = new GEMChainMeasurementImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMChainMeasurement> toCacheModel() {
				return _nullGEMChainMeasurementCacheModel;
			}
		};

	private static CacheModel<GEMChainMeasurement> _nullGEMChainMeasurementCacheModel =
		new CacheModel<GEMChainMeasurement>() {
			@Override
			public GEMChainMeasurement toEntityModel() {
				return _nullGEMChainMeasurement;
			}
		};
}