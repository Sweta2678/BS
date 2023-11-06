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

import com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException;
import com.ihg.brandstandards.db.model.GEMUniqueGroupCountry;
import com.ihg.brandstandards.db.model.impl.GEMUniqueGroupCountryImpl;
import com.ihg.brandstandards.db.model.impl.GEMUniqueGroupCountryModelImpl;

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
 * The persistence implementation for the g e m unique group country service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mummanedi
 * @see GEMUniqueGroupCountryPersistence
 * @see GEMUniqueGroupCountryUtil
 * @generated
 */
public class GEMUniqueGroupCountryPersistenceImpl extends BasePersistenceImpl<GEMUniqueGroupCountry>
	implements GEMUniqueGroupCountryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GEMUniqueGroupCountryUtil} to access the g e m unique group country persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GEMUniqueGroupCountryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupCountryModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupCountryModelImpl.FINDER_CACHE_ENABLED,
			GEMUniqueGroupCountryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupCountryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GEMUniqueGroupCountryPersistenceImpl() {
		setModelClass(GEMUniqueGroupCountry.class);
	}

	/**
	 * Caches the g e m unique group country in the entity cache if it is enabled.
	 *
	 * @param gemUniqueGroupCountry the g e m unique group country
	 */
	@Override
	public void cacheResult(GEMUniqueGroupCountry gemUniqueGroupCountry) {
		EntityCacheUtil.putResult(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupCountryImpl.class,
			gemUniqueGroupCountry.getPrimaryKey(), gemUniqueGroupCountry);

		gemUniqueGroupCountry.resetOriginalValues();
	}

	/**
	 * Caches the g e m unique group countries in the entity cache if it is enabled.
	 *
	 * @param gemUniqueGroupCountries the g e m unique group countries
	 */
	@Override
	public void cacheResult(List<GEMUniqueGroupCountry> gemUniqueGroupCountries) {
		for (GEMUniqueGroupCountry gemUniqueGroupCountry : gemUniqueGroupCountries) {
			if (EntityCacheUtil.getResult(
						GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
						GEMUniqueGroupCountryImpl.class,
						gemUniqueGroupCountry.getPrimaryKey()) == null) {
				cacheResult(gemUniqueGroupCountry);
			}
			else {
				gemUniqueGroupCountry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all g e m unique group countries.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GEMUniqueGroupCountryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GEMUniqueGroupCountryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the g e m unique group country.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GEMUniqueGroupCountry gemUniqueGroupCountry) {
		EntityCacheUtil.removeResult(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupCountryImpl.class,
			gemUniqueGroupCountry.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GEMUniqueGroupCountry> gemUniqueGroupCountries) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GEMUniqueGroupCountry gemUniqueGroupCountry : gemUniqueGroupCountries) {
			EntityCacheUtil.removeResult(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
				GEMUniqueGroupCountryImpl.class,
				gemUniqueGroupCountry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new g e m unique group country with the primary key. Does not add the g e m unique group country to the database.
	 *
	 * @param groupCountryId the primary key for the new g e m unique group country
	 * @return the new g e m unique group country
	 */
	@Override
	public GEMUniqueGroupCountry create(long groupCountryId) {
		GEMUniqueGroupCountry gemUniqueGroupCountry = new GEMUniqueGroupCountryImpl();

		gemUniqueGroupCountry.setNew(true);
		gemUniqueGroupCountry.setPrimaryKey(groupCountryId);

		return gemUniqueGroupCountry;
	}

	/**
	 * Removes the g e m unique group country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCountryId the primary key of the g e m unique group country
	 * @return the g e m unique group country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException if a g e m unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupCountry remove(long groupCountryId)
		throws NoSuchGEMUniqueGroupCountryException, SystemException {
		return remove((Serializable)groupCountryId);
	}

	/**
	 * Removes the g e m unique group country with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the g e m unique group country
	 * @return the g e m unique group country that was removed
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException if a g e m unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupCountry remove(Serializable primaryKey)
		throws NoSuchGEMUniqueGroupCountryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			GEMUniqueGroupCountry gemUniqueGroupCountry = (GEMUniqueGroupCountry)session.get(GEMUniqueGroupCountryImpl.class,
					primaryKey);

			if (gemUniqueGroupCountry == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGEMUniqueGroupCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(gemUniqueGroupCountry);
		}
		catch (NoSuchGEMUniqueGroupCountryException nsee) {
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
	protected GEMUniqueGroupCountry removeImpl(
		GEMUniqueGroupCountry gemUniqueGroupCountry) throws SystemException {
		gemUniqueGroupCountry = toUnwrappedModel(gemUniqueGroupCountry);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gemUniqueGroupCountry)) {
				gemUniqueGroupCountry = (GEMUniqueGroupCountry)session.get(GEMUniqueGroupCountryImpl.class,
						gemUniqueGroupCountry.getPrimaryKeyObj());
			}

			if (gemUniqueGroupCountry != null) {
				session.delete(gemUniqueGroupCountry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (gemUniqueGroupCountry != null) {
			clearCache(gemUniqueGroupCountry);
		}

		return gemUniqueGroupCountry;
	}

	@Override
	public GEMUniqueGroupCountry updateImpl(
		com.ihg.brandstandards.db.model.GEMUniqueGroupCountry gemUniqueGroupCountry)
		throws SystemException {
		gemUniqueGroupCountry = toUnwrappedModel(gemUniqueGroupCountry);

		boolean isNew = gemUniqueGroupCountry.isNew();

		Session session = null;

		try {
			session = openSession();

			if (gemUniqueGroupCountry.isNew()) {
				session.save(gemUniqueGroupCountry);

				gemUniqueGroupCountry.setNew(false);
			}
			else {
				session.merge(gemUniqueGroupCountry);
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

		EntityCacheUtil.putResult(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
			GEMUniqueGroupCountryImpl.class,
			gemUniqueGroupCountry.getPrimaryKey(), gemUniqueGroupCountry);

		return gemUniqueGroupCountry;
	}

	protected GEMUniqueGroupCountry toUnwrappedModel(
		GEMUniqueGroupCountry gemUniqueGroupCountry) {
		if (gemUniqueGroupCountry instanceof GEMUniqueGroupCountryImpl) {
			return gemUniqueGroupCountry;
		}

		GEMUniqueGroupCountryImpl gemUniqueGroupCountryImpl = new GEMUniqueGroupCountryImpl();

		gemUniqueGroupCountryImpl.setNew(gemUniqueGroupCountry.isNew());
		gemUniqueGroupCountryImpl.setPrimaryKey(gemUniqueGroupCountry.getPrimaryKey());

		gemUniqueGroupCountryImpl.setGroupCountryId(gemUniqueGroupCountry.getGroupCountryId());
		gemUniqueGroupCountryImpl.setUniqueGroupId(gemUniqueGroupCountry.getUniqueGroupId());
		gemUniqueGroupCountryImpl.setCountryCode(gemUniqueGroupCountry.getCountryCode());
		gemUniqueGroupCountryImpl.setCreatorId(gemUniqueGroupCountry.getCreatorId());
		gemUniqueGroupCountryImpl.setCreatedDate(gemUniqueGroupCountry.getCreatedDate());
		gemUniqueGroupCountryImpl.setUpdatedBy(gemUniqueGroupCountry.getUpdatedBy());
		gemUniqueGroupCountryImpl.setUpdatedDate(gemUniqueGroupCountry.getUpdatedDate());

		return gemUniqueGroupCountryImpl;
	}

	/**
	 * Returns the g e m unique group country with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m unique group country
	 * @return the g e m unique group country
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException if a g e m unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupCountry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGEMUniqueGroupCountryException, SystemException {
		GEMUniqueGroupCountry gemUniqueGroupCountry = fetchByPrimaryKey(primaryKey);

		if (gemUniqueGroupCountry == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGEMUniqueGroupCountryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return gemUniqueGroupCountry;
	}

	/**
	 * Returns the g e m unique group country with the primary key or throws a {@link com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException} if it could not be found.
	 *
	 * @param groupCountryId the primary key of the g e m unique group country
	 * @return the g e m unique group country
	 * @throws com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException if a g e m unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupCountry findByPrimaryKey(long groupCountryId)
		throws NoSuchGEMUniqueGroupCountryException, SystemException {
		return findByPrimaryKey((Serializable)groupCountryId);
	}

	/**
	 * Returns the g e m unique group country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the g e m unique group country
	 * @return the g e m unique group country, or <code>null</code> if a g e m unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupCountry fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		GEMUniqueGroupCountry gemUniqueGroupCountry = (GEMUniqueGroupCountry)EntityCacheUtil.getResult(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
				GEMUniqueGroupCountryImpl.class, primaryKey);

		if (gemUniqueGroupCountry == _nullGEMUniqueGroupCountry) {
			return null;
		}

		if (gemUniqueGroupCountry == null) {
			Session session = null;

			try {
				session = openSession();

				gemUniqueGroupCountry = (GEMUniqueGroupCountry)session.get(GEMUniqueGroupCountryImpl.class,
						primaryKey);

				if (gemUniqueGroupCountry != null) {
					cacheResult(gemUniqueGroupCountry);
				}
				else {
					EntityCacheUtil.putResult(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
						GEMUniqueGroupCountryImpl.class, primaryKey,
						_nullGEMUniqueGroupCountry);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GEMUniqueGroupCountryModelImpl.ENTITY_CACHE_ENABLED,
					GEMUniqueGroupCountryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return gemUniqueGroupCountry;
	}

	/**
	 * Returns the g e m unique group country with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupCountryId the primary key of the g e m unique group country
	 * @return the g e m unique group country, or <code>null</code> if a g e m unique group country with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public GEMUniqueGroupCountry fetchByPrimaryKey(long groupCountryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)groupCountryId);
	}

	/**
	 * Returns all the g e m unique group countries.
	 *
	 * @return the g e m unique group countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroupCountry> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the g e m unique group countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m unique group countries
	 * @param end the upper bound of the range of g e m unique group countries (not inclusive)
	 * @return the range of g e m unique group countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroupCountry> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the g e m unique group countries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.brandstandards.db.model.impl.GEMUniqueGroupCountryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of g e m unique group countries
	 * @param end the upper bound of the range of g e m unique group countries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of g e m unique group countries
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<GEMUniqueGroupCountry> findAll(int start, int end,
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

		List<GEMUniqueGroupCountry> list = (List<GEMUniqueGroupCountry>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GEMUNIQUEGROUPCOUNTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEMUNIQUEGROUPCOUNTRY;

				if (pagination) {
					sql = sql.concat(GEMUniqueGroupCountryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<GEMUniqueGroupCountry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<GEMUniqueGroupCountry>(list);
				}
				else {
					list = (List<GEMUniqueGroupCountry>)QueryUtil.list(q,
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
	 * Removes all the g e m unique group countries from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (GEMUniqueGroupCountry gemUniqueGroupCountry : findAll()) {
			remove(gemUniqueGroupCountry);
		}
	}

	/**
	 * Returns the number of g e m unique group countries.
	 *
	 * @return the number of g e m unique group countries
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

				Query q = session.createQuery(_SQL_COUNT_GEMUNIQUEGROUPCOUNTRY);

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
	 * Initializes the g e m unique group country persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.brandstandards.db.model.GEMUniqueGroupCountry")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<GEMUniqueGroupCountry>> listenersList = new ArrayList<ModelListener<GEMUniqueGroupCountry>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<GEMUniqueGroupCountry>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(GEMUniqueGroupCountryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GEMUNIQUEGROUPCOUNTRY = "SELECT gemUniqueGroupCountry FROM GEMUniqueGroupCountry gemUniqueGroupCountry";
	private static final String _SQL_COUNT_GEMUNIQUEGROUPCOUNTRY = "SELECT COUNT(gemUniqueGroupCountry) FROM GEMUniqueGroupCountry gemUniqueGroupCountry";
	private static final String _ORDER_BY_ENTITY_ALIAS = "gemUniqueGroupCountry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GEMUniqueGroupCountry exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GEMUniqueGroupCountryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"groupCountryId", "uniqueGroupId", "countryCode", "creatorId",
				"createdDate", "updatedBy", "updatedDate"
			});
	private static GEMUniqueGroupCountry _nullGEMUniqueGroupCountry = new GEMUniqueGroupCountryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<GEMUniqueGroupCountry> toCacheModel() {
				return _nullGEMUniqueGroupCountryCacheModel;
			}
		};

	private static CacheModel<GEMUniqueGroupCountry> _nullGEMUniqueGroupCountryCacheModel =
		new CacheModel<GEMUniqueGroupCountry>() {
			@Override
			public GEMUniqueGroupCountry toEntityModel() {
				return _nullGEMUniqueGroupCountry;
			}
		};
}