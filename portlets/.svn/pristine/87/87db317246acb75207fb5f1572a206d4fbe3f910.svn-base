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

import com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException;
import com.ihg.brandstandards.db.model.GEMMeasurementFormula;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaImpl;
import com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaModelImpl;

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
 * The persistence implementation for the g e m measurement formula service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementFormulaPersistence
 * @see GEMMeasurementFormulaUtil
 * @generated
 */
public class GEMMeasurementFormulaPersistenceImpl extends BasePersistenceImpl<GEMMeasurementFormula>
	implements GEMMeasurementFormulaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMMeasurementFormulaUtil} to access the g e m measurement formula persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMMeasurementFormulaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementFormulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaModelImpl.FINDER_CACHE_ENABLED,
			GEMMeasurementFormulaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMMeasurementFormulaPersistenceImpl() {
		setModelClass(GEMMeasurementFormula.class);
	}

	/**
	 * Caches the g e m measurement formula in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementFormula the g e m measurement formula
	 */
	@Override
	public void cacheResult(GEMMeasurementFormula gemMeasurementFormula) {
		EntityCacheUtil.putResult(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaImpl.class,
			gemMeasurementFormula.getPrimaryKey(), gemMeasurementFormula);

		gemMeasurementFormula.resetOriginalValues();
	}

	/**
	 * Caches the g e m measurement formulas in the entity cache if it is enabled.
	 *
	 * @param gemMeasurementFormulas the g e m measurement formulas
	 */
	@Override
	public void cacheResult(List<GEMMeasurementFormula> gemMeasurementFormulas) {
		for (GEMMeasurementFormula gemMeasurementFormula : gemMeasurementFormulas) {
			if (EntityCacheUtil.getResult(
						GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementFormulaImpl.class,
						gemMeasurementFormula.getPrimaryKey()) == null) {
				cacheResult(gemMeasurementFormula);
			}
			else {
				gemMeasurementFormula.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m measurement formulas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMMeasurementFormulaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMMeasurementFormulaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m measurement formula.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMMeasurementFormula gemMeasurementFormula) {
		EntityCacheUtil.removeResult(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaImpl.class,
			gemMeasurementFormula.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMMeasurementFormula> gemMeasurementFormulas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMMeasurementFormula gemMeasurementFormula : gemMeasurementFormulas) {
			EntityCacheUtil.removeResult(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementFormulaImpl.class,
				gemMeasurementFormula.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m measurement formula with the primary key. Does not add the g e m measurement formula to the database.
	 *
	 * @param formulaId the primary key for the new g e m measurement formula
	 * @return the new g e m measurement formula
	 */
	@Override
	public GEMMeasurementFormula create(long formulaId) {
		GEMMeasurementFormula gemMeasurementFormula = new GEMMeasurementFormulaImpl();

		gemMeasurementFormula.setNew(true);
		gemMeasurementFormula.setPrimaryKey(formulaId);

		return gemMeasurementFormula;
	}

	/**
	 * Removes the g e m measurement formula with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formulaId the primary key of the g e m measurement formula
	 * @return the g e m measurement formula that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException if a g e m measurement formula with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormula remove(long formulaId)
		throws NoSuchGEMMeasurementFormulaException, SystemException {
		return remove((Serializable)formulaId);
	}

	/**
	 * Removes the g e m measurement formula with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m measurement formula
	 * @return the g e m measurement formula that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException if a g e m measurement formula with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormula remove(Serializable primaryKey)
		throws NoSuchGEMMeasurementFormulaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMMeasurementFormula gemMeasurementFormula = (GEMMeasurementFormula)session.get(GEMMeasurementFormulaImpl.class,
					primaryKey);

			if (gemMeasurementFormula == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMMeasurementFormulaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemMeasurementFormula);
		}
		catch (NoSuchGEMMeasurementFormulaException nsee) {
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
	protected GEMMeasurementFormula removeImpl(
		GEMMeasurementFormula gemMeasurementFormula) throws SystemException {
		gemMeasurementFormula = toUnwrappedModel(gemMeasurementFormula);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemMeasurementFormula)) {
				gemMeasurementFormula = (GEMMeasurementFormula)session.get(GEMMeasurementFormulaImpl.class,
						gemMeasurementFormula.getPrimaryKeyObj());
			}

			if (gemMeasurementFormula != null) {
				session.delete(gemMeasurementFormula);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemMeasurementFormula != null) {
			clearCache(gemMeasurementFormula);
		}

		return gemMeasurementFormula;
	}

	@Override
	public GEMMeasurementFormula updateImpl(
		com.ihg.brandstandards.db.model.GEMMeasurementFormula gemMeasurementFormula)
		throws SystemException {
		gemMeasurementFormula = toUnwrappedModel(gemMeasurementFormula);

		boolean isNew = gemMeasurementFormula.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemMeasurementFormula.isNew()) {
				session.save(gemMeasurementFormula);

				gemMeasurementFormula.setNew(false);
			}
			else {
				session.merge(gemMeasurementFormula);
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

		EntityCacheUtil.putResult(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
			GEMMeasurementFormulaImpl.class,
			gemMeasurementFormula.getPrimaryKey(), gemMeasurementFormula);

		return gemMeasurementFormula;
	}

	protected GEMMeasurementFormula toUnwrappedModel(
		GEMMeasurementFormula gemMeasurementFormula) {
		if (gemMeasurementFormula instanceof GEMMeasurementFormulaImpl) {
			return gemMeasurementFormula;
		}

		GEMMeasurementFormulaImpl gemMeasurementFormulaImpl = new GEMMeasurementFormulaImpl();

		gemMeasurementFormulaImpl.setNew(gemMeasurementFormula.isNew());
		gemMeasurementFormulaImpl.setPrimaryKey(gemMeasurementFormula.getPrimaryKey());

		gemMeasurementFormulaImpl.setFormulaId(gemMeasurementFormula.getFormulaId());
		gemMeasurementFormulaImpl.setPublishId(gemMeasurementFormula.getPublishId());
		gemMeasurementFormulaImpl.setRegionId(gemMeasurementFormula.getRegionId());
		gemMeasurementFormulaImpl.setMeasurementId(gemMeasurementFormula.getMeasurementId());
		gemMeasurementFormulaImpl.setSeverityId(gemMeasurementFormula.getSeverityId());
		gemMeasurementFormulaImpl.setSubRegionLevelCd(gemMeasurementFormula.getSubRegionLevelCd());
		gemMeasurementFormulaImpl.setCreatorId(gemMeasurementFormula.getCreatorId());
		gemMeasurementFormulaImpl.setCreatedDate(gemMeasurementFormula.getCreatedDate());
		gemMeasurementFormulaImpl.setUpdatedBy(gemMeasurementFormula.getUpdatedBy());
		gemMeasurementFormulaImpl.setUpdatedDate(gemMeasurementFormula.getUpdatedDate());

		return gemMeasurementFormulaImpl;
	}

	/**
	 * Returns the g e m measurement formula with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement formula
	 * @return the g e m measurement formula
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException if a g e m measurement formula with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormula findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMMeasurementFormulaException, SystemException {
		GEMMeasurementFormula gemMeasurementFormula = fetchByPrimaryKey(primaryKey);

		if (gemMeasurementFormula == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMMeasurementFormulaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemMeasurementFormula;
	}

	/**
	 * Returns the g e m measurement formula with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException} if it could not be found.
	 *
	 * @param formulaId the primary key of the g e m measurement formula
	 * @return the g e m measurement formula
	 * @throws com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException if a g e m measurement formula with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormula findByPrimaryKey(long formulaId)
		throws NoSuchGEMMeasurementFormulaException, SystemException {
		return findByPrimaryKey((Serializable)formulaId);
	}

	/**
	 * Returns the g e m measurement formula with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m measurement formula
	 * @return the g e m measurement formula, or <code>null</code> if a g e m measurement formula with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormula fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMMeasurementFormula gemMeasurementFormula = (GEMMeasurementFormula)EntityCacheUtil.getResult(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
				GEMMeasurementFormulaImpl.class, primaryKey);

		if (gemMeasurementFormula == _nullGEMMeasurementFormula) {
			return null;
		}

		if (gemMeasurementFormula == null) {
			Session session = null;

			try {
				session = openSession();

				gemMeasurementFormula = (GEMMeasurementFormula)session.get(GEMMeasurementFormulaImpl.class,
						primaryKey);

				if (gemMeasurementFormula != null) {
					cacheResult(gemMeasurementFormula);
				}
				else {
					EntityCacheUtil.putResult(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
						GEMMeasurementFormulaImpl.class, primaryKey,
						_nullGEMMeasurementFormula);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMMeasurementFormulaModelImpl.ENTITY_CACHE_ENABLED,
					GEMMeasurementFormulaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemMeasurementFormula;
	}

	/**
	 * Returns the g e m measurement formula with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formulaId the primary key of the g e m measurement formula
	 * @return the g e m measurement formula, or <code>null</code> if a g e m measurement formula with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMMeasurementFormula fetchByPrimaryKey(long formulaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)formulaId);
	}

	/**
	 * Returns all the g e m measurement formulas.
	 *
	 * @return the g e m measurement formulas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementFormula> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m measurement formulas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement formulas
	 * @param end the upper bound of the range of g e m measurement formulas (not inclusive)
	 * @return the range of g e m measurement formulas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementFormula> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m measurement formulas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m measurement formulas
	 * @param end the upper bound of the range of g e m measurement formulas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m measurement formulas
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMMeasurementFormula> findAll(int start, int end,
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

		List<GEMMeasurementFormula> list = (List<GEMMeasurementFormula>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMMEASUREMENTFORMULA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMMEASUREMENTFORMULA;

				if (pagination) {
					sql = sql.concat(GEMMeasurementFormulaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMMeasurementFormula>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMMeasurementFormula>(list);
				}
				else {
					list = (List<GEMMeasurementFormula>)QueryUtil.list(q,
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
	 * Removes all the g e m measurement formulas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMMeasurementFormula gemMeasurementFormula : findAll()) {
			remove(gemMeasurementFormula);
		}
	}

	/**
	 * Returns the number of g e m measurement formulas.
	 *
	 * @return the number of g e m measurement formulas
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

				Query q = session.createQuery(_SQL_COUNT_GEMMEASUREMENTFORMULA);

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
	 * Initializes the g e m measurement formula persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMMeasurementFormula")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMMeasurementFormula>> listenersList = new ArrayList<ModelListener<GEMMeasurementFormula>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMMeasurementFormula>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMMeasurementFormulaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMMEASUREMENTFORMULA = "SELECT gemMeasurementFormula FROM GEMMeasurementFormula gemMeasurementFormula";
	private static final String _SQL_COUNT_GEMMEASUREMENTFORMULA = "SELECT COUNT(gemMeasurementFormula) FROM GEMMeasurementFormula gemMeasurementFormula";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemMeasurementFormula.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMMeasurementFormula exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMMeasurementFormulaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"formulaId", "publishId", "regionId", "measurementId",
				"severityId", "subRegionLevelCd", "creatorId", "createdDate",
				"updatedBy", "updatedDate"
			});
	private static GEMMeasurementFormula _nullGEMMeasurementFormula = new GEMMeasurementFormulaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMMeasurementFormula> toCacheModel() {
				return _nullGEMMeasurementFormulaCacheModel;
			}
		};

	private static CacheModel<GEMMeasurementFormula> _nullGEMMeasurementFormulaCacheModel =
		new CacheModel<GEMMeasurementFormula>() {
			@Override
			public GEMMeasurementFormula toEntityModel() {
				return _nullGEMMeasurementFormula;
			}
		};
}