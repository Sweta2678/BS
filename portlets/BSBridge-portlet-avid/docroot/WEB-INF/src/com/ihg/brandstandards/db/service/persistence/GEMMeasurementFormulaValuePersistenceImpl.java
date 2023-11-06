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

import com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException;
import com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaValueImpl;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaValueModelImpl;

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
 * The persistence implementation for the g e m measurement formula value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementFormulaValuePersistence
 * @see GEMMeasurementFormulaValueUtil
 * @generated
 */
public class GEMMeasurementFormulaValuePersistenceImpl
	extends BasePersistenceImpl<GEMMeasurementFormulaValue>
	implements GEMMeasurementFormulaValuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMMeasurementFormulaValueUtil} to access the g e m measurement formula value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMMeasurementFormulaValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaValueModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementFormulaValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaValueModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementFormulaValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaValueModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public GEMMeasurementFormulaValuePersistenceImpl() {
		setModelClass(GEMMeasurementFormulaValue.class);
	}

	/**
	 * Caches the g e m measurement formula value in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementFormulaValue the g e m measurement formula value
	 */
	@Override
	public void cacheResult(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		EntityCacheUtil.putResult(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaValueImpl.class,
			gemMeasurementFormulaValue.getPrimaryKey(),
			gemMeasurementFormulaValue);

		gemMeasurementFormulaValue.resetOriginalValues();
	}

	/**
	 * Caches the g e m measurement formula values in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementFormulaValues the g e m measurement formula values
	 */
	@Override
	public void cacheResult(
		List<GEMMeasurementFormulaValue> gemMeasurementFormulaValues) {
		for (GEMMeasurementFormulaValue gemMeasurementFormulaValue : gemMeasurementFormulaValues) {
			if (EntityCacheUtil.getResult(
						GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementFormulaValueImpl.class,
						gemMeasurementFormulaValue.getPrimaryKey()) == null) {
				cacheResult(gemMeasurementFormulaValue);
			}
			else {
				gemMeasurementFormulaValue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m measurement formula values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMMeasurementFormulaValueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMMeasurementFormulaValueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m measurement formula value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		EntityCacheUtil.removeResult(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaValueImpl.class,
			gemMeasurementFormulaValue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<GEMMeasurementFormulaValue> gemMeasurementFormulaValues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMMeasurementFormulaValue gemMeasurementFormulaValue : gemMeasurementFormulaValues) {
			EntityCacheUtil.removeResult(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementFormulaValueImpl.class,
				gemMeasurementFormulaValue.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m measurement formula value with the primary key. Does not add the g e m measurement formula value to the database.
	 *
	 * @param formulaValueId the primary key for the new g e m measurement formula value
	 * @return the new g e m measurement formula value
	 */
	@Override
	public GEMMeasurementFormulaValue create(long formulaValueId) {
		GEMMeasurementFormulaValue gemMeasurementFormulaValue = new GEMMeasurementFormulaValueImpl();

		gemMeasurementFormulaValue.setNew(true);
		gemMeasurementFormulaValue.setPrimaryKey(formulaValueId);

		return gemMeasurementFormulaValue;
	}

	/**
	 * Removes the g e m measurement formula value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formulaValueId the primary key of the g e m measurement formula value
	 * @return the g e m measurement formula value that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormulaValue remove(long formulaValueId)
		throws NoSuchGEMMeasurementFormulaValueException, SystemException {
		return remove((Serializable)formulaValueId);
	}

	/**
	 * Removes the g e m measurement formula value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m measurement formula value
	 * @return the g e m measurement formula value that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormulaValue remove(Serializable primaryKey)
		throws NoSuchGEMMeasurementFormulaValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMMeasurementFormulaValue gemMeasurementFormulaValue = (GEMMeasurementFormulaValue)session.get(GEMMeasurementFormulaValueImpl.class,
					primaryKey);

			if (gemMeasurementFormulaValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMMeasurementFormulaValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemMeasurementFormulaValue);
		}
		catch (NoSuchGEMMeasurementFormulaValueException nsee) {
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
	protected GEMMeasurementFormulaValue removeImpl(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue)
		throws SystemException {
		gemMeasurementFormulaValue = toUnwrappedModel(gemMeasurementFormulaValue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemMeasurementFormulaValue)) {
				gemMeasurementFormulaValue = (GEMMeasurementFormulaValue)session.get(GEMMeasurementFormulaValueImpl.class,
						gemMeasurementFormulaValue.getPrimaryKeyObj());
			}

			if (gemMeasurementFormulaValue != null) {
				session.delete(gemMeasurementFormulaValue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemMeasurementFormulaValue != null) {
			clearCache(gemMeasurementFormulaValue);
		}

		return gemMeasurementFormulaValue;
	}

	@Override
	public GEMMeasurementFormulaValue updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue gemMeasurementFormulaValue)
		throws SystemException {
		gemMeasurementFormulaValue = toUnwrappedModel(gemMeasurementFormulaValue);

		boolean isNew = gemMeasurementFormulaValue.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemMeasurementFormulaValue.isNew()) {
				session.save(gemMeasurementFormulaValue);

				gemMeasurementFormulaValue.setNew(false);
			}
			else {
				session.merge(gemMeasurementFormulaValue);
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

		EntityCacheUtil.putResult(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaValueImpl.class,
			gemMeasurementFormulaValue.getPrimaryKey(),
			gemMeasurementFormulaValue);

		return gemMeasurementFormulaValue;
	}

	protected GEMMeasurementFormulaValue toUnwrappedModel(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		if (gemMeasurementFormulaValue instanceof GEMMeasurementFormulaValueImpl) {
			return gemMeasurementFormulaValue;
		}

		GEMMeasurementFormulaValueImpl gemMeasurementFormulaValueImpl = new GEMMeasurementFormulaValueImpl();

		gemMeasurementFormulaValueImpl.setNew(gemMeasurementFormulaValue.isNew());
		gemMeasurementFormulaValueImpl.setPrimaryKey(gemMeasurementFormulaValue.getPrimaryKey());

		gemMeasurementFormulaValueImpl.setFormulaValueId(gemMeasurementFormulaValue.getFormulaValueId());
		gemMeasurementFormulaValueImpl.setFormulaId(gemMeasurementFormulaValue.getFormulaId());
		gemMeasurementFormulaValueImpl.setFormulaType(gemMeasurementFormulaValue.getFormulaType());
		gemMeasurementFormulaValueImpl.setFormulaValue(gemMeasurementFormulaValue.getFormulaValue());
		gemMeasurementFormulaValueImpl.setCreatorId(gemMeasurementFormulaValue.getCreatorId());
		gemMeasurementFormulaValueImpl.setCreatedDate(gemMeasurementFormulaValue.getCreatedDate());
		gemMeasurementFormulaValueImpl.setUpdatedBy(gemMeasurementFormulaValue.getUpdatedBy());
		gemMeasurementFormulaValueImpl.setUpdatedDate(gemMeasurementFormulaValue.getUpdatedDate());

		return gemMeasurementFormulaValueImpl;
	}

	/**
	 * Returns the g e m measurement formula value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement formula value
	 * @return the g e m measurement formula value
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormulaValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMMeasurementFormulaValueException, SystemException {
		GEMMeasurementFormulaValue gemMeasurementFormulaValue = fetchByPrimaryKey(primaryKey);

		if (gemMeasurementFormulaValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMMeasurementFormulaValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemMeasurementFormulaValue;
	}

	/**
	 * Returns the g e m measurement formula value with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException} if it could not be found.
	 *
	 * @param formulaValueId the primary key of the g e m measurement formula value
	 * @return the g e m measurement formula value
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException if a g e m measurement formula value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormulaValue findByPrimaryKey(long formulaValueId)
		throws NoSuchGEMMeasurementFormulaValueException, SystemException {
		return findByPrimaryKey((Serializable)formulaValueId);
	}

	/**
	 * Returns the g e m measurement formula value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement formula value
	 * @return the g e m measurement formula value, or <code>null</code> if a g e m measurement formula value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormulaValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMMeasurementFormulaValue gemMeasurementFormulaValue = (GEMMeasurementFormulaValue)EntityCacheUtil.getResult(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementFormulaValueImpl.class, primaryKey);

		if (gemMeasurementFormulaValue == _nullGEMMeasurementFormulaValue) {
			return null;
		}

		if (gemMeasurementFormulaValue == null) {
			Session session = null;

			try {
				session = openSession();

				gemMeasurementFormulaValue = (GEMMeasurementFormulaValue)session.get(GEMMeasurementFormulaValueImpl.class,
						primaryKey);

				if (gemMeasurementFormulaValue != null) {
					cacheResult(gemMeasurementFormulaValue);
				}
				else {
					EntityCacheUtil.putResult(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementFormulaValueImpl.class, primaryKey,
						_nullGEMMeasurementFormulaValue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMMeasurementFormulaValueModelImpl.ENTITY_CACHE_ENABLED,
					GEMMeasurementFormulaValueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemMeasurementFormulaValue;
	}

	/**
	 * Returns the g e m measurement formula value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formulaValueId the primary key of the g e m measurement formula value
	 * @return the g e m measurement formula value, or <code>null</code> if a g e m measurement formula value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormulaValue fetchByPrimaryKey(long formulaValueId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)formulaValueId);
	}

	/**
	 * Returns all the g e m measurement formula values.
	 *
	 * @return the g e m measurement formula values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementFormulaValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m measurement formula values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement formula values
	 * @param end the upper bound of the range of g e m measurement formula values (not inclusive)
	 * @return the range of g e m measurement formula values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementFormulaValue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m measurement formula values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement formula values
	 * @param end the upper bound of the range of g e m measurement formula values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m measurement formula values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementFormulaValue> findAll(int start, int end,
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

		List<GEMMeasurementFormulaValue> list = (List<GEMMeasurementFormulaValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMMEASUREMENTFORMULAVALUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMMEASUREMENTFORMULAVALUE;

				if (pagination) {
					sql = sql.concat(GEMMeasurementFormulaValueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMMeasurementFormulaValue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMMeasurementFormulaValue>(list);
				}
				else {
					list = (List<GEMMeasurementFormulaValue>)QueryUtil.list(q,
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
	 * Removes all the g e m measurement formula values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMMeasurementFormulaValue gemMeasurementFormulaValue : findAll()) {
			remove(gemMeasurementFormulaValue);
		}
	}

	/**
	 * Returns the number of g e m measurement formula values.
	 *
	 * @return the number of g e m measurement formula values
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

				Query q = session.createQuery(_SQL_COUNT_GEMMEASUREMENTFORMULAVALUE);

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
	 * Initializes the g e m measurement formula value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMMeasurementFormulaValue>> listenersList = new ArrayList<ModelListener<GEMMeasurementFormulaValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMMeasurementFormulaValue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMMeasurementFormulaValueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMMEASUREMENTFORMULAVALUE = "SELECT gemMeasurementFormulaValue FROM GEMMeasurementFormulaValue gemMeasurementFormulaValue";
	private static final String _SQL_COUNT_GEMMEASUREMENTFORMULAVALUE = "SELECT COUNT(gemMeasurementFormulaValue) FROM GEMMeasurementFormulaValue gemMeasurementFormulaValue";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemMeasurementFormulaValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMMeasurementFormulaValue exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMMeasurementFormulaValuePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"formulaValueId", "formulaId", "formulaType", "formulaValue",
				"creatorId", "createdDate", "updatedBy", "updatedDate"
			});
	private static GEMMeasurementFormulaValue _nullGEMMeasurementFormulaValue = new GEMMeasurementFormulaValueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMMeasurementFormulaValue> toCacheModel() {
				return _nullGEMMeasurementFormulaValueCacheModel;
			}
		};

	private static CacheModel<GEMMeasurementFormulaValue> _nullGEMMeasurementFormulaValueCacheModel =
		new CacheModel<GEMMeasurementFormulaValue>() {
			@Override
			public GEMMeasurementFormulaValue toEntityModel() {
				return _nullGEMMeasurementFormulaValue;
			}
		};
}